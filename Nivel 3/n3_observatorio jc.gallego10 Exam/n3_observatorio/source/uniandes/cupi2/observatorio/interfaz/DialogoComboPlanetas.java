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

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 * Dialogo que muestra la lista de los planetas.
 */
public class DialogoComboPlanetas extends JDialog
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Interfaz principal de la aplicaci�n.
     */
    private InterfazObservatorio principal;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Panel principal del dialogo.
     */
    private PanelComboPlanetas panel;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del di�logo donde se van a mostar la lista de los planetas.
     * @param pPrincipal Interfaz principal de la aplicaci�n.
     * @param pNombresPlanetas Lista con los nombres de los planetas.
     */
    public DialogoComboPlanetas( InterfazObservatorio pPrincipal, String[] pNombresPlanetas )
    {

        principal = pPrincipal;
        setTitle( "Planeta con menor inclinaci�n." );
        setMinimumSize(new Dimension(300, 40));
        setLocationRelativeTo( principal );
        panel = new PanelComboPlanetas( this, pNombresPlanetas );
        add( panel );
        pack( );
        setVisible( true );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * M�todo que consulta a la ventana principal de la aplicaci�n los planetas menores a la inclinaci�n especificada.
     * @param pNombre Nombre del planeta con el que se quiere comparar los otros.
     */
    public void consultarPlanetasPorInclinacion( String pNombre )
    {
        principal.consultarPlanetasPorInclinacion( pNombre );
    }

}
