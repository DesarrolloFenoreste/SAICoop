package com.saicoop.modelo.ejb.faSe.catalogo;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.catalogo.ColoniasDTO;
import com.saicoop.modelo.dto.catalogo.CompletoDatoColoniasDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Gerardo Treviño Montelongo
 * @version 1.00.001
 * @fecha 17 de Julio de 2017
 * @descripción: Clase que contiene las sentencias de CRUD de la tabla colonias
 */
@Stateless
@LocalBean
public class ColoniasFacade {

    @EJB
    private ControladorJDBC controladorJDBC;

    // -------------------------------------------------------------------------
    // --- SELECT --------------------------------------------------------------
    String buscaTodasLasColonias = "SELECT * FROM colonias ORDER BY idcolonia ASC";
    String buscaColoniasPorMunicipio = "SELECT * FROM colonias WHERE idmunicipio = ? ORDER BY idcolonia ASC";
    String buscaColonia = "SELECT * FROM colonias WHERE idcolonia = ? LIMIT 1";
    String ultimaColonia = "SELECT * FROM colonias ORDER BY idcolonia DESC LIMIT 1";
    // --- INSERT --------------------------------------------------------------
    String guardaColonia = "INSERT INTO colonias(nombre, idmunicipio, codigopostal, idcolonia) VALUES (?, ?, ?, ?)";
    // --- UPDATE --------------------------------------------------------------
    String actualizaColonia = "UPDATE colonias SET nombre = ?, idmunicipio = ?, codigopostal = ? WHERE idcolonia = ?";
    // --- DELITE --------------------------------------------------------------
    String borraColonia = "DELETE FROM colonias WHERE idcolonia = ?";
    // --- SELECT GENERICO -----------------------------------------------------
    String completoDatoColonia = " SELECT c.idcolonia, c.nombre AS colonia, c.codigopostal, "
            + " m.idmunicipio, m.nombre AS municipio, m.poblacion, m.localidad_siti, m.de_cp, m.a_cp, "
            + " e.idestado, e.nombre AS estado, e.ef, e.idpais "
            + " FROM colonias c "
            + " INNER JOIN municipios m USING (idmunicipio) "
            + " INNER JOIN estados e USING (idestado) "
            + " ORDER BY idestado, idmunicipio, idcolonia ";
    String buscarPorRangoCodigoPostal = " SELECT c.idcolonia, c.nombre AS colonia, c.codigopostal, "
            + " m.idmunicipio, m.nombre AS municipio, m.poblacion, m.localidad_siti, m.de_cp, m.a_cp, "
            + " e.idestado, e.nombre AS estado, e.ef, e.idpais "
            + " FROM colonias c "
            + " INNER JOIN municipios m USING (idmunicipio) "
            + " INNER JOIN estados e USING (idestado) "
            + " WHERE c.codigopostal::INTEGER BETWEEN ? AND ? "
            + " ORDER BY idestado, idmunicipio, idcolonia ";
    // -------------------------------------------------------------------------

    // -------------------------------------------------------------------------
    // --- BUSCA TODAS LAS COLONIAS ORDENADO POR IDCOLONA ----------------------
    // -------------------------------------------------------------------------
    public List<ColoniasDTO> buscarTodasLasColonias() {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(ColoniasDTO.class, listParametrosDTO, buscaTodasLasColonias);
        return (List<ColoniasDTO>) paqueteDTO.getListResultadoDTO();
    }

    // -------------------------------------------------------------------------
    // --- BUSCA LAS COLONIAS POR IDMUNICIPIO ----------------------------------
    // -------------------------------------------------------------------------
    public List<ColoniasDTO> buscarColoniasPorMunicipio(int idmunicipio) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idmunicipio));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(ColoniasDTO.class, listParametrosDTO, buscaColoniasPorMunicipio);
        return (List<ColoniasDTO>) paqueteDTO.getListResultadoDTO();
    }

    // -------------------------------------------------------------------------
    // --- BUSCA LA COLONIA PRO IDCOLONIA --------------------------------------
    // -------------------------------------------------------------------------
    public ColoniasDTO buscarColonia(int idcolonia) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idcolonia));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(ColoniasDTO.class, listParametrosDTO, buscaColonia);
        return (ColoniasDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

    // -------------------------------------------------------------------------
    // --- APLICA EN COLONIAS EL INSERT Y UDPDATE ------------------------------
    // -------------------------------------------------------------------------
    public int coloniasCU(boolean esInserta, int idcolonia, String nombre, int idmunicipio, String codigopostal) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTO.add(new ParametrosDTO(1, "String", nombre));
            listParametrosDTO.add(new ParametrosDTO(2, "Integer", idmunicipio));
            listParametrosDTO.add(new ParametrosDTO(3, "String", codigopostal));
            listParametrosDTO.add(new ParametrosDTO(4, "Integer", idcolonia));
            ListaParametros.add(listParametrosDTO);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            if (esInserta) {
                querys.add(guardaColonia);
            } else {
                querys.add(actualizaColonia);
            }
            // Ejecutamos el insert o update
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto.getListAfecto().get(0);
        } catch (Exception e) {
            return 0;
        }
    }

    // -------------------------------------------------------------------------
    // --- BORRA LA COLONIA EN BASE A UN IDCOLONIA -----------------------------
    // -------------------------------------------------------------------------
    public int borrarColonia(int idcolonia) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // TIPO DE HUELLAS REG - registrar
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", idcolonia));
            ListaParametros.add(listParametrosDTOreg);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            querys.add(borraColonia);
            // Ejecutamos el insert o update
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto.getListAfecto().get(0);
        } catch (Exception e) {
            return 0;
        }
    }

    // -------------------------------------------------------------------------
    // --- RETORNA LA ULTIMA CLONIA AGREGADA -----------------------------------
    // -------------------------------------------------------------------------
    public ColoniasDTO ultimoColonia() {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(ColoniasDTO.class, listParametrosDTO, ultimaColonia);
        return (ColoniasDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

    // -------------------------------------------------------------------------
    // --- GENERICO ------------------------------------------------------------
    // -------------------------------------------------------------------------
    public List<CompletoDatoColoniasDTO> buscarCompletoDatoColonias() {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(CompletoDatoColoniasDTO.class, listParametrosDTO, completoDatoColonia);
        return (List<CompletoDatoColoniasDTO>) paqueteDTO.getListResultadoDTO();
    }

    public List<CompletoDatoColoniasDTO> buscarPorRangoCodigoPostal(int codigoPostalDe, int codigoPostalA) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", codigoPostalDe));
        listParametrosDTO.add(new ParametrosDTO(2, "Integer", codigoPostalA));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(CompletoDatoColoniasDTO.class, listParametrosDTO, buscarPorRangoCodigoPostal);
        return (List<CompletoDatoColoniasDTO>) paqueteDTO.getListResultadoDTO();
    }
    // -------------------------------------------------------------------------
    // -------------------------------------------------------------------------

}
