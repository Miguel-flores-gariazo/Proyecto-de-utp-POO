package plazavea.empleados;

import java.util.Date;


public class Empleado{

    public static void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private String nombre;
    private String apellido_Paterno;
    private String apellido_Materno;
    private int edad;
    private String genero;
    private String dni;
    private String telefono;
    private String puesto;
    private String tipoSeguro;
    private String gmail;
    private String Ecivil;
    private Date fechaN;
    private String nacionalidad;

    public Empleado( String nombre, String apellido_Paterno, String apellido_Materno, int edad, String genero, String dni, String telefono, String puesto, String tipoSeguro, String gmail, String Ecivil, Date fechaN, String nacionalidad) {
        this.nombre = nombre;
        this.apellido_Paterno = apellido_Paterno;
        this.apellido_Materno = apellido_Materno;
        this.edad = edad;
        this.genero = genero;
        this.dni = dni;
        this.telefono = telefono;
        this.puesto = puesto;
        this.tipoSeguro = tipoSeguro;
        this.gmail = gmail;
        this.Ecivil = Ecivil;
        this.fechaN = fechaN;
        this.nacionalidad = nacionalidad;
    }


    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_Paterno() {
        return apellido_Paterno;
    }

    public void setApellido_Paterno(String apellido_Paterno) {
        this.apellido_Paterno = apellido_Paterno;
    }

    public String getApellido_Materno() {
        return apellido_Materno;
    }

    public void setApellido_Materno(String apellido_Materno) {
        this.apellido_Materno = apellido_Materno;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getEcivil() {
        return Ecivil;
    }

    public void setEcivil(String Ecivil) {
        this.Ecivil = Ecivil;
    }

    public Date getFechaN() {
        return fechaN;
    }

    public void setFechaN(Date fechaN) {
        this.fechaN = fechaN;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", apellido_Paterno='" + apellido_Paterno + '\'' +
                ", apellido_Materno='" + apellido_Materno + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                ", dni='" + dni + '\'' +
                ", telefono='" + telefono + '\'' +
                ", puesto='" + puesto + '\'' +
                ", tipoSeguro='" + tipoSeguro + '\'' +
                ", fecha de nacimiento =" + fechaN +
                ", correo electronico=" + gmail +
                ", estado civil =" + Ecivil +
                ", nacionalidad=" + nacionalidad +
                '}';
    }
}