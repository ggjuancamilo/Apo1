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
 * Panel para crear un nuevo sat�lite natural o editar uno existente.
 */
public class PanelSatelite extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para aceptar la acci�n.
     */
    public static final String ACEPTAR = "ACEPTAR";

    /**
     * Constante para cancelar la acci�n.
     */
    public static final String CANCELAR = "CANCELAR";

    /**
     * Constante para eliminar un sat�lite natural.
     */
    public static final String ELIMINAR = "ELIMINAR";

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta donde se muestra nombre del sat�lite.
     */
    private JLabel lblNombre;

    /**
     * Campo de texto para el nombre del satelite.
     */
    private JTextField txtNombre;

    /**
     * Etiqueta donde se muestra la excentricidad del sat�lite.
     */
    private JLabel lblExcentricidad;

    /**
     * Campo de texto donde se coloca la excentricidad del sat�lite.
     */
    private JTextField txtExcentricidad;

    /**
     * Etiqueta donde se muestra inclinaci�n orbital.
     */
    private JLabel lblInclinacion;

    /**
     * Campo de texto donde se muestra la inclinaci�n orbital del sat�lite.
     */
    private JTextField txtInclinacion;

    /**
     * Bot�n para aceptar.
     */
    private JButton btnAceptar;

    /**
     * Bot�n para cancelar.
     */
    private JButton btnCancelar;

    /**
     * Bot�n para eliminar.
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
     * Si es null, se desea utilizar el dialogo para creaci�n. De lo contrario, se quiere utilizar el dialogo para edici�n
     */
    private SateliteNatural satelite;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del dialogo.
     * @param pDialogo Dialogo que contiene a este panel
     * @param pSatelite Null para cuando se quiere mostrar el dialogo para creaci�n. Diferente de null para edici�n.
     */
    public PanelSatelite( DialogoInformacionSatelite pDialogo, SateliteNatural pSatelite )
    {
        dialogo = pDialogo;
        satelite = pSatelite;

        lblNombre = new JLabel( "Nombre:" );
        txtNombre = new JTextField( );
        lblExcentricidad = new JLabel( "Excentricidad:" );
        txtExcentricidad = new JTextField( );
        lblInclinacion = new JLabel( "Inclinaci�n orbital    " );
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
     * Inserta los valores del sat�lite al panel.
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
     * @param e Acci�n que gener� el evento.
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
                JOptionPane.showMessageDialog( this, "Debe ingresar un nombre v�lido.", "Error.", JOptionPane.ERROR_MESSAGE );
            }
            else if( strExcentricidad == null || strExcentricidad.length( ) == 0 )
            {
                todoOk = false;
                JOptionPane.showMessageDialog( this, "Debe ingresar una excentricidad v�lida.", "Error.", JOptionPane.ERROR_MESSAGE );
            }
            else if( strInclinacion == null || strInclinacion.length( ) == 0 )
            {
                todoOk = false;
                JOptionPane.showMessageDialog( this, "Debe ingresar una inclinaci�n v�lida.", "Error.", JOptionPane.ERROR_MESSAGE );
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
                JOptionPane.showMessageDialog( this, "Debe ingresar datos v�lidos.", "Error.", JOptionPane.ERROR_MESSAGE );
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
