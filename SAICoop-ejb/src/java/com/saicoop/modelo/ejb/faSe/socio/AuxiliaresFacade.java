/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.socio;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.socio.AuxiliaresDTO;
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
public class AuxiliaresFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    String buscaAuxiliaresPorIds = "SELECT *FROM auxiliares WHERE idorigen=? AND idgrupo=? AND idsocio=?";

    private final String auxiliaresParaEstadosDeCuenta = ""
            + "SELECT *FROM ("
            + "   SELECT *FROM ("
            + "      SELECT *"
            + "      FROM auxiliares_h auxh "
            + "      INNER JOIN productos prod "
            + "      ON auxh.idproducto=prod.idproducto "
            + "      WHERE estatus=3 "
            + "      AND saldo > 0"
            + "      AND prod.tipoproducto=? ORDER BY auxh.idorigen,auxh.idgrupo,auxh.idsocio) as c  "
            + "   UNION ALL"
            + "   SELECT *FROM ("
            + "      SELECT * "
            + "      FROM auxiliares aux "
            + "      INNER JOIN productos prod "
            + "      ON aux.idproducto=prod.idproducto"
            + "      WHERE aux.estatus=2 or aux.estatus=3 "
            + "      AND saldo > 0"
            + "      AND prod.tipoproducto=? ORDER BY aux.idorigen,aux.idgrupo,aux.idsocio) as t "
            + ") AS x "
            + "WHERE fechauma "
            + "BETWEEN to_date(?,'YYYY-MM-DD') "
            + "AND to_date(?,'YYYY-MM-DD')";

    public List<AuxiliaresDTO> buscaAuxiliaresPorIds(int idorigen, int idgrupo, int idsocio) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idorigen));
        listParametrosDTO.add(new ParametrosDTO(2, "Integer", idgrupo));
        listParametrosDTO.add(new ParametrosDTO(3, "Integer", idsocio));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(AuxiliaresDTO.class, listParametrosDTO, buscaAuxiliaresPorIds);
        return (List<AuxiliaresDTO>) paqueteDTO.getListResultadoDTO();
    }

    public List<AuxiliaresDTO> buscaAuxiliaresParaEstadosDeCuenta(String fechainicial, String fechafinal, String tipo) {
        String query = null;
        if (tipo.equals("prestamo")) {
            query = auxiliaresParaEstadosDeCuenta.replace("AND prod.tipoproducto=?", "AND prod.tipoproducto=2");
        } else if (tipo.equals("dpf")) {
            query = auxiliaresParaEstadosDeCuenta.replace("AND prod.tipoproducto=?", "AND prod.tipoproducto=1 OR  prod.tipoproducto=8");
        } else if (tipo.equals("ahorro")) {
            query = auxiliaresParaEstadosDeCuenta.replace("AND prod.tipoproducto=?", "AND prod.tipoproducto!=1 AND  prod.tipoproducto!=2 AND prod.tipoproducto!=8");
        }
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Date", fechainicial));
        listParametrosDTO.add(new ParametrosDTO(2, "Date", fechafinal));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(AuxiliaresDTO.class, listParametrosDTO, query);
        return (List<AuxiliaresDTO>) paqueteDTO.getListResultadoDTO();
    }
}
