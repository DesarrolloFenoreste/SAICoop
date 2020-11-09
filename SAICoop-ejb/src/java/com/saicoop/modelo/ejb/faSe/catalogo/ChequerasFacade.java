/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.catalogo;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.catalogo.ChequerasDTO;
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
public class ChequerasFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    String buscaTodasLasChequeras = "SELECT * FROM chequeras ORDER BY idchequera ASC";
    String buscachequeraPorId = "SELECT * FROM chequeras WHERE idchequera = ? ORDER BY idchequera ASC";
    String guardaChequera = "INSERT INTO chequeras(idbanco, nombre, idcuenta, ultimocheque, impresora, idorigen, idchequera) VALUES (?, ?, ?, ?, ?, ?, ?)";
    String actualizaChequera = "UPDATE chequeras SET idbanco = ?, nombre = ?, idcuenta = ?, ultimocheque = ?, impresora = ?, idorigen = ? WHERE idchequera = ?";
    String borrachequera = "DELETE FROM chequeras WHERE idchequera = ?";
    String ultimoIdChequera = "SELECT *FROM chequeras ORDER BY idchequera DESC limit 1";

    public int proximoIdChequera() {
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(ChequerasDTO.class, listParametrosDTO, ultimoIdChequera);
        ChequerasDTO sdto = (ChequerasDTO) paqueteDTO.getListResultadoDTO().get(0);
        return sdto.getIdchequera() + 1;
    }

    public ChequerasDTO buscaChequeraPorId(int idchequera) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idchequera));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(ChequerasDTO.class, listParametrosDTO, buscachequeraPorId);
        return (ChequerasDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

    public List<ChequerasDTO> buscaTodasLasChequeras() {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(ChequerasDTO.class, listParametrosDTO, buscaTodasLasChequeras);
        return (List<ChequerasDTO>) paqueteDTO.getListResultadoDTO();
    }

    public int chequerasCU(boolean esInserta, int idchequera, int idbanco, String nombre, String idcuenta, int ultimocheque, String impresora, int idorigen) {
        try {
            if (idchequera < 0) {
                idchequera = proximoIdChequera();
            }
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTO.add(new ParametrosDTO(1, "Integer", idbanco));
            listParametrosDTO.add(new ParametrosDTO(2, "String", nombre));
            listParametrosDTO.add(new ParametrosDTO(3, "String", idcuenta));
            listParametrosDTO.add(new ParametrosDTO(4, "Integer", ultimocheque));
            listParametrosDTO.add(new ParametrosDTO(5, "String", impresora));
            listParametrosDTO.add(new ParametrosDTO(6, "Integer", idorigen));
            listParametrosDTO.add(new ParametrosDTO(7, "Integer", idchequera));
            ListaParametros.add(listParametrosDTO);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            if (esInserta) {
                querys.add(guardaChequera);
            } else {
                querys.add(actualizaChequera);
            }
            // Ejecutamos el insert o update
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto.getListAfecto().get(0);
        } catch (Exception e) {
            return 0;
        }
    }

    public int borrarChequera(int idchequera) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // TIPO DE HUELLAS REG - registrar
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", idchequera));
            ListaParametros.add(listParametrosDTOreg);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            querys.add(borrachequera);
            // Ejecutamos el insert o update
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto.getListAfecto().get(0);
        } catch (Exception e) {
            return 0;
        }
    }

}
