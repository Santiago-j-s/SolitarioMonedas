package vista;

import javax.swing.ImageIcon;

public class Recursos {
  private static final String MONEDA_PATH = "/moneda1.png";
  private static final String VACIA_PATH = "/vacia1.png";
  private static final String NULA_PATH = "/nula1.png";
  private static final String FONDO_PATH = "/fondo2.jpg";

  private ImageIcon imgMoneda, imgVacia, imgNula, imgFondo;
  
  public Recursos() {
    this.setImgMoneda(MONEDA_PATH);
    this.setImgVacia(VACIA_PATH);
    this.setImgNula(NULA_PATH);
    this.setImgFondo(FONDO_PATH);
  }
  
  private ImageIcon obtenerImagen(String imgPath) {
    return new ImageIcon(getClass().getResource(imgPath));
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
}
