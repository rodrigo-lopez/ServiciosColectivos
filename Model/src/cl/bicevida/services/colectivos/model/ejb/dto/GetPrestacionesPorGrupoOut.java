package cl.bicevida.services.colectivos.model.ejb.dto;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GetPrestacionesPorGrupoOut implements Serializable {
    @SuppressWarnings("compatibility")
    private static final long serialVersionUID = 1L;
    
    private PolizaDTO poliza;
    private GrupoDTO grupo;
    private List <PlanPrestacionDTO> planPrestacionList;
    
    public GetPrestacionesPorGrupoOut() {
        super();
    }


    public GetPrestacionesPorGrupoOut(PolizaDTO poliza, GrupoDTO grupo, List<PlanPrestacionDTO> planPrestacionList) {
        super();
        this.poliza = poliza;
        this.grupo = grupo;
        this.planPrestacionList = planPrestacionList;
    }


    public void setPoliza(PolizaDTO poliza) {
        this.poliza = poliza;
    }

    public PolizaDTO getPoliza() {
        return poliza;
    }

    public void setGrupo(GrupoDTO grupo) {
        this.grupo = grupo;
    }

    public GrupoDTO getGrupo() {
        return grupo;
    }

    public void setPlanPrestacionList(List<PlanPrestacionDTO> planPrestacionList) {
        this.planPrestacionList = planPrestacionList;
    }

    public List<PlanPrestacionDTO> getPlanPrestacionList() {
        return planPrestacionList;
    }
    
    public void addPlanPrestacion(PlanPrestacionDTO planPrestacion) {
        if (planPrestacionList == null)
            planPrestacionList = new ArrayList <PlanPrestacionDTO>();
        planPrestacionList.add(planPrestacion);
    }    
}
