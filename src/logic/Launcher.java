package logic;

import javax.swing.JFrame;

import data.JDBCConnection;
import presentation.MainWindow;

public class Launcher extends JFrame {

	public static void main(String args[]) {
		// Instalacion del servicio
		JDBCConnection.getInstance();

		// Ejecutamos LA VENTANA PRINCIPAL
		 new MainWindow();
	}
}
