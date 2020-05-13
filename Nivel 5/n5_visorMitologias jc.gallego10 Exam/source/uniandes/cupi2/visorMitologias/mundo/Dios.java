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
package uniandes.cupi2.visorMitologias.mundo;

/**
 * Clase que representa un dios.
 */
public class Dios  
{
	//-------------------------------------------------------------
	// Atributos
	//-------------------------------------------------------------
		
    /**
     * Nombre del dios.
     */
    private String nombre;
    
    /**
     * Descripci�n del dios.
     */
    private String descripcion;
    
    /**
     * Especialidad del dios.
     */
    private String especialidad;
    
    /**
     * Ruta de la imagen del dios.
     */
    private String rutaImagen;
    
    /**
     * Detemina si el dios es principal o no.
     */
    private boolean esPrincipal;
    
    //-------------------------------------------------------------
    // Constructores
    //-------------------------------------------------------------
    
    /**
     * Construye un nuevo dios con la informaci�n dada por par�metro.<br>
     * @param pNombre Nombre del dios. pNombre != null && pNombre != "".
     * @param pDescripcion Descripci�n del dios. pDescripcion != null && pDescripcion != ""
     * @param pEspecialidad Especialidad del dios. pEspecialidad != null && pEspecialidad != ""
     * @param pRutaImagen Ruta de la imagen del dios. pRutaImagen != null && pRutaImagen != ""
     * @param pEsPrincipal True si el dios es principal, false de lo contrario.
     */
    public Dios( String pNombre, String pDescripcion, String pEspecialidad, String pRutaImagen, boolean pEsPrincipal )
    {
        nombre = pNombre;
        descripcion = pDescripcion;
        especialidad = pEspecialidad;
        rutaImagen = pRutaImagen;
        esPrincipal = pEsPrincipal;
    }
    
	//-------------------------------------------------------------
	// M�todos
	//-------------------------------------------------------------
	
    /**
     * Retorna el nombre del dios.
     * @return Nombre del dios.
     */
    public String darNombre( )
    {
        return nombre;
    }
    
    /**
     * Retorna la descripci�n del dios.
     * @return Descripci�n del dios con formato html para alinearlo.
     */
    public String darDescripcion( )
    {
        return descripcion;
    }

    /**
     * Retorna la especialidad.
     * @return Especialidad del dios.
     */
    public String darEspecialidad( )
    {
        return especialidad;
    }
    
    /**
     * Retorna la ruta de la imagen del dios.
     * @return Ruta de la imagen del dios.
     */
    public String darRutaImagen( )
    {
        return rutaImagen;
    }
    
    /**
     * Retorna si el dios es principal o no.
     * @return True si el dios es principal, false de lo contrario.
     */
    public boolean darEsPrincipal( )
    {
    	return esPrincipal;
    }
}