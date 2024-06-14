package Controlador;

import GUI.JFrame_Accidentes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import plazavea.empleados.ListarTrabajador;
import plazavea.empleados.Resgistro;
import plazavea.empleados.trabajador;

public class controlador_JF_Accidentes implements ActionListener{
    JFrame_Accidentes frm_ra;

    public controlador_JF_Accidentes(JFrame_Accidentes frm_ra) {
        this.frm_ra = frm_ra;
        this.frm_ra.btnGuardar.addActionListener(this);
    }

    public controlador_JF_Accidentes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==frm_ra.btnGuardar){
            
            int IDEmpleado=Integer.parseInt(frm_ra.TFID.getText());
            String nombre=frm_ra.TFNombre.getText();
            String ApellidoP=frm_ra.TFAP.getText();
            String ApellidoM=frm_ra.TFAM.getText();
            int edad=Integer.parseInt(frm_ra.TFEdad.getText());
            String Genero=frm_ra.TFGenero.getText();
            String Descripcion=frm_ra.TFDescripcion.getText();
              
            trabajador T=new trabajador(IDEmpleado, nombre, ApellidoP, ApellidoM, edad, Genero, Descripcion);
            Resgistro  R=new Resgistro();
            R.registrarbd(T);
            
            
            ListarTrabajador la=new ListarTrabajador();
            la.MostrarTabla(frm_ra.tablaRegistro);
            limpiarentradas();
            
        }
    }

    private void limpiarentradas() {
        
        frm_ra.TFID.setText("");
        frm_ra.TFNombre.setText("");
        frm_ra.TFAP.setText("");
        frm_ra.TFAM.setText("");
        frm_ra.TFEdad.setText("");
        frm_ra.TFGenero.setText("");
        frm_ra.TFDescripcion.setText("");
    }
    public static void main(String[] args) {
        // Crear una instancia de JFrame_Accidentes
        JFrame_Accidentes frame = new JFrame_Accidentes();

        // Hacer visible el frame
        frame.setVisible(true);

        // Crear una instancia del controlador y pasarle el frame
        new controlador_JF_Accidentes(frame);
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
