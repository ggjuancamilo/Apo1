/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n6_crucigrama
 * Autor: ff - 03-nov-2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.crucigrama.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel de manejo de extensiones
 */
public class PanelExtension extends JPanel implements ActionListener
{

    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    /**
     * Comando Opción 1
     */
    private static final String OPCION_1 = "OPCION_1";

    /**
     * Comando Opción 2
     */
    private static final String OPCION_2 = "OPCION_2";
    
    private static final String CARGAR = "Cargar";
    
    private static final String SOLUCIONAR = "Solucionar";
    
    private static final String VALIDAR_HORIZONTALES = "ValidarHorizontales";
    
    private static final String VALIDAR_VERTICALES = "ValidarVerticales";
    
    private static final String LIMPIAR = "Limpiar";
    		
    
    
    
    

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación
     */
    private InterfazCrucigrama principal;

    //-----------------------------------------------------------------
    // Atributos de interfaz
    //-----------------------------------------------------------------

    /**
     * Botón Opción 1
     */
    private JButton btnOpcion1;

    /**
     * Botón Opción 2
     */
    private JButton btnOpcion2;
    
    
    /**
     * 
     */
    private JButton btnCargar;

    /**
     * 
     */
    private JButton btnSolucionar;
    
    /**
     * 
     */
    private JButton btnValidarHorizontales;
    
    /**
     * 
     */
    private JButton btnValidarVerticales;
    
    /**
     * 
     */
    private JButton btnLimpiar;
    
    
    

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Constructor del panel
     * @param ventana Ventana principal
     */
    public PanelExtension( InterfazCrucigrama ventana )
    {
        principal = ventana;

        setBorder( new TitledBorder( "Opciones" ) );
        setLayout( new GridLayout( 2, 4 ) );

       
        btnValidarHorizontales = new JButton("Validar Horizontales");
        btnValidarHorizontales.setActionCommand(VALIDAR_HORIZONTALES);
        btnValidarHorizontales.addActionListener(this);
        add(btnValidarHorizontales);
        
        btnValidarVerticales = new JButton("Validar Verticales");
        btnValidarHorizontales.setActionCommand(VALIDAR_VERTICALES);
        btnValidarHorizontales.addActionListener(this);
        add(btnValidarVerticales);
    
        btnSolucionar = new JButton("Solucionar");
        btnSolucionar.setActionCommand(SOLUCIONAR);
        btnSolucionar.addActionListener(this);
        add(btnSolucionar);
        
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setActionCommand(LIMPIAR);
        btnLimpiar.addActionListener(this);
        add(btnLimpiar);
    
        
        btnCargar = new JButton("Cargar");
        btnCargar.setActionCommand(CARGAR);
        btnCargar.addActionListener(this);
        add(btnCargar);    
        
        
        //Botón opción 1
        btnOpcion1 = new JButton("Columna letra");
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.addActionListener( this );
        add(btnOpcion1);
        
        //Botón opción 2
        btnOpcion2 = new JButton("Filas con dos palabras");
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.addActionListener( this );
        add(btnOpcion2);
    }
        


    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones
     * @param e Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent e )
    {
        if(OPCION_1.equals( e.getActionCommand() ))
        {
            principal.reqFuncOpcion1();
        }
        else if(OPCION_2.equals( e.getActionCommand() ))
        {
            principal.reqFuncOpcion2();
        }
        else if(CARGAR.equals( e.getActionCommand() ))
        {
            principal.cargar();
        }
        else if(VALIDAR_HORIZONTALES.equals( e.getActionCommand() ))
        {
        	principal.validarHorizontales();
        }
        else if(VALIDAR_VERTICALES.equals( e.getActionCommand() ))
        {
            principal.validarVerticales();
        }
        else if(LIMPIAR.equals( e.getActionCommand() ))
        {
            principal.limpiar();
        }
        else if(SOLUCIONAR.equals( e.getActionCommand() ))
        {
            principal.Solucionar();
        }
        
    }

}
