/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_barcoPirata 
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.barcoPirata.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel de manejo de extensiones.
 */
public class PanelExtension extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

	/**
     * Comando Contenedor m�s pesado
     */
	private static final String CONTENEDOR_MAS_PESADO = "CONTENEDOR_MAS_PESADO";
	
    /**
     * Comando Opci�n 1.
     */
    private static final String OPCION_1 = "OPCION_1";

    /**
     * Comando Opci�n 2.
     */
    private static final String OPCION_2 = "OPCION_2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazBarcoPirata principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Bot�n Opci�n 1.
     */
    private JButton btnContenedorMasPesado;
    
    /**
     * Bot�n Opci�n 1.
     */
    private JButton btnOpcion1;

    /**
     * Bot�n Opci�n 2.
     */
    private JButton btnOpcion2;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param ventanaPrincipal Ventana principal. ventanaPrincipal != null.
     */
    public PanelExtension( InterfazBarcoPirata ventanaPrincipal )
    {
        principal = ventanaPrincipal;

        setBorder( new TitledBorder( "Opciones" ) );
        setLayout( new GridLayout( 1, 3 ) );
        
        btnContenedorMasPesado = new JButton( "Buscar due�o contenedor m�s pesado" );
        btnContenedorMasPesado.setActionCommand( CONTENEDOR_MAS_PESADO );
        btnContenedorMasPesado.addActionListener( this );
        add( btnContenedorMasPesado );
        
        btnOpcion1 = new JButton( "Opci�n 1" );
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.addActionListener( this );
        add( btnOpcion1 );
        
        btnOpcion2 = new JButton( "Opci�n 2" );
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.addActionListener( this );
        add( btnOpcion2 );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param e Acci�n que gener� el evento. e != null.
     */
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        if( CONTENEDOR_MAS_PESADO.equals( comando ) )
        {
        	principal.buscarContenedorMasPesado();
        }
        else if( OPCION_1.equals( comando ) )
        {
            principal.opcion1( );
        }
        else if( OPCION_2.equals( comando ) )
        {
            principal.opcion2( );
        }

    }
}
