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
@XmlRootElement(name = "JMatrizReferenciaDTO")
public class JMatrizReferenciaDTO implements Serializable {

    /*
    CREATE TABLE j_matriz_referencia(
    idreferencia     INTEGER NOT NULL,
    periodo          CHARACTER VARYING NOT NULL,
    idcontenido      INTEGER NOT NULL,
    valor            CHARACTER VARYING NOT NULL,
    descripcion            CHARACTER VARYING NOT NULL,
    CONSTRAINT j_matriz_referencia_pkey PRIMARY KEY (idreferencia,periodo,idcontenido),
    CONSTRAINT j_matriz_contenido_fkey FOREIGN KEY (idcontenido)
    REFERENCES j_matriz_contenido (idcontenido) MATCH SIMPLE
    ON UPDATE NO ACTION ON DELETE NO ACTION
    );
    COMMENT ON TABLE j_matriz_referencia IS 'esta tabla contiene valores con referencia a algun registro de j_matriz_contenido
     */
    Integer idreferencia;
    String periodo;
    Integer idcontenido;
    String valor;
    String descripcion;

    public JMatrizReferenciaDTO() {
    }

    public JMatrizReferenciaDTO(Integer idreferencia, String periodo, Integer idcontenido) {
        this.idreferencia = idreferencia;
        this.periodo = periodo;
        this.idcontenido = idcontenido;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.idreferencia);
        hash = 59 * hash + Objects.hashCode(this.periodo);
        hash = 59 * hash + Objects.hashCode(this.idcontenido);
        return hash;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdreferencia() {
        return idreferencia;
    }

    public void setIdreferencia(Integer idreferencia) {
        this.idreferencia = idreferencia;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
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
        final JMatrizReferenciaDTO other = (JMatrizReferenciaDTO) obj;
        if (!Objects.equals(this.periodo, other.periodo)) {
            return false;
        }
        if (!Objects.equals(this.idreferencia, other.idreferencia)) {
            return false;
        }
        if (!Objects.equals(this.idcontenido, other.idcontenido)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JMatrizReferenciaDTO{" + "idreferencia=" + idreferencia + ", periodo=" + periodo + ", idcontenido=" + idcontenido + ", valor=" + valor + '}';
    }

}
