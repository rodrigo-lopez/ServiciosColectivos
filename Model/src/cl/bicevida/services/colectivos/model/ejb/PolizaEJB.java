package cl.bicevida.services.colectivos.model.ejb;

import cl.bicevida.services.colectivos.model.ejb.dto.GetGrupoFamiliarIn;
import cl.bicevida.services.colectivos.model.ejb.dto.GetGrupoFamiliarOut;
import cl.bicevida.services.colectivos.model.ejb.dto.GetPolizaIn;
import cl.bicevida.services.colectivos.model.ejb.dto.GetPolizaOut;

import cl.bicevida.services.colectivos.model.ejb.dto.GetPolizaMasNuevaLiquidableByTitularIn;
import cl.bicevida.services.colectivos.model.ejb.dto.GetPolizaMasNuevaLiquidableByTitularOut;

import cl.bicevida.services.colectivos.model.ejb.dto.GetPrestacionesPorGrupoIn;
import cl.bicevida.services.colectivos.model.ejb.dto.GetPrestacionesPorGrupoOut;

import javax.ejb.Remote;

@Remote
public interface PolizaEJB {
    GetPolizaOut getPoliza(GetPolizaIn gpIn);

    GetPolizaMasNuevaLiquidableByTitularOut getPolizaMasNuevaLiquidableByTitular(GetPolizaMasNuevaLiquidableByTitularIn gpvbtIn);

    GetGrupoFamiliarOut getGrupoFamiliar(GetGrupoFamiliarIn ggfIn);

    GetPrestacionesPorGrupoOut getPlanPrestacionAsegurado(GetPrestacionesPorGrupoIn gppgIn);
}
