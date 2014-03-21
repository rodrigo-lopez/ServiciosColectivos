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
    /*
    private String rutTitular;
    private Integer numeroCarga;
    */
    
    
    public GetPrestacionesPorGrupoIn() {
        super();
    }


    public GetPrestacionesPorGrupoIn(Integer prefijoPoliza, Integer numeroPoliza, Integer secuenciaPoliza,
                                     Integer numeroGrupo, String tipoBeneficiario) {
        super();
        this.prefijoPoliza = prefijoPoliza;
        this.numeroPoliza = numeroPoliza;
        this.secuenciaPoliza = secuenciaPoliza;
        this.numeroGrupo = numeroGrupo;
        this.tipoBeneficiario = tipoBeneficiario;
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
}
