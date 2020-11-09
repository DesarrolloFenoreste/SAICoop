/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.socio;

import com.saicoop.modelo.dto.socio.PersonasDTO;
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
public class PersonasService {

    @EJB
    private PersonasFacade personasFacade;

    public List<PersonasDTO> buscaPersonasPorOrigen(int idorigen) {
        return personasFacade.buscaPersonasPorOrigen(idorigen);
    }

    public List<PersonasDTO> buscaPersonasPorGrupo(int idgrupo) {
        return personasFacade.buscaPersonasPorGrupo(idgrupo);
    }

    public PersonasDTO buscaPersona(int idorigen, int idgrupo, int idsocio) {
        return personasFacade.buscaPersona(idorigen, idgrupo, idsocio);
    }

    public List<PersonasDTO> buscaPersonaCnbv(String persona, String paterno, String materno, String nombre, String rfc, String curp) {
        return personasFacade.buscaPersonaCnbv(persona, paterno, materno, nombre, rfc, curp);
    }
}
