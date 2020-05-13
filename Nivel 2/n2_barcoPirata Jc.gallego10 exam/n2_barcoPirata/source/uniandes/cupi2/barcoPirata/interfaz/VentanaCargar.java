/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_barcoPirata 
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.barcoPirata.interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * Ventana para embarcar la carga del barco.
 */
public class VentanaCargar extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazBarcoPirata principal;

    /**
     * Nombre del pirata dueño del contenedor.
     */
    private String nombrePirata;

    /**
     * Panel con los datos de la carga.
     */
    private PanelCargar panelCargar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor de la ventana.
     * @param ventanaPrincipal Ventana principal de la aplicación.
     * @param pNombrePirata Nombre del pirata dueño del contenedor.
     */
    public VentanaCargar( InterfazBarcoPirata ventanaPrincipal, String pNombrePirata )
    {
        principal = ventanaPrincipal;
        nombrePirata = pNombrePirata;

        setTitle( "Cargar contenedor" );
        setLayout( new BorderLayout( ) );

        panelCargar = new PanelCargar( this );
        add( panelCargar );
        pack( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Carga un contenedor.
     * @param numeroCajas Número de cajas de la carga.
     * @param pesoPorCaja Peso de cada caja en la carga.
     * @param tipoCarga Tipo de carga.
     */
    public void cargarBarco( int numeroCajas, double pesoPorCaja,  int tipoCarga )
    {
        // Realiza la carga
        principal.cargarContenedor(nombrePirata, numeroCajas, pesoPorCaja, tipoCarga);
        dispose( );
    }

    /**
     * Cancela la adición de la carga.
     */
    public void cancelar( )
    {
        dispose( );
    }

}
