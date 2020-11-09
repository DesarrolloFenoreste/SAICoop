/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.socio;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.socio.PersonasDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author prometeo
 */
@Stateless
@LocalBean
public class PersonasFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    String buscaTodasLasPersonas = "SELECT * FROM personas";
    String buscaPersonasPorIdOrigen = "SELECT * FROM personas WHERE idorigen =?";
    String buscaPersonasPorIdGrupo = "SELECT * FROM personas WHERE idgrupo =?";
    String buscaPersonasPorIdSocio = "SELECT * FROM personas WHERE idsocio =?";
    String buscaPersonasPorOG = "SELECT * FROM personas WHERE idorigen =? AND idgrupo =?";
    String buscaPersonasPorOGS = "SELECT * FROM personas WHERE idorigen =? AND idgrupo =? AND idsocio =?";

    //-- Personas fisicas ( NOMBRE COMPLETO )  -------------------------------------------------------------------------------
    String busquedaGeneralFisica = "SELECT *FROM personas WHERE (trim(UPPER(nombre)) = trim(UPPER(?)) AND trim(UPPER(appaterno)) = trim(UPPER(?)) AND trim(UPPER(apmaterno)) = trim(UPPER(?))) "
            + "UNION DISTINCT "
            + "SELECT *FROM personas WHERE (trim(UPPER(nombre)) = trim(UPPER(?)) AND trim(UPPER(appaterno)) = trim(UPPER(?))) "
            + "UNION DISTINCT "
            + "SELECT *FROM personas WHERE (trim(UPPER(nombre)) = trim(UPPER(?)) AND trim(UPPER(apmaterno)) = trim(UPPER(?))) "
            + "UNION DISTINCT "
            + "SELECT *FROM personas WHERE (trim(UPPER(rfc)) = trim(UPPER(?))) "
            + "UNION DISTINCT "
            + "SELECT *FROM personas WHERE (trim(UPPER(curp)) = trim(UPPER(?)));";

    String busquedaGeneralMoral = "SELECT *FROM personas WHERE (trim(UPPER(razon_social)) = trim(UPPER(?))) "
            + "UNION DISTINCT "
            + "SELECT *FROM personas WHERE (trim(UPPER(rfc)) = trim(UPPER(?)));";


    /* -------------------------------------------------------------------------
     * RETORNAN AL CLIENTE 
     ------------------------------------------------------------------------- */
    public List<PersonasDTO> buscaPersonasPorOrigen(int idorigen) {
        //Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idorigen));
        //Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(PersonasDTO.class, listParametrosDTO, buscaPersonasPorIdOrigen);
        return (List<PersonasDTO>) paqueteDTO.getListResultadoDTO();
    }

    public List<PersonasDTO> buscaPersonasPorGrupo(int idgrupo) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idgrupo));
        //Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(PersonasDTO.class, listParametrosDTO, buscaPersonasPorIdGrupo);
        return (List<PersonasDTO>) paqueteDTO.getListResultadoDTO();
    }

    public PersonasDTO buscaPersona(int idorigen, int idgrupo, int idsocio) {
        //Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idorigen));
        listParametrosDTO.add(new ParametrosDTO(2, "Integer", idgrupo));
        listParametrosDTO.add(new ParametrosDTO(3, "Integer", idsocio));
        //Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(PersonasDTO.class, listParametrosDTO, buscaPersonasPorOGS);
        ((PersonasDTO) paqueteDTO.getListResultadoDTO().get(0)).setEmail(escaparCaracterXMLNoValido(((PersonasDTO) paqueteDTO.getListResultadoDTO().get(0)).getEmail()));
        return (PersonasDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

    private boolean yaExiste(List<PersonasDTO> lu, PersonasDTO persona) {
        for (int i = 0; i < lu.size(); i++) {
            PersonasDTO p = lu.get(i);
            if (Objects.equals(p.getIdorigen(), persona.getIdorigen()) && Objects.equals(p.getIdgrupo(), persona.getIdgrupo()) && Objects.equals(p.getIdsocio(), persona.getIdsocio())) {
                return true;
            }
        }
        return false;
    }

    public List<PersonasDTO> buscaPersonaCnbv(String persona, String paterno, String materno, String nombre, String rfc, String curp) {
        if (persona.toLowerCase().equals("fisica")) {
            return buscaPersonasFisicas(nombre, paterno, materno, rfc, curp);
        } else {
            return buscaPersonasMorales(nombre, rfc);
        }
    }

    public List<PersonasDTO> buscaPersonasFisicas(String nombre, String paterno, String materno, String rfc, String curp) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        //1
        listParametrosDTO.add(new ParametrosDTO(1, "String", nombre));
        listParametrosDTO.add(new ParametrosDTO(2, "String", paterno));
        listParametrosDTO.add(new ParametrosDTO(3, "String", materno));
        //2
        listParametrosDTO.add(new ParametrosDTO(4, "String", nombre));
        listParametrosDTO.add(new ParametrosDTO(5, "String", paterno));
        //3
        listParametrosDTO.add(new ParametrosDTO(6, "String", nombre));
        listParametrosDTO.add(new ParametrosDTO(7, "String", materno));
        //4
        listParametrosDTO.add(new ParametrosDTO(8, "String", rfc));
        //5
        listParametrosDTO.add(new ParametrosDTO(9, "String", curp));

        //Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(PersonasDTO.class, listParametrosDTO, busquedaGeneralFisica);
        return (List<PersonasDTO>) paqueteDTO.getListResultadoDTO();
    }

    public List<PersonasDTO> buscaPersonasMorales(String nombre, String rfc) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "String", nombre));
        listParametrosDTO.add(new ParametrosDTO(2, "String", rfc));
        //Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(PersonasDTO.class, listParametrosDTO, busquedaGeneralMoral);
        return (List<PersonasDTO>) paqueteDTO.getListResultadoDTO();
    }
    
    //--------------------------------------------------------------------------
    public String escaparCaracterXMLNoValido(String in) {
        StringBuilder out = new StringBuilder(); // Used to hold the output.
        char current; // Used to reference the current character.

        if (in == null || ("".equals(in))) {
            return ""; // vacancy test.
        }
        for (int i = 0; i < in.length(); i++) {
            current = in.charAt(i); // NOTE: No IndexOutOfBoundsException caught here; it should not happen.
            if ((current == 0x9)
                    || (current == 0xA)
                    || (current == 0xD)
                    || ((current >= 0x20) && (current <= 0xD7FF))
                    || ((current >= 0xE000) && (current <= 0xFFFD))
                    || ((current >= 0x10000) && (current <= 0x10FFFF))) {
                out.append(current);
            }
        }
        return out.toString();
    }
    

}
