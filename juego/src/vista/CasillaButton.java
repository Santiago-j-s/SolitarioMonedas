package vista;

import java.awt.Color;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.JButton;

import juego.TipoCasilla;

/**
 * Casilla del tablero de juego.
 * Contiene una imagen que representa el tipo de casilla en el modelo
 * @author santiago
 *
 */
public class CasillaButton extends JButton {
  private static final long serialVersionUID = -2509999651403344434L;
 
  private Map<String, Icon> imgs;
  
  public CasillaButton(TipoCasilla casilla, Map<String, Icon> imgs) {
    this.imgs = imgs;
    this.setTipoCasilla(casilla);
  }
  
  /**
   * Actualiza la imágen de la casilla
   * @param tipoCasilla la casilla del modelo
   */
  public void setTipoCasilla(TipoCasilla tipoCasilla) {
    this.setContentAreaFilled(false);
    String tipo = tipoCasilla.name();
    this.setIcon(imgs.get(tipo));
  }
  
  /**
   * Da color de fondo a una casilla
   * @param color el color que tendrá la casilla
   */
  public void colorear(Color color) {
    this.setContentAreaFilled(true);
    this.setBackground(color);
  }
}
