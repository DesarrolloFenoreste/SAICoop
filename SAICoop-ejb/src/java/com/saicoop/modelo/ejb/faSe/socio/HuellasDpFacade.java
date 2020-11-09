/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.socio;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.socio.HuellasDpDTO;
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
 * @author gerardo
 */
@Stateless
@LocalBean
public class HuellasDpFacade {

    @EJB
    private SaiFunciones saiFunciones;

    @EJB
    private ControladorJDBC controladorJDBC;

    KitWeb kitweb = new KitWeb();


    /* -------------------------------------------------------------------------
     * RETORNAN AL CLIENTE
    ------------------------------------------------------------------------- */
    String buscaHuellaPoprSocio = "SELECT * FROM huellas_dp WHERE idorigen = ? AND idgrupo = ? AND idsocio = ?";
    String buscaTodoEntreLimitYOffset = "SELECT * FROM huellas_dp ORDER BY idorigen, idgrupo, idsocio LIMIT ? OFFSET ?";
    String buscaTodoSinHuellaPorEstatus = "SELECT idorigen, idgrupo, idsocio, dedo FROM huellas_dp INNER JOIN personas p USING (idorigen, idgrupo, idsocio) WHERE p.estatus = ?";
    String guardaHuellaSocio = "INSERT INTO huellas_dp(dedo, huella, idorigen, idgrupo, idsocio) VALUES(?, ?, ?, ?, ?)";
    String actualizaHuellaSocio = "UPDATE huellas_dp SET dedo = ?, huella = ? WHERE idorigen = ? AND idgrupo = ? AND idsocio = ?";
    String guardadetallehuellasSocio = "INSERT INTO huellas_dp_d(idorigen, idgrupo, idsocio, fecha, idusuario, dedo) VALUES(?, ?, ?, ?, ?, ?)";

    // BUSCA AL SOCIO Y PASA LA ENTIDAD A DTO PARA RETORNARLA AL CLIENTE
    public HuellasDpDTO buscarHuellaPorSocio(int idorigen, int idgrupo, int idsocio) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idorigen));
        listParametrosDTO.add(new ParametrosDTO(2, "Integer", idgrupo));
        listParametrosDTO.add(new ParametrosDTO(3, "Integer", idsocio));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(HuellasDpDTO.class, listParametrosDTO, buscaHuellaPoprSocio);
        return (HuellasDpDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

    // BUSCA AL SOCIO CON LA ENTIDAD
    public List<HuellasDpDTO> buscarTodo(int limit, int offset) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", limit));
        listParametrosDTO.add(new ParametrosDTO(2, "Integer", offset));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(HuellasDpDTO.class, listParametrosDTO, buscaTodoEntreLimitYOffset);
        return (List<HuellasDpDTO>) paqueteDTO.getListResultadoDTO();
    }

    // BUSCA AL SOCIO CON LA ENTIDAD
    public List<HuellasDpDTO> buscarTodoSinByte(boolean estatus) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Boolean", estatus));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(HuellasDpDTO.class, listParametrosDTO, buscaTodoSinHuellaPorEstatus);
        return (List<HuellasDpDTO>) paqueteDTO.getListResultadoDTO();
    }

    // INSERTA O ACTUALIZA LA HUELLA DEL SOCIO
    public boolean huellaDigitalSocio(boolean esInserta, int idorigen, int idgrupo, int idsocio, int dedo, byte[] huella, int idusuario) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // TIPO DE HUELLAS REG - registrar
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", dedo));
            listParametrosDTOreg.add(new ParametrosDTO(2, "Bytes", huella));
            listParametrosDTOreg.add(new ParametrosDTO(3, "Integer", idorigen));
            listParametrosDTOreg.add(new ParametrosDTO(4, "Integer", idgrupo));
            listParametrosDTOreg.add(new ParametrosDTO(5, "Integer", idsocio));
            ListaParametros.add(listParametrosDTOreg);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            if (esInserta) {
                querys.add(guardaHuellaSocio);
            } else {
                querys.add(actualizaHuellaSocio);
            }
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOdetalle = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOdetalle.add(new ParametrosDTO(1, "Integer", idorigen));
            listParametrosDTOdetalle.add(new ParametrosDTO(2, "Integer", idgrupo));
            listParametrosDTOdetalle.add(new ParametrosDTO(3, "Integer", idsocio));
            listParametrosDTOdetalle.add(new ParametrosDTO(4, "Timestamp", saiFunciones.saiFechaDBTimeStampString()));
            listParametrosDTOdetalle.add(new ParametrosDTO(5, "Integer", idusuario));
            listParametrosDTOdetalle.add(new ParametrosDTO(6, "Integer", dedo));
            ListaParametros.add(listParametrosDTOdetalle);
            querys.add(guardadetallehuellasSocio);
            // Ejecutamos el insert o update
            controladorJDBC.procesaCRUD(querys, ListaParametros);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
