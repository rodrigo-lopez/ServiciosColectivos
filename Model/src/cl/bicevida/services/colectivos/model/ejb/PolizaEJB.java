package cl.bicevida.services.colectivos.model.ejb;

import cl.bicevida.services.colectivos.model.ejb.dto.GetPolizaIn;
import cl.bicevida.services.colectivos.model.ejb.dto.GetPolizaOut;

import javax.ejb.Remote;

@Remote
public interface PolizaEJB {
    GetPolizaOut getPoliza(GetPolizaIn gpIn);
}
