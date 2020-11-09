/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author prometeo
 */
public class KitWeb {

    // --- FORMATO PARA FECHA Y HORA -------------------------------------------
    public SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    public SimpleDateFormat formatterFechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SS");//dd/MM/yyyy HH:mm:ss
    public SimpleDateFormat formatoSqlDate = new SimpleDateFormat("yyyy-MM-dd");
    public SimpleDateFormat formatoTimeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    // -------------------------------------------------------------------------
    //public DateFormat formatoDate = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
    // -------------------------------------------------------------------------

    public int cuantas(String s, char c) {
        int n = 0;
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == c) {
                n = n + 1;
            }
        }
        return n;
    }

    public String cambiaFilaColumnas(String fila, int n) {
        boolean b = true;
        char[] arr = fila.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ' && arr[i] != '=' && arr[i] != '-') {
                b = false;
                break;
            }
        }
        if (b == true) {
            fila = "";
            for (int i = 0; i < n; i++) {
                fila = fila + "-------     ";
            }
        }
        return fila.trim();
    }

    public List<String> parteFila(String fila) {
        List<String> lista = new ArrayList<>(0);
        char[] c = fila.toCharArray();
        String ca = "";
        for (int i = 0; i < c.length; i++) {
            if (Character.isWhitespace(c[i])) {
                if (!ca.isEmpty() && Character.isWhitespace(c[i - 1])) {
                    lista.add(new String(ca.trim()));
                    ca = "";
                }
            } else {
                if (i >= 1 && Character.isWhitespace(c[i - 1])) {
                    ca = ca + ' ';
                }
                ca = ca + c[i];
                if (i == c.length - 1) {
                    lista.add(new String(ca.trim()));
                    ca = "";
                }
            }
        }
        return lista;
    }

    public boolean filaValida(String fila) {
        char[] arr = fila.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '=' && arr[i] != ' ' && arr[i] != '-' && arr[i] != '_') {
                return true;
            }
        }
        return false;
    }

    public Date getDateDeTimestamp(String fecha) {
        try {
            Date d = formatoTimeStamp.parse(fecha);
            return d;
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public Date getDateDeSqlDate(String fecha) {
        try {
            Date d = formatoSqlDate.parse(fecha);
            return d;
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public String formatoFecha(XMLGregorianCalendar fecha) {
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = fecha.toGregorianCalendar().getTime();
        return sf.format(date);
    }

    public String formatoFecha(Date fecha) {
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
        return sf.format(fecha);
    }

    public String formatoFechaHora(Date fecha) {
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SS");
        return sf.format(fecha);
    }

    public String esteFormatoFecha(Date fecha, String formato) {
        SimpleDateFormat sf = new SimpleDateFormat(formato);
        return sf.format(fecha);
    }

    public String getHora() {
        SimpleDateFormat sf = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return sf.format(date.getTime());
    }

    public Date getFEchaHora() {
        try {
            SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            return sf.parse(new Date().toString());
        } catch (ParseException ex) {

        }
        return null;
    }

    public XMLGregorianCalendar toXMLGregorianCalendar(Date date) {
        GregorianCalendar gCalendar = new GregorianCalendar();
        gCalendar.setTime(date);
        XMLGregorianCalendar xmlCalendar = null;
        try {
            xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
        } catch (DatatypeConfigurationException ex) {
            System.out.println("Error al transformar tipo Date a XmlGregorianCalendar: " + ex);
        }
        return xmlCalendar;
    }

    public Date toDate(XMLGregorianCalendar calendar) {
        if (calendar == null) {
            return null;
        }
        return calendar.toGregorianCalendar().getTime();
    }

    public String escapaCaracteresXmlNoValidos(Object in) {
        StringBuilder out = new StringBuilder();
        char current;
        if (in == null || ("".equals(in)) || in.toString().equals("|") || in.toString().equals("\\|")) {
            return "";
        }
        for (int i = 0; i < in.toString().length(); i++) {
            current = in.toString().charAt(i);
            if ((current == 0x9)
                    || (current == 0xA)
                    || (current == 0xD)
                    || ((current >= 0x20) && (current <= 0xD7FF))
                    || ((current >= 0xE000) && (current <= 0xFFFD))
                    || ((current >= 0x10000) && (current <= 0x10FFFF))) {
                out.append(current);
            }
        }
        return out.toString();
    }

    public byte[] read(File file) throws IOException {
        /*if (file.length() > MAX_FILE_SIZE) {
         throw new FileTooBigException(file);
         }*/
        ByteArrayOutputStream ous = null;
        InputStream ios = null;
        try {
            byte[] buffer = new byte[2048];
            ous = new ByteArrayOutputStream();
            ios = new FileInputStream(file);
            int read = 0;
            while ((read = ios.read(buffer)) != -1) {
                ous.write(buffer, 0, read);
            }
        } finally {
            try {
                if (ous != null) {
                    ous.close();
                }
            } catch (IOException e) {
            }
            try {
                if (ios != null) {
                    ios.close();
                }
            } catch (IOException e) {
            }
        }
        return ous.toByteArray();
    }

    // a este metodo le pasas los tres valores del opa y te retorna el opa en 
    // su formato de 32 caracteres 
    public String getOPA32(int idorigenp, int idproducto, int idauxiliar) {
        return "0000000000000" // son 13 para completar los 32 digitos
                + String.format("%06d", idorigenp) // idorigenp
                + String.format("%05d", idproducto) // idproducto
                + String.format("%08d", idauxiliar); //idauxiliar 
    }

    public int[] getOPA(String OPA32) {
        int[] opa = new int[3];
        opa[0] = Integer.parseInt(OPA32.substring(0, 19));
        opa[1] = Integer.parseInt(OPA32.substring(19, 24));
        opa[2] = Integer.parseInt(OPA32.substring(24, 32));
        return opa;
    }

    public String getOGS32(int idorigen, int idgrupo, int idsocio) {
        return "000000000000000000" // son 18 para completar los 32 digitos
                + String.format("%06d", idorigen) // idorigen
                + String.format("%02d", idgrupo) // idgrupo
                + String.format("%06d", idsocio); // idsocio
    }

    // a este metodo le pasas como parametro tu cadena de 32 caracteres que 
    // representa tu ogs y te retorna tu ogs en un arreglo de enteros
    public int[] getOGS(String OGS32) {
        int[] ogs = new int[3];
        ogs[0] = Integer.parseInt(OGS32.substring(0, 24)); //idorigen
        ogs[1] = Integer.parseInt(OGS32.substring(24, 26)); //idgrupo
        ogs[2] = Integer.parseInt(OGS32.substring(26, 32)); //idsocio
        return ogs;
    }

    public Date stringToFechayyyyMMdd(String fs) {
        Date fecha = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fecha = sdf.parse(fs);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return fecha;
    }

    public String formatoFecha(XMLGregorianCalendar fecha, String formato) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formato);
        Date date = fecha.toGregorianCalendar().getTime();
        return simpleDateFormat.format(date);
    }

    public String formatoFecha(Date fecha, String formato) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formato);
        return simpleDateFormat.format(fecha);
    }

    public XMLGregorianCalendar aXMLGregorianCalendar(Date date) {
        GregorianCalendar gCalendar = new GregorianCalendar();
        gCalendar.setTime(date);
        XMLGregorianCalendar xmlCalendar = null;
        try {
            xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
        } catch (DatatypeConfigurationException ex) {
            System.out.println("Error al transformar tipo Date a XmlGregorianCalendar: " + ex);
        }
        return xmlCalendar;
    }

    public String getFechaActual(String fe) {
        Date ahora = new Date();
        String salida;
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        String[] f = formateador.format(ahora).split("-");
        switch (fe) {
            case "dmy":
                salida = f[0] + f[1] + f[2].substring(2, 4);
                break;
            case "dmyyyy":
                salida = formateador.format(ahora);
                break;
            default:
                salida = f[2] + f[1];
                break;
        }
        return salida;
    }

    public Date aDate(XMLGregorianCalendar calendar) {
        if (calendar == null) {
            return null;
        }
        return calendar.toGregorianCalendar().getTime();
    }

    public int[] getIntsDeStrings(String[] c) {
        int[] ints = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            ints[i] = Integer.parseInt(c[i]);
        }
        return ints;
    }

    public Date getFechaDeString(String s) {
        int[] as = getIntsDeStrings(s.split(":"));
        return getFechaForma(as[0], as[1], as[2], as[3], as[4], as[5]);
    }

    public Date getFechaForma(int anio, int mes, int dia, int hora, int min, int seg) {
        GregorianCalendar c = new GregorianCalendar(anio, mes, dia, hora, min, seg);
        return c.getTime();
    }

    public List<String> ArrayALista(String ar) {
        String[] n = ((ar.replace("{", "")).replace("}", "")).split(",");
        List<String> l = new ArrayList<>(0);
        for (int i = 0; i < n.length; i++) {
            l.add(n[i]);
        }
        return l;
    }

    public List<Integer> listStringToInteger(List<String> ls) {
        List<Integer> l = new ArrayList<>(0);
        for (int i = 0; i < ls.size(); i++) {
            l.add(Integer.parseInt(ls.get(i)));
        }
        return l;
    }

    // Convierte de String a Timestamp
    public Timestamp convertStringToTimestamp(String stringDate) {
        try {
            Date date = (Date) formatterFechaHora.parse(stringDate);
            java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());
            return timeStampDate;
        } catch (ParseException e) {
            System.out.println("Error en convertStringToTimestamp de KitWeb:" + e.getMessage());
            return null;
        }
    }

}
