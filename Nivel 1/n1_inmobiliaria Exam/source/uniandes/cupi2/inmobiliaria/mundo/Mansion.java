/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_inmobiliaria
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.inmobiliaria.mundo;

/**
 * Clase que representa una mansión de la inmobiliaria
 */

public class Mansion
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Número de habitantes de la mansión.
     */
    private int habitantes;

    /**
     * Número de parqueaderos de la mansión
     */
    private int numParqueaderos;

    /**
     * Número de empleados de la mansión.
     */
    private int numEmpleados;

    /**
     * Precio de la mansión en dólares.
     */
    private int precio;
    // TODO Declarar el atributo para modelar el precio de la mansión (valor entero).

    /**
     * Tamaño de la mansión en metros cuadrados.
     */
    private int tamanio;
    // TODO Declarar el atributo para modelar el tamaño de la mansión (valor entero).
    
    //hecho en el exam
    /**
     * cantidad de arboles que tiene la mansion
     */
    private double numArboles;


    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa los datos de la mansión <br>
     * <b>post: </b> El número de habitantes se inicializó en cero. <br>
     * El número de parqueaderos se inicializó en cero. <br>
     * El número de empleados se inicializó en cero. <br>
     * El precio se inicializó en cero. <br>
     * El tamaño se inicializó en cero. <br>
     * 
     * el numero de arboles se incializo aleatoriamente entre 0 y 100 . <br>
     */
    public void inicializar( )
    {
        habitantes = 0;
        numParqueaderos = 0;
        numEmpleados = 0;
        
        precio = 0;
        tamanio = 0;
       
    	//TODO Completar el método según la documentación. El precio y tamaño
    	//deben inicializarse en cero.
        
        // hecho en el exam
        numArboles = (int)(Math.random()*100);
        
    }

    /**
     * Devuelve el número de habitantes.
     * @return Cantidad de habitantes que viven en la mansión.
     */
    public int darHabitantes( )
    {
        return habitantes;
    }

    /**
     * Devuelve el número de empleados que tiene la mansión.
     * @return El número de empleados de la mansión.
     */
    public int darEmpleados( )
    {
    	
    	return numEmpleados;
    	//TODO Implementar el método según la documentación  
    }

    /**
	 * Devuelve el número de parqueaderos que tiene la mansión.
	 * @return Número de parqueaderos que tiene la mansión.
	 */
	public int darParqueaderos( )
	{
	    return numParqueaderos;
	}

	/**
	 * Devuelve el precio de la mansión.
	 * @return El precio de la mansión en dólares.
	 */
	public int darPrecio( )
	{
	    return precio;
	}

	/**
	 * Devuelve el tamaño de la mansión.
	 * @return Devuelve el tamaño de la mansión.
	 */
	public int darTamanio( )
	{
	    return tamanio;
	}
	
	/**
	 * devulve el numero de arboles de la mansion.
	 * 
	 * @return numero de arboles de la mansion.
	 */
	// hecho en el exam
	public double darNumArboles  ()
	{
		return numArboles;
	}

	/**
	 * Actualiza el número de habitantes. <br>
	 * <b>post: </b> Se modificó el número de habitantes con el valor dado por parámetro.
	 * @param pHabitantes Nuevo número de habitantes de la mansión.
	 */
	public void modificarHabitantes( int pHabitantes )
	{
	    habitantes = pHabitantes;
	}

	/**
     * Actualiza el número de empleados de mansión.<br>
     * <b>post: </b> Se modificó el número de empleados con el valor dado por parámetro.
     * @param pNumEmpleados Nuevo número de empleados de la mansión.
     */
    public void modificarNumeroEmpleados( int pNumEmpleados )
    {
        numEmpleados = pNumEmpleados;
    }

    /**
     * Actualiza el número de parqueaderos que tiene la mansión. <br>
     * <b>post: </b> Se modificó el número de parqueaderos con el valor dado por parámetro.
     * @param pNumParqueaderos Nuevo número de parqueaderos que tiene la mansión.
     */
    public void modificarNumeroParqueaderos( int pNumParqueaderos )
    {
        numParqueaderos = pNumParqueaderos;
    }

    /**
     * Actualiza el precio de la mansión.<br>
     * <b>post: </b> Se modificó el precio de la mansión con el valor dado por parámetro.
     * @param pPrecio Nuevo precio de la mansión.
     */
    public void modificarPrecio( int pPrecio )
    {
        precio = pPrecio;
    }

    /**
     * Actualiza el tamaño de la mansión. <br>
     * <b>post: </b> Se modificó el tamaño de la mansión con el valor dado por parámetro.
     * @param pTamanio El nuevo tamaño de la mansión.
     */
    public void modificarTamanio( int pTamanio )
    {
    	tamanio = pTamanio;
    	//TODO Implementar el método según la documentación  
    }

    /**
     * Calcula el costo de limpieza de la mansión.
     * @return Costo de limpieza de la mansión.
     */
    public int calcularCostoLimpieza( )
    {
        return (habitantes * 250) + (numEmpleados * 3000) + (tamanio * 500);
    }

    /**
     * Calcula el costo por servicios públicos de la mansión.
     * @return Costo por servicios de la mansión.
     */
    public double calcularCostoServicios( )
    {
    	return (habitantes * 5000 + precio * 0.02);
    	// 
    	//TODO Implementar el método según la documentación  
    }

    /**
     * Calcula el costo de seguridad de la mansión.
     * @return Costo de seguridad de la mansión.
     */
    public int calcularCostoSeguridad( )
    {
    	return (numParqueaderos * 450 + tamanio * 500);
    	//TODO Implementar el método según la documentación  
    }
    
    // hecho en el exam
    /**
     * calcula el bono ecologico de la mansion
     * @return el bono ecologico de la mansion
     */
    public double calcularBonoEcologico ()
    {
    	System.out.println(precio  * 0.05 * (tamanio/numArboles));
    	return (precio  * 0.05 * (numArboles/tamanio));
    }
}