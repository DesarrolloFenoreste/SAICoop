/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.dto.util.PaqueteDTO;
import com.saicoop.modelo.dto.util.QperfilesDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author prometeo
 */
@Stateless
@LocalBean
public class QperfilesService {
    
    @EJB
    private QperfilesFacade qperfilesFacade;
    
    public List<QperfilesDTO> buscaQperfilesDTOPorIdQuery(int idquery) {
        return qperfilesFacade.buscaQperfilesDTOPorIdQuery(idquery);
    }
    
    public List<QperfilesDTO> buscaQperfilesDTOPorIdugrupo(int idugrupo) {
        return qperfilesFacade.buscaQperfilesDTOPorIdugrupo(idugrupo);
    }
    
    public QperfilesDTO buscaQperfilesDTOPorIdQueryYIdugrupo(int idquery, int idugrupo) {
        return qperfilesFacade.buscaQperfilesDTOPorIdQueryYIdugrupo(idquery, idugrupo);
    }
    
    public PaqueteDTO qPerfilesCR(boolean esInserta, int idquery, int idugrupo) {
        return qperfilesFacade.qPerfilesCR(esInserta, idquery, idugrupo);
    }
    
    public PaqueteDTO eliminaQPerfiles(int idquery) {
        return qperfilesFacade.eliminaQPerfiles(idquery);
    }
}
