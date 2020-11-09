/*
 si personas bloqueadas esta vacia, inserta
 si una persona nueva con el mismo origen ya existe en jpersonasbloqueadas solo actualiza fechas.
 si una persona nueva con el mimso origen no existe en jpersonasbloqueadas inserta
 si una persona en jpersonasbloqueadas del mismo origen no esta entre las personas nuevas manda a historial 
 */
package com.saicoop.modelo.conexion;

import com.saicoop.modelo.dto.general.JPersonasBloqueadasDTO;
import com.saicoop.modelo.dto.general.JOrigenDatosDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import com.saicoop.modelo.ejb.faSe.general.JPersonasBloqueadasService;
import com.saicoop.modelo.ejb.faSe.general.JPersonasBloqueadas_HService;
import com.saicoop.modelo.ejb.faSe.general.JPersonasBloqueadasTempService;
import com.saicoop.modelo.ejb.faSe.util.TablasService;
import com.saicoop.modelo.ejb.impl.SaiFunciones;
import com.saicoop.modelo.ejb.util.KitWeb;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 *
 * @author prometeo
 */
@Stateful
@LocalBean
public class ConexionHTTP {

    @EJB
    private JPersonasBloqueadas_HService jPersonasBloqueadas_HService;

    @EJB
    private JPersonasBloqueadasTempService jPersonasBloqueadasTempService;

    @EJB
    private TablasService tablasService;

    @EJB
    private SaiFunciones saiFunciones;

    @EJB
    private JPersonasBloqueadasService jPersonasBloqueadasService;

    private void limpiaMemoria() {
        System.gc();
        System.runFinalization();
        System.gc();
    }

