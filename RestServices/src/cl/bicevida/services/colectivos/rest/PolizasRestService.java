package cl.bicevida.services.colectivos.rest;

import cl.bicevida.services.colectivos.model.ejb.PolizaEJB;
import cl.bicevida.services.colectivos.model.ejb.dto.GetPolizaIn;
import cl.bicevida.services.colectivos.model.ejb.dto.GetPolizaOut;
import cl.bicevida.services.colectivos.model.ejb.dto.PolizaDTO;

import java.util.ArrayList;
import java.util.Hashtable;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("polizas")
public class PolizasRestService {
    public PolizasRestService() {
        super();
    }

    @GET
    @Path("{numeroPoliza}")
    @Produces({"application/json", "application/xml"})
    public PolizaDTO getPoliza(@PathParam("numeroPoliza") Integer x) throws NamingException {
        final Context context = getInitialContext();
        PolizaEJB polizaEJB =
            (PolizaEJB)context.lookup("TestLiquidadorWeb-PolizaEJB#cl.bicevida.liquidadorweb.model.ejb.PolizaEJB");
        
        GetPolizaIn gpIn = new GetPolizaIn();
        gpIn.setNumeroPoliza(x);
        GetPolizaOut result = polizaEJB.getPoliza(gpIn);
        return result.getPoliza();            
    }
    
    @GET
    @Path("test")
    public List <String> getList() {
        List <String> result = new ArrayList <String>();
        result.add("hola");
        return result;
    }

    private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        // WebLogic Server 10.x connection details
        env.put( Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory" );
        env.put(Context.PROVIDER_URL, "t3://localhost:7101");
        return new InitialContext( env );
    }
}

