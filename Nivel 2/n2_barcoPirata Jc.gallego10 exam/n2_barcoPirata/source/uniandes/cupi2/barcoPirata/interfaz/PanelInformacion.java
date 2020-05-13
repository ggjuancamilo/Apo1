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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Panel para mostrar la información general del barco.
 */
public class PanelInformacion extends JPanel implements ActionListener
{
    // ------------------------------------------------------------
    // Constantes
    // ------------------------------------------------------------

    /**
     * Comando del botón botonNuevoViaje.
     */
    private static final String NUEVO = "nuevo";

    /**
     * Ruta a la imagen del barco pirata.
     */
    private static final String BARCO = "data/barcoPirata.png";

    // ------------------------------------------------------------
    // Atributos de interfaz
    // ------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazBarcoPirata principal;

    /**
     * Etiqueta con la imagen del barco pirata.
     */
    private JLabel lblImagen;

    /**
     * Etiqueta que informa el peso total.
     */
    private JLabel lblPesoTotal;

    /**
     * Etiqueta que informa si se puede zarpar o no.
     */
    private JLabel lblZarpar;

    /**
     * Botón para hacer un nuevo viaje.
     */
    private JButton btnNuevoViaje;

    // ------------------------------------------------------------
    // Constructor
    // ------------------------------------------------------------

    /**
     * Constructor del panel de información del barco pirata.
     * @param ventanaPrincipal Ventana principal de laaplicación.
     */
    public PanelInformacion( InterfazBarcoPirata ventanaPrincipal )
    {
        principal = ventanaPrincipal;
        setLayout( new GridBagLayout( ) );

        // Etiqueta de Imagen
        ImageIcon icono = new ImageIcon( BARCO );
        lblImagen = new JLabel( "" );
        lblImagen.setIcon( icono );

        // Organización
        GridBagConstraints posicion = new GridBagConstraints( 0, 0, 2, 2, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( lblImagen, posicion );

        setLayout( new BorderLayout( ) );
        setPreferredSize( new Dimension( 720, 180 ) );
        setBorder( new CompoundBorder( new EmptyBorder( 4, 3, 3, 3 ), new TitledBorder( "" ) ) );

        add( lblImagen, BorderLayout.CENTER );

        JPanel panelResto = new JPanel( );

        // inicializa y adiciona el label del peso
        lblPesoTotal = new JLabel( "El peso total es 0 Kg." );
        lblPesoTotal.setForeground( Color.BLUE.darker( ) );
        lblPesoTotal.setFont( new Font( "Tahoma", Font.BOLD, 18 ) );
        panelResto.add( lblPesoTotal );

        // Botón para hacer un nuevo viaje
        btnNuevoViaje = new JButton( "Nuevo viaje" );
        btnNuevoViaje.setActionCommand( NUEVO );
        btnNuevoViaje.addActionListener( this );
        panelResto.add( btnNuevoViaje );

        // inicializa y adiciona el label de zarpar
        lblZarpar = new JLabel( "No se puede zarpar" );
        lblZarpar.setForeground( Color.RED.darker( ) );
        lblZarpar.setFont( new Font( "Tahoma", Font.BOLD, 18 ) );
        panelResto.add( lblZarpar );

        add( panelResto, BorderLayout.SOUTH );
        setOpaque( true );

    }

    // ------------------------------------------------------------
    // Métodos
    // ------------------------------------------------------------

    /**
     * Actualiza el panel al adicionar una carga.
     */
    public void actualizarInformacion( )
    {
        // actualiza el peso
        String nuevoPeso = "El peso total es " + PanelContenedor.formatearValor( principal.darPesoTotal( ) ) + " Kg.";
        lblPesoTotal.setText( nuevoPeso );

        // Verifica si puede zarpar
        if( principal.puedeZarpar( ) )
        {
            lblZarpar.setText( "Se puede zarpar" );
        }
        else if( !principal.puedeZarpar( ))
        {
        	lblZarpar.setText( "No se puede zarpar" );
        }
    }

    /**
     * Poner en blanco el panel.
     */
    public void clear( )
    {

        lblPesoTotal.setText( "El peso total es 0 Kg." );
        lblZarpar.setText( "No se puede zarpar" );
        lblZarpar.setBackground( Color.RED );

    }

    /**
     * Manejo de eventos de los botones
     * @param e Acción que generó el evento. e != null.
     */
    public void actionPerformed( ActionEvent e )
    {
        principal.descargarBarco( );
    }
}
