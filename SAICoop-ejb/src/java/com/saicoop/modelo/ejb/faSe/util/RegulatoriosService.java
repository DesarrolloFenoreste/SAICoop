/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.dto.util.PaqueteDTO;
import com.saicoop.modelo.dto.util.JRegulatoriosDTO;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author prometeo
 */
@Stateless
@LocalBean
public class RegulatoriosService {

    @EJB
    private RegulatoriosFacade regulatoriosFacade;

    public PaqueteDTO buscaTodosLosRegulatorios() {
        return regulatoriosFacade.buscaTodosLosRegulatorios();
    }

    public JRegulatoriosDTO buscaRegulatorioPorSerieYIdReg(String serie, String idreg) {
        return regulatoriosFacade.buscaRegulatorioPorSerieYIdReg(serie, idreg);
    }

    public PaqueteDTO buscaRegulatorioPorSerie(String serie) {
        return regulatoriosFacade.buscaRegulatorioPorSerie(serie);
    }

    public PaqueteDTO buscaRegulatorioPorIdReg(String idreg) {
        return regulatoriosFacade.buscaRegulatorioPorIdReg(idreg);
    }

    public PaqueteDTO borrarRegulatorio(String serie, String idreg) {
        try {
            return regulatoriosFacade.borrarRegulatorio(serie, idreg);
        } catch (Exception e) {
            return null;
        }
    }

    public PaqueteDTO regulatoriosCU(boolean esInserta, String serie, String idreg, String descripcion, int periodo, String funcion, String consulta, boolean visible) {
        try {
            return regulatoriosFacade.regulatoriosCU(esInserta, serie, idreg, descripcion, periodo, funcion, consulta, visible);
        } catch (Exception e) {
            return null;
        }
    }
}
