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
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Clase que representa el visor de mitologías.
 */
public class VisorMitologias 
{   
	//-------------------------------------------------------------
	// Atributos
	//-------------------------------------------------------------

	/**
	 * Posición de la mitología actual en la lista.
	 */
	private int posicionMitologiaActual;

	/**
	 * Lista de las mitologías.
	 */
	private ArrayList mitologias;

	//-------------------------------------------------------------
	// Constructores
	//-------------------------------------------------------------

	/**
	 * Construye un nuevo visor de mitologías inicializando la lista de mitologías.<br>
	 * Debe cargar toda la información del visor desde el archivo de propiedades.<br>
	 * <b>post: </b> La posición de la mitología actual debe ser 0.<br>
	 * @throws Exception Si se presentan problemas en la lectura del archivo que contiene la información de las mitologías.
	 */
	public VisorMitologias( ) throws Exception
	{
		posicionMitologiaActual = 0;
		mitologias = new ArrayList( );
		File archivo = new File( "./data/visorMitologias.properties" );
		Properties datos = new Properties( );
		FileInputStream in = new FileInputStream( archivo );

		try
		{
			datos.load( in );
			in.close( );
		}
		catch( Exception e )
		{
			throw new Exception( "Formato inválido" );
		}

		int numeroMitologias = Integer.parseInt( datos.getProperty( "visorMitologias.numeroMitologias" ) );

		for( int i = 1; i <= numeroMitologias; i++ )
		{
			String nombreMitologia = datos.getProperty( "visorMitologias.mitologia" + i + ".nombre" );
			String descripcionMitologia = datos.getProperty( "visorMitologias.mitologia" + i + ".descripcion" );
			String lugarMitologia = datos.getProperty( "visorMitologias.mitologia" + i + ".lugar" );
			String rutaImagenMitologia = datos.getProperty( "visorMitologias.mitologia" + i + ".rutaImagen" );
			int numeroDioses = Integer.parseInt( datos.getProperty( "visorMitologias.mitologia" + i + ".numeroDioses" ) );
			String colorRStr = datos.getProperty( "visorMitologias.mitologia" + i + ".colorR" );
			String colorGStr = datos.getProperty( "visorMitologias.mitologia" + i + ".colorG" );
			String colorBStr = datos.getProperty( "visorMitologias.mitologia" + i + ".colorB" );
			int colorR = Integer.parseInt(colorRStr);
			int colorG = Integer.parseInt(colorGStr);
			int colorB = Integer.parseInt(colorBStr);
			Color color = new Color(colorR, colorG, colorB);


			agregarMitologia( nombreMitologia, descripcionMitologia, lugarMitologia, rutaImagenMitologia, color );
			Mitologia nuevaMitologia = buscarMitologia(nombreMitologia);

			for( int j = 1; j <= numeroDioses; j++ )
			{
				String nombreDios = datos.getProperty( "visorMitologias.mitologia" + i + ".dios" + j + ".nombre" );
				String descripcionDios = datos.getProperty( "visorMitologias.mitologia" + i + ".dios" + j + ".descripcion" );
				String especialidadDios = datos.getProperty( "visorMitologias.mitologia" + i + ".dios" + j + ".especialidad" );
				String rutaImagenDios = datos.getProperty( "visorMitologias.mitologia" + i + ".dios" + j + ".rutaImagen" );
				String esPrincipalStr = datos.getProperty( "visorMitologias.mitologia" + i + ".dios" + j + ".esPrincipal" );
				boolean esPrincipal = false;
				if(esPrincipalStr.equals("si"))
				{
					esPrincipal = true;
				}
				nuevaMitologia.agregarDios( nombreDios, descripcionDios, especialidadDios, rutaImagenDios, esPrincipal );
			}
		}
		posicionMitologiaActual=0;
	}

	//-------------------------------------------------------------
	// Métodos
	//-------------------------------------------------------------

	/**
	 * Retorna la mitología actual.
	 * @return Mitología actual.
	 */
	public Mitologia darMitologiaActual( )
	{
		Mitologia actual = ( Mitologia )mitologias.get( posicionMitologiaActual );
		return actual;
	}


	/**
	 * Agrega una nueva mitología.<br>
	 * <b>pre: </b> La lista de mitologías esta inicializada.<br>
	 * @param pNombreMitologia Nombre de la mitología. pNombreMitologia != null && pNombreMitologia != "".
	 * @param pDescripcion Descripción de la mitología. pDescripcion != null && pDescripcion != "".
	 * @param pLugar Lugar de origen de la mitología. pLugar != null && pLugar != "".
	 * @param pRutaImagenMitologia Ruta de la imagen de la mitología. pRutaImagenMitologia != null && pRutaImagenMitologia != "".
	 * @param pColor Color de la mitología. pColor != null.
	 * @throws Exception Si ya existe una mitología con el nombre dado.
	 */
	private void agregarMitologia( String pNombreMitologia, String pDescripcion, String pLugar, String pRutaImagenMitologia, Color pColor ) throws Exception
	{
		Mitologia nueva = buscarMitologia(pNombreMitologia);
		if(nueva != null)
		{
			throw new Exception ( "La mitología con el nombre "+ pNombreMitologia + " ya existe." );
		}
		Mitologia nuevaMitologia = new Mitologia( pNombreMitologia, pDescripcion, pLugar, pRutaImagenMitologia, pColor );
		mitologias.add( nuevaMitologia );
	}

