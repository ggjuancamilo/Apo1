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

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uniandes.cupi2.observatorio.mundo.SateliteNatural;

/**
 * Panel para crear un nuevo satélite natural o editar uno existente.
 */
public class PanelSatelite extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para aceptar la acción.
     */
    public static final String ACEPTAR = "ACEPTAR";

    /**
     * Constante para cancelar la acción.
     */
    public static final String CANCELAR = "CANCELAR";

    /**
     * Constante para eliminar un satélite natural.
     */
    public static final String ELIMINAR = "ELIMINAR";

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta donde se muestra nombre del satélite.
     */
    private JLabel lblNombre;

    /**
     * Campo de texto para el nombre del satelite.
     */
    private JTextField txtNombre;

    /**
     * Etiqueta donde se muestra la excentricidad del satélite.
     */
    private JLabel lblExcentricidad;

    /**
     * Campo de texto donde se coloca la excentricidad del satélite.
     */
    private JTextField txtExcentricidad;

    /**
     * Etiqueta donde se muestra inclinación orbital.
     */
    private JLabel lblInclinacion;

    /**
     * Campo de texto donde se muestra la inclinación orbital del satélite.
     */
    private JTextField txtInclinacion;

    /**
     * Botón para aceptar.
     */
    private JButton btnAceptar;

    /**
     * Botón para cancelar.
     */
    private JButton btnCancelar;

    /**
     * Botón para eliminar.
     */
    private JButton btnEliminar;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Dialogo que contiene al panel.
     */
    private DialogoInformacionSatelite dialogo;

    /**
     * Satelite que se quiere modificar. <br>
     * Si es null, se desea utilizar el dialogo para creación. De lo contrario, se quiere utilizar el dialogo para edición
     */
    private SateliteNatural satelite;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del dialogo.
     * @param pDialogo Dialogo que contiene a este panel
     * @param pSatelite Null para cuando se quiere mostrar el dialogo para creación. Diferente de null para edición.
     */
    public PanelSatelite( DialogoInformacionSatelite pDialogo, SateliteNatural pSatelite )
    {
        dialogo = pDialogo;
        satelite = pSatelite;

        lblNombre = new JLabel( "Nombre:" );
        txtNombre = new JTextField( );
        lblExcentricidad = new JLabel( "Excentricidad:" );
        txtExcentricidad = new JTextField( );
        lblInclinacion = new JLabel( "Inclinación orbital    " );
        txtInclinacion = new JTextField( );

        if( satelite == null )
            btnAceptar = new JButton( "Aceptar" );
        else
            btnAceptar = new JButton( "Editar" );
        btnAceptar.addActionListener( this );
        btnAceptar.setActionCommand( ACEPTAR );
        if( satelite != null )
        {
            btnEliminar = new JButton( "Eliminar" );
            btnEliminar.addActionListener( this );
            btnEliminar.setActionCommand( ELIMINAR );
        }
        btnCancelar = new JButton( "Cancelar" );
        btnCancelar.addActionListener( this );
        btnCancelar.setActionCommand( CANCELAR );

        if( satelite != null )
        {
            setLayout( new GridLayout( 4, 3 ) );
            add( lblNombre );
            add( new JLabel( ) );
            add( txtNombre );
            add( lblExcentricidad );
            add( new JLabel( ) );
            add( txtExcentricidad );
            add( lblInclinacion );
            add( new JLabel( ) );
            add( txtInclinacion );
            add( btnAceptar );
            add( btnEliminar );
            add( btnCancelar );
        }
        else
        {
            setLayout( new GridLayout( 4, 2 ) );
            add( lblNombre );
            add( txtNombre );
            add( lblExcentricidad );
            add( txtExcentricidad );
            add( lblInclinacion );
            add( txtInclinacion );
            add( btnAceptar );
            add( btnCancelar );
        }

        establecerCamposEditables( );
    }

    /**
     * Inserta los valores del satélite al panel.
     */
    private void establecerCamposEditables( )
    {
        if( satelite != null )
        {
            txtNombre.setEditable( false );
            txtNombre.setText( satelite.darNombre( ) );
            txtExcentricidad.setText( "" + satelite.darExcentricidad( ) );
            txtInclinacion.setText( "" + satelite.darInclinacion( ) );
        }
    }

    /**
     * Manejo de los eventos de los botones.
     * @param e Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );

        if( comando.equals( ACEPTAR ) )
        {
            String nombre = txtNombre.getText( );
            String strExcentricidad = txtExcentricidad.getText( );
            String strInclinacion = txtInclinacion.getText( );

            boolean todoOk = true;

            if( nombre == null || nombre.length( ) == 0 )
            {
                todoOk = false;
                JOptionPane.showMessageDialog( this, "Debe ingresar un nombre válido.", "Error.", JOptionPane.ERROR_MESSAGE );
            }
            else if( strExcentricidad == null || strExcentricidad.length( ) == 0 )
            {
                todoOk = false;
                JOptionPane.showMessageDialog( this, "Debe ingresar una excentricidad válida.", "Error.", JOptionPane.ERROR_MESSAGE );
            }
            else if( strInclinacion == null || strInclinacion.length( ) == 0 )
            {
                todoOk = false;
                JOptionPane.showMessageDialog( this, "Debe ingresar una inclinación válida.", "Error.", JOptionPane.ERROR_MESSAGE );
            }

            double excentricidad = 0;
            double inclinacion = 0;
            try
            {
                excentricidad = Double.parseDouble( strExcentricidad );
                inclinacion = Double.parseDouble( strInclinacion );
            }
            catch( NumberFormatException e1 )
            {
                todoOk = false;
            }

            if( todoOk )
            {
                if( satelite == null )
                    dialogo.agregarSateliteNatural( nombre, excentricidad, inclinacion );
                else
                    dialogo.editarSateliteNatural( nombre, excentricidad, inclinacion );
                dialogo.dispose( );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "Debe ingresar datos válidos.", "Error.", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( comando.equals( CANCELAR ) )
        {
            dialogo.dispose( );
        }
        else if( comando.equals( ELIMINAR ) )
        {
            dialogo.eliminarSateliteNatural( satelite.darNombre( ) );
            dialogo.dispose( );
        }
    }
}
