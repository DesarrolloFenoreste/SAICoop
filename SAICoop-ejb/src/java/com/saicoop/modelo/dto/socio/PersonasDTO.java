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
@XmlRootElement(name = "personasDTO")
public class PersonasDTO implements Serializable {

    private Integer idorigen;
    private Integer idgrupo;
    private Integer idsocio;
    private String calle;
    private String numeroext;
    private String numeroint;
    private Integer idcolonia;
    private String entrecalles;
    private Object fechanacimiento;
    private String lugarnacimiento;
    private Integer efnacimiento;
    private BigDecimal sexo;
    private String telefono;
    private String telefonorecados;
    private Boolean listanegra = false;
    private BigDecimal estadocivil;
    private String idcoop;
    private Integer idsector;
    private Boolean estatus = false;
    private Boolean aceptado = false;
    private Object fechaingreso;
    private Object fecharetiro;
    private Object fechaciudad;
    private BigDecimal regimen_mat;
    private String nombre;
    private BigDecimal medio_inf;
    private Integer requisitos;
    private String appaterno;
    private String apmaterno;
    private BigDecimal nacionalidad;
    private BigDecimal grado_estudios;
    private BigDecimal categoria;
    private String rfc;
    private String curp;
    private String email;
    private String razon_social;
    private Integer causa_baja;
    private BigDecimal nivel_riesgo;
    private String celular;
    private Boolean rfc_valido = false;
    private Boolean curp_valido = false;
    private Integer pais_nacimiento;
    private Integer tipo_idoficial;
    private String clave_idoficial;
    private String fiel;
    private Object fecha_modificacion;
    private Integer modifico;

    public PersonasDTO() {
    }

