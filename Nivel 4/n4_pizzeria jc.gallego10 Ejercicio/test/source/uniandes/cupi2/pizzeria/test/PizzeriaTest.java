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

import java.util.ArrayList;

import junit.framework.TestCase;
import uniandes.cupi2.pizzeria.mundo.Cliente;
import uniandes.cupi2.pizzeria.mundo.Pedido;
import uniandes.cupi2.pizzeria.mundo.Pizzeria;

/**
 * Clase usada para verificar que los m�todos de la clase Pizzer�a est�n correctamente implementados.
 */
public class PizzeriaTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Pizzeria de prueba.
     */
    private Pizzeria pizzeria;


    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye una pizzer�a vac�a.
     */
    private void setupEscenario1( )
    {
        pizzeria = new Pizzeria( );
    }

    /**
     * Escenario 2: Construye una pizzer�a con productos.
     */
    private void setupEscenario2( )
    {
        setupEscenario1( );
        try
        {
            pizzeria.agregarProducto( "Pizza napolitana", 20000 );
            pizzeria.agregarProducto( "Pizza hawaiana", 18000 );
            pizzeria.agregarProducto( "Pizza de carnes", 22000 );
            pizzeria.agregarProducto( "Gaseosa megafamiliar", 5000 );
        }
        catch( Exception e )
        {
            fail("No deber�a lanzar excepci�n.");
        }

    }

    /**
     * Escenario 3: Construye una pizzer�a con productos y pedidos.
     */
    private void setupEscenario3( )
    {
        setupEscenario2( );

        try
        {
            Cliente cliente = new Cliente ( "German", 1020, 3394949, "Calle 19 # 1 - 2" );
            pizzeria.agregarPedido( 1, cliente );
            pizzeria.agregarPedido( 2, cliente );
            pizzeria.registrarDespachoPedido( 2, 10 );
            pizzeria.agregarPedido( 3, cliente );
            pizzeria.agregarProductoAPedido( 3, "Pizza napolitana" );
            pizzeria.registrarDespachoPedido( 3, 10 );
            pizzeria.registrarEntregaPedido( 3, 20 );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }

    }

    /**
     * Prueba 1: Verifica el m�todo constructor.
     */
    public void testCrearPizzeria( )
    {
        setupEscenario1( );

        assertNotNull( "La lista de productos debe estar inicializada.", pizzeria.darProductos( ) );
        assertNotNull( "La lista de pedidos debe estar inicializada.", pizzeria.darPedidos( ) );
        assertEquals( "La lista de productos no deber�a tener elementos.", 0, pizzeria.darProductos( ).size( ) );
        assertEquals( "La lista de pedidos no deber�a tener elementos.", 0, pizzeria.darPedidos( ).size( ) );
    }

    /**
     * Prueba 2: Verifica el m�todo agregarProducto.
     */
    public void testAgregarProducto( )
    {
        setupEscenario1( );
        // Un producto que no existe.
        try
        {
            pizzeria.agregarProducto( "Pizza napolitana", 20000 );
        }
        catch( Exception e )
        {
            fail("No deber�a lanzar excepci�n.");
        }
        // Un producto ya tiene el nombre
        try
        {
            pizzeria.agregarProducto( "Pizza napolitana", 20000 );
            fail("Deber�a lanzar excepci�n.");
        }
        catch( Exception e )
        {
            assertEquals( "La lista de productos deber�a tener 1 elemento.", 1, pizzeria.darProductos( ).size( ) );
        }
    }

    /**
     * Prueba 3: Verifica el m�todo eliminarProducto.
     */
    public void testEliminarProducto( )
    {
        setupEscenario2( );
        // Elimina correctamente.
        try
        {
            pizzeria.eliminarProducto( "Pizza napolitana" );
            assertEquals( "Deber�a haber 3 productos.", 3, pizzeria.darProductos( ).size( ) );
        }
        catch( Exception e )
        {
            fail("No deber�a lanzar excepci�n.");
        }
        // Cuando el producto no existe.
        try
        {
            pizzeria.eliminarProducto( "Pizza" );
            fail("Deber�a lanzar excepci�n.");
        }
        catch( Exception e )
        {
            assertEquals( "Deber�a haber 3 productos.", 3, pizzeria.darProductos( ).size( ) );
        }
        // Cuando el producto est� presente en alg�n pedido.
        setupEscenario3( );
        try
        {
            pizzeria.eliminarProducto( "Pizza napolitana" );
            fail("Deber�a lanzar excepci�n.");
        }
        catch( Exception e )
        {
            assertEquals( "Deber�a haber 4 productos.", 4, pizzeria.darProductos( ).size( ) );
        }
    }

    /**
     * Prueba 4: Verifica el m�todo buscarProducto.
     */
    public void testBuscarProducto( )
    {
        setupEscenario2( );
        assertNotNull( "Deber�a encontrar el producto.", pizzeria.buscarProducto( "Pizza napolitana" ) );
        assertNull( "No deber�a encontrar ning�n producto.", pizzeria.buscarProducto( "Pizza" ) );
    }


    /**
     * Prueba 5: Verifica el m�todo agregarPedido.
     */
    public void testAgregarPedido( )
    {
        setupEscenario2( );
        Cliente cliente = new Cliente ( "German", 1020, 3394949, "Calle 19 # 1 - 2" );
        pizzeria.agregarPedido( 1, cliente );
        assertEquals( "Deber�a existir 1 pedido.", 1, pizzeria.darPedidos( ).size( ) );

    }

    /**
     * Prueba 6: Verifica el m�todo buscarPedido.
     */
    public void testBuscarPedido( )
    {
        setupEscenario3( );
        // Cuando lo encuentra.
        Pedido p = pizzeria.buscarPedido( 1 );
        assertNotNull( "Deber�a haber encontrado el pedido.", p );
        // Cuando no existe.
        Pedido p2 = pizzeria.buscarPedido( 6 );
        assertNull( "Deber�a ser nulo el resultado.", p2 );
    }

    /**
     * Prueba 7: Verifica el m�todo eliminarPedido.
     */
    public void testEliminarPedido( )
    {
        setupEscenario3( );
        // Si no existe el pedido que se quiere eliminar.
        try
        {
            pizzeria.eliminarPedido( 6 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertEquals( "No deber�a haber eliminado ning�n pedido.", 3, pizzeria.darPedidos( ).size( ) );
        }
        // Si el pedido ya ha sido despachado.
        try
        {
            pizzeria.eliminarPedido( 2 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertEquals( "No deber�a haber eliminado ning�n pedido.", 3, pizzeria.darPedidos( ).size( ) );
        }
        // Si el pedido ya ha sido entregado.
        try
        {
            pizzeria.eliminarPedido( 3 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertEquals( "No deber�a haber eliminado ning�n pedido.", 3, pizzeria.darPedidos( ).size( ) );
        }
        // Si elimina correctamente.
        try
        {
            pizzeria.eliminarPedido( 1 );
            assertEquals( "Deber�a haber eliminado un pedido.", 2, pizzeria.darPedidos( ).size( ) );

        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }

    }

    /**
     * Prueba 8: Verifica el m�todo agregarProductoAPedido.
     */
    public void testAgregarProductoAPedido( )
    {
        setupEscenario3( );
        // Agrega correctamente.
        try
        {
            pizzeria.agregarProductoAPedido( 1, "Pizza napolitana" );
            assertEquals("Deber�a haber agregado el producto.", 1, pizzeria.buscarPedido( 1 ).darProductosPedidos( ).size( ));
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }

        // Agrega correctamente.
        try
        {
            pizzeria.agregarProductoAPedido( 2, "Pizza" );
            fail( "Deber�a lanzar excepci�n." );

        }
        catch( Exception e )
        {
            // Deber�a pasar por aqu�.
        }

    }

    /**
     * Prueba 9: Verifica el m�todo eliminarProductoAPedido.
     */
    public void testEliminarProductoAPedido( )
    {
        setupEscenario3( );

        try
        {
            pizzeria.agregarProductoAPedido( 1, "Pizza napolitana" );
        }
        catch( Exception e )
        {
            fail("No deber�a lanzar excepciones.");
        }

        // Elimina correctamente.
        try
        {
            pizzeria.eliminarProductoAPedido( 1, "Pizza napolitana" );
        }
        catch( Exception e )
        {
            fail("No deber�a lanzar excepciones.");
        }

        // Lanza excepci�n al intentar eliminar.
        try
        {
            pizzeria.eliminarProductoAPedido( 1, "Pizza napolitana" );
            fail("Deber�a lanzar excepciones.");
        }
        catch( Exception e )
        {
            // Deber�a pasar por aqu�.
        }
    }

    /**
     * Prueba 10: Verifica el m�todo registrarDespachoPedido.
     */
    public void testRegistrarDespachoPedido( )
    {
        setupEscenario3( );
        // Registra el despacho correctamente.
        try
        {
            pizzeria.registrarDespachoPedido( 1, 10 );
            assertEquals( "El estado deber�a ser despachado.", Pedido.DESPACHADO, pizzeria.buscarPedido( 1 ).darEstado( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
        // Excepci�n si se intenta registrar el despacho de un pedido que no existe.
        try
        {
            pizzeria.registrarDespachoPedido( 4, 10 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            // Deber�a pasar por aqu�.
        }
        // Excepci�n si se intenta registrar el despacho de un pedido que ya estaba despachado.
        try
        {
            pizzeria.registrarDespachoPedido( 2, 10 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            // Deber�a pasar por aqu�.
        }
        // Excepci�n si se intenta registra el despacho de un pedido que ya estaba entregado.
        try
        {
            pizzeria.registrarDespachoPedido( 3, 10 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            // Deber�a pasar por aqu�.
        }
        // Excepci�n si se intenta registrar el despacho con tiempo negativo.
        try
        {
            pizzeria.registrarDespachoPedido( 1, -10 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertEquals( "Deber�a haber dos pedidos despachados.", 2, pizzeria.filtrarPedidosDespachados( ).size( ) );
        }
    }

    /**
     * Prueba 11: Verifica el m�todo registrarEntregaPedido.
     */
    public void testRegistrarEntregaPedido( )
    {
        setupEscenario3( );
        // Registra la entrega correctamente.
        try
        {
            pizzeria.registrarEntregaPedido( 2, 10 );
            assertEquals( "El estado deber�a ser entregado.", Pedido.ENTREGADO, pizzeria.buscarPedido( 2 ).darEstado( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
        // Excepci�n si se intenta registrar la entrega de un pedido que no existe.
        try
        {
            pizzeria.registrarEntregaPedido( 4, 10 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            // Deber�a pasar por aqu�.
        }
        // Excepci�n si se intenta registrar la entrega  de uin pedido que no ha sido despachado.
        try
        {
            pizzeria.registrarEntregaPedido( 1, 10 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            // Deber�a pasar por aqu�.
        }
        // Excepci�n si se intenta registrar la entrega de un pedido que ya estaba entregado.
        try
        {
            pizzeria.registrarDespachoPedido( 3, 10 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            // Deber�a pasar por aqu�.
        }
        // Excepci�n si se intenta registrar la entrega con tiempo negativo.
        try
        {
            pizzeria.registrarDespachoPedido( 2, -10 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertEquals( "Deber�a haber dos pedidos entregados.", 2, pizzeria.filtrarPedidosEntregados( ).size( ) );
        }
    }

    /**
     * Prueba 12: Verifica el m�todo filtrarPedidosCliente.
     */
    public void testFiltrarPedidosCliente( )
    {
        setupEscenario2( );
        assertEquals( "El tama�o de la lista no coincide.", 0, pizzeria.filtrarPedidosCliente( 1020 ).size( ) );
        setupEscenario3( );
        assertEquals( "Deber�a tener 3 pedidos.", 3, pizzeria.filtrarPedidosCliente( 1020 ).size( ) );
    }

    /**
     * Prueba 13: Verifica el m�todo filtrarPedidosEnElaboracion.
     */
    public void testFiltrarPedidosEnElaboracion( )
    {
        setupEscenario2( );
        ArrayList lista = pizzeria.filtrarPedidosEnElaboracion( );
        assertEquals( "El tama�o de la lista no coincide.", 0, lista.size( ) );
        setupEscenario3( );
        lista = pizzeria.filtrarPedidosEnElaboracion( );
        assertEquals( "El tama�o de la lista no coincide.", 1, lista.size( ) );
        Pedido ped = (Pedido) lista.get(0);
        assertEquals( "El pedido no coincide.", 1, ped.darCodigo( ) );

    }

    /**
     * Prueba 14: Verifica el m�todo filtrarPedidosEnElaboracion.
     */
    public void testFiltrarPedidosDespachados( )
    {
        setupEscenario2( );
        ArrayList lista = pizzeria.filtrarPedidosDespachados( );
        assertEquals( "El tama�o de la lista no coincide.", 0, lista.size( ) );
        setupEscenario3( );
        lista = pizzeria.filtrarPedidosDespachados( );
        assertEquals( "El tama�o de la lista no coincide.", 1, lista.size( ) );
        Pedido ped = (Pedido) lista.get(0);
        assertEquals( "El pedido no coincide.", 2, ped.darCodigo( ) );
    }

    /**
     * Prueba 15: Verifica el m�todo filtrarPedidosEntregados.
     */
    public void testFiltrarPedidosEntregados( )
    {
        setupEscenario2( );
        ArrayList lista = pizzeria.filtrarPedidosEntregados( );
        assertEquals( "El tama�o de la lista no coincide.", 0, lista.size( ) );
        setupEscenario3( );
        lista = pizzeria.filtrarPedidosEntregados( );
        assertEquals( "El tama�o de la lista no coincide.", 1, lista.size( ) );
        Pedido ped = (Pedido) lista.get(0);
        assertEquals( "El pedido no coincide.", 3, ped.darCodigo( ) );
    }

    /**
     * Prueba 16: Verifica el m�todo buscarCliente.
     */
    public void testBuscarCliente( )
    { 
        setupEscenario1( );
        pizzeria.agregarCliente( "German", 1020, 3394949, "Calle 19 # 1 - 2" );
        // Cuando lo encuentra.
        assertNotNull( "Deber�a encontrar al cliente.", pizzeria.buscarCliente( 1020 ) ); 
        // Cuando no lo encuentra.
        assertNull( "No deber�a encontrar al cliente.", pizzeria.buscarCliente( 1021 ) ); 
    }
    
    /**
     * Prueba 17: Verifica el m�todo agregarCliente.
     */
    public void testAgregarCliente( )
    {
        setupEscenario1( );
        assertEquals( "No deber�a tener elementos la lista.", 0, pizzeria.darClientes( ).size( ) );
        pizzeria.agregarCliente( "German", 1020, 3394949, "Calle 19 # 1 - 2" );
        assertEquals( "La lista deber�a tener 1 elemento.", 1, pizzeria.darClientes( ).size( ) );
    }
    
}