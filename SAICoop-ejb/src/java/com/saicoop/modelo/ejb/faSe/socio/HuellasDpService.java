/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.socio;

import com.saicoop.modelo.dto.socio.HuellasDpDTO;
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
public class HuellasDpService {

    @EJB
    private HuellasDpFacade huellasDpFacade;

    public HuellasDpDTO buscarHuellaPorSocio(int idorigen, int idgrupo, int idsocio) {
        return huellasDpFacade.buscarHuellaPorSocio(idorigen, idgrupo, idsocio);
    }

    public List<HuellasDpDTO> buscarTodasHuellasSocio(int limit, int offset) {
        return huellasDpFacade.buscarTodo(limit, offset);
    }  
    
    public List<HuellasDpDTO> buscarTodasHuellasSocioSinByte(boolean estatus) {
        return huellasDpFacade.buscarTodoSinByte(estatus);
    }  

    public boolean huellaDigitalSocio(boolean esInserta, int idorigen, int idgrupo, int idsocio, int dedo, byte[] huella, int idusuario) {
        return huellasDpFacade.huellaDigitalSocio(esInserta, idorigen, idgrupo, idsocio, dedo, huella, idusuario);
    }

}
