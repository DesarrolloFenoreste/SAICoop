/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.general.HuellasDpUsuarioDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import com.saicoop.modelo.ejb.impl.SaiFunciones;
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
public class HuellasDpUsuarioFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    @EJB
    private SaiFunciones saiFunciones;

    KitWeb kitweb = new KitWeb();

    String buscarTadasLasHuellasPorFormato = "SELECT * FROM huellas_dp_usuario WHERE formatohuella = ?";
    String buscarTadasLasHuellasPorUsuarioYFormato = "SELECT * FROM huellas_dp_usuario WHERE idusuario = ? AND formatohuella = ?";
    String guardaHuellaUsuario = "INSERT INTO huellas_dp_usuario(huella0, huella1, huella2, huella3, huella4, huella5, huella6, huella7, huella8, huella9, idusuario, formatohuella) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String actualizaHuellaUsuario = "UPDATE huellas_dp_usuario SET huella0 = ?, huella1 = ?, huella2 = ?, huella3 = ?, huella4 = ?, huella5 = ?, huella6 = ?, huella7 = ?, huella8 = ?, huella9 = ? WHERE idusuario = ? and formatohuella = ?";
    // Detalle
    String guardahuellas_dp_usuario_d = "INSERT INTO huellas_dp_usuario_d(capturo, idusuario, formatohuella, fecha) VALUES(?, ?, ?, ?)";

    /*-------------------------------------------------------------------------
     * RETORNAN AL CLIENTE
     -------------------------------------------------------------------------*/
    // BUSCA TODAS LAS HUELLAS DEL USUARIO Y PASA LA ENTIDAD A DTO PARA RETORNARLA AL CLIENTE
    public List<HuellasDpUsuarioDTO> buscarTodoHuellaUsuario(int formatohuella) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", formatohuella));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(HuellasDpUsuarioDTO.class, listParametrosDTO, buscarTadasLasHuellasPorFormato);
        return (List<HuellasDpUsuarioDTO>) paqueteDTO.getListResultadoDTO();
    }

    // BUSCA LA HUELLA DEL USUARIO Y PASA LA ENTIDAD A DTO PARA RETORNARLA AL CLIENTE
    public HuellasDpUsuarioDTO buscaHuellaUsuario(int idusuario, int formatohuella) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idusuario));
        listParametrosDTO.add(new ParametrosDTO(2, "Integer", formatohuella));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(HuellasDpUsuarioDTO.class, listParametrosDTO, buscarTadasLasHuellasPorUsuarioYFormato);
        System.out.println(paqueteDTO.getListResultadoDTO().size());
        if (paqueteDTO.getListResultadoDTO().size() > 0) {
            return (HuellasDpUsuarioDTO) paqueteDTO.getListResultadoDTO().get(0);
        }
        return new HuellasDpUsuarioDTO();
    }

    // INSERTA O ACTUALIZA LA HUELLA DEL USUARIO
    public boolean huellaDigitalUsuario(boolean esInserta, int idusuarioIngreso, int idusuarioCapturo, List<byte[]> templateREG, List<byte[]> templateVER) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // TIPO DE HUELLAS REG - registrar
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            for (int i = 0; i < templateREG.size(); i++) {
                listParametrosDTOreg.add(new ParametrosDTO(((i + 1)), "Bytes", templateREG.get(i)));
            }
            listParametrosDTOreg.add(new ParametrosDTO(11, "Integer", idusuarioIngreso));
            listParametrosDTOreg.add(new ParametrosDTO(12, "Integer", 0));
            ListaParametros.add(listParametrosDTOreg);
            // TIPO DE HUELLAS VER - Verificacion
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOver = new ArrayList<>(0);
            // Parametros para la consulta
            for (int i = 0; i < templateVER.size(); i++) {
                listParametrosDTOver.add(new ParametrosDTO(((i + 1)), "Bytes", templateVER.get(i)));
            }
            listParametrosDTOver.add(new ParametrosDTO(11, "Integer", idusuarioIngreso));
            listParametrosDTOver.add(new ParametrosDTO(12, "Integer", 1));
            ListaParametros.add(listParametrosDTOver);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            if (esInserta) {
                querys.add(guardaHuellaUsuario);
                querys.add(guardaHuellaUsuario);
            } else {
                querys.add(actualizaHuellaUsuario);
                querys.add(actualizaHuellaUsuario);
            }
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOdetalle = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOdetalle.add(new ParametrosDTO(1, "Integer", idusuarioCapturo));
            listParametrosDTOdetalle.add(new ParametrosDTO(2, "Integer", idusuarioIngreso));
            listParametrosDTOdetalle.add(new ParametrosDTO(3, "Integer", 0));
            listParametrosDTOdetalle.add(new ParametrosDTO(4, "Timestamp", saiFunciones.saiFechaDBTimeStampString()));
            ListaParametros.add(listParametrosDTOdetalle);
            querys.add(guardahuellas_dp_usuario_d);
            // Ejecutamos el insert o update
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return true;
        } catch (Exception e) {
            System.out.println("Error en huellaDigitalUsuario de HuellasDpUsuarioFacade. " + e.getMessage());
            return false;
        }
    }

}
