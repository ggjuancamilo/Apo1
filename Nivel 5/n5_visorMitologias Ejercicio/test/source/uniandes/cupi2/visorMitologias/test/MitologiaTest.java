/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
 * Clase usada para verificar que los m�todos de la clase Mitologia est�n correctamente implementados.
 */
public class MitologiaTest extends TestCase  
{
	//-------------------------------------------------------------
	// Atributos
	//-------------------------------------------------------------

	/**
	 * Mitolog�a de prueba.
	 */
	private Mitologia mitologia; 

	//-------------------------------------------------------------
	// M�todos
	//-------------------------------------------------------------

	/**
	 * Escenario 1: Crea una mitolog�a sin dioses.
	 */
	public void setupEscenario1( )
	{
		Color c = new Color ( 255, 0, 0);
		mitologia = new Mitologia( "Griega", "Descripci�n", "Grecia", "RutaImagen", c );
	}

	/**
	 * Escenario 2: Crea una mitolog�a con dioses.
	 */
	public void setupEscenario2( )
	{
		Color c = new Color ( 255, 0, 0);
		mitologia = new Mitologia( "Griega", "Descripci�n", "Grecia", "RutaImagen",c );
		try 
		{
			mitologia.agregarDios( "Zeus", "Descripci�n", "Trueno", "RutaImagen1",true );
			mitologia.agregarDios( "Poseid�n", "Descripci�n", "Mar", "RutaImagen2",false );
			mitologia.agregarDios( "Hades", "Descripci�n", "Infierno", "RutaImagen3",false );
			mitologia.agregarDios( "Hades2", "Descripci�n", "Infierno", "RutaImagen4",false );   
		} 
		catch (Exception e) 
		{
			fail( "No deber�a lanzar excepci�n." );
		}

	}

	/**
	 * Prueba 1: Verifica que el m�todo construtor est� corretamente implementado.
	 */
	public void testDarAtributos( )
	{
		setupEscenario1( );

		assertEquals( "El lugar de la mitolog�a deber�a ser Grecia.", "Grecia", mitologia.darLugar( ) );
		assertEquals( "La ruta de la imagen deber�a ser RutaImagen.", "RutaImagen", mitologia.darRutaImagen( ) );
		assertNotNull( "La lista de dioses deber�a existir.", mitologia.darDioses() );
		assertEquals( "La lista de dioses deber�a estar vac�a.", 0, mitologia.darDioses().size());
		assertNotNull( "El colo no deber�a ser nulo.", mitologia.darColor() );
	}

	/**
	 * Prueba 2: Verifica que el m�todo agregarDios est� corretamente implementado.
	 */
	public void testAgregarDios( )
	{
		setupEscenario1( );
		try
		{

			mitologia.agregarDios( "Zeus", "Descripci�n", "Trueno", "RutaImagen1",true );
		} 
		catch (Exception e) 
		{
			fail( "No deber�a lanzar excepci�n." );
		}
		assertEquals( "Debe haber un dios.", 1, mitologia.darDioses( ).size( ) );

		Dios dios = ( Dios )mitologia.darDioses( ).get( 0 );

		assertEquals( "El nombre del dios deber�a ser Zeus.", "Zeus", dios.darNombre( ) );
		try
		{

			mitologia.agregarDios( "Poseid�n", "Descripci�n", "Mar", "RutaImagen2",true );
		} 
		catch (Exception e) 
		{
			fail( "No deber�a lanzar excepci�n." );
		}
		assertEquals( "Deber�a haber dos dioses.", 2, mitologia.darDioses( ).size( ) );

		dios = ( Dios )mitologia.darDioses( ).get( 1 );

		assertEquals( "El nombre del dios deber�a ser Poseid�n.", "Poseid�n", dios.darNombre( ) );
	}

	/**
	 * Prueba 3: Verifica que el m�todo darPrimerDios est� corretamente implementado.
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
			fail( "No deber�a lanzar excepci�n." );
		}
		setupEscenario2( );
		try
		{
			Dios dios = mitologia.darPrimerDios( );
			fail( "Deber�a lanzar excepci�n." );
		}
		catch( Exception e )
		{
			// Debe pasar por aqu�.
		}
	}

	/**
	 * Prueba 4: Verifica que el m�todo darDiosAnterior est� corretamente implementado.
	 */
	public void testDarDiosAnterior( )
	{
		setupEscenario2( );

		try
		{
			mitologia.darDiosAnterior( );
			fail( "Deber�a lanzar excepci�n." );
		}
		catch( Exception e )
		{
			//Debe pasar por ac�
		}

		try
		{
			mitologia.darDiosSiguiente( );
			Dios dios = mitologia.darDiosAnterior( );
			assertEquals( "El nombre del dios deber�a ser Zeus.", "Zeus", dios.darNombre( ) );
		}
		catch( Exception e )
		{
			fail( "No deber�a lanzar excepci�n." );
		}

	}

	/**
	 * Prueba 5: Verifica que el m�todo darDiosSiguiente est� corretamente implementado.
	 */
	public void testDarDiosSiguiente( )
	{
		setupEscenario2( );

		try
		{
			Dios dios = mitologia.darDiosSiguiente( );
			assertEquals( "El nombre del dios debe ser Poseid�n.", "Poseid�n", dios.darNombre( ) );
		}
		catch( Exception e )
		{
			fail( "No deber�a lanzar excepci�n." );
		}

		try
		{
			mitologia.darDiosSiguiente();
			mitologia.darDiosSiguiente();
			mitologia.darDiosSiguiente();
			fail( "Deber�a lanzar excepci�n." );
		}
		catch( Exception e )
		{

		}


	}

	/**
	 * Prueba 6: Verifica que el m�todo darUltimoDios est� corretamente implementado.
	 */
	public void testDarUltimoDios( )
	{
		setupEscenario2( );

		try
		{
			Dios dios = mitologia.darUltimoDios( );
			assertEquals( "El nombre del dios deber�a ser Hades2", "Hades2", dios.darNombre( ) );
		}
		catch( Exception e )
		{
			fail( "No deber�a lanzar excepci�n." );
		}

		try
		{
			mitologia.darUltimoDios( );
			fail( "Deber�a lanzar excepci�n." );
		}
		catch( Exception e )
		{
		}
	}

	/**
	 * Prueba 7: Verifica que el m�todo buscarDiosesPorEspecialidad est� corretamente implementado.
	 */
	public void testBuscarDioses( )
	{
		setupEscenario2( );

		ArrayList dioses = mitologia.buscarDiosesPorEspecialidad( "Infierno" );
		assertEquals( "Deber�a haber dos dioses con esa especialidad.", 2, dioses.size( ) );
		String nombreDios = ( String )dioses.get( 0 );
		assertEquals( "El nombre del dios deber�a ser Hades.", "Hades", nombreDios );
		String nombreDios2 = ( String )dioses.get( 1 );
		assertEquals( "El nombre del dios deber�a ser Hades2.", "Hades2", nombreDios2 );
		ArrayList dioses2 = mitologia.buscarDiosesPorEspecialidad( "Mar" );
		assertEquals( "Deber�a haber un dios con esa especialidad.", 2, dioses.size( ) );
	}
}