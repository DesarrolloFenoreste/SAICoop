/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import com.saicoop.modelo.dto.util.PolizasDTO;
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
public class PolizasFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    String buscaPolizasPorIdUsuarioYFecha = "SELECT *FROM polizas WHERE fecha=? AND idusuario=?";

    public List<PolizasDTO> buscaPolizasDTOPorfechayusuario(String fecha, int idusuario) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "String", fecha));
        listParametrosDTO.add(new ParametrosDTO(2, "Integer", idusuario));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(PolizasDTO.class, listParametrosDTO, buscaPolizasPorIdUsuarioYFecha);
        return (List<PolizasDTO>) paqueteDTO.getListResultadoDTO();
    }
}
