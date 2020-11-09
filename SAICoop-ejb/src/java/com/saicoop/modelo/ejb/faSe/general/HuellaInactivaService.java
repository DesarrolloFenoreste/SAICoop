/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.dto.general.HuellaInactivaDTO;
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
public class HuellaInactivaService {

    @EJB
    private HuellaInactivaFacade huellaInactivaFacade;

    public HuellaInactivaDTO buscaHuellaInactivaPorOGSyFecha(Integer idorigen, Integer idgrupo, Integer idsocio, String fecha) {
        return huellaInactivaFacade.buscaHuellaInactivaPorOGSyFecha(idorigen, idgrupo, idsocio, fecha);
    }

    public PaqueteDTO buscaHuellaInactivaPorOGS(Integer idorigen, Integer idgrupo, Integer idsocio) {
        return huellaInactivaFacade.buscaHuellaInactivaPorOGS(idorigen, idgrupo, idsocio);
    }

    public PaqueteDTO insertaHuellaInactiva(Integer idorigen, Integer idgrupo, Integer idsocio, Integer motivo, Integer usuario) {
        return huellaInactivaFacade.insertaHuellaInactiva(idorigen, idgrupo, idsocio, motivo, usuario);
    }
}
