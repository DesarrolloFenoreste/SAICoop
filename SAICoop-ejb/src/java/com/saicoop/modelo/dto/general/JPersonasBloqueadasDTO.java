/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.dto.general;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author prometeo
 */
@XmlRootElement(name = "JPersonasBloqueadasDTO")
public class JPersonasBloqueadasDTO implements Serializable {

    /*

CREATE TABLE j_personasbloqueadas
(
  id_doc character varying NOT NULL,
  nombre character varying NOT NULL,
  rfc character varying,
  curp character varying,
  idod integer NOT NULL,
  fecha character varying NOT NULL,
  fecha_alta_saicoop timestamp without time zone NOT NULL,
  dato1 character varying,
  dato2 character varying,
  dato3 character varying,
  CONSTRAINT j_personasbloqueadas_pkey PRIMARY KEY (id_doc, nombre, idod, fecha),
  CONSTRAINT j_origen_datos_fkey FOREIGN KEY (idod)
      REFERENCES j_origen_datos (idod) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=TRUE
);
ALTER TABLE j_personasbloqueadas
  OWNER TO postgres;
COMMENT ON TABLE j_personasbloqueadas
  IS 'en esta tabla se encuantran las personas bloqueadas';
     */
    String id_doc;
    String nombre;
    String rfc;
    String curp;
    Integer idod;
    String fecha;
    Object fecha_alta_saicoop;
    String dato1;
    String dato2;
    String dato3;

    public JPersonasBloqueadasDTO(String id_doc, String nombre, String rfc, String curp, Integer idod, String fecha, Object fecha_alta_saicoop, String dato1, String dato2, String dato3) {
        this.id_doc = id_doc;
        this.nombre = nombre;
        this.rfc = rfc;
        this.curp = curp;
        this.idod = idod;
        this.fecha = fecha;
        this.fecha_alta_saicoop = fecha_alta_saicoop;
        this.dato1 = dato1;
        this.dato2 = dato2;
        this.dato3 = dato3;
    }

    public JPersonasBloqueadasDTO() {
    }

    public String getId_doc() {
        return id_doc;
    }

    public void setId_doc(String id_doc) {
        this.id_doc = id_doc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public Integer getIdod() {
        return idod;
    }

    public void setIdod(Integer idod) {
        this.idod = idod;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Object getFecha_alta_saicoop() {
        return fecha_alta_saicoop;
    }

    public void setFecha_alta_saicoop(Object fecha_alta_saicoop) {
        this.fecha_alta_saicoop = fecha_alta_saicoop;
    }

    public String getDato1() {
        return dato1;
    }

    public void setDato1(String dato1) {
        this.dato1 = dato1;
    }

    public String getDato2() {
        return dato2;
    }

    public void setDato2(String dato2) {
        this.dato2 = dato2;
    }

    public String getDato3() {
        return dato3;
    }

    public void setDato3(String dato3) {
        this.dato3 = dato3;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id_doc);
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
        final JPersonasBloqueadasDTO other = (JPersonasBloqueadasDTO) obj;
        if (!Objects.equals(this.id_doc, other.id_doc)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "JPersonasBloqueadasDTO{" + "id_doc=" + id_doc + ", nombre=" + nombre + ", rfc=" + rfc + ", curp=" + curp + ", idod=" + idod + ", fecha=" + fecha + ", fecha_alta_saicoop=" + fecha_alta_saicoop + ", dato1=" + dato1 + ", dato2=" + dato2 + ", dato3=" + dato3 + '}';
    }

}
