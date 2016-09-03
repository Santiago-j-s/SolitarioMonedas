package pregunta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FxModeloPregunta {
  private Pregunta modeloPregunta;
  private final StringProperty pregunta;
  private final StringProperty opcion1;
  private final StringProperty opcion2;
  private final StringProperty opcion3;

  public FxModeloPregunta() {
    this.pregunta = new SimpleStringProperty();
    this.opcion1 = new SimpleStringProperty();
    this.opcion2 = new SimpleStringProperty();
    this.opcion3 = new SimpleStringProperty();
  }

  public void setPregunta(Pregunta pregunta) {
    this.modeloPregunta = pregunta;
    this.setPregunta(pregunta.getPregunta());
    List<Opcion> list = new ArrayList<Opcion>(pregunta.getOpciones());
    Collections.shuffle(list);
    this.setOpcion1(list.get(0).toString());
    this.setOpcion2(list.get(1).toString());
    this.setOpcion3(list.get(2).toString());
  }

  public boolean correcta(String respuesta) {
    return this.modeloPregunta.correcta(respuesta);
  }

  public String getPregunta() {
    return pregunta.get();
  }

  public StringProperty getPropertyPregunta() {
    return pregunta;
  }

  public final void setPregunta(String pregunta) {
    this.pregunta.set(pregunta);
  }

  public final String getOpcion1() {
    return opcion1.get();
  }

  public StringProperty getPropertyOpcion1() {
    return opcion1;
  }

  public void setOpcion1(String opcion) {
    this.opcion1.set(opcion);
  }

  public String getOpcion2() {
    return opcion2.get();
  }

  public StringProperty getPropertyOpcion2() {
    return opcion2;
  }

  public void setOpcion2(String opcion) {
    this.opcion2.set(opcion);
  }

  public String getOpcion3() {
    return opcion3.get();
  }

  public StringProperty getPropertyOpcion3() {
    return opcion3;
  }

  public void setOpcion3(String opcion) {
    this.opcion3.set(opcion);
  }
}
