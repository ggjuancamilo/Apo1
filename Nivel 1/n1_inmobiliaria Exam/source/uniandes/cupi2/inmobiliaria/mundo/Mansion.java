/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_inmobiliaria
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.inmobiliaria.mundo;

/**
 * Clase que representa una mansi�n de la inmobiliaria
 */

public class Mansion
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * N�mero de habitantes de la mansi�n.
     */
    private int habitantes;

    /**
     * N�mero de parqueaderos de la mansi�n
     */
    private int numParqueaderos;

    /**
     * N�mero de empleados de la mansi�n.
     */
    private int numEmpleados;

    /**
     * Precio de la mansi�n en d�lares.
     */
    private int precio;
    // TODO Declarar el atributo para modelar el precio de la mansi�n (valor entero).

    /**
     * Tama�o de la mansi�n en metros cuadrados.
     */
    private int tamanio;
    // TODO Declarar el atributo para modelar el tama�o de la mansi�n (valor entero).
    
    //hecho en el exam
    /**
     * cantidad de arboles que tiene la mansion
     */
    private double numArboles;


    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Inicializa los datos de la mansi�n <br>
     * <b>post: </b> El n�mero de habitantes se inicializ� en cero. <br>
     * El n�mero de parqueaderos se inicializ� en cero. <br>
     * El n�mero de empleados se inicializ� en cero. <br>
     * El precio se inicializ� en cero. <br>
     * El tama�o se inicializ� en cero. <br>
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
       
    	//TODO Completar el m�todo seg�n la documentaci�n. El precio y tama�o
    	//deben inicializarse en cero.
        
        // hecho en el exam
        numArboles = (int)(Math.random()*100);
        
    }

    /**
     * Devuelve el n�mero de habitantes.
     * @return Cantidad de habitantes que viven en la mansi�n.
     */
    public int darHabitantes( )
    {
        return habitantes;
    }

    /**
     * Devuelve el n�mero de empleados que tiene la mansi�n.
     * @return El n�mero de empleados de la mansi�n.
     */
    public int darEmpleados( )
    {
    	
    	return numEmpleados;
    	//TODO Implementar el m�todo seg�n la documentaci�n  
    }

    /**
	 * Devuelve el n�mero de parqueaderos que tiene la mansi�n.
	 * @return N�mero de parqueaderos que tiene la mansi�n.
	 */
	public int darParqueaderos( )
	{
	    return numParqueaderos;
	}

	/**
	 * Devuelve el precio de la mansi�n.
	 * @return El precio de la mansi�n en d�lares.
	 */
	public int darPrecio( )
	{
	    return precio;
	}

	/**
	 * Devuelve el tama�o de la mansi�n.
	 * @return Devuelve el tama�o de la mansi�n.
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
	 * Actualiza el n�mero de habitantes. <br>
	 * <b>post: </b> Se modific� el n�mero de habitantes con el valor dado por par�metro.
	 * @param pHabitantes Nuevo n�mero de habitantes de la mansi�n.
	 */
	public void modificarHabitantes( int pHabitantes )
	{
	    habitantes = pHabitantes;
	}

	/**
     * Actualiza el n�mero de empleados de mansi�n.<br>
     * <b>post: </b> Se modific� el n�mero de empleados con el valor dado por par�metro.
     * @param pNumEmpleados Nuevo n�mero de empleados de la mansi�n.
     */
    public void modificarNumeroEmpleados( int pNumEmpleados )
    {
        numEmpleados = pNumEmpleados;
    }

    /**
     * Actualiza el n�mero de parqueaderos que tiene la mansi�n. <br>
     * <b>post: </b> Se modific� el n�mero de parqueaderos con el valor dado por par�metro.
     * @param pNumParqueaderos Nuevo n�mero de parqueaderos que tiene la mansi�n.
     */
    public void modificarNumeroParqueaderos( int pNumParqueaderos )
    {
        numParqueaderos = pNumParqueaderos;
    }

    /**
     * Actualiza el precio de la mansi�n.<br>
     * <b>post: </b> Se modific� el precio de la mansi�n con el valor dado por par�metro.
     * @param pPrecio Nuevo precio de la mansi�n.
     */
    public void modificarPrecio( int pPrecio )
    {
        precio = pPrecio;
    }

    /**
     * Actualiza el tama�o de la mansi�n. <br>
     * <b>post: </b> Se modific� el tama�o de la mansi�n con el valor dado por par�metro.
     * @param pTamanio El nuevo tama�o de la mansi�n.
     */
    public void modificarTamanio( int pTamanio )
    {
    	tamanio = pTamanio;
    	//TODO Implementar el m�todo seg�n la documentaci�n  
    }

    /**
     * Calcula el costo de limpieza de la mansi�n.
     * @return Costo de limpieza de la mansi�n.
     */
    public int calcularCostoLimpieza( )
    {
        return (habitantes * 250) + (numEmpleados * 3000) + (tamanio * 500);
    }

    /**
     * Calcula el costo por servicios p�blicos de la mansi�n.
     * @return Costo por servicios de la mansi�n.
     */
    public double calcularCostoServicios( )
    {
    	return (habitantes * 5000 + precio * 0.02);
    	// 
    	//TODO Implementar el m�todo seg�n la documentaci�n  
    }

    /**
     * Calcula el costo de seguridad de la mansi�n.
     * @return Costo de seguridad de la mansi�n.
     */
    public int calcularCostoSeguridad( )
    {
    	return (numParqueaderos * 450 + tamanio * 500);
    	//TODO Implementar el m�todo seg�n la documentaci�n  
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