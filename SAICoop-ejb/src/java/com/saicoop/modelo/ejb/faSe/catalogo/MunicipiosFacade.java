/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.catalogo;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.catalogo.MunicipiosDTO;
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
 * @descripción: Clase que contiene las sentencias de CRUD de la tabla municipios
 */
@Stateless
@LocalBean
public class MunicipiosFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    // -------------------------------------------------------------------------
    // --- SELECT --------------------------------------------------------------
    String buscaTodosLosMunicipios = "SELECT * FROM municipios ORDER BY idmunicipio ASC";
    String buscaMunicipio = "SELECT * FROM municipios WHERE idmunicipio = ? LIMIT 1";
    String buscaMunicipioPorEstado = "SELECT * FROM municipios WHERE idestado = ? ORDER BY idmunicipio ASC";
    String consecutivoMunicipio = "SELECT * FROM municipios ORDER BY idmunicipio DESC LIMIT 1";
    String ultimoIdMunicipio = "SELECT *FROM municipios ORDER BY idmunicipio DESC limit 1";
    // --- INSERT --------------------------------------------------------------
    String guardaMunicipio = "INSERT INTO municipios(nombre, idestado, de_cp, a_cp, idmunicipio) VALUES(?, ?, ?, ?, ?)";
    // --- UPDATE --------------------------------------------------------------
    String actualizaMunicipio = "UPDATE municipios SET nombre = ?, idestado = ?, de_cp = ?, a_cp = ?  WHERE idmunicipio = ?";
    // --- DELITE --------------------------------------------------------------
    String borraMunicipio = "DELETE FROM municipios WHERE idmunicipio = ?";
    // -------------------------------------------------------------------------
    

    public List<MunicipiosDTO> buscarTodosLosMunicipos() {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(MunicipiosDTO.class, listParametrosDTO, buscaTodosLosMunicipios);
        return (List<MunicipiosDTO>) paqueteDTO.getListResultadoDTO();
    }

    public MunicipiosDTO buscarMunicipio(int idmunicipio) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idmunicipio));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(MunicipiosDTO.class, listParametrosDTO, buscaMunicipio);
        return (MunicipiosDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

    public List<MunicipiosDTO> buscarMuniciposPorEstado(int idestado) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idestado));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(MunicipiosDTO.class, listParametrosDTO, buscaMunicipioPorEstado);
        return (List<MunicipiosDTO>) paqueteDTO.getListResultadoDTO();
    }

    public int municipiosCU(boolean esInserta, int idmunicipio, String nombre, int idestado, String de_cp, String a_cp) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "String", nombre));
            listParametrosDTOreg.add(new ParametrosDTO(2, "Integer", idestado));
            listParametrosDTOreg.add(new ParametrosDTO(3, "String", de_cp));
            listParametrosDTOreg.add(new ParametrosDTO(4, "String", a_cp));
            listParametrosDTOreg.add(new ParametrosDTO(5, "Integer", idmunicipio));
            ListaParametros.add(listParametrosDTOreg);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            if (esInserta) {
                querys.add(guardaMunicipio);
            } else {
                querys.add(actualizaMunicipio);
            }
            // Ejecutamos el insert o update
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto.getListAfecto().get(0);
        } catch (Exception e) {
            return 0;
        }
    }

    public int borrarMunicipio(int idmunicipio) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // TIPO DE HUELLAS REG - registrar
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", idmunicipio));
            ListaParametros.add(listParametrosDTOreg);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            querys.add(borraMunicipio);
            // Ejecutamos el insert o update
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto.getListAfecto().get(0);
        } catch (Exception e) {
            return 0;
        }
    }

    public MunicipiosDTO ultimoMunicipio() {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(MunicipiosDTO.class, listParametrosDTO, consecutivoMunicipio);
        return (MunicipiosDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

}
