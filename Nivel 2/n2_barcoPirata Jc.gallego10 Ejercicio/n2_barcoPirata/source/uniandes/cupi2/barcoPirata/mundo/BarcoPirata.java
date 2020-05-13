/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_barcoPirata 
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.barcoPirata.mundo;

/**
 * Clase que representa el barco pirata.
 */
public class BarcoPirata
{

    // ---------------------------------------------------------------------
    // Constantes
    // ---------------------------------------------------------------------

	/**
	 * Constante que determina la carga m�nima para que el barco pueda zarpar.
	 */
	public static final int CARGA_MINIMA = 12000;
	//TODO Declare la constante CARGA_MINIMA
	
    /**
     * Constante que determina la carga m�xima soportada por el barco.
     */
	public static final int CARGA_MAXIMA = 20000;
    //TODO Declare la constante CARGA_MAXIMA

    /**
     * Constante que determina la cantidad m�nima de contenedores cargados para que el barco pueda zarpar.
     */
    public static final int CANT_MIN_CONTENEDORES = 2;

    // ---------------------------------------------------------------------
    // Atributos
    // ---------------------------------------------------------------------

    /**
     * Contenedor 1 del barco.
     */
    private Contenedor contenedor1;

    /**
     * Contenedor 2 del barco.
     */
    private Contenedor contenedor2;
    // TODO: Declarar la asociaci�n contenedor2

    /**
     * Contenedor 3 del barco.
     */
    private Contenedor contenedor3;
    // TODO: Declarar la asociaci�n contenedor3

    /**
     * Contenedor 4 del barco.
     */
    private Contenedor contenedor4;

    // ---------------------------------------------------------------------
    // Constructores
    // ---------------------------------------------------------------------
    
    /**
     * Crea un barco con cuatro contenedores vac�os. Los valores para cada uno de los contenedores son los siguientes:
     * Contenedor 1 - Nombre del pirata due�o: Barba Negra.
     * Contenedor 2 - Nombre del pirata due�o: Francis Drake.
     * Contenedor 3 - Nombre del pirata due�o: Anne Bonny.
     * Contenedor 4 - Nombre del pirata due�o: Davy Jones.
     */
    public BarcoPirata( )
    {
        contenedor1 = new Contenedor(Contenedor.BARBA_NEGRA);
        
        contenedor2 = new Contenedor(Contenedor.FRANCIS_DRAKE);
        //TODO Completar la creaci�n del contenedor2 con los valores especificados en la documentaci�n
        
        contenedor3 = new Contenedor(Contenedor.ANNE_BONNY);
        //TODO Completar la creaci�n del contenedor3 con los valores especificados en la documentaci�n
        
        contenedor4 = new Contenedor(Contenedor.DAVY_JONES);
    }

    // ---------------------------------------------------------------------
    // M�todos
    // ---------------------------------------------------------------------

    /**
     * Devuelve el primer contenedor.
     * @return Contenedor 1.
     */
    public Contenedor darContenedor1( )
    {
        return contenedor1;
    }

    /**
     * Devuelve el segundo contenedor.
     * @return Contenedor 2.
     */
    public Contenedor darContenedor2( )
    {
        return contenedor2;
    }

    /**
     * Devuelve el tercer contenedor.
     * @return Contenedor 3.
     */
    public Contenedor darContenedor3( )
    {
        return contenedor3;
    }

    /**
     * Devuelve el cuarto contenedor.
     * @return Contenedor4.
     */
    public Contenedor darContenedor4( )
    {
        return contenedor4;
    }

	/**
	 * Calcula el peso total de la carga que transporta el barco en sus cuatro contenedores.
	 * @return Peso total de la carga que transporta el barco.
	 */
	public double darPesoTotal( )
	{
	    return  contenedor1.darPesoContenedor() + contenedor2.darPesoContenedor() + contenedor3.darPesoContenedor() + contenedor4.darPesoContenedor() ;
	}
	
	/**
	 * Determina si en el barco hay alg�n contenedor que tenga una carga de tipo CARGA_PELIGROSA.
	 * @return True si existe alg�n contenedor que cumpla la condici�n, false de lo contrario.
	 */
    public boolean existeContenedorConCargaPeligrosa( )
    {   
    	
    	
    	return (contenedor1.darTipoCarga() == Contenedor.CARGA_PELIGROSA ||
    			contenedor1.darTipoCarga() == Contenedor.CARGA_PELIGROSA ||
    			contenedor1.darTipoCarga() == Contenedor.CARGA_PELIGROSA  );
    	
    	// TODO: Completar seg�n la documentaci�n del m�todo
    }

