package plazavea.capacitacion;

public class capacitacion {
    // Atributos de la clase
    private String titulo;
    private String descripcion;
    private String fecha;
    private String hora;
    private String duracion;
    private String ubicacion;
    private String facilitador;
    private String contactoFacilitador;
    private String departamentoFacilitador;
    private String capacidadSala;
    private String numeroAsistentes;
    private String otros;

    // Constructor con todos los atributos
    public capacitacion(String titulo, String descripcion, String fecha, String hora, String duracion,
                        String ubicacion, String facilitador, String contactoFacilitador, 
                        String departamentoFacilitador, String capacidadSala, String numeroAsistentes, 
                        String otros) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
        this.ubicacion = ubicacion;
        this.facilitador = facilitador;
        this.contactoFacilitador = contactoFacilitador;
        this.departamentoFacilitador = departamentoFacilitador;
        this.capacidadSala = capacidadSala;
        this.numeroAsistentes = numeroAsistentes;
        this.otros = otros;
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFacilitador() {
        return facilitador;
    }

    public void setFacilitador(String facilitador) {
        this.facilitador = facilitador;
    }

    public String getContactoFacilitador() {
        return contactoFacilitador;
    }

    public void setContactoFacilitador(String contactoFacilitador) {
        this.contactoFacilitador = contactoFacilitador;
    }

    public String getDepartamentoFacilitador() {
        return departamentoFacilitador;
    }

    public void setDepartamentoFacilitador(String departamentoFacilitador) {
        this.departamentoFacilitador = departamentoFacilitador;
    }

    public String getCapacidadSala() {
        return capacidadSala;
    }

    public void setCapacidadSala(String capacidadSala) {
        this.capacidadSala = capacidadSala;
    }

    public String getNumeroAsistentes() {
        return numeroAsistentes;
    }

    public void setNumeroAsistentes(String numeroAsistentes) {
        this.numeroAsistentes = numeroAsistentes;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }

    // Método para mostrar la información de la capacitación
    @Override
    public String toString() {
        return "Capacitacion{" +
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", duracion='" + duracion + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", facilitador='" + facilitador + '\'' +
                ", contactoFacilitador='" + contactoFacilitador + '\'' +
                ", departamentoFacilitador='" + departamentoFacilitador + '\'' +
                ", capacidadSala='" + capacidadSala + '\'' +
                ", numeroAsistentes='" + numeroAsistentes + '\'' +
                ", otros='" + otros + '\'' +
                '}';
    }
}
