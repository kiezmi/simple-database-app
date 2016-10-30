package presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;

import data.Constants;
import logic.Mantainment;

public class MainWindow extends TableFrame{
	private MainWindow instance = null;
	private JMenuBar menuBar;
	private JMenu menuActions, menuHelp;
	private JMenuItem menuItemAdd, menuItemQuery;


	public MainWindow() {
		instance = this;
		// Configuracion principal
		setTitle(Constants.APP_NAME);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Anyadimos el menu
		menuBar = new JMenuBar();

		menuActions = new JMenu(Constants.ACTIONS);
		menuItemAdd = new JMenuItem(Constants.ADD);
		menuItemQuery = new JMenuItem(Constants.QUERY);
		menuActions.add(menuItemAdd);
		menuActions.add(menuItemQuery);

		menuHelp = new JMenu(Constants.HELP);

		menuBar.add(menuActions);
		menuBar.add(menuHelp);
		setJMenuBar(menuBar);

		// Configuramos listeners
		menuItemAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddDialog(instance);
			}
		});
		menuItemQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new QueryDialog(instance);
			}
		});

		

		// Localizacion y tamanyo de la ventana
		setSize(700, 400);

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);

		setVisible(true);
	}

	@Override
	public void showData(Object[][] rowData, Object[] columnNames) {
		JTable table = new JTable(rowData, columnNames);

		getContentPane().add(table.getTableHeader(), BorderLayout.NORTH);
		getContentPane().add(table, BorderLayout.CENTER);
		
		
		setVisible(true);
	}
}
