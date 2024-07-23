package RAArray;

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

    // Constructor vacío que inicializa los campos con valores predeterminados
    public Accidente() {
        this.idEmpleado = "";
        this.tipoDocumento = "";
        this.numeroDocumento = "";
        this.nombres = "";
        this.apellidos = "";
        this.fechaNacimiento = new Date();
        this.sexo = "";
        this.fechaAccidente = new Date();
        this.tipoAccidente = "";
        this.descripcion = "";
    }

    // Constructor con parámetros
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

    // Getters
    public String getIdEmpleado() {
        return idEmpleado;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public Date getFechaAccidente() {
        return fechaAccidente;
    }

    public String getTipoAccidente() {
        return tipoAccidente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // Setters
    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setFechaAccidente(Date fechaAccidente) {
        this.fechaAccidente = fechaAccidente;
    }

    public void setTipoAccidente(String tipoAccidente) {
        this.tipoAccidente = tipoAccidente;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    void setCodigo(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setGravedad(String trim) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setHora(String trim) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setFecha(String trim) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}