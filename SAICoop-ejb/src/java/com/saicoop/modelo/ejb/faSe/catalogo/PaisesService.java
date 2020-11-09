/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.catalogo;

import com.saicoop.modelo.dto.catalogo.PaisesDTO;
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
public class PaisesService {

    @EJB
    private PaisesFacade paisesFacade;
    
    public List<PaisesDTO> buscaTodosLosPaises() {
        return paisesFacade.buscaTodosLosPaises();
    }
    
    public PaisesDTO buscaPaisPorEstado(int idestado) {
        return paisesFacade.buscaPaisPorEstado(idestado);
    }

}
