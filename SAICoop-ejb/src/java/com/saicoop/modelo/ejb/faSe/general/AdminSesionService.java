/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.dto.general.AdminSesionDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author gerardo
 */
@Stateless
@LocalBean
public class AdminSesionService {

    @EJB
    private AdminSesionFacade adminSesionFacade;

    public AdminSesionDTO buscaAdminSesionPorUsuario(int idusuario) {
        return adminSesionFacade.buscaAdminSesionPorUsuario(idusuario);
    }

    public List<AdminSesionDTO> buscaAdminSesionTodo() {
        return adminSesionFacade.buscaAdminSesionTodo();
    }

    public int adminSesion(boolean esInserta, int idusuario, String sesionServidor, String ipLocal, String ipExterna, String macAddress, String ipBaseDatos, String baseDatos, String usuarioSistemaOperativo, String sistemaOperativo, String versionSistemaOperativo, String arquitecturaSistemaOperativo) {
        return adminSesionFacade.adminSesion(esInserta, idusuario, sesionServidor, ipLocal, ipExterna, macAddress, ipBaseDatos, baseDatos, usuarioSistemaOperativo, sistemaOperativo, versionSistemaOperativo, arquitecturaSistemaOperativo);
    }

    public int actualizaAdminSesionEstatus(int idusuario, boolean estatus) {
        return adminSesionFacade.actualizaAdminSesionEstatus(idusuario, estatus);
    }

    public int actualizaAdminSesionBloqueo(int idusuario, boolean bloqueo) {
        return adminSesionFacade.actualizaAdminSesionBloqueo(idusuario, bloqueo);
    }

}
