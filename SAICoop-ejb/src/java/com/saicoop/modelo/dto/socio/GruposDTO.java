/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.dto.socio;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author prometeo
 */
@XmlRootElement(name = "gruposDTO")
public class GruposDTO implements Serializable {

    private Integer idgrupo;//idgrupo integer NOT NULL,
    private String nombre;//nombre character varying(30) NOT NULL,
    private Integer tipogrupo;//tipogrupo smallint,

    public GruposDTO() {
    }

    public Integer getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(Integer idgrupo) {
        this.idgrupo = idgrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTipogrupo() {
        return tipogrupo;
    }

    public void setTipogrupo(Integer tipogrupo) {
        this.tipogrupo = tipogrupo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.idgrupo);
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
        final GruposDTO other = (GruposDTO) obj;
        return Objects.equals(this.idgrupo, other.idgrupo);
    }

    @Override
    public String toString() {
        return idgrupo + " - " + nombre;
    }
 
}
