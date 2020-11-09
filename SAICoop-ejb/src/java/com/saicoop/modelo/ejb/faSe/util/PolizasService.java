/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.dto.util.PolizasDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author prometeo
 */
@Stateless
@LocalBean
public class PolizasService {

    @EJB
    private PolizasFacade polizasFacade;

    public List<PolizasDTO> buscaPolizasDTOPorfechayusuario(String fecha, int idusuario) {
        System.out.println(fecha);
        return polizasFacade.buscaPolizasDTOPorfechayusuario(fecha, idusuario);
    }
}
