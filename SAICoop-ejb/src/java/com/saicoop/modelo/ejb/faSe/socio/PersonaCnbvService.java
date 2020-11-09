/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.socio;

import com.saicoop.modelo.dto.socio.PersonaCnbvDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
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
public class PersonaCnbvService {

    @EJB
    private PersonaCnbvFacade personaCnbvFacade;

    public List<PersonaCnbvDTO> buscaTodosLasPersonaCnbv() {
        return personaCnbvFacade.buscaTodosLasPersonaCnbv();
    }

    public List<PersonaCnbvDTO> buscaPersonaCnbvPorExpediente(String expediente) {
        return personaCnbvFacade.buscaPersonaCnbvPorExpediente(expediente);
    }

    public PersonaCnbvDTO buscaPersonaCnbvPorExpedienteYId(String expediente, int personaid) {
        return personaCnbvFacade.buscaPersonaCnbvPorExpedienteYId(expediente, personaid);
    }

    public PaqueteDTO insertaPersonaCnbv(String expediente, int personaid, String caracter, String persona, String paterno, String materno, String nombre, String rfc, String curp, String domicilio, String relacion, String complementarios, Boolean xml) {
        return personaCnbvFacade.insertaPersonaCnbv(expediente, personaid, caracter, persona, paterno, materno, nombre, rfc, curp, domicilio, relacion, complementarios, xml);
    }

    public PaqueteDTO actualizaPersonaCnbv(String expediente, int personaid, String caracter, String persona, String paterno, String materno, String nombre, String rfc, String curp, String domicilio, String relacion, String complementarios, Boolean xml) {
        return personaCnbvFacade.actualizaPersonaCnbv(expediente, personaid, caracter, persona, paterno, materno, nombre, rfc, curp, domicilio, relacion, complementarios, xml);
    }

    public PaqueteDTO borraExpedienteCnbv(String expediente, int personaid) {
        return personaCnbvFacade.borraExpedienteCnbv(expediente, personaid);
    }

    public PaqueteDTO borraPersonaCnbv(String expediente) {
        return personaCnbvFacade.borraPersonaCnbv(expediente);
    }
}
