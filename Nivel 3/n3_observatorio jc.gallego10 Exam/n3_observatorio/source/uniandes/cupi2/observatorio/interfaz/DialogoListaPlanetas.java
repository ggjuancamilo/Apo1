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

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JDialog;

/**
 * Dialogo que muesta la lista de los planetas.
 */
public class DialogoListaPlanetas extends JDialog
{
    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Panel principal del dialogo.
     */
    private PanelListaPlanetas panelPlanetas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del diálogo que muestra la lista de planetas.
     * @param pPlanetas Lista de los planetas a mostrar.
     */
    public DialogoListaPlanetas( ArrayList pPlanetas, String pTitulo)
    {
        setLocationRelativeTo( null );
        setTitle( pTitulo );
        setSize( new Dimension( 340, 173 ) );
        panelPlanetas = new PanelListaPlanetas( this, pPlanetas );
        add( panelPlanetas );
        setVisible( true );
    }

}
