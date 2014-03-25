package cl.bicevida.services.colectivos.model.ejb.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReclamoDTO implements Serializable {
    @SuppressWarnings("compatibility")
    private static final long serialVersionUID = 1L;
    
    private PlanPrestacionDTO planPrestacion;
    private Double totalAtencion;
    private Double montoIsapre;
    
    private Double totalCalculado;
    private Boolean estado;
    private String mensaje;
    
    public ReclamoDTO() {
        super();
    }


    public ReclamoDTO(PlanPrestacionDTO planPrestacion, Double totalAtencion, Double montoIsapre,
                      Double totalCalculado, Boolean estado, String mensaje) {
        super();
        this.planPrestacion = planPrestacion;
        this.totalAtencion = totalAtencion;
        this.montoIsapre = montoIsapre;
        this.totalCalculado = totalCalculado;
        this.estado = estado;
        this.mensaje = mensaje;
    }


    public void setPlanPrestacion(PlanPrestacionDTO planPrestacion) {
        this.planPrestacion = planPrestacion;
    }

    public PlanPrestacionDTO getPlanPrestacion() {
        return planPrestacion;
    }

    public void setTotalAtencion(Double totalAtencion) {
        this.totalAtencion = totalAtencion;
    }

    public Double getTotalAtencion() {
        return totalAtencion;
    }

    public void setMontoIsapre(Double montoIsapre) {
        this.montoIsapre = montoIsapre;
    }

    public Double getMontoIsapre() {
        return montoIsapre;
    }

    public void setTotalCalculado(Double totalCalculado) {
        this.totalCalculado = totalCalculado;
    }

    public Double getTotalCalculado() {
        return totalCalculado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
