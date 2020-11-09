/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
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
public class EjecucionDeQuerysFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    public PaqueteDTO ejecutaQuery(String query) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(null, listParametrosDTO, query);
        return paqueteDTO;
    }

    public PaqueteDTO ejecutaQueries(List<String> querys) {
        try {
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            // Ejecutamos el insert o update
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys,ListaParametros);
            //System.out.println(afecto.getListAfecto().get(0));
            return afecto;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
