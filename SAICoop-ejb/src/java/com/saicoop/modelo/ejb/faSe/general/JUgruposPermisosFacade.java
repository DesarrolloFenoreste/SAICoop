/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.general.JUgruposPermisosDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import java.util.ArrayList;
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
public class JUgruposPermisosFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    String todosLosUgruposPermisos = "select *from j_ugrupospermisos;";
    String buscaUgruposPermisosPorId = "select *from j_ugrupospermisos WHERE idugrupo=?";
    String buscaPermisosInnerJoinUsuariosugrupos = "SELECT up.idugrupo,up.idpermiso FROM j_usuariosugrupos uu INNER JOIN j_ugrupospermisos up ON  up.idugrupo= uu.idugrupo where uu.idusuario=?;";
    String insertaUgrupoPermiso = "insert into j_ugrupospermisos(idugrupo,idpermiso) values(?,?);";
    String eliminaUgrupoPermiso = "delete from j_ugrupospermisos where idugrupo=? and idpermiso=?";

    public List<JUgruposPermisosDTO> buscaTodosLosUgruposPermisos() {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(JUgruposPermisosDTO.class, listParametrosDTO, todosLosUgruposPermisos);
        return (List<JUgruposPermisosDTO>) paqueteDTO.getListResultadoDTO();
    }

    public List<JUgruposPermisosDTO> buscaUgruposPermisos(int idugrupo) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idugrupo));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(JUgruposPermisosDTO.class, listParametrosDTO, buscaUgruposPermisosPorId);
        return (List<JUgruposPermisosDTO>) paqueteDTO.getListResultadoDTO();
    }

    public List<JUgruposPermisosDTO> buscaPermisosInnerJoinUsuariosugrupos(int idusuario) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idusuario));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(JUgruposPermisosDTO.class, listParametrosDTO, buscaPermisosInnerJoinUsuariosugrupos);
        return (List<JUgruposPermisosDTO>) paqueteDTO.getListResultadoDTO();
    }

    public PaqueteDTO jUgruposPermisosCR(boolean esInserta, int idugrupo, int idpermiso) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", idugrupo));
            listParametrosDTOreg.add(new ParametrosDTO(2, "Integer", idpermiso));
            ListaParametros.add(listParametrosDTOreg);
            if (esInserta == true) {
                querys.add(insertaUgrupoPermiso);
            } else {
                querys.add(eliminaUgrupoPermiso);
            }
            // Ejecutamos el insert o update
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto;
        } catch (Exception e) {
            return null;
        }
    }

}
