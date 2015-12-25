package controlador;

import javax.swing.JButton;

import juego.Juego;
import vista.PanelAyuda;
import vista.PanelAyudaPreguntas;
import vista.PanelAyudaSinPreguntas;
import vista.PanelTablero;
import vista.VentanaPrincipal;


/**
 * Clase que relaciona los diferentes elementos de la GUI con la lógica del juego 
 * que se encuentra en la clase 'Tablero' del paquete 'modelo'
 * 
 * @author Dibez, Santana
 *
 */
public class ManejadorJuego {
	
	private Juego juego;
	private PanelTablero panelTablero;
	private VentanaPrincipal ventanaPrincipal;
	
	/**
	 * Constructor único de la clase. 
	 * Crea y muestra la ventana principal con el tablero de juego.
	 */
	public ManejadorJuego(boolean conPreguntas) {
		
		PanelAyuda panelAyuda;
		
		if (conPreguntas) {
			this.inicializarPanelTablero(new BotonListenerPregunta(this));
			panelAyuda = new PanelAyudaPreguntas();
		} else {
			this.inicializarPanelTablero(new BotonListenerSinPregunta(this));
			panelAyuda = new PanelAyudaSinPreguntas();
		}
        
		this.setVentanaPrincipal(new VentanaPrincipal(this.panelTablero, 
        		panelAyuda)
		);
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
	protected VentanaPrincipal getVentanaPrincipal() {
		return ventanaPrincipal;
	}

	/**
	 * @param ventanaPrincipal the ventanaPrincipal to set
	 */
	protected void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
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
		String casilla = juego.getCasilla(fila, columna).toString();
		
		PanelTablero panelDeJuego = this.getPanelTablero();
		
		panelDeJuego.setBoton(fila, columna, new JButton(casilla));
		panelDeJuego.add(panelTablero.getBoton(fila, columna));
		panelDeJuego.getBoton(fila, columna).addActionListener(escuchador);
	}
	
	/**
	 * Prepara el panel con la interfaz gráfica del tablero según el modelo
	 */
	private void inicializarPanelTablero(BotonListenerPadre escuchadorBoton) {
		this.setJuego(new Juego());
		
		int cantFilas = this.getJuego().getCantFilas();
		int cantColumnas = this.getJuego().getCantColumnas();
		
		PanelTablero panelDeJuego = new PanelTablero(cantFilas, cantColumnas);
		
		this.setPanelTablero(panelDeJuego);
		
		for (int fila = 0; fila < cantFilas; fila++) {
			for (int columna = 0; columna < cantColumnas; columna++) {
				inicializarBoton(fila, columna, escuchadorBoton);
			}
		}
		
		this.getPanelTablero().setearTablero();
		this.getPanelTablero().setVisible(true);
	}
	
	/**
	 * Inicia el juego
	 */
	public static void main(String[] args) {
		new ManejadorJuego(true);
	}

}
