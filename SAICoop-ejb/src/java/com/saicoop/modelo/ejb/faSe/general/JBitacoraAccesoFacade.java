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
public class JBitacoraAccesoFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    @EJB
    private SaiFunciones saiFunciones;

    String guardaEnBitacoraAcceso = "insert into j_bitacora_accesos(fecha,idmenu,idaccion,idusuario,fechatrabajo) values(?,?,?,?,Date(?));";
    Control c = new Control();

    private String getFechaTrabajoCambiaMilis() {
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        String fecha = saiFunciones.saiFechaDBTimeStampString();
        String ns = fecha;
        try {
            int i = (c.randomInt(3) + c.randomInt(3)) / (c.randomInt(1) + 1);
            ns = fecha.split("\\.")[0] + "." + i;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return ns;
    }

    public PaqueteDTO guardaEnBitacoraAcceso(int idmenu, int idaccion, int idusuario) {
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
            listParametrosDTOreg.add(new ParametrosDTO(5, "String", fechaTrabajo));
            ListaParametros.add(listParametrosDTOreg);
            querys.add(guardaEnBitacoraAcceso);
            // Ejecutamos el insert o update
            return controladorJDBC.procesaCRUD(querys, ListaParametros);
        } catch (Exception e) {
            return null;
        }
    }
    /*
    private LocalDate fecha;
    private String modulo;
    private int accion;
    private int idusuario;
    private LocalDateTime fechatrabajo;
     */
}
