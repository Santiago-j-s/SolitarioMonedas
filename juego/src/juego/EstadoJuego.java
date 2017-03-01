package juego;

public class EstadoJuego {
  private int cantSaltos = 1;

  public int getCantSaltos() {
    return cantSaltos;
  }
  
  public void add1Salto() {
    cantSaltos += 1;
  }
}
