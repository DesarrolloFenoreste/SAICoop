/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.dto.util.OrigenesDTO;
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
public class OrigenesService {

    @EJB
    private OrigenesFacade origenesFacade;

    public OrigenesDTO buscaOrigenes(int idorigen) {
        return origenesFacade.buscaOrigenes(idorigen);
    }

    public List<OrigenesDTO> buscaTodosLosOrigenes() {
        return origenesFacade.buscaTodosLosOrigenes();
    }

}
