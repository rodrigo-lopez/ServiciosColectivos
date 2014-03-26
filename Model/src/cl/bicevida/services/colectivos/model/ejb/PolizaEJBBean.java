package cl.bicevida.services.colectivos.model.ejb;

import cl.bicevida.services.colectivos.model.ejb.dto.AseguradoDTO;
import cl.bicevida.services.colectivos.model.ejb.dto.ContratanteDTO;
import cl.bicevida.services.colectivos.model.ejb.dto.EmpleadorDTO;
import cl.bicevida.services.colectivos.model.ejb.dto.GetGrupoFamiliarIn;
import cl.bicevida.services.colectivos.model.ejb.dto.GetGrupoFamiliarOut;
import cl.bicevida.services.colectivos.model.ejb.dto.GetPolizaIn;
import cl.bicevida.services.colectivos.model.ejb.dto.GetPolizaOut;
import cl.bicevida.services.colectivos.model.ejb.dto.GetPolizaMasNuevaLiquidableByTitularIn;
import cl.bicevida.services.colectivos.model.ejb.dto.GetPolizaMasNuevaLiquidableByTitularOut;
import cl.bicevida.services.colectivos.model.ejb.dto.GetPrestacionesPorGrupoIn;
import cl.bicevida.services.colectivos.model.ejb.dto.GetPrestacionesPorGrupoOut;
import cl.bicevida.services.colectivos.model.ejb.dto.GrupoDTO;
import cl.bicevida.services.colectivos.model.ejb.dto.PlanPrestacionDTO;
import cl.bicevida.services.colectivos.model.ejb.dto.PolizaDTO;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import java.util.Calendar;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;

@Stateless(name = "PolizaEJB", mappedName = "ServiciosColectivos-PolizaEJB")
public class PolizaEJBBean implements PolizaEJB {
    @Resource
    SessionContext sessionContext;
    @Resource(mappedName = "jdbc/ruda/bicevidanet")
    DataSource ds;
    
