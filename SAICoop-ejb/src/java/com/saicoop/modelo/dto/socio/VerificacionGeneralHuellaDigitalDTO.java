/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.dto.socio;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gerardo
 */
@XmlRootElement(name = "verificacionGeneralHuellaDigitalDTO")
public class VerificacionGeneralHuellaDigitalDTO implements Serializable {

    private Integer idusuario;
    private String sesion;
    private String modulo;
    private Integer idorigen;
    private Integer idgrupo;
    private Integer idsocio;
    private Integer tipo;
    private String mensaje;
    private Boolean verificado;

    public VerificacionGeneralHuellaDigitalDTO() {
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getSesion() {
        return sesion;
    }

    public void setSesion(String sesion) {
        this.sesion = sesion;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public int getIdorigen() {
        return idorigen;
    }

    public void setIdorigen(int idorigen) {
        this.idorigen = idorigen;
    }

    public int getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(int idgrupo) {
        this.idgrupo = idgrupo;
    }

    public int getIdsocio() {
        return idsocio;
    }

    public void setIdsocio(int idsocio) {
        this.idsocio = idsocio;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isVerificado() {
        return verificado;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.sesion);
        hash = 31 * hash + this.idorigen;
        hash = 31 * hash + this.idgrupo;
        hash = 31 * hash + this.idsocio;
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
        final VerificacionGeneralHuellaDigitalDTO other = (VerificacionGeneralHuellaDigitalDTO) obj;
        if (this.idorigen != other.idorigen) {
            return false;
        }
        if (this.idgrupo != other.idgrupo) {
            return false;
        }
        if (this.idsocio != other.idsocio) {
            return false;
        }
        return Objects.equals(this.sesion, other.sesion);
    }

    @Override
    public String toString() {
        return "VerificacionGeneralHuellaDigitalDTO{" + "idusuario=" + idusuario + ", sesion=" + sesion + ", modulo=" + modulo + ", idorigen=" + idorigen + ", idgrupo=" + idgrupo + ", idsocio=" + idsocio + ", tipo=" + tipo + ", mensaje=" + mensaje + ", verificado=" + verificado + '}';
    }

}
