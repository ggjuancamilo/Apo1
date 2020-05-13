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
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Clase que representa el visor de mitolog�as.
 */
public class VisorMitologias 
{   
	//-------------------------------------------------------------
	// Atributos
	//-------------------------------------------------------------

	/**
	 * Posici�n de la mitolog�a actual en la lista.
	 */
	private int posicionMitologiaActual;

	/**
	 * Lista de las mitolog�as.
	 */
	private ArrayList mitologias;

	//-------------------------------------------------------------
	// Constructores
	//-------------------------------------------------------------

	/**
	 * Construye un nuevo visor de mitolog�as inicializando la lista de mitolog�as.<br>
	 * Debe cargar toda la informaci�n del visor desde el archivo de propiedades.<br>
	 * <b>post: </b> La posici�n de la mitolog�a actual debe ser 0.<br>
	 * @throws Exception Si se presentan problemas en la lectura del archivo que contiene la informaci�n de las mitolog�as.
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
			throw new Exception( "Formato inv�lido" );
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
	// M�todos
	//-------------------------------------------------------------

	/**
	 * Retorna la mitolog�a actual.
	 * @return Mitolog�a actual.
	 */
	public Mitologia darMitologiaActual( )
	{
		Mitologia actual = ( Mitologia )mitologias.get( posicionMitologiaActual );
		return actual;
	}


	/**
	 * Agrega una nueva mitolog�a.<br>
	 * <b>pre: </b> La lista de mitolog�as esta inicializada.<br>
	 * @param pNombreMitologia Nombre de la mitolog�a. pNombreMitologia != null && pNombreMitologia != "".
	 * @param pDescripcion Descripci�n de la mitolog�a. pDescripcion != null && pDescripcion != "".
	 * @param pLugar Lugar de origen de la mitolog�a. pLugar != null && pLugar != "".
	 * @param pRutaImagenMitologia Ruta de la imagen de la mitolog�a. pRutaImagenMitologia != null && pRutaImagenMitologia != "".
	 * @param pColor Color de la mitolog�a. pColor != null.
	 * @throws Exception Si ya existe una mitolog�a con el nombre dado.
	 */
	private void agregarMitologia( String pNombreMitologia, String pDescripcion, String pLugar, String pRutaImagenMitologia, Color pColor ) throws Exception
	{
		Mitologia nueva = buscarMitologia(pNombreMitologia);
		if(nueva != null)
		{
			throw new Exception ( "La mitolog�a con el nombre "+ pNombreMitologia + " ya existe." );
		}
		Mitologia nuevaMitologia = new Mitologia( pNombreMitologia, pDescripcion, pLugar, pRutaImagenMitologia, pColor );
		mitologias.add( nuevaMitologia );
	}

	/**
	 * Retorna la primera mitolog�a.
	 * <b>pre: </b> La lista de mitolog�as est� inicializada.
	 * <b>post: </b> Retrocede hasta la primera mitolog�a.
	 * 				 La posici�n de la mitolog�a actual corresponde a la de la primera mitolog�a.
	 * @return Primera mitolog�a.
	 * @throws Exception Si la mitolog�a actual es la primera.
	 */
	public Mitologia darPrimeraMitologia( ) throws Exception
	{
		if( posicionMitologiaActual == 0 )
		{
			throw new Exception( "Se encuentra en la primera mitolog�a." );

		}

		posicionMitologiaActual = 0;
		Mitologia mitologiaPrimera = ( Mitologia )mitologias.get( posicionMitologiaActual );
		return mitologiaPrimera;
	}

	/**
	 * Retorna la mitolog�a anterior.
	 * <b>pre: </b> La lista de mitolog�as est� inicializada.
	 * <b>post: </b> Retrocede una posici�n en la lista de mitolog�as.
	 * 				 La posici�n de la mitolog�a actual corresponde a la de la mitolog�a anterior.
	 * @return Mitolog�a anterior.
	 * @throws Exception Si la mitolog�a actual es la primera.
	 */
	public Mitologia darMitologiaAnterior( ) throws Exception
	{

		if( posicionMitologiaActual == 0 )
		{
			throw new Exception( "Se encuentra en la primera mitolog�a." );

		}

		posicionMitologiaActual--;
		Mitologia mitologiaAnterior = ( Mitologia )mitologias.get( posicionMitologiaActual );
		return mitologiaAnterior;
	}

	/**
	 * Retorna la mitolog�a siguiente.
	 * <b>pre: </b> La lista de mitolog�as est� inicializada.
	 * <b>post: </b> Avanza una posici�n en la lista de mitolog�as.
	 * 				 La posici�n de la mitolog�a actual corresponde a la de la mitolog�a siguiente.
	 * @return Mitolog�a siguiente.
	 * @throws Exception Si la mitolog�a actual es la �ltima.
	 */
	public Mitologia darMitologiaSiguiente( ) throws Exception
	{
		if( posicionMitologiaActual == mitologias.size( ) - 1  )
		{
			throw new Exception( "Se encuentra en la �ltima mitolog�a." );

		}

		posicionMitologiaActual++;
		Mitologia mitologiaSiguiente = ( Mitologia )mitologias.get( posicionMitologiaActual );
		return mitologiaSiguiente;
	}

	/**
	 * Retorna la �ltima mitolog�a.
	 * <b>pre: </b> La lista de mitolog�as est� inicializada.
	 * <b>post: </b> Avanza hasta la �ltima posici�n en la lista de mitolog�as.
	 * 				 La posici�n de la mitolog�a actual corresponde a la de la �ltima mitolog�a.
	 * @return �ltima mitolog�a.
	 * @throws Exception Si la mitolog�a actual es la �ltima.
	 */
	public Mitologia darUltimaMitologia( ) throws Exception
	{
		if( posicionMitologiaActual == mitologias.size( ) - 1  )
		{
			throw new Exception( "Se encuentra en la �ltima mitolog�a." );

		}

		posicionMitologiaActual = mitologias.size( ) - 1;
		Mitologia mitologiaUltima = ( Mitologia )mitologias.get( posicionMitologiaActual );
		return mitologiaUltima;
	}

	/**
	 * Busca una mitolog�a dado su nombre por par�metro.<br>
	 * <b>pre: </b> La lista de mitolog�as est� inicializada.<br>
	 * <b>post: </b> Se actualiza la posici�n de la mitolog�a actual con la encontrada.
	 * @param pNombreMitologia Nombre de la mitolog�a. pNombreMitologia != null && pNombreMitologia != ""
	 * @return Mitolog�a con el nombre dado por par�metro, null en caso de no encontrarla.
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
	 * Busca todos los dioses de todas las mitolog�as que tienen la especialidad recibida por par�metro.<br>
	 * <b>pre: </b> La lista de mitolog�as est� inicializada.
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
	// Puntos de extensi�n
	//-------------------------------------------------------------

	/**
	 * M�todo para la extensi�n 1.
	 * @return respuesta 1.
	 */
	public String metodo1( )
	{
		return "Respuesta 1";
	}

	/**
	 * M�todo para la extensi�n 2.
	 * @return respuesta 2.
	 */
	public String metodo2( )
	{
		return "Respuesta 2";
	}
}