/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.dto.general;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gerardo
 */
@XmlRootElement(name = "huellasDpUsuarioDDTO")
public class HuellasDpUsuarioDDTO implements Serializable {

    private Integer capturo;
    private Integer idusuario;
    private Integer formatohuella;
    private Object fecha;

    public HuellasDpUsuarioDDTO() {
    }

    public HuellasDpUsuarioDDTO(Integer capturo, Integer idusuario, Integer formatohuella, Object fecha) {
        this.capturo = capturo;
        this.idusuario = idusuario;
        this.formatohuella = formatohuella;
        this.fecha = fecha;
    }

    public Integer getCapturo() {
        return capturo;
    }

    public void setCapturo(Integer capturo) {
        this.capturo = capturo;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getFormatohuella() {
        return formatohuella;
    }

    public void setFormatohuella(Integer formatohuella) {
        this.formatohuella = formatohuella;
    }

    public Object getFecha() {
        return fecha;
    }

    public void setFecha(Object fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idusuario);
        hash = 97 * hash + Objects.hashCode(this.fecha);
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
        final HuellasDpUsuarioDDTO other = (HuellasDpUsuarioDDTO) obj;
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return Objects.equals(this.idusuario, other.idusuario);
    }

    @Override
    public String toString() {
        return "HuellasDpUsuarioDDTO{" + "capturo=" + capturo + ", idusuario=" + idusuario + ", formatohuella=" + formatohuella + ", fecha=" + fecha + '}';
    }

}
