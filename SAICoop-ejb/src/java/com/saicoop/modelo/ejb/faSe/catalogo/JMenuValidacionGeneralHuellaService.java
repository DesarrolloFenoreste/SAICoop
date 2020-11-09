/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.catalogo;

import com.saicoop.modelo.dto.util.JMenuValidacionGeneralHuellaDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author gerardo
 */
@Stateless
@LocalBean
public class JMenuValidacionGeneralHuellaService {

    @EJB
    private JMenuValidacionGeneralHuellaFacade jMenuValidacionGeneralHuellaFacade;

    public List<JMenuValidacionGeneralHuellaDTO> buscarMenuValidacionGeneralHuella() {
        return jMenuValidacionGeneralHuellaFacade.buscarMenuValidacionGeneralHuella();
    }

}
