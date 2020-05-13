/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_inmobiliaria
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.inmobiliaria.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.inmobiliaria.mundo.Inmobiliaria;

/**
 * Panel donde se van a mostrar los datos de la inmobiliaria para las tres mansiones.
 */
public class PanelInmobiliaria extends JPanel
{
    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Etiqueta costo de administraci�n.
     */
    private JLabel etiquetaCostoAdministracion;

    /**
     * Etiqueta costo promedio servicios p�blicos.
     */
    private JLabel etiquetaCostoPromedioServicios;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    
    /**
     * Constructor del panel.
     */
    public PanelInmobiliaria( )
    {
        setBorder( new TitledBorder( "Totales" ) );
        setLayout( new GridLayout( 3, 1 ) );

        // Etiqueta costo seguridad
        etiquetaCostoAdministracion = new JLabel( "Costo administraci�n : (U$)" );
        etiquetaCostoAdministracion.setHorizontalAlignment( JLabel.CENTER );
        etiquetaCostoAdministracion.setForeground( Color.BLUE.darker( ) );
        etiquetaCostoAdministracion.setFont( new Font( "Tahoma", Font.BOLD, 24 ) );

        // Etiqueta costo jardiner�a
        etiquetaCostoPromedioServicios = new JLabel( "Costo promedio servicios: (U$)" );
        etiquetaCostoPromedioServicios.setHorizontalAlignment( JLabel.CENTER );
        etiquetaCostoPromedioServicios.setForeground( Color.BLUE.darker( ) );
        etiquetaCostoPromedioServicios.setFont( new Font( "Tahoma", Font.BOLD, 24 ) );

        add( etiquetaCostoAdministracion );
        add( etiquetaCostoPromedioServicios );
        setPreferredSize( new Dimension( 120, 120 ) );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Actualiza la informaci�n
     * @param inmobiliaria Inmobiliaria de la cual se va a mostrar la informaci�n. inmobiliaria != null.
     */
    public void actualizar( Inmobiliaria inmobiliaria )
    {
        etiquetaCostoAdministracion.setText( "Costo administraci�n: (U$)" + formatearValorReal( inmobiliaria.calcularCostoAdministracion( ) ) );
        etiquetaCostoPromedioServicios.setText( "Costo promedio servicios: (U$)" + formatearValorReal( inmobiliaria.calcularCostoPromedioServicios( ) ) );
        
    }

    /**
     * Formatea un valor num�rico real para presentar en la interfaz <br>
     * @param valor El valor num�rico a ser formateado
     * @return Cadena con el valor formateado con puntos y signos.
     */
    private String formatearValorReal( double valor )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( " ###,###.##" );
        df.setMinimumFractionDigits( 2 );
        return df.format( valor );
    }

}