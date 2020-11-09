/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.ejb.util.ConfigVista;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 *
 * @author prometeo
 */
@Singleton
@LocalBean
public class UtilService {

    public String getValor(String usuario, String ventana, String atributo) {
        ConfigVista config = new ConfigVista();
        return config.getValor(usuario, ventana, atributo);
    }

    public boolean editarValorAtributo(String usuario, String ventana, String atributo, String valor) {
        ConfigVista config = new ConfigVista();
        return config.editarValorAtributo(usuario, ventana, atributo, valor);
    }
}
