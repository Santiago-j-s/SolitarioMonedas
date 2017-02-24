package menuinicial;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.logging.Logger;

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

  private final Logger logger = Logger.getLogger(getClass().getName());

  private JMenuItem nuevoJuego;
  private JMenuItem salir;
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
    this.setIconImage(icono.getImage());

    this.setMinimumSize(new Dimension(400, 400));

    this.setLocationByPlatform(true);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setJMenuBar(crearMenu());
  }

  public void reset(AccionesAplicacion app) {
    logger.info("reset");

    nuevoJuego.setEnabled(false);
    ayuda.setEnabled(false);

    nuevoJuego.addActionListener(event -> {
      app.nuevoJuego();
    });
    salir.addActionListener(event -> {
      app.salir();
    });

    this.revalidate();
    this.repaint();
    Platform.runLater(() -> {
      EventQueue.invokeLater(() -> {
        this.pack();
      });
    });
  }

  public void setearPanelTablero(PanelTablero panel) {
    this.setContentPane(panel);
    this.nuevoJuego.setEnabled(true);
    this.pack();
  }

  private JMenuBar crearMenu() {
    JMenuBar barraMenu;
    JMenu menuJuego;
    JMenu menuAyuda;

    this.nuevoJuego = new JMenuItem("Nuevo juego");
    this.ayuda = new JMenuItem("Ver ayuda");
    this.salir = new JMenuItem("Salir");

    menuJuego = new JMenu("Juego");
    menuJuego.add(this.nuevoJuego);
    menuJuego.add(this.salir);

    menuAyuda = new JMenu("Acerca de");
    menuAyuda.add(this.ayuda);

    barraMenu = new JMenuBar();

    barraMenu.add(menuJuego);
    barraMenu.add(menuAyuda);

    return barraMenu;
  }
}
