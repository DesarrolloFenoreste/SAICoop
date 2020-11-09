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
@XmlRootElement(name = "origenesDTO")
public class OrigenesDTO implements Serializable {

    private Integer idorigen;
    private Integer matriz;
    private String nombre;
    private String calle;
    private String numeroext;
    private String numeroint;
    private String telefono1;
    private String telefono2;
    private Integer idestado;
    private Integer idmunicipio;
    private Integer idcolonia;
    private String codigopostal;
    private Boolean estatus;
    private Object fechatrabajo;
    private String cta_rendimientos;
    private String cta_quebrantos;
    private String cta_efectivo;
    private String cta_documentos1;
    private String cta_documentos2;
    private String cta_documentos3;
    private String cta_documentos4;
    private String cta_documentos5;
    private Boolean enlinea;
    private String cta_documentos6;
    private String cta_documentos7;

    public OrigenesDTO() {
    }

    public OrigenesDTO(Integer idorigen) {
        this.idorigen = idorigen;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.idorigen);
        return hash;
    }

    @Override
    public String toString() {
        return "OrigenesDTO{" + "idorigen=" + idorigen + ", matriz=" + matriz + ", nombre=" + nombre + ", calle=" + calle + ", numeroext=" + numeroext + ", numeroint=" + numeroint + ", telefono1=" + telefono1 + ", telefono2=" + telefono2 + ", idestado=" + idestado + ", idmunicipio=" + idmunicipio + ", idcolonia=" + idcolonia + ", codigopostal=" + codigopostal + ", estatus=" + estatus + ", fechatrabajo=" + fechatrabajo + ", cta_rendimientos=" + cta_rendimientos + ", cta_quebrantos=" + cta_quebrantos + ", cta_efectivo=" + cta_efectivo + ", cta_documentos1=" + cta_documentos1 + ", cta_documentos2=" + cta_documentos2 + ", cta_documentos3=" + cta_documentos3 + ", cta_documentos4=" + cta_documentos4 + ", cta_documentos5=" + cta_documentos5 + ", enlinea=" + enlinea + ", cta_documentos6=" + cta_documentos6 + ", cta_documentos7=" + cta_documentos7 + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrigenesDTO other = (OrigenesDTO) obj;
        return Objects.equals(this.idorigen, other.idorigen);
    }

    public Integer getIdorigen() {
        return idorigen;
    }

    public void setIdorigen(Integer idorigen) {
        this.idorigen = idorigen;
    }

    public Integer getMatriz() {
        return matriz;
    }

    public void setMatriz(Integer matriz) {
        this.matriz = matriz;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroext() {
        return numeroext;
    }

    public void setNumeroext(String numeroext) {
        this.numeroext = numeroext;
    }

    public String getNumeroint() {
        return numeroint;
    }

    public void setNumeroint(String numeroint) {
        this.numeroint = numeroint;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public Integer getIdestado() {
        return idestado;
    }

    public void setIdestado(Integer idestado) {
        this.idestado = idestado;
    }

    public Integer getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(Integer idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public Integer getIdcolonia() {
        return idcolonia;
    }

    public void setIdcolonia(Integer idcolonia) {
        this.idcolonia = idcolonia;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public Object getFechatrabajo() {
        return fechatrabajo;
    }

    public void setFechatrabajo(Object fechatrabajo) {
        this.fechatrabajo = fechatrabajo;
    }

    public String getCta_rendimientos() {
        return cta_rendimientos;
    }

    public void setCta_rendimientos(String cta_rendimientos) {
        this.cta_rendimientos = cta_rendimientos;
    }

    public String getCta_quebrantos() {
        return cta_quebrantos;
    }

    public void setCta_quebrantos(String cta_quebrantos) {
        this.cta_quebrantos = cta_quebrantos;
    }

    public String getCta_efectivo() {
        return cta_efectivo;
    }

    public void setCta_efectivo(String cta_efectivo) {
        this.cta_efectivo = cta_efectivo;
    }

    public String getCta_documentos1() {
        return cta_documentos1;
    }

    public void setCta_documentos1(String cta_documentos1) {
        this.cta_documentos1 = cta_documentos1;
    }

    public String getCta_documentos2() {
        return cta_documentos2;
    }

    public void setCta_documentos2(String cta_documentos2) {
        this.cta_documentos2 = cta_documentos2;
    }

    public String getCta_documentos3() {
        return cta_documentos3;
    }

    public void setCta_documentos3(String cta_documentos3) {
        this.cta_documentos3 = cta_documentos3;
    }

    public String getCta_documentos4() {
        return cta_documentos4;
    }

    public void setCta_documentos4(String cta_documentos4) {
        this.cta_documentos4 = cta_documentos4;
    }

    public String getCta_documentos5() {
        return cta_documentos5;
    }

    public void setCta_documentos5(String cta_documentos5) {
        this.cta_documentos5 = cta_documentos5;
    }

    public boolean isEnlinea() {
        return enlinea;
    }

    public void setEnlinea(boolean enlinea) {
        this.enlinea = enlinea;
    }

    public String getCta_documentos6() {
        return cta_documentos6;
    }

    public void setCta_documentos6(String cta_documentos6) {
        this.cta_documentos6 = cta_documentos6;
    }

    public String getCta_documentos7() {
        return cta_documentos7;
    }

    public void setCta_documentos7(String cta_documentos7) {
        this.cta_documentos7 = cta_documentos7;
    }

}
