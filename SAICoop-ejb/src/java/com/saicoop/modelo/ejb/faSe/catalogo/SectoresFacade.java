/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.catalogo;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.catalogo.SectoresDTO;
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
public class SectoresFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    String buscaTodosLosSectores = "SELECT * FROM sectores ORDER BY idsector ASC";
    String buscaSectorPorId = "SELECT * FROM sectores WHERE idsector = ? ORDER BY idsector ASC";
    String guardaSector = "INSERT INTO sectores(nombre, idsector) VALUES(?, ?)";
    String actualizaSector = "UPDATE sectores SET nombre = ? WHERE idsector = ?";
    String borraSector = "DELETE FROM sectores WHERE idsector = ?";
    String ultimoSector = "SELECT *FROM sectores ORDER BY idsector DESC limit 1";

    public int proximoIdSector() {
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(SectoresDTO.class, listParametrosDTO, ultimoSector);
        if (paqueteDTO.getListResultadoDTO().get(0) != null) {
            SectoresDTO sdto = (SectoresDTO) paqueteDTO.getListResultadoDTO().get(0);
            return sdto.getIdsector() + 1;
        }
        return 0;
    }

    public List<SectoresDTO> buscaTodosLosSectores() {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(SectoresDTO.class, listParametrosDTO, buscaTodosLosSectores);
        return (List<SectoresDTO>) paqueteDTO.getListResultadoDTO();
    }

    public SectoresDTO buscaSectorPoId(int idsector) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idsector));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(SectoresDTO.class, listParametrosDTO, buscaSectorPorId);
        return (SectoresDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

    public int sectoresCU(boolean esInserta, int idsector, String nombre) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "String", nombre));
            listParametrosDTOreg.add(new ParametrosDTO(2, "Integer", idsector));
            ListaParametros.add(listParametrosDTOreg);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            if (esInserta) {
                querys.add(guardaSector);
            } else {
                querys.add(actualizaSector);
            }
            // Ejecutamos el insert o update
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto.getListAfecto().get(0);
        } catch (Exception e) {
            return 0;
        }
    }

    public int borrarSector(int idsector) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // TIPO DE HUELLAS REG - registrar
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", idsector));
            ListaParametros.add(listParametrosDTOreg);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            querys.add(borraSector);
            // Ejecutamos el insert o update
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto.getListAfecto().get(0);
        } catch (Exception e) {
            return 0;
        }
    }

}
