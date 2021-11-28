package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

import vista.VentanaCalculadora;

// Clase que controla la funcionalidad de los botones e implementa la interfaz ActionListener
public class ManejadorEventos implements ActionListener {

	
	
	private VentanaCalculadora vc;

	// Constructor de ManejadorEventos con un parámetro de clase VentanaCalculadora
	public ManejadorEventos(VentanaCalculadora vc) {
		this.vc = vc;
	}

	// Sobrescritura del método actionPerformed
	@Override
	public void actionPerformed(ActionEvent e) {

		// Variable que almacena el resultado de la operación solicitada
		double resultado = 0;

		// Condicionales que determinan la funcionalidad de los botones

		// Con un try-catch(Exception) controlamos las posibles excepciones de los
		// métodos
		try {
			// Botón sumar
			if (e.getSource() == vc.getBoton1()) {
				resetBotones();
				// Cambiamos el estilo del boton
				vc.getBoton1().setBackground(Color.decode("#ffb300"));
				vc.getBoton1().setFont(new Font("Roboto", 3, 12));// Con 3 establecemos negrita + cursiva
				vc.getBoton1().setForeground(Color.black);
				vc.getBoton1().setText("Sumado");
				vc.getBoton1().setBounds(55, 175, 110, 60);

				resultado = Double.parseDouble(vc.getCajaTexto1().getText())
						+ Double.parseDouble(vc.getCajaTexto2().getText());
				imprimirResultado(resultado);
			}

			// Botón restar
			// La funcionalidad se implementa de la forma: Número 1 - Número 2
			if (e.getSource() == vc.getBoton2()) {
				resetBotones();
				// Cambiamos el estilo del boton
				vc.getBoton2().setBackground(Color.decode("#ffb300"));
				vc.getBoton2().setFont(new Font("Roboto", 3, 12));// Con 3 establecemos negrita + cursiva
				vc.getBoton2().setForeground(Color.black);
				vc.getBoton2().setText("Restado");
				vc.getBoton2().setBounds(175, 175, 110, 60);

				resultado = Double.parseDouble(vc.getCajaTexto1().getText())
						- Double.parseDouble(vc.getCajaTexto2().getText());
				imprimirResultado(resultado);
			}

			// Botón multiplicar
			if (e.getSource() == vc.getBoton3()) {
				resetBotones();
				// Cambiamos el estilo del boton
				vc.getBoton3().setBackground(Color.decode("#ffb300"));
				vc.getBoton3().setFont(new Font("Roboto", 3, 12));// Con 3 establecemos negrita + cursiva
				vc.getBoton3().setForeground(Color.black);
				vc.getBoton3().setText("Multiplicado");
				vc.getBoton3().setBounds(55, 245, 110, 60);

				resultado = Double.parseDouble(vc.getCajaTexto1().getText())
						* Double.parseDouble(vc.getCajaTexto2().getText());
				imprimirResultado(resultado);
			}

			// Botón dividir
			// La funcionalidad se implementa de la forma: Número 1 / Número 2
			if (e.getSource() == vc.getBoton4()) {
				resetBotones();
				// Cambiamos el estilo del boton
				vc.getBoton4().setBackground(Color.decode("#ffb300"));
				vc.getBoton4().setFont(new Font("Roboto", 3, 12));// Con 3 establecemos negrita + cursiva
				vc.getBoton4().setForeground(Color.black);
				vc.getBoton4().setText("Dividido");
				vc.getBoton4().setBounds(175, 245, 110, 60);

				resultado = Double.parseDouble(vc.getCajaTexto1().getText())
						/ Double.parseDouble(vc.getCajaTexto2().getText());
				imprimirResultado(resultado);
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
			// Si la contraseña es errónea se indica por ventana y se reinicia la
			// calculadora.
			if (e.getSource() == vc.getBoton6()) {
				// Ocultamos etiqueta2 y cajaTexto2 y establecemos el valor de cajaTexto2 en ""
				vc.getEtiqueta2().setVisible(false);
				vc.getCajaTexto2().setVisible(false);
				vc.getCajaTexto2().setText(null);
				String password = "1234";
				resultado = Math.cbrt(Double.parseDouble(vc.getCajaTexto1().getText()));
				String validacion = JOptionPane.showInputDialog("Contraseña:");

				// Con el condicional controlamos la contraseña almacenada en password
				if (validacion.equals(password)) {
					resetBotones();
					// Cambiamos el estilo del boton
					vc.getBoton6().setBackground(Color.decode("#ffb300"));
					vc.getBoton6().setFont(new Font("Roboto", 3, 12));// Con 3 establecemos negrita + cursiva
					vc.getBoton6().setForeground(Color.black);
					vc.getBoton6().setText("Raíz cúbica");
					vc.getBoton6().setBounds(175, 315, 110, 60);

					imprimirResultado(resultado);
				} else {
					JOptionPane.showMessageDialog(null, "Contraseña erronea", "Contraseña erronea",
							JOptionPane.WARNING_MESSAGE);
					resultado = 0;
					reset();
				}
			}

			// Botón reset
			// Devuelve la calculadora a su situación inicial.
			if (e.getSource() == vc.getBoton7()) {
				resultado = 0;
				reset();
			}

		} catch (Exception e1) {
			// e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Números no válidos, revisa los datos introducidos", "Datos erróneos",
					JOptionPane.ERROR_MESSAGE);
			resultado = 0;
			reset();
			vc.getCajaTexto1().requestFocus();
		}
	}

