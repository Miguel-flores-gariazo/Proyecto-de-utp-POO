package plazavea.empleados;

import Conexion.ConexionMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Resgistro {
    ConexionMysql con = new ConexionMysql();
    Connection cn = con.conectar();
    
    public void registrarbd(trabajador t) {
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement("INSERT INTO trabajador (IDEmpleado, nombre, ApellidoP, ApellidoM, edad, genero, descripcion) VALUES (?, ?, ?, ?, ?, ?, ?)");
                ps.setInt(1, t.getIDEmpleado());
                ps.setString(2, t.getNombre());
                ps.setString(3, t.getApellidoP());
                ps.setString(4, t.getApellidoM());
                ps.setInt(5, t.getEdad());
                ps.setString(6, t.getGenero());
                ps.setString(7, t.getDescripcion());
                
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro exitoso");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al registrar datos: " + e.getMessage());
                e.printStackTrace();
            } finally {
                try {
                    if (cn != null) {
                        cn.close();
                    }
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar la conexión: " + ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos");
        }
    }
}
