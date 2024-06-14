package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    public static Connection getConexion(){
         
        String Url = "jdbc:sqlserver://localhost:1433;"
                + "database=Lista_Empleados;"
                + "Server name=LAPTOP-0LV0G41V\\SQLEXPRESS;"
                + "Authenticatio = Windows Authentication;"
                + "loginTimeout=30"; 
        try{
             Connection con = DriverManager.getConnection(Url);
             return con;
             
        } catch(SQLException e){
           System.out.println("Error al conectar a la base de datos: " + e.toString());
       return null;
        }
    }
}
