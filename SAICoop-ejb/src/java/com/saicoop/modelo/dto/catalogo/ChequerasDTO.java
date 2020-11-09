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
@XmlRootElement(name = "chequerasDTO")
public class ChequerasDTO implements Serializable {

    Integer idchequera;
    Integer idbanco;
    String nombre;
    String idcuenta;
    Integer ultimocheque;
    String impresora;
    Integer idorigen;

    public ChequerasDTO() {
    }

    public ChequerasDTO(Integer idchequera, Integer idbanco, String nombre, String idcuenta, Integer ultimocheque, String impresora, Integer idorigen) {
        this.idchequera = idchequera;
        this.idbanco = idbanco;
        this.nombre = nombre;
        this.idcuenta = idcuenta;
        this.ultimocheque = ultimocheque;
        this.impresora = impresora;
        this.idorigen = idorigen;
    }

    public Integer getIdchequera() {
        return idchequera;
    }

    public void setIdchequera(Integer idchequera) {
        this.idchequera = idchequera;
    }

    public Integer getIdbanco() {
        return idbanco;
    }

    public void setIdbanco(Integer idbanco) {
        this.idbanco = idbanco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(String idcuenta) {
        this.idcuenta = idcuenta;
    }

    public Integer getUltimocheque() {
        return ultimocheque;
    }

    public void setUltimocheque(Integer ultimocheque) {
        this.ultimocheque = ultimocheque;
    }

    public String getImpresora() {
        return impresora;
    }

    public void setImpresora(String impresora) {
        this.impresora = impresora;
    }

    public Integer getIdorigen() {
        return idorigen;
    }

    public void setIdorigen(Integer idorigen) {
        this.idorigen = idorigen;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.idchequera;
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
        final ChequerasDTO other = (ChequerasDTO) obj;
        return Objects.equals(this.idchequera, other.idchequera);
    }

    @Override
    public String toString() {
        return "ChequerasDTO{" + "idchequera=" + idchequera + ", idbanco=" + idbanco + ", nombre=" + nombre + ", idcuenta=" + idcuenta + ", ultimocheque=" + ultimocheque + ", impresora=" + impresora + ", idorigen=" + idorigen + '}';
    }

}
