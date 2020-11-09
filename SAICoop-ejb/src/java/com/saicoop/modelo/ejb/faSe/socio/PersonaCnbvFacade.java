/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.socio;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.socio.PersonaCnbvDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import com.saicoop.modelo.ejb.impl.SaiFunciones;
import com.saicoop.modelo.ejb.util.Control;
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
public class PersonaCnbvFacade {

    @EJB
    private SaiFunciones saiFunciones;

    @EJB
    private ControladorJDBC controladorJDBC;
    /*
    CREATE TABLE j_PersonaCnbv (
  expediente        CHARACTER VARYING NOT NULL, 
  personaId         INTEGER NOT NULL,
  fecha             timestamp without time zone NOT NULL,
  caracter          CHARACTER VARYING NOT NULL, 
  persona           CHARACTER VARYING NOT NULL, 
  paterno           CHARACTER VARYING NOT NULL, 
  materno           CHARACTER VARYING NOT NULL, 
  nombre            CHARACTER VARYING NOT NULL, 
  rfc               CHARACTER VARYING NOT NULL, 
  curp              CHARACTER VARYING NOT NULL, 
  relacion          CHARACTER VARYING NOT NULL, 
  domicilio         CHARACTER VARYING NOT NULL, 
  complementarios   TEXT,
  CONSTRAINT j_PersonaCnbv_pkey PRIMARY KEY (expediente,personaid)
);    
     */
    String buscaTodosLasPersonaCnbv = "SELECT * FROM j_personacnbv ORDER BY fecha ASC";
    String buscaPersonaCnbvPorExpediente = "SELECT * FROM j_personacnbv WHERE expediente = ?";
    String buscaPersonaCnbvPorExpedienteYId = "SELECT * FROM j_personacnbv WHERE expediente = ? and personaid = ?";
    String guardaPersonaCnbv = "INSERT INTO j_personacnbv(expediente,personaId,fecha,caracter,persona,paterno, materno,nombre,rfc,curp,relacion,domicilio,complementarios,xml) "
            + "SELECT ?,?,?,?,?,?,?,?,?,?,?,?,?,? "
            + "WHERE NOT EXISTS("
            + "SELECT expediente,personaId,fecha,caracter,persona,paterno,materno,nombre,rfc,curp,relacion,domicilio,complementarios "
            + "FROM j_personacnbv "
            + "WHERE expediente=? and nombre=? and paterno=? and materno=? and rfc=? and curp=? and domicilio=? and complementarios=?);";

    String actualizaPersonaCnbv = "UPDATE j_personacnbv SET fecha = ? ,caracter = ? ,persona = ? ,paterno = ? , materno = ? ,nombre = ? ,rfc = ? ,curp = ? ,relacion = ? ,domicilio = ? ,complementarios = ?,xml = ?  WHERE expediente = ? and personaid = ?";
    String borraExpedienteCnbv = "DELETE FROM j_personacnbv WHERE expediente = ?";
    String borraPersonaCnbv = "DELETE FROM j_personacnbv WHERE expediente = ? and personaid = ?";

    public List<PersonaCnbvDTO> buscaTodosLasPersonaCnbv() {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(PersonaCnbvDTO.class, listParametrosDTO, buscaTodosLasPersonaCnbv);
        return (List<PersonaCnbvDTO>) paqueteDTO.getListResultadoDTO();
    }

