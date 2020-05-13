package uniandes.cupi2.crucigrama.interfaz;


import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.crucigrama.mundo.Crucigrama;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

public class PanelPista extends JPanel
{
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

	/**
	 * 
	 */
	private JPanel pistaHorizontal;
	
	/**
	 * 
	 */
	private JPanel pistaVertical;
	
	private Crucigrama principal;
    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------
	
	public PanelPista()
	{
		setLayout(new GridLayout(2,1));	
		setBorder(null);

		
		pistaHorizontal = new JPanel();
		pistaHorizontal.setBorder(new TitledBorder("Horizontales"));
		pistaHorizontal.setSize(400,200);
		add(pistaHorizontal);
		
		pistaVertical = new JPanel();
		pistaVertical.setBorder(new TitledBorder("Verticales"));
		pistaVertical.setSize(400,200);
		add(pistaVertical);
		
		for( int i=0; i<principal.darDescH().length; i++)
		{
			JLabel descH = new JLabel();
			descH.setText(principal.darDescH()[i]);
			pistaHorizontal.add(descH);
		}
		for( int j=0; j<principal.DarDescV().length; j++)
		{
			JLabel descV = new JLabel();
			descV.setText(principal.DarDescV()[j]);
			pistaHorizontal.add(descV);
		}
	}
}
