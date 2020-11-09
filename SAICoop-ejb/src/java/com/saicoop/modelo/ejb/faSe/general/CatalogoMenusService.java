/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.dto.general.CatalogoMenusDTO;
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
public class CatalogoMenusService {

    @EJB
    private CatalogoMenusFacade catalogoMenusFacade;

    public CatalogoMenusDTO buscaCatalogoPorMenuYOpcion(String menu, Integer opcion) {
        return catalogoMenusFacade.buscaCatalogoPorMenuYOpcion(menu, opcion);
    }

    public PaqueteDTO buscaCatalogoPorMenu(String menu) {
        return catalogoMenusFacade.buscaCatalogoPorMenu(menu);
    }
}
