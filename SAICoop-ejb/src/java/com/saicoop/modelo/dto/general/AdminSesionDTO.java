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
 * @author gerardo
 */
@XmlRootElement(name = "adminSesionDTO")
public class AdminSesionDTO implements Serializable {

    private Integer idusuario;
    private String sesionservidor;
    private String iplocal;
    private String ipexterna;
    private String macaddress;
    private String ipbasedatos; 
    private String basedatos;
    private String usuariosistemaoperativo; 
    private String sistemaoperativo;
    private String versionsistemaoperativo;
    private String arquitecturasistemaoperativo;
    private Object ultimaentrada;
    private Boolean estatus = true;
    private Boolean bloqueado = false;

    public AdminSesionDTO() {
    }

    public AdminSesionDTO(Integer idusuario, String sesionservidor, String iplocal, String ipexterna, String macaddress, String ipbasedatos, String basedatos, String usuariosistemaoperativo, String sistemaoperativo, String versionsistemaoperativo, String arquitecturasistemaoperativo, Object ultimaentrada, boolean estatus, boolean bloqueado) {
        this.idusuario = idusuario;
        this.sesionservidor = sesionservidor;
        this.iplocal = iplocal;
        this.ipexterna = ipexterna;
        this.macaddress = macaddress;
        this.ipbasedatos = ipbasedatos;
        this.basedatos = basedatos;
        this.usuariosistemaoperativo = usuariosistemaoperativo;
        this.sistemaoperativo = sistemaoperativo;
        this.versionsistemaoperativo = versionsistemaoperativo;
        this.arquitecturasistemaoperativo = arquitecturasistemaoperativo;
        this.ultimaentrada = ultimaentrada;
        this.estatus = estatus;
        this.bloqueado = bloqueado;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getSesionservidor() {
        return sesionservidor;
    }

    public void setSesionservidor(String sesionservidor) {
        this.sesionservidor = sesionservidor;
    }

    public String getIplocal() {
        return iplocal;
    }

    public void setIplocal(String iplocal) {
        this.iplocal = iplocal;
    }

    public String getIpexterna() {
        return ipexterna;
    }

    public void setIpexterna(String ipexterna) {
        this.ipexterna = ipexterna;
    }

    public String getMacaddress() {
        return macaddress;
    }

    public void setMacaddress(String macaddress) {
        this.macaddress = macaddress;
    }

    public String getIpbasedatos() {
        return ipbasedatos;
    }

    public void setIpbasedatos(String ipbasedatos) {
        this.ipbasedatos = ipbasedatos;
    }

    public String getBasedatos() {
        return basedatos;
    }

    public void setBasedatos(String basedatos) {
        this.basedatos = basedatos;
    }

    public String getUsuariosistemaoperativo() {
        return usuariosistemaoperativo;
    }

    public void setUsuariosistemaoperativo(String usuariosistemaoperativo) {
        this.usuariosistemaoperativo = usuariosistemaoperativo;
    }

    public String getSistemaoperativo() {
        return sistemaoperativo;
    }

    public void setSistemaoperativo(String sistemaoperativo) {
        this.sistemaoperativo = sistemaoperativo;
    }

    public String getVersionsistemaoperativo() {
        return versionsistemaoperativo;
    }

    public void setVersionsistemaoperativo(String versionsistemaoperativo) {
        this.versionsistemaoperativo = versionsistemaoperativo;
    }

    public String getArquitecturasistemaoperativo() {
        return arquitecturasistemaoperativo;
    }

    public void setArquitecturasistemaoperativo(String arquitecturasistemaoperativo) {
        this.arquitecturasistemaoperativo = arquitecturasistemaoperativo;
    }

    public Object getUltimaentrada() {
        return ultimaentrada;
    }

    public void setUltimaentrada(Object ultimaentrada) {
        this.ultimaentrada = ultimaentrada;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.idusuario);
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
        final AdminSesionDTO other = (AdminSesionDTO) obj;
        return Objects.equals(this.idusuario, other.idusuario);
    }

    @Override
    public String toString() {
        return "AdminSesionDTO{" + "idusuario=" + idusuario + ", sesionservidor=" + sesionservidor + ", iplocal=" + iplocal + ", ipexterna=" + ipexterna + ", macaddress=" + macaddress + ", ipbasedatos=" + ipbasedatos + ", basedatos=" + basedatos + ", usuariosistemaoperativo=" + usuariosistemaoperativo + ", sistemaoperativo=" + sistemaoperativo + ", versionsistemaoperativo=" + versionsistemaoperativo + ", arquitecturasistemaoperativo=" + arquitecturasistemaoperativo + ", ultimaentrada=" + ultimaentrada + ", estatus=" + estatus + ", bloqueado=" + bloqueado + '}';
    }

}
