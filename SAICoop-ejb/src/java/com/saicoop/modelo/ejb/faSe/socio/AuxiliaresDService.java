/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.socio;

import com.saicoop.modelo.dto.socio.AuxiliaresDDTO;
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
public class AuxiliaresDService {

    @EJB
    private AuxiliaresDFacade auxiliaresDFacade;

    public List<AuxiliaresDDTO> buscaAuxiliaresdDTOPorIdPoliza(int idorigenc, String periodo, short idtipo, int idpoliza) {
        return auxiliaresDFacade.buscaAuxiliaresdDTOPorNumeroDPoliza(idorigenc, periodo, idtipo, idpoliza);
    }
}
