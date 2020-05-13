/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
- * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_barcoPirata 
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.barcoPirata.test;

import junit.framework.TestCase;
import uniandes.cupi2.barcoPirata.mundo.BarcoPirata;
import uniandes.cupi2.barcoPirata.mundo.Contenedor;

/**
 * Clase usada para verificar que los métodos de la clase BarcoPirata estén correctamente implementados.
 */
public class BarcoPirataTest extends TestCase
{

    // ---------------------------------------------------------
    // Atributos
    // ---------------------------------------------------------

    /**
     * El barco de pruebas.
     */
    private BarcoPirata barco;

    // ---------------------------------------------------------
    // Métodos
    // ---------------------------------------------------------

    /**
     * Escenario de un barco con contenedores sin cargar.
     */
    private void setupEscenario1( )
    {
        barco = new BarcoPirata( );
    }

    /**
     * Escenario de un barco con contenedores cargados.
     */
    private void setupEscenario2( )
    {
        barco = new BarcoPirata( );
        barco.cargarContenedor(Contenedor.BARBA_NEGRA, 10, 1000, Contenedor.CARGA_PELIGROSA);
        barco.cargarContenedor(Contenedor.FRANCIS_DRAKE, 1, 1000, Contenedor.CARGA_NO_PERECEDERA);
        barco.cargarContenedor(Contenedor.ANNE_BONNY, 1, 2000, Contenedor.CARGA_PELIGROSA);
        barco.cargarContenedor(Contenedor.DAVY_JONES, 1, 3000, Contenedor.CARGA_NO_PERECEDERA);
    }

    /**
     * Escenario de un barco con un contenedor con carga peligrosa.
     */
    private void setupEscenario3( )
    {
        barco = new BarcoPirata( );
        barco.cargarContenedor(Contenedor.BARBA_NEGRA, 10, 1000, Contenedor.CARGA_PELIGROSA);
    }

    /**
     * Escenario de un barco con un contenedor con carga perecedera.
     */
    private void setupEscenario4( )
    {
        barco = new BarcoPirata( );
        barco.cargarContenedor(Contenedor.DAVY_JONES, 1, 3000, Contenedor.CARGA_PERECEDERA);
    }

