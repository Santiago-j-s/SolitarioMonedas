package vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import juego.Casilla;

public class CasillaButton extends JButton {
  private static final long serialVersionUID = -2509999651403344434L;
 
  private Casilla tipoCasilla;
  private Recursos recursos;
  
  public CasillaButton(Recursos r, Casilla casilla) {
    this.recursos = r;
    this.setTipoCasilla(casilla);
  }

  public Casilla getTipoCasilla() {
    return tipoCasilla;
  }

  public void setTipoCasilla(Casilla tipoCasilla) {
    this.setContentAreaFilled(false);
    this.tipoCasilla = tipoCasilla;
    switch(tipoCasilla) {
    case Moneda:
      this.setIcon(recursos.getImgMoneda());
      break;
    case Vacia:
      this.setIcon(recursos.getImgVacia());
      break;
    case Nula:
      this.setIcon(recursos.getImgNula());
      break;
    }
  }
}
