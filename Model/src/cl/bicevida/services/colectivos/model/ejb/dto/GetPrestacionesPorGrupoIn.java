package cl.bicevida.services.colectivos.model.ejb.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GetPrestacionesPorGrupoIn implements Serializable {
    @SuppressWarnings("compatibility")
    private static final long serialVersionUID = 1L;
    
    private Integer prefijoPoliza;
    private Integer numeroPoliza;
    private Integer secuenciaPoliza;
    private Integer numeroGrupo;
    private String tipoBeneficiario;
    private Integer numeroAsegurado;
    private Integer numeroCarga;
    private String terminoVigencia;
    /*
    private String rutTitular;
    private Integer numeroCarga;
    */
    
    
    public GetPrestacionesPorGrupoIn() {
        super();
    }


    public GetPrestacionesPorGrupoIn(Integer prefijoPoliza, Integer numeroPoliza, Integer secuenciaPoliza,
                                     Integer numeroGrupo, String tipoBeneficiario, Integer numeroAsegurado,
                                     Integer numeroCarga, String terminoVigencia) {
        super();
        this.prefijoPoliza = prefijoPoliza;
        this.numeroPoliza = numeroPoliza;
        this.secuenciaPoliza = secuenciaPoliza;
        this.numeroGrupo = numeroGrupo;
        this.tipoBeneficiario = tipoBeneficiario;
        this.numeroAsegurado = numeroAsegurado;
        this.numeroCarga = numeroCarga;
        this.terminoVigencia = terminoVigencia;
        
    }

    public void setPrefijoPoliza(Integer prefijoPoliza) {
        this.prefijoPoliza = prefijoPoliza;
    }

    public Integer getPrefijoPoliza() {
        return prefijoPoliza;
    }

    public void setNumeroPoliza(Integer numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public Integer getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setSecuenciaPoliza(Integer secuenciaPoliza) {
        this.secuenciaPoliza = secuenciaPoliza;
    }

    public Integer getSecuenciaPoliza() {
        return secuenciaPoliza;
    }

    public void setNumeroGrupo(Integer numeroGrupo) {
        this.numeroGrupo = numeroGrupo;
    }

    public Integer getNumeroGrupo() {
        return numeroGrupo;
    }


    public void setTipoBeneficiario(String tipoBeneficiario) {
        this.tipoBeneficiario = tipoBeneficiario;
    }

    public String getTipoBeneficiario() {
        return tipoBeneficiario;
    }
    
    public void setNumeroAsegurado(Integer numeroAsegurado) {
        this.numeroAsegurado = numeroAsegurado;
    }

    public Integer getNumeroAsegurado() {
        return numeroAsegurado;
    }

    public void setNumeroCarga(Integer numeroCarga) {
        this.numeroCarga = numeroCarga;
    }

    public Integer getNumeroCarga() {
        return numeroCarga;
    }

    public void setTerminoVigencia(String terminoVigencia) {
        this.terminoVigencia = terminoVigencia;
    }

    public String getTerminoVigencia() {
        return terminoVigencia;
    }
}
