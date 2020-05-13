/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_inmobiliaria
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.inmobiliaria.test;

import junit.framework.TestCase;
import uniandes.cupi2.inmobiliaria.mundo.Inmobiliaria;

/**
 * Clase usada para verificar que los métodos de la clase Inmobiliaria estén correctamente implementados.
 */
public class InmobiliariaTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Inmobiliaria de prueba.
     */
    private Inmobiliaria inmobiliaria;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa una inmobiliaria con tres mansiones cuyos atributos han sido inicializados en cero.
     */
    private void setupEscenario1( )
    {
        inmobiliaria = new Inmobiliaria( );
        inmobiliaria.inicializar( );
    }

    /**
     * Inicializa una inmobiliaria con tres mansiones cuyos atributos han sido inicializados con valores específicos.
     */
    private void setupEscenario2( )
    {
        inmobiliaria = new Inmobiliaria( );
        inmobiliaria.inicializar( );

        inmobiliaria.actualizarDatosMansion1( 5, 10, 20, 1000000, 500 );
        inmobiliaria.actualizarDatosMansion2( 10, 20, 25, 5000000, 800 );
        inmobiliaria.actualizarDatosMansion3( 15, 30, 30, 10000000, 1000 );

    }

    /**
     * Prueba 1 - Inicialización de las mansiones.
     */
    public void testInicializacion( )
    {
        setupEscenario1( );
        assertNotNull( "La mansión 1 debe estar inicializada.", inmobiliaria.darMansion1( ) );
        assertNotNull( "La mansión 2 debe estar inicializada.", inmobiliaria.darMansion2( ) );
        assertNotNull( "La mansión 3 debe estar inicializada.", inmobiliaria.darMansion3( ) );
    }

    /**
     * Prueba 2 - Actualización datos mansión 1.
     */
    public void testActualizarDatosMansion1( )
    {
        setupEscenario1( );
        inmobiliaria.actualizarDatosMansion1( 5, 10, 20, 100000000, 600 );
        assertEquals( "No se actualizó bien los habitantes de la mansión 1.", 5, inmobiliaria.darMansion1( ).darHabitantes( ) );
        assertEquals( "No se actualizó bien el número de parqueaderos de la mansión 1.", 10, inmobiliaria.darMansion1( ).darParqueaderos( ) );
        assertEquals( "No se actualizó bien el número de empleados de la mansión 1.", 20, inmobiliaria.darMansion1( ).darEmpleados( ) );
        assertEquals( "No se actualizó bien el tamaño de la mansión 1.", 600, inmobiliaria.darMansion1( ).darTamanio( ) );
        assertEquals( "No se actualizó bien el precio de la mansión 1.", 100000000, inmobiliaria.darMansion1( ).darPrecio( ) );
    }

    /**
     * Prueba 3 - Actualización datos mansión 2.
     */
    public void testActualizarDatosMansion2( )
    {
        setupEscenario1( );
        inmobiliaria.actualizarDatosMansion2( 10, 15, 30, 50000000, 700 );
        assertEquals( "No se actualizó bien los habitantes de la mansión 2.", 10, inmobiliaria.darMansion2( ).darHabitantes( ) );
        assertEquals( "No se actualizó bien el número de parqueaderos de la mansión 2.", 15, inmobiliaria.darMansion2( ).darParqueaderos( ) );
        assertEquals( "No se actualizó bien el número de empleados de la mansión 2.", 30, inmobiliaria.darMansion2( ).darEmpleados( ) );
        assertEquals( "No se actualizó bien el tamaño de la mansión 2.", 700, inmobiliaria.darMansion2( ).darTamanio( ) );
        assertEquals( "No se actualizó bien el precio de la mansión 2.", 50000000, inmobiliaria.darMansion2( ).darPrecio( ) );
    }

    /**
     * Prueba 4 - Actualización datos mansión 3.
     */
    public void testActualizarDatosMansion3( )
    {
        setupEscenario1( );
        inmobiliaria.actualizarDatosMansion3( 10, 15, 30, 50000000, 700 );
        assertEquals( "No se actualizó bien los habitantes de la mansión 3.", 10, inmobiliaria.darMansion3( ).darHabitantes( ) );
        assertEquals( "No se actualizó bien el número de parqueaderos de la mansión 3.", 15, inmobiliaria.darMansion3( ).darParqueaderos( ) );
        assertEquals( "No se actualizó bien el número de empleados de la mansión 3.", 30, inmobiliaria.darMansion3( ).darEmpleados( ) );
        assertEquals( "No se actualizó bien el tamaño de la mansión 3.", 700, inmobiliaria.darMansion3( ).darTamanio( ) );
        assertEquals( "No se actualizó bien el precio de la mansión 3.", 50000000, inmobiliaria.darMansion3( ).darPrecio( ) );
    }

    /**
     * Prueba 5. Cálculo del costo de administración.
     */
    public void testCalcularCostoAdministracion( )
    {
        setupEscenario2( );
        assertEquals( "El costo de administración de las tres mansiones está mal calculado.", 463325.00, inmobiliaria.calcularCostoAdministracion( ), 0.01 );
    }

    /**
     * Prueba 6. Cálculo del costo promedio por servicios públicos.
     */
    public void testCalcularCostoPromedioServicios( )
    {
        setupEscenario2( );
        assertEquals( "El costo promedio por servicios está mal calculado.", 156666.66, inmobiliaria.calcularCostoPromedioServicios( ), 0.01 );
    }

}