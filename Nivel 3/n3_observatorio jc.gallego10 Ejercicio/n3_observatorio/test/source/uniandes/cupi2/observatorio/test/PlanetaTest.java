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

import java.util.ArrayList;

import junit.framework.TestCase;
import uniandes.cupi2.observatorio.mundo.Observatorio;
import uniandes.cupi2.observatorio.mundo.Planeta;
import uniandes.cupi2.observatorio.mundo.SateliteArtificial;
import uniandes.cupi2.observatorio.mundo.SateliteNatural;

/**
 * Clase usada para verificar que los m�todos de la clase Planeta est�n correctamente implementados
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
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo planeta.
     * 
     * planeta - nombre: Mercurio, distancia media al sol: 0.382, excentricidad: 0.205, periodo de �rbita: 115.88, velocidad media: 478.725, inclinaci�n: 7.004.  
     */
    private void setupEscenario1( )
    {
        planeta = new Planeta( Observatorio.NOMBRE_MERCURIO, 0.382, 0.205, 115.88, 478.725, 7.004 );
    }

    /**
     * Escenario 2: Construye un nuevo planeta con un sat�lite natural.
     * 
     * planeta - nombre: Mercurio, distancia media al sol: 0.382, excentricidad: 0.205, periodo de �rbita: 115.88, velocidad media: 478.725, inclinaci�n: 7.004.  
     * sal�lite natural - nombre: Io, excentricidad: 0.041, inclinaci�n orbital: 0.040.
     */
    private void setupEscenario2( )
    {
        planeta = new Planeta( Observatorio.NOMBRE_MERCURIO, 0.382, 0.205, 115.88, 478.725, 7.004 );
        planeta.agregarSateliteNatural( "Io", 0.041, 0.040 );
    }

    /**
     * Prueba 1: Agrega un sat�lite natural a un planeta.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarSateliteNatural<br>
     * buscarSateliteNatural<br>
     * <b> Objetivo: </b> Probar la inserci�n de un nuevo sat�lite natural.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un sat�lite natural que no existe, retorne null. <br>
     * 2. Creaci�n de un nuevo sat�lite natural con el nombre Io con excentricidad 0.041 e inclinaci�n 0.040 y retorne true.<br>
     */
    public void testAgregarSateliteNatural( )
    {
        setupEscenario1( );
        assertNull( "No deber�a existir el sat�lite natural", planeta.buscarSateliteNatural( "Io" ) );
        planeta.agregarSateliteNatural( "Io", 0.041, 0.040 );
        assertNotNull( "No deber�a existir el sat�lite natural", planeta.buscarSateliteNatural( "Io" ) );
        SateliteNatural io = planeta.buscarSateliteNatural( "Io" );
        assertEquals( "No creo el sat�lite natural con la excentricidad correcta", 0.041, io.darExcentricidad( ), 0.001 );
        assertEquals( "No creo el sat�lite natural con la inclinaci�n correcta", 0.040, io.darInclinacion( ), 0.001 );
    }

    /**
     * Prueba 2: Editar las propiedades de un sat�lite natural de un planeta.<br>
     * <b> M�todos a probar: </b> <br>
     * buscarSateliteNatural<br>
     * editarSateliteNatural<br>
     * <b> Objetivo: </b> Probar la modificaci�n de un sat�lite natural.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Creaci�n de un nuevo sat�lite natural con el nombre Io con excentricidad 0.041 e inclinaci�n 0.040.<br>
     * 2. Modificar los datos del sat�lite natural con el nombre Io con excentricidad 0.5 e inclinaci�n 0.05.<br>
     * 3. Verificar que los nuevos datos de el sat�lite natural sean correctos.
     * 4. Modificar los datos del sat�lite natural con el nombre Io2 que no existe debe recibir false.
     */
    public void testEditarSateliteNatural( )
    {
        setupEscenario2( );
        SateliteNatural io = planeta.buscarSateliteNatural( "Io" );
        assertNotNull( "El sat�lite natural Io deber�a existir para J�piter.", io );
        assertEquals( "No creo el sat�lite natural con la excentricidad correcta", 0.041, io.darExcentricidad( ), 0.001 );
        assertEquals( "No creo el sat�lite natural con la inclinaci�n correcta", 0.040, io.darInclinacion( ), 0.001 );
        planeta.editarSateliteNatural( "Io", 0.5, 0.05 );
        io = planeta.buscarSateliteNatural( "Io" );
        assertNotNull( "El sat�lite natural Io deber�a existir para J�piter.", io );
        assertEquals( "No creo el sat�lite natural con la excentricidad correcta", 0.5, io.darExcentricidad( ), 0.001 );
        assertEquals( "No creo el sat�lite natural con la inclinaci�n correcta", 0.05, io.darInclinacion( ), 0.001 );
        assertEquals( "No debe editar la informaci�n del sat�lite natural", false, planeta.editarSateliteNatural( "Io2", 0.5, 0.05 ));
    }

    /**
     * Prueba 3: Eliminar un sat�lite natural a un planeta.<br>
     * <b> M�todos a probar: </b> <br>
     * buscarSateliteNatural<br>
     * eliminarSatelite<br>
     * <b> Objetivo: </b> Probar la eliminaci�n de un sat�lite natural.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el sat�lite natural creado. 
     * 2. Eliminar el sat�lite natural creado. 
     * 3. Eliminar el sat�lite natural inexistente.
     * 4. Obtener el sat�lite natural y verificar que no existe.
     */
    public void testEliminarSateliteNatural( )
    {
        setupEscenario2( );
        SateliteNatural io = planeta.buscarSateliteNatural( "Io" );
        assertNotNull( "El sat�lite natural Io deber�a existir para J�piter.", io );
        planeta.eliminarSateliteNatural( "Io" );
        io = planeta.buscarSateliteNatural( "Io" );
        assertNull( "El sat�lite natural Io no deber�a existir para J�piter.", io );
        assertFalse("No puede eliminar el sat�lite natural ya que este no existe.", planeta.eliminarSateliteNatural( "Io" ));
    }

    /**
     * Prueba 4: Devuelve la distancia de un planeta.<br>
     * <b> M�todos a probar: </b> <br>
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
     * Prueba 5: Devuelve la inclinaci�n del planeta.<br>
     * <b> M�todos a probar: </b> <br>
     * darInclinacion<br>
     * <b> Objetivo: </b> Probar que se creo correctamente el planeta.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el valor correcto de la inclinaci�n orbital.
     */
    public void testObtenerInclinacion( )
    {
        setupEscenario2( );
        assertEquals( "La distancia es incorrecta", 7.004, planeta.darInclinacion( ), 0.001 );
    }

    /**
     * Prueba 6: Devuelve el nombre del planeta.<br>
     * <b> M�todos a probar: </b> <br>
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
     * <b> M�todos a probar: </b> <br>
     * darSateliteNatural<br>
     * <b> Objetivo: </b> Probar que se agrego correctamente el sat�lite natural al planeta.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el valor correcto del sat�lite natural.
     */
    public void testObtenerSateliteNatural( )
    {
        setupEscenario2( );
        SateliteNatural io = planeta.buscarSateliteNatural( "Io" );
        assertNotNull( "El sat�lite natural Io deber�a existir para J�piter.", io );
        assertEquals( "No creo el sat�lite natural con la excentricidad correcta", 0.041, io.darExcentricidad( ), 0.001 );
        assertEquals( "No creo el sat�lite natural con la inclinaci�n correcta", 0.04, io.darInclinacion( ), 0.001 );

    }

    /**
     * Prueba 8: Devuelve la lista de sat�lites naturales de un planeta.<br>
     * <b> M�todos a probar: </b> <br>
     * darSatelitesNaturales<br>
     * <b> Objetivo: </b> Probar que se obtiene correctamente un sat�lite natural.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un sat�lite natural que no existe, retorne null. 
     * 2. Al buscar un sat�lite natural que existe, retorne uno con el nombre Io con excentricidad 0.041 e
     * inclinaci�n 0.040 y retorne true.<br>
     */
    public void testObtenerSatelitesNaturales( )
    {
        setupEscenario1( );
        ArrayList satelites = planeta.darSatelitesNaturales( );
        assertNotNull( "La lista de sat�lites naturales no deber�a ser null", satelites );
        assertEquals( "La lista de sat�lites naturales deber�a ser vac�a", 0, satelites.size( ) );
        setupEscenario2( );
        satelites = planeta.darSatelitesNaturales( );
        assertNotNull( "La lista de sat�lites naturales no deber�a ser null", satelites );
        assertEquals( "La lista de sat�lites naturales no deber�a ser vac�a", 1, satelites.size( ) );
    }
    
    /**
     * Prueba 8: Agrega un sat�lite artificial a un planeta.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarSateliteArtificial<br>
     * darSateliteArtificial<br>
     * <b> Objetivo: </b> Probar la inserci�n de un nuevo sat�lite artificial.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un sat�lite artificial que no existe, retorne null. <br>
     * 2. Creaci�n de un nuevo sat�lite artificial con el nombre Satelite1 con pa�s de origen USA y tipo de servicio MILITAR y retorne true.<br>
     */
    public void testAgregarSateliteArtificial( )
    {
        setupEscenario1( );
        assertNull( "No deber�a existir el sat�lite artificial", planeta.darSateliteArtificial() );
        planeta.agregarSateliteArtificial("Satelite1", "USA", SateliteArtificial.TIPO_MILITAR);
        assertNotNull( "No deber�a existir el sat�lite natural", planeta.darSateliteArtificial() );
        SateliteArtificial satelite = planeta.darSateliteArtificial();
        assertEquals( "No creo el sat�lite artificial con el pa�s de origen correcto", "USA", satelite.darPais());
        assertEquals( "No creo el sat�lite artificial con tipo de servicio correcto", SateliteArtificial.TIPO_MILITAR, satelite.darTipoDeServicio());
    }
    
    /**
     * Prueba 9: Eliminar un sat�lite artificial a un planeta.<br>
     * <b> M�todos a probar: </b> <br>
     * darSateliteArtificial<br>
     * eliminarSateliteArtificial<br>
     * <b> Objetivo: </b> Probar la eliminaci�n de un sat�lite artificial.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el sat�lite artificial creado. 
     * 2. Eliminar el sat�lite artificial creado. 
     * 3. Eliminar el sat�lite artificial con un nombre incorrecto. 
     * 4. Eliminar el sat�lite artificial cuando el planeta no tiene uno. 
     * 5. Obtener el sat�lite artificial y verificar que no existe.
     */
    public void testEliminarSateliteArtificial( )
    {
        setupEscenario2( );
        assertNull( "El sat�lite artifical no deber�a existir.", planeta.darSateliteArtificial() );
        planeta.agregarSateliteArtificial("Satelite1", "USA", SateliteArtificial.TIPO_MILITAR);
        assertNotNull( "El sat�lite artifical no deber�a existir.", planeta.darSateliteArtificial() );
        assertEquals( "No se debe eliminar el sat�lite artificial tiene otro nombre.", false, planeta.eliminarSateliteArtificial("jhjjj"));
        assertEquals( "Se debe eliminar el sat�lite artificial con el pa�s de origen correcto", true, planeta.eliminarSateliteArtificial("Satelite1"));
        assertEquals( "No se debe eliminar el sat�lite el planeta no tiene sat�lite artificial.", false, planeta.eliminarSateliteArtificial("Satelite1"));
        assertNull( "El sat�lite natural Io no deber�a existir para J�piter.", planeta.darSateliteArtificial() );
    }

}