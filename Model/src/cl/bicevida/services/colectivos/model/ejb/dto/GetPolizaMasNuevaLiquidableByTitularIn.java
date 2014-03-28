package cl.bicevida.services.colectivos.model.ejb.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GetPolizaMasNuevaLiquidableByTitularIn implements Serializable {
    @SuppressWarnings("compatibility")
    private static final long serialVersionUID = 1L;
    
    private String rut;
    private String fecha;

    public GetPolizaMasNuevaLiquidableByTitularIn() {
        super();
    }

    public GetPolizaMasNuevaLiquidableByTitularIn(String rut, String fecha) {
        super();
        this.rut = rut;
        this.fecha = fecha;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getRut() {
        return rut;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }
}
