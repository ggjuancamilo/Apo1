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
 * Clase que representa un producto de la pizzer�a.
 */
public class Producto
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * 
     */
    private String nombre;
    // TODO Declarar y documentar el atributo que modela el nombre del producto.

    
    /**
     * 
     */
    private double precio;
    // TODO Declarar y documentar el atributo que modela el precio del producto.
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un producto con los valores dados por par�metro. Inicializa los atributos de la clase con los par�metros dados.
     * @param pNombre Nombre del producto. pNombre != null && pNombre != "".
     * @param pPrecio Precio del producto.
     * @throws Exception Si el precio del producto pasado por par�metro es menor o igual a cero.
     */
    public Producto( String pNombre, double pPrecio ) throws Exception
    {
        nombre = pNombre;
        if (pPrecio > 0)
        {
            precio = pPrecio;
        }
        else
        {
            throw new Exception( "el valor del producto debe ser mayor a cero." );
        }
        // TODO Completar el contructor para inicializar el precio, si pPrecio es menor o igual a cero lanza excepci�n.
        
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del producto. <br>
     * @return Nombre del producto.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna el precio del producto. <br>
     * @return Precio del producto.
     */
    public double darPrecio( )
    {
        return precio;
    }

}
