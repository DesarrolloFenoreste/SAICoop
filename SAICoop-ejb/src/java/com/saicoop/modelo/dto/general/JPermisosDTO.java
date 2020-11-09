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
@XmlRootElement(name = "jPermisosDTO")
public class JPermisosDTO implements Serializable {

    /*
        idpermiso integer NOT NULL,
        permiso character varying(50),
        idmenu integer NOT NULL,
        descripcion character varying(100),
        estatus boolean NOT NULL,
     */
    private Integer idpermiso;
    private String permiso;
    private Integer idmenu;
    private String descripcion;
    private Boolean estatus;

    public JPermisosDTO() {
    }

    public JPermisosDTO(Integer idpermiso, String permiso, Integer idmenu, String descripcion, Boolean estatus) {
        this.idpermiso = idpermiso;
        this.permiso = permiso;
        this.idmenu = idmenu;
        this.descripcion = descripcion;
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "JPermisosDTO{" + "idpermiso=" + idpermiso + ", permiso=" + permiso + ", idmenu=" + idmenu + ", descripcion=" + descripcion + ", estatus=" + estatus + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.idpermiso);
        hash = 23 * hash + Objects.hashCode(this.idmenu);
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
        final JPermisosDTO other = (JPermisosDTO) obj;
        if (!Objects.equals(this.idpermiso, other.idpermiso)) {
            return false;
        }
        return Objects.equals(this.idmenu, other.idmenu);
    }

    public Integer getIdpermiso() {
        return idpermiso;
    }

    public void setIdpermiso(Integer idpermiso) {
        this.idpermiso = idpermiso;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
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

    public Boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }

}
