package controlador;

import vista.VentanaCalculadora;

public class Main {

	public static void main(String[] args) {
		// Inicialización de VentanaCalculadora
		VentanaCalculadora calc = new VentanaCalculadora();
		// Inicialización de ManejadorEventos pasándole como argumento VentanaCalculadora
		ManejadorEventos me = new ManejadorEventos(calc);
		// Asociación de VentanaCalculadora a ManejadorEventos
		calc.establecerManejador(me);
	}

}
