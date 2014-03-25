package cl.bicevida.services.exceptions;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class BusinessException extends WebApplicationException {
    private static final long serialVersionUID = 1L;
    private List <String> message = new ArrayList <String>();
    private Throwable cause;
    
    public BusinessException(String message, Throwable cause) {
        super();        
        this.message.add(message);
        this.message.add(cause.getMessage());
    }    
    
    public BusinessException(String message) {
        super();        
        this.message.add(message);
    }        

    
    @Override
    public Response getResponse() {
        Response.Status httpStatus = null;
        if (cause == null)
            httpStatus = Response.Status.BAD_REQUEST;
        else
            httpStatus = Response.Status.INTERNAL_SERVER_ERROR;
        return Response.status(httpStatus).entity(message).build();
    }
}
