package Conexion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

public class ConexionMysql {
    Connection cn;
            
    public Connection conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/plazavea","root","");
            System.out.println("Conexcion Establecida");
        } catch (Exception e) {
            System.out.println("ERROR DE CONEXION"+e);
        }
        return cn;
    }
}

