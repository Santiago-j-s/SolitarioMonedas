package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import juego.Casilla;
import juego.Juego;
import juego.Tablero;
import vista.PanelAyuda;
import vista.PanelAyudaPreguntas;
import vista.PanelAyudaSinPreguntas;
import vista.PanelTablero;
import vista.Recursos;
import vista.VentanaPrincipal;
import vista.PanelPantallaPrincipal;


/**
 * Clase que relaciona los diferentes elementos de la GUI con la lógica del juego 
 * que se encuentra en la clase 'Tablero' del paquete 'modelo'
 * 
 * @author Dibez, Santana
 *
 */
public class ManejadorJuego{
	
	private Juego juego;
	private PanelTablero panelTablero;
	private JFrame ventanaPrincipal;
	private PanelPantallaPrincipal panelPantallaPrincipal;
	private Recursos recursos;
	
	/**
	 * Constructor único de la clase. 
	 * Crea y muestra la ventana principal con el tablero de juego.
	 */
	public ManejadorJuego(boolean conPreguntas, VentanaPrincipal mainWindow, Recursos r) {
	  
	  this.setRecursos(r);
		
		PanelAyuda panelAyuda;
		
		if (conPreguntas) {
			this.inicializarPanelTablero(new BotonListenerPregunta(this));
			panelAyuda = new PanelAyudaPreguntas();
		} else {
			this.inicializarPanelTablero(new BotonListenerSinPregunta(this));
			panelAyuda = new PanelAyudaSinPreguntas();
		}
        
		this.setPanelPantallaPrincipal(
				new PanelPantallaPrincipal(this.panelTablero, panelAyuda));
		
		this.setVentanaPrincipal(mainWindow);
	}
	
	protected PanelPantallaPrincipal getPanelPantallaPrincipal() {
		return panelPantallaPrincipal;
	}

	protected void setPanelPantallaPrincipal(PanelPantallaPrincipal panelPantallaPrincipal) {
		this.panelPantallaPrincipal = panelPantallaPrincipal;
	}

	/**
	 * @return the tablero
	 */
	protected Juego getJuego() {
		return juego;
	}

	/**
	 * @param juego the tablero to set
	 */
	protected void setJuego(Juego juego) {
		this.juego = juego;
	}

	/**
	 * @return the panelTablero
	 */
	protected PanelTablero getPanelTablero() {
		return panelTablero;
	}

	/**
	 * @param panelTablero the panelTablero to set
	 */
	protected void setPanelTablero(PanelTablero panelTablero) {
		this.panelTablero = panelTablero;
	}

	/**
	 * @return the ventanaPrincipal
	 */
	protected JFrame getVentanaPrincipal() {
		return ventanaPrincipal;
	}

	private Recursos getRecursos() {
    return recursos;
  }

  private void setRecursos(Recursos recursos) {
    this.recursos = recursos;
  }

  /**
	 * @param ventanaPrincipal the ventanaPrincipal to set
	 */
	private void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}
	
	/**
	 * Le da al botón señalado por 'fila' y 'columna' el valor correspondiente 
	 * 		a la misma casilla del tablero correspondiente al modelo 
	 * 		y le añade el escuchador pasado como parámetro
	 *
	 * @param fila
	 * @param columna
	 * @param escuchador
	 */
	private void inicializarBoton(int fila, int columna, BotonListenerPadre escuchador) {
		PanelTablero panelTablero = this.getPanelTablero();
		
		panelTablero.add(panelTablero.getBoton(fila, columna));
		panelTablero.getBoton(fila, columna).addActionListener(escuchador);
	}
	
	/**
	 * Prepara el panel con la interfaz gráfica del tablero según el modelo
	 */
	private void inicializarPanelTablero(BotonListenerPadre escuchadorBoton) {
		this.setJuego(new Juego());	
		
		Tablero tablero = this.getJuego().getTablero();
		int filas = tablero.getCantFilas();
		int cols = tablero.getCantColumnas();
		
		PanelTablero panelTablero = new PanelTablero(tablero, this.getRecursos());
		
		this.setPanelTablero(panelTablero);
		
		for (int fila = 0; fila < filas; fila++) {
			for (int columna = 0; columna < cols; columna++) {
				inicializarBoton(fila, columna, escuchadorBoton);
			}
		}
		
		this.getPanelTablero().setVisible(true);
	}
}
