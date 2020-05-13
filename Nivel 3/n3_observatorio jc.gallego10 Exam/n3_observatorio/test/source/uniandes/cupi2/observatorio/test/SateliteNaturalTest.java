/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
 * Clase usada para verificar que los m�todos de la clase SateliteNatural est�n correctamente implementados
 */
public class SateliteNaturalTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Sat�lite natural de prueba
     */
    private SateliteNatural satelite;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo sat�lite natural.
     * 
     * sat�lite - nombre: Satelite1, excentricidad: 0.1, inclinaci�n orbital: 0.2.
     */
    private void setupEscenario1( )
    {
        satelite = new SateliteNatural( "Satelite1", 0.1, 0.2 );
    }

    /**
     * Prueba 1: Editar un sat�lite natural y constructor de la clase.<br>
     * <b> M�todos a probar: </b> <br>
     * editar<br>
     * <b> Objetivo: </b> Probar la modificaci�n de un sat�lite natural.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Creaci�n de un nuevo sat�lite natural con el nombre nombre con excentricidad 0.1 e inclinaci�n 0.2.<br>
     * 2. Modificar los datos del sat�lite natural con el nombre nombre con excentricidad 0.3 e inclinaci�n 0.4.<br>
     * 3. Verificar que los nuevos datos de el sat�lite natural sean correctos.
     */
    public void testEditar( )
    {
        setupEscenario1( );
        assertEquals( "La excentricidad es incorrecta", 0.1, satelite.darExcentricidad( ), 0.001 );
        assertEquals( "La inclinaci�n es incorrecta", 0.2, satelite.darInclinacion( ), 0.001 );
        satelite.editarSatelite(0.3, 0.4);
        assertEquals( "La excentricidad es incorrecta", 0.3, satelite.darExcentricidad( ), 0.001);
        assertEquals( "La inclinaci�n es incorrecta", 0.4, satelite.darInclinacion( ), 0.001 );
    }

    /**
     * Prueba 2: Obtener la excentricidad del sat�lite natural.<br>
     * <b> M�todos a probar: </b> <br>
     * darExcentricidad<br>
     * <b> Objetivo: </b> Probar que se creo correctamente el sat�lite natural.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el valor correcto de la excentricidad.
     */
    public void testDarExcentricidad( )
    {
        setupEscenario1( );
        assertEquals( "La excentricidad es incorrecta", 0.1, satelite.darExcentricidad( ), 0.001 );
    }

    /**
     * Prueba 3: Obtener la inclinaci�n orbital del sat�lite natural.<br>
     * <b> M�todos a probar: </b> <br>
     * darInclinacion<br>
     * <b> Objetivo: </b> Probar que se creo correctamente el sat�lite natural.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el valor correcto de la inclinaci�n.
     */
    public void testDarInclinacion( )
    {
        setupEscenario1( );
        assertEquals( "La inclinaci�n es incorrecta", 0.2, satelite.darInclinacion( ), 0.001 );
    }

    /**
     * Prueba 4: Obtener el nombre del sat�lite natural.<br>
     * <b> M�todos a probar: </b> <br>
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