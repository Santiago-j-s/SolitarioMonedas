package pregunta;

import java.util.List;

public class ObservadoresPregunta {
  public List<Observador> observadores;

  public ObservadoresPregunta(List<Observador> observadores) {
    this.observadores = observadores;
  }

  public void addObservador(Observador o) {
    observadores.add(o);
  }

  public void removeObservador(Observador o) {
    observadores.remove(o);
  }

  public void removeAllObservadores() {
    observadores.clear();
  }

  public void notifyCorrecto() {
    observadores.forEach(Observador::correcto);
  }

  public void notifyIncorrecto() {
    observadores.forEach(Observador::incorrecto);
  }
}