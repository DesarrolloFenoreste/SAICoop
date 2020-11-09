/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.socio;

import com.saicoop.modelo.dto.socio.VerificacionGeneralHuellaDigitalDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author gerardo
 */
@Stateless
@LocalBean
public class VerificacionGeneralHuellaDigitalService {

    @EJB
    private VerificacionGeneralHuellaDigitalFacade verificacionGeneralHuellaDigitalFacade;

    public VerificacionGeneralHuellaDigitalDTO buscaVerificacionGeneralHuellaDigitalDTOPorIdUsuario(int idusuario) {
        return verificacionGeneralHuellaDigitalFacade.buscaVerificacionGeneralHuellaDigitalDTOPorIdUsuario(idusuario);
    }

    public VerificacionGeneralHuellaDigitalDTO buscaVerificacionGeneralHuellaDigital(int idusuario, String modulo) {
        return verificacionGeneralHuellaDigitalFacade.buscaVerificacionGeneralHuellaDigital(idusuario, modulo);
    }

    public List<VerificacionGeneralHuellaDigitalDTO> buscaVerificacionGeneralHuellaDigitalPorIdUsuario(int idusuario) {
        return verificacionGeneralHuellaDigitalFacade.buscaVerificacionGeneralHuellaDigitalPorIdUsuario(idusuario);
    }

    public int actualizaVerificacionGeneralHuellaDigital(int idusuario, String modulo, int idorigen, int idgrupo, int idsocio) {
        return verificacionGeneralHuellaDigitalFacade.actualizaVerificacionGeneralHuellaDigital(idusuario, modulo, idorigen, idgrupo, idsocio);
    }

}
