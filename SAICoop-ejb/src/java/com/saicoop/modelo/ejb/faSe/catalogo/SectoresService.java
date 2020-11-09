/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.catalogo;

import com.saicoop.modelo.dto.catalogo.SectoresDTO;
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
public class SectoresService {

    @EJB
    private SectoresFacade sectoresFacade;

    public List<SectoresDTO> buscaTodosLosSectores() {
        return sectoresFacade.buscaTodosLosSectores();
    }

    public SectoresDTO buscaSectorPoId(int idsector) {
        return sectoresFacade.buscaSectorPoId(idsector);
    }

    public int sectoresCU(boolean esInserta, int idsector, String nombre) {
        return sectoresFacade.sectoresCU(esInserta, idsector, nombre);
    }

    public int proximoIdSector() {
        return sectoresFacade.proximoIdSector();
    }

    public int borrarSector(int idsector) {
        return sectoresFacade.borrarSector(idsector);
    }
}
