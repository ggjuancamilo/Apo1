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
package uniandes.cupi2.pizzeria.mundo;

import java.util.ArrayList;

/**
 * Clase que representa la pizzería.
 */
public class Pizzeria
{

    

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    
    /**
     * Constante que declara el maximo de pedidos que puede realizar un cliente.
     */
    public static final int MAX_PEDIDOS_CLIENTES = 3;
    
    /**
     * Constante que declara el maximo de productos que puede tener la pizzeria en elaboracion.
     */
    public static final int MAX_PROD_ELABORACION = 25;
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la colección de de productos de la pizzeria
     */
    private ArrayList<Producto>productos;
    // TODO Declare y documente el atributo que modela la lista de productos de la pizzería.

    /**
     * Es la colección de pedidos.
     */
    private ArrayList<Pedido>pedidos;
    // TODO Declare y documente el atributo que modela la lista de pedidos de la pizzería.

    /**
     * Es la colección de clientes.
     */
    private ArrayList<Cliente>clientes;
    // TODO Declare y documente el atributo que modela la lista de clientes de la pizzería.


    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la pizzería. 
     * <b>post: </b> Crea una lista vacía de productos. <br>
     *               Crea una lista vacía de pedidos. <br>
     *               Crea una lista vacía de clientes. <br>
     */
    public Pizzeria( )
    {
        productos = new ArrayList<Producto>( );
        pedidos = new ArrayList<Pedido>( );
        clientes = new ArrayList<Cliente>( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna los productos de la pizzería.
     * @return Productos de la pizzería.
     */
    public ArrayList<Producto> darProductos( )
    {
        return productos;
    }

    /**
     * Retorna los pedidos de la pizzería.
     * @return Pedidos de la pizzería.
     */
    public ArrayList<Pedido> darPedidos( )
    {
        return pedidos;
    }

    /**
     * Retorna los clientes de la pizzería.
     * @return Clientes de la pizzería.
     */
    public ArrayList<Cliente> darClientes( )
    {
        return clientes;
    }

    /**
     * Retorna el producto con el nombre dado. <br>
     * <b>pre:</b> La lista de productos se encuentra inicializada. <br>
     * @param pNombreProducto Nombre del producto deseado. pNombreProducto != null && pNombreProducto != "".
     * @return Producto con el nombre dado, null si no lo encuentra.
     */
    public Producto buscarProducto( String pNombreProducto )
    {
        Producto buscado = null;
        boolean encontro = false;
        for( int i = 0; i < productos.size( ) && !encontro; i++ )
        {
            Producto productoActual = ( Producto ) productos.get( i );
            if( productoActual.darNombre( ).equals( pNombreProducto ) )
            {
                encontro = true;
                buscado = productoActual;
            }
        }
        return buscado;
    }

    /**
     * Retorna el pedido con el código dado por parámetro. <br>
     * <b>pre:</b> La lista de pedidos se encuentra inicializada. <br>
     * @param pCodigoPedido Código del pedido. pCodigoPedido >= 0.
     * @return Pedido con el código dado, null si no lo encuentra.
     */
    public Pedido buscarPedido( int pCodigoPedido )
    {
        boolean encontro = false;
        Pedido buscado = null;

        for( int i = 0; i < pedidos.size( ) && !encontro; i++ )
        {
            Pedido pedidoActual = ( Pedido )pedidos.get( i );
            if( pedidoActual.darCodigo( ) == pCodigoPedido )
            {
                buscado = pedidoActual;
                encontro = true;
            }
        }
        return buscado;
    }

    /**
     * Retorna el cliente que tiene la cédula dada por parámetro.
     * <b>pre:</b> La lista de clientes se encuentra inicializada. <br>
     * @param pCedulaCliente Cédula del cliente que se está buscando. pCedulaCliente > 0.
     * @return Cliente con la cédula dada, null si no lo encuentra.
     */
    public Cliente buscarCliente(int pCedulaCliente)
    {
        
        for( int i = 0; i < clientes.size( ); i++ )
        {
            if(clientes.get(i).darCedula( ) == pCedulaCliente)
            {
                return clientes.get(i);
            }
        }
        return null;
    }
    // TODO Implemente el método buscarCliente de acuerdo al contrato proporcionado.

    /**
     * Agrega un nuevo producto a la lista de productos de la pizzería.<br>
     * <b>pre:</b>La lista de productos está inicializada. <br>
     * <b>post:</b>La lista de productos tiene un nuevo producto.<br>
     *             La lista de productos no tiene dos productos con el mismo nombre.
     * @param pNombreProducto Nombre del producto. pNombreProducto != null && pNombreProducto != "".
     * @param pPrecioProducto Precio del producto.
     * @throws Exception Si se intenta agregar un producto con precio negativo.
     * @throws Exception Si ya existe un producto con el nombre dado.
     */
    
    public void agregarProducto(String pNombreProducto, double pPrecioProducto)throws Exception
    {
        if( pPrecioProducto > 0 )
        {
            for( int i = 0; i < productos.size( ); i++ )
            {
                if(productos.get( i ).darNombre( ).equals( pNombreProducto ))
                {
                   throw new Exception( "ya existe producto con este nombre");
                }
              
            } 
            productos.add(new Producto( pNombreProducto, pPrecioProducto )  );
        }
        else
        {
            throw new Exception("debe ingresar un precio positivo");
        }
        
    }
    // TODO Implemente el método agregarProducto de acuerdo al contrato proporcionado.

    /**
     * Agrega un pedido a la pizzería. 
     * <b>pre:</b> La lista de pedidos se encuentra inicializada. <br>
     * <b>post:</b> La lista de pedidos tiene un nuevo pedido. <br>
     * @param pCodigoPedido Código del pedido. pCodigoPedido > 0.
     * @param pCliente Cliente que ordenó el pedido. pCliente != null.
     * @throws Exepcion si el cliene ya tiene 3 pedidos a su nombre.
     */
    public void agregarPedido( int pCodigoPedido, Cliente pCliente) throws Exception
    {
        int contador = 0;
        for( int i = 0; i < pedidos.size( ); i++ )
            {
            if(pedidos.get( i ).darCliente( ).equals(pCliente))
                {
                contador ++;
                }
          
            }
       if( contador == MAX_PEDIDOS_CLIENTES )
       {
           throw new Exception("El cliente ya pidio el numero maximo de pedidos");
       }
       else{pedidos.add( new Pedido( pCodigoPedido,  pCliente) );}
           
      
        
    }

    /**
     * Agrega un cliente dado por parámetro.
     * <b>pre:</b> No existe en la pizzería ningún cliente con cédula pCedula.
     * @param pNombreCliente Nombre del cliente a ser agregado. pNombreCliente != null && pNombreCliente != "".
     * @param pCedulaCliente Cédula del cliente a ser agregado. pCedulaCliente > 0.
     * @param pTelefonoCliente Teléfono del cliente a ser agregado. pTelefonoCliente > 0.
     * @param pDireccionCliente Dirección del cliente a ser agregado. pDireccionCliente != null && pDireccionCliente != "".
     */
    public void agregarCliente( String pNombreCliente, int pCedulaCliente, int pTelefonoCliente, String pDireccionCliente)
    {
        Cliente nuevoCliente = new Cliente(pNombreCliente, pCedulaCliente, pTelefonoCliente, pDireccionCliente);
        clientes.add( nuevoCliente );
    }

    /**
     * Agrega un producto a un pedido.
     * <b>pre:</b> Las listas de productos y pedidos se encuentran inicializadas.
     * <b>post:</b> El pedido tiene un producto más si existe un pedido con código pCodigoPedido y si existe un producto en la pizzería con nombre pNombreProducto.
     * @param pCodigoPedido Código del pedido.  pCodigoPedido > 0.
     * @param pNombreProducto Nombre del producto para agregar. pNombreProducto != null && pNombreProducto != "".
     * @throws Exception Si el pedido con el código dado no existe.
     * @throws Exception Si el producto con el nombre dado no existe.
     * @throws Exception si la pizzeria tiene su horno completamente ocupado.
     */
    public void agregarProductoAPedido( int pCodigoPedido, String pNombreProducto ) throws Exception
    {
        Pedido elPedido = buscarPedido( pCodigoPedido );

        if( elPedido == null )
        {
            throw new Exception ( "No existe un pedido con el código dado." );
        }

        else
        {
            Producto p = buscarProducto( pNombreProducto );
            if(p == null)
            {
                throw new Exception ( "No existe un producto con el nombre dado." );
            }
            else if (cuantosProdElaboracion( ) == MAX_PROD_ELABORACION)
            {
                throw new Exception ("La pizzeria a llegado al limite de productos en el horno");        
            }
            else 
            {
                elPedido.agregarProducto(p);
            }
        }
    }

    /**
     * Eliminar un producto dado su nombre.
     * <b>pre:</b>La lista de productos está inicializada. <br>
     * <b>post:</b>La lista de productos tiene un producto menos.<br>
     * @param pNombreProducto Nombre del producto que se quiere eliminar. pNombreProducto != null && pNombreProducto != "".
     * @throws Exception Si el producto que se quiere eliminar no existe.
     * @throws Exception Si el producto que se quiere eliminar está presente en algún pedido registrado.
     */
    public void eliminarProducto(String pNombreProducto) throws Exception
    {
        if(buscarProducto( pNombreProducto ) == null)
        {
            throw new Exception( "no existe producto con ese nombre.");
        }
        else
        {
            for( int i = 0; i < pedidos.size( ) ; i++ )
            {
                if(pedidos.get( i ).darProductosPedidos( ).contains( buscarProducto( pNombreProducto ) ))
                {
                    throw new Exception( "No se puede eliminar el producto porque está presente en algún pedido");
                }
            }
            productos.remove( buscarProducto( pNombreProducto ) );
           
        }
    }
   
    // TODO Implemente el método eliminarProducto de acuerdo al contrato proporcionado.

    /**
     * Elimina un pedido dado su código.
     * <b>pre:</b> La lista de pedidos se encuentra inicializada. <br>
     * <b>post:</b> La lista de pedidos tiene un pedido menos si se encontró el pedido con el código dado y si no ha sido despachado. <br>
     * @param pCodigoPedido Código del pedido. pCodigoPedido > 0. 
     * @throws Exception Si el pedido con el código dado no existe.
     * @throws Exception Si se intenta eliminar un pedido que ya ha sido despachado.
     */
    public void eliminarPedido(int pCodigo) throws Exception
    {

        
        if(buscarPedido( pCodigo ) == null)
            {
            throw new Exception( "No existe un pedido con el código dado.");
            }
        else if(buscarPedido( pCodigo ).darEstado( ).equals( Pedido.ENTREGADO ) || buscarPedido( pCodigo ).darEstado( ).equals( Pedido.DESPACHADO ))
            {
            throw new Exception( "El pedido no se puede eliminar porque ya fue despachado y/o entregado.");                
            }
       else
        {
            pedidos.remove( buscarPedido( pCodigo ) );
        }
    }
    
    
    
    // TODO Implemente el método eliminarPedido de acuerdo al contrato proporcionado.



   

    
    /**
     * @param pCodigoPedido
     * @param pNombreProducto
     * @throws Exception
     */
  //TODO: Escribir el contrato del método eliminarProductoAPedido de acuerdo a la funcionalidad implementada.
    public void eliminarProductoAPedido( int pCodigoPedido, String pNombreProducto ) throws Exception
    {
        Pedido elPedido = buscarPedido( pCodigoPedido );
        if( elPedido == null )
        {
            throw new Exception( "No existe un pedido con el código dado." );
        }
        else
        {
            elPedido.eliminarProducto( pNombreProducto );
        }
    }

    /**
     * Registra el despacho de un pedido que se encontraba en elaboración.
     * <b>pre:</b> La lista de pedidos se encuentra inicializada.
     * <b>post:</b> El estado del pedido cambia a despachado y se actualiza el tiempo de despacho.
     * @param pCodigoPedido Código del pedido que se va a registrar el despacho. pCodigoPedido > 0.
     * @param pTiempoDeDespachoPedido Tiempo que tomó despachar el producto.
     * @throws Exception Si no existe un pedido con el código dado.
     * @throws Exception Si el pedido al que se le quiere registrar el despacho no se encontraba en estado de elaboración.
     * @throws Exception Si el tiempo que tomó despachar el producto es negativo, se captura la excepción, se cambia el número a positivo, se registra el tiempo de despacho y se lanza nuevamente la excepción con el mensaje correspondiente.
     */
    public void registrarDespachoPedido( int pCodigoPedido, int pTiempoDeDespachoPedido ) throws Exception
    {
        Pedido ped = buscarPedido( pCodigoPedido );
        if( ped == null )
        {
            throw new Exception( "No existe un pedido con el código dado." );
        }
        else
        {
            if( !ped.darEstado( ).equals( Pedido.EN_ELABORACION ) )
            {
                throw new Exception ( "No se puede registrar el despacho porque el pedido no se encuentra en elaboración." );
            }
            try
            {
                ped.registrarTiempoDeDespacho( pTiempoDeDespachoPedido );
            }
            catch ( Exception e)
            {
                if(pTiempoDeDespachoPedido<0)
                {
                    int nuevoTiempoDeDespacho = -pTiempoDeDespachoPedido;
                    ped.registrarTiempoDeDespacho( nuevoTiempoDeDespacho );
                    throw new Exception ( "El tiempo de despacho fue cambiado automáticamente a positivo para ser registrado." );
                }
            }   
        }
    }

    /**
     * Registra la entrega de un pedido que se encontraba despachado.
     * <b>pre:</b> La lista de pedidos se encuentra inicializada.
     * <b>post:</b> El estado del pedido cambia a entregado y se actualiza el tiempo de entrega.
     * @param pCodigoPedido Código del pedido que se va a registrar la entrega. pCodigoPedido > 0.
     * @param pTiempoDeEntregaPedido Tiempo que tomó entregar el producto.
     * @throws Exception Si no existe un pedido con el código dado.
     * @throws Exception Si el pedido al que se le quiere registrar la entrega no se encontraba en estado despachado.
     * @throws Exception Si el tiempo que tomó entregar el producto es negativo, se captura la excepción, se cambia el número a positivo, se registra el tiempo de entrega y se lanza nuevamente la excepción con el mensaje correspondiente.
     */
    public void registrarEntregaPedido (int pCodigoPedido, int pTiempoDeEntegaPedido) throws Exception
    {
        Pedido ped = buscarPedido( pCodigoPedido );
        if( ped == null )
        {
            throw new Exception( "No existe un pedido con el código dado." );
        }
        else
        {
            if( !ped.darEstado( ).equals( Pedido.DESPACHADO) )
            {
                throw new Exception ( "No se puede registrar la entrega porque el pedido no se encuentra despachado." );
            }
            try
            {
                ped.registrarTiempoDeEntrega( pTiempoDeEntegaPedido );
            }
            catch ( Exception e)
            {
                if(pTiempoDeEntegaPedido<0)
                {
                    int nuevoTiempoDeEntrega = -pTiempoDeEntegaPedido;
                    ped.registrarTiempoDeDespacho( nuevoTiempoDeEntrega );
                    throw new Exception ( "El tiempo de despacho fue cambiado automáticamente a positivo para ser registrado." );
                }
            }   
        }
    }
    // TODO Implemente el método registrarEntregaPedido de acuerdo al contrato proporcionado.

    /**
     * Retorna los pedidos que ha realizado un cliente con la cédula dada. <br>
     * <b>pre:</b> La lista de pedidos se encuentra inicializada. <br>
     * @param pCedulaCliente Cédula del cliente. pCedulaCliente > 0.
     * @return Lista de los pedidos que ha realizado el cliente.
     */
    public ArrayList filtrarPedidosCliente( int pCedulaCliente )
    {
        ArrayList lista = new ArrayList( );

        for( int i = 0; i < pedidos.size( ); i++ )
        {
            Pedido pedido = ( Pedido )pedidos.get( i );
            if( pedido.darCliente( ).darCedula( ) == pCedulaCliente )
            {
                lista.add( pedido );
            }
        }

        return lista;
    }

    /**
     * Retorna los pedidos que se encuentran en elaboración.
     * <b>pre:</b> La lista de pedidos se encuentra inicializada. <br>
     * @return Lista de pedidos en elaboración.
     */
    public ArrayList filtrarPedidosEnElaboracion( )
    {
        ArrayList lista = new ArrayList( );
        for( int i = 0; i < pedidos.size( ); i++ )
        {
            Pedido pedido = ( Pedido )pedidos.get( i );
            if( pedido.darEstado( ).equals( Pedido.EN_ELABORACION ) )
            {
                lista.add( pedido );
            }
        }
        return lista;
    }

    /**
     * Retorna los pedidos que ya han sido despachados.
     * <b>pre:</b> La lista de pedidos se encuentra inicializada. <br>
     * @return Lista de pedidos despachados.
     */
    public ArrayList filtrarPedidosDespachados( )
    {
        ArrayList lista = new ArrayList( );
        for( int i = 0; i < pedidos.size( ); i++ )
        {
            Pedido pedido = ( Pedido )pedidos.get( i );
            if( pedido.darEstado( ).equals( Pedido.DESPACHADO ) )
            {
                lista.add( pedido );
            }
        }
        return lista;
    }

    /**
     * Retorna los pedidos que ya han sido entregados.
     * <b>pre:</b> La lista de pedidos se encuentra inicializada. <br>
     * @return Lista de pedidos entregados.
     */
    public ArrayList filtrarPedidosEntregados( )
    {
        ArrayList lista = new ArrayList( );
        for( int i = 0; i < pedidos.size( ); i++ )
        {
            Pedido pedido = ( Pedido )pedidos.get( i );
            if( pedido.darEstado( ).equals( Pedido.ENTREGADO ) )
            {
                lista.add( pedido );
            }
        }
        return lista;
    }

    /**
     * Metodo para saber cuatos productos se encuentran en elaboracion. 
     * @return cuatos productos se encuentran en elaboracion.
     */
    public int cuantosProdElaboracion()
    {
        int contador = 0;
        for( int i = 0; i < pedidos.size(); i++ )
            {
                if(pedidos.get( i).darEstado( ).equals( Pedido.EN_ELABORACION ))
                {
                    contador += pedidos.get( i ).darProductosPedidos( ).size( );
                }
            }    
        return contador;
    }
    



    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     * @return respuesta1.
     */
    public String metodo1( )
    {
        return "Respuesta 1.";
    }

    /**
     * Método para la extensión2.
     * @return respuesta2.
     */
    public String metodo2( )
    {
        return "Respuesta 2.";
    }
}