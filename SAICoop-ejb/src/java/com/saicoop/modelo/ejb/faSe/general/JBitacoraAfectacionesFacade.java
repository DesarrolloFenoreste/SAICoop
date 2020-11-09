/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import com.saicoop.modelo.ejb.impl.SaiFunciones;
import com.saicoop.modelo.ejb.util.Control;
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
public class JBitacoraAfectacionesFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    @EJB
    private SaiFunciones saiFunciones;

    String guardaEnBitacoraAfectaciones = "insert into j_bitacora_afectaciones(fecha,idmenu,idaccion,idusuario,referencia,detalle,fechatrabajo) values(?,?,?,?,?,?,Date(?));";
    String ultimaFecha = "select fecha from j_bitacora_afectaciones order by fecha desc limit 1;";

    Control c = new Control();

    private String getFechaTrabajoCambiaMilis() {
        String fecha = saiFunciones.saiFechaDBTimeStampString();
        String ns = fecha.split("\\.")[0] + "." + String.format("%3d", c.randomInt(6));
        return ns;
    }

    public PaqueteDTO guardaEnBitacoraAfectaciones(int idmenu, int idaccion, int idusuario, String referencia, String detalle) {
        try {
            String fecha = getFechaTrabajoCambiaMilis();
            String fechaTrabajo = saiFunciones.saiFechaTrabajo();
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "Timestamp", fecha));
            listParametrosDTOreg.add(new ParametrosDTO(2, "Integer", idmenu));
            listParametrosDTOreg.add(new ParametrosDTO(3, "Integer", idaccion));
            listParametrosDTOreg.add(new ParametrosDTO(4, "Integer", idusuario));
            listParametrosDTOreg.add(new ParametrosDTO(5, "String", referencia));
            listParametrosDTOreg.add(new ParametrosDTO(6, "String", detalle));
            listParametrosDTOreg.add(new ParametrosDTO(7, "String", fechaTrabajo));
            ListaParametros.add(listParametrosDTOreg);
            querys.add(guardaEnBitacoraAfectaciones);
            // Ejecutamos el insert o update
            return controladorJDBC.procesaCRUD(querys, ListaParametros);
        } catch (Exception e) {
            return null;
        }
    }
    /*
    private LocalDate fecha;
    private int idmenu;
    private int accion;
    private int idusuario;
    private LocalDateTime fechatrabajo;
    private String referencia;
    private String detalle;
     */
}
