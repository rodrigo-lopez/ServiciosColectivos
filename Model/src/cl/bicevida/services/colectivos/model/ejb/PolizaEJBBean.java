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
            contratante.setRut(rs.getString("Rut_Contratante") + "-" + rs.getString("con_dv"));
            //contratante.setRut(rs.getInt("con_rut") + "-" + rs.getString("con_dv"));
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
            empleador.setRut(rs.getString("Rut_Empleador") + "-" + rs.getString("emp_dv"));
            //empleador.setRut(rs.getInt("emp_rut") + "-" + rs.getString("emp_dv"));
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
    

    public GetPolizaMasNuevaLiquidableByTitularOut getPolizaMasNuevaLiquidableByTitular(GetPolizaMasNuevaLiquidableByTitularIn gpvbtIn) {
        GetPolizaMasNuevaLiquidableByTitularOut result = new GetPolizaMasNuevaLiquidableByTitularOut();
        Connection conn = null;
        PolizaDTO poliza = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        Integer iRutTitular = null;
        Integer iRutUsuario = null;

        iRutTitular = Integer.parseInt(gpvbtIn.getRutAsegurado().split("-")[0].replace(".", ""));
        iRutUsuario = Integer.parseInt(gpvbtIn.getRutUsuario().split("-")[0].replace(".", ""));
        
        try {
            conn = ds.getConnection();
            stmt = conn.prepareCall("{call Bicevidanet.Mll_Pkg_Consultas.Get_Pol_Vig_Ase_Tit(?, ?, ?)}");
            stmt.setObject("P_RUT", iRutTitular);
            stmt.setObject("P_RUT_USUARIO", iRutUsuario);
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
        asegurado.setRelacion(rs.getString("relacion"));
        asegurado.setRut(rs.getInt("rut_carga"));
        asegurado.setRutCarga(rs.getString("Rut_Cargas"));
        asegurado.setSegundoApellido(rs.getString("ase_segundo_apellido"));
        asegurado.setSexo(rs.getString("ase_sexo"));
        asegurado.setPolNumero(rs.getInt("Pol_numero"));
        asegurado.setPolPrefijo(rs.getInt("Pol_Prefijo"));
        asegurado.setPolSecuencia(rs.getInt("Pol_Secuencia"));


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
        CallableStatement stmt = null;
        AseguradoDTO asegurado = null;
        ResultSet rs = null;
        Integer iRutTitular = null;
        String fechaAtencion = null;

        iRutTitular = Integer.parseInt(ggfIn.getRutAsegurado().split("-")[0].replace(".",""));
        fechaAtencion = ggfIn.getFechaAtencion();
        try {            
            conn = ds.getConnection();
            stmt = conn.prepareCall("{call Bicevidanet.Mll_Pkg_Consultas.Get_Grupo_Familiar_Fechas(?, ?, ?)}");
            stmt.setObject("P_RUT", iRutTitular);
            stmt.setObject("P_FECHA_ATENCION",fechaAtencion);
            stmt.registerOutParameter("P_CUR", OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet)stmt.getObject("P_CUR");
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
        CallableStatement stmt = null;
        ResultSet rs = null;
        
        Integer prefijoPoliza = null;
        Integer numeroPoliza = null;
        Integer secuenciaPoliza = null;
        Integer numeroGrupo = null;
        Integer numeroAsegurado = null;
        Integer numeroCarga = null;
        
        prefijoPoliza = gppgIn.getPrefijoPoliza();
        numeroPoliza = gppgIn.getNumeroPoliza();
        secuenciaPoliza = gppgIn.getSecuenciaPoliza();
        numeroGrupo = gppgIn.getNumeroGrupo();
        numeroAsegurado = gppgIn.getNumeroAsegurado();
        numeroCarga = gppgIn.getNumeroCarga();
        

        try {   
            conn = ds.getConnection();
            stmt = conn.prepareCall("{call Bicevidanet.Mll_Pkg_Consultas.Get_Plan_Prestacion_Asegu(?, ?, ?, ?, ?, ?, ?)}");
            stmt.setObject("P_Pol_Prefijo",prefijoPoliza);
            stmt.setObject("P_Pol_Numero",numeroPoliza);
            stmt.setObject("P_Pol_Secuencia",secuenciaPoliza);
            stmt.setObject("P_Grupo",numeroGrupo);
            stmt.setObject("P_Numero_Ase_Tit",numeroAsegurado);
            stmt.setObject("P_Numero_Carga",numeroCarga);
            stmt.registerOutParameter("P_CUR", OracleTypes.CURSOR);
            stmt.execute();
            rs = (ResultSet)stmt.getObject("P_CUR");
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
