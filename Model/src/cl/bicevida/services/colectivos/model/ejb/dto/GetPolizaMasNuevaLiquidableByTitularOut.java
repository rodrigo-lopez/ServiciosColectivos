package cl.bicevida.services.colectivos.model.ejb.dto;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GetPolizaMasNuevaLiquidableByTitularOut implements Serializable {
    @SuppressWarnings("compatibility")
    private static final long serialVersionUID = 1L;
    
    private PolizaDTO poliza;


    public GetPolizaMasNuevaLiquidableByTitularOut() {
        super();
    }

    public GetPolizaMasNuevaLiquidableByTitularOut(PolizaDTO poliza) {
        super();
        this.poliza = poliza;
    }


    public void setPoliza(PolizaDTO poliza) {
        this.poliza = poliza;
    }

    public PolizaDTO getPoliza() {
        return poliza;
    }
}
