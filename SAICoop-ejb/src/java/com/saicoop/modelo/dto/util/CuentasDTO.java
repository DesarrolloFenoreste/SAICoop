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
@XmlRootElement(name = "cuentasdto")
public class CuentasDTO implements Serializable {

    private Integer idorigenc;
    private String idcuenta;
    private String nombre;
    private String dependede;
    private BigDecimal tipo;
    private BigDecimal naturaleza;
    private BigDecimal clase;
    private Boolean activa;
    private Boolean original;
    private Object fecha_cambio;
    private String clavesiti;
    private Integer nivel;
    private BigDecimal codigo_agrupador;

    public CuentasDTO() {
    }

    public CuentasDTO(Integer idorigenc, String idcuenta) {
        this.idorigenc = idorigenc;
        this.idcuenta = idcuenta;
    }

    public Integer getIdorigenc() {
        return idorigenc;
    }

    public void setIdorigenc(Integer idorigenc) {
        this.idorigenc = idorigenc;
    }

    public String getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(String idcuenta) {
        this.idcuenta = idcuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDependede() {
        return dependede;
    }

    public void setDependede(String dependede) {
        this.dependede = dependede;
    }

    public BigDecimal getTipo() {
        return tipo;
    }

    public void setTipo(BigDecimal tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(BigDecimal naturaleza) {
        this.naturaleza = naturaleza;
    }

    public BigDecimal getClase() {
        return clase;
    }

    public void setClase(BigDecimal clase) {
        this.clase = clase;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public boolean isOriginal() {
        return original;
    }

    public void setOriginal(boolean original) {
        this.original = original;
    }

    public Object getFechaCambio() {
        return fecha_cambio;
    }

    public void setFechaCambio(Object fechaCambio) {
        this.fecha_cambio = fechaCambio;
    }

    public String getClavesiti() {
        return clavesiti;
    }

    public void setClavesiti(String clavesiti) {
        this.clavesiti = clavesiti;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public BigDecimal getCodigoAgrupador() {
        return codigo_agrupador;
    }

    public void setCodigoAgrupador(BigDecimal codigoAgrupador) {
        this.codigo_agrupador = codigoAgrupador;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.idorigenc;
        hash = 37 * hash + Objects.hashCode(this.idcuenta);
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
        final CuentasDTO other = (CuentasDTO) obj;
        if (!Objects.equals(this.idorigenc, other.idorigenc)) {
            return false;
        }
        return Objects.equals(this.idcuenta, other.idcuenta);
    }

    @Override
    public String toString() {
        return "CuentasDTO{" + "idorigenc=" + idorigenc + ", idcuenta=" + idcuenta + ", nombre=" + nombre + ", dependede=" + dependede + ", tipo=" + tipo + ", naturaleza=" + naturaleza + ", clase=" + clase + ", activa=" + activa + ", original=" + original + ", fechaCambio=" + fecha_cambio + ", clavesiti=" + clavesiti + ", nivel=" + nivel + ", codigoAgrupador=" + codigo_agrupador + '}';
    }
    
}
