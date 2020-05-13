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
import uniandes.cupi2.observatorio.mundo.SateliteArtificial;

/**
 * Clase usada para verificar que los métodos de la clase SateliteArtificial estén correctamente implementados
 */
public class SateliteArtificialTest extends TestCase {
	
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Satélite artificial de prueba
     */
    private SateliteArtificial satelite;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo satélite natural.
     * 
     * satélite - nombre: Satelite1, país de origen: Colombia, tipo de servicio: COMUNICACION.
     */
    private void setupEscenario1( )
    {
        satelite = new SateliteArtificial("Satelite1", "Colombia", SateliteArtificial.TIPO_COMUNICACION);
    }
    
    /**
     * Prueba 1: Obtener el nombre del satélite artificial.<br>
     * <b> Métodos a probar: </b> <br>
     * darNombre<br>
     * <b> Objetivo: </b> Probar que se creo correctamente el satélite artificial.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el valor correcto del nombre.
     */
    public void testDarNombre( )
    {
        setupEscenario1( );
        assertEquals( "El nombre es incorrecto", "Satelite1", satelite.darNombre( ) );
    }
    
    /**
     * Prueba 2: Obtener el país de origen del satélite artificial.<br>
     * <b> Métodos a probar: </b> <br>
     * darPais<br>
     * <b> Objetivo: </b> Probar que se creo correctamente el satélite artificial.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el valor correcto del país.
     */
    public void testDarPais( )
    {
        setupEscenario1( );
        assertEquals( "El país es incorrecto", "Colombia", satelite.darPais() );
    }
    
    /**
     * Prueba 3: Obtener el tipo de servicio que ofrece el satélite artificial.<br>
     * <b> Métodos a probar: </b> <br>
     * darTipoDeServicio<br>
     * <b> Objetivo: </b> Probar que se creo correctamente el satélite artificial.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el valor correcto del tipo de servicio.
     */
    public void testDarTipoDeServicio( )
    {
        setupEscenario1( );
        assertEquals( "El país es incorrecto", SateliteArtificial.TIPO_COMUNICACION, satelite.darTipoDeServicio() );
    }
    
}
