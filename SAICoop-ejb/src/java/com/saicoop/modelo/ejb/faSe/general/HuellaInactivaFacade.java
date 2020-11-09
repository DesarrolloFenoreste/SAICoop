/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.general.HuellaInactivaDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import com.saicoop.modelo.ejb.impl.SaiFunciones;
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
public class HuellaInactivaFacade {

    @EJB
    private SaiFunciones saiFunciones;

    @EJB
    private ControladorJDBC controladorJDBC;

    /*
    CREATE TABLE huella_inactiva
    (
    idorigen integer NOT NULL,
    idgrupo integer NOT NULL,
    idsocio integer NOT NULL,
    motivo integer NOT NULL DEFAULT 0,
    usuario integer NOT NULL,
    fecha timestamp without time zone NOT NULL,
    CONSTRAINT huella_inactiva_pkey PRIMARY KEY (idorigen, idgrupo, idsocio, fecha),
    CONSTRAINT huella_inactiva_fkey FOREIGN KEY (idorigen, idgrupo, idsocio)
      REFERENCES personas (idorigen, idgrupo, idsocio) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
    )
     */
    private static final String buscaHuellaInactivaPorOGSyFecha = "select *from huella_inactiva where idorigen=? and idgrupo=? and idsocio=? and fecha=? order by desc;";
    private static final String buscaHuellaInactivaPorOGS = "select *from huella_inactiva where idorigen=? and idgrupo=? and idsocio=? order by fecha desc;";
    private static final String insertaHuellaInactiva = "insert into huella_inactiva(idorigen,idgrupo,idsocio,motivo,usuario,fecha) values(?,?,?,?,?,?);";

    public HuellaInactivaDTO buscaHuellaInactivaPorOGSyFecha(Integer idorigen, Integer idgrupo, Integer idsocio, String fecha) {
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idorigen));
        listParametrosDTO.add(new ParametrosDTO(2, "Integer", idgrupo));
        listParametrosDTO.add(new ParametrosDTO(3, "Integer", idsocio));
        listParametrosDTO.add(new ParametrosDTO(4, "Timestamp", fecha));
        return (HuellaInactivaDTO) controladorJDBC.procesaSelect(HuellaInactivaDTO.class, listParametrosDTO, buscaHuellaInactivaPorOGSyFecha).getListResultadoDTO().get(0);
    }

    public PaqueteDTO buscaHuellaInactivaPorOGS(Integer idorigen, Integer idgrupo, Integer idsocio) {
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idorigen));
        listParametrosDTO.add(new ParametrosDTO(2, "Integer", idgrupo));
        listParametrosDTO.add(new ParametrosDTO(3, "Integer", idsocio));
        return controladorJDBC.procesaSelect(HuellaInactivaDTO.class, listParametrosDTO, buscaHuellaInactivaPorOGS);
    }

    public PaqueteDTO insertaHuellaInactiva(Integer idorigen, Integer idgrupo, Integer idsocio, Integer motivo, Integer usuario) {
        System.out.println(saiFunciones.saiFechaDBTimeStampString());
        // Lista de parametros para la consulta
        List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
        List<String> querys = new ArrayList<>(0);
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idorigen));
        listParametrosDTO.add(new ParametrosDTO(2, "String", idgrupo));
        listParametrosDTO.add(new ParametrosDTO(3, "Integer", idsocio));
        listParametrosDTO.add(new ParametrosDTO(4, "Integer", motivo));
        listParametrosDTO.add(new ParametrosDTO(5, "Integer", usuario));
        listParametrosDTO.add(new ParametrosDTO(6, "Timestamp", saiFunciones.saiFechaDBTimeStampString()));
        querys.add(insertaHuellaInactiva);
        ListaParametros.add(listParametrosDTO);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaCRUD(querys, ListaParametros);
        return paqueteDTO;
    }
}
