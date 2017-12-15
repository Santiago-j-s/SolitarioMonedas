package juego;

import java.util.logging.Logger;

public class Estado {
  private final Logger logger = Logger.getLogger(getClass().getName());

  private int cantSaltos = 0;
  private int aciertos = 0;
  private int fallos = 0;

  public int getCantSaltos() {
    return cantSaltos;
  }

  public int getAciertos() {
    return aciertos;
  }

  public int getFallos() {
    return fallos;
  }

  public int cantidadPreguntas() {
    return fallos + aciertos;
  }

  public void add1Salto() {
    cantSaltos += 1;
    logger.info(String.format("Cantidad de Saltos: %d", cantSaltos));
  }

  public void add1Acierto() {
    aciertos += 1;
    logger.info(String.format("Cantidad de Aciertos: %d", aciertos));
  }

  public void add1Fallo() {
    fallos += 1;
    logger.info(String.format("Cantidad de Fallos: %d", fallos));
  }
}
