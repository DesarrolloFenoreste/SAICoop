/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.dto.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author prometeo
 */
@XmlRootElement(name = "temporalDTO")
public class TemporalDTO implements Serializable {

    private Integer idusuario;
    private String sesion;
    private Integer idorigen;
    private Integer idgrupo;
    private Integer idsocio;
    private Integer idorigenp;
    private Integer idproducto;
    private Integer idauxiliar;
    private Boolean esentrada = false;
    private BigDecimal acapital;
    private BigDecimal io_pag;
    private BigDecimal io_cal;
    private BigDecimal im_pag;
    private BigDecimal im_cal;
    private BigDecimal aiva;
    private BigDecimal saldodiacum;
    private BigDecimal abonifio;
    private String idcuenta; 
    private Boolean aplicado = false;
    private BigDecimal ivaio_pag;
    private BigDecimal ivaio_cal;
    private BigDecimal ivaim_pag;
    private BigDecimal ivaim_cal;
    private Integer mov;
    private Integer tipomov;
    private BigDecimal efectivo;
    private String referencia;
    private BigDecimal cpnp_pag;
    private BigDecimal cpnp_cal;
    private Integer diasvencidos;
    private BigDecimal montovencido;
    private Integer idorigena;
    private Boolean huella_valida = false;
    private String concepto_mov;
    private String fe_nom_archivo;
    private String fe_xml;
    private String sai_aux;

    public TemporalDTO() {
    }

