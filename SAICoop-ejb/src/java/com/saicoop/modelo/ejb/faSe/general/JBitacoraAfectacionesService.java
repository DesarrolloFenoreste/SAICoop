/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

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
public class JBitacoraAfectacionesService {

    @EJB
    private JBitacoraAfectacionesFacade jBitacoraAfectacionesFacade;

    public PaqueteDTO guardaEnBitacoraAfectaciones(int idmenu, int idaccion, int idusuario, String referencia, String detalle) {
        return jBitacoraAfectacionesFacade.guardaEnBitacoraAfectaciones(idmenu, idaccion, idusuario, referencia, detalle);
    }
}