    public PolizaEJBBean() {
    }
    
    
    private static PolizaDTO mapeoPoliza(ResultSet rs) throws SQLException {
        PolizaDTO poliza = new PolizaDTO();
        Calendar cal = null;
        Date fecha = null;
        poliza.setNumeroPoliza(rs.getInt("numero_poliza"));
        try {
            fecha = rs.getDate("pol_inicio_vigencia");
            cal = Calendar.getInstance();
            cal.setTime(fecha);
            poliza.setInicioVigencia(cal);
        } catch(SQLException e) {;}
        
        try{
            fecha = rs.getDate("pol_termino_vigencia");
            cal = Calendar.getInstance();
            cal.setTime(fecha);
            poliza.setTerminoVigencia(cal);
        } catch(SQLException e) {;}

        ContratanteDTO contratante = new ContratanteDTO();
        try {
            contratante.setRut(rs.getInt("con_rut") + "-" + rs.getString("con_dv"));
        } catch (SQLException e) {
            ;
        }
        try {
            contratante.setNombre(rs.getString("con_razon_social"));
        } catch (SQLException e) {
            ;
        }                
        poliza.setContratante(contratante);
        
        EmpleadorDTO empleador = new EmpleadorDTO();
        try {
            empleador.setRut(rs.getInt("emp_rut") + "-" + rs.getString("emp_dv"));
        } catch (SQLException e) {
            ;
        }
        try {
            empleador.setNombre(rs.getString("emp_razon_social"));
        } catch (SQLException e) {
            ;
        }                
        poliza.setEmpleador(empleador);        
        return poliza;
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
            while (rs.next()) {
                poliza = mapeoPoliza(rs);
            }
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
    
    /*Devuelve las pólizas vigentes del asegurado titular*/
    public GetPolizaMasNuevaLiquidableByTitularOut getPolizaMasNuevaLiquidableByTitular(GetPolizaMasNuevaLiquidableByTitularIn gpvbtIn) {
        GetPolizaMasNuevaLiquidableByTitularOut result = new GetPolizaMasNuevaLiquidableByTitularOut();
        Connection conn = null;
        PolizaDTO poliza = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        Integer iRut = null;
        
        iRut = Integer.parseInt(gpvbtIn.getRut().split("-")[0]);
        try {
            conn = ds.getConnection();
            stmt = conn.prepareCall("{call Bicevidanet.Mll_Pkg_Consultas.Get_Pol_Vig_Ase_Tit(?, ?)}");
            stmt.setObject("P_RUT", iRut);
            stmt.registerOutParameter("P_CUR", OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet)stmt.getObject("P_CUR");
            while (rs.next()) {
                poliza = mapeoPoliza(rs);
                result.setPoliza(poliza);
            }            
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
    
    
    private static AseguradoDTO mapeoAsegurado(ResultSet rs) throws SQLException {
        AseguradoDTO asegurado = new AseguradoDTO();
        asegurado.setDv(rs.getString("dv_carga"));
        Calendar cal = null;
        if (rs.getDate("ase_fecha_exclusion") != null) {
            cal = Calendar.getInstance();
            cal.setTime(rs.getDate("ase_fecha_exclusion"));
            asegurado.setFechaExclusion(cal);
        }
        if (rs.getDate("ase_fecha_incorporacion") != null) {
            cal = Calendar.getInstance();
            cal.setTime(rs.getDate("ase_fecha_incorporacion"));
            asegurado.setFechaIncorporacion(cal);
        }
        
        if (rs.getDate("ase_vigencia_desde") != null) {
            cal = Calendar.getInstance();
            cal.setTime(rs.getDate("ase_vigencia_desde"));
            asegurado.setInicioVigencia(cal);
        }
        
        asegurado.setNombre(rs.getString("Ase_Nombre_Pila"));
        asegurado.setNombreCompleto(rs.getString("ase_nombre"));
        asegurado.setNumeroAsegurado(rs.getInt("ase_numero"));
        asegurado.setNumeroCarga(rs.getInt("car_numero"));
        asegurado.setPrimerApellido(rs.getString("ase_primer_apellido"));
        asegurado.setRelacion(rs.getString("ase_relacion"));
        asegurado.setRut(rs.getInt("rut_carga"));
        asegurado.setSegundoApellido(rs.getString("ase_segundo_apellido"));
        asegurado.setSexo(rs.getString("ase_sexo"));
        
        if (rs.getDate("ase_vigencia_hasta") != null) {
            cal = Calendar.getInstance();
            cal.setTime(rs.getDate("ase_vigencia_hasta"));
            asegurado.setTerminoVigencia(cal);
        }
        
        asegurado.setNumeroGrupo(rs.getInt("grp_numero"));
        
        return asegurado;
    }
    
    
    public GetGrupoFamiliarOut getGrupoFamiliar(GetGrupoFamiliarIn ggfIn) {
        GetGrupoFamiliarOut result = new GetGrupoFamiliarOut();
        Connection conn = null;
        PreparedStatement stmt = null;
        AseguradoDTO asegurado = null;
        ResultSet rs = null;
        Integer iRut = null;
        
        
        iRut = Integer.parseInt(ggfIn.getRutAsegurado().split("-")[0]);
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(                
                "Select \n" + 
                "  Trim(Substr(Ase_Nombre, 1, Instr(Ase_Nombre, '+', 1, 1)-1)) As Ase_Primer_Apellido, \n" + 
                "  Trim(Substr(Ase_Nombre, Instr(Ase_Nombre, '+', 1, 1)+1, Instr(Ase_Nombre, '+', 1, 2) - Instr(Ase_Nombre, '+', 1, 1)-1)) As Ase_Segundo_Apellido, \n" + 
                "  Trim(Substr(Ase_Nombre, Instr(Ase_Nombre, '+', 1, 2)+1, Length(Ase_Nombre) - Instr(Ase_Nombre, '+', 1, 2))) As Ase_Nombre_Pila, \n" + 
                "  A1.*\n" + 
                "From Bicevidanet.Bvnet_Vw_Asegurado_Salud a1\n" + 
                "Where \n" + 
                " Pol_Prefijo = ? And Pol_Numero = ? And Pol_Secuencia = ?\n" + 
                " And Ase_Numero = (\n" + 
                "    Select Ase_Numero \n" + 
                "    From Bicevidanet.Bvnet_Vw_Asegurado_Salud A2 \n" + 
                "    Where A1.Pol_Prefijo = A2.Pol_Prefijo	And A1.Pol_Numero = A2.Pol_Numero	And A1.Pol_Secuencia = A2.Pol_Secuencia And A1.Grp_Numero = A2.Grp_Numero\n" + 
                "    And A2.Car_Numero = 0 And A2.Ase_Rut = ?\n" + 
                " )\n" +
                "Order by A1.car_numero"
            );
            stmt.setInt(1, ggfIn.getPrefijoPoliza());
            stmt.setInt(2, ggfIn.getNumeroPoliza());
            stmt.setInt(3, ggfIn.getSecuenciaPoliza());
            stmt.setInt(4, iRut);
            rs = stmt.executeQuery();
            while (rs.next()) {
                asegurado = mapeoAsegurado(rs);
                result.addAsegurado(asegurado);
            }            
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
    
    
    public GetPrestacionesPorGrupoOut getPlanPrestacionAsegurado(GetPrestacionesPorGrupoIn gppgIn) {
        GetPrestacionesPorGrupoOut result = new GetPrestacionesPorGrupoOut();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = "Select \n" + 
                "  Pol.Pol_Prefijo, Pol.Pol_Numero, Pol.Pol_Secuencia, Pol.Poliza as Numero_Poliza, \n" + 
                "  G.Grupo as grp_numero, \n" +
                "  G.Nombre_Grupo, \n" + 
                "  PlAs.descripcion_de_plan,\n" + 
                "  Pre.Descripcion_De_Prestacion,\n" + 
                "  Pre.Prestacion_Por_Defecto,\n" + 
                "  Pre.Flag_Reembolso_Diferenciado,\n" + 
                "  PlPre.*  \n" + 
                "From Salud.Polizas Pol\n" + 
                "Join Salud.Grupos G \n" + 
                "  On Pol.poliza = G.Poliza\n" + 
                "Join Salud.Planes PlAs\n";
                if (gppgIn.getTipoBeneficiario().equalsIgnoreCase("AS")) {
                    query = query + "  On G.Plan_Para_Asegurados = PlAs.Plan\n";
                } else {
                    query = query + "  On G.Plan_Para_Cargas = PlAs.Plan\n";
                }
                query = query + "Join Salud.Plan_Prestaciones PlPre\n" + 
                "  On PlAs.Plan = PlPre.Plan\n" + 
                "Join Salud.Prestaciones Pre\n" + 
                "  On PlPre.Prestacion = Pre.Prestacion\n" + 
                "Where \n" + 
                "  Pol.pol_prefijo = ? and pol.pol_numero = ? and pol.pol_secuencia = ?\n" + 
                "  And\n" + 
                "  G.Grupo = ?\n" + 
                "  And\n" + 
                "  Pre.Prestacion_Basica In ('AMB', 'HOS')\n" + 
                "Order By Pre.Prestacion"
        ;
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, gppgIn.getPrefijoPoliza());
            stmt.setInt(2, gppgIn.getNumeroPoliza());
            stmt.setInt(3, gppgIn.getSecuenciaPoliza());
            stmt.setInt(4, gppgIn.getNumeroGrupo());
            rs = stmt.executeQuery();
            while (rs.next()) {
                PolizaDTO poliza = mapeoPoliza(rs);
                GrupoDTO grupo = mapeoGrupo(rs);
                PlanPrestacionDTO planPrestacion = mapeoPlanPrestacion(rs);
                result.setPoliza(poliza);
                result.setGrupo(grupo);
                result.addPlanPrestacion(planPrestacion);
            }            
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

    private GrupoDTO mapeoGrupo(ResultSet rs) throws SQLException {
        GrupoDTO grupo = new GrupoDTO();
        grupo.setNumero(rs.getInt("grp_numero"));
        grupo.setNombre(rs.getString("Nombre_Grupo"));
        return grupo;
    }

    private PlanPrestacionDTO mapeoPlanPrestacion(ResultSet rs) throws SQLException {
        PlanPrestacionDTO result = new PlanPrestacionDTO();
        result.setCodigoPlan(rs.getString("plan"));
        result.setCodigoPrestacion(rs.getString("prestacion"));
        result.setNombrePlan(rs.getString("descripcion_de_plan"));
        result.setNombrePrestacion(rs.getString("descripcion_de_prestacion"));
        return result;
    }
}
