package vista;

import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import juego.Direccion;

/**
 * Un JPanel que contiene unicamente un diálogo de ingreso de datos para la dirección. 
 * @author Dibez, Santana
 *
 */
public class PanelIngresoDireccion extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Direccion direccion;
	
	/**
	 * Devuelve una cadena con la dirección seleccionada por el usuario.
	 * 
	 * @return String direccion
	 */
	public Direccion getDireccion() {
		return direccion;
	}
	
	/**
	 * Devuelve una cadena con la dirección seleccionada por el usuario
	 * @param direccion
	 */
	private void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	/**
	 * Constructor único de la clase
	 * @param direcciones
	 */
	public PanelIngresoDireccion(Container contenedor, ArrayList<Direccion> direcciones) {
		
		Direccion valor = (Direccion) JOptionPane.showInputDialog(contenedor,
				"Seleccione la dirección en que desea saltar", 
				"Dirección", 
				JOptionPane.PLAIN_MESSAGE,
				null,
				direcciones.toArray(), 
				direcciones.get(0));
		
		this.setDireccion(valor);
	}
}
