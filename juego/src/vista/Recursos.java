package vista;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.ImageIcon;

public class Recursos {
  private static final String RECURSOS_PATH = "/recursos";
  private static final String MONEDA_PATH = "/moneda.png";
  private static final String VACIA_PATH = "/casillaVacia.png";
  private static final String NULA_PATH = "/nula.png";
  private static final String FONDO_PATH = "/fondoTablero.png";
  private static final String MENU_FONDO = "/pantallaMenuInicialConLogo.png";
  private static final String ICONO = "/logoJuego2.png";
  
  public static final Path PREGUNTAS_PATH = Paths.get("./preguntas");
  public static final ImageIcon IMG_MONEDA = obtenerImagen(MONEDA_PATH);
  public static final ImageIcon IMG_VACIA = obtenerImagen(VACIA_PATH);
  public static final ImageIcon IMG_NULA = obtenerImagen(NULA_PATH);
  public static final ImageIcon IMG_FONDO = obtenerImagen(FONDO_PATH);
  public static final ImageIcon IMG_MENU = obtenerImagen(MENU_FONDO);
  public static final ImageIcon IMG_ICONO = obtenerImagen(ICONO);

  private static ImageIcon obtenerImagen(String imgPath) {
    String path = RECURSOS_PATH + imgPath;
    return new ImageIcon(Recursos.class.getResource(path));
  }
}
