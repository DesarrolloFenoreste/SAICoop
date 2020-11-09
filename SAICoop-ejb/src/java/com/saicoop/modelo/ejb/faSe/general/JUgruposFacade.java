/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.general.JUgruposDTO;
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
public class JUgruposFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    String proximoIndiceJUgrupos = "select *from j_ugrupos order by idugrupo desc limit 1 ";
    String buscaTodosLosUGrupos = "SELECT *FROM j_ugrupos;";
    String buscaUGruposPorIdUGrupo = "SELECT *FROM j_ugrupos WHERE idugrupo=?;";
    String buscaUGruposPorNombre = "SELECT *FROM j_ugrupos WHERE nombre =?;";
    String insertaJUGrupo = "insert into j_ugrupos(idugrupo,nombre) values(?,?);";
    String actualizaJUGrupo = "update j_ugrupos set nombre=? where idugrupo=?;";
    String eliminaJUGrupo = "delete from j_ugrupos where idugrupo=?;";

    public PaqueteDTO jUgruposCU(boolean esInserta, int idugrupo, String nombre) {
        PaqueteDTO afecto = null;
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            if (esInserta == true) {
                listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", idugrupo));
                listParametrosDTOreg.add(new ParametrosDTO(2, "String", nombre));
                querys.add(insertaJUGrupo);
            } else {
                listParametrosDTOreg.add(new ParametrosDTO(1, "String", nombre));
                listParametrosDTOreg.add(new ParametrosDTO(2, "Integer", idugrupo));
                querys.add(actualizaJUGrupo);
            }
            ListaParametros.add(listParametrosDTOreg);
            // Ejecutamos el insert o update
            afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
        } catch (Exception e) {
            if (afecto != null) {
                afecto.setError(afecto.getError() + "\n" + e.getMessage());
            }
        }
        return afecto;
    }

    public PaqueteDTO eliminaJUgrupo(int idugrupo) {
        PaqueteDTO afecto = null;
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", idugrupo));
            ListaParametros.add(listParametrosDTOreg);
            querys.add(eliminaJUGrupo);
            // Ejecutamos el insert o update
            afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
        } catch (Exception e) {
            if (afecto != null) {
                afecto.setError(afecto.getError() + "\n" + e.getMessage());
            }
        }
        return afecto;
    }

    public int proximoIndiceJUGrupos() {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(JUgruposDTO.class, listParametrosDTO, proximoIndiceJUgrupos);
        return ((JUgruposDTO) paqueteDTO.getListResultadoDTO().get(0)).getIdugrupo() + 1;
    }

    public JUgruposDTO buscaJUGrupoPorId(int idugrupo) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idugrupo));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(JUgruposDTO.class, listParametrosDTO, buscaUGruposPorIdUGrupo);
        return (JUgruposDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

    public List<JUgruposDTO> buscaTodosLosJUGrupos() {
        List<JUgruposDTO> lDTOs = new ArrayList<>(0);
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(JUgruposDTO.class, listParametrosDTO, buscaTodosLosUGrupos);
        List<JUgruposDTO> l = (List<JUgruposDTO>) paqueteDTO.getListResultadoDTO();
        for (int i = 0; i < l.size(); i++) {
            JUgruposDTO dto = l.get(i);
            lDTOs.add(dto);
        }
        return lDTOs;
    }
}
