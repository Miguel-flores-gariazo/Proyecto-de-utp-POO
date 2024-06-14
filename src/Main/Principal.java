package Main;

import Controlador.controlador_JF_Accidentes;
import GUI.JFrame_Accidentes;

public class Principal {
     
   public static JFrame_Accidentes frm_ra;
    public static Controlador.controlador_JF_Accidentes c_frm_ra;
        public static void main(String[] args) {
        
            frm_ra=new JFrame_Accidentes();
            frm_ra.setVisible(true);
            frm_ra.setLocationRelativeTo(null);
            
            c_frm_ra=new controlador_JF_Accidentes(frm_ra);
        } 
}