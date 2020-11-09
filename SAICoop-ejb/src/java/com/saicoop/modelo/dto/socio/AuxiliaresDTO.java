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
@XmlRootElement(name = "auxiliaresDTO")
public class AuxiliaresDTO implements Serializable {

    private Integer idorigen;//idorigen integer,
    private Integer idgrupo; //idgrupo integer,
    private Integer idsocio; //idsocio integer,
    private Integer idorigenp;//idorigenp integer NOT NULL,
    private Integer idproducto; //idproducto integer NOT NULL,
    private Integer idauxiliar; //idauxiliar integer NOT NULL,
    private Object fechaape;//fechaape date NOT NULL,
    private Integer elaboro;//elaboro integer,
    private Integer autorizo;//autorizo integer,
    private BigDecimal estatus;//estatus numeric(1,0),
    private BigDecimal tasaio;//tasaio numeric(6,4) NOT NULL DEFAULT 0,
    private BigDecimal tasaim;//tasaim numeric(6,4) NOT NULL DEFAULT 0,
    private BigDecimal tasaiod;//tasaiod numeric(6,4) NOT NULL DEFAULT 0,
    private BigDecimal montosolicitado;//montosolicitado numeric(12,2) NOT NULL DEFAULT 0,
    private BigDecimal montoautorizado;//montoautorizado numeric(12,2) NOT NULL DEFAULT 0,
    private BigDecimal montoprestado;//montoprestado numeric(12,2) NOT NULL DEFAULT 0,
    private Integer idfinalidad; //idfinalidad integer,
    private BigDecimal plazo;//plazo numeric(4,0) NOT NULL,
    private BigDecimal periodoabonos;//periodoabonos numeric(4,0) NOT NULL DEFAULT 0,
    private BigDecimal saldoinicial;//saldoinicial numeric(12,2) NOT NULL DEFAULT 0,
    private BigDecimal saldo;//saldo numeric(12,2) NOT NULL DEFAULT 0,
    private BigDecimal io;//io numeric(12,2) NOT NULL DEFAULT 0,
    private BigDecimal idnc;//idnc numeric(12,2) NOT NULL DEFAULT 0,
    private BigDecimal ieco;//ieco numeric(12,2) NOT NULL DEFAULT 0,
    private BigDecimal im;//im numeric(12,2) NOT NULL DEFAULT 0,
    private BigDecimal iva;//iva numeric(12,2) NOT NULL DEFAULT 0,
    private Object fechaactivacion;//fechaactivacion date,
    private Object fechaumi;//fechaumi date NOT NULL,
    private String idnotas;//idnotas character varying(30),
    private BigDecimal tipoprestamo;//tipoprestamo numeric(1,0) NOT NULL DEFAULT 0,
    private String cartera;//cartera character varying(1) NOT NULL DEFAULT 'C'::character varying,
    private BigDecimal contaidnc;//contaidnc numeric(12,2) NOT NULL DEFAULT 0,
    private BigDecimal contaieco;//contaieco numeric(12,2) NOT NULL DEFAULT 0,
    private BigDecimal reservaidnc; //reservaidnc numeric(12,2) NOT NULL DEFAULT 0,
    private BigDecimal reservacapital;//reservacapital numeric(12,2) NOT NULL DEFAULT 0,
    private Integer tipoamortizacion; //tipoamortizacion smallint DEFAULT 0,
    private BigDecimal saldodiacum;//saldodiacum numeric(12,2) NOT NULL DEFAULT 0,
    private Object fechacartera;//fechacartera date,
    private Object fechauma;//fechauma date NOT NULL,
    private BigDecimal ivaidnccalc;//ivaidnccalc numeric(12,2) NOT NULL DEFAULT 0,
    private BigDecimal ivaidncpag;//ivaidncpag numeric(12,2) NOT NULL DEFAULT 0,
    private Integer tiporeferencia;//tiporeferencia smallint DEFAULT 0,
    private Integer calificacion;//calificacion integer,
    private Integer pagodiafijo;//pagodiafijo smallint DEFAULT 0,
    private BigDecimal iodif;//iodif numeric(12,2) DEFAULT 0,
    private BigDecimal garantia;//garantia numeric(12,2) DEFAULT 0,
    private BigDecimal saldodiacummi;//saldodiacummi numeric(12,2) NOT NULL DEFAULT 0,
    private BigDecimal comision;//comision numeric(12,2),
    private Object fechasdiacum;//fechasdiacum date NOT NULL,
    private BigDecimal prc_comision;//prc_comision numeric(6,4) DEFAULT 0,
    private BigDecimal sobreprecio;//sobreprecio numeric(12,2) NOT NULL DEFAULT 0,
    private BigDecimal comision_np;//comision_np numeric(12,2) NOT NULL DEFAULT 0,
    private Boolean pagos_dia_ultimo;//pagos_dia_ultimo boolean DEFAULT false,
    private Integer tipo_dv;//tipo_dv integer DEFAULT 0,
    private Object fecha_solicitud;//fecha_solicitud date,
    private Object fecha_autorizacion;//fecha_autorizacion date,
    private BigDecimal idncm;//idncm numeric(12,2) DEFAULT 0,
    private BigDecimal iecom;//iecom numeric(12,2) DEFAULT 0,
    private BigDecimal reservaidncm;//reservaidncm numeric(12,2) DEFAULT 0,
    private BigDecimal tasa_cat_gat;//tasa_cat_gat numeric,
    private BigDecimal retencion;//retencion numeric(12,2),

