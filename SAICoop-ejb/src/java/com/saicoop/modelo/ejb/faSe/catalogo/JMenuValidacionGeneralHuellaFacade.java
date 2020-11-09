/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.catalogo;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.util.JMenuValidacionGeneralHuellaDTO;
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
public class JMenuValidacionGeneralHuellaFacade {

    @EJB
    private ControladorJDBC controladorJDBC;
    
    /* -------------------------------------------------------------------------
     * CONSULTAS
    ------------------------------------------------------------------------- */
    String menuValidacionGeneralHuella = "SELECT * FROM j_menu_validacion_general_huella WHERE estatus = true";
    // -------------------------------------------------------------------------
    
    // BUSCA AL SOCIO CON LA ENTIDAD
    public List<JMenuValidacionGeneralHuellaDTO> buscarMenuValidacionGeneralHuella() {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(JMenuValidacionGeneralHuellaDTO.class, listParametrosDTO, menuValidacionGeneralHuella);
        return (List<JMenuValidacionGeneralHuellaDTO>) paqueteDTO.getListResultadoDTO();
    }
    
}
