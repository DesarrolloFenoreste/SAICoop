/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.general.AdminSesionDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import com.saicoop.modelo.ejb.impl.SaiFunciones;
import com.saicoop.modelo.ejb.util.KitWeb;
import com.saicoop.modelo.ejb.util.ResultSetToDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author gerardo
 */
@Stateless
@LocalBean
public class AdminSesionFacade {

    @EJB
    private ControladorJDBC controladorJDBC;
    @EJB
    private SaiFunciones saiFunciones;

    KitWeb kitweb = new KitWeb();
    ResultSetToDTO resultSetToDTO = new ResultSetToDTO();

    String buscaSesionesPorIsUsuario = "SELECT * FROM j_admin_sesion WHERE idusuario = ?";
    String guardaSesion = "INSERT INTO j_admin_sesion(sesionServidor, ipLocal, ipExterna, macAddress, ipBaseDatos, baseDatos, usuarioSistemaOperativo, sistemaOperativo, versionSistemaOperativo, arquitecturaSistemaOperativo, ultimaentrada, estatus, bloqueado, idusuario) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String actualizaSesion = "UPDATE j_admin_sesion SET sesionServidor = ?, ipLocal = ?, ipExterna = ?, macAddress = ?, ipBaseDatos = ?, baseDatos = ?, usuarioSistemaOperativo = ?, sistemaOperativo = ?, versionSistemaOperativo = ?, arquitecturaSistemaOperativo = ?, ultimaentrada = ?, estatus = ?, bloqueado = ? WHERE idusuario = ?";
    String buscaTodasLasSesiones = "SELECT * FROM j_admin_sesion";
    //private final String buscaPorEstatusYBloqueado = "SELECT *F ROM admin_sesion WHERE estatus=_estatus and bloqueado =_bloqueado";
    String actualizaEstatusSesion = "UPDATE j_admin_sesion SET estatus = ? WHERE idusuario = ?";
    String actualizaBloqueoSesion = "UPDATE j_admin_sesion SET bloqueado = ? WHERE idusuario = ?";

    /* -------------------------------------------------------------------------
     * RETORNAN AL CLIENTE 
     -------------------------------------------------------------------------*/
    // BUSCA AL USUARIO Y PASA LA ENTIDAD A DTO PARA RETORNARLA AL CLIENTE
    public AdminSesionDTO buscaAdminSesionPorUsuario(int idusuario) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idusuario));
        // Ejecuta el proceso
        List<?> paqueteDTO = controladorJDBC.procesaSelect(AdminSesionDTO.class, listParametrosDTO, buscaSesionesPorIsUsuario).getListResultadoDTO();
        return (AdminSesionDTO) paqueteDTO.get(0);
    }

    // BUSCA AL SOCIO Y PASA LA ENTIDAD A DTO PARA RETORNARLA AL CLIENTE
    public List<AdminSesionDTO> buscaAdminSesionTodo() {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(AdminSesionDTO.class, listParametrosDTO, buscaTodasLasSesiones);
        List<?> listHuellasDpUsuarioDTO = paqueteDTO.getListResultadoDTO();
        return (List<AdminSesionDTO>) listHuellasDpUsuarioDTO;
    }

    // INSERTA LA SESION DEL USUARIO
    public int adminSesion(boolean esInserta, int idusuario, String sesionServidor, String ipLocal, String ipExterna, String macAddress, String ipBaseDatos, String baseDatos, String usuarioSistemaOperativo, String sistemaOperativo, String versionSistemaOperativo, String arquitecturaSistemaOperativo) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            // Se agrega el o los querys
            List<String> querys = new ArrayList<>(0);
            // Parametros para la consulta
            List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
            listParametrosDTO.add(new ParametrosDTO(1, "Integer", sesionServidor));
            listParametrosDTO.add(new ParametrosDTO(2, "String", ipLocal));
            listParametrosDTO.add(new ParametrosDTO(3, "String", ipExterna));
            listParametrosDTO.add(new ParametrosDTO(4, "String", macAddress));
            listParametrosDTO.add(new ParametrosDTO(5, "String", ipBaseDatos));
            listParametrosDTO.add(new ParametrosDTO(6, "String", baseDatos));
            listParametrosDTO.add(new ParametrosDTO(7, "String", usuarioSistemaOperativo));
            listParametrosDTO.add(new ParametrosDTO(8, "String", sistemaOperativo));
            listParametrosDTO.add(new ParametrosDTO(9, "String", versionSistemaOperativo));
            listParametrosDTO.add(new ParametrosDTO(10, "String", arquitecturaSistemaOperativo));
            listParametrosDTO.add(new ParametrosDTO(11, "Timestamp", saiFunciones.saiFechaDBTimeStampString()));
            listParametrosDTO.add(new ParametrosDTO(12, "Boolean", true));
            listParametrosDTO.add(new ParametrosDTO(13, "Boolean", false));
            listParametrosDTO.add(new ParametrosDTO(14, "Integer", idusuario));
            ListaParametros.add(listParametrosDTO);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            if (esInserta) {
                querys.add(guardaSesion);
            } else {
                querys.add(actualizaSesion);
            }
            // Ejecuta el INSERT
            Integer afecto = controladorJDBC.procesaCRUD(querys, ListaParametros).getListAfecto().get(0);
            return afecto;
        } catch (Exception e) {
            return 0;
        }
    }

    //estatus boolean NOT NULL DEFAULT true,
    //bloqueado boolean NOT NULL DEFAULT false,
    public int actualizaAdminSesionEstatus(int idusuario, boolean estatus) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            // Se agrega el o los querys
            List<String> querys = new ArrayList<>(0);
            querys.add(actualizaEstatusSesion);
            // Parametros para la consulta
            List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
            listParametrosDTO.add(new ParametrosDTO(1, "Boolean", estatus));
            listParametrosDTO.add(new ParametrosDTO(2, "Integer", idusuario));
            ListaParametros.add(listParametrosDTO);
            // Ejecuta el INSERT
            Integer afecto = controladorJDBC.procesaCRUD(querys, ListaParametros).getListAfecto().get(0);
            return afecto;
        } catch (Exception e) {
            return 0;
        }
    }

    // ACTUALIZA EL BLOQUEO DE LA SESION
    public int actualizaAdminSesionBloqueo(int idusuario, boolean bloqueado) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            // Se agrega el o los querys
            List<String> querys = new ArrayList<>(0);
            querys.add(actualizaBloqueoSesion);
            // Parametros para la consulta
            List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
            listParametrosDTO.add(new ParametrosDTO(1, "Boolean", bloqueado));
            listParametrosDTO.add(new ParametrosDTO(2, "Integer", idusuario));
            ListaParametros.add(listParametrosDTO);
            // Ejecuta el INSERT
            Integer afecto = controladorJDBC.procesaCRUD(querys, ListaParametros).getListAfecto().get(0);
            return afecto;
        } catch (Exception e) {
            return 0;
        }
    }

}
