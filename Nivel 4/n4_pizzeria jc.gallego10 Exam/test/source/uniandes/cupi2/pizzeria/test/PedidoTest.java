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
package uniandes.cupi2.pizzeria.test;

import uniandes.cupi2.pizzeria.mundo.Cliente;
import uniandes.cupi2.pizzeria.mundo.Pedido;
import uniandes.cupi2.pizzeria.mundo.Producto;
import junit.framework.TestCase;

/**
 * Clase usada para verificar que los m�todos de la clase Pedido est�n correctamente implementados.
 */
public class PedidoTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Pedido de prueba.
     */
    private Pedido pedido;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo pedido.
     */
    private void setupEscenario1( )
    {
        Cliente cliente = new Cliente( "German", 1020, 3394949, "Calle 19 # 1 - 2" );
        pedido = new Pedido( 1, cliente );
    }
    
    /**
     * Escenario 2: Construye un nuevo pedido con productos.
     */
    private void setupEscenario2( )
    {
        Cliente cliente = new Cliente( "German", 1020, 3394949, "Calle 19 # 1 - 2" );
        pedido = new Pedido( 1, cliente );
        try
        {
            Producto p1 = new Producto( "Pizza carnes", 10000.0 );
            Producto p2 = new Producto( "Pizza vegetariana", 9000.0 );
            Producto p3 = new Producto( "Pizza queso", 8000.0 );
            pedido.agregarProducto( p1 );
            pedido.agregarProducto( p2 );
            pedido.agregarProducto( p3 );
        }
        catch( Exception e )
        {
            fail("No deber�a lanzar excepci�n.");
        }
    }
    
    /**
     * Escenario 3: Construye un nuevo pedido con productos y estado despachado.
     */
    private void setupEscenario3( )
    {
        setupEscenario2( );
        try
        {
            Producto p1 = new Producto( "Pizza carnes", 10000.0 );
            Producto p2 = new Producto( "Pizza vegetariana", 9000.0 );
            Producto p3 = new Producto( "Pizza queso", 8000.0 );
            pedido.agregarProducto( p1 );
            pedido.agregarProducto( p2 );
            pedido.agregarProducto( p3 );
            
            pedido.registrarTiempoDeDespacho( 20 );
        }
        catch( Exception e )
        {
            fail("No deber�a lanzar excepci�n.");
        }
    }

    /**
     * Prueba 1: Verifica el m�todo constructor.
     */
    public void testProducto( )
    {
        setupEscenario1( );
        assertEquals( "Error al dar el c�digo.", 1, pedido.darCodigo( ) );
        assertNotNull( "El cliente no deber�a se nulo.", pedido.darCliente( ));
        assertNotNull( "La lista de productos deber�a estar inicializada.", pedido.darProductosPedidos( ) );
        assertEquals( "La lista deber�a estar vac�a.", 0 , pedido.darProductosPedidos( ).size( ) );
        assertEquals( "El pedido deber�a estar en elaboraci�n.", Pedido.EN_ELABORACION, pedido.darEstado( ) );
        assertEquals( "Error al inicializar el valor total del pedido.", 0, pedido.darValorTotalPedido( ), 0.01 );
        assertEquals( "Error al inicializar el tiempo de despacho.", 0, pedido.darTiempoDeDespacho( ) );
        assertEquals( "Error al inicializar el tiempo de entrega.", 0, pedido.darTiempoDeEntrega( ) );
    }
    
    
    /**
     * Prueba 2: Verifica el m�todo agregarProducto.
     */
    public void testAgregarProducto( )
    {
        setupEscenario1( );
        try
        {
            Producto p1 = new Producto( "Pizza carnes", 10000.0 );
            pedido.agregarProducto( p1 );
            
            assertEquals( "La lista deber�a tener 1 elemento.", 1 , pedido.darProductosPedidos( ).size( ) );
            assertEquals( "Error al sumar el precio del producto al valor total del pedido.", 10000, pedido.darValorTotalPedido( ), 0.01 );
            
            Producto p2 = new Producto( "Pizza queso", 9000.0 );
            pedido.agregarProducto( p2 );
            
            assertEquals( "La lista deber�a tener 2 elementos.", 2 , pedido.darProductosPedidos( ).size( ) );
            assertEquals( "Error al sumar el precio del producto al valor total del pedido.", 19000, pedido.darValorTotalPedido( ), 0.01 );
            
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
    }
    
    /**
     * Prueba 3: Verifica el m�todo eliminarProducto.
     */
    public void testEliminarProducto( )
    {
        
        // Lanza excepci�n cuando no existe un producto con el nombre a eliminar.
        setupEscenario1( );
        try
        {
            pedido.eliminarProducto( "Pizza carnes" );
            fail( "Deber�a lanzar excepci�n, no existe ning�n producto con ese nombre." );
        }
        catch( Exception e )
        {
            assertEquals( "La lista no deber�a tener elementos.", 0 , pedido.darProductosPedidos( ).size( ) );
        }
        
        // No lanza excepci�n y elimina los productos.
        setupEscenario2( );
        try
        {
            pedido.eliminarProducto( "Pizza carnes" );
            assertEquals( "La lista deber�a tener 2 elementos.", 2 , pedido.darProductosPedidos( ).size( ) );
            assertEquals( "Error al restar el precio del producto al valor total del pedido.", 17000, pedido.darValorTotalPedido( ), 0.01 );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
    }
    
    
    /**
     * Prueba 4: Verifica el m�todo registrarTiempoDeDespacho.
     */
    public void testRegistrarTiempoDeDespacho( )
    {
        setupEscenario2( );
        // Lanza excepci�n con tiempo negativo.
        try
        {
            pedido.registrarTiempoDeDespacho( -2 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch ( Exception e )
        {
            assertEquals( "El pedido deber�a estar en elaboraci�n.", Pedido.EN_ELABORACION, pedido.darEstado( ) );
            assertEquals( "El tiempo de despacho deber�a seguir siendo 0.", 0, pedido.darTiempoDeDespacho( ) );
            assertEquals( "El tiempo de entrega deber�a seguir siendo 0.", 0, pedido.darTiempoDeEntrega( ) );
        }
        
        // No lanza excepci�n cuando registra el tiempo correctamente.
        try
        {
            pedido.registrarTiempoDeDespacho( 20 );
            assertEquals( "El pedido deber�a estar despachado.", Pedido.DESPACHADO, pedido.darEstado( ) );
            assertEquals( "El tiempo de despacho deber�a ser 20.", 20, pedido.darTiempoDeDespacho( ) );
            assertEquals( "El tiempo de entrega deber�a seguir siendo 0.", 0, pedido.darTiempoDeEntrega( ) );
        }
        catch ( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
    }
    
    /**
     * Prueba 5: Verifica el m�todo registrarTiempoDeEntrega.
     */
    public void testRegistrarTiempoDeEntrega( )
    {
        setupEscenario2( );
        // Lanza excepci�n con tiempo negativo.
        try
        {
            pedido.registrarTiempoDeEntrega( -2 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch ( Exception e )
        {
            assertEquals( "El pedido deber�a estar en elaboraci�n.", Pedido.EN_ELABORACION, pedido.darEstado( ) );
            assertEquals( "El tiempo de despacho deber�a seguir siendo 0.", 0, pedido.darTiempoDeDespacho( ) );
            assertEquals( "El tiempo de entrega deber�a seguir siendo 0.", 0, pedido.darTiempoDeEntrega( ) );
        }
        
        // No lanza excepci�n cuando registra el tiempo correctamente.
        try
        {
            pedido.registrarTiempoDeDespacho( 20 );
            assertEquals( "El pedido deber�a estar despachado.", Pedido.DESPACHADO, pedido.darEstado( ) );
            assertEquals( "El tiempo de despacho deber�a ser 20.", 20, pedido.darTiempoDeDespacho( ) );
            assertEquals( "El tiempo de entrega deber�a seguir siendo 0.", 0, pedido.darTiempoDeEntrega( ) );
            pedido.registrarTiempoDeEntrega( 30 );
            assertEquals( "El pedido deber�a estar entregado.", Pedido.ENTREGADO, pedido.darEstado( ) );
            assertEquals( "El tiempo de despacho deber�a ser 20.", 20, pedido.darTiempoDeDespacho( ) );
            assertEquals( "El tiempo de entrega deber�a ser 30.", 30, pedido.darTiempoDeEntrega( ) );
        }
        catch ( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
        // Verifica cuando no es gratis porque hay m�s de 5  productos.
        setupEscenario3( );
        try
        {
            pedido.registrarTiempoDeEntrega( 50 );
            assertEquals( "El valor total no deber�a ser 0.", 54000, pedido.darValorTotalPedido( ), 0.01 );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
        // Verifica cuando no es gratis porque demora m�ximo 60 minutos.
        setupEscenario2( );
        try
        {
            pedido.registrarTiempoDeDespacho( 20 );
            pedido.registrarTiempoDeEntrega( 40 );
            assertEquals( "El valor total no deber�a ser 0.", 27000, pedido.darValorTotalPedido( ), 0.01 );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
        // Verifica cuand es gratis porque se cumplen ambas condiciones.
        setupEscenario2( );
        try
        {
            pedido.registrarTiempoDeDespacho( 20 );
            pedido.registrarTiempoDeEntrega( 41 );
            assertEquals( "El valor total no deber�a ser 0.", 0, pedido.darValorTotalPedido( ), 0.01 );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
    }
   
    /**
     * Prueba 6: Verifica el m�todo tieneProducto.
     */
    public void testTieneProducto( )
    {
        setupEscenario2( );
        // Caso de false.
        assertFalse( "Deber�a ser falso que tiene el producto.", pedido.tieneProducto( "Pizza" ) );
        // Casos de true.
        assertTrue( "Deber�a ser verdadero que tiene el producto.", pedido.tieneProducto( "Pizza carnes" ) );
        assertTrue( "Deber�a ser verdadero que tiene el producto.", pedido.tieneProducto( "Pizza vegetariana" ) );
        assertTrue( "Deber�a ser verdadero que tiene el producto.", pedido.tieneProducto( "Pizza queso" ) );
    }
}
