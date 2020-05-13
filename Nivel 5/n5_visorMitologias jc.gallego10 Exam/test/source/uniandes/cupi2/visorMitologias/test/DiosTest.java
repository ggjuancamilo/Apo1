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

import junit.framework.*; 
import uniandes.cupi2.visorMitologias.mundo.*; 

/**
 * Clase usada para verificar que los métodos de la clase Dios estén correctamente implementados.
 */
public class DiosTest extends TestCase  
{	
	//-------------------------------------------------------------
	// Atributos
	//-------------------------------------------------------------
		
	/**
	 * Dios de prueba.
	 */
	private Dios dios; 
		
	//-------------------------------------------------------------
	// Métodos
	//-------------------------------------------------------------
		
	/**
	 * Escenario 1: Crea un nuevo dios.
	 */
	public void setupEscenario1()
	{
	    dios = new Dios( "Zeus", "Descripción", "Trueno", "RutaImagen", true );
	}
	
	/**
	 * Prueba 1: Verifica que el método construtor esté corretamente implementado.
	 */
	public void testCrearDios( )
	{
	    setupEscenario1( );
	    
	    assertEquals( "El nombre del dios debería ser Zeus.", "Zeus", dios.darNombre( ) );    
	    assertEquals( "La especialización del dios debería ser Trueno.", "Trueno", dios.darEspecialidad( ) );
	    assertEquals( "La ruta de la imagen debería ser RutaImagen", "RutaImagen", dios.darRutaImagen( ) );
	    assertTrue( "La condición de principal del dios debería ser true.", dios.darEsPrincipal() );
	}
}