/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.dto.util;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gerardo
 */
@XmlRootElement(name = "huellasColaGuardadoDTO")
public class HuellasColaGuardadoDTO implements Serializable {

    private Integer idusuario = 0;
    private Integer idorigen = 0;
    private Integer idgrupo = 0;
    private Integer idsocio = 0;
    private Object fecha;

    public HuellasColaGuardadoDTO() {
    }

    public HuellasColaGuardadoDTO(int idorigen, int idgrupo, int idsocio) {
        this.idorigen = idorigen;
        this.idgrupo = idgrupo;
        this.idsocio = idsocio;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdorigen() {
        return idorigen;
    }

    public void setIdorigen(int idorigen) {
        this.idorigen = idorigen;
    }

    public int getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(int idgrupo) {
        this.idgrupo = idgrupo;
    }

    public int getIdsocio() {
        return idsocio;
    }

    public void setIdsocio(int idsocio) {
        this.idsocio = idsocio;
    }

    public Object getFecha() {
        return fecha;
    }

    public void setFecha(Object fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.idusuario);
        hash = 37 * hash + Objects.hashCode(this.idorigen);
        hash = 37 * hash + Objects.hashCode(this.idgrupo);
        hash = 37 * hash + Objects.hashCode(this.idsocio);
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
        final HuellasColaGuardadoDTO other = (HuellasColaGuardadoDTO) obj;
        if (!Objects.equals(this.idusuario, other.idusuario)) {
            return false;
        }
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
        return "HuellasColaGuardadoDTO{" + "idusuario=" + idusuario + ", idorigen=" + idorigen + ", idgrupo=" + idgrupo + ", idsocio=" + idsocio + ", fecha=" + fecha + '}';
    }

}
