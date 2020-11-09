/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.socio;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.socio.VerificacionGeneralHuellaDigitalDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author gerardo
 */
@Stateless
@LocalBean
public class VerificacionGeneralHuellaDigitalFacade {

    @EJB
    private ControladorJDBC controladorJDBC;
    // --- SELECT --------------------------------------------------------------
    String buscaVerificacionGeneralHuellaDigital = " SELECT * "
            + " FROM verificacion_general_huella_digital "
            + " WHERE idusuario = ? "
            + "   AND modulo = ? "
            + "   AND verificado = false "
            + "   ORDER BY fecha DESC ";

    /*String buscaVerificacionGeneralHuellaDigitalPorIdUsuario = "SELECT DISTINCT(modulo),idusuario,sesion,idorigen,idgrupo,idsocio,tipo,mensaje,verificado,fecha " +
     "FROM verificacion_general_huella_digital WHERE idusuario = ? AND verificado = false ORDER BY fecha DESC;";*/
    String buscaVerificacionGeneralHuellaDigitalPorIdUsuario = "select DISTINCT(modulo),idusuario,sesion,idorigen,idgrupo,idsocio,tipo,mensaje,verificado,fecha from verificacion_general_huella_digital WHERE idusuario = ? AND verificado = false order by fecha desc limit 1;";
    // --- INSERT --------------------------------------------------------------
    String buscaVerificacionGeneralHuellaDigitalDTOPorIdUsuario = "SELECT vg.* FROM verificacion_general_huella_digital vg "
            + " INNER JOIN j_menu_validacion_general_huella jm on vg.modulo=jm.modulo "
            + " WHERE jm.estatus=true AND vg.idusuario = ? AND vg.verificado = false "
            + " ORDER BY fecha DESC limit 1;";

    // --- UPDATE --------------------------------------------------------------
    String actualizaVerificacionGeneralHuellaDigital = "UPDATE verificacion_general_huella_digital SET verificado = true "
            + " WHERE idusuario = ? AND modulo = ? AND idorigen = ? AND idgrupo = ? AND idsocio = ? ";

    // --- DELETE --------------------------------------------------------------
    // --- SELECT GENERICO -----------------------------------------------------
    // -------------------------------------------------------------------------
    // -------------------------------------------------------------------------
    public VerificacionGeneralHuellaDigitalDTO buscaVerificacionGeneralHuellaDigitalDTOPorIdUsuario(int idusuario) {
        try {
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTO.add(new ParametrosDTO(1, "Integer", idusuario));
            // Ejecuta el proceso
            PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(VerificacionGeneralHuellaDigitalDTO.class, listParametrosDTO, buscaVerificacionGeneralHuellaDigitalDTOPorIdUsuario);
            return (VerificacionGeneralHuellaDigitalDTO) paqueteDTO.getListResultadoDTO().get(0);
        } catch (Exception e) {
            return null;
        }
    }

    public List<VerificacionGeneralHuellaDigitalDTO> buscaVerificacionGeneralHuellaDigitalPorIdUsuario(int idusuario) {
        try {
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTO.add(new ParametrosDTO(1, "Integer", idusuario));
            // Ejecuta el proceso
            PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(VerificacionGeneralHuellaDigitalDTO.class, listParametrosDTO, buscaVerificacionGeneralHuellaDigitalPorIdUsuario);
            return (List<VerificacionGeneralHuellaDigitalDTO>) paqueteDTO.getListResultadoDTO();
        } catch (Exception e) {
            return null;
        }
    }

    // --- BUSCA SI EXISTE SOCIO PARA LA VERIFICACION GENERAL ------------------
    // -------------------------------------------------------------------------
    public VerificacionGeneralHuellaDigitalDTO buscaVerificacionGeneralHuellaDigital(int idusuario, String modulo) {
        try {
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTO.add(new ParametrosDTO(1, "Integer", idusuario));
            listParametrosDTO.add(new ParametrosDTO(2, "String", modulo));
            // Ejecuta el proceso
            PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(VerificacionGeneralHuellaDigitalDTO.class, listParametrosDTO, buscaVerificacionGeneralHuellaDigital);
            return (VerificacionGeneralHuellaDigitalDTO) paqueteDTO.getListResultadoDTO().get(0);
        } catch (Exception e) {
            return null;
        }
    }

    // -------------------------------------------------------------------------
    // --- ACTUALIZA AL SOCIO PARA LA VERIFICACION GENERAL ---------------------
    // -------------------------------------------------------------------------
    public int actualizaVerificacionGeneralHuellaDigital(int idusuario, String modulo, int idorigen, int idgrupo, int idsocio) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            // Se agrega el o los querys
            List<String> querys = new ArrayList<>(0);
            querys.add(actualizaVerificacionGeneralHuellaDigital);
            // Parametros para la consulta
            List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
            listParametrosDTO.add(new ParametrosDTO(1, "Integer", idusuario));
            listParametrosDTO.add(new ParametrosDTO(2, "String", modulo));
            listParametrosDTO.add(new ParametrosDTO(3, "Integer", idorigen));
            listParametrosDTO.add(new ParametrosDTO(4, "Integer", idgrupo));
            listParametrosDTO.add(new ParametrosDTO(5, "Integer", idsocio));
            ListaParametros.add(listParametrosDTO);
            // Ejecuta el INSERT
            Integer afecto = controladorJDBC.procesaCRUD(querys, ListaParametros).getListAfecto().get(0);
            return afecto;
        } catch (Exception e) {
            return 0;
        }
    }

}
