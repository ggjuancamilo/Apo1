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

import java.util.ArrayList;

import junit.framework.TestCase;
import uniandes.cupi2.observatorio.mundo.Observatorio;
import uniandes.cupi2.observatorio.mundo.Planeta;
import uniandes.cupi2.observatorio.mundo.SateliteArtificial;
import uniandes.cupi2.observatorio.mundo.SateliteNatural;

/**
 * Clase usada para verificar que los métodos de la clase Planeta estén correctamente implementados
 */
public class PlanetaTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Planeta de prueba.
     */
    private Planeta planeta;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo planeta.
     * 
     * planeta - nombre: Mercurio, distancia media al sol: 0.382, excentricidad: 0.205, periodo de órbita: 115.88, velocidad media: 478.725, inclinación: 7.004.  
     */
    private void setupEscenario1( )
    {
        planeta = new Planeta( Observatorio.NOMBRE_MERCURIO, 0.382, 0.205, 115.88, 478.725, 7.004 );
    }

    /**
     * Escenario 2: Construye un nuevo planeta con un satélite natural.
     * 
     * planeta - nombre: Mercurio, distancia media al sol: 0.382, excentricidad: 0.205, periodo de órbita: 115.88, velocidad media: 478.725, inclinación: 7.004.  
     * salélite natural - nombre: Io, excentricidad: 0.041, inclinación orbital: 0.040.
     */
    private void setupEscenario2( )
    {
        planeta = new Planeta( Observatorio.NOMBRE_MERCURIO, 0.382, 0.205, 115.88, 478.725, 7.004 );
        planeta.agregarSateliteNatural( "Io", 0.041, 0.040 );
    }

    /**
     * Prueba 1: Agrega un satélite natural a un planeta.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarSateliteNatural<br>
     * buscarSateliteNatural<br>
     * <b> Objetivo: </b> Probar la inserción de un nuevo satélite natural.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un satélite natural que no existe, retorne null. <br>
     * 2. Creación de un nuevo satélite natural con el nombre Io con excentricidad 0.041 e inclinación 0.040 y retorne true.<br>
     */
    public void testAgregarSateliteNatural( )
    {
        setupEscenario1( );
        assertNull( "No debería existir el satélite natural", planeta.buscarSateliteNatural( "Io" ) );
        planeta.agregarSateliteNatural( "Io", 0.041, 0.040 );
        assertNotNull( "No debería existir el satélite natural", planeta.buscarSateliteNatural( "Io" ) );
        SateliteNatural io = planeta.buscarSateliteNatural( "Io" );
        assertEquals( "No creo el satélite natural con la excentricidad correcta", 0.041, io.darExcentricidad( ), 0.001 );
        assertEquals( "No creo el satélite natural con la inclinación correcta", 0.040, io.darInclinacion( ), 0.001 );
    }

    /**
     * Prueba 2: Editar las propiedades de un satélite natural de un planeta.<br>
     * <b> Métodos a probar: </b> <br>
     * buscarSateliteNatural<br>
     * editarSateliteNatural<br>
     * <b> Objetivo: </b> Probar la modificación de un satélite natural.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Creación de un nuevo satélite natural con el nombre Io con excentricidad 0.041 e inclinación 0.040.<br>
     * 2. Modificar los datos del satélite natural con el nombre Io con excentricidad 0.5 e inclinación 0.05.<br>
     * 3. Verificar que los nuevos datos de el satélite natural sean correctos.
     * 4. Modificar los datos del satélite natural con el nombre Io2 que no existe debe recibir false.
     */
    public void testEditarSateliteNatural( )
    {
        setupEscenario2( );
        SateliteNatural io = planeta.buscarSateliteNatural( "Io" );
        assertNotNull( "El satélite natural Io debería existir para Júpiter.", io );
        assertEquals( "No creo el satélite natural con la excentricidad correcta", 0.041, io.darExcentricidad( ), 0.001 );
        assertEquals( "No creo el satélite natural con la inclinación correcta", 0.040, io.darInclinacion( ), 0.001 );
        planeta.editarSateliteNatural( "Io", 0.5, 0.05 );
        io = planeta.buscarSateliteNatural( "Io" );
        assertNotNull( "El satélite natural Io debería existir para Júpiter.", io );
        assertEquals( "No creo el satélite natural con la excentricidad correcta", 0.5, io.darExcentricidad( ), 0.001 );
        assertEquals( "No creo el satélite natural con la inclinación correcta", 0.05, io.darInclinacion( ), 0.001 );
        assertEquals( "No debe editar la información del satélite natural", false, planeta.editarSateliteNatural( "Io2", 0.5, 0.05 ));
    }

    /**
     * Prueba 3: Eliminar un satélite natural a un planeta.<br>
     * <b> Métodos a probar: </b> <br>
     * buscarSateliteNatural<br>
     * eliminarSatelite<br>
     * <b> Objetivo: </b> Probar la eliminación de un satélite natural.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el satélite natural creado. 
     * 2. Eliminar el satélite natural creado. 
     * 3. Eliminar el satélite natural inexistente.
     * 4. Obtener el satélite natural y verificar que no existe.
     */
    public void testEliminarSateliteNatural( )
    {
        setupEscenario2( );
        SateliteNatural io = planeta.buscarSateliteNatural( "Io" );
        assertNotNull( "El satélite natural Io debería existir para Júpiter.", io );
        planeta.eliminarSateliteNatural( "Io" );
        io = planeta.buscarSateliteNatural( "Io" );
        assertNull( "El satélite natural Io no debería existir para Júpiter.", io );
        assertFalse("No puede eliminar el satélite natural ya que este no existe.", planeta.eliminarSateliteNatural( "Io" ));
    }

    /**
     * Prueba 4: Devuelve la distancia de un planeta.<br>
     * <b> Métodos a probar: </b> <br>
     * darDistancia<br>
     * <b> Objetivo: </b> Probar que se creo correctamente el planeta.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el valor correcto de la distancia media al sol.
     */
    public void testObtenerDistancia( )
    {
        setupEscenario2( );
        assertEquals( "La distancia es incorrecta", 0.382, planeta.darDistancia( ), 0.001 );
    }

    /**
     * Prueba 5: Devuelve la inclinación del planeta.<br>
     * <b> Métodos a probar: </b> <br>
     * darInclinacion<br>
     * <b> Objetivo: </b> Probar que se creo correctamente el planeta.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el valor correcto de la inclinación orbital.
     */
    public void testObtenerInclinacion( )
    {
        setupEscenario2( );
        assertEquals( "La distancia es incorrecta", 7.004, planeta.darInclinacion( ), 0.001 );
    }

    /**
     * Prueba 6: Devuelve el nombre del planeta.<br>
     * <b> Métodos a probar: </b> <br>
     * darNombre<br>
     * <b> Objetivo: </b> Probar que se creo correctamente el planeta.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el valor correcto del nombre del planeta.
     */
    public void testObtenerNombre( )
    {
        setupEscenario1( );
        assertEquals( "El nombre es incorrecto", Observatorio.NOMBRE_MERCURIO, planeta.darNombre( ) );

    }

    /**
     * Prueba 7: Busca un satelite natural de un planeta.<br>
     * <b> Métodos a probar: </b> <br>
     * darSateliteNatural<br>
     * <b> Objetivo: </b> Probar que se agrego correctamente el satélite natural al planeta.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el valor correcto del satélite natural.
     */
    public void testObtenerSateliteNatural( )
    {
        setupEscenario2( );
        SateliteNatural io = planeta.buscarSateliteNatural( "Io" );
        assertNotNull( "El satélite natural Io debería existir para Júpiter.", io );
        assertEquals( "No creo el satélite natural con la excentricidad correcta", 0.041, io.darExcentricidad( ), 0.001 );
        assertEquals( "No creo el satélite natural con la inclinación correcta", 0.04, io.darInclinacion( ), 0.001 );

    }

    /**
     * Prueba 8: Devuelve la lista de satélites naturales de un planeta.<br>
     * <b> Métodos a probar: </b> <br>
     * darSatelitesNaturales<br>
     * <b> Objetivo: </b> Probar que se obtiene correctamente un satélite natural.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un satélite natural que no existe, retorne null. 
     * 2. Al buscar un satélite natural que existe, retorne uno con el nombre Io con excentricidad 0.041 e
     * inclinación 0.040 y retorne true.<br>
     */
    public void testObtenerSatelitesNaturales( )
    {
        setupEscenario1( );
        ArrayList satelites = planeta.darSatelitesNaturales( );
        assertNotNull( "La lista de satélites naturales no debería ser null", satelites );
        assertEquals( "La lista de satélites naturales debería ser vacía", 0, satelites.size( ) );
        setupEscenario2( );
        satelites = planeta.darSatelitesNaturales( );
        assertNotNull( "La lista de satélites naturales no debería ser null", satelites );
        assertEquals( "La lista de satélites naturales no debería ser vacía", 1, satelites.size( ) );
    }
    
    /**
     * Prueba 8: Agrega un satélite artificial a un planeta.<br>
     * <b> Métodos a probar: </b> <br>
     * agregarSateliteArtificial<br>
     * darSateliteArtificial<br>
     * <b> Objetivo: </b> Probar la inserción de un nuevo satélite artificial.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un satélite artificial que no existe, retorne null. <br>
     * 2. Creación de un nuevo satélite artificial con el nombre Satelite1 con país de origen USA y tipo de servicio MILITAR y retorne true.<br>
     */
    public void testAgregarSateliteArtificial( )
    {
        setupEscenario1( );
        assertNull( "No debería existir el satélite artificial", planeta.darSateliteArtificial() );
        planeta.agregarSateliteArtificial("Satelite1", "USA", SateliteArtificial.TIPO_MILITAR);
        assertNotNull( "No debería existir el satélite natural", planeta.darSateliteArtificial() );
        SateliteArtificial satelite = planeta.darSateliteArtificial();
        assertEquals( "No creo el satélite artificial con el país de origen correcto", "USA", satelite.darPais());
        assertEquals( "No creo el satélite artificial con tipo de servicio correcto", SateliteArtificial.TIPO_MILITAR, satelite.darTipoDeServicio());
    }
    
    /**
     * Prueba 9: Eliminar un satélite artificial a un planeta.<br>
     * <b> Métodos a probar: </b> <br>
     * darSateliteArtificial<br>
     * eliminarSateliteArtificial<br>
     * <b> Objetivo: </b> Probar la eliminación de un satélite artificial.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el satélite artificial creado. 
     * 2. Eliminar el satélite artificial creado. 
     * 3. Eliminar el satélite artificial con un nombre incorrecto. 
     * 4. Eliminar el satélite artificial cuando el planeta no tiene uno. 
     * 5. Obtener el satélite artificial y verificar que no existe.
     */
    public void testEliminarSateliteArtificial( )
    {
        setupEscenario2( );
        assertNull( "El satélite artifical no debería existir.", planeta.darSateliteArtificial() );
        planeta.agregarSateliteArtificial("Satelite1", "USA", SateliteArtificial.TIPO_MILITAR);
        assertNotNull( "El satélite artifical no debería existir.", planeta.darSateliteArtificial() );
        assertEquals( "No se debe eliminar el satélite artificial tiene otro nombre.", false, planeta.eliminarSateliteArtificial("jhjjj"));
        assertEquals( "Se debe eliminar el satélite artificial con el país de origen correcto", true, planeta.eliminarSateliteArtificial("Satelite1"));
        assertEquals( "No se debe eliminar el satélite el planeta no tiene satélite artificial.", false, planeta.eliminarSateliteArtificial("Satelite1"));
        assertNull( "El satélite natural Io no debería existir para Júpiter.", planeta.darSateliteArtificial() );
    }

}