
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

    public void addSolicitudSalud(SolicitudSeguroSalud solicitud) {
        solicitudesSalud.add(solicitud);
    }

    public void addSolicitudSalud2(SolicitudSeguroSalud2 solicitud) {
        solicitudesSalud2.add(solicitud);
    }

    public List<SolicitudSeguroSalud> getSolicitudesSalud() {
        return solicitudesSalud;
    }

    public List<SolicitudSeguroSalud2> getSolicitudesSalud2() {
        return solicitudesSalud2;
    }

    public void removeSolicitudSalud(String numeroDocumento) {
        solicitudesSalud.removeIf(s -> s.getNumeroDocumento().equals(numeroDocumento));
    }

    public void removeSolicitudSalud2(String numeroDocumentoConyuge) {
        solicitudesSalud2.removeIf(s -> s.getNumeroDocumentoConyuge().equals(numeroDocumentoConyuge));
    }

    // Singleton pattern for global instance
    private static class RepositorioSingletonHolder {
        private static final Repositorio INSTANCE = new Repositorio();
    }

    public static Repositorio getInstance() {
        return RepositorioSingletonHolder.INSTANCE;
    }
}