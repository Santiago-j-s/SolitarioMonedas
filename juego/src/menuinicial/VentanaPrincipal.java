package menuinicial;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javafx.application.Platform;
import vista.PanelTablero;
import vista.Recursos;

/**
 * La ventana principal del juego; es decir la que contiene el tablero y la
 * ayuda.
 * 
 * @author Dibez, Santana
 *
 */
public class VentanaPrincipal extends JFrame {

  private static final long serialVersionUID = 1L;

  private JMenuItem nuevoJuego;
  private JMenuItem salir;
  private JMenuItem autores;
  private JMenuItem ayuda;

  private ImageIcon icono;

  /**
   * Único constructor de la clase. Recibe como parámetro al panel con el
   * tablero de juego. Crea la ventana, introduce los elementos en un
   * BorderLayout y finalmente muestra la ventana
   */
  public VentanaPrincipal() {
    super("Solitario con Monedas");

    icono = Recursos.IMG_ICONO;
    setIconImage(icono.getImage());

    setMinimumSize(new Dimension(400, 400));

    setResizable(false);
    setLocationByPlatform(true);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setJMenuBar(crearMenu());
  }
  
  public void setNuevoJuegoListener(ActionListener listener) {
    nuevoJuego.addActionListener(listener);
  }
  
  public void setSalirListener(ActionListener listener) {
    salir.addActionListener(listener);
  }
  
  public void setAutoresListener(ActionListener listener) {
    autores.addActionListener(listener);
  }

  public void setAyudaListener(ActionListener listener) {
    ayuda.addActionListener(listener);
  }

  public void reset(AccionesAplicacion app) {
    nuevoJuego.setEnabled(false);

    setNuevoJuegoListener(event -> app.nuevoJuego());
    setSalirListener(event -> app.salir());
    setAutoresListener(event -> new FxPanelAutores());
    setAyudaListener(event -> new FxAyuda());

    revalidate();
    repaint();
    Platform.runLater(()
        -> EventQueue.invokeLater(()
            -> pack()));
  }

  public void setearPanelTablero(PanelTablero panel) {
    setContentPane(panel);
    nuevoJuego.setEnabled(true);
    pack();
  }
  
  private JMenu crearMenuJuego() {
    JMenu menuJuego = new JMenu("Juego");

    nuevoJuego = new JMenuItem("Nuevo juego");
    menuJuego.add(nuevoJuego);
    
    salir = new JMenuItem("Salir");
    menuJuego.add(salir);
    
    autores = new JMenuItem("Autores");
    ayuda = new JMenuItem("Ayuda");
    
    return menuJuego;
  }
  
  private JMenu crearMenuAyuda() {
    JMenu menuAyuda = new JMenu("Acerca de");
   
    menuAyuda.add(this.autores);
    menuAyuda.add(this.ayuda);
    
    return menuAyuda;
  }

  private JMenuBar crearMenu() {
    JMenuBar barraMenu;
    JMenu menuJuego = crearMenuJuego();
    JMenu menuAyuda = crearMenuAyuda();

    barraMenu = new JMenuBar();

    barraMenu.add(menuJuego);
    barraMenu.add(menuAyuda);

    return barraMenu;
  }
}
