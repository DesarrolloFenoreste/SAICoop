/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.general.CatalogoMenusDTO;
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
public class CatalogoMenusFacade {

    @EJB
    private ControladorJDBC controladorJDBC;
    /*
    CREATE TABLE catalogo_menus
    (
    menu character varying NOT NULL,
    opcion integer NOT NULL,
    descripcion character varying,
    orden integer,
    activo boolean,
    referencia character varying,
    CONSTRAINT catalogo_menus_pkey PRIMARY KEY (menu, opcion)
    )
     */
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private static final String buscaCatalogoPorMenu = "select *from catalogo_menus where menu=?;";
    private static final String buscaCatalogoPorMenuYOpcion = "select *from catalogo_menus where menu=? and opcion=?;";

    public CatalogoMenusDTO buscaCatalogoPorMenuYOpcion(String menu, Integer opcion) {
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "String", menu));
        listParametrosDTO.add(new ParametrosDTO(2, "Integer", opcion));
        return (CatalogoMenusDTO) controladorJDBC.procesaSelect(CatalogoMenusDTO.class, listParametrosDTO, buscaCatalogoPorMenuYOpcion).getListResultadoDTO().get(0);
    }

    public PaqueteDTO buscaCatalogoPorMenu(String menu) {
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "String", menu));
        return controladorJDBC.procesaSelect(CatalogoMenusDTO.class, listParametrosDTO, buscaCatalogoPorMenu);
    }
}
