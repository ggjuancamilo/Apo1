/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_inmobiliaria
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.inmobiliaria.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.cupi2.inmobiliaria.mundo.Inmobiliaria;
import uniandes.cupi2.inmobiliaria.mundo.Mansion;

/**
 * Ventana principal de la aplicaci�n.
 */
public class InterfazInmobiliaria extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Clase principal del mundo.
     */
    private Inmobiliaria inmobiliaria;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con la imagen.
     */
    private PanelImagen panelImagen;

    /**
     * Panel de la mansi�n 1.
     */
    private PanelMansion panelMansion1;

    /**
     * Panel de la mansi�n 2.
     */
    private PanelMansion panelMansion2;

    /**
     * Panel de la mansi�n 3.
     */
    private PanelMansion panelMansion3;

    /**
     * Panel con los totales de las tres mansiones.
     */
    private PanelInmobiliaria panelInmobiliaria;

    /**
     * Panel con las extensiones.
     */
    private PanelExtension panelExtension;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor donde se arma la interfaz.
     */
    public InterfazInmobiliaria( )
    {
        // Crea la clase principal
        inmobiliaria = new Inmobiliaria( );
        inmobiliaria.inicializar( );

        // Construye la forma
        setTitle( "Inmobiliaria Cupi2" );
        getContentPane( ).setLayout( new BorderLayout( ) );
        setSize( 800, 600 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setResizable( false );

        // Creaci�n de los paneles aqu�

        // Panel imagen
        panelImagen = new PanelImagen( );
        getContentPane( ).add( panelImagen, BorderLayout.NORTH );

        // Construye el panel con las tres mansiones
        JPanel panelMansiones = new JPanel( );
        panelMansiones.setLayout( new GridLayout( 1, 3 ) );
        getContentPane( ).add( panelMansiones, BorderLayout.CENTER );
        panelMansion1 = new PanelMansion( this, 1 );
        panelMansiones.add( panelMansion1 );
        panelMansion2 = new PanelMansion( this, 2 );
        panelMansiones.add( panelMansion2 );
        panelMansion3 = new PanelMansion( this, 3 );
        panelMansiones.add( panelMansion3 );

        // Construye el panel inferior
        JPanel panelInferior = new JPanel( );
        panelInferior.setLayout( new BorderLayout( ) );
        getContentPane( ).add( panelInferior, BorderLayout.SOUTH );
        panelInmobiliaria = new PanelInmobiliaria( );
        panelInferior.add( panelInmobiliaria, BorderLayout.CENTER );
        panelExtension = new PanelExtension( this );
        panelInferior.add( panelExtension, BorderLayout.SOUTH );
        setLocationRelativeTo( null );

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Actualiza los datos de una mansi�n. <br>
     * <b>pre: </b> 1 <= numeroMansion <= 3 <br>
     * @param numeroMansion N�mero de la mansi�n.
     * @param habitantes N�mero de habitantes de la mansi�n.
     * @param numParqueaderos N�mero de parqueaderos de la mansi�n.
     * @param numEmpleados N�mero de empleados de la mansi�n.
     * @param precio Precio de la mansi�n.
     * @param tamano tama�o en metros cuadrados.
     */
    public void ingresarDatosMansion( int numeroMansion, int habitantes, int numParqueaderos, int numEmpleados, int precio, int tamano )
    {

        if( numeroMansion == 1 )
        {
            inmobiliaria.actualizarDatosMansion1( habitantes, numParqueaderos, numEmpleados, precio, tamano );
        }

        if( numeroMansion == 2 )
        {
            inmobiliaria.actualizarDatosMansion2( habitantes, numParqueaderos, numEmpleados, precio, tamano );
        }

        if( numeroMansion == 3 )
        {
            inmobiliaria.actualizarDatosMansion3( habitantes, numParqueaderos, numEmpleados, precio, tamano );
        }

        actualizar( );
    }

    /**
     * Actualiza la visualizaci�n de la interfaz <br>
     * <b>post: </b> Se actualiza la visualizaci�n
     */
    private void actualizar( )
    {
        panelInmobiliaria.actualizar( inmobiliaria );
        panelMansion1.actualizar( inmobiliaria.darMansion1( ) );
        panelMansion2.actualizar( inmobiliaria.darMansion2( ) );
        panelMansion3.actualizar( inmobiliaria.darMansion3( ) );
    }

    /**
     * Muestra el dialogo con los datos de una mansi�n <br>
     * <b>pre: </b> 1 <= numeroMansion <= 3 <br>
     * @param numeroMansion Numero de la mansi�n.
     */
    public void mostrarDialogoDatosMansion( int numMansion )
    {
        Mansion laMansion = null;
        if( numMansion == 1 )
            laMansion = inmobiliaria.darMansion1( );
        if( numMansion == 2 )
            laMansion = inmobiliaria.darMansion2( );
        if( numMansion == 3 )
            laMansion = inmobiliaria.darMansion3( );

        DialogoActualizarMansion dialogo = new DialogoActualizarMansion( this, laMansion, numMansion );
        dialogo.actualizar( );
        dialogo.setVisible( true );

    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1
     */
    public void reqFuncOpcion1( )
    {
        String resultado = inmobiliaria.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * M�todo para la extensi�n 2
     */
    public void reqFuncOpcion2( )
    {
        String resultado = inmobiliaria.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este m�todo ejecuta la aplicaci�n, creando una nueva interfaz
     * @param args
     */
    public static void main( String[] args )
    {

        InterfazInmobiliaria interfaz = new InterfazInmobiliaria( );
        interfaz.setVisible( true );
    }

}