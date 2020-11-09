/*
 en metodo getCampo lo que hace es retornar los campos de la tabla, con las letras PK indico que ese campo es la llave
 de la tabla, cuando pongo -PK "signo de menos con pk", quiere decir que en una busqueda manual va a ignorar ese campo, ejemplo:
 en la ventana de dialogo tablaLista va a ignorar ese campo y cuando el usuario busque manualmente entre las filas del jtable
 comenzara por el nombre no por idcolonia.
 */
package com.saicoop.modelo.dto.catalogo;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author prometeo
 */
@XmlRootElement(name = "coloniasDTO")
public class ColoniasDTO implements Serializable {

    private Integer idcolonia;
    private String nombre;
    private Integer idmunicipio;
    private String codigopostal;

    public ColoniasDTO() {
    }

    public ColoniasDTO(Integer idcolonia, Integer idmunicipio) {
        this.idcolonia = idcolonia;
        this.idmunicipio = idmunicipio;
    }

    public Integer getIdcolonia() {
        return idcolonia;
    }

    public void setIdcolonia(Integer idcolonia) {
        this.idcolonia = idcolonia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(Integer idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idcolonia);
        hash = 89 * hash + Objects.hashCode(this.idmunicipio);
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
        final ColoniasDTO other = (ColoniasDTO) obj;
        if (!Objects.equals(this.idcolonia, other.idcolonia)) {
            return false;
        }
        return Objects.equals(this.idmunicipio, other.idmunicipio);
    }

    @Override
    public String toString() {
        return "ColoniasDTO{" + "idcolonia=" + idcolonia + ", nombre=" + nombre + ", idmunicipio=" + idmunicipio + ", codigopostal=" + codigopostal + '}';
    }
    
}
