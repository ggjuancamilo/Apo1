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

import java.awt.BorderLayout;
import java.io.FileInputStream;
import java.util.Properties;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.cupi2.crucigrama.mundo.Casilla;
import uniandes.cupi2.crucigrama.mundo.Crucigrama;


/**
 * Esta es la ventana principal de la aplicación.
 */
public class InterfazCrucigrama extends JFrame
{
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Clase principal del mundo
     */
    private Crucigrama crucigrama;

    //-----------------------------------------------------------------
    // Atributos de la interfaz
    //-----------------------------------------------------------------

    /**
     * Panel con las extensiones
     */
    private PanelExtension panelExtension;
    
    /**
     * Panel con la imagen del encabezado
     */
    private PanelImagen panelImagen;
    
    /**
     * 
     */
    private PanelPista panelPista;
    
    /**
     * 
     */
    private PanelTablero panelTablero;
    

    

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Descripción <br>
     * <b>post: </b> Descripción
     */
    public InterfazCrucigrama()
    {
        // Crea la clase principal
        crucigrama = new Crucigrama();

        // Construye la forma
        setLayout( new BorderLayout( ) );
        setSize( 800, 700 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        //Creación de los paneles aquí
        panelImagen = new PanelImagen();
        add( panelImagen, BorderLayout.NORTH );
        
        panelExtension = new PanelExtension( this );
        add( panelExtension, BorderLayout.SOUTH );
        
        

    
        
        
        
        
    }


	//-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------
    public Casilla[][] darCrucigrama()
    {
    		return crucigrama.darCrucigrama();
     }
    public Crucigrama darCrucigramaMundo()
    {
    	return crucigrama;
    }

	public void cargarCrucigrama()
	
	{
		Casilla[][] cruci = crucigrama.darCrucigrama();
		int ancho = cruci[0].length;
		int alto= cruci.length;
		panelTablero = new PanelTablero(this, alto, ancho);
		add(panelTablero, BorderLayout.CENTER);
        panelPista= new PanelPista(crucigrama);
        panelPista.setSize(400,400);
        add(panelPista, BorderLayout.CENTER);
		pack();
		
	} 
    
    
    public void cargar()
	{
		JFileChooser elegir = new JFileChooser( );
        elegir.setCurrentDirectory( new java.io.File( "./data" ) );
        elegir.setDialogTitle( "Seleccionar archvo" );
        elegir.setFileSelectionMode( JFileChooser.FILES_ONLY );
        elegir.setVisible( true );

        if( elegir.showOpenDialog( this ) == JFileChooser.APPROVE_OPTION )
        {
        	try
        	{
        		Properties propiedades = new Properties( );
        		propiedades.load( new FileInputStream( elegir.getSelectedFile( ) ) );
        		crucigrama.cargar( propiedades );
        		cargarCrucigrama();

        	}
            catch( Exception e )
            {                
            	e.printStackTrace();
                JOptionPane.showMessageDialog( this, e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
	}
    
    public void validarHorizontales()
    {
    	
    }
    
  
    public void validarVerticales()
    {
   
    }
    
 
    public void Solucionar()
    {
    	panelTablero.solucionarCrucigrama();
 
    }
    
   
    public void limpiar()
    {
    	panelTablero.limpiar();	
    }
    
	public String[] darDescripcionH()
	{
		return crucigrama.darDescH();
	}


	public String[] darDescripcionV()
	{
		return crucigrama.darDescH();
	}

    //-----------------------------------------------------------------
    // Puntos de Extensión
    //-----------------------------------------------------------------

    /**
     * Método que pinta la columna con mas ocurrencias dadas por el usuario
     */
    public void reqFuncOpcion1(  )
    {
    	String ingresada = JOptionPane.showInputDialog(this,"ingrese la letra que desea contar:");
        char letraIngresadaUsuario = ingresada.charAt(0);
        try {
        	panelTablero.contarOcurrenciasLetraColumna(letraIngresadaUsuario);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"No existen columnas con esa letra");
		}
    }

    /**
     * Método que pinta las filas con dos palabras
     */
    public void reqFuncOpcion2( )
    {
        panelTablero.pintarFilasConDosPalabras();
    }

    


    //-----------------------------------------------------------------
    // Main
    //-----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args
     */
     public static void main(String[] args) 
    {
    	try
    	{
    		InterfazCrucigrama interfaz = new InterfazCrucigrama( );
    		interfaz.setVisible( true );
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
	}







}