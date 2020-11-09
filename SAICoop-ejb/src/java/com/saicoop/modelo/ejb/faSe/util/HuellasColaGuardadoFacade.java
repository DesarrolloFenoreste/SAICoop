/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.util.HuellasColaGuardadoDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import com.saicoop.modelo.ejb.util.KitWeb;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author gerardo
 */
@Stateless
@LocalBean
public class HuellasColaGuardadoFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    KitWeb kitweb = new KitWeb();

    /* -------------------------------------------------------------------------
     * RETORNAN AL CLIENTE 
     ------------------------------------------------------------------------- */
    // BUSCA AL SOCIO QUE SE LE VA A CAPTURAR HUELLA Y PASA LA ENTIDAD A DTO PARA RETORNARLA AL CLIENTE
    String buscaHuellasColaGuardadoPorIdUsuario = "SELECT idusuario,idorigen,idgrupo,idsocio,fecha FROM huellas_cola_guardado WHERE idusuario = ? ORDER BY fecha DESC LIMIT 1 ";
    String eliminaHuellasColaGuardado = "DELETE FROM huellas_cola_guardado WHERE idusuario = ? ";

    public HuellasColaGuardadoDTO buscaIdsocioCola(int idusuario) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idusuario));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(HuellasColaGuardadoDTO.class, listParametrosDTO, buscaHuellasColaGuardadoPorIdUsuario);
        return (HuellasColaGuardadoDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

    public int eliminaHuellasColaGuardado(int idusuario) {
        try {
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", idusuario));
            ListaParametros.add(listParametrosDTOreg);
            querys.add(eliminaHuellasColaGuardado);
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto.getListAfecto().get(0);
        } catch (Exception e) {
            return 0;
        }
    }

}
