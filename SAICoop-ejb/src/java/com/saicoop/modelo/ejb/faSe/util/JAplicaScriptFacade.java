/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.util.JAplicaScriptDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
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
public class JAplicaScriptFacade {

    @EJB
    private ControladorJDBC controladorJDBC;
    /*
    CREATE TABLE j_aplica_script
    (
    idscript                 VARCHAR(50) NOT NULL, 
    idusuario                INTEGER NOT NULL, 
    fecha_aplico             timestamp without time zone NOT NULL,
    autor                    VARCHAR(50) NOT NULL, 
    script                   TEXT, 
    comentario               TEXT,
     */

    private final String buscaAplicaScriptPorId = "SELECT *FROM j_aplica_script WHERE idscript=?;";
    private final String insertaAplicaScript = "INSERT INTO j_aplica_script(idscript,idusuario,fecha_aplico,autor,script,comentario)VALUES(?,?,(SELECT fechatrabajo FROM origenes LIMIT 1),?,?,?);";

    public JAplicaScriptDTO getJAplicaScriptPorId(String idscript) {
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "String", idscript));
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(JAplicaScriptDTO.class, listParametrosDTO, buscaAplicaScriptPorId);
        if (paqueteDTO.getListResultadoDTO().isEmpty()) {
            return null;
        } else {
            return (JAplicaScriptDTO) paqueteDTO.getListResultadoDTO().get(0);
        }
    }

    public int insertaJAplicaScript(String idscript, int idusuario, String autor, String script, String comentario) {
        try {
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "String", idscript));
            listParametrosDTOreg.add(new ParametrosDTO(2, "Integer", idusuario));
            listParametrosDTOreg.add(new ParametrosDTO(3, "String", autor));
            listParametrosDTOreg.add(new ParametrosDTO(4, "String", script));
            listParametrosDTOreg.add(new ParametrosDTO(5, "String", comentario));
            querys.add(insertaAplicaScript);
            ListaParametros.add(listParametrosDTOreg);
            // Ejecutamos el insert o update
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            //System.out.println(afecto.getListAfecto().get(0));
            return afecto.getListAfecto().get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

}
