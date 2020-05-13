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

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.observatorio.mundo.Planeta;

/**
 * Panel que muestra las propiedades de un planeta.
 */
public class PanelPropiedadesPlaneta extends JPanel{
	
	// -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------
	
	/**
     * Etiqueta donde se muestra nombre del planeta.
     */
    private JLabel lblNombre;
    
    /**
     * Etiqueta donde se muestra el valor del nombre del planeta.
     */
    private JLabel lblValorNombre;
    
    /**
     * Etiqueta donde se muestra distancia media del sol del planeta.
     */
    private JLabel lblDistanciaMediaSol;
    
    /**
     * Etiqueta donde se muestra el valor del distancia media del sol del planeta.
     */
    private JLabel lblValorDistanciaMediaSol;
    
    /**
     * Etiqueta donde se muestra la excentricidad del planeta.
     */
    private JLabel lblExcentricidad;
    
    /**
     * Etiqueta donde se muestra el valor la excentricidad del planeta.
     */
    private JLabel lblValorExcentricidad;
    
    /**
     * Etiqueta donde se muestra el periodo orbital.
     */
    private JLabel lblPeriodoOrbitalSinodico;
    
    /**
     * Etiqueta donde se muestra el valor del  periodo orbital del planeta.
     */
    private JLabel lblValorPeriodoOrbitalSinodico;
    
    /**
     * Etiqueta donde se muestra la velocidad orbital media.
     */
    private JLabel lblVelocidadOrbitalMedia;
    
    /**
     * Etiqueta donde se muestra el valor de la velocidad orbital media del planeta.
     */
    private JLabel lblValorVelocidadOrbitalMedia;
    
    /**
     * Etiqueta donde se muestra la inclinación del planeta.
     */
    private JLabel lblInclinacion;
    
    /**
     * Etiqueta donde se muestra el valor de la inclinación del planeta.
     */
    private JLabel lblValorInclinacion;
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    
    /**
     * Planeta seleccionado.
     */
    private Planeta planeta;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    
    /**
     * Constructor del panel.
     * @param pPlaneta Planeta seleccionado.
     */
    public PanelPropiedadesPlaneta(Planeta pPlaneta){
    	planeta = pPlaneta;
    	
    	setBorder( new TitledBorder( "Propiedades del planeta" ) );
        setLayout( new GridLayout(0, 2) );
        
    	lblNombre = new JLabel("Nombre:");
    	add(lblNombre);
    	lblValorNombre = new JLabel(""+planeta.darNombre());
    	add(lblValorNombre);
    	
    	lblDistanciaMediaSol= new JLabel("Distancia media al sol:");
        lblValorDistanciaMediaSol= new JLabel(""+planeta.darDistancia()+" UA");
        add(lblDistanciaMediaSol);
        add(lblValorDistanciaMediaSol);
        
        lblExcentricidad = new JLabel("Excentricidad:");
        lblValorExcentricidad = new JLabel(""+planeta.darExcentricidad());
        add(lblExcentricidad);
        add(lblValorExcentricidad);
        
        lblPeriodoOrbitalSinodico = new JLabel("Periodo orbital:");
        lblValorPeriodoOrbitalSinodico = new JLabel(""+planeta.darPeriodoOrbital()+" días");
        add(lblPeriodoOrbitalSinodico);
        add(lblValorPeriodoOrbitalSinodico);
        
        lblVelocidadOrbitalMedia = new JLabel("Velocidad orbital:");
        lblValorVelocidadOrbitalMedia = new JLabel(""+planeta.darVelocidadMedia()+" km/s");
        add(lblVelocidadOrbitalMedia);
        add(lblValorVelocidadOrbitalMedia);
        
        lblInclinacion = new JLabel("Inclinación:");
        lblValorInclinacion = new JLabel(""+planeta.darInclinacion()+" °");
        add(lblInclinacion);
        add(lblValorInclinacion);
    	
    }
    
    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------
    
    /**
     * Actualiza las propiedades del planeta seleccionado.
     * @param pPlaneta Nuevo planeta seleccionado.
     */
    public void actualizarPropiedades(Planeta pPlaneta){
    	planeta = pPlaneta;
    	lblValorNombre.setText(""+planeta.darNombre());
        lblValorDistanciaMediaSol.setText(""+planeta.darDistancia()+" UA");
        lblValorExcentricidad.setText(""+planeta.darExcentricidad());
        lblValorPeriodoOrbitalSinodico.setText(""+planeta.darPeriodoOrbital()+" días");
        lblValorVelocidadOrbitalMedia.setText(""+planeta.darVelocidadMedia()+" km/s");
        lblValorInclinacion.setText(""+planeta.darInclinacion()+" °");

    }

}
