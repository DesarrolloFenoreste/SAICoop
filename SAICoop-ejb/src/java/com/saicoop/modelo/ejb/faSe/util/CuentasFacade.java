/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.util.CuentasDTO;
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
public class CuentasFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    String buscaTodasLasCuentas = "SELECT * FROM cuentas";
    String buscaCuentaPorIdcuenta = "SELECT * FROM cuentas WHERE idcuenta = ?";

    public List<CuentasDTO> buscaTodasLasCuentas() {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(CuentasDTO.class, listParametrosDTO, buscaTodasLasCuentas);
        List<?> listHuellasDpUsuarioDTO = paqueteDTO.getListResultadoDTO();
        return (List<CuentasDTO>) listHuellasDpUsuarioDTO;
    }

    public CuentasDTO buscaCuentaPorIdCuenta(String idcuenta) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "String", idcuenta));
        // Ejecuta el proceso
        List<?> paqueteDTO = controladorJDBC.procesaSelect(CuentasDTO.class, listParametrosDTO, buscaCuentaPorIdcuenta).getListResultadoDTO();
        return (CuentasDTO) paqueteDTO.get(0);
    }

    public CuentasDTO buscaCuentaPorIdCuentaClaseYTipo(String idcuenta, int clase, int tipo) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "String", idcuenta));
        listParametrosDTO.add(new ParametrosDTO(2, "Integer", clase));
        listParametrosDTO.add(new ParametrosDTO(3, "Integer", tipo));
        // Ejecuta el proceso
        List<?> paqueteDTO = controladorJDBC.procesaSelect(CuentasDTO.class, listParametrosDTO, buscaCuentaPorIdcuenta).getListResultadoDTO();
        return (CuentasDTO) paqueteDTO.get(0);
    }

}
