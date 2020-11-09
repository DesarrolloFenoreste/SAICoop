/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import com.saicoop.modelo.dto.util.TablasDTO;
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
public class TablasFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    String buscaTablaPorIdsTablayElemento = " SELECT * FROM tablas WHERE idtabla = ? AND idelemento = ? and tipo!=2";
    String buscaTablaPorIdTabla = " SELECT * FROM tablas WHERE idtabla = ? and tipo!=2";
    String buscaTodos_los_idtabla = "SELECT DISTINCT idtabla FROM tablas WHERE tipo!=2 ORDER BY idtabla";
    String insertaTabla = "insert into tablas(idtabla,idelemento,nombre,dato1,dato2,dato3,dato4,dato5,tipo) values (?,?,?,?,?,?,?,?,?)";
    String eliminaTabla = "delete from tablas where idtabla=? and idelemento=?";
    String actualizaTabla = "update tablas set nombre = ?, dato1 = ?, dato2 = ?, dato3 = ?, dato4 = ?, dato5 = ?, tipo = ? where idtabla = ? and idelemento = ?";

    /* -------------------------------------------------------------------------
     * RETORNAN AL CLIENTE 
     ------------------------------------------------------------------------ */
    public PaqueteDTO actualizaTabla(String nombre, String dato1, String dato2, String dato3, String dato4, String dato5, int tipo, String idtabla, String idelemento) {
        // Lista de parametros para la consulta
        List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
        List<String> querys = new ArrayList<>(0);
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "String", nombre));
        listParametrosDTO.add(new ParametrosDTO(2, "String", dato1));
        listParametrosDTO.add(new ParametrosDTO(3, "String", dato2));
        listParametrosDTO.add(new ParametrosDTO(4, "String", dato3));
        listParametrosDTO.add(new ParametrosDTO(5, "String", dato4));
        listParametrosDTO.add(new ParametrosDTO(6, "String", dato5));
        listParametrosDTO.add(new ParametrosDTO(7, "Integer", tipo));
        listParametrosDTO.add(new ParametrosDTO(8, "String", idtabla));
        listParametrosDTO.add(new ParametrosDTO(9, "String", idelemento));
        // Ejecuta el proceso
        querys.add(actualizaTabla);
        ListaParametros.add(listParametrosDTO);
        PaqueteDTO paqueteDTO = controladorJDBC.procesaCRUD(querys, ListaParametros);
        return paqueteDTO;
    }

    // BUSCA LA TABLA Y PASA LA ENTIDAD A DTO PARA RETORNARLA AL CLIENTE
    public PaqueteDTO eliminaTabla(String idtabla, String idelemento) {
        List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
        List<String> querys = new ArrayList<>(0);
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "String", idtabla));
        listParametrosDTO.add(new ParametrosDTO(2, "String", idelemento));
        querys.add(eliminaTabla);
        ListaParametros.add(listParametrosDTO);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaCRUD(querys, ListaParametros);
        return paqueteDTO;
    }

    public PaqueteDTO insertaTabla(String idtabla, String idelemento, String nombre, String dato1, String dato2, String dato3, String dato4, String dato5, int tipo) {
        // Lista de parametros para la consulta
        List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
        List<String> querys = new ArrayList<>(0);
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "String", idtabla));
        listParametrosDTO.add(new ParametrosDTO(2, "String", idelemento));
        listParametrosDTO.add(new ParametrosDTO(3, "String", nombre));
        listParametrosDTO.add(new ParametrosDTO(4, "String", dato1));
        listParametrosDTO.add(new ParametrosDTO(5, "String", dato2));
        listParametrosDTO.add(new ParametrosDTO(6, "String", dato3));
        listParametrosDTO.add(new ParametrosDTO(7, "String", dato4));
        listParametrosDTO.add(new ParametrosDTO(8, "String", dato5));
        listParametrosDTO.add(new ParametrosDTO(9, "Integer", tipo));
        querys.add(insertaTabla);
        ListaParametros.add(listParametrosDTO);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaCRUD(querys, ListaParametros);
        return paqueteDTO;
    }

    // BUSCA LA TABLA Y PASA LA ENTIDAD A DTO PARA RETORNARLA AL CLIENTE
    public TablasDTO buscaTabla(String idtabla, String idelemento) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "String", idtabla));
        listParametrosDTO.add(new ParametrosDTO(2, "String", idelemento));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(TablasDTO.class, listParametrosDTO, buscaTablaPorIdsTablayElemento);
        return (TablasDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

    public List<TablasDTO> buscaTablasPorIdTabla(String idtabla) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "String", idtabla));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(TablasDTO.class, listParametrosDTO, buscaTablaPorIdTabla);
        return (List<TablasDTO>) paqueteDTO.getListResultadoDTO();
    }

    public PaqueteDTO buscaTodosLosIdtabla() {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(null, listParametrosDTO, buscaTodos_los_idtabla);

        return paqueteDTO;
    }

}
