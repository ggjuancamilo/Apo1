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
 * Clase que representa un pedido de la pizzería.
 */
public class Pedido
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    
    /**
     * 
     */
    public static final String EN_ELABORACION = "en elaboracion";
    // TODO Declarar y documentar la constante que representa un pedido en elaboración.
    
    /**
     * 
     */
    public static final String DESPACHADO = "Despachado";
    // TODO Declarar y documentar la constante que representa un pedido despachado.
    
    /**
     * 
     */
    public static final String ENTREGADO = "Entregado";
    // TODO Declarar y documentar la constante que representa un pedido entregado.

    
    /**
     * 
     */
    public static final int MAX_PRODUCTOS = 5;
    // TODO Declarar y documentar la constante que representa la cantidad máxima de productos para que el pedido sea gratis si se sobrepasa el tiempo límite.

    /**
     * 
     */
    public static final int TIEMPO_LIMITE = 60;
    // TODO Declarar y documentar la constante que representa el tiempo máximo para que el pedido sea gratis.

    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * 
     */
    private int codigo;
    // TODO Declarar y documentar el atributo que modela el código del pedido.

    /**
     * 
     */
    private Cliente cliente;
    // TODO Declarar y documentar el atributo que modela el cliente del pedido.

    /**
     * 
     */
    private int tiempoDeDespacho;
    // TODO Declarar y documentar el atributo que modela el tiempo de despacho del pedido.
    
    /**
     * 
     */
    private int tiempoDeEntrega;
   
    // TODO Declarar y documentar el atributo que modela el tiempo de entrega del pedido.

    /**
     * 
     */
    private String estado;
    // TODO Declarar y documentar el atributo que modela el estado del pedido.

    private ArrayList <Producto> productos;
    // TODO Declarar y documentar el atributo que modela la lista de productos del pedido.
    
    private double valorTotal;
    // TODO Declarar y documentar el atributo que modela el valor total del pedido.
    
    

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un pedido con los valores pasados por parámetro. <br>
     * <b>post: </b> Crea una nueva lista de productos vacía. <br>
     *               Inicializa el tiempoDeDespacho en 0. <br>
     *               Inicializa el tiempoDeEntrega en 0. <br>
     *               Inicializa el valorTotal en 0.
     *               Inicializa el atributo estado con la constante EN_ELABORACION. <br>
     * @param pCodigo Código que identifica al pedido. pCodigo > 0.
     * @param pCliente Cliente que realizó el pedido. pCliente != null.
     */
    public Pedido( int pCodigo, Cliente pCliente )
    {
        codigo = pCodigo;
        cliente = pCliente; 
        
        productos = new ArrayList<Producto>( );
        // TODO Inicialice los productos como una lista vacía.
        tiempoDeDespacho = 0;
        tiempoDeEntrega = 0;
        valorTotal = 0;
        estado = EN_ELABORACION;
        // TODO Inicialice los atributos de tiempo de despacho, tiempo de entrega, valor total y estado de acuerdo al contrato proporcionado.
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el código del pedido. <br>
     * @return Código del pedido.
     */
    public int darCodigo( )
    {
        return codigo;
    }

    /**
     * Retorna el cliente del pedido.
     * @return Cliente del pedido.
     */
   public Cliente darCliente( )
   {
       return cliente;
   }

    /**
     * Retorna el estado del pedido. <br>
     * @return Estado del pedido
     */
    public String darEstado( )
    {
        return estado;
    }

    /**
     * Retorna el tiempo en el que fue despachado el pedido. <br>
     * @return Tiempo de despacho del pedido.
     */
    public int darTiempoDeDespacho( )
    {
        return tiempoDeDespacho;
    }

    /**
     * Retorna el tiempo en el que fue entregado el pedido. <br>
     * @return Tiempo de entrega del pedido.
     */
    public int darTiempoDeEntrega( )
    {
        return tiempoDeEntrega;
    }
    
    /**
     * Retorna una lista con los productos que conforman el pedido. <br>
     * @return Lista de productos que conforman el pedido.
     */
    public ArrayList <Producto> darProductosPedidos( )
    {
        return productos;
    }

    /**
     * Retorna el valor total del pedido.
     * @return Valor total del pedido.
     */
    public double darValorTotalPedido( )
    {
        return valorTotal;
    }

    /**
     * Agrega un producto a la lista.
     * <b>post: </b> El precio del producto se suma al valor total del pedido.
     *               Se agrega el producto a la lista de productos.
     * @param pProducto Producto que se va a agregar. pProducto != null.
     */
    public void agregarProducto(Producto pProducto) throws Exception
    {
        valorTotal += pProducto.darPrecio( );
        productos.add( pProducto );
      
    }
    // TODO Implementar el método agregarProducto de acuerdo al contrato proporcionado.

    /**
     * Elimina el producto que tiene el nombre dado por parámetro.
     * <b>post: </b> El precio del producto se resta al valor total del pedido.
     *               Se elimina el producto con nombre pNombreProducto de la lista.
     * @param pNombreProducto Nombre del producto. pNombreProducto != null && pNombreProducto != "".
     * @throws Exception Si no encuentra un producto con el nombre dado.
     */
    
    public void eliminarProducto (String pNombreProducto) throws Exception
    {
        

       if(pNombreProducto != null && pNombreProducto != "")
       {
           boolean termino = false;
            for( int i = 0; i < productos.size( ) && !termino; i++ )
            {
              
                if (productos.get( i ).darNombre( ).equals( pNombreProducto ))
                {
                    valorTotal = valorTotal - productos.get( i ).darPrecio( );
                    productos.remove( productos.get( i ) );
                    termino = true;
                }
            }
           if(termino == false)
            {
                throw new Exception( "No esta ingresando un nombre valido" ); 
            }
       }
       else 
       {
           throw new Exception( "No esta ingresando un nombre valido" );
       }

    }
    // TODO Implementar el método eliminarProducto de acuerdo al contrato proporcionado.

    /**
     * Registra el tiempo de despacho.<br>
     * <b>post: </b> Cambia el tiempo de despacho con el valor dado por parámetro. <br>
     *               Cambia el estado a DESPACHADO.
     * @param pTiempoDeDespacho Tiempo en minutos que tomó elaborar el pedido para ser despachado.
     * @throws Exception Si el tiempo de despacho pasado por parámetro es menor a cero.
     */
    public void registrarTiempoDeDespacho (int pTiempoDeDespacho) throws Exception
    {
        if(pTiempoDeDespacho>0)
        {
        tiempoDeDespacho = pTiempoDeDespacho;
        estado = DESPACHADO;
        }
        else 
        {
            throw new Exception("debe ingresar un valor positivo" );
        }
    }
    // TODO Implementar el método registrarTiempoDeDespacho de acuerdo al contrato proporcionado.

    /**
     * Registra el tiempo de entrega.<br>
     * <b>post: </b> Cambia el tiempo de entrega con el valor dado por parámetro. <br>
     *               Cambia el estado a ENTREGADO.
     *               Cambia el valor total del pedido a 0 si la suma del tiempo de despacho y de entrega excede el tiempo límite y la cantidad de productos es inferior al tope máximo   
     * @param pTiempoDeEntrega Tiempo en minutos que tomó entregar el pedido al cliente.
     * @throws Exception Si el tiempo de entrega pasado por parámetro es menor a cero.
     */
    public void registrarTiempoDeEntrega (int pTiempoDeEntrega) throws Exception
    {
        double precio = 0;
        if(pTiempoDeEntrega>0)
        {
            tiempoDeEntrega = pTiempoDeEntrega;
            estado = ENTREGADO;
            
            if(tiempoDeDespacho+tiempoDeEntrega>TIEMPO_LIMITE && productos.size( )<=MAX_PRODUCTOS)
            {
                valorTotal = 0;
            }
            else
            {
               
                for( int i = 0; i < productos.size( ); i++ )
                   {
                       precio += productos.get( i ).darPrecio( );
                   }
            }
            valorTotal = precio;
        }
        else 
            {
                throw new Exception("debe ingresar un valor positivo" );
            }
    }
    
    // TODO Implementar el método registrarTiempoDeEntrega de acuerdo al contrato proporcionado.
    
    
    
    /**
     * busca si un producto existe dado su nombre
     * @param pNombreProducto. 
     * @return True si existe el producto en la lista, False emn caso contrario.
     */
  //TODO: Escribir el contrato del método tieneProducto de acuerdo a la funcionalidad implementada.
    public boolean tieneProducto( String pNombreProducto )
    {
        boolean tiene = false;
        for( int i = 0; i < productos.size( ) && !tiene; i++ )
        {
            Producto pActual = ( Producto ) productos.get( i );
            if( pActual.darNombre( ).equals( pNombreProducto ) )
            {
                tiene = true;
            }
        }
        
        return tiene;
    }
    
    
}
