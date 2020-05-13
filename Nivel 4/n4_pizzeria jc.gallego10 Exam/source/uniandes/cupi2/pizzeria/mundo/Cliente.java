/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_pizzeria
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.pizzeria.mundo;

/**
 * Clase que representa un cliente de la pizzería.
 */
public class Cliente
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del cliente.
     */
    private String nombre;

    /**
     * Cédula del cliente.
     */
    private int cedula;

    /**
     * Teléfono del cliente.
     */
    private int telefono;

    /**
     * Dirección del cliente.
     */
    private String direccion;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    
    /**
     * Construye un cliente con los valores dados por parámetro.
     * @param pNombre Nombre del cliente. pNombre != null && pNombre != "".
     * @param pCedula Cédula del cliente. pCedula > 0.
     * @param pTelefono Teléfono del cliente.  pTelefono > 0.
     * @param pDireccion Dirección del cliente. pDireccion != null && pDireccion != "".
     */
    public Cliente (String pNombre, int pCedula, int pTelefono, String pDireccion)
    {
        nombre = pNombre;
        cedula = pCedula;
        telefono = pTelefono;
        direccion = pDireccion;
    }
    
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    
    /**
     * Retorna el nombre del cliente. <br>
     * @return Nombre del cliente
     */
    public String darNombre( )
    {
        return nombre;
    }
    
    /**
     * Retorna la cédula del cliente. <br>
     * @return Cédula del cliente.
     */
    public int darCedula( )
    {
        return cedula;
    }
    
    /**
     * Retorna el teléfono del cliente. <br>
     * @return Teléfono del cliente.
     */
    public int darTelefono( )
    {
        return telefono;
    }

    /**
     * Retorna la dirección del cliente. <br>
     * @return Dirección del cliente.
     */
    public String darDireccion( )
    {
        return direccion;
    }
    
    

}
