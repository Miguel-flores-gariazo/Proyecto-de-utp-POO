package plazavea.accidentes;
import java.util.Date;
public class accidente {
    private String idAccidente;
    private Date fecha;
    private String descripcion;

    public accidente(String idAccidente, Date fecha, String descripcion) {
        this.idAccidente = idAccidente;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    // Getters and Setters
    public String getIdAccidente() {
        return idAccidente;
    }

    public void setIdAccidente(String idAccidente) {
        this.idAccidente = idAccidente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
