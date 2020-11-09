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
@XmlRootElement(name = "JPersonasBloqueadas_HDTO")
public class JPersonasBloqueadas_HDTO implements Serializable {

    /*
CREATE TABLE j_personasbloqueadas_h
(
  id_doc character varying NOT NULL,
  nombre character varying NOT NULL,
  rfc character varying,
  curp character varying,
  idod integer NOT NULL,
  fecha character varying NOT NULL,
  fecha_alta_saicoop timestamp without time zone NOT NULL,
  fecha_baja_saicoop timestamp without time zone NOT NULL,
  dato1 character varying,
  dato2 character varying,
  dato3 character varying,
  usuario_baja integer NOT NULL,
  CONSTRAINT j_personasbloqueadas_h_pkey PRIMARY KEY (id_doc, nombre, idod, fecha),
  CONSTRAINT j_origen_datos_fkey FOREIGN KEY (idod)
      REFERENCES j_origen_datos (idod) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=TRUE
);
ALTER TABLE j_personasbloqueadas_h
  OWNER TO postgres;
COMMENT ON TABLE j_personasbloqueadas_h
  IS 'en esta tabla es del historial de personas bloqueadas';
     */
    String id_doc;
    String nombre;
    String rfc;
    String curp;
    Integer idod;
    String fecha;
    Object fecha_alta_saicoop;
    Object fecha_baja_saicoop;
    Integer usuario_baja;
    String dato1;
    String dato2;
    String dato3;

    public JPersonasBloqueadas_HDTO() {
    }

    public JPersonasBloqueadas_HDTO(String id_doc, String nombre, String rfc, String curp, Integer idod, String fecha, Object fecha_alta_saicoop, Object fecha_baja_saicoop, Integer usuario_baja, String dato1, String dato2, String dato3) {
        this.id_doc = id_doc;
        this.nombre = nombre;
        this.rfc = rfc;
        this.curp = curp;
        this.idod = idod;
        this.fecha = fecha;
        this.fecha_alta_saicoop = fecha_alta_saicoop;
        this.fecha_baja_saicoop = fecha_baja_saicoop;
        this.usuario_baja = usuario_baja;
        this.dato1 = dato1;
        this.dato2 = dato2;
        this.dato3 = dato3;
    }

    @Override
    public String toString() {
        return "JPersonasBloqueadas_HDTO{" + " id_doc=" + id_doc + ", nombre=" + nombre + ", rfc=" + rfc + ", curp=" + curp + ", idod=" + idod + ", fecha=" + fecha + ", fecha_alta_saicoop=" + fecha_alta_saicoop + ", fecha_baja_saicoop=" + fecha_baja_saicoop + ", usuario_baja=" + usuario_baja + ", dato1=" + dato1 + ", dato2=" + dato2 + ", dato3=" + dato3 + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id_doc);
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
        final JPersonasBloqueadas_HDTO other = (JPersonasBloqueadas_HDTO) obj;
        if (!Objects.equals(this.id_doc, other.id_doc)) {
            return false;
        }
        return true;
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

    public Object getFecha_baja_saicoop() {
        return fecha_baja_saicoop;
    }

    public void setFecha_baja_saicoop(Object fecha_baja_saicoop) {
        this.fecha_baja_saicoop = fecha_baja_saicoop;
    }

    public Integer getUsuario_baja() {
        return usuario_baja;
    }

    public void setUsuario_baja(Integer usuario_baja) {
        this.usuario_baja = usuario_baja;
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

}
