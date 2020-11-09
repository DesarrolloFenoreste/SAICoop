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
 * @author prometeo
 */
@XmlRootElement(name = "personascnbvdto")
public class PersonaCnbvDTO implements Serializable {

    String expediente;
    Integer personaid;
    Object fecha;
    String caracter;
    String persona;
    String paterno;
    String materno;
    String nombre;
    String rfc;
    String curp;
    String relacion;
    String domicilio;
    String complementarios;
    Boolean xml;

    public PersonaCnbvDTO() {
    }

    public PersonaCnbvDTO(String expediente, Integer personaid) {
        this.expediente = expediente;
        this.personaid = personaid;
    }

    public PersonaCnbvDTO(String expediente, Integer personaid, Object fecha, String caracter, String persona, String paterno, String materno, String nombre, String rfc, String curp, String relacion, String domicilio, String complementarios, Boolean xml) {
        this.expediente = expediente;
        this.personaid = personaid;
        this.fecha = fecha;
        this.caracter = caracter;
        this.persona = persona;
        this.paterno = paterno;
        this.materno = materno;
        this.nombre = nombre;
        this.rfc = rfc;
        this.curp = curp;
        this.relacion = relacion;
        this.domicilio = domicilio;
        this.complementarios = complementarios;
        this.xml = xml;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.expediente);
        hash = 71 * hash + Objects.hashCode(this.personaid);
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
        final PersonaCnbvDTO other = (PersonaCnbvDTO) obj;
        if (!Objects.equals(this.expediente, other.expediente)) {
            return false;
        }
        if (!Objects.equals(this.personaid, other.personaid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PersonaCnbvDTO{" + "expediente=" + expediente + ", personaid=" + personaid + ", fecha=" + fecha + ", caracter=" + caracter + ", persona=" + persona + ", paterno=" + paterno + ", materno=" + materno + ", nombre=" + nombre  + ", rfc=" + rfc + ", curp=" + curp + ", relacion=" + relacion + ", domicilio=" + domicilio + ", complementarios=" + complementarios + ", xml=" + xml + '}';
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public Integer getPersonaid() {
        return personaid;
    }

    public void setPersonaid(Integer personaid) {
        this.personaid = personaid;
    }

    public Object getFecha() {
        return fecha;
    }

    public void setFecha(Object fecha) {
        this.fecha = fecha;
    }

    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
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

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getComplementarios() {
        return complementarios;
    }

    public void setComplementarios(String complementarios) {
        this.complementarios = complementarios;
    }

    public Boolean getXml() {
        return xml;
    }

    public void setXml(Boolean xml) {
        this.xml = xml;
    }

}
