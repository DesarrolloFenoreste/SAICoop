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
@XmlRootElement(name = "JOrigenDatosDTO")
public class JOrigenDatosDTO implements Serializable{

    /*
CREATE TABLE j_origen_datos (
idod                INTEGER NOT NULL,--id del registro
nombre              CHARACTER VARYING NOT NULL, --nombre "DEA Bloqueados, SAT Bloqueados, QeQ acceso, QeQ consultas"
descripcion         TEXT, --descripcion del enlace
url                 TEXT, --enlace
tipo                CHARACTER VARYING NOT NULL,--servicio a consumir "ws", extencion de archivo descargable "csv"
idmenu              INTEGER NOT NULL,
config_lectura      CHARACTER VARYING, --{columnas xlsx:1,2,3,4,5} ; {etiquetas xml: raiz.persona.nombre, raiz.persona.paterno,raiz.fecha} ; {index de separar csv:1,2,3,4,5} 
charset_lectura     CHARACTER VARYING,
charset_escritura   CHARACTER VARYING,
  CONSTRAINT j_origen_datos_pkey PRIMARY KEY (idod),
  CONSTRAINT j_idmenu_fkey FOREIGN KEY (idmenu)
      REFERENCES j_catalogo_menus (idmenu) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
COMMENT ON TABLE j_origen_datos IS 'esta tabla guarda direcciones de internet para descargar archivos o consumir'; 

     */
    Integer idod;
    String nombre;
    String descripcion;
    String url;
    String tipo;
    Integer idmenu;
    String config_lectura;
    String charset_lectura;
    String charset_escritura;

    public JOrigenDatosDTO() {
    }

    public JOrigenDatosDTO(Integer idod, String nombre, String descripcion, String url, String tipo, Integer idmenu, String config_lectura, String charset_lectura, String charset_escritura) {
        this.idod = idod;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
        this.tipo = tipo;
        this.idmenu = idmenu;
        this.config_lectura = config_lectura;
        this.charset_lectura = charset_lectura;
        this.charset_escritura = charset_escritura;
    }

    @Override
    public String toString() {
        return "JurlDTO{" + "idod=" + idod + ", nombre=" + nombre + ", descripcion=" + descripcion + ", url=" + url + ", tipo=" + tipo + ", idmenu=" + idmenu + ", config_lectura=" + config_lectura + ", charset_lectura=" + charset_lectura + ", charset_escritura=" + charset_escritura + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idod);
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
        final JOrigenDatosDTO other = (JOrigenDatosDTO) obj;
        if (!Objects.equals(this.idod, other.idod)) {
            return false;
        }
        return true;
    }

    public Integer getIdod() {
        return idod;
    }

    public void setIdod(Integer idod) {
        this.idod = idod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(Integer idmenu) {
        this.idmenu = idmenu;
    }

    public String getConfig_lectura() {
        return config_lectura;
    }

    public void setConfig_lectura(String config_lectura) {
        this.config_lectura = config_lectura;
    }

    public String getCharset_lectura() {
        return charset_lectura;
    }

    public void setCharset_lectura(String charset_lectura) {
        this.charset_lectura = charset_lectura;
    }

    public String getCharset_escritura() {
        return charset_escritura;
    }

    public void setCharset_escritura(String charset_escritura) {
        this.charset_escritura = charset_escritura;
    }

}
