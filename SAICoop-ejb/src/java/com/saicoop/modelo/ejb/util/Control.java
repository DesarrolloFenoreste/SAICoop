/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.util;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author prometeo
 */
public class Control {

    public List<String[]> buscaDirectorio(String path) {
        
        boolean b = true;
        boolean v = true;
        
        List<String[]> lista = new ArrayList<>(0);// esta es la lista donde se iran guardando los datos de las carpetas y archivos

        while (b == true) {//se ejecutara el bucle siempre que b sea igual a true 
            b = false;
            /*pongo la variable b como false, mas adelante checo si existe una carpeta 
             sin explorar y si existe, regreso la variable b como true para que continue
             repitiendose*/

            if (lista.size() > 0) { //si y hay elementos en la lista
                for (String[] lista1 : lista) {
                    //explora la lista
                    if (lista1.length == 7 && lista1[5].equals("no")) {
                        //si en la lista hay una carpeta sin explorar
                        path = lista1[1]; //pongo la direccion de la carpeta en la variable path
                        lista1[5] = "si"; //cambio el estado de la carpeta a si explorada
                        break;//salgo de este bucle for
                    } else {
                        //si no entonces path es nulo
                        path = null;
                    }
                }
            }

            if (path != null) {//si path es diferente a nulo
                File base = new File(path);//genero un objeto tipo file apartir del path
                if (base.exists()) {//si existe el objeto file
                    if (base.isDirectory()) {//si es directorio el objeto file

                        /*si la lista ya tiene elementos explorala y si ya 
                         existe la carpeta base, entonces v=false*/
                        if (lista.size() > 0) {
                            for (String[] lista1 : lista) {
                                if (lista1[1].equals(base.getPath())) {
                                    v = false;
                                }
                            }
                        }
                        /*si no existe entonces saco la fecha y registro la 
                         carpeta en la lista*/
                        if (v == true) {

                            Date db = new Date(base.lastModified());/*creo una variable tipo date y 
                             le asigno la fecha de modificado de la carpeta*/

                            Calendar cb = new GregorianCalendar();//creo una variable tipo Calendar

                            cb.setTime(db);//le paso a la variable Calendar la variable date
                            lista.add(new String[]{base.getName(), base.getPath(), Long.toString(cb.getTimeInMillis()), Long.toString(base.length()), "carpeta", "si", System.getProperty("user.home") + "/SAICoop_Service"});
                        }

                        File[] cont = base.listFiles();/*saco todos los files(carpetas y archivos) 
                         y los asigno a un arreglo de files*/

                        if (cont.length > 0) {//si el arreglo de files tiene elementos 
                            v = true;
                            for (File cont1 : cont) {
                                //explora el arreglo
                                if (lista.size() > 0) {
                                    for (String[] lista1 : lista) {
                                        if (lista1[1].equals(cont1.getPath())) {
                                            v = false;
                                        }
                                    }
                                }

                                if (v == true) {
                                    //si todabia no existe en la lista agregalo
                                    Date d = new Date(cont1.lastModified());
                                    /*creo una variable tipo date y
                                     le asigno la fecha de modificado del elementodel arreglo*/

                                    Calendar c = new GregorianCalendar();//creo una variable tipo Calendar
                                    c.setTime(d);//le paso a la variable Calendar la variable date
                                    /*si el elemento del arreglo es directorio,
                                     guardalo en la lista como carpeta y si es file
                                     entonces como archivo*/
                                    /*nombre, path, tamaño, tipo. y si es carpeta entonces su estado como no explorada*/
                                    if (cont1.isDirectory()) {
                                        lista.add(new String[]{cont1.getName(), cont1.getPath(), Long.toString(c.getTimeInMillis()), Long.toString(cont1.length()), "carpeta", "no", System.getProperty("user.home") + "/SAICoop_Service"});
                                    } else if (cont1.isFile()) {
                                        // HACER EL METODO AQUI - GERA
                                        if (!"saicoop.config".equals(cont1.getName()) && !"valida.config".equals(cont1.getName()) && !"listaNegra.config".equals(cont1.getName())) {// && !"Lanzador.jar".equals(cont1.getName())) {
                                            lista.add(new String[]{cont1.getName(), cont1.getPath(), Long.toString(c.getTimeInMillis()), Long.toString(cont1.length()), "archivo"});
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            //si todabia existe alguna carpeta sin explorar se repite el bucle
            for (String[] lista1 : lista) {
                if (lista1.length == 7 && lista1[5].equals("no")) {
                    b = true;
                }
            }
        }
        return lista;
    }

    public byte[] getFile(String path) {
        System.gc();
        try {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[Integer.parseInt(Long.toString(file.length()))];
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return new byte[0];
    }

    public byte[] arregloAFichero(byte[][] arr, String nomFile) {
        creaFichero(arr, nomFile);
        return getFile(nomFile);
    }

    public void creaFichero(byte[][] arr, String nomFile) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(nomFile);
            pw = new PrintWriter(fichero);

            for (int i = 0; i < arr.length; i++) {
                pw.println(new String(arr[i]));
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                System.out.println(e2);
            }
        }
    }

    static final String alfaNumerico = "9876543210ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static final String numerico = "9876543210";
    static final String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    public int randomInt(int len) {
        return Integer.parseInt(randomString(len, 0));
    }

    public String randomAlfabetico(int len) {
        return randomString(len, 1);
    }

    public String randomAlfanumerico(int len) {
        return randomString(len, 2);
    }

    private String randomString(int len, int n) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            if (n == 0) {
                sb.append(numerico.charAt(rnd.nextInt(numerico.length())));
            } else if (n == 1) {
                sb.append(abc.charAt(rnd.nextInt(abc.length())));
            } else {
                sb.append(alfaNumerico.charAt(rnd.nextInt(alfaNumerico.length())));
            }
        }
        return sb.toString();
    }

    public void enviaPorSocket(String host, int puerto, byte[] bytes) {
        try {
            Socket socket = new Socket(host, puerto);
            DataOutputStream mensaje = new DataOutputStream(socket.getOutputStream());
            mensaje.writeInt(bytes.length);
            mensaje.write(bytes);
            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
