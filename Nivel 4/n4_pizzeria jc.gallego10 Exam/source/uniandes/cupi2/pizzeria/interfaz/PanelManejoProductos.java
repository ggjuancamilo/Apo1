/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_pizzeria
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.pizzeria.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Panel que muestra las opciones para manejar los productos de la pizzería.
 */
public class PanelManejoProductos extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para agregar un producto.
     */
    public final static String AGREGAR = "Agregar producto";

    /**
     * Comando para eliminar un producto.
     */
    public final static String ELIMINAR = "Eliminar producto";
    

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazPizzeria principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Botón para agregar un producto.
     */
    private JButton btnAgregarProducto;
    
    /**
     * Botón para eliminar un producto.
     */
    private JButton btnEliminarProducto;


    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel para mostrar las opciones de manejo de  productos.
     * @param pPrincipal Ventana principal de la aplicación.
     */
    public PanelManejoProductos( InterfazPizzeria pPrincipal )
    {
        principal = pPrincipal;
        setBorder( BorderFactory.createTitledBorder( "Productos" ) );

        GridLayout layout = new GridLayout( 2, 1 );
        layout.setVgap( 10 );
        layout.setHgap( 15 );

        this.setLayout( layout );

        btnAgregarProducto = new JButton( AGREGAR );
        btnAgregarProducto.setActionCommand( AGREGAR );
        btnAgregarProducto.addActionListener( this );
        add( btnAgregarProducto );

        btnEliminarProducto = new JButton( ELIMINAR );
        btnEliminarProducto.setActionCommand( ELIMINAR );
        btnEliminarProducto.addActionListener( this );
        add( btnEliminarProducto );

        
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Método que recoge las acciones sobre los objetos que está escuchando.
     * @param pEvento Evento que se realizó.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        if( AGREGAR.equals( pEvento.getActionCommand( ) ) )
        {
            principal.mostrarDialogoAgregarProducto( );
        }
        else if( ELIMINAR.equals( pEvento.getActionCommand( ) ) )
        {
            principal.eliminarProducto();
        }
        
    }
}
