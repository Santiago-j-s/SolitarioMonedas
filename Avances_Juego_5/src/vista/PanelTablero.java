package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Clase encargada de crear y asignar elementos
 * al panel del tablero del juego
 * @author Dibez, Santana
 *
 */
public class PanelTablero extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	
	private int cantFilas, cantColumnas;
	private ImageIcon imgMoneda,imgVacia,imgNula,fondoTablero;
	
    private JButton[][] tablero; //matriz de botones que contiene las casillas
    
    /**
     * Constructor de la clase.
     * @param cantFilas - cantidad total de filas
     * @param cantColumnas - cantidad total de columnas
     */
    public PanelTablero(int cantFilas, int cantColumnas) {
    	this.cantFilas = cantFilas;
    	this.cantColumnas = cantColumnas;
    	
    	this.imgMoneda = new ImageIcon(getClass().getResource("/moneda1.png"));
    	this.imgVacia = new ImageIcon(getClass().getResource("/vacia1.png"));
    	this.imgNula = new ImageIcon(getClass().getResource("/nula1.png"));
    	    	
    	this.setLayout(new GridLayout(this.cantFilas, this.cantColumnas));
    	                
    	tablero = new JButton[this.cantFilas][this.cantColumnas];
    	this.setOpaque(false);
    	this.setPreferredSize(new Dimension(500, 500));
    }
	
    /**
     * Metodo que agrega una imagen de fondo al panel del tablero
     */
    public void paint(Graphics g)
    {
    	this.fondoTablero = new ImageIcon(getClass().getResource("/fondo2.jpg"));
    	g.drawImage(this.fondoTablero.getImage(), this.getX(), this.getY(), this.getWidth(), this.getHeight(), null);
    	this.paintComponents(g);
    }
    
    /**
     * Constructor usado para pruebas
     */
	public PanelTablero()
	{
		this(5, 5);
		
        //inicializamos botones y los a�adimos al tablero
        tablero[0][0] = new JButton("M");
        add(tablero[0][0]);
        tablero[0][1] = new JButton("V");
        add(tablero[0][1]);
        tablero[0][2] = new JButton("M");
        add(tablero[0][2]);
        tablero[0][3] = new JButton("M");
        add(tablero[0][3]);
        tablero[0][4] = new JButton("N");
        add(tablero[0][4]);
        tablero[1][0] = new JButton("M");
        add(tablero[1][0]);
        tablero[1][1] = new JButton("M");
        add(tablero[1][1]);
        tablero[1][2] = new JButton("M");
        add(tablero[1][2]);
        tablero[1][3] = new JButton("M");
        add(tablero[1][3]);
        tablero[1][4] = new JButton("N");
        add(tablero[1][4]);
        tablero[2][0] = new JButton("N");
        add(tablero[2][0]);
        tablero[2][1] = new JButton("M");
        add(tablero[2][1]);
        tablero[2][2] = new JButton("M");
        add(tablero[2][2]);
        tablero[2][3] = new JButton("M");
        add(tablero[2][3]);
        tablero[2][4] = new JButton("V");
        add(tablero[2][4]);
        tablero[3][0] = new JButton("N");
        add(tablero[3][0]);
        tablero[3][1] = new JButton("M");
        add(tablero[3][1]);
        tablero[3][2] = new JButton("M");
        add(tablero[3][2]);
        tablero[3][3] = new JButton("M");
        add(tablero[3][3]);
        tablero[3][4] = new JButton("N");
        add(tablero[3][4]);
        tablero[4][0] = new JButton("N");
        add(tablero[4][0]);
        tablero[4][1] = new JButton("M");
        add(tablero[4][1]);
        tablero[4][2] = new JButton("N");
        add(tablero[4][2]);
        tablero[4][3] = new JButton("N");
        add(tablero[4][3]);
        tablero[4][4] = new JButton("N");
        add(tablero[4][4]);
        tablero[2][3].
        //seteamos visibilidad
        setVisible(true);
	}
	
	/**
	 * 
	 * @return la cantidad total de filas del tablero
	 */
	public int getCantFilas() {
		return cantFilas;
	}

	/**
	 * 
	 * @return la cantidad total de columnas del tablero
	 */
	public int getCantColumnas() {
		return cantColumnas;
	}

	/**
	 * 
	 * @param fila
	 * @param columna
	 * @return el botón correspondiente 
	 * 	a la fila y columna pasados como parámetros
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public JButton getBoton(int fila, int columna) throws ArrayIndexOutOfBoundsException {
		if (fila < this.getCantFilas() && columna < this.getCantColumnas()) {
			return tablero[fila][columna];
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	/**
	 * Metodo que establece un boton de tipoCasilla en el tablero
	 * ubicado en la fila y columna pasados como parametros
	 * @param fila
	 * @param columna
	 * @param tipoCasilla
	 */
	public void setBoton(int fila, int columna, JButton tipoCasilla) {
		tablero[fila][columna] = tipoCasilla;
	}
	
	/**
	 * 
	 * @param casilla
	 * @return la fila correspondiente al botón pasado como parámetro.
	 */
	public int getFila(JButton casilla) {
		Point punto = casilla.getLocation();
		Dimension dimensiones = casilla.getSize();
		return (int) ((punto.getY() + dimensiones.height / 2) / (dimensiones.height));
	}
	
	/**
	 * 
	 * @param casilla
	 * @return la columna correspondiente al botón pasado como parámetro.
	 */
	public int getColumna(JButton casilla) {
		Point punto = casilla.getLocation();
		Dimension dimensiones = casilla.getSize();
		return (int) ((punto.getX() + dimensiones.width / 2) / (dimensiones.width));
	}
	
	/**
	 * Dota a las casillas del tablero de una imagen según cual sea su valor
	 */
	public void setearTablero() {
		for (int fila = 0; fila < this.getCantFilas(); fila++) {
			for (int columna = 0; columna < this.getCantColumnas(); columna++) {
				JButton boton = this.getBoton(fila, columna);
				boton.setContentAreaFilled(false);// vuelve transparente el fondo del boton
								
				switch(boton.getText()) {
				case "M": boton.setIcon(imgMoneda); break;
				case "V": boton.setIcon(imgVacia); break;
				case "N": boton.setIcon(imgNula); break;
				default: this.colorearBoton(fila, columna, Color.BLACK); break;
				}
				
				
			}
		}
	}
	
	/**
	 * Vuelve opaca a una casilla y setea su color de fondo
	 * 
	 * @param fila - la fila correspondiente a la casilla
	 * @param columna - la columna correspondiente a la casilla
	 * @param color - el color con que se pintará el fondo
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public void colorearBoton(int fila, int columna, Color color) throws ArrayIndexOutOfBoundsException {
		if (fila < this.getCantFilas() && columna < this.getCantColumnas()) {
			this.getBoton(fila, columna).setContentAreaFilled(true);
			this.getBoton(fila, columna).setBackground(color);
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
}
