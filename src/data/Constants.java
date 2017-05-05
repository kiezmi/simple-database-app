package data;

public class Constants {

	public static final String APP_NAME = "DATABASE EXAMPLE";
	public static final String ERROR = "ERROR";
	public static final String EMPTY = "";

	// Log
	public static final String LOG_FILE = APP_NAME + ".log";
	public static final String ERROR_CREATING_LOG = "No hay permisos suficientes para crear el log";

	// Database
	public static final String DRIVERPATH = "jdbc:sqlite:" + Constants.DATABASE_FILE;
	public static final String DATABASE_FILE = APP_NAME + ".db";
	public static final int DATABASE_TIMEOUT = 10; // 10 segundos

	// Main window
	public static final String ADD = "AÑADIR";
	public static final String QUERY = "BUSCAR";
	public static final String EDIT = "EDITAR";

	// Menu items
	public static final String ACTIONS = "ACCIONES";
	public static final String HELP = "AYUDA";

	// Add window
	public static final String MACHINE = "Maquina";
	public static final String DATE = "Fecha";
	public static final String ACTUATION_TYPE = "Tipo actuacion";
	public static final String COST = "Coste";
	public static final String ACTUATION = "Actuacion";
	public static final String TIME = "Tiempo";
	public static final String COMENT = "Comentario";

	// User errors
	public static final String COST_VAL_NUMBER = "El valor de coste debe de ser numérico";
	public static final String ERROR_ADD = "Error añadiendo el mantenimiento en la base de datos";
	public static final String ERROR_EMPTY_VALUE = "No puede haber campos vacios ni coste < 0";
	

	// JDBCConnection
	public static final String ERROR_CLOSING_CONNECTION = "Problemas cerrando la conexion en el creador del JDBC";
	public static final String ERROR_CONNECTING_DB = "Error conectando con la base de datos";
	public static final String ERROR_CREATING_TABLES = "Error creando las tablas";
}
