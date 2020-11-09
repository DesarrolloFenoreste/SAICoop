/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.socio;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.socio.AuxiliaresDDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
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
public class AuxiliaresDFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    String buscarPolizaPorNumero = "SELECT * FROM auxiliares_d WHERE idorigenc = ? AND periodo = ? AND idtipo = ? AND idpoliza = ?";

    public List<AuxiliaresDDTO> buscaAuxiliaresdDTOPorNumeroDPoliza(int idorigenc, String periodo, short idtipo, int idpoliza) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idorigenc));
        listParametrosDTO.add(new ParametrosDTO(2, "String", periodo));
        listParametrosDTO.add(new ParametrosDTO(3, "Integer", idtipo));
        listParametrosDTO.add(new ParametrosDTO(4, "Integer", idpoliza));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(AuxiliaresDDTO.class, listParametrosDTO, buscarPolizaPorNumero);
        return (List<AuxiliaresDDTO>) paqueteDTO.getListResultadoDTO();
    }

}
