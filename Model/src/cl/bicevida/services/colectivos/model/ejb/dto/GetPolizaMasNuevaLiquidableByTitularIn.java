package cl.bicevida.services.colectivos.model.ejb.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GetPolizaMasNuevaLiquidableByTitularIn implements Serializable {
    @SuppressWarnings("compatibility")
    private static final long serialVersionUID = 1L;
    
    private String rut;

    public GetPolizaMasNuevaLiquidableByTitularIn() {
        super();
    }

    public GetPolizaMasNuevaLiquidableByTitularIn(String rut) {
        super();
        this.rut = rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getRut() {
        return rut;
    }
}
