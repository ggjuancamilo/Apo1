/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
 * Clase que representa una mitolog�a.
 */
public class Mitologia  
{
	//-------------------------------------------------------------
	// Atributos
	//-------------------------------------------------------------

	/**
	 * Nombre de la mitolog�a.
	 */
	private String nombre;

	/**
	 * Descripci�n de la mitolog�a.
	 */
	private String descripcion;

	/**
	 * Lugar de origen de la mitolog�a.
	 */
	private String lugar;

	/**
	 * Ruta de la imagen de la mitolog�a.
	 */
	private String rutaImagen;

	/**
	 * Posici�n del dios actual en la lista.
	 */
	private int posicionDiosActual;

	/**
	 * Dioses de la mitolog�a.
	 */
	private ArrayList dioses;

	/**
	 * Color que representa la mitolog�a.
	 */
	private Color color;

	//-------------------------------------------------------------
	// Constructores
	//-------------------------------------------------------------

	/**
	 * Construye una nueva mitolog�a con la informaci�n dada por par�metro.<br>
	 * <b>post: </b> La posici�n del dios actual es la 0.
	 * <b>post: </b> Crea la lista de dioses como un vector vac�o.
	 * @param pNombre Nombre de la mitolog�a. pNombre != null && pNombre != "".
	 * @param pDescripcion Descripci�n de la mitolog�a. pDescripcion != null && pDescripcion != "".
	 * @param pLugar Lugar de origen de la mitolog�a. pLugar != null && pLugar != "".
	 * @param pRutaImagen Ruta de la imagen de la mitolog�a. pRutaImagen != null && pRutaImagen != "".
	 * @param pColor Color de la mitolog�a. pColor != null.
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
	// M�todos
	//-------------------------------------------------------------

	/**
	 * Retorna el dios actual de la mitolog�a.
	 * @return Dios actual de la mitolog�a.
	 */
	public Dios darDiosActual( )
	{
		Dios actual = ( Dios )dioses.get( posicionDiosActual );
		return actual;
	}

	/**
	 * Retorna el nombre de la mitolog�a.
	 * @return Nombre de la mitolog�a.
	 */
	public String darNombre( )
	{
		return nombre;
	}

	/**
	 * Retorna la descripci�n de la mitolog�a.
	 * @return Descripci�n de la mitolog�a.
	 */
	public String darDescripcion( )
	{
		return descripcion;
	}

	/**
	 * Retorna el lugar de origen de la mitolog�a.
	 * @return Lugar de origen de la mitolog�a.
	 */
	public String darLugar( )
	{
		return lugar;
	}

	/**
	 * Retorna la ruta de la imagen de la mitolog�a.
	 * @return Ruta de la imagen de la mitolog�a.
	 */
	public String darRutaImagen( )
	{
		return rutaImagen;
	}

	/**
	 * Retorna los dioses de la mitolog�a.
	 * @return Lista de dioses de la mitolog�a.
	 */
	public ArrayList darDioses( )
	{
		return dioses;
	}	

	/**
	 * Retorna el color de la mitolog�a.
	 * @return Color de la mitolog�a.
	 */
	public Color darColor( )
	{
		return color;
	}

	/**
	 * Busca un dios dado su nombre por par�metro.
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
	 * Agrega un nuevo dios en la mitolog�a.<br>
	 * <b>pre: </b> La lista de dioses esta inicializada.<br>
	 * <b>post: </b> Se agreg� un nuevo dios.
	 * @param pNombreDios Nombre del dios. pNombreDios != null && pNombreDios != "".
	 * @param pDescripcion Descripci�n del dios. pDescripcion != null && pDescripcion != "".
	 * @param pEspecialidad Especialidad del dios. pEspecialidad != null && pEspecialidad != "".
	 * @param pRutaImagenDios Ruta de la imagen del dios. pRutaImagenDios != null && pRutaImagenDios != "".
	 * @param pEsPrincipal True si el dios es principal, false de lo contrario.
	 * @throws Exception Si ya existe un dios en la mitolog�a con el nombre dado. 
	 */
	public void agregarDios( String pNombreDios, String pDescripcion, String pEspecialidad, String pRutaImagenDios, boolean pEsPrincipal) throws Exception
	{
		Dios nuevo = buscarDios(pNombreDios);
		if(nuevo!= null)
		{
			throw new Exception ( "Ya existe en la mitolgo�a un dios con el nombre dado." );
		}

		Dios nuevoDios = new Dios( pNombreDios, pDescripcion, pEspecialidad, pRutaImagenDios, pEsPrincipal );
		dioses.add( nuevoDios );
	}

	/**
	 * Retorna el primer dios de la mitolog�a.
	 * <b>pre: </b> La lista de dioses est� inicializada.
	 * <b>post: </b> Retrocede hasta el primer dios.
	 * 				 La posici�n del dios actual corresponde a la del primer dios de la lista.
	 * @return Primer dios de la mitolog�a.
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
	 * Retorna el dios anterior de la mitolog�a.
	 * <b>pre: </b> La lista de dioses est� inicializada.
	 * <b>post: </b> Retrocede una posici�n en la lista de dioses.
	 * 				 La posici�n del dios actual corresponde a la del dios anterior en la lista.
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
	 * Retorna el dios siguiente de la mitolog�a.
	 * <b>pre: </b> La lista de dioses est� inicializada.
	 * <b>post: </b> Avanza una posici�n en la lista de dioses.
	 * 				 La posici�n del dios actual corresponde a la del dios siguiente en la lista.
	 * @return Dios siguiente de la mitolog�a.
	 * @throws Exception Si el dios actual es el �ltimo.
	 */
	public Dios darDiosSiguiente( ) throws Exception
	{
		if( posicionDiosActual == dioses.size( ) - 1 )
		{
			throw new Exception( "Se encuentra en el �ltimo dios." );

		}

		posicionDiosActual++;
		Dios diosSiguiente = ( Dios )dioses.get( posicionDiosActual );
		return diosSiguiente;
	}

	/**
	 * Retorna el �ltimo dios de la mitolog�a
	 * <b>pre: </b> La lista de dioses est� inicializada.
	 * <b>post: </b> Avanza hasta el �ltimo dios.
	 * 				 La posici�n del dios actual corresponde a la del �ltimo dios de la lista.
	 * @return �ltimo dios de la mitolog�a.
	 * @throws Exception Si el dios actual es el �ltimo.
	 */
	public Dios darUltimoDios( ) throws Exception
	{
		if( posicionDiosActual == dioses.size( ) - 1 )
		{
			throw new Exception( "Se encuentra en el �ltimo dios." );

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