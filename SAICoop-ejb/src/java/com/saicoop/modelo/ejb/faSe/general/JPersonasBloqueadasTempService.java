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
public class JPersonasBloqueadasTempService {

    @EJB
    private JPersonasBloqueadasTempFacade jPersonasBloqueadasTempFacade;

    public PaqueteDTO jPersonasBloqueadasInserta(List<JPersonasBloqueadasDTO> lista, String fecha_hoy_saicoop) {
        return jPersonasBloqueadasTempFacade.jPersonasBloqueadasInserta(lista, fecha_hoy_saicoop);
    }

    public PaqueteDTO eliminaJPersonasBloqueadasPorId(int id_doc) {
        return jPersonasBloqueadasTempFacade.eliminaJPersonasBloqueadasPorId(id_doc);
    }

    public PaqueteDTO eliminaTodoJPersonasBloqueadasTemp() {
        return jPersonasBloqueadasTempFacade.eliminaTodoJPersonasBloqueadasTemp();
    }

}
