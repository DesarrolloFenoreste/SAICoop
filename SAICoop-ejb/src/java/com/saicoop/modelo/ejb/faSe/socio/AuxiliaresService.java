/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.socio;

import com.saicoop.modelo.dto.socio.AuxiliaresDTO;
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
public class AuxiliaresService {

    @EJB
    private AuxiliaresFacade auxiliaresFacade;

    public List<AuxiliaresDTO> buscaAuxiliaresPorIds(int idorigen, int idgrupo, int idsocio) {
        return auxiliaresFacade.buscaAuxiliaresPorIds(idorigen, idgrupo, idsocio);
    }

    public List<AuxiliaresDTO> buscaAuxiliaresParaEstadosDeCuenta(String fechainicial, String fechafinal, String tipo) {
        return auxiliaresFacade.buscaAuxiliaresParaEstadosDeCuenta(fechainicial, fechafinal, tipo);
    }
}
