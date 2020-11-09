/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.general.JUsuariospermisosDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import java.util.ArrayList;
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
public class JUsuariospermisosFacade {

    @EJB
    private JPermisosFacade jPermisosFacade;

    @EJB
    private ControladorJDBC controladorJDBC;

    String buscaPermisosDeUsuarioPorId = " SELECT * FROM j_usuariospermisos WHERE idusuario = ?;";
    String buscaPermisosPorIdYPermiso = " SELECT * FROM j_usuariospermisos jup INNER JOIN j_permisos jp ON jp.idpermiso = jup.idpermiso WHERE jup.idusuario = ? AND jp.permiso = ?;";
    String insertaUsuarioPermiso = " INSERT INTO j_usuariospermisos(idusuario, idpermiso) values(?, ?);";
    String eliminaUsuarioPermiso = " DELETE FROM j_usuariospermisos WHERE idusuario = ? AND idpermiso = ?;";

    public PaqueteDTO usuarioPermisoCR(boolean esInserta, int idusuario, int idpermiso) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", idusuario));
            listParametrosDTOreg.add(new ParametrosDTO(2, "Integer", idpermiso));
            ListaParametros.add(listParametrosDTOreg);
            if (esInserta == true) {
                querys.add(insertaUsuarioPermiso);
            } else {
                querys.add(eliminaUsuarioPermiso);
            }
            // Ejecutamos el insert o update
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto;
        } catch (Exception e) {
            return null;
        }
    }

    //retorna usuarios permisos
    public PaqueteDTO buscaPermisosdeUsuarioConIdYPermiso(int idusuario, String permiso) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idusuario));
        listParametrosDTO.add(new ParametrosDTO(2, "String", permiso));
        // Ejecuta el proceso
        return controladorJDBC.procesaSelect(JUsuariospermisosDTO.class, listParametrosDTO, buscaPermisosPorIdYPermiso);

    }

    public boolean permisos(int idusuario, String permiso) {
        PaqueteDTO paqueteDTO1 = buscaPermisosdeUsuarioConIdYPermiso(idusuario, permiso);
        PaqueteDTO paqueteDTO2 = jPermisosFacade.innerPermisosDeGrupoDeUsuario(idusuario, permiso);
        return !(validaLista(paqueteDTO1.getListResultadoDTO()) == false && validaLista(paqueteDTO2.getListResultadoDTO()) == false);
    }

    private boolean validaLista(List lista) {
        if (lista.isEmpty()) {
            return false;
        } else if (lista.get(0) == null) {
            return false;
        } else {
            return true;
        }
    }

    public List<JUsuariospermisosDTO> buscaPermisosPorIdUsuario(int idusuario) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idusuario));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(JUsuariospermisosDTO.class, listParametrosDTO, buscaPermisosDeUsuarioPorId);
        return (List<JUsuariospermisosDTO>) paqueteDTO.getListResultadoDTO();
    }
}
