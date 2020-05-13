/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_pizzeria
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.pizzeria.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uniandes.cupi2.pizzeria.mundo.Pedido;

/**
 * Dialogo para ingresar un pedido. 
 */
public class DialogoPedido extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    
    /**
     * Constante ruta de la imagen.
     */
    private final static String RUTA = "data/pizza_delivery.jpg";

    /**
     * Constante para el nombre del cliente.
     */
    private final static String NOMBRE_CLIENTE = "Nombre";

    /**
     * Constante para la c�dula del cliente.
     */
    private final static String CEDULA_CLIENTE = "C�dula";

    /**
     * Constante apra el tel�fono del cliente.
     */
    private final static String TELEFONO_CLIENTE = "Tel�fono";

    /**
     * Constante para la direcci�n del cliente.
     */
    private final static String DIRECCION_CLIENTE = "Direcci�n";

    /**
     * Constante para ingresar un pedido.
     */
    private final static String INGRESAR = "Ingresar pedido";

    /**
     * Constante para la informaci�n del cliente.
     */
    private final static String INFORMACION_CLIENTE = "Informaci�n del cliente";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n
     */
    private InterfazPizzeria principal;

    /**
     * Pedido del cual se mostrar� la informaci�n
     */
    private Pedido pedido;
    
    /**
     * C�digo del pedido que ser� ingresado.
     */
    private int codigoPedido;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta nombre del cliente.
     */
    private JLabel labelNombreCliente;
    /**
     * Etiqueta c�dula del cliente.
     */
    private JLabel labelCedulaCliente;

    /**
     * Etiqueta tel�fono del cliente.
     */
    private JLabel labelTelefonoCliente;

    /**
     * Etiqueta direcci�n del cliente.
     */
    private JLabel labelDireccionCliente;

    /**
     * Cuadro de texto con el nombre del cliente.
     */
    private JTextField txtNombreCliente;
    /**
     * Cuadro de texto con la c�dula del cliente.
     */
    private JTextField txtCedulaCliente;

    /**
     * Cuadro de texto con el tel�fono del cliente.
     */
    private JTextField txtTelefonoCliente;

    /**
     * Cuadro de texto con la direcci�n del cliente.
     */
    private JTextField txtDireccionCliente;

    /**
     * Panel que muestra los productos agregados al pedido.
     */
    private PanelProductosPedidos panelProductosPedidos;

    /**
     * Bot�n para ingresar el pedido.
     */
    private JButton btnIngresarPedido;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del di�logo para realizar un pedido.
     * @param pPrincipal Ventana principal de la aplicaci�n.
     * @param pCodigoPedido C�digo del pedido.
     */
    public DialogoPedido( InterfazPizzeria pPrincipal, int pCodigoPedido )
    {

        super( pPrincipal, true );

        principal = pPrincipal;
        codigoPedido = pCodigoPedido;
        setTitle( "Ingresar pedido" );
        setLayout( new java.awt.BorderLayout( ) );

        JPanel panelImagen = new JPanel( );
        panelImagen.setPreferredSize( new Dimension( 250, 400 ) );
        panelImagen.setLayout( new BorderLayout( ) );
        getContentPane( ).add( panelImagen, java.awt.BorderLayout.WEST );
        JLabel temp = new JLabel( );
        temp.setHorizontalAlignment( JLabel.CENTER );
        temp.setVerticalAlignment( JLabel.CENTER );
        temp.setIcon( new ImageIcon( RUTA ) );
        panelImagen.add( temp, BorderLayout.CENTER );

        JPanel granPanel = new JPanel( );
        granPanel.setPreferredSize( new Dimension( 300, 300 ) );
        granPanel.setLayout( new BorderLayout( ) );
        getContentPane( ).add( granPanel, java.awt.BorderLayout.CENTER );

        JPanel panelInformacion = new JPanel( );
        panelInformacion.setBorder( BorderFactory.createTitledBorder( INFORMACION_CLIENTE ) );
        GridLayout layout = new GridLayout( 4, 2 );
        layout.setVgap( 8 );
        layout.setHgap( 8 );
        panelInformacion.setLayout( layout );

        labelNombreCliente = new JLabel( );
        labelNombreCliente.setText( NOMBRE_CLIENTE );
        panelInformacion.add( labelNombreCliente );
        txtNombreCliente = new JTextField( );
        txtNombreCliente.setEditable( false );
        panelInformacion.add( txtNombreCliente );

        labelCedulaCliente = new JLabel( );
        labelCedulaCliente.setText( CEDULA_CLIENTE );
        panelInformacion.add( labelCedulaCliente );
        txtCedulaCliente = new JTextField( );
        txtCedulaCliente.setEditable( false );
        panelInformacion.add( txtCedulaCliente );

        labelTelefonoCliente = new JLabel( );
        labelTelefonoCliente.setText( TELEFONO_CLIENTE );
        panelInformacion.add( labelTelefonoCliente );
        txtTelefonoCliente = new JTextField( );
        txtTelefonoCliente.setEditable( false );
        panelInformacion.add( txtTelefonoCliente );

        labelDireccionCliente = new JLabel( );
        labelDireccionCliente.setText( DIRECCION_CLIENTE );
        panelInformacion.add( labelDireccionCliente );
        txtDireccionCliente = new JTextField( );
        txtDireccionCliente.setEditable( false );
        panelInformacion.add( txtDireccionCliente );

        granPanel.add( panelInformacion, java.awt.BorderLayout.NORTH );

        panelProductosPedidos = new PanelProductosPedidos( principal, codigoPedido );
        granPanel.add( panelProductosPedidos, java.awt.BorderLayout.CENTER );

        JPanel panelActualizar = new JPanel( );
        panelActualizar.setLayout( new BorderLayout( 1, 3 ) );
        btnIngresarPedido = new JButton( INGRESAR );
        btnIngresarPedido.setActionCommand( INGRESAR );
        btnIngresarPedido.addActionListener( this );
        panelActualizar.add( btnIngresarPedido, BorderLayout.CENTER );
        JPanel vacio4 = new JPanel( );
        panelActualizar.add( vacio4, BorderLayout.SOUTH );
        granPanel.add( panelActualizar, BorderLayout.SOUTH );

        JPanel vacio = new JPanel( );
        getContentPane( ).add( vacio, java.awt.BorderLayout.EAST );
        pack( );
        setLocationRelativeTo( null );
        pedido = principal.buscarPedido( codigoPedido );
        actualizarInformacionPedido( );
    }

    /**
     * Constructor di�logo para mostrar la informaci�n de un pedido dado por par�metro.
     * @param pPrincipal Ventana principal de la aplicaci�n.
     * @param pPedido Pedido del cual se desea mostrar la informaci�n.
     */
    public DialogoPedido( InterfazPizzeria pPrincipal, Pedido pPedido )
    {

        super( pPrincipal, true );

        principal = pPrincipal;
        pedido = pPedido;
        setTitle( "Informaci�n pedido" );
        setLayout( new java.awt.BorderLayout( ) );

        // Panel Imagen
        JPanel panelImagen = new JPanel( );
        panelImagen.setPreferredSize( new Dimension( 250, 400 ) );
        panelImagen.setLayout( new BorderLayout( ) );
        getContentPane( ).add( panelImagen, java.awt.BorderLayout.WEST );
        JLabel temp = new JLabel( );
        temp.setHorizontalAlignment( JLabel.CENTER );
        temp.setVerticalAlignment( JLabel.CENTER );
        temp.setIcon( new ImageIcon( RUTA ) );
        panelImagen.add( temp, BorderLayout.CENTER );

        JPanel granPanel = new JPanel( );
        granPanel.setPreferredSize( new Dimension( 300, 300 ) );
        granPanel.setLayout( new BorderLayout( ) );
        getContentPane( ).add( granPanel, java.awt.BorderLayout.CENTER );

        JPanel panelInformacion = new JPanel( );
        panelInformacion.setBorder( BorderFactory.createTitledBorder( INFORMACION_CLIENTE ) );
        GridLayout layout = new GridLayout( 4, 2 );
        layout.setVgap( 8 );
        layout.setHgap( 8 );
        panelInformacion.setLayout( layout );

        labelNombreCliente = new JLabel( );
        labelNombreCliente.setText( NOMBRE_CLIENTE );
        panelInformacion.add( labelNombreCliente );
        txtNombreCliente = new JTextField( );
        txtNombreCliente.setEditable( false );
        panelInformacion.add( txtNombreCliente );

        labelCedulaCliente = new JLabel( );
        labelCedulaCliente.setText( CEDULA_CLIENTE );
        panelInformacion.add( labelCedulaCliente );
        txtCedulaCliente = new JTextField( );
        txtCedulaCliente.setEditable( false );
        panelInformacion.add( txtCedulaCliente );

        labelTelefonoCliente = new JLabel( );
        labelTelefonoCliente.setText( TELEFONO_CLIENTE );
        panelInformacion.add( labelTelefonoCliente );
        txtTelefonoCliente = new JTextField( );
        txtTelefonoCliente.setEditable( false );
        panelInformacion.add( txtTelefonoCliente );

        labelDireccionCliente = new JLabel( );
        labelDireccionCliente.setText( DIRECCION_CLIENTE );
        panelInformacion.add( labelDireccionCliente );
        txtDireccionCliente = new JTextField( );
        txtDireccionCliente.setEditable( false );
        panelInformacion.add( txtDireccionCliente );

        granPanel.add( panelInformacion, java.awt.BorderLayout.NORTH );

        panelProductosPedidos = new PanelProductosPedidos( principal, pPedido.darProductosPedidos( ) );
        granPanel.add( panelProductosPedidos, java.awt.BorderLayout.CENTER );

        JPanel vacio = new JPanel( );
        granPanel.add( vacio, java.awt.BorderLayout.SOUTH );

        JPanel vacio3 = new JPanel( );
        getContentPane( ).add( vacio3, java.awt.BorderLayout.EAST );
        pack( );
        setLocationRelativeTo( null );

        actualizarInformacionPedido( );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Actualiza la informaci�n desplegada en el dialogo con la informaci�n que contiene el pedido dado.
     */
    private void actualizarInformacionPedido( )
    {
        txtNombreCliente.setText( pedido.darCliente( ).darNombre( ) );
        txtCedulaCliente.setText( String.valueOf( pedido.darCliente( ).darCedula( ) ) );
        txtDireccionCliente.setText( pedido.darCliente( ).darDireccion( ) );
        txtTelefonoCliente.setText( String.valueOf( pedido.darCliente( ).darTelefono( ) ) );
        panelProductosPedidos.actualizarProductosPedidos( pedido.darProductosPedidos( ), pedido.darValorTotalPedido( ) );

    }
   
    /**
     * Recoge las acciones sobre los objetos que est� escuchando.
     * @param pEvento Evento que se realiz�.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        if( INGRESAR.equals( pEvento.getActionCommand( ) ) )
        {
            if(principal.buscarPedido( codigoPedido ).darProductosPedidos( ).size( )>0)
            {
                principal.mostrarTodosLosPedidos( );
                dispose( );
            }
            else
            {
                JOptionPane.showMessageDialog( principal, "Un pedido debe tener por lo menos un producto.", "Error al ingresar pedido.", JOptionPane.ERROR_MESSAGE );
            }
            
            
        }
    }
    
}
