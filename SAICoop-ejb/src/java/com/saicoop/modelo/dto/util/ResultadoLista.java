/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.dto.util;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gerardo
 */
@XmlRootElement(name = "resultadoLista")
public class ResultadoLista implements Serializable {

    private List<String> resultadoLista;

    public ResultadoLista() {
    }
    
    public List<String> getResultadoLista() {
        return resultadoLista;
    }

    public void setResultadoLista(List<String> resultadoLista) {
        this.resultadoLista = resultadoLista;
    }

}
