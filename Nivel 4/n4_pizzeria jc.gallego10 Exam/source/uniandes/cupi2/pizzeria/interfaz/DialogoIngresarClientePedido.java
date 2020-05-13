/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_pizzeria
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.pizzeria.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * Dialogo para ingresar los datos del cliente para un pedido.
 */
public class DialogoIngresarClientePedido extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para aceptar.
     */
    private final static String ACEPTAR = "Aceptar";

    /**
     * Constante para cancelar.
     */
    private final static String CANCELAR = "Cancelar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazPizzeria principal;


    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta nombre del cliente.
     */
    private JLabel lblNombreCliente;
    
    /**
     * Etiqueta cédula del cliente.
     */
    private JLabel lblCedula;

    /**
     * Etiqueta teléfono del cliente.
     */
    private JLabel lblTelefono;
    
    /**
     * Etiqueta dirección del cliente.
     */
    private JLabel lblDireccion;

    /**
     * Cuadro de texto con el nombre del cliente.
     */
    private JTextField txtNombreCliente;
    
    /**
     * Cuadro de texto con la cédula del cliente.
     */
    private JTextField txtCedula;

    /**
     * Cuadro de texto con el teléfono del cliente.
     */
    private JTextField txtTelefono;
    
    /**
     * Cuadro de texto con la dirección del cliente.
     */
    private JTextField txtDireccion;

    /**
     * Botón para aceptar.
     */
    private JButton btnAceptar;
    
    /**
     * Botón para cancelar.
     */
    private JButton btnCancelar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del diálogo para realizar un pedido.
     * @param pPrincipal Ventana principal de la aplicación.
     */
    public DialogoIngresarClientePedido( InterfazPizzeria pPrincipal, int cedula )
    {

        super( pPrincipal, true );

        principal = pPrincipal;
        setTitle( "Datos cliente" );
        setSize( 300, 200 );
        setLayout( new java.awt.BorderLayout( ) );

        JPanel panelInformacion = new JPanel( );
        GridLayout layout = new GridLayout( 5, 2 );
        layout.setVgap( 8 );
        layout.setHgap( 8 );
        panelInformacion.setLayout( layout );

        lblNombreCliente = new JLabel( );
        lblNombreCliente.setText( "Nombre" );
        panelInformacion.add( lblNombreCliente );
        txtNombreCliente = new JTextField( );
        panelInformacion.add( txtNombreCliente );

        lblCedula = new JLabel( );
        lblCedula.setText( "Cédula" );
        panelInformacion.add( lblCedula );
        txtCedula = new JTextField(""+cedula);
        txtCedula.setEditable( false );
        panelInformacion.add( txtCedula );

        lblTelefono = new JLabel( );
        lblTelefono.setText( "Teléfono" );
        panelInformacion.add( lblTelefono );
        txtTelefono = new JTextField( );
        panelInformacion.add( txtTelefono );
        
        lblDireccion = new JLabel( );
        lblDireccion.setText( "Dirección" );
        panelInformacion.add( lblDireccion );
        txtDireccion = new JTextField( );
        panelInformacion.add( txtDireccion );
        
        btnAceptar = new JButton( "Aceptar" );
        btnAceptar.setActionCommand( ACEPTAR );
        btnAceptar.addActionListener( this );
        panelInformacion.add( btnAceptar );

        btnCancelar = new JButton( "Cancelar" );
        btnCancelar.setActionCommand( CANCELAR );
        btnCancelar.addActionListener( this );
        panelInformacion.add( btnCancelar );

        add( panelInformacion, BorderLayout.CENTER );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Método que recoge las acciones sobre los objetos que está escuchando.
     * @param pEvento Evento que se realizó.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( ACEPTAR.equals( comando ) )
        {
            String nombre = txtNombreCliente.getText( );
            String cedula = txtCedula.getText( );
            String telefono = txtTelefono.getText( );
            String direccion = txtDireccion.getText( );
            
            
            boolean problemas = false;
            int ced=0;
            int tel=0;
            
            if( !nombre.equals( "" ) && !telefono.equals( "" )&& !cedula.equals( "" )&& !direccion.equals( "" ) )
            {
                try
                {
                    ced = Integer.parseInt( cedula );
                }
                catch(NumberFormatException e1)
                {
                    problemas=true;
                    JOptionPane.showMessageDialog(this, "La cédula tiene que ser un número.", "Error en cédula", JOptionPane.ERROR_MESSAGE );
                }
                
                try
                {
                    tel = Integer.parseInt( telefono );
                }
                catch(NumberFormatException e1)
                {
                    problemas=true;
                    JOptionPane.showMessageDialog(this, "El teléfono tiene que ser un número.", "Error en teléfono", JOptionPane.ERROR_MESSAGE );
                }
                
                if(problemas==false)
                {
                    dispose();
                    principal.agregarCliente(ced, nombre, tel, direccion);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Debe llenar todos los datos.", "Error", JOptionPane.ERROR_MESSAGE );
            }
            
            
            
        }
        else if( CANCELAR.equals( comando ) )
        {
            dispose();
        }
    }

    
}
