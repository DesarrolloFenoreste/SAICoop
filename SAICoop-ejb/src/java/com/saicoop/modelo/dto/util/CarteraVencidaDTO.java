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
@XmlRootElement(name = "carteraVencidaDTO")
public class CarteraVencidaDTO implements Serializable {

    private Integer idorigenp;
    private Integer idproducto;
    private Integer idauxiliar;
    private String fechacalculo;
    private Integer idorigen;
    private Integer idgrupo;
    private Integer idsocio;
    private String fechaprestamo;
    private BigDecimal montoprestado;
    private Integer autorizo;
    private BigDecimal saldo;
    private BigDecimal io;
    private BigDecimal im;
    private String cartera;
    private String fechacartera;
    private String fechauma;
    private Integer diasvencidos;
    private BigDecimal montovencido;
    private BigDecimal abonosvencidos;
    private BigDecimal montoapagar;
    private Boolean escarterav;

    public CarteraVencidaDTO() {
    }

    public CarteraVencidaDTO(Integer idorigenp, Integer idproducto, Integer idauxiliar, String fechacalculo) {
        this.idorigenp = idorigenp;
        this.idproducto = idproducto;
        this.idauxiliar = idauxiliar;
        this.fechacalculo = fechacalculo;
    }

    @Override
    public String toString() {
        return "CarteraVencidaDTO{" + "idorigenp=" + idorigenp + ", idproducto=" + idproducto + ", idauxiliar=" + idauxiliar + ", fechacalculo=" + fechacalculo + ", idorigen=" + idorigen + ", idgrupo=" + idgrupo + ", idsocio=" + idsocio + ", fechaprestamo=" + fechaprestamo + ", montoprestado=" + montoprestado + ", autorizo=" + autorizo + ", saldo=" + saldo + ", io=" + io + ", im=" + im + ", cartera=" + cartera + ", fechacartera=" + fechacartera + ", fechauma=" + fechauma + ", diasvencidos=" + diasvencidos + ", montovencido=" + montovencido + ", abonosvencidos=" + abonosvencidos + ", montoapagar=" + montoapagar + ", escarterav=" + escarterav + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idorigenp;
        hash = 97 * hash + this.idproducto;
        hash = 97 * hash + this.idauxiliar;
        hash = 97 * hash + Objects.hashCode(this.fechacalculo);
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
        final CarteraVencidaDTO other = (CarteraVencidaDTO) obj;
        if (!Objects.equals(this.idorigenp, other.idorigenp)) {
            return false;
        }
        if (!Objects.equals(this.idproducto, other.idproducto)) {
            return false;
        }
        if (!Objects.equals(this.idauxiliar, other.idauxiliar)) {
            return false;
        }
        if (!Objects.equals(this.fechacalculo, other.fechacalculo)) {
            return false;
        }
        return true;
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

    public String getFechacalculo() {
        return fechacalculo;
    }

    public void setFechacalculo(String fechacalculo) {
        this.fechacalculo = fechacalculo;
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

    public String getFechaprestamo() {
        return fechaprestamo;
    }

    public void setFechaprestamo(String fechaprestamo) {
        this.fechaprestamo = fechaprestamo;
    }

    public BigDecimal getMontoprestado() {
        return montoprestado;
    }

    public void setMontoprestado(BigDecimal montoprestado) {
        this.montoprestado = montoprestado;
    }

    public Integer getAutorizo() {
        return autorizo;
    }

    public void setAutorizo(Integer autorizo) {
        this.autorizo = autorizo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getIo() {
        return io;
    }

    public void setIo(BigDecimal io) {
        this.io = io;
    }

    public BigDecimal getIm() {
        return im;
    }

    public void setIm(BigDecimal im) {
        this.im = im;
    }

    public String getCartera() {
        return cartera;
    }

    public void setCartera(String cartera) {
        this.cartera = cartera;
    }

    public String getFechacartera() {
        return fechacartera;
    }

    public void setFechacartera(String fechacartera) {
        this.fechacartera = fechacartera;
    }

    public String getFechauma() {
        return fechauma;
    }

    public void setFechauma(String fechauma) {
        this.fechauma = fechauma;
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

    public BigDecimal getAbonosvencidos() {
        return abonosvencidos;
    }

    public void setAbonosvencidos(BigDecimal abonosvencidos) {
        this.abonosvencidos = abonosvencidos;
    }

    public BigDecimal getMontoapagar() {
        return montoapagar;
    }

    public void setMontoapagar(BigDecimal montoapagar) {
        this.montoapagar = montoapagar;
    }

    public boolean isEscarterav() {
        return escarterav;
    }

    public void setEscarterav(boolean escarterav) {
        this.escarterav = escarterav;
    }

}
