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
 * @author prometeo
 */
@XmlRootElement(name = "queryDTO")
public class QueryDTO implements Serializable {

    private Integer idquery = -1;
    private String descripcion = null;
    private String query;
    private Boolean editable;
    private Boolean remota;

    public QueryDTO() {
    }

    public Integer getIdquery() {
        return idquery;
    }

    public void setIdquery(Integer idquery) {
        this.idquery = idquery;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public Boolean getRemota() {
        return remota;
    }

    public void setRemota(Boolean remota) {
        this.remota = remota;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idquery);
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
        final QueryDTO other = (QueryDTO) obj;
        return Objects.equals(this.idquery, other.idquery);
    }

    @Override
    public String toString() {
        return "QueryDTO{" + "idquery=" + idquery + ", descripcion=" + descripcion + ", query=" + query + ", editable=" + editable + ", remota=" + remota + '}';
    }

}
