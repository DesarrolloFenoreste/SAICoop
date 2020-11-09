/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.dto.general.JUsuariospermisosDTO;
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
public class JUsuariospermisosService {

    @EJB
    private JUsuariospermisosFacade usuariospermisosFacade;

    public boolean permisos(int idusuario, String permiso) {
        return usuariospermisosFacade.permisos(idusuario, permiso);
    }

    public List<JUsuariospermisosDTO> buscaPermisosporIdUsuario(int idusuario) {
        return usuariospermisosFacade.buscaPermisosPorIdUsuario(idusuario);
    }

    public PaqueteDTO insertaUsuarioPermiso(int idusuario, int idpermiso) {
        return usuariospermisosFacade.usuarioPermisoCR(true, idusuario, idpermiso);
    }

    public PaqueteDTO eliminaUsuarioPermiso(int idusuario, int idpermiso) {
        return usuariospermisosFacade.usuarioPermisoCR(false, idusuario, idpermiso);
    }
}
