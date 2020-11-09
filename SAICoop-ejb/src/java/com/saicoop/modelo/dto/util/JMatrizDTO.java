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
@XmlRootElement(name = "JMatrizDTO")
public class JMatrizDTO implements Serializable {

    Integer idmatriz;
    String nombre;
    Integer filas;
    Integer columnas;
    String periodo;
    String descripcion;
    Integer tipo;
    String autor;
    Integer administrador;
    String grupo;

    /*
CREATE TABLE j_matriz(
  idmatriz      INTEGER NOT NULL,
  nombre        CHARACTER VARYING NOT NULL,
  filas         INTEGER NOT NULL,
  columnas      INTEGER NOT NULL,
  periodo       CHARACTER VARYING NOT NULL,
  descripcion   CHARACTER VARYING NOT NULL,
  tipo          INTEGER NOT NULL,
  autor         CHARACTER VARYING NOT NULL,
  administrador INTEGER NOT NULL,
  grupo         CHARACTER VARYING,
  CONSTRAINT j_matriz_pkey PRIMARY KEY (idmatriz)
);
COMMENT ON TABLE j_matriz IS 'contiene plantillas y matrices'; 
     */
    public JMatrizDTO() {
    }

    public JMatrizDTO(Integer idmatriz) {
        this.idmatriz = idmatriz;
    }

    public Integer getIdmatriz() {
        return idmatriz;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Integer getFilas() {
        return filas;
    }

    public void setFilas(Integer filas) {
        this.filas = filas;
    }

    public Integer getColumnas() {
        return columnas;
    }

    public void setColumnas(Integer columnas) {
        this.columnas = columnas;
    }

    public void setIdmatriz(Integer idmatriz) {
        this.idmatriz = idmatriz;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Integer administrador) {
        this.administrador = administrador;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.idmatriz);
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
        final JMatrizDTO other = (JMatrizDTO) obj;
        if (!Objects.equals(this.idmatriz, other.idmatriz)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JMatrizDTO{" + "idmatriz=" + idmatriz + ", nombre=" + nombre + ", periodo=" + periodo + ", descripcion=" + descripcion + ", tipo=" + tipo + ", autor=" + autor + ", administrador=" + administrador + '}';
    }
}
