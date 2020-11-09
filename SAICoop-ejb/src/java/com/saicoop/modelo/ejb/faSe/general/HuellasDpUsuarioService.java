/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.dto.general.HuellasDpUsuarioDTO;
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
public class HuellasDpUsuarioService {

    @EJB
    private HuellasDpUsuarioFacade huellasDpUsuarioFacade;

    public List<HuellasDpUsuarioDTO> buscarTodoHuellaUsuario(int formatohuella) {
        return huellasDpUsuarioFacade.buscarTodoHuellaUsuario(formatohuella);
    }

    public HuellasDpUsuarioDTO buscaHuellaUsuario(int idusuario, int formatoHuella) {
        return huellasDpUsuarioFacade.buscaHuellaUsuario(idusuario, formatoHuella);
    }

    public boolean huellaDigitalUsuario(boolean esInserta, int idusuarioIngreso, int idusuarioCapturo, List<byte[]> templateREG, List<byte[]> templateVER) {
        return huellasDpUsuarioFacade.huellaDigitalUsuario(esInserta, idusuarioIngreso, idusuarioCapturo, templateREG, templateVER);
    }

}
