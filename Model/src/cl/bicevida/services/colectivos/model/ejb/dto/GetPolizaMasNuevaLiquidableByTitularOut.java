package cl.bicevida.services.colectivos.model.ejb.dto;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GetPolizaMasNuevaLiquidableByTitularOut implements Serializable {
    @SuppressWarnings("compatibility")
    private static final long serialVersionUID = 1L;
    
    private List <PolizaDTO> polizaList;


    public GetPolizaMasNuevaLiquidableByTitularOut() {
        super();
    }

    public GetPolizaMasNuevaLiquidableByTitularOut(List<PolizaDTO> polizaList) {
        super();
        this.polizaList = polizaList;
    }


    public void setPolizaList(List<PolizaDTO> polizaList) {
        this.polizaList = polizaList;
    }

    public List<PolizaDTO> getPolizaList() {
        return polizaList;
    }
    
    public void addPoliza(PolizaDTO poliza) {
        if (polizaList == null)
            polizaList = new ArrayList <PolizaDTO> ();
        polizaList.add(poliza);
    }
}
