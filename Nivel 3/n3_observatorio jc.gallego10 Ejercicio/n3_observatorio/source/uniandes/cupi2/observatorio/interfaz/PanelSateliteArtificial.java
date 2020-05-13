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
import javax.swing.border.TitledBorder;

import uniandes.cupi2.observatorio.mundo.Planeta;
import uniandes.cupi2.observatorio.mundo.SateliteArtificial;

/**
 * Panel de administración de los satélites artificiales.
 *
 */
public class PanelSateliteArtificial extends JPanel implements ActionListener{
	
	// -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
	
	/**
     * Constante para crear un satélite artificial.
     */
    public static final String CREAR_SATELITE_ARTIFICIAL = "CREAR_SATELITE_ARTIFICIAL";


    /**
     * Constante para eliminar un satélite artificial.
     */
    public static final String ELIMINAR_SATELITE_ARTIFICIAL = "ELIMINAR_SATELITE_ARTIFICIAL";
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazObservatorio principal;
    
    /**
     * Satelite seleccionado.
     */
    private SateliteArtificial satelite;
    
    /**
     * Planeta seleccionado.
     */
    private Planeta planeta;
    
    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------
    
    /**
     * Etiqueta donde se muestra nombre del satélite artificial.
     */
    private JLabel lblNombre;
    
    /**
     * Etiqueta donde se muestra el valor del nombre del satélite artificial.
     */
    private JLabel lblValorNombre;
    
    /**
     * Etiqueta donde se muestra el país de origen del satélite artificial.
     */
    private JLabel lbPais;
    
    /**
     * Etiqueta donde se muestra el valor del país de origen del satélite artificial.
     */
    private JLabel lblValorPais;
    
    /**
     * Etiqueta donde se muestra el tipo del satélite artificial.
     */
    private JLabel lbTipo;
    
    /**
     * Etiqueta donde se muestra el valor del tipo del satélite artificial.
     */
    private JLabel lblValorTipo;
    
    /**
     * Botón para crear.
     */
    private JButton btnCrear;

    /**
     * Botón para eliminar.
     */
    private JButton btnEliminar;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    
    /**
     * Constructor del panel.
     * @param pPrincipal Ventana principal de la aplicación.
     * @param pPlaneta Planeta seleccionado.
     */
    public PanelSateliteArtificial(InterfazObservatorio pPrincipal, Planeta pPlaneta){
    	principal = pPrincipal;
    	satelite = pPlaneta.darSateliteArtificial();
    	planeta = pPlaneta;
    	setBorder( new TitledBorder( "Satélite artificial" ) );
        setLayout( new GridLayout(0, 2) );
        
    	lblNombre = new JLabel("Nombre:");
    	add(lblNombre);
    	lblValorNombre = new JLabel("");
    	add(lblValorNombre);
    	
    	lbPais = new JLabel("País de origen:");
    	lblValorPais = new JLabel("");
    	add(lbPais);
    	add(lblValorPais);
    	
    	lbTipo = new JLabel("Tipo de servicio:");
    	lblValorTipo = new JLabel("");
    	add(lbTipo);
    	add(lblValorTipo);
    	
    	btnCrear = new JButton( "Agregar" );
    	btnCrear.addActionListener( this );
    	btnCrear.setActionCommand( CREAR_SATELITE_ARTIFICIAL );
    	
    	btnEliminar = new JButton( "Eliminar" );
    	btnEliminar.addActionListener( this );
    	btnEliminar.setActionCommand( ELIMINAR_SATELITE_ARTIFICIAL );
    	
    	add(btnCrear);
    	add(btnEliminar);
    	actualizarPropiedades(planeta);
    }
    
    /**
     * Manejo de los eventos de los botones.
     * @param e Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        if( comando.equals( CREAR_SATELITE_ARTIFICIAL ) )
        {
        	DialogoCreaSateliteArtificial dialogo = new DialogoCreaSateliteArtificial(principal);
        	
        }
        else if( comando.equals( ELIMINAR_SATELITE_ARTIFICIAL ) )
        {
            if(satelite!=null){
            	principal.eliminarSateliteArtificial(planeta.darNombre(), satelite.darNombre());
            	actualizarPropiedades(planeta);
            }
            else{
            	JOptionPane.showMessageDialog( this, "Este planeta no tiene un satélite artificial.", "Satélite artificial eliminado", JOptionPane.INFORMATION_MESSAGE );
            }
        }
        
    }
    
    /**
     * Actualiza las propiedades del satélite artificial.
     * @param pSatelite Satélite artificial.
     */
    public void actualizarPropiedades(Planeta pPlaneta){
    	satelite = pPlaneta.darSateliteArtificial();
    	planeta = pPlaneta;
    	if(satelite!=null){
	    	lblValorNombre.setText(""+satelite.darNombre());
	    	lblValorPais.setText(""+satelite.darPais());
	    	lblValorTipo.setText(""+satelite.darTipoDeServicio());
    	}
    	else{
    		lblValorNombre.setText("");
	    	lblValorPais.setText("");
	    	lblValorTipo.setText("");
    	}
        

    }
}