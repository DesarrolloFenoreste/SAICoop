/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.dto.util.TemporalDTO;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import java.util.List;

/**
 *
 * @author prometeo
 */
@Stateless
@LocalBean
public class TemporalService {

    @EJB
    private TemporalFacade temporalFacade;

    public void insertaTemporal(String sesion, int idorigenp, int idproducto, int idauxiliar, int idusuario, int idorigen, int idgrupo, int idsocio, boolean esentrada, String cuenta, double acapital, int mov) {
        temporalFacade.insertaTemporal(sesion, idorigenp, idproducto, idauxiliar, idusuario, idorigen, idgrupo, idsocio, esentrada, cuenta, acapital, mov);
    }

    public void eliminaTemporal(String sesion, int idorigenp, int idproducto, int idauxiliar) {
        if (idorigenp == 0 && idproducto == 0 && idauxiliar == 0) {
            temporalFacade.eliminaTemporal(sesion);
        } else {
            temporalFacade.eliminaTemporal(sesion, idorigenp, idproducto, idauxiliar);
        }
    }

    public List<TemporalDTO> buscaTemporalIdusuario(int idusuario) {
        return temporalFacade.buscaTemporalIdusuario(idusuario);
    }

    public void actualizaTemporalHuella(int idusuario, int idorigenp, int idproducto, int idauxiliar, int mov) {
        temporalFacade.actualizaTemporalHuella(idusuario, idorigenp, idproducto, idauxiliar, mov);
    }
    
    public void actualizaTemporalHuellaOGS(int idusuario, int idorigen, int idgrupo, int idsocio) {
        temporalFacade.actualizaTemporalHuellaOGS(idusuario, idorigen, idgrupo, idsocio);
    }
    
}
