/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import com.saicoop.modelo.dto.util.JRegulatoriosDTO;
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
public class RegulatoriosFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    /*
  CREATE TABLE j_regulatorios (
  serie             CHARACTER VARYING NOT NULL,
  idreg             CHARACTER VARYING NOT NULL, 
  descripcion       CHARACTER VARYING NOT NULL, 
  periodo           INTEGER NOT NULL,
  funcion           TEXT, 
  consulta          TEXT, 
  visible           BOOLEAN NOT NULL DEFAULT FALSE,
  CONSTRAINT j_Regulatorios_pkey PRIMARY KEY (idreg)
    );
    COMMENT ON TABLE j_Regulatorios IS 'Contiene las funciones para obtener los reportes regulatorios'; 
     
    private String serie;
    private String idreg;
    private String descripcion;
    private Integer periodo;
    private String funcion;
    private String consulta;
    private Boolean visible;
     */
    private final String buscaRegulatorioPorserie = " SELECT * FROM j_regulatorios where serie=?;";
    private final String buscaRegulatorioPorIdreg = " SELECT * FROM j_regulatorios where idreg=?;";
    private final String buscaRegulatorioPorSerieYIdreg = " SELECT *FROM j_regulatorios where serie=? and idreg=?;";
    private final String buscaTodosLosRegulatorios = "SELECT * FROM j_regulatorios;";
    private final String insertaj_Regulatorio = "insert into j_regulatorios(serie,idreg,descripcion,periodo,funcion,consulta,visible) values (?,?,?,?,?,?,?);";
    private final String eliminaj_Regulatorio = "delete from j_regulatorios where serie=? and idreg=?;";
    private final String actualizaj_Regulatorio = "update j_regulatorios set descripcion=?,periodo=?,funcion=?,consulta=?,visible=? where serie=? and idreg=?;";

    public PaqueteDTO buscaTodosLosRegulatorios() {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(JRegulatoriosDTO.class, listParametrosDTO, buscaTodosLosRegulatorios);
        return paqueteDTO;
    }

    public JRegulatoriosDTO buscaRegulatorioPorSerieYIdReg(String serie, String idreg) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "String", serie));
        listParametrosDTO.add(new ParametrosDTO(2, "String", idreg));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(JRegulatoriosDTO.class, listParametrosDTO, buscaRegulatorioPorSerieYIdreg);
        if (!paqueteDTO.getListResultadoDTO().isEmpty()) {
            return (JRegulatoriosDTO) paqueteDTO.getListResultadoDTO().get(0);
        } else {
            return null;
        }
    }

    public PaqueteDTO buscaRegulatorioPorSerie(String serie) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "String", serie));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(JRegulatoriosDTO.class, listParametrosDTO, buscaRegulatorioPorserie);
        return paqueteDTO;
    }

    public PaqueteDTO buscaRegulatorioPorIdReg(String idreg) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "String", idreg));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(JRegulatoriosDTO.class, listParametrosDTO, buscaRegulatorioPorIdreg);
        return paqueteDTO;
    }

    public PaqueteDTO borrarRegulatorio(String serie, String idreg) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // TIPO DE HUELLAS REG - registrar
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "String", serie));
            listParametrosDTOreg.add(new ParametrosDTO(2, "String", idreg));
            ListaParametros.add(listParametrosDTOreg);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            querys.add(eliminaj_Regulatorio);
            // Ejecutamos el insert o update
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto;
        } catch (Exception e) {
            return null;
        }
    }

    public PaqueteDTO regulatoriosCU(boolean esInserta, String serie, String idreg, String descripcion, int periodo, String funcion, String consulta, boolean visible) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
            // Parametros para la consulta
            // Dependiendo si es insert o update se ejecuta la cosnulta
            if (esInserta) {
                listParametrosDTO.add(new ParametrosDTO(1, "String", serie));
                listParametrosDTO.add(new ParametrosDTO(2, "String", idreg));
                listParametrosDTO.add(new ParametrosDTO(3, "String", descripcion));
                listParametrosDTO.add(new ParametrosDTO(4, "Integer", periodo));
                listParametrosDTO.add(new ParametrosDTO(5, "String", funcion));
                listParametrosDTO.add(new ParametrosDTO(6, "String", consulta));
                listParametrosDTO.add(new ParametrosDTO(7, "Boolean", visible));
                querys.add(insertaj_Regulatorio);
            } else {
                listParametrosDTO.add(new ParametrosDTO(1, "String", descripcion));
                listParametrosDTO.add(new ParametrosDTO(2, "Integer", periodo));
                listParametrosDTO.add(new ParametrosDTO(3, "String", funcion));
                listParametrosDTO.add(new ParametrosDTO(4, "String", consulta));
                listParametrosDTO.add(new ParametrosDTO(5, "Boolean", visible));
                listParametrosDTO.add(new ParametrosDTO(6, "String", serie));
                listParametrosDTO.add(new ParametrosDTO(7, "String", idreg));
                querys.add(actualizaj_Regulatorio);
            }

            ListaParametros.add(listParametrosDTO);
            // Ejecutamos el insert o update
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto;
        } catch (Exception e) {
            return null;
        }
    }
}
