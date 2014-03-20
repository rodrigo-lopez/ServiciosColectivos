package cl.bicevida.services.colectivos.model.ejb.dto;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PolizaDTO implements Serializable {
    @SuppressWarnings("compatibility")
    private static final long serialVersionUID = 1L;
    @Column(name="pol_numero_poliza")
    private Integer numeroPoliza;
    @Column(name="pol_inicio_vigencia")
    private Calendar inicioVigencia;
    @Column(name="pol_termino_vigencia")
    private Calendar terminoVigencia;
    private ContratanteDTO contratante;
    private EmpleadorDTO empleador;

    public PolizaDTO() {
        super();
    }

    public PolizaDTO(Integer numeroPoliza, Calendar inicioVigencia, Calendar terminoVigencia,
                     ContratanteDTO contratante, EmpleadorDTO empleador) {
        super();
        this.numeroPoliza = numeroPoliza;
        this.inicioVigencia = inicioVigencia;
        this.terminoVigencia = terminoVigencia;
        this.contratante = contratante;
        this.empleador = empleador;
    }


    public void setNumeroPoliza(Integer numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public Integer getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setInicioVigencia(Calendar inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public Calendar getInicioVigencia() {
        return inicioVigencia;
    }

    public void setTerminoVigencia(Calendar terminoVigencia) {
        this.terminoVigencia = terminoVigencia;
    }

    public Calendar getTerminoVigencia() {
        return terminoVigencia;
    }

    public void setContratante(ContratanteDTO contratante) {
        this.contratante = contratante;
    }

    public ContratanteDTO getContratante() {
        return contratante;
    }

    public void setEmpleador(EmpleadorDTO empleador) {
        this.empleador = empleador;
    }

    public EmpleadorDTO getEmpleador() {
        return empleador;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PolizaDTO)) {
            return false;
        }
        final PolizaDTO other = (PolizaDTO)object;
        if (!(numeroPoliza == null ? other.numeroPoliza == null : numeroPoliza.equals(other.numeroPoliza))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 37;
        int result = 1;
        result = PRIME * result + ((numeroPoliza == null) ? 0 : numeroPoliza.hashCode());
        return result;
    }
}
