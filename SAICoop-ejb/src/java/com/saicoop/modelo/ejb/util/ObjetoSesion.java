/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.util;

import java.io.Serializable;

/**
 *
 * @author prometeo
 */
public class ObjetoSesion implements Serializable {

    public ObjetoSesion() {
    }

    public ObjetoSesion(String id, String usuario,String so, String ipBd, String bd, String ultimaEntrada,String iplocal, String macAddress, boolean estado) {
        this.id = id;
        this.iplocal = iplocal;
        this.macAddress = macAddress;
        this.ipBd = ipBd;
        this.bd = bd;
        this.usuario = usuario;
        this.so = so;
        this.ultimaEntrada = ultimaEntrada;
        this.estado = estado;
    }

    private String id;
    private String iplocal;
    private String macAddress;
    private String ipBd;
    private String bd;
    private String usuario;
    private String so;
    private String ultimaEntrada;
    private boolean estado;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIplocal() {
        return iplocal;
    }

    public void setIplocal(String iplocal) {
        this.iplocal = iplocal;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getIpBd() {
        return ipBd;
    }

    public void setIpBd(String ipBd) {
        this.ipBd = ipBd;
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public String getUltimaEntrada() {
        return ultimaEntrada;
    }

    public void setUltimaEntrada(String ultimaEntrada) {
        this.ultimaEntrada = ultimaEntrada;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
