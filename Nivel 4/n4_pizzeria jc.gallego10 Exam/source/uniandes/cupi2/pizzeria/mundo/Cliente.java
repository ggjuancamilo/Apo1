/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_pizzeria
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.pizzeria.mundo;

/**
 * Clase que representa un cliente de la pizzer�a.
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
     * C�dula del cliente.
     */
    private int cedula;

    /**
     * Tel�fono del cliente.
     */
    private int telefono;

    /**
     * Direcci�n del cliente.
     */
    private String direccion;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    
    /**
     * Construye un cliente con los valores dados por par�metro.
     * @param pNombre Nombre del cliente. pNombre != null && pNombre != "".
     * @param pCedula C�dula del cliente. pCedula > 0.
     * @param pTelefono Tel�fono del cliente.  pTelefono > 0.
     * @param pDireccion Direcci�n del cliente. pDireccion != null && pDireccion != "".
     */
    public Cliente (String pNombre, int pCedula, int pTelefono, String pDireccion)
    {
        nombre = pNombre;
        cedula = pCedula;
        telefono = pTelefono;
        direccion = pDireccion;
    }
    
    // -----------------------------------------------------------------
    // M�todos
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
     * Retorna la c�dula del cliente. <br>
     * @return C�dula del cliente.
     */
    public int darCedula( )
    {
        return cedula;
    }
    
    /**
     * Retorna el tel�fono del cliente. <br>
     * @return Tel�fono del cliente.
     */
    public int darTelefono( )
    {
        return telefono;
    }

    /**
     * Retorna la direcci�n del cliente. <br>
     * @return Direcci�n del cliente.
     */
    public String darDireccion( )
    {
        return direccion;
    }
    
    

}