    /*
    *si la tabla de jpersonasbloqueadas esta vacia, inserta a todas las personas bloqueadas de la lista
    *si una persona nueva con el mismo origen ya existe en jpersonasbloqueadas solo actualiza fechas.
    *si una persona nueva con el mimso origen no existe en jpersonasbloqueadas inserta
    *si una persona en jpersonasbloqueadas del mismo origen no esta entre las personas nuevas manda a historial de personas bloqueadas
    *una persona no se inserta en jpersonasbloqueadas si ya existe en la tabla de historial de personas bloqueadas 
     */
    public void ActualizaPersonasBloqueadas(int idusuario, List<JPersonasBloqueadasDTO> lBloq, List<JOrigenDatosDTO> loris) {
        String f = saiFunciones.saiFechaDBTimeStampString();

        limpiaMemoria();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                jPersonasBloqueadasTempService.eliminaTodoJPersonasBloqueadasTemp();
                //lista de todas las personas bloqueadas
                List<JPersonasBloqueadasDTO> nuevos = obtenerListaNueva(loris);
                //lista de las personas que traen las urls
                //le pongo la fecha actual
                for (int i = 0; i < lBloq.size(); i++) {
                    JPersonasBloqueadasDTO dto = lBloq.get(i);
                    dto.setFecha_alta_saicoop(f);
                    nuevos.add(dto);
                }
                //inserto todas las personas nuevas en temporal
                insertaEnPersonasBloqueadasTemp(nuevos);
                //inserta en historial lo que este en personas bloqueadas que no este en temporal
                PaqueteDTO pjpbh = jPersonasBloqueadas_HService.insertaPBenHistorialSiNoEstaEnTemporal(idusuario);
                //inserta en personas bloqueadas lo que este en temporal y que no este en historial y no este en personas bloqueadas
                PaqueteDTO pjpbs = jPersonasBloqueadasService.insertarPBTempEnPBsiNoEstanEnHistorialYPB();
                //borra las personas de personas bloqueadas que esten en historial 
                PaqueteDTO pjpbb = jPersonasBloqueadasService.borrarPBsiEstanEnHistorial();
                //borra todo lo que este en temporal.
                PaqueteDTO pjpbt = jPersonasBloqueadasTempService.eliminaTodoJPersonasBloqueadasTemp();
                tablasService.actualizaTabla("", "0", "", "", "", "", 0, "actualiza_personas_bloqueadas", "tiempo_espera");
            }
        });
        t.start();
    }

    private void insertaEnPersonasBloqueadasTemp(List<JPersonasBloqueadasDTO> nuevos) {
        String f = saiFunciones.saiFechaDBTimeStampString();
        jPersonasBloqueadasTempService.jPersonasBloqueadasInserta(nuevos, f);
    }

    KitWeb kw = new KitWeb();

    //3682,LPI130502F13,"LEX PUBLICIDAD INTEGRAL, S.A. DE C.V.","jfkgjflgjfkljgklj",Definitivos,500-05-2016-6283 de fecha 29 de febrero de 2016,
    private String[] parte(String linea) {
        String[] arr = linea.split(",");
        List<String> l = new ArrayList<>(0);
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            if (s.startsWith("\"") && !s.endsWith("\"")) {
                while (!arr[i].contains("\"")) {
                    s = s + "," + arr[i];
                    if (i < arr.length) {
                        i = i + 1;
                    }
                }
                /*do {
                    i = i + 1;
                    s = s + "," + arr[i];
                } while (!arr[i].endsWith("\""));*/
            }
            l.add(s);
        }
        return listaAarray(l);
    }

    private String[] listaAarray(List<String> lista) {
        String[] arr = new String[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            arr[i] = lista.get(i);
        }
        return arr;
    }

    private List<JPersonasBloqueadasDTO> obtenerListaNueva(List<JOrigenDatosDTO> loris) {
        String f = saiFunciones.saiFechaDBTimeStampString();
        //creo una lista de personas bloqueadas
        List<JPersonasBloqueadasDTO> lPerBloqs = new ArrayList<>(0);
        //si la lista no esta vacia continua
        if (!loris.isEmpty()) {
            //exploro todos los origenes
            for (int i = 0; i < loris.size(); i++) {
                //obtengo la configuracion  para leer lo que descargue
                String config = loris.get(i).getConfig_lectura();
                String encoEsc = loris.get(i).getCharset_escritura();
                //comienzo a partir las configuraciones
                String[] cgnes = config.split("\\|");
                //obtengo la configuracion de donde iniciara la busqueda de datos como columnas
                int inicio = Integer.parseInt(cgnes[0].split("=")[1]);
                //obtengo configuracion de datos que sacare en columnas
                String[] columnas = cgnes[1].split(">")[1].split("&");
                String[] celdas = null;
                if (cgnes.length > 2) {
                    //obtengo configuracion de datos que sacare como celdas
                    celdas = cgnes[2].split(">")[1].split("&");
                }
                //descargo datos de la url
                DescargaURL durl = new DescargaURL();
                /*se lee lo descargado y lo retorno en forma de una lista con las lineas de texto*/
                List<String> filasDoc = durl.descargaDatosDeURL(loris.get(i).getUrl(), loris.get(i).getCharset_lectura());
                //creo una lista de arreglos de strings
                List<String[]> larr = new ArrayList<>();
                //cada linea de texto en filasDoc se parte en arreglos y cada arreglo se guarda en la lista
                for (int j = 0; j < filasDoc.size(); j++) {
                    larr.add(parte(filasDoc.get(j)));
                }
                //exploramos el la lista de arreglos
                for (int j = inicio; j < larr.size(); j++) {
                    //obtengo el arreglo
                    String[] arr = larr.get(j);
                    if (arr.length > 3) {
                        JPersonasBloqueadasDTO dto = new JPersonasBloqueadasDTO();
                        dto.setId_doc(" ");
                        dto.setNombre(" ");
                        dto.setRfc(" ");
                        dto.setCurp(" ");
                        dto.setIdod(loris.get(i).getIdod());
                        dto.setFecha(" ");
                        dto.setFecha_alta_saicoop(" ");
                        dto.setDato1(" ");
                        dto.setDato2(" ");
                        dto.setDato3(" ");
                        //exploro al arreglo 
                        for (int k = 0; k < arr.length; k++) {
                            String val = new String(arr[k].replace("  ", " ").replace("\"", "").getBytes(), Charset.forName(encoEsc));
                            for (int l = 0; l < columnas.length; l++) {
                                String nombreCol = columnas[l].split("=")[0];
                                int numCol = Integer.parseInt(columnas[l].trim().split("=")[1]);
                                if (k == numCol) {
                                    switch (nombreCol) {
                                        case "id_doc":
                                            dto.setId_doc(val);
                                            break;
                                        case "nombre":
                                            dto.setNombre(val);
                                            break;
                                        case "rfc":
                                            dto.setRfc(val);
                                            break;
                                        case "curp":
                                            dto.setCurp(val);
                                            break;
                                        case "fecha":
                                            dto.setFecha(val);
                                            break;
                                        case "dato1":
                                            dto.setDato1(val);
                                            break;
                                        case "dato2":
                                            dto.setDato2(val);
                                            break;
                                        case "dato3":
                                            dto.setDato3(val);
                                            break;
                                        default:
                                            break;
                                    }
                                }
                            }
                        }
                        dto.setFecha_alta_saicoop(f);
                        lPerBloqs.add(dto);
                    }
                }
                if (celdas != null) {
                    lPerBloqs = cargaDatosDeCeldas(lPerBloqs, larr, celdas);
                }

            }
        }
        return lPerBloqs;
    }

    //inicia=3|columna>id_doc=0&nombre=2&rfc=1|celda>fecha=0,0
    private List<JPersonasBloqueadasDTO> cargaDatosDeCeldas(List<JPersonasBloqueadasDTO> ldtos, List<String[]> filas, String[] celdas) {
        String f = saiFunciones.saiFechaDBTimeStampString();
        for (int k = 0; k < celdas.length; k++) {
            String nombreVar = celdas[k].split("=")[0];
            int rowCel = Integer.parseInt(celdas[k].split("=")[1].split(",")[0]);
            int colCel = Integer.parseInt(celdas[k].split("=")[1].split(",")[1]);
            String val = filas.get(rowCel)[colCel];
            for (int i = 0; i < ldtos.size(); i++) {
                JPersonasBloqueadasDTO dto = ldtos.get(i);
                switch (nombreVar) {
                    case "id_doc":
                        dto.setId_doc(val);
                        break;
                    case "nombre":
                        dto.setNombre(val);
                        break;
                    case "rfc":
                        dto.setRfc(val);
                        break;
                    case "curp":
                        dto.setCurp(val);
                        break;
                    case "idod":
                        dto.setIdod(Integer.parseInt(val));
                        break;
                    case "fecha":
                        dto.setFecha(val);
                        break;
                    case "dato1":
                        dto.setDato1(val);
                        break;
                    case "dato2":
                        dto.setDato2(val);
                        break;
                    case "dato3":
                        dto.setDato3(val);
                        break;
                    default:
                        break;
                }
                dto.setFecha_alta_saicoop(f);
            }
        }
        return ldtos;
    }

}
