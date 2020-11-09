/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.util;

import com.saicoop.modelo.conexion.ConexionJDBC;
import java.sql.Connection;
import java.util.Date;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author prometeo
 */
@LocalBean
@Stateless
public class DatosConexion {

    private String ip;
    private String bd;
    private String idSesion;

    public boolean verificaConexionBD() {
        Connection c = null;
        try {
            ConexionJDBC con = new ConexionJDBC();
            c = con.Conexion(getIp(), getBd(), "");
            if (c == null) {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            try {
                c.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            return false;
        } finally {
            try {
                c.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return true;
    }

    public Date getHora() {
        KitWeb kitweb = new KitWeb();
        return kitweb.getFEchaHora();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public String getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(String idSesion) {
        this.idSesion = idSesion;
    }

}
