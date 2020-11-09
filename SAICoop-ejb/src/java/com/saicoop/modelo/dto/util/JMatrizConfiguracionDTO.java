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
@XmlRootElement(name = "JMatrizConfiguracionDTO")
public class JMatrizConfiguracionDTO implements Serializable {

    Integer idconfiguracion;
    Integer idmatriz;
    String celda;
    String configuracion;
    Integer idcontenido;

    /*
    CREATE TABLE j_matriz_configuracion(
    idconfiguracion   INTEGER NOT NULL,
    idmatriz          INTEGER NOT NULL,
    celda             CHARACTER VARYING NOT NULL,
    configuracion     CHARACTER VARYING NOT NULL,
    idcontenido       INTEGER NOT NULL, 
    CONSTRAINT j_matriz_configuracion_pkey PRIMARY KEY (idconfiguracion,idmatriz,celda),
    CONSTRAINT j_matriz_fkey FOREIGN KEY (idmatriz)
      REFERENCES j_matriz (idmatriz) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT j_matriz_contenido_fkey FOREIGN KEY (idcontenido)
      REFERENCES j_matriz_contenido (idcontenido) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
    );
    COMMENT ON TABLE j_matriz_configuracion IS 'contiene la configuracion de plantillas y matrices'; 
     */

    public JMatrizConfiguracionDTO() {
    }

    public JMatrizConfiguracionDTO(Integer idconfiguracion, Integer idmatriz, String celda) {
        this.idconfiguracion = idconfiguracion;
        this.idmatriz = idmatriz;
        this.celda = celda;
    }

    public Integer getIdconfiguracion() {
        return idconfiguracion;
    }

    public void setIdconfiguracion(Integer idconfiguracion) {
        this.idconfiguracion = idconfiguracion;
    }

    public Integer getIdmatriz() {
        return idmatriz;
    }

    public void setIdmatriz(Integer idmatriz) {
        this.idmatriz = idmatriz;
    }

    public String getCelda() {
        return celda;
    }

    public void setCelda(String celda) {
        this.celda = celda;
    }

    public String getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(String configuracion) {
        this.configuracion = configuracion;
    }

    public Integer getIdcontenido() {
        return idcontenido;
    }

    public void setIdcontenido(Integer idcontenido) {
        this.idcontenido = idcontenido;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.idconfiguracion);
        hash = 23 * hash + Objects.hashCode(this.idmatriz);
        hash = 23 * hash + Objects.hashCode(this.celda);
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
        final JMatrizConfiguracionDTO other = (JMatrizConfiguracionDTO) obj;
        if (!Objects.equals(this.celda, other.celda)) {
            return false;
        }
        if (!Objects.equals(this.idconfiguracion, other.idconfiguracion)) {
            return false;
        }
        if (!Objects.equals(this.idmatriz, other.idmatriz)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JMatrizConfiguracionDTO{" + "idconfiguracion=" + idconfiguracion + ", idmatriz=" + idmatriz + ", celda=" + celda + ", configuracion=" + configuracion + ", idcontenido=" + idcontenido + '}';
    }

}
