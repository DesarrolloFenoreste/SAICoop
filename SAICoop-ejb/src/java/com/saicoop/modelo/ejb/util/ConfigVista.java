/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.util;

import java.io.FileOutputStream;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author prometeo
 */
public class ConfigVista {

    Document documento = null;
    CargarArchivo cargarArchivo;

    private void setConfigs() {
        try {
            cargarArchivo = new CargarArchivo();
            documento = cargarArchivo.cargarXml("SAICoop_Service/recursos/xml/vista.config".split("/"));
        } catch (Exception e) {
            System.out.println("Error en setConfigs de ConfigVista: " + e.getMessage());
        }

    }

    public String getValor(String usuario, String ventana, String atributo) {
        setConfigs();
        for (int i = 0; i < documento.getRootElement().getChildren().size(); i++) {
            if (documento.getRootElement().getChildren().get(i).getAttribute("usuario").getValue().equals(usuario)) {
                if (documento.getRootElement().getChildren().get(i).getAttribute("nombre").getValue().equals(ventana)) {
                    return documento.getRootElement().getChildren().get(i).getAttribute(atributo).getValue();
                }
            }
        }
        return null;
    }

    public boolean editarValorAtributo(String usuario, String ventana, String atributo, String valor) {
        setConfigs();
        try {
            agregaUsuario(usuario, ventana);
            for (int i = 0; i < documento.getRootElement().getChildren().size(); i++) {
                if (documento.getRootElement().getChildren().get(i).getAttribute("usuario").getValue().equals(usuario)) {
                    if (documento.getRootElement().getChildren().get(i).getAttribute("nombre").getValue().equals(ventana)) {
                        documento.getRootElement().getChildren().get(i).getAttribute(atributo).setValue(valor);
                    }
                }
            }
            guardar();
            return true;
        } catch (IOException e) {
            System.out.println("Error en editarValorAtributo de ConfigVista: " + e.getMessage());
            return false;
        }
    }

    private void guardar() throws IOException {
        XMLOutputter xmlOutput = new XMLOutputter();
        // display xml
        xmlOutput.setFormat(Format.getPrettyFormat());
        xmlOutput.output(documento, new FileOutputStream(cargarArchivo.getPath()));
    }

    private void agregaUsuario(String usuario, String ventana) {
        // <ventana nombre="principal" usuario="999" menuArbol="true" menuBarra="true"/>
        try {
            boolean existe = false;
            for (int i = 0; i < documento.getRootElement().getChildren().size(); i++) {
                if (documento.getRootElement().getChildren().get(i).getAttribute("usuario").getValue().equals(usuario)) {
                    existe = true;
                    break;
                }
            }
            if (existe == false) {
                //<ventana nombre="Principal" usuario="999" arbolSAICoop="true" menuSAICoop="true" areaMsjs="true" areaLateral="true" />
                Element elemento = new Element("ventana");
                elemento.setAttribute("nombre", ventana);
                elemento.setAttribute("usuario", usuario);
                elemento.setAttribute("arbolSAICoop", "true");
                elemento.setAttribute("menuSAICoop", "true");
                elemento.setAttribute("areaMsjs", "true");
                elemento.setAttribute("areaLateral", "true");
                documento.getRootElement().addContent(elemento);
                guardar();
            }
        } catch (IOException e) {
            System.out.println("Error en agregaUsuario de ConfigVista: " + e.getMessage());
        }
    }

}
