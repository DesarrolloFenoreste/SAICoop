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
@XmlRootElement(name = "polizasdto")
public class PolizasDTO implements Serializable {

    private Integer idorigenc;
    private String periodo;
    private Short idtipo;
    private Integer idpoliza;
    private String fecha;
    private String concepto;
    private Short estatus;
    private String referencia;
    private Boolean esresumen;
    private Integer idusuario;

    public PolizasDTO() {
    }

    public PolizasDTO(int idorigenc, Integer idusuario) {
        this.idorigenc = idorigenc;
        this.idusuario = idusuario;
    }

    public Integer getIdorigenc() {
        return idorigenc;
    }

    public void setIdorigenc(Integer idorigenc) {
        this.idorigenc = idorigenc;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public short getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(short idtipo) {
        this.idtipo = idtipo;
    }

    public Integer getIdpoliza() {
        return idpoliza;
    }

    public void setIdpoliza(Integer idpoliza) {
        this.idpoliza = idpoliza;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Short getEstatus() {
        return estatus;
    }

    public void setEstatus(Short estatus) {
        this.estatus = estatus;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Boolean getEsresumen() {
        return esresumen;
    }

    public void setEsresumen(Boolean esresumen) {
        this.esresumen = esresumen;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.idorigenc;
        hash = 31 * hash + Objects.hashCode(this.idusuario);
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
        final PolizasDTO other = (PolizasDTO) obj;
        if (!Objects.equals(this.idorigenc, other.idorigenc)) {
            return false;
        }
        return Objects.equals(this.idusuario, other.idusuario);
    }

    @Override
    public String toString() {
        return "PolizasDTO{" + "idorigenc=" + idorigenc + ", periodo=" + periodo + ", idtipo=" + idtipo + ", idpoliza=" + idpoliza + ", fecha=" + fecha + ", concepto=" + concepto + ", estatus=" + estatus + ", referencia=" + referencia + ", esresumen=" + esresumen + ", idusuario=" + idusuario + '}';
    }
    
}
