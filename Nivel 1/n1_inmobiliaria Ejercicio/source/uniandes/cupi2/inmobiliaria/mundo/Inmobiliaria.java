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
 * Clase que representa la inmobiliaria que administra las 3 mansiones.
 */
public class Inmobiliaria
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Representa la mansión número 1.
     */
    private Mansion mansion1;

    /**
     * Representa la mansión número 2.
     */
    private Mansion mansion2;
    // TODO Declarar el atributo para modelar la mansión número 2.

    /**
     * Representa la mansión número 3.
     */
    private Mansion mansion3;
 // TODO Declarar el atributo para modelar la mansión número 3.

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa las tres mansiones con sus datos en cero.<br>
     * <b>post: </b> Se inicializaron las tres mansiones.
     */
    public void inicializar( )
    {
        // Inicializa la mansión 1
        mansion1 = new Mansion( );
        mansion1.inicializar( );

        // Inicializa la mansión 2
        // TODO Crear e inicializar la mansión número 2.

        mansion2 = new Mansion();
        mansion2.inicializar();
        
        
        // Inicializa la mansión 3
        
        mansion3 = new Mansion();
        mansion3.inicializar();
        // TODO Crear e inicializar la mansión número 3.

    }

    /**
     * Devuelve la mansión 1.
     * @return Mansión 1.
     */
    public Mansion darMansion1( )
    {
        return mansion1;
    }

    /**
     * Devuelve la mansión 2.
     * @return Mansión 2.
     */
    public Mansion darMansion2( )
    {
    	return mansion2;
    	//TODO Completar el método según la documentación.
    }

    /**
     * Devuelve la mansión 3.
     * @return Mansión 3.
     */
    public Mansion darMansion3( )
    {
    	return mansion3;
    	
    	//TODO Completar el método según la documentación.
    }

    /**
     * Actualiza los datos de la mansión 1.<br>
     * <b>post: </b> Se modificó el número de habitantes de la mansión 1.<br>
     * Se modificó el número de parqueaderos de la mansión 1.<br>
     * Se modificó el número de empleados de la mansión 1. <br>
     * Se modificó el precio de la mansión 1.<br>
     * Se modificó el tamaño de la mansión 1. <br>
     * @param habitantes Nuevo número de habitantes de la mansión 1.
     * @param numParqueaderos Nuevo número de parqueaderos de la mansión 1.
     * @param numEmpleados Nuevo número de empleados de la mansión 1.
     * @param precio Nuevo precio de la mansión 1.
     * @param tamanio Nuevo tamaño de la mansión 1.
     */
    public void actualizarDatosMansion1( int habitantes, int numParqueaderos, int numEmpleados, int precio, int tamanio )
    {
        mansion1.modificarHabitantes( habitantes );
        mansion1.modificarNumeroParqueaderos( numParqueaderos );
        mansion1.modificarNumeroEmpleados( numEmpleados );
        mansion1.modificarPrecio( precio );
        mansion1.modificarTamanio( tamanio );

    }

    /**
     * Actualiza los datos de la mansión 2.<br>
     * <b>post: </b> Se modificó el número de habitantes de la mansión 2.<br>
     * Se modificó el número de parqueaderos de la mansión 2. <br>
     * Se modificó el número de empleados de la mansión 2.<br>
     * Se modificó el precio de la mansión 2. <br>
     * Se modificó el tamaño de la mansión 2.<br>
     * @param habitantes Nuevo número de habitantes de la mansión 2.
     * @param numParqueaderos Nuevo número de parqueaderos de la mansión 2.
     * @param numEmpleados Nuevo número de empleados de la mansión 2.
     * @param precio Nuevo precio de la mansión 2.
     * @param tamanio Nuevo tamaño de la mansión 2.
     */
    public void actualizarDatosMansion2( int habitantes, int numParqueaderos, int numEmpleados, int precio, int tamanio )
    {
    	mansion2.modificarHabitantes( habitantes );
        mansion2.modificarNumeroParqueaderos( numParqueaderos );
        mansion2.modificarNumeroEmpleados( numEmpleados );
        mansion2.modificarPrecio( precio );
        mansion2.modificarTamanio( tamanio );
    	//TODO Completar el método según la documentación.
    }

    /**
     * Actualiza los datos de la mansión 3.<br>
     * <b>post: </b> Se modificó el número de habitantes de la mansión 3.<br>
     * Se modificó el número de parqueaderos de la mansión 3. <br>
     * Se modificó el número de empleados de la mansión 3.<br>
     * Se modificó el precio de la mansión 3. <br>
     * Se modificó el tamaño de la mansión 3.<br>
     * @param habitantes Nuevo número de habitantes de la mansión 3.
     * @param numParqueaderos Nuevo número de parqueaderos de la mansión 3.
     * @param numEmpleados Nuevo número de empleados de la mansión 3.
     * @param precio Nuevo precio de la mansión 3.
     * @param tamanio Nuevo tamaño de la mansión 3.
     */
    public void actualizarDatosMansion3( int habitantes, int numParqueaderos, int numEmpleados, int precio, int tamanio )
    {
    	mansion3.modificarHabitantes( habitantes );
        mansion3.modificarNumeroParqueaderos( numParqueaderos );
        mansion3.modificarNumeroEmpleados( numEmpleados );
        mansion3.modificarPrecio( precio );
        mansion3.modificarTamanio( tamanio );
    	//TODO Completar el método según la documentación.
    }

    /**
     * Calcula el costo total de administración de las tres mansiones.
     * @return Costo por el concepto de administración en dólares
     */
    public double calcularCostoAdministracion( )
    {
    	return (0.25 * ( mansion1.calcularCostoLimpieza() + mansion2.calcularCostoLimpieza() + mansion3.calcularCostoLimpieza()) 
    			+ 0.1 * (mansion1.calcularCostoSeguridad() + mansion2.calcularCostoSeguridad() + mansion3.calcularCostoSeguridad()));
    	//TODO Completar el método según la documentación.
    }

    /**
     * Calcula el costo promedio por servicios públicos.
     * @return Costo promedio por servicios públicos en dólares.
     */
    public double calcularCostoPromedioServicios( )
    {
    	return ((mansion1.calcularCostoServicios()+mansion2.calcularCostoServicios()+mansion3.calcularCostoServicios())/3);
    	//TODO Completar el método según la documentación.
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     * @return respuesta1.
     */
    public String metodo1( )
    {
        return "Respuesta 1.";
    }

    /**
     * Método para la extensión2.
     * @return respuesta2.
     */
    public String metodo2( )
    {
        return "Respuesta 2.";
    }
}