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
 * Clase que representa la inmobiliaria que administra las 3 mansiones.
 */
public class Inmobiliaria
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Representa la mansi�n n�mero 1.
     */
    private Mansion mansion1;

    /**
     * Representa la mansi�n n�mero 2.
     */
    private Mansion mansion2;
    // TODO Declarar el atributo para modelar la mansi�n n�mero 2.

    /**
     * Representa la mansi�n n�mero 3.
     */
    private Mansion mansion3;
 // TODO Declarar el atributo para modelar la mansi�n n�mero 3.

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Inicializa las tres mansiones con sus datos en cero.<br>
     * <b>post: </b> Se inicializaron las tres mansiones.
     */
    public void inicializar( )
    {
        // Inicializa la mansi�n 1
        mansion1 = new Mansion( );
        mansion1.inicializar( );

        // Inicializa la mansi�n 2
        // TODO Crear e inicializar la mansi�n n�mero 2.

        mansion2 = new Mansion();
        mansion2.inicializar();
        
        
        // Inicializa la mansi�n 3
        
        mansion3 = new Mansion();
        mansion3.inicializar();
        // TODO Crear e inicializar la mansi�n n�mero 3.

    }

    /**
     * Devuelve la mansi�n 1.
     * @return Mansi�n 1.
     */
    public Mansion darMansion1( )
    {
        return mansion1;
    }

    /**
     * Devuelve la mansi�n 2.
     * @return Mansi�n 2.
     */
    public Mansion darMansion2( )
    {
    	return mansion2;
    	//TODO Completar el m�todo seg�n la documentaci�n.
    }

    /**
     * Devuelve la mansi�n 3.
     * @return Mansi�n 3.
     */
    public Mansion darMansion3( )
    {
    	return mansion3;
    	
    	//TODO Completar el m�todo seg�n la documentaci�n.
    }

    /**
     * Actualiza los datos de la mansi�n 1.<br>
     * <b>post: </b> Se modific� el n�mero de habitantes de la mansi�n 1.<br>
     * Se modific� el n�mero de parqueaderos de la mansi�n 1.<br>
     * Se modific� el n�mero de empleados de la mansi�n 1. <br>
     * Se modific� el precio de la mansi�n 1.<br>
     * Se modific� el tama�o de la mansi�n 1. <br>
     * @param habitantes Nuevo n�mero de habitantes de la mansi�n 1.
     * @param numParqueaderos Nuevo n�mero de parqueaderos de la mansi�n 1.
     * @param numEmpleados Nuevo n�mero de empleados de la mansi�n 1.
     * @param precio Nuevo precio de la mansi�n 1.
     * @param tamanio Nuevo tama�o de la mansi�n 1.
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
     * Actualiza los datos de la mansi�n 2.<br>
     * <b>post: </b> Se modific� el n�mero de habitantes de la mansi�n 2.<br>
     * Se modific� el n�mero de parqueaderos de la mansi�n 2. <br>
     * Se modific� el n�mero de empleados de la mansi�n 2.<br>
     * Se modific� el precio de la mansi�n 2. <br>
     * Se modific� el tama�o de la mansi�n 2.<br>
     * @param habitantes Nuevo n�mero de habitantes de la mansi�n 2.
     * @param numParqueaderos Nuevo n�mero de parqueaderos de la mansi�n 2.
     * @param numEmpleados Nuevo n�mero de empleados de la mansi�n 2.
     * @param precio Nuevo precio de la mansi�n 2.
     * @param tamanio Nuevo tama�o de la mansi�n 2.
     */
    public void actualizarDatosMansion2( int habitantes, int numParqueaderos, int numEmpleados, int precio, int tamanio )
    {
    	mansion2.modificarHabitantes( habitantes );
        mansion2.modificarNumeroParqueaderos( numParqueaderos );
        mansion2.modificarNumeroEmpleados( numEmpleados );
        mansion2.modificarPrecio( precio );
        mansion2.modificarTamanio( tamanio );
    	//TODO Completar el m�todo seg�n la documentaci�n.
    }

    /**
     * Actualiza los datos de la mansi�n 3.<br>
     * <b>post: </b> Se modific� el n�mero de habitantes de la mansi�n 3.<br>
     * Se modific� el n�mero de parqueaderos de la mansi�n 3. <br>
     * Se modific� el n�mero de empleados de la mansi�n 3.<br>
     * Se modific� el precio de la mansi�n 3. <br>
     * Se modific� el tama�o de la mansi�n 3.<br>
     * @param habitantes Nuevo n�mero de habitantes de la mansi�n 3.
     * @param numParqueaderos Nuevo n�mero de parqueaderos de la mansi�n 3.
     * @param numEmpleados Nuevo n�mero de empleados de la mansi�n 3.
     * @param precio Nuevo precio de la mansi�n 3.
     * @param tamanio Nuevo tama�o de la mansi�n 3.
     */
    public void actualizarDatosMansion3( int habitantes, int numParqueaderos, int numEmpleados, int precio, int tamanio )
    {
    	mansion3.modificarHabitantes( habitantes );
        mansion3.modificarNumeroParqueaderos( numParqueaderos );
        mansion3.modificarNumeroEmpleados( numEmpleados );
        mansion3.modificarPrecio( precio );
        mansion3.modificarTamanio( tamanio );
    	//TODO Completar el m�todo seg�n la documentaci�n.
    }

    /**
     * Calcula el costo total de administraci�n de las tres mansiones.
     * @return Costo por el concepto de administraci�n en d�lares
     */
    public double calcularCostoAdministracion( )
    {
    	return (0.25 * ( mansion1.calcularCostoLimpieza() + mansion2.calcularCostoLimpieza() + mansion3.calcularCostoLimpieza()) 
    			+ 0.1 * (mansion1.calcularCostoSeguridad() + mansion2.calcularCostoSeguridad() + mansion3.calcularCostoSeguridad()));
    	//TODO Completar el m�todo seg�n la documentaci�n.
    }

    /**
     * Calcula el costo promedio por servicios p�blicos.
     * @return Costo promedio por servicios p�blicos en d�lares.
     */
    public double calcularCostoPromedioServicios( )
    {
    	return ((mansion1.calcularCostoServicios()+mansion2.calcularCostoServicios()+mansion3.calcularCostoServicios())/3);
    	//TODO Completar el m�todo seg�n la documentaci�n.
    }

    //hecho en el exam
      
    /**
     * devulve la utilidad relativa de las mansiones
     * @return la utilidad relativa de las mansiones
     */
    public double calcularUtilidadRelativa()
    {
    	return mansion1.calcularBonoEcologico() + mansion2.calcularBonoEcologico() + mansion3.calcularBonoEcologico();
    }
    
    //hecho en el exam
    
    public double descuentoRelativoMansion1()
    {
    	return mansion1.calcularBonoEcologico()/calcularUtilidadRelativa();
    }
    
    //hecho en el exam
    
    public double descuentoRelativoMansion2()
    {
    	return mansion2.calcularBonoEcologico()/calcularUtilidadRelativa();
    }
    
    
    //hecho en el exam
    
    public double descuentoRelativoMansion3()
    {
    	return mansion3.calcularBonoEcologico()/calcularUtilidadRelativa();
    }
    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1.
     * @return respuesta1.
     */
    public String metodo1( )
    {
        return "Mansi�n 1: "+ mansion1.darNumArboles() + " �rboles. Bono relativo = " + descuentoRelativoMansion1() + '\n' +
        		"Mansi�n 2: "+ mansion2.darNumArboles() + " �rboles. Bono relativo = " + descuentoRelativoMansion2() + '\n' + 
        		"Mansi�n 3: "+ mansion3.darNumArboles() + " �rboles. Bono relativo = " + descuentoRelativoMansion3();
    }

    /**
     * M�todo para la extensi�n2.
     * @return respuesta2.
     */
    public String metodo2( )
    {
        return "Mansi�n 1: "+ mansion1.darNumArboles() + " �rboles. Bono ecologico = " + mansion1.calcularBonoEcologico() + '\n' +
        		"Mansi�n 2: "+ mansion2.darNumArboles() + " �rboles. Bono ecologico = " + mansion2.calcularBonoEcologico() + '\n' + 
        		"Mansi�n 3: "+ mansion3.darNumArboles() + " �rboles. Bono ecologico = " + mansion3.calcularBonoEcologico();
    }
}