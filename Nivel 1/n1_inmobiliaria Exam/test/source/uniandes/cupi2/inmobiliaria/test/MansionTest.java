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
import uniandes.cupi2.inmobiliaria.mundo.Mansion;

/**
 * Clase usada para verificar que los métodos de la clase Mansión estén correctamente implementados.
 */
public class MansionTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se harán las pruebas.
     */
    private Mansion mansion;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Construye una nueva Mansión.
     */
    private void setupEscenario1( )
    {
        mansion = new Mansion( );
    }

    /**
     * Prueba 1 - Inicializar los datos de la mansión correctamente.
     */
    public void testInicializar( )
    {
        setupEscenario1( );
        mansion.inicializar( );
        assertTrue( "No se crea con habitantes en 0.", mansion.darHabitantes( ) == 0 );
        assertTrue( "No se crea con número de empleados en 0.", mansion.darEmpleados( ) == 0 );
        assertTrue( "No se crea con número de parqueaderos en 0.", mansion.darParqueaderos( ) == 0 );
        assertTrue( "No se crea con tamaño en 0.", mansion.darTamanio( ) == 0 );
        assertTrue( "No se crea con en precio 0.", mansion.darPrecio( ) == 0 );
    }

    /**
     * Prueba 2 - Modificar los datos de la mansión correctamente.
     */
    public void testModificarDatos( )
    {
        setupEscenario1( );
        mansion.modificarHabitantes( 5 );
        mansion.modificarNumeroParqueaderos( 10 );
        mansion.modificarNumeroEmpleados( 3 );
        mansion.modificarPrecio( 10000000 );
        mansion.modificarTamanio( 600 );

        assertTrue( "El número de habitantes no se actualizó correctamente", mansion.darHabitantes( ) == 5 );
        assertTrue( "El número de parqueaderos no se actualizó correctamente", mansion.darParqueaderos( ) == 10 );
        assertTrue( "El número de empleados no se actualizó correctamente", mansion.darEmpleados( ) == 3 );
        assertTrue( "El precio no se actualizó correctamente", mansion.darPrecio( ) == 10000000 );
        assertTrue( "El tamaño no se actualizó correctamente", mansion.darTamanio( ) == 600 );

    }

    /**
     * Prueba 3 - Calcular los costos de limpieza.
     */
    public void testCalcularCostoLimpieza( )
    {
        setupEscenario1( );
        assertEquals( "El costo de limpieza debe ser cero ", 0, mansion.calcularCostoLimpieza( ) );

        mansion.modificarHabitantes( 5 );
        mansion.modificarNumeroEmpleados( 10 );
        mansion.modificarTamanio( 600 );
        assertEquals( "El costo de limpieza está mal calculado", 331250, mansion.calcularCostoLimpieza( ) );

    }

    /**
     * Prueba 4 - Calcular los gastos en servicios públicos.
     */
    public void testCalcularCostoServicios( )
    {
        setupEscenario1( );
        assertEquals( "Los gastos en servicios deben ser cero ", 0.0, mansion.calcularCostoServicios( ), 0.01 );

        mansion.modificarHabitantes( 10 );
        mansion.modificarPrecio( 500000000 );
        assertEquals( "Los gastos en servicios públicos están mal calculados", 10050000.00, mansion.calcularCostoServicios( ), 0.01 );

    }

    /**
     * Prueba 5 - Calcular los costos de seguridad.
     */
    public void testCalcularCostoSeguridad( )
    {
        setupEscenario1( );
        assertEquals( "El costo de seguridad debe ser cero.", 0, mansion.calcularCostoSeguridad() );

        mansion.modificarNumeroParqueaderos( 10 );
        mansion.modificarTamanio( 1000 );
        assertEquals( "El costo de seguridad está mal calculado.", 504500, mansion.calcularCostoSeguridad( ) );

    }

}