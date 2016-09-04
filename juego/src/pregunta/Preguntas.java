package pregunta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Paths;
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
class Preguntas {
  ArrayList<Pregunta> historico_preguntas = new ArrayList<Pregunta>();
  String archivo_preguntas;
  String recursos_path = Paths.get("juego", "src", "recursos", "preguntas")
      .toString();

  /**
   * Inicializa las preguntas
   */
  Preguntas(String filename) {
    this.archivo_preguntas = filename.concat(".json");
    this.inicializarPreguntas();
  }

  /**
   * Obtiene las preguntas desde un archivo json
   */
  private void inicializarPreguntas() {
    String path = Paths.get(recursos_path, archivo_preguntas).toString();
    File f = new File(path);
    try {
      BufferedReader br = new BufferedReader(new FileReader(f));
      Gson gson = new Gson();
      Type preguntasType = new TypeToken<ArrayList<Pregunta>>() {
      }.getType();
      this.historico_preguntas = gson.fromJson(br, preguntasType);
      Collections.shuffle(historico_preguntas);
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
    }
    return this.historico_preguntas.remove(0);
  }

  /**
   * Serializa el historico_preguntas (un ArrayList<Pregunta>) a un archivo json
   */
  @SuppressWarnings("unused")
  private void serialize(String filename) {
    String jsonString = new Gson().toJson(historico_preguntas);
    String path = Paths.get(recursos_path, archivo_preguntas).toString();

    try (BufferedWriter bw = new BufferedWriter(
        new FileWriter(new File(path)))) {
      bw.write(jsonString);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
