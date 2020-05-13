package uniandes.cupi2.crucigrama.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.crucigrama.mundo.Casilla;
import uniandes.cupi2.crucigrama.mundo.Crucigrama;

public class PanelTablero extends JPanel
{
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------
	public static final Color  COL_SIN_JUEGO= Color.WHITE;
	public static final Color  COL_NO_JUGABLE= Color.BLACK;
	public  static final Color  COL_INCORRECTA=Color.RED;
	public static final Color  COL_CORRECTA=Color.GREEN; 
	//-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------
	private InterfazCrucigrama principal;
	private int alto;
	private int ancho;
	private JTextField[][] casillas;	
  
	//-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------
	
	public PanelTablero(InterfazCrucigrama pPrincipal, int pAlto, int pAncho)
	{
		setBorder(new TitledBorder("Crucigrama"));
		
		principal=pPrincipal;
		alto = pAlto;
		ancho = pAncho;
		setLayout(new GridLayout(alto+1, ancho+1));
		casillas = new JTextField[alto][ancho];		
		setVisible(true);
		add(new JLabel(""));
		
		
		for (  int i =0;    i<alto ;   i++)
		{
			JLabel etiqueta = new JLabel(""+(i+1));
			etiqueta.setHorizontalAlignment(JTextField.CENTER);
			add(etiqueta);
			Casilla[][] casilla = principal.darCrucigrama();
			for(int j=0      ;j<ancho      ;  j++)
			{
				if(casilla[i][j].darvalCorr()==Casilla.INICIAL)
				{
					casillas[ i ][ j ] = new JTextField( "" );
					casillas[i][j].setBackground(Color.BLACK);
					casillas[i][j].setEditable(false);
					add( casillas[ i ][ j] );
				}
				else 
				{
					casillas[ i ][ j ] = new JTextField( "" );
					casillas[ i ][ j ].setHorizontalAlignment( JTextField.CENTER );     
					casillas[ i ][ j ].setPreferredSize( new Dimension( 40, 40 ) );
					casillas[ i ][ j ].setEditable( true );
					add( casillas[ i ][ j ] );
				}
			}
		}
		
		for(int i=1   ;   i< ancho+1     ;i++)
		{
			JLabel etiqueta = new JLabel(""+i);
			etiqueta.setHorizontalAlignment(JTextField.CENTER);
			add(etiqueta);
		}
	}
	
	//-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------
	
	public void darColor(int estado)
	{
		for( int i = 0; i < alto; i++ )
		{
			for( int j = 0; j < ancho; j++ )
			{
				if(estado == Casilla.CORRECTO )
				{
					casillas[i][j].setBackground( COL_CORRECTA);
				}
				else if(estado==Casilla.INCORRECTO )
				{
					casillas[ i ] [ j ].setBackground(COL_INCORRECTA);
				}
				else if(estado==Casilla.SIN_JUGAR )
				{
					casillas[ i ] [ j ].setBackground(COL_SIN_JUEGO);
				}
			}
		}
	}
	
	
	public void solucionarCrucigrama()
	{
		String mensaje = "Se pintan de verde las casillas correctas, de rojo las casillas erroneas y de blanco las casillas vacias";
		JOptionPane.showMessageDialog( this, mensaje, "Solucion crucigrama", JOptionPane.INFORMATION_MESSAGE);
		Casilla[][] casillasaa = principal.darCrucigrama();
	
		for( int i = 0; i < alto; i++ )
		{
			for( int j = 0; j < ancho; j++ )
			{
				if(casillas[ i ][ j ].getText().length()  != 0)
				{
					casillasaa[ i ][ j ].cambVal(casillas[ i ][ j ].getText().charAt(0));
				}
				else
				{
					casillasaa[ i ][ j ].cambVal(Casilla.VACIO);
				}

				if(casillasaa[ i ][ j ].darValIngr()==casillasaa[ i ][ j ].darvalCorr())
				{
					casillas[ i ][ j ].setBackground( COL_CORRECTA );
				}
				else if(casillasaa[ i ][ j ].darValIngr()==Casilla.VACIO)
				{
					casillas[ i ][ j ].setBackground( COL_SIN_JUEGO );
				}
				else if(casillasaa[ i ][ j ].darValIngr()!=casillasaa[ i ][ j ].darvalCorr())
				{
					casillas[ i ][ j ].setBackground( COL_INCORRECTA );
				}
			}

		}
				
	}
	
	public void limpiar()
	{
		Casilla[][] casillass = principal.darCrucigrama();
		for( int i = 0; i < alto; i++ )
		{
			for( int j = 0; j < ancho; j++ )
			{
				
				if(casillass[i][j].darvalCorr() != Casilla.INICIAL)
					
				{
					casillas[ i ][ j ].setBackground( COL_SIN_JUEGO );
					casillas[ i ][ j ].setText("");
					casillas[i][j].setEditable(true);

				}
			}
		}
	}
	

	/**
	 * pinta la columna que tiene mas ocurrencias con la letra dada por el usuario
	 * @param pLetra letra que el usuario ingresa
	 * @throws Exception no exista tal columna
	 */
	public void contarOcurrenciasLetraColumna( char pLetra) throws Exception
	{
		int columna = principal.darCrucigramaMundo().contarOcurrenciasLetraColumna(pLetra);
		
		for (int i = 0; i < casillas.length; i++) 
		{
			casillas[i][columna].setBackground(Color.blue);
		}
	}
	
	/**
	 * pinta las filas que tienen dos palabras
	 */
	public void pintarFilasConDosPalabras ()
	{
		for (int i = 0; i < principal.darCrucigramaMundo().darfilascondospalabras().size(); i++) 
		{
			for (int j = 0; j <casillas[0].length; j++) 
			{
				casillas[principal.darCrucigramaMundo().darfilascondospalabras().get(i)][j].setBackground(Color.PINK);
			}
		}
	}
	
	
	
	
	
	
}
