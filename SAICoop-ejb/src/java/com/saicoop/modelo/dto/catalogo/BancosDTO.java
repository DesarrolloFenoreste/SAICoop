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
@XmlRootElement(name = "bancosDTO")
public class BancosDTO implements Serializable {

    Integer idbanco;
    String nombre;
    String banco_receptor;

    public BancosDTO() {
    }

    public BancosDTO(Integer idbanco, String nombre, String banco_receptor) {
        this.idbanco = idbanco;
        this.nombre = nombre;
        this.banco_receptor = banco_receptor;
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

    public String getBanco_receptor() {
        return banco_receptor;
    }

    public void setBanco_receptor(String banco_receptor) {
        this.banco_receptor = banco_receptor;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idbanco;
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
        final BancosDTO other = (BancosDTO) obj;
        return Objects.equals(this.idbanco, other.idbanco);
    }

    @Override
    public String toString() {
        return "BancosDTO{" + "idbanco=" + idbanco + ", nombre=" + nombre + ", banco_receptor=" + banco_receptor + '}';
    }

}
