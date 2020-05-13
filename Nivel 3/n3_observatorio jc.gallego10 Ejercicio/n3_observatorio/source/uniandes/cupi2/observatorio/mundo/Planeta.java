/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
     *  Periodo de orbital del planeta. Dado en a�os.
     */
    private double periodoOrbitalSinodico;

    /**
     * Velocidad media del planeta. Dada en km/s.
     */
    private double velocidadOrbitalMedia;

    /**
     * Inclinaci�n del planeta. Dada en grados.
     */
    private double inclinacion;

    /**
     * Lista de los sat�lites naturales que posee el planeta.
     */
    
    private ArrayList <SateliteNatural> satelitesNaturales;
    //TODO: Declarar la asociaci�n satelites como una contenedora de tama�o variable.
    
    /**
     * Sat�lite artificial que posee el planeta.
     */
    private SateliteArtificial sateliteArtificial;
    //TODO: Declarar la asociaci�n que modela el sat�lite artificial que posee el planeta.

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un planeta con los datos suministrados por par�metro.
     * @param pNombre Nombre del planeta.
     * @param pDistanciaMediaSol Distancia media al sol.
     * @param pExcentricidad Excentricidad de la �rbita.
     * @param pPeriodoOrbitalSinodico Periodo orbital sin�dico.
     * @param pVelocidadOrbitalMedia Velocidad media del planeta.
     * @param pInclinacion Inclinaci�n del planeta con respecto a su eje.
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
        
        //TODO: Completar la creaci�n de las asociaciones satelites y sateliteArtificial seg�n la documentaci�n del constructor.
    }

    // -----------------------------------------------------------------
    // M�todos
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
     * Devuelve la inclinaci�n del planeta.
     * @return Inclinaci�n del planeta con respecto a su eje.
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
     * Devuelve la lista de los sat�lites naturales que posee el planeta.
     * @return Lista de los sat�lites naturales que posee el planeta. Lista vac�a en caso de no tener sat�lite naturales.
     */
    public ArrayList <SateliteNatural> darSatelitesNaturales( )
    {
    	return satelitesNaturales;
    	// TODO: Completar seg�n la documentaci�n del m�todo.
    }
    
    /**
     * Devuelve el sat�lite artificial del planeta.
     * @return Sat�lite artifical del planeta. Null si no tiene sat�lite artificial.
     */
    public SateliteArtificial darSateliteArtificial()
    {
    	return sateliteArtificial;
    	// TODO: Completar seg�n la documentaci�n del m�todo.
    }
    
    /**
     * Agrega un nuevo sat�lite artificial al planeta.
     * @param pNombre Nombre del sat�lite artificial.
     * @param pPais Pa�s de origen del sat�lite artificial.
     * @param pTipoDeServicio Tipo de servicio que ofrece sat�lite artificial.
     * @return True si logr� agregar el sat�lite artificial al planeta. False de lo contrario.
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
     * Elimina un sat�lite artificial dado su nombre.
     * @param pNombreSatelite Nombre del sat�lite artificial que se quiere eliminar.
     * @return True si se pudo eliminar el sat�lite artificial. False en caso de no tener sat�lite artificial o su nombre no corresponda con el nombre dado por par�metro.
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
    	// TODO: Completar seg�n la documentaci�n del m�todo.
    }

    /**
     * Agrega un nuevo sat�lite natural al planeta. <br>
     * <b> pre: </b> satelites != null <br>
     * Se debe verificar que no exista un sat�lite natural con el mismo nombre.
     * @param pNombreSatelite Nombre del nuevo sat�lite natural.
     * @param pExcentricidad Excentricidad del nuevo sat�lite natural.
     * @param pInclinacion Inclinaci�n del nuevo sat�lite natural.
     * @return True si logr� agregar el sat�lite natural al planeta. False de lo contrario.
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
    	// TODO: Completar seg�n la documentaci�n del m�todo.
    }

    /**
     * Elimina un sat�lite natural dado su nombre.
     * @param pNombreSatelite Nombre del sat�lite natural que se quiere eliminar.
     * @return True si se pudo eliminar el sat�lite natural. False en caso de no encontrar el sat�lite natural con el nombre dado.
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
    	// TODO: Completar seg�n la documentaci�n del m�todo.
    }

    /**
     * Busca un sat�lite natural dado su nombre. 
     * @param pNombreSatelite Nombre del sat�lite natural que se quiere buscar.
     * @return Sat�lite natural buscado. Null en caso de no encontrarlo.
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
    	// TODO: Completar seg�n la documentaci�n del m�todo.
    }

    /**
     * Edita las propiedades de un sat�lite natural dado su nombre.
     * @param pNombreSatelite Nombre del sat�lite que se quiere modificar. 
     * @param pExcentricidad Nueva excentricidad del sat�lite natural. 
     * @param pInclinacion Nueva inclinaci�n del sat�lite natural.
     * return True si se edito el sat�lite natural. False en caso de no encontrar el sat�lite natural con el nombre dado.
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
    	
    	// TODO: Completar seg�n la documentaci�n del m�todo.
    }

}
