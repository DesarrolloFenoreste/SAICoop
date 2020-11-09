/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.catalogo;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.catalogo.PaisesDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author gerardo
 */
@Stateless
@LocalBean
public class PaisesFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    // --- SELECT --------------------------------------------------------------
    String buscaTodosLosEstados = "SELECT * FROM paises ORDER BY idpais ASC";
    String buscaPaisPorEstado = " ";
    // -------------------------------------------------------------------------

    public List<PaisesDTO> buscaTodosLosPaises() {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(PaisesDTO.class, listParametrosDTO, buscaTodosLosEstados);
        return (List<PaisesDTO>) paqueteDTO.getListResultadoDTO();
    }
    
    public PaisesDTO buscaPaisPorEstado(int idestado) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idestado));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(PaisesDTO.class, listParametrosDTO, buscaPaisPorEstado);
        return (PaisesDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

}
