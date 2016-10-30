package data;

public final class SQLSchema {
	private SQLSchema() {
	}

	private static final String COMMA_SEP = ",";
	private static final String TEXT_TYPE = " STRING ";
	private static final String NUMBER_TYPE = " INTEGER ";
	private static final String PRIMARY_KEY = " PRIMARY KEY ";
	private static final String DATE_TYPE = TEXT_TYPE;
	private static final String AUTOINCREMENT = " AUTOINCREMENT ";

	public static class Mantenimiento {
		private Mantenimiento() {
		}

		public static final String TABLE_NAME = "MANTENIMIENTO";
		public static final String COLUMN_NAME_IDAVERIA = "IDAVERIA";
		public static final String COLUMN_NAME_MAQUINA = "MAQUINA";
		public static final String COLUMN_NAME_FECHA = "FECHA";
		public static final String COLUMN_NAME_TIPO_ACTUACION = "TIPO_ACTUACION";
		public static final String COLUMN_NAME_ACTUACION = "ACTUACION";
		public static final String COLUMN_NAME_COSTE = "COSTE";
		public static final String COLUMN_NAME_TIEMPO = "TIEMPO";
		public static final String COLUMN_NAME_COMENTARIOS = "COMENTARIOS";

		public static final String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_NAME_IDAVERIA
				+ NUMBER_TYPE + PRIMARY_KEY + AUTOINCREMENT + COMMA_SEP + COLUMN_NAME_MAQUINA + TEXT_TYPE + COMMA_SEP
				+ COLUMN_NAME_FECHA + DATE_TYPE + COMMA_SEP + COLUMN_NAME_TIPO_ACTUACION + TEXT_TYPE + COMMA_SEP
				+ COLUMN_NAME_ACTUACION + TEXT_TYPE + COMMA_SEP + COLUMN_NAME_COSTE + NUMBER_TYPE + COMMA_SEP
				+ COLUMN_NAME_TIEMPO + TEXT_TYPE + COMMA_SEP + COLUMN_NAME_COMENTARIOS + TEXT_TYPE + " );";

		public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

		public static String insert(logic.Mantainment m) {
			return "INSERT INTO " + TABLE_NAME + " (" + COLUMN_NAME_MAQUINA + ", " + COLUMN_NAME_FECHA + ", "
					+ COLUMN_NAME_TIPO_ACTUACION + ", " + COLUMN_NAME_ACTUACION + ", " + COLUMN_NAME_COSTE + ", "
					+ COLUMN_NAME_TIEMPO + ", " + COLUMN_NAME_COMENTARIOS + ") VALUES (\"" + m.getMaquina() + "\", \""
					+ m.getFecha().toString() + "\", \"" + m.getTipoActuacion() + "\", \"" + m.getActuacion() + "\", \""
					+ m.getCoste() + "\", \"" + m.getTiempo() + "\", \"" + m.getComentario() + "\");";
		}

		public static String queryData(String maquina, String fecha, String tipoActuacion, String actuacion, String coste,
				String tiempo, String comentarios) {
			
			try{
				
			int valorCoste = Integer.valueOf(coste);
			
			return "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_NAME_MAQUINA + " LIKE '%" + maquina + "%' AND "
			+ COLUMN_NAME_FECHA + " LIKE '%" + fecha + "%' AND " + COLUMN_NAME_TIPO_ACTUACION + " LIKE '%"
			+ tipoActuacion + "%' AND " + COLUMN_NAME_ACTUACION + " LIKE '%" + actuacion + "%' AND "
			+ COLUMN_NAME_COSTE + " LIKE '%" + valorCoste + "%' AND " + COLUMN_NAME_TIEMPO + " LIKE '%" + tiempo
			+ "%'" + " AND " + COLUMN_NAME_COMENTARIOS + " LIKE '%" + comentarios + "%' ORDER BY "
			+ COLUMN_NAME_MAQUINA + ";";
			
			}catch(Exception e){
				return "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_NAME_MAQUINA + " LIKE '%" + maquina
						+ "%' AND " + COLUMN_NAME_FECHA + " LIKE '%" + fecha + "%' AND " + COLUMN_NAME_TIPO_ACTUACION
						+ " LIKE '%" + tipoActuacion + "%' AND " + COLUMN_NAME_ACTUACION + " LIKE '%" + actuacion
						+ "%' AND " + COLUMN_NAME_TIEMPO + " LIKE '%" + tiempo + "%'" + " AND "
						+ COLUMN_NAME_COMENTARIOS + " LIKE '%" + comentarios + "%' ORDER BY " + COLUMN_NAME_MAQUINA
						+ ";";
			}
				

			
		}
	}
}