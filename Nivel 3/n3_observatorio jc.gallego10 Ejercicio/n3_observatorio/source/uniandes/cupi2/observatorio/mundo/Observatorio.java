/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_observatorio
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.observatorio.mundo;

import java.util.ArrayList;

/**
 * Clase que representa el observatorio.
 */
public class Observatorio
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que determina la cantidad de elementos que tiene el arreglo de planetas.
     */
	
	public static final int CANTIDAD_PLANETAS = 8;
	//TODO Declarar la constante CANTIDAD_PLANETAS.

    /**
     * Constante que determina el nombre del planeta Mercurio.
     */
    public static final String NOMBRE_MERCURIO = "Mercurio";

    /**
     * Constante que determina el nombre del planeta Venus.
     */
    public static final String NOMBRE_VENUS = "Venus";

    /**
     * Constante que determina el nombre del planeta Tierra.
     */
    public static final String NOMBRE_TIERRA = "Tierra";

    /**
     * Constante que determina el nombre del planeta Marte.
     */
    
    public static final String NOMBRE_MARTE = "Marte";
    //TODO Declarar la constante NOMBRE_MARTE.

    /**
     * Constante que determina el nombre del planeta J�piter.
     */
    public static final String NOMBRE_JUPITER = "J�piter";

    /**
     * Constante que determina el nombre del planeta Saturno.
     */
    public static final String NOMBRE_SATURNO = "Saturno";

    /**
     * Constante que determina el nombre del planeta Urano.
     */
    
    public static final String NOMBRE_URANO = "Urano";
    //TODO Declarar la constante NOMBRE_URANO.

    /**
     * Constante que determina el nombre del planeta Neptuno.
     */
    public static final String NOMBRE_NEPTUNO = "Neptuno";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Arreglo que contiente los planetas del sistema solar.
     */
    
    private Planeta [] planetas;
 
    //TODO: Declarar la asociaci�n planetas como una contenedora de tama�o fijo.
    

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el obervatorio con los siguientes planetas:
	 * planetas[0] - nombre: Mercurio - distanciMediaSol: 0.466 - excentricidad: 0.205 - periodoOrbital: 115.88 - velocidad: 478.725 - inclinaci�n: 7.004.
	 * planetas[1] - nombre: Venus - distanciMediaSol: 0.728 - excentricidad: 0.006 - periodoOrbital: 583.92 - velocidad: 35.021 - inclinaci�n: 339.471.
	 * planetas[2] - nombre: Tierra - distanciMediaSol: 1.016 - excentricidad: 0.0167 - periodoOrbital: 365.25 - velocidad: 30.28 - inclinaci�n: 23.45.
	 * planetas[3] - nombre: Marte - distanciMediaSol: 1.665 - excentricidad: 0.09341233 - periodoOrbital: 779.95 - velocidad: 24.13 - inclinaci�n: 1.850.
	 * planetas[4] - nombre: Jupiter - distanciMediaSol: 5.458 - excentricidad: 0.09341233 - periodoOrbital: 398.9 - velocidad: 13.069 - inclinaci�n: 1.305.
	 * planetas[5] - nombre: Saturno - distanciMediaSol: 10.115 - excentricidad: 0.0541506 - periodoOrbital: 378.1 - velocidad: 9.67 - inclinaci�n: 2.484.
	 * planetas[6] - nombre: Urano - distanciMediaSol: 20.096 - excentricidad: 0.04716771 - periodoOrbital: 369.7 - velocidad: 6.835 - inclinaci�n: 0.769.
	 * planetas[7] - nombre: Neptuno - distanciMediaSol: 30.327 - excentricidad: 0.00858587 - periodoOrbital: 367.5 - velocidad: 5.47 - inclinaci�n: 1.769.
     */
    public Observatorio( )
    {
        planetas = new Planeta[CANTIDAD_PLANETAS];
        planetas[ 0 ] = new Planeta( NOMBRE_MERCURIO, 0.466, 0.205, 115.88, 478.725, 7.004 );
        planetas[ 1 ] = new Planeta( NOMBRE_VENUS, 0.728, 0.006, 583.92, 35.021, 339.471 );
        planetas[ 2 ] = new Planeta( NOMBRE_TIERRA, 1.016, 0.0167, 365.25, 30.28, 23.45 );
        planetas[ 3 ] = new Planeta( NOMBRE_MARTE, 1.665, 0.09341233, 779.95, 24.13, 1.850 );
    	
        planetas[ 4 ] = new Planeta( NOMBRE_JUPITER, 5.458, 0.09341233, 398.9, 13.069, 1.305 );
        //TODO: Completar la creaci�n del planeta Jupiter con los valores especificados en la documentaci�n.
       
        planetas[ 5 ] = new Planeta( NOMBRE_SATURNO, 10.115, 0.0541506, 378.1, 9.67, 2.484 );
		//TODO: Completar la creaci�n del planeta Saturno con los valores especificados en la documentaci�n.
       
        planetas[ 6 ] = new Planeta( NOMBRE_URANO, 20.096, 0.04716771, 369.7, 6.835, 0.769 );
		//TODO: Completar la creaci�n del planeta Urano con los valores especificados en la documentaci�n.
       
        planetas[ 7 ] = new Planeta( NOMBRE_NEPTUNO, 30.327, 0.00858587, 367.5, 5.47, 1.769 );
		//TODO: Completar la creaci�n del planeta Neptuno con los valores especificados en la documentaci�n.
        
        
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Devuelve un arreglo con los nombres de los planetas registrados.
     * @return Arreglo con los nombres de los planetas.
     */
    public String[] darNombresPlanetas( )
    {
    	// TODO: Completar seg�n la documentaci�n del m�todo.
    	return new String []{NOMBRE_MERCURIO, NOMBRE_VENUS, NOMBRE_TIERRA, NOMBRE_MARTE, NOMBRE_JUPITER, NOMBRE_SATURNO, NOMBRE_URANO, NOMBRE_NEPTUNO};
    	
    }
    
    /**
     * Devuelve el sat�lite artificial de un planeta dado.
     * @param pNombrePlaneta Nombre del planeta.
     * @return Sat�lite artificial del planeta. Null si no encuentra el sat�lite.
     */
    public SateliteArtificial darSateliteArtificial(String pNombrePlaneta)
    {
        boolean encontrado = false;
        SateliteArtificial satelite = null;
        for( int i = 0; i < planetas.length && !encontrado; i++ )
        {
            if( planetas[ i ].darNombre( ).equals( pNombrePlaneta ) )
            {
               satelite =  planetas[ i ].darSateliteArtificial();
               encontrado = true;
            }
        }
        return satelite;
    }
    
    /**
     * Devuelve una lista con los sat�lites naturales del planeta con el nombre dado.
     * @param pNombrePlaneta Nombre del planeta.
     * @return Lista con los sat�lites naturales del planeta especificado. List vac�a en el caso de que el planeta especificado no tenga sat�lites naturales o que el planeta con el nombre especificado no exista.
     */
    public ArrayList<SateliteNatural> darSatelitesNaturales( String pNombrePlaneta )
    {
    	ArrayList<SateliteNatural> var = new ArrayList<SateliteNatural>();
    	 for (int i = 0; i < CANTIDAD_PLANETAS; i++) 
    	 {
			if(planetas[i].darNombre().equals(pNombrePlaneta))
			{
				var = planetas[i].darSatelitesNaturales();
			}
			
    	 }
    	 return var;
    	// TODO: Completar seg�n la documentaci�n del m�todo.
    }
        
    /**
     * Devuelve una lista con los nombres de los planetas que tienen menor distancia orbital que la especificada por par�metro.
     * @param pDistancia Distancia orbital con la cual compara.
     * @return Lista de los nombres de los planetas que cumplen con la condici�n especificada. Lista vac�a si ning�n planeta cumple la condici�n.
     */
    public ArrayList<String> darPlanetasPorDistancia( double pDistancia )
    {
        ArrayList <String> listaPlanetas = new ArrayList<String>( );
        for( int i = 0; i < CANTIDAD_PLANETAS; i++ )
        {
            Planeta planeta = planetas[ i ];
            if( planeta.darDistancia( ) <= pDistancia )
                listaPlanetas.add( planeta.darNombre( ) );
        }
        return listaPlanetas;
    }

    /**
     * Devuelve una lista con los nombres de los planetas que tienen menor inclinaci�n orbital que la del planeta cuyo nombre es especificado por par�metro.
     * @param pNombre Nombre del planeta del cual se quiere obtener su inclinaci�n para comprar.
     * @return Lista con los nombres de los planetas que tienen menor inclinaci�n orbital que la del planeta cuyo nombre es especificado por
     *         par�metro. Lista vac�a si no hay planetas que cumplen con la condici�n o si el nombre del planeta no existe.
     */
    public ArrayList<String> darPlanetasPorInclinacion( String pNombre )
    {
    	ArrayList <String> listaPlanetas = new ArrayList<String>( );
        Planeta planPrue = null;
        boolean fini = false;
    	for (int j = 0; j < CANTIDAD_PLANETAS && !fini; j++)
        {
        	if(planetas[j].darNombre().equals(pNombre))
        	{
        		planPrue=planetas[j];
        		for( int i = 0; i < CANTIDAD_PLANETAS; i++ )
                {
                 
                    if(planetas[i].darInclinacion() < planPrue.darInclinacion() )
                    {
                        listaPlanetas.add( planetas[i].darNombre( ) );
                    }
                }
        		fini = true;
        	
        	}
		}
    	
        return listaPlanetas;
    	// TODO: Completar seg�n la documentaci�n del m�todo.
    }
    
    /**
     * Devuelve el planeta con el mayor n�mero de sat�lites naturales.
     * @return Planeta con el mayor n�mero de sat�lites naturales. Null si no hay sat�lites naturales registrados en el sistema. 
     */
    public Planeta darPlanetaMasSatelites()
    {
    	int muyLargo = 0;
    	Planeta abuso = null;
    	for(int i = 0 ; i<CANTIDAD_PLANETAS ; i++)
    	{
    		Planeta planeta = planetas[i];
    		if(planeta.darSatelitesNaturales().size()  > muyLargo)
    		{
    			muyLargo = planeta.darSatelitesNaturales().size();
    			abuso = planeta;
    		}
    	}
    	return abuso;
    	// TODO: Completar seg�n la documentaci�n del m�todo.
    }
    
    /**
     * Devuelve una lista con los nombres de los sat�lites naturales que tienen una excentricidad mayor al valor dado.
     * @param pExcentricidad Excentricidad con la que se quiere comparar a todos los sat�lites naturales.
     * @return Lista con los nombres de los sat�lites naturales que tienen una excentricidad mayor al valor dado. Lista vac�a en caso de no encontrar sat�lites naturales que cumplan la condici�n.
     */
    public ArrayList<String> darSatelitesExcentricidadMayor(double pExcentricidad)
    {
    	ArrayList<String> listaP = new ArrayList<String> ();
    	for (int i = 0; i < planetas.length; i++)
    	{
    		ArrayList <SateliteNatural> listaS = planetas[i].darSatelitesNaturales();
    		for (int j = 0; j < listaS.size(); j++)
    		{
    			if (listaS.get(j).darExcentricidad() > pExcentricidad)
    			{
    			  listaP.add(listaS.get(j).darNombre());
    			}
    		}
    	}
    	return listaP;
    	// TODO: Completar seg�n la documentaci�n del m�todo.
    }
    
    /**
     * Devuelve el n�mero de satelites militares.
     * @return N�mero de satelites militares. 0 de no exitir este tipo de sat�lites.
     */
    public int darNumeroSatelitesMilitares()
    {
    	int k = 0;
    	for( int i = 0 ; i < CANTIDAD_PLANETAS ; i++)
    	{
    		Planeta planeta = planetas[ i ];
    		if(planeta.darSateliteArtificial() != null && planeta.darSateliteArtificial().darTipoDeServicio() == SateliteArtificial.TIPO_MILITAR)
    		{
    			k++;
    		}
    	}
    	return k;
    	// TODO: Completar seg�n la documentaci�n del m�todo.
    }

    /**
     * Agrega un nuevo sat�lite artificial a un planeta cuyo nombre es especificado por par�metro.
     * @param pNombrePlaneta Nombre del planeta donde se quiere agregar el sat�lite artificial. 
     * @param pNombreSatelite Nombre del sat�lite artificial.
     * @param pPais Pa�s de origen del sat�lite artificial.
     * @param pTipoDeServicio Tipo de servicio que ofrece sat�lite artificial.
     * @return True si logr� agregar el sat�lite artificial al planeta especificado. False de lo contrario.
     */
    public boolean agregarSateliteArtificial(String pNombrePlaneta, String pNombreSatelite, String pPais, String pTipoDeServicio)
    {
    	
    	boolean agregar = false;
    	for(int i = 0 ; i < CANTIDAD_PLANETAS && !agregar ; i++)
    	{
    		Planeta plane = planetas[i];
    		if(plane.darNombre().equals(pNombrePlaneta))
    		{
    			agregar = plane.agregarSateliteArtificial(pNombreSatelite, pPais, pTipoDeServicio);
    			planetas[i].agregarSateliteArtificial(pNombreSatelite, pPais, pTipoDeServicio);
    		}
    	}
    	return agregar;
    	// TODO: Completar seg�n la documentaci�n del m�todo
    }
    
    /**
     * Elimina el sat�lite artificial dado su nombre y el nombre del planeta al cual pertence.
     * @param pNombrePlaneta Nombre del planeta al cual pertenece el sat�lite artificial. 
     * @param pNombreSatelite Nombre del sat�lite artificial que se quiere eliminar.
     * @return True si se pudo eliminar el sat�lite artificial. False de caso contratio.
     */
    public boolean eliminarSateliteArtificial( String pNombrePlaneta, String pNombreSatelite )
    {
    	boolean eliminar = false;
    	for(int i = 0;i<CANTIDAD_PLANETAS && !eliminar;i++)
    	{
    		Planeta pluto = planetas[i];
    		if(pluto.darNombre().equals(pNombrePlaneta))
    		{
    			if(pluto.darSateliteArtificial() != null && pluto.darSateliteArtificial().darNombre().equals(pNombreSatelite))
    			{
    				eliminar = pluto.eliminarSateliteArtificial(pNombreSatelite);
    				
    			}
    		}
    	}
    	return eliminar;
    	// TODO: Completar seg�n la documentaci�n del m�todo.
    }
    
    /**
     * Agrega un sat�lite natural a un planeta especificado por par�metro.
     * @param pNombrePlaneta Nombre del planeta donde se quiere agregar el sat�lite natural. 
     * @param pNombreSatelite Nombre del nuevo sat�lite natural. 
     * @param pExcentricidad Excentricidad del nuevo sat�lite natural.
     * @param pInclinacion Inclinaci�n del nuevo sat�lite natural.
     * @return True si se agreg� el sat�lite natural al planeta especificado. False de lo contrario.
     */
    public boolean agregarSateliteNatural( String pNombrePlaneta, String pNombreSatelite, double pExcentricidad, double pInclinacion )
    {
    	boolean agregar = false;
    	for(int i = 0 ; i < CANTIDAD_PLANETAS && !agregar; i++)
    	{
    		Planeta pl = planetas [i];
    		if(pl.darNombre().equals(pNombrePlaneta))
    		{
    			agregar = pl.agregarSateliteNatural(pNombreSatelite, pExcentricidad, pInclinacion);
    		}
    	}
    	return agregar;
    	
    	// TODO: Completar seg�n la documentaci�n del m�todo.
    }

    /**
     * Elimina el sat�lite natural dado su nombre y el nombre del planeta al cual pertence.
     * @param pNombrePlaneta Nombre del planeta al cual pertenece el sat�lite natural. 
     * @param pNombreSatelite Nombre del sat�lite natural que se quiere eliminar.
     * @return True si se pudo eliminar el sat�lite natural. False de caso contrario.
     */
    public boolean eliminarSateliteNatural( String pNombrePlaneta, String pNombreSatelite )
    {
        boolean encontrado = false;
        for( int i = 0; i < planetas.length && !encontrado; i++ )
        {
            Planeta planeta = planetas[ i ];
            if( planeta.darNombre( ).equals( pNombrePlaneta ) )
            {
            	encontrado = planeta.eliminarSateliteNatural( pNombreSatelite );
            }
        }
        return encontrado;

    }
    
    /**
     * Busca un sat�lite natural dado su nombre y el nombre del planeta al cual pertence.
     * @param pNombrePlaneta Nombre del planeta al cual pertenece el sat�lite natural.
     * @param pNombreSatelite Nombre del sat�lite natural que se quiere buscar.
     * @return Sat�lite natural del planeta. Null si no encuentra el sat�lite natural.
     */
    public SateliteNatural buscarSateliteNatural( String pNombrePlaneta, String pNombreSatelite )
    {
    	
    	SateliteNatural sat = null;
    	for( int i = 0; i < CANTIDAD_PLANETAS; i++ )
        {
    		Planeta planeta = planetas[ i ];
            if(planeta.darNombre().equals(pNombrePlaneta))
            {
            	sat = planeta.buscarSateliteNatural(pNombreSatelite);
            }
        }
         return sat;
    	
    	// TODO: Completar seg�n la documentaci�n del m�todo.
    }


    /**
     * Edita la excentricidad y la inclinaci�n orbital de un sat�lite natural dado su nombre y el nombre del planeta al cual pertenece.
     * @param pNombrePlaneta Nombre del planeta al cual pertenece el sat�lite natural. 
     * @param pNombreSatelite Nombre del sat�lite natural. 
     * @param pExcentricidad Nuevo valor de la excentricidad del sat�lite natural.
     * @param pInclinacion Nuevo valor de la inclinaci�n del sat�lite natural.
     */
    public boolean editarSateliteNatural( String pNombrePlaneta, String pNombreSatelite, double pExcentricidad, double pInclinacion )
    {
    	boolean edt = false;
    	
    		for(int i = 0; i < CANTIDAD_PLANETAS && !edt; i++)
    		{
    			Planeta plan = planetas[i];
    			if(plan.darNombre().equals(pNombrePlaneta))
    			{
    				edt = plan.editarSateliteNatural(pNombreSatelite, pExcentricidad, pInclinacion);
    			}
    		}
    	return edt;
    	
    	// TODO: Completar seg�n la documentaci�n del m�todo.
    }
    
    /**
     * Busca una planeta dado su nombre.
     * @param pNombrePlaneta  Nombre del planeta que se quiere buscar.
     * @return Planeta buscado. Null si no encuentra el planeta con el nombre.
     */
    public Planeta buscarPlaneta(String pNombrePlaneta) 
    {
    	boolean encontrado = false;
    	Planeta planetica = null;
    	for (int i = 0; i < CANTIDAD_PLANETAS && !encontrado; i++) 
    		{
    			if (planetas[i].darNombre().equals(pNombrePlaneta))
    			{
    				planetica = planetas[i];
    			}
    		}
    	return planetica;
    	
    	// TODO: Completar seg�n la documentaci�n del m�todo.
	}

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1
     * @return respuesta1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * M�todo para la extensi�n2
     * @return respuesta2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

	

}