
package plazavea.solicitudseguro;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    private List<SolicitudSeguro2> solicitudes;

    public Repositorio() {
        solicitudes = new ArrayList<>();
    }

    public void guardarSolicitud(SolicitudSeguro2 solicitud) {
        solicitudes.add(solicitud);
        System.out.println("Solicitud guardada: " + solicitud);
    }

    public void guardarSolicitud(SolicitudSeguroSalud2 solicitud) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static class SolicitudSeguro2 {

        public SolicitudSeguro2() {
        }
    }
}
