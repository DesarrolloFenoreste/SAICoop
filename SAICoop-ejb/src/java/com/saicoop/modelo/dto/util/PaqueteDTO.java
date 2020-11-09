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
@XmlRootElement(name = "paqueteDTO")
public class PaqueteDTO implements Serializable {

    private List<?> listResultadoDTO;
    private List<ResultadoLista> listResultadoLista;
    private List<RaiceNotice> listRaiceNotice;
    private List<Integer> listAfecto;
    private String error;

    public PaqueteDTO() {
    }

    public PaqueteDTO(List<?> listResultadoDTO, List<ResultadoLista> listResultadoLista, List<RaiceNotice> listRaiceNotice, List<Integer> listAfecto, String error) {
        this.listResultadoDTO = listResultadoDTO;
        this.listResultadoLista = listResultadoLista;
        this.listRaiceNotice = listRaiceNotice;
        this.listAfecto = listAfecto;
        this.error = error;
    }

    public List<?> getListResultadoDTO() {
        return listResultadoDTO;
    }

    public void setListResultadoDTO(List<?> listResultadoDTO) {
        this.listResultadoDTO = listResultadoDTO;
    }

    public List<ResultadoLista> getListResultadoLista() {
        return listResultadoLista;
    }

    public void setListResultadoLista(List<ResultadoLista> listResultadoLista) {
        this.listResultadoLista = listResultadoLista;
    }

    public List<RaiceNotice> getListRaiceNotice() {
        return listRaiceNotice;
    }

    public void setListRaiceNotice(List<RaiceNotice> listRaiceNotice) {
        this.listRaiceNotice = listRaiceNotice;
    }

    public List<Integer> getListAfecto() {
        return listAfecto;
    }

    public void setListAfecto(List<Integer> listAfecto) {
        this.listAfecto = listAfecto;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "PaqueteDTO{" + "listResultadoDTO=" + listResultadoDTO + ", listResultadoLista=" + listResultadoLista + ", listRaiceNotice=" + listRaiceNotice + ", listAfecto=" + listAfecto + ", error=" + error + '}';
    }

}
