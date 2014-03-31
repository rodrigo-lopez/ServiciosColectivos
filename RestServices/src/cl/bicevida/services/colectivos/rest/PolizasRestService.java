package cl.bicevida.services.colectivos.rest;

import cl.bicevida.services.colectivos.model.ejb.PolizaEJB;
import cl.bicevida.services.colectivos.model.ejb.dto.AseguradoDTO;
import cl.bicevida.services.colectivos.model.ejb.dto.GetGrupoFamiliarIn;
import cl.bicevida.services.colectivos.model.ejb.dto.GetGrupoFamiliarOut;
import cl.bicevida.services.colectivos.model.ejb.dto.GetPolizaIn;
import cl.bicevida.services.colectivos.model.ejb.dto.GetPolizaOut;
import cl.bicevida.services.colectivos.model.ejb.dto.GetPolizaMasNuevaLiquidableByTitularIn;
import cl.bicevida.services.colectivos.model.ejb.dto.GetPolizaMasNuevaLiquidableByTitularOut;
import cl.bicevida.services.colectivos.model.ejb.dto.GetPrestacionesPorGrupoIn;
import cl.bicevida.services.colectivos.model.ejb.dto.GetPrestacionesPorGrupoOut;
import cl.bicevida.services.colectivos.model.ejb.dto.PolizaDTO;

import java.util.ArrayList;
import java.util.Hashtable;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import cl.bicevida.services.exceptions.BusinessException;

@Path("polizas")
public class PolizasRestService {
    private static PolizaEJB polizaEJB;
    
    @javax.ws.rs.core.Context 
    HttpServletRequest request;
    @javax.ws.rs.core.Context 
    HttpServletResponse response;
    
    
    public PolizasRestService() throws BusinessException {
        super();
        final Context context;
        try {
            context = getInitialContext();
            polizaEJB = (PolizaEJB)context.lookup("ServiciosColectivos-PolizaEJB#cl.bicevida.services.colectivos.model.ejb.PolizaEJB");        
        } catch (NamingException e) {
            throw new BusinessException("Imposible establecer comunicación con el servicio", e);
        }
        
    }

    @GET
    @Path("titular/{rutAsegurado}/{fechaAtencion}/{rutUsuario}")
    @Produces({"application/json", "application/xml"})
    public PolizaDTO getPolizaMasNuevaLiquidableByTitular(
            @PathParam("rutAsegurado") String rutAsegurado, 
            @PathParam("fechaAtencion") String fechaAtencion,
            @PathParam("rutUsuario") String rutUsuario) throws NamingException {        
        response.addHeader("Access-Control-Allow-Origin", "http://127.0.0.1:9000");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        GetPolizaMasNuevaLiquidableByTitularIn in = new GetPolizaMasNuevaLiquidableByTitularIn();
        in.setRutAsegurado(rutAsegurado);
        in.setFechaAtencion(fechaAtencion);
        in.setRutUsuario(rutUsuario);
        GetPolizaMasNuevaLiquidableByTitularOut result = polizaEJB.getPolizaMasNuevaLiquidableByTitular(in);
        return result.getPoliza();
    }   
    
    @GET
    @Path("{numeroPoliza}")
    @Produces({"application/json", "application/xml"})
    public PolizaDTO getPoliza(@PathParam("numeroPoliza") Integer numeroPoliza) throws BusinessException {
        if (1==1)
            throw new BusinessException("Error!", new Exception("Más Error"));
        response.addHeader("Access-Control-Allow-Origin", "http://127.0.0.1:9000");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        GetPolizaIn gpIn = new GetPolizaIn();
        gpIn.setNumeroPoliza(numeroPoliza);
        GetPolizaOut result = polizaEJB.getPoliza(gpIn);
        return result.getPoliza();
    }
    
    @GET
    @Path("grupofamiliar/{numeroPoliza}/{rutAsegurado}/{fechaAtencion}")
    public List <AseguradoDTO> getGrupoFamiliar(
            @PathParam("numeroPoliza") Integer numeroPoliza, 
            @PathParam("rutAsegurado") String rutAsegurado, 
            @PathParam("fechaAtencion") String fechaAtencion) throws BusinessException{
        response.addHeader("Access-Control-Allow-Origin", "http://127.0.0.1:9000");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        GetGrupoFamiliarIn ggfIn = new GetGrupoFamiliarIn();
        ggfIn.setRutAsegurado(rutAsegurado);
        ggfIn.setFechaAtencion(fechaAtencion);
        
        String strNumPol = numeroPoliza.toString();
        ggfIn.setPrefijoPoliza(Integer.parseInt(strNumPol.substring(0,1)));
        ggfIn.setNumeroPoliza(Integer.parseInt(strNumPol.substring(1, strNumPol.length()-2)));
        ggfIn.setSecuenciaPoliza(Integer.parseInt(strNumPol.substring(strNumPol.length()-2)));
        
        GetGrupoFamiliarOut result = polizaEJB.getGrupoFamiliar(ggfIn);
        return result.getAseguradoList();
    }
    
    @GET
    @Path("planprestacion/{numeroPoliza}/{numeroGrupo}/{numeroAsegurado}/{numeroCarga}")
    public List getPlanPrestacion(
            @PathParam("numeroPoliza") Integer numeroPoliza,
            @PathParam("numeroGrupo") Integer numeroGrupo,
            @PathParam("numeroAsegurado") Integer numeroAsegurado,
            @PathParam("numeroCarga") Integer numeroCarga  
            )  throws BusinessException
    {
        response.addHeader("Access-Control-Allow-Origin", "http://127.0.0.1:9000");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        GetPrestacionesPorGrupoIn in = new GetPrestacionesPorGrupoIn();
        String strNumPol = numeroPoliza.toString();
        in.setPrefijoPoliza(Integer.parseInt(strNumPol.substring(0,1)));
        in.setNumeroPoliza(Integer.parseInt(strNumPol.substring(1, strNumPol.length()-2)));
        in.setSecuenciaPoliza(Integer.parseInt(strNumPol.substring(strNumPol.length()-2)));
        in.setNumeroGrupo(numeroGrupo);
        in.setNumeroAsegurado(numeroAsegurado);
        in.setNumeroCarga(numeroCarga);
        GetPrestacionesPorGrupoOut out = polizaEJB.getPlanPrestacionAsegurado(in);
        return out.getPlanPrestacionList();
    }
    
    
    @PUT
    @Path("test")
    public List <String> getList()  throws BusinessException {
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

