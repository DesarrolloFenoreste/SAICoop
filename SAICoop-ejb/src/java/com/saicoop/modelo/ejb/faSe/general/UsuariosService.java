/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.dto.general.UsuariosDTO;
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
public class UsuariosService {

    @EJB
    private UsuariosFacade usuariosFacade;

    public void actualizaPIngreso(int idusuario, String pingreso) {
        usuariosFacade.actualizaPIngreso(idusuario, pingreso);
    }

    public UsuariosDTO buscaUsuarioPorId(int idusuario) {
        return usuariosFacade.buscaUsuario(idusuario);
    }

    public List<UsuariosDTO> buscaTodosLosUsuarios() {
        return usuariosFacade.buscaTodosLosUsuarios();
    }
}
