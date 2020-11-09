/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.catalogo;

import com.saicoop.modelo.dto.catalogo.BancosDTO;
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
public class BancosService {

    @EJB
    private BancosFacade bancosFacade;

    public BancosDTO buscaBancosPorId(int idbanco) {
        return bancosFacade.buscaBancosPorId(idbanco);
    }

    public List<BancosDTO> buscaTodosLosBancos() {
        return bancosFacade.buscaTodosLosBancos();
    }

    public int bancosCU(boolean esInserta, int idbanco, String nombre, String banco_receptor) {
        return bancosFacade.bancosCU(esInserta, idbanco, nombre, banco_receptor);
    }

    public int borrarBanco(int idbanco) {
        return bancosFacade.borrarBanco(idbanco);
    }

    public int proximoIdBanco() {
        return bancosFacade.proximoIdBanco();
    }
}
