/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.dto.general.JUsuariosugruposDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author prometeo
 */
@Stateless
@LocalBean
public class JUsuariosugruposService {

    @EJB
    private JUsuariosugruposFacade usuariosugruposFacade;

    public List<JUsuariosugruposDTO> buscauGruposporIdUsuario(int idusuario) {
        return usuariosugruposFacade.buscaUgruposPorIdUsuario(idusuario);
    }

    public PaqueteDTO jUsuariosugruposCR(boolean esInserta, int idusuario, int idugrupo) {
        return usuariosugruposFacade.jUsuariosugruposCR(esInserta, idusuario, idugrupo);
    }

}
