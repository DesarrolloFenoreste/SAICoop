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
@XmlRootElement(name = "jUsuariospermisosDTO")
public class JUsuariospermisosDTO implements Serializable {

    private Integer idusuario;//idusuario integer NOT NULL,
    private Integer idpermiso;//idpermiso character varying(30) NOT NULL,

    public JUsuariospermisosDTO() {
    }

    public JUsuariospermisosDTO(Integer idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public String toString() {
        return "UsuariospermisosDTO{" + "idusuario=" + idusuario + ", idpermiso=" + idpermiso + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.idusuario;
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
        final JUsuariospermisosDTO other = (JUsuariospermisosDTO) obj;
        return Objects.equals(this.idusuario, other.idusuario);
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getIdpermiso() {
        return idpermiso;
    }

    public void setIdpermiso(Integer idpermiso) {
        this.idpermiso = idpermiso;
    }

}
