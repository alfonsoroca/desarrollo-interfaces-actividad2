package vista;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.Color;

import controlador.ManejadorEventos;

// Clase que despliega la ventana de la calculadora y extiende JFrame 
public class VentanaCalculadora extends JFrame {

	// Atributos de la clase
	private JLabel etiqueta1, etiqueta2, etiqueta3;
	private JTextField cajaTexto1, cajaTexto2;
	private JButton boton1, boton2, boton3, boton4, boton5, boton6, boton7;

	// Constructor de VentanaCalculadora
	public VentanaCalculadora() {

		// Título de la ventana
		setTitle("Calculadora");
		// Tamaño
		setSize(340, 550);
		// Bloqueamos tamaño
		setResizable(false);
		// Posición centrada
		setLocationRelativeTo(null);
		// Comportamiento al cierre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Desactivación colocación componentes
		setLayout(null);
		// Inicialización de componentes
		initComponentes();
		// Color del fondo de la ventana
		this.getContentPane().setBackground(Color.decode("#fafafa"));
		// Visibilidad
		setVisible(true);
	}

	// Getters
	public JLabel getEtiqueta3() {
		return etiqueta3;
	}

	public JTextField getCajaTexto1() {
		return cajaTexto1;
	}

	public JTextField getCajaTexto2() {
		return cajaTexto2;
	}

	public JButton getBoton1() {
		return boton1;
	}

	public JButton getBoton2() {
		return boton2;
	}

	public JButton getBoton3() {
		return boton3;
	}

	public JButton getBoton4() {
		return boton4;
	}

	public JButton getBoton5() {
		return boton5;
	}

	public JButton getBoton6() {
		return boton6;
	}

	public JButton getBoton7() {
		return boton7;
	}

	// Método que inicializa los componentes
	private void initComponentes() {

		// Inicialización de etiqueta1 y características
		// Inicialización
		etiqueta1 = new JLabel("Número 1:");
		// Posición y tamaño
		etiqueta1.setBounds(60, 50, 70, 40);
		// Añadimos a ventana
		add(etiqueta1);

		// Inicialización de cajaTexto1 y características
		// Inicialización
		cajaTexto1 = new JTextField();
		// Posición y tamaño
		cajaTexto1.setBounds(180, 50, 100, 40);
		// Ponemos el foco en cajaTexto1
		cajaTexto1.requestFocus();
		// Añadimos a ventana
		add(cajaTexto1);

		// Inicialización de etiqueta2 y características
		// Inicialización
		etiqueta2 = new JLabel("Número 2:");
		// Posición y tamaño
		etiqueta2.setBounds(60, 100, 70, 40);
		// Añadimos a ventana
		add(etiqueta2);

		// Inicialización de cajaTexto2 y características
		// Inicialización
		cajaTexto2 = new JTextField();
		// Posición y tamaño
		cajaTexto2.setBounds(180, 100, 100, 40);
		// Añadimos a ventana
		add(cajaTexto2);

		// Inicialización de boton1 y características
		// Inicialización
		boton1 = new JButton("Sumar");
		// Posición y tamaño
		boton1.setBounds(60, 160, 100, 50);
		// Estilo del boton
		boton1.setBackground(Color.decode("#2196f3"));
		boton1.setForeground(Color.decode("#ffffff"));
		boton1.setBorder(BorderFactory.createBevelBorder(0));

		// Añadimos a ventana
		add(boton1);

		// Inicialización de boton2 y características
		// Inicialización
		boton2 = new JButton("Restar");
		// Posición y tamaño
		boton2.setBounds(180, 160, 100, 50);
		// Estilo del boton
		boton2.setBackground(Color.decode("#2196f3"));
		boton2.setForeground(Color.decode("#ffffff"));
		boton2.setBorder(BorderFactory.createBevelBorder(0));
		// Añadimos a ventana
		add(boton2);

		// Inicialización de boton3 y características
		// Inicialización
		boton3 = new JButton("Multiplicar");
		// Posición y tamaño
		boton3.setBounds(60, 230, 100, 50);
		// Estilo del boton
		boton3.setBackground(Color.decode("#2196f3"));
		boton3.setForeground(Color.decode("#ffffff"));
		boton3.setBorder(BorderFactory.createBevelBorder(0));
		// Añadimos a ventana
		add(boton3);

		// Inicialización de boton4 y características
		// Inicialización
		boton4 = new JButton("Dividir");
		// Posición y tamaño
		boton4.setBounds(180, 230, 100, 50);
		// Estilo del boton
		boton4.setBackground(Color.decode("#2196f3"));
		boton4.setForeground(Color.decode("#ffffff"));
		boton4.setBorder(BorderFactory.createBevelBorder(0));
		// Añadimos a ventana
		add(boton4);

		// Inicialización de boton5 y características
		// Inicialización
		boton5 = new JButton("Raíz 2");
		// Posición y tamaño
		boton5.setBounds(60, 300, 100, 50);
		// Estilo del boton
		boton5.setBackground(Color.decode("#2196f3"));
		boton5.setForeground(Color.decode("#ffffff"));
		boton5.setBorder(BorderFactory.createBevelBorder(0));
		// Añadimos a ventana
		add(boton5);

		// Inicialización de boton6 y características
		// Inicialización
		boton6 = new JButton("Raíz 3");
		// Posición y tamaño
		boton6.setBounds(180, 300, 100, 50);
		// Estilo del boton
		boton6.setBackground(Color.decode("#2196f3"));
		boton6.setForeground(Color.decode("#ffffff"));
		boton6.setBorder(BorderFactory.createBevelBorder(0));
		// Añadimos a ventana
		add(boton6);

		// Inicialización de etiqueta3 y características
		// Esta etiqueta será la que muestre el resultado en la ventana
		// Inicialización
		etiqueta3 = new JLabel("Resultado:");
		// Posición y tamaño
		etiqueta3.setBounds(60, 370, 220, 40);
		// Añadimos a ventana
		add(etiqueta3);

		// Inicialización de boton7 y características
		// Inicialización
		boton7 = new JButton("Reset");
		// Posición y tamaño
		boton7.setBounds(120, 420, 100, 50);
		// Añadimos a ventana
		add(boton7);
	}

	// Método que asocia el manejador de eventos
	public void establecerManejador(ManejadorEventos me) {
		boton1.addActionListener(me);
		boton2.addActionListener(me);
		boton3.addActionListener(me);
		boton4.addActionListener(me);
		boton5.addActionListener(me);
		boton6.addActionListener(me);
		boton7.addActionListener(me);
	}

}