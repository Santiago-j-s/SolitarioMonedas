package menuinicial;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import javafx.scene.control.Cell;
import vista.Recursos;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Clase que crea un panel inicial en la cual se elige como desea jugar (con o
 * sin preguntas)
 * 
 * 
 * @author Dibez, Santana
 *
 */
public class PanelMenuInicio extends JPanel {
  private static final long serialVersionUID = 1L;
  private static final int HEIGHT = 500;
  private static final int WIDTH = 500;
  private static final Dimension SIZE = new Dimension(HEIGHT, WIDTH);
  
  JComboBox<String> preguntas;
  JButton botonJugarConPreguntas;
  JButton botonJugarSinPreguntas;

  private ImageIcon fondoMenu;

  /**
   * Constructor que se encarga de crear el panel que se verá en la ventana de
   * inicio del juego Agrega sus botones necesarios
   */
  public PanelMenuInicio(Recursos r, ActionListener jugarConPreguntas,
      ActionListener jugarSinPreguntas) {
    BoxLayout caja = new BoxLayout(this, BoxLayout.Y_AXIS);
    this.fondoMenu = r.getImgMenu();

    this.setLayout(caja);
    
    //TODO: Combobox con los archivos de pregunta
    //this.preguntas = new JComboBox<String>();
    //this.preguntas.setAlignmentX(CENTER_ALIGNMENT);

    this.botonJugarConPreguntas = new JButton("CON PREGUNTAS");
    this.botonJugarConPreguntas.setAlignmentX(CENTER_ALIGNMENT);

    this.botonJugarSinPreguntas = new JButton("SIN PREGUNTAS");
    this.botonJugarSinPreguntas.setAlignmentX(CENTER_ALIGNMENT);

    this.add(Box.createRigidArea(new Dimension(0, 204)));
    this.add(botonJugarConPreguntas);
    this.add(Box.createRigidArea(new Dimension(0, 2)));
    this.add(botonJugarSinPreguntas);

    this.setVisible(true);
    this.setPreferredSize(SIZE);

    this.botonJugarConPreguntas.addActionListener(jugarConPreguntas);
    this.botonJugarSinPreguntas.addActionListener(jugarSinPreguntas);
  }

  /**
   * Metodo que agrega una imagen de fondo al panel de la pantalla de inicio
   */
  public void paintComponent(Graphics g) {
    g.drawImage(this.fondoMenu.getImage(), 0, 0, this.getWidth(),
        this.getHeight(), null);
    this.setOpaque(false);
    super.paintComponents(g);
  }
}