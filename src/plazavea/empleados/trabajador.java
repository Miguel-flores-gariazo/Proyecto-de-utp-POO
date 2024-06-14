package plazavea.empleados;


public class trabajador{
    private int IDEmpleado;
    private String nombre;
    private String ApellidoP;
    private String ApellidoM;
    private int edad;
    private String genero;
    private String descripcion;

    public trabajador(int IDEmpleado, String nombre, String ApellidoP, String ApellidoM, int edad, String genero, String descripcion) {
        this.IDEmpleado = IDEmpleado;
        this.nombre = nombre;
        this.ApellidoP = ApellidoP;
        this.ApellidoM = ApellidoM;
        this.edad = edad;
        this.genero = genero;
        this.descripcion = descripcion;
    }

    public int getIDEmpleado() {
        return IDEmpleado;
    }

    public void setIDEmpleado(int IDEmpleado) {
        this.IDEmpleado = IDEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return ApellidoP;
    }

    public void setApellidoP(String ApellidoP) {
        this.ApellidoP = ApellidoP;
    }

    public String getApellidoM() {
        return ApellidoM;
    }

    public void setApellidoM(String ApellidoM) {
        this.ApellidoM = ApellidoM;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    }