package logic;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import data.JDBCConnection;

public class Controller {

	public static void addData(Mantainment m) throws SQLException {
		JDBCConnection.getInstance().addData(m);
	}
	
	public static List<Mantainment> queryData(String maquina, String fecha, String tipoActuacion, String actuacion, String coste, String tiempo, String comentario){
		return JDBCConnection.getInstance().queryData(maquina, fecha, tipoActuacion, actuacion, coste, tiempo, comentario);
	}
}
