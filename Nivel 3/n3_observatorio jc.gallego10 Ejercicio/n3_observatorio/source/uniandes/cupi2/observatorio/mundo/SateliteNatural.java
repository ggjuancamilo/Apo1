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

/**
 * Clase que representa un sat�lite natural de un planeta.
 */
public class SateliteNatural
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Nombre del sat�lite natural.
     */
    private String nombre;

    /**
     * Excentricidad del sat�lite natural.
     */
    private double excentricidad;

    /**
     * Inclinaci�n orbital del sat�lite natural.
     */
    private double inclinacionOrbital;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un sat�lite natural con los datos suministrados por par�metro.
     * @param pNombre Nombre del sat�lite natural.
     * @param pExcentricidad Excentricidad del sat�lite natural.
     * @param pInclinacion Inclinaci�n orbital del sat�lite natural.
     */
    public SateliteNatural( String pNombre, double pExcentricidad, double pInclinacion )
    {
        nombre = pNombre;   
        excentricidad = pExcentricidad;
        inclinacionOrbital = pInclinacion;
    }

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Devuelve el nombre del sat�lite natural.
     * @return Nombre del sat�lite natural.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Devuelve la excentricidad del sat�lite natural.
     * @return Excentricidad del sat�lite natural.
     */
    public double darExcentricidad( )
    {
        return excentricidad;
    }

    /**
     * Devuelve la inclinaci�n del sat�lite natural.
     * @return Inclinaci�n orbital del sat�lite natural.
     */
    public double darInclinacion( )
    {
        return inclinacionOrbital;
    }

    /**
     * Edita la excentricidad e inclinaci�n orbital del sat�lite natural.
     * @param pExcentricidad Nueva excentricidad del sat�lite natural.
     * @param pInclinacion Nueva inclinaci�n orbital del sat�lite natural.
     */
    public void editarSatelite( double pExcentricidad , double pInclinacion)
    {
        excentricidad = pExcentricidad;
        inclinacionOrbital = pInclinacion;
    }
    
    /**
     * M�todo que devuelve las propiedades  del sat�lite natural.
     * @return Cadena con las propiedades  del sat�lite natural.
     */
    public String toString(){
    	return this.darNombre( ) +" - Excentricidad: "+ this.darExcentricidad() + " Inclinaci�n: " +this.darInclinacion()+"�";
    }

}
