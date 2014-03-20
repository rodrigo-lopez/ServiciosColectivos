package cl.bicevida.services.colectivos.model.ejb.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GrupoDTO implements Serializable {
    @SuppressWarnings("compatibility")
    private static final long serialVersionUID = 1L;
    
    private Integer numero;
    private String nombre;
    private Double topeIndemnizacion;
    private Double montoDefectoAsegurado;
    private Double montoDefectoCarga;
    private Double topeGrupoFamiliar;
    private String planAsegurados;
    private String planCargas;
    private Double deducible;
    private Double maximoDeducibles;
    private Integer diaPago;
    private Integer periodicidadPago;
    private Double pagoMinimo;
    private String deducibleIndividual;

    private String planCatastroficoAsegurado;
    private String planCatastroficoCarga;
    
    private Double topeMaximoAnualAseguradoCat;
    private Double topeMaximoAnualCargaCat;
    private Double montoActivacionCatastrofico;
    private Double montoMaximoEfectivo;    
    private Double topeDiario;    
    
    
    public GrupoDTO() {
        super();
    }


    public GrupoDTO(Integer numero, String nombre, Double topeIndemnizacion, Double montoDefectoAsegurado,
                    Double montoDefectoCarga, Double topeGrupoFamiliar, String planAsegurados, String planCargas,
                    Double deducible, Double maximoDeducibles, Integer diaPago, Integer periodicidadPago,
                    Double pagoMinimo, String deducibleIndividual, String planCatastroficoAsegurado,
                    String planCatastroficoCarga, Double topeMaximoAnualAseguradoCat, Double topeMaximoAnualCargaCat,
                    Double montoActivacionCatastrofico, Double montoMaximoEfectivo, Double topeDiario) {
        super();
        this.numero = numero;
        this.nombre = nombre;
        this.topeIndemnizacion = topeIndemnizacion;
        this.montoDefectoAsegurado = montoDefectoAsegurado;
        this.montoDefectoCarga = montoDefectoCarga;
        this.topeGrupoFamiliar = topeGrupoFamiliar;
        this.planAsegurados = planAsegurados;
        this.planCargas = planCargas;
        this.deducible = deducible;
        this.maximoDeducibles = maximoDeducibles;
        this.diaPago = diaPago;
        this.periodicidadPago = periodicidadPago;
        this.pagoMinimo = pagoMinimo;
        this.deducibleIndividual = deducibleIndividual;
        this.planCatastroficoAsegurado = planCatastroficoAsegurado;
        this.planCatastroficoCarga = planCatastroficoCarga;
        this.topeMaximoAnualAseguradoCat = topeMaximoAnualAseguradoCat;
        this.topeMaximoAnualCargaCat = topeMaximoAnualCargaCat;
        this.montoActivacionCatastrofico = montoActivacionCatastrofico;
        this.montoMaximoEfectivo = montoMaximoEfectivo;
        this.topeDiario = topeDiario;
    }


    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setTopeIndemnizacion(Double topeIndemnizacion) {
        this.topeIndemnizacion = topeIndemnizacion;
    }

    public Double getTopeIndemnizacion() {
        return topeIndemnizacion;
    }

    public void setMontoDefectoAsegurado(Double montoDefectoAsegurado) {
        this.montoDefectoAsegurado = montoDefectoAsegurado;
    }

    public Double getMontoDefectoAsegurado() {
        return montoDefectoAsegurado;
    }

    public void setMontoDefectoCarga(Double montoDefectoCarga) {
        this.montoDefectoCarga = montoDefectoCarga;
    }

    public Double getMontoDefectoCarga() {
        return montoDefectoCarga;
    }

    public void setTopeGrupoFamiliar(Double topeGrupoFamiliar) {
        this.topeGrupoFamiliar = topeGrupoFamiliar;
    }

    public Double getTopeGrupoFamiliar() {
        return topeGrupoFamiliar;
    }

    public void setPlanAsegurados(String planAsegurados) {
        this.planAsegurados = planAsegurados;
    }

    public String getPlanAsegurados() {
        return planAsegurados;
    }

    public void setPlanCargas(String planCargas) {
        this.planCargas = planCargas;
    }

    public String getPlanCargas() {
        return planCargas;
    }

    public void setDeducible(Double deducible) {
        this.deducible = deducible;
    }

    public Double getDeducible() {
        return deducible;
    }

    public void setMaximoDeducibles(Double maximoDeducibles) {
        this.maximoDeducibles = maximoDeducibles;
    }

    public Double getMaximoDeducibles() {
        return maximoDeducibles;
    }

    public void setDiaPago(Integer diaPago) {
        this.diaPago = diaPago;
    }

    public Integer getDiaPago() {
        return diaPago;
    }

    public void setPeriodicidadPago(Integer periodicidadPago) {
        this.periodicidadPago = periodicidadPago;
    }

    public Integer getPeriodicidadPago() {
        return periodicidadPago;
    }

    public void setPagoMinimo(Double pagoMinimo) {
        this.pagoMinimo = pagoMinimo;
    }

    public Double getPagoMinimo() {
        return pagoMinimo;
    }

    public void setDeducibleIndividual(String deducibleIndividual) {
        this.deducibleIndividual = deducibleIndividual;
    }

    public String getDeducibleIndividual() {
        return deducibleIndividual;
    }

    public void setPlanCatastroficoAsegurado(String planCatastroficoAsegurado) {
        this.planCatastroficoAsegurado = planCatastroficoAsegurado;
    }

    public String getPlanCatastroficoAsegurado() {
        return planCatastroficoAsegurado;
    }

    public void setPlanCatastroficoCarga(String planCatastroficoCarga) {
        this.planCatastroficoCarga = planCatastroficoCarga;
    }

    public String getPlanCatastroficoCarga() {
        return planCatastroficoCarga;
    }

    public void setTopeMaximoAnualAseguradoCat(Double topeMaximoAnualAseguradoCat) {
        this.topeMaximoAnualAseguradoCat = topeMaximoAnualAseguradoCat;
    }

    public Double getTopeMaximoAnualAseguradoCat() {
        return topeMaximoAnualAseguradoCat;
    }

    public void setTopeMaximoAnualCargaCat(Double topeMaximoAnualCargaCat) {
        this.topeMaximoAnualCargaCat = topeMaximoAnualCargaCat;
    }

    public Double getTopeMaximoAnualCargaCat() {
        return topeMaximoAnualCargaCat;
    }

    public void setMontoActivacionCatastrofico(Double montoActivacionCatastrofico) {
        this.montoActivacionCatastrofico = montoActivacionCatastrofico;
    }

    public Double getMontoActivacionCatastrofico() {
        return montoActivacionCatastrofico;
    }

    public void setMontoMaximoEfectivo(Double montoMaximoEfectivo) {
        this.montoMaximoEfectivo = montoMaximoEfectivo;
    }

    public Double getMontoMaximoEfectivo() {
        return montoMaximoEfectivo;
    }

    public void setTopeDiario(Double topeDiario) {
        this.topeDiario = topeDiario;
    }

    public Double getTopeDiario() {
        return topeDiario;
    }
}
