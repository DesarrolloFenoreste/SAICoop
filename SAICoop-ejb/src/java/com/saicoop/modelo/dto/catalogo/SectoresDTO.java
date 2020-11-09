/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.dto.catalogo;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author prometeo
 */
@XmlRootElement(name = "sectoresDTO")
public class SectoresDTO implements Serializable {

    Integer idsector;
    String nombre;

    public SectoresDTO() {
    }

    public SectoresDTO(Integer idsector, String nombre) {
        this.idsector = idsector;
        this.nombre = nombre;
    }

    public Integer getIdsector() {
        return idsector;
    }

    public void setIdsector(Integer idsector) {
        this.idsector = idsector;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idsector;
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
        final SectoresDTO other = (SectoresDTO) obj;
        return Objects.equals(this.idsector, other.idsector);
    }

    @Override
    public String toString() {
        return "SectoresDTO{" + "idsector=" + idsector + ", nombre=" + nombre + '}';
    }

}
