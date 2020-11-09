/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.general.ProductosDTO;
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
public class ProductosFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    String buscaProductoPorIdProducto = "SELECT * FROM productos WHERE idproducto = ?";

    /* -------------------------------------------------------------------------
     * RETORNAN AL CLIENTE
     ------------------------------------------------------------------------- */
    public ProductosDTO buscaProductoPorId(int idproducto) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idproducto));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(ProductosDTO.class, listParametrosDTO, buscaProductoPorIdProducto);
        return (ProductosDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

}
