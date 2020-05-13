package uniandes.cupi2.visorMitologias.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import sun.org.mozilla.javascript.internal.InterfaceAdapter;

public class PanelAcciones extends JPanel implements ActionListener
{
	private String[] nombres = {"Buscar mitología por nombre", "Buscar dios por especialidad", "Mitologia con mas dioses", "Opción 2"};
	private String[] acciones = {"a", "b", "c", "d"};
	private InterazVisorMitologias principal;
	
	public PanelAcciones(InterazVisorMitologias pPrincipal)
	{
		// TODO Auto-generated constructor stub
		principal = pPrincipal;
		
		setLayout(new GridLayout(2,2));
		setBorder(new TitledBorder("Acciones"));
		
		for (int i = 0; i < acciones.length; i++) 
		{
			JButton btn = new JButton(nombres[i]+"");
			btn.setActionCommand(acciones[i]+"");
			btn.addActionListener(this);
			add(btn);
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if(acciones[0].equals(e.getActionCommand()))
		{
			principal.buscarMitologia();
		}
		else if(acciones[1].equals(e.getActionCommand()))
		{
			principal.buscarDiosesPorEspecialidad();
		}
		else if(acciones[2].equals(e.getActionCommand()))
		{
			principal.reqFuncOpcion1();
		}
		else if(acciones[3].equals(e.getActionCommand()))
		{
			principal.reqFuncOpcion2();
		}
	}
	
}
