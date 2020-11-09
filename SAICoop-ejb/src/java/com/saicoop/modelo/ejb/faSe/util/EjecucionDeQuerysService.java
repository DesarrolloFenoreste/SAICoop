/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

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
public class EjecucionDeQuerysService {

    @EJB
    private EjecucionDeQuerysFacade ejecucionDeQuerysFacade;

    public PaqueteDTO ejecutaQuery(String query) {
        return ejecucionDeQuerysFacade.ejecutaQuery(query);
    }

    public PaqueteDTO ejecutaQueries( List<String> query) {
        return ejecucionDeQuerysFacade.ejecutaQueries(query);
    }
}
