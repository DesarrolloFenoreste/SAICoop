/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.dto.general.JPermisosDTO;
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
public class JPermisosService {

    @EJB
    private JPermisosFacade permisosFacade;

    public JPermisosDTO buscaJPermiso(int idpermiso) {
        return permisosFacade.buscaPermiso(idpermiso);
    }

    public List<JPermisosDTO> buscaJPermisos() {
        return permisosFacade.buscaPermisos();
    }

    public int proximoIndiceJPermisos() {
        return permisosFacade.proximoIndicePermisos();
    }

    public PaqueteDTO eliminaJPermiso(int idpermiso) {
        return permisosFacade.eliminaJPermiso(idpermiso);
    }

    public PaqueteDTO jPermisosCU(boolean esInserta, int idpermiso, String permiso, int idmenu, String descripcion, boolean estatus) {
        return permisosFacade.jPermisosCU(esInserta, idpermiso, permiso, idmenu, descripcion, estatus);
    }
}
