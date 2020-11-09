/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.dto.util.CuentasDTO;
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
public class CuentasService {

    @EJB
    private CuentasFacade cuentasFacade;

    public CuentasDTO buscaCuentaPorId(String idcuenta) {
        return cuentasFacade.buscaCuentaPorIdCuenta(idcuenta);
    }

    public List<CuentasDTO> buscaTodasLasCuentas() {
        return cuentasFacade.buscaTodasLasCuentas();
    }

    public CuentasDTO buscaCuentaPorIdClaseYTipo(String idcuenta, int clase, int tipo) {
        return cuentasFacade.buscaCuentaPorIdCuentaClaseYTipo(idcuenta, clase, tipo);
    }
}
