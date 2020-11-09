/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import com.saicoop.modelo.dto.util.TipoCambioDolarDTO;
import com.saicoop.modelo.ejb.util.KitWeb;
import java.math.BigDecimal;
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
public class TipoCambioDolarFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    KitWeb kitweb = new KitWeb();

    private final String buscaTipoCambio = "SELECT * FROM tipo_cambio_dolar WHERE fechatrabajo = ? and fecha = ?";
    private final String buscaUltimoTipoCambio = "SELECT * FROM tipo_cambio_dolar ORDER BY fecha DESC";
    private final String guardaUltimoTipoCambio = "INSERT INTO tipo_cambio_dolar(fechatrabajo, idusuario, tipo_cambio, fecha) VALUES((SELECT fechatrabajo FROM origenes LIMIT 1), ?, ?, (SELECT CURRENT_TIMESTAMP))";

    public TipoCambioDolarDTO buscaUltimoTipoCambio() {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(TipoCambioDolarDTO.class, listParametrosDTO, buscaUltimoTipoCambio);
        return (TipoCambioDolarDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

    public TipoCambioDolarDTO buscaTipoCambio(String fechatrabajo, String fecha) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Date", fechatrabajo));
        listParametrosDTO.add(new ParametrosDTO(2, "Date", fecha));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(TipoCambioDolarDTO.class, listParametrosDTO, buscaTipoCambio);
        return (TipoCambioDolarDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

    public int guardaUltimoTipoCambio(int idusuario, BigDecimal tipo_cambio) {
        PaqueteDTO paqueteDTO = new PaqueteDTO();
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTO.add(new ParametrosDTO(1, "Integer", idusuario));
            listParametrosDTO.add(new ParametrosDTO(2, "BigDecimal", tipo_cambio));
            ListaParametros.add(listParametrosDTO);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            querys.add(guardaUltimoTipoCambio);
            // Ejecutamos el insert o update
            controladorJDBC.procesaFUNCTION(querys, ListaParametros, "");
            return 1;
        } catch (Exception e) {
            String error = "Error en guardaUltimoTipoCambio de TipoCambioDolarFacade.";
            paqueteDTO.setError(error + e.getMessage());
            return 0;
        }
    }

}
