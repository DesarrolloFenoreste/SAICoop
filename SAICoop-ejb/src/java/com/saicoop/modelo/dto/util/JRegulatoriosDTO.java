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
@XmlRootElement(name = "regulatoriosdto")
public class JRegulatoriosDTO implements Serializable {

    /*
  CREATE TABLE j_regulatorios (
  serie             CHARACTER VARYING NOT NULL,
  idreg             CHARACTER VARYING NOT NULL, 
  descripcion       CHARACTER VARYING NOT NULL, 
  periodo           INTEGER NOT NULL,
  funcion           TEXT, 
  consulta          TEXT, 
  visible           BOOLEAN NOT NULL DEFAULT FALSE,
  CONSTRAINT j_Regulatorios_pkey PRIMARY KEY (idreg)
);
COMMENT ON TABLE j_Regulatorios IS 'Contiene las funciones para obtener los reportes regulatorios'; 
     */
    private String serie;
    private String idreg;
    private String descripcion;
    private Integer periodo;
    private String funcion;
    private String consulta;
    private Boolean visible;

    public JRegulatoriosDTO() {
    }

    public JRegulatoriosDTO(String serie, String idreg, String descripcion, Integer periodo, String funcion, String consulta, Boolean visible) {
        this.serie = serie;
        this.idreg = idreg;
        this.descripcion = descripcion;
        this.periodo = periodo;
        this.funcion = funcion;
        this.consulta = consulta;
        this.visible = visible;
    }

    @Override
    public String toString() {
        return "JRegulatoriosDTO{" + "serie=" + serie + ", idreg=" + idreg + ", descripcion=" + descripcion + ", periodo=" + periodo + ", funcion=" + funcion + ", consulta=" + consulta + ", visible=" + visible + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.serie);
        hash = 11 * hash + Objects.hashCode(this.idreg);
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
        final JRegulatoriosDTO other = (JRegulatoriosDTO) obj;
        if (!Objects.equals(this.serie, other.serie)) {
            return false;
        }
        if (!Objects.equals(this.idreg, other.idreg)) {
            return false;
        }
        return true;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getIdreg() {
        return idreg;
    }

    public void setIdreg(String idreg) {
        this.idreg = idreg;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

}