	// Método que muestra el resultado de la operación realizada
	private void imprimirResultado(double r) {
		// Transformamos y mostramos el resultado en formato local
		vc.getEtiqueta3().setVisible(true);
		NumberFormat nf = NumberFormat.getInstance();		
		vc.getEtiqueta3().setText("Resultado: " + String.valueOf(nf.format(r)));
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
		// Reseteamos botones
		resetBotones();
	}

	// Método que resetea los botones a su estado original
	private void resetBotones() {
		// Reseteamos el boton1
		vc.getBoton1().setText("Sumar");
		vc.getBoton1().setBounds(60, 180, 100, 50);
		vc.getBoton1().setBackground(Color.decode("#2196f3"));
		vc.getBoton1().setFont(new Font("Roboto", 1, 12));
		vc.getBoton1().setForeground(Color.decode("#ffffff"));
		vc.getBoton1().setBorder(BorderFactory.createBevelBorder(0));
		// Reseteamos el boton2
		vc.getBoton2().setText("Restar");
		vc.getBoton2().setBounds(180, 180, 100, 50);
		vc.getBoton2().setBackground(Color.decode("#2196f3"));
		vc.getBoton2().setFont(new Font("Roboto", 1, 12));
		vc.getBoton2().setForeground(Color.decode("#ffffff"));
		vc.getBoton2().setBorder(BorderFactory.createBevelBorder(0));
		// Reseteamos el boton3
		vc.getBoton3().setText("Multiplicar");
		vc.getBoton3().setBounds(60, 250, 100, 50);
		vc.getBoton3().setBackground(Color.decode("#2196f3"));
		vc.getBoton3().setFont(new Font("Roboto", 1, 12));
		vc.getBoton3().setForeground(Color.decode("#ffffff"));
		vc.getBoton3().setBorder(BorderFactory.createBevelBorder(0));
		// Reseteamos el boton4
		vc.getBoton4().setText("Dividir");
		vc.getBoton4().setBounds(180, 250, 100, 50);
		vc.getBoton4().setBackground(Color.decode("#2196f3"));
		vc.getBoton4().setFont(new Font("Roboto", 1, 12));
		vc.getBoton4().setForeground(Color.decode("#ffffff"));
		vc.getBoton4().setBorder(BorderFactory.createBevelBorder(0));
		// Reseteamos el boton6
		vc.getBoton6().setText("Raíz 3");
		vc.getBoton6().setBounds(180, 320, 100, 50);
		vc.getBoton6().setBackground(Color.decode("#2196f3"));
		vc.getBoton6().setFont(new Font("Roboto", 1, 12));
		vc.getBoton6().setForeground(Color.decode("#ffffff"));
		vc.getBoton6().setBorder(BorderFactory.createBevelBorder(0));
		// Mostramos etiqueta2 y cajaTexto2
		vc.getEtiqueta2().setVisible(true);
		vc.getCajaTexto2().setVisible(true);
		// Ocultamos la etiqueta3
		vc.getEtiqueta3().setVisible(false);
	}
}