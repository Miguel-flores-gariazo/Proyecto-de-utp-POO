
package plazavea.solicitudseguro;

import java.util.ArrayList;
import java.util.List;


// Se asume que SolicitudSeguroSalud y SolicitudSeguroSalud2 son clases de solicitud.
public class Repositorio {
    private List<SolicitudSeguroSalud> solicitudesSalud;
    private List<SolicitudSeguroSalud2> solicitudesSalud2;


    public Repositorio() {
        solicitudesSalud = new ArrayList<>();
        solicitudesSalud2 = new ArrayList<>();
    }

// Método para guardar solicitudes de tipo SolicitudSeguroSalud
    public void guardarSolicitud(SolicitudSeguroSalud solicitud) {
        solicitudesSalud.add(solicitud);
        System.out.println("Solicitud de Salud guardada: " + solicitud);
    }
     // Método para guardar solicitudes de tipo SolicitudSeguroSalud2
    public void guardarSolicitud(SolicitudSeguroSalud2 solicitud) {
        solicitudesSalud2.add(solicitud);
        System.out.println("Solicitud de Salud2 guardada: " + solicitud);
    }

// Métodos adicionales para obtener las solicitudes si es necesario
    public List<SolicitudSeguroSalud> getSolicitudesSalud() {
        return solicitudesSalud;
    }
   public List<SolicitudSeguroSalud2> getSolicitudesSalud2() {
        return solicitudesSalud2;
    }
}
