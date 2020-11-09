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
@XmlRootElement(name = "jUsuariosugruposDTO")
public class JUsuariosugruposDTO implements Serializable {

    private Integer idusuario;//idusuario integer,
    private Integer idugrupo; //idugrupo integer,

    public JUsuariosugruposDTO() {
    }

    public JUsuariosugruposDTO(Integer idusuario, Integer idugrupo) {
        this.idusuario = idusuario;
        this.idugrupo = idugrupo;
    }

    @Override
    public String toString() {
        return "UsuariosugruposDTO{" + "idusuario=" + idusuario + ", idugrupo=" + idugrupo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.idusuario;
        hash = 83 * hash + this.idugrupo;
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
        final JUsuariosugruposDTO other = (JUsuariosugruposDTO) obj;
        if (!Objects.equals(this.idusuario, other.idusuario)) {
            return false;
        }
        return Objects.equals(this.idugrupo, other.idugrupo);
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getIdugrupo() {
        return idugrupo;
    }

    public void setIdugrupo(Integer idugrupo) {
        this.idugrupo = idugrupo;
    }

}
