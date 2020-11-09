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
@XmlRootElement(name = "jMenuValidacionGeneralHuellaDTO")
public class JMenuValidacionGeneralHuellaDTO implements Serializable {
    
    private String modulo;
    private String descripcion;

    public JMenuValidacionGeneralHuellaDTO() {
    }

    public JMenuValidacionGeneralHuellaDTO(String modulo, String descripcion) {
        this.modulo = modulo;
        this.descripcion = descripcion;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.modulo);
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
        final JMenuValidacionGeneralHuellaDTO other = (JMenuValidacionGeneralHuellaDTO) obj;
        return Objects.equals(this.modulo, other.modulo);
    }

    @Override
    public String toString() {
        return "JMenuValidacionGeneralHuellaDTO{" + "modulo=" + modulo + ", descripcion=" + descripcion + '}';
    }

}
