/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.dto.util.TipoCambioDolarDTO;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author prometeo
 */
@Stateless
@LocalBean
public class TipoCambioDolarService {

    @EJB
    private TipoCambioDolarFacade tipoCambioDolarFacade;

    public TipoCambioDolarDTO buscaUltimoTipoCambio() {
        return tipoCambioDolarFacade.buscaUltimoTipoCambio();
    }

    public TipoCambioDolarDTO buscaTipoCambio(String fechatrabajo, String fecha) {
        return tipoCambioDolarFacade.buscaTipoCambio(fechatrabajo, fecha);
    }

    public int guardaUltimoTipoCambio(int idusuario, BigDecimal tipo_cambio) {
        return tipoCambioDolarFacade.guardaUltimoTipoCambio(idusuario, tipo_cambio);
    }
}
