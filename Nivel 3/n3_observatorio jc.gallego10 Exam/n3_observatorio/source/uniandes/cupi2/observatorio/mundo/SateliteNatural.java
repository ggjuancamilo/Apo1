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

/**
 * Clase que representa un satélite natural de un planeta.
 */
public class SateliteNatural
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Nombre del satélite natural.
     */
    private String nombre;

    /**
     * Excentricidad del satélite natural.
     */
    private double excentricidad;

    /**
     * Inclinación orbital del satélite natural.
     */
    private double inclinacionOrbital;

    /**
     * densidad del satelite.
     */
    private double densidad;
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un satélite natural con los datos suministrados por parámetro.
     * @param pNombre Nombre del satélite natural.
     * @param pExcentricidad Excentricidad del satélite natural.
     * @param pInclinacion Inclinación orbital del satélite natural.
     */
    public SateliteNatural( String pNombre, double pExcentricidad, double pInclinacion )
    {
        nombre = pNombre;   
        excentricidad = pExcentricidad;
        inclinacionOrbital = pInclinacion;
        densidad = 0.2+(double)(Math.random()*99.8);
    }

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Devuelve el nombre del satélite natural.
     * @return Nombre del satélite natural.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Devuelve la excentricidad del satélite natural.
     * @return Excentricidad del satélite natural.
     */
    public double darExcentricidad( )
    {
        return excentricidad;
    }

    /**
     * Devuelve la inclinación del satélite natural.
     * @return Inclinación orbital del satélite natural.
     */
    public double darInclinacion( )
    {
        return inclinacionOrbital;
    }

    /**
     * Edita la excentricidad e inclinación orbital del satélite natural.
     * @param pExcentricidad Nueva excentricidad del satélite natural.
     * @param pInclinacion Nueva inclinación orbital del satélite natural.
     */
    public void editarSatelite( double pExcentricidad , double pInclinacion)
    {
        excentricidad = pExcentricidad;
        inclinacionOrbital = pInclinacion;
    }
    
    /**
     * devuelve la densidad del planeta.
     * @return Densidad del satelite.
     */
    public double darDensidad()
    {
    	return densidad;
    }
    /**
     * Método que devuelve las propiedades  del satélite natural.
     * @return Cadena con las propiedades  del satélite natural.
     */
    public String toString(){
    	return this.darNombre( ) +" - Excentricidad: "+ this.darExcentricidad() + " Inclinación: " +this.darInclinacion()+"°"+ " Dencidad: " + this.darDensidad();
    }

}
