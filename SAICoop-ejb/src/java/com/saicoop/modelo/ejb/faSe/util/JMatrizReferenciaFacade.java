/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.util.JMatrizReferenciaDTO;
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
public class JMatrizReferenciaFacade {

    /*
  CREATE TABLE j_matriz_referencia(
  idreferencia     INTEGER NOT NULL,
  periodo          CHARACTER VARYING NOT NULL,
  idcontenido      INTEGER NOT NULL,
  valor            CHARACTER VARYING NOT NULL,
  descripcion      CHARACTER VARYING NOT NULL,
  CONSTRAINT j_matriz_referencia_pkey PRIMARY KEY (idreferencia,periodo,idcontenido),
  CONSTRAINT j_matriz_contenido_fkey FOREIGN KEY (idcontenido)
      REFERENCES j_matriz_contenido (idcontenido) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
COMMENT ON TABLE j_matriz_referencia IS 'esta tabla contiene valores con referencia a algun registro de j_matriz_contenido'; 
     */
    @EJB
    private ControladorJDBC controladorJDBC;

    private final static String buscaJMatrizReferenciaPorIdContenido = "select *from j_matriz_referencia where idcontenido=?;";
    private final static String buscaJMatrizReferenciaPorIdReferenciaYPeriodo = "select *from j_matriz_referencia where idreferencia=? and periodo=?;";
    private final static String buscaJMatrizReferenciaPorLlaveCompleta = "select *from j_matriz_referencia where idreferencia=? and periodo=? and idcontenido=?;";
    private final static String buscaTodoJMatrizReferencia = "select *from j_matriz_referencia;";
    private final static String insertaReferencia = "insert into j_matriz_referencia(idreferencia,periodo,idcontenido,valor,descripcion)values(?,?,?,?,?)";
    private final static String eliminaReferencia = "delete from j_matriz_referencia where idreferencia=?;";
    private final static String actualizaReferencia = "update j_matriz_referencia set valor=?, descripcion=? where idreferencia=? and periodo=? and idcontenido=?";
    private final static String referenciasDeLaMatriz = "select distinct ctr.idcontenido,ctr.idreferencia,ctr.periodo,ctr.valor,ctr.descripcion "
            + "from j_matriz_referencia ctr "
            + "inner join j_matriz_configuracion cnf "
            + "on ctr.idcontenido=cnf.idcontenido "
            + "where cnf.idmatriz=? order by ctr.idcontenido;";

    public PaqueteDTO actualizaJMatrizReferencia(int idreferencia, String periodo, int idcontenido, String valor, String descripcion) {
        // Lista de parametros para la consulta
        List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
        List<String> querys = new ArrayList<>(0);
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "String", valor));
        listParametrosDTO.add(new ParametrosDTO(2, "String", descripcion));
        listParametrosDTO.add(new ParametrosDTO(3, "Integer", idreferencia));
        listParametrosDTO.add(new ParametrosDTO(4, "String", periodo));
        listParametrosDTO.add(new ParametrosDTO(5, "Integer", idcontenido));
        querys.add(actualizaReferencia);
        ListaParametros.add(listParametrosDTO);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaCRUD(querys, ListaParametros);
        return paqueteDTO;
    }

    public PaqueteDTO insertaJMatrizReferencia(int idreferencia, String periodo, int idcontenido, String valor, String descripcion) {
        // Lista de parametros para la consulta
        List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
        List<String> querys = new ArrayList<>(0);
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idreferencia));
        listParametrosDTO.add(new ParametrosDTO(2, "String", periodo));
        listParametrosDTO.add(new ParametrosDTO(3, "Integer", idcontenido));
        listParametrosDTO.add(new ParametrosDTO(4, "String", valor));
        listParametrosDTO.add(new ParametrosDTO(5, "String", descripcion));
        querys.add(insertaReferencia);
        ListaParametros.add(listParametrosDTO);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaCRUD(querys, ListaParametros);
        return paqueteDTO;
    }

    public PaqueteDTO eliminaJMAtrizReferencia(int idreferencia) {
        List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
        List<String> querys = new ArrayList<>(0);
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idreferencia));
        querys.add(eliminaReferencia);
        ListaParametros.add(listParametrosDTO);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaCRUD(querys, ListaParametros);
        return paqueteDTO;
    }

    public JMatrizReferenciaDTO buscaJMatrizReferenciaPorId(int idreferencia, String periodo, Integer idcontenido) {
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idreferencia));
        listParametrosDTO.add(new ParametrosDTO(2, "String", periodo));
        listParametrosDTO.add(new ParametrosDTO(3, "Integer", idcontenido));
        return (JMatrizReferenciaDTO) controladorJDBC.procesaSelect(JMatrizReferenciaDTO.class, listParametrosDTO, buscaJMatrizReferenciaPorLlaveCompleta).getListResultadoDTO().get(0);
    }

    public JMatrizReferenciaDTO buscaJMatrizReferenciaPorIdContenido(Integer idcontenido) {
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idcontenido));
        return (JMatrizReferenciaDTO) controladorJDBC.procesaSelect(JMatrizReferenciaDTO.class, listParametrosDTO, buscaJMatrizReferenciaPorIdContenido).getListResultadoDTO().get(0);
    }

    public PaqueteDTO buscaTodoJMatrizReferencia() {
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        return controladorJDBC.procesaSelect(JMatrizReferenciaDTO.class, listParametrosDTO, buscaTodoJMatrizReferencia);
    }

    public PaqueteDTO buscaJMatrizReferenciaSoloPestañaPorPeriodo(String periodo) {
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "String", periodo));
        return controladorJDBC.procesaSelect(JMatrizReferenciaDTO.class, listParametrosDTO, buscaJMatrizReferenciaPorIdReferenciaYPeriodo);
    }

    public PaqueteDTO buscaJMatrizReferenciasPorIdMatriz(int idmatriz) {
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idmatriz));
        return controladorJDBC.procesaSelect(JMatrizReferenciaDTO.class, listParametrosDTO, referenciasDeLaMatriz);
    }
}
