/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.util.JMatrizContenidoDTO;
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
public class JMatrizContenidoFacade {

    @EJB
    private ControladorJDBC controladorJDBC;
    /*
   CREATE TABLE j_matriz_contenido(
  idcontenido   INTEGER NOT NULL,
  valor         CHARACTER VARYING NOT NULL, 
  tipo          INTEGER NOT NULL,
  descripcion   CHARACTER VARYING NOT NULL,
  CONSTRAINT j_matriz_contenido_pkey PRIMARY KEY (idcontenido)
);
COMMENT ON TABLE j_matriz_contenido IS 'esta tabla tiene el contenido de cada celda en plantillas y matrices'; 
     */
    private final static String buscaJMatrizTxtPorId = "select *from j_matriz_contenido where idcontenido=?";
    private final static String buscaTodoJMatrizTxt = "select *from j_matriz_contenido";
    private final static String buscaJMatrizTxtSoloPestañaPorPeriodo = "select distinct cont.idcontenido,cont.valor,cont.descripcion "
            + "from j_matriz_contenido cont "
            + "inner join j_matriz_configuracion conf "
            + "on conf.idcontenido=cont.idcontenido "
            + "inner join j_matriz matriz "
            + "on conf.idmatriz=matriz.idmatriz "
            + "where matriz.periodo=? order by txt.idcontenido;";
    private final static String eliminaMatrizContenido = "delete from j_matriz_contenido where idcontenido=?";
    private final static String insertaMatrizContenido = "insert into j_matriz_contenido(idcontenido,valor,tipo,descripcion) values(?,?,?,?);";
    private final static String actualizarMatrizContenido = "update j_matriz_contenido set valor=?, tipo=?, descripcion=? where idcontenido=?";
    private final static String buscaContenidoPorMatriz = "select distinct ctn.idcontenido,ctn.valor,ctn.tipo,ctn.descripcion from j_matriz_contenido ctn "
            + "inner join j_matriz_configuracion cnf "
            + "on ctn.idcontenido=cnf.idcontenido "
            + "where cnf.idmatriz=? order by ctn.idcontenido;";

    public PaqueteDTO actualizaJMatrizContenido(int idcontenido, String valor, int tipo, String descripcion) {
        // Lista de parametros para la consulta
        List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
        List<String> querys = new ArrayList<>(0);
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "String", valor));
        listParametrosDTO.add(new ParametrosDTO(2, "Integer", tipo));
        listParametrosDTO.add(new ParametrosDTO(3, "String", descripcion));
        listParametrosDTO.add(new ParametrosDTO(4, "Integer", idcontenido));
        querys.add(actualizarMatrizContenido);
        ListaParametros.add(listParametrosDTO);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaCRUD(querys, ListaParametros);
        return paqueteDTO;
    }

    public PaqueteDTO insertaJMatrizContenido(int idcontenido, String valor, int tipo, String descripcion) {
        // Lista de parametros para la consulta
        List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
        List<String> querys = new ArrayList<>(0);
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idcontenido));
        listParametrosDTO.add(new ParametrosDTO(2, "String", valor));
        listParametrosDTO.add(new ParametrosDTO(3, "Integer", tipo));
        listParametrosDTO.add(new ParametrosDTO(4, "String", descripcion));
        querys.add(insertaMatrizContenido);
        ListaParametros.add(listParametrosDTO);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaCRUD(querys, ListaParametros);
        return paqueteDTO;
    }

    public PaqueteDTO eliminaJMatrizContenido(int idcontenido) {
        List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
        List<String> querys = new ArrayList<>(0);
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idcontenido));
        querys.add(eliminaMatrizContenido);
        ListaParametros.add(listParametrosDTO);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaCRUD(querys, ListaParametros);
        return paqueteDTO;
    }

    public JMatrizContenidoDTO buscaJMatrizContenidoPorId(int idconfig) {
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idconfig));
        return (JMatrizContenidoDTO) controladorJDBC.procesaSelect(JMatrizContenidoDTO.class, listParametrosDTO, buscaJMatrizTxtPorId).getListResultadoDTO().get(0);
    }

    public PaqueteDTO buscaTodoJMatrizContenido() {
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        return controladorJDBC.procesaSelect(JMatrizContenidoDTO.class, listParametrosDTO, buscaTodoJMatrizTxt);
    }

    public PaqueteDTO buscaJMatrizContenidoSoloPestañaPorPeriodo(String periodo) {
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "String", periodo));
        return controladorJDBC.procesaSelect(JMatrizContenidoDTO.class, listParametrosDTO, buscaJMatrizTxtSoloPestañaPorPeriodo);
    }

    public PaqueteDTO buscaJMatrizContenidoPorIdMatriz(int idmatriz) {
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idmatriz));
        return controladorJDBC.procesaSelect(JMatrizContenidoDTO.class, listParametrosDTO, buscaContenidoPorMatriz);
    }
}
