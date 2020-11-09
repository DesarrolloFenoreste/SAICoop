/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.util;

import java.io.File;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author gerardo
 */
public class CargarArchivo {

    private String path = null;

    // Forma la ruta del archivo desde el home
    public String formaRuta(String[] arr) {
        String rutaArchivo = getRutaArchivo();
        for (String arr1 : arr) {
            rutaArchivo = rutaArchivo + getSep() + arr1;
        }
        path = rutaArchivo;
        return rutaArchivo;
    }

    public String getRutaArchivo() {
        String rc = System.getProperty("java.class.path");
        String pathhome = System.getProperty("user.home");
        if (rc.contains(pathhome)) {
            return pathhome;
        } else {
            return getSep() + rc.split("/")[1] + getSep() + rc.split("/")[2];
        }
    }

    public String getPath() {
        return path;
    }

    // Verifica si existe un archivo
    public boolean existeArchivo(String[] arr) {
        File fichero = new File(formaRuta(arr));
        return fichero.exists();
    }

    // Crea la carpeta
    public boolean creaCArpeta(String[] arr) {
        File fichero = new File(formaRuta(arr));
        return fichero.mkdir();
    }

    // Carga el xml 
    public Document cargarXml(String[] arr) {
        Document document = null;
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(formaRuta(arr));
        try {
            document = (Document) builder.build(xmlFile);
        } catch (IOException | JDOMException io) {
            System.out.println(io.getMessage());
        }
        return document;
    }

    // Separador dependiendo del sistema operativo
    private static char getSep() {
        return File.separatorChar;
    }
}
