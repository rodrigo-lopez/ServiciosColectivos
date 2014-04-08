package cl.bicevida.services.colectivos.model;

import cl.bicevida.services.colectivos.model.ejb.PolizaEJB;

import java.util.Hashtable;

import javax.naming.CommunicationException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class PolizaEJBClient1 {
    public static void main(String[] args) {
        try {
            final Context context = getInitialContext();
            PolizaEJB polizaEJB =
                (PolizaEJB)context.lookup("ServiciosColectivos-PolizaEJB#cl.bicevida.services.colectivos.model.ejb.PolizaEJB");
        } catch (CommunicationException ex) {
            System.out.println(ex.getClass().getName());
            System.out.println(ex.getRootCause().getLocalizedMessage());
            System.out.println("\n*** A CommunicationException was raised.  This typically\n*** occurs when the target WebLogic server is not running.\n");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        // WebLogic Server 10.x connection details
        env.put( Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory" );
        env.put(Context.PROVIDER_URL, "t3://aplicaciones-desa.bicevida.cl:8701");
        return new InitialContext( env );
    }
}
