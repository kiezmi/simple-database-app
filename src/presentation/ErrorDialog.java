package presentation;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import data.Constants;

public class ErrorDialog {

	public static void show(String message) {
		JOptionPane.showMessageDialog(new JFrame(), message, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
	}
}
