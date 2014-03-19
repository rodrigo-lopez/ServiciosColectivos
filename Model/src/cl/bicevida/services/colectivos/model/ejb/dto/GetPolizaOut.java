package cl.bicevida.services.colectivos.model.ejb.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GetPolizaOut implements Serializable {
    @SuppressWarnings("compatibility")
    private static final long serialVersionUID = 1L;
    
    private PolizaDTO poliza;

    public GetPolizaOut() {
        super();
    }

    public GetPolizaOut(PolizaDTO poliza) {
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
