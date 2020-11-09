/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.catalogo;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.catalogo.FinalidadesDTO;
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
public class FinalidadesFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    String buscaTodasLasFinalidades = "SELECT * FROM finalidades ORDER BY idfinalidad ASC";
    String buscaFinalidadPorId = "SELECT * FROM finalidades WHERE idfinalidad = ? ORDER BY idfinalidad ASC";
    String buscaFinalidadPorDependencia = "SELECT * FROM finalidades WHERE dependede = ? ORDER BY idfinalidad ASC";
    String guardaFinalidad = "INSERT INTO finalidades(descripcion, dependede, clasif_contable_siti, idfinalidad) VALUES(?, ?, ?, ?)";
    String actualizaFinalidad = "UPDATE finalidades SET descripcion = ?, dependede = ?, clasif_contable_siti = ?  WHERE idfinalidad = ?";
    String borraFinalidad = "DELETE FROM finalidades WHERE idfinalidad = ?";
    String ultimaFinalidad = "SELECT *FROM finalidades ORDER BY idfinalidad DESC limit 1";

    public int proximoIdFinalidad() {
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(FinalidadesDTO.class, listParametrosDTO, ultimaFinalidad);
        FinalidadesDTO sdto = (FinalidadesDTO) paqueteDTO.getListResultadoDTO().get(0);
        return sdto.getIdfinalidad() + 1;
    }

    public List<FinalidadesDTO> buscaTodasLasFinalidades() {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(FinalidadesDTO.class, listParametrosDTO, buscaTodasLasFinalidades);
        return (List<FinalidadesDTO>) paqueteDTO.getListResultadoDTO();
    }

    public FinalidadesDTO buscaFinalidadPorId(int idfinalidad) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idfinalidad));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(FinalidadesDTO.class, listParametrosDTO, buscaFinalidadPorId);
        return (FinalidadesDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

    public List<FinalidadesDTO> buscaFinalidadesPorDependencia(int dependede) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", dependede));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(FinalidadesDTO.class, listParametrosDTO, buscaFinalidadPorDependencia);
        return (List<FinalidadesDTO>) paqueteDTO.getListResultadoDTO();
    }

    public int finalidadesCU(boolean esInserta, int idfinalidad, String descripcion, int dependede, Long clasif_contable_siti) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "String", descripcion));
            listParametrosDTOreg.add(new ParametrosDTO(2, "Integer", dependede));
            listParametrosDTOreg.add(new ParametrosDTO(3, "Long", clasif_contable_siti));
            listParametrosDTOreg.add(new ParametrosDTO(4, "Integer", idfinalidad));
            ListaParametros.add(listParametrosDTOreg);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            if (esInserta) {
                querys.add(guardaFinalidad);
            } else {
                querys.add(actualizaFinalidad);
            }
            // Ejecutamos el insert o update
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto.getListAfecto().get(0);
        } catch (Exception e) {
            return 0;
        }
    }

    public int borrarFinalidad(int idfinalidad) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // TIPO DE HUELLAS REG - registrar
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", idfinalidad));
            ListaParametros.add(listParametrosDTOreg);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            querys.add(borraFinalidad);
            // Ejecutamos el insert o update
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto.getListAfecto().get(0);
        } catch (Exception e) {
            return 0;
        }
    }

}
