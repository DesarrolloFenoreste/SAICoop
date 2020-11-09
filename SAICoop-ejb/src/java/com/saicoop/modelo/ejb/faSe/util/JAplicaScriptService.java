/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.dto.util.JAplicaScriptDTO;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author prometeo
 */
@Stateless
@LocalBean
public class JAplicaScriptService {

    @EJB
    private JAplicaScriptFacade jAplicaScriptFacade;

    public JAplicaScriptDTO getJAplicaScriptPorId(String idscript) {
        return jAplicaScriptFacade.getJAplicaScriptPorId(idscript);
    }

    public int insertaJAplicaScript(String idscript, int idusuario, String autor, String script, String comentario) {
        return jAplicaScriptFacade.insertaJAplicaScript(idscript, idusuario, autor, script, comentario);
    }
}
