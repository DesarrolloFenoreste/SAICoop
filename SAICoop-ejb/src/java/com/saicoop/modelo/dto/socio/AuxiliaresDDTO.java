/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.dto.socio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author prometeo
 */
@XmlRootElement(name = "auxiliaresDDTO")
public class AuxiliaresDDTO implements Serializable {

    private Integer idorigenp;//idorigenp integer,
    private Integer idproducto;//idproducto integer,
    private Integer idauxiliar;//idauxiliar integer,
    private String fecha;//fecha timestamp with time zone NOT NULL,
    private Short cargoabono;//cargoabono numeric(1,0),
    private BigDecimal monto;//monto numeric(12,2) NOT NULL DEFAULT 0,
    private BigDecimal montoio;//montoio numeric(12,2) NOT NULL DEFAULT 0,
    private BigDecimal montoim; //montoim numeric(12,2) NOT NULL DEFAULT 0,
    private BigDecimal montoiva;//montoiva numeric(12,2) NOT NULL DEFAULT 0,
    private Integer idorigenc;//idorigenc integer,
    private String periodo;//periodo character varying(6),
    private Short idtipo;//idtipo numeric(1,0),
    private Integer idpoliza;//idpoliza integer,
    private Short tipomov;//tipomov numeric(1,0) DEFAULT 0,
    private BigDecimal saldoec;//saldoec numeric(12,2) NOT NULL DEFAULT 0,
    private Integer transaccion;//transaccion integer,
    private BigDecimal montoivaim;//montoivaim numeric(12,2) NOT NULL DEFAULT 0,
    private BigDecimal efectivo;//efectivo numeric(12,2) NOT NULL DEFAULT 0,
    private Integer diasvencidos;//diasvencidos integer NOT NULL DEFAULT 0,
    private BigDecimal montovencido;//montovencido numeric(12,2) NOT NULL DEFAULT 0,
    private Integer ticket;//ticket integer DEFAULT 0,
    private BigDecimal montoidnc;//montoidnc numeric(12,2),
    private BigDecimal montoieco;//montoieco numeric(12,2),
    private BigDecimal montoidncm;//montoidncm numeric(12,2),
    private BigDecimal montoiecom;//montoiecom numeric(12,2),
    private String cartera;//cartera character varying(1),

    public AuxiliaresDDTO() {
    }

    public AuxiliaresDDTO(Integer idorigenp, Integer idproducto, Integer idauxiliar) {
        this.idorigenp = idorigenp;
        this.idproducto = idproducto;
        this.idauxiliar = idauxiliar;
    }

    @Override
    public String toString() {
        return "AuxiliaresDDTO{" + "idorigenp=" + idorigenp + ", idproducto=" + idproducto + ", idauxiliar=" + idauxiliar + ", fecha=" + fecha + ", cargoabono=" + cargoabono + ", monto=" + monto + ", montoio=" + montoio + ", montoim=" + montoim + ", montoiva=" + montoiva + ", idorigenc=" + idorigenc + ", periodo=" + periodo + ", idtipo=" + idtipo + ", idpoliza=" + idpoliza + ", tipomov=" + tipomov + ", saldoec=" + saldoec + ", transaccion=" + transaccion + ", montoivaim=" + montoivaim + ", efectivo=" + efectivo + ", diasvencidos=" + diasvencidos + ", montovencido=" + montovencido + ", ticket=" + ticket + ", montoidnc=" + montoidnc + ", montoieco=" + montoieco + ", montoidncm=" + montoidncm + ", montoiecom=" + montoiecom + ", cartera=" + cartera + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.idorigenp;
        hash = 73 * hash + this.idproducto;
        hash = 73 * hash + this.idauxiliar;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AuxiliaresDDTO other = (AuxiliaresDDTO) obj;
        if (!Objects.equals(this.idorigenp, other.idorigenp)) {
            return false;
        }
        if (!Objects.equals(this.idproducto, other.idproducto)) {
            return false;
        }
        return Objects.equals(this.idauxiliar, other.idauxiliar);
    }

    public Integer getIdorigenp() {
        return idorigenp;
    }

    public void setIdorigenp(Integer idorigenp) {
        this.idorigenp = idorigenp;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Integer getIdauxiliar() {
        return idauxiliar;
    }

    public void setIdauxiliar(Integer idauxiliar) {
        this.idauxiliar = idauxiliar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Short getCargoabono() {
        return cargoabono;
    }

    public void setCargoabono(Short cargoabono) {
        this.cargoabono = cargoabono;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getMontoio() {
        return montoio;
    }

    public void setMontoio(BigDecimal montoio) {
        this.montoio = montoio;
    }

    public BigDecimal getMontoim() {
        return montoim;
    }

    public void setMontoim(BigDecimal montoim) {
        this.montoim = montoim;
    }

    public BigDecimal getMontoiva() {
        return montoiva;
    }

    public void setMontoiva(BigDecimal montoiva) {
        this.montoiva = montoiva;
    }

    public Integer getIdorigenc() {
        return idorigenc;
    }

    public void setIdorigenc(Integer idorigenc) {
        this.idorigenc = idorigenc;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Short getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Short idtipo) {
        this.idtipo = idtipo;
    }

    public Integer getIdpoliza() {
        return idpoliza;
    }

    public void setIdpoliza(Integer idpoliza) {
        this.idpoliza = idpoliza;
    }

    public Short getTipomov() {
        return tipomov;
    }

    public void setTipomov(Short tipomov) {
        this.tipomov = tipomov;
    }

    public BigDecimal getSaldoec() {
        return saldoec;
    }

    public void setSaldoec(BigDecimal saldoec) {
        this.saldoec = saldoec;
    }

    public Integer getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Integer transaccion) {
        this.transaccion = transaccion;
    }

    public BigDecimal getMontoivaim() {
        return montoivaim;
    }

    public void setMontoivaim(BigDecimal montoivaim) {
        this.montoivaim = montoivaim;
    }

    public BigDecimal getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(BigDecimal efectivo) {
        this.efectivo = efectivo;
    }

    public Integer getDiasvencidos() {
        return diasvencidos;
    }

    public void setDiasvencidos(Integer diasvencidos) {
        this.diasvencidos = diasvencidos;
    }

    public BigDecimal getMontovencido() {
        return montovencido;
    }

    public void setMontovencido(BigDecimal montovencido) {
        this.montovencido = montovencido;
    }

    public Integer getTicket() {
        return ticket;
    }

    public void setTicket(Integer ticket) {
        this.ticket = ticket;
    }

    public BigDecimal getMontoidnc() {
        return montoidnc;
    }

    public void setMontoidnc(BigDecimal montoidnc) {
        this.montoidnc = montoidnc;
    }

    public BigDecimal getMontoieco() {
        return montoieco;
    }

    public void setMontoieco(BigDecimal montoieco) {
        this.montoieco = montoieco;
    }

    public BigDecimal getMontoidncm() {
        return montoidncm;
    }

    public void setMontoidncm(BigDecimal montoidncm) {
        this.montoidncm = montoidncm;
    }

    public BigDecimal getMontoiecom() {
        return montoiecom;
    }

    public void setMontoiecom(BigDecimal montoiecom) {
        this.montoiecom = montoiecom;
    }

    public String getCartera() {
        return cartera;
    }

    public void setCartera(String cartera) {
        this.cartera = cartera;
    }

}
