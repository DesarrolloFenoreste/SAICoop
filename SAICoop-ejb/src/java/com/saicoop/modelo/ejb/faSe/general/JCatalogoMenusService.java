/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.dto.general.JCatalogoMenusDTO;
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
public class JCatalogoMenusService {

    @EJB
    private JCatalogoMenusFacade jCatalogoMenusFacade;

    public PaqueteDTO buscaTodoElCatalogoDeMenu() {
        return jCatalogoMenusFacade.buscaTodoElCatalogoDeMenu();
    }

    public JCatalogoMenusDTO buscaMenuPorId(int idmenu) {
        return jCatalogoMenusFacade.buscaMenuPorId(idmenu);
    }
}
