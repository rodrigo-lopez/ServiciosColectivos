package cl.bicevida.services.colectivos.model.ejb.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PlanPrestacionDTO implements Serializable {
    @SuppressWarnings("compatibility")
    private static final long serialVersionUID = 1L;
    
    private String codigoPlan;
    private String nombrePlan;
    private String codigoPrestacion;
    private String nombrePrestacion;
    
    public PlanPrestacionDTO() {
        super();
    }


    public PlanPrestacionDTO(String codigoPlan, String nombrePlan, String codigoPrestacion, String nombrePrestacion) {
        super();
        this.codigoPlan = codigoPlan;
        this.nombrePlan = nombrePlan;
        this.codigoPrestacion = codigoPrestacion;
        this.nombrePrestacion = nombrePrestacion;
    }


    public void setCodigoPlan(String codigoPlan) {
        this.codigoPlan = codigoPlan;
    }

    public String getCodigoPlan() {
        return codigoPlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setCodigoPrestacion(String codigoPrestacion) {
        this.codigoPrestacion = codigoPrestacion;
    }

    public String getCodigoPrestacion() {
        return codigoPrestacion;
    }

    public void setNombrePrestacion(String nombrePrestacion) {
        this.nombrePrestacion = nombrePrestacion;
    }

    public String getNombrePrestacion() {
        return nombrePrestacion;
    }
}
