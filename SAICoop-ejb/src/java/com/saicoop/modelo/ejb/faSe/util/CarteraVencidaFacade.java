/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import com.saicoop.modelo.ejb.impl.SaiFunciones;
import com.saicoop.modelo.ejb.util.KitWeb;
import java.util.ArrayList;
import java.util.Date;
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
public class CarteraVencidaFacade {

    @EJB
    private SaiFunciones saiFunciones;
    @EJB
    private ControladorJDBC controladorJDBC;

    KitWeb kitweb = new KitWeb();

    String fechaCarteravencida = "SELECT fechacalculo FROM carteravencida ORDER BY fechacalculo DESC LIMIT 1";

    public boolean seCalculoCarteravencida() {
        try {
            Date dateFEchaTrabajo = kitweb.getDateDeSqlDate(saiFunciones.saiFechaTrabajo());
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
            // Ejecuta el proceso
            PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(null, listParametrosDTO, fechaCarteravencida);
            String fecha = paqueteDTO.getListResultadoLista().get(2).getResultadoLista().get(0);
            Date dateFechaCartera = kitweb.getDateDeSqlDate(fecha);
            return dateFEchaTrabajo.compareTo(dateFechaCartera) == 0;
        } catch (NullPointerException ex) {
            System.out.println("Error en seCalculoCarteravencida de CarteraVencidaFacade." + ex.getMessage());
            return false;
        }
    }

}
