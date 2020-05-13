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
import uniandes.cupi2.observatorio.mundo.SateliteArtificial;

/**
 * Clase usada para verificar que los m�todos de la clase SateliteArtificial est�n correctamente implementados
 */
public class SateliteArtificialTest extends TestCase {
	
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Sat�lite artificial de prueba
     */
    private SateliteArtificial satelite;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo sat�lite natural.
     * 
     * sat�lite - nombre: Satelite1, pa�s de origen: Colombia, tipo de servicio: COMUNICACION.
     */
    private void setupEscenario1( )
    {
        satelite = new SateliteArtificial("Satelite1", "Colombia", SateliteArtificial.TIPO_COMUNICACION);
    }
    
    /**
     * Prueba 1: Obtener el nombre del sat�lite artificial.<br>
     * <b> M�todos a probar: </b> <br>
     * darNombre<br>
     * <b> Objetivo: </b> Probar que se creo correctamente el sat�lite artificial.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el valor correcto del nombre.
     */
    public void testDarNombre( )
    {
        setupEscenario1( );
        assertEquals( "El nombre es incorrecto", "Satelite1", satelite.darNombre( ) );
    }
    
    /**
     * Prueba 2: Obtener el pa�s de origen del sat�lite artificial.<br>
     * <b> M�todos a probar: </b> <br>
     * darPais<br>
     * <b> Objetivo: </b> Probar que se creo correctamente el sat�lite artificial.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el valor correcto del pa�s.
     */
    public void testDarPais( )
    {
        setupEscenario1( );
        assertEquals( "El pa�s es incorrecto", "Colombia", satelite.darPais() );
    }
    
    /**
     * Prueba 3: Obtener el tipo de servicio que ofrece el sat�lite artificial.<br>
     * <b> M�todos a probar: </b> <br>
     * darTipoDeServicio<br>
     * <b> Objetivo: </b> Probar que se creo correctamente el sat�lite artificial.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el valor correcto del tipo de servicio.
     */
    public void testDarTipoDeServicio( )
    {
        setupEscenario1( );
        assertEquals( "El pa�s es incorrecto", SateliteArtificial.TIPO_COMUNICACION, satelite.darTipoDeServicio() );
    }
    
}
