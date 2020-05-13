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

import uniandes.cupi2.pizzeria.mundo.Producto;
import junit.framework.TestCase;

/**
 * Clase usada para verificar que los m�todos de la clase Producto est�n correctamente implementados.
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
    // M�todos
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
            fail("No deber�a lanzar excepci�n.");
        }
    }

    /**
     * Prueba 1: Verifica el m�todo constructor.
     */
    public void testCrearProducto( )
    {
        setupEscenario1( );
        assertTrue( "El nombre no coincide.", producto.darNombre( ).equals( "Pizza napolitana" ) );
        assertEquals( "El precio no coincide.", 20000.0, producto.darPrecio( ), 0.01 );
    }
    
    /**
     * Prueba 2: Verifica el m�todo constructor con error.
     */
    public void testCrearProductoError( )
    {
        // Con un n�mero negativo.
        try
        {
            producto= new Producto( "Pizza napolitana", -10000 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertNull( "No deber�a haber creado el producto.", producto );
        }
        
        // Con un precio igual a cero.
        try
        {
            producto= new Producto( "Pizza napolitana", 0 );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            assertNull( "No deber�a haber creado el producto.", producto );
        }
    }
}
