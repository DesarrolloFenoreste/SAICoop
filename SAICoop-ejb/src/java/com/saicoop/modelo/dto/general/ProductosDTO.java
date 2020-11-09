/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.dto.general;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author prometeo
 */
@XmlRootElement(name = "productosDTO")
public class ProductosDTO implements Serializable {

    private Integer idproducto;
    private String nombre;
    private Integer idorigen;
    private String cuentaaplica;
    private String cuentavencida;
    private String cuentaintord;
    private String cuentaidnc;
    private String cuentaidncv;
    private String cuentaidncres;
    private String cuentaoiod;
    private String cuentaintmor;
    private String cuentaiva;
    private String cuentarc;
    private String cuentari;
    private BigDecimal tipoproducto;
    private BigDecimal tiporetiro;
    private BigDecimal tipocalculo;
    private BigDecimal tasaio;
    private BigDecimal tasaiod;
    private BigDecimal tasaim;
    private BigDecimal iva;
    private BigDecimal ivaim;
    private BigDecimal garantias;
    private BigDecimal avales;
    private Boolean reqsocio;
    private Integer tipoamortizacion;
    private BigDecimal maxeventos;
    private BigDecimal maxdv;
    private String saldominimo;
    private String saldomaximo;
    private String cuentageprcc;
    private String cuentageprci;
    private String cuentaeprcc;
    private String cuentaeprci;
    private String cuentaoimd;
    private String cuentaoima;
    private String cuentaoioa;
    private String cuentaivaim;
    private String cuentaivaidncvig;
    private String cuentaivaidncven;
    private String cuentaivappidnc;
    private String cuentaintordv;
    private Integer plazomax;
    private Integer tipofinalidad;
    private Integer activo;
    private Integer pagodiafijo;
    private Integer cant_aperturas;
    private Integer producto_padre;
    private BigDecimal tasasp;
    private BigDecimal ivasp;
    private String cuentasp;
    private String cuentaivasp;
    private Integer tolerancia_im;
    private Integer tolerancia_com_no_pago;
    private BigDecimal monto_com_no_pago;
    private BigDecimal comision_apertura;
    private String rango_edad;
    private String evalua_aperturas;
    private String cuentaintmorv;
    private String cuentaidncmres;
    private String cuentaidncm;
    private String cuentaidncmv;
    private String cuentageprcim;
    private String cuentaeprcim;

    public ProductosDTO() {
    }

