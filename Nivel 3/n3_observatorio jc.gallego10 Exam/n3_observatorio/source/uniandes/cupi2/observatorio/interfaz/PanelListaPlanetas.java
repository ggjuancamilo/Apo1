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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Panel con la lista de los planetas que es respuesta de una consulta.
 */
public class PanelListaPlanetas extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para cerrar el dialogo que contiene al panel.
     */
    private static final String CERRAR = "CERRAR";

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Dialogo princiapal del panel.
     */
    private DialogoListaPlanetas dialogo;

    /**
     * Lista de planetas a desplegar en el panel.
     */
    private ArrayList planetas;

    /**
     * Scroll para la lista de planetas.
     */
    private JScrollPane scroll;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param pDialogo Dialogo que contiene este panel.
     * @param pPlanetas Lista de planetas para mostrar en el panel.
     */
    public PanelListaPlanetas( DialogoListaPlanetas pDialogo, ArrayList pPlanetas )
    {
        planetas = pPlanetas;
        dialogo = pDialogo;

        setLayout( new BorderLayout( ) );

        JList listaPlanetas = new JList( planetas.toArray( ) );
        scroll = new JScrollPane( listaPlanetas );

        JButton btnCerrar = new JButton( "Cerrar" );
        btnCerrar.addActionListener( this );
        btnCerrar.setActionCommand( CERRAR );

        add( scroll, BorderLayout.CENTER );
        add( btnCerrar, BorderLayout.SOUTH );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param e Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );

        if( comando.equals( CERRAR ) )
        {
            dialogo.dispose( );
        }
    }

}
