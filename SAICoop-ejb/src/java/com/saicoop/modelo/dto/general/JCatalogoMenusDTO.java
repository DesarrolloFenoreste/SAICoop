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
@XmlRootElement(name = "jCatalogoMenusDTO")
public class JCatalogoMenusDTO implements Serializable {

    private Integer idmenu;
    private Integer dependede;
    private String nombre;
    private String descripcion;
    private Integer orden;
    private String jar;
    private String permiso;
    private Boolean estatus;

    public JCatalogoMenusDTO() {
    }

    public JCatalogoMenusDTO(Integer idmenu, Integer dependede, String nombre, String descripcion, Integer orden, String jar, String permiso, boolean estatus) {
        this.idmenu = idmenu;
        this.dependede = dependede;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.orden = orden;
        this.jar = jar;
        this.permiso = permiso;
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "JCatalogoMenusDTO{" + "idmenu=" + idmenu + ", dependede=" + dependede + ", nombre=" + nombre + ", descripcion=" + descripcion + ", orden=" + orden + ", jar=" + jar + ", permiso=" + permiso + ", estatus=" + estatus + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.idmenu;
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
        final JCatalogoMenusDTO other = (JCatalogoMenusDTO) obj;
        return Objects.equals(this.idmenu, other.idmenu);
    }

    public Integer getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(Integer idmenu) {
        this.idmenu = idmenu;
    }

    public Integer getDependede() {
        return dependede;
    }

    public void setDependede(Integer dependede) {
        this.dependede = dependede;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getJar() {
        return jar;
    }

    public void setJar(String jar) {
        this.jar = jar;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

}
