/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_barcoPirata 
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.barcoPirata.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.barcoPirata.mundo.Contenedor;

/**
 * Panel para mostrar la información de una contenedor.
 */
public class PanelContenedor extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para el botón cargar.
     */
    private static final String CARGAR = "CARGAR";

    /**
     * Comando para el botón descargar.
     */
    private static final String DESCARGAR = "DESCARGAR";
    
    /**
     * Ruta de la imagen que indica que la carga existe.
     */
    private static final String CARGA_EXISTE = "data/carga.jpg";

    /**
     * Ruta de la imagen que indica que la carga no existe.
     */
    private static final String CARGA_NO_EXISTE = "data/noCarga.jpg";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazBarcoPirata principal;

    /**
     * Nombre del pirata dueño del contenedor.
     */
    private String nombrePirata;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta del nombre del pirata.
     */
    private JLabel lblPirata;
    
    /**
     * Etiqueta con la imagen de la carga.
     */
    private JLabel lblImagen;

    /**
     * Etiqueta del numero de cajas.
     */
    private JLabel lblNumeroCajas;

    /**
     * Etiqueta del peso por caja.
     */
    private JLabel lblPesoPorCaja;

    /**
     * Etiqueta del tipo de carga.
     */
    private JLabel lblTipoCarga;
    
    /**
     * Campo de texto del nombre del pirata.
     */
    private JTextField txtPirata;

    /**
     * Campo de texto del numero de cajas.
     */
    private JTextField txtNumeroCajas;

    /**
     * Campo de texto del peso por caja.
     */
    private JTextField txtPesoPorCaja;

    /**
     * Campo de texto del tipo de carga.
     */
    private JTextField txtTipoCarga;

    /**
     * Botón cargar.
     */
    private JButton btnCargar;
    
    /**
     * Botón descargar.
     */
    private JButton btnDescargar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param ventanaPrincipal Ventana principal de la aplicación.
     * @param numeroContenedor Número del contenedor.
     * @param pNombrePirata Nombre del pirata dueño de la carga.
     */
    public PanelContenedor( InterfazBarcoPirata ventanaPrincipal, int numeroContenedor, String pNombrePirata )
    {
        principal = ventanaPrincipal;
        nombrePirata = pNombrePirata;
        setBorder( new TitledBorder( "Contenedor " + numeroContenedor ) );
        setLayout( new BorderLayout());

        ImageIcon icono = new ImageIcon( CARGA_NO_EXISTE );
        lblImagen = new JLabel( "" );
        lblImagen.setIcon( icono );

        lblNumeroCajas = new JLabel( "   No. cajas:" );
        lblNumeroCajas.setForeground(Color.BLUE);
        lblPesoPorCaja = new JLabel( "   Peso por caja:" );
        lblPesoPorCaja.setForeground(Color.BLUE);
        lblPirata = new JLabel( "   Pirata:");
        lblPirata.setForeground(Color.BLUE);
        lblTipoCarga = new JLabel( "   Tipo de carga:" );
        lblTipoCarga.setForeground(Color.BLUE);

        txtNumeroCajas = new JTextField( "0" );
        txtNumeroCajas.setEditable(false);
		txtNumeroCajas.setHorizontalAlignment(JTextField.CENTER);
        txtPesoPorCaja = new JTextField( "0.0 Kg." );
        txtPesoPorCaja.setEditable(false);
        txtPesoPorCaja.setHorizontalAlignment(JTextField.CENTER);
        txtPirata = new JTextField( nombrePirata );
        txtPirata.setEditable(false);
        txtPirata.setHorizontalAlignment(JTextField.CENTER);
        txtPirata.setForeground(Color.RED);
        txtTipoCarga = new JTextField( "Sin carga" );
        txtTipoCarga.setEditable(false);
        txtTipoCarga.setHorizontalAlignment(JTextField.CENTER);
        
        btnCargar = new JButton( "Cargar" );
        btnCargar.setActionCommand( CARGAR );
        btnCargar.addActionListener( this );
        
        btnDescargar = new JButton( "Descargar" );
        btnDescargar.setActionCommand( DESCARGAR );
        btnDescargar.addActionListener( this );
        btnDescargar.setEnabled(false);
        
        JPanel panelAux = new JPanel();
        panelAux.setLayout(new GridLayout(5, 2, 2, 2));
        panelAux.add(lblPirata);
        panelAux.add(txtPirata);
        panelAux.add(lblNumeroCajas);
        panelAux.add(txtNumeroCajas);
        panelAux.add(lblPesoPorCaja);
        panelAux.add(txtPesoPorCaja);
        panelAux.add(lblTipoCarga);
        panelAux.add(txtTipoCarga);
        panelAux.add(btnCargar);
        panelAux.add(btnDescargar);
        
        add(lblImagen, BorderLayout.WEST);
        add(panelAux, BorderLayout.CENTER);

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    
    /**
     * Actualiza la información de la carga.
     * @param numeroCajas Número de cajas de la carga.
     * @param pesoPorCaja Peso de cada caja de la carga.
     * @param tipoCarga Tipo de la carga.
     */
    public void actualizar( int numeroCajas, double pesoPorCaja,  int tipoCarga )
    {

        if( numeroCajas == 0 && pesoPorCaja == 0.0 && tipoCarga == 0 )
        {
            ImageIcon icono = new ImageIcon( CARGA_NO_EXISTE );
            lblImagen.setIcon( icono );
            btnCargar.setEnabled( true );
            btnDescargar.setEnabled(false);

        }
        else
        {
            ImageIcon icono = new ImageIcon( CARGA_EXISTE );
            lblImagen.setIcon( icono );
            btnCargar.setEnabled( false );
            btnDescargar.setEnabled(true);
        }

        txtNumeroCajas.setText(numeroCajas +"");
        txtPesoPorCaja.setText(formatearValor( pesoPorCaja ) + " Kg.");

        switch( tipoCarga )
        {
            case Contenedor.CARGA_PELIGROSA:
                txtTipoCarga.setText( "Peligrosa" );
                break;
            case Contenedor.CARGA_PERECEDERA:
                txtTipoCarga.setText(  "Perecedera" );
                break;
            case Contenedor.CARGA_NO_PERECEDERA:
                txtTipoCarga.setText( "No perecedera" );
                break;
            case Contenedor.SIN_CARGA:
                txtTipoCarga.setText( "Sin carga" );
                break;
        }
    }

    /**
     * Manejo de eventos de los botones.
     * @param e Acción que generó el evento. e != null.
     */
    public void actionPerformed( ActionEvent e )
    {
    	String comando = e.getActionCommand();
    	if(comando.equals(CARGAR))
    	{
    		principal.mostrarVentanaCargarBarco( nombrePirata );
    	}
    	else if(comando.equals(DESCARGAR))
    	{
    		principal.descargarContenedor( nombrePirata );
    	}
        
    }

    /**
     * Formatea un valor numérico real para presentar en la interfaz. <br>
     * @param valor El valor numérico a ser formateado.
     * @return Retorna una cadena con el valor formateado con puntos y signos.
     */
    public final static String formatearValor( double valor )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( " ###,###.##" );
        df.setMinimumFractionDigits( 2 );
        return df.format( valor );
    }

    /**
     * Formatea un valor numérico entero para presentar en la interfaz. <br>
     * @param valor El valor numérico a ser formateado.
     * @return Retorna una cadena con el valor formateado con puntos y signos.
     */
    public final static String formatearValor( int valor )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( " ###,###" );
        df.setMinimumFractionDigits( 0 );
        return df.format( valor );
    }

}