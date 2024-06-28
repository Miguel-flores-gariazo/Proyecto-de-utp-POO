package accidente;

import java.util.Date;

public class Accidente {
    // atributos y métodos de la clase Accidente

    private String idEmpleado;
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombres;
    private String apellidos;
    private String sexo;
    private String tipoAccidente;
    private String descripcion;
    private Date fechaAccidente;
    private Date fechaNacimiento;

    public Accidente(String idEmpleado, String tipoDocumento, String numeroDocumento, String nombres, String apellidos,
                     String sexo, String tipoAccidente, String descripcion, Date fechaAccidente, Date fechaNacimiento) {
        this.idEmpleado = idEmpleado;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.tipoAccidente = tipoAccidente;
        this.descripcion = descripcion;
        this.fechaAccidente = fechaAccidente;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters y setters para cada campo
    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipoAccidente() {
        return tipoAccidente;
    }

    public void setTipoAccidente(String tipoAccidente) {
        this.tipoAccidente = tipoAccidente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaAccidente() {
        return fechaAccidente;
    }

    public void setFechaAccidente(Date fechaAccidente) {
        this.fechaAccidente = fechaAccidente;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public static void main(String[] args) {
        // Creamos una instancia de la clase Accidente
        Accidente accidente = new Accidente("12345", "DNI", "12345678", "Juan", "Pérez", "Masculino", "Accidente laboral", "Se cayó en el trabajo", new Date(), new Date());

        // Imprimimos los datos del accidente
        System.out.println("Datos del accidente:");
        System.out.println("ID Empleado: " + accidente.getIdEmpleado());
        System.out.println("Tipo de documento: " + accidente.getTipoDocumento());
        System.out.println("Número de documento: " + accidente.getNumeroDocumento());
        System.out.println("Nombres: " + accidente.getNombres());
        System.out.println("Apellidos: " + accidente.getApellidos());
        System.out.println("Sexo: " + accidente.getSexo());
        System.out.println("Tipo de accidente: " + accidente.getTipoAccidente());
        System.out.println("Descripción: " + accidente.getDescripcion());
        System.out.println("Fecha de accidente: " + accidente.getFechaAccidente());
        System.out.println("Fecha de nacimiento: " + accidente.getFechaNacimiento());
    }
}