    /**
	 * Determina si en el barco hay alg�n contenedor que tenga una carga de tipo CARGA_PERECEDERA.
	 * @return True si existe alg�n contenedor que cumpla la condici�n, false de lo contrario.
	 */
    public boolean existeContenedorConCargaPerecedera( )
    {   
        return ( contenedor1.darTipoCarga() == Contenedor.CARGA_PERECEDERA || 
        		 contenedor2.darTipoCarga() == Contenedor.CARGA_PERECEDERA || 
        		 contenedor3.darTipoCarga() == Contenedor.CARGA_PERECEDERA || 
        		 contenedor4.darTipoCarga()==Contenedor.CARGA_PERECEDERA );
    }
    
    /**
	 * Determina si al agregar el peso total de las cajas que entran como par�metro al peso total de la carga del barco se excede la carga m�xima del barco.
	 * @param pNumeroCajas N�mero de cajas que se desean agregar al barco.
	 * @param pPesoPorCaja Peso de cada una de las cajas que se desean agregar al barco.
	 * @return True si se sobrepasa el peso m�ximo de carga (incluyendo el peso del barco antes de la carga), false de lo contrario.
	 */
	public boolean sobrepasaPesoLimite( int pNumeroCajas, double pPesoPorCaja )
	{
		
		return ((darPesoTotal() + pNumeroCajas*pPesoPorCaja) > CARGA_MAXIMA);
		
		// TODO: Completar seg�n la documentaci�n del m�todo
	}

