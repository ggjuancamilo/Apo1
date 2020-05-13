/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_inmobiliaria
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.inmobiliaria.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.cupi2.inmobiliaria.mundo.Mansion;

/**
 * Panel con la informaci�n de una mansi�n.
 */
public class PanelMansion extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Comando actualizar datos de la mansi�n.
     */
    private static final String ACTUALIZAR = "Actualizar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazInmobiliaria principal;

    /**
     * N�mero de la mansi�n.
     */
    private int numMansion;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta costo limpieza.
     */
    private JLabel etiquetaCostoLimpieza;

    /**
     * Etiqueta costo servicios p�blicos.
     */
    private JLabel etiquetaCostoServicios;

    /**
     * Etiqueta costo seguridad.
     */
    private JLabel etiquetaCostoSeguridad;

    /**
     * Bot�n Actualizar.
     */
    private JButton botonActualizar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel
     * @param laPrincipal Ventana principal. laPrincipal != null.
     * @param nMansion N�mero de la mansi�n.
     */
    public PanelMansion( InterfazInmobiliaria laPrincipal, int nMansion )
    {
        principal = laPrincipal;
        numMansion = nMansion;

        // Bot�n actualizar datos
        botonActualizar = new JButton( ACTUALIZAR );
        botonActualizar.setPreferredSize( new Dimension( 160, 20 ) );
        botonActualizar.setActionCommand( ACTUALIZAR );
        botonActualizar.addActionListener( this );

        etiquetaCostoServicios = new JLabel( "Costo servicios: (U$)" );
        etiquetaCostoServicios.setHorizontalAlignment( JLabel.CENTER );
        etiquetaCostoLimpieza = new JLabel( "Costo limpieza: (U$)" );
        etiquetaCostoLimpieza.setHorizontalAlignment( JLabel.CENTER );
        etiquetaCostoSeguridad = new JLabel( "Costo seguridad: (U$)" );
        etiquetaCostoSeguridad.setHorizontalAlignment( JLabel.CENTER );

        JPanel panelImagen = new JPanel( );
        JPanel panelInformacion = new JPanel( );

        setLayout( new java.awt.BorderLayout( ) );
        setBorder( javax.swing.BorderFactory.createTitledBorder( "Mansi�n " + numMansion ) );

        add( panelImagen, java.awt.BorderLayout.CENTER );
        panelImagen.setLayout( new BorderLayout( ) );
        JLabel temp = new JLabel( );
        temp.setHorizontalAlignment( JLabel.CENTER );
        temp.setIcon( new ImageIcon( "data/mansion" + numMansion + ".jpg" ) );
        panelImagen.add( temp, BorderLayout.CENTER );

        panelInformacion.setLayout( new GridLayout( 4, 1 ) );

        panelInformacion.add( botonActualizar );

        panelInformacion.add( etiquetaCostoLimpieza );

        panelInformacion.add( etiquetaCostoServicios );

        panelInformacion.add( etiquetaCostoSeguridad );

        add( panelInformacion, java.awt.BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Actualiza la visualizaci�n de la informaci�n
     * @param mansion Mansi�n de donde se saca la informaci�n. mansion != null.
     */
    public void actualizar( Mansion mansion )
    {
        etiquetaCostoLimpieza.setText( "Costo limpieza: (U$) " + formatearValorEntero( mansion.calcularCostoLimpieza( ) ) );
        etiquetaCostoServicios.setText( "Costo servicios: (U$) " + formatearValorReal( mansion.calcularCostoServicios( ) ) );
        etiquetaCostoSeguridad.setText( "Costo seguridad: (U$) " + formatearValorReal( mansion.calcularCostoSeguridad( ) ) );
    }

    /**
     * Manejo de eventos del usuario
     * @param e Evento de usuario. e != null.
     */
    public void actionPerformed( ActionEvent e )
    {
        if( ACTUALIZAR.equals( e.getActionCommand( ) ) )
        {
            principal.mostrarDialogoDatosMansion( numMansion );
        }

    }

    /**
     * Formatea un valor num�rico entero para presentar en la interfaz. <br>
     * @param valor Valor num�rico a ser formateado.
     * @return Retorna una cadena con el valor formateado con puntos y signos.
     */
    private String formatearValorEntero( int valor )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( " ###,###" );
        df.setMinimumFractionDigits( 0 );
        return df.format( valor );
    }

    /**
     * Formatea un valor num�rico real para presentar en la interfaz. <br>
     * @param valor El valor num�rico a ser formateado.
     * @return Cadena con el valor formateado con puntos y signos.
     */
    private String formatearValorReal( double valor )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( " ###,###.##" );
        df.setMinimumFractionDigits( 2 );
        return df.format( valor );
    }
}