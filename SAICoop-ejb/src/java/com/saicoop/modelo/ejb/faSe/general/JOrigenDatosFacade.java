/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.general.JOrigenDatosDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author prometeo
 */
@Stateless
@LocalBean
public class JOrigenDatosFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    /*
    CREATE TABLE j_origen_datos (
idod                INTEGER NOT NULL,--id del registro
nombre              CHARACTER VARYING NOT NULL, --nombre "DEA Bloqueados, SAT Bloqueados, QeQ acceso, QeQ consultas"
descripcion         TEXT, --descripcion del enlace
url                 TEXT, --enlace
tipo                CHARACTER VARYING NOT NULL,--servicio a consumir "ws", extencion de archivo descargable "csv"
idmenu              INTEGER NOT NULL,
config_lectura      CHARACTER VARYING, --{columnas xlsx:1,2,3,4,5} ; {etiquetas xml: raiz.persona.nombre, raiz.persona.paterno,raiz.fecha} ; {index de separar csv:1,2,3,4,5} 
charset_lectura     CHARACTER VARYING,
charset_escritura   CHARACTER VARYING,
  CONSTRAINT j_origen_datos_pkey PRIMARY KEY (idod),
  CONSTRAINT j_idmenu_fkey FOREIGN KEY (idmenu)
      REFERENCES j_catalogo_menus (idmenu) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
COMMENT ON TABLE j_origen_datos IS 'esta tabla guarda direcciones de internet para descargar archivos o consumir'; 
     
    Integer idod;
    String nombre;
    String descripcion;
    String url;
    String tipo;
    Integer idmenu;
    String config_lectura;
    String charset_lectura;
    String charset_escritura;
     */
    private final static String insertaJURL = "insert into j_origen_datos(idod,nombre,descripcion,url,tipo,idmenu,config_lectura,charset_lectura,charset_escritura)values(?,?,?,?,?,?,?,?,?);";
    private final static String eliminaJURL = "delete from j_origen_datos where idod=?";
    private final static String actualizaJURL = "update j_origen_datos set nombre=?,descripcion=?,url=?,tipo=?, idmenu=?,config_lectura=?,charset_lectura=?,charset_escritura=? where idod=?;";
    private final static String buscaTodasURLs = "select *from j_origen_datos order by idod;";
    private final static String buscaURLPorID = "select *from j_origen_datos where idod=?;";

    public JOrigenDatosDTO buscaJOrigenDatosPorId(int idod) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idod));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(JOrigenDatosDTO.class, listParametrosDTO, buscaURLPorID);
        return (JOrigenDatosDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

    public PaqueteDTO buscaTodasLasJOrigenDatos() {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(JOrigenDatosDTO.class, listParametrosDTO, buscaTodasURLs);

        return paqueteDTO;
    }

    public PaqueteDTO JOrigenDatosCU(boolean esInserta, Integer idod, String nombre, String descripcion, String url, String tipo, Integer idmenu, String config_lectura, String charset_lectura, String charset_escritura) {
        PaqueteDTO afecto = null;
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            if (esInserta == true) {
                listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", idod));
                listParametrosDTOreg.add(new ParametrosDTO(2, "String", nombre));
                listParametrosDTOreg.add(new ParametrosDTO(3, "String", descripcion));
                listParametrosDTOreg.add(new ParametrosDTO(4, "String", url));
                listParametrosDTOreg.add(new ParametrosDTO(5, "String", tipo));
                listParametrosDTOreg.add(new ParametrosDTO(6, "Integer", idmenu));
                listParametrosDTOreg.add(new ParametrosDTO(7, "String", config_lectura));
                listParametrosDTOreg.add(new ParametrosDTO(8, "String", charset_lectura));
                listParametrosDTOreg.add(new ParametrosDTO(9, "String", charset_escritura));
                querys.add(insertaJURL);
            } else {
                listParametrosDTOreg.add(new ParametrosDTO(1, "String", nombre));
                listParametrosDTOreg.add(new ParametrosDTO(2, "String", descripcion));
                listParametrosDTOreg.add(new ParametrosDTO(3, "String", url));
                listParametrosDTOreg.add(new ParametrosDTO(4, "String", tipo));
                listParametrosDTOreg.add(new ParametrosDTO(5, "Integer", idmenu));
                listParametrosDTOreg.add(new ParametrosDTO(6, "String", config_lectura));
                listParametrosDTOreg.add(new ParametrosDTO(7, "String", charset_lectura));
                listParametrosDTOreg.add(new ParametrosDTO(8, "String", charset_escritura));
                listParametrosDTOreg.add(new ParametrosDTO(9, "Integer", idod));
                querys.add(actualizaJURL);
            }
            ListaParametros.add(listParametrosDTOreg);
            // Ejecutamos el insert o update
            afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
        } catch (Exception e) {
            if (afecto != null) {
                afecto.setError(afecto.getError() + "\n" + e.getMessage());
            }
        }
        return afecto;
    }

    public PaqueteDTO eliminaJOrigenDatosPorId(int idod) {
        PaqueteDTO afecto = null;
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", idod));
            ListaParametros.add(listParametrosDTOreg);
            querys.add(eliminaJURL);
            // Ejecutamos el insert o update
            afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
        } catch (Exception e) {
            if (afecto != null) {
                afecto.setError(afecto.getError() + "\n" + e.getMessage());
            }
        }
        return afecto;
    }

}
