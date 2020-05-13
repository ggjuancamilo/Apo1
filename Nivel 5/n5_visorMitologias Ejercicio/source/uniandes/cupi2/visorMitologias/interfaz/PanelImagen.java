package uniandes.cupi2.visorMitologias.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelImagen extends JPanel
{
	private JLabel etiquetaImagen;
	
	public PanelImagen()
	{
		// TODO Auto-generated constructor stub
		setLayout( new BorderLayout( ) );
        setBackground( Color.WHITE );

        // Etiqueta Logo de la pizzería
        ImageIcon icono = new ImageIcon( "./data/imagenes/banner.png" );
        etiquetaImagen = new JLabel( "" );
        etiquetaImagen.setIcon( icono );
        etiquetaImagen.setHorizontalAlignment( JLabel.CENTER );
        etiquetaImagen.setVerticalAlignment( JLabel.CENTER );
        etiquetaImagen.setIcon( new ImageIcon( "./data/imagenes/banner.png" ) );

        add( etiquetaImagen, BorderLayout.CENTER );
	}
	
}
