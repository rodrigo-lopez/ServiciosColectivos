package cl.bicevida.services.colectivos.model.ejb.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GetPolizaIn implements Serializable {
    @SuppressWarnings("compatibility")
    private static final long serialVersionUID = 1L;
    
    private Integer numeroPoliza;

    public GetPolizaIn() {
        super();
    }
    

    public GetPolizaIn(Integer numeroPoliza) {
        super();
        this.numeroPoliza = numeroPoliza;
    }


    public void setNumeroPoliza(Integer numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public Integer getNumeroPoliza() {
        return numeroPoliza;
    }
}
