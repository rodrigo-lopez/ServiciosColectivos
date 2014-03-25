package cl.bicevida.services.colectivos.model.ejb;

import cl.bicevida.services.colectivos.model.ejb.dto.PreCalcularIn;
import cl.bicevida.services.colectivos.model.ejb.dto.PreCalcularOut;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless(name = "LiquidacionEJB", mappedName = "ServiciosColectivos-LiquidacionEJB")
public class LiquidacionEJBBean implements LiquidacionEJB {
    @Resource
    SessionContext sessionContext;

    public LiquidacionEJBBean() {
    }
    
    public PreCalcularOut preCalcular(PreCalcularIn pcIn) {
        PreCalcularOut result = new PreCalcularOut();
        
        return result;
    }
    
    public void verificar(PreCalcularIn pcIn) {
        
    }
}
