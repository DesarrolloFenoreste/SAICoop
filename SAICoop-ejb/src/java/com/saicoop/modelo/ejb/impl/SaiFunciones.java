/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.impl;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.general.UsuariosDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import com.saicoop.modelo.dto.util.ResultadoLista;
import com.saicoop.modelo.ejb.faSe.general.JUsuariospermisosFacade;
import com.saicoop.modelo.ejb.faSe.general.UsuariosFacade;
import com.saicoop.modelo.ejb.util.DatosConexion;
import com.saicoop.modelo.ejb.util.KitWeb;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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
public class SaiFunciones {

    @EJB
    private JUsuariospermisosFacade jUsuariospermisosFacade;
    // cambia la codificacion de un campo en una consulta
    //: convert_from(convert(apmaterno::bytea,'ISO_8859_1','UTF8'), 'UTF8')

    @EJB
    public DatosConexion datosConexion;
    @EJB
    private UsuariosFacade usuariosFacade;
    @EJB
    private ControladorJDBC controladorJDBC;

    KitWeb kitweb = new KitWeb();

    // REPORTE DE CONDONACION MASIVA
    private final String sai_condonacion_masiva = "SELECT sai_condonacion_masiva(?, ?, ?)";
    // SAI_ESTATUS_PERSONAS
    private final String sai_estatus_personas = "SELECT * FROM sai_estatus_personas(?)";
    // SAI_TRASÂSA_AHORO_A_PRESTAMOS
    //sai_traspasa_ahorros_a_prestamos_lp(character varying, numeric, integer, text, integer, integer, integer, integer, integer)
    //sai_traspasa_ahorros_a_prestamos_lp(character varying, numeric, integer, text, integer, boolean, integer, integer, integer, integer, integer)
    //sai_traspasa_ahorros_a_prestamos_lp(character varying, numeric, integer, text, integer, boolean, integer, integer, integer, integer, integer, boolean)
    private final String sai_traspasa_ahorros_a_prestamos_lp = "SELECT sai_traspasa_ahorros_a_prestamos_lp(?, ?, -1 , ?, ?, null, 0, ?, ?, ?, ?, ?)";
    // REPORTE DE EVOLUCION DE BANDAS DETALLE
    private final String sai_reporte_de_evolucion_de_bandas_detalle = "SELECT * FROM sai_reporte_de_evolucion_de_bandas_detalle(?, ?)";
    // REPORTE DE EVOLUCION DE BANDAS RESUMEN
    private final String sai_reporte_de_evolucion_de_bandas_resumen = "SELECT * FROM sai_reporte_de_evolucion_de_bandas_resumen(?, ?)";
    // REPORTTE DE CONCENTRACION DE CARTERA
    private final String sai_concentracion_de_cartera = "SELECT * FROM sai_concentracion_de_cartera (?, sai_periodo(Date(?)), ?)";
    // CARTERA VENCIDA
    private final String sai_calcula_carteravencida = "SELECT sai_calcula_carteravencida(Date(?), 1)";
    // REPORTE DE CONCENTRACION DE CAPTACION
    private final String sai_concentracion_de_captacion = "select sai_concentracion_de_captacion(?)";
    // SAI_GENERADOR_DE_POLIZAS CON FECHA
    private final String sai_generador_de_polizas_conFecha = "SELECT sai_generador_de_polizas(?, ?, ?, ?, ?, ?)";
    // SAI_GENERADOR_DE_POLIZAS
    private final String sai_generador_de_polizas = "SELECT sai_generador_de_polizas(?, ?, ?, ?, ?)";
    //IMPORTAR POLIZAS EXTEMPORANEAS  
    //SET client_encoding TO LATIN1;
    private final String sai_importa_polizas_from = "SET client_encoding TO LATIN1;SELECT sai_importa_polizas_from ('/tmp/cuentas_paso_x.txt', '/tmp/polizas_paso.txt', '/tmp/polizas_d_paso.txt');";
    // -------------------------------------------------------------------------
    // EXPORTAR POLIZAS EXTEMPORANEAS
    private final String creaTemporalCuentas = "SELECT * INTO temp cuentas_paso_x FROM cuentas";
    private final String copiaTemporalCuentas_EnArchivo = "COPY cuentas_paso_x TO '/tmp/cuentas_paso_x.txt' DELIMITERS '|'";
    private final String copiaTemporalPolizas_D_EnArchivo = "COPY polizas_d_paso TO '/tmp/polizas_d_paso.txt' DELIMITERS '|'";
    private final String copiaTemporalPolizas_EnArchivo = "COPY polizas_paso TO '/tmp/polizas_paso.txt' DELIMITERS '|'";
    private final String borraTemporalCuentas = "DROP TABLE cuentas_paso_x";
    private final String borraTemporalPolizas = "DROP TABLE polizas_paso";
    private final String borraTemporalPolizas_D = "DROP TABLE polizas_d_paso";
    private final String creaTemporalPolizas_D = "SELECT pd.* INTO temp polizas_d_paso FROM polizas AS p INNER JOIN polizas_d AS pd USING(idorigenc, periodo, idtipo, idpoliza)"
            + "WHERE (p.concepto LIKE '%%<<< POLIZA EXTEMPORANEA >>>%%' OR p.concepto LIKE '%%<<< POLIZA EXTRA EXTEMPORANEA >>>%%') AND periodo = ?";
    private final String creaTemporalPolizas = "SELECT * INTO temp polizas_paso FROM polizas "
            + "WHERE (concepto LIKE '%%<<< POLIZA EXTEMPORANEA >>>%%' OR concepto LIKE '%%<<< POLIZA EXTRA EXTEMPORANEA >>>%%') AND periodo = ?";
    // -------------------------------------------------------------------------
    // REPORTE DE REQUERIMIENTO DE RESERVA RESUMEN
    // Sin considerar garantias 0 y Considerando garantias 1
    private final String requerimientos_reserva_resumen = "SELECT requerimientos_reserva_resumen(?)";
    // REPORTE DE REQUERIMIENTO DE RESERVA DETALLE
    // Considerar garantías para el calculo del reporte 1,0
    // SIN Considerar garantias para el calculo del reporte  0,0
    // El reporte lo envia a archivo en el /home del usuario  0,1
    private final String requerimientos_reserva_detalle = "SELECT requerimientos_reserva_detalle(?,?)";
    //FECHAS DE CARTERA VENCIDA
    private final String listaFechaCarteraVencidaHistorial = "SELECT DISTINCT fechacalculo FROM v_carteravencida_historial ORDER BY fechacalculo DESC";
    // FECHA FORMATO
    private final String fechaBD = "SELECT TRIM(TO_CHAR(CURRENT_TIMESTAMP, 'dd/MM/yyyy HH24:mi:ss.SSS'))";//dd/MM/yyyy HH:mi:ss.MS
    // FECHA DE TRABAJO
    private final String fechaDeTrabajo = "SELECT fechatrabajo FROM origenes LIMIT 1";
    //--AHORROS: -----------------------------------------------------------------------------
    private final String sai_estado_cuenta_ahorros = "select sai_estado_cuenta_ahorros (?,?,?,date(?),date(?),?);";
    //--PRESTAMOS: ----------------------------------------------------------------------------
    private final String sai_estado_cuenta_prestamos = "select sai_estado_cuenta_prestamos (?,?,?,date(?),date(?),?);";
    //--DPF'S: ---------------------------------------------------------------------------------
    private final String sai_estado_cuenta_dpfs_ind = "select sai_estado_cuenta_dpfs_ind (?,?,?,date(?),date(?),?);";
    //--CIERRE ANUAL: --------------------------------------------------------------------------
    private final String sai_cierre_anual = "SELECT sai_cierre_anual (Date(?));";
    //--GENERA SALDOS INICIALES: --------------------------------------------------------------------------
    private final String genera_saldos_iniciales = "SELECT genera_saldos_iniciales (Date(?));";
    //obtener la ip del cliente que se esta conectando
    private final String getDireccionCliente = "select inet_client_addr();";
    //obtener la ip del Servidor
    private final String getDireccionServer = "SELECT inet_server_addr();";
    //obtener elnombre de la base de datos
    private final String getNombreDB = "SELECT current_database();";

