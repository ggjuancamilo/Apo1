/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_barcoPirata 
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.barcoPirata.mundo;

/**
 * Clase que representa un contenedor del barco pirata.
 */
public class Contenedor
{

    // ---------------------------------------------------------------------
    // Constantes
    // ---------------------------------------------------------------------

	/**
	 * Constante que determina que el contenedor está vacío
	 */
	public static final int SIN_CARGA = 0;
	
    /**
     * Constante que determina el tipo de carga peligrosa.
     */
    public static final int CARGA_PELIGROSA = 1;

    /**
     * Constante que determina el tipo de carga perecedera.
     */
    
    public static final int CARGA_PERECEDERA = 2;
    
    //TODO Declare la constante CARGA_PERECEDERA

    /**
     * Constante que determina el tipo de carga no perecedera.
     */
    
    public static final int CARGA_NO_PERECEDERA = 3;
    
    //TODO Declare la constante CARGA_NO_PERECEDERA.

    /**
     * Nombre del pirata Barba Negra.
     */
    public static final String BARBA_NEGRA = "Barba Negra";
    
    /**
     * Nombre del pirata Francis Drake.
     */
    
    public static final String  FRANCIS_DRAKE = "Francis Drake";
    
    		
    //TODO Declare la constante FRANCIS_DRAKE.
    
    /**
     * Nombre del pirata Anne Bonny.
     */
    public static final String ANNE_BONNY = "Anne Bonny";
    
   //TODO Declare la constante ANNE_BONNY.
    
    /**
     * Nombre del pirata Davy Jones.
     */
    
    public static final String DAVY_JONES = "Davy Jones";
    //TODO Declare la constante DAVY_JONES.
    
    
    // examen
    
    /**
     * riesgo bajo
     */
    public static final int RIESGO_BAJO = 11;
    /**
     * riesgo medio
     */
    public static final int RIESGO_MEDIO = 12;
    /**
     * riesgo alto
     */
    public static final int RIESGO_ALTO = 13;
    
    
    
    
    
    // ---------------------------------------------------------------------
    // Atributos
    // ---------------------------------------------------------------------

    /**
     * Nombre del pirata dueño del contenedor.
     */
    
    private String nombrePirata;
    //TODO Declare el atributo que modela el pirata dueño del contenedor.

    /**
     * Número de cajas del contenedor.
     */
    private int numeroCajas;

    /**
     * Peso de cada caja del contenedor.
     */
    private double pesoPorCaja;
    //TODO Declare el atributo que modela peso por caja del contenedor.

    /**
     * Tipo de carga del contenedor.
     */
    private int tipoCarga;
    
    //TODO Declare el atributo que modela el tipo de carga del contenedor.

    // ---------------------------------------------------------------------
    // Constructores
    // ---------------------------------------------------------------------

    /**
     * Constructor de la clase carga. <br>
     * @param pNombrePirata Nombre del pirata dueño del contenedor.
     */
    public Contenedor(  String pNombrePirata )
    {
        nombrePirata = pNombrePirata;
        pesoPorCaja = 0;
        numeroCajas = 0;
        tipoCarga = SIN_CARGA;
        //TODO Inicialice el atributo pesoPorCaja en 0
        //TODO Inicialice el atributo numeroCajas en 0
        //TODO Inicialice el atributo tipoCarga como SIN_CARGA
    }
    
    // ---------------------------------------------------------------------
    // Métodos
    // ---------------------------------------------------------------------

    /**
     * Retorna el nombre del pirata dueño del contenedor.
     * @return Nombre del pirata dueño del contenedor.
     */
    public String darNombrePirata( )
    {
    	return nombrePirata;
    	// TODO: Complete el método según su documentación 
    }
    
    /**
	 * Retorna el número de cajas del contenedor.
	 * @return Número de cajas que hay en el contenedor.
	 */
	public int darNumeroCajas( )
	{
		return numeroCajas;
		// TODO: Complete el método según su documentación
	}
	
	/**
     * Retorna el peso de cada caja que hay en el contenedor.
     * @return Peso de cada caja del contenedor.
     */
    public double darPesoPorCaja( )
    {
    	return pesoPorCaja;
    	// TODO: Complete el método según su documentación
    }


    /**
     * Retorna el tipo de carga del contenedor.
     * @return Tipo de carga del contenedor.
     */
    public int darTipoCarga( )
    {
        return tipoCarga;
    }
    
    /**
     * Retorna el peso total del contenedor.
     * @return Peso total del contenedor.
     */
    public double darPesoContenedor()
    {
    	return pesoPorCaja * numeroCajas;
    } 
    
    /**
     * Carga el contenedor con los valores pasados por parámetro.
     * @param pNumeroCajas Número de cajas del contenedor.
     * @param pPesoPorCaja Peso de cada una de las cajas del contenedor.
     * @param pTipoCarga Tipo de la carga del contenedor.
     */
    public void cargar(int pNumeroCajas, double pPesoPorCaja, int pTipoCarga)
    {
    	
    	
        pesoPorCaja = pPesoPorCaja;
        numeroCajas = pNumeroCajas;
        tipoCarga = pTipoCarga;
    	// TODO: Asigne a los atributos del cargador, los respectivos valores dados por parámetro
    }
    
    /**
     * Descarga el contenedor.
     * post: El número de cajas y el peso por caja es 0. El tipo de carga es SIN_CARGA.
     */
    public void descargar()
    {
        numeroCajas = 0;
        pesoPorCaja = 0;
        tipoCarga = SIN_CARGA;
    	//TODO Inicialice el atributo pesoPorCaja en 0
        //TODO Inicialice el atributo numeroCajas en 0
        //TODO Inicialice el atributo tipoCarga como SIN_CARGA
    	    	
    }
    //EXAMEN
    
    /**
     * Me dice que riesgo es el contenedor
     * @return riesgo contenedor
     */
    public int darRiesgo ()
    {
    	int ries = 0;

    	if(numeroCajas<10)
    	{
    		ries = RIESGO_BAJO;
    	}
    	else if(tipoCarga == CARGA_NO_PERECEDERA)
    	{
    		ries = RIESGO_BAJO;
    	}
    	else if(tipoCarga == CARGA_PERECEDERA && numeroCajas >= 10  )
    	{
    		ries = RIESGO_MEDIO;
    	}
    	
    	else if (tipoCarga == CARGA_PELIGROSA && numeroCajas <50)
    	{
    		ries = RIESGO_MEDIO;
    	}
    	else if ( tipoCarga == CARGA_PELIGROSA && numeroCajas >= 50)
    	{
    		ries = RIESGO_ALTO;
    	}
    	return ries;
    }
}
