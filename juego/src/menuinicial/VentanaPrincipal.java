package menuinicial;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import vista.PanelPantallaPrincipal;
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
  private JMenuItem ayuda;

  private AccionesAplicacion app;

  private ImageIcon icono;

  private Recursos recursos;

  /**
   * Único constructor de la clase. Recibe como parámetro al panel con el
   * tablero de juego. Crea la ventana, introduce los elementos en un
   * BorderLayout y finalmente muestra la ventana
   */
  public VentanaPrincipal(Recursos r) {
    super("Solitario con Monedas");

    this.setRecursos(r);

    icono = r.getImgIcono();
    this.setIconImage(icono.getImage());

    this.setMinimumSize(new Dimension(400, 400));

    this.setResizable(true);
    this.pack();
    this.setLocationByPlatform(true);

    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setJMenuBar(crearMenu());
  }

  public void reset(AccionesAplicacion app) {
    nuevoJuego.setEnabled(false);
    this.getContentPane().removeAll();
    this.app = app;
    nuevoJuego.addActionListener(new NuevoJuegoListener());
    salir.addActionListener(new SalirListener());
  }

  public void construirMenuInicial() {
    JFXPanel panel = new FxPanelInicio().start();
    this.setContentPane(panel);
    Platform.runLater(() -> {
      SwingUtilities.invokeLater(() -> {
        this.validate();
        this.repaint();
        this.pack();
      });
    });
  }
  
  public void construirJuego(PanelPantallaPrincipal panel) {
    this.setContentPane(panel);
    this.nuevoJuego.setEnabled(true);
    this.pack();
    panel.revalidate();
    panel.repaint();
  }

  private class NuevoJuegoListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      app.nuevoJuego();
    }
  }

  private class SalirListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      app.salir();
    }
  }

  private JMenuBar crearMenu() {
    JMenuBar barraMenu;
    JMenu menuJuego, menuAyuda;

    this.setNuevoJuego(new JMenuItem("Nuevo juego"));
    this.setSalir(new JMenuItem("Salir"));
    this.setAyuda(new JMenuItem("Ver ayuda"));

    menuJuego = new JMenu("Juego");
    menuJuego.add(this.getNuevoJuego());
    menuJuego.add(this.getSalir());

    menuAyuda = new JMenu("Acerca de");
    menuAyuda.add(this.getAyuda());

    barraMenu = new JMenuBar();

    barraMenu.add(menuJuego);
    barraMenu.add(menuAyuda);

    return barraMenu;
  }

  private JMenuItem getAyuda() {
    return this.ayuda;
  }

  private void setAyuda(JMenuItem item) {
    item.setEnabled(false);
    this.ayuda = item;
  }

  private JMenuItem getSalir() {
    return this.salir;
  }

  private void setSalir(JMenuItem item) {
    this.salir = item;
  }

  private JMenuItem getNuevoJuego() {
    return this.nuevoJuego;
  }

  private void setNuevoJuego(JMenuItem item) {
    item.setEnabled(false);
    this.nuevoJuego = item;
  }

  public Recursos getRecursos() {
    return recursos;
  }

  private void setRecursos(Recursos recursos) {
    this.recursos = recursos;
  }
}
