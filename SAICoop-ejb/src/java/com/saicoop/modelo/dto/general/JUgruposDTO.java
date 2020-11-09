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
@XmlRootElement(name = "jUgruposDTO")
public class JUgruposDTO implements Serializable {

    private Integer idugrupo;//idugrupo integer NOT NULL,
    private String nombre;//nombre character varying(30),

    public JUgruposDTO() {
    }

    public JUgruposDTO(Integer idugrupo) {
        this.idugrupo = idugrupo;
    }

    @Override
    public String toString() {
        return "UgruposDTO{" + "idugrupo=" + idugrupo + ", nombre=" + nombre + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idugrupo);
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
        final JUgruposDTO other = (JUgruposDTO) obj;
        return Objects.equals(this.idugrupo, other.idugrupo);
    }

    public Integer getIdugrupo() {
        return idugrupo;
    }

    public void setIdugrupo(Integer idugrupo) {
        this.idugrupo = idugrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
