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
@XmlRootElement(name = "huellainactivadto")
public class HuellaInactivaDTO implements Serializable {

    /*
    CREATE TABLE huella_inactiva
    (
    idorigen integer NOT NULL,
    idgrupo integer NOT NULL,
    idsocio integer NOT NULL,
    motivo integer NOT NULL DEFAULT 0,
    usuario integer NOT NULL,
    fecha timestamp without time zone NOT NULL,
    CONSTRAINT huella_inactiva_pkey PRIMARY KEY (idorigen, idgrupo, idsocio, fecha),
    CONSTRAINT huella_inactiva_fkey FOREIGN KEY (idorigen, idgrupo, idsocio)
      REFERENCES personas (idorigen, idgrupo, idsocio) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
    )
     */
    Integer idorigen;
    Integer idgrupo;
    Integer idsocio;
    Integer motivo;
    Integer usuario;
    Object fecha;

    public HuellaInactivaDTO() {
    }

    @Override
    public String toString() {
        return "HuellaInactivaDTO{" + "idorigen=" + idorigen + ", idgrupo=" + idgrupo + ", idsocio=" + idsocio + ", motivo=" + motivo + ", usuario=" + usuario + ", fecha=" + fecha + '}';
    }

    public HuellaInactivaDTO(Integer idorigen, Integer idgrupo, Integer idsocio, Integer motivo, Integer usuario, Object fecha) {
        this.idorigen = idorigen;
        this.idgrupo = idgrupo;
        this.idsocio = idsocio;
        this.motivo = motivo;
        this.usuario = usuario;
        this.fecha = fecha;
    }

    public Integer getIdorigen() {
        return idorigen;
    }

    public void setIdorigen(Integer idorigen) {
        this.idorigen = idorigen;
    }

    public Integer getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(Integer idgrupo) {
        this.idgrupo = idgrupo;
    }

    public Integer getIdsocio() {
        return idsocio;
    }

    public void setIdsocio(Integer idsocio) {
        this.idsocio = idsocio;
    }

    public Integer getMotivo() {
        return motivo;
    }

    public void setMotivo(Integer motivo) {
        this.motivo = motivo;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public Object getFecha() {
        return fecha;
    }

    public void setFecha(Object fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.idorigen);
        hash = 67 * hash + Objects.hashCode(this.idgrupo);
        hash = 67 * hash + Objects.hashCode(this.idsocio);
        hash = 67 * hash + Objects.hashCode(this.fecha);
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
        final HuellaInactivaDTO other = (HuellaInactivaDTO) obj;
        if (!Objects.equals(this.idorigen, other.idorigen)) {
            return false;
        }
        if (!Objects.equals(this.idgrupo, other.idgrupo)) {
            return false;
        }
        if (!Objects.equals(this.idsocio, other.idsocio)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

}
