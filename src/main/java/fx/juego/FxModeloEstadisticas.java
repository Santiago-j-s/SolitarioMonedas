package fx.juego;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import juego.Estado;

public class FxModeloEstadisticas {
  private final StringProperty mensaje;
  private final StringProperty saltos;
  private final StringProperty aciertos;
  private final StringProperty fallos;

  public FxModeloEstadisticas() {
    this.mensaje = new SimpleStringProperty();
    this.saltos = new SimpleStringProperty();
    this.aciertos = new SimpleStringProperty();
    this.fallos = new SimpleStringProperty();
  }
  
  public void setProperties(Estado estado, String mensaje) {
    this.mensaje.set(mensaje);
    this.saltos.set(String.format("Cantidad de Saltos: %d", estado.getCantSaltos()));
    this.aciertos.set(String.format("Cantidad de Aciertos: %d", estado.getAciertos()));
    this.fallos.set(String.format("Cantidad de Fallos: %d", estado.getFallos()));
  }
  
  public void bind(StringProperty otroMensaje,
      StringProperty otroSaltos,
      StringProperty otroAciertos,
      StringProperty otroFallos) {
    otroMensaje.bind(this.mensaje);
    otroSaltos.bind(this.saltos);
    otroAciertos.bind(this.aciertos);
    otroFallos.bind(this.fallos);
  }
}
