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
 * @author prometeo
 */
@XmlRootElement(name = "jUgruposPermisosDTO")
public class JUgruposPermisosDTO implements Serializable {

    private Integer idugrupo;
    private Integer idpermiso;

    public JUgruposPermisosDTO() {
    }

    public JUgruposPermisosDTO(int idugrupo, int idpermiso) {
        this.idugrupo = idugrupo;
        this.idpermiso = idpermiso;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idugrupo;
        hash = 97 * hash + Objects.hashCode(this.idpermiso);
        return hash;
    }

    @Override
    public String toString() {
        return "UgruposPermisosDTO{" + "idugrupo=" + idugrupo + ", idpermiso=" + idpermiso + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JUgruposPermisosDTO other = (JUgruposPermisosDTO) obj;
        if (!Objects.equals(this.idugrupo, other.idugrupo)) {
            return false;
        }
        return Objects.equals(this.idpermiso, other.idpermiso);
    }

    public Integer getIdugrupo() {
        return idugrupo;
    }

    public void setIdugrupo(Integer idugrupo) {
        this.idugrupo = idugrupo;
    }

    public Integer getIdpermiso() {
        return idpermiso;
    }

    public void setIdpermiso(Integer idpermiso) {
        this.idpermiso = idpermiso;
    }
}
