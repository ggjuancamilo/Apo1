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

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.swing.JDialog;

import uniandes.cupi2.observatorio.mundo.SateliteNatural;

/**
 * Dialogo que muestra los detalles de un sat�lite natural.
 */
public class DialogoInformacionSatelite extends JDialog
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Interfaz principal de la aplicaci�n.
     */
    private InterfazObservatorio principal;

    /**
     * Panel principal del dialogo.
     */
    private PanelSatelite panelSatelite;

    /**
     * Nombre del planeta al que pertenece el sat�lite natural.
     */
    private String nombrePlaneta;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del di�logo donde se van a editar la informaci�n de los satelites.
     * @param pPrincipal Interfaz principal de la aplicaci�n
     * @param pSatelite Sat�lite natural a editar.
     * @param pNombrePlaneta Nombre del planeta al que pertenece el sat�lite natural
     */
    public DialogoInformacionSatelite( InterfazObservatorio pPrincipal, SateliteNatural pSatelite, String pNombrePlaneta )
    {
        principal = pPrincipal;
        nombrePlaneta = pNombrePlaneta;
        panelSatelite = new PanelSatelite( this, pSatelite );
        add( panelSatelite );
        pack( );
        
        setTitle( "Sat�lite natural" );
        setLocationRelativeTo( pPrincipal );
        setVisible( true );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Agrega un sat�lite natural al planeta.
     * @param pNombre Nombre del sat�lite natural.
     * @param pExcentricidad Excentricidad del sat�lite natural. 
     * @param pInclinacion Inclinaci�n del sat�lite natural.
     */
    public void agregarSateliteNatural( String pNombre, double pExcentricidad, double pInclinacion )
    {
    	DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        DecimalFormat format = new DecimalFormat("#0.##");
        format.setDecimalFormatSymbols(symbols);
        pExcentricidad = Double.parseDouble(format.format(pExcentricidad));
        pInclinacion =Double.parseDouble(format.format(pInclinacion));
        principal.agregarSateliteNatural( pNombre, pExcentricidad, pInclinacion );
    }

    /**
     * Edita la informaci�n de un sat�lite natural.
     * @param pNombre Nombre del sat�lite natural a editar.
     * @param pExcentricidad Nuevo valor de la excentricidad del sat�lite natural.
     * @param pInclinacion Nuevo valor de la inclinaci�n del sat�lite natural. 
     */
    public void editarSateliteNatural( String pNombre, double pExcentricidad, double pInclinacion )
    {
    	DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        DecimalFormat format = new DecimalFormat("#0.##");
        format.setDecimalFormatSymbols(symbols);
        pExcentricidad = Double.parseDouble(format.format(pExcentricidad));
        pInclinacion =Double.parseDouble(format.format(pInclinacion));
        principal.editarSateliteNatural( pNombre, pExcentricidad, pInclinacion );
    }

    /**
     * Eliminar un sat�lite natural del planeta.
     * @param nombreSatelite Nombre del sat�lite natural a eliminar.
     */
    public void eliminarSateliteNatural( String nombreSatelite )
    {
        principal.eliminarSateliteNatural( nombrePlaneta, nombreSatelite );
    }
     
}
