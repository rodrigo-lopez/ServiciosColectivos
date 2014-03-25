package cl.bicevida.services.colectivos.model.ejb.dto;

import java.util.List;

public class PreCalcularIn {
    private PolizaDTO poliza;
    private AseguradoDTO asegurado;
    private List <ReclamoDTO> reclamoList;

    public PreCalcularIn(PolizaDTO poliza, AseguradoDTO asegurado, List<ReclamoDTO> reclamoList) {
        super();
        this.poliza = poliza;
        this.asegurado = asegurado;
        this.reclamoList = reclamoList;
    }


    public void setPoliza(PolizaDTO poliza) {
        this.poliza = poliza;
    }

    public PolizaDTO getPoliza() {
        return poliza;
    }

    public void setAsegurado(AseguradoDTO asegurado) {
        this.asegurado = asegurado;
    }

    public AseguradoDTO getAsegurado() {
        return asegurado;
    }

    public void setReclamoList(List<ReclamoDTO> reclamoList) {
        this.reclamoList = reclamoList;
    }

    public List<ReclamoDTO> getReclamoList() {
        return reclamoList;
    }
}
