package cl.bicevida.services.colectivos.model.ejb;

import cl.bicevida.services.colectivos.model.ejb.dto.ContratanteDTO;
import cl.bicevida.services.colectivos.model.ejb.dto.EmpleadorDTO;
import cl.bicevida.services.colectivos.model.ejb.dto.GetPolizaIn;
import cl.bicevida.services.colectivos.model.ejb.dto.GetPolizaOut;
import cl.bicevida.services.colectivos.model.ejb.dto.PolizaDTO;

import java.sql.Connection;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import java.util.Calendar;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.sql.DataSource;

@Stateless(name = "PolizaEJB", mappedName = "TestLiquidadorWeb-PolizaEJB")
public class PolizaEJBBean implements PolizaEJB {
    @Resource
    SessionContext sessionContext;
    @Resource(mappedName = "jdbc/ruda/bicevidanet")
    DataSource ds;
    
    public PolizaEJBBean() {
    }
    
    public GetPolizaOut getPoliza(GetPolizaIn gpIn) {
        GetPolizaOut result = new GetPolizaOut();
        Connection conn = null;
        PolizaDTO poliza = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = ds.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(
                "Select Cast(Pol_Prefijo || Pol_Numero || Lpad(Pol_Secuencia, 2, '0') as Integer) as numero_poliza, p.*\n" + 
                "From Bvnet_Vw_Poliza_Salud p\n" + 
                "Where Pol_Prefijo || Pol_Numero || Lpad(Pol_Secuencia, 2, '0') = " + gpIn.getNumeroPoliza()
            );
            poliza = new PolizaDTO();
            while (rs.next()) {
                poliza.setNumeroPoliza(rs.getInt("numero_poliza"));
                Date fecha = rs.getDate("pol_inicio_vigencia");
                Calendar cal = Calendar.getInstance();
                cal.setTime(fecha);
                poliza.setInicioVigencia(cal);
                fecha = rs.getDate("pol_termino_vigencia");
                cal = Calendar.getInstance();
                cal.setTime(fecha);
                poliza.setTerminoVigencia(cal);
                poliza.setContratante(new ContratanteDTO(rs.getInt("con_rut") +"-"+ rs.getString("con_dv"), rs.getString("con_razon_social")));                
            }
            
            //poliza.addEmpleador(new EmpleadorDTO("1-1", "test"));
            result.setPoliza(poliza);
        } catch (SQLException e) {
            e.printStackTrace();            
        } finally {
            if (rs != null)
                try {rs.close();} catch (SQLException e) {;}
            if(stmt != null)
                try {stmt.close();} catch (SQLException e) {;}                
            if(conn != null)
                try {conn.close();} catch (SQLException e) {;}                            
        }
        return result;
    }
}
