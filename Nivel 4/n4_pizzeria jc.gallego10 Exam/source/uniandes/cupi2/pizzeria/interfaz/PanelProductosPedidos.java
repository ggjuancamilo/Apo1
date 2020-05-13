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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import uniandes.cupi2.pizzeria.mundo.Producto;

/**
 * Panel para visualizar los productos seleccionados en un pedido.
 */
public class PanelProductosPedidos extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante de serializaci�n.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constante para agregar producto.
     */
    private static final String AGREGAR = "Agregar";

    /**
     * Constante para eliminar producto.
     */
    private static final String ELIMINAR = "Eliminar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazPizzeria principal;

    /**
     * Lista con los productos pedidos.
     */
    private Vector productosPedidos;

    /**
     * Valor total del pedido.
     */
    private double valorTotal;
    
    /**
     * C�digo del pedido.
     */
    private int codigoPedido;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Lista donde se muestran los pedidos existentes en la pizzer�a.
     */
    private JList listaProductos;

    /**
     * Bot�n para agregar un producto a la lista.
     */
    private JButton btnAgregar;

    /**
     * Bot�n para eliminar un producto de la lista.
     */
    private JButton btnEliminar;

    /**
     * Etiqueta para informar el total del pedido.
     */
    private JLabel lblTotalPedido;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel para la visualizaci�n de los productos a�adidos en un pedido.
     * @param pPrincipal Ventana principal de la aplicaci�n.
     */
    public PanelProductosPedidos( InterfazPizzeria pPrincipal, int pCodigoPedido )
    {

        principal = pPrincipal;
        productosPedidos = new Vector( );
        valorTotal = 0;
        codigoPedido = pCodigoPedido;

        setBorder( BorderFactory.createTitledBorder( "Productos seleccionados" ) );
        setLayout( new BorderLayout( ) );

        listaProductos = new JList( );
        JScrollPane scroll = new JScrollPane( );
        scroll.setViewportView( listaProductos );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        scroll.setPreferredSize( new Dimension( 300, 160 ) );
        add( scroll, BorderLayout.NORTH );

        btnAgregar = new JButton( );
        btnAgregar.setText( AGREGAR );
        btnAgregar.setActionCommand( AGREGAR );
        btnAgregar.addActionListener( this );

        btnEliminar = new JButton( );
        btnEliminar.setText( ELIMINAR );
        btnEliminar.setActionCommand( ELIMINAR );
        btnEliminar.addActionListener( this );

        JPanel panel = new JPanel( );
        panel.add( btnAgregar );
        panel.add( btnEliminar );
        add( panel, BorderLayout.CENTER );

        lblTotalPedido = new JLabel( "Total: $0" );
        lblTotalPedido.setForeground( Color.BLUE.darker( ) );
        lblTotalPedido.setFont( new Font( "Arial", Font.BOLD, 14 ) );
        lblTotalPedido.setPreferredSize( new Dimension( 10, 10 ) );

        add( lblTotalPedido, BorderLayout.SOUTH );

    }

    /**
     * Crea el panel para la visualizaci�n de los productos dados por par�metro.
     * @param pPrincipal Ventana principal de la aplicaci�n.
     * @param pProductos Productos pedidos.
     */
    public PanelProductosPedidos( InterfazPizzeria pPrincipal, ArrayList pProductos )
    {

        principal = pPrincipal;
        productosPedidos = new Vector( );
        valorTotal = 0;

        setBorder( BorderFactory.createTitledBorder( "Productos seleccionados" ) );
        setLayout( new BorderLayout( ) );

        listaProductos = new JList( );
        JScrollPane scroll = new JScrollPane( );
        scroll.setViewportView( listaProductos );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        scroll.setPreferredSize( new Dimension( 300, 200 ) );
        add( scroll, BorderLayout.NORTH );

        lblTotalPedido = new JLabel( "Total: 0" );
        lblTotalPedido.setForeground( Color.BLUE.darker( ) );
        lblTotalPedido.setFont( new Font( "Arial", Font.BOLD, 14 ) );
        lblTotalPedido.setPreferredSize( new Dimension( 10, 10 ) );

        add( lblTotalPedido, BorderLayout.SOUTH );

    }
    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Actualiza la lista de productos pedidos.
     * @param pProductos Productos pedidos.
     * @param pPrecio Precio total de los productos pedidos.
     */
    public void actualizarProductosPedidos( ArrayList pProductos, double pPrecio )
    {
        String[] lista = new String[pProductos.size( )];

        for( int i = 0; i < pProductos.size( ); i++ )
        {
            lista[ i ] = String.valueOf( ( ( Producto )pProductos.get( i ) ).darNombre( ) );
        }

        listaProductos.removeAll( );
        listaProductos.setListData( lista );
        lblTotalPedido.setText( "Total: $" + formatearValorReal( pPrecio ) );
        valorTotal = pPrecio;
    }

    /**
     * Recoge las acciones sobre los objetos que est� escuchando.
     * @param pEvento Evento que se realiz�.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        if( AGREGAR.equals( pEvento.getActionCommand( ) ) )
        {
            agregarProducto( );
        }
        if( ELIMINAR.equals( pEvento.getActionCommand( ) ) )
        {
            eliminarProducto( );
        }

    }

    /**
     * Agrega un producto a la lista de productos pedidos.
     */
    private void agregarProducto( )
    {
        Object[] possibilities = new Object[principal.darProductosPizzeria( ).size( )];

        for( int i = 0; i < principal.darProductosPizzeria( ).size( ); i++ )
        {
            possibilities[ i ] = ( ( Producto )principal.darProductosPizzeria( ).get( i ) ).darNombre( );
        }

        String producto = ( String )JOptionPane.showInputDialog( this, "Productos disponibles:", "Productos", JOptionPane.INFORMATION_MESSAGE, null, possibilities, possibilities[ 0 ] );
        if( producto != null )
        {
            principal.agregarProductoAPedido( codigoPedido, producto );
            productosPedidos = principal.darProductosPedido( codigoPedido );
            valorTotal = principal.buscarPedido( codigoPedido ).darValorTotalPedido( );
            listaProductos.setListData( productosPedidos );
            lblTotalPedido.setText( "Total: $" + formatearValorReal( valorTotal ) );
        }
    }

    /**
     * Elimina un producto de la lista de productos pedidos.
     */
    private void eliminarProducto( )
    {

        if( listaProductos.getSelectedValue( ) != null )
        {
            String seleccionado = listaProductos.getSelectedValue( ).toString( );
            principal.eliminarProductoAPedido( codigoPedido, seleccionado );
            productosPedidos.remove( seleccionado );
            valorTotal = principal.buscarPedido( codigoPedido ).darValorTotalPedido( );
            listaProductos.setListData( productosPedidos );
            lblTotalPedido.setText( "Total: $" + formatearValorReal( valorTotal ) );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Debe seleccionar un producto de la lista.", "Eliminar producto.", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Retorna una lista con los productos seleccionados para el pedido.
     * @return Lista con los productos pedidos.
     */
    public ArrayList darProductosSeleccionados( )
    {
        ArrayList productos = new ArrayList( );
        for( Iterator iter = productosPedidos.iterator( ); iter.hasNext( ); )
        {
            String nombre = ( String )iter.next( );
            productos.add( principal.buscarProductoPizzeria( nombre ) );
        }
        return productos;
    }

    /**
     * Formatea un valor num�rico real para presentar en la interfaz. <br>
     * @param pValor Valor num�rico a ser formateado.
     * @return Cadena con el valor formateado con puntos y signos.
     */
    private String formatearValorReal( double pValor )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( " ###,###" );
        df.setMinimumFractionDigits( 0 );
        return df.format( pValor );
    }

}
