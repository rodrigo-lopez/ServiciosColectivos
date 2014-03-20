package cl.bicevida.services.colectivos.model.ejb.dto;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GetGrupoFamiliarOut implements Serializable {
    @SuppressWarnings("compatibility")
    private static final long serialVersionUID = 1L;
    
    private List <AseguradoDTO> aseguradoList;

    public GetGrupoFamiliarOut() {
        super();
    }

    public GetGrupoFamiliarOut(List<AseguradoDTO> aseguradoList) {
        super();
        this.aseguradoList = aseguradoList;
    }


    public void setAseguradoList(List<AseguradoDTO> aseguradoList) {
        this.aseguradoList = aseguradoList;
    }

    public List<AseguradoDTO> getAseguradoList() {
        return aseguradoList;
    }
    
    public void addAsegurado(AseguradoDTO asegurado) {
        if (aseguradoList == null)
            aseguradoList = new ArrayList <AseguradoDTO> ();
        aseguradoList.add(asegurado);
    }    
}
