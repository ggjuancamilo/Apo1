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

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.swing.JDialog;

import uniandes.cupi2.observatorio.mundo.SateliteNatural;

/**
 * Dialogo que muestra los detalles de un satélite natural.
 */
public class DialogoInformacionSatelite extends JDialog
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Interfaz principal de la aplicación.
     */
    private InterfazObservatorio principal;

    /**
     * Panel principal del dialogo.
     */
    private PanelSatelite panelSatelite;

    /**
     * Nombre del planeta al que pertenece el satélite natural.
     */
    private String nombrePlaneta;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del diálogo donde se van a editar la información de los satelites.
     * @param pPrincipal Interfaz principal de la aplicación
     * @param pSatelite Satélite natural a editar.
     * @param pNombrePlaneta Nombre del planeta al que pertenece el satélite natural
     */
    public DialogoInformacionSatelite( InterfazObservatorio pPrincipal, SateliteNatural pSatelite, String pNombrePlaneta )
    {
        principal = pPrincipal;
        nombrePlaneta = pNombrePlaneta;
        panelSatelite = new PanelSatelite( this, pSatelite );
        add( panelSatelite );
        pack( );
        
        setTitle( "Satélite natural" );
        setLocationRelativeTo( pPrincipal );
        setVisible( true );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Agrega un satélite natural al planeta.
     * @param pNombre Nombre del satélite natural.
     * @param pExcentricidad Excentricidad del satélite natural. 
     * @param pInclinacion Inclinación del satélite natural.
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
     * Edita la información de un satélite natural.
     * @param pNombre Nombre del satélite natural a editar.
     * @param pExcentricidad Nuevo valor de la excentricidad del satélite natural.
     * @param pInclinacion Nuevo valor de la inclinación del satélite natural. 
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
     * Eliminar un satélite natural del planeta.
     * @param nombreSatelite Nombre del satélite natural a eliminar.
     */
    public void eliminarSateliteNatural( String nombreSatelite )
    {
        principal.eliminarSateliteNatural( nombrePlaneta, nombreSatelite );
    }
     
}
