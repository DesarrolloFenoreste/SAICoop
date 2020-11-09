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
@XmlRootElement(name = "finalidadesDTO")
public class FinalidadesDTO implements Serializable{

    private Integer idfinalidad = -1;
    private String descripcion;
    private Integer dependede = -1;
    private Long clasif_contable_siti;

    public FinalidadesDTO() {
    }

    public FinalidadesDTO(Integer idfinalidad, String descripcion, Integer dependede, Long clasif_contable_siti) {
        this.idfinalidad = idfinalidad;
        this.descripcion = descripcion;
        this.dependede = dependede;
        this.clasif_contable_siti = clasif_contable_siti;
    }

    public Integer getIdfinalidad() {
        return idfinalidad;
    }

    public void setIdfinalidad(Integer idfinalidad) {
        this.idfinalidad = idfinalidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getDependede() {
        return dependede;
    }

    public void setDependede(Integer dependede) {
        this.dependede = dependede;
    }

    public Long getClasif_contable_siti() {
        return clasif_contable_siti;
    }

    public void setClasif_contable_siti(Long clasif_contable_siti) {
        this.clasif_contable_siti = clasif_contable_siti;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.idfinalidad;
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
        final FinalidadesDTO other = (FinalidadesDTO) obj;
        return Objects.equals(this.idfinalidad, other.idfinalidad);
    }

    @Override
    public String toString() {
        return "FinalidadesDTO{" + "idfinalidad=" + idfinalidad + ", descripcion=" + descripcion + ", dependede=" + dependede + ", clasif_contable_siti=" + clasif_contable_siti + '}';
    }

}
