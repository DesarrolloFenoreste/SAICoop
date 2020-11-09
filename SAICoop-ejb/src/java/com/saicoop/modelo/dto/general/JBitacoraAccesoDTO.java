/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.dto.general;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author prometeo
 */
@XmlRootElement(name = "jBitacoraAccesoDTO")
public class JBitacoraAccesoDTO implements Serializable {

    private LocalDate fecha;
    private String modulo;
    private Integer idaccion;
    private Integer idusuario;
    private LocalDateTime fechatrabajo;

    public JBitacoraAccesoDTO() {
    }

    @Override
    public String toString() {
        return "JBitacoraAccesoDTO{" + "fecha=" + fecha + ", modulo=" + modulo + ", idaccion=" + idaccion + ", idusuario=" + idusuario + ", fechatrabajo=" + fechatrabajo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.fecha);
        hash = 41 * hash + this.idaccion;
        hash = 41 * hash + this.idusuario;
        hash = 41 * hash + Objects.hashCode(this.fechatrabajo);
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
        final JBitacoraAccesoDTO other = (JBitacoraAccesoDTO) obj;
        if (!Objects.equals(this.idaccion, other.idaccion)) {
            return false;
        }
        if (!Objects.equals(this.idusuario, other.idusuario)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return Objects.equals(this.fechatrabajo, other.fechatrabajo);
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public Integer getIdaccion() {
        return idaccion;
    }

    public void setIdaccion(Integer idaccion) {
        this.idaccion = idaccion;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public LocalDateTime getFechatrabajo() {
        return fechatrabajo;
    }

    public void setFechatrabajo(LocalDateTime fechatrabajo) {
        this.fechatrabajo = fechatrabajo;
    }

}
