/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.general.JUsuariosugruposDTO;
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
public class JUsuariosugruposFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    String buscaGruposDeUsuariosPorId = "SELECT * FROM j_usuariosugrupos WHERE idusuario=?";
    String insertaUsuarioUgrupo = "insert into j_usuariosugrupos(idusuario,idugrupo) values(?,?);";
    String eliminaUsuarioUgrupo = "delete from j_usuariosugrupos where idusuario=? and idugrupo=?;";

    public PaqueteDTO jUsuariosugruposCR(boolean esInserta, int idusuario, int idugrupo) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", idusuario));
            listParametrosDTOreg.add(new ParametrosDTO(2, "Integer", idugrupo));
            ListaParametros.add(listParametrosDTOreg);
            if (esInserta == true) {
                querys.add(insertaUsuarioUgrupo);
            } else {
                querys.add(eliminaUsuarioUgrupo);
            }
            // Ejecutamos el insert o update
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto;
        } catch (Exception e) {
            return null;
        }
    }

    public List<JUsuariosugruposDTO> buscaUgruposPorIdUsuario(int idusuario) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idusuario));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(JUsuariosugruposDTO.class, listParametrosDTO, buscaGruposDeUsuariosPorId);
        return (List<JUsuariosugruposDTO>) paqueteDTO.getListResultadoDTO();
    }

}