    public ProductosDTO(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdorigen() {
        return idorigen;
    }

    public void setIdorigen(Integer idorigen) {
        this.idorigen = idorigen;
    }

    public String getCuentaaplica() {
        return cuentaaplica;
    }

    public void setCuentaaplica(String cuentaaplica) {
        this.cuentaaplica = cuentaaplica;
    }

    public String getCuentavencida() {
        return cuentavencida;
    }

    public void setCuentavencida(String cuentavencida) {
        this.cuentavencida = cuentavencida;
    }

    public String getCuentaintord() {
        return cuentaintord;
    }

    public void setCuentaintord(String cuentaintord) {
        this.cuentaintord = cuentaintord;
    }

    public String getCuentaidnc() {
        return cuentaidnc;
    }

    public void setCuentaidnc(String cuentaidnc) {
        this.cuentaidnc = cuentaidnc;
    }

    public String getCuentaidncv() {
        return cuentaidncv;
    }

    public void setCuentaidncv(String cuentaidncv) {
        this.cuentaidncv = cuentaidncv;
    }

    public String getCuentaidncres() {
        return cuentaidncres;
    }

    public void setCuentaidncres(String cuentaidncres) {
        this.cuentaidncres = cuentaidncres;
    }

    public String getCuentaoiod() {
        return cuentaoiod;
    }

    public void setCuentaoiod(String cuentaoiod) {
        this.cuentaoiod = cuentaoiod;
    }

    public String getCuentaintmor() {
        return cuentaintmor;
    }

    public void setCuentaintmor(String cuentaintmor) {
        this.cuentaintmor = cuentaintmor;
    }

    public String getCuentaiva() {
        return cuentaiva;
    }

    public void setCuentaiva(String cuentaiva) {
        this.cuentaiva = cuentaiva;
    }

    public String getCuentarc() {
        return cuentarc;
    }

    public void setCuentarc(String cuentarc) {
        this.cuentarc = cuentarc;
    }

    public String getCuentari() {
        return cuentari;
    }

    public void setCuentari(String cuentari) {
        this.cuentari = cuentari;
    }

    public BigDecimal getTipoproducto() {
        return tipoproducto;
    }

    public void setTipoproducto(BigDecimal tipoproducto) {
        this.tipoproducto = tipoproducto;
    }

    public BigDecimal getTiporetiro() {
        return tiporetiro;
    }

    public void setTiporetiro(BigDecimal tiporetiro) {
        this.tiporetiro = tiporetiro;
    }

    public BigDecimal getTipocalculo() {
        return tipocalculo;
    }

    public void setTipocalculo(BigDecimal tipocalculo) {
        this.tipocalculo = tipocalculo;
    }

    public BigDecimal getTasaio() {
        return tasaio;
    }

    public void setTasaio(BigDecimal tasaio) {
        this.tasaio = tasaio;
    }

    public BigDecimal getTasaiod() {
        return tasaiod;
    }

    public void setTasaiod(BigDecimal tasaiod) {
        this.tasaiod = tasaiod;
    }

    public BigDecimal getTasaim() {
        return tasaim;
    }

    public void setTasaim(BigDecimal tasaim) {
        this.tasaim = tasaim;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getIvaim() {
        return ivaim;
    }

    public void setIvaim(BigDecimal ivaim) {
        this.ivaim = ivaim;
    }

    public BigDecimal getGarantias() {
        return garantias;
    }

    public void setGarantias(BigDecimal garantias) {
        this.garantias = garantias;
    }

    public BigDecimal getAvales() {
        return avales;
    }

    public void setAvales(BigDecimal avales) {
        this.avales = avales;
    }

    public boolean isReqsocio() {
        return reqsocio;
    }

    public void setReqsocio(boolean reqsocio) {
        this.reqsocio = reqsocio;
    }

    public Integer getTipoamortizacion() {
        return tipoamortizacion;
    }

    public void setTipoamortizacion(Integer tipoamortizacion) {
        this.tipoamortizacion = tipoamortizacion;
    }

    public BigDecimal getMaxeventos() {
        return maxeventos;
    }

    public void setMaxeventos(BigDecimal maxeventos) {
        this.maxeventos = maxeventos;
    }

    public BigDecimal getMaxdv() {
        return maxdv;
    }

    public void setMaxdv(BigDecimal maxdv) {
        this.maxdv = maxdv;
    }

    public String getSaldominimo() {
        return saldominimo;
    }

    public void setSaldominimo(String saldominimo) {
        this.saldominimo = saldominimo;
    }

    public String getSaldomaximo() {
        return saldomaximo;
    }

    public void setSaldomaximo(String saldomaximo) {
        this.saldomaximo = saldomaximo;
    }

    public String getCuentageprcc() {
        return cuentageprcc;
    }

    public void setCuentageprcc(String cuentageprcc) {
        this.cuentageprcc = cuentageprcc;
    }

    public String getCuentageprci() {
        return cuentageprci;
    }

    public void setCuentageprci(String cuentageprci) {
        this.cuentageprci = cuentageprci;
    }

    public String getCuentaeprcc() {
        return cuentaeprcc;
    }

    public void setCuentaeprcc(String cuentaeprcc) {
        this.cuentaeprcc = cuentaeprcc;
    }

    public String getCuentaeprci() {
        return cuentaeprci;
    }

    public void setCuentaeprci(String cuentaeprci) {
        this.cuentaeprci = cuentaeprci;
    }

    public String getCuentaoimd() {
        return cuentaoimd;
    }

    public void setCuentaoimd(String cuentaoimd) {
        this.cuentaoimd = cuentaoimd;
    }

    public String getCuentaoima() {
        return cuentaoima;
    }

    public void setCuentaoima(String cuentaoima) {
        this.cuentaoima = cuentaoima;
    }

    public String getCuentaoioa() {
        return cuentaoioa;
    }

    public void setCuentaoioa(String cuentaoioa) {
        this.cuentaoioa = cuentaoioa;
    }

    public String getCuentaivaim() {
        return cuentaivaim;
    }

    public void setCuentaivaim(String cuentaivaim) {
        this.cuentaivaim = cuentaivaim;
    }

    public String getCuentaivaidncvig() {
        return cuentaivaidncvig;
    }

    public void setCuentaivaidncvig(String cuentaivaidncvig) {
        this.cuentaivaidncvig = cuentaivaidncvig;
    }

    public String getCuentaivaidncven() {
        return cuentaivaidncven;
    }

    public void setCuentaivaidncven(String cuentaivaidncven) {
        this.cuentaivaidncven = cuentaivaidncven;
    }

    public String getCuentaivappidnc() {
        return cuentaivappidnc;
    }

    public void setCuentaivappidnc(String cuentaivappidnc) {
        this.cuentaivappidnc = cuentaivappidnc;
    }

    public String getCuentaintordv() {
        return cuentaintordv;
    }

    public void setCuentaintordv(String cuentaintordv) {
        this.cuentaintordv = cuentaintordv;
    }

    public Integer getPlazomax() {
        return plazomax;
    }

    public void setPlazomax(Integer plazomax) {
        this.plazomax = plazomax;
    }

    public Integer getTipofinalidad() {
        return tipofinalidad;
    }

    public void setTipofinalidad(Integer tipofinalidad) {
        this.tipofinalidad = tipofinalidad;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    public Integer getPagodiafijo() {
        return pagodiafijo;
    }

    public void setPagodiafijo(Integer pagodiafijo) {
        this.pagodiafijo = pagodiafijo;
    }

    public Integer getCant_aperturas() {
        return cant_aperturas;
    }

    public void setCant_aperturas(Integer cant_aperturas) {
        this.cant_aperturas = cant_aperturas;
    }

    public Integer getProducto_padre() {
        return producto_padre;
    }

    public void setProducto_padre(Integer producto_padre) {
        this.producto_padre = producto_padre;
    }

    public BigDecimal getTasasp() {
        return tasasp;
    }

    public void setTasasp(BigDecimal tasasp) {
        this.tasasp = tasasp;
    }

    public BigDecimal getIvasp() {
        return ivasp;
    }

    public void setIvasp(BigDecimal ivasp) {
        this.ivasp = ivasp;
    }

    public String getCuentasp() {
        return cuentasp;
    }

    public void setCuentasp(String cuentasp) {
        this.cuentasp = cuentasp;
    }

    public String getCuentaivasp() {
        return cuentaivasp;
    }

    public void setCuentaivasp(String cuentaivasp) {
        this.cuentaivasp = cuentaivasp;
    }

    public Integer getTolerancia_im() {
        return tolerancia_im;
    }

    public void setTolerancia_im(Integer tolerancia_im) {
        this.tolerancia_im = tolerancia_im;
    }

    public Integer getTolerancia_com_no_pago() {
        return tolerancia_com_no_pago;
    }

    public void setTolerancia_com_no_pago(Integer tolerancia_com_no_pago) {
        this.tolerancia_com_no_pago = tolerancia_com_no_pago;
    }

    public BigDecimal getMonto_com_no_pago() {
        return monto_com_no_pago;
    }

    public void setMonto_com_no_pago(BigDecimal monto_com_no_pago) {
        this.monto_com_no_pago = monto_com_no_pago;
    }

    public BigDecimal getComision_apertura() {
        return comision_apertura;
    }

    public void setComision_apertura(BigDecimal comision_apertura) {
        this.comision_apertura = comision_apertura;
    }

    public String getRango_edad() {
        return rango_edad;
    }

    public void setRango_edad(String rango_edad) {
        this.rango_edad = rango_edad;
    }

    public String getEvalua_aperturas() {
        return evalua_aperturas;
    }

    public void setEvalua_aperturas(String evalua_aperturas) {
        this.evalua_aperturas = evalua_aperturas;
    }

    public String getCuentaintmorv() {
        return cuentaintmorv;
    }

    public void setCuentaintmorv(String cuentaintmorv) {
        this.cuentaintmorv = cuentaintmorv;
    }

    public String getCuentaidncmres() {
        return cuentaidncmres;
    }

    public void setCuentaidncmres(String cuentaidncmres) {
        this.cuentaidncmres = cuentaidncmres;
    }

    public String getCuentaidncm() {
        return cuentaidncm;
    }

    public void setCuentaidncm(String cuentaidncm) {
        this.cuentaidncm = cuentaidncm;
    }

    public String getCuentaidncmv() {
        return cuentaidncmv;
    }

    public void setCuentaidncmv(String cuentaidncmv) {
        this.cuentaidncmv = cuentaidncmv;
    }

    public String getCuentageprcim() {
        return cuentageprcim;
    }

    public void setCuentageprcim(String cuentageprcim) {
        this.cuentageprcim = cuentageprcim;
    }

    public String getCuentaeprcim() {
        return cuentaeprcim;
    }

    public void setCuentaeprcim(String cuentaeprcim) {
        this.cuentaeprcim = cuentaeprcim;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.idproducto);
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
        final ProductosDTO other = (ProductosDTO) obj;
        return Objects.equals(this.idproducto, other.idproducto);
    }

    @Override
    public String toString() {
        return "ProductosDTO{" + "idproducto=" + idproducto + ", nombre=" + nombre + ", idorigen=" + idorigen + ", cuentaaplica=" + cuentaaplica + ", cuentavencida=" + cuentavencida + ", cuentaintord=" + cuentaintord + ", cuentaidnc=" + cuentaidnc + ", cuentaidncv=" + cuentaidncv + ", cuentaidncres=" + cuentaidncres + ", cuentaoiod=" + cuentaoiod + ", cuentaintmor=" + cuentaintmor + ", cuentaiva=" + cuentaiva + ", cuentarc=" + cuentarc + ", cuentari=" + cuentari + ", tipoproducto=" + tipoproducto + ", tiporetiro=" + tiporetiro + ", tipocalculo=" + tipocalculo + ", tasaio=" + tasaio + ", tasaiod=" + tasaiod + ", tasaim=" + tasaim + ", iva=" + iva + ", ivaim=" + ivaim + ", garantias=" + garantias + ", avales=" + avales + ", reqsocio=" + reqsocio + ", tipoamortizacion=" + tipoamortizacion + ", maxeventos=" + maxeventos + ", maxdv=" + maxdv + ", saldominimo=" + saldominimo + ", saldomaximo=" + saldomaximo + ", cuentageprcc=" + cuentageprcc + ", cuentageprci=" + cuentageprci + ", cuentaeprcc=" + cuentaeprcc + ", cuentaeprci=" + cuentaeprci + ", cuentaoimd=" + cuentaoimd + ", cuentaoima=" + cuentaoima + ", cuentaoioa=" + cuentaoioa + ", cuentaivaim=" + cuentaivaim + ", cuentaivaidncvig=" + cuentaivaidncvig + ", cuentaivaidncven=" + cuentaivaidncven + ", cuentaivappidnc=" + cuentaivappidnc + ", cuentaintordv=" + cuentaintordv + ", plazomax=" + plazomax + ", tipofinalidad=" + tipofinalidad + ", activo=" + activo + ", pagodiafijo=" + pagodiafijo + ", cant_aperturas=" + cant_aperturas + ", producto_padre=" + producto_padre + ", tasasp=" + tasasp + ", ivasp=" + ivasp + ", cuentasp=" + cuentasp + ", cuentaivasp=" + cuentaivasp + ", tolerancia_im=" + tolerancia_im + ", tolerancia_com_no_pago=" + tolerancia_com_no_pago + ", monto_com_no_pago=" + monto_com_no_pago + ", comision_apertura=" + comision_apertura + ", rango_edad=" + rango_edad + ", evalua_aperturas=" + evalua_aperturas + ", cuentaintmorv=" + cuentaintmorv + ", cuentaidncmres=" + cuentaidncmres + ", cuentaidncm=" + cuentaidncm + ", cuentaidncmv=" + cuentaidncmv + ", cuentageprcim=" + cuentageprcim + ", cuentaeprcim=" + cuentaeprcim + '}';
    }

}
