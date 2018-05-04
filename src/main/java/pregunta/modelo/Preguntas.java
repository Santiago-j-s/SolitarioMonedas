package pregunta.modelo;

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
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Clase que almacena una serie de preguntas que se utilizaran a lo largo del
 * juego
 * 
 * @author Dibez, Santana
 *
 */
public class Preguntas implements Categorizable {
  List<Pregunta> historico_preguntas = new ArrayList<Pregunta>();
  String categoria;
    String recursos_path = Paths.get("src","main", "java", "recursos", "preguntas").toString();
//  String recursos_path = Paths.get("./preguntas")
//      .toStrling();

  /**
   * Obtiene las preguntas desde un archivo json
   */
  private void inicializarPreguntas() {
    String path = Paths.get(recursos_path, categoria.concat(".json")).toString();
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
  public Pregunta sortearPregunta() {
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
    String path = Paths.get(recursos_path, categoria.concat(".json")).toString();

    try (BufferedWriter bw = new BufferedWriter(
        new FileWriter(new File(path)))) {
      bw.write(jsonString);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void setCategoria(String categoria) {
    this.categoria = categoria;
    this.inicializarPreguntas();
  }
  
  @Override
  public String getCategoria() {
    return categoria;
  }
}
