package cl.bicevida.services.colectivos.model.ejb.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GetPolizaMasNuevaLiquidableByTitularIn implements Serializable {
    @SuppressWarnings("compatibility")
    private static final long serialVersionUID = 1L;
    
    private String rutAsegurado;
    private String fechaAtencion;
    private String rutUsuario;

    public GetPolizaMasNuevaLiquidableByTitularIn() {
        super();
    }

    public GetPolizaMasNuevaLiquidableByTitularIn(String rutAsegurado, String fechaAtencion, String rutUsuario) {
        super();
        this.rutAsegurado = rutAsegurado;
        this.fechaAtencion = fechaAtencion;
        this.rutUsuario = rutUsuario;
    }

    public void setRutAsegurado(String rutAsegurado) {
        this.rutAsegurado = rutAsegurado;
    }

    public String getRutAsegurado() {
        return rutAsegurado;
    }
    
    public void setFechaAtencion(String fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public String getFechaAtencion() {
        return fechaAtencion;
    }
    
    public void setRutUsuario(String rutUsuario) {
        this.rutUsuario = rutUsuario;
    }

    public String getRutUsuario() {
        return rutUsuario;
    }
}
