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
@XmlRootElement(name = "huellasDpDTO")
public class HuellasDpDTO implements Serializable {

    private Integer idorigen;
    private Integer idgrupo;
    private Integer idsocio;
    private Integer dedo;
    private byte[] huella;

    public HuellasDpDTO() {
    }

    public HuellasDpDTO(Integer idorigen, Integer idgrupo, Integer idsocio, Integer dedo, byte[] huella) {
        this.idorigen = idorigen;
        this.idgrupo = idgrupo;
        this.idsocio = idsocio;
        this.dedo = dedo;
        this.huella = huella;
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

    public Integer getDedo() {
        return dedo;
    }

    public void setDedo(Integer dedo) {
        this.dedo = dedo;
    }

    public byte[] getHuella() {
        return huella;
    }

    public void setHuella(byte[] huella) {
        this.huella = huella;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idorigen;
        hash = 97 * hash + this.idgrupo;
        hash = 97 * hash + this.idsocio;
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
        final HuellasDpDTO other = (HuellasDpDTO) obj;
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
        return "HuellasDpDTO{" + "idorigen=" + idorigen + ", idgrupo=" + idgrupo + ", idsocio=" + idsocio + ", dedo=" + dedo + ", huella=" + huella + '}';
    }

}
