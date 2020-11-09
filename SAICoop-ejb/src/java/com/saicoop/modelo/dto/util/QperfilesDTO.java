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
@XmlRootElement(name = "qperfilesDTO")
public class QperfilesDTO implements Serializable {

    private Integer idquery = -1;
    private Integer idugrupo = -1;

    public QperfilesDTO() {
    }

    public QperfilesDTO(Integer idquery, Integer idugrupo) {
        this.idquery = idquery;
        this.idugrupo = idugrupo;
    }

    public Integer getIdquery() {
        return idquery;
    }

    public void setIdquery(Integer idquery) {
        this.idquery = idquery;
    }

    public Integer getIdugrupo() {
        return idugrupo;
    }

    public void setIdugrupo(Integer idugrupo) {
        this.idugrupo = idugrupo;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.idquery);
        hash = 43 * hash + Objects.hashCode(this.idugrupo);
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
        final QperfilesDTO other = (QperfilesDTO) obj;
        if (!Objects.equals(this.idquery, other.idquery)) {
            return false;
        }
        return Objects.equals(this.idugrupo, other.idugrupo);
    }
    
    @Override
    public String toString() {
        return "QperfilesDTO{" + "idquery=" + idquery + ", idugrupo=" + idugrupo + '}';
    }

}
