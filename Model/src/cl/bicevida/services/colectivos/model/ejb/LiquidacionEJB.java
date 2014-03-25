package cl.bicevida.services.colectivos.model.ejb;

import cl.bicevida.services.colectivos.model.ejb.dto.PreCalcularIn;
import cl.bicevida.services.colectivos.model.ejb.dto.PreCalcularOut;

import javax.ejb.Remote;

@Remote
public interface LiquidacionEJB {
    PreCalcularOut preCalcular(PreCalcularIn pcIn);
}
