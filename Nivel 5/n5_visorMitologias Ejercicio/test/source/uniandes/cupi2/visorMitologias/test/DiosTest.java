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

import junit.framework.*; 
import uniandes.cupi2.visorMitologias.mundo.*; 

/**
 * Clase usada para verificar que los m�todos de la clase Dios est�n correctamente implementados.
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
	// M�todos
	//-------------------------------------------------------------
		
	/**
	 * Escenario 1: Crea un nuevo dios.
	 */
	public void setupEscenario1()
	{
	    dios = new Dios( "Zeus", "Descripci�n", "Trueno", "RutaImagen", true );
	}
	
	/**
	 * Prueba 1: Verifica que el m�todo construtor est� corretamente implementado.
	 */
	public void testCrearDios( )
	{
	    setupEscenario1( );
	    
	    assertEquals( "El nombre del dios deber�a ser Zeus.", "Zeus", dios.darNombre( ) );    
	    assertEquals( "La especializaci�n del dios deber�a ser Trueno.", "Trueno", dios.darEspecialidad( ) );
	    assertEquals( "La ruta de la imagen deber�a ser RutaImagen", "RutaImagen", dios.darRutaImagen( ) );
	    assertTrue( "La condici�n de principal del dios deber�a ser true.", dios.darEsPrincipal() );
	}
}