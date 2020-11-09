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
@XmlRootElement(name = "huellasDpUsuarioDTO")
public class HuellasDpUsuarioDTO implements Serializable {

    private Integer idusuario;
    private Integer formatohuella;
    private byte[] huella0;
    private byte[] huella1;
    private byte[] huella2;
    private byte[] huella3;
    private byte[] huella4;
    private byte[] huella5;
    private byte[] huella6;
    private byte[] huella7;
    private byte[] huella8;
    private byte[] huella9;

    public HuellasDpUsuarioDTO() {
    }

    public HuellasDpUsuarioDTO(Integer idusuario, Integer formatohuella, byte[] huella0, byte[] huella1, byte[] huella2, byte[] huella3, byte[] huella4, byte[] huella5, byte[] huella6, byte[] huella7, byte[] huella8, byte[] huella9) {
        this.idusuario = idusuario;
        this.formatohuella = formatohuella;
        this.huella0 = huella0;
        this.huella1 = huella1;
        this.huella2 = huella2;
        this.huella3 = huella3;
        this.huella4 = huella4;
        this.huella5 = huella5;
        this.huella6 = huella6;
        this.huella7 = huella7;
        this.huella8 = huella8;
        this.huella9 = huella9;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getFormatohuella() {
        return formatohuella;
    }

    public void setFormatohuella(Integer formatohuella) {
        this.formatohuella = formatohuella;
    }

    public byte[] getHuella0() {
        return huella0;
    }

    public void setHuella0(byte[] huella0) {
        this.huella0 = huella0;
    }

    public byte[] getHuella1() {
        return huella1;
    }

    public void setHuella1(byte[] huella1) {
        this.huella1 = huella1;
    }

    public byte[] getHuella2() {
        return huella2;
    }

    public void setHuella2(byte[] huella2) {
        this.huella2 = huella2;
    }

    public byte[] getHuella3() {
        return huella3;
    }

    public void setHuella3(byte[] huella3) {
        this.huella3 = huella3;
    }

    public byte[] getHuella4() {
        return huella4;
    }

    public void setHuella4(byte[] huella4) {
        this.huella4 = huella4;
    }

    public byte[] getHuella5() {
        return huella5;
    }

    public void setHuella5(byte[] huella5) {
        this.huella5 = huella5;
    }

    public byte[] getHuella6() {
        return huella6;
    }

    public void setHuella6(byte[] huella6) {
        this.huella6 = huella6;
    }

    public byte[] getHuella7() {
        return huella7;
    }

    public void setHuella7(byte[] huella7) {
        this.huella7 = huella7;
    }

    public byte[] getHuella8() {
        return huella8;
    }

    public void setHuella8(byte[] huella8) {
        this.huella8 = huella8;
    }

    public byte[] getHuella9() {
        return huella9;
    }

    public void setHuella9(byte[] huella9) {
        this.huella9 = huella9;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final HuellasDpUsuarioDTO other = (HuellasDpUsuarioDTO) obj;
        return Objects.equals(this.idusuario, other.idusuario);
    }

    @Override
    public String toString() {
        return "HuellasDpUsuarioDTO{" + "idusuario=" + idusuario + ", formatohuella=" + formatohuella + ", huella0=" + huella0 + ", huella1=" + huella1 + ", huella2=" + huella2 + ", huella3=" + huella3 + ", huella4=" + huella4 + ", huella5=" + huella5 + ", huella6=" + huella6 + ", huella7=" + huella7 + ", huella8=" + huella8 + ", huella9=" + huella9 + '}';
    }

}
