/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.general.JPersonasBloqueadasDTO;
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
public class JPersonasBloqueadas_HFacade {

    @EJB
    private SaiFunciones saiFunciones;

    @EJB
    private ControladorJDBC controladorJDBC;

    /*
CREATE SEQUENCE idPersonasBloqueadash;
CREATE TABLE j_personasbloqueadas_h (
id		    INTEGER NOT NULL DEFAULT nextval('idPersonasBloqueadash'),
id_doc              CHARACTER VARYING NOT NULL,  
nombre	            CHARACTER VARYING NOT NULL, 
rfc                 CHARACTER VARYING NOT NULL, 
curp	            CHARACTER VARYING NOT NULL, 
idod     	    INTEGER,
fecha	            CHARACTER VARYING NOT NULL,  
fecha_alta_saicoop  timestamp without time zone NOT NULL,
fecha_baja_saicoop  timestamp without time zone NOT NULL,
usuario_baja        INTEGER NOT NULL,
  CONSTRAINT j_personasbloqueadas_h_pkey PRIMARY KEY (id,fecha_baja_saicoop),
  CONSTRAINT j_origen_datos_fkey FOREIGN KEY (idod)
      REFERENCES j_origen_datos (idod) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
COMMENT ON TABLE j_personasbloqueadas_h IS 'en esta tabla es del historial de personas bloqueadas';
     
    Integer id;
    String id_doc;
    String nombre;
    String rfc;
    String curp;
    Integer idod;
    String fecha;
    Object fecha_alta_saicoop;
    Object fecha_baja_saicoop;
    Integer usuario_baja;
     */
 /*inserta en historial lo que este en personas bloqueadas que no este en temporal*/
 /*private static final String insertaPBenHistorialSiNoEstaEnTemporal = "insert into j_personasbloqueadas_h(id_doc,nombre,rfc,curp,idod,fecha,fecha_alta_saicoop,fecha_baja_saicoop,dato1,dato2,dato3,usuario_baja) "
            + "select id_doc,nombre,rfc,curp,idod,fecha,fecha_alta_saicoop,CURRENT_TIMESTAMP,dato1,dato2,dato3,? from j_personasbloqueadas jpb "
            + "where not exists(select null from j_personasbloqueadas_temp jtemp where jpb.idod=jtemp.idod) and jpb.id_doc=jtemp.id_doc and jpb.nombre=jtemp.nombre and jpb.fecha=jtemp.fecha;";*/
    private static final String insertaPBenHistorialSiNoEstaEnTemporal_h = "insert into j_personasbloqueadas_h(id_doc,nombre,rfc,curp,idod,fecha,fecha_alta_saicoop,fecha_baja_saicoop,dato1,dato2,dato3,usuario_baja) "
            + "select id_doc,nombre,rfc,curp,idod,fecha,fecha_alta_saicoop,CURRENT_TIMESTAMP,dato1,dato2,dato3,? from j_personasbloqueadas jpb "
            + "where not exists(select null from j_personasbloqueadas_temp jtemp where jpb.id_doc=jtemp.id_doc and jpb.nombre=jtemp.nombre and jpb.fecha=jtemp.fecha) "
            + "and jpb.idod= any(select distinct idod from j_personasbloqueadas_temp) and jpb.fecha= any(select distinct fecha from j_personasbloqueadas_temp);";

    private static final String insertaJPersonaBloqueada_h = "insert into j_personasbloqueadas_h(id_doc,nombre,rfc,curp,idod,fecha,fecha_alta_saicoop,fecha_baja_saicoop,dato1,dato2,dato3,usuario_baja)values(?,?,?,?,?,?,?::timestamp,?::timestamp,?,?,?,?);";
    private static final String eliminaLPersonaBloqueada = "delete from j_personasbloqueadas where id_doc=? and idod=? and fecha=?;";

    private static final String eliminaTodasLasJPersonasBloqueadas_h = "delete from j_personasbloqueadas_h;";
    private static final String actualizaJPersonaBloqueada_h = "update j_personasbloqueadas_h set nombre=?,rfc=?,curp=?,fecha_alta_saicoop=?,fecha_baja_saicoop=?, dato1=?, dato2=?, dato3=?,usuario_baja=? where id_doc=?,idod=?,fecha=?;";
    private static final String buscaTodasLasJPersonasBloqueadas_h = "select *from j_personasbloqueadas_h;";
    private static final String buscarJPersonaBloqueadaPorIds_h = "select *from j_personasbloqueadas_h where id_doc=? and idod=? and fecha=?;";

