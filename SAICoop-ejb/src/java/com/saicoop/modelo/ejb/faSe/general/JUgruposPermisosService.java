/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.dto.general.JUgruposPermisosDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author prometeo
 */
@Stateless
@LocalBean
public class JUgruposPermisosService {

    @EJB
    private JUgruposPermisosFacade ugruposPermisosFacade;

    public PaqueteDTO jUgruposPermisosCR(boolean esInserta, int idugrupo, int idpermiso) {
        return ugruposPermisosFacade.jUgruposPermisosCR(esInserta, idugrupo, idpermiso);
    }

    public List<JUgruposPermisosDTO> buscaPermisosInnerJoinUsuariosugrupos(int idusuario) {
        return ugruposPermisosFacade.buscaPermisosInnerJoinUsuariosugrupos(idusuario);
    }

    public List<JUgruposPermisosDTO> buscaTodosLosUgruposPermisos() {
        return ugruposPermisosFacade.buscaTodosLosUgruposPermisos();
    }

    public List<JUgruposPermisosDTO> buscaUgruposPermisos(int idugrupo) {
        return ugruposPermisosFacade.buscaUgruposPermisos(idugrupo);
    }
}