    /**
     * Prueba 1 - Verifica el método darContenedor1.
     */
    public void testDarContenedor1( )
    {
        setupEscenario1( );
        
        // 1. Cuando el contenedor está vacío.
        assertEquals( "El primer contenedor debería estar vacío inicialmente.", Contenedor.SIN_CARGA, barco.darContenedor1().darTipoCarga() );
        assertEquals( "El primer contenedor debería estar vacío inicialmente.", 0, barco.darContenedor1().darNumeroCajas() );
        assertEquals( "El primer contenedor debería estar vacío inicialmente.", 0, barco.darContenedor1().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata dueño del primer contenedor no coincide.", Contenedor.BARBA_NEGRA, barco.darContenedor1().darNombrePirata() );
        
        // 2. Al cargar el contenedor.
        barco.cargarContenedor(Contenedor.BARBA_NEGRA, 10, 1000, Contenedor.CARGA_PELIGROSA);
        assertEquals( "El tipo de carga no corresponde.", Contenedor.CARGA_PELIGROSA, barco.darContenedor1().darTipoCarga() );
        assertEquals( "El número de cajas no corresponde.", 10, barco.darContenedor1().darNumeroCajas() );
        assertEquals( "El peso por caja no corresponde.", 1000, barco.darContenedor1().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata dueño del primer contenedor no coincide.", Contenedor.BARBA_NEGRA, barco.darContenedor1().darNombrePirata() );
        
        // 3. Al descargar el barco.
        barco.descargarBarco( );
        assertEquals( "El primer contenedor debería estar vacío después de decargar el barco.", Contenedor.SIN_CARGA, barco.darContenedor1().darTipoCarga() );
        assertEquals( "El primer contenedor debería estar vacío después de decargar el barco.", 0, barco.darContenedor1().darNumeroCajas() );
        assertEquals( "El primer contenedor debería estar vacío después de decargar el barco.", 0, barco.darContenedor1().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata dueño del primer contenedor no coincide.", Contenedor.BARBA_NEGRA, barco.darContenedor1().darNombrePirata() );
    }

    /**
     * Prueba 2 - Verifica el método darContenedor2.
     */
    public void testDarContenedor2( )
    {
    	setupEscenario1( );
        
        // 1. Cuando el contenedor está vacío.
        assertEquals( "El segundo contenedor debería estar vacío inicialmente.", Contenedor.SIN_CARGA, barco.darContenedor2().darTipoCarga() );
        assertEquals( "El segundo contenedor debería estar vacío inicialmente.", 0, barco.darContenedor2().darNumeroCajas() );
        assertEquals( "El segundo contenedor debería estar vacío inicialmente.", 0, barco.darContenedor2().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata dueño del segundo contenedor no coincide.", Contenedor.FRANCIS_DRAKE, barco.darContenedor2().darNombrePirata() );
        
        // 2. Al cargar el contenedor.
        barco.cargarContenedor(Contenedor.FRANCIS_DRAKE, 1, 1000, Contenedor.CARGA_NO_PERECEDERA);
        assertEquals( "El tipo de carga no corresponde.", Contenedor.CARGA_NO_PERECEDERA, barco.darContenedor2().darTipoCarga() );
        assertEquals( "El número de cajas no corresponde.", 1, barco.darContenedor2().darNumeroCajas() );
        assertEquals( "El peso por caja no corresponde.", 1000, barco.darContenedor2().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata dueño del segundo contenedor no coincide.", Contenedor.FRANCIS_DRAKE, barco.darContenedor2().darNombrePirata() );
        
        // 3. Al descargar el barco.
        barco.descargarBarco( );
        assertEquals( "El segundo contenedor debería estar vacío después de decargar el barco.", Contenedor.SIN_CARGA, barco.darContenedor2().darTipoCarga() );
        assertEquals( "El segundo contenedor debería estar vacío después de decargar el barco.", 0, barco.darContenedor2().darNumeroCajas() );
        assertEquals( "El segundo contenedor debería estar vacío después de decargar el barco.", 0, barco.darContenedor2().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata dueño del segundo contenedor no coincide.", Contenedor.FRANCIS_DRAKE, barco.darContenedor2().darNombrePirata() );
    }

    /**
     * Prueba 3 - Verifica el método darContenedor3.
     */
    public void testDarContenedor3( )
    {
        setupEscenario1( ); 
        
        // 1. Cuando el contenedor está vacío.
        assertEquals( "El tercer contenedor debería estar vacío inicialmente.", Contenedor.SIN_CARGA, barco.darContenedor3().darTipoCarga() );
        assertEquals( "El tercer contenedor debería estar vacío inicialmente.", 0, barco.darContenedor3().darNumeroCajas() );
        assertEquals( "El tercer contenedor debería estar vacío inicialmente.", 0, barco.darContenedor3().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata dueño del tercer contenedor no coincide.", Contenedor.ANNE_BONNY, barco.darContenedor3().darNombrePirata() );
        
        // 2. Al cargar el contenedor.
        barco.cargarContenedor(Contenedor.ANNE_BONNY, 1, 2000, Contenedor.CARGA_PELIGROSA);
        assertEquals( "El tipo de carga no corresponde.", Contenedor.CARGA_PELIGROSA, barco.darContenedor3().darTipoCarga() );
        assertEquals( "El número de cajas no corresponde.", 1, barco.darContenedor3().darNumeroCajas() );
        assertEquals( "El peso por caja no corresponde.", 2000, barco.darContenedor3().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata dueño del tercer contenedor no coincide.", Contenedor.ANNE_BONNY, barco.darContenedor3().darNombrePirata() );
        
        // 3. Al descargar el barco.
        barco.descargarBarco( );
        assertEquals( "El tercer contenedor debería estar vacío después de decargar el barco.", Contenedor.SIN_CARGA, barco.darContenedor3().darTipoCarga() );
        assertEquals( "El tercer contenedor debería estar vacío después de decargar el barco.", 0, barco.darContenedor3().darNumeroCajas() );
        assertEquals( "El tercer contenedor debería estar vacío después de decargar el barco.", 0, barco.darContenedor3().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata dueño del tercer contenedor no coincide.", Contenedor.ANNE_BONNY, barco.darContenedor3().darNombrePirata() );
    }

    /**
     * Prueba 4 - Verifica el método darContenedor4.
     */
    public void testDarContenedor4( )
    {
        setupEscenario1( );
        
        // 1. Cuando el contenedor está vacío.
        assertEquals( "El cuarto contenedor debería estar vacío inicialmente.", Contenedor.SIN_CARGA, barco.darContenedor4().darTipoCarga() );
        assertEquals( "El cuarto contenedor debería estar vacío inicialmente.", 0, barco.darContenedor4().darNumeroCajas() );
        assertEquals( "El cuarto contenedor debería estar vacío inicialmente.", 0, barco.darContenedor4().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata dueño del cuarto contenedor no coincide.", Contenedor.DAVY_JONES, barco.darContenedor4().darNombrePirata() );
        
        // 2. Al cargar el contenedor.
        barco.cargarContenedor(Contenedor.DAVY_JONES, 1, 3000, Contenedor.CARGA_NO_PERECEDERA);
        assertEquals( "El tipo de carga no corresponde.", Contenedor.CARGA_NO_PERECEDERA, barco.darContenedor4().darTipoCarga() );
        assertEquals( "El número de cajas no corresponde.", 1, barco.darContenedor4().darNumeroCajas() );
        assertEquals( "El peso por caja no corresponde.", 3000, barco.darContenedor4().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata dueño del cuarto contenedor no coincide.", Contenedor.DAVY_JONES, barco.darContenedor4().darNombrePirata() );
        
        // 3. Al descargar el barco.
        barco.descargarBarco( );
        assertEquals( "El cuarto contenedor debería estar vacío después de decargar el barco.", Contenedor.SIN_CARGA, barco.darContenedor4().darTipoCarga() );
        assertEquals( "El cuarto contenedor debería estar vacío después de decargar el barco.", 0, barco.darContenedor4().darNumeroCajas() );
        assertEquals( "El cuarto contenedor debería estar vacío después de decargar el barco.", 0, barco.darContenedor4().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata dueño del cuarto contenedor no coincide.", Contenedor.DAVY_JONES, barco.darContenedor4().darNombrePirata() );
    }

    /**
	 * Prueba 5 - Verifica el método darPesoTotal.
	 */
	public void testDarPesoTotal( )
	{
		// 1. El barco con los 4 contenedores vacíos.
		setupEscenario1();
		assertEquals("El peso debería ser 0.", 0, barco.darPesoTotal(), 0.01);
		
		// 2. El barco con los 4 contenedores cargados.
		setupEscenario2();
		assertEquals("El peso debería ser 16000.", 16000, barco.darPesoTotal(), 0.01);
	}

    /**
     * Prueba 6 - Verifica el método existeContenedorConCargaPeligrosa.
     */
    public void testExisteContenedorConCargaPeligrosa( )
    {
    	// 1. El barco con los 4 contenedores vacíos.
    	setupEscenario1();
    	assertFalse("No debería ser cierto que existe un contenedor con carga peligrosa.", barco.existeContenedorConCargaPeligrosa());
    	
    	// 2. Cuando hay por lo menos un contenedor cargado pero ninguno tiene carga peligrosa.
    	setupEscenario4();
    	assertFalse("No debería ser cierto que existe un contenedor con carga peligrosa.", barco.existeContenedorConCargaPeligrosa());
    	
    	// 3. Cuando hay un contenedor con carga peligrosa.
    	setupEscenario3();
    	assertTrue("Debería ser cierto que existe un contenedor con carga peligrosa.", barco.existeContenedorConCargaPeligrosa());
    }

    /**
     * Prueba  7 - Verifica el método existeContenedorConCargaPerecedera.
     */
    public void testExisteContenedorConCargaPerecedera( )
    {
    	// 1. El barco con los 4 contenedores vacíos.
    	setupEscenario1();
    	assertFalse("No debería ser cierto que existe un contenedor con carga perecedera.", barco.existeContenedorConCargaPerecedera());
    	
    	// 2. Cuando hay por lo menos un contenedor cargado pero ninguno tiene carga perecedera.
    	setupEscenario3();
    	assertFalse("No debería ser cierto que existe un contenedor con carga perecedera.", barco.existeContenedorConCargaPerecedera());
    	
    	// 3. Cuando hay un contenedor con carga perecedera.
    	setupEscenario4();
    	assertTrue("Debería ser cierto que existe un contenedor con carga perecedera.", barco.existeContenedorConCargaPerecedera());
    }
    
    /**
     * Prueba 8 - Verifica el método sobrepasaPesoLimite.
     */
    public void testSobrepasaPesoLimite( )
    {
        // 1. Con un peso igual no se sobrepasa el peso límite.
    	setupEscenario3();
    	assertFalse("No debería ser cierto que sobrepasa el peso límite.", barco.sobrepasaPesoLimite(10, 1000));
    	
    	// 2. Con un peso menor no se sobrepasa el peso límite.
    	setupEscenario1();
    	assertFalse("No debería ser cierto que sobrepasa el peso límite.", barco.sobrepasaPesoLimite(19, 1000));
    	
    	// 3. Con un peso mayor sobrepasa el peso límite. 
    	setupEscenario4();
    	assertTrue("Debería ser cierto que sobrepasa el peso límite.",barco.sobrepasaPesoLimite(19, 1000));
    }
    
    /**
     * Prueba 9 - Verifica el método cargarContenedor.
     */
    public void testCargarContenedor( )
    {
    	// 1. Verifica que compruebe la condición de peso máximo para cargar.
    	setupEscenario1();
    	assertFalse("No debería poder cargar el contenedor por exceso de peso.", barco.cargarContenedor(Contenedor.BARBA_NEGRA, 21, 1000, Contenedor.CARGA_PELIGROSA));
    	
    	// 2. Verifica que compruebe las condiciónes sanitarias si existe carga peligrosa.
    	setupEscenario3();
    	assertFalse("No debería poder cargar el contenedor porque la carga es tipo PERECEDERA y ya existe una PELIGROSA.", barco.cargarContenedor(Contenedor.FRANCIS_DRAKE, 2, 1000, Contenedor.CARGA_PERECEDERA));
    	
    	// 3. Verifica que compruebe las condiciónes sanitarias si existe carga perecedera.
    	setupEscenario4();
    	assertFalse("No debería poder cargar el contenedor porque la carga es tipo PELIGROSA y ya existe una PERECEDERA.", barco.cargarContenedor(Contenedor.FRANCIS_DRAKE, 2, 1000, Contenedor.CARGA_PELIGROSA));
    	
    	// 4. Verifica que compruebe que el nombre del pirata dueño corresponda a alguna de los contenedores.
    	setupEscenario1();
    	assertFalse("No debería poder cargar ningún contenedor, porque no hay ningún pirata con ese nombre.", barco.cargarContenedor("Morgan", 2, 1000, Contenedor.CARGA_PELIGROSA));
    	
    	// 5. Verifica que permita cargar cualquiera de los cuatro contenedores si cumplen las condiciones.
    	setupEscenario1();barco.cargarContenedor(Contenedor.BARBA_NEGRA, 10, 1000, Contenedor.CARGA_PELIGROSA);
        assertTrue("Debería permitir cargar el contenedor.", barco.cargarContenedor(Contenedor.FRANCIS_DRAKE, 1, 1000, Contenedor.CARGA_NO_PERECEDERA));
        assertTrue("Debería permitir cargar el contenedor.", barco.cargarContenedor(Contenedor.ANNE_BONNY, 1, 2000, Contenedor.CARGA_PELIGROSA));
        assertTrue("Debería permitir cargar el contenedor.", barco.cargarContenedor(Contenedor.DAVY_JONES, 1, 3000, Contenedor.CARGA_NO_PERECEDERA));
    	
    }
    
    /**
     * Prueba 10 - Verifica el método descargarContenedor.
     */
    public void testDescargarContenedor()
    {
    	setupEscenario2();
    	
    	// 1. Al descargar el primer contenedor.
    	barco.descargarContenedor(Contenedor.BARBA_NEGRA);
    	assertEquals( "El primer contenedor debería estar vacío después de decargar el barco.", Contenedor.SIN_CARGA, barco.darContenedor1().darTipoCarga() );
        assertEquals( "El primer contenedor debería estar vacío después de decargar el barco.", 0, barco.darContenedor1().darNumeroCajas() );
        assertEquals( "El primer contenedor debería estar vacío después de decargar el barco.", 0, barco.darContenedor1().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata dueño del primer contenedor no coincide.", Contenedor.BARBA_NEGRA, barco.darContenedor1().darNombrePirata() );
        
        // 2. Al descargar el segundo contenedor.
    	barco.descargarContenedor(Contenedor.FRANCIS_DRAKE);
        assertEquals( "El segundo contenedor debería estar vacío después de decargar el barco.", Contenedor.SIN_CARGA, barco.darContenedor2().darTipoCarga() );
        assertEquals( "El segundo contenedor debería estar vacío después de decargar el barco.", 0, barco.darContenedor2().darNumeroCajas() );
        assertEquals( "El segundo contenedor debería estar vacío después de decargar el barco.", 0, barco.darContenedor2().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata dueño del segundo contenedor no coincide.", Contenedor.FRANCIS_DRAKE, barco.darContenedor2().darNombrePirata() );

        // 3. Al descargar el tercer contenedor.
    	barco.descargarContenedor(Contenedor.ANNE_BONNY);
        assertEquals( "El tercer contenedor debería estar vacío después de decargar el barco.", Contenedor.SIN_CARGA, barco.darContenedor3().darTipoCarga() );
        assertEquals( "El tercer contenedor debería estar vacío después de decargar el barco.", 0, barco.darContenedor3().darNumeroCajas() );
        assertEquals( "El tercer contenedor debería estar vacío después de decargar el barco.", 0, barco.darContenedor3().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata dueño del tercer contenedor no coincide.", Contenedor.ANNE_BONNY, barco.darContenedor3().darNombrePirata() );

        // 4. Al descargar el cuarto contenedor.
    	barco.descargarContenedor(Contenedor.DAVY_JONES);
        assertEquals( "El cuarto contenedor debería estar vacío después de decargar el barco.", Contenedor.SIN_CARGA, barco.darContenedor4().darTipoCarga() );
        assertEquals( "El cuarto contenedor debería estar vacío después de decargar el barco.", 0, barco.darContenedor4().darNumeroCajas() );
        assertEquals( "El cuarto contenedor debería estar vacío después de decargar el barco.", 0, barco.darContenedor4().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata dueño del cuarto contenedor no coincide.", Contenedor.DAVY_JONES, barco.darContenedor4().darNombrePirata() );
  
    }
    
    /**
     * Prueba 11 - Verifica el método descargarBarco.
     */
    public void testDescargarBarco( )
    {
        setupEscenario2( );
        barco.descargarBarco( );
        
        assertEquals( "El primer contenedor debería estar vacío después de decargar el barco.", Contenedor.SIN_CARGA, barco.darContenedor1().darTipoCarga() );
        assertEquals( "El primer contenedor debería estar vacío después de decargar el barco.", 0, barco.darContenedor1().darNumeroCajas() );
        assertEquals( "El primer contenedor debería estar vacío después de decargar el barco.", 0, barco.darContenedor1().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata dueño del primer contenedor no coincide.", Contenedor.BARBA_NEGRA, barco.darContenedor1().darNombrePirata() );
        
        assertEquals( "El segundo contenedor debería estar vacío después de decargar el barco.", Contenedor.SIN_CARGA, barco.darContenedor2().darTipoCarga() );
        assertEquals( "El segundo contenedor debería estar vacío después de decargar el barco.", 0, barco.darContenedor2().darNumeroCajas() );
        assertEquals( "El segundo contenedor debería estar vacío después de decargar el barco.", 0, barco.darContenedor2().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata dueño del segundo contenedor no coincide.", Contenedor.FRANCIS_DRAKE, barco.darContenedor2().darNombrePirata() );
        
        assertEquals( "El tercer contenedor debería estar vacío después de decargar el barco.", Contenedor.SIN_CARGA, barco.darContenedor3().darTipoCarga() );
        assertEquals( "El tercer contenedor debería estar vacío después de decargar el barco.", 0, barco.darContenedor3().darNumeroCajas() );
        assertEquals( "El tercer contenedor debería estar vacío después de decargar el barco.", 0, barco.darContenedor3().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata dueño del tercer contenedor no coincide.", Contenedor.ANNE_BONNY, barco.darContenedor3().darNombrePirata() );
        
        assertEquals( "El cuarto contenedor debería estar vacío después de decargar el barco.", Contenedor.SIN_CARGA, barco.darContenedor4().darTipoCarga() );
        assertEquals( "El cuarto contenedor debería estar vacío después de decargar el barco.", 0, barco.darContenedor4().darNumeroCajas() );
        assertEquals( "El cuarto contenedor debería estar vacío después de decargar el barco.", 0, barco.darContenedor4().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata dueño del cuarto contenedor no coincide.", Contenedor.DAVY_JONES, barco.darContenedor4().darNombrePirata() );
    }
    
    /**
     * Prueba 12 - Verifica el método sobrepasaPesoLimite.
     */
    public void testPuedeZarpar( )
    {
    	// 1. Si no hay contenedores cargados no puede zarpar.
        setupEscenario1( );
        assertFalse("No cumple las condiciones, no puede zarpar.", barco.puedeZarpar());
        
        // 2. Si incumple con la condición del peso mínimo
        setupEscenario3();
        assertFalse("No cumple la condición de peso mínimo, no puede zarpar.", barco.puedeZarpar());
        
        // 3. Si cumple la condición de tener una carga con peso mayor al mínimo.
        setupEscenario1( );
        barco.cargarContenedor(Contenedor.BARBA_NEGRA, 15, 1000, Contenedor.CARGA_PELIGROSA);
        assertTrue("Debería poder zarpar, su carga es mayor al mínimo.", barco.puedeZarpar());
        
        // 4. Si cumple la condición de tener al menos dos contenedores cargados.
        setupEscenario4();
        barco.cargarContenedor(Contenedor.BARBA_NEGRA, 1, 1000, Contenedor.CARGA_PERECEDERA);
        assertTrue("Debería poder zarpar, tiene al menos dos contenedores cargados.", barco.puedeZarpar());
        
        // 5. Si cumple ambas condiciones.
        setupEscenario2();
        assertTrue("Debería poder zarpar, cumple todas las condiciones.", barco.puedeZarpar());
        
    }
    
    /**
     * Prueba 13 - Verifica el método darContenedorMasPesado.
     */
    public void testDarContenedorMasPesado( )
    {
    	// 1. Si el barco está vacío debería retornar null. 
    	setupEscenario1();
    	assertNull("Debería retornar null.", barco.darContenedorMasPesado());
    	
    	// 2. Si hay solo un máximo debe encontrarlo.
    	setupEscenario2();
    	assertNotNull("No debería ser null.", barco.darContenedorMasPesado());
    	assertEquals("El peso del contenedor más pesado no corresponde.", 10000.0, barco.darContenedorMasPesado().darPesoContenedor(), 0.01);
    	assertEquals("El nombre del pirata dueño del contenedor más pesado no corresponde.", Contenedor.BARBA_NEGRA, barco.darContenedorMasPesado().darNombrePirata());
    	
    	// 3. Si hay más de 1 contenedor que es el más pesado.
    	setupEscenario4();
    	barco.cargarContenedor(Contenedor.FRANCIS_DRAKE, 150, 20, Contenedor.CARGA_PERECEDERA);
    	barco.cargarContenedor(Contenedor.ANNE_BONNY, 10, 10, Contenedor.CARGA_PERECEDERA);
    	assertNotNull("No debería ser null.", barco.darContenedorMasPesado());
    	boolean maximo = (barco.darContenedorMasPesado().darNombrePirata().equals(Contenedor.DAVY_JONES)||barco.darContenedorMasPesado().darNombrePirata().equals(Contenedor.FRANCIS_DRAKE));
    	assertEquals("El peso del contenedor más pesado no corresponde.", 3000.0, barco.darContenedorMasPesado().darPesoContenedor(), 0.01);
    	assertTrue("El nombre del pirata dueño del contenedor más pesado no corresponde.", maximo);
    }
    
    /**
     * Prueba 14 - Verifica el método buscarContenedorMasPesado.
     */
    public void testBuscarPirataDuenioContenedorMasPesado( )
    {
        // 1. Si el barco está vacío el mensaje correspondiente.
    	setupEscenario1();
    	assertEquals("El mensaje no corresponde.", "El barco está vacío.", barco.buscarPirataDuenioContenedorMasPesado() );
    	
    	// 2. Si hay un único máximo.
    	setupEscenario2();
    	assertTrue("El mensaje no corresponde.",  barco.buscarPirataDuenioContenedorMasPesado().contains(Contenedor.BARBA_NEGRA) );
    	
    	// 3. Si hay mas de un máximo.
    	setupEscenario4();
        barco.cargarContenedor(Contenedor.FRANCIS_DRAKE, 1, 3000, Contenedor.CARGA_PERECEDERA);
        barco.cargarContenedor(Contenedor.ANNE_BONNY, 1, 1000, Contenedor.CARGA_PERECEDERA);
        barco.cargarContenedor(Contenedor.BARBA_NEGRA, 1, 2000, Contenedor.CARGA_PERECEDERA);
        
        String rta= barco.buscarPirataDuenioContenedorMasPesado();
        assertTrue("Falta el nombre de un pirata.", rta.contains(Contenedor.DAVY_JONES));
        assertTrue("Falta el nombre de un pirata.", rta.contains(Contenedor.FRANCIS_DRAKE));
        assertFalse("Contiene un nombre de un pirata que no es máximo.", rta.contains(Contenedor.ANNE_BONNY));
        assertFalse("Contiene un nombre de un pirata que no es máximo.", rta.contains(Contenedor.BARBA_NEGRA));
        
    }
}
