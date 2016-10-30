package data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import logic.Mantainment;
import presentation.ErrorDialog;

public class JDBCConnection {
	private final static Logger LOGGER = Logger.getLogger(JDBCConnection.class.getName());
	private static JDBCConnection instance = null;

	/**
	 * Constructor de la clase. Obtiene acceso a la base de datos. En caso de
	 * que no exista la base de datos la crea. Siempre intenta crear las tablas.
	 * Si la base de datos ya estaba instalada no salen mensajes. Si la base de
	 * datos no existia no salen mensajes.
	 */
	private JDBCConnection() {
		try {
			LOGGER.addHandler(new FileHandler(Constants.LOG_FILE));
		} catch (SecurityException | IOException e) {
			ErrorDialog.show(Constants.ERROR_CREATING_LOG);
			e.printStackTrace();
		}

		/* OBTENIENDO ACCESO A LA BASE DE DATOS */
		Connection connection = null;
		Boolean conex = false;
		try {
			// Check connection to the database
			connection = DriverManager.getConnection(Constants.DRIVERPATH);

			// En este punto sabemos que existe una conexion en la base de datos
			conex = true;
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(Constants.DATABASE_TIMEOUT);
			statement.executeUpdate(SQLSchema.Mantenimiento.SQL_CREATE_TABLE);

		} catch (SQLException e) {
			if (!conex)
				LOGGER.log(Level.SEVERE, Constants.ERROR_CONNECTING_DB, e);
			else if (!e.getMessage().contains("already exists"))
				LOGGER.log(Level.SEVERE, Constants.ERROR_CREATING_TABLES, e);
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					LOGGER.log(Level.SEVERE, Constants.ERROR_CLOSING_CONNECTION, e);
				}
		}
	}

	public static JDBCConnection getInstance()  {
		if (instance == null)
			instance = new JDBCConnection();
		return instance;
	}

	public void updateDatabaseVersion() {
		/*
		 * Ignoramos este trozo de codigo
		 */
	}

	public List<Mantainment> queryData(String maquina, String fecha, String tipoActuacion, String actuacion, String coste, String tiempo, String comentario){
		List<Mantainment> res = new ArrayList<Mantainment>();

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Constants.DRIVERPATH);
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(Constants.DATABASE_TIMEOUT);
			ResultSet rs = statement.executeQuery(SQLSchema.Mantenimiento.queryData(maquina, fecha, tipoActuacion, actuacion, coste, tiempo, comentario));

			while(rs.next())
			res.add(new Mantainment(rs.getString(SQLSchema.Mantenimiento.COLUMN_NAME_MAQUINA),
					rs.getString(SQLSchema.Mantenimiento.COLUMN_NAME_FECHA),
					rs.getString(SQLSchema.Mantenimiento.COLUMN_NAME_TIPO_ACTUACION),
					rs.getString(SQLSchema.Mantenimiento.COLUMN_NAME_ACTUACION),
					rs.getInt(SQLSchema.Mantenimiento.COLUMN_NAME_COSTE),
					rs.getString(SQLSchema.Mantenimiento.COLUMN_NAME_TIEMPO),
					rs.getString(SQLSchema.Mantenimiento.COLUMN_NAME_COMENTARIOS)));

		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Problemas obteniendo un mantenimiento", e);
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				LOGGER.log(Level.SEVERE, Constants.ERROR_CLOSING_CONNECTION, e);
			}
		}
		return res;
	}

	public void addData(Mantainment m) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Constants.DRIVERPATH);
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(Constants.DATABASE_TIMEOUT);

			statement.executeUpdate(SQLSchema.Mantenimiento.insert(m));

		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, Constants.ERROR_ADD, e);
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				LOGGER.log(Level.SEVERE, Constants.ERROR_CLOSING_CONNECTION, e);
			}
		}
	}
}