    public AuxiliaresDTO() {
    }

    public AuxiliaresDTO(Integer idorigenp, Integer idproducto, Integer idauxiliar) {
        this.idorigenp = idorigenp;
        this.idproducto = idproducto;
        this.idauxiliar = idauxiliar;
    }

    @Override
    public String toString() {
        return "AuxiliaresDTO{" + "idorigen=" + idorigen + ", idgrupo=" + idgrupo + ", idsocio=" + idsocio + ", idorigenp=" + idorigenp + ", idproducto=" + idproducto + ", idauxiliar=" + idauxiliar + ", fechaape=" + fechaape + ", elaboro=" + elaboro + ", autorizo=" + autorizo + ", estatus=" + estatus + ", tasaio=" + tasaio + ", tasaim=" + tasaim + ", tasaiod=" + tasaiod + ", montosolicitado=" + montosolicitado + ", montoautorizado=" + montoautorizado + ", montoprestado=" + montoprestado + ", idfinalidad=" + idfinalidad + ", plazo=" + plazo + ", periodoabonos=" + periodoabonos + ", saldoinicial=" + saldoinicial + ", saldo=" + saldo + ", io=" + io + ", idnc=" + idnc + ", ieco=" + ieco + ", im=" + im + ", iva=" + iva + ", fechaactivacion=" + fechaactivacion + ", fechaumi=" + fechaumi + ", idnotas=" + idnotas + ", tipoprestamo=" + tipoprestamo + ", cartera=" + cartera + ", contaidnc=" + contaidnc + ", contaieco=" + contaieco + ", reservaidnc=" + reservaidnc + ", reservacapital=" + reservacapital + ", tipoamortizacion=" + tipoamortizacion + ", saldodiacum=" + saldodiacum + ", fechacartera=" + fechacartera + ", fechauma=" + fechauma + ", ivaidnccalc=" + ivaidnccalc + ", ivaidncpag=" + ivaidncpag + ", tiporeferencia=" + tiporeferencia + ", calificacion=" + calificacion + ", pagodiafijo=" + pagodiafijo + ", iodif=" + iodif + ", garantia=" + garantia + ", saldodiacummi=" + saldodiacummi + ", comision=" + comision + ", fechasdiacum=" + fechasdiacum + ", prc_comision=" + prc_comision + ", sobreprecio=" + sobreprecio + ", comision_np=" + comision_np + ", pagos_dia_ultimo=" + isPagos_dia_ultimo() + ", tipo_dv=" + tipo_dv + ", fecha_solicitud=" + fecha_solicitud + ", fecha_autorizacion=" + fecha_autorizacion + ", idncm=" + idncm + ", iecom=" + iecom + ", reservaidncm=" + reservaidncm + ", tasa_cat_gat=" + tasa_cat_gat + ", retencion=" + retencion + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.idorigenp;
        hash = 23 * hash + this.idproducto;
        hash = 23 * hash + this.idauxiliar;
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
        final AuxiliaresDTO other = (AuxiliaresDTO) obj;
        if (!Objects.equals(this.idorigenp, other.idorigenp)) {
            return false;
        }
        if (!Objects.equals(this.idproducto, other.idproducto)) {
            return false;
        }
        return Objects.equals(this.idauxiliar, other.idauxiliar);
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

    public Object getFechaape() {
        return fechaape;
    }

    public void setFechaape(String fechaape) {
        this.fechaape = fechaape;
    }

    public Integer getElaboro() {
        return elaboro;
    }

    public void setElaboro(Integer elaboro) {
        this.elaboro = elaboro;
    }

    public Integer getAutorizo() {
        return autorizo;
    }

    public void setAutorizo(Integer autorizo) {
        this.autorizo = autorizo;
    }

    public BigDecimal getEstatus() {
        return estatus;
    }

    public void setEstatus(BigDecimal estatus) {
        this.estatus = estatus;
    }

    public BigDecimal getTasaio() {
        return tasaio;
    }

    public void setTasaio(BigDecimal tasaio) {
        this.tasaio = tasaio;
    }

    public BigDecimal getTasaim() {
        return tasaim;
    }

    public void setTasaim(BigDecimal tasaim) {
        this.tasaim = tasaim;
    }

    public BigDecimal getTasaiod() {
        return tasaiod;
    }

    public void setTasaiod(BigDecimal tasaiod) {
        this.tasaiod = tasaiod;
    }

    public BigDecimal getMontosolicitado() {
        return montosolicitado;
    }

    public void setMontosolicitado(BigDecimal montosolicitado) {
        this.montosolicitado = montosolicitado;
    }

    public BigDecimal getMontoautorizado() {
        return montoautorizado;
    }

    public void setMontoautorizado(BigDecimal montoautorizado) {
        this.montoautorizado = montoautorizado;
    }

    public BigDecimal getMontoprestado() {
        return montoprestado;
    }

    public void setMontoprestado(BigDecimal montoprestado) {
        this.montoprestado = montoprestado;
    }

    public Integer getIdfinalidad() {
        return idfinalidad;
    }

    public void setIdfinalidad(Integer idfinalidad) {
        this.idfinalidad = idfinalidad;
    }

    public BigDecimal getPlazo() {
        return plazo;
    }

    public void setPlazo(BigDecimal plazo) {
        this.plazo = plazo;
    }

    public BigDecimal getPeriodoabonos() {
        return periodoabonos;
    }

    public void setPeriodoabonos(BigDecimal periodoabonos) {
        this.periodoabonos = periodoabonos;
    }

    public BigDecimal getSaldoinicial() {
        return saldoinicial;
    }

    public void setSaldoinicial(BigDecimal saldoinicial) {
        this.saldoinicial = saldoinicial;
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

    public BigDecimal getIdnc() {
        return idnc;
    }

    public void setIdnc(BigDecimal idnc) {
        this.idnc = idnc;
    }

    public BigDecimal getIeco() {
        return ieco;
    }

    public void setIeco(BigDecimal ieco) {
        this.ieco = ieco;
    }

    public BigDecimal getIm() {
        return im;
    }

    public void setIm(BigDecimal im) {
        this.im = im;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public Object getFechaactivacion() {
        return fechaactivacion;
    }

    public void setFechaactivacion(Object fechaactivacion) {
        this.fechaactivacion = fechaactivacion;
    }

    public Object getFechaumi() {
        return fechaumi;
    }

    public void setFechaumi(String fechaumi) {
        this.fechaumi = fechaumi;
    }

    public String getIdnotas() {
        return idnotas;
    }

    public void setIdnotas(String idnotas) {
        this.idnotas = idnotas;
    }

    public BigDecimal getTipoprestamo() {
        return tipoprestamo;
    }

    public void setTipoprestamo(BigDecimal tipoprestamo) {
        this.tipoprestamo = tipoprestamo;
    }

    public String getCartera() {
        return cartera;
    }

    public void setCartera(String cartera) {
        this.cartera = cartera;
    }

    public BigDecimal getContaidnc() {
        return contaidnc;
    }

    public void setContaidnc(BigDecimal contaidnc) {
        this.contaidnc = contaidnc;
    }

    public BigDecimal getContaieco() {
        return contaieco;
    }

    public void setContaieco(BigDecimal contaieco) {
        this.contaieco = contaieco;
    }

    public BigDecimal getReservaidnc() {
        return reservaidnc;
    }

    public void setReservaidnc(BigDecimal reservaidnc) {
        this.reservaidnc = reservaidnc;
    }

    public BigDecimal getReservacapital() {
        return reservacapital;
    }

    public void setReservacapital(BigDecimal reservacapital) {
        this.reservacapital = reservacapital;
    }

    public Integer getTipoamortizacion() {
        return tipoamortizacion;
    }

    public void setTipoamortizacion(Integer tipoamortizacion) {
        this.tipoamortizacion = tipoamortizacion;
    }

    public BigDecimal getSaldodiacum() {
        return saldodiacum;
    }

    public void setSaldodiacum(BigDecimal saldodiacum) {
        this.saldodiacum = saldodiacum;
    }

    public Object getFechacartera() {
        return fechacartera;
    }

    public void setFechacartera(String fechacartera) {
        this.fechacartera = fechacartera;
    }

    public Object getFechauma() {
        return fechauma;
    }

    public void setFechauma(String fechauma) {
        this.fechauma = fechauma;
    }

    public BigDecimal getIvaidnccalc() {
        return ivaidnccalc;
    }

    public void setIvaidnccalc(BigDecimal ivaidnccalc) {
        this.ivaidnccalc = ivaidnccalc;
    }

    public BigDecimal getIvaidncpag() {
        return ivaidncpag;
    }

    public void setIvaidncpag(BigDecimal ivaidncpag) {
        this.ivaidncpag = ivaidncpag;
    }

    public Integer getTiporeferencia() {
        return tiporeferencia;
    }

    public void setTiporeferencia(Integer tiporeferencia) {
        this.tiporeferencia = tiporeferencia;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Integer getPagodiafijo() {
        return pagodiafijo;
    }

    public void setPagodiafijo(Integer pagodiafijo) {
        this.pagodiafijo = pagodiafijo;
    }

    public BigDecimal getIodif() {
        return iodif;
    }

    public void setIodif(BigDecimal iodif) {
        this.iodif = iodif;
    }

    public BigDecimal getGarantia() {
        return garantia;
    }

    public void setGarantia(BigDecimal garantia) {
        this.garantia = garantia;
    }

    public BigDecimal getSaldodiacummi() {
        return saldodiacummi;
    }

    public void setSaldodiacummi(BigDecimal saldodiacummi) {
        this.saldodiacummi = saldodiacummi;
    }

    public BigDecimal getComision() {
        return comision;
    }

    public void setComision(BigDecimal comision) {
        this.comision = comision;
    }

    public Object getFechasdiacum() {
        return fechasdiacum;
    }

    public void setFechasdiacum(String fechasdiacum) {
        this.fechasdiacum = fechasdiacum;
    }

    public BigDecimal getPrc_comision() {
        return prc_comision;
    }

    public void setPrc_comision(BigDecimal prc_comision) {
        this.prc_comision = prc_comision;
    }

    public BigDecimal getSobreprecio() {
        return sobreprecio;
    }

    public void setSobreprecio(BigDecimal sobreprecio) {
        this.sobreprecio = sobreprecio;
    }

    public BigDecimal getComision_np() {
        return comision_np;
    }

    public void setComision_np(BigDecimal comision_np) {
        this.comision_np = comision_np;
    }

    public boolean isPagos_dia_ultimo() {
        return pagos_dia_ultimo;
    }

    public void setPagos_dia_ultimo(boolean pagos_dia_ultimo) {
        this.pagos_dia_ultimo = pagos_dia_ultimo;
    }

    public Integer getTipo_dv() {
        return tipo_dv;
    }

    public void setTipo_dv(Integer tipo_dv) {
        this.tipo_dv = tipo_dv;
    }

    public Object getFecha_solicitud() {
        return fecha_solicitud;
    }

    public void setFecha_solicitud(String fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    public Object getFecha_autorizacion() {
        return fecha_autorizacion;
    }

    public void setFecha_autorizacion(String fecha_autorizacion) {
        this.fecha_autorizacion = fecha_autorizacion;
    }

    public BigDecimal getIdncm() {
        return idncm;
    }

    public void setIdncm(BigDecimal idncm) {
        this.idncm = idncm;
    }

    public BigDecimal getIecom() {
        return iecom;
    }

    public void setIecom(BigDecimal iecom) {
        this.iecom = iecom;
    }

    public BigDecimal getReservaidncm() {
        return reservaidncm;
    }

    public void setReservaidncm(BigDecimal reservaidncm) {
        this.reservaidncm = reservaidncm;
    }

    public BigDecimal getTasa_cat_gat() {
        return tasa_cat_gat;
    }

    public void setTasa_cat_gat(BigDecimal tasa_cat_gat) {
        this.tasa_cat_gat = tasa_cat_gat;
    }

    public BigDecimal getRetencion() {
        return retencion;
    }

    public void setRetencion(BigDecimal retencion) {
        this.retencion = retencion;
    }

}
