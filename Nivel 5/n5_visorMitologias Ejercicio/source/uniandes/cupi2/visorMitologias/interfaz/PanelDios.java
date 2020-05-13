package uniandes.cupi2.visorMitologias.interfaz;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.visorMitologias.mundo.Dios;
import uniandes.cupi2.visorMitologias.mundo.Mitologia;
import uniandes.cupi2.visorMitologias.mundo.VisorMitologias;

public class PanelDios extends JPanel implements ActionListener
{
	
	
	private InterazVisorMitologias principal;
	private Dios dios;
	

	
	
	private JLabel descripcionDios;
	private JLabel especialidadDios;
	private JLabel esPrincipal;
	private JLabel rutaImagenDios;

	
	
	private JTextField txtNombreDios;
	private JTextField txtDescripcionDios;
	private JTextField txtEspecialidadDios;
	
	private JCheckBox checkPrincipal;
	
	
	private JPanel aux1;
	private JPanel aux2;
	private JPanel aux2a;
	private JPanel aux2b;
	private JPanel aux3; 
	
	public String[] botNom = {"<<","<",">",">>"};
	public String[] actBot = {"a","b","c","d"};
	
	
	public PanelDios(InterazVisorMitologias pPrincipal)
	{
		
	
		
		// TODO Auto-generated constructor stub
		
		principal = pPrincipal;
		setBorder(new TitledBorder("Dios"));
		setPreferredSize(new Dimension(350,0));
		setLayout(new BorderLayout());
		
		dios = principal.darMitologiaActual().darDiosActual();
		
		
		aux1 = new JPanel();
		aux2 = new JPanel();
		aux2a = new JPanel();
		aux2b = new JPanel();
		aux3 = new JPanel();

		txtNombreDios = new JTextField(dios.darNombre());
		txtNombreDios.setEditable(false);
		rutaImagenDios = new JLabel();
		rutaImagenDios.setIcon(new ImageIcon(dios.darRutaImagen()));
		aux1.setLayout(new GridLayout(2,1));
		aux1.add(txtNombreDios);
		aux1.add(rutaImagenDios);	
		add(aux1,BorderLayout.NORTH);
		
		
		
		especialidadDios = new JLabel("Especialidad:");
		txtEspecialidadDios = new JTextField(dios.darEspecialidad());
		txtEspecialidadDios.setEditable(false);
		
		esPrincipal = new JLabel("¿Es principal?");
		checkPrincipal = new JCheckBox();
		checkPrincipal.setEnabled(false);
		
		descripcionDios = new JLabel();
		txtDescripcionDios  = new JTextField("Descripción");
		String textoOriginal = dios.darDescripcion();
		String textoFormato = String.format("<html><div align=\"justify\" style=\"width:%dpx;\">%s</div><html>", 100, textoOriginal);
		descripcionDios.setText(textoFormato);
		txtDescripcionDios.setEditable(false);
		
		aux2.setLayout(new BorderLayout());
		
		aux2a.add(especialidadDios);
		aux2a.add(txtEspecialidadDios);
		aux2a.add(esPrincipal);
		aux2a.add(checkPrincipal);
		aux2a.setLayout(new GridLayout(2,2));
		aux2.add(aux2a,BorderLayout.NORTH);
		
		
		aux2b.setLayout(new BorderLayout());
		aux2b.add(descripcionDios, BorderLayout.SOUTH);
		aux2b.add(txtDescripcionDios, BorderLayout.NORTH);
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
		
	public void actualizar(Dios dios)
	{
		txtNombreDios.setText(dios.darNombre()+"");
		txtEspecialidadDios.setText(dios.darEspecialidad()+"");
		String textoOriginal = dios.darDescripcion();
		String textoFormato = String.format("<html><div align=\"justify\" style=\"width:%dpx;\">%s</div><html>", 100, textoOriginal);
		descripcionDios.setText(textoFormato);
		rutaImagenDios.setIcon(new ImageIcon(dios.darRutaImagen()));
	
		
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (actBot[0].equals(e.getActionCommand())) 
		{
			principal.actualizarPrimerDios();
		}
		else if (actBot[1].equals(e.getActionCommand()))
		{
			principal.actualizarDiosAnterior();
		}
		else if (actBot[2].equals(e.getActionCommand()))
		{
			principal.actualizarDiosSiguiente();
		}
		else if ( actBot[3].equals(e.getActionCommand()))
		{
			principal.actualizarUltimoDios();
		}
		// TODO Auto-generated method stub
		
	}

	
}
