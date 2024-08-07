package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class SQLiteDataHelper {

    private static String DBPathConnection = "jdbc:sqlite:DataBase//RegistroEmpleado.sqlite";
    private static Connection conn = null;
    //protected SQLiteDataHelper(){}

    public  synchronized Connection openConnection()throws Exception{
        try {
            if(conn==null)
                conn = DriverManager.getConnection(DBPathConnection);
        } catch (SQLException e) {
            throw e;
        }
        return conn;
    }

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
