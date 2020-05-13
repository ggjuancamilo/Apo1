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
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.cupi2.pizzeria.mundo.Cliente;
import uniandes.cupi2.pizzeria.mundo.Pedido;
import uniandes.cupi2.pizzeria.mundo.Pizzeria;
import uniandes.cupi2.pizzeria.mundo.Producto;

/**
 * Ventana principal de la aplicación.
 */
public class InterfazPizzeria extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private Pizzeria pizzeria;
 
    /**
     * Numero consecutivo para dar un identificador a los pedidos.
     */
    private int numConsecutivo;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con la imagen.
     */
    private PanelImagen panelImagen;

    /**
     * Panel con las extensiones.
     */
    private PanelOpciones panelOpciones;

    /**
     * Panel con la lista de pedidos.
     */
    private PanelPedidos panelPedidos;

    /**
     * Panel con las opciones para manejar los productos.
     */
    private PanelManejoProductos panelManejoProductos;

    /**
     * Panel con las consultas sobre los pedidos.
     */
    private PanelConsultas panelConsultas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la ventana principal.
     */
    public InterfazPizzeria( )
    {
        // Crea la clase principal
        pizzeria = new Pizzeria( );
        numConsecutivo = 1;

        // Construye la forma
        setTitle( "Pizzería" );
        getContentPane( ).setLayout( new BorderLayout( 10, 10 ) );
        setSize( 1200, 620 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // Panel imagen
        panelImagen = new PanelImagen( );
        getContentPane( ).add( panelImagen, BorderLayout.NORTH );
        panelPedidos = new PanelPedidos( this );
        add( panelPedidos, BorderLayout.CENTER );

        JPanel panelDerecho = new JPanel( );
        panelDerecho.setLayout( new BorderLayout( 10, 10 ) );
        panelConsultas = new PanelConsultas( this );
        panelDerecho.add( panelConsultas, BorderLayout.CENTER );
        panelManejoProductos = new PanelManejoProductos( this );
        panelDerecho.add( panelManejoProductos, BorderLayout.NORTH );

        add( panelDerecho, BorderLayout.EAST );

        panelOpciones = new PanelOpciones( this );
        add( panelOpciones, BorderLayout.SOUTH );

        try
        {
            cargarProductos( "data/productos.properties" );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
        }

        setLocationRelativeTo( null );
        setResizable( false );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Carga de un archivo de propiedades los productos de la pizzería.<br>
     * <b>pre:</b> La lista de productos esta inicializada <br>
     * @param pArchivo Ruta y nombre del archivo que se quiere cargar. pArchivo != null.
     * @throws Exception Si el archivo está mal formado.
     */
    private void cargarProductos( String pArchivo ) throws Exception
    {
        String nombre, sprecio;
        double precio;
        int nProductos;

        try
        {
            Properties datos = new Properties( );
            FileInputStream input = new FileInputStream( pArchivo );
            datos.load( input );

            // Obtiene el número de productos
            nProductos = Integer.parseInt( datos.getProperty( "total.productos" ) );

            for( int i = 1; i <= nProductos; i++ )
            {
                nombre = datos.getProperty( "producto" + i + ".nombre" );
                if( nombre == null )
                {
                    throw new Exception( "Falta definir la propiedad " + "producto" + i + ".nombre" );
                }
                sprecio = datos.getProperty( "producto" + i + ".precio" );
                if( sprecio == null )
                {
                    throw new Exception( "Falta definir la propiedad " + "producto" + i + ".precio" );
                }

                precio = Double.valueOf( sprecio ).doubleValue( );

                pizzeria.agregarProducto( nombre, precio );
            }
        }
        catch( Exception e )
        {
            throw new Exception( "Error al cargar los datos almacenados de los productos" );
        }

    }


    /**
     * Retorna los productos que contiene la pizzería. <br>
     * <b>post: </b> Retorna una lista inicializada con los productos de la pizzería. <br>
     * @return Productos de la pizzería.
     */
    public ArrayList darProductosPizzeria( )
    {
        return pizzeria.darProductos( );
    }

    /**
     * Muestra el diálogo que permite agregar un producto a la pizzería.
     */
    public void mostrarDialogoAgregarProducto()
    {
        DialogoAgregarProducto dialogo = new DialogoAgregarProducto( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
    }

    /**
     * Agrega un producto a la pizzería con los valores pasados por parámetro.
     * @param pNombreProducto Nombre del producto. pNombreProducto != null.
     * @param pPrecio Precio del producto.
     */
    public void agregarProducto( String pNombreProducto, double pPrecio )
    {
        try
        {
            pizzeria.agregarProducto( pNombreProducto, pPrecio );
            JOptionPane.showMessageDialog( this, "Se agregó el producto correctamente.", "Agregar producto", JOptionPane.INFORMATION_MESSAGE );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Error al agregar producto", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Elimina un producto que tiene el nombre ingresado por el usuario. Si se presentan errores se notifica con un mensaje.
     */
    public void eliminarProducto( )
    {
        String nombreProducto = JOptionPane.showInputDialog( this, "Ingrese el nombre del producto a eliminar.", "Eliminar producto", JOptionPane.QUESTION_MESSAGE );

        if(nombreProducto!=null)
        {
            try
            {
                pizzeria.eliminarProducto( nombreProducto );
                JOptionPane.showMessageDialog( this, "Se eliminó el producto correctamente.", "Eliminar producto", JOptionPane.INFORMATION_MESSAGE );
            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( this, e.getMessage( ), "Error al eliminar producto", JOptionPane.ERROR_MESSAGE );
            }
        }

    }

    /**
     * Muestra el diálogo que permite ingresar los datos del cliente del pedido.
     */
    public void mostrarDialogoIngresarClientePedido( )
    {
        
        String cedulaStr = JOptionPane.showInputDialog( this, "Cédula del cliente:" );
        if( cedulaStr != null )
        {
            try
            {
                int cedula = Integer.parseInt( cedulaStr );     
                
                if(cedula <= 0)
                {
                    JOptionPane.showMessageDialog( this, "La cédula del cliente debe ser un número positivo.", "Error", JOptionPane.ERROR_MESSAGE );
                }
                
                else
                {
                    Cliente elCliente = pizzeria.buscarCliente(cedula);
                    
                    if (elCliente != null)
                    {
                        mostrarDialogoPedido(elCliente);
                    }
                    else
                    {
                        DialogoIngresarClientePedido dialogo = new DialogoIngresarClientePedido( this, cedula );
                        dialogo.setLocationRelativeTo( this );
                        dialogo.setVisible( true );           
                    }
                }
                
            }
            catch( NumberFormatException e1 )
            {
                JOptionPane.showMessageDialog( this, "La cédula del cliente debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE );
            }
            
        }
    }

    
    /**
     * Muestra el diálogo que permite agregar un nuevo pedido.
     * <b>pre:</b> No existe en la pizzería ningún cliente con cédula pCedula
     * @param pCedula Cédula del cliente a ser agregado. pCedula > 0.
     * @param pNombre Nombre del cliente a ser agregado. pNombre != null && pNombre != ""
     * @param pTelefono Teléfono del cliente a ser agregado. pTelefono > 0
     * @param pDireccion Dirección del cliente a ser agregado. pDireccion != null && pDireccion != ""
     */
    public void agregarCliente( int pCedula, String pNombre, int pTelefono, String pDireccion)
    {
        pizzeria.agregarCliente(pNombre, pCedula, pTelefono, pDireccion);
        
        Cliente nuevoCliente = pizzeria.buscarCliente(pCedula);
        
        mostrarDialogoPedido( nuevoCliente );
    }    
    
    /**
     * Muestra el diálogo que permite agregar un nuevo pedido.
     * @param pCliente Cliente que hace el pedido.

     */
    public void mostrarDialogoPedido( Cliente pCliente)
    {
        try
        {
            pizzeria.agregarPedido( numConsecutivo,  pCliente);
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Ya se encuentran el maximo de productos en elaboración.", JOptionPane.ERROR_MESSAGE );
            // TODO: handle exception
        }
        
        DialogoPedido dialogo = new DialogoPedido( this, numConsecutivo );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
        numConsecutivo++;
    }

    /**
     * Agrega un producto a un pedido dado su código.
     * @param pCodigoPedido Código del producto. pCodigoPedido > 0.
     * @param pNombreProducto Nombre del producto a ser agregado. pNombre != null.
     */
    public void agregarProductoAPedido( int pCodigoPedido, String pNombreProducto )
    {
        try
        {
            pizzeria.agregarProductoAPedido( pCodigoPedido, pNombreProducto );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Error al agregar producto", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Elimina un producto de un pedido dado su código.
     * @param pCodigoPedido Código del producto. pCodigoPedido > 0.
     * @param pNombreProducto Nombre del producto a ser agregado. pNombre != null.
     */
    public void eliminarProductoAPedido( int pCodigoPedido, String pNombreProducto)
    {
        try
        {
            pizzeria.eliminarProductoAPedido( pCodigoPedido, pNombreProducto );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Error al eliminar producto", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Retorna el producto con el nombre dado por parámetro.
     * @param pNombre Nombre del producto. pNombre != null.
     * @return Producto con el nombre dado.
     */
    public Producto buscarProductoPizzeria( String pNombre )
    {
        return pizzeria.buscarProducto( pNombre );
    }

    /**
     * Retorna un pedido dado su código.
     * @param pCodigoPedido Código del pedido. pCodigoPedido > 0.
     * @return Pedido con el código dado.
     */
    public Pedido buscarPedido(int pCodigoPedido)
    {
        try
        {
            return pizzeria.buscarPedido( pCodigoPedido );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return null;
    }

    /**
     * Registra el despacho del pedido seleccionado.
     */
    public void registrarDespachoPedido( )
    {

        int seleccionado = panelPedidos.darPedidoSeleccionado( );
        if( seleccionado != -1 )
        {
            try
            {
                String tiempoStr = JOptionPane.showInputDialog( this, "Tiempo en minutos que tomó despachar el pedido:" );
                if( tiempoStr != null )
                {
                    int tiempo = Integer.parseInt( tiempoStr );
                    if(tiempo==0)
                    {
                        JOptionPane.showMessageDialog( this, "El tiempo ingresado debe ser mayor a cero.", "Error", JOptionPane.ERROR_MESSAGE );
                    }
                    else
                    {
                        pizzeria.registrarDespachoPedido( seleccionado, tiempo );
                        mostrarTodosLosPedidos( );
                    }
                }

            }
            catch( NumberFormatException e1 )
            {
                JOptionPane.showMessageDialog( this, "El tiempo ingresado debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE );
            }
            catch( Exception e2 )
            {
                JOptionPane.showMessageDialog( this, e2.getMessage( ), "Registrar despacho pedido.", JOptionPane.ERROR_MESSAGE );
                mostrarTodosLosPedidos( );
            }
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Debe seleccionar un pedido de la lista.", "Registrar despacho pedido.", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Registra el despacho del pedido seleccionado.
     */
    public void registrarEntregaPedido( )
    {

        int seleccionado = panelPedidos.darPedidoSeleccionado( );
        
        if( seleccionado != -1 )
        {
            try
            {
                String tiempoStr = JOptionPane.showInputDialog( this, "Tiempo en minutos que tomó entregar el pedido:" );
                if( tiempoStr != null )
                {

                    int tiempo = Integer.parseInt( tiempoStr );
                    if(tiempo==0)
                    {
                        JOptionPane.showMessageDialog( this, "El tiempo ingresado no puede ser cero.", "Error", JOptionPane.ERROR_MESSAGE );
                    }
                    else
                    {
                        pizzeria.registrarEntregaPedido( seleccionado, tiempo );
                        Pedido pedido = pizzeria.buscarPedido( seleccionado );

                        if( pedido.darValorTotalPedido( ) == 0 )
                        {
                            JOptionPane.showMessageDialog( this, "El pedido es gratis dado que no se cumplieron las condiciones de calidad de la entrega.", "Pedido gratis", JOptionPane.INFORMATION_MESSAGE );
                        }
                        mostrarTodosLosPedidos( );
                    }
                }

            }
            catch( NumberFormatException e1 )
            {
                JOptionPane.showMessageDialog( this, "El tiempo ingresado debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE );
            }
            catch( Exception e2 )
            {
                JOptionPane.showMessageDialog( this, e2.getMessage( ), "Registrar entrega pedido.", JOptionPane.ERROR_MESSAGE );

                Pedido pedido = pizzeria.buscarPedido( seleccionado );
                if( pedido.darValorTotalPedido( ) == 0 )
                {
                    JOptionPane.showMessageDialog( this, "El pedido es gratis dado que se cumplieron las condiciones de calidad de la entrega.", "Pedido gratis", JOptionPane.INFORMATION_MESSAGE );
                }
                mostrarTodosLosPedidos( );
            }
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Debe seleccionar un pedido de la lista.", "Registrar entrega pedido", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Elimina el pedido seleccionado.
     */
    public void eliminarPedido( )
    {
        int seleccionado = panelPedidos.darPedidoSeleccionado( );
        if( seleccionado != -1 )
        {
            try
            {
                pizzeria.eliminarPedido( seleccionado );
                mostrarTodosLosPedidos( );
            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( this, e.getMessage( ), "Eliminar pedido", JOptionPane.ERROR_MESSAGE );
            }
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Debe seleccionar un pedido de la lista.", "Eliminar pedido", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Muestra todos los pedidos que hay en la pizzería.
     */
    public void mostrarTodosLosPedidos( )
    {
        panelPedidos.modificarTitulo( "Todos los pedidos" );
        panelPedidos.repaint( );
        panelPedidos.actualizarPedidos( pizzeria.darPedidos( ) );
    }

    /**
     * Muestra la información del pedido que está seleccionado en el panel de pedidos.
     */
    public void mostrarInformacionPedido( )
    {
        int seleccionado = panelPedidos.darPedidoSeleccionado( );
        if( seleccionado != -1 )
        {
            try
            {
                Pedido pedido = pizzeria.buscarPedido( seleccionado );
                DialogoPedido dialogo = new DialogoPedido( this, pedido );
                dialogo.setVisible( true );
            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( this, e.getMessage( ), "Información pedido", JOptionPane.ERROR_MESSAGE );
            }
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Debe seleccionar un pedido de la lista.", "Información pedido", JOptionPane.ERROR_MESSAGE );
        }

    }

    /**
     * Retorna los productos de un pedido dado su código.
     * @param pCodigoPedido Código del pedido.
     * @return Lista con los productos del pedido.
     */
    public Vector darProductosPedido( int pCodigoPedido )
    {
        Vector rta= new Vector( );
        try
        {
            ArrayList lista = pizzeria.buscarPedido( pCodigoPedido ).darProductosPedidos( );
            for( int i = 0; i < lista.size( ); i++ )
            {
                Producto p = (Producto) lista.get( i );
                rta.add( p.darNombre( ) );
            }
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return rta;
    }

    /**
     * Muestra todos los pedidos que tiene asignados un cliente.
     */
    public void mostrarInformacionPedidosCliente( )
    {
        String cedulaCliente = JOptionPane.showInputDialog( this, "Cédula del cliente" );
        if( cedulaCliente != null )
        {
            try
            {
                ArrayList pedidosCliente = pizzeria.filtrarPedidosCliente( Integer.valueOf( cedulaCliente ).intValue( ) );
                if( pedidosCliente.size( ) != 0 )
                {
                    panelPedidos.modificarTitulo( "Pedidos del cliente: " + cedulaCliente );
                    panelPedidos.repaint( );
                    panelPedidos.actualizarPedidos( pedidosCliente );
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "No hay pedidos registrados de un cliente con la cédula dada.", "Pedidos cliente", JOptionPane.INFORMATION_MESSAGE );
                }
            }
            catch( NumberFormatException e )
            {
                JOptionPane.showMessageDialog( this, "Debe ingresar un número.", "Pedidos cliente", JOptionPane.ERROR_MESSAGE );
            }
        }

    }

    /**
     * Muestra los pedidos que están próximos en elaboración.
     */
    public void mostrarInformacionPedidosEnElaboracion( )
    {
        ArrayList pedidosEnElaboracion = pizzeria.filtrarPedidosEnElaboracion( );
        if( pedidosEnElaboracion.size( ) != 0 )
        {
            panelPedidos.modificarTitulo( "Pedidos en elaboración" );
            panelPedidos.repaint( );
            panelPedidos.actualizarPedidos( pedidosEnElaboracion );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No hay pedidos próximos en elaboración.", "Pedidos en elaboración", JOptionPane.INFORMATION_MESSAGE );
        }

    }

    /**
     * Muestra la información de los pedidos despachados.
     */
    public void mostrarInformacionPedidosDespachados( )
    {
        ArrayList pedidosDespachados = pizzeria.filtrarPedidosDespachados( );
        if( pedidosDespachados.size( ) != 0 )
        {
            panelPedidos.modificarTitulo( "Pedidos despachados" );
            panelPedidos.repaint( );
            panelPedidos.actualizarPedidos( pedidosDespachados );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No hay pedidos despachados.", "Pedidos despachados", JOptionPane.INFORMATION_MESSAGE );
        }

    }

    /**
     * Muestra la información de los pedidos entregados.
     */
    public void mostrarInformacionPedidosEntregados( )
    {
        ArrayList pedidosEntregados = pizzeria.filtrarPedidosEntregados( );
        if( pedidosEntregados.size( ) != 0 )
        {
            panelPedidos.modificarTitulo( "Pedidos entregados" );
            panelPedidos.repaint( );
            panelPedidos.actualizarPedidos( pedidosEntregados );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No hay pedidos entregados.", "Pedidos entregados", JOptionPane.INFORMATION_MESSAGE );
        }

    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1
     */
    public void reqFuncOpcion1( )
    {
        String resultado = pizzeria.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2
     */
    public void reqFuncOpcion2( )
    {
        String resultado = pizzeria.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Método ejecuta la aplicación creando una nueva interfaz.
     * @param args No son necesarios.
     */
    public static void main( String[] args )
    {
        InterfazPizzeria interfaz = new InterfazPizzeria( );
        interfaz.setVisible( true );
    }



}