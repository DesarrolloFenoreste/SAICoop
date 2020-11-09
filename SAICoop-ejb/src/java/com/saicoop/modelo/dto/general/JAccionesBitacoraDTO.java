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
@XmlRootElement(name = "jAccionesBitacoraDTO")
public class JAccionesBitacoraDTO implements Serializable {

    /*
     idaccion integer NOT NULL UNIQUE, 
     idmenu integer NOT NULL,
     descripcion character varying,
     */
    private Integer idaccion;
    private Integer idmenu;
    private String descripcion;

    public JAccionesBitacoraDTO() {
    }

    @Override
    public String toString() {
        return "JAccionesBitacoraDTO{" + "idaccion=" + idaccion + ", idmenu=" + idmenu + ", descripcion=" + descripcion + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.idaccion;
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
        final JAccionesBitacoraDTO other = (JAccionesBitacoraDTO) obj;
        return Objects.equals(this.idaccion, other.idaccion);
    }

    public Integer getIdaccion() {
        return idaccion;
    }

    public void setIdaccion(Integer idaccion) {
        this.idaccion = idaccion;
    }

    public Integer getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(Integer idmenu) {
        this.idmenu = idmenu;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   

}
