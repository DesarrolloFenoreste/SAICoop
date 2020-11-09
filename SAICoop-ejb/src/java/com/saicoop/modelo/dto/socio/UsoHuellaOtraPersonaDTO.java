/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.dto.socio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gerardo
 */
@XmlRootElement(name = "usoHuellaOtraPersonaDTO")
public class UsoHuellaOtraPersonaDTO implements Serializable {

    private Integer idusaurio;
    private Integer idorigen;
    private Integer idgrupo;
    private Integer idsocio;
    private Integer idorigenp;
    private Integer idproducto;
    private Integer idauxiliar;
    private BigDecimal monto;
    private Object fecha;
    private Integer idorigenr;
    private Integer idgrupor;
    private Integer idsocior;

    public UsoHuellaOtraPersonaDTO() {
    }

    public Integer getIdusaurio() {
        return idusaurio;
    }

    public void setIdusaurio(Integer idusaurio) {
        this.idusaurio = idusaurio;
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

    public Integer getIdorigenp() {
        return idorigenp;
    }

    public void setIdorigenp(Integer idorigenp) {
        this.idorigenp = idorigenp;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Integer getIdauxiliar() {
        return idauxiliar;
    }

    public void setIdauxiliar(Integer idauxiliar) {
        this.idauxiliar = idauxiliar;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Object getFecha() {
        return fecha;
    }

    public void setFecha(Object fecha) {
        this.fecha = fecha;
    }

    public Integer getIdorigenr() {
        return idorigenr;
    }

    public void setIdorigenr(Integer idorigenr) {
        this.idorigenr = idorigenr;
    }

    public Integer getIdgrupor() {
        return idgrupor;
    }

    public void setIdgrupor(Integer idgrupor) {
        this.idgrupor = idgrupor;
    }

    public Integer getIdsocior() {
        return idsocior;
    }

    public void setIdsocior(Integer idsocior) {
        this.idsocior = idsocior;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idorigenp);
        hash = 89 * hash + Objects.hashCode(this.idproducto);
        hash = 89 * hash + Objects.hashCode(this.idauxiliar);
        hash = 89 * hash + Objects.hashCode(this.fecha);
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
        final UsoHuellaOtraPersonaDTO other = (UsoHuellaOtraPersonaDTO) obj;
        if (!Objects.equals(this.idorigenp, other.idorigenp)) {
            return false;
        }
        if (!Objects.equals(this.idproducto, other.idproducto)) {
            return false;
        }
        if (!Objects.equals(this.idauxiliar, other.idauxiliar)) {
            return false;
        }
        return Objects.equals(this.fecha, other.fecha);
    }

    @Override
    public String toString() {
        return "UsoHuellaOtraPersonaDTO{" + "idusaurio=" + idusaurio + ", idorigen=" + idorigen + ", idgrupo=" + idgrupo + ", idsocio=" + idsocio + ", idorigenp=" + idorigenp + ", idproducto=" + idproducto + ", idauxiliar=" + idauxiliar + ", monto=" + monto + ", fecha=" + fecha + ", idorigenr=" + idorigenr + ", idgrupor=" + idgrupor + ", idsocior=" + idsocior + '}';
    }

}
