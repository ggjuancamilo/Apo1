/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_observatorio
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.observatorio.test;

import junit.framework.TestCase;
import uniandes.cupi2.observatorio.mundo.SateliteNatural;

/**
 * Clase usada para verificar que los métodos de la clase SateliteNatural estén correctamente implementados
 */
public class SateliteNaturalTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Satélite natural de prueba
     */
    private SateliteNatural satelite;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo satélite natural.
     * 
     * satélite - nombre: Satelite1, excentricidad: 0.1, inclinación orbital: 0.2.
     */
    private void setupEscenario1( )
    {
        satelite = new SateliteNatural( "Satelite1", 0.1, 0.2 );
    }

    /**
     * Prueba 1: Editar un satélite natural y constructor de la clase.<br>
     * <b> Métodos a probar: </b> <br>
     * editar<br>
     * <b> Objetivo: </b> Probar la modificación de un satélite natural.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Creación de un nuevo satélite natural con el nombre nombre con excentricidad 0.1 e inclinación 0.2.<br>
     * 2. Modificar los datos del satélite natural con el nombre nombre con excentricidad 0.3 e inclinación 0.4.<br>
     * 3. Verificar que los nuevos datos de el satélite natural sean correctos.
     */
    public void testEditar( )
    {
        setupEscenario1( );
        assertEquals( "La excentricidad es incorrecta", 0.1, satelite.darExcentricidad( ), 0.001 );
        assertEquals( "La inclinación es incorrecta", 0.2, satelite.darInclinacion( ), 0.001 );
        satelite.editarSatelite(0.3, 0.4);
        assertEquals( "La excentricidad es incorrecta", 0.3, satelite.darExcentricidad( ), 0.001);
        assertEquals( "La inclinación es incorrecta", 0.4, satelite.darInclinacion( ), 0.001 );
    }

    /**
     * Prueba 2: Obtener la excentricidad del satélite natural.<br>
     * <b> Métodos a probar: </b> <br>
     * darExcentricidad<br>
     * <b> Objetivo: </b> Probar que se creo correctamente el satélite natural.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el valor correcto de la excentricidad.
     */
    public void testDarExcentricidad( )
    {
        setupEscenario1( );
        assertEquals( "La excentricidad es incorrecta", 0.1, satelite.darExcentricidad( ), 0.001 );
    }

    /**
     * Prueba 3: Obtener la inclinación orbital del satélite natural.<br>
     * <b> Métodos a probar: </b> <br>
     * darInclinacion<br>
     * <b> Objetivo: </b> Probar que se creo correctamente el satélite natural.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el valor correcto de la inclinación.
     */
    public void testDarInclinacion( )
    {
        setupEscenario1( );
        assertEquals( "La inclinación es incorrecta", 0.2, satelite.darInclinacion( ), 0.001 );
    }

    /**
     * Prueba 4: Obtener el nombre del satélite natural.<br>
     * <b> Métodos a probar: </b> <br>
     * darrNombre<br>
     * <b> Objetivo: </b> Probar que se creo correctamente el planeta.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el valor correcto del nombre del planeta.
     */
    public void testDarNombre( )
    {
        setupEscenario1( );
        assertEquals( "El nombre es incorrecto", "Satelite1", satelite.darNombre( ) );
    }

}