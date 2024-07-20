package plazavea.solicitudseguro;

public class SolicitudSeguroSalud2 {

    public String getNombreConyuge() {
        return nombreConyuge;
    }

    public void setNombreConyuge(String nombreConyuge) {
        this.nombreConyuge = nombreConyuge;
    }

    public String getApellidoConyuge() {
        return apellidoConyuge;
    }

    public void setApellidoConyuge(String apellidoConyuge) {
        this.apellidoConyuge = apellidoConyuge;
    }

    public String getTipoDocumentoConyuge() {
        return tipoDocumentoConyuge;
    }

    public void setTipoDocumentoConyuge(String tipoDocumentoConyuge) {
        this.tipoDocumentoConyuge = tipoDocumentoConyuge;
    }

    public String getNumeroDocumentoConyuge() {
        return numeroDocumentoConyuge;
    }

    public void setNumeroDocumentoConyuge(String numeroDocumentoConyuge) {
        this.numeroDocumentoConyuge = numeroDocumentoConyuge;
    }

    public String getNombreHijo() {
        return nombreHijo;
    }

    public void setNombreHijo(String nombreHijo) {
        this.nombreHijo = nombreHijo;
    }

    public String getApellidoHijo() {
        return apellidoHijo;
    }

    public void setApellidoHijo(String apellidoHijo) {
        this.apellidoHijo = apellidoHijo;
    }

    public String getTipoDocumentoHijo() {
        return tipoDocumentoHijo;
    }

    public void setTipoDocumentoHijo(String tipoDocumentoHijo) {
        this.tipoDocumentoHijo = tipoDocumentoHijo;
    }

    public String getNumeroDocumentoHijo() {
        return numeroDocumentoHijo;
    }

    public void setNumeroDocumentoHijo(String numeroDocumentoHijo) {
        this.numeroDocumentoHijo = numeroDocumentoHijo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoProceso() {
        return tipoProceso;
    }

    public void setTipoProceso(String tipoProceso) {
        this.tipoProceso = tipoProceso;
    }

    public String getMotivoBaja() {
        return motivoBaja;
    }

    public void setMotivoBaja(String motivoBaja) {
        this.motivoBaja = motivoBaja;
    }

    public String getFechaFinVinculo() {
        return fechaFinVinculo;
    }

    public void setFechaFinVinculo(String fechaFinVinculo) {
        this.fechaFinVinculo = fechaFinVinculo;
    }
    private String nombreConyuge;
    private String apellidoConyuge;
    private String tipoDocumentoConyuge;
    private String numeroDocumentoConyuge;
    private String nombreHijo;
    private String apellidoHijo;
    private String tipoDocumentoHijo;
    private String numeroDocumentoHijo;
    private String pais;
    private String departamento;
    private String distrito;
    private String direccion;
    private String tipoProceso;
    private String motivoBaja;
    private String fechaFinVinculo;

    // Constructor, getters, and setters

    @Override
    public String toString() {
        return "SolicitudSeguro{" +
                "nombreConyuge='" + nombreConyuge + '\'' +
                ", apellidoConyuge='" + apellidoConyuge + '\'' +
                ", tipoDocumentoConyuge='" + tipoDocumentoConyuge + '\'' +
                ", numeroDocumentoConyuge='" + numeroDocumentoConyuge + '\'' +
                ", nombreHijo='" + nombreHijo + '\'' +
                ", apellidoHijo='" + apellidoHijo + '\'' +
                ", tipoDocumentoHijo='" + tipoDocumentoHijo + '\'' +
                ", numeroDocumentoHijo='" + numeroDocumentoHijo + '\'' +
                ", pais='" + pais + '\'' +
                ", departamento='" + departamento + '\'' +
                ", distrito='" + distrito + '\'' +
                ", direccion='" + direccion + '\'' +
                ", tipoProceso='" + tipoProceso + '\'' +
                ", motivoBaja='" + motivoBaja + '\'' +
                ", fechaFinVinculo='" + fechaFinVinculo + '\'' +
                '}';
    }
}
