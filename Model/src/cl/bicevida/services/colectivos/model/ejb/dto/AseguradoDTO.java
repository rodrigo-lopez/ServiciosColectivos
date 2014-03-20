package cl.bicevida.services.colectivos.model.ejb.dto;

import java.io.Serializable;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AseguradoDTO implements Serializable {
    @SuppressWarnings("compatibility")
    private static final long serialVersionUID = 1L;
    
    private Integer numeroAsegurado;
    private Integer numeroCarga;
    private Integer rut;
    private String dv;
    private String nombreCompleto;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private Calendar inicioVigencia;
    private Calendar terminoVigencia;
    private Calendar fechaIncorporacion;
    private Calendar fechaExclusion;
    private String sexo;
    private String relacion;    
    private Integer numeroGrupo;
    
    
    public AseguradoDTO() {
        super();
    }


    public AseguradoDTO(Integer numeroAsegurado, Integer numeroCarga, Integer rut, String dv, String nombreCompleto,
                        String nombre, String primerApellido, String segundoApellido, Calendar inicioVigencia,
                        Calendar terminoVigencia, Calendar fechaIncorporacion, Calendar fechaExclusion, String sexo,
                        String relacion, Integer numeroGrupo) {
        super();
        this.numeroAsegurado = numeroAsegurado;
        this.numeroCarga = numeroCarga;
        this.rut = rut;
        this.dv = dv;
        this.nombreCompleto = nombreCompleto;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.inicioVigencia = inicioVigencia;
        this.terminoVigencia = terminoVigencia;
        this.fechaIncorporacion = fechaIncorporacion;
        this.fechaExclusion = fechaExclusion;
        this.sexo = sexo;
        this.relacion = relacion;
        this.numeroGrupo = numeroGrupo;
    }


    public void setNumeroAsegurado(Integer numeroAsegurado) {
        this.numeroAsegurado = numeroAsegurado;
    }

    public Integer getNumeroAsegurado() {
        return numeroAsegurado;
    }

    public void setNumeroCarga(Integer numeroCarga) {
        this.numeroCarga = numeroCarga;
    }

    public Integer getNumeroCarga() {
        return numeroCarga;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public Integer getRut() {
        return rut;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getDv() {
        return dv;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setInicioVigencia(Calendar inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public Calendar getInicioVigencia() {
        return inicioVigencia;
    }

    public void setTerminoVigencia(Calendar terminoVigencia) {
        this.terminoVigencia = terminoVigencia;
    }

    public Calendar getTerminoVigencia() {
        return terminoVigencia;
    }

    public void setFechaIncorporacion(Calendar fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public Calendar getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaExclusion(Calendar fechaExclusion) {
        this.fechaExclusion = fechaExclusion;
    }

    public Calendar getFechaExclusion() {
        return fechaExclusion;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    public String getRelacion() {
        return relacion;
    }
    
    


    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AseguradoDTO)) {
            return false;
        }
        final AseguradoDTO other = (AseguradoDTO)object;
        if (!(rut == null ? other.rut == null : rut.equals(other.rut))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 37;
        int result = 1;
        result = PRIME * result + ((rut == null) ? 0 : rut.hashCode());
        return result;
    }

    public void setNumeroGrupo(Integer numeroGrupo) {
        this.numeroGrupo = numeroGrupo;
    }

    public Integer getNumeroGrupo() {
        return numeroGrupo;
    }
}
