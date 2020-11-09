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
public class JPersonasBloqueadasFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    /*
    *si la tabla de jpersonasbloqueadas esta vacia, inserta a todas las personas bloqueadas de la lista
    *si una persona nueva con el mismo origen ya existe en jpersonasbloqueadas solo actualiza fechas.
    *si una persona nueva con el mimso origen no existe en jpersonasbloqueadas inserta
    *si una persona en jpersonasbloqueadas del mismo origen no esta entre las personas nuevas manda a historial de personas bloqueadas
     */
    //inserta en personas bloqueadas lo que este en temporal y que no este en historial y no este en personas bloqueadas
    private static final String insertarPBTempEnPBsiNoEstanEnHistorialYPB = "insert into j_personasbloqueadas select *from j_personasbloqueadas_temp jtemp where not exists "
            + "(select null from j_personasbloqueadas_h jph where jph.id_doc=jtemp.id_doc and jph.nombre=jtemp.nombre and jph.idod=jtemp.idod and jph.fecha=jtemp.fecha) and not exists "
            + "(select null from j_personasbloqueadas jpb where jpb.id_doc=jtemp.id_doc and jpb.nombre=jtemp.nombre and jpb.idod=jtemp.idod and jpb.fecha=jtemp.fecha);";
    //inserta en historial lo que esta en personas bloqueadas y no este en temporal

    //borra lo que este en personas bloqueadas que este en historial
    private static final String borrarPBsiEstanEnHistorial = "delete from j_personasbloqueadas jpb where exists(select null from j_personasbloqueadas_h jpbh where jpb.id_doc=jpbh.id_doc and jpb.nombre=jpbh.nombre and jpb.idod=jpbh.idod and jpb.fecha=jpbh.fecha);";

    private static final String insertaJPersonaBloqueada = "insert into j_personasbloqueadas(id_doc,nombre,rfc,curp,idod,fecha,fecha_alta_saicoop,dato1,dato2,dato3)values(?,?,?,?,?,?,?::timestamp,?,?,?);";
    private static final String eliminaJPersonaBloqueada = "delete from j_personasbloqueadas where id_doc=? and idod=? and fecha=?;";
    private static final String actualizaJPersonaBloqueada = "update j_personasbloqueadas set id_doc=?,nombre=?,rfc=?,curp=?,idod=?,fecha=?,fecha_alta_saicoop=?, dato1=?, dato2=?, dato3=? where id_doc=? and idod=? and fecha=?;";
    private static final String buscaTodasLasJPersonasBloqueadas = "select *from j_personasbloqueadas order by id_doc,idod,fecha;";
    private static final String buscarJPersonaBloqueadaPorIds = "select *from j_personasbloqueadas where id_doc=? and idod=? and fecha=?;";
    private static final String buscaFechasJPersonasBloqueadasPorIdOd = "select distinct fecha from j_personasbloqueadas where idod=?;";
    private static final String buscaJPersonasBloqueadasPorIdODFecha = "select *from j_personasbloqueadas where idod=? and fecha=?;";
    private static final String buscaJPersonasBloqueadasPorIDDoc = "select *from j_personasbloqueadas where id_doc=?;";

    public PaqueteDTO borrarPBsiEstanEnHistorial() {
        PaqueteDTO afecto = null;
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            ListaParametros.add(listParametrosDTOreg);
            querys.add(borrarPBsiEstanEnHistorial);
            // Ejecutamos el insert o update
            afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
        } catch (Exception e) {
            if (afecto != null) {
                afecto.setError(afecto.getError() + "\n" + e.getMessage());
            }
        }
        return afecto;
    }

    public PaqueteDTO insertarPBTempEnPBsiNoEstanEnHistorialYPB() {
        PaqueteDTO afecto = null;
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            ListaParametros.add(listParametrosDTOreg);
            querys.add(insertarPBTempEnPBsiNoEstanEnHistorialYPB);
            // Ejecutamos el insert o update
            afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
        } catch (Exception e) {
            if (afecto != null) {
                afecto.setError(afecto.getError() + "\n" + e.getMessage());
            }
        }
        return afecto;
    }

    public PaqueteDTO buscaJPersonasBloqueadasPorIdODFecha(Integer idod, String fecha) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idod));
        listParametrosDTO.add(new ParametrosDTO(2, "String", fecha));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(JPersonasBloqueadasDTO.class, listParametrosDTO, buscaJPersonasBloqueadasPorIdODFecha);
        return paqueteDTO;
    }

    public List<JPersonasBloqueadasDTO> buscaJPersonasBloqueadasPorIDDoc(String id_doc) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "String", id_doc));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(null, listParametrosDTO, buscaJPersonasBloqueadasPorIDDoc);
        return (List<JPersonasBloqueadasDTO>) paqueteDTO.getListResultadoDTO();
    }

    public PaqueteDTO buscaFechasDeJPersonasBloqueadasPorIdOD(Integer idod) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idod));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(null, listParametrosDTO, buscaFechasJPersonasBloqueadasPorIdOd);
        return paqueteDTO;
    }

    public JPersonasBloqueadasDTO buscaJPersonasBloqueadasPorIds(String id_doc, Integer idod, String fecha) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "String", id_doc));
        listParametrosDTO.add(new ParametrosDTO(2, "Integer", idod));
        listParametrosDTO.add(new ParametrosDTO(3, "String", fecha));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(JPersonasBloqueadasDTO.class, listParametrosDTO, buscarJPersonaBloqueadaPorIds);
        return (JPersonasBloqueadasDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

    public PaqueteDTO buscaTodasLasJPersonasBloqueadas() {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(JPersonasBloqueadasDTO.class, listParametrosDTO, buscaTodasLasJPersonasBloqueadas);

        return paqueteDTO;
    }

    public PaqueteDTO jPersonasBloqueadasInserta(List<JPersonasBloqueadasDTO> lista) {
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
                querys.add(insertaJPersonaBloqueada);
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

    public PaqueteDTO eliminaJPersonasBloqueadasPorIds(String id_doc, Integer idod, String fecha) {
        PaqueteDTO afecto = null;
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "String", id_doc));
            listParametrosDTOreg.add(new ParametrosDTO(2, "Integer", idod));
            listParametrosDTOreg.add(new ParametrosDTO(3, "String", fecha));
            ListaParametros.add(listParametrosDTOreg);
            querys.add(eliminaJPersonaBloqueada);
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
