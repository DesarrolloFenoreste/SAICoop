/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.socio;

import com.saicoop.modelo.dto.socio.GruposDTO;
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
public class GruposService {

    @EJB
    private GruposFacade gruposFacade;

    public GruposDTO buscaGrupo(int idgrupo) {
        return gruposFacade.buscaGrupo(idgrupo);
    }

    public List<GruposDTO> buscaTodosLosGrupos() {
        return gruposFacade.buscaTodosLosGrupos();
    }

    public int eliminarGrupo(int idgrupo) {
        return gruposFacade.borrarGrupo(idgrupo);
    }

    public int gruposCU(boolean esInserta, int idgrupo, String nombre, int tipogrupo) {
        return gruposFacade.gruposCU(esInserta, idgrupo, nombre, tipogrupo);
    }

    public int proximoIdGrupos() {
        return gruposFacade.proximoIdGrupos();
    }
}
