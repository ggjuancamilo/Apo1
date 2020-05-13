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
package uniandes.cupi2.pizzeria.test;

import uniandes.cupi2.pizzeria.mundo.Producto;
import junit.framework.TestCase;

/**
 * Clase usada para verificar que los métodos de la clase Producto estén correctamente implementados.
 */
public class ProductoTest extends TestCase
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Producto de prueba.
     */
    private Producto producto;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo pedido.
     */
    private void setupEscenario1( )
    {
        try
        {
            producto = new Producto( "Pizza napolitana", 20000.0 );
        }
        catch( Exception e )
        {
            fail("No debería lanzar excepción.");
        }
    }

    /**
     * Prueba 1: Verifica el método constructor.
     */
    public void testCrearProducto( )
    {
        setupEscenario1( );
        assertTrue( "El nombre no coincide.", producto.darNombre( ).equals( "Pizza napolitana" ) );
        assertEquals( "El precio no coincide.", 20000.0, producto.darPrecio( ), 0.01 );
    }
    
    /**
     * Prueba 2: Verifica el método constructor con error.
     */
    public void testCrearProductoError( )
    {
        // Con un número negativo.
        try
        {
            producto= new Producto( "Pizza napolitana", -10000 );
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            assertNull( "No debería haber creado el producto.", producto );
        }
        
        // Con un precio igual a cero.
        try
        {
            producto= new Producto( "Pizza napolitana", 0 );
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            assertNull( "No debería haber creado el producto.", producto );
        }
    }
}
