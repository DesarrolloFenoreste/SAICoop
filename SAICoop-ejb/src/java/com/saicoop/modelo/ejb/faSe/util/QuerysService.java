/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.dto.util.PaqueteDTO;
import com.saicoop.modelo.dto.util.QueryDTO;
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
public class QuerysService {

    @EJB
    private QuerysFacade querysFacade;

    public PaqueteDTO eliminaQuery(int idquery) {
        return querysFacade.eliminaQuery(idquery);
    }

    public PaqueteDTO QueryCU(boolean esInserta, int idquery, String descripcion, String query, boolean editable, boolean remota) {
        return querysFacade.QueryCU(esInserta, idquery, descripcion, query, editable, remota);
    }

    public QueryDTO buscaQueryDTOPorId(int idquery) {
        return querysFacade.buscaQueryDTOPorId(idquery);
    }

    public int buscaProximoIdQuery(boolean esVacio) {
        int g = querysFacade.buscaProximoIdQuery(esVacio);
        System.out.println(g);
        return g;
    }

    public List<QueryDTO> getQueriesLibresDTO(boolean esBase) {
        return querysFacade.getQueriesLibresDTO(esBase);
    }

    public List<QueryDTO> getQueriesPorIdUsuario(int idusuario, boolean esBase) {
        return querysFacade.getQueriesPorIdUsuario(idusuario, esBase);
    }
}
