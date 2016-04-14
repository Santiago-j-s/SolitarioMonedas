package vista;

import javax.swing.ImageIcon;

public class Recursos {
  private static final String RECURSOS_PATH = "/recursos";
  private static final String MONEDA_PATH = "/moneda.png";
  private static final String VACIA_PATH = "/casillaVacia.png";
  private static final String NULA_PATH = "/nula.png";
  private static final String FONDO_PATH = "/fondoTablero.png";
  private static final String MENU_FONDO = "/pantallaMenuInicialConLogo.png";
  private static final String ICONO = "/logoJuego.png";

  private ImageIcon imgMoneda, imgVacia, imgNula, imgFondo, imgMenu, imgIcono;
  
  public Recursos() {
    this.setImgMoneda(MONEDA_PATH);
    this.setImgVacia(VACIA_PATH);
    this.setImgNula(NULA_PATH);
    this.setImgFondo(FONDO_PATH);
    this.setImgMenu(MENU_FONDO);
    this.setImgIcono(ICONO);
  }

  private ImageIcon obtenerImagen(String imgPath) {
    String path = RECURSOS_PATH + imgPath;
    return new ImageIcon(getClass().getResource(path));
  }

  public ImageIcon getImgMoneda() {
    return imgMoneda;
  }

  public ImageIcon getImgVacia() {
    return imgVacia;
  }

  public ImageIcon getImgNula() {
    return imgNula;
  }

  public ImageIcon getImgFondo() {
    return imgFondo;
  }
  
  public ImageIcon getImgMenu() {
    return imgMenu;
  }
  
  public ImageIcon getImgIcono() {
    return imgIcono;
  }

  private void setImgVacia(String imgVacia) {
    this.imgVacia = obtenerImagen(imgVacia);
  }
  
  private void setImgNula(String imgNula) {
    this.imgNula = obtenerImagen(imgNula);
  }
  
  private void setImgMoneda(String imgMoneda) {
    this.imgMoneda = obtenerImagen(imgMoneda);
  }

  private void setImgFondo(String imgFondo) {
    this.imgFondo = obtenerImagen(imgFondo);
  }

  private void setImgMenu(String imgMenu) {
    this.imgMenu = obtenerImagen(imgMenu);
  }

  private void setImgIcono(String imgIcono) {
    this.imgIcono = obtenerImagen(imgIcono);
  }
}
