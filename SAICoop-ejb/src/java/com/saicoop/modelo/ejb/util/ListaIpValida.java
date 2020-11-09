/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;

/**
 *
 * @author gerardo
 */
public class ListaIpValida {

    CargarArchivo cargarxml = new CargarArchivo();
    Document doc;
    String[] path = {"SAICoop_Service", "recursos/xml", "valida.config"};

    private ArrayList listaIP() {
        ArrayList validarCliente = new ArrayList(0);
        // Comprubea que exista el archivo
        if (cargarxml.existeArchivo(path)) {
            try {
                doc = cargarxml.cargarXml(path);
                //Se obtiene la raiz 'tables'
                Element rootNode = doc.getRootElement();
                //Se obtiene la lista de hijos de la raiz 'tables'
                List list = rootNode.getChildren("valido");
                //Se recorre la lista de hijos de 'tables'
                for (Object list1 : list) {
                    //Se obtiene el elemento 'tabla'
                    Element tabla = (Element) list1;
                    //Se obtiene la lista de hijos del tag 'tabla'
                    List lista_campos = tabla.getChildren();
                    // Inicia en el registro 0
                    int i = 0;
                    //Se recorre la lista de campos
                    for (Object lista_campo : lista_campos) {
                        validarCliente.add(new ArrayList(0));
                        //Se obtiene el elemento 'campo'
                        Element campo = (Element) lista_campo;
                        // Agrega los datos al arreglo
                        ((ArrayList) validarCliente.get(i)).add(campo.getAttributeValue("usuario"));
                        ((ArrayList) validarCliente.get(i)).add(campo.getAttributeValue("ip"));
                        ((ArrayList) validarCliente.get(i)).add(campo.getAttributeValue("mac"));
                        // Aumenta en 1 los registros
                        i++;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error al obtener usuarios validos: " + e);
            }
        } else {
            System.out.println("No existe el archivo valida.config: " + Arrays.toString(path) + "    " + cargarxml.formaRuta(path));
        }
        return validarCliente;
    }

    private String[] corrige(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                arr[i] = "nulo";
            } else {
                arr[i] = arr[i].toLowerCase().trim();
                if (arr[i].contains("-")) {
                    arr[i] = arr[i].replace("-", ":");
                }
            }
        }
        return arr;
    }

    // Obtiene los datos del cliente: ip, mac, usuario
    public boolean validaIP(String Usuario, String ip, String mac) {
        boolean valido = false;
        for (Object listaIP : listaIP()) {
            String validaUsuario = (String) ((ArrayList) listaIP).get(0);
            String[] usus = corrige(new String[]{validaUsuario, Usuario});
            if (usus[0].equals(usus[1])) {
                String validaIp = (String) ((ArrayList) listaIP).get(1);
                String validaMac = (String) ((ArrayList) listaIP).get(2);
                String[] dats = corrige(new String[]{validaIp, ip, mac, validaMac});
                if (dats[0].equals(dats[1]) || dats[2].equals(dats[3])) {
                    valido = true;
                }
            }
        }
        return valido;
    }

}
