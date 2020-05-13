/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_barcoPirata 
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.barcoPirata.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.cupi2.barcoPirata.mundo.BarcoPirata;
import uniandes.cupi2.barcoPirata.mundo.Contenedor;

/**
 * Ventana principal de la aplicación del barco Pirata.
 */
public class InterfazBarcoPirata extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private BarcoPirata barco;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel del contenedor 1.
     */
    private PanelContenedor panelContenedor1;

    /**
     * Panel del contenedor 2.
     */
    private PanelContenedor panelContenedor2;

    /**
     * Panel del contenedor 3.
     */
    private PanelContenedor panelContenedor3;

    /**
     * Panel del contenedor 4.
     */
    private PanelContenedor panelContenedor4;

    /**
     * Panel que informa el estado del barco.
     */
    private PanelInformacion panelInformacion;

    /**
     * Panel de extensiones.
     */
    private PanelExtension panelExtension;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la ventana principal de la aplicación.
     */
    public InterfazBarcoPirata( )
    {
        barco = new BarcoPirata( );

        getContentPane( ).setLayout( new BorderLayout( ) );
        setSize( 720, 700 );
        setTitle( "Barco pirata" );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        JPanel panelCentral = new JPanel( );
        panelCentral.setLayout( new GridLayout( 2, 2 ) );
        add( panelCentral, BorderLayout.CENTER );

        panelInformacion = new PanelInformacion( this );
        getContentPane( ).add( panelInformacion, BorderLayout.NORTH );

        panelContenedor1 = new PanelContenedor( this, 1, barco.darContenedor1().darNombrePirata() );
        panelCentral.add( panelContenedor1 );

        panelContenedor2 = new PanelContenedor( this, 2, barco.darContenedor2().darNombrePirata() );
        panelCentral.add( panelContenedor2 );

        panelContenedor3 = new PanelContenedor( this, 3, barco.darContenedor3().darNombrePirata() );
        panelCentral.add( panelContenedor3 );

        panelContenedor4 = new PanelContenedor( this, 4, barco.darContenedor4().darNombrePirata() );
        panelCentral.add( panelContenedor4 );

        panelExtension = new PanelExtension( this );
        getContentPane( ).add( panelExtension, BorderLayout.SOUTH );

        pack( );
        setResizable( false );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Muestra la ventana para embarcar una carga en la posición especificada.
     * @param pNombrePirata Nombre del pirata dueño del contenedor a cargar.
     */
    public void mostrarVentanaCargarBarco( String pNombrePirata )
    {
        VentanaCargar ventanaCargar = new VentanaCargar( this, pNombrePirata );
        ventanaCargar.setLocationRelativeTo(this);
        ventanaCargar.setVisible( true );
    }

    
    /**
	 * Calcula el peso total de la carga del barco
	 * @return Peso total de la carga del barco del barco.
	 */
	public double darPesoTotal( )
	{
	    return barco.darPesoTotal( );
	}

	/**
	 * Carga un contenedor con los valores pasados por parámetro.
	 * @param pNombrePirata Nombre del pirata dueño del contenedor.
	 * @param pNumeroCajas Número de cajas de la nueva carga.
	 * @param pPesoPorCaja Peso de cada una de las cajas.
	 * @param pTipoCarga Tipo de la carga.
	 */
	public void cargarContenedor( String pNombrePirata, int pNumeroCajas, double pPesoPorCaja, int pTipoCarga)
    {
        boolean sePuede = barco.cargarContenedor(pNombrePirata, pNumeroCajas, pPesoPorCaja, pTipoCarga);
        if( !sePuede )
        {
           
            if( barco.sobrepasaPesoLimite(pNumeroCajas, pPesoPorCaja)== true )
            {
                JOptionPane.showMessageDialog( this, "No se pudo cargar el contenedor, las cajas son demasiado pesadas para el barco.", "Error", JOptionPane.ERROR_MESSAGE );
            }
            else 
            {
                JOptionPane.showMessageDialog( this, "No se pudo cargar el contenedor, el tipo de carga no cumple con las reglas sanitarias del barco.", "Error", JOptionPane.ERROR_MESSAGE );
            }
            
        }
        else
        {
        	if(pNombrePirata.equals(barco.darContenedor1().darNombrePirata()))
        	{
        		panelContenedor1.actualizar(pNumeroCajas, pPesoPorCaja, pTipoCarga);
        	}
        	
        	else if(pNombrePirata.equals(barco.darContenedor2().darNombrePirata()))
        	{
        		panelContenedor2.actualizar(pNumeroCajas, pPesoPorCaja, pTipoCarga);
        	}
        	
        	else if(pNombrePirata.equals(barco.darContenedor3().darNombrePirata()))
        	{
        		panelContenedor3.actualizar(pNumeroCajas, pPesoPorCaja, pTipoCarga);
        	}
        	
        	else if(pNombrePirata.equals(barco.darContenedor4().darNombrePirata()))
        	{
        		panelContenedor4.actualizar(pNumeroCajas, pPesoPorCaja, pTipoCarga);
        	}
        	panelInformacion.actualizarInformacion( );
        }
    }
	
	/**
	 * Descarga un contenedor con los valores pasados por parámetro.
	 * @param pNombrePirata Nombre del pirata dueño del contenedor.
	 */
	public void descargarContenedor(String pNombrePirata) 
	{
		barco.descargarContenedor(pNombrePirata);
		
		if(pNombrePirata.equals(barco.darContenedor1().darNombrePirata()))
    	{
    		panelContenedor1.actualizar(0, 0.0, Contenedor.SIN_CARGA);
    	}
    	
    	else if(pNombrePirata.equals(barco.darContenedor2().darNombrePirata()))
    	{
    		panelContenedor2.actualizar(0, 0.0, Contenedor.SIN_CARGA);
    	}
    	
    	else if(pNombrePirata.equals(barco.darContenedor3().darNombrePirata()))
    	{
    		panelContenedor3.actualizar(0, 0.0, Contenedor.SIN_CARGA);
    	}
    	
    	else if(pNombrePirata.equals(barco.darContenedor4().darNombrePirata()))
    	{
    		panelContenedor4.actualizar(0, 0.0, Contenedor.SIN_CARGA);
    	}
    	panelInformacion.actualizarInformacion( );
	}
	
    /**
     * Vacía las cargas de todos los contenedores del barco para comenzar un nuevo viaje.
     */
    public void descargarBarco( )
    {
        barco.descargarBarco( );
        panelContenedor1.actualizar( 0, 0.0, 0 );
        panelContenedor2.actualizar( 0, 0.0, 0 );
        panelContenedor3.actualizar( 0, 0.0, 0 );
        panelContenedor4.actualizar( 0, 0.0, 0 );
        panelInformacion.clear( );
    }

    /**
     * Determina si el barco puede zarpar o no.
     * @return True si se puede, false de lo contrario.
     */
    public boolean puedeZarpar( )
    {
        return barco.puedeZarpar( );
    }

    /**
     * Muestra una ventana con un mensaje que indica el nombre del pirata dueño del contenedor más pesado, o de los dueños si hay mas de uno.
     */
    public void buscarContenedorMasPesado()
    {
    	String rta = barco.buscarPirataDuenioContenedorMasPesado();
    	JOptionPane.showMessageDialog(this, rta, "Pirata dueño del contenedor más pesado", JOptionPane.INFORMATION_MESSAGE);
    }
    

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método de extensión 1.
     */
    public void opcion1( )
    {
        String resultado = barco.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método de extensión 2.
     */
    public void opcion2( )
    {
        String resultado = barco.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Ejecución
    // -----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz.
     * @param args.
     */
    public static void main( String[] args )
    {
        InterfazBarcoPirata a = new InterfazBarcoPirata( );
        a.setVisible( true );
    }

}
