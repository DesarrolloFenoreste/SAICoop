/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.dto.socio;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gerardo
 */
@XmlRootElement(name = "referenciasDTO")
public class ReferenciasDTO implements Serializable{

    private Integer idorigen;
    private Integer idgrupo;
    private Integer idsocio;
    private Short tiporeferencia;
    private String referencia;
    private Integer idorigenr;
    private Integer idgrupor;
    private Integer idsocior;

    public ReferenciasDTO() {
    }

    public ReferenciasDTO(int idorigen, int idgrupo, int idsocio, Short tiporeferencia) {
        this.idorigen = idorigen;
        this.idgrupo = idgrupo;
        this.idsocio = idsocio;
        this.tiporeferencia = tiporeferencia;
    }

    public int getIdorigen() {
        return idorigen;
    }

    public void setIdorigen(int idorigen) {
        this.idorigen = idorigen;
    }

    public int getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(int idgrupo) {
        this.idgrupo = idgrupo;
    }

    public int getIdsocio() {
        return idsocio;
    }

    public void setIdsocio(int idsocio) {
        this.idsocio = idsocio;
    }

    public Short getTiporeferencia() {
        return tiporeferencia;
    }

    public void setTiporeferencia(Short tiporeferencia) {
        this.tiporeferencia = tiporeferencia;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getIdorigenr() {
        return idorigenr;
    }

    public void setIdorigenr(int idorigenr) {
        this.idorigenr = idorigenr;
    }

    public int getIdgrupor() {
        return idgrupor;
    }

    public void setIdgrupor(int idgrupor) {
        this.idgrupor = idgrupor;
    }

    public int getIdsocior() {
        return idsocior;
    }

    public void setIdsocior(int idsocior) {
        this.idsocior = idsocior;
    }

    @Override
    public String toString() {
        return "ReferenciasDTO{" + "idorigen=" + idorigen + ", idgrupo=" + idgrupo + ", idsocio=" + idsocio + ", tiporeferencia=" + tiporeferencia + ", referencia=" + referencia + ", idorigenr=" + idorigenr + ", idgrupor=" + idgrupor + ", idsocior=" + idsocior + '}';
    }

}
