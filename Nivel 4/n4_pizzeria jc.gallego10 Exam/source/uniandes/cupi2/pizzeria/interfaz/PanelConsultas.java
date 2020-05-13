/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
 * Panel que muestra las opciones de filtros para ver los pedidos.
 */
public class PanelConsultas extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para consultar todos los pedidos.
     */
    public final static String TODOS_LOS_PEDIDOS = "Ver todos los pedidos";

    /**
     * Constante para consultar pedidos cliente.
     */
    public final static String PEDIDOS_CLIENTE = "Ver los pedidos de un cliente";

    /**
     * Constante para consultar pedidos en elaboraci�n.
     */
    public final static String PEDIDOS_ELABORACION = "Ver los pedidos en elaboraci�n";

    /**
     * Constante para consultar pedidos despachados.
     */
    public final static String PEDIDOS_DESPACHADOS = "Ver los pedidos despachados";
    
    /**
     * Constante para consultar pedidos entregados.
     */
    public final static String PEDIDOS_ENTREGADOS = "Ver los pedidos entregados";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazPizzeria principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Bot�n para consultar todos los pedidos que hay en la pizzer�a.
     */
    private JButton btnTodosLosPedidos;

    /**
     * Bot�n para consultar los pedidos en elaboraci�n.
     */
    private JButton btnPedidosEnElaboracion;

    /**
     * Bot�n para consultar los pedidos de un cliente.
     */
    private JButton btnPedidosCliente;

    /**
     * Bot�n para consultar los pedidos despachados.
     */
    private JButton btnPedidosDespachados;
    
    /**
     * Bot�n para consultar los pedidos entregados.
     */
    private JButton btnPedidosEntregados;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel para mostrar las opciones disponibles.
     * @param pPrincipal Ventana principal de la aplicaci�n.
     */
    public PanelConsultas( InterfazPizzeria pPrincipal )
    {
        principal = pPrincipal;
        setBorder( BorderFactory.createTitledBorder( "Filtros de pedidos" ) );

        GridLayout layout = new GridLayout( 5, 1 );
        layout.setVgap( 10 );
        layout.setHgap( 15 );

        this.setLayout( layout );

        btnTodosLosPedidos = new JButton( TODOS_LOS_PEDIDOS );
        btnTodosLosPedidos.setActionCommand( TODOS_LOS_PEDIDOS );
        btnTodosLosPedidos.addActionListener( this );
        add( btnTodosLosPedidos );

        btnPedidosCliente = new JButton( PEDIDOS_CLIENTE );
        btnPedidosCliente.setActionCommand( PEDIDOS_CLIENTE );
        btnPedidosCliente.addActionListener( this );
        add( btnPedidosCliente );

        btnPedidosEnElaboracion = new JButton( PEDIDOS_ELABORACION );
        btnPedidosEnElaboracion.setActionCommand( PEDIDOS_ELABORACION );
        btnPedidosEnElaboracion.addActionListener( this );
        add( btnPedidosEnElaboracion );

        btnPedidosDespachados = new JButton( PEDIDOS_DESPACHADOS );
        btnPedidosDespachados.setActionCommand( PEDIDOS_DESPACHADOS );
        btnPedidosDespachados.addActionListener( this );
        add( btnPedidosDespachados );
        
        btnPedidosEntregados = new JButton( PEDIDOS_ENTREGADOS );
        btnPedidosEntregados.setActionCommand( PEDIDOS_ENTREGADOS );
        btnPedidosEntregados.addActionListener( this );
        add( btnPedidosEntregados );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * M�todo que recoge las acciones sobre los objetos que est� escuchando.
     * @param pEvento Evento que se realiz�.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( TODOS_LOS_PEDIDOS.equals( comando ) )
        {
            principal.mostrarTodosLosPedidos( );
        }
        else if( PEDIDOS_CLIENTE.equals( comando ) )
        {
            principal.mostrarInformacionPedidosCliente( );
        }
        else if( PEDIDOS_ELABORACION.equals( comando ) )
        {
            principal.mostrarInformacionPedidosEnElaboracion( );
        }
        else if( PEDIDOS_DESPACHADOS.equals( comando ) )
        {
            principal.mostrarInformacionPedidosDespachados( );
        }
        else if( PEDIDOS_ENTREGADOS.equals( comando ) )
        {
            principal.mostrarInformacionPedidosEntregados( );
        }
    }
}
