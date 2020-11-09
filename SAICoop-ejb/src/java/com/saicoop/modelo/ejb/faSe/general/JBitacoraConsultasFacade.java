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
public class JBitacoraConsultasFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    @EJB
    private SaiFunciones saiFunciones;

    String guardaEnBitacoraConsultas = "insert into j_bitacora_consultas(fecha,idmenu,idaccion,idusuario,fechatrabajo,idorigen,idgrupo,idsocio,idorigenp,idproducto,idauxiliar) values(?,?,?,?,Date(?),?,?,?,?,?,?);";
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

    public PaqueteDTO guardaEnBitacoraConsultas(int idmenu, int idaccion, int idusuario, int idorigen, int idgrupo, int idsocio, int idorigenp, int idproducto, int idauxiliar) {
        String fecha = getFechaTrabajoCambiaMilis();
        String fechaTrabajo = saiFunciones.saiFechaTrabajo();
        try {
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
            listParametrosDTOreg.add(new ParametrosDTO(6, "Integer", idorigen));
            listParametrosDTOreg.add(new ParametrosDTO(7, "Integer", idgrupo));
            listParametrosDTOreg.add(new ParametrosDTO(8, "Integer", idsocio));
            listParametrosDTOreg.add(new ParametrosDTO(9, "Integer", idorigenp));
            listParametrosDTOreg.add(new ParametrosDTO(10, "Integer", idproducto));
            listParametrosDTOreg.add(new ParametrosDTO(11, "Integer", idauxiliar));
            querys.add(guardaEnBitacoraConsultas);
            ListaParametros.add(listParametrosDTOreg);
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
    private int idorigen;
    private int idgrupo;
    private int idsocio;
    private int idorigenp;
    private int idproducto;
    private int idauxiliar;
     *///
}
