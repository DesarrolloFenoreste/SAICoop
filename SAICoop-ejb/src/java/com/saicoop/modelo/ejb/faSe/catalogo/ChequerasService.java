/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.catalogo;

import com.saicoop.modelo.dto.catalogo.ChequerasDTO;
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
public class ChequerasService {

    @EJB
    private ChequerasFacade chequerasFacade;

    public ChequerasDTO buscaChequeraPorId(int idchequera) {
        return chequerasFacade.buscaChequeraPorId(idchequera);
    }

    public List<ChequerasDTO> buscaTodasLasChequeras() {
        return chequerasFacade.buscaTodasLasChequeras();
    }

    public int chequerasCU(boolean esInserta, int idchequera, int idbanco, String nombre, String idcuenta, int ultimocheque, String impresora, int idorigen) {
        return chequerasFacade.chequerasCU(esInserta, idchequera, idbanco, nombre, idcuenta, ultimocheque, impresora, idorigen);
    }

    public int borrarChequera(int idchequera) {
        return chequerasFacade.borrarChequera(idchequera);
    }

    public int proximoIdChequera() {
        return chequerasFacade.proximoIdChequera();
    }
}
