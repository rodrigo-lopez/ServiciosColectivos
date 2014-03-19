package cl.bicevida.services.colectivos.model.ejb.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ContratanteDTO implements Serializable {
    @SuppressWarnings("compatibility")
    private static final long serialVersionUID = 1L;
    
    private String rut;
    private String nombre;

    public ContratanteDTO() {
        super();
    }

    public ContratanteDTO(String rut, String nombre) {
        super();
        this.rut = rut;
        this.nombre = nombre;
    }


    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getRut() {
        return rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ContratanteDTO)) {
            return false;
        }
        final ContratanteDTO other = (ContratanteDTO)object;
        if (!(rut == null ? other.rut == null : rut.equals(other.rut))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 37;
        int result = 1;
        result = PRIME * result + ((rut == null) ? 0 : rut.hashCode());
        return result;
    }
}