    public PersonasDTO(int idorigen, int idgrupo, int idsocio) {
        this.idorigen = idorigen;
        this.idgrupo = idgrupo;
        this.idsocio = idsocio;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idorigen);
        hash = 97 * hash + Objects.hashCode(this.idgrupo);
        hash = 97 * hash + Objects.hashCode(this.idsocio);
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.appaterno);
        hash = 97 * hash + Objects.hashCode(this.apmaterno);
        hash = 97 * hash + Objects.hashCode(this.rfc);
        hash = 97 * hash + Objects.hashCode(this.curp);
        hash = 97 * hash + Objects.hashCode(this.razon_social);
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
        final PersonasDTO other = (PersonasDTO) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.appaterno, other.appaterno)) {
            return false;
        }
        if (!Objects.equals(this.apmaterno, other.apmaterno)) {
            return false;
        }
        if (!Objects.equals(this.rfc, other.rfc)) {
            return false;
        }
        if (!Objects.equals(this.curp, other.curp)) {
            return false;
        }
        if (!Objects.equals(this.razon_social, other.razon_social)) {
            return false;
        }
        if (!Objects.equals(this.idorigen, other.idorigen)) {
            return false;
        }
        if (!Objects.equals(this.idgrupo, other.idgrupo)) {
            return false;
        }
        if (!Objects.equals(this.idsocio, other.idsocio)) {
            return false;
        }
        return true;
    }

    /*@Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idorigen);
        hash = 53 * hash + Objects.hashCode(this.idgrupo);
        hash = 53 * hash + Objects.hashCode(this.idsocio);
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
        final PersonasDTO other = (PersonasDTO) obj;
        if (!Objects.equals(this.idorigen, other.idorigen)) {
            return false;
        }
        if (!Objects.equals(this.idgrupo, other.idgrupo)) {
            return false;
        }
        if (!Objects.equals(this.idsocio, other.idsocio)) {
            return false;
        }
        return true;
    }*/

    @Override
    public String toString() {
        return "PersonasDTO{" + "idorigen=" + idorigen + ", idgrupo=" + idgrupo + ", idsocio=" + idsocio + ", calle=" + calle + ", numeroext=" + numeroext + ", numeroint=" + numeroint + ", idcolonia=" + idcolonia + ", entrecalles=" + entrecalles + ", fechanacimiento=" + fechanacimiento + ", lugarnacimiento=" + lugarnacimiento + ", efnacimiento=" + efnacimiento + ", sexo=" + sexo + ", telefono=" + telefono + ", telefonorecados=" + telefonorecados + ", listanegra=" + listanegra + ", estadocivil=" + estadocivil + ", idcoop=" + idcoop + ", idsector=" + idsector + ", estatus=" + estatus + ", aceptado=" + aceptado + ", fechaingreso=" + fechaingreso + ", fecharetiro=" + fecharetiro + ", fechaciudad=" + fechaciudad + ", regimen_mat=" + regimen_mat + ", nombre=" + nombre + ", medio_inf=" + medio_inf + ", requisitos=" + requisitos + ", appaterno=" + appaterno + ", apmaterno=" + apmaterno + ", nacionalidad=" + nacionalidad + ", grado_estudios=" + grado_estudios + ", categoria=" + categoria + ", rfc=" + rfc + ", curp=" + curp + ", email=" + email + ", razon_social=" + razon_social + ", causa_baja=" + causa_baja + ", nivel_riesgo=" + nivel_riesgo + ", celular=" + celular + ", rfc_valido=" + rfc_valido + ", curp_valido=" + curp_valido + ", pais_nacimiento=" + pais_nacimiento + ", tipo_idoficial=" + tipo_idoficial + ", clave_idoficial=" + clave_idoficial + ", fiel=" + fiel + ", fecha_modificacion=" + fecha_modificacion + ", modifico=" + modifico + '}';
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

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroext() {
        return numeroext;
    }

    public void setNumeroext(String numeroext) {
        this.numeroext = numeroext;
    }

    public String getNumeroint() {
        return numeroint;
    }

    public void setNumeroint(String numeroint) {
        this.numeroint = numeroint;
    }

    public Integer getIdcolonia() {
        return idcolonia;
    }

    public void setIdcolonia(Integer idcolonia) {
        this.idcolonia = idcolonia;
    }

    public String getEntrecalles() {
        return entrecalles;
    }

    public void setEntrecalles(String entrecalles) {
        this.entrecalles = entrecalles;
    }

    public Object getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Object fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getLugarnacimiento() {
        return lugarnacimiento;
    }

    public void setLugarnacimiento(String lugarnacimiento) {
        this.lugarnacimiento = lugarnacimiento;
    }

    public Integer getEfnacimiento() {
        return efnacimiento;
    }

    public void setEfnacimiento(Integer efnacimiento) {
        this.efnacimiento = efnacimiento;
    }

    public BigDecimal getSexo() {
        return sexo;
    }

    public void setSexo(BigDecimal sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefonorecados() {
        return telefonorecados;
    }

    public void setTelefonorecados(String telefonorecados) {
        this.telefonorecados = telefonorecados;
    }

    public Boolean getListanegra() {
        return listanegra;
    }

    public void setListanegra(Boolean listanegra) {
        this.listanegra = listanegra;
    }

    public BigDecimal getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(BigDecimal estadocivil) {
        this.estadocivil = estadocivil;
    }

    public String getIdcoop() {
        return idcoop;
    }

    public void setIdcoop(String idcoop) {
        this.idcoop = idcoop;
    }

    public Integer getIdsector() {
        return idsector;
    }

    public void setIdsector(Integer idsector) {
        this.idsector = idsector;
    }

    public Boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }

    public Boolean getAceptado() {
        return aceptado;
    }

    public void setAceptado(Boolean aceptado) {
        this.aceptado = aceptado;
    }

    public Object getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Object fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public Object getFecharetiro() {
        return fecharetiro;
    }

    public void setFecharetiro(Object fecharetiro) {
        this.fecharetiro = fecharetiro;
    }

    public Object getFechaciudad() {
        return fechaciudad;
    }

    public void setFechaciudad(Object fechaciudad) {
        this.fechaciudad = fechaciudad;
    }

    public BigDecimal getRegimen_mat() {
        return regimen_mat;
    }

    public void setRegimen_mat(BigDecimal regimen_mat) {
        this.regimen_mat = regimen_mat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getMedio_inf() {
        return medio_inf;
    }

    public void setMedio_inf(BigDecimal medio_inf) {
        this.medio_inf = medio_inf;
    }

    public Integer getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(Integer requisitos) {
        this.requisitos = requisitos;
    }

    public String getAppaterno() {
        return appaterno;
    }

    public void setAppaterno(String appaterno) {
        this.appaterno = appaterno;
    }

    public String getApmaterno() {
        return apmaterno;
    }

    public void setApmaterno(String apmaterno) {
        this.apmaterno = apmaterno;
    }

    public BigDecimal getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(BigDecimal nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public BigDecimal getGrado_estudios() {
        return grado_estudios;
    }

    public void setGrado_estudios(BigDecimal grado_estudios) {
        this.grado_estudios = grado_estudios;
    }

    public BigDecimal getCategoria() {
        return categoria;
    }

    public void setCategoria(BigDecimal categoria) {
        this.categoria = categoria;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public Integer getCausa_baja() {
        return causa_baja;
    }

    public void setCausa_baja(Integer causa_baja) {
        this.causa_baja = causa_baja;
    }

    public BigDecimal getNivel_riesgo() {
        return nivel_riesgo;
    }

    public void setNivel_riesgo(BigDecimal nivel_riesgo) {
        this.nivel_riesgo = nivel_riesgo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Boolean getRfc_valido() {
        return rfc_valido;
    }

    public void setRfc_valido(Boolean rfc_valido) {
        this.rfc_valido = rfc_valido;
    }

    public Boolean getCurp_valido() {
        return curp_valido;
    }

    public void setCurp_valido(Boolean curp_valido) {
        this.curp_valido = curp_valido;
    }

    public Integer getPais_nacimiento() {
        return pais_nacimiento;
    }

    public void setPais_nacimiento(Integer pais_nacimiento) {
        this.pais_nacimiento = pais_nacimiento;
    }

    public Integer getTipo_idoficial() {
        return tipo_idoficial;
    }

    public void setTipo_idoficial(Integer tipo_idoficial) {
        this.tipo_idoficial = tipo_idoficial;
    }

    public String getClave_idoficial() {
        return clave_idoficial;
    }

    public void setClave_idoficial(String clave_idoficial) {
        this.clave_idoficial = clave_idoficial;
    }

    public String getFiel() {
        return fiel;
    }

    public void setFiel(String fiel) {
        this.fiel = fiel;
    }

    public Object getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Object fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public Integer getModifico() {
        return modifico;
    }

    public void setModifico(Integer modifico) {
        this.modifico = modifico;
    }

}
