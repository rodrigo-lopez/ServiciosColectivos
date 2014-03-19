package cl.bicevida.services.colectivos.model;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless(name = "PolizaEJB", mappedName = "ServiciosColectivos-PolizaEJB")
public class PolizaEJBBean implements PolizaEJB {
    @Resource
    SessionContext sessionContext;

    public PolizaEJBBean() {
        /**hola*/
    }
    
    
}
