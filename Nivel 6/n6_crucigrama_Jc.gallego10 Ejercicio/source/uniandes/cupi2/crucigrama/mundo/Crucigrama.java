/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n6_crucigrama
 * Autor: ff - 03-nov-2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.crucigrama.mundo;


import java.util.Properties;


/**
 *  
 */
public class Crucigrama
{
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------



    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------
	public int numColumnas;
	public int numFilas;
	public String[] descripcionH;
	public String[] descripcionV;
	public int[][] coordHori;
	public int[][] coordVerti;
	public Casilla [][] crucigrama;
    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     *  
     */
    public Crucigrama( )
    {
    	
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------
	/**
	 * @param arch
	 */
	private void inicializarCasillas(Properties arch)
	{
		numFilas = Integer.parseInt((String) arch.get("crucigrama.filas"));
		numColumnas = Integer.parseInt((String) arch.get("crucigrama.columnas"));
		
		crucigrama = new Casilla[numFilas][numColumnas];
		
		for (int i = 1; i<(numFilas-1); i++)
		{
			String palabraActual = arch.getProperty("crucigrama."+"fila"+i);
			for (int j = 1; j<(numColumnas-1); j++)
			{
				char letraActual = palabraActual.charAt(j);
				if (letraActual == '$')
				{
					crucigrama[i][j].cambEstado(Casilla.NO_JUGABLE);
					crucigrama[i][j] = new Casilla(letraActual);
				}
				if (letraActual != '$')
				{
					crucigrama[i][j].cambEstado(Casilla.SIN_JUGAR);
					crucigrama[i][j] = new Casilla(letraActual);
				}
			}
		}
	}

	/**
	 * @param arch
	 */
	private void inicializarCoordenadasH(Properties arch)
	{
		String PalabH = arch.getProperty("crucigrama."+"palabrasHorizontales");
		PalabH.trim();
		int numPalabH = Integer.parseInt(PalabH);
		
		coordHori = new int[numPalabH][2];
		
		for (int i = 1; i<(numPalabH+1); i++)
		{
			String datosCoordHori = arch.getProperty("crucigrama."+"Hpalabra"+i);
			datosCoordHori.trim();
			
			String[] strCoordH = datosCoordHori.split(";",2);
			
			String coord1 = strCoordH[0];
			coord1.trim();
			coordHori[i-1][0] = Integer.parseInt(coord1);
			
			String coord2 = strCoordH[1];
			coord2.trim();
			coordHori[i-1][1] = Integer.parseInt(coord2);
		}
	}
	
	/**
	 * @param arch
	 */
	private void inicializarCoordenadasV(Properties arch)
	{
		String PalabV = arch.getProperty("crucigrama."+"palabrasVerticales");
		PalabV.trim();
		int numPalabV = Integer.parseInt(PalabV);
		
		coordVerti = new int[numPalabV][2];
		
		for (int i = 1; i<(numPalabV+1); i++)
		{
			String datosCoordV = arch.getProperty("crucigrama."+"Vpalabra"+i);
			datosCoordV.trim();
			
			String[] strCoordV = datosCoordV.split(";",2);
			
			String coord1 = strCoordV[0];
			coord1.trim();
			coordVerti[i-1][0] = Integer.parseInt(coord1);
			
			String coord2 = strCoordV[1];
			coord2.trim();
			coordVerti[i-1][1] = Integer.parseInt(coord2);
		}
	}
	public void cargarDescripciones(Properties arch)
	{
		int palabrasH = Integer.parseInt((String) arch.get("crucigrama.palabrasHorizontales"));
		int palabrasV = Integer.parseInt((String) arch.get("crucigrama.palabrasVerticales"));
		descripcionH= new String[palabrasH];
		descripcionV= new String[palabrasV];

		for(int i=0; i<descripcionH.length; i++)
		{
			descripcionH[i]=coordHori[i][0]+ ":" 
					+ coordHori[i][1] + "-"
					+ (String) arch.get("crucigrama.Hdescripcion" 
							+ (i+1));
		}
		for(int j =0; j <descripcionV.length; j ++)
		{
			descripcionV[j]=coordVerti[j][0]+ ":" 
					+ coordVerti[j][1] + "-"
					+(String) arch.get("crucigrama.Vdescripcion" + (j+1));
		}
	}
	
	public void cargar(Properties propiedades)

	{
		inicializarCasillas(propiedades);
		inicializarCoordenadasH(propiedades);
		inicializarCoordenadasV(propiedades);
		cargarDescripciones(propiedades);
	}
	
	public String[] darDescH()
	{
		return descripcionH;
	}
	
	public String[] DarDescV()
	{
		return descripcionV;
	}
	
	public Casilla[][] darCrucigrama()
	{
		return crucigrama;
	}
	

    //-----------------------------------------------------------------
    // Puntos de Extensión
    //-----------------------------------------------------------------

    /**
     * Método para la extensión 1
     * @return respuesta1
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión2
     * @return respuesta2
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }


}