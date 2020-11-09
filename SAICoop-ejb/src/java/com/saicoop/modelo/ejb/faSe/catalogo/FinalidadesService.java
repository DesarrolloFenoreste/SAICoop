/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.catalogo;

import com.saicoop.modelo.dto.catalogo.FinalidadesDTO;
import java.math.BigInteger;
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
public class FinalidadesService {

    @EJB
    private FinalidadesFacade finalidadesFacade;

    public FinalidadesDTO buscaFinalidadPorId(int idfinalidad) {
        return finalidadesFacade.buscaFinalidadPorId(idfinalidad);
    }

    public List<FinalidadesDTO> buscaFinalidadesPorDependencia(int dependede) {
        return finalidadesFacade.buscaFinalidadesPorDependencia(dependede);
    }

    public List<FinalidadesDTO> buscaTodasLasFinalidades() {
        return finalidadesFacade.buscaTodasLasFinalidades();
    }

    public int finalidadesCU(boolean esInserta, int idfinalidad, String descripcion, int dependede, Long clasif_contable_siti) {
        return finalidadesFacade.finalidadesCU(esInserta, idfinalidad, descripcion, dependede, clasif_contable_siti);
    }

    public int borrarFinalidad(int idfinalidad) {
        return finalidadesFacade.borrarFinalidad(idfinalidad);
    }

    public int proximoIdFinalidad() {
        return finalidadesFacade.proximoIdFinalidad();
    }
}
