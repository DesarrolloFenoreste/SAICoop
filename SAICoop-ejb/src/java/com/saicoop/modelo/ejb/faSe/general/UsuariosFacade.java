/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.general.UsuariosDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import com.saicoop.modelo.ejb.util.KitWeb;
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
public class UsuariosFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    String buscaUsuarioPorId = "SELECT * FROM usuarios WHERE idusuario = ?";
    String actualizaPIngreso = "UPDATE usuarios SET pingreso = ? WHERE idusuario = ?";
    String buscaUsuarios = "SELECT * FROM usuarios ORDER BY idusuario ASC";

    KitWeb kitweb = new KitWeb();

    /* -------------------------------------------------------------------------
     * RETORNAN AL CLIENTE
     ------------------------------------------------------------------------- */
    public int actualizaPIngreso(int idusuario, String pingreso) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // TIPO DE HUELLAS REG - registrar
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "String", pingreso));
            listParametrosDTOreg.add(new ParametrosDTO(2, "Integer", idusuario));
            ListaParametros.add(listParametrosDTOreg);
            querys.add(actualizaPIngreso);
            // Ejecutamos el insert o update
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto.getListAfecto().get(0);
        } catch (Exception e) {
            return 0;
        }
    }

    /* -------------------------------------------------------------------------
     * RETORNAN AL DTO
     ------------------------------------------------------------------------- */
    public UsuariosDTO buscaUsuario(int idusuario) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idusuario));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(UsuariosDTO.class, listParametrosDTO, buscaUsuarioPorId);
        return (UsuariosDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

    // BUSCA AL USUARIO CON LA ENTIDAD
    public List<UsuariosDTO> buscaTodosLosUsuarios() {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(UsuariosDTO.class, listParametrosDTO, buscaUsuarios);
        return (List<UsuariosDTO>) paqueteDTO.getListResultadoDTO();
    }

}
