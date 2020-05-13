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

package uniandes.cupi2.observatorio.interfaz;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.cupi2.observatorio.mundo.Observatorio;
import uniandes.cupi2.observatorio.mundo.Planeta;
import uniandes.cupi2.observatorio.mundo.SateliteNatural;

/**
 * Ventana principal de la aplicaci�n.
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
     * Panel que contiene la informaci�n de los planetas.
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

        // Creaci�n de los paneles aqu�
        panelExtension = new PanelExtension( this );
        add( panelExtension, BorderLayout.SOUTH );

        setTitle( "Observatorio Cupi2" );
        pack( );
    }

    // -----------------------------------------------------------------
    // M�todos
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
     * Muestra el dialogo para agregar un sat�lite natural.
     */
    public void mostrarDialogoSateliteCreacion( )
    {
        DialogoInformacionSatelite dialogo = new DialogoInformacionSatelite( this, null, null );
    }

    /**
     * Agrega un nuevo sat�lite natural al planeta seleccionado.
     * @param pNombreSatelite Nombre del nuevo sat�lite natural.
     * @param pExcentricidad Excentricidad del nuevo sat�lite natural. 
     * @param pInclinacion Inclinaci�n del nuevo sat�lite natural.
     */
    public void agregarSateliteNatural( String pNombreSatelite, double pExcentricidad, double pInclinacion )
    {
        String nombrePlaneta = panelPlanetas.darPlanetaSeleccionado( );
        if( observatorio.agregarSateliteNatural( nombrePlaneta, pNombreSatelite, pExcentricidad, pInclinacion ) )
        {
            JOptionPane.showMessageDialog( this, "Se agreg� el sat�lite natural", "Sat�lite natural agregado", JOptionPane.INFORMATION_MESSAGE );
            panelPlanetas.llenarListaSatelitesNaturales( darPropiedadesSatelitesNaturales( panelPlanetas.darPlanetaSeleccionado( ) ) );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No se pudo agregar el sat�lite natural, porque ya existe uno con ese nombre", "Sat�lite natural no agregado", JOptionPane.ERROR_MESSAGE );
        }
    }
    
    /**
     * Agrega un nuevo sat�lite artificial al planeta seleccionado.
     * @param pNombre Nombre del nuevo sat�lite artificial.
     * @param pPais Pais de origen del nuevo sat�lite artificial.
     * @param pTipo Tipo de servicio que presta el nuevo sat�lite artificial.
     */
    public void agregarSateliteArtificial(String pNombre, String pPais, String pTipo) {
    	String nombrePlaneta = panelPlanetas.darPlanetaSeleccionado( );
        if( observatorio.agregarSateliteArtificial( nombrePlaneta, pNombre, pPais, pTipo ) )
        {
            JOptionPane.showMessageDialog( this, "Se agreg� el sat�lite artificial.", "Sat�lite artificial agregado", JOptionPane.INFORMATION_MESSAGE );
            panelPlanetas.llenarInformacionSatelitesArtificial( buscarPlaneta(nombrePlaneta).darSateliteArtificial() );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "No se pudo agregar el sat�lite artificial, porque este planeta ya tiene un sat�lite artificial.", "Sat�lite artificial no agregado", JOptionPane.ERROR_MESSAGE );
        }
		
	} 

    /**
     * Elimina un sat�lite natural de un planeta.
     * @param pNombrePlaneta Nombre del planeta donde se quiere eliminar el sat�lite. 
     * @param pNombreSatelite Nombre del sat�lite artificial donde se quiere eliminar el sat�lite. 
     */
    public void eliminarSateliteArtificial( String pNombrePlaneta, String pNombreSatelite )
    {
        observatorio.eliminarSateliteArtificial(pNombrePlaneta, pNombreSatelite);
        JOptionPane.showMessageDialog( this, "Se elimin� el sat�lite artificial", "Sat�lite artificial eliminado", JOptionPane.INFORMATION_MESSAGE );
    }
    
    /**
     * Elimina un sat�lite natural de un planeta.
     * @param pNombrePlaneta Nombre del planeta donde se quiere eliminar el sat�lite. 
     * @param pNombreSatelite Nombre del sat�lite natural donde se quiere eliminar el sat�lite. 
     */
    public void eliminarSateliteNatural( String pNombrePlaneta, String pNombreSatelite )
    {
        observatorio.eliminarSateliteNatural( pNombrePlaneta, pNombreSatelite );
        panelPlanetas.llenarListaSatelitesNaturales( darPropiedadesSatelitesNaturales( panelPlanetas.darPlanetaSeleccionado( ) ) );
    }

    /**
     * Muestra el dialogo con la informaci�n del sat�lite natural para ser editado.
     * @param pNombrePlaneta Nombre del planeta donde se quiere eliminar el sat�lite. 
     * @param pNombreSatelite Nombre del sat�lite natural donde se quiere eliminar el sat�lite.
     */
    public void mostrarDialogoSateliteEdicion( String pNombrePlaneta, String pNombreSatelite )
    {
        DialogoInformacionSatelite dialogo = new DialogoInformacionSatelite( this, observatorio.buscarSateliteNatural( pNombrePlaneta, pNombreSatelite ), pNombrePlaneta );
    }

    /**
     * Edita las propiedades de un sat�lite natural identificado con el nombre.
     * @param pNombre Nombre del sat�lite natural que se quiere editar. 
     * @param pExcentricidad Nuevo valor de la excentricidad.
     * @param pInclinacion Nuevo valor de la inclinaci�n. 
     */
    public void editarSateliteNatural( String pNombre, double pExcentricidad, double pInclinacion )
    {
        observatorio.editarSateliteNatural( panelPlanetas.darPlanetaSeleccionado( ), pNombre, pExcentricidad, pInclinacion );
        panelPlanetas.llenarListaSatelitesNaturales(darPropiedadesSatelitesNaturales( panelPlanetas.darPlanetaSeleccionado( )));
    }

    /**
     * Muestra el dialogo para consultar los sat�lites dada una excentricidad.
     */
    public void mostrarDialogoConsultarPorExcentricidad( )
    {
        String strPos = JOptionPane.showInputDialog( this, "Ingrese la excentricidad: ", "Sat�lites con mayor excentricidad", JOptionPane.QUESTION_MESSAGE );
        if( strPos != null )
        {
            try
            {
                double pExcentricidad = Double.parseDouble( strPos );
                ArrayList planetas = observatorio.darSatelitesExcentricidadMayor(pExcentricidad);
                if(planetas.size()==0){
                	JOptionPane.showMessageDialog( this, "No hay registrados sat�lites naturales con menor excentricidad a "+pExcentricidad, "Sat�lites con mayor excentricidad", JOptionPane.INFORMATION_MESSAGE );
                }
                else{
                	DialogoListaPlanetas dialogo = new DialogoListaPlanetas( planetas, "Sat�lites con menor excentricidad a "+pExcentricidad);
                	dialogo.setLocationRelativeTo( this );
                }
            }
            catch( NumberFormatException e )
            {
                JOptionPane.showMessageDialog( this, "Debe ingresar un valor v�lido.", "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
    }
    
    /**
     * Muestra el dialogo con la respuesta del planeta con mayor n�mero de sat�lites naturales.
     */
    public void mostrarDialogoConsultarMayorSatelites() {
		
    	Planeta respuesta = observatorio.darPlanetaMasSatelites();
    	if(respuesta ==null){
    		JOptionPane.showMessageDialog( this, "No hay sat�lites naturales registrados.", "Planeta con mayor n�mero de sat�lites naturales", JOptionPane.INFORMATION_MESSAGE );
    	}
    	else
    		JOptionPane.showMessageDialog( this, "Planeta con mayor n�mero de sat�lites naturales: "+ respuesta.darNombre(), "Planeta con mayor n�mero de sat�lites naturales", JOptionPane.INFORMATION_MESSAGE );
	}
    
    /**
     * Muestra el dialogo con el n�mero de sat�lites militares.
     */
    public void mostrarDialogoConsultarSateliteMilitar() {
    	JOptionPane.showMessageDialog( this, "El n�mero de sat�lites militares es: "+ observatorio.darNumeroSatelitesMilitares(), "Sat�lites de tipo militar", JOptionPane.INFORMATION_MESSAGE );
		
	}

    /**
     * Muestra el dialogo para consultar los planetas que poseen una inclinaci�n menor que un planeta.
     */
    public void mostrarDialogoConsultarPorInclinacion( )
    {
        DialogoComboPlanetas dialogo = new DialogoComboPlanetas( this, observatorio.darNombresPlanetas( ) );
    }

    /**
     * Consulta los planetas que tienen menor inclinaci�n que la del planeta dado.
     * @param nombrePlaneta Nombre del planeta al cual se le quiere compara la inclinaci�n.
     */
    public void consultarPlanetasPorInclinacion( String nombrePlaneta )
    {
    	ArrayList planetas = observatorio.darPlanetasPorInclinacion( nombrePlaneta ); 
    	if(planetas.size()==0){
         	JOptionPane.showMessageDialog( this, "No hay planetas con menor inclinaci�n a "+nombrePlaneta,  "Planetas con menor inclinaci�n a "+nombrePlaneta, JOptionPane.INFORMATION_MESSAGE );
         }
         else{
        	 DialogoListaPlanetas dialogo = new DialogoListaPlanetas( planetas , "Planetas con menor inclinaci�n a "+nombrePlaneta);
             dialogo.setLocationRelativeTo( this );
         }  
    }

    /**
     * Devuelve una lista con las propiedades de los sat�lites naturales de un planeta especificado.
     * @param pNombrePlaneta Nombre del planeta del que se desea conocer sus sat�lites naturales.
     * @return Arraylist con las propiedades de los sat�lites naturales de un planeta dado. Lista vacia si no el planeta no tiene sat�lites naturales.
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
     * Actualiza la informaci�n de los sat�lites naturales y artificiales del planeta actual.
     */
    public void actualizarSatelites(){
    	panelPlanetas.llenarListaSatelitesNaturales( darPropiedadesSatelitesNaturales( panelPlanetas.darPlanetaSeleccionado( ) ) );
    	panelPlanetas.llenarInformacionSatelitesArtificial( buscarPlaneta(panelPlanetas.darPlanetaSeleccionado( )).darSateliteArtificial() );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1.
     */
    public void reqFuncOpcion1( )
    {
        String resultado = observatorio.metodo1( );
        actualizarSatelites();
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * M�todo para la extensi�n 2.
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
     * Este m�todo ejecuta la aplicaci�n, creando una nueva interfaz.
     * @param args. Argumentos del llamado. No se requiere ninguno.
     */
    public static void main( String[] args )
    {
        InterfazObservatorio interfaz = new InterfazObservatorio( );
        interfaz.setVisible( true );
    }

	

	
}