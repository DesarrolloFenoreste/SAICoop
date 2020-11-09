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
@XmlRootElement(name = "jAplicaScriptDTO")
public class JAplicaScriptDTO implements Serializable {

    private String idscript;
    private Integer idusuario;
    private Object fecha_aplico;
    private String autor;
    private String script;
    private String comentario;

    public JAplicaScriptDTO() {
    }

    public JAplicaScriptDTO(String idscript, int idusuario, Object fecha_aplico, String autor, String script, String comentario) {
        this.idscript = idscript;
        this.idusuario = idusuario;
        this.fecha_aplico = fecha_aplico;
        this.autor = autor;
        this.script = script;
        this.comentario = comentario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.idscript);
        return hash;
    }

    @Override
    public String toString() {
        return "J_AplicaScriptDTO{" + "idscript=" + idscript + ", idusuario=" + idusuario + ", fecha_aplico=" + fecha_aplico + ", autor=" + autor + ", script=" + script + ", comentario=" + comentario + '}';
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
        final JAplicaScriptDTO other = (JAplicaScriptDTO) obj;
        if (!Objects.equals(this.idscript, other.idscript)) {
            return false;
        }
        return true;
    }

    public String getIdscript() {
        return idscript;
    }

    public void setIdscript(String idscript) {
        this.idscript = idscript;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public Object getFecha_aplico() {
        return fecha_aplico;
    }

    public void setFecha_aplico(Object fecha_aplico) {
        this.fecha_aplico = fecha_aplico;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}
