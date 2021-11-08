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

		try {
			// Condicionales que determinan la funcionalidad de los botones
			// Botón sumar
			if (e.getSource() == vc.getBoton1()) {
				Double suma = Double.parseDouble(vc.getCajaTexto1().getText())
						+ Double.parseDouble(vc.getCajaTexto2().getText());
				vc.getEtiqueta3().setText("Resultado: " + String.valueOf(suma));
				reset();
			}

			// Botón restar
			// La funcionalidad se implementa de la forma: Número 1 - Número 2
			if (e.getSource() == vc.getBoton2()) {
				double resta = Double.parseDouble(vc.getCajaTexto1().getText())
						- Double.parseDouble(vc.getCajaTexto2().getText());
				vc.getEtiqueta3().setText("Resultado: " + String.valueOf(resta));
				reset();
			}

			// Botón multiplicar
			if (e.getSource() == vc.getBoton3()) {
				double multiplicacion = Double.parseDouble(vc.getCajaTexto1().getText())
						* Double.parseDouble(vc.getCajaTexto2().getText());
				vc.getEtiqueta3().setText("Resultado: " + String.valueOf(multiplicacion));
				reset();
			}

			// Botón dividir
			// La funcionalidad se implementa de la forma: Número 1 / Número 2
			if (e.getSource() == vc.getBoton4()) {
				double division = Double.parseDouble(vc.getCajaTexto1().getText())
						/ Double.parseDouble(vc.getCajaTexto2().getText());
				vc.getEtiqueta3().setText("Resultado: " + String.valueOf(division));
				reset();
			}

			// Botón raíz cuadrada
			// Genera una nueva ventana que muesta un mensaje
			if (e.getSource() == vc.getBoton5()) {
				JOptionPane.showMessageDialog(null, "Funcionalidad no disponible", "Raíz Cuadrada",
						JOptionPane.INFORMATION_MESSAGE);
				reset();
			}

			// Botón raíz cúbica
			// La funcionalidad se implementa de la forma: raíz cúbica Número 1
			if (e.getSource() == vc.getBoton6()) {
				double raiz3 = Math.cbrt(Double.parseDouble(vc.getCajaTexto1().getText()));
				vc.getEtiqueta3().setText("Resultado: " + String.valueOf(raiz3));
				reset();
			}
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Números no válidos, revisa los datos introducidos", "Datos erróneos", JOptionPane.ERROR_MESSAGE);
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
		// Vaciamos etiqueta3 ---- Pendiente de estudio
		//vc.getEtiqueta3().setText("Resultado:");
	}
}