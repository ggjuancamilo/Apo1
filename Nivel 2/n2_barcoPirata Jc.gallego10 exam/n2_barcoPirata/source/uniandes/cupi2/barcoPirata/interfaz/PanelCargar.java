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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uniandes.cupi2.barcoPirata.mundo.Contenedor;

/**
 * Panel para cargar un contenedor del barco.
 */
public class PanelCargar extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando Aceptar.
     */
    private static final String ACEPTAR = "ACEPTAR";

    /**
     * Comando Cancelar.
     */
    private static final String CANCELAR = "CANCELAR";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana del panel.
     */
    private VentanaCargar ventana;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta del número de cajas.
     */
    private JLabel lblNumeroCajas;

    /**
     * Texto del número de cajas.
     */
    private JTextField txtNumeroCajas;

    /**
     * Etiqueta del peso por caja.
     */
    private JLabel lblPesoPorCaja;

    /**
     * Texto del peso por caja.
     */
    private JTextField txtPesoPorCaja;

    /**
     * Etiqueta del tipo de carga.
     */
    private JLabel etiquetaTipoCarga;

    /**
     * Combo del tipo de carga.
     */
    private JComboBox boxTipoCarga;

    /**
     * Botón Aceptar.
     */
    private JButton btnAceptar;

    /**
     * Botón Cancelar.
     */
    private JButton btnCancelar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor de la ventana.
     * @param ventanaPrincipal Ventana del panel. laVentana != null.
     */
    public PanelCargar( VentanaCargar ventanaPrincipal )
    {
        ventana = ventanaPrincipal;

        setLayout( new BorderLayout( ) );

        JPanel panelCentral = new JPanel( );
        panelCentral.setLayout( new GridLayout( 4, 2, 3, 3 ) );

        lblNumeroCajas = new JLabel( "Número de cajas:" );
        panelCentral.add( lblNumeroCajas );
        txtNumeroCajas = new JTextField( );
        panelCentral.add( txtNumeroCajas );

        lblPesoPorCaja = new JLabel( "Peso por caja:" );
        panelCentral.add( lblPesoPorCaja );
        txtPesoPorCaja = new JTextField( );
        panelCentral.add( txtPesoPorCaja );

        etiquetaTipoCarga = new JLabel( "Tipo de carga:" );
        panelCentral.add( etiquetaTipoCarga );
        boxTipoCarga = new JComboBox( );
        boxTipoCarga.addItem( "Peligrosa" );
        boxTipoCarga.addItem( "Perecedera" );
        boxTipoCarga.addItem( "No perecedera" );
        panelCentral.add( boxTipoCarga );

        // Botones
        btnAceptar = new JButton( "Aceptar" );
        btnAceptar.setActionCommand( ACEPTAR );
        btnAceptar.addActionListener( this );
        panelCentral.add( btnAceptar );
        btnCancelar = new JButton( "Cancelar" );
        btnCancelar.setActionCommand( CANCELAR );
        btnCancelar.addActionListener( this );
        panelCentral.add( btnCancelar );

        add( panelCentral );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de eventos de los botones.
     * @param e Acción que generó el evento. e != null.
     */
    public void actionPerformed( ActionEvent e )
    {
        if( ACEPTAR.equals( e.getActionCommand( ) ) )
        {
        	boolean problemas=false;
            int cajas = 0;
            double peso = 0;
            String tipo = null;
            
            if( txtNumeroCajas.getText( ).length( ) == 0 || txtNumeroCajas.getText( ).length( ) == 0 )
            {
                JOptionPane.showMessageDialog( this, "Debe ingresar todos los valores.", "Error", JOptionPane.ERROR_MESSAGE );
                problemas = true;
            }

            try
            {
                cajas = Integer.parseInt( txtNumeroCajas.getText( ) );
                if( cajas <= 0 )
                {
                    JOptionPane.showMessageDialog( this, "El número de cajas debe ser mayor a cero.", "Error", JOptionPane.ERROR_MESSAGE );
                    problemas = true;
                }
            }
            catch( NumberFormatException e2 )
            {
                JOptionPane.showMessageDialog( this, "El número de cajas debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE );
                problemas = true;
            }

            try
            {
                peso = Double.parseDouble( txtPesoPorCaja.getText( ) );
                if( peso <= 0 )
                {
                    JOptionPane.showMessageDialog( this, "El peso por caja debe ser mayor a cero.", "Error", JOptionPane.ERROR_MESSAGE );
                    problemas = true;
                }

            }
            catch( NumberFormatException e2 )
            {
                JOptionPane.showMessageDialog( this, "El peso por caja debe ser un número real.", "Error", JOptionPane.ERROR_MESSAGE );
                problemas = true;
            }

            tipo = ( String )boxTipoCarga.getSelectedItem( );

            int tipoInt = 0;
            if( tipo.equals( "Peligrosa" ) )
            {
            	tipoInt = Contenedor.CARGA_PELIGROSA;
            }
            else if( tipo.equals( "Perecedera" ) )
            {
            	tipoInt = Contenedor.CARGA_PERECEDERA;
            }
            else if( tipo.equals( "No perecedera" ) )
            {
            	tipoInt = Contenedor.CARGA_NO_PERECEDERA;
            }
                
            if(!problemas)
            {
            	ventana.cargarBarco( cajas, peso, tipoInt );
            }
            
        }
        else
        {
            ventana.cancelar( );
        }
    }

}
