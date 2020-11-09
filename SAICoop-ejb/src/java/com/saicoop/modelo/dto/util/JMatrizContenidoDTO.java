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
@XmlRootElement(name = "JMatrizContenidoDTO")
public class JMatrizContenidoDTO implements Serializable {

    Integer idcontenido;
    String valor;
    Integer tipo;
    String descripcion;

    /*
    CREATE TABLE j_matriz_contenido(
    idcontenido   INTEGER NOT NULL,
    valor         CHARACTER VARYING NOT NULL, 
    tipo          INTEGER NOT NULL,
    descripcion   CHARACTER VARYING NOT NULL,
    CONSTRAINT j_matriz_contenido_pkey PRIMARY KEY (idcontenido)
     */
    public JMatrizContenidoDTO() {

    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public JMatrizContenidoDTO(Integer idcontenido) {
        this.idcontenido = idcontenido;
    }

    public Integer getIdcontenido() {
        return idcontenido;
    }

    public void setIdcontenido(Integer idcontenido) {
        this.idcontenido = idcontenido;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.idcontenido);
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
        final JMatrizContenidoDTO other = (JMatrizContenidoDTO) obj;
        if (!Objects.equals(this.idcontenido, other.idcontenido)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JMatrizContenidoDTO{" + "idcontenido=" + idcontenido + ", valor=" + valor + ", descripcion=" + descripcion + '}';
    }
}
