/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n5_visorMitologias
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.visorMitologias.mundo;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Clase que representa una mitología.
 */
public class Mitologia  
{
	//-------------------------------------------------------------
	// Atributos
	//-------------------------------------------------------------

	/**
	 * Nombre de la mitología.
	 */
	private String nombre;

	/**
	 * Descripción de la mitología.
	 */
	private String descripcion;

	/**
	 * Lugar de origen de la mitología.
	 */
	private String lugar;

	/**
	 * Ruta de la imagen de la mitología.
	 */
	private String rutaImagen;

	/**
	 * Posición del dios actual en la lista.
	 */
	private int posicionDiosActual;

	/**
	 * Dioses de la mitología.
	 */
	private ArrayList dioses;

	/**
	 * Color que representa la mitología.
	 */
	private Color color;

	//-------------------------------------------------------------
	// Constructores
	//-------------------------------------------------------------

	/**
	 * Construye una nueva mitología con la información dada por parámetro.<br>
	 * <b>post: </b> La posición del dios actual es la 0.
	 * <b>post: </b> Crea la lista de dioses como un vector vacío.
	 * @param pNombre Nombre de la mitología. pNombre != null && pNombre != "".
	 * @param pDescripcion Descripción de la mitología. pDescripcion != null && pDescripcion != "".
	 * @param pLugar Lugar de origen de la mitología. pLugar != null && pLugar != "".
	 * @param pRutaImagen Ruta de la imagen de la mitología. pRutaImagen != null && pRutaImagen != "".
	 * @param pColor Color de la mitología. pColor != null.
	 */
	public Mitologia( String pNombre, String pDescripcion, String pLugar, String pRutaImagen, Color pColor )
	{
		nombre = pNombre;
		descripcion = pDescripcion;
		lugar = pLugar;
		rutaImagen = pRutaImagen;
		posicionDiosActual = 0;
		dioses = new ArrayList( );
		color = pColor;
	}

	//-------------------------------------------------------------
	// Métodos
	//-------------------------------------------------------------

	/**
	 * Retorna el dios actual de la mitología.
	 * @return Dios actual de la mitología.
	 */
	public Dios darDiosActual( )
	{
		Dios actual = ( Dios )dioses.get( posicionDiosActual );
		return actual;
	}

	/**
	 * Retorna el nombre de la mitología.
	 * @return Nombre de la mitología.
	 */
	public String darNombre( )
	{
		return nombre;
	}

	/**
	 * Retorna la descripción de la mitología.
	 * @return Descripción de la mitología.
	 */
	public String darDescripcion( )
	{
		return descripcion;
	}

	/**
	 * Retorna el lugar de origen de la mitología.
	 * @return Lugar de origen de la mitología.
	 */
	public String darLugar( )
	{
		return lugar;
	}

	/**
	 * Retorna la ruta de la imagen de la mitología.
	 * @return Ruta de la imagen de la mitología.
	 */
	public String darRutaImagen( )
	{
		return rutaImagen;
	}

	/**
	 * Retorna los dioses de la mitología.
	 * @return Lista de dioses de la mitología.
	 */
	public ArrayList darDioses( )
	{
		return dioses;
	}	

	/**
	 * Retorna el color de la mitología.
	 * @return Color de la mitología.
	 */
	public Color darColor( )
	{
		return color;
	}

	/**
	 * Busca un dios dado su nombre por parámetro.
	 * @param pNombre Nombre del dios a buscar. pNombre != null && pNombre != "".
	 * @return Dios que tiene el nombre dado, null si no lo encuentra.
	 */
	private Dios buscarDios( String pNombre )
	{
		Dios rta = null;
		boolean existe = false;
		for(int i = 0; i < dioses.size() && !existe; i ++)
		{
			Dios actual = (Dios) dioses.get(i);
			if(actual.darNombre().equals(pNombre))
			{
				existe= true;
				rta = actual;
			}
		}
		return rta;
	}

	/**
	 * Agrega un nuevo dios en la mitología.<br>
	 * <b>pre: </b> La lista de dioses esta inicializada.<br>
	 * <b>post: </b> Se agregó un nuevo dios.
	 * @param pNombreDios Nombre del dios. pNombreDios != null && pNombreDios != "".
	 * @param pDescripcion Descripción del dios. pDescripcion != null && pDescripcion != "".
	 * @param pEspecialidad Especialidad del dios. pEspecialidad != null && pEspecialidad != "".
	 * @param pRutaImagenDios Ruta de la imagen del dios. pRutaImagenDios != null && pRutaImagenDios != "".
	 * @param pEsPrincipal True si el dios es principal, false de lo contrario.
	 * @throws Exception Si ya existe un dios en la mitología con el nombre dado. 
	 */
	public void agregarDios( String pNombreDios, String pDescripcion, String pEspecialidad, String pRutaImagenDios, boolean pEsPrincipal) throws Exception
	{
		Dios nuevo = buscarDios(pNombreDios);
		if(nuevo!= null)
		{
			throw new Exception ( "Ya existe en la mitolgoía un dios con el nombre dado." );
		}

		Dios nuevoDios = new Dios( pNombreDios, pDescripcion, pEspecialidad, pRutaImagenDios, pEsPrincipal );
		dioses.add( nuevoDios );
	}

