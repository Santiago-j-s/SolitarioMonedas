package vista;

import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import juego.Direccion;

/**
 * Un JPanel que contiene unicamente un diálogo de ingreso de datos para la dirección. 
 * @author Dibez, Santana
 *
 */
public class PreguntaDireccion extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private Direccion direccion;
	
	public Direccion getDireccion() {
		return direccion;
	}
	
	public PreguntaDireccion(List<Direccion> direcciones) {
		Direccion valor = (Direccion) JOptionPane.showInputDialog(this,
				"Seleccione la dirección en que desea saltar", 
				"Dirección", 
				JOptionPane.PLAIN_MESSAGE,
				null,
				direcciones.toArray(), 
				direcciones.get(0));
		
		direccion = valor;
	}
}
