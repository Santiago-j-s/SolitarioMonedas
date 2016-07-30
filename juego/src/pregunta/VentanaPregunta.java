package pregunta;

import javax.swing.JFrame;

class VentanaPregunta {
  
  private JFrame frame;
  
  VentanaPregunta(PanelPregunta panel) {
    frame = new JFrame("Pregunta");
    frame.setLocationByPlatform(true);
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    frame.add(panel);
    frame.pack();
    frame.setResizable(false);
    frame.setVisible(true);
    frame.setAlwaysOnTop(true);
  }
  
  void cerrar() {
    this.frame.dispose();
  }
}
