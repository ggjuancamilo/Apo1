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
 * Panel de administración de los planetas.
 */
public class PanelInformacionPlanetas extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para agregar un satélite a un planeta.
     */
    public static final String AGREGAR_SATELITE = "AGREGAR_SATELITE";
    
    /**
     * Constante para editar un satélite de un planeta.
     */
    public static final String EDITAR_SATELITE = "EDITAR_SATELITE";

    /**
     * Constante para cambiar la información de un planeta.
     */
    public static final String CAMBIAR_PLANETA = "CAMBIAR_PLANETA";

    /**
     * Constante para consultar los satélites naturales que tienen una excentricidad menor a un excentricidad dada.
     */
    public static final String CONSULTAR_SATELITES_POR_EXCENTRICIDAD = "CONSULTAR_SATELITES_POR_EXCENTRICIDAD";

    /**
     * Constante para consultar los planetas que tiene una menor inclinación a otro planeta.
     */
    public static final String CONSULTAR_PLANETAS_POR_INCLINACION = "CONSULTAR_PLANETAS_POR_INCLINACION";
    
    /**
     * Constante para consultar el planeta con mayor número de satélites.
     */
    public static final String CONSULTAR_PLANETA_MAYOR_SATELITES = "CONSULTAR_PLANETA_MAYOR_SATELITES";
 
    /**
     * Constante para consultar el número de satélites artificiales que ofrecen servicio de tipo militar.
     */
    public static final String CONSULTAR_SATELITE_MILITAR = "CONSULTAR_SATELITE_MILITAR";
    

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
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
     * Botón para agregar un nuevo satélite al planeta seleccionado.
     */
    private JButton btnAgregarSatelite;
    
    /**
     * Botón para editar un satélite del planeta seleccionado.
     */
    private JButton btnEditarSatelite;

    /**
     * Botón para consultar los satélites naturales por excentricidad.
     */
    private JButton btnConsultarMayorExcentricidad;

    /**
     * Botón para consultar los planetas por inclinación.
     */
    private JButton btnConsultarPorInclinacion;
    
    /**
     * Botón para consultar el planeta con mayor número de satélites naturales.
     */
    private JButton btnConsultarMayor;
    
    /**
     * Botón para consultar el número de satélites artificiales que ofrecen servicio de tipo militar.
     */
    private JButton btnConsultaSateliteMilitar;

    /**
     * Panel que contiene los botones.
     */
    private JPanel panelBotones;

    /**
     * Panel que contiene la lista de planetas y satélites naturales.
     */
    private JPanel panelCombo;

    /**
     * Scroll de la lista de los satélites naturales.
     */
    private JScrollPane scrollSatelites;

    /**
     * Lista de los satélites naturales.
     */
    private JList listaSatelites;
    
    /**
     * Panel con las propiedades del planeta actual.
     */
    private PanelPropiedadesPlaneta panelPropiedadesPlaneta;
    
    /**
     * Panel con las propiedades del satélite artificial.
     */
    private PanelSateliteArtificial artificial;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor de la clase del panel de administración de los planetas.
     * @param pPrincipal Ventana principal de la aplicación.
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

        btnConsultarMayorExcentricidad = new JButton( "Satélites naturales con mayor excentricidad a..." );
        btnConsultarMayorExcentricidad.addActionListener( this );
        btnConsultarMayorExcentricidad.setActionCommand( CONSULTAR_SATELITES_POR_EXCENTRICIDAD );
        
        btnConsultarPorInclinacion = new JButton( "Planetas con menor inclinación a..." );
        btnConsultarPorInclinacion.addActionListener( this );
        btnConsultarPorInclinacion.setActionCommand( CONSULTAR_PLANETAS_POR_INCLINACION );
        
        btnConsultarMayor = new JButton( "Planeta con más satélites naturales." );
        btnConsultarMayor.addActionListener( this );
        btnConsultarMayor.setActionCommand( CONSULTAR_PLANETA_MAYOR_SATELITES);
        
        btnConsultaSateliteMilitar = new JButton( "Cantidad de satélites artificiales de tipo militar" );
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
        panelListaSatelites.setBorder( new TitledBorder( "Lista de satélites naturales" ) );
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
     * @param e Acción que generó el evento.
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
     * Actualiza la lista de los satélites naturales con la información que entra por parámetro.
     * @param pSatelitesNaturales Lista con los satélites naturales.
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
     * Actualiza la información del satélite artificial con la información que entra por parámetro.
     * @param pSatelite Satélite artificial del planeta seleccionado.
     */
	public void llenarInformacionSatelitesArtificial(SateliteArtificial pSatelite) {
		
		artificial.actualizarPropiedades(principal.buscarPlaneta(darPlanetaSeleccionado( )));
		
	}

}

