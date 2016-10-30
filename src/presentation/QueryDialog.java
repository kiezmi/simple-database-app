package presentation;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.Constants;
import logic.Controller;
import logic.Mantainment;

public class QueryDialog extends JDialog {
	private TableFrame parent;
	private JButton btn;

	private JTextField maquina, fecha, tipoActuacion, actuacion, coste, tiempo, comentario;
	private JLabel lblmaquina, lblfecha, lbltipoActuacion, lblactuacion, lblcoste, lbltiempo, lblcomentario;

	public QueryDialog(TableFrame parent) {
		super(parent, Constants.QUERY, true);
		this.parent = parent;

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(15, 0));

		
		lblmaquina = new JLabel(Constants.MACHINE);
		maquina = new JTextField();
		panel.add(lblmaquina);
		panel.add(maquina);

		lblfecha = new JLabel(Constants.MACHINE);
		fecha = new JTextField();
		panel.add(lblfecha);
		panel.add(fecha);

		lbltipoActuacion = new JLabel(Constants.MACHINE);
		tipoActuacion = new JTextField();
		panel.add(lbltipoActuacion);
		panel.add(tipoActuacion);

		lblactuacion = new JLabel(Constants.MACHINE);
		actuacion = new JTextField();
		panel.add(lblactuacion);
		panel.add(actuacion);

		lblcoste = new JLabel(Constants.MACHINE);
		coste = new JTextField();
		panel.add(lblcoste);
		panel.add(coste);

		lbltiempo = new JLabel(Constants.MACHINE);
		tiempo = new JTextField();
		panel.add(lbltiempo);
		panel.add(tiempo);

		lblcomentario = new JLabel(Constants.MACHINE);
		comentario = new JTextField();
		panel.add(lblcomentario);
		panel.add(comentario);

		btn = new JButton(Constants.QUERY);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queryData();
			}
		});

		panel.add(btn);

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

	private void queryData() {
		List<Mantainment> dataResult = Controller.queryData(maquina.getText(), fecha.getText(), tipoActuacion.getText(),
				actuacion.getText(), coste.getText(), tiempo.getText(), comentario.getText());

		String[][] rowData = new String[dataResult.size()][7];

		for (int i = 0; i < dataResult.size(); i++) {
			rowData[i][0] = dataResult.get(i).getMaquina();
			rowData[i][1] = dataResult.get(i).getFecha();
			rowData[i][2] = dataResult.get(i).getTipoActuacion();
			rowData[i][3] = dataResult.get(i).getActuacion();
			rowData[i][4] = String.valueOf(dataResult.get(i).getCoste());
			rowData[i][5] = dataResult.get(i).getTiempo();
			rowData[i][6] = dataResult.get(i).getComentario();
		}
		final String[] fieldNames = { "maquina", "fecha", "tipoActuacion", "actuacion", "coste", "tiempo",
				"comentario" };

		parent.showData(rowData, fieldNames);
		this.dispose();
	}
}
