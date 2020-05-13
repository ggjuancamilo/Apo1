/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
- * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
 * Clase usada para verificar que los m�todos de la clase BarcoPirata est�n correctamente implementados.
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
    // M�todos
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
     * Prueba 1 - Verifica el m�todo darContenedor1.
     */
    public void testDarContenedor1( )
    {
        setupEscenario1( );
        
        // 1. Cuando el contenedor est� vac�o.
        assertEquals( "El primer contenedor deber�a estar vac�o inicialmente.", Contenedor.SIN_CARGA, barco.darContenedor1().darTipoCarga() );
        assertEquals( "El primer contenedor deber�a estar vac�o inicialmente.", 0, barco.darContenedor1().darNumeroCajas() );
        assertEquals( "El primer contenedor deber�a estar vac�o inicialmente.", 0, barco.darContenedor1().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata due�o del primer contenedor no coincide.", Contenedor.BARBA_NEGRA, barco.darContenedor1().darNombrePirata() );
        
        // 2. Al cargar el contenedor.
        barco.cargarContenedor(Contenedor.BARBA_NEGRA, 10, 1000, Contenedor.CARGA_PELIGROSA);
        assertEquals( "El tipo de carga no corresponde.", Contenedor.CARGA_PELIGROSA, barco.darContenedor1().darTipoCarga() );
        assertEquals( "El n�mero de cajas no corresponde.", 10, barco.darContenedor1().darNumeroCajas() );
        assertEquals( "El peso por caja no corresponde.", 1000, barco.darContenedor1().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata due�o del primer contenedor no coincide.", Contenedor.BARBA_NEGRA, barco.darContenedor1().darNombrePirata() );
        
        // 3. Al descargar el barco.
        barco.descargarBarco( );
        assertEquals( "El primer contenedor deber�a estar vac�o despu�s de decargar el barco.", Contenedor.SIN_CARGA, barco.darContenedor1().darTipoCarga() );
        assertEquals( "El primer contenedor deber�a estar vac�o despu�s de decargar el barco.", 0, barco.darContenedor1().darNumeroCajas() );
        assertEquals( "El primer contenedor deber�a estar vac�o despu�s de decargar el barco.", 0, barco.darContenedor1().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata due�o del primer contenedor no coincide.", Contenedor.BARBA_NEGRA, barco.darContenedor1().darNombrePirata() );
    }

    /**
     * Prueba 2 - Verifica el m�todo darContenedor2.
     */
    public void testDarContenedor2( )
    {
    	setupEscenario1( );
        
        // 1. Cuando el contenedor est� vac�o.
        assertEquals( "El segundo contenedor deber�a estar vac�o inicialmente.", Contenedor.SIN_CARGA, barco.darContenedor2().darTipoCarga() );
        assertEquals( "El segundo contenedor deber�a estar vac�o inicialmente.", 0, barco.darContenedor2().darNumeroCajas() );
        assertEquals( "El segundo contenedor deber�a estar vac�o inicialmente.", 0, barco.darContenedor2().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata due�o del segundo contenedor no coincide.", Contenedor.FRANCIS_DRAKE, barco.darContenedor2().darNombrePirata() );
        
        // 2. Al cargar el contenedor.
        barco.cargarContenedor(Contenedor.FRANCIS_DRAKE, 1, 1000, Contenedor.CARGA_NO_PERECEDERA);
        assertEquals( "El tipo de carga no corresponde.", Contenedor.CARGA_NO_PERECEDERA, barco.darContenedor2().darTipoCarga() );
        assertEquals( "El n�mero de cajas no corresponde.", 1, barco.darContenedor2().darNumeroCajas() );
        assertEquals( "El peso por caja no corresponde.", 1000, barco.darContenedor2().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata due�o del segundo contenedor no coincide.", Contenedor.FRANCIS_DRAKE, barco.darContenedor2().darNombrePirata() );
        
        // 3. Al descargar el barco.
        barco.descargarBarco( );
        assertEquals( "El segundo contenedor deber�a estar vac�o despu�s de decargar el barco.", Contenedor.SIN_CARGA, barco.darContenedor2().darTipoCarga() );
        assertEquals( "El segundo contenedor deber�a estar vac�o despu�s de decargar el barco.", 0, barco.darContenedor2().darNumeroCajas() );
        assertEquals( "El segundo contenedor deber�a estar vac�o despu�s de decargar el barco.", 0, barco.darContenedor2().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata due�o del segundo contenedor no coincide.", Contenedor.FRANCIS_DRAKE, barco.darContenedor2().darNombrePirata() );
    }

    /**
     * Prueba 3 - Verifica el m�todo darContenedor3.
     */
    public void testDarContenedor3( )
    {
        setupEscenario1( ); 
        
        // 1. Cuando el contenedor est� vac�o.
        assertEquals( "El tercer contenedor deber�a estar vac�o inicialmente.", Contenedor.SIN_CARGA, barco.darContenedor3().darTipoCarga() );
        assertEquals( "El tercer contenedor deber�a estar vac�o inicialmente.", 0, barco.darContenedor3().darNumeroCajas() );
        assertEquals( "El tercer contenedor deber�a estar vac�o inicialmente.", 0, barco.darContenedor3().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata due�o del tercer contenedor no coincide.", Contenedor.ANNE_BONNY, barco.darContenedor3().darNombrePirata() );
        
        // 2. Al cargar el contenedor.
        barco.cargarContenedor(Contenedor.ANNE_BONNY, 1, 2000, Contenedor.CARGA_PELIGROSA);
        assertEquals( "El tipo de carga no corresponde.", Contenedor.CARGA_PELIGROSA, barco.darContenedor3().darTipoCarga() );
        assertEquals( "El n�mero de cajas no corresponde.", 1, barco.darContenedor3().darNumeroCajas() );
        assertEquals( "El peso por caja no corresponde.", 2000, barco.darContenedor3().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata due�o del tercer contenedor no coincide.", Contenedor.ANNE_BONNY, barco.darContenedor3().darNombrePirata() );
        
        // 3. Al descargar el barco.
        barco.descargarBarco( );
        assertEquals( "El tercer contenedor deber�a estar vac�o despu�s de decargar el barco.", Contenedor.SIN_CARGA, barco.darContenedor3().darTipoCarga() );
        assertEquals( "El tercer contenedor deber�a estar vac�o despu�s de decargar el barco.", 0, barco.darContenedor3().darNumeroCajas() );
        assertEquals( "El tercer contenedor deber�a estar vac�o despu�s de decargar el barco.", 0, barco.darContenedor3().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata due�o del tercer contenedor no coincide.", Contenedor.ANNE_BONNY, barco.darContenedor3().darNombrePirata() );
    }

    /**
     * Prueba 4 - Verifica el m�todo darContenedor4.
     */
    public void testDarContenedor4( )
    {
        setupEscenario1( );
        
        // 1. Cuando el contenedor est� vac�o.
        assertEquals( "El cuarto contenedor deber�a estar vac�o inicialmente.", Contenedor.SIN_CARGA, barco.darContenedor4().darTipoCarga() );
        assertEquals( "El cuarto contenedor deber�a estar vac�o inicialmente.", 0, barco.darContenedor4().darNumeroCajas() );
        assertEquals( "El cuarto contenedor deber�a estar vac�o inicialmente.", 0, barco.darContenedor4().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata due�o del cuarto contenedor no coincide.", Contenedor.DAVY_JONES, barco.darContenedor4().darNombrePirata() );
        
        // 2. Al cargar el contenedor.
        barco.cargarContenedor(Contenedor.DAVY_JONES, 1, 3000, Contenedor.CARGA_NO_PERECEDERA);
        assertEquals( "El tipo de carga no corresponde.", Contenedor.CARGA_NO_PERECEDERA, barco.darContenedor4().darTipoCarga() );
        assertEquals( "El n�mero de cajas no corresponde.", 1, barco.darContenedor4().darNumeroCajas() );
        assertEquals( "El peso por caja no corresponde.", 3000, barco.darContenedor4().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata due�o del cuarto contenedor no coincide.", Contenedor.DAVY_JONES, barco.darContenedor4().darNombrePirata() );
        
        // 3. Al descargar el barco.
        barco.descargarBarco( );
        assertEquals( "El cuarto contenedor deber�a estar vac�o despu�s de decargar el barco.", Contenedor.SIN_CARGA, barco.darContenedor4().darTipoCarga() );
        assertEquals( "El cuarto contenedor deber�a estar vac�o despu�s de decargar el barco.", 0, barco.darContenedor4().darNumeroCajas() );
        assertEquals( "El cuarto contenedor deber�a estar vac�o despu�s de decargar el barco.", 0, barco.darContenedor4().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata due�o del cuarto contenedor no coincide.", Contenedor.DAVY_JONES, barco.darContenedor4().darNombrePirata() );
    }

    /**
	 * Prueba 5 - Verifica el m�todo darPesoTotal.
	 */
	public void testDarPesoTotal( )
	{
		// 1. El barco con los 4 contenedores vac�os.
		setupEscenario1();
		assertEquals("El peso deber�a ser 0.", 0, barco.darPesoTotal(), 0.01);
		
		// 2. El barco con los 4 contenedores cargados.
		setupEscenario2();
		assertEquals("El peso deber�a ser 16000.", 16000, barco.darPesoTotal(), 0.01);
	}

    /**
     * Prueba 6 - Verifica el m�todo existeContenedorConCargaPeligrosa.
     */
    public void testExisteContenedorConCargaPeligrosa( )
    {
    	// 1. El barco con los 4 contenedores vac�os.
    	setupEscenario1();
    	assertFalse("No deber�a ser cierto que existe un contenedor con carga peligrosa.", barco.existeContenedorConCargaPeligrosa());
    	
    	// 2. Cuando hay por lo menos un contenedor cargado pero ninguno tiene carga peligrosa.
    	setupEscenario4();
    	assertFalse("No deber�a ser cierto que existe un contenedor con carga peligrosa.", barco.existeContenedorConCargaPeligrosa());
    	
    	// 3. Cuando hay un contenedor con carga peligrosa.
    	setupEscenario3();
    	assertTrue("Deber�a ser cierto que existe un contenedor con carga peligrosa.", barco.existeContenedorConCargaPeligrosa());
    }

    /**
     * Prueba  7 - Verifica el m�todo existeContenedorConCargaPerecedera.
     */
    public void testExisteContenedorConCargaPerecedera( )
    {
    	// 1. El barco con los 4 contenedores vac�os.
    	setupEscenario1();
    	assertFalse("No deber�a ser cierto que existe un contenedor con carga perecedera.", barco.existeContenedorConCargaPerecedera());
    	
    	// 2. Cuando hay por lo menos un contenedor cargado pero ninguno tiene carga perecedera.
    	setupEscenario3();
    	assertFalse("No deber�a ser cierto que existe un contenedor con carga perecedera.", barco.existeContenedorConCargaPerecedera());
    	
    	// 3. Cuando hay un contenedor con carga perecedera.
    	setupEscenario4();
    	assertTrue("Deber�a ser cierto que existe un contenedor con carga perecedera.", barco.existeContenedorConCargaPerecedera());
    }
    
    /**
     * Prueba 8 - Verifica el m�todo sobrepasaPesoLimite.
     */
    public void testSobrepasaPesoLimite( )
    {
        // 1. Con un peso igual no se sobrepasa el peso l�mite.
    	setupEscenario3();
    	assertFalse("No deber�a ser cierto que sobrepasa el peso l�mite.", barco.sobrepasaPesoLimite(10, 1000));
    	
    	// 2. Con un peso menor no se sobrepasa el peso l�mite.
    	setupEscenario1();
    	assertFalse("No deber�a ser cierto que sobrepasa el peso l�mite.", barco.sobrepasaPesoLimite(19, 1000));
    	
    	// 3. Con un peso mayor sobrepasa el peso l�mite. 
    	setupEscenario4();
    	assertTrue("Deber�a ser cierto que sobrepasa el peso l�mite.",barco.sobrepasaPesoLimite(19, 1000));
    }
    
    /**
     * Prueba 9 - Verifica el m�todo cargarContenedor.
     */
    public void testCargarContenedor( )
    {
    	// 1. Verifica que compruebe la condici�n de peso m�ximo para cargar.
    	setupEscenario1();
    	assertFalse("No deber�a poder cargar el contenedor por exceso de peso.", barco.cargarContenedor(Contenedor.BARBA_NEGRA, 21, 1000, Contenedor.CARGA_PELIGROSA));
    	
    	// 2. Verifica que compruebe las condici�nes sanitarias si existe carga peligrosa.
    	setupEscenario3();
    	assertFalse("No deber�a poder cargar el contenedor porque la carga es tipo PERECEDERA y ya existe una PELIGROSA.", barco.cargarContenedor(Contenedor.FRANCIS_DRAKE, 2, 1000, Contenedor.CARGA_PERECEDERA));
    	
    	// 3. Verifica que compruebe las condici�nes sanitarias si existe carga perecedera.
    	setupEscenario4();
    	assertFalse("No deber�a poder cargar el contenedor porque la carga es tipo PELIGROSA y ya existe una PERECEDERA.", barco.cargarContenedor(Contenedor.FRANCIS_DRAKE, 2, 1000, Contenedor.CARGA_PELIGROSA));
    	
    	// 4. Verifica que compruebe que el nombre del pirata due�o corresponda a alguna de los contenedores.
    	setupEscenario1();
    	assertFalse("No deber�a poder cargar ning�n contenedor, porque no hay ning�n pirata con ese nombre.", barco.cargarContenedor("Morgan", 2, 1000, Contenedor.CARGA_PELIGROSA));
    	
    	// 5. Verifica que permita cargar cualquiera de los cuatro contenedores si cumplen las condiciones.
    	setupEscenario1();barco.cargarContenedor(Contenedor.BARBA_NEGRA, 10, 1000, Contenedor.CARGA_PELIGROSA);
        assertTrue("Deber�a permitir cargar el contenedor.", barco.cargarContenedor(Contenedor.FRANCIS_DRAKE, 1, 1000, Contenedor.CARGA_NO_PERECEDERA));
        assertTrue("Deber�a permitir cargar el contenedor.", barco.cargarContenedor(Contenedor.ANNE_BONNY, 1, 2000, Contenedor.CARGA_PELIGROSA));
        assertTrue("Deber�a permitir cargar el contenedor.", barco.cargarContenedor(Contenedor.DAVY_JONES, 1, 3000, Contenedor.CARGA_NO_PERECEDERA));
    	
    }
    
    /**
     * Prueba 10 - Verifica el m�todo descargarContenedor.
     */
    public void testDescargarContenedor()
    {
    	setupEscenario2();
    	
    	// 1. Al descargar el primer contenedor.
    	barco.descargarContenedor(Contenedor.BARBA_NEGRA);
    	assertEquals( "El primer contenedor deber�a estar vac�o despu�s de decargar el barco.", Contenedor.SIN_CARGA, barco.darContenedor1().darTipoCarga() );
        assertEquals( "El primer contenedor deber�a estar vac�o despu�s de decargar el barco.", 0, barco.darContenedor1().darNumeroCajas() );
        assertEquals( "El primer contenedor deber�a estar vac�o despu�s de decargar el barco.", 0, barco.darContenedor1().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata due�o del primer contenedor no coincide.", Contenedor.BARBA_NEGRA, barco.darContenedor1().darNombrePirata() );
        
        // 2. Al descargar el segundo contenedor.
    	barco.descargarContenedor(Contenedor.FRANCIS_DRAKE);
        assertEquals( "El segundo contenedor deber�a estar vac�o despu�s de decargar el barco.", Contenedor.SIN_CARGA, barco.darContenedor2().darTipoCarga() );
        assertEquals( "El segundo contenedor deber�a estar vac�o despu�s de decargar el barco.", 0, barco.darContenedor2().darNumeroCajas() );
        assertEquals( "El segundo contenedor deber�a estar vac�o despu�s de decargar el barco.", 0, barco.darContenedor2().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata due�o del segundo contenedor no coincide.", Contenedor.FRANCIS_DRAKE, barco.darContenedor2().darNombrePirata() );

        // 3. Al descargar el tercer contenedor.
    	barco.descargarContenedor(Contenedor.ANNE_BONNY);
        assertEquals( "El tercer contenedor deber�a estar vac�o despu�s de decargar el barco.", Contenedor.SIN_CARGA, barco.darContenedor3().darTipoCarga() );
        assertEquals( "El tercer contenedor deber�a estar vac�o despu�s de decargar el barco.", 0, barco.darContenedor3().darNumeroCajas() );
        assertEquals( "El tercer contenedor deber�a estar vac�o despu�s de decargar el barco.", 0, barco.darContenedor3().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata due�o del tercer contenedor no coincide.", Contenedor.ANNE_BONNY, barco.darContenedor3().darNombrePirata() );

        // 4. Al descargar el cuarto contenedor.
    	barco.descargarContenedor(Contenedor.DAVY_JONES);
        assertEquals( "El cuarto contenedor deber�a estar vac�o despu�s de decargar el barco.", Contenedor.SIN_CARGA, barco.darContenedor4().darTipoCarga() );
        assertEquals( "El cuarto contenedor deber�a estar vac�o despu�s de decargar el barco.", 0, barco.darContenedor4().darNumeroCajas() );
        assertEquals( "El cuarto contenedor deber�a estar vac�o despu�s de decargar el barco.", 0, barco.darContenedor4().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata due�o del cuarto contenedor no coincide.", Contenedor.DAVY_JONES, barco.darContenedor4().darNombrePirata() );
  
    }
    
    /**
     * Prueba 11 - Verifica el m�todo descargarBarco.
     */
    public void testDescargarBarco( )
    {
        setupEscenario2( );
        barco.descargarBarco( );
        
        assertEquals( "El primer contenedor deber�a estar vac�o despu�s de decargar el barco.", Contenedor.SIN_CARGA, barco.darContenedor1().darTipoCarga() );
        assertEquals( "El primer contenedor deber�a estar vac�o despu�s de decargar el barco.", 0, barco.darContenedor1().darNumeroCajas() );
        assertEquals( "El primer contenedor deber�a estar vac�o despu�s de decargar el barco.", 0, barco.darContenedor1().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata due�o del primer contenedor no coincide.", Contenedor.BARBA_NEGRA, barco.darContenedor1().darNombrePirata() );
        
        assertEquals( "El segundo contenedor deber�a estar vac�o despu�s de decargar el barco.", Contenedor.SIN_CARGA, barco.darContenedor2().darTipoCarga() );
        assertEquals( "El segundo contenedor deber�a estar vac�o despu�s de decargar el barco.", 0, barco.darContenedor2().darNumeroCajas() );
        assertEquals( "El segundo contenedor deber�a estar vac�o despu�s de decargar el barco.", 0, barco.darContenedor2().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata due�o del segundo contenedor no coincide.", Contenedor.FRANCIS_DRAKE, barco.darContenedor2().darNombrePirata() );
        
        assertEquals( "El tercer contenedor deber�a estar vac�o despu�s de decargar el barco.", Contenedor.SIN_CARGA, barco.darContenedor3().darTipoCarga() );
        assertEquals( "El tercer contenedor deber�a estar vac�o despu�s de decargar el barco.", 0, barco.darContenedor3().darNumeroCajas() );
        assertEquals( "El tercer contenedor deber�a estar vac�o despu�s de decargar el barco.", 0, barco.darContenedor3().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata due�o del tercer contenedor no coincide.", Contenedor.ANNE_BONNY, barco.darContenedor3().darNombrePirata() );
        
        assertEquals( "El cuarto contenedor deber�a estar vac�o despu�s de decargar el barco.", Contenedor.SIN_CARGA, barco.darContenedor4().darTipoCarga() );
        assertEquals( "El cuarto contenedor deber�a estar vac�o despu�s de decargar el barco.", 0, barco.darContenedor4().darNumeroCajas() );
        assertEquals( "El cuarto contenedor deber�a estar vac�o despu�s de decargar el barco.", 0, barco.darContenedor4().darPesoPorCaja(), 0.01 );
        assertEquals( "El nombre del pirata due�o del cuarto contenedor no coincide.", Contenedor.DAVY_JONES, barco.darContenedor4().darNombrePirata() );
    }
    
    /**
     * Prueba 12 - Verifica el m�todo sobrepasaPesoLimite.
     */
    public void testPuedeZarpar( )
    {
    	// 1. Si no hay contenedores cargados no puede zarpar.
        setupEscenario1( );
        assertFalse("No cumple las condiciones, no puede zarpar.", barco.puedeZarpar());
        
        // 2. Si incumple con la condici�n del peso m�nimo
        setupEscenario3();
        assertFalse("No cumple la condici�n de peso m�nimo, no puede zarpar.", barco.puedeZarpar());
        
        // 3. Si cumple la condici�n de tener una carga con peso mayor al m�nimo.
        setupEscenario1( );
        barco.cargarContenedor(Contenedor.BARBA_NEGRA, 15, 1000, Contenedor.CARGA_PELIGROSA);
        assertTrue("Deber�a poder zarpar, su carga es mayor al m�nimo.", barco.puedeZarpar());
        
        // 4. Si cumple la condici�n de tener al menos dos contenedores cargados.
        setupEscenario4();
        barco.cargarContenedor(Contenedor.BARBA_NEGRA, 1, 1000, Contenedor.CARGA_PERECEDERA);
        assertTrue("Deber�a poder zarpar, tiene al menos dos contenedores cargados.", barco.puedeZarpar());
        
        // 5. Si cumple ambas condiciones.
        setupEscenario2();
        assertTrue("Deber�a poder zarpar, cumple todas las condiciones.", barco.puedeZarpar());
        
    }
    
    /**
     * Prueba 13 - Verifica el m�todo darContenedorMasPesado.
     */
    public void testDarContenedorMasPesado( )
    {
    	// 1. Si el barco est� vac�o deber�a retornar null. 
    	setupEscenario1();
    	assertNull("Deber�a retornar null.", barco.darContenedorMasPesado());
    	
    	// 2. Si hay solo un m�ximo debe encontrarlo.
    	setupEscenario2();
    	assertNotNull("No deber�a ser null.", barco.darContenedorMasPesado());
    	assertEquals("El peso del contenedor m�s pesado no corresponde.", 10000.0, barco.darContenedorMasPesado().darPesoContenedor(), 0.01);
    	assertEquals("El nombre del pirata due�o del contenedor m�s pesado no corresponde.", Contenedor.BARBA_NEGRA, barco.darContenedorMasPesado().darNombrePirata());
    	
    	// 3. Si hay m�s de 1 contenedor que es el m�s pesado.
    	setupEscenario4();
    	barco.cargarContenedor(Contenedor.FRANCIS_DRAKE, 150, 20, Contenedor.CARGA_PERECEDERA);
    	barco.cargarContenedor(Contenedor.ANNE_BONNY, 10, 10, Contenedor.CARGA_PERECEDERA);
    	assertNotNull("No deber�a ser null.", barco.darContenedorMasPesado());
    	boolean maximo = (barco.darContenedorMasPesado().darNombrePirata().equals(Contenedor.DAVY_JONES)||barco.darContenedorMasPesado().darNombrePirata().equals(Contenedor.FRANCIS_DRAKE));
    	assertEquals("El peso del contenedor m�s pesado no corresponde.", 3000.0, barco.darContenedorMasPesado().darPesoContenedor(), 0.01);
    	assertTrue("El nombre del pirata due�o del contenedor m�s pesado no corresponde.", maximo);
    }
    
    /**
     * Prueba 14 - Verifica el m�todo buscarContenedorMasPesado.
     */
    public void testBuscarPirataDuenioContenedorMasPesado( )
    {
        // 1. Si el barco est� vac�o el mensaje correspondiente.
    	setupEscenario1();
    	assertEquals("El mensaje no corresponde.", "El barco est� vac�o.", barco.buscarPirataDuenioContenedorMasPesado() );
    	
    	// 2. Si hay un �nico m�ximo.
    	setupEscenario2();
    	assertTrue("El mensaje no corresponde.",  barco.buscarPirataDuenioContenedorMasPesado().contains(Contenedor.BARBA_NEGRA) );
    	
    	// 3. Si hay mas de un m�ximo.
    	setupEscenario4();
        barco.cargarContenedor(Contenedor.FRANCIS_DRAKE, 1, 3000, Contenedor.CARGA_PERECEDERA);
        barco.cargarContenedor(Contenedor.ANNE_BONNY, 1, 1000, Contenedor.CARGA_PERECEDERA);
        barco.cargarContenedor(Contenedor.BARBA_NEGRA, 1, 2000, Contenedor.CARGA_PERECEDERA);
        
        String rta= barco.buscarPirataDuenioContenedorMasPesado();
        assertTrue("Falta el nombre de un pirata.", rta.contains(Contenedor.DAVY_JONES));
        assertTrue("Falta el nombre de un pirata.", rta.contains(Contenedor.FRANCIS_DRAKE));
        assertFalse("Contiene un nombre de un pirata que no es m�ximo.", rta.contains(Contenedor.ANNE_BONNY));
        assertFalse("Contiene un nombre de un pirata que no es m�ximo.", rta.contains(Contenedor.BARBA_NEGRA));
        
    }
}
