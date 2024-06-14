package plazavea.empleados;

import Conexion.ConexionMysql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListarTrabajador {
    ConexionMysql con=new ConexionMysql();
    Connection cn=con.conectar();
    
    public void MostrarTabla(JTable tabla) {
        DefaultTableModel modelo=new DefaultTableModel();
        modelo.addColumn("IDEmpleado");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido_Paterno");
        modelo.addColumn("Apellido_Materno");
        modelo.addColumn("Edad");
        modelo.addColumn("Genero");
        modelo.addColumn("Descripcion");
        String consultasql="SELECT*FROM trabajador";
        Statement st;
        try {
            st=cn.createStatement();
             ResultSet rs=st.executeQuery(consultasql);
             while (rs.next()) {
                Object [] lista={rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getString(7)};
                modelo.addRow(lista);
             }
             tabla.setModel(modelo);
        } catch (Exception e){
            System.out.println("ERROR AL LISTAR LOS DATOS"+e);
        }
    }

    public void MostrarTable(JTable tablaRegistro) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    
    
    
    
    
    
}
