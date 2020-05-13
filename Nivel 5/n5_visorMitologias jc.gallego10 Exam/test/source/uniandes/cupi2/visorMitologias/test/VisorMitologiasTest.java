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

import java.util.ArrayList;

import junit.framework.*; 
import uniandes.cupi2.visorMitologias.mundo.*; 

/**
 * Clase usada para verificar que los m�todos de la clase VisorMitologias est�n correctamente implementados.
 */
public class VisorMitologiasTest extends TestCase
{
	//-------------------------------------------------------------
	// Atributos
	//-------------------------------------------------------------
		
	/**
	 * VisorMitologias de prueba.
	 */
	private VisorMitologias visorMitologias; 
		
	//-------------------------------------------------------------
	// M�todos
	//-------------------------------------------------------------
	
	/**
	 * Escenario 1: Crea el visor de mitolog�a con el archivo de propiedades.
	 */
	public void setupEscenario1( )
	{
	    try
        {
            visorMitologias = new VisorMitologias( );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
	}
	
	/**
     * Prueba 1: Verifica que el m�todo darPrimeraMitologia est� correctamente implementado.
     */
    public void testDarPrimeraMitologia( )
    {
        setupEscenario1( );
        
        try
        {
            visorMitologias.darPrimeraMitologia( );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            //Debe pasar por ac�
        }
        
        try
        {
            visorMitologias.darMitologiaSiguiente( );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
        
        try
        {
            Mitologia mitologia = visorMitologias.darPrimeraMitologia( );
            assertEquals( "El nombre de la mitolog�a deber�a ser Egipcia", "Egipcia", mitologia.darNombre( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
    }
    
    /**
     * Prueba 2: Verifica que el m�todo darMitologiaAnterior est� correctamente implementado.
     */
    public void testDarMitologiaAnterior( )
    {
        setupEscenario1( );
        
        try
        {
            visorMitologias.darMitologiaAnterior( );
            fail( "Deber�a lanzar excepci�n." );
        }
        catch( Exception e )
        {
            //Debe pasar por ac�
        }
        
        try
        {
            visorMitologias.darMitologiaSiguiente( );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
        
        try
        {
            Mitologia mitologia = visorMitologias.darMitologiaAnterior( );
            assertEquals( "El nombre de la mitolog�a deber�a ser Egipcia", "Egipcia", mitologia.darNombre( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
    }
    
    /**
     * Prueba 3: Verifica que el m�todo darMitologiaSiguiente est� correctamente implementado.
     */
    public void testDarMitologiaSiguiente( )
    {
        setupEscenario1( );
        
        try
        {
            Mitologia mitologia = visorMitologias.darMitologiaSiguiente( );
            assertEquals( "El nombre de la mitolog�a deber�a ser Griega", "Griega", mitologia.darNombre( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
    }
    
    /**
     * Prueba 4: Verifica que el m�todo darUltimaMitologia est� correctamente implementado.
     */
    public void testDarUltimaMitologia( )
    {
        setupEscenario1( );
        
        try
        {
            Mitologia mitologia = visorMitologias.darUltimaMitologia( );
            assertEquals( "El nombre de la mitolog�a deber�a ser Celta.", "Celta", mitologia.darNombre( ) );
        }
        catch( Exception e )
        {
            fail( "No deber�a lanzar excepci�n." );
        }
    }
    
    /**
     * Prueba 5: Verifica que el m�todo buscarMitologia est� correctamente implementado.
     */
    public void testBuscarMitologia( )
    {
        setupEscenario1( );
        
        Mitologia mitologia = visorMitologias.buscarMitologia( "Nombre" );
        assertNull( "No deber�a existir una mitolog�a con el nombre Nombre.", mitologia );
        
        mitologia = visorMitologias.buscarMitologia( "N�rdica" );
        assertNotNull( "Debe existir una mitolog�a con el nombre N�rdica.", mitologia );
        assertEquals( "El nombre de la mitologia deber�a ser N�rdica.", "N�rdica", mitologia.darNombre( ) );
    }
    
    /**
     * Prueba 6: Verifica que el m�todo buscarDiosesPorEspecialidad est� correctamente implementado.
     */
    public void testBuscarDiosesPorEspecialidad( )
    {
        setupEscenario1( );
        
        ArrayList dioses = visorMitologias.buscarDiosesPorEspecialidad( "Infierno" );
        assertEquals( "S�lo deber�a haber cuatro dioses con esa especialidad.", 4, dioses.size( ) );
        String nombreDios = ( String )dioses.get( 0 );
        assertEquals( "El nombre del dios deber�a ser Osiris.", "Osiris", nombreDios );
        
        nombreDios = ( String )dioses.get( 1 );
        assertEquals( "El nombre del dios deber�a ser Hades.", "Hades", nombreDios );
        
        nombreDios = ( String )dioses.get( 2 );
        assertEquals( "El nombre del dios deber�a ser Ereshkigal.", "Ereshkigal", nombreDios );
        
        nombreDios = ( String )dioses.get( 3 );
        assertEquals( "El nombre del dios deber�a ser Arawn.", "Arawn", nombreDios );
    }
}