package cl.bicevida.services.colectivos.model.ejb.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GetGrupoFamiliarIn implements Serializable {
    @SuppressWarnings("compatibility")
    private static final long serialVersionUID = 1L;
    
    private Integer prefijoPoliza;
    private Integer numeroPoliza;
    private Integer secuenciaPoliza;
    private String rutAsegurado;
    private String fechaAtencion;
    private String fechaPresentacionGastos;

    public GetGrupoFamiliarIn() {
        super();
    }

    public GetGrupoFamiliarIn(Integer prefijoPoliza, Integer numeroPoliza, Integer secuenciaPoliza,
                              String rutAsegurado, String fechaAtencion, String fechaPresentacionGastos) {
        super();
        this.prefijoPoliza = prefijoPoliza;
        this.numeroPoliza = numeroPoliza;
        this.secuenciaPoliza = secuenciaPoliza;
        this.rutAsegurado = rutAsegurado;
        this.fechaAtencion = fechaAtencion;
        this.fechaPresentacionGastos = fechaPresentacionGastos;
    }


    public void setPrefijoPoliza(Integer prefijoPoliza) {
        this.prefijoPoliza = prefijoPoliza;
    }

    public Integer getPrefijoPoliza() {
        return prefijoPoliza;
    }

    public void setNumeroPoliza(Integer numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public Integer getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setSecuenciaPoliza(Integer secuenciaPoliza) {
        this.secuenciaPoliza = secuenciaPoliza;
    }

    public Integer getSecuenciaPoliza() {
        return secuenciaPoliza;
    }

    public void setRutAsegurado(String rutAsegurado) {
        this.rutAsegurado = rutAsegurado;
    }

    public String getRutAsegurado() {
        return rutAsegurado;
    }
    
    public void setFechaAtencion(String fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public String getFechaAtencion() {
        return fechaAtencion;
    }   
    
    public void setFechaPresentacionGastos(String fechaPresentacionGastos) {
        this.fechaPresentacionGastos = fechaPresentacionGastos;
    }

    public String getFechaPresentacionGastos() {
        return fechaPresentacionGastos;
    }  
}
