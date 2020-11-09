/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.dto.util.HuellasColaGuardadoDTO;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author gerardo
 */
@Stateless
@LocalBean
public class HuellasColaGuardadoService {

    @EJB
    private HuellasColaGuardadoFacade hellasColaGuardadoFacade;

    public HuellasColaGuardadoDTO BuscaSocioPorIdusuario(int idusuario) {
        return hellasColaGuardadoFacade.buscaIdsocioCola(idusuario);
    }
    
    public void eliminaHuellasColaGuardado(int idusuario) {
        hellasColaGuardadoFacade.eliminaHuellasColaGuardado(idusuario);
    }
    
}
