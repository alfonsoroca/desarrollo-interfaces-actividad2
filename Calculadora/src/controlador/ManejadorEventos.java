package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vista.VentanaCalculadora;

// Clase que controla la funcionalidad de los botones e implementa la interfaz ActionListener
public class ManejadorEventos implements ActionListener {

	VentanaCalculadora vc;

	// Constructor de ManejadorEventos con un parámetro de clase VentanaCalculadora
	public ManejadorEventos(VentanaCalculadora vc) {
		this.vc = vc;
	}

	// Sobrescritura del método actionPerformed
	@Override
	public void actionPerformed(ActionEvent e) {
		// Con un try-catch(Exception) controlamos las posibles excepciones de los
		// métodos
		try {
			// Condicionales que determinan la funcionalidad de los botones
			// Botón sumar
			if (e.getSource() == vc.getBoton1()) {
				Double suma = Double.parseDouble(vc.getCajaTexto1().getText())
						+ Double.parseDouble(vc.getCajaTexto2().getText());
				vc.getEtiqueta3().setText("Resultado: " + String.valueOf(suma));				
			}

			// Botón restar
			// La funcionalidad se implementa de la forma: Número 1 - Número 2
			if (e.getSource() == vc.getBoton2()) {
				double resta = Double.parseDouble(vc.getCajaTexto1().getText())
						- Double.parseDouble(vc.getCajaTexto2().getText());
				vc.getEtiqueta3().setText("Resultado: " + String.valueOf(resta));				
			}

			// Botón multiplicar
			if (e.getSource() == vc.getBoton3()) {
				double multiplicacion = Double.parseDouble(vc.getCajaTexto1().getText())
						* Double.parseDouble(vc.getCajaTexto2().getText());
				vc.getEtiqueta3().setText("Resultado: " + String.valueOf(multiplicacion));				
			}

			// Botón dividir
			// La funcionalidad se implementa de la forma: Número 1 / Número 2
			if (e.getSource() == vc.getBoton4()) {
				double division = Double.parseDouble(vc.getCajaTexto1().getText())
						/ Double.parseDouble(vc.getCajaTexto2().getText());
				vc.getEtiqueta3().setText("Resultado: " + String.valueOf(division));				
			}

			// Botón raíz cuadrada
			// Genera una nueva ventana que muestra un mensaje
			if (e.getSource() == vc.getBoton5()) {
				JOptionPane.showMessageDialog(null, "Funcionalidad no disponible", "Raíz Cuadrada",
						JOptionPane.INFORMATION_MESSAGE);				
			}

			// Botón raíz cúbica
			// La funcionalidad se implementa de la forma: raíz cúbica Número 1 y requiere
			// de una contraseña para su cálculo que es solicitada en una nueva ventana.
			// Si la contraseña es errónea se indica por ventana y se reinicia la calculadora.
			if (e.getSource() == vc.getBoton6()) {				
				String password = "1234";
				double raiz3 = Math.cbrt(Double.parseDouble(vc.getCajaTexto1().getText()));
				String validacion = JOptionPane.showInputDialog("Contraseña:");
				
				// Con el condicional controlamos la contraseña almacenada en password
				if(validacion.equals(password)) {					
					vc.getEtiqueta3().setText("Resultado: " + String.valueOf(raiz3));						
				} else {
					JOptionPane.showMessageDialog(null, "Contraseña erronea", "Contraseña erronea", JOptionPane.WARNING_MESSAGE);
					reset();
				}
			}
			
			// Botón reset
			// Devuelve la calculadora a su situación inicial.
			if(e.getSource() == vc.getBoton7() ) {
				reset();
			}
			
		} catch (Exception e1) {
			// e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Números no válidos, revisa los datos introducidos", "Datos erróneos",
					JOptionPane.ERROR_MESSAGE);
			vc.getCajaTexto1().requestFocus();
		}
	}

	// Método que resetea la calculadora a las condiciones del requerimiento
	private void reset() {

		// Vaciamos cajaTexto1
		vc.getCajaTexto1().setText(null);
		// Vaciamos cajaTexto2
		vc.getCajaTexto2().setText(null);
		// Ponemos el foco en cajaTexto1
		vc.getCajaTexto1().requestFocus();
		// Vaciamos etiqueta3
		vc.getEtiqueta3().setText("Resultado:");
	}
}