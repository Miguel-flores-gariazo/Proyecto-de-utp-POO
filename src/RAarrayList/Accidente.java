package RAarrayList;

import java.util.Date;

public class Accidente {
    private String idEmpleado;
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String sexo;
    private Date fechaAccidente;
    private String tipoAccidente;
    private String descripcion;

    public Accidente(String idEmpleado, String tipoDocumento, String numeroDocumento, String nombres, String apellidos, Date fechaNacimiento, String sexo, Date fechaAccidente, String tipoAccidente, String descripcion) {
        this.idEmpleado = idEmpleado;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.fechaAccidente = fechaAccidente;
        this.tipoAccidente = tipoAccidente;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public String getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(String idEmpleado) { this.idEmpleado = idEmpleado; }
    public String getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(String tipoDocumento) { this.tipoDocumento = tipoDocumento; }
    public String getNumeroDocumento() { return numeroDocumento; }
    public void setNumeroDocumento(String numeroDocumento) { this.numeroDocumento = numeroDocumento; }
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public Date getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }
    public Date getFechaAccidente() { return fechaAccidente; }
    public void setFechaAccidente(Date fechaAccidente) { this.fechaAccidente = fechaAccidente; }
    public String getTipoAccidente() { return tipoAccidente; }
    public void setTipoAccidente(String tipoAccidente) { this.tipoAccidente = tipoAccidente; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
