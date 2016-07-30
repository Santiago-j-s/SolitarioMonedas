package vista;

import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

/**
 * Clase destinada al panel de ayuda que 
 * aparecera en el juego con preguntas
 * @author Dibez, Santana
 *
 */
public class PanelAyudaPreguntas extends PanelAyuda 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//atributos
	private JLabel cuadroTexto;
	private ImageIcon fondoAyuda;
	
	/**
	 * Constructor del panel de ayuda con preguntas
	 */
	public PanelAyudaPreguntas()
	{
		String texto ="<html><body><font color="+"white><CENTER><b><u><font size=4>SOLITARIO CON MONEDAS</size></u></b><br>" 
				+ " <br>" 
				+ " El juego del solitario con monedas consta<br> de un tablero de 25 casillas<br>(5 filas por 5" 
				+ " columnas),<br>de las cuales inicialmente se dispone<br> de 14 monedas, 2 casillas libres y<br>" 
				+ " 9 casillas inutilizables.<br>" 
				+ " <br>" 
				+ " <b><u><font size=4>OBJETIVO</size></u></b><br>" 
				+ " <br>" 
				+ " El juego se da por ganado<br> si logra dejar una sola moneda<br> en la grilla. <br>Por el contrario<br>" 
				+ " el juego se da por perdido.<br>" 
				+ " <br>" 
				+ " <b><u><font size=4>REGLAS</size></u></b><br>" 
				+ " <br>" 
				+ " Inicialmente en el tablero se encuentran<br> las 25 casillas distribuidas de forma aleatoria,<br>" 
				+ " y el único movimiento posible<br> es seleccionar una moneda y saltar sobre otra<br> para comerla" 
				+ " al estilo del juego Damas<br> volviendo vacia la moneda comida.<br>" 
				+ " <br>" 
				+ " Al seleccionar una moneda, si solo puede<br>" 
				+ " realizar un movimiento, el mismo se hara<br>"
				+ " de forma autmomatica. Si la ficha tiene<br>"
				+ " mas de un destino posible, su fondo se<br>"
				+ " coloreara de violeta y saltará una<br>"
				+ " ventana con las opciones:<br>arriba, abajo, izquierda, derecha;<br>"
				+ " a fin de elegir en que direccion saltar.<br>Las posibles nuevas casillas<br>"
				+ " colorean su fondo de verde."  
				+ " <br>" 
				+ " <br>" 
				+ " <br>" 
				+ " <br>" 
				+ " Cada tres saltos,<br> aparecerá una pregunta<br> de respuestas" 
				+ " rápidas;<br> si contesta correctamente<br> puede hacer el movimiento,<br> sino saltará otra pregunta<br>" 
				+ " y así sucesivamente<br> hasta que responda correctamente.<br>" 
				+ " <br>" 
				+ " <b><u><font size=4>FIN DEL JUEGO</size></u></b><br>" 
				+ " <br>" 
				+ " El juego finaliza cuando:<br>" 
				+ " <br>" 
				+ " *Solo queda una moneda en el tablero,<br> por lo gana el juego.<br><br>" 
				+ " *No quedan movimientos posibles,<br> por lo que pierde el juego.<br><br>" 
				+ " *Abandona el juego,<br> que se considera como perdido.<br><br>" 
				+ " <br>" 
				+ "<CENTER></font></body></html>";
  
	
		this.cuadroTexto = new JLabel(texto);
		this.add(cuadroTexto);
		this.setOpaque(false);

	}
	
    /**
     * Metodo que agrega una imagen de fondo al panel de ayuda
     */
    public void paint(Graphics g)
    {
    	this.fondoAyuda = new ImageIcon(getClass().getResource("/fondo5.jpg"));
    	g.drawImage(this.fondoAyuda.getImage(), this.getX(), this.getY(),300,2000, null);
    	this.paintComponents(g);
    }
	
}