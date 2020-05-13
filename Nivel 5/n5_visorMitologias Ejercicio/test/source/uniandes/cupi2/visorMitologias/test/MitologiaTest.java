/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n5_visorMitologias
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.visorMitologias.test;

import java.awt.Color;
import java.util.ArrayList;

import junit.framework.*; 
import uniandes.cupi2.visorMitologias.mundo.*; 

/**
 * Clase usada para verificar que los métodos de la clase Mitologia estén correctamente implementados.
 */
public class MitologiaTest extends TestCase  
{
	//-------------------------------------------------------------
	// Atributos
	//-------------------------------------------------------------

	/**
	 * Mitología de prueba.
	 */
	private Mitologia mitologia; 

	//-------------------------------------------------------------
	// Métodos
	//-------------------------------------------------------------

	/**
	 * Escenario 1: Crea una mitología sin dioses.
	 */
	public void setupEscenario1( )
	{
		Color c = new Color ( 255, 0, 0);
		mitologia = new Mitologia( "Griega", "Descripción", "Grecia", "RutaImagen", c );
	}

	/**
	 * Escenario 2: Crea una mitología con dioses.
	 */
	public void setupEscenario2( )
	{
		Color c = new Color ( 255, 0, 0);
		mitologia = new Mitologia( "Griega", "Descripción", "Grecia", "RutaImagen",c );
		try 
		{
			mitologia.agregarDios( "Zeus", "Descripción", "Trueno", "RutaImagen1",true );
			mitologia.agregarDios( "Poseidón", "Descripción", "Mar", "RutaImagen2",false );
			mitologia.agregarDios( "Hades", "Descripción", "Infierno", "RutaImagen3",false );
			mitologia.agregarDios( "Hades2", "Descripción", "Infierno", "RutaImagen4",false );   
		} 
		catch (Exception e) 
		{
			fail( "No debería lanzar excepción." );
		}

	}

	/**
	 * Prueba 1: Verifica que el método construtor esté corretamente implementado.
	 */
	public void testDarAtributos( )
	{
		setupEscenario1( );

		assertEquals( "El lugar de la mitología debería ser Grecia.", "Grecia", mitologia.darLugar( ) );
		assertEquals( "La ruta de la imagen debería ser RutaImagen.", "RutaImagen", mitologia.darRutaImagen( ) );
		assertNotNull( "La lista de dioses debería existir.", mitologia.darDioses() );
		assertEquals( "La lista de dioses debería estar vacía.", 0, mitologia.darDioses().size());
		assertNotNull( "El colo no debería ser nulo.", mitologia.darColor() );
	}

	/**
	 * Prueba 2: Verifica que el método agregarDios esté corretamente implementado.
	 */
	public void testAgregarDios( )
	{
		setupEscenario1( );
		try
		{

			mitologia.agregarDios( "Zeus", "Descripción", "Trueno", "RutaImagen1",true );
		} 
		catch (Exception e) 
		{
			fail( "No debería lanzar excepción." );
		}
		assertEquals( "Debe haber un dios.", 1, mitologia.darDioses( ).size( ) );

		Dios dios = ( Dios )mitologia.darDioses( ).get( 0 );

		assertEquals( "El nombre del dios debería ser Zeus.", "Zeus", dios.darNombre( ) );
		try
		{

			mitologia.agregarDios( "Poseidón", "Descripción", "Mar", "RutaImagen2",true );
		} 
		catch (Exception e) 
		{
			fail( "No debería lanzar excepción." );
		}
		assertEquals( "Debería haber dos dioses.", 2, mitologia.darDioses( ).size( ) );

		dios = ( Dios )mitologia.darDioses( ).get( 1 );

		assertEquals( "El nombre del dios debería ser Poseidón.", "Poseidón", dios.darNombre( ) );
	}

	/**
	 * Prueba 3: Verifica que el método darPrimerDios esté corretamente implementado.
	 */
	public void testDarPrimerDios( )
	{
		setupEscenario2( );
		try
		{
			mitologia.darDiosSiguiente();
			Dios dios = mitologia.darPrimerDios( );
			assertEquals( "El nombre del dios debe ser Zeus", "Zeus", dios.darNombre( ) );
		}
		catch( Exception e )
		{
			fail( "No debería lanzar excepción." );
		}
		setupEscenario2( );
		try
		{
			Dios dios = mitologia.darPrimerDios( );
			fail( "Debería lanzar excepción." );
		}
		catch( Exception e )
		{
			// Debe pasar por aquí.
		}
	}

	/**
	 * Prueba 4: Verifica que el método darDiosAnterior esté corretamente implementado.
	 */
	public void testDarDiosAnterior( )
	{
		setupEscenario2( );

		try
		{
			mitologia.darDiosAnterior( );
			fail( "Debería lanzar excepción." );
		}
		catch( Exception e )
		{
			//Debe pasar por acá
		}

		try
		{
			mitologia.darDiosSiguiente( );
			Dios dios = mitologia.darDiosAnterior( );
			assertEquals( "El nombre del dios debería ser Zeus.", "Zeus", dios.darNombre( ) );
		}
		catch( Exception e )
		{
			fail( "No debería lanzar excepción." );
		}

	}

	/**
	 * Prueba 5: Verifica que el método darDiosSiguiente esté corretamente implementado.
	 */
	public void testDarDiosSiguiente( )
	{
		setupEscenario2( );

		try
		{
			Dios dios = mitologia.darDiosSiguiente( );
			assertEquals( "El nombre del dios debe ser Poseidón.", "Poseidón", dios.darNombre( ) );
		}
		catch( Exception e )
		{
			fail( "No debería lanzar excepción." );
		}

		try
		{
			mitologia.darDiosSiguiente();
			mitologia.darDiosSiguiente();
			mitologia.darDiosSiguiente();
			fail( "Debería lanzar excepción." );
		}
		catch( Exception e )
		{

		}


	}

	/**
	 * Prueba 6: Verifica que el método darUltimoDios esté corretamente implementado.
	 */
	public void testDarUltimoDios( )
	{
		setupEscenario2( );

		try
		{
			Dios dios = mitologia.darUltimoDios( );
			assertEquals( "El nombre del dios debería ser Hades2", "Hades2", dios.darNombre( ) );
		}
		catch( Exception e )
		{
			fail( "No debería lanzar excepción." );
		}

		try
		{
			mitologia.darUltimoDios( );
			fail( "Debería lanzar excepción." );
		}
		catch( Exception e )
		{
		}
	}

	/**
	 * Prueba 7: Verifica que el método buscarDiosesPorEspecialidad esté corretamente implementado.
	 */
	public void testBuscarDioses( )
	{
		setupEscenario2( );

		ArrayList dioses = mitologia.buscarDiosesPorEspecialidad( "Infierno" );
		assertEquals( "Debería haber dos dioses con esa especialidad.", 2, dioses.size( ) );
		String nombreDios = ( String )dioses.get( 0 );
		assertEquals( "El nombre del dios debería ser Hades.", "Hades", nombreDios );
		String nombreDios2 = ( String )dioses.get( 1 );
		assertEquals( "El nombre del dios debería ser Hades2.", "Hades2", nombreDios2 );
		ArrayList dioses2 = mitologia.buscarDiosesPorEspecialidad( "Mar" );
		assertEquals( "Debería haber un dios con esa especialidad.", 2, dioses.size( ) );
	}
}