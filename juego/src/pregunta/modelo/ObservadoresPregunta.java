package pregunta.modelo;

import java.util.ArrayList;
import java.util.List;

public class ObservadoresPregunta {
  public List<Observador> observadores = new ArrayList<Observador>();

  public void addObservador(Observador o) {
    observadores.add(o);
  }

  public void removeObservador(Observador o) {
    observadores.remove(o);
  }

  public void removeAllObservadores() {
    observadores.clear();
  }
  
  public void setObservador(Observador o) {
    this.removeAllObservadores();
    this.addObservador(o);
  }

  public void notifyCorrecto() {
    observadores.forEach(Observador::correcto);
  }

  public void notifyIncorrecto() {
    observadores.forEach(Observador::incorrecto);
  }
}