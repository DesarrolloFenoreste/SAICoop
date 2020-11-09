/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.util;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author prometeo
 */
@Stateless
@LocalBean
public class Intermediario {

    Control c = new Control();

    public List<String[]> traeLista() {
        return c.buscaDirectorio(System.getProperty("user.home") + "/SAICoop_Service");
    }

    public byte[] getFile(String path) {
        return c.getFile(path);
    }
}
