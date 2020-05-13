package uniandes.cupi2.visorMitologias.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.visorMitologias.mundo.Mitologia;



public class PanelMitologia extends JPanel implements ActionListener
{
	
	private InterazVisorMitologias principal;
	private Mitologia mitologia;
	

	
	
	private JLabel descripcionMit;
	private JLabel lugarMit;
	private JLabel rutaImagenMit;

	
	
	private JTextField txtNombreMit;
	private JTextField txtDescripcionMit;
	private JTextField txtLugarMit;
	
	
	
	private JPanel aux1;
	private JPanel aux2;
	private JPanel aux2a;
	private JPanel aux2b;
	private JPanel aux3; 
	
	public String[] botNom = {"<<","<",">",">>"};
	public String[] actBot = {"a","b","c","d"};
	
	
	public PanelMitologia(InterazVisorMitologias pPrincipal)
	{
		
	
		
		// TODO Auto-generated constructor stub
		
		principal = pPrincipal;
		setBorder(new TitledBorder("Mitologia"));
		setPreferredSize(new Dimension(350,0));
		setLayout(new BorderLayout());
		
		
		
		
		aux1 = new JPanel();
		aux2 = new JPanel();
		aux2a = new JPanel();
		aux2b = new JPanel();
		aux3 = new JPanel();

		
		mitologia = principal.darMitologiaActual();
		txtNombreMit = new JTextField(mitologia.darNombre());
		txtNombreMit.setForeground(mitologia.darColor());
		txtNombreMit.setEditable(false);
		rutaImagenMit = new JLabel();
		rutaImagenMit.setIcon(new ImageIcon(mitologia.darRutaImagen()));
		aux1.setLayout(new GridLayout(2,1));
		aux1.add(txtNombreMit);
		aux1.add(rutaImagenMit);	
		add(aux1,BorderLayout.NORTH);
		
		
		lugarMit = new JLabel("Lugar:");
		txtLugarMit = new JTextField(mitologia.darLugar());
		txtLugarMit.setEditable(false);
		
		descripcionMit = new JLabel("Descripción");
		String textoDescripcion = mitologia.darDescripcion();
		String textoConFormato = String.format("<html><div align=\"justify\" style=\"width:%dpx;\">%s</div><html>", 250, textoDescripcion); 
		descripcionMit.setText ( textoConFormato );
		txtDescripcionMit  = new JTextField();
		
		txtDescripcionMit.setEditable(false);
		
		aux2.setLayout(new BorderLayout());
		
		aux2a.add(lugarMit);
		aux2a.add(txtLugarMit);
		aux2a.setLayout(new GridLayout(1,2));
		aux2.add(aux2a,BorderLayout.NORTH);
		
		
		aux2b.setLayout(new BorderLayout());
		aux2b.add(descripcionMit, BorderLayout.SOUTH);
		aux2b.add(txtDescripcionMit, BorderLayout.NORTH);
		aux2.add(aux2b, BorderLayout.SOUTH);
		
		add(aux2,BorderLayout.CENTER);

		
		aux3.setLayout(new GridLayout(1,4));
		
		for (int i = 0; i < actBot.length; i++)
		{
			JButton btn = new JButton(botNom[i]+"");
			btn.setActionCommand(actBot[i]+"");
			btn.addActionListener(this);
			aux3.add(btn);
		}
		add(aux3, BorderLayout.SOUTH);
		
		
	}
		
	public void actualizar(Mitologia mith )
	{
		txtNombreMit.setText(mith.darNombre());
		txtLugarMit.setText(mith.darLugar());
		String textoDescripcion = mith.darDescripcion();
		String textoConFormato = String.format("<html><div align=\"justify\" style=\"width:%dpx;\">%s</div><html>", 250, textoDescripcion); 
		descripcionMit.setText ( textoConFormato );
		txtDescripcionMit.setText("descripcion:");
		
		rutaImagenMit.setIcon(new ImageIcon(mith.darRutaImagen()));
		// TODO Auto-generated method stub
		System.out.println("gfg");
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (actBot[0].equals(e.getActionCommand())) 
		{
			principal.actualizarPrimeraMitologia();
		}
		else if (actBot[1].equals(e.getActionCommand()))
		{
			principal.actualizarMitologiaAnterior();
		}
		else if (actBot[2].equals(e.getActionCommand()))
		{
			principal.actualizarMitologiaSiguiente();
		}
		else if ( actBot[3].equals(e.getActionCommand()))
		{
			principal.actualizarUltimaMitologia();
		}
		// TODO Auto-generated method stub
		
	}
}