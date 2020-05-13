package uniandes.cupi2.visorMitologias.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.cupi2.visorMitologias.mundo.Dios;
import uniandes.cupi2.visorMitologias.mundo.Mitologia;
import uniandes.cupi2.visorMitologias.mundo.VisorMitologias;

public class InterazVisorMitologias extends JFrame
{
	private VisorMitologias visorMitologias;

	private Mitologia mitologia;

	private PanelDios panelDios;

	private PanelMitologia panelMitologia;

	private PanelImagen panelImagen;

	private PanelAcciones panelAcciones;
	private JPanel panelCentralEnCero;

	public InterazVisorMitologias() 
	{
		// TODO Auto-generated constructor stub

	
		try 
		{
			visorMitologias = new VisorMitologias();
			
			setLayout(new BorderLayout());
			setSize(700,700);
			setResizable(false);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setTitle("Visor Mitologia");
			
			/*
			 * Panel Imagen
			 */
			panelImagen = new PanelImagen();
			add(panelImagen, BorderLayout.NORTH);
		
			
			/*
			 * Panel Mitologia
			 */
			panelMitologia = new PanelMitologia(this);
			panelMitologia.setSize(350,350);
			add(panelMitologia, BorderLayout.WEST);
			/*
			 * Panel Dios
			 */
			panelDios = new PanelDios(this);
			panelDios.setSize(350,350);
			add(panelDios,BorderLayout.EAST);
			/*
			 * Panel Acciones
			 */
			panelAcciones = new PanelAcciones(this);
			add(panelAcciones,BorderLayout.SOUTH);
			
			panelCentralEnCero = new JPanel();
			setPreferredSize(null);
			add(panelCentralEnCero, BorderLayout.CENTER);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			// TODO: handle exception
		}


	}
	public Mitologia darMitologiaActual()
	{
		return visorMitologias.darMitologiaActual();
	}
	
	
	
	public Mitologia buscarMitologia(String nombreMitologia)
	{
		return visorMitologias.buscarMitologia(nombreMitologia);
	}

	
	public void ActualizarDiosActualx(Dios diosAct)
	{
		panelDios.actualizar(diosAct);
	}
	
	public void actualizarMitologia()
	{
		
		panelMitologia.actualizar(visorMitologias.darMitologiaActual());
	}
	
	
	
	/**
	 * 
	 */
	public void actualizarPrimeraMitologia()
	{
		try 
		{
			Mitologia x = visorMitologias.darPrimeraMitologia();
			panelMitologia.actualizar(x);
			panelDios.actualizar(x.darDiosActual());
			
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "Se encuentra en la primera mitologia","Error", JOptionPane.WARNING_MESSAGE);
		}
	}
	/**
	 * 
	 */
	public void actualizarMitologiaAnterior()
	{
		try 
		{
			Mitologia x = visorMitologias.darMitologiaAnterior();
			panelMitologia.actualizar(x);
			panelDios.actualizar(x.darDiosActual());
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Se encuentra en la primera mitologia","Error", JOptionPane.WARNING_MESSAGE);
		}
	}
	/**
	 * 
	 */
	public void actualizarMitologiaSiguiente()
	{
		try
		{
			Mitologia x = visorMitologias.darMitologiaSiguiente();
			panelMitologia.actualizar(x);
			panelDios.actualizar(x.darDiosActual());
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, "Se encuentra en la ultima mitologia","Error", JOptionPane.WARNING_MESSAGE);
		}
	}
	/**
	 * 
	 */
	public void actualizarUltimaMitologia()
	{
		try
		{
			
			Mitologia x = visorMitologias.darUltimaMitologia();
			panelMitologia.actualizar(x);
			panelDios.actualizar(x.darDiosActual());
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, "Se encuentra en la ultima mitologia","Error", JOptionPane.WARNING_MESSAGE);
		}
	}
	/**
	 * 
	 */
	public void actualizarPrimerDios()
	{
		try
		{
			panelDios.actualizar(visorMitologias.darMitologiaActual().darPrimerDios());
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, "Se encuentra en el primer dios","Error", JOptionPane.WARNING_MESSAGE);
		}
	}
	/**
	 * 
	 */
	public void actualizarDiosAnterior()
	{
		try
		{
			panelDios.actualizar(visorMitologias.darMitologiaActual().darDiosAnterior());
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, "Se encuentra en el primer dios","Error", JOptionPane.WARNING_MESSAGE);
		}
	}
	/**
	 * 
	 */
	public void actualizarDiosSiguiente()
	{
		try
		{
			panelDios.actualizar(visorMitologias.darMitologiaActual().darDiosSiguiente());
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, "Se encuentra en el ultimo dios","Error", JOptionPane.WARNING_MESSAGE);
		}
	}
	/**
	 * 
	 */
	public void actualizarUltimoDios()
	{

		try
		{
			panelDios.actualizar(visorMitologias.darMitologiaActual().darUltimoDios());
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, "Se encuentra en el ultimo dios","Error", JOptionPane.WARNING_MESSAGE);
		}
	}
	/**
	 * 
	 */
	public void buscarMitologia()
	{

		try
		{
			visorMitologias.buscarMitologia(JOptionPane.showInputDialog("Ingrese el nombre de la mitologia:"));
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, "No hay una mitologia con este nombre: ","Error", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	
	public void buscarDiosesPorEspecialidad()
	{

		try 
		{
			visorMitologias.buscarDiosesPorEspecialidad(JOptionPane.showInputDialog("Ingrese el nombre de la especialidad:"));
		} 
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(this, "No hay una especialidad con este nombre: ","Error", JOptionPane.WARNING_MESSAGE);
			// TODO: handle exception
		}
	}

	/**
	 * 
	 */
	public void actualizarPanelMitologia(Mitologia pMitologia)
	{
		pMitologia = visorMitologias.darMitologiaActual();
		actualizarMitologia();
		actualizarPrimerDios();
		
	}
	/**
	 * 
	 */
	public void actualizarPanelDios(Dios pDios)
	{
		panelDios.actualizar(visorMitologias.darMitologiaActual().darDiosActual());
	}
	/**
	 * Método para la extensión 1
	 */
	public void reqFuncOpcion1( )
	{
		String resultado = visorMitologias.metodo1();
		JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
	}

	/**
	 * Método para la extensión 2
	 */
	public void reqFuncOpcion2( )
	{
		String resultado = visorMitologias.metodo2();
		JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
	}


	//-----------------------------------------------------------------
	// Main
	//-----------------------------------------------------------------

	/**
	 * Este método ejecuta la aplicación, creando una nueva interfaz
	 * @param args
	 */
	public static void main( String[] args )
	{

		InterazVisorMitologias interfaz = new InterazVisorMitologias();
		interfaz.setVisible( true );
	}

}
