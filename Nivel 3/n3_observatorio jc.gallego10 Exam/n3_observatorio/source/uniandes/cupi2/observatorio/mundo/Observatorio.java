/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_observatorio
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.observatorio.mundo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

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
     * Constante que determina el nombre del planeta Júpiter.
     */
    public static final String NOMBRE_JUPITER = "Júpiter";

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
 
    //TODO: Declarar la asociación planetas como una contenedora de tamaño fijo.
    

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el obervatorio con los siguientes planetas:
	 * planetas[0] - nombre: Mercurio - distanciMediaSol: 0.466 - excentricidad: 0.205 - periodoOrbital: 115.88 - velocidad: 478.725 - inclinación: 7.004.
	 * planetas[1] - nombre: Venus - distanciMediaSol: 0.728 - excentricidad: 0.006 - periodoOrbital: 583.92 - velocidad: 35.021 - inclinación: 339.471.
	 * planetas[2] - nombre: Tierra - distanciMediaSol: 1.016 - excentricidad: 0.0167 - periodoOrbital: 365.25 - velocidad: 30.28 - inclinación: 23.45.
	 * planetas[3] - nombre: Marte - distanciMediaSol: 1.665 - excentricidad: 0.09341233 - periodoOrbital: 779.95 - velocidad: 24.13 - inclinación: 1.850.
	 * planetas[4] - nombre: Jupiter - distanciMediaSol: 5.458 - excentricidad: 0.09341233 - periodoOrbital: 398.9 - velocidad: 13.069 - inclinación: 1.305.
	 * planetas[5] - nombre: Saturno - distanciMediaSol: 10.115 - excentricidad: 0.0541506 - periodoOrbital: 378.1 - velocidad: 9.67 - inclinación: 2.484.
	 * planetas[6] - nombre: Urano - distanciMediaSol: 20.096 - excentricidad: 0.04716771 - periodoOrbital: 369.7 - velocidad: 6.835 - inclinación: 0.769.
	 * planetas[7] - nombre: Neptuno - distanciMediaSol: 30.327 - excentricidad: 0.00858587 - periodoOrbital: 367.5 - velocidad: 5.47 - inclinación: 1.769.
     */
    public Observatorio( )
    {
        planetas = new Planeta[CANTIDAD_PLANETAS];
        planetas[ 0 ] = new Planeta( NOMBRE_MERCURIO, 0.466, 0.205, 115.88, 478.725, 7.004 );
        planetas[ 1 ] = new Planeta( NOMBRE_VENUS, 0.728, 0.006, 583.92, 35.021, 339.471 );
        planetas[ 2 ] = new Planeta( NOMBRE_TIERRA, 1.016, 0.0167, 365.25, 30.28, 23.45 );
        planetas[ 3 ] = new Planeta( NOMBRE_MARTE, 1.665, 0.09341233, 779.95, 24.13, 1.850 );
    	
        planetas[ 4 ] = new Planeta( NOMBRE_JUPITER, 5.458, 0.09341233, 398.9, 13.069, 1.305 );
        //TODO: Completar la creación del planeta Jupiter con los valores especificados en la documentación.
       
        planetas[ 5 ] = new Planeta( NOMBRE_SATURNO, 10.115, 0.0541506, 378.1, 9.67, 2.484 );
		//TODO: Completar la creación del planeta Saturno con los valores especificados en la documentación.
       
        planetas[ 6 ] = new Planeta( NOMBRE_URANO, 20.096, 0.04716771, 369.7, 6.835, 0.769 );
		//TODO: Completar la creación del planeta Urano con los valores especificados en la documentación.
       
        planetas[ 7 ] = new Planeta( NOMBRE_NEPTUNO, 30.327, 0.00858587, 367.5, 5.47, 1.769 );
		//TODO: Completar la creación del planeta Neptuno con los valores especificados en la documentación.
        
        
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Devuelve un arreglo con los nombres de los planetas registrados.
     * @return Arreglo con los nombres de los planetas.
     */
    public String[] darNombresPlanetas( )
    {
    	// TODO: Completar según la documentación del método.
    	return new String []{NOMBRE_MERCURIO, NOMBRE_VENUS, NOMBRE_TIERRA, NOMBRE_MARTE, NOMBRE_JUPITER, NOMBRE_SATURNO, NOMBRE_URANO, NOMBRE_NEPTUNO};
    	
    }
    
    /**
     * Devuelve el satélite artificial de un planeta dado.
     * @param pNombrePlaneta Nombre del planeta.
     * @return Satélite artificial del planeta. Null si no encuentra el satélite.
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
     * Devuelve una lista con los satélites naturales del planeta con el nombre dado.
     * @param pNombrePlaneta Nombre del planeta.
     * @return Lista con los satélites naturales del planeta especificado. List vacía en el caso de que el planeta especificado no tenga satélites naturales o que el planeta con el nombre especificado no exista.
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
    	// TODO: Completar según la documentación del método.
    }
        
    /**
     * Devuelve una lista con los nombres de los planetas que tienen menor distancia orbital que la especificada por parámetro.
     * @param pDistancia Distancia orbital con la cual compara.
     * @return Lista de los nombres de los planetas que cumplen con la condición especificada. Lista vacía si ningún planeta cumple la condición.
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
     * Devuelve una lista con los nombres de los planetas que tienen menor inclinación orbital que la del planeta cuyo nombre es especificado por parámetro.
     * @param pNombre Nombre del planeta del cual se quiere obtener su inclinación para comprar.
     * @return Lista con los nombres de los planetas que tienen menor inclinación orbital que la del planeta cuyo nombre es especificado por
     *         parámetro. Lista vacía si no hay planetas que cumplen con la condición o si el nombre del planeta no existe.
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
    	// TODO: Completar según la documentación del método.
    }
    
    /**
     * Devuelve el planeta con el mayor número de satélites naturales.
     * @return Planeta con el mayor número de satélites naturales. Null si no hay satélites naturales registrados en el sistema. 
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
    	// TODO: Completar según la documentación del método.
    }
    
    /**
     * Devuelve una lista con los nombres de los satélites naturales que tienen una excentricidad mayor al valor dado.
     * @param pExcentricidad Excentricidad con la que se quiere comparar a todos los satélites naturales.
     * @return Lista con los nombres de los satélites naturales que tienen una excentricidad mayor al valor dado. Lista vacía en caso de no encontrar satélites naturales que cumplan la condición.
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
    	// TODO: Completar según la documentación del método.
    }
    
    /**
     * Devuelve el número de satelites militares.
     * @return Número de satelites militares. 0 de no exitir este tipo de satélites.
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
    	// TODO: Completar según la documentación del método.
    }

    /**
     * Agrega un nuevo satélite artificial a un planeta cuyo nombre es especificado por parámetro.
     * @param pNombrePlaneta Nombre del planeta donde se quiere agregar el satélite artificial. 
     * @param pNombreSatelite Nombre del satélite artificial.
     * @param pPais País de origen del satélite artificial.
     * @param pTipoDeServicio Tipo de servicio que ofrece satélite artificial.
     * @return True si logró agregar el satélite artificial al planeta especificado. False de lo contrario.
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
    	// TODO: Completar según la documentación del método
    }
    
    /**
     * Elimina el satélite artificial dado su nombre y el nombre del planeta al cual pertence.
     * @param pNombrePlaneta Nombre del planeta al cual pertenece el satélite artificial. 
     * @param pNombreSatelite Nombre del satélite artificial que se quiere eliminar.
     * @return True si se pudo eliminar el satélite artificial. False de caso contratio.
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
    	// TODO: Completar según la documentación del método.
    }
    
    /**
     * Agrega un satélite natural a un planeta especificado por parámetro.
     * @param pNombrePlaneta Nombre del planeta donde se quiere agregar el satélite natural. 
     * @param pNombreSatelite Nombre del nuevo satélite natural. 
     * @param pExcentricidad Excentricidad del nuevo satélite natural.
     * @param pInclinacion Inclinación del nuevo satélite natural.
     * @return True si se agregó el satélite natural al planeta especificado. False de lo contrario.
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
    	
    	// TODO: Completar según la documentación del método.
    }

    /**
     * Elimina el satélite natural dado su nombre y el nombre del planeta al cual pertence.
     * @param pNombrePlaneta Nombre del planeta al cual pertenece el satélite natural. 
     * @param pNombreSatelite Nombre del satélite natural que se quiere eliminar.
     * @return True si se pudo eliminar el satélite natural. False de caso contrario.
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
     * Busca un satélite natural dado su nombre y el nombre del planeta al cual pertence.
     * @param pNombrePlaneta Nombre del planeta al cual pertenece el satélite natural.
     * @param pNombreSatelite Nombre del satélite natural que se quiere buscar.
     * @return Satélite natural del planeta. Null si no encuentra el satélite natural.
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
    	
    	// TODO: Completar según la documentación del método.
    }


    /**
     * Edita la excentricidad y la inclinación orbital de un satélite natural dado su nombre y el nombre del planeta al cual pertenece.
     * @param pNombrePlaneta Nombre del planeta al cual pertenece el satélite natural. 
     * @param pNombreSatelite Nombre del satélite natural. 
     * @param pExcentricidad Nuevo valor de la excentricidad del satélite natural.
     * @param pInclinacion Nuevo valor de la inclinación del satélite natural.
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
    	
    	// TODO: Completar según la documentación del método.
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
    	
    	// TODO: Completar según la documentación del método.
	}

    public int darNumeroPlanetasConSatelitesDensos(double pDensidad)
    {
    	int contador=0;
    	for (int i = 0; i < planetas.length; i++) 
    	{
    		if(planetas[i].darNumeroSatelitesDensos(pDensidad) == planetas[i].darSatelitesNaturales().size() && planetas[i].darNumeroSatelitesDensos(pDensidad) > 0)
    		{
    			contador++;
    		}
		}
    	return contador;
    	
    }
    
    
    
    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Retorna Cuantos planetas densos hay en el sistema solar.
     * @return Cuantos planetas densos hay en el sistema solar.
     */
    public String metodo1()
    {
       String s = JOptionPane.showInputDialog("Densidad de referencia (0.2-100)");
       double pDensidad = Double.parseDouble(s);
       if(pDensidad<0.2 || pDensidad > 100)
    	   {
    	   return "No ha ingresado un valor valido"; 
    	   }
       if(darNumeroPlanetasConSatelitesDensos(pDensidad)>0)
       	{
    	  return "La cantidad de planetas densos son: " + darNumeroPlanetasConSatelitesDensos(pDensidad);
       	}
       else 
       {
    	   return " No hay planetas densos.";
       }
       
    	
    }

    /**
     * retorna cual es el planeta mas denso del sistema solar.
     * @return el planeta mas denso del sistema solar.
     */
    public String metodo2( )
    {
    	String s = JOptionPane.showInputDialog("Densidad de referencia (0.2-100)");
        double pDensidad = Double.parseDouble(s);
    	Planeta pla = null;
    	if(planetas[0].darNumeroSatelitesDensos(pDensidad)>0)
    	{
    		pla = planetas[0];
    	}
    	
    	for (int i = 0; i < planetas.length-1; i++) 
    	{
			if (planetas[i].darNumeroSatelitesDensos(pDensidad) < planetas[i+1].darNumeroSatelitesDensos(pDensidad)) 
			{
				pla = planetas[i+1];
			}
		}
    	if(pla != null)
    	{
    		return "El planeta mas denso es: " + pla.darNombre() + " - Tiene " + pla.darNumeroSatelitesDensos(pDensidad) + " de " + pla.darSatelitesNaturales().size() + " sátelites densos.";
    	}
    	else 
    	{
    		return "No hay satélites densos en el sismtema solar";
    	}
    }

	

}