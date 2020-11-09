/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.dto.util.JMatrizContenidoDTO;
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
public class JMatrizContenidoService {

    @EJB
    private JMatrizContenidoFacade jMatrizContenidoFacade;

    public PaqueteDTO insertaJMatrizContenido(int idcontenido, String valor, int tipo, String descripcion) {
        return jMatrizContenidoFacade.insertaJMatrizContenido(idcontenido, valor, tipo, descripcion);
    }

    public PaqueteDTO eliminaJMatrizContenido(int idcontenido) {
        return jMatrizContenidoFacade.eliminaJMatrizContenido(idcontenido);
    }

    public JMatrizContenidoDTO buscaJMatrizContenidoPorId(int idconfig) {
        return jMatrizContenidoFacade.buscaJMatrizContenidoPorId(idconfig);
    }

    public PaqueteDTO buscaTodoJMatrizContenido() {
        return jMatrizContenidoFacade.buscaTodoJMatrizContenido();
    }

    public PaqueteDTO buscaJMatrizContenidoSoloPestañaPorPeriodo(String periodo) {
        return jMatrizContenidoFacade.buscaJMatrizContenidoSoloPestañaPorPeriodo(periodo);
    }

    public PaqueteDTO actualizaJMatrizContenido(int idcontenido, String valor, int tipo, String descripcion) {
        return jMatrizContenidoFacade.actualizaJMatrizContenido(idcontenido, valor, tipo, descripcion);
    }

    public PaqueteDTO buscaJMatrizContenidoPorIdMatriz(int idmatriz) {
        return jMatrizContenidoFacade.buscaJMatrizContenidoPorIdMatriz(idmatriz);
    }
}
