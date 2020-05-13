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

import java.util.ArrayList;

import junit.framework.*; 
import uniandes.cupi2.visorMitologias.mundo.*; 

/**
 * Clase usada para verificar que los métodos de la clase VisorMitologias estén correctamente implementados.
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
	// Métodos
	//-------------------------------------------------------------
	
	/**
	 * Escenario 1: Crea el visor de mitología con el archivo de propiedades.
	 */
	public void setupEscenario1( )
	{
	    try
        {
            visorMitologias = new VisorMitologias( );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }
	}
	
	/**
     * Prueba 1: Verifica que el método darPrimeraMitologia esté correctamente implementado.
     */
    public void testDarPrimeraMitologia( )
    {
        setupEscenario1( );
        
        try
        {
            visorMitologias.darPrimeraMitologia( );
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            //Debe pasar por acá
        }
        
        try
        {
            visorMitologias.darMitologiaSiguiente( );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }
        
        try
        {
            Mitologia mitologia = visorMitologias.darPrimeraMitologia( );
            assertEquals( "El nombre de la mitología debería ser Egipcia", "Egipcia", mitologia.darNombre( ) );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }
    }
    
    /**
     * Prueba 2: Verifica que el método darMitologiaAnterior esté correctamente implementado.
     */
    public void testDarMitologiaAnterior( )
    {
        setupEscenario1( );
        
        try
        {
            visorMitologias.darMitologiaAnterior( );
            fail( "Debería lanzar excepción." );
        }
        catch( Exception e )
        {
            //Debe pasar por acá
        }
        
        try
        {
            visorMitologias.darMitologiaSiguiente( );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }
        
        try
        {
            Mitologia mitologia = visorMitologias.darMitologiaAnterior( );
            assertEquals( "El nombre de la mitología debería ser Egipcia", "Egipcia", mitologia.darNombre( ) );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }
    }
    
    /**
     * Prueba 3: Verifica que el método darMitologiaSiguiente esté correctamente implementado.
     */
    public void testDarMitologiaSiguiente( )
    {
        setupEscenario1( );
        
        try
        {
            Mitologia mitologia = visorMitologias.darMitologiaSiguiente( );
            assertEquals( "El nombre de la mitología debería ser Griega", "Griega", mitologia.darNombre( ) );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }
    }
    
    /**
     * Prueba 4: Verifica que el método darUltimaMitologia esté correctamente implementado.
     */
    public void testDarUltimaMitologia( )
    {
        setupEscenario1( );
        
        try
        {
            Mitologia mitologia = visorMitologias.darUltimaMitologia( );
            assertEquals( "El nombre de la mitología debería ser Celta.", "Celta", mitologia.darNombre( ) );
        }
        catch( Exception e )
        {
            fail( "No debería lanzar excepción." );
        }
    }
    
    /**
     * Prueba 5: Verifica que el método buscarMitologia esté correctamente implementado.
     */
    public void testBuscarMitologia( )
    {
        setupEscenario1( );
        
        Mitologia mitologia = visorMitologias.buscarMitologia( "Nombre" );
        assertNull( "No debería existir una mitología con el nombre Nombre.", mitologia );
        
        mitologia = visorMitologias.buscarMitologia( "Nórdica" );
        assertNotNull( "Debe existir una mitología con el nombre Nórdica.", mitologia );
        assertEquals( "El nombre de la mitologia debería ser Nórdica.", "Nórdica", mitologia.darNombre( ) );
    }
    
    /**
     * Prueba 6: Verifica que el método buscarDiosesPorEspecialidad esté correctamente implementado.
     */
    public void testBuscarDiosesPorEspecialidad( )
    {
        setupEscenario1( );
        
        ArrayList dioses = visorMitologias.buscarDiosesPorEspecialidad( "Infierno" );
        assertEquals( "Sólo debería haber cuatro dioses con esa especialidad.", 4, dioses.size( ) );
        String nombreDios = ( String )dioses.get( 0 );
        assertEquals( "El nombre del dios debería ser Osiris.", "Osiris", nombreDios );
        
        nombreDios = ( String )dioses.get( 1 );
        assertEquals( "El nombre del dios debería ser Hades.", "Hades", nombreDios );
        
        nombreDios = ( String )dioses.get( 2 );
        assertEquals( "El nombre del dios debería ser Ereshkigal.", "Ereshkigal", nombreDios );
        
        nombreDios = ( String )dioses.get( 3 );
        assertEquals( "El nombre del dios debería ser Arawn.", "Arawn", nombreDios );
    }
}