    public TemporalDTO(Integer idusuario, String sesion, Integer idorigen, Integer idgrupo, Integer idsocio) {
        this.idusuario = idusuario;
        this.sesion = sesion;
        this.idorigen = idorigen;
        this.idgrupo = idgrupo;
        this.idsocio = idsocio;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getSesion() {
        return sesion;
    }

    public void setSesion(String sesion) {
        this.sesion = sesion;
    }

    public Integer getIdorigen() {
        return idorigen;
    }

    public void setIdorigen(Integer idorigen) {
        this.idorigen = idorigen;
    }

    public Integer getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(Integer idgrupo) {
        this.idgrupo = idgrupo;
    }

    public Integer getIdsocio() {
        return idsocio;
    }

    public void setIdsocio(Integer idsocio) {
        this.idsocio = idsocio;
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

    public boolean isEsentrada() {
        return esentrada;
    }

    public void setEsentrada(boolean esentrada) {
        this.esentrada = esentrada;
    }

    public BigDecimal getAcapital() {
        return acapital;
    }

    public void setAcapital(BigDecimal acapital) {
        this.acapital = acapital;
    }

    public BigDecimal getIo_pag() {
        return io_pag;
    }

    public void setIo_pag(BigDecimal io_pag) {
        this.io_pag = io_pag;
    }

    public BigDecimal getIo_cal() {
        return io_cal;
    }

    public void setIo_cal(BigDecimal io_cal) {
        this.io_cal = io_cal;
    }

    public BigDecimal getIm_pag() {
        return im_pag;
    }

    public void setIm_pag(BigDecimal im_pag) {
        this.im_pag = im_pag;
    }

    public BigDecimal getIm_cal() {
        return im_cal;
    }

    public void setIm_cal(BigDecimal im_cal) {
        this.im_cal = im_cal;
    }

    public BigDecimal getAiva() {
        return aiva;
    }

    public void setAiva(BigDecimal aiva) {
        this.aiva = aiva;
    }

    public BigDecimal getSaldodiacum() {
        return saldodiacum;
    }

    public void setSaldodiacum(BigDecimal saldodiacum) {
        this.saldodiacum = saldodiacum;
    }

    public BigDecimal getAbonifio() {
        return abonifio;
    }

    public void setAbonifio(BigDecimal abonifio) {
        this.abonifio = abonifio;
    }

    public String getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(String idcuenta) {
        this.idcuenta = idcuenta;
    }

    public boolean isAplicado() {
        return aplicado;
    }

    public void setAplicado(boolean aplicado) {
        this.aplicado = aplicado;
    }

    public BigDecimal getIvaio_pag() {
        return ivaio_pag;
    }

    public void setIvaio_pag(BigDecimal ivaio_pag) {
        this.ivaio_pag = ivaio_pag;
    }

    public BigDecimal getIvaio_cal() {
        return ivaio_cal;
    }

    public void setIvaio_cal(BigDecimal ivaio_cal) {
        this.ivaio_cal = ivaio_cal;
    }

    public BigDecimal getIvaim_pag() {
        return ivaim_pag;
    }

    public void setIvaim_pag(BigDecimal ivaim_pag) {
        this.ivaim_pag = ivaim_pag;
    }

    public BigDecimal getIvaim_cal() {
        return ivaim_cal;
    }

    public void setIvaim_cal(BigDecimal ivaim_cal) {
        this.ivaim_cal = ivaim_cal;
    }

    public Integer getMov() {
        return mov;
    }

    public void setMov(Integer mov) {
        this.mov = mov;
    }

    public Integer getTipomov() {
        return tipomov;
    }

    public void setTipomov(Integer tipomov) {
        this.tipomov = tipomov;
    }

    public BigDecimal getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(BigDecimal efectivo) {
        this.efectivo = efectivo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public BigDecimal getCpnp_pag() {
        return cpnp_pag;
    }

    public void setCpnp_pag(BigDecimal cpnp_pag) {
        this.cpnp_pag = cpnp_pag;
    }

    public BigDecimal getCpnp_cal() {
        return cpnp_cal;
    }

    public void setCpnp_cal(BigDecimal cpnp_cal) {
        this.cpnp_cal = cpnp_cal;
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

    public Integer getIdorigena() {
        return idorigena;
    }

    public void setIdorigena(Integer idorigena) {
        this.idorigena = idorigena;
    }

    public boolean isHuella_valida() {
        return huella_valida;
    }

    public void setHuella_valida(boolean huella_valida) {
        this.huella_valida = huella_valida;
    }

    public String getConcepto_mov() {
        return concepto_mov;
    }

    public void setConcepto_mov(String concepto_mov) {
        this.concepto_mov = concepto_mov;
    }

    public String getFe_nom_archivo() {
        return fe_nom_archivo;
    }

    public void setFe_nom_archivo(String fe_nom_archivo) {
        this.fe_nom_archivo = fe_nom_archivo;
    }

    public String getFe_xml() {
        return fe_xml;
    }

    public void setFe_xml(String fe_xml) {
        this.fe_xml = fe_xml;
    }

    public String getSai_aux() {
        return sai_aux;
    }

    public void setSai_aux(String sai_aux) {
        this.sai_aux = sai_aux;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.idusuario);
        hash = 67 * hash + Objects.hashCode(this.sesion);
        hash = 67 * hash + Objects.hashCode(this.idorigen);
        hash = 67 * hash + Objects.hashCode(this.idgrupo);
        hash = 67 * hash + Objects.hashCode(this.idsocio);
        hash = 67 * hash + Objects.hashCode(this.idorigenp);
        hash = 67 * hash + Objects.hashCode(this.idproducto);
        hash = 67 * hash + Objects.hashCode(this.idauxiliar);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TemporalDTO other = (TemporalDTO) obj;
        if (!Objects.equals(this.sesion, other.sesion)) {
            return false;
        }
        if (!Objects.equals(this.idusuario, other.idusuario)) {
            return false;
        }
        if (!Objects.equals(this.idorigen, other.idorigen)) {
            return false;
        }
        if (!Objects.equals(this.idgrupo, other.idgrupo)) {
            return false;
        }
        if (!Objects.equals(this.idsocio, other.idsocio)) {
            return false;
        }
        if (!Objects.equals(this.idorigenp, other.idorigenp)) {
            return false;
        }
        if (!Objects.equals(this.idproducto, other.idproducto)) {
            return false;
        }
        return Objects.equals(this.idauxiliar, other.idauxiliar);
    }

    @Override
    public String toString() {
        return "TemporalDTO{" + "idusuario=" + idusuario + ", sesion=" + sesion + ", idorigen=" + idorigen + ", idgrupo=" + idgrupo + ", idsocio=" + idsocio + ", idorigenp=" + idorigenp + ", idproducto=" + idproducto + ", idauxiliar=" + idauxiliar + ", esentrada=" + esentrada + ", acapital=" + acapital + ", io_pag=" + io_pag + ", io_cal=" + io_cal + ", im_pag=" + im_pag + ", im_cal=" + im_cal + ", aiva=" + aiva + ", saldodiacum=" + saldodiacum + ", abonifio=" + abonifio + ", idcuenta=" + idcuenta + ", aplicado=" + aplicado + ", ivaio_pag=" + ivaio_pag + ", ivaio_cal=" + ivaio_cal + ", ivaim_pag=" + ivaim_pag + ", ivaim_cal=" + ivaim_cal + ", mov=" + mov + ", tipomov=" + tipomov + ", efectivo=" + efectivo + ", referencia=" + referencia + ", cpnp_pag=" + cpnp_pag + ", cpnp_cal=" + cpnp_cal + ", diasvencidos=" + diasvencidos + ", montovencido=" + montovencido + ", idorigena=" + idorigena + ", huella_valida=" + huella_valida + ", concepto_mov=" + concepto_mov + ", fe_nom_archivo=" + fe_nom_archivo + ", fe_xml=" + fe_xml + ", sai_aux=" + sai_aux + '}';
    }

}
