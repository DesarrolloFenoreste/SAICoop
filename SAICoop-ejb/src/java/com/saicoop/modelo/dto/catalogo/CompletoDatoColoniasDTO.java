/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.dto.catalogo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gerardo
 */

@XmlRootElement(name = "completoDatoColoniasDTO")
public class CompletoDatoColoniasDTO implements Serializable {

    private Integer idcolonia;
    private String colonia;
    private String codigopostal;
    private Integer idmunicipio;
    private String municipio;
    private BigDecimal poblacion;
    private Long localidad_siti;
    private String de_cp;
    private String a_cp;
    private Integer idestado;
    private String estado;
    private String ef;
    private Integer idpais;

    public CompletoDatoColoniasDTO() {
    }

    public Integer getIdcolonia() {
        return idcolonia;
    }

    public void setIdcolonia(Integer idcolonia) {
        this.idcolonia = idcolonia;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public Integer getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(Integer idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public BigDecimal getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(BigDecimal poblacion) {
        this.poblacion = poblacion;
    }

    public Long getLocalidad_siti() {
        return localidad_siti;
    }

    public void setLocalidad_siti(Long localidad_siti) {
        this.localidad_siti = localidad_siti;
    }

    public String getDe_cp() {
        return de_cp;
    }

    public void setDe_cp(String de_cp) {
        this.de_cp = de_cp;
    }

    public String getA_cp() {
        return a_cp;
    }

    public void setA_cp(String a_cp) {
        this.a_cp = a_cp;
    }

    public Integer getIdestado() {
        return idestado;
    }

    public void setIdestado(Integer idestado) {
        this.idestado = idestado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEf() {
        return ef;
    }

    public void setEf(String ef) {
        this.ef = ef;
    }

    public Integer getIdpais() {
        return idpais;
    }

    public void setIdpais(Integer idpais) {
        this.idpais = idpais;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.idcolonia);
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
        final CompletoDatoColoniasDTO other = (CompletoDatoColoniasDTO) obj;
        return Objects.equals(this.idcolonia, other.idcolonia);
    }

    @Override
    public String toString() {
        return "CompletoDatoColoniasDTO{" + "idcolonia=" + idcolonia + ", colonia=" + colonia + ", codigopostal=" + codigopostal + ", idmunicipio=" + idmunicipio + ", municipio=" + municipio + ", poblacion=" + poblacion + ", localidad_siti=" + localidad_siti + ", de_cp=" + de_cp + ", a_cp=" + a_cp + ", idestado=" + idestado + ", estado=" + estado + ", ef=" + ef + ", idpais=" + idpais + '}';
    }

}
