/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.general.JOrigenDatosDTO;
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
public class JOrigenDatosService {

    @EJB
    private JOrigenDatosFacade jOrigenDatosFacade;

    public JOrigenDatosDTO buscaJOrigenDatosPorId(int idod) {
        return jOrigenDatosFacade.buscaJOrigenDatosPorId(idod);
    }

    public PaqueteDTO buscaTodasLasJOrigenDatos() {
        return jOrigenDatosFacade.buscaTodasLasJOrigenDatos();
    }

    public PaqueteDTO JOrigenDatosCU(boolean esInserta, Integer idod, String nombre, String descripcion, String url, String tipo, Integer idmenu, String config_lectura, String charset_lectura, String charset_escritura) {
        return jOrigenDatosFacade.JOrigenDatosCU(esInserta, idod, nombre, descripcion, url, tipo, idmenu, config_lectura, charset_lectura, charset_escritura);
    }

    public PaqueteDTO eliminaJOrigenDatosPorId(int idod) {
        return jOrigenDatosFacade.eliminaJOrigenDatosPorId(idod);
    }

}
