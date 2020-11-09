/*
 el metodo getCampos retorna los nombres de los campos de la tabla que representa el dto 
 la llave primaria va acompañada de PK y en el caso como por ejemplo en el jdialog tablalista
 usare un -PK para que ignore la primarykey y no la ponga como campo por default para hacer
 la busqueda manual.
 */
package com.saicoop.modelo.dto.catalogo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author prometeo
 */
@XmlRootElement(name = "municipiosDTO")
public class MunicipiosDTO implements Serializable {

    private Integer idmunicipio;
    private String nombre;
    private Integer idestado;
    private BigDecimal poblacion;
    private Long localidad_siti;
    private String de_cp;
    private String a_cp;

    public MunicipiosDTO() {
    }

    public MunicipiosDTO(Integer idmunicipio, Integer idestado) {
        this.idmunicipio = idmunicipio;
        this.idestado = idestado;
    }

    public Integer getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(Integer idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdestado() {
        return idestado;
    }

    public void setIdestado(Integer idestado) {
        this.idestado = idestado;
    }

    public BigDecimal getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(BigDecimal poblacion) {
        this.poblacion = poblacion;
    }

    public Long getLocalidad_siti() {
        return localidad_siti;
    }

    public void setLocalidad_siti(Long localidad_siti) {
        this.localidad_siti = localidad_siti;
    }

    public String getDe_cp() {
        return de_cp;
    }

    public void setDe_cp(String de_cp) {
        this.de_cp = de_cp;
    }

    public String getA_cp() {
        return a_cp;
    }

    public void setA_cp(String a_cp) {
        this.a_cp = a_cp;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.idmunicipio);
        hash = 41 * hash + Objects.hashCode(this.idestado);
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
        final MunicipiosDTO other = (MunicipiosDTO) obj;
        if (!Objects.equals(this.idmunicipio, other.idmunicipio)) {
            return false;
        }
        return Objects.equals(this.idestado, other.idestado);
    }

    @Override
    public String toString() {
        return "MunicipiosDTO{" + "idmunicipio=" + idmunicipio + ", nombre=" + nombre + ", idestado=" + idestado + ", poblacion=" + poblacion + ", localidad_siti=" + localidad_siti + ", de_cp=" + de_cp + ", a_cp=" + a_cp + '}';
    }

}
