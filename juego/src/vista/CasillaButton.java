package vista;

import java.awt.Color;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.JButton;

import juego.Casilla;

/**
 * Casilla del tablero de juego.
 * Contiene una imagen que representa el tipo de casilla en el modelo
 */
public class CasillaButton extends JButton {
  private static final long serialVersionUID = -2509999651403344434L;
 
  private Map<String, Icon> imgs;
  
  public CasillaButton(Casilla casilla, Map<String, Icon> imgs) {
    this.imgs = imgs;
    this.setTipoCasilla(casilla);
  }
  
  public void setTipoCasilla(Casilla casilla) {
    this.setContentAreaFilled(false);
    String tipo = casilla.getTipoCasilla().name();
    this.setIcon(imgs.get(tipo));
  }
  
  public void colorear(Color color) {
    this.setContentAreaFilled(true);
    this.setBackground(color);
  }
}