    public PaqueteDTO insertaPBenHistorialSiNoEstaEnTemporal(int idusuario) {
        // Lista de parametros para la consulta
        List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idusuario));
        // Ejecuta el proceso
        List<String> querys = new ArrayList<>(0);
        querys.add(insertaPBenHistorialSiNoEstaEnTemporal_h);
        ListaParametros.add(listParametrosDTO);
        return controladorJDBC.procesaCRUD(querys, ListaParametros);
    }

    public JPersonasBloqueadasDTO buscaJPersonasBloqueadasHPorIds(String id_doc, int idod, String fecha) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "String", id_doc));
        listParametrosDTO.add(new ParametrosDTO(2, "Integer", idod));
        listParametrosDTO.add(new ParametrosDTO(3, "String", fecha));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(JPersonasBloqueadasDTO.class, listParametrosDTO, buscarJPersonaBloqueadaPorIds_h);
        return (JPersonasBloqueadasDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

    public PaqueteDTO buscaTodasLasJPersonasBloqueadasH() {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(JPersonasBloqueadasDTO.class, listParametrosDTO, buscaTodasLasJPersonasBloqueadas_h);
        return paqueteDTO;
    }

    public PaqueteDTO JPersonasBloqueadasHInserta(List<JPersonasBloqueadasDTO> lista, int usuario_baja) {
        String fecha_hoy_saicoop = saiFunciones.saiFechaDBTimeStampString();
        PaqueteDTO afecto = null;
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            for (int i = 0; i < lista.size(); i++) {
                JPersonasBloqueadasDTO dto = lista.get(i);
                // Lista de parametros para la consulta
                List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
                // Parametros para la consulta
                listParametrosDTOreg.add(new ParametrosDTO(1, "String", dto.getId_doc()));
                listParametrosDTOreg.add(new ParametrosDTO(2, "String", dto.getNombre()));
                listParametrosDTOreg.add(new ParametrosDTO(3, "String", dto.getRfc()));
                listParametrosDTOreg.add(new ParametrosDTO(4, "String", dto.getCurp()));
                listParametrosDTOreg.add(new ParametrosDTO(5, "Integer", dto.getIdod()));
                listParametrosDTOreg.add(new ParametrosDTO(6, "String", dto.getFecha()));
                listParametrosDTOreg.add(new ParametrosDTO(7, "Object", dto.getFecha_alta_saicoop()));
                listParametrosDTOreg.add(new ParametrosDTO(8, "Object", fecha_hoy_saicoop));
                listParametrosDTOreg.add(new ParametrosDTO(9, "String", dto.getDato1()));
                listParametrosDTOreg.add(new ParametrosDTO(10, "String", dto.getDato2()));
                listParametrosDTOreg.add(new ParametrosDTO(11, "String", dto.getDato3()));
                listParametrosDTOreg.add(new ParametrosDTO(12, "Integer", usuario_baja));
                querys.add(insertaJPersonaBloqueada_h);
                ListaParametros.add(listParametrosDTOreg);
            }
            // Ejecutamos el insert o update
            afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
        } catch (Exception e) {
            if (afecto != null) {
                afecto.setError(afecto.getError() + "\n" + e.getMessage());
            }
        }
        return afecto;
    }

    public PaqueteDTO insertarJPersonasBloqueadasH(String id_doc, String nombre, String rfc, String curp, Integer idod, String fecha, String fecha_alta_saicoop, String dato1, String dato2, String dato3, int usuario_baja) {
        JPersonasBloqueadasDTO dto = buscaJPersonasBloqueadasHPorIds(id_doc, idod, fecha);
        String fecha_hoy_saicoop = saiFunciones.saiFechaDBTimeStampString();
        PaqueteDTO afecto = null;
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOinsertar = new ArrayList<>(0);
            List<ParametrosDTO> listParametrosDTOeliminar = new ArrayList<>(0);
            // Parametros para la consulta
            if (dto == null) {
                //inserta
                listParametrosDTOinsertar.add(new ParametrosDTO(1, "String", id_doc));
                listParametrosDTOinsertar.add(new ParametrosDTO(2, "String", nombre));
                listParametrosDTOinsertar.add(new ParametrosDTO(3, "String", rfc));
                listParametrosDTOinsertar.add(new ParametrosDTO(4, "String", curp));
                listParametrosDTOinsertar.add(new ParametrosDTO(5, "Integer", idod));
                listParametrosDTOinsertar.add(new ParametrosDTO(6, "String", fecha));
                listParametrosDTOinsertar.add(new ParametrosDTO(7, "Object", fecha_alta_saicoop));
                listParametrosDTOinsertar.add(new ParametrosDTO(8, "Object", fecha_hoy_saicoop));
                listParametrosDTOinsertar.add(new ParametrosDTO(9, "String", dato1));
                listParametrosDTOinsertar.add(new ParametrosDTO(10, "String", dato2));
                listParametrosDTOinsertar.add(new ParametrosDTO(11, "String", dato3));
                listParametrosDTOinsertar.add(new ParametrosDTO(12, "Integer", usuario_baja));
                //elimina
                listParametrosDTOeliminar.add(new ParametrosDTO(1, "String", id_doc));
                listParametrosDTOeliminar.add(new ParametrosDTO(2, "Integer", idod));
                listParametrosDTOeliminar.add(new ParametrosDTO(3, "String", fecha));
                querys.add(insertaJPersonaBloqueada_h);
                querys.add(eliminaLPersonaBloqueada);
            }
            ListaParametros.add(listParametrosDTOinsertar);
            ListaParametros.add(listParametrosDTOeliminar);
            // Ejecutamos el insert o update
            afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
        } catch (Exception e) {
            if (afecto != null) {
                afecto.setError(afecto.getError() + "\n" + e.getMessage());
            }
        }
        return afecto;
    }

    public PaqueteDTO eliminaJPersonasBloqueadasHPorId(int id) {
        PaqueteDTO afecto = null;
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", id));
            ListaParametros.add(listParametrosDTOreg);
            querys.add(eliminaTodasLasJPersonasBloqueadas_h);
            // Ejecutamos el insert o update
            afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
        } catch (Exception e) {
            if (afecto != null) {
                afecto.setError(afecto.getError() + "\n" + e.getMessage());
            }
        }
        return afecto;
    }

}
