/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.general.JCatalogoMenusDTO;
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
public class JCatalogoMenusFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    private String buscaTodosLosElementosDeMenu = "select *from j_catalogo_menus order by dependede,orden asc;";
    private String buscaMenuPorId = "select *from j_catalogo_menus where idmenu=?;";

    public PaqueteDTO buscaTodoElCatalogoDeMenu() {
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(JCatalogoMenusDTO.class, listParametrosDTO, buscaTodosLosElementosDeMenu);
        return paqueteDTO;
    }

    public JCatalogoMenusDTO buscaMenuPorId(int idmenu) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idmenu));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(JCatalogoMenusDTO.class, listParametrosDTO, buscaMenuPorId);
        return (JCatalogoMenusDTO) paqueteDTO.getListResultadoDTO().get(0);
    }
}
