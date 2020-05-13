/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
 * Clase usada para verificar que los m�todos de la clase Inmobiliaria est�n correctamente implementados.
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
    // M�todos
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
     * Inicializa una inmobiliaria con tres mansiones cuyos atributos han sido inicializados con valores espec�ficos.
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
     * Prueba 1 - Inicializaci�n de las mansiones.
     */
    public void testInicializacion( )
    {
        setupEscenario1( );
        assertNotNull( "La mansi�n 1 debe estar inicializada.", inmobiliaria.darMansion1( ) );
        assertNotNull( "La mansi�n 2 debe estar inicializada.", inmobiliaria.darMansion2( ) );
        assertNotNull( "La mansi�n 3 debe estar inicializada.", inmobiliaria.darMansion3( ) );
    }

    /**
     * Prueba 2 - Actualizaci�n datos mansi�n 1.
     */
    public void testActualizarDatosMansion1( )
    {
        setupEscenario1( );
        inmobiliaria.actualizarDatosMansion1( 5, 10, 20, 100000000, 600 );
        assertEquals( "No se actualiz� bien los habitantes de la mansi�n 1.", 5, inmobiliaria.darMansion1( ).darHabitantes( ) );
        assertEquals( "No se actualiz� bien el n�mero de parqueaderos de la mansi�n 1.", 10, inmobiliaria.darMansion1( ).darParqueaderos( ) );
        assertEquals( "No se actualiz� bien el n�mero de empleados de la mansi�n 1.", 20, inmobiliaria.darMansion1( ).darEmpleados( ) );
        assertEquals( "No se actualiz� bien el tama�o de la mansi�n 1.", 600, inmobiliaria.darMansion1( ).darTamanio( ) );
        assertEquals( "No se actualiz� bien el precio de la mansi�n 1.", 100000000, inmobiliaria.darMansion1( ).darPrecio( ) );
    }

    /**
     * Prueba 3 - Actualizaci�n datos mansi�n 2.
     */
    public void testActualizarDatosMansion2( )
    {
        setupEscenario1( );
        inmobiliaria.actualizarDatosMansion2( 10, 15, 30, 50000000, 700 );
        assertEquals( "No se actualiz� bien los habitantes de la mansi�n 2.", 10, inmobiliaria.darMansion2( ).darHabitantes( ) );
        assertEquals( "No se actualiz� bien el n�mero de parqueaderos de la mansi�n 2.", 15, inmobiliaria.darMansion2( ).darParqueaderos( ) );
        assertEquals( "No se actualiz� bien el n�mero de empleados de la mansi�n 2.", 30, inmobiliaria.darMansion2( ).darEmpleados( ) );
        assertEquals( "No se actualiz� bien el tama�o de la mansi�n 2.", 700, inmobiliaria.darMansion2( ).darTamanio( ) );
        assertEquals( "No se actualiz� bien el precio de la mansi�n 2.", 50000000, inmobiliaria.darMansion2( ).darPrecio( ) );
    }

    /**
     * Prueba 4 - Actualizaci�n datos mansi�n 3.
     */
    public void testActualizarDatosMansion3( )
    {
        setupEscenario1( );
        inmobiliaria.actualizarDatosMansion3( 10, 15, 30, 50000000, 700 );
        assertEquals( "No se actualiz� bien los habitantes de la mansi�n 3.", 10, inmobiliaria.darMansion3( ).darHabitantes( ) );
        assertEquals( "No se actualiz� bien el n�mero de parqueaderos de la mansi�n 3.", 15, inmobiliaria.darMansion3( ).darParqueaderos( ) );
        assertEquals( "No se actualiz� bien el n�mero de empleados de la mansi�n 3.", 30, inmobiliaria.darMansion3( ).darEmpleados( ) );
        assertEquals( "No se actualiz� bien el tama�o de la mansi�n 3.", 700, inmobiliaria.darMansion3( ).darTamanio( ) );
        assertEquals( "No se actualiz� bien el precio de la mansi�n 3.", 50000000, inmobiliaria.darMansion3( ).darPrecio( ) );
    }

    /**
     * Prueba 5. C�lculo del costo de administraci�n.
     */
    public void testCalcularCostoAdministracion( )
    {
        setupEscenario2( );
        assertEquals( "El costo de administraci�n de las tres mansiones est� mal calculado.", 463325.00, inmobiliaria.calcularCostoAdministracion( ), 0.01 );
    }

    /**
     * Prueba 6. C�lculo del costo promedio por servicios p�blicos.
     */
    public void testCalcularCostoPromedioServicios( )
    {
        setupEscenario2( );
        assertEquals( "El costo promedio por servicios est� mal calculado.", 156666.66, inmobiliaria.calcularCostoPromedioServicios( ), 0.01 );
    }

}