/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.dto.util.JMatrizDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author prometeo
 */
@Stateless
@LocalBean
public class JMatrizService {

    @EJB
    private JMatrizFacade jMatrizFacade;

    public PaqueteDTO buscaTodasLasJMatrices() {
        return jMatrizFacade.buscaTodasLasJMatrices();
    }

    public JMatrizDTO buscaJMatrizPorId(int idMatriz) {
        return jMatrizFacade.buscaJMatrizPorId(idMatriz);
    }

    public PaqueteDTO insertaJMatriz(int idmatriz, String nombre, int filas, int columnas, String periodo, String descripcion, int tipo, String autor, int administrador, String grupo) {
        return jMatrizFacade.insertaJMatriz(idmatriz, nombre, filas, columnas, periodo, descripcion, tipo, autor, administrador, grupo);
    }

    public PaqueteDTO eliminaJMatriz(int idmatriz) {
        return jMatrizFacade.eliminaJMatriz(idmatriz);
    }

    public PaqueteDTO actualizaJMatriz(int idmatriz, String nombre, int filas, int columnas, String periodo, String descripcion, int tipo, String autor, int administrador, String grupo) {
        return jMatrizFacade.actualizaJMatriz(idmatriz, nombre, filas, columnas, periodo, descripcion, tipo, autor, administrador, grupo);
    }
}
