/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.util.JMatrizConfiguracionDTO;
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
public class JMatrizConfiguracionFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    /*
   CREATE TABLE j_matriz_configuracion(
  idconfiguracion   INTEGER NOT NULL,
  idmatriz          INTEGER NOT NULL,
  celda             CHARACTER VARYING NOT NULL,
  configuracion     CHARACTER VARYING NOT NULL,
  idcontenido       INTEGER NOT NULL, 
  CONSTRAINT j_matriz_configuracion_pkey PRIMARY KEY (idconfiguracion,idmatriz,celda),
  CONSTRAINT j_matriz_fkey FOREIGN KEY (idmatriz)
      REFERENCES j_matriz (idmatriz) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT j_matriz_contenido_fkey FOREIGN KEY (idcontenido)
      REFERENCES j_matriz_contenido (idcontenido) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
COMMENT ON TABLE j_matriz_configuracion IS 'contiene la configuracion de plantillas y matrices'; 
     */
    private final static String buscaConfiguracionesPorIdMatriz = "select *from j_matriz_configuracion where idmatriz=?;";
    private final static String buscaConfiguracionPorIdMatrizYCelda = "select *from j_matriz_configuracion where idmatriz=? and celda=?;";
    private final static String eliminaMatrizconfiguracion = "delete from j_matriz_configuracion where idmatriz=?;";
    private final static String insertarConfiguracion = "insert into j_matriz_configuracion(idconfiguracion,idmatriz,celda,configuracion,idcontenido)values(?,?,?,?,?)";
    private final static String buscaMatrizConfiguracionCelda = "select *from j_matriz_configuracion where idconfiguracion=? and idmatriz=? and celda=?;";
    private final static String actualizaMatrizConfiguracion = "update j_matriz_configuracion set configuracion=?,idcontenido=? where idconfiguracion=? and idmatriz=? and celda=?";
    private final static String eliminaMatrizconfiguracionporIdConfiguracion = "delete from j_matriz_configuracion where idconfiguracion=?;";

    public PaqueteDTO actualizarJMatrizConfiguracion(int idconfiguracion, int idmatriz, String celda, String configuracion, int idcontenido) {
        // Lista de parametros para la consulta
        List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
        List<String> querys = new ArrayList<>(0);
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "String", configuracion));
        listParametrosDTO.add(new ParametrosDTO(2, "Integer", idcontenido));
        listParametrosDTO.add(new ParametrosDTO(3, "Integer", idconfiguracion));
        listParametrosDTO.add(new ParametrosDTO(4, "Integer", idmatriz));
        listParametrosDTO.add(new ParametrosDTO(5, "String", celda));
        querys.add(actualizaMatrizConfiguracion);
        ListaParametros.add(listParametrosDTO);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaCRUD(querys, ListaParametros);
        return paqueteDTO;
    }

    public JMatrizConfiguracionDTO buscaJMatrizConfiguracionCelda(int idconfiguracion, int idmatriz, String celda) {
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idconfiguracion));
        listParametrosDTO.add(new ParametrosDTO(2, "Integer", idmatriz));
        listParametrosDTO.add(new ParametrosDTO(3, "String", celda));
        return (JMatrizConfiguracionDTO) controladorJDBC.procesaSelect(JMatrizConfiguracionDTO.class, listParametrosDTO, buscaMatrizConfiguracionCelda).getListResultadoDTO().get(0);
    }

    public PaqueteDTO buscaTodoJMatrizConfig(int idmatriz) {
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idmatriz));
        return controladorJDBC.procesaSelect(JMatrizConfiguracionDTO.class, listParametrosDTO, buscaConfiguracionesPorIdMatriz);
    }

    public JMatrizConfiguracionDTO buscaJMatrizConfigConIdMatrizYCelda(int idmatriz, String celda) {
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idmatriz));
        listParametrosDTO.add(new ParametrosDTO(2, "String", celda));
        return (JMatrizConfiguracionDTO) controladorJDBC.procesaSelect(JMatrizConfiguracionDTO.class, listParametrosDTO, buscaConfiguracionPorIdMatrizYCelda).getListResultadoDTO().get(0);
    }

    public PaqueteDTO insertaJMatrizConfiguracion(int idconfiguracion, int idmatriz, String celda, String configuracion, int idcontenido) {
        // Lista de parametros para la consulta
        List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
        List<String> querys = new ArrayList<>(0);
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idconfiguracion));
        listParametrosDTO.add(new ParametrosDTO(2, "Integer", idmatriz));
        listParametrosDTO.add(new ParametrosDTO(3, "String", celda));
        listParametrosDTO.add(new ParametrosDTO(4, "String", configuracion));
        listParametrosDTO.add(new ParametrosDTO(5, "Integer", idcontenido));
        querys.add(insertarConfiguracion);
        ListaParametros.add(listParametrosDTO);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaCRUD(querys, ListaParametros);
        return paqueteDTO;
    }

    public PaqueteDTO eliminaJMatrizConfiguracion(int idmatriz) {
        List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
        List<String> querys = new ArrayList<>(0);
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idmatriz));
        querys.add(eliminaMatrizconfiguracion);
        ListaParametros.add(listParametrosDTO);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaCRUD(querys, ListaParametros);
        return paqueteDTO;
    }

    public PaqueteDTO eliminaJMatrizConfiguracionPorIdConfiguracion(int idconfiguracion) {
        List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
        List<String> querys = new ArrayList<>(0);
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idconfiguracion));
        querys.add(eliminaMatrizconfiguracionporIdConfiguracion);
        ListaParametros.add(listParametrosDTO);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaCRUD(querys, ListaParametros);
        return paqueteDTO;
    }
}
