/*
si personas bloqueadas esta vacia, inserta
si una persona nueva con el mismo origen ya existe en jpersonasbloqueadas solo actualiza fechas.
si una persona nueva con el mimso origen no existe en jpersonasbloqueadas inserta
si una persona en jpersonasbloqueadas del mismo origen no esta entre las personas nuevas manda a historial 

 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.general.JPersonasBloqueadasDTO;
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
public class JPersonasBloqueadasTempFacade {

    /*
    CREATE TABLE j_personasbloqueadas_temp
    (
        id_doc character varying NOT NULL,
        nombre character varying NOT NULL,
        rfc character varying,
        curp character varying,
        idod integer NOT NULL,
        fecha character varying NOT NULL,
        fecha_alta_saicoop timestamp without time zone NOT NULL,
        dato1 character varying,
        dato2 character varying,
        dato3 character varying,
        CONSTRAINT j_personasbloqueadas_temp_pkey PRIMARY KEY (id_doc, nombre, idod, fecha)
    )
    WITH (OIDS=TRUE);
    ALTER TABLE j_personasbloqueadas_temp OWNER TO postgres;
    COMMENT ON TABLE j_personasbloqueadas_temp IS 'en esta tabla que es temporal se encuantran las personas bloqueadas';
     */
    @EJB
    private ControladorJDBC controladorJDBC;

    private static final String insertaJPersonaBloqueadaTemp = "insert into j_personasbloqueadas_temp(id_doc,nombre,rfc,curp,idod,fecha,fecha_alta_saicoop,dato1,dato2,dato3)values(?,?,?,?,?,?,?::timestamp,?,?,?);";
    private static final String eliminaJPersonaBloqueadaTemp = "delete from j_personasbloqueadas_temp where id_doc=?;";
    private static final String eliminaTodoJPersonasBloqueadasTemp = "delete from j_personasbloqueadas_temp;";

    public PaqueteDTO jPersonasBloqueadasInserta(List<JPersonasBloqueadasDTO> lista, String fecha_hoy_saicoop) {
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
                listParametrosDTOreg.add(new ParametrosDTO(8, "String", dto.getDato1()));
                listParametrosDTOreg.add(new ParametrosDTO(9, "String", dto.getDato2()));
                listParametrosDTOreg.add(new ParametrosDTO(10, "String", dto.getDato3()));
                querys.add(insertaJPersonaBloqueadaTemp);
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

    public PaqueteDTO eliminaJPersonasBloqueadasPorId(int id) {
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
            querys.add(eliminaJPersonaBloqueadaTemp);
            // Ejecutamos el insert o update
            afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
        } catch (Exception e) {
            if (afecto != null) {
                afecto.setError(afecto.getError() + "\n" + e.getMessage());
            }
        }
        return afecto;
    }

    public PaqueteDTO eliminaTodoJPersonasBloqueadasTemp() {
        PaqueteDTO afecto = null;
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            ListaParametros.add(listParametrosDTOreg);
            querys.add(eliminaTodoJPersonasBloqueadasTemp);
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
