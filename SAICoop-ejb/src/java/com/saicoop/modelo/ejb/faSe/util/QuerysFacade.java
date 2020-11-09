/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import com.saicoop.modelo.dto.util.QueryDTO;
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
public class QuerysFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    String guardaQuery = "INSERT INTO j_query(idquery,descripcion,query,editable,remota) VALUES (?,?,?,?,?);";
    String actualizaQuery = "UPDATE j_query SET descripcion=?,query=?,editable=?,remota=? WHERE idquery=?;";
    String borraQuery = "DELETE FROM j_query WHERE idquery=?;";
    String buscaQueryPorIdQuery = "SELECT *FROM j_query WHERE idquery=?";
    String proximoIndice = "SELECT *FROM j_query order by idquery desc limit 1;";
    String innerQuerysDeUsuario = "SELECT q.idquery, q.descripcion, q.query, q.editable, q.remota FROM j_query q INNER JOIN j_qperfiles qp ON q.idquery=qp.idquery INNER JOIN j_usuariosugrupos ug ON  qp.idugrupo=ug.idugrupo WHERE ug.idusuario=? and q.idquery>10000;";
    String innerQuerysBaseDeUsuario = "SELECT q.idquery, q.descripcion, q.query, q.editable, q.remota FROM j_query q INNER JOIN j_qperfiles qp ON q.idquery=qp.idquery INNER JOIN j_usuariosugrupos ug ON  qp.idugrupo=ug.idugrupo WHERE ug.idusuario=? and q.idquery<=10000;";
    String innerQuerysLibres = "select *from j_query q where q.idquery is null or not exists(select qp.idquery from j_qperfiles qp where qp.idquery=q.idquery) and q.idquery>10000;";
    String innerQuerysLibresBase = "select *from j_query q where q.idquery is null or not exists(select qp.idquery from j_qperfiles qp where qp.idquery=q.idquery) and q.idquery<=10000;";

    public List<QueryDTO> getQueriesLibresDTO(boolean esBase) {
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        PaqueteDTO paqueteDTO = null;
        if (esBase == true) {
            paqueteDTO = controladorJDBC.procesaSelect(QueryDTO.class, listParametrosDTO, innerQuerysLibresBase);
        } else {
            paqueteDTO = controladorJDBC.procesaSelect(QueryDTO.class, listParametrosDTO, innerQuerysLibres);
        }
        return (List<QueryDTO>) paqueteDTO.getListResultadoDTO();
    }

    public List<QueryDTO> getQueriesPorIdUsuario(int idusuario, boolean esBase) {
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idusuario));
        PaqueteDTO paqueteDTO;
        if (esBase == true) {
            paqueteDTO = controladorJDBC.procesaSelect(QueryDTO.class, listParametrosDTO, innerQuerysBaseDeUsuario);
        } else {
            paqueteDTO = controladorJDBC.procesaSelect(QueryDTO.class, listParametrosDTO, innerQuerysDeUsuario);
        }
        return (List<QueryDTO>) paqueteDTO.getListResultadoDTO();
    }

    public PaqueteDTO eliminaQuery(int idquery) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", idquery));
            ListaParametros.add(listParametrosDTOreg);
            querys.add(borraQuery);
            // Ejecutamos el insert o update
            return controladorJDBC.procesaCRUD(querys, ListaParametros);
        } catch (Exception e) {
            return null;
        }
    }

    public PaqueteDTO QueryCU(boolean esInserta, int idquery, String descripcion, String query, boolean editable, boolean remota) {
        PaqueteDTO afecto = null;
        //System.out.println(esInserta + " - " + idquery + " - " + descripcion + " - " + query + " - " + editable + " - " + remota);
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            if (esInserta == true) {
                listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", idquery));
                listParametrosDTOreg.add(new ParametrosDTO(2, "String", descripcion));
                listParametrosDTOreg.add(new ParametrosDTO(3, "String", query));
                listParametrosDTOreg.add(new ParametrosDTO(4, "Boolean", editable));
                listParametrosDTOreg.add(new ParametrosDTO(5, "Boolean", remota));
                querys.add(guardaQuery);
            } else {
                listParametrosDTOreg.add(new ParametrosDTO(1, "String", descripcion));
                listParametrosDTOreg.add(new ParametrosDTO(2, "String", query));
                listParametrosDTOreg.add(new ParametrosDTO(3, "Boolean", editable));
                listParametrosDTOreg.add(new ParametrosDTO(4, "Boolean", remota));
                listParametrosDTOreg.add(new ParametrosDTO(5, "Integer", idquery));
                querys.add(actualizaQuery);
            }
            ListaParametros.add(listParametrosDTOreg);
            // Ejecutamos el insert o update
            afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            //System.out.println(afecto.getListAfecto().get(0));
            return afecto;
        } catch (Exception e) {
            if (afecto == null) {
                afecto = new PaqueteDTO();
            }
            afecto.setError(afecto.getError() + "\n" + e.getMessage());
            return afecto;
        }
    }

    public QueryDTO buscaQueryDTOPorId(int idquery) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idquery));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(QueryDTO.class, listParametrosDTO, buscaQueryPorIdQuery);
        return (QueryDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

    public int buscaProximoIdQuery(boolean vacio) {
        if (vacio == true) {
            int a = 0;
            while (true) {
                a = a + 1;
                if (buscaQueryDTOPorId(a) == null) {
                    break;
                }
            }
            return a;
        } else { // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
            // Ejecuta el proceso
            PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(QueryDTO.class, listParametrosDTO, proximoIndice);
            List<QueryDTO> lista = (List<QueryDTO>) paqueteDTO.getListResultadoDTO();
            if (!lista.isEmpty()) {
                if (lista.get(0) != null) {
                    int r = lista.get(0).getIdquery();
                    return r + 1;
                }
            }
            return 1;
        }

    }
}
