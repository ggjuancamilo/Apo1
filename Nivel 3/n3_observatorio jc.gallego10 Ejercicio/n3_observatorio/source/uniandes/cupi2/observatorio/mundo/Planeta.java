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


package uniandes.cupi2.observatorio.mundo;

import java.util.ArrayList;

/**
 * Clase que representa un planeta del sistema solar.
 */
public class Planeta
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del planeta.
     */
    private String nombre;

    /**
     * Distancia media al sol. Dada en UA.
     */
    private double distanciaMediaSol;

    /**
     * Excentricidad del planeta.
     */
    private double excentricidad;

    /**
     *  Periodo de orbital del planeta. Dado en años.
     */
    private double periodoOrbitalSinodico;

    /**
     * Velocidad media del planeta. Dada en km/s.
     */
    private double velocidadOrbitalMedia;

    /**
     * Inclinación del planeta. Dada en grados.
     */
    private double inclinacion;

    /**
     * Lista de los satélites naturales que posee el planeta.
     */
    
    private ArrayList <SateliteNatural> satelitesNaturales;
    //TODO: Declarar la asociación satelites como una contenedora de tamaño variable.
    
    /**
     * Satélite artificial que posee el planeta.
     */
    private SateliteArtificial sateliteArtificial;
    //TODO: Declarar la asociación que modela el satélite artificial que posee el planeta.

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un planeta con los datos suministrados por parámetro.
     * @param pNombre Nombre del planeta.
     * @param pDistanciaMediaSol Distancia media al sol.
     * @param pExcentricidad Excentricidad de la órbita.
     * @param pPeriodoOrbitalSinodico Periodo orbital sinódico.
     * @param pVelocidadOrbitalMedia Velocidad media del planeta.
     * @param pInclinacion Inclinación del planeta con respecto a su eje.
     */
    public Planeta( String pNombre, double pDistanciaMediaSol, double pExcentricidad, double pPeriodoOrbitalSinodico, double pVelocidadOrbitalMedia, double pInclinacion )
    {
        nombre = pNombre;
        distanciaMediaSol = pDistanciaMediaSol;
        excentricidad = pExcentricidad;
        periodoOrbitalSinodico = pPeriodoOrbitalSinodico;
        velocidadOrbitalMedia = pVelocidadOrbitalMedia;
        inclinacion = pInclinacion;
        
        sateliteArtificial = null;
        satelitesNaturales = new ArrayList<>();
        
        //TODO: Completar la creación de las asociaciones satelites y sateliteArtificial según la documentación del constructor.
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Devuelve el nombre del planeta.
     * @return Nombre del planeta.
     */
    public String darNombre( )
    {
        return nombre;
    }
    
    /**
     * Devuelve la distancia media al sol del planeta.
     * @return Distancia media al sol.
     */
    public double darDistancia( )
    {
        return distanciaMediaSol;
    }

    /**
     * Devuelve la inclinación del planeta.
     * @return Inclinación del planeta con respecto a su eje.
     */
    public double darInclinacion( )
    {
        return inclinacion;
    }
    
    /**
     * Devuelve la excentricidad del planeta.
     * @return Excentricidad del planeta.
     */
    public double darExcentricidad( )
    {
        return excentricidad;
    }
    
    /**
     * Devuelve el periodo orbital del planeta.
     * @return Periodo orbital del planeta.
     */
    public double darPeriodoOrbital( )
    {
        return periodoOrbitalSinodico;
    }
    
    /**
     * Devuelve la velocidad media del planeta.
     * @return Velocidad media del planeta.
     */
    public double darVelocidadMedia( )
    {
        return velocidadOrbitalMedia;
    }
    
    /**
     * Devuelve la lista de los satélites naturales que posee el planeta.
     * @return Lista de los satélites naturales que posee el planeta. Lista vacía en caso de no tener satélite naturales.
     */
    public ArrayList <SateliteNatural> darSatelitesNaturales( )
    {
    	return satelitesNaturales;
    	// TODO: Completar según la documentación del método.
    }
    
    /**
     * Devuelve el satélite artificial del planeta.
     * @return Satélite artifical del planeta. Null si no tiene satélite artificial.
     */
    public SateliteArtificial darSateliteArtificial()
    {
    	return sateliteArtificial;
    	// TODO: Completar según la documentación del método.
    }
    
    /**
     * Agrega un nuevo satélite artificial al planeta.
     * @param pNombre Nombre del satélite artificial.
     * @param pPais País de origen del satélite artificial.
     * @param pTipoDeServicio Tipo de servicio que ofrece satélite artificial.
     * @return True si logró agregar el satélite artificial al planeta. False de lo contrario.
     */
    public boolean agregarSateliteArtificial(String pNombre, String pPais, String pTipoDeServicio){
    	if(sateliteArtificial!=null)
    		return false;
    	else{
    		sateliteArtificial = new SateliteArtificial(pNombre, pPais, pTipoDeServicio);
    	}
    	
    	return true;
    }
    
    /**
     * Elimina un satélite artificial dado su nombre.
     * @param pNombreSatelite Nombre del satélite artificial que se quiere eliminar.
     * @return True si se pudo eliminar el satélite artificial. False en caso de no tener satélite artificial o su nombre no corresponda con el nombre dado por parámetro.
     */
    public boolean eliminarSateliteArtificial(String pNombreSatelite)
    {
    	
    	boolean eliminar = false;
    	if(sateliteArtificial != null && sateliteArtificial.darNombre().equals(pNombreSatelite))
    	{
    		eliminar = true;
    		sateliteArtificial = null;
    	}
    	return eliminar;
    	// TODO: Completar según la documentación del método.
    }

    /**
     * Agrega un nuevo satélite natural al planeta. <br>
     * <b> pre: </b> satelites != null <br>
     * Se debe verificar que no exista un satélite natural con el mismo nombre.
     * @param pNombreSatelite Nombre del nuevo satélite natural.
     * @param pExcentricidad Excentricidad del nuevo satélite natural.
     * @param pInclinacion Inclinación del nuevo satélite natural.
     * @return True si logró agregar el satélite natural al planeta. False de lo contrario.
     */
    public boolean agregarSateliteNatural( String pNombreSatelite, double pExcentricidad, double pInclinacion )
    {
    	for (int i = 0; i < satelitesNaturales.size(); i++) 
    	{
    		if(satelitesNaturales.get(i).equals(pNombreSatelite))
    		{
    			return false;
    		}
    		
		}
    	satelitesNaturales.add(new SateliteNatural(pNombreSatelite, pExcentricidad, pInclinacion));
    	return true;
    	// TODO: Completar según la documentación del método.
    }

    /**
     * Elimina un satélite natural dado su nombre.
     * @param pNombreSatelite Nombre del satélite natural que se quiere eliminar.
     * @return True si se pudo eliminar el satélite natural. False en caso de no encontrar el satélite natural con el nombre dado.
     */
    public boolean eliminarSateliteNatural( String pNombreSatelite )
    {
    	for (int i = 0; i < satelitesNaturales.size(); i++) 
    	{
    		if (satelitesNaturales.get(i).darNombre().equals(pNombreSatelite))
    		{
    			satelitesNaturales.remove(i);
    			return true;
    		}
    	
		}
    	return false;
    	// TODO: Completar según la documentación del método.
    }

    /**
     * Busca un satélite natural dado su nombre. 
     * @param pNombreSatelite Nombre del satélite natural que se quiere buscar.
     * @return Satélite natural buscado. Null en caso de no encontrarlo.
     */
    public SateliteNatural buscarSateliteNatural( String pNombreSatelite )
    {

    	for (int i = 0; i < satelitesNaturales.size(); i++) 
    	{
			if(satelitesNaturales.get(i).darNombre().equals(pNombreSatelite) )
			{
				return satelitesNaturales.get(i);
			}
			
		}
    	return null;
    	// TODO: Completar según la documentación del método.
    }

    /**
     * Edita las propiedades de un satélite natural dado su nombre.
     * @param pNombreSatelite Nombre del satélite que se quiere modificar. 
     * @param pExcentricidad Nueva excentricidad del satélite natural. 
     * @param pInclinacion Nueva inclinación del satélite natural.
     * return True si se edito el satélite natural. False en caso de no encontrar el satélite natural con el nombre dado.
     */
    public boolean editarSateliteNatural( String pNombreSatelite, double pExcentricidad, double pInclinacion )
    {
    	for (int i = 0; i < satelitesNaturales.size(); i++) 
    	{
    		if( satelitesNaturales.get(i).darNombre().equals(pNombreSatelite))
    		{
    			satelitesNaturales.get(i).editarSatelite(pExcentricidad, pInclinacion);
    			return true;
    		}
    		
		}
    	return false;
    	
    	// TODO: Completar según la documentación del método.
    }

}
