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

  public void bind(StringProperty pregunta, StringProperty opcion1, StringProperty opcion2,
      StringProperty opcion3) {
    pregunta.bind(this.pregunta);
    opcion1.bind(this.opcion1);
    opcion2.bind(this.opcion2);
    opcion3.bind(this.opcion3);
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

  private void setOpcion1(String opcion) {
    this.opcion1.set(opcion);
  }

  private void setOpcion2(String opcion) {
    this.opcion2.set(opcion);
  }

  private void setOpcion3(String opcion) {
    this.opcion3.set(opcion);
  }
}
