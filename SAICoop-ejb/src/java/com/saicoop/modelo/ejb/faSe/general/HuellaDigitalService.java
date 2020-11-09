/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.dto.general.HuellasDpUsuarioDTO;
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
public class HuellaDigitalService {

    @EJB
    private HuellaDigitalFacade huellaDigitalFacade;

    public List<HuellasDpDTO> huellasDPsocios(int limit, int offset) {
        return huellaDigitalFacade.huellasDPsocios(limit, offset);
    }

    public HuellasDpUsuarioDTO huellasDPusuario(int idusuario, int formatoHuella) {
            return huellaDigitalFacade.huellasDPusuario(idusuario, formatoHuella);
    }
    
    public boolean generaImagenHuella(byte[] imagen, String asignado, int toma, String carpeta, int dedo) {
        return huellaDigitalFacade.generaImagenHuella(imagen, asignado, toma, carpeta, dedo);
    }
    
}
