/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import com.saicoop.modelo.dto.util.QperfilesDTO;
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
public class QperfilesFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    String buscaTodosLosQPerfiles = "SELECT *FROM j_qperfiles";
    String buscaQPerfilPorIdQuery = "SELECT *FROM j_qperfiles WHERE idquery=?";
    String buscaQPerfilesPorIdGrupo = "SELECT *FROM j_qperfiles WHERE idugrupo=?";
    String buscaQPerfilPorIdQueryEIdGrupo = "SELECT *FROM j_qperfiles WHERE idquery=? AND idugrupo=?;";
    String guardaQPerfiles = "INSERT INTO j_qperfiles(idquery,idugrupo) VALUES (?,?);";
    String borraQPerfilesPorId = "DELETE FROM j_qperfiles WHERE idquery=?;";
    String borraQPerfilesPorIds = "DELETE FROM j_qperfiles WHERE idquery=? and idugrupo=?;";

    public List<QperfilesDTO> buscaQperfilesDTOPorIdQuery(int idquery) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idquery));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(QperfilesDTO.class, listParametrosDTO, buscaQPerfilPorIdQuery);
        return (List<QperfilesDTO>) paqueteDTO.getListResultadoDTO();
    }

    public List<QperfilesDTO> buscaQperfilesDTOPorIdugrupo(int idugrupo) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idugrupo));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(QperfilesDTO.class, listParametrosDTO, buscaQPerfilesPorIdGrupo);
        return (List<QperfilesDTO>) paqueteDTO.getListResultadoDTO();
    }

    public QperfilesDTO buscaQperfilesDTOPorIdQueryYIdugrupo(int idquery, int idugrupo) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idquery));
        listParametrosDTO.add(new ParametrosDTO(2, "Integer", idugrupo));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(QperfilesDTO.class, listParametrosDTO, buscaQPerfilPorIdQueryEIdGrupo);
        return (QperfilesDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

    public PaqueteDTO qPerfilesCR(boolean esInserta, int idquery, int idugrupo) {
        System.out.println("perfil");
        PaqueteDTO afecto = null;
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", idquery));
            listParametrosDTOreg.add(new ParametrosDTO(2, "Integer", idugrupo));
            ListaParametros.add(listParametrosDTOreg);
            if (esInserta == true) {
                querys.add(guardaQPerfiles);
            } else {
                querys.add(borraQPerfilesPorIds);
            }
            // Ejecutamos el insert o update
            afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto;
        } catch (Exception e) {
            if (afecto == null) {
                afecto = new PaqueteDTO();
            }
            afecto.setError(afecto.getError() + "\n" + e.getMessage());
            return afecto;
        }
    }

    public PaqueteDTO eliminaQPerfiles(int idquery) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", idquery));
            ListaParametros.add(listParametrosDTOreg);
            querys.add(borraQPerfilesPorId);
            // Ejecutamos el insert o update
            return controladorJDBC.procesaCRUD(querys, ListaParametros);
        } catch (Exception e) {
            return null;
        }
    }

}
