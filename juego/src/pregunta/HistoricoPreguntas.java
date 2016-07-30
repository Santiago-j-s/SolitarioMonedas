package pregunta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Clase que almacena una serie de preguntas que se utilizaran a lo largo del
 * juego
 * 
 * @author Dibez, Santana
 *
 */
class HistoricoPreguntas {
  ArrayList<Pregunta> historico_preguntas = new ArrayList<Pregunta>();

  /**
   * Constructor defecto
   */
  HistoricoPreguntas() {
    this.inicializarPreguntas();
  }

  /*
   * Obtiene las preguntas desde un archivo json
   */
  private void inicializarPreguntas() {
    File f = new File("preguntas.json");
    try {
      BufferedReader br = new BufferedReader(new FileReader(f));
      Gson gson = new Gson();
      Type preguntasType = new TypeToken<ArrayList<Pregunta>>() {}.getType();
      this.historico_preguntas = gson.fromJson(br, preguntasType);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  /**
   * Selecciona de forma aleatoria una pregunta, elimina las preguntas ya
   * seleccionadas
   * 
   * @return la pregunta sorteada
   */
  Pregunta sortearPregunta() {
    if (historico_preguntas.isEmpty()) {
      this.inicializarPreguntas();
      Collections.shuffle(historico_preguntas);
    }
    return this.historico_preguntas.remove(0);
  }

  /*
   * Permite serializar un objeto java a un archivo json
   */
  @SuppressWarnings("unused")
  private void serialize() {
    String jsonString = new Gson().toJson(historico_preguntas);
    try (BufferedWriter bw = new BufferedWriter(
        new FileWriter(new File("preguntas.json")))) {
      bw.write(jsonString);
    } catch (IOException e) {
      System.out.println(e.toString());
    }
  }
}
