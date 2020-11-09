/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.conexion.ConexionHTTP;
import com.saicoop.modelo.dto.general.JOrigenDatosDTO;
import com.saicoop.modelo.dto.general.JPersonasBloqueadasDTO;
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
public class MasivosService {

    @EJB
    private ConexionHTTP conexionHTTP;

    public void ActualizaPersonasBloqueadas(int idusuario, List<JPersonasBloqueadasDTO> lBloq, List<JOrigenDatosDTO> loris) {
        conexionHTTP.ActualizaPersonasBloqueadas(idusuario, lBloq, loris);
    }
}
