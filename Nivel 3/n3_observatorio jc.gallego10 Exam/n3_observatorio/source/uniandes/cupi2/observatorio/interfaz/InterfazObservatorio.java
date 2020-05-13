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

package uniandes.cupi2.observatorio.interfaz;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.cupi2.observatorio.mundo.Observatorio;
import uniandes.cupi2.observatorio.mundo.Planeta;
import uniandes.cupi2.observatorio.mundo.SateliteNatural;

/**
 * Ventana principal de la aplicación.
 */
public class InterfazObservatorio extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private Observatorio observatorio;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con las extensiones.
     */
    private PanelExtension panelExtension;

    /**
     * Panel que contiene la imagen del observatorio.
     */
    private PanelImagen panelImagen;

    /**
     * Panel que contiene la información de los planetas.
     */
    private PanelInformacionPlanetas panelPlanetas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor de la interfaz <br>
     */
    public InterfazObservatorio( )
    {
        // Crea la clase principal
        observatorio = new Observatorio( );

        // Construye la forma
        getContentPane( ).setLayout( new BorderLayout( ) );
        setSize( 680, 586 );
        setLocationRelativeTo( null );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setResizable( false );

        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.NORTH );

        panelPlanetas = new PanelInformacionPlanetas( this );
        add( panelPlanetas, BorderLayout.CENTER );

        // Creación de los paneles aquí
        panelExtension = new PanelExtension( this );
        add( panelExtension, BorderLayout.SOUTH );

        setTitle( "Observatorio Cupi2" );
        pack( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Devuele un arreglo con los nombres de los planetas.
     * @return Arreglo con los nombres de los planetas.
     */
    public String[] darNombresPlanetas( )
    {
        return observatorio.darNombresPlanetas( );
    }

    /**
     * Muestra el dialogo para agregar un satélite natural.
     */
    public void mostrarDialogoSateliteCreacion( )
    {
        DialogoInformacionSatelite dialogo = new DialogoInformacionSatelite( this, null, null );
    }

    /**
     * Agrega un nuevo satélite natural al planeta seleccionado.
     * @param pNombreSatelite Nombre del nuevo satélite natural.
     * @param pExcentricidad Excentricidad del nuevo satélite natural. 
     * @param pInclinacion Inclinación del nuevo satélite natural.
     */
    public void agregarSateliteNatural( String pNombreSatelite, double pExcentricidad, double pInclinacion )
    {
        String nombrePlaneta = panelPlanetas.darPlanetaSeleccionado( );
        if( observatorio.agregarSateliteNatural( nombrePlaneta, pNombreSatelite, pExcentricidad, pInclinacion ) )
        {
            JOptionPane.showMessageDialog( this, "Se agregó el satélite natural", "Satélite natural agregado", JOptionPane.INFORMATION_MESSAGE );
            panelPlanetas.llenarListaSatelitesNaturales( darPropiedadesSatelitesNaturales( panelPlanetas.darPlanetaSeleccionado( ) ) );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No se pudo agregar el satélite natural, porque ya existe uno con ese nombre", "Satélite natural no agregado", JOptionPane.ERROR_MESSAGE );
        }
    }
    
    /**
     * Agrega un nuevo satélite artificial al planeta seleccionado.
     * @param pNombre Nombre del nuevo satélite artificial.
     * @param pPais Pais de origen del nuevo satélite artificial.
     * @param pTipo Tipo de servicio que presta el nuevo satélite artificial.
     */
    public void agregarSateliteArtificial(String pNombre, String pPais, String pTipo) {
    	String nombrePlaneta = panelPlanetas.darPlanetaSeleccionado( );
        if( observatorio.agregarSateliteArtificial( nombrePlaneta, pNombre, pPais, pTipo ) )
        {
            JOptionPane.showMessageDialog( this, "Se agregó el satélite artificial.", "Satélite artificial agregado", JOptionPane.INFORMATION_MESSAGE );
            panelPlanetas.llenarInformacionSatelitesArtificial( buscarPlaneta(nombrePlaneta).darSateliteArtificial() );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No se pudo agregar el satélite artificial, porque este planeta ya tiene un satélite artificial.", "Satélite artificial no agregado", JOptionPane.ERROR_MESSAGE );
        }
		
	} 

    /**
     * Elimina un satélite natural de un planeta.
     * @param pNombrePlaneta Nombre del planeta donde se quiere eliminar el satélite. 
     * @param pNombreSatelite Nombre del satélite artificial donde se quiere eliminar el satélite. 
     */
    public void eliminarSateliteArtificial( String pNombrePlaneta, String pNombreSatelite )
    {
        observatorio.eliminarSateliteArtificial(pNombrePlaneta, pNombreSatelite);
        JOptionPane.showMessageDialog( this, "Se eliminó el satélite artificial", "Satélite artificial eliminado", JOptionPane.INFORMATION_MESSAGE );
    }
    
    /**
     * Elimina un satélite natural de un planeta.
     * @param pNombrePlaneta Nombre del planeta donde se quiere eliminar el satélite. 
     * @param pNombreSatelite Nombre del satélite natural donde se quiere eliminar el satélite. 
     */
    public void eliminarSateliteNatural( String pNombrePlaneta, String pNombreSatelite )
    {
        observatorio.eliminarSateliteNatural( pNombrePlaneta, pNombreSatelite );
        panelPlanetas.llenarListaSatelitesNaturales( darPropiedadesSatelitesNaturales( panelPlanetas.darPlanetaSeleccionado( ) ) );
    }

    /**
     * Muestra el dialogo con la información del satélite natural para ser editado.
     * @param pNombrePlaneta Nombre del planeta donde se quiere eliminar el satélite. 
     * @param pNombreSatelite Nombre del satélite natural donde se quiere eliminar el satélite.
     */
    public void mostrarDialogoSateliteEdicion( String pNombrePlaneta, String pNombreSatelite )
    {
        DialogoInformacionSatelite dialogo = new DialogoInformacionSatelite( this, observatorio.buscarSateliteNatural( pNombrePlaneta, pNombreSatelite ), pNombrePlaneta );
    }

    /**
     * Edita las propiedades de un satélite natural identificado con el nombre.
     * @param pNombre Nombre del satélite natural que se quiere editar. 
     * @param pExcentricidad Nuevo valor de la excentricidad.
     * @param pInclinacion Nuevo valor de la inclinación. 
     */
    public void editarSateliteNatural( String pNombre, double pExcentricidad, double pInclinacion )
    {
        observatorio.editarSateliteNatural( panelPlanetas.darPlanetaSeleccionado( ), pNombre, pExcentricidad, pInclinacion );
        panelPlanetas.llenarListaSatelitesNaturales(darPropiedadesSatelitesNaturales( panelPlanetas.darPlanetaSeleccionado( )));
    }

    /**
     * Muestra el dialogo para consultar los satélites dada una excentricidad.
     */
    public void mostrarDialogoConsultarPorExcentricidad( )
    {
        String strPos = JOptionPane.showInputDialog( this, "Ingrese la excentricidad: ", "Satélites con mayor excentricidad", JOptionPane.QUESTION_MESSAGE );
        if( strPos != null )
        {
            try
            {
                double pExcentricidad = Double.parseDouble( strPos );
                ArrayList planetas = observatorio.darSatelitesExcentricidadMayor(pExcentricidad);
                if(planetas.size()==0){
                	JOptionPane.showMessageDialog( this, "No hay registrados satélites naturales con menor excentricidad a "+pExcentricidad, "Satélites con mayor excentricidad", JOptionPane.INFORMATION_MESSAGE );
                }
                else{
                	DialogoListaPlanetas dialogo = new DialogoListaPlanetas( planetas, "Satélites con menor excentricidad a "+pExcentricidad);
                	dialogo.setLocationRelativeTo( this );
                }
            }
            catch( NumberFormatException e )
            {
                JOptionPane.showMessageDialog( this, "Debe ingresar un valor válido.", "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
    }
    
    /**
     * Muestra el dialogo con la respuesta del planeta con mayor número de satélites naturales.
     */
    public void mostrarDialogoConsultarMayorSatelites() {
		
    	Planeta respuesta = observatorio.darPlanetaMasSatelites();
    	if(respuesta ==null){
    		JOptionPane.showMessageDialog( this, "No hay satélites naturales registrados.", "Planeta con mayor número de satélites naturales", JOptionPane.INFORMATION_MESSAGE );
    	}
    	else
    		JOptionPane.showMessageDialog( this, "Planeta con mayor número de satélites naturales: "+ respuesta.darNombre(), "Planeta con mayor número de satélites naturales", JOptionPane.INFORMATION_MESSAGE );
	}
    
    /**
     * Muestra el dialogo con el número de satélites militares.
     */
    public void mostrarDialogoConsultarSateliteMilitar() {
    	JOptionPane.showMessageDialog( this, "El número de satélites militares es: "+ observatorio.darNumeroSatelitesMilitares(), "Satélites de tipo militar", JOptionPane.INFORMATION_MESSAGE );
		
	}

    /**
     * Muestra el dialogo para consultar los planetas que poseen una inclinación menor que un planeta.
     */
    public void mostrarDialogoConsultarPorInclinacion( )
    {
        DialogoComboPlanetas dialogo = new DialogoComboPlanetas( this, observatorio.darNombresPlanetas( ) );
    }

    /**
     * Consulta los planetas que tienen menor inclinación que la del planeta dado.
     * @param nombrePlaneta Nombre del planeta al cual se le quiere compara la inclinación.
     */
    public void consultarPlanetasPorInclinacion( String nombrePlaneta )
    {
    	ArrayList planetas = observatorio.darPlanetasPorInclinacion( nombrePlaneta ); 
    	if(planetas.size()==0){
         	JOptionPane.showMessageDialog( this, "No hay planetas con menor inclinación a "+nombrePlaneta,  "Planetas con menor inclinación a "+nombrePlaneta, JOptionPane.INFORMATION_MESSAGE );
         }
         else{
        	 DialogoListaPlanetas dialogo = new DialogoListaPlanetas( planetas , "Planetas con menor inclinación a "+nombrePlaneta);
             dialogo.setLocationRelativeTo( this );
         }  
    }

    /**
     * Devuelve una lista con las propiedades de los satélites naturales de un planeta especificado.
     * @param pNombrePlaneta Nombre del planeta del que se desea conocer sus satélites naturales.
     * @return Arraylist con las propiedades de los satélites naturales de un planeta dado. Lista vacia si no el planeta no tiene satélites naturales.
     */
    public ArrayList darPropiedadesSatelitesNaturales( String pNombrePlaneta )
    {
        ArrayList nombres = new ArrayList( );
        ArrayList satelitesNaturales = observatorio.darSatelitesNaturales( pNombrePlaneta );
        for( int i = 0; i < satelitesNaturales.size( ); i++ )
        {
        	SateliteNatural actual = (SateliteNatural) satelitesNaturales.get( i );
            nombres.add( actual.toString());
        }
        return nombres;
    }
    
    /**
     * Busca una planeta dado su nombre.
     * @param pNombrePlaneta  Nombre del planeta que se quiere buscar.
     * @return Planeta buscado.
     */
    public Planeta buscarPlaneta(String pNombrePlaneta){
    	return observatorio.buscarPlaneta(pNombrePlaneta);
    }
    
    /**
     * Actualiza la información de los satélites naturales y artificiales del planeta actual.
     */
    public void actualizarSatelites(){
    	panelPlanetas.llenarListaSatelitesNaturales( darPropiedadesSatelitesNaturales( panelPlanetas.darPlanetaSeleccionado( ) ) );
    	panelPlanetas.llenarInformacionSatelitesArtificial( buscarPlaneta(panelPlanetas.darPlanetaSeleccionado( )).darSateliteArtificial() );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     */
    public void reqFuncOpcion1( )
    {
        String resultado = observatorio.metodo1( );
        actualizarSatelites();
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2.
     */
    public void reqFuncOpcion2( )
    {
        String resultado = observatorio.metodo2( );
        actualizarSatelites();
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz.
     * @param args. Argumentos del llamado. No se requiere ninguno.
     */
    public static void main( String[] args )
    {
        InterfazObservatorio interfaz = new InterfazObservatorio( );
        interfaz.setVisible( true );
    }

	

	
}