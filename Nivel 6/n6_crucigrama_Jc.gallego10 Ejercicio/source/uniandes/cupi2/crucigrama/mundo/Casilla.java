package uniandes.cupi2.crucigrama.mundo;

public class Casilla 
{
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------
	/**
	 * 
	 */
	public static final int CORRECTO =2;
	/**
	 * 
	 */
	public static final int INCORRECTO = 3;
	/**
	 * 
	 */
	public static final int NO_JUGABLE = 0;
	/**
	 * 
	 */
	public static final int SIN_JUGAR = 1;	
	/**
	 * 
	 */
	public static final char INICIAL = '$';
	/**
	 * 
	 */
	public static final char VACIO = ' ';
	
	
	//-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------
	
	/**
	 * 
	 */
	private char valCorr;
	/**
	 * 
	 */
	private char valIngr;
	/**
	 * 
	 */
	private int estado;

	//-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------
	/**
	 * @param pValorCorrecto
	 */
	public Casilla(char pValorCorrecto)
	{
		valCorr = pValorCorrecto;
		valIngr=VACIO;
		
			if(pValorCorrecto == INICIAL)
			{
				estado = NO_JUGABLE;
			}
			else
			{
				estado = SIN_JUGAR ;
			}
	}
	
	
    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------
  
	
	/**
	 * @return
	 */
	public char darvalCorr()
	{
		return valCorr;
	}
	
	/**
	 * @return
	 */
	public char darValIngr()
	{
		return valIngr;
	}
	
	public int darEstado()
	{
		return estado;
	}
	
	public void cambVal(char pIngr)
	{
		char var = pIngr;
		
		valIngr= var;
	}
	
	public void cambEstado(int pEstado)
	{
		estado = pEstado;
	}
	
	public boolean enJuego()
	{
		if (estado == NO_JUGABLE)
		{
			return false;
		}
		else
		{return true;}
		
	}
}
