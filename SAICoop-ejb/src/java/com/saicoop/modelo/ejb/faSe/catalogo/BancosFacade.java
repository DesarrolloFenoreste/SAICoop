/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.catalogo;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.catalogo.BancosDTO;
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
public class BancosFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    String buscaTodosLosBancos = "SELECT * FROM bancos ORDER BY idbanco ASC";
    String buscaBancoPorId = "SELECT * FROM bancos WHERE idbanco = ? ORDER BY idbanco ASC";
    String guardaBanco = "INSERT INTO bancos(nombre, banco_receptor, idbanco) VALUES(?, ?, ?)";
    String actualizaBanco = "UPDATE bancos SET nombre = ?, banco_receptor= ? WHERE idbanco = ?";
    String borraBanco = "DELETE FROM bancos WHERE idbanco = ?";
    String ultimoIdBanco = "SELECT *FROM bancos ORDER BY idbanco DESC limit 1";

    public int proximoIdBanco() {
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(BancosDTO.class, listParametrosDTO, ultimoIdBanco);
        BancosDTO sdto = (BancosDTO) paqueteDTO.getListResultadoDTO().get(0);
        return sdto.getIdbanco() + 1;
    }

    public BancosDTO buscaBancosPorId(int idbanco) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idbanco));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(BancosDTO.class, listParametrosDTO, buscaBancoPorId);
        return (BancosDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

    public List<BancosDTO> buscaTodosLosBancos() {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(BancosDTO.class, listParametrosDTO, buscaTodosLosBancos);
        return (List<BancosDTO>) paqueteDTO.getListResultadoDTO();
    }

    public int bancosCU(boolean esInserta, int idbanco, String nombre, String banco_receptor) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "String", nombre));
            listParametrosDTOreg.add(new ParametrosDTO(2, "String", banco_receptor));
            listParametrosDTOreg.add(new ParametrosDTO(3, "Integer", idbanco));
            ListaParametros.add(listParametrosDTOreg);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            if (esInserta) {
                querys.add(guardaBanco);
            } else {
                querys.add(actualizaBanco);
            }
            // Ejecutamos el insert o update
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto.getListAfecto().get(0);
        } catch (Exception e) {
            return 0;
        }
    }

    public int borrarBanco(int idbanco) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // TIPO DE HUELLAS REG - registrar
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", idbanco));
            ListaParametros.add(listParametrosDTOreg);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            querys.add(borraBanco);
            // Ejecutamos el insert o update
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto.getListAfecto().get(0);
        } catch (Exception e) {
            return 0;
        }
    }

}
