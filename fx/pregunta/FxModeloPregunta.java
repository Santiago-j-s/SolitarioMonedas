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
    this.opcion1.set(list.get(0).toString());
    this.opcion2.set(list.get(1).toString());
    this.opcion3.set(list.get(2).toString());
  }

  public void bind(StringProperty otraPregunta, StringProperty otraOpcion1, StringProperty otraOpcion2,
      StringProperty otraOpcion3) {
    otraPregunta.bind(this.pregunta);
    otraOpcion1.bind(this.opcion1);
    otraOpcion2.bind(this.opcion2);
    otraOpcion3.bind(this.opcion3);
  }
  
  public boolean correcta(String respuesta) {
    return this.modeloPregunta.correcta(respuesta);
  }

  public final void setPregunta(String pregunta) {
    this.pregunta.set(pregunta);
  }
}