	/**
	 * Retorna la primera mitología.
	 * <b>pre: </b> La lista de mitologías está inicializada.
	 * <b>post: </b> Retrocede hasta la primera mitología.
	 * 				 La posición de la mitología actual corresponde a la de la primera mitología.
	 * @return Primera mitología.
	 * @throws Exception Si la mitología actual es la primera.
	 */
	public Mitologia darPrimeraMitologia( ) throws Exception
	{
		if( posicionMitologiaActual == 0 )
		{
			throw new Exception( "Se encuentra en la primera mitología." );

		}

		posicionMitologiaActual = 0;
		Mitologia mitologiaPrimera = ( Mitologia )mitologias.get( posicionMitologiaActual );
		return mitologiaPrimera;
	}

	/**
	 * Retorna la mitología anterior.
	 * <b>pre: </b> La lista de mitologías está inicializada.
	 * <b>post: </b> Retrocede una posición en la lista de mitologías.
	 * 				 La posición de la mitología actual corresponde a la de la mitología anterior.
	 * @return Mitología anterior.
	 * @throws Exception Si la mitología actual es la primera.
	 */
	public Mitologia darMitologiaAnterior( ) throws Exception
	{

		if( posicionMitologiaActual == 0 )
		{
			throw new Exception( "Se encuentra en la primera mitología." );

		}

		posicionMitologiaActual--;
		Mitologia mitologiaAnterior = ( Mitologia )mitologias.get( posicionMitologiaActual );
		return mitologiaAnterior;
	}

	/**
	 * Retorna la mitología siguiente.
	 * <b>pre: </b> La lista de mitologías está inicializada.
	 * <b>post: </b> Avanza una posición en la lista de mitologías.
	 * 				 La posición de la mitología actual corresponde a la de la mitología siguiente.
	 * @return Mitología siguiente.
	 * @throws Exception Si la mitología actual es la última.
	 */
	public Mitologia darMitologiaSiguiente( ) throws Exception
	{
		if( posicionMitologiaActual == mitologias.size( ) - 1  )
		{
			throw new Exception( "Se encuentra en la última mitología." );

		}

		posicionMitologiaActual++;
		Mitologia mitologiaSiguiente = ( Mitologia )mitologias.get( posicionMitologiaActual );
		return mitologiaSiguiente;
	}

	/**
	 * Retorna la última mitología.
	 * <b>pre: </b> La lista de mitologías está inicializada.
	 * <b>post: </b> Avanza hasta la última posición en la lista de mitologías.
	 * 				 La posición de la mitología actual corresponde a la de la última mitología.
	 * @return Última mitología.
	 * @throws Exception Si la mitología actual es la última.
	 */
	public Mitologia darUltimaMitologia( ) throws Exception
	{
		if( posicionMitologiaActual == mitologias.size( ) - 1  )
		{
			throw new Exception( "Se encuentra en la última mitología." );

		}

		posicionMitologiaActual = mitologias.size( ) - 1;
		Mitologia mitologiaUltima = ( Mitologia )mitologias.get( posicionMitologiaActual );
		return mitologiaUltima;
	}

	/**
	 * Busca una mitología dado su nombre por parámetro.<br>
	 * <b>pre: </b> La lista de mitologías está inicializada.<br>
	 * <b>post: </b> Se actualiza la posición de la mitología actual con la encontrada.
	 * @param pNombreMitologia Nombre de la mitología. pNombreMitologia != null && pNombreMitologia != ""
	 * @return Mitología con el nombre dado por parámetro, null en caso de no encontrarla.
	 */
	public Mitologia buscarMitologia( String pNombreMitologia )
	{
		Mitologia buscada = null;
		boolean encontro = false;
		
		for( int i = 0; i < mitologias.size( ) && !encontro; i++ )
		{
			Mitologia actual = ( Mitologia )mitologias.get( i );

			if( actual.darNombre( ).equalsIgnoreCase( pNombreMitologia ) )
			{
				posicionMitologiaActual = i;
				encontro = true;
				buscada = actual;
			}
		}

		return buscada;
	}

	/**
	 * Busca todos los dioses de todas las mitologías que tienen la especialidad recibida por parámetro.<br>
	 * <b>pre: </b> La lista de mitologías está inicializada.
	 * @param pEspecialidadDios Especialidad buscada. pEspecialidadDios != null && pEspecialidadDios != ""
	 * @return Lista con los nombres de todos los dioses que tienen la especialidad dada.
	 */
	public ArrayList buscarDiosesPorEspecialidad( String pEspecialidadDios )
	{
		ArrayList dioses = new ArrayList( );

		for( int i = 0; i < mitologias.size( ); i++ )
		{
			Mitologia actual = ( Mitologia )mitologias.get( i );
			ArrayList diosesEspecialidad = actual.buscarDiosesPorEspecialidad( pEspecialidadDios );
			for (int j = 0; j < diosesEspecialidad.size(); j++) 
			{
				String diosActual = ( String ) diosesEspecialidad.get( j );
				dioses.add(diosActual);
			}
		}

		return dioses;
	}

	//-------------------------------------------------------------
	// Puntos de extensión
	//-------------------------------------------------------------

	/**
	 * Método para la extensión 1.
	 * @return respuesta 1.
	 */
	public String metodo1( )
	{
		return "Respuesta 1";
	}

	/**
	 * Método para la extensión 2.
	 * @return respuesta 2.
	 */
	public String metodo2( )
	{
		return "Respuesta 2";
	}
}