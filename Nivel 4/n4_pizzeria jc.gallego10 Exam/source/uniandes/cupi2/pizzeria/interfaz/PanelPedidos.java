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
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import uniandes.cupi2.pizzeria.mundo.Pedido;

/**
 * Clase para visualizar los pedidos de una pizzería.
 */
public class PanelPedidos extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para consultar información pedido.
     */
    public final static String INFORMACION_PEDIDO = "Ver información pedido";
    
    /**
     * Constante para ingresar un pedido.
     */
    private final static String INGRESAR = "Ingresar pedido";

    /**
     * Constante para registrar el despacho de un pedido.
     */
    private final static String DESPACHAR = "Registrar despacho pedido";
    
    /**
     * Constante para registrar la entrega de un pedido.
     */
    private final static String ENTREGAR = "Registrar entrega pedido";
    
    /**
     * Constante para eliminar un pedido.
     */
    private final static String ELIMINAR = "Eliminar pedido";
    
    /**
     * Constante con los nombres de las columnas de la tabla.
     */
    public static final String[] NOMBRE_COLUMNAS = { "Número", "Estado", "Tiempo despacho", "Tiempo entrega", "Teléfono", "Nombre", "Cédula" };

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
     * Tabla para mostrar la información de los pedidos.
     */
    private JTable tablaPedidos;

    /**
     * Modelo para visualizar la información en la tabla de los pedidos.
     */
    private DefaultTableModel model;

    /**
     * Botón para consultar la información de un pedido seleccionado.
     */
    private JButton btnInformacionPedido;
    
    /**
     * Botón para ingresar un pedido.
     */
    private JButton btnIngresarPedido;

    /**
     * Botón para registrar el despacho de un pedido.
     */
    private JButton btnDespacharPedido;
    
    /**
     * Botón para registrar la entrega de un pedido.
     */
    private JButton btnEntregarPedido;
    
    /**
     * Botón para eliminar un pedido.
     */
    private JButton btnEliminarPedido;

    /**
     * Borde del panel.
     */
    private TitledBorder borde;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel para la visualización de los pedidos.
     * @param pPrincipal Ventana principal de la aplicación.
     */
    public PanelPedidos( InterfazPizzeria pPrincipal )
    {

        principal = pPrincipal;

        borde = new TitledBorder( "Todos los pedidos" );
        setBorder( borde );
        setLayout( new BorderLayout( ) );

        model = new DefaultTableModel( NOMBRE_COLUMNAS, 0 );
        tablaPedidos = new JTable( model );
        tablaPedidos.setColumnSelectionAllowed( false );
        tablaPedidos.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        tablaPedidos.setFont( new Font( "Arial", Font.BOLD, 12 ) );
        tablaPedidos.setAutoResizeMode( JTable.AUTO_RESIZE_ALL_COLUMNS );
        tablaPedidos.getTableHeader( ).setReorderingAllowed( false );

        JScrollPane scroll = new JScrollPane( );
        scroll.setViewportView( tablaPedidos );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        add( scroll, BorderLayout.CENTER );

        JPanel panelOpcionesPedido = new JPanel( );
        panelOpcionesPedido.setLayout( new GridLayout( 1, 5 ) );
        
        btnInformacionPedido = new JButton( INFORMACION_PEDIDO );
        btnInformacionPedido.setActionCommand( INFORMACION_PEDIDO );
        btnInformacionPedido.addActionListener( this );
        panelOpcionesPedido.add( btnInformacionPedido );
        
        btnIngresarPedido = new JButton( INGRESAR );
        btnIngresarPedido.setActionCommand( INGRESAR );
        btnIngresarPedido.addActionListener( this );
        panelOpcionesPedido.add( btnIngresarPedido );

        btnDespacharPedido = new JButton( DESPACHAR );
        btnDespacharPedido.setActionCommand( DESPACHAR );
        btnDespacharPedido.addActionListener( this );
        panelOpcionesPedido.add( btnDespacharPedido );
        
        btnEntregarPedido = new JButton( ENTREGAR );
        btnEntregarPedido.setActionCommand( ENTREGAR );
        btnEntregarPedido.addActionListener( this );
        panelOpcionesPedido.add( btnEntregarPedido );
        
        btnEliminarPedido = new JButton( ELIMINAR );
        btnEliminarPedido.setActionCommand( ELIMINAR );
        btnEliminarPedido.addActionListener( this );
        panelOpcionesPedido.add( btnEliminarPedido );
        add( panelOpcionesPedido, BorderLayout.SOUTH );

    }
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Método que actualiza la tabla con la información de los pedidos.
     * @param pPedidos Pedidos que contiene actualmente la pizzería.
     */
    public void actualizarPedidos( ArrayList pPedidos )
    {
        model = new DefaultTableModel( NOMBRE_COLUMNAS, 0 );
        tablaPedidos.setModel( model );
        String[] columna;

        for( int i = 0; i < pPedidos.size( ); i++ )
        {
            columna = new String[7];
            Pedido pedido = ( Pedido )pPedidos.get( i );
            columna[ 0 ] = String.valueOf( pedido.darCodigo( ) );
            columna[ 1 ] = pedido.darEstado( );
            columna[ 2 ] = String.valueOf( pedido.darTiempoDeDespacho( ) );
            columna[ 3 ] = String.valueOf( pedido.darTiempoDeEntrega( ) );
            columna[ 4 ] = String.valueOf( pedido.darCliente( ).darTelefono( ) );
            columna[ 5 ] = pedido.darCliente( ).darNombre( );
            columna[ 6 ] = String.valueOf( pedido.darCliente( ).darCedula( ) );

            model.addRow( columna );
        }
    }

    /**
     * Retorna el índice del pedido seleccionado en la tabla.
     * @return Índice del pedido seleccionado en la tabla.
     */
    public int darPedidoSeleccionado( )
    {
        try
        {
            String numPedido = ( String )model.getValueAt( tablaPedidos.getSelectedRow( ), 0 );
            if( numPedido != null )
                return Integer.valueOf( numPedido ).intValue( );
        }
        catch( ArrayIndexOutOfBoundsException e )
        {
            return -1;
        }
        return -1;

    }

    /**
     * Modifica el titulo del panel.
     * @param pTitulo Nuevo titulo. pTitulo != null.
     */
    public void modificarTitulo( String pTitulo )
    {
        borde.setTitle( pTitulo );
    }

    /**
     * Recoge las acciones sobre los objetos que está escuchando.
     * @param pEvento Evento que se realizó.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( INGRESAR ) )
        {
            principal.mostrarDialogoIngresarClientePedido();
        }
        else if( INFORMACION_PEDIDO.equals( comando ) )
        {
            principal.mostrarInformacionPedido( );
        }
        else if( comando.equals( DESPACHAR ) )
        {
            principal.registrarDespachoPedido( );
        }
        else if( comando.equals( ENTREGAR ) )
        {
            principal.registrarEntregaPedido( );
        }
        else if( comando.equals( ELIMINAR ) )
        {
            principal.eliminarPedido( );
        }

    }
}
