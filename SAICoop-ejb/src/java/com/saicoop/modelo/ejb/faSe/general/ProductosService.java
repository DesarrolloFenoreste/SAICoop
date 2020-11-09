/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.dto.general.ProductosDTO;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author prometeo
 */
@Stateless
@LocalBean
public class ProductosService {

    @EJB
    private ProductosFacade productosFacade;

    public ProductosDTO buscaProductoPorId(int idproducto) {
        return productosFacade.buscaProductoPorId(idproducto);
    }
    
}
