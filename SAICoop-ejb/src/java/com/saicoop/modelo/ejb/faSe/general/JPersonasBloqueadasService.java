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
public class JPersonasBloqueadasService {

    @EJB
    private JPersonasBloqueadasFacade personasBloqueadasFacade;

    public PaqueteDTO borrarPBsiEstanEnHistorial() {
        return personasBloqueadasFacade.borrarPBsiEstanEnHistorial();
    }

    public PaqueteDTO insertarPBTempEnPBsiNoEstanEnHistorialYPB() {
        return personasBloqueadasFacade.insertarPBTempEnPBsiNoEstanEnHistorialYPB();
    }

    public JPersonasBloqueadasDTO buscaJPersonasBloqueadasPorIds(String id_doc, int idod, String fecha) {
        return personasBloqueadasFacade.buscaJPersonasBloqueadasPorIds(id_doc, idod, fecha);
    }

    public PaqueteDTO buscaTodasLasJPersonasBloqueadas() {
        return personasBloqueadasFacade.buscaTodasLasJPersonasBloqueadas();
    }

    public PaqueteDTO jPersonasBloqueadasInserta(List<JPersonasBloqueadasDTO> lista) {
        return personasBloqueadasFacade.jPersonasBloqueadasInserta(lista);
    }

    public PaqueteDTO eliminaJPersonasBloqueadasPorIds(String id_doc, int idod, String fecha) {
        return personasBloqueadasFacade.eliminaJPersonasBloqueadasPorIds(id_doc, idod, fecha);
    }

    public PaqueteDTO buscaFechasDeJPersonasBloqueadasPorIdOD(Integer idod) {
        return personasBloqueadasFacade.buscaFechasDeJPersonasBloqueadasPorIdOD(idod);
    }

    public PaqueteDTO buscaJPersonasBloqueadasPorIdODFecha(Integer idod, String fecha) {
        return personasBloqueadasFacade.buscaJPersonasBloqueadasPorIdODFecha(idod, fecha);
    }

    public List<JPersonasBloqueadasDTO> buscaJPersonasBloqueadasPorIDDoc(String id_doc) {
        return personasBloqueadasFacade.buscaJPersonasBloqueadasPorIDDoc(id_doc);
    }
}
