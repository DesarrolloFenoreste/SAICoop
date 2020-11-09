/*
 el metodo getCampos retorna el nombre de los campos de la tabla que representa el dto,
 la llave primaria va acompañada de PK, en el caso de que quiera saber que debe ser 
 ignorada como campo por default para hacer busquedas de forma manual en tabla lista 
 ira de esta manera -PK 
 */
package com.saicoop.modelo.dto.catalogo;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author prometeo
 */
@XmlRootElement(name = "estadosDTO")
public class EstadosDTO implements Serializable {

    private Integer idestado;
    private String nombre;
    private String ef;
    private Integer idpais;

    public EstadosDTO() {
    }

    public EstadosDTO(Integer idestado, Integer idpais) {
        this.idestado = idestado;
        this.idpais = idpais;
    }

    public Integer getIdestado() {
        return idestado;
    }

    public void setIdestado(Integer idestado) {
        this.idestado = idestado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEf() {
        return ef;
    }

    public void setEf(String ef) {
        this.ef = ef;
    }

    public Integer getIdpais() {
        return idpais;
    }

    public void setIdpais(Integer idpais) {
        this.idpais = idpais;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.idestado);
        hash = 79 * hash + Objects.hashCode(this.idpais);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EstadosDTO other = (EstadosDTO) obj;
        if (!Objects.equals(this.idestado, other.idestado)) {
            return false;
        }
        return Objects.equals(this.idpais, other.idpais);
    }

    @Override
    public String toString() {
        return "EstadosDTO{" + "idestado=" + idestado + ", nombre=" + nombre + ", ef=" + ef + ", idpais=" + idpais + '}';
    }

}
