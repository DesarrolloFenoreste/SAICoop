/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.dto.socio;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gerardo
 */
@XmlRootElement(name = "huellasDpdDTO")
public class HuellasDpdDTO implements Serializable {

    private Integer idorigen;
    private Integer idgrupo;
    private Integer idsocio;
    private Object fecha;
    private Integer idusuario;
    private Integer dedo;

    public HuellasDpdDTO() {
    }

    public HuellasDpdDTO(Integer idorigen, Integer idgrupo, Integer idsocio, Object fecha, Integer idusuario, Integer dedo) {
        this.idorigen = idorigen;
        this.idgrupo = idgrupo;
        this.idsocio = idsocio;
        this.fecha = fecha;
        this.idusuario = idusuario;
        this.dedo = dedo;
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

    public Object getFecha() {
        return fecha;
    }

    public void setFecha(Object fecha) {
        this.fecha = fecha;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getDedo() {
        return dedo;
    }

    public void setDedo(Integer dedo) {
        this.dedo = dedo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.idorigen);
        hash = 47 * hash + Objects.hashCode(this.idgrupo);
        hash = 47 * hash + Objects.hashCode(this.idsocio);
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
        final HuellasDpdDTO other = (HuellasDpdDTO) obj;
        if (!Objects.equals(this.idorigen, other.idorigen)) {
            return false;
        }
        if (!Objects.equals(this.idgrupo, other.idgrupo)) {
            return false;
        }
        return Objects.equals(this.idsocio, other.idsocio);
    }

    @Override
    public String toString() {
        return "HuellasDpdDTO{" + "idorigen=" + idorigen + ", idgrupo=" + idgrupo + ", idsocio=" + idsocio + ", fecha=" + fecha + ", idusuario=" + idusuario + ", dedo=" + dedo + '}';
    }

}
