/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.socio;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.socio.GruposDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author prometeo
 */
@Stateless
@LocalBean
public class GruposFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    String buscaTodosLosGrupos = "SELECT * FROM grupos ORDER BY idgrupo ASC";
    String buscaGruposPorId = "SELECT * FROM grupos WHERE idgrupo = ?";
    String guardaGrupo = "INSERT INTO grupos(nombre, tipogrupo, idgrupo) VALUES(?, ?, ?)";
    String actualizaGrupo = "UPDATE grupos SET nombre = ?, tipogrupo = ? WHERE idgrupo = ?";
    String borraGrupo = "DELETE FROM grupos WHERE idgrupo = ?";
    String ultimoIdGrupo = "SELECT *FROM grupos ORDER BY idgrupo DESC limit 1";

    public int proximoIdGrupos() {
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(GruposDTO.class, listParametrosDTO, ultimoIdGrupo);
        GruposDTO sdto = (GruposDTO) paqueteDTO.getListResultadoDTO().get(0);
        return sdto.getIdgrupo() + 1;
    }

    public List<GruposDTO> buscaTodosLosGrupos() {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(GruposDTO.class, listParametrosDTO, buscaTodosLosGrupos);
        return (List<GruposDTO>) paqueteDTO.getListResultadoDTO();
    }

    public GruposDTO buscaGrupo(int idgrupo) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idgrupo));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(GruposDTO.class, listParametrosDTO, buscaGruposPorId);
        return (GruposDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

    public int gruposCU(boolean esInserta, int idgrupo, String nombre, int tipogrupo) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTO.add(new ParametrosDTO(1, "String", nombre));
            listParametrosDTO.add(new ParametrosDTO(2, "Integer", tipogrupo));
            listParametrosDTO.add(new ParametrosDTO(3, "Integer", idgrupo));
            ListaParametros.add(listParametrosDTO);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            if (esInserta) {
                querys.add(guardaGrupo);
            } else {
                querys.add(actualizaGrupo);
            }
            // Ejecutamos el insert o update
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto.getListAfecto().get(0);
        } catch (Exception e) {
            return 0;
        }
    }

    public int borrarGrupo(int idgrupo) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // TIPO DE HUELLAS REG - registrar
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", idgrupo));
            ListaParametros.add(listParametrosDTOreg);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            querys.add(borraGrupo);
            // Ejecutamos el insert o update
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto.getListAfecto().get(0);
        } catch (Exception e) {
            return 0;
        }
    }

}
