/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author prometeo
 */
@Stateless
@LocalBean
public class CarteraVencidaService {

    @EJB
    private CarteraVencidaFacade carteraVencidaFacade;

    public boolean seCalculoCarteravencida() {
        return carteraVencidaFacade.seCalculoCarteravencida();
    }
}
