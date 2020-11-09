/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.dto.util.JMatrizReferenciaDTO;
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
public class JMatrizReferenciaService {

    @EJB
    private JMatrizReferenciaFacade jMatrizReferenciaFacade;

    public PaqueteDTO insertaJMatrizReferencia(int idreferencia, String periodo, int idcontenido, String valor, String descripcion) {
        return jMatrizReferenciaFacade.insertaJMatrizReferencia(idreferencia, periodo, idcontenido, valor, descripcion);
    }

    public JMatrizReferenciaDTO buscaJMatrizReferenciaPorIdContenido(Integer idcontenido) {
        return jMatrizReferenciaFacade.buscaJMatrizReferenciaPorIdContenido(idcontenido);
    }

    public PaqueteDTO eliminaJMatrizReferencia(int idreferencia) {
        return jMatrizReferenciaFacade.eliminaJMAtrizReferencia(idreferencia);
    }

    public JMatrizReferenciaDTO buscaJMatrizReferenciaPorId(int idReferencia, String periodo, Integer idContenido) {
        return jMatrizReferenciaFacade.buscaJMatrizReferenciaPorId(idReferencia, periodo, idContenido);
    }

    public PaqueteDTO buscaTodoJMatrizReferencia() {
        return jMatrizReferenciaFacade.buscaTodoJMatrizReferencia();
    }

    public PaqueteDTO buscaJMatrizReferenciaSoloPestañaPorPeriodo(String periodo) {
        return jMatrizReferenciaFacade.buscaJMatrizReferenciaSoloPestañaPorPeriodo(periodo);
    }

    public PaqueteDTO actualizaJMatrizReferencia(int idreferencia, String periodo, int idcontenido, String valor, String descripcion) {
        return jMatrizReferenciaFacade.actualizaJMatrizReferencia(idreferencia, periodo, idcontenido, valor, descripcion);
    }

    public PaqueteDTO buscaJMatrizReferenciasPorIdMatriz(int idmatriz) {
        return jMatrizReferenciaFacade.buscaJMatrizReferenciasPorIdMatriz(idmatriz);
    }
}
