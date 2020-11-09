/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.util.JMatrizDTO;
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
public class JMatrizFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    /*
 CREATE TABLE j_matriz(
  idmatriz      INTEGER NOT NULL,
  nombre        CHARACTER VARYING NOT NULL,
  filas         INTEGER NOT NULL,
  columnas      INTEGER NOT NULL,
  periodo       CHARACTER VARYING NOT NULL,
  descripcion   CHARACTER VARYING NOT NULL,
  tipo          INTEGER NOT NULL,
  autor         CHARACTER VARYING NOT NULL,
  administrador INTEGER NOT NULL,
  CONSTRAINT j_matriz_pkey PRIMARY KEY (idmatriz)
);
COMMENT ON TABLE j_matriz IS 'contiene plantillas y matrices';  
     */
    private final static String buscaTodasLasMatrices = "select *from j_matriz order by idmatriz;";
    private final static String buscaMatrizPorIdMatriz = "select *from j_matriz where idmatriz=?;";
    private final static String guardaMatriz = "insert into j_matriz(idmatriz,nombre,filas,columnas,periodo,descripcion,tipo,autor,administrador,grupo) values(?,?,?,?,?,?,?,?,?,?);";
    private final static String eliminaMatriz = "delete from j_matriz where idmatriz=?;";
    private final static String actualizaMatriz = "update j_matriz set nombre=?,filas=?,columnas=?,periodo=?,descripcion=?,tipo=?,autor=?,administrador=?,grupo=? where idmatriz=?;";

    public PaqueteDTO actualizaJMatriz(int idmatriz, String nombre, int filas, int columnas, String periodo, String descripcion, int tipo, String autor, int administrador, String grupo) {
        // Lista de parametros para la consulta
        List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
        List<String> querys = new ArrayList<>(0);
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "String", nombre));
        listParametrosDTO.add(new ParametrosDTO(2, "Integer", filas));
        listParametrosDTO.add(new ParametrosDTO(3, "Integer", columnas));
        listParametrosDTO.add(new ParametrosDTO(4, "String", periodo));
        listParametrosDTO.add(new ParametrosDTO(5, "String", descripcion));
        listParametrosDTO.add(new ParametrosDTO(6, "Integer", tipo));
        listParametrosDTO.add(new ParametrosDTO(7, "String", autor));
        listParametrosDTO.add(new ParametrosDTO(8, "Integer", administrador));
        listParametrosDTO.add(new ParametrosDTO(9, "String", grupo));
        listParametrosDTO.add(new ParametrosDTO(10, "Integer", idmatriz));
        querys.add(actualizaMatriz);
        ListaParametros.add(listParametrosDTO);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaCRUD(querys, ListaParametros);
        return paqueteDTO;
    }

    public PaqueteDTO buscaTodasLasJMatrices() {
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        return controladorJDBC.procesaSelect(JMatrizDTO.class, listParametrosDTO, buscaTodasLasMatrices);
    }

    // BUSCA LA TABLA Y PASA LA ENTIDAD A DTO PARA RETORNARLA AL CLIENTE
    public JMatrizDTO buscaJMatrizPorId(int idMatriz) {
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idMatriz));
        List<JMatrizDTO> list = (List<JMatrizDTO>) controladorJDBC.procesaSelect(JMatrizDTO.class, listParametrosDTO, buscaMatrizPorIdMatriz).getListResultadoDTO();
        if (list.isEmpty()) {
            return null;
        } else {
            return (JMatrizDTO) list.get(0);
        }
    }

    public PaqueteDTO insertaJMatriz(int idmatriz, String nombre, int filas, int columnas, String periodo, String descripcion, int tipo, String autor, int administrador, String grupo) {
        // Lista de parametros para la consulta
        List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
        List<String> querys = new ArrayList<>(0);
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idmatriz));
        listParametrosDTO.add(new ParametrosDTO(2, "String", nombre));
        listParametrosDTO.add(new ParametrosDTO(3, "Integer", filas));
        listParametrosDTO.add(new ParametrosDTO(4, "Integer", columnas));
        listParametrosDTO.add(new ParametrosDTO(5, "String", periodo));
        listParametrosDTO.add(new ParametrosDTO(6, "String", descripcion));
        listParametrosDTO.add(new ParametrosDTO(7, "Integer", tipo));
        listParametrosDTO.add(new ParametrosDTO(8, "String", autor));
        listParametrosDTO.add(new ParametrosDTO(9, "Integer", administrador));
        listParametrosDTO.add(new ParametrosDTO(10, "String", grupo));
        querys.add(guardaMatriz);
        ListaParametros.add(listParametrosDTO);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaCRUD(querys, ListaParametros);
        return paqueteDTO;
    }

    public PaqueteDTO eliminaJMatriz(int idmatriz) {
        List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
        List<String> querys = new ArrayList<>(0);
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idmatriz));
        querys.add(eliminaMatriz);
        ListaParametros.add(listParametrosDTO);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaCRUD(querys, ListaParametros);
        return paqueteDTO;
    }
}