    public List<PersonaCnbvDTO> buscaPersonaCnbvPorExpediente(String expediente) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "String", expediente));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(PersonaCnbvDTO.class, listParametrosDTO, buscaPersonaCnbvPorExpediente);
        return (List<PersonaCnbvDTO>) paqueteDTO.getListResultadoDTO();
    }

    public PersonaCnbvDTO buscaPersonaCnbvPorExpedienteYId(String expediente, int personaid) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "String", expediente));
        listParametrosDTO.add(new ParametrosDTO(2, "Integer", personaid));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(PersonaCnbvDTO.class, listParametrosDTO, buscaPersonaCnbvPorExpedienteYId);
        return (PersonaCnbvDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

    public PaqueteDTO insertaPersonaCnbv(String expediente, int personaid, String caracter, String persona, String paterno, String materno, String nombre, String rfc, String curp, String domicilio, String relacion, String complementarios, Boolean xml) {
        try {
            String fecha = getFechaTrabajoCambiaMilis();
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            querys.add(guardaPersonaCnbv);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTO.add(new ParametrosDTO(1, "String", expediente));
            listParametrosDTO.add(new ParametrosDTO(2, "Integer", personaid));
            listParametrosDTO.add(new ParametrosDTO(3, "Timestamp", fecha));
            listParametrosDTO.add(new ParametrosDTO(4, "String", caracter));
            listParametrosDTO.add(new ParametrosDTO(5, "String", persona));
            listParametrosDTO.add(new ParametrosDTO(6, "String", paterno));
            listParametrosDTO.add(new ParametrosDTO(7, "String", materno));
            listParametrosDTO.add(new ParametrosDTO(8, "String", nombre));
            listParametrosDTO.add(new ParametrosDTO(9, "String", rfc));
            listParametrosDTO.add(new ParametrosDTO(10, "String", curp));
            listParametrosDTO.add(new ParametrosDTO(11, "String", relacion));
            listParametrosDTO.add(new ParametrosDTO(12, "String", domicilio));
            listParametrosDTO.add(new ParametrosDTO(13, "String", complementarios));
            listParametrosDTO.add(new ParametrosDTO(14, "Boolean", xml));
            listParametrosDTO.add(new ParametrosDTO(15, "String", expediente));
            listParametrosDTO.add(new ParametrosDTO(16, "String", nombre));
            listParametrosDTO.add(new ParametrosDTO(17, "String", paterno));
            listParametrosDTO.add(new ParametrosDTO(18, "String", materno));
            listParametrosDTO.add(new ParametrosDTO(19, "String", rfc));
            listParametrosDTO.add(new ParametrosDTO(20, "String", curp));
            listParametrosDTO.add(new ParametrosDTO(21, "String", domicilio));
            listParametrosDTO.add(new ParametrosDTO(22, "String", complementarios));
            ListaParametros.add(listParametrosDTO);
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public PaqueteDTO actualizaPersonaCnbv(String expediente, int personaid, String caracter, String persona, String paterno, String materno, String nombre,  String rfc, String curp, String domicilio, String relacion, String complementarios, Boolean xml) {
        try {
            String fecha = getFechaTrabajoCambiaMilis();
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            querys.add(actualizaPersonaCnbv);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTO.add(new ParametrosDTO(1, "Timestamp", fecha));
            listParametrosDTO.add(new ParametrosDTO(2, "String", caracter));
            listParametrosDTO.add(new ParametrosDTO(3, "String", persona));
            listParametrosDTO.add(new ParametrosDTO(4, "String", paterno));
            listParametrosDTO.add(new ParametrosDTO(5, "String", materno));
            listParametrosDTO.add(new ParametrosDTO(6, "String", nombre));
            listParametrosDTO.add(new ParametrosDTO(7, "String", rfc));
            listParametrosDTO.add(new ParametrosDTO(8, "String", curp));
            listParametrosDTO.add(new ParametrosDTO(9, "String", domicilio));
            listParametrosDTO.add(new ParametrosDTO(10, "String", relacion));
            listParametrosDTO.add(new ParametrosDTO(11, "String", complementarios));
            listParametrosDTO.add(new ParametrosDTO(12, "Boolean", xml));
            listParametrosDTO.add(new ParametrosDTO(13, "String", expediente));
            listParametrosDTO.add(new ParametrosDTO(14, "Integer", personaid));
            ListaParametros.add(listParametrosDTO);
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public PaqueteDTO borraExpedienteCnbv(String expediente, int personaid) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // TIPO DE HUELLAS REG - registrar
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "String", expediente));
            listParametrosDTOreg.add(new ParametrosDTO(2, "Integer", personaid));
            ListaParametros.add(listParametrosDTOreg);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            querys.add(borraPersonaCnbv);
            // Ejecutamos el insert o update
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public PaqueteDTO borraPersonaCnbv(String expediente) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // TIPO DE HUELLAS REG - registrar
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "String", expediente));
            ListaParametros.add(listParametrosDTOreg);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            querys.add(borraExpedienteCnbv);
            // Ejecutamos el insert o update
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    Control c = new Control();

    private String getFechaTrabajoCambiaMilis() {
        String fecha = saiFunciones.saiFechaDBTimeStampString();
        String ns = fecha;
        try {
            int i = (c.randomInt(3) + c.randomInt(3)) / (c.randomInt(1) + 1);
            ns = fecha.split("\\.")[0] + "." + i;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return ns;
    }
}
