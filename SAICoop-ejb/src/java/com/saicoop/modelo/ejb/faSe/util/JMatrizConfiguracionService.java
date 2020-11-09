/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.dto.util.JMatrizConfiguracionDTO;
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
public class JMatrizConfiguracionService {

    @EJB
    private JMatrizConfiguracionFacade jMatrizConfiguracionFacade;

    public PaqueteDTO buscaTodoJMatrizConfig(int idmatriz) {
        return jMatrizConfiguracionFacade.buscaTodoJMatrizConfig(idmatriz);
    }

    public PaqueteDTO insertaJMatrizConfiguracion(int idconfiguracion, int idmatriz, String celda, String configuracion, int idcontenido) {
        return jMatrizConfiguracionFacade.insertaJMatrizConfiguracion(idconfiguracion, idmatriz, celda, configuracion, idcontenido);
    }

    public PaqueteDTO eliminaJMatrizConfiguracion(int idmatriz) {
        return jMatrizConfiguracionFacade.eliminaJMatrizConfiguracion(idmatriz);
    }

    public PaqueteDTO eliminaJMatrizConfiguracionPorIdConfiguracion(int idconfiguracion) {
        return jMatrizConfiguracionFacade.eliminaJMatrizConfiguracionPorIdConfiguracion(idconfiguracion);
    }

    public JMatrizConfiguracionDTO buscaJMatrizConfiguracionCelda(int idconfiguracion, int idmatriz, String celda) {
        return jMatrizConfiguracionFacade.buscaJMatrizConfiguracionCelda(idconfiguracion, idmatriz, celda);
    }

    public JMatrizConfiguracionDTO buscaJMatrizConfigConIdMatrizYCelda(int idmatriz, String celda) {
        return jMatrizConfiguracionFacade.buscaJMatrizConfigConIdMatrizYCelda(idmatriz, celda);
    }

    public PaqueteDTO actualizaJMatrizConfiguracion(int idconfiguracion, int idmatriz, String celda, String configuracion, int idcontenido) {
        return jMatrizConfiguracionFacade.actualizarJMatrizConfiguracion(idconfiguracion, idmatriz, celda, configuracion, idcontenido);
    }
}
