/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.dto.util;

import java.math.BigDecimal;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author prometeo
 */
@XmlRootElement(name = "tipoCambioDolarDTO")
public class TipoCambioDolarDTO {

    private Object fechatrabajo;
    private Integer idusuario;
    private BigDecimal tipo_cambio;
    private Object fecha;

    public TipoCambioDolarDTO() {
    }

    public TipoCambioDolarDTO(String fechatrabajo, Integer idusuario, BigDecimal tipo_cambio, Object fecha) {
        this.fechatrabajo = fechatrabajo;
        this.idusuario = idusuario;
        this.tipo_cambio = tipo_cambio;
        this.fecha = fecha;
    }

    public Object getFechatrabajo() {
        return fechatrabajo;
    }

    public void setFechatrabajo(Object fechatrabajo) {
        this.fechatrabajo = fechatrabajo;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public BigDecimal getTipo_cambio() {
        return tipo_cambio;
    }

    public void setTipo_cambio(BigDecimal tipo_cambio) {
        this.tipo_cambio = tipo_cambio;
    }

    public Object getFecha() {
        return fecha;
    }

    public void setFecha(Object fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.fechatrabajo);
        hash = 23 * hash + Objects.hashCode(this.fecha);
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
        final TipoCambioDolarDTO other = (TipoCambioDolarDTO) obj;
        if (!Objects.equals(this.fechatrabajo, other.fechatrabajo)) {
            return false;
        }
        return Objects.equals(this.fecha, other.fecha);
    }

    @Override
    public String toString() {
        return "TipoCambioDolarDTO{" + "fechatrabajo=" + fechatrabajo + ", idusuario=" + idusuario + ", tipo_cambio=" + tipo_cambio + ", fecha=" + fecha + '}';
    }
    
}
