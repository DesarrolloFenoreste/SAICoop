package com.saicoop.modelo.conexion;

import java.io.Serializable;

/**
 *
 * @author Gerardo Treviño Montelongo
 * @version 1.00.001
 * @fecha 17 de Julio de 2017
 * @descripción: Clase que se usa como referencia para pasar los valores al 
 * preparedStatement
 */
public class ParametrosDTO implements Serializable {

    // Posicion del valor
    private int posicion; 
    // Tipo de valor
    private String tipo;
    // Valor, se envia como Object para despues castearlo
    private Object valor;

    public ParametrosDTO() {
    }

    public ParametrosDTO(int posicion, String tipo, Object valor) {
        this.posicion = posicion;
        this.tipo = tipo;
        this.valor = valor;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.posicion;
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
        final ParametrosDTO other = (ParametrosDTO) obj;
        return this.posicion == other.posicion;
    }

    @Override
    public String toString() {
        return "ParametrosDTO{" + "posicion=" + posicion + ", tipo=" + tipo + ", valor=" + valor + '}';
    }

}
