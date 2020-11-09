/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.dto.general.JPersonasBloqueadasDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
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
public class JPersonasBloqueadas_HService {

    @EJB
    private JPersonasBloqueadas_HFacade jPersonasBloqueadas_HFacade;

    public PaqueteDTO insertaPBenHistorialSiNoEstaEnTemporal(int idusuario) {

        return jPersonasBloqueadas_HFacade.insertaPBenHistorialSiNoEstaEnTemporal(idusuario);
    }

    public PaqueteDTO JPersonasBloqueadasHInserta(List<JPersonasBloqueadasDTO> lista, int usuario_baja) {
        return jPersonasBloqueadas_HFacade.JPersonasBloqueadasHInserta(lista, usuario_baja);
    }

    public JPersonasBloqueadasDTO buscaJPersonasBloqueadasHPorIds(String id_doc, int idod, String fecha) {
        return jPersonasBloqueadas_HFacade.buscaJPersonasBloqueadasHPorIds(id_doc, idod, fecha);
    }

    public PaqueteDTO buscaTodasLasJPersonasBloqueadasH() {
        return jPersonasBloqueadas_HFacade.buscaTodasLasJPersonasBloqueadasH();
    }

    public PaqueteDTO insertarJPersonasBloqueadasH(String id_doc, String nombre, String rfc, String curp, Integer idod, String fecha, String fecha_alta_saicoop, String dato1, String dato2, String dato3, int usuario_baja) {
        return jPersonasBloqueadas_HFacade.insertarJPersonasBloqueadasH(id_doc, nombre, rfc, curp, idod, fecha, fecha_alta_saicoop, dato1, dato2, dato3, usuario_baja);
    }

    public PaqueteDTO eliminaJPersonasBloqueadasHPorId(int id) {
        return jPersonasBloqueadas_HFacade.eliminaJPersonasBloqueadasHPorId(id);
    }
  
}
