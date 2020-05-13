/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_inmobiliaria
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.inmobiliaria.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uniandes.cupi2.inmobiliaria.mundo.Mansion;

/**
 * Diálogo para actualizar los datos de cada mansión.
 */
public class DialogoActualizarMansion extends JDialog implements ActionListener
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Comando para actualziar la información de la mansión.
     */
	private final static String ACTUALIZAR = "Actualizar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Interfaz principal.
     */
    private InterfazInmobiliaria principal;

    /**
     * La mansión de la cual se van a mostrar los datos.
     */
    private Mansion mansion;

    /**
     * El número de la mansión de la que se va a mostrar la información.
     */
    private int numMansion;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Botón para actualizar los datos.
     */
    private JButton botonActualizar;

    /**
     * Etiqueta empleados.
     */
    private JLabel etiquetaEmpleados;

    /**
     * Etiqueta habitantes.
     */
    private JLabel etiquetaHabitantes;

    /**
     * Etiqueta parqueaderos.
     */
    private JLabel etiquetaParqueaderos;

    /**
     * Etiqueta precio.
     */
    private JLabel etiquetaPrecio;

    /**
     * Etiqueta tamaño.
     */
    private JLabel etiquetaTamano;

    /**
     * Cuadro de texto empleados.
     */
    private JTextField txtEmpleados;

    /**
     * Cuadro de texto habitantes.
     */
    private JTextField txtHabitantes;

    /**
     * Cuadro de texto parqueaderos
     */
    private JTextField txtParqueaderos;

    /**
     * Cuadro de texto precio.
     */
    private JTextField txtPrecio;

    /**
     * Cuadro de texto tamaño.
     */
    private JTextField txtTamano;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del diálogo.
     * @param nNumMansion Número de la mansión.
     * @param ventana Grupo de mansiones.
     */
    public DialogoActualizarMansion( InterfazInmobiliaria ventana, Mansion laMansion, int nNumMansion )
    {

        super( ventana, true );
        setTitle( "Actualizar datos" );
        setLayout( new java.awt.BorderLayout( ) );

        // Inicialización
        principal = ventana;
        mansion = laMansion;
        numMansion = nNumMansion;

        // Panel Imagen
        JPanel panelImagen = new JPanel( );
        panelImagen.setPreferredSize( new Dimension( 250, 20 ) );
        panelImagen.setLayout( new BorderLayout( ) );
        getContentPane( ).add( panelImagen, java.awt.BorderLayout.WEST );
        JLabel temp = new JLabel( );
        temp.setHorizontalAlignment( JLabel.CENTER );
        temp.setVerticalAlignment( JLabel.CENTER );
        temp.setIcon( new ImageIcon( "data/mansion" + numMansion + ".jpg" ) );
        panelImagen.add( temp, BorderLayout.CENTER );

        // Panel información
        JPanel panelInformacion = new JPanel( );
        GridLayout layout = new GridLayout( 6, 2 );
        layout.setVgap( 10 );
        layout.setHgap( 10 );
        panelInformacion.setLayout( layout );

        etiquetaHabitantes = new JLabel( );
        etiquetaHabitantes.setText( "Habitantes:" );
        panelInformacion.add( etiquetaHabitantes );
        txtHabitantes = new JTextField( );
        panelInformacion.add( txtHabitantes );

        etiquetaParqueaderos = new JLabel( );
        txtParqueaderos = new JTextField( );
        etiquetaParqueaderos.setText( "Parqueaderos:" );
        panelInformacion.add( etiquetaParqueaderos );
        panelInformacion.add( txtParqueaderos );

        etiquetaTamano = new JLabel( );
        txtTamano = new JTextField( );
        etiquetaTamano.setText( "Tamaño: (m2)" );
        panelInformacion.add( etiquetaTamano );
        panelInformacion.add( txtTamano );

        etiquetaEmpleados = new JLabel( );
        txtEmpleados = new JTextField( );
        etiquetaEmpleados.setText( "Empleados:" );
        panelInformacion.add( etiquetaEmpleados );
        panelInformacion.add( txtEmpleados );

        etiquetaPrecio = new JLabel( );
        txtPrecio = new JTextField( );
        etiquetaPrecio.setText( "Precio (U$):" );
        panelInformacion.add( etiquetaPrecio );
        panelInformacion.add( txtPrecio );

        add( panelInformacion, java.awt.BorderLayout.CENTER );

        // Panel actualizar
        JPanel panelActualizar = new JPanel( );
        panelActualizar.setLayout( new BorderLayout( 1, 3 ) );
        botonActualizar = new JButton( ACTUALIZAR );
        botonActualizar.setActionCommand( ACTUALIZAR );
        botonActualizar.addActionListener( this );
        panelActualizar.add( botonActualizar, BorderLayout.CENTER );
        getContentPane( ).add( panelActualizar, BorderLayout.SOUTH );

        JPanel blanco = new JPanel( );
        blanco.setPreferredSize( new Dimension( 20, 20 ) );

        JPanel blanco2 = new JPanel( );
        blanco2.setPreferredSize( new Dimension( 10, 10 ) );

        getContentPane( ).add( blanco, BorderLayout.NORTH );
        getContentPane( ).add( blanco2, BorderLayout.EAST );

        pack( );
        setLocationRelativeTo( null );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza los datos del diálogo para la mansión dada por parámetro.
     */
    public void actualizar( )
    {
        txtHabitantes.setText( mansion.darHabitantes( ) + "" );
        txtParqueaderos.setText( mansion.darParqueaderos( ) + "" );
        txtEmpleados.setText( mansion.darEmpleados( ) + "" );
        txtPrecio.setText( mansion.darPrecio( ) + "" );
        txtTamano.setText( mansion.darTamanio( ) + "" );
    }

    /**
     * Manejo de eventos del botón actualizar.
     * @param e Evento que generó la acción. e != null.
     */
    public void actionPerformed( ActionEvent e )
	{
		String comando = e.getActionCommand( );

		if( comando.equals( ACTUALIZAR ) )
		{
			try
			{
				int habitantes = Integer.parseInt( txtHabitantes.getText( ) );
				int numParqueaderos = Integer.parseInt( txtParqueaderos.getText( ) );
				int numEmpleados = Integer.parseInt( txtEmpleados.getText( ) );
				int precio = Integer.parseInt( txtPrecio.getText( ) );
				int tamano = Integer.parseInt( txtTamano.getText( ) );

				if(habitantes<0)
				{
					JOptionPane.showMessageDialog( this, "El número de habitantes no puede ser menor a 0.", "Información", JOptionPane.INFORMATION_MESSAGE );
				}
				else if(numParqueaderos<0)
				{
					JOptionPane.showMessageDialog( this, "El número de parqueaderos no puede ser menor a 0.", "Información", JOptionPane.INFORMATION_MESSAGE );
				}
				else if(numEmpleados<0)
				{
					JOptionPane.showMessageDialog( this, "El número de empleados no puede ser menor a 0.", "Información", JOptionPane.INFORMATION_MESSAGE );
				}
				else if(precio<0)
				{
					JOptionPane.showMessageDialog( this, "El precio no puede ser menor a 0.", "Información", JOptionPane.INFORMATION_MESSAGE );
				}
				else if(tamano<0)
				{
					JOptionPane.showMessageDialog( this, "El tamaño no puede ser menor a 0.", "Información", JOptionPane.INFORMATION_MESSAGE );
				}
				else
				{
					principal.ingresarDatosMansion( numMansion, habitantes, numParqueaderos, numEmpleados, precio, tamano );
					dispose( );
				}


			}
			catch( NumberFormatException ex )
			{
				JOptionPane.showMessageDialog( this, "Debe ingresar números enteros", "Información", JOptionPane.INFORMATION_MESSAGE );
			}

		}

	}

}
