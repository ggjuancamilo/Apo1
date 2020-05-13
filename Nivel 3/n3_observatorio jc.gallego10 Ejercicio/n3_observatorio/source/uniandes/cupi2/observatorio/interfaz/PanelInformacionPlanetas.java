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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import uniandes.cupi2.observatorio.mundo.Planeta;
import uniandes.cupi2.observatorio.mundo.SateliteArtificial;

/**
 * Panel de administraci�n de los planetas.
 */
public class PanelInformacionPlanetas extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para agregar un sat�lite a un planeta.
     */
    public static final String AGREGAR_SATELITE = "AGREGAR_SATELITE";
    
    /**
     * Constante para editar un sat�lite de un planeta.
     */
    public static final String EDITAR_SATELITE = "EDITAR_SATELITE";

    /**
     * Constante para cambiar la informaci�n de un planeta.
     */
    public static final String CAMBIAR_PLANETA = "CAMBIAR_PLANETA";

    /**
     * Constante para consultar los sat�lites naturales que tienen una excentricidad menor a un excentricidad dada.
     */
    public static final String CONSULTAR_SATELITES_POR_EXCENTRICIDAD = "CONSULTAR_SATELITES_POR_EXCENTRICIDAD";

    /**
     * Constante para consultar los planetas que tiene una menor inclinaci�n a otro planeta.
     */
    public static final String CONSULTAR_PLANETAS_POR_INCLINACION = "CONSULTAR_PLANETAS_POR_INCLINACION";
    
    /**
     * Constante para consultar el planeta con mayor n�mero de sat�lites.
     */
    public static final String CONSULTAR_PLANETA_MAYOR_SATELITES = "CONSULTAR_PLANETA_MAYOR_SATELITES";
 
    /**
     * Constante para consultar el n�mero de sat�lites artificiales que ofrecen servicio de tipo militar.
     */
    public static final String CONSULTAR_SATELITE_MILITAR = "CONSULTAR_SATELITE_MILITAR";
    

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
     * Etiqueta con la imagen de un planeta.
     */
    private JLabel lblImagen;

    /**
     * Combo con los nombres de los planetas.
     */
    private JComboBox comboPlanetas;

    /**
     * Bot�n para agregar un nuevo sat�lite al planeta seleccionado.
     */
    private JButton btnAgregarSatelite;
    
    /**
     * Bot�n para editar un sat�lite del planeta seleccionado.
     */
    private JButton btnEditarSatelite;

    /**
     * Bot�n para consultar los sat�lites naturales por excentricidad.
     */
    private JButton btnConsultarMayorExcentricidad;

    /**
     * Bot�n para consultar los planetas por inclinaci�n.
     */
    private JButton btnConsultarPorInclinacion;
    
    /**
     * Bot�n para consultar el planeta con mayor n�mero de sat�lites naturales.
     */
    private JButton btnConsultarMayor;
    
    /**
     * Bot�n para consultar el n�mero de sat�lites artificiales que ofrecen servicio de tipo militar.
     */
    private JButton btnConsultaSateliteMilitar;

    /**
     * Panel que contiene los botones.
     */
    private JPanel panelBotones;

    /**
     * Panel que contiene la lista de planetas y sat�lites naturales.
     */
    private JPanel panelCombo;

    /**
     * Scroll de la lista de los sat�lites naturales.
     */
    private JScrollPane scrollSatelites;

    /**
     * Lista de los sat�lites naturales.
     */
    private JList listaSatelites;
    
    /**
     * Panel con las propiedades del planeta actual.
     */
    private PanelPropiedadesPlaneta panelPropiedadesPlaneta;
    
    /**
     * Panel con las propiedades del sat�lite artificial.
     */
    private PanelSateliteArtificial artificial;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor de la clase del panel de administraci�n de los planetas.
     * @param pPrincipal Ventana principal de la aplicaci�n.
     */
    public PanelInformacionPlanetas( InterfazObservatorio pPrincipal )
    {
    	principal = pPrincipal;
    	panelPropiedadesPlaneta = new PanelPropiedadesPlaneta(principal.buscarPlaneta("Mercurio"));
    	artificial = new PanelSateliteArtificial(pPrincipal, principal.buscarPlaneta("Mercurio"));
        panelBotones = new JPanel( );
        panelCombo = new JPanel( );
        listaSatelites = new JList( );
        panelCombo.setLayout( new GridBagLayout( ) );
        panelBotones.setLayout( new GridBagLayout( ) );
        setLayout( new GridBagLayout( ) );
        scrollSatelites = new JScrollPane( listaSatelites );
        lblImagen = new JLabel( );
        Icon icono = new ImageIcon( );
        lblImagen.setIcon( icono );

        comboPlanetas = new JComboBox( principal.darNombresPlanetas( ) );
        comboPlanetas.addActionListener( this );
        comboPlanetas.setActionCommand( CAMBIAR_PLANETA );
        comboPlanetas.setSelectedIndex( 0 );

        btnAgregarSatelite = new JButton( "Agregar" );
        btnAgregarSatelite.addActionListener( this );
        btnAgregarSatelite.setActionCommand( AGREGAR_SATELITE );
        
        btnEditarSatelite = new JButton( "Editar" );
        btnEditarSatelite.addActionListener( this );
        btnEditarSatelite.setActionCommand( EDITAR_SATELITE );

        btnConsultarMayorExcentricidad = new JButton( "Sat�lites naturales con mayor excentricidad a..." );
        btnConsultarMayorExcentricidad.addActionListener( this );
        btnConsultarMayorExcentricidad.setActionCommand( CONSULTAR_SATELITES_POR_EXCENTRICIDAD );
        
        btnConsultarPorInclinacion = new JButton( "Planetas con menor inclinaci�n a..." );
        btnConsultarPorInclinacion.addActionListener( this );
        btnConsultarPorInclinacion.setActionCommand( CONSULTAR_PLANETAS_POR_INCLINACION );
        
        btnConsultarMayor = new JButton( "Planeta con m�s sat�lites naturales." );
        btnConsultarMayor.addActionListener( this );
        btnConsultarMayor.setActionCommand( CONSULTAR_PLANETA_MAYOR_SATELITES);
        
        btnConsultaSateliteMilitar = new JButton( "Cantidad de sat�lites artificiales de tipo militar" );
        btnConsultaSateliteMilitar.addActionListener( this );
        btnConsultaSateliteMilitar.setActionCommand( CONSULTAR_SATELITE_MILITAR);
        
        
        JPanel panelPlaneta = new JPanel();
        panelPlaneta.setLayout(new BorderLayout());
        panelPlaneta.add(lblImagen,BorderLayout.CENTER);
        panelPlaneta.add(panelPropiedadesPlaneta,BorderLayout.SOUTH);
        GridBagConstraints constraint = new GridBagConstraints( );
        constraint.gridx = 0;
        constraint.gridy = 0;
        constraint.gridheight = 2;
        panelCombo.add( panelPlaneta, constraint );

        constraint = new GridBagConstraints( );
        constraint.gridx = 1;
        constraint.gridy = 0;
        Insets insets = new Insets( 5, 20, 5, 10 );
        constraint.insets = insets;
        
        JPanel panelDerecha = new JPanel();
        panelDerecha.setPreferredSize(new Dimension(300, 420));
        panelDerecha.setLayout(new BorderLayout());
        
        JPanel panelListaPlanetas = new JPanel();
        panelListaPlanetas.setBorder( new TitledBorder( "Lista de planetas" ) );
        panelListaPlanetas.setPreferredSize(new Dimension(300, 50));
        panelListaPlanetas.setLayout(new BorderLayout());
        panelListaPlanetas.add(comboPlanetas,BorderLayout.CENTER);
        
        panelDerecha.add(panelListaPlanetas,BorderLayout.NORTH);
        
        JPanel panelListaSatelites = new JPanel();
        panelListaSatelites.setBorder( new TitledBorder( "Lista de sat�lites naturales" ) );
        panelListaSatelites.setLayout(new BorderLayout());
        panelListaSatelites.add(scrollSatelites,BorderLayout.CENTER);
        
        JPanel panelOpcionesSatelites = new JPanel();
        panelOpcionesSatelites.setLayout( new GridLayout(0, 2) );
        panelOpcionesSatelites.add(btnAgregarSatelite);
        panelOpcionesSatelites.add(btnEditarSatelite);
        
        panelListaSatelites.add(panelOpcionesSatelites,BorderLayout.SOUTH);
        
        panelDerecha.add(panelListaSatelites,BorderLayout.CENTER);
        panelDerecha.add(artificial,BorderLayout.SOUTH);
        panelCombo.add( panelDerecha, constraint );

        constraint = new GridBagConstraints( );
        constraint.gridx = 1;
        constraint.gridy = 0;
        insets = new Insets( 5, 10, 5, 10 );
        constraint.insets = insets;
        constraint.fill = GridBagConstraints.BOTH;
        constraint.weighty = 1;
        add( panelCombo, constraint );
        
        JPanel panelConsultas= new JPanel();
        panelConsultas.setBorder( new TitledBorder( "Consultas" ) );
        panelConsultas.setPreferredSize(new Dimension(750, 80));
        panelConsultas.setLayout( new GridLayout(0, 2) );
        panelConsultas.add(btnConsultarMayorExcentricidad);
        panelConsultas.add(btnConsultarPorInclinacion);
        panelConsultas.add(btnConsultarMayor);
        panelConsultas.add(btnConsultaSateliteMilitar);

        constraint = new GridBagConstraints( );
        constraint.gridx = 1;
        constraint.gridy = 0;
        insets = new Insets( 5, 2, 5, 2 );
        constraint.insets = insets;
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.weighty = 1;
        panelBotones.add( panelConsultas, constraint );

        constraint = new GridBagConstraints( );
        constraint.gridx = 1;
        constraint.gridy = 1;
        add( panelBotones, constraint );
    }

    /**
     * Manejo de los eventos de los botones.
     * @param e Acci�n que gener� el evento.
     */
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        if( comando.equals( CAMBIAR_PLANETA ) )
        {
            cambiarImagen( );
            Planeta actual = principal.buscarPlaneta(darPlanetaSeleccionado( ));
            panelPropiedadesPlaneta.actualizarPropiedades(actual);
            llenarListaSatelitesNaturales( principal.darPropiedadesSatelitesNaturales( darPlanetaSeleccionado( ) ) );
            artificial.actualizarPropiedades(actual);
        }
        else if( comando.equals( AGREGAR_SATELITE ) )
        {
            principal.mostrarDialogoSateliteCreacion( );
        }
        else if( comando.equals( CONSULTAR_SATELITES_POR_EXCENTRICIDAD ) )
        {
            principal.mostrarDialogoConsultarPorExcentricidad( );
        }
        else if( comando.equals( CONSULTAR_PLANETAS_POR_INCLINACION ) )
        {
            principal.mostrarDialogoConsultarPorInclinacion( );
        }
        else if( comando.equals( CONSULTAR_PLANETA_MAYOR_SATELITES ) )
        {
        	principal.mostrarDialogoConsultarMayorSatelites( );
        }
        else if( comando.equals( CONSULTAR_SATELITE_MILITAR ) )
        {
        	principal.mostrarDialogoConsultarSateliteMilitar();
        }
        else if( comando.equals( EDITAR_SATELITE ) )
        {
        	if(listaSatelites.getSelectedValue( )!=null){
        		principal.mostrarDialogoSateliteEdicion( darPlanetaSeleccionado( ), ((String)listaSatelites.getSelectedValue()).split(" - ")[0] );
        	}
        }
    }

    /**
     * Actualiza la lista de los sat�lites naturales con la informaci�n que entra por par�metro.
     * @param pSatelitesNaturales Lista con los sat�lites naturales.
     */
    public void llenarListaSatelitesNaturales( ArrayList pSatelitesNaturales )
    {
        listaSatelites.removeAll( );
        listaSatelites.setListData( pSatelitesNaturales.toArray( ) );
    }

    /**
     * Cambia la imagen que se ve en pantalla, de acuerdo al planeta seleccionado.
     */
    private void cambiarImagen( )
    {
        String seleccionado = darPlanetaSeleccionado( );
        Icon icono = new ImageIcon( "./data/" + seleccionado + ".jpg" );
        lblImagen.setIcon( icono );
    }

    /**
     * Devuelve el nombre del planeta seleccionado.
     * @return Nombre del planeta seleccionado. 
     */
    public String darPlanetaSeleccionado( )
    {
        return ( String )comboPlanetas.getSelectedItem( );
    }

    /**
     * Actualiza la informaci�n del sat�lite artificial con la informaci�n que entra por par�metro.
     * @param pSatelite Sat�lite artificial del planeta seleccionado.
     */
	public void llenarInformacionSatelitesArtificial(SateliteArtificial pSatelite) {
		
		artificial.actualizarPropiedades(principal.buscarPlaneta(darPlanetaSeleccionado( )));
		
	}

}