	/**
	 * Retorna el primer dios de la mitología.
	 * <b>pre: </b> La lista de dioses está inicializada.
	 * <b>post: </b> Retrocede hasta el primer dios.
	 * 				 La posición del dios actual corresponde a la del primer dios de la lista.
	 * @return Primer dios de la mitología.
	 * @throws Exception Si el dios actual es el primero.
	 */
	public Dios darPrimerDios( ) throws Exception
	{
		if( posicionDiosActual == 0 )
		{
			throw new Exception( "Se encuentra en el primer dios." );
		}

		posicionDiosActual = 0;
		Dios diosPrimero = ( Dios )dioses.get( posicionDiosActual );
		return diosPrimero;

	}

	/**
	 * Retorna el dios anterior de la mitología.
	 * <b>pre: </b> La lista de dioses está inicializada.
	 * <b>post: </b> Retrocede una posición en la lista de dioses.
	 * 				 La posición del dios actual corresponde a la del dios anterior en la lista.
	 * @return Dios anterior en la lista de dioses.
	 * @throws Exception Si el dios actual es el primero.
	 */
	public Dios darDiosAnterior( ) throws Exception
	{
		if( posicionDiosActual == 0 )
		{
			throw new Exception( "Se encuentra en el primer dios." );
		}

		posicionDiosActual--;
		Dios diosAnterior = ( Dios )dioses.get( posicionDiosActual );
		return diosAnterior;
	}

	/**
	 * Retorna el dios siguiente de la mitología.
	 * <b>pre: </b> La lista de dioses está inicializada.
	 * <b>post: </b> Avanza una posición en la lista de dioses.
	 * 				 La posición del dios actual corresponde a la del dios siguiente en la lista.
	 * @return Dios siguiente de la mitología.
	 * @throws Exception Si el dios actual es el último.
	 */
	public Dios darDiosSiguiente( ) throws Exception
	{
		if( posicionDiosActual == dioses.size( ) - 1 )
		{
			throw new Exception( "Se encuentra en el último dios." );

		}

		posicionDiosActual++;
		Dios diosSiguiente = ( Dios )dioses.get( posicionDiosActual );
		return diosSiguiente;
	}

	/**
	 * Retorna el último dios de la mitología
	 * <b>pre: </b> La lista de dioses está inicializada.
	 * <b>post: </b> Avanza hasta el último dios.
	 * 				 La posición del dios actual corresponde a la del último dios de la lista.
	 * @return Último dios de la mitología.
	 * @throws Exception Si el dios actual es el último.
	 */
	public Dios darUltimoDios( ) throws Exception
	{
		if( posicionDiosActual == dioses.size( ) - 1 )
		{
			throw new Exception( "Se encuentra en el último dios." );

		}

		posicionDiosActual = dioses.size( ) - 1;
		Dios diosUltimo = ( Dios )dioses.get( posicionDiosActual );
		return diosUltimo;
	}

	/**
	 * Busca todos los dioses que tienen la especialidad dada.<br>
	 * <b>pre: </b> La lista de dioses esta inicializada.
	 * @param pEspecialidad Eespecialidad buscada. pEspecialidad != null && pEspecialidad != ""
	 * @return Lista con los nombres de todos los dioses que tienen la especialidad dada.
	 */
	public ArrayList buscarDiosesPorEspecialidad( String pEspecialidad )
	{
		ArrayList diosesEspecialidad = new ArrayList( );

		for( int i = 0; i < dioses.size( ); i++ )
		{
			Dios actual = ( Dios )dioses.get( i );

			if( actual.darEspecialidad( ).toLowerCase( ).equals( pEspecialidad.toLowerCase( ) ) )
			{
				diosesEspecialidad.add( actual.darNombre( ) );
			}
		}

		return diosesEspecialidad;
	}


	/**
	 * retorna la posicion del dios actual
	 * @return posicion del dios actual
	 */
	public int darPosicionDiosActual()
	{

		return posicionDiosActual + 1;

	}


	/**
	 * retorna el total de dioses que tiene la mitolodia
	 * @return total de dioses que tiene la mitolodia
	 */
	public int darTotalDioses()
	{
		return dioses.size();
	}
}