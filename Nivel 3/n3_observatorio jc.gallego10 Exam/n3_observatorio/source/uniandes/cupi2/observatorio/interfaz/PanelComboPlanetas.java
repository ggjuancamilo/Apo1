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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Panel donde se muestra la lista de los planetas.
 */
public class PanelComboPlanetas extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para aceptar una acción.
     */
    private static final String ACEPTAR = "ACEPTAR";

    /**
     * Constante para cancelar una acción.
     */
    private static final String CANCELAR = "CANCELAR";

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Campo donde ingresar el nombre del planeta.
     */
    private JTextField comboPlanetas;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Dialogo que contiene este panel.
     */
    private DialogoComboPlanetas dialogo;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param pDialogo Instancia del dialogo que contiene este panel.
     * @param pNombresPlanetas Arreglo que contiene los nombres de los planetas.
     */
    public PanelComboPlanetas( DialogoComboPlanetas pDialogo, String[] pNombresPlanetas )
    {
        dialogo = pDialogo;
        comboPlanetas = new JTextField();
        setLayout( new GridLayout( 3, 1 ) );
        JButton btnAceptar = new JButton( "Aceptar" );
        btnAceptar.addActionListener( this );
        btnAceptar.setActionCommand( ACEPTAR );
        JButton btnCancelar = new JButton( "Cancelar" );
        btnCancelar.addActionListener( this );
        btnCancelar.setActionCommand( CANCELAR );
        add(new JLabel("Ingresar planeta a comparar:"));
        add( comboPlanetas );

        JPanel botones = new JPanel( );
        botones.add( btnAceptar );
        botones.add( btnCancelar );
        add( botones );
    }

    /**
     * Manejo de los eventos de los botones.
     * @param e Evento asociado al click en un botón. e != null.
     */
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        if( comando.equals( ACEPTAR ) )
        {
            String planeta = ( String )comboPlanetas.getText();
            dialogo.consultarPlanetasPorInclinacion( planeta );
            dialogo.dispose( );
        }
        else if( comando.equals( CANCELAR ) )
        {
            dialogo.dispose( );
        }
    }

}
