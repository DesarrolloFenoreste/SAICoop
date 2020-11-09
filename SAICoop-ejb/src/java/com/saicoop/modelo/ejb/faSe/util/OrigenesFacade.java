/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.util.OrigenesDTO;
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
public class OrigenesFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    /*
     idorigen integer NOT NULL,
     matriz integer NOT NULL DEFAULT 0,
     nombre character varying(50),
     calle character varying(50),
     numeroext character varying(10),
     numeroint character varying(10),
     telefono1 character varying(15),
     telefono2 character varying(15),
     idestado integer,
     idmunicipio integer,
     idcolonia integer,
     codigopostal character varying(6),
     estatus boolean NOT NULL DEFAULT false,
     fechatrabajo timestamp with time zone NOT NULL DEFAULT now(),
     cta_rendimientos character varying(20),
     cta_quebrantos character varying(20),
     cta_efectivo character varying(20),
     cta_documentos1 character varying(20),
     cta_documentos2 character varying(20),
     cta_documentos3 character varying(20),
     cta_documentos4 character varying(20),
     cta_documentos5 character varying(20),
     enlinea boolean NOT NULL DEFAULT true,
     cta_documentos6 character varying(20),
     cta_documentos7 character varying(20),
     */
    //idorigen,matriz,nombre,calle,numeroext,numeroint,telefono1,telefono2,idestado,idmunicipio,idcolonia,codigopostal,estatus,fechatrabajo,cta_rendimientos,cta_quebrantos,cta_efectivo,cta_documentos1,cta_documentos2,cta_documentos3,cta_documentos4,cta_documentos5,enlinea,cta_documentos6,cta_documentos7
    String buscaTodosLosOrigenes = "SELECT *FROM origenes";
    String buscaOrigenPorIdOrigen = "SELECT *FROM origenes WHERE idorigen=?";

    public OrigenesDTO buscaOrigenes(int idorigen) {
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idorigen));
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(OrigenesDTO.class, listParametrosDTO, buscaOrigenPorIdOrigen);
        return (OrigenesDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

    public List<OrigenesDTO> buscaTodosLosOrigenes() {
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(OrigenesDTO.class, listParametrosDTO, buscaTodosLosOrigenes);
        return (List<OrigenesDTO>) paqueteDTO.getListResultadoDTO();
    }
}
