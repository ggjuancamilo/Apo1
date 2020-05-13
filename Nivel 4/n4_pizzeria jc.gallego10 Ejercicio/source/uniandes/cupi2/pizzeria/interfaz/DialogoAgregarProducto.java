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

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * Dialogo para agregar un producto a la pizzería.
 */
public class DialogoAgregarProducto extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para aceptar.
     */
    private final static String ACEPTAR = "Aceptar";

    /**
     * Constante para cancelar.
     */
    private final static String CANCELAR = "Cancelar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazPizzeria principal;


    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta nombre del producto.
     */
    private JLabel lblNombreProducto;
    
    /**
     * Etiqueta precio del producto.
     */
    private JLabel lblPrecio;

    /**
     * Cuadro de texto con el nombre del producto.
     */
    private JTextField txtNombreProducto;
    
    /**
     * Cuadro de texto con el precio del producto.
     */
    private JTextField txtPrecio;

    /**
     * Botón para aceptar.
     */
    private JButton btnAceptar;
    
    /**
     * Botón para cancelar.
     */
    private JButton btnCancelar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del diálogo para realizar un pedido.
     * @param pPrincipal Ventana principal de la aplicación.
     */
    public DialogoAgregarProducto( InterfazPizzeria pPrincipal )
    {

        super( pPrincipal, true );

        principal = pPrincipal;
        setTitle( "Agregar producto" );
        setSize( 250, 150 );
        setLayout( new java.awt.BorderLayout( ) );

        JPanel panelInformacion = new JPanel( );
        GridLayout layout = new GridLayout( 3, 2 );
        layout.setVgap( 8 );
        layout.setHgap( 8 );
        panelInformacion.setLayout( layout );

        lblNombreProducto = new JLabel( );
        lblNombreProducto.setText( "Nombre" );
        panelInformacion.add( lblNombreProducto );
        txtNombreProducto = new JTextField( );
        panelInformacion.add( txtNombreProducto );

        lblPrecio = new JLabel( );
        lblPrecio.setText( "Precio" );
        panelInformacion.add( lblPrecio );
        txtPrecio = new JTextField( );
        panelInformacion.add( txtPrecio );

        
        btnAceptar = new JButton( "Aceptar" );
        btnAceptar.setActionCommand( ACEPTAR );
        btnAceptar.addActionListener( this );
        panelInformacion.add( btnAceptar );

        btnCancelar = new JButton( "Cancelar" );
        btnCancelar.setActionCommand( CANCELAR );
        btnCancelar.addActionListener( this );
        panelInformacion.add( btnCancelar );

        add( panelInformacion, BorderLayout.CENTER );
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
        String comando = pEvento.getActionCommand( );
        if( ACEPTAR.equals( comando ) )
        {
            String nombre = txtNombreProducto.getText( );
            String precioPr = txtPrecio.getText( );
            boolean problemas = false;
            int tiempo=0;
            double precio=0;
            
            if(!nombre.equals( "")  && !precioPr.equals( ""))
            {
                try
                {
                    precio = Double.parseDouble( precioPr );
                }
                catch(NumberFormatException e1)
                {
                    problemas=true;
                    JOptionPane.showMessageDialog(this, "El precio tiene que ser un número.", "Error en precio", JOptionPane.ERROR_MESSAGE );
                }
                
                
                
                if(problemas==false)
                {
                    dispose();
                    principal.agregarProducto( nombre, precio );
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Debe llenar todos los datos.", "Error", JOptionPane.ERROR_MESSAGE );
            }
            
            
            
        }
        else if( CANCELAR.equals( comando ) )
        {
            dispose();
        }
    }

    
}
