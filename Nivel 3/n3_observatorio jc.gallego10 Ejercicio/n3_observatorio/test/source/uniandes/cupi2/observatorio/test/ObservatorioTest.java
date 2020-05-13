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
import uniandes.cupi2.observatorio.mundo.SateliteArtificial;
import uniandes.cupi2.observatorio.mundo.SateliteNatural;

/**
 * Clase usada para verificar que los métodos de la clase Observatorio estén correctamente implementados
 */
public class ObservatorioTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Observatorio de prueba.
     */
    private Observatorio observatorio;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo observatorio.
     * 
     */
    private void setupEscenario1( )
    {
        observatorio = new Observatorio( );
    }

    /**
     * Escenario 2: Construye un nuevo observatorio. El planeta Júpiter tiene un satélite con la siguiente información.
     * 
     * satélite natural - nombre: Io, excentricidad: 0.041, inclinación orbital: 0.040
     */
    private void setupEscenario2( )
    {
        observatorio = new Observatorio( );
        observatorio.agregarSateliteNatural( Observatorio.NOMBRE_JUPITER, "Io", 0.041, 0.040 );
    }

    /**
     * Prueba 1: Construye el observatorio.
     * <b> Objetivo: </b> Probar la inicialización del observatorio.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. El observatorio debe tener 8 planetas.
     */
    public void testObservatorio( )
    {
        setupEscenario1( );
        assertTrue( "El observatorio debería tener 8 planetas", observatorio.darNombresPlanetas().length==8 );
    }

    

    /**
     * Prueba 3: Editar un satélite natural de un planeta.<br>
     * <b> Métodos a probar: </b> <br>
     * buscarSateliteNatural<br>
     * editarSateliteNatural<br>
     * <b> Objetivo: </b> Probar la modificación de un satélite natural.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Creación de un nuevo satélite natural con el nombre Io con excentricidad 0.041 e inclinación 0.040<br>
     * 2. Modificar los datos del satélite natural con el nombre Io con excentricidad 0.5 e inclinación 0.05<br>
     * 3. Verificar que los nuevos datos de el satélite natural sean correctos.
     */
    public void testEditarSateliteNatural( )
    {
        setupEscenario2( );
        SateliteNatural io = observatorio.buscarSateliteNatural( Observatorio.NOMBRE_JUPITER, "Io" );
        assertNotNull( "El satélite natural Io debería existir para Júpiter.", io );
        assertEquals( "No creo el satélite natural con la excentricidad correcta", 0.041, io.darExcentricidad( ), 0.001 );
        assertEquals( "No creo el satélite natural con la inclinación correcta", 0.04, io.darInclinacion( ), 0.001 );
        assertEquals( "Se debio modificar el satélite.", observatorio.editarSateliteNatural( Observatorio.NOMBRE_JUPITER, "Io", 0.5, 0.05 ), true);
        assertEquals( "No se debio modificar el satélite.", observatorio.editarSateliteNatural( Observatorio.NOMBRE_JUPITER, "Iosdasd", 0.5, 0.05 ), false);
        io = observatorio.buscarSateliteNatural( Observatorio.NOMBRE_JUPITER, "Io" );
        assertNotNull( "El satélite natural Io debería existir para Júpiter.", io );
        assertEquals( "No creo el satélite natural con la excentricidad correcta", 0.5, io.darExcentricidad( ), 0.001 );
        assertEquals( "No creo el satélite natural con la inclinación correcta", 0.05, io.darInclinacion( ), 0.001 );
    }

    /**
     * Prueba 4: Eliminar un satélite natural de un planeta.<br>
     * <b> Métodos a probar: </b> <br>
     * buscarSateliteNatural<br>
     * eliminarSateliteNatural<br>
     * <b> Objetivo: </b> Probar la eliminación de un satélite natural.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el satélite natural creado. 
     * 2. Eliminar el satélite natural creado. 
     * 3. Eliminar el satélite natural con nombre incorrecto. 
     * 4. Obtener el satélite natural y verificar que no existe.
     */
    public void testEliminarSateliteNatural( )
    {
        setupEscenario2( );
        SateliteNatural io = observatorio.buscarSateliteNatural( Observatorio.NOMBRE_JUPITER, "Io" );
        assertNotNull( "El satélite natural Io debería existir para Júpiter.", io );
        assertEquals( "No se debio eliminar el satélite.",  observatorio.eliminarSateliteNatural( Observatorio.NOMBRE_JUPITER, "assasa" ), false);
        assertEquals( "Se debio eliminar el satélite.",  observatorio.eliminarSateliteNatural( Observatorio.NOMBRE_JUPITER, "Io" ), true);
        io = observatorio.buscarSateliteNatural( Observatorio.NOMBRE_JUPITER, "Io" );
        assertNull( "El satélite natural Io no debería existir para Júpiter.", io );
    }

    /**
     * Prueba 5: Devuelve la lista de los nombres de los planeta registrados.<br>
     * <b> Métodos a probar: </b> <br>
     * darNombresPlanetas<br>
     * <b> Objetivo: </b> Probar el método que devuelve la lista de los nombres de los planeta.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener los nombres de todos los planetas 2. Verificar que los nombres son los mismos de las constantes. 3. Verificar que la cantidad de los nombres sea la misma de
     * los plantas.
     */
    public void testDarNombresPlanetas( )
    {
        setupEscenario1( );
        String[] nombres = observatorio.darNombresPlanetas( );
        int i = 0;
        for( ; i < nombres.length; i++ )
        {
            if( nombres[ i ] != Observatorio.NOMBRE_JUPITER && nombres[ i ] != Observatorio.NOMBRE_MARTE && nombres[ i ] != Observatorio.NOMBRE_MERCURIO && nombres[ i ] != Observatorio.NOMBRE_NEPTUNO && nombres[ i ] != Observatorio.NOMBRE_SATURNO
                    && nombres[ i ] != Observatorio.NOMBRE_TIERRA && nombres[ i ] != Observatorio.NOMBRE_URANO && nombres[ i ] != Observatorio.NOMBRE_VENUS )
                fail( "Uno de los nombres retornados no pertenece a los definidos en las constantes" );
        }
        if( i != Observatorio.CANTIDAD_PLANETAS )
            fail( "La cantidad de planetas retornados no corresponde al tamaño del arreglo de planetas" );

    }

    /**
     * Prueba 6: Devuelve una lista de los planetas que tienen menor distancia orbital que la especificada por parámetro. <br>
     * <b> Métodos a probar: </b> <br>
     * darPlanetasPorDistancia<br>
     * <b> Objetivo: </b> Probar que se obtienen correctamente la cantidad de planetas que cumplen el criterio de distancia.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener ningún planeta cuando se quiere buscar por distancia 0. 2. Obtener 6 planetas cuando se quiere buscar por distancia 5. 3. Obtener 8 planetas cuando se quiere
     * buscar por distancia 20.
     */
    public void testDarPlanetasPorDistancia( )
    {
        setupEscenario1( );
        ArrayList planetas = observatorio.darPlanetasPorDistancia( 0 );
        assertNotNull( "La lista de planetas no puede ser null", planetas );
        assertEquals( "La cantidad de planetas que cumplen el criterio deberían ser 0", 0, planetas.size( ) );
        planetas = observatorio.darPlanetasPorDistancia( 5 );
        assertNotNull( "La lista de planetas no puede ser null", planetas );
        assertEquals( "La cantidad de planetas que cumplen el criterio deberían ser 4", 4, planetas.size( ) );
        planetas = observatorio.darPlanetasPorDistancia( 50 );
        assertEquals( "La cantidad de planetas que cumplen el criterio deberían ser 8", 8, planetas.size( ) );
    }

    /**
     * Prueba 7: Devuelve una lista de los planetas que tienen menor inclinación orbital que la del planeta cuyo nombre es especificado por parámetro.<br>
     * <b> Métodos a probar: </b> <br>
     * darPlanetasPorInclinacion<br>
     * <b> Objetivo: </b> Probar que se obtienen correctamente la cantidad de planetas que cumplen el criterio de inclinación.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener 1 planetas cuando se quiere buscar por inclinación de júpiter. 
     * 2. Obtener 3 planetas cuando se quiere buscar por inclinación de marte. 
     * 3. Obtener 5 planetas cuando se quiere buscar por inclinación de mercurio. 4. Obtener 2 planetas cuando se quiere buscar por inclinación de neptuno. 5. Obtener 4 planetas cuando se quiere
     * buscar por inclinación de saturno. 6. Obtener 6 planetas cuando se quiere buscar por inclinación de tierra. 7. Obtener 0 planetas cuando se quiere buscar por
     * inclinación de urano. 8. Obtener 7 planetas cuando se quiere buscar por inclinación de venus.
     */
    public void testDarPlanetasPorInclinacion( )
    {
        setupEscenario1( );
        ArrayList planetas = observatorio.darPlanetasPorInclinacion( "" );
        assertNotNull( "La lista de planetas no puede ser null", planetas );
        assertEquals( "La cantidad de planetas que cumplen el criterio deberían ser 0", 0, planetas.size( ) );
        planetas = observatorio.darPlanetasPorInclinacion( Observatorio.NOMBRE_JUPITER );
        assertNotNull( "La lista de planetas no puede ser null", planetas );
        assertEquals( "La cantidad de planetas que cumplen el criterio deberían ser 1", 1, planetas.size( ) );
        planetas = observatorio.darPlanetasPorInclinacion( Observatorio.NOMBRE_MARTE );
        assertNotNull( "La lista de planetas no puede ser null", planetas );
        assertEquals( "La cantidad de planetas que cumplen el criterio deberían ser 3", 3, planetas.size( ) );
        planetas = observatorio.darPlanetasPorInclinacion( Observatorio.NOMBRE_MERCURIO );
        assertNotNull( "La lista de planetas no puede ser null", planetas );
        assertEquals( "La cantidad de planetas que cumplen el criterio deberían ser 5", 5, planetas.size( ) );
        planetas = observatorio.darPlanetasPorInclinacion( Observatorio.NOMBRE_NEPTUNO );
        assertNotNull( "La lista de planetas no puede ser null", planetas );
        assertEquals( "La cantidad de planetas que cumplen el criterio deberían ser 2", 2, planetas.size( ) );
        planetas = observatorio.darPlanetasPorInclinacion( Observatorio.NOMBRE_SATURNO );
        assertNotNull( "La lista de planetas no puede ser null", planetas );
        assertEquals( "La cantidad de planetas que cumplen el criterio deberían ser 4", 4, planetas.size( ) );
        planetas = observatorio.darPlanetasPorInclinacion( Observatorio.NOMBRE_TIERRA );
        assertNotNull( "La lista de planetas no puede ser null", planetas );
        assertEquals( "La cantidad de planetas que cumplen el criterio deberían ser 6", 6, planetas.size( ) );
        planetas = observatorio.darPlanetasPorInclinacion( Observatorio.NOMBRE_URANO );
        assertNotNull( "La lista de planetas no puede ser null", planetas );
        assertEquals( "La cantidad de planetas que cumplen el criterio deberían ser 0", 0, planetas.size( ) );
        planetas = observatorio.darPlanetasPorInclinacion( Observatorio.NOMBRE_VENUS );
        assertNotNull( "La lista de planetas no puede ser null", planetas );
        assertEquals( "La cantidad de planetas que cumplen el criterio deberían ser 7", 7, planetas.size( ) );
    }

    /**
     * Prueba 8: Busca un satélite natural para un planeta especificado.<br>
     * <b> Métodos a probar: </b> <br>
     * buscarSateliteNatural<br>
     * <b> Objetivo: </b> Probar que se busca correctamente un satélite natural.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un satélite natural que no existe, retorne null. 
     * 2. Al buscar un satélite natural que existe, retorne uno con el nombre Io con excentricidad 0.041 e
     * inclinación 0.040 y retorne true<br>
     */
    public void testDarSateliteNatural( )
    {
        setupEscenario2( );
        SateliteNatural io = observatorio.buscarSateliteNatural( Observatorio.NOMBRE_JUPITER, "" );
        assertNull( "Al no existir el satélite natural, debería retornar null", io );
        io = observatorio.buscarSateliteNatural( Observatorio.NOMBRE_JUPITER, "Io" );
        assertNotNull( "El satélite natural Io debería existir para Júpiter.", io );
        assertEquals( "No creo el satélite natural con la excentricidad correcta", 0.041, io.darExcentricidad( ), 0.001 );
        assertEquals( "No creo el satélite natural con la inclinación correcta", 0.04, io.darInclinacion( ), 0.001 );
    }

    /**
     * Prueba 9: Devuelve la lista de satélistes naturales que tiene un planeta.<br>
     * <b> Métodos a probar: </b> <br>
     * darSatelitesNaturales<br>
     * <b> Objetivo: </b> Probar que se obtiene correctamente un satélite natural.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un satélite natural que no existe, retorne null. 
     * 2. Al buscar un satélite natural que existe, retorne uno con el nombre Io con excentricidad 0.041 e
     * inclinación 0.040 y retorne true<br>
     */
    public void testDarSatelitesNaturales( )
    {
        setupEscenario2( );
        ArrayList satelites = observatorio.darSatelitesNaturales( Observatorio.NOMBRE_MARTE );
        assertNotNull( "La lista de satélites naturales no debería ser null", satelites );
        assertEquals( "La lista de satélites naturales debería ser vacía", 0, satelites.size( ) );
        satelites = observatorio.darSatelitesNaturales( Observatorio.NOMBRE_JUPITER );
        assertNotNull( "La lista de satélites naturales no debería ser null", satelites );
        assertEquals( "La lista de satélites naturales no debería ser vacía", 1, satelites.size( ) );

    }
    
    /**
     * Prueba 10: Agrega un nuevo satélite artificial a un planeta. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarSateliteArtificial<br>
     * darSateliteArtificial<br>
     * <b> Objetivo: </b> Probar la inserción de un nuevo satélite artificial.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un satélite artificial que no existe, retorne null. 
     * 2. Creación de un nuevo satélite artificial con el nombre Satelite1 con país de origen USA y tipo de servicio MILITAR
     * retorne true<br>
     */
    public void testAgregarSateliteArtificial( )
    {
        setupEscenario1( );
        assertNull( "El satélite artificial Satelite1 no debería existir para Júpiter.", observatorio.darSateliteArtificial(Observatorio.NOMBRE_JUPITER) );
        assertTrue( "El satélite artificial debió haberse agregado", observatorio.agregarSateliteArtificial(Observatorio.NOMBRE_JUPITER, "Satelite1", "USA", SateliteArtificial.TIPO_MILITAR));
        assertFalse( "El satélite artificial no debió haberse agregado", observatorio.agregarSateliteArtificial(Observatorio.NOMBRE_JUPITER, "Satelite1", "USA", SateliteArtificial.TIPO_MILITAR));
        SateliteArtificial satelite = observatorio.darSateliteArtificial(Observatorio.NOMBRE_JUPITER);
        assertNotNull( "El satélite artificial Io debería existir para Júpiter.", satelite );
        assertEquals( "No creo el satélite artificial con el país de origen correcto", "USA", satelite.darPais());
        assertEquals( "No creo el satélite artificial con tipo de servicio correcto", SateliteArtificial.TIPO_MILITAR, satelite.darTipoDeServicio());
    }
    
    /**
     * Prueba 11: Eliminar un satélite artificial de un planeta.<br>
     * <b> Métodos a probar: </b> <br>
     * darSateliteArtificial<br>
     * eliminarSateliteArtificial<br>
     * <b> Objetivo: </b> Probar la eliminación de un satélite artificial.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el satélite artificial creado.
     * 2. Eliminar el satélite artificial creado. 
     * 3. Eliminar el satélite artificial no creado.
     * 4. Obtener el satélite artificial y verificar que no existe.
     */
    public void testEliminarSateliteArtificial( )
    {
        setupEscenario2( );
        observatorio.agregarSateliteArtificial(Observatorio.NOMBRE_JUPITER, "Satelite1", "USA", SateliteArtificial.TIPO_MILITAR);
        SateliteArtificial satelite = observatorio.darSateliteArtificial(Observatorio.NOMBRE_JUPITER);
        assertNotNull( "El satélite artificial debería existir para Júpiter.", satelite );
        assertFalse("No debe elminar el satélite artificial porque se ingreso un nombre incorrecto.",  observatorio.eliminarSateliteArtificial(Observatorio.NOMBRE_JUPITER, "Satelite2"));
        observatorio.eliminarSateliteArtificial(Observatorio.NOMBRE_JUPITER, "Satelite1");
        assertFalse("No debe elminar el satélite artificial porque ya se borro.",  observatorio.eliminarSateliteArtificial(Observatorio.NOMBRE_JUPITER, "Satelite1"));
        satelite = observatorio.darSateliteArtificial(Observatorio.NOMBRE_JUPITER);
        assertNull( "El satélite artificial no debería existir para Júpiter.", satelite );
    }
    
    /**
     * Prueba 12: Devuelve el planeta con más satélites naturales.<br>
     * <b> Métodos a probar: </b> <br>
     * darPlanetaMasSatelites<br>
     * <b> Objetivo: </b> Probar el método que devuelve el planeta con más satélites naturales.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el planeta con más satélites naturales 
     * 2. Verificar que sea el correcto. 
     * 3. Cuando no hay satélites natuales devuelve null.
     * 4. Cuando hay varios planeta con el mismo número de satélites naturales devuelve el primero en la lista.
     */
    public void testDarPlanetaMasSatelites( )
    {
        setupEscenario1( );
        assertNull( "Cuando no hay satélites naturales devuelve null.", observatorio.darPlanetaMasSatelites() );
        observatorio.agregarSateliteNatural( Observatorio.NOMBRE_JUPITER, "Io", 0.041, 0.040 );
        assertEquals("El planeta con más satélites naturales debería ser Jupiter.",Observatorio.NOMBRE_JUPITER,observatorio.darPlanetaMasSatelites().darNombre());
        observatorio.agregarSateliteNatural( Observatorio.NOMBRE_MERCURIO, "Io2", 0.041, 0.040 );
        assertEquals("El planeta con más satélites naturales debería ser Jupiter.",Observatorio.NOMBRE_MERCURIO,observatorio.darPlanetaMasSatelites().darNombre());
    }
    
    /**
     * Prueba 13: Devuelve una lista con los satélites naturales que tienen una excentricidad mayor al valor dado.<br>
     * <b> Métodos a probar: </b> <br>
     * darSatelitesExcentricidadMayor<br>
     * <b> Objetivo: </b> Probar el método que devuelve una lista con los satélites naturales que tienen una excentricidad mayor al valor dado.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Devuelve una lista vacia cuando no hay satélites que cumplan el criterio.
     * 2. Devuelve correctamente el satélite que se agrego para cumplir el criterio
     */
    public void testDarSatelitesExcentricidadMayor( )
    {
        setupEscenario1( );
        assertEquals("La lista debería estar vacia.", 0,observatorio.darSatelitesExcentricidadMayor(5).size());
        observatorio.agregarSateliteNatural( Observatorio.NOMBRE_JUPITER, "Io", 0.041, 0.040 );
        assertEquals("La lista debería estar vacia.", 1,observatorio.darSatelitesExcentricidadMayor(0).size());
        observatorio.agregarSateliteNatural( Observatorio.NOMBRE_JUPITER, "Io2", 1, 0.040 );
        assertEquals("La lista debería estar vacia.", 2,observatorio.darSatelitesExcentricidadMayor(0).size());
        assertEquals("La lista debería estar vacia.", 1,observatorio.darSatelitesExcentricidadMayor(0.5).size());
    }
    
    /**
     * Prueba 14: Devuelve el número de satelites militares que prestan un servicio de tipo militar.<br>
     * <b> Métodos a probar: </b> <br>
     * darNumeroSatelitesMilitares<br>
     * <b> Objetivo: </b> Probar el método que devuelve el número de satelites militares que prestan un servicio de tipo militar.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Devuelve 0 cuando no hay satélites militares o se agrega un satélite de otro tipo.
     * 2. Devuelve correctamente el total de satélites militares.
     */
    public void testDarNumeroSatelitesMilitares( )
    {
        setupEscenario1( );
        assertEquals("Devuelve 0 no hay satélites militares.", 0, observatorio.darNumeroSatelitesMilitares());
        observatorio.agregarSateliteArtificial(Observatorio.NOMBRE_MERCURIO, "Satelite2", "USA", SateliteArtificial.TIPO_COMUNICACION);
        assertEquals("Devuelve 0 hay un satélite de tipo de comunicación.", 0, observatorio.darNumeroSatelitesMilitares());
        observatorio.agregarSateliteArtificial(Observatorio.NOMBRE_JUPITER, "Satelite1", "USA", SateliteArtificial.TIPO_MILITAR);
        assertEquals("Devuelve 1 hay solo un satélite militar.", 1, observatorio.darNumeroSatelitesMilitares());

    }
    
    /**
     * Prueba 15: Devuelve el planeta buscado.<br>
     * <b> Métodos a probar: </b> <br>
     * buscarPlaneta<br>
     * <b> Objetivo: </b> Probar el método busca el planeta a partir del nombre.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Devuelve null cuando el nombre del planeta no existe.
     * 2. Devuelve correctamente el planeta buscado.
     */
    public void testBuscarPlaneta( )
    {
        setupEscenario1( );
        assertNull("No existe el planeta con ese nombre.", observatorio.buscarPlaneta("ELPLANETA"));
        assertNotNull("Debería existir el planeta con ese nombre.", observatorio.buscarPlaneta(Observatorio.NOMBRE_JUPITER));

    }
    
    

}