package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase abstracta para la conexion
 */
public abstract class SQLiteDataHelper {

    private static String DBPathConnection = "jdbc:sqlite:DataBase//RegistroEmpleado.sqlite";
    private static Connection conn = null;

    /**
     * Metodo para abrir la conexiona la bases de datos
     * @return: la coneccion abierta
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public  synchronized Connection openConnection()throws Exception{
        try {
            if(conn==null)
                conn = DriverManager.getConnection(DBPathConnection);
        } catch (SQLException e) {
            throw e;
        }
        return conn;
    }

    /**
     * Metodo para cerra la conexion
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public static void closeConnection() throws Exception {
        
        try {
            if(conn!=null){
                conn.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
