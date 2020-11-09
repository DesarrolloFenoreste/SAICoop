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
@XmlRootElement(name = "catalogomenusdto")
public class CatalogoMenusDTO implements Serializable {

    /*
    CREATE TABLE catalogo_menus
    (
    menu character varying NOT NULL,
    opcion integer NOT NULL,
    descripcion character varying,
    orden integer,
    activo boolean,
    referencia character varying,
    CONSTRAINT catalogo_menus_pkey PRIMARY KEY (menu, opcion)
    )
     */
    String menu;
    Integer opcion;
    String descripcion;
    Integer orden;
    Boolean activo;
    String referencia;

    public CatalogoMenusDTO() {
    }

    public CatalogoMenusDTO(String menu, Integer opcion, String descripcion, Integer orden, Boolean activo, String referencia) {
        this.menu = menu;
        this.opcion = opcion;
        this.descripcion = descripcion;
        this.orden = orden;
        this.activo = activo;
        this.referencia = referencia;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.menu);
        hash = 31 * hash + Objects.hashCode(this.opcion);
        return hash;
    }

    @Override
    public String toString() {
        return "CatalogoMenusDTO{" + "menu=" + menu + ", opcion=" + opcion + ", descripcion=" + descripcion + ", orden=" + orden + ", activo=" + activo + ", referencia=" + referencia + '}';
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
        final CatalogoMenusDTO other = (CatalogoMenusDTO) obj;
        if (!Objects.equals(this.menu, other.menu)) {
            return false;
        }
        if (!Objects.equals(this.opcion, other.opcion)) {
            return false;
        }
        return true;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public Integer getOpcion() {
        return opcion;
    }

    public void setOpcion(Integer opcion) {
        this.opcion = opcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

}
