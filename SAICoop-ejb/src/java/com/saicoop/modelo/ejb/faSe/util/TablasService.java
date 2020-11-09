/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.dto.util.PaqueteDTO;
import com.saicoop.modelo.dto.util.TablasDTO;
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
public class TablasService {

    @EJB
    private TablasFacade tablasFacade;

    public TablasDTO buscaTabla(String idtabla, String idelemento) {
        return tablasFacade.buscaTabla(idtabla, idelemento);
    }

    public List<TablasDTO> buscaTablasPorIdTabla(String idtabla) {
        return tablasFacade.buscaTablasPorIdTabla(idtabla);
    }

    public PaqueteDTO buscaTodosLosIdtabla() {
        return tablasFacade.buscaTodosLosIdtabla();
    }

    public PaqueteDTO actualizaTabla(String nombre, String dato1, String dato2, String dato3, String dato4, String dato5, int tipo, String idtabla, String idelemento) {
        return tablasFacade.actualizaTabla(nombre, dato1, dato2, dato3, dato4, dato5, tipo, idtabla, idelemento);
    }

    public PaqueteDTO eliminaTabla(String idtabla, String idelemento) {
        return tablasFacade.eliminaTabla(idtabla, idelemento);
    }

    public PaqueteDTO insertaTabla(String idtabla, String idelemento, String nombre, String dato1, String dato2, String dato3, String dato4, String dato5, int tipo) {
        return tablasFacade.insertaTabla(idtabla, idelemento, nombre, dato1, dato2, dato3, dato4, dato5, tipo);
    }
}
