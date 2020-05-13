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
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.observatorio.mundo.Planeta;
import uniandes.cupi2.observatorio.mundo.SateliteArtificial;

/**
 * Dialogo para crea un nuevo sat�lite artifical.
 */
public class DialogoCreaSateliteArtificial extends JDialog implements ActionListener{
	
	// -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para aceptar una acci�n.
     */
    private static final String ACEPTAR = "ACEPTAR";

    /**
     * Constante para cancelar una acci�n.
     */
    private static final String CANCELAR = "CANCELAR";
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazObservatorio principal;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Combo que contiene el nombre del sat�lite.
     */
    private JLabel lblNombre;
    
    /**
     * Combo que contiene el pa�s de origen del sat�lite.
     */
    private JLabel lblpais;
    
    /**
     * Campo de texto para ingresar el nombre del sat�lite.
     */
    private JTextField txtNombre;
    
    /**
     * Campo de texto para ingresar el pa�s de origen del sat�lite.
     */
    private JTextField txtPais;
    
    /**
     * Combo que contiene el tipo de servicio.
     */
    private JLabel lblTipo;
    
    /**
     * Combo que contiene a los tipos de servicio.
     */
    private JComboBox comboTipo;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    
    /**
	 * Constructor del panel.
     * @param pPrincipal Ventana principal de la aplicaci�n.
     */
    public DialogoCreaSateliteArtificial(InterfazObservatorio pPrincipal){
    	principal = pPrincipal;
    	setTitle( "Crear sat�lite artificial." );
    	setMinimumSize(new Dimension(300,160));
        setLayout( new GridLayout(0, 2) );
    	lblNombre = new JLabel("Nombre:");
    	txtNombre = new JTextField();
    	add(lblNombre);
    	add(txtNombre);
    	
    	lblpais = new JLabel("Pa�s de origen:");
    	txtPais = new JTextField();
    	add(lblpais);
    	add(txtPais);
    	
    	lblTipo = new JLabel("Tipo de servicio:");
    	add(lblTipo);
    	
    	String [] tipos = new String[3];
    	tipos[0] = SateliteArtificial.TIPO_COMUNICACION;
    	tipos[1] = SateliteArtificial.TIPO_INVESTIGACION;
    	tipos[2] = SateliteArtificial.TIPO_MILITAR;
    	comboTipo  = new JComboBox(tipos);
    	add(comboTipo);
    	
    	JButton btnAceptar = new JButton( "Aceptar" );
        btnAceptar.addActionListener( this );
        btnAceptar.setActionCommand( ACEPTAR );
        JButton btnCancelar = new JButton( "Cancelar" );
        btnCancelar.addActionListener( this );
        btnCancelar.setActionCommand( CANCELAR );
        
        add(btnAceptar);
        add(btnCancelar);
        
        setLocationRelativeTo( principal );
        setVisible( true );   	
    }
    
    /**
     * Manejo de los eventos de los botones.
     * @param e Evento asociado al click en un bot�n. e != null.
     */
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        if( comando.equals( ACEPTAR ) )
        {
        	String pNombre = txtNombre.getText();
        	String pPais = txtPais.getText();
            String pTipo = ( String )comboTipo.getSelectedItem( );
            
            principal.agregarSateliteArtificial(pNombre, pPais, pTipo);
            this.dispose( );
        }
        else if( comando.equals( CANCELAR ) )
        {
            this.dispose( );
        }
    }

}
