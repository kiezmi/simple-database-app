package presentation;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.Constants;
import data.JDBCConnection;
import logic.Controller;
import logic.Mantainment;

public class AddDialog extends JDialog{
	private final static Logger LOGGER = Logger.getLogger(JDBCConnection.class.getName());

	private JLabel txtMaquina, txtFecha, txtTipoActuacion, txtActuacion, txtComentarios, txtTiempo, txtCoste;
	private JTextField maquina, fecha, tipoActuacion, actuacion, coste, tiempo, comentarios;

	private JButton btnAnyadir;

	public AddDialog(JFrame parent) {
		super(parent, Constants.ADD, true);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(15, 0));

		txtMaquina = new JLabel(Constants.MACHINE);
		maquina = new JTextField();
		txtFecha = new JLabel(Constants.DATE);
		fecha = new JTextField();
		txtTipoActuacion = new JLabel(Constants.ACTUATION_TYPE);
		tipoActuacion = new JTextField();
		txtCoste = new JLabel(Constants.COST);
		actuacion = new JTextField();
		txtActuacion = new JLabel(Constants.ACTUATION);
		coste = new JTextField();
		txtTiempo = new JLabel(Constants.TIME);
		tiempo = new JTextField();
		txtComentarios = new JLabel(Constants.COMENT);
		comentarios = new JTextField();

		btnAnyadir = new JButton(Constants.ADD);
		btnAnyadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addData();
			}
		});

		panel.add(txtMaquina);
		panel.add(maquina);
		panel.add(txtFecha);
		panel.add(fecha);
		panel.add(txtTipoActuacion);
		panel.add(tipoActuacion);
		panel.add(txtActuacion);
		panel.add(actuacion);
		panel.add(txtCoste);
		panel.add(coste);
		panel.add(txtTiempo);
		panel.add(tiempo);
		panel.add(txtComentarios);
		panel.add(comentarios);
		panel.add(btnAnyadir);

		setContentPane(panel);

		/* LOCALIZACION Y TAMANYO */
		setSize(400, 400);
		setResizable(false);

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - getHeight()) / 2);
		setLocation(x, y);
		setVisible(true);
	}

	private void addData() {
		try {
			int valorCoste = Integer.valueOf(coste.getText());

			// TODO we cant allow empty values
			Controller.addData(new Mantainment(maquina.getText(), fecha.getText(), tipoActuacion.getText(),
					actuacion.getText(), valorCoste, tiempo.getText(), comentarios.getText()));
			
			maquina.setText(Constants.EMPTY);
			fecha.setText(Constants.EMPTY);
			tipoActuacion.setText(Constants.EMPTY);
			actuacion.setText(Constants.EMPTY);
			coste.setText(Constants.EMPTY);
			tiempo.setText(Constants.EMPTY);
			comentarios.setText(Constants.EMPTY);
			this.dispose();
		} catch (IllegalArgumentException e) {
			ErrorDialog.show(Constants.COST_VAL_NUMBER);

		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, Constants.ERROR_ADD, e);
			ErrorDialog.show(Constants.ERROR_ADD);
		} catch(ExceptionInInitializerError e){
			ErrorDialog.show(Constants.ERROR_EMPTY_VALUE);
		}
		
	}
}
