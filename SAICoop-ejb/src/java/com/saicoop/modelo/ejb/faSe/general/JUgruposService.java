/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.dto.general.JUgruposDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author prometeo
 */
@Stateless
@LocalBean
public class JUgruposService {

    @EJB
    private JUgruposFacade ugruposFacade;

    public PaqueteDTO jUgruposCU(boolean esInserta, int idugrupo, String nombre) {
        return ugruposFacade.jUgruposCU(esInserta, idugrupo, nombre);
    }

    public PaqueteDTO eliminaJUgrupo(int idugrupo) {
        return ugruposFacade.eliminaJUgrupo(idugrupo);
    }

    public int proximoIndiceJUGrupos() {
        return ugruposFacade.proximoIndiceJUGrupos();
    }

    public JUgruposDTO buscaJUGrupoPorIdugrupo(int idugrupo) {
        return ugruposFacade.buscaJUGrupoPorId(idugrupo);
    }

    public List<JUgruposDTO> buscaLosJUGrupos() {
        return ugruposFacade.buscaTodosLosJUGrupos();
    }

}