	/**
	 * Carga un contenedor del barco con los valores dados por par�metro si se cumplen las siguientes condiciones:
	 *         - el peso del barco (incluyendo el contenedor) no sobrepasa la capacidad del barco 
	 *         - el tipo de carga del contenedor cumple con las condiciones sanitarias 
	 * @param pNombrePirata Nombre del pirata due�o del contenedor que se desea cargar.
	 * @param pNumeroCajas Cantidad de cajas del contenedor.
	 * @param pPesoPorCaja Peso de cada una de las cajas del contenedor.
	 * @param pTipoCarga Tipo de carga del contenedor.
	 * @return True si se pudo agregar la carga al contenedor, false de lo contrario.
	 */
    public boolean cargarContenedor( String pNombrePirata, int pNumeroCajas, double pPesoPorCaja, int pTipoCarga )
    {
    	if ( pTipoCarga == Contenedor.CARGA_PELIGROSA && existeContenedorConCargaPerecedera() )
    	{
    		return false;
    	}
    	if ( pTipoCarga == Contenedor.CARGA_PERECEDERA && existeContenedorConCargaPeligrosa() )
    	{
    		return false;
    	}
    	if ( sobrepasaPesoLimite(pNumeroCajas, pPesoPorCaja))
    	{
    		return false;
    	}
    	if ( pNombrePirata.equals(contenedor1.darNombrePirata()) )
    	{
    		contenedor1.cargar(pNumeroCajas, pPesoPorCaja, pTipoCarga);
    		return true;
    	}
    	if ( pNombrePirata.equals(contenedor2.darNombrePirata()) )
    	{
    		contenedor2.cargar(pNumeroCajas, pPesoPorCaja, pTipoCarga);
    		return true;
    	}
    	if ( pNombrePirata.equals(contenedor3.darNombrePirata()) )
    	{
    		contenedor3.cargar(pNumeroCajas, pPesoPorCaja, pTipoCarga);
    		return true;
    	}
    	if ( pNombrePirata.equals(contenedor4.darNombrePirata()) )
    	{
    		contenedor4.cargar(pNumeroCajas, pPesoPorCaja, pTipoCarga);
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    	
    	
    	// TODO: Completar seg�n la documentaci�n del m�todo
    }
    
    /**
	 * Descarga un contenedor del barco.
	 * @param pNombrePirata Nombre del pirata due�o del contenedor que ser� descargado.
	 */
    public void descargarContenedor(String pNombrePirata)
    {
    	if (contenedor1.darNombrePirata().equals(pNombrePirata))
    				{contenedor1.descargar();}
    	
    	else if ( contenedor2.darNombrePirata().equals(pNombrePirata))
					{contenedor2.descargar();}
    	
    	else if ( contenedor3.darNombrePirata().equals(pNombrePirata))
					{contenedor3.descargar();}
    	
    	else if ( contenedor4.darNombrePirata().equals(pNombrePirata))
					{contenedor4.descargar();}
    	// TODO: Completar seg�n la documentaci�n del m�todo
    }
    
	/**
	 * Vac�a todos los contenedores del barco para comenzar un nuevo viaje.
	 */
	public void descargarBarco( )
	{
	    contenedor1.descargar();
	    contenedor2.descargar();
	    contenedor3.descargar();
	    contenedor4.descargar();
	}

	/**
     * Determina si se puede zarpar o no. Se puede zarpar si se cumple alguna de las siguientes condiciones:
     * 1) Tiene por lo menos 2 contenedores cargados.
     * 2) El peso total de la carga del barco es mayor a la carga m�nima requerida.
     * @return True si se puede zarpar, false de lo contrario.
     */
    public boolean puedeZarpar( )
    {
        boolean puede = false;
        int contador = 0;
        
        if( contenedor1.darTipoCarga()!=Contenedor.SIN_CARGA )
        {
        	 contador++;
        }
        if( contenedor2.darTipoCarga()!=Contenedor.SIN_CARGA )
        {
        	 contador++;
        }
        if( contenedor3.darTipoCarga()!=Contenedor.SIN_CARGA )
        {
        	 contador++;
        }
        if( contenedor4.darTipoCarga()!=Contenedor.SIN_CARGA )
        {
        	 contador++;
        }

        if( darPesoTotal( ) > CARGA_MINIMA || contador >= CANT_MIN_CONTENEDORES )
        {
        	puede = true;
        }

        return puede;

    }

    
    /**
     * Retorna el contenedor m�s pesado.
     * Si hay m�s de un contenedor que cumple con la condici�n de ser el m�s pesado del barco (es decir, que tienen el mismo peso y este es el m�s elevado), retorna cualquiera de los contenedores que sean m�ximos.
     * @return El contenedor m�s pesado o null si el barco est� vac�o.
     */
    public Contenedor darContenedorMasPesado()
    {
    	Contenedor elMasPesado = null;
    	
    	if( contenedor1.darPesoContenedor() !=0 || contenedor2.darPesoContenedor() !=0 || contenedor3.darPesoContenedor() !=0 || contenedor4.darPesoContenedor() !=0)
    	{
    		if ( contenedor1.darPesoContenedor() >= contenedor2.darPesoContenedor()  )
        	{
        		elMasPesado = contenedor1;
        	}
        	if ( contenedor2.darPesoContenedor() >= contenedor1.darPesoContenedor()  )
        	{
        		elMasPesado = contenedor2;
        	}
        	if ( contenedor3.darPesoContenedor() > elMasPesado.darPesoContenedor()  )
        	{
        		elMasPesado = contenedor3;
        	}
        	if ( contenedor4.darPesoContenedor() > elMasPesado.darPesoContenedor()  )
        	{
        		elMasPesado = contenedor4;
        	}
    	}
    	
    	
    	
    	
    	
    	// TODO: Completar seg�n la documentaci�n del m�todo
    	
    	return elMasPesado;
    }
    
    /**
     * Busca el nombre del pirata due�o del contenedor m�s pesado del barco.
     * Si todos los contenedores est�n vac�os, retorna el mensaje "El barco est� vac�o.".
     * Si hay m�s de un contenedor que cumple con la condici�n de ser el m�s pesado del barco (es decir, que tienen el mismo peso y este es el m�s elevado), se muestran los nombres de los piratas due�os de dichos contenedores separados por comas.
     * @return El (o los) nombre(s) del (de los) pirata(s) due�o(s) del (de los) contenedor(es) mas pesado(s) del barco o un mensaje que indica que el barco est� vac�o
     */
    public String buscarPirataDuenioContenedorMasPesado( )
    {
    	String dueno = "";
    	
    	if ( darPesoTotal() == 0)
    	{
    		return  "El barco est� vac�o.";
    	}
    	if ( darContenedorMasPesado().darPesoContenedor() == contenedor1.darPesoContenedor())
    	{
    		dueno = contenedor1.darNombrePirata();
    	}
    	if ( darContenedorMasPesado().darPesoContenedor() == contenedor2.darPesoContenedor())
    	{
    		dueno +=  ", " + contenedor2.darNombrePirata();
    	}
    	if ( darContenedorMasPesado().darPesoContenedor() == contenedor3.darPesoContenedor())
    	{
    		dueno += ", " + contenedor3.darNombrePirata();
    	}
    	if ( darContenedorMasPesado().darPesoContenedor() == contenedor4.darPesoContenedor())
    	{
    		dueno += ", " + contenedor4.darNombrePirata();
    	}
    	return dueno;
    	
    	// TODO: Completar seg�n la documentaci�n del m�todo
    	
    }

    

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1.
     * @return Respuesta de la extensi�n 1.
     */
    public String metodo1( )
    {
        return "Respuesta 1.";
    }

    /**
     * M�todo para la extensi�n 2.
     * @return Respuesta de la extensi�n 2.
     */
    public String metodo2( )
    {
        return "Respuesta 2.";
    }
}