    private final String eprcc = "SELECT crea_tabla_temporal_eprcc_2 ((SELECT DISTINCT fechatrabajo FROM origenes)::DATE);";

    public PaqueteDTO ejecutaEPRCC() {
        PaqueteDTO paqueteDTO = new PaqueteDTO();
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            ListaParametros.add(listParametrosDTOreg);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            querys.add(eprcc);
            // Ejecutamos el insert o update
            //la propiedad allowEncodingChanges=true permite el cambio de codificacion indicada con el SET client_encoding TO LATIN1;(cuando se utiliza el COPY)
            controladorJDBC.procesaFUNCTION(querys, ListaParametros, "");
            return paqueteDTO;
        } catch (Exception e) {
            String error = "Error en ejecutaEPRCC de SaiFunciones.";
            paqueteDTO.setError(error + e.getMessage());
            return paqueteDTO;
        }
    }
    public PaqueteDTO generaSaldosIniciales() {
        PaqueteDTO paqueteDTO = new PaqueteDTO();
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "String", saiFechaTrabajo()));
            ListaParametros.add(listParametrosDTOreg);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            querys.add(genera_saldos_iniciales);
            // Ejecutamos el insert o update
            paqueteDTO = controladorJDBC.procesaFUNCTION(querys, ListaParametros, "");
        } catch (Exception e) {
            String error = "Error en generaSaldosIniciales de SaiFunciones.";
            paqueteDTO.setError(error + e.getMessage());
        }
        return paqueteDTO;
    }

    public PaqueteDTO cierreAnual() {
        PaqueteDTO paqueteDTO = new PaqueteDTO();
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "String", saiFechaTrabajo()));
            ListaParametros.add(listParametrosDTOreg);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            querys.add(sai_cierre_anual);
            // Ejecutamos el insert o update
            paqueteDTO = controladorJDBC.procesaFUNCTION(querys, ListaParametros, "");
        } catch (Exception e) {
            String error = "Error en cierreAnual de SaiFunciones.";
            paqueteDTO.setError(error + e.getMessage());
        }
        return paqueteDTO;
    }

    public PaqueteDTO estadoDeCuentas(int idorigenp, int idproducto, int idauxiliar, String fecha_ini, String fecha_fin, String tipo) {
        String funcion = "";

        //formato_estado_cuenta_dpfs_ind
        //xml_estado_cuenta_dpfs_ind
        //formato_estado_cuenta_ahorros
        //xml_estado_cuenta_ahorros
        //formato_estado_cuenta_prestamo
        //xml_estado_cuenta_prestamos
        if (tipo.contains("ahorro")) {
            funcion = sai_estado_cuenta_ahorros;
        } else if (tipo.contains("prestamo")) {
            funcion = sai_estado_cuenta_prestamos;
        } else if (tipo.contains("dpfs")) {
            funcion = sai_estado_cuenta_dpfs_ind;
        }
        PaqueteDTO paqueteDTO = new PaqueteDTO();
        try {
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", idorigenp));
            listParametrosDTOreg.add(new ParametrosDTO(2, "Integer", idproducto));
            listParametrosDTOreg.add(new ParametrosDTO(3, "Integer", idauxiliar));
            listParametrosDTOreg.add(new ParametrosDTO(4, "String", fecha_ini));
            listParametrosDTOreg.add(new ParametrosDTO(5, "String", fecha_fin));
            listParametrosDTOreg.add(new ParametrosDTO(6, "String", tipo));
            paqueteDTO = controladorJDBC.procesaSelect(null, listParametrosDTOreg, funcion);
        } catch (Exception e) {
            String error = "Error en reporteDeConcentracionDeCaptacion de SaiFunciones.";
            paqueteDTO.setError(error + e.getMessage());
        }
        return paqueteDTO;
    }
    // -------------------------------------------------------------------------
    // --- EJECUTA LA FUNCION SAI_CONCENTRACION_DE_CAPTACION -------------------
    // -------------------------------------------------------------------------

    public PaqueteDTO reporteDeConcentracionDeCaptacion(int valor) {
        PaqueteDTO paqueteDTO = new PaqueteDTO();
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", valor));
            ListaParametros.add(listParametrosDTOreg);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            querys.add(sai_concentracion_de_captacion);
            // Ejecutamos el insert o update
            paqueteDTO = controladorJDBC.procesaFUNCTION(querys, ListaParametros, "");
        } catch (Exception e) {
            String error = "Error en reporteDeConcentracionDeCaptacion de SaiFunciones.";
            paqueteDTO.setError(error + e.getMessage());
        }
        return paqueteDTO;
    }

    // -------------------------------------------------------------------------
    // --- EJECUTA LA FUNCION SAI_REQUERIMIENTO_RESERVA_RESUMEN ----------------
    // -------------------------------------------------------------------------
    public PaqueteDTO reporteDeRequerimientosDeReserva(String tipo, String valor) {
        PaqueteDTO paqueteDTO = new PaqueteDTO();
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            if (tipo.equals("detalle")) {
                // Parametros para la consulta
                listParametrosDTO.add(new ParametrosDTO(1, "Integer", Integer.parseInt(valor.split(",")[0])));
                listParametrosDTO.add(new ParametrosDTO(2, "Integer", Integer.parseInt(valor.split(",")[1])));
                querys.add(requerimientos_reserva_detalle);
            } else {
                // Parametros para la consulta
                listParametrosDTO.add(new ParametrosDTO(1, "Integer", Integer.parseInt(valor)));
                querys.add(requerimientos_reserva_resumen);
            }
            ListaParametros.add(listParametrosDTO);
            // Ejecutamos el insert o update
            paqueteDTO = controladorJDBC.procesaFUNCTION(querys, ListaParametros, "");
        } catch (Exception e) {
            String error = "Error en reporteDeRequerimientosDeReserva de SaiFunciones.";
            paqueteDTO.setError(error + e.getMessage());
        }
        return paqueteDTO;
    }

    // -------------------------------------------------------------------------
    // --- EJECUTA LA FUNCION SAI_REPORTE_DE_EVOLUCION_DE_BANDAS RESUMEN-DETALLE
    // -------------------------------------------------------------------------
    public PaqueteDTO reporteDeEvolucionDeBandas(String tipo, String fechainicial, String fechafinal) {
        PaqueteDTO paqueteDTO = new PaqueteDTO();
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "String", fechainicial));
            listParametrosDTOreg.add(new ParametrosDTO(2, "String", fechafinal));
            ListaParametros.add(listParametrosDTOreg);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            if (tipo.equals("resumido")) {
                querys.add(sai_reporte_de_evolucion_de_bandas_resumen);
            } else {
                querys.add(sai_reporte_de_evolucion_de_bandas_detalle);
            }
            // Ejecutamos el insert o update
            paqueteDTO = controladorJDBC.procesaFUNCTION(querys, ListaParametros, "");
        } catch (Exception e) {
            String error = "Error en reporteDeEvolucionDeBandas de SaiFunciones.";
            paqueteDTO.setError(error + e.getMessage());
        }
        return paqueteDTO;
    }

    // -------------------------------------------------------------------------
    // --- EJECUTA LA FUNCION SAI_CALCULA_CARTERAVENCIDA -----------------------
    // -------------------------------------------------------------------------
    public PaqueteDTO generacionDeCarteraVencida() {
        PaqueteDTO paqueteDTO = new PaqueteDTO();
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "String", saiFechaTrabajo()));
            ListaParametros.add(listParametrosDTOreg);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            querys.add(sai_calcula_carteravencida);
            // Ejecutamos el insert o update
            paqueteDTO = controladorJDBC.procesaFUNCTION(querys, ListaParametros, "");
        } catch (Exception e) {
            String error = "Error en generacionDeCarteraVencida de SaiFunciones.";
            paqueteDTO.setError(error + e.getMessage());
        }
        return paqueteDTO;
    }

    // -------------------------------------------------------------------------
    // --- EJECUTA LA FUNCION SAI_CONCENTRACION_DE_CARTERA ---------------------
    // -------------------------------------------------------------------------
    public PaqueteDTO reporteConcentracionDeCartera(int concentrado, String fecha, String tipos) {
        PaqueteDTO paqueteDTO = new PaqueteDTO();
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", concentrado));
            listParametrosDTOreg.add(new ParametrosDTO(2, "String", fecha));
            listParametrosDTOreg.add(new ParametrosDTO(3, "String", tipos));
            ListaParametros.add(listParametrosDTOreg);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            querys.add(sai_concentracion_de_cartera);
            // Ejecutamos el insert o update
            paqueteDTO = controladorJDBC.procesaFUNCTION(querys, ListaParametros, "");
        } catch (Exception e) {
            String error = "Error en reporteDeEvolucionDeBandas de SaiFunciones.";
            paqueteDTO.setError(error + e.getMessage());
        }
        return paqueteDTO;
    }

    // -------------------------------------------------------------------------
    // --- LISTADO DE FECHAS DE CARTERA VENCIDA TOTAL --------------------------
    // -------------------------------------------------------------------------
    public List<ResultadoLista> listaFechaCarteraVencidaHistorial() {
        PaqueteDTO paqueteDTO = new PaqueteDTO();
        try {
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
            // Ejecuta el proceso
            paqueteDTO = controladorJDBC.procesaSelect(null, listParametrosDTO, listaFechaCarteraVencidaHistorial);
        } catch (Exception e) {
            String error = "Error en saiFechasCalculoV_CarteraVencidaH de SaiFunciones.";
            paqueteDTO.setError(error + e.getMessage());
        }
        return paqueteDTO.getListResultadoLista();
    }

    // -------------------------------------------------------------------------
    // --- EXPORTAR POLIZAS EXTEMPORANEAS --------------------------------------
    // -------------------------------------------------------------------------
    public int exportarPolizasExtemporaneas(String periodo) {
        PaqueteDTO paqueteDTO = new PaqueteDTO();
        try {
            // Lista de parametros y querys a ejecutar -------------------------
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            //------------------------------------------------------------------
            // Lista de parametros para la consulta
            ListaParametros.add(new ArrayList<>(0));
            // Dependiendo si es insert o update se ejecuta la cosnulta
            querys.add(creaTemporalCuentas);
            //------------------------------------------------------------------
            // Lista de parametros para la consulta
            ListaParametros.add(new ArrayList<>(0));
            // Dependiendo si es insert o update se ejecuta la cosnulta
            querys.add(copiaTemporalCuentas_EnArchivo);
            //------------------------------------------------------------------
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosPolizasD = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosPolizasD.add(new ParametrosDTO(1, "String", periodo));
            ListaParametros.add(listParametrosPolizasD);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            querys.add(creaTemporalPolizas_D);
            //------------------------------------------------------------------
            // Lista de parametros para la consulta
            ListaParametros.add(new ArrayList<>(0));
            // Dependiendo si es insert o update se ejecuta la cosnulta
            querys.add(copiaTemporalPolizas_D_EnArchivo);
            //------------------------------------------------------------------
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosPolizas = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosPolizas.add(new ParametrosDTO(1, "String", periodo));
            ListaParametros.add(listParametrosPolizas);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            querys.add(creaTemporalPolizas);
            //------------------------------------------------------------------
            // Lista de parametros para la consulta
            ListaParametros.add(new ArrayList<>(0));
            // Dependiendo si es insert o update se ejecuta la cosnulta
            querys.add(copiaTemporalPolizas_EnArchivo);
            //------------------------------------------------------------------
            // Lista de parametros para la consulta
            ListaParametros.add(new ArrayList<>(0));
            // Dependiendo si es insert o update se ejecuta la cosnulta
            querys.add(borraTemporalCuentas);
            //------------------------------------------------------------------
            // Lista de parametros para la consulta
            ListaParametros.add(new ArrayList<>(0));
            // Dependiendo si es insert o update se ejecuta la cosnulta
            querys.add(borraTemporalPolizas);
            //------------------------------------------------------------------
            // Lista de parametros para la consulta
            ListaParametros.add(new ArrayList<>(0));
            // Dependiendo si es insert o update se ejecuta la cosnulta
            querys.add(borraTemporalPolizas_D);
            //------------------------------------------------------------------
            // Ejecutamos el insert o update
            controladorJDBC.procesaFUNCTION(querys, ListaParametros, "");
            return 1;
        } catch (Exception e) {
            String error = "Error en exportarPolizasExtemporaneas de SaiFunciones.";
            paqueteDTO.setError(error + e.getMessage());
        }
        return 0;
    }

    // -------------------------------------------------------------------------
    // --- IMPORTAR POLIZAS EXTEMPORANEAS --------------------------------------
    // -------------------------------------------------------------------------
    public int ImportarPolizasExtemporaneas() {
        PaqueteDTO paqueteDTO = new PaqueteDTO();
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            ListaParametros.add(listParametrosDTOreg);
            // Dependiendo si es insert o update se ejecuta la cosnulta
            querys.add(sai_importa_polizas_from);
            // Ejecutamos el insert o update
            //la propiedad allowEncodingChanges=true permite el cambio de codificacion indicada con el SET client_encoding TO LATIN1;(cuando se utiliza el COPY)
            controladorJDBC.procesaFUNCTION(querys, ListaParametros, "allowEncodingChanges=true&");
            return 1;
        } catch (Exception e) {
            String error = "Error en ImportarPolizasExtemporaneas de SaiFunciones.";
            paqueteDTO.setError(error + e.getMessage());
            return 0;
        }
    }

    // -------------------------------------------------------------------------
    // --- EJECUTA LA FUNCION SAI_TRASPASA_AHORRO_A_PRESTAMO_LP ----------------
    // -------------------------------------------------------------------------
    public PaqueteDTO liquidacionMasivaDePrestamos(String cuentaContable, BigDecimal montoLimite, String nomArch, int idorigen, int idProductoDeudor, int idProductoAcredor, int limitediasVencidos, int limiteDiasSinMovimientos, boolean abonar) {
        PaqueteDTO paqueteDTO = new PaqueteDTO();
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOdetalle = new ArrayList<>(0);
            // Parametros para la consulta
            //SELECT sai_traspasa_ahorros_a_prestamos_lp('10402070201015', 0.00, -1 , '/tmp/prestamos.csv', 31501, null, 0, 60001, 70001, 0, 0, false)
            //                                                   ?         ?       -1     ?        ?     null        0        ?        ?        ?        ?        ?
            //sai_traspasa_ahorros_a_prestamos_lp(character varying, numeric, integer, text, integer, boolean, integer, integer, integer, integer, integer, boolean)
            //SELECT sai_traspasa_ahorros_a_prestamos_lp(?, ?, -1 , ?, ?, null, 0, ?, ?, ?, ?, ?)
            listParametrosDTOdetalle.add(new ParametrosDTO(1, "String", cuentaContable));//character varying
            listParametrosDTOdetalle.add(new ParametrosDTO(2, "Object", montoLimite));//numeric
            listParametrosDTOdetalle.add(new ParametrosDTO(3, "String", nomArch));//text
            listParametrosDTOdetalle.add(new ParametrosDTO(4, "Integer", idorigen));//integer
            listParametrosDTOdetalle.add(new ParametrosDTO(5, "Integer", idProductoDeudor));//integer
            listParametrosDTOdetalle.add(new ParametrosDTO(6, "Integer", idProductoAcredor));//integer
            listParametrosDTOdetalle.add(new ParametrosDTO(7, "Integer", limitediasVencidos));//integer
            listParametrosDTOdetalle.add(new ParametrosDTO(8, "Integer", limiteDiasSinMovimientos));//integer
            listParametrosDTOdetalle.add(new ParametrosDTO(9, "Object", abonar));//boolean
            ListaParametros.add(listParametrosDTOdetalle);
            querys.add(sai_traspasa_ahorros_a_prestamos_lp);
            // Ejecutamos el insert o update
            paqueteDTO = controladorJDBC.procesaFUNCTION(querys, ListaParametros, "");
        } catch (Exception e) {
            String error = "Error en liquidacionMasivaDePrestamos de SaiFunciones.";
            paqueteDTO.setError(error + e.getMessage());
        }
        return paqueteDTO;
    }

    // -------------------------------------------------------------------------
    // --- EJECUTA LA FUNCION SAI_GENERADOR_DE_POLIZAS -------------------------
    // -------------------------------------------------------------------------
    public PaqueteDTO generacionDePolizas(Integer idusuario, boolean esResumen, String concepto, String nomArchivo, String fecha) {
        PaqueteDTO paqueteDTO = new PaqueteDTO();
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOdetalle = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOdetalle.add(new ParametrosDTO(1, "Integer", idusuario));
            listParametrosDTOdetalle.add(new ParametrosDTO(2, "String", datosConexion.getIdSesion()));
            listParametrosDTOdetalle.add(new ParametrosDTO(3, "Boolean", esResumen));
            listParametrosDTOdetalle.add(new ParametrosDTO(4, "String", concepto));
            listParametrosDTOdetalle.add(new ParametrosDTO(5, "String", nomArchivo));
            boolean b = jUsuariospermisosFacade.permisos(idusuario, "o_cambio_fecha_generacion_poliza");
            if (!fecha.isEmpty()) {
                if (b == true) {
                    listParametrosDTOdetalle.add(new ParametrosDTO(6, "Date", fecha));
                    querys.add(sai_generador_de_polizas_conFecha);
                }
            } else {
                querys.add(sai_generador_de_polizas);
            }
            // Ejecutamos el insert o update
            ListaParametros.add(listParametrosDTOdetalle);
            paqueteDTO = controladorJDBC.procesaFUNCTION(querys, ListaParametros, "");
        } catch (Exception e) {
            String error = "Error en generacionDePolizas de SaiFunciones.";
            paqueteDTO.setError(error + e.getMessage());
        }
        return paqueteDTO;
    }

    // -------------------------------------------------------------------------
    // --- EJECUTA LA FUNCION SAI_CONDONACION_MASIVA ---------------------------
    // -------------------------------------------------------------------------
    // --- select sai_condonacion_masiva (20199,'/tmp/condonacion01.txt',999)
    public PaqueteDTO condonacionMasiva(int idusuario, String nomArch) {
        PaqueteDTO paqueteDTO = new PaqueteDTO();
        try {
            UsuariosDTO usuariosDTO = usuariosFacade.buscaUsuario(idusuario);
            if (usuariosDTO.getIdorigen() != null) {
                // Lista de parametros y querys a ejecutar
                List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
                List<String> querys = new ArrayList<>(0);
                // Lista de parametros para la consulta
                List<ParametrosDTO> listParametrosDTOdetalle = new ArrayList<>(0);
                // Parametros para la consulta
                listParametrosDTOdetalle.add(new ParametrosDTO(1, "Integer", usuariosDTO.getIdorigen()));
                listParametrosDTOdetalle.add(new ParametrosDTO(2, "String", nomArch));
                listParametrosDTOdetalle.add(new ParametrosDTO(3, "Integer", idusuario));
                ListaParametros.add(listParametrosDTOdetalle);
                querys.add(sai_condonacion_masiva);
                // Ejecutamos el insert o update
                paqueteDTO = controladorJDBC.procesaFUNCTION(querys, ListaParametros, "");
            } else {
                paqueteDTO.setError("Error no existe el usuario");
            }
        } catch (Exception e) {
            String error = "Error en condonacionMasiva de SaiFunciones.";
            paqueteDTO.setError(error + e.getMessage());
        }
        return paqueteDTO;
    }

    // -------------------------------------------------------------------------
    // --- EJECUTA LA FUNCION SAI_ESTATUS_PERSONAS -----------------------------
    // -------------------------------------------------------------------------
    //SELECT TRIM(TO_CHAR(idorigen,'099999'))||'-'||idgrupo||'-'||TRIM(TO_CHAR(idsocio,'09999999')) AS socio,nombre_x(appaterno,apmaterno,nombre) AS nombre_socio  FROM sai_estatus_personas(10);
    public PaqueteDTO inactivaPersonasPorGrupo(int idgrupo) {
        PaqueteDTO paqueteDTO = new PaqueteDTO();
        try {
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTO.add(new ParametrosDTO(1, "Integer", idgrupo));
            // Ejecuta el proceso
            paqueteDTO = controladorJDBC.procesaSelect(null, listParametrosDTO, sai_estatus_personas);
        } catch (Exception e) {
            String error = "Error en inactivaPersonasPorGrupo de SaiFunciones.";
            paqueteDTO.setError(error + e.getMessage());
        }
        return paqueteDTO;
    }

    // -------------------------------------------------------------------------
    // --- FECHA DE LA BASE DE DATOS -------------------------------------------
    // SELECT TRIM(TO_CHAR(current_timestamp, 'dd/mm/yyyy HH12:mi:ss.SS'))";
    // SELECT TRIM(TO_CHAR(current_timestamp, 'dd/mm/yyyy HH24:mi:ss.SS'))";
    // -------------------------------------------------------------------------
    public Date saiFechaDBTimeStamp() {
        try {
            return kitweb.formatterFechaHora.parse(saiFechaDBTimeStampString());
        } catch (ParseException | NullPointerException ex) {
            System.out.println("Error en saiFechaDBTimeStamp de SaiFunciones." + ex.getMessage());
            return null;
        }
    }

    public String saiFechaDBTimeStampString() {
        try {
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
            // Ejecuta el proceso
            PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(null, listParametrosDTO, fechaBD);
            String fecha = paqueteDTO.getListResultadoLista().get(2).getResultadoLista().get(0);
            return fecha;
        } catch (Exception ex) {
            System.out.println("Error en saiFechaDBTimeStampString de SaiFunciones." + ex.getMessage());
            return null;
        }
    }

    // -------------------------------------------------------------------------
    // --- FECHA DE ORIGENES ---------------------------------------------------
    // -------------------------------------------------------------------------
    public String saiFechaTrabajo() {
        try {
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
            // Ejecuta el proceso
            PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(null, listParametrosDTO, fechaDeTrabajo);
            String fecha = paqueteDTO.getListResultadoLista().get(2).getResultadoLista().get(0);
            return fecha;
        } catch (NullPointerException ex) {
            System.out.println("Error en saiFechaTrabajo de SaiFunciones." + ex.getMessage());
            return null;
        }
    }

    public String getIPCliente() {
        try {
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
            // Ejecuta el proceso
            PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(null, listParametrosDTO, getDireccionCliente);
            String fecha = paqueteDTO.getListResultadoLista().get(2).getResultadoLista().get(0);
            return fecha;
        } catch (NullPointerException ex) {
            System.out.println("Error en getIPCliente( de SaiFunciones." + ex.getMessage());
            return null;
        }
    }

    public String getIPServidor() {
        try {
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
            // Ejecuta el proceso
            PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(null, listParametrosDTO, getDireccionServer);
            String fecha = paqueteDTO.getListResultadoLista().get(2).getResultadoLista().get(0);
            return fecha;
        } catch (NullPointerException ex) {
            System.out.println("Error en getIPServidor de SaiFunciones." + ex.getMessage());
            return null;
        }
    }

    public String getNombreDB() {
        try {
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
            // Ejecuta el proceso
            PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(null, listParametrosDTO, getNombreDB);
            String fecha = paqueteDTO.getListResultadoLista().get(2).getResultadoLista().get(0);
            return fecha;
        } catch (NullPointerException ex) {
            System.out.println("Error en getNombreDB de SaiFunciones." + ex.getMessage());
            return null;
        }
    }
}
/*private final String getPeriodos = "select distinct periodo from auxiliares_d order by periodo desc limit ?;";

    private final String getPeriodosMatriz = "select distinct periodo from j_matriz_pld order by periodo;";
    select (select nombre from j_matriz_pld_txt where idconfig=?) as pestaña,config.ubicacion,config.periodo,config.tipo,txt.nombre,txt.descripcion,config.editable 
    from j_matriz_pld_txt txt
    inner join j_matriz_pld_config config 
    on config.valor=txt.idconfig
    where config.periodo=? and config.idconfig=?;
    
    public PaqueteDTO getPeriodosMatriz() {
        PaqueteDTO paqueteDTO = new PaqueteDTO();
        try {
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            paqueteDTO = controladorJDBC.procesaSelect(null, listParametrosDTOreg, getPeriodosMatriz);
        } catch (Exception e) {
            String error = "Error en getPeriodosMatriz de SaiFunciones.";
            paqueteDTO.setError(error + e.getMessage());
        }
        return paqueteDTO;
    }

    public PaqueteDTO getPeriodos(int c) {
        PaqueteDTO paqueteDTO = new PaqueteDTO();
        try {
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", c));
            paqueteDTO = controladorJDBC.procesaSelect(null, listParametrosDTOreg, getPeriodos);
        } catch (Exception e) {
            String error = "Error en getPeriodos de SaiFunciones.";
            paqueteDTO.setError(error + e.getMessage());
        }
        return paqueteDTO;
    }*/
 /*
 ESTO ES DE LIQUIDACION MATIVA DE PRESTAMOS

 -- select sai_traspasa_ahorros_a_prestamos_lp('10101010101',-300.00,30302,'lista',030257,TRUE,0,60001,70001,180,90,TRUE);

 --  1.- Cuenta contable de donde se tomará la diferencia para liquidar el prestamo.
 --  2.- Es monto máximo que podrá tomar de la cuenta contable establecida en el
 --      parametro 1  (Debe ser negativo).
 --  3.- El producto base (tipo prestamo).
 --      Si se establece el producto base el socio deberá tener este producto para
 --        ser tomado en consideración
 --       O = Significa que no existe un producto base y que se liquidarán todos
 --           los prestamos del socio.
 --      -1 = Significa que existirá una lista de folios de prestamos en un archivo
 --           ubicado en /tmp del servidor de la base de datos.
 --  4.- Es el nombre de la lista particular, donde aparecen los socios a los que
 --      se les liquidarán los prestamos.
 --      Si se usa la opción -1 en el parametro 3, en este espacio se definirá el
 --      archivo y la ruta de folios por ejemplo /tmp/archivo.txt
 --  5.- Es el origen donde se desea aplicar la póliza resultante del proceso de
 --      liquidación de préstamos.
 -------------------------------------------------------------------------------
 --  6.- Solo aplica cuando hay un producto base, de lo contrario se omite.
 --      TRUE = A que se liquiden los demás prestamos además del producto base.
 --      FALSE = Solo se liquide el prestamo base.
 --  7.- Solo aplica cuando hay un producto base, de lo contrario se omite.
 --      Va de la mano del parametro anterior y siempre va de manera fija un cero.
 -------------------------------------------------------------------------------
 --  8.- Es el número de producto de ORDEN DEUDOR Para registrar el monto usado de la reserva.
 --      Si no se desean utilizar los productos de las cuentas de orden se dejan ceros.
 --  9.- Es el número de producto de ORDEN ACREEDOR Para registrar el monto usado de la reserva.
 --      Si no se desean utilizar los productos de las cuentas de orden se dejan ceros.
 -- 10.- Es el minimo de dias vencidos que debera tener el prestamo para liquidarse.
 -- 11.- Es el maximo de dias sin mov que debera tener el prestamo para liquidarse.
 -- 12.- Permite Abonar a prestamos que no alcancen a liquidar
 --      (TRUE: Abonar, FALSE: No, modo normal)
 select sai_traspasa_ahorros_a_prestamos_lp('cuentaDeDiferencias',montoLimite,origenProductos,'nomArch',30501,NULL,0,idProductoDeudor,idProductoAcredor,limiteDiasVencidos,limiteDiasSinMovimientos,abonaNoLiquida)

 -- Sin usar productos 60001 y 70001
 select sai_traspasa_ahorros_a_prestamos_lp('10502070101025',20000.00,-1,'/tmp/L_liqui_dic11.txt',30501,NULL,0,0,0,0,0,FALSE)

 -- Usando productos 60001 y 70001
 select sai_traspasa_ahorros_a_prestamos_lp('10502070101025',20000.00,-1,'/tmp/L_liqui_dic11.txt',30501,NULL,0,60001,70001,0,0,FALSE)
 */
 /*
 @EJB
 private OrigenesServiceLocal origenesService;

 CREATE DATABASE santarosa31jul16_java
 WITH OWNER = admin2
 ENCODING = 'SQL_ASCII'
 TABLESPACE = pg_default
 LC_COLLATE = 'es_MX.UTF-8'
 LC_CTYPE = 'es_MX.UTF-8'
 CONNECTION LIMIT = -1;


 */
//ISO-8859-1
//"amp;useUnicode=true&"
//"amp;characterEncoding=UTF-8&"
//"allowEncodingChanges=true&"
//"amp;characterSetResults=utf8&"
//"amp;connectionCollation=utf8_general_ci&"
    //useUnicode=true&amp;characterEncoding=latin1&amp;connectionCollation=latin1_swedish_ci
