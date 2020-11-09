/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.webService;

import com.saicoop.modelo.ejb.util.DatosConexion;
import com.saicoop.modelo.ejb.util.Intermediario;
import com.saicoop.modelo.ejb.util.ListaIpValida;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author gerardo
 */
@WebService(serviceName = "Descarga")
@Stateless()
public class Descarga {

    @EJB
    private DatosConexion datosConexion;

    @EJB
    private Intermediario intermediario;

    @Resource
    private WebServiceContext webServiceContext;

    /**
     *
     * @return
     */
    //-- VALIDA EL USUARIO Y PASSWORD DE LA CABECERA DEL HTTP ------------------
    private boolean validadorInter() {
        MessageContext messageContext = webServiceContext.getMessageContext();
        Map http_headers = (Map) messageContext.get(MessageContext.HTTP_REQUEST_HEADERS);
        List userList = (List) http_headers.get("USUARIO");
        List passList = (List) http_headers.get("CONTRASENA");
        String username = "";
        String password = "";
        if (userList != null && passList != null) {
            // USUARIO Y CONTRASEÑA
            username = userList.get(0).toString();
            password = passList.get(0).toString();
            //
            List idSesionList = (List) http_headers.get("IDSESION");
            List ipBaseDatosList = (List) http_headers.get("IPBASEDATOS");
            List baseDatosList = (List) http_headers.get("BASEDATOS");
            if (ipBaseDatosList != null && baseDatosList != null && idSesionList != null) {
                datosConexion.setIp(ipBaseDatosList.get(0).toString());
                datosConexion.setBd(baseDatosList.get(0).toString());
                datosConexion.setIdSesion(idSesionList.get(0).toString());
            }
        }
        return username.equals("usuario") && password.equals("contrasena");
    }

    /**
     *
     * @param usuario
     * @param ip
     * @param mac
     * @return
     */
    @WebMethod(operationName = "validaIp", action = "validaIp")
    public boolean validaIP(@WebParam(name = "usuario") String usuario,
            @WebParam(name = "ip") String ip,
            @WebParam(name = "mac") String mac) {
        if (validadorInter()) {
            System.out.println("Lllego al web service");
            return new ListaIpValida().validaIP(usuario, ip, mac);
        } else {
            return false;
        }
    }

    /**
     *
     * @return
     */
    @WebMethod(operationName = "traeLista", action = "traeLista")
    public List<String[]> traeLista() {
        if (validadorInter()) {
            return intermediario.traeLista();
        } else {
            return null;
        }
    }

    /**
     *
     * @param path
     * @return
     */
    @WebMethod(operationName = "getFile", action = "getFile")
    public byte[] getFile(@WebParam(name = "path") String path) {
        if (validadorInter()) {
            return intermediario.getFile(path);
        } else {
            return new byte[0];
        }
    }

    /**
     *
     * @return
     */
    @WebMethod(operationName = "validador", action = "validador")
    public boolean validador() {
        return validadorInter();
    }

}
