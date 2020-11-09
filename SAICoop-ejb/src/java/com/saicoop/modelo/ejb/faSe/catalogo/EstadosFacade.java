/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.catalogo;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.catalogo.EstadosDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Gerardo Treviño Montelongo
 * @version 1.00.001
 * @fecha 17 de Julio de 2017
 * @descripción: Clase que contiene las sentencias de CRUD de la tabla estados
 */
@Stateless
@LocalBean
public class EstadosFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    // -------------------------------------------------------------------------
    // --- SELECT --------------------------------------------------------------
    String buscaTodosLosEstados = "SELECT * FROM estados ORDER BY idestado ASC";
    String buscaEstado = "SELECT * FROM estados WHERE idestado = ? LIMIT 1";
    String buscaEstadosPorPais = "SELECT * FROM estados WHERE idpais = ? ORDER BY idestado ASC";
    String ultimoEstado = "SELECT * FROM estados ORDER BY idestado DESC LIMIT 1";
    // --- INSERT --------------------------------------------------------------
    String guardaEstado = "INSERT INTO estados(nombre, ef, idpais, idestado) VALUES (?, ?, ?, ?)";
    // --- UPDATE --------------------------------------------------------------
    String actualizaEstado = "UPDATE estados SET nombre = ?, ef = ?, idpais = ? WHERE idestado = ?";
    // --- DELITE --------------------------------------------------------------
    String borraEstado = "DELETE FROM estados WHERE idestado = ?";
    // -------------------------------------------------------------------------

    // -------------------------------------------------------------------------
    // --- BUSCA TODOS LOS ESTADOS ---------------------------------------------
    // -------------------------------------------------------------------------
    public List<EstadosDTO> buscarTodosLosEstados() {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(EstadosDTO.class, listParametrosDTO, buscaTodosLosEstados);
        return (List<EstadosDTO>) paqueteDTO.getListResultadoDTO();
    }

    // -------------------------------------------------------------------------
    // --- BUSCA TODOS LOS ESTADOS POR IDPAIS ----------------------------------
    // -------------------------------------------------------------------------    
    public List<EstadosDTO> buscarEstadosPorPais(int idpais) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idpais));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(EstadosDTO.class, listParametrosDTO, buscaEstadosPorPais);
        return (List<EstadosDTO>) paqueteDTO.getListResultadoDTO();
    }

    // -------------------------------------------------------------------------
    // --- BUSCA ESTADO POR IDESTADO -------------------------------------------
    // -------------------------------------------------------------------------
    public EstadosDTO buscarEstado(int idestado) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idestado));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(EstadosDTO.class, listParametrosDTO, buscaEstado);
        return (EstadosDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

    // -------------------------------------------------------------------------
    // --- APLICA EN COLONIAS EL INSERT Y UDPDATE ------------------------------
    // -------------------------------------------------------------------------
    public int estadosCU(boolean esInserta, int idestado, String nombre, String ef, int idpais) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTO.add(new ParametrosDTO(1, "String", nombre));
            listParametrosDTO.add(new ParametrosDTO(2, "String", ef));
            listParametrosDTO.add(new ParametrosDTO(3, "Integer", idpais));
            listParametrosDTO.add(new ParametrosDTO(4, "Integer", idestado));
            ListaParametros.add(listParametrosDTO);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            if (esInserta) {
                querys.add(guardaEstado);
            } else {
                querys.add(actualizaEstado);
            }
            // Ejecutamos el insert o update
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto.getListAfecto().get(0);
        } catch (Exception e) {
            return 0;
        }
    }

    // -------------------------------------------------------------------------
    // --- BORRA EL ESTADO POR IDESTADO ----------------------------------------
    // -------------------------------------------------------------------------
    public int borrarEstado(int idestado) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // TIPO DE HUELLAS REG - registrar
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", idestado));
            ListaParametros.add(listParametrosDTOreg);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            querys.add(borraEstado);
            // Ejecutamos el insert o update
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto.getListAfecto().get(0);
        } catch (Exception e) {
            return 0;
        }
    }

    // -------------------------------------------------------------------------
    // --- RETORNA EL ULTIMO ESTADO AGREGADO ----------------------------------- 
    // -------------------------------------------------------------------------
    public EstadosDTO ultimoEstado() {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(EstadosDTO.class, listParametrosDTO, ultimoEstado);
        return (EstadosDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

}
