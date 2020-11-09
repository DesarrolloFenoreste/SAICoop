/**
 *
 */
package com.saicoop.modelo.webService;

//catalogo
import com.saicoop.modelo.ejb.faSe.catalogo.BancosService;
import com.saicoop.modelo.ejb.faSe.catalogo.ChequerasService;
import com.saicoop.modelo.ejb.faSe.catalogo.ColoniasService;
import com.saicoop.modelo.ejb.faSe.catalogo.EstadosService;
import com.saicoop.modelo.ejb.faSe.catalogo.SectoresService;
import com.saicoop.modelo.dto.catalogo.BancosDTO;
import com.saicoop.modelo.dto.catalogo.ColoniasDTO;
import com.saicoop.modelo.dto.catalogo.ChequerasDTO;
import com.saicoop.modelo.dto.catalogo.CompletoDatoColoniasDTO;
import com.saicoop.modelo.dto.catalogo.EstadosDTO;
import com.saicoop.modelo.dto.catalogo.SectoresDTO;
import com.saicoop.modelo.dto.catalogo.MunicipiosDTO;
import com.saicoop.modelo.ejb.faSe.catalogo.FinalidadesService;
import com.saicoop.modelo.ejb.faSe.socio.GruposService;
import com.saicoop.modelo.dto.catalogo.FinalidadesDTO;
import com.saicoop.modelo.dto.catalogo.PaisesDTO;
import com.saicoop.modelo.ejb.faSe.catalogo.MunicipiosService;
import com.saicoop.modelo.dto.socio.GruposDTO;
/*general*/
import com.saicoop.modelo.ejb.faSe.general.JUgruposService;
import com.saicoop.modelo.ejb.faSe.general.UsuariosService;
import com.saicoop.modelo.ejb.faSe.general.JUsuariospermisosService;
import com.saicoop.modelo.ejb.faSe.general.JUsuariosugruposService;
import com.saicoop.modelo.ejb.faSe.general.ProductosService;
/*huella digital*/
import com.saicoop.modelo.ejb.faSe.general.HuellasDpUsuarioService;
import com.saicoop.modelo.ejb.faSe.socio.HuellasDpService;
import com.saicoop.modelo.ejb.faSe.util.HuellasColaGuardadoService;
import com.saicoop.modelo.ejb.faSe.general.HuellaDigitalService;
/*util*/
import com.saicoop.modelo.ejb.faSe.util.OrigenesService;
import com.saicoop.modelo.ejb.faSe.util.PolizasService;
import com.saicoop.modelo.ejb.faSe.util.QperfilesService;
import com.saicoop.modelo.ejb.faSe.util.QuerysService;
import com.saicoop.modelo.ejb.faSe.util.CuentasService;
import com.saicoop.modelo.ejb.faSe.util.TablasService;
import com.saicoop.modelo.ejb.faSe.util.TemporalService;
import com.saicoop.modelo.ejb.faSe.util.SaiFuncionesService;
/*socio*/
import com.saicoop.modelo.ejb.faSe.socio.PersonasService;
import com.saicoop.modelo.ejb.faSe.socio.AuxiliaresDService;
import com.saicoop.modelo.ejb.faSe.socio.AuxiliaresService;
/*control de sesion*/
import com.saicoop.modelo.ejb.faSe.general.AdminSesionService;
import com.saicoop.modelo.ejb.util.DatosConexion;
/*otro*/
import com.saicoop.modelo.ejb.util.Intermediario;
/**/
import java.math.BigDecimal;
import com.saicoop.modelo.dto.util.OrigenesDTO;
import com.saicoop.modelo.dto.util.PolizasDTO;
import com.saicoop.modelo.dto.util.QperfilesDTO;
import com.saicoop.modelo.dto.util.QueryDTO;
import com.saicoop.modelo.dto.general.ProductosDTO;
import com.saicoop.modelo.dto.util.HuellasColaGuardadoDTO;
import com.saicoop.modelo.dto.socio.PersonasDTO;
import com.saicoop.modelo.dto.general.AdminSesionDTO;
import com.saicoop.modelo.dto.general.CatalogoMenusDTO;
import com.saicoop.modelo.dto.general.HuellaInactivaDTO;
import com.saicoop.modelo.dto.general.JUgruposDTO;
import com.saicoop.modelo.dto.general.UsuariosDTO;
import com.saicoop.modelo.dto.general.JUsuariospermisosDTO;
import com.saicoop.modelo.dto.general.JUsuariosugruposDTO;
import com.saicoop.modelo.dto.socio.AuxiliaresDDTO;
import com.saicoop.modelo.dto.socio.AuxiliaresDTO;
import com.saicoop.modelo.dto.util.CuentasDTO;
import com.saicoop.modelo.dto.util.TablasDTO;
import com.saicoop.modelo.dto.util.TemporalDTO;
import com.saicoop.modelo.dto.general.HuellasDpUsuarioDTO;
import com.saicoop.modelo.dto.general.JCatalogoMenusDTO;
import com.saicoop.modelo.dto.general.JPermisosDTO;
import com.saicoop.modelo.dto.general.JPersonasBloqueadasDTO;
import com.saicoop.modelo.dto.general.JUgruposPermisosDTO;
import com.saicoop.modelo.dto.general.JOrigenDatosDTO;
import com.saicoop.modelo.dto.socio.HuellasDpDTO;
import com.saicoop.modelo.dto.socio.PersonaCnbvDTO;
import com.saicoop.modelo.dto.socio.VerificacionGeneralHuellaDigitalDTO;
import com.saicoop.modelo.dto.util.JAplicaScriptDTO;
import com.saicoop.modelo.dto.util.JMatrizConfiguracionDTO;
import com.saicoop.modelo.dto.util.JMatrizContenidoDTO;
import com.saicoop.modelo.dto.util.JMatrizDTO;
import com.saicoop.modelo.dto.util.JMatrizReferenciaDTO;
import com.saicoop.modelo.dto.util.JMenuValidacionGeneralHuellaDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import com.saicoop.modelo.dto.util.JRegulatoriosDTO;
import com.saicoop.modelo.dto.util.ResultadoLista;
import com.saicoop.modelo.dto.util.TipoCambioDolarDTO;
import com.saicoop.modelo.ejb.faSe.catalogo.JMenuValidacionGeneralHuellaService;
import com.saicoop.modelo.ejb.faSe.catalogo.PaisesService;
import com.saicoop.modelo.ejb.faSe.general.CatalogoMenusService;
import com.saicoop.modelo.ejb.faSe.general.HuellaInactivaService;
import com.saicoop.modelo.ejb.faSe.general.JBitacoraAccesoService;
import com.saicoop.modelo.ejb.faSe.general.JBitacoraAfectacionesService;
import com.saicoop.modelo.ejb.faSe.general.JBitacoraConsultasService;
import com.saicoop.modelo.ejb.faSe.general.JCatalogoMenusService;
import com.saicoop.modelo.ejb.faSe.general.JPermisosService;
import com.saicoop.modelo.ejb.faSe.general.JUgruposPermisosService;
import com.saicoop.modelo.ejb.faSe.general.JOrigenDatosService;
import com.saicoop.modelo.ejb.faSe.general.JPersonasBloqueadasService;
import com.saicoop.modelo.ejb.faSe.general.JPersonasBloqueadas_HService;
import com.saicoop.modelo.ejb.faSe.socio.PersonaCnbvService;
import com.saicoop.modelo.ejb.faSe.socio.ReferenciasService;
import com.saicoop.modelo.ejb.faSe.socio.VerificacionGeneralHuellaDigitalService;
import com.saicoop.modelo.ejb.faSe.util.CarteraVencidaService;
import com.saicoop.modelo.ejb.faSe.util.EjecucionDeQuerysService;
import com.saicoop.modelo.ejb.faSe.util.JAplicaScriptService;
import com.saicoop.modelo.ejb.faSe.util.JMatrizConfiguracionService;
import com.saicoop.modelo.ejb.faSe.util.JMatrizReferenciaService;
import com.saicoop.modelo.ejb.faSe.util.JMatrizContenidoService;
import com.saicoop.modelo.ejb.faSe.util.JMatrizService;
import com.saicoop.modelo.ejb.faSe.util.MasivosService;
import com.saicoop.modelo.ejb.faSe.util.RegulatoriosService;
import com.saicoop.modelo.ejb.faSe.util.TipoCambioDolarService;
import com.saicoop.modelo.ejb.faSe.util.UtilService;
import com.saicoop.modelo.ejb.util.ListaIpValida;
import com.saicoop.modelo.ejb.util.Utileria;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author prometeo
 */
@WebService(serviceName = "SAICoop")
@Stateless
public class SAICoop {

    @EJB
    private JOrigenDatosService jOrigenDatosService;
    @EJB
    private MasivosService masivosService;
    @EJB
    private JPersonasBloqueadas_HService jPersonasBloqueadas_HService;
    @EJB
    private JPersonasBloqueadasService jPersonasBloqueadasService;
    @EJB
    private RegulatoriosService regulatoriosService;
    @EJB
    private CatalogoMenusService catalogoMenusService;
    @EJB
    private HuellaInactivaService huellaInactivaService;
    @EJB
    private JMatrizService jMatrizService;
    @EJB
    private JMatrizReferenciaService jMatrizReferenciaService;
    @EJB
    private JMatrizContenidoService jMatrizContenidoService;
    @EJB
    private JMatrizConfiguracionService jMatrizConfiguracionService;
    @EJB
    private UtilService utilService;
    @EJB
    private Utileria utileria;
    @EJB
    private PersonaCnbvService personaCnbvService;
    @EJB
    private ReferenciasService referenciasService1;
    @EJB
    private JMenuValidacionGeneralHuellaService jMenuValidacionGeneralHuellaService;
    /*catalogos*/
    @EJB
    private MunicipiosService municipiosService;
    @EJB
    private GruposService gruposService;
    @EJB
    private FinalidadesService finalidadesService;
    @EJB
    private EstadosService estadosService;
    @EJB
    private PaisesService paisesService;
    @EJB
    private ColoniasService coloniasService;
    @EJB
    private ChequerasService chequerasService;
    @EJB
    private BancosService bancosService;
    @EJB
    private SectoresService sectoresService;
    /*general*/
    @EJB
    private JBitacoraConsultasService jBitacoraConsultasService;
    @EJB
    private JBitacoraAfectacionesService jBitacoraAfectacionesService;
    @EJB
    private JBitacoraAccesoService jBitacoraAccesoService;
    @EJB
    private JCatalogoMenusService jCatalogoMenusService;
    @EJB
    private JPermisosService permisosService;
    @EJB
    private JUsuariosugruposService usuariosugruposService;
    @EJB
    private JUgruposService ugruposService;
    @EJB
    private UsuariosService usuariosService;
    @EJB
    private JUsuariospermisosService usuariospermisosService;
    @EJB
    private ProductosService productosService;
    @EJB
    private JUgruposPermisosService ugruposPermisosService;
    /*huella digital*/
    @EJB
    private HuellasDpUsuarioService huellasDpUsuarioService;
    @EJB
    private HuellasDpService huellasDpService;
    @EJB
    private HuellasColaGuardadoService huellasColaGuardadoService;
    @EJB
    private HuellaDigitalService huellaDigitalService;
    /*util*/
    @EJB
    private EjecucionDeQuerysService ejecucionDeQuerysService;
    @EJB
    private CarteraVencidaService carteraVencidaService;
    @EJB
    private TipoCambioDolarService tipoCambioDolarService;
    @EJB
    private CuentasService cuentasService;
    @EJB
    private QuerysService querysService;
    @EJB
    private JAplicaScriptService jAplicaScriptService;
    @EJB
    private QperfilesService qperfilesService;
    @EJB
    private TablasService tablasService;
    @EJB
    private PolizasService polizasService;
    @EJB
    private SaiFuncionesService saiFuncionesService;
    @EJB
    private OrigenesService origenesService;
    @EJB
    private TemporalService temporalService;

    /*socio*/
    @EJB
    private AuxiliaresService auxiliaresService;
    @EJB
    private AuxiliaresDService auxiliaresDService;
    @EJB
    private PersonasService personasService;
    /*control de sesion*/
    @EJB
    private AdminSesionService adminSesionService;
    @EJB
    private DatosConexion datosConexion;
    /*otro*/
    @EJB
    private Intermediario intermediario;
    // Referencias
    @EJB
    private ReferenciasService referenciasService;
    @EJB
    private VerificacionGeneralHuellaDigitalService verificacionGeneralHuellaDigitalService;

    // -------------------------------------------------------------------------
    // -------------------------------------------------------------------------
    // ---------------------------- HUELLA DIGITAL -----------------------------
    // -------------------------------------------------------------------------
    // -------------------------------------------------------------------------
    @WebMethod(operationName = "buscaHuellaInactivaPorOGSyFecha", action = "buscaHuellaInactivaPorOGSyFecha")
    public HuellaInactivaDTO buscaHuellaInactivaPorOGSyFecha(@WebParam(name = "idorigen") Integer idorigen,
            @WebParam(name = "idgrupo") Integer idgrupo,
            @WebParam(name = "idsocio") Integer idsocio,
            @WebParam(name = "fecha") String fecha) {
        if (validadorInter()) {
            return huellaInactivaService.buscaHuellaInactivaPorOGSyFecha(idorigen, idgrupo, idsocio, fecha);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaHuellaInactivaPorOGS", action = "buscaHuellaInactivaPorOGS")
    public PaqueteDTO buscaHuellaInactivaPorOGS(@WebParam(name = "idorigen") Integer idorigen,
            @WebParam(name = "idgrupo") Integer idgrupo,
            @WebParam(name = "idsocio") Integer idsocio) {
        if (validadorInter()) {
            return huellaInactivaService.buscaHuellaInactivaPorOGS(idorigen, idgrupo, idsocio);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "insertaHuellaInactiva", action = "insertaHuellaInactiva")
    public PaqueteDTO insertaHuellaInactiva(@WebParam(name = "idorigen") Integer idorigen,
            @WebParam(name = "idgrupo") Integer idgrupo,
            @WebParam(name = "idsocio") Integer idsocio,
            @WebParam(name = "motivo") Integer motivo,
            @WebParam(name = "usuario") Integer usuario) {
        if (validadorInter()) {
            return huellaInactivaService.insertaHuellaInactiva(idorigen, idgrupo, idsocio, motivo, usuario);
        } else {
            return null;
        }
    }

    /**
     *
     * @param idusuario
     * @param formatoHuella
     * @return
     */
    @WebMethod(operationName = "huellasDPusuario", action = "huellasDPusuario")
    public HuellasDpUsuarioDTO huellasDPusuario(@WebParam(name = "idusuario") int idusuario,
            @WebParam(name = "formatoHuella") int formatoHuella) {
        if (validadorInter()) {
            return huellaDigitalService.huellasDPusuario(idusuario, formatoHuella);
        } else {
            return null;
        }
    }

    /**
     *
     * @param limit
     * @param offset
     * @return
     */
    @WebMethod(operationName = "huellasDPsocios", action = "huellasDPsocios")
    public List<HuellasDpDTO> huellasDPsocios(@WebParam(name = "limit") int limit,
            @WebParam(name = "offset") int offset) {
        if (validadorInter()) {
            return huellaDigitalService.huellasDPsocios(limit, offset);
        } else {
            return null;
        }
    }

    /**
     *
     * @param imagen
     * @param asignado
     * @param toma
     * @param carpeta
     * @param dedo
     * @return
     */
    @WebMethod(operationName = "generaImagenHuella", action = "generaImagenHuella")
    public boolean generaImagenHuella(@WebParam(name = "imagen") byte[] imagen,
            @WebParam(name = "asignado") String asignado,
            @WebParam(name = "toma") int toma,
            @WebParam(name = "carpeta") String carpeta,
            @WebParam(name = "dedo") int dedo) {
        if (validadorInter()) {
            return huellaDigitalService.generaImagenHuella(imagen, asignado, toma, carpeta, dedo);
        }
        return false;
    }

    /**
     *
     * @param esInserta
     * @param idorigen
     * @param idgrupo
     * @param idsocio
     * @param dedo
     * @param huella
     * @param idusuario
     */
    @WebMethod(operationName = "huellaDigitalSocio", action = "huellaDigitalSocio")
    public void huellaDigitalSocio(
            @WebParam(name = "esInserta") boolean esInserta,
            @WebParam(name = "idorigen") int idorigen,
            @WebParam(name = "idgrupo") int idgrupo,
            @WebParam(name = "idsocio") int idsocio,
            @WebParam(name = "dedo") int dedo,
            @WebParam(name = "huella") byte[] huella,
            @WebParam(name = "idusuario") int idusuario) {
        if (validadorInter()) {
            huellasDpService.huellaDigitalSocio(esInserta, idorigen, idgrupo, idsocio, dedo, huella, idusuario);
        }
    }

    /**
     *
     *
     *
     ******
     *
     *
     */
    @WebMethod(operationName = "buscaCatalogoPorMenuYOpcion", action = "buscaCatalogoPorMenuYOpcion")
    public CatalogoMenusDTO buscaCatalogoPorMenuYOpcion(@WebParam(name = "menu") String menu, @WebParam(name = "opcion") Integer opcion) {
        if (validadorInter()) {
            return catalogoMenusService.buscaCatalogoPorMenuYOpcion(menu, opcion);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaCatalogoPorMenu", action = "buscaCatalogoPorMenu")
    public PaqueteDTO buscaCatalogoPorMenu(@WebParam(name = "menu") String menu) {
        if (validadorInter()) {
            return catalogoMenusService.buscaCatalogoPorMenu(menu);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaJMatrizConfiguracionCelda", action = "buscaJMatrizConfiguracionCelda")
    public JMatrizConfiguracionDTO buscaJMatrizConfiguracionCelda(@WebParam(name = "idconfiguracion") int idconfiguracion,
            @WebParam(name = "idmatriz") int idmatriz,
            @WebParam(name = "celda") String celda) {
        if (validadorInter()) {
            return jMatrizConfiguracionService.buscaJMatrizConfiguracionCelda(idconfiguracion, idmatriz, celda);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaTodoJMatrizConfiguracion", action = "buscaTodoJMatrizConfiguracion")
    public PaqueteDTO buscaTodoJMatrizConfiguracion(@WebParam(name = "idmatriz") int idmatriz) {
        if (validadorInter()) {
            return jMatrizConfiguracionService.buscaTodoJMatrizConfig(idmatriz);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaJMatrizConfiguracionConIdMatrizYCelda", action = "buscaJMatrizConfiguracionConIdMatrizYCelda")
    public JMatrizConfiguracionDTO buscaJMatrizConfiguracionConIdMatrizYCelda(@WebParam(name = "idmatriz") int idmatriz, @WebParam(name = "celda") String celda) {
        if (validadorInter()) {
            return jMatrizConfiguracionService.buscaJMatrizConfigConIdMatrizYCelda(idmatriz, celda);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaJMatrizContenidoPorId", action = "buscaJMatrizContenidoPorId")
    public JMatrizContenidoDTO buscaJMatrizContenidoPorId(@WebParam(name = "idconfig") int idconfig) {
        if (validadorInter()) {
            return jMatrizContenidoService.buscaJMatrizContenidoPorId(idconfig);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaTodoJMatrizContenido", action = "buscaTodoJMatrizContenido")
    public PaqueteDTO buscaTodoJMatrizContenido() {
        if (validadorInter()) {
            return jMatrizContenidoService.buscaTodoJMatrizContenido();
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaJMatrizContenidoSoloPestañaPorPeriodo", action = "buscaJMatrizContenidoSoloPestañaPorPeriodo")
    public PaqueteDTO buscaJMatrizContenidoSoloPestañaPorPeriodo(@WebParam(name = "periodo") String periodo) {
        if (validadorInter()) {
            return jMatrizContenidoService.buscaJMatrizContenidoSoloPestañaPorPeriodo(periodo);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaJMatrizReferenciaPorIdContenido", action = "buscaJMatrizReferenciaPorIdContenido")
    public JMatrizReferenciaDTO buscaJMatrizReferenciaPorIdContenido(@WebParam(name = "idcontenido") Integer idcontenido) {
        if (validadorInter()) {
            return jMatrizReferenciaService.buscaJMatrizReferenciaPorIdContenido(idcontenido);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaJMatrizReferenciaPorId", action = "buscaJMatrizReferenciaPorId")
    public JMatrizReferenciaDTO buscaJMatrizReferenciaPorId(@WebParam(name = "idperiodo") int idperiodo,
            @WebParam(name = "periodo") String periodo,
            @WebParam(name = "idContenido") Integer idContenido) {
        if (validadorInter()) {
            return jMatrizReferenciaService.buscaJMatrizReferenciaPorId(idperiodo, periodo, idContenido);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaJMatrizReferenciasPorIdMatriz", action = "buscaJMatrizReferenciasPorIdMatriz")
    public PaqueteDTO buscaJMatrizReferenciasPorIdMatriz(@WebParam(name = "idmatriz") int idmatriz) {
        if (validadorInter()) {
            return jMatrizReferenciaService.buscaJMatrizReferenciasPorIdMatriz(idmatriz);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaJMatrizContenidoPorIdMatriz", action = "buscaJMatrizContenidoPorIdMatriz")
    public PaqueteDTO buscaJMatrizContenidoPorIdMatriz(@WebParam(name = "idmatriz") int idmatriz) {
        if (validadorInter()) {
            return jMatrizContenidoService.buscaJMatrizContenidoPorIdMatriz(idmatriz);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaTodoJMatrizReferencia", action = "buscaTodoJMatrizReferencia")
    public PaqueteDTO buscaTodoJMatrizReferencia() {
        if (validadorInter()) {
            return jMatrizReferenciaService.buscaTodoJMatrizReferencia();
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaJMatrizReferenciaSoloPestañaPorPeriodo", action = "buscaJMatrizReferenciaSoloPestañaPorPeriodo")
    public PaqueteDTO buscaJMatrizReferenciaSoloPestañaPorPeriodo(@WebParam(name = "periodo") String periodo) {
        if (validadorInter()) {
            return jMatrizReferenciaService.buscaJMatrizReferenciaSoloPestañaPorPeriodo(periodo);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaTodasLasJMatrices", action = "buscaTodasLasJMatrices")
    public PaqueteDTO buscaTodasLasJMatrices() {
        if (validadorInter()) {
            return jMatrizService.buscaTodasLasJMatrices();
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaJMatrizPorId", action = "buscaJMatrizPorId")
    public JMatrizDTO buscaJMatrizPorId(@WebParam(name = "idMatriz") int idMatriz) {
        if (validadorInter()) {
            return jMatrizService.buscaJMatrizPorId(idMatriz);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "insertaJMatrizConfiguracion", action = "insertaJMatrizConfiguracion")
    public PaqueteDTO insertaJMatrizConfiguracion(@WebParam(name = "idconfiguracion") int idconfiguracion,
            @WebParam(name = "idmatriz") int idmatriz,
            @WebParam(name = "celda") String celda,
            @WebParam(name = "configuracion") String configuracion,
            @WebParam(name = "idcontenido") int idcontenido) {
        if (validadorInter()) {
            return jMatrizConfiguracionService.insertaJMatrizConfiguracion(idconfiguracion, idmatriz, celda, configuracion, idcontenido);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "insertaJMatrizContenido", action = "insertaJMatrizContenido")
    public PaqueteDTO insertaJMatrizContenido(@WebParam(name = "idcontenido") int idcontenido,
            @WebParam(name = "valor") String valor,
            @WebParam(name = "tipo") int tipo,
            @WebParam(name = "descripcion") String descripcion) {
        if (validadorInter()) {
            return jMatrizContenidoService.insertaJMatrizContenido(idcontenido, valor, tipo, descripcion);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "insertaJMatriz", action = "insertaJMatriz")
    public PaqueteDTO insertaJMatriz(@WebParam(name = "idmatriz") int idmatriz,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "filas") int filas,
            @WebParam(name = "columnas") int columnas,
            @WebParam(name = "periodo") String periodo,
            @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "tipo") int tipo,
            @WebParam(name = "autor") String autor,
            @WebParam(name = "administrador") int administrador,
            @WebParam(name = "grupo") String grupo) {
        if (validadorInter()) {
            return jMatrizService.insertaJMatriz(idmatriz, nombre, filas, columnas, periodo, descripcion, tipo, autor, administrador, grupo);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "insertaJMatrizReferencia", action = "insertaJMatrizReferencia")
    public PaqueteDTO insertaJMatrizReferencia(@WebParam(name = "idreferencia") int idreferencia,
            @WebParam(name = "periodo") String periodo,
            @WebParam(name = "idcontenido") int idcontenido,
            @WebParam(name = "valor") String valor,
            @WebParam(name = "descripcion") String descripcion) {
        if (validadorInter()) {
            return jMatrizReferenciaService.insertaJMatrizReferencia(idreferencia, periodo, idcontenido, valor, descripcion);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "eliminaJMatrizReferencia", action = "eliminaJMatrizReferencia")
    public PaqueteDTO eliminaJMatrizReferencia(@WebParam(name = "idreferencia") int idreferencia) {
        if (validadorInter()) {
            return jMatrizReferenciaService.eliminaJMatrizReferencia(idreferencia);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "eliminaJMatriz", action = "eliminaJMatriz")
    public PaqueteDTO eliminaJMatriz(@WebParam(name = "idmatriz") int idmatriz) {
        if (validadorInter()) {
            return jMatrizService.eliminaJMatriz(idmatriz);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "eliminaJMatrizContenido", action = "eliminaJMatrizContenido")
    public PaqueteDTO eliminaJMatrizContenido(@WebParam(name = "idcontenido") int idcontenido) {
        if (validadorInter()) {
            return jMatrizContenidoService.eliminaJMatrizContenido(idcontenido);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "eliminaJMAtrizConfiguracion", action = "eliminaJMAtrizConfiguracion")
    public PaqueteDTO eliminaJMAtrizConfiguracion(@WebParam(name = "idmatriz") int idmatriz) {
        if (validadorInter()) {
            return jMatrizConfiguracionService.eliminaJMatrizConfiguracion(idmatriz);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "eliminaJMatrizConfiguracionPorIdConfiguracion", action = "eliminaJMatrizConfiguracionPorIdConfiguracion")
    public PaqueteDTO eliminaJMatrizConfiguracionPorIdConfiguracion(@WebParam(name = "iconfiguracion") int idconfiguracion) {
        if (validadorInter()) {
            return jMatrizConfiguracionService.eliminaJMatrizConfiguracionPorIdConfiguracion(idconfiguracion);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "actualizaJMatrizConfiguracion", action = "actualizaJMatrizConfiguracion")
    public PaqueteDTO actualizaJMatrizConfiguracion(@WebParam(name = "idconfiguracion") int idconfiguracion,
            @WebParam(name = "idmatriz") int idmatriz,
            @WebParam(name = "celda") String celda,
            @WebParam(name = "configuracion") String configuracion,
            @WebParam(name = "idcontenido") int idcontenido) {
        if (validadorInter()) {
            return jMatrizConfiguracionService.actualizaJMatrizConfiguracion(idconfiguracion, idmatriz, celda, configuracion, idcontenido);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "actualizaJMatrizContenido", action = "actualizaJMatrizContenido")
    public PaqueteDTO actualizaJMatrizContenido(@WebParam(name = "idcontenido") int idcontenido,
            @WebParam(name = "valor") String valor,
            @WebParam(name = "tipo") int tipo,
            @WebParam(name = "descripcion") String descripcion) {
        if (validadorInter()) {
            return jMatrizContenidoService.actualizaJMatrizContenido(idcontenido, valor, tipo, descripcion);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "actualizaJMatriz", action = "actualizaJMatriz")
    public PaqueteDTO actualizaJMatriz(@WebParam(name = "idmatriz") int idmatriz,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "filas") int filas,
            @WebParam(name = "columnas") int columnas,
            @WebParam(name = "periodo") String periodo,
            @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "tipo") int tipo,
            @WebParam(name = "autor") String autor,
            @WebParam(name = "administrador") int administrador,
            @WebParam(name = "grupo") String grupo) {
        if (validadorInter()) {
            return jMatrizService.actualizaJMatriz(idmatriz, nombre, filas, columnas, periodo, descripcion, tipo, autor, administrador, grupo);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "actualizaJMatrizReferencia", action = "actualizaJMatrizReferencia")
    public PaqueteDTO actualizaJMatrizReferencia(@WebParam(name = "idreferencia") int idreferencia,
            @WebParam(name = "periodo") String periodo,
            @WebParam(name = "idcontenido") int idcontenido,
            @WebParam(name = "valor") String valor,
            @WebParam(name = "descripcion") String descripcion) {
        if (validadorInter()) {
            return jMatrizReferenciaService.actualizaJMatrizReferencia(idreferencia, periodo, idcontenido, valor, descripcion);
        } else {
            return null;
        }
    }

    /**
     * *******
     */
    @WebMethod(operationName = "ActualizaPersonasBloqueadas", action = "ActualizaPersonasBloqueadas")
    public void ActualizaPersonasBloqueadas(@WebParam(name = "idusuario") int idusuario, @WebParam(name = "lbloq") List<JPersonasBloqueadasDTO> lbloq, @WebParam(name = "loris") List<JOrigenDatosDTO> loris) {
        if (validadorInter()) {
            masivosService.ActualizaPersonasBloqueadas(idusuario, lbloq, loris);
        }
    }

    @WebMethod(operationName = "ejecutaEPRCC", action = "ejecutaEPRCC")
    public PaqueteDTO ejecutaEPRCC() {
        if (validadorInter()) {
            return saiFuncionesService.ejecutaEPRCC();
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "generaSaldosIniciales", action = "generaSaldosIniciales")
    public PaqueteDTO generaSaldosIniciales() {
        if (validadorInter()) {
            return saiFuncionesService.generaSaldosIniciales();
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "cierreAnual", action = "cierreAnual")
    public PaqueteDTO cierreAnual() {
        if (validadorInter()) {
            return saiFuncionesService.cierreAnual();
        } else {
            return null;
        }
    }

    /**
     *
     * @param valor
     * @return
     */
    @WebMethod(operationName = "reporteDeConcentracionDeCaptacion", action = "reporteDeConcentracionDeCaptacion")
    public PaqueteDTO reporteDeConcentracionDeCaptacion(@WebParam(name = "valor") int valor) {
        if (validadorInter()) {
            return saiFuncionesService.reporteDeConcentracionDeCaptacion(valor);
        } else {
            return null;
        }
    }

    /**
     *
     * @param tipo
     * @param valor
     * @return
     */
    @WebMethod(operationName = "reporteDeRequerimientosDeReserva", action = "reporteDeRequerimientosDeReserva")
    public PaqueteDTO reporteDeRequerimientosDeReserva(@WebParam(name = "tipo") String tipo,
            @WebParam(name = "valor") String valor) {
        if (validadorInter()) {
            return saiFuncionesService.reporteDeRequerimientosDeReserva(tipo, valor);
        } else {
            return null;
        }
    }

    /**
     *
     * @param tipo
     * @param fechainicial
     * @param fechafinal
     * @return
     */
    @WebMethod(operationName = "reporteDeEvolucionDeBandas", action = "reporteDeEvolucionDeBandas")
    public PaqueteDTO reporteDeEvolucionDeBandas(
            @WebParam(name = "tipo") String tipo,
            @WebParam(name = "fechainicial") String fechainicial,
            @WebParam(name = "fechafinal") String fechafinal) {
        if (validadorInter()) {
            //return saiFuncionesService.reporteDeEvolucionDeBandas(tipo, fechainicial, fechafinal);

            PaqueteDTO dto = saiFuncionesService.reporteDeEvolucionDeBandas(tipo, fechainicial, fechafinal);
            /*
            try {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                ObjectOutputStream os = new ObjectOutputStream(out);
                os.writeObject(gera);
                byte[] gerabyte = out.toByteArray();

                FileOutputStream fileOuputStream = new FileOutputStream("/home/gerardo/gera");
                fileOuputStream.write(gerabyte);

                System.out.println("---------------------------------------------" + new Date());
                ByteArrayInputStream in = new ByteArrayInputStream(gerabyte);
                ObjectInputStream is = new ObjectInputStream(in);
                Object geraobject = is.readObject();
                System.out.println("---------------------------------------------" + new Date());
                
                System.out.println(((PaqueteDTO) geraobject).getListRaiceNotice().get(0));
                
                System.out.println("---------------------------------------------" + new Date());
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al convertir archivo");
            }
             */

            return dto;

        } else {
            return null;
        }
    }

    // toByteArray and toObject are taken from: http://tinyurl.com/69h8l7x
    private byte[] toByteArray(Object obj) throws IOException {
        byte[] bytes = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
        } finally {
            if (oos != null) {
                oos.close();
            }
            if (bos != null) {
                bos.close();
            }
        }
        return bytes;
    }

    /**
     *
     * @param concentrado
     * @param fecha
     * @param tipos
     * @return
     */
    @WebMethod(operationName = "concentracionDeCartera", action = "concentracionDeCartera")
    public PaqueteDTO reporteDeConcentracionDeCartera(
            @WebParam(name = "concentrado") int concentrado,
            @WebParam(name = "fecha") String fecha,
            @WebParam(name = "tipos") String tipos) {
        if (validadorInter()) {
            return saiFuncionesService.reporteDeConcentracionDeCartera(concentrado, fecha, tipos);
        } else {
            return null;
        }
    }

    /**
     *
     * @return
     */
    @WebMethod(operationName = "listaFechaCarteraVencidaHistorial", action = "listaFechaCarteraVencidaHistorial")
    public List<ResultadoLista> listaFechaCarteraVencidaHistorial() {
        if (validadorInter()) {
            return saiFuncionesService.listaFechaCarteraVencidaHistorial();
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @return
     */
    @WebMethod(operationName = "getFechaTrabajo", action = "getFechaTrabajo")
    public String getFechaTrabajo() {
        if (validadorInter()) {
            return saiFuncionesService.saiFechaTrabajo();
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @return
     */
    @WebMethod(operationName = "seCalculoCarteravencida", action = "seCalculoCarteravencida")
    public boolean seCalculoCarteravencida() {
        if (validadorInter()) {
            return carteraVencidaService.seCalculoCarteravencida();
        } else {
            return false;
        }
    }

    /**
     *
     * @return
     */
    @WebMethod(operationName = "generacionDeCarteraVencida", action = "generacionDeCarteraVencida")
    public PaqueteDTO generacionDeCarteraVencida() {
        if (validadorInter()) {
            return saiFuncionesService.generacionDeCarteraVencida();
        } else {
            return null;
        }
    }

    /**
     *
     * @return
     */
    @WebMethod(operationName = "buscaUltimoTipoCambio", action = "buscaUltimoTipoCambio")
    public TipoCambioDolarDTO buscaUltimoTipoCambio() {
        if (validadorInter()) {
            return tipoCambioDolarService.buscaUltimoTipoCambio();
        } else {
            return null;
        }
    }

    /**
     *
     * @param fechatrabajo
     * @param fecha
     * @return
     */
    @WebMethod(operationName = "buscaTipoCambio", action = "buscaTipoCambio")
    public TipoCambioDolarDTO buscaTipoCambio(@WebParam(name = "fechatrabajo") String fechatrabajo,
            @WebParam(name = "fecha") String fecha) {
        if (validadorInter()) {
            return tipoCambioDolarService.buscaTipoCambio(fechatrabajo, fecha);
        } else {
            return null;
        }
    }

    /**
     *
     * @param idusuario
     * @param tipo_cambio
     * @return
     */
    @WebMethod(operationName = "guardaUltimoTipoCambio", action = "guardaUltimoTipoCambio")
    public int guardaUltimoTipoCambio(@WebParam(name = "idusuario") int idusuario,
            @WebParam(name = "tipo_cambio") BigDecimal tipo_cambio) {
        if (validadorInter()) {
            return tipoCambioDolarService.guardaUltimoTipoCambio(idusuario, tipo_cambio);
        } else {
            return 0;
        }
    }

    /**
     *
     * @return
     */
    @WebMethod(operationName = "importarPolizasExtemporaneas", action = "importarPolizasExtemporaneas")
    public int importarPolizasExtemporaneas() {
        if (validadorInter()) {
            return saiFuncionesService.ImportarPolizasExtemporaneas();
        } else {
            return 0;
        }
    }

    /**/
    /**
     *
     * @param periodo
     * @return
     */
    @WebMethod(operationName = "exportarPolizasExtemporaneas", action = "exportarPolizasExtemporaneas")
    public int exportarPolizasExtemporaneas(@WebParam(name = "periodo") String periodo) {
        if (validadorInter()) {
            return saiFuncionesService.exportarPolizasExtemporaneas(periodo);
        } else {
            return 0;
        }
    }

    /**
     *
     * @return
     */
    @WebMethod(operationName = "buscaTodasLasCuentas", action = "buscaTodasLasCuentas")
    public List<CuentasDTO> buscaTodasLasCuentas() {
        if (validadorInter()) {
            return cuentasService.buscaTodasLasCuentas();
        } else {
            return null;
        }
    }

    /**
     *
     * @param idcuenta
     * @return
     */
    @WebMethod(operationName = "buscaCuentaPorId", action = "buscaCuentaPorId")
    public CuentasDTO buscaCuentaPorId(@WebParam(name = "idcuenta") String idcuenta) {
        if (validadorInter()) {
            return cuentasService.buscaCuentaPorId(idcuenta);
        } else {
            return null;
        }
    }

    /**
     *
     * @param idcuenta
     * @param clase
     * @param tipo
     * @return
     */
    @WebMethod(operationName = "buscaCuentaPorIdClaseYTipo", action = "buscaCuentaPorIdClaseYTipo")
    public CuentasDTO buscaCuentaPorIdClaseYTipo(@WebParam(name = "idcuenta") String idcuenta,
            @WebParam(name = "clase") int clase,
            @WebParam(name = "tipo") int tipo) {
        if (validadorInter()) {
            return cuentasService.buscaCuentaPorIdClaseYTipo(idcuenta, clase, tipo);
        } else {
            return null;
        }
    }

    /**
     *
     * @param cuentaContable
     * @param montoLimite
     * @param nomArch
     * @param idorigen
     * @param idProductoDeudor
     * @param idProductoAcredor
     * @param limitediasVencidos
     * @param limiteDiasSinMovimientos
     * @param abonar
     * @return
     */
    @WebMethod(operationName = "liquidacionMasivaDePrestamos", action = "liquidacionMasivaDePrestamos")
    public PaqueteDTO liquidacionMasivaDePrestamos(
            @WebParam(name = "cuentaContable") String cuentaContable,
            @WebParam(name = "montoLimite") BigDecimal montoLimite,
            @WebParam(name = "nomarch") String nomArch,
            @WebParam(name = "idorigen") int idorigen,
            @WebParam(name = "idProductoDeudor") int idProductoDeudor,
            @WebParam(name = "idProductoAcredor") int idProductoAcredor,
            @WebParam(name = "limitediasVencidos") int limitediasVencidos,
            @WebParam(name = "limiteDiasSinMovimientos") int limiteDiasSinMovimientos,
            @WebParam(name = "abonar") boolean abonar) {
        if (validadorInter()) {
            return saiFuncionesService.liquidacionMasivaDePrestamos(cuentaContable, montoLimite, nomArch, idorigen, idProductoDeudor, idProductoAcredor, limitediasVencidos, limiteDiasSinMovimientos, abonar);
        } else {
            return null;
        }
    }

    /**
     *
     * @param idgrupo
     * @return
     */
    @WebMethod(operationName = "inactivaPersonasPorGrupo", action = "inactivaPersonasPorGrupo")
    public PaqueteDTO inactivaPersonasPorGrupo(@WebParam(name = "idgrupo") int idgrupo) {
        if (validadorInter()) {
            return saiFuncionesService.inactivaPersonasPorGrupo(idgrupo);
        } else {
            return null;
        }
    }

    /**
     *
     * @param idusuario
     * @param nomArch
     * @return
     */
    @WebMethod(operationName = "condonacionMasiva", action = "condonacionMasiva")
    public PaqueteDTO condonacionMasiva(
            @WebParam(name = "idusuario") int idusuario,
            @WebParam(name = "nomArch") String nomArch) {
        if (validadorInter()) {
            return saiFuncionesService.condonacionMasiva(idusuario, nomArch);
        } else {
            return null;
        }
    }

    /**
     *
     * @param idusuario
     * @param esResumen
     * @param concepto
     * @param nomArchivo
     * @param fecha
     * @return
     */
    @WebMethod(operationName = "generacionDePolizas", action = "generacionDePolizas")
    public PaqueteDTO generacionDePolizas(@WebParam(name = "idusuario") Integer idusuario,
            @WebParam(name = "esResumen") boolean esResumen,
            @WebParam(name = "concepto") String concepto,
            @WebParam(name = "nomArchivo") String nomArchivo,
            @WebParam(name = "fecha") String fecha) {
        if (validadorInter()) {
            return saiFuncionesService.generacionDePolizas(idusuario, esResumen, concepto, nomArchivo, fecha);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "estadoDeCuentas", action = "estadoDeCuentas")
    public PaqueteDTO estadoDeCuentas(@WebParam(name = "idorigenp") int idorigenp,
            @WebParam(name = "idproducto") int idproducto,
            @WebParam(name = "idauxiliar") int idauxiliar,
            @WebParam(name = "fecha_ini") String fecha_ini,
            @WebParam(name = "fecha_fin") String fecha_fin,
            @WebParam(name = "ipo") String tipo) {
        if (validadorInter()) {
            return saiFuncionesService.estadoDeCuentas(idorigenp, idproducto, idauxiliar, fecha_ini, fecha_fin, tipo);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param fecha
     * @param idusuario
     * @return
     */
    @WebMethod(operationName = "buscaPolizasPorFechaYUsuario", action = "buscaPolizasPorFechaYUsuario")
    public List<PolizasDTO> buscaPolizasPorFechaYUsuario(@WebParam(name = "fecha") String fecha,
            @WebParam(name = "idusuario") int idusuario) {
        if (validadorInter()) {
            return polizasService.buscaPolizasDTOPorfechayusuario(fecha, idusuario);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaTodosLosRegulatorios", action = "buscaTodosLosRegulatorios")
    public PaqueteDTO buscaTodosLosRegulatorios() {
        if (validadorInter()) {
            return regulatoriosService.buscaTodosLosRegulatorios();
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaRegulatorioPorSerieYIdReg", action = "buscaRegulatorioPorSerieYIdReg")
    public JRegulatoriosDTO buscaRegulatorioPorSerieYIdReg(@WebParam(name = "serie") String serie, @WebParam(name = "idreg") String idreg) {
        if (validadorInter()) {
            return regulatoriosService.buscaRegulatorioPorSerieYIdReg(serie, idreg);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaRegulatorioPorSerie", action = "buscaRegulatorioPorSerie")
    public PaqueteDTO buscaRegulatorioPorSerie(@WebParam(name = "serie") String serie) {
        if (validadorInter()) {
            return regulatoriosService.buscaRegulatorioPorSerie(serie);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaRegulatorioPorIdReg", action = "buscaRegulatorioPorIdReg")
    public PaqueteDTO buscaRegulatorioPorIdReg(@WebParam(name = "idreg") String idreg) {
        if (validadorInter()) {
            return regulatoriosService.buscaRegulatorioPorIdReg(idreg);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "borrarRegulatorio", action = "borrarRegulatorio")
    public PaqueteDTO borrarRegulatorio(@WebParam(name = "serie") String serie, @WebParam(name = "idreg") String idreg) {
        if (validadorInter()) {
            return regulatoriosService.borrarRegulatorio(serie, idreg);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "regulatoriosCU", action = "regulatoriosCU")
    public PaqueteDTO regulatoriosCU(@WebParam(name = "esInserta") boolean esInserta,
            @WebParam(name = "serie") String serie,
            @WebParam(name = "idreg") String idreg,
            @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "periodo") int periodo,
            @WebParam(name = "funcion") String funcion,
            @WebParam(name = "consulta") String consulta,
            @WebParam(name = "visible") boolean visible) {
        if (validadorInter()) {
            return regulatoriosService.regulatoriosCU(esInserta, serie, idreg, descripcion, periodo, funcion, consulta, visible);
        } else {
            return null;
        }
    }

    /**
     *
     * @param query
     * @return
     */
    @WebMethod(operationName = "ejecutaQuery", action = "ejecutaQuery")
    public PaqueteDTO ejecutaQuery(@WebParam(name = "query") String query) {
        if (validadorInter()) {
            return ejecucionDeQuerysService.ejecutaQuery(query);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "ejecutaQueries", action = "ejecutaQueries")
    public PaqueteDTO ejecutaQueries(@WebParam(name = "queries") List<String> queries) {
        if (validadorInter()) {
            return ejecucionDeQuerysService.ejecutaQueries(queries);
        } else {
            return null;
        }
    }

    /**
     *
     * @param idtabla
     * @param idelemento
     * @return
     */
    @WebMethod(operationName = "buscarTabla", action = "buscarTabla")
    public TablasDTO buscarTabla(@WebParam(name = "idtabla") String idtabla,
            @WebParam(name = "idelemento") String idelemento) {
        if (validadorInter()) {
            return tablasService.buscaTabla(idtabla, idelemento);
        } else {
            return null;
        }
    }

    /**
     *
     * @param idtabla
     * @return
     */
    @WebMethod(operationName = "buscarTablasPorIdTabla", action = "buscarTablasPorIdTabla")
    public List<TablasDTO> buscarTablasPorIdTabla(@WebParam(name = "idtabla") String idtabla) {
        if (validadorInter()) {
            return tablasService.buscaTablasPorIdTabla(idtabla);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaTodosLosIdtabla", action = "buscaTodosLosIdtabla")
    public PaqueteDTO buscaTodosLosIdtabla() {
        if (validadorInter()) {
            return tablasService.buscaTodosLosIdtabla();
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "actualizaTabla", action = "actualizaTabla")
    public PaqueteDTO actualizaTabla(String nombre, String dato1, String dato2, String dato3, String dato4, String dato5, int tipo, String idtabla, String idelemento) {
        if (validadorInter()) {
            return tablasService.actualizaTabla(nombre, dato1, dato2, dato3, dato4, dato5, tipo, idtabla, idelemento);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "eliminaTabla", action = "eliminaTabla")
    public PaqueteDTO eliminaTabla(String idtabla, String idelemento) {
        if (validadorInter()) {
            return tablasService.eliminaTabla(idtabla, idelemento);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "insertaTabla", action = "insertaTabla")
    public PaqueteDTO insertaTabla(String idtabla, String idelemento, String nombre, String dato1, String dato2, String dato3, String dato4, String dato5, int tipo) {
        if (validadorInter()) {
            return tablasService.insertaTabla(idtabla, idelemento, nombre, dato1, dato2, dato3, dato4, dato5, tipo);
        } else {
            return null;
        }
    }

    /**
     *
     * @param sesion
     * @param idorigenp
     * @param idproducto
     * @param idauxiliar
     * @param idusuario
     * @param idorigen
     * @param idgrupo
     * @param idsocio
     * @param esentrada
     * @param cuenta
     * @param acapital
     * @param mov
     */
    @WebMethod(operationName = "insertarTemporal", action = "insertarTemporal")
    public void insertarTemporal(
            @WebParam(name = "sesion") String sesion,
            @WebParam(name = "idorigenp") int idorigenp,
            @WebParam(name = "idproducto") int idproducto,
            @WebParam(name = "idauxiliar") int idauxiliar,
            @WebParam(name = "idusuario") int idusuario,
            @WebParam(name = "idorigen") int idorigen,
            @WebParam(name = "idgrupo") int idgrupo,
            @WebParam(name = "idsocio") int idsocio,
            @WebParam(name = "esentrada") boolean esentrada,
            @WebParam(name = "cuenta") String cuenta,
            @WebParam(name = "acapital") double acapital,
            @WebParam(name = "mov") int mov) {
        if (validadorInter()) {
            temporalService.insertaTemporal(sesion, idorigenp, idproducto, idauxiliar, idusuario, idorigen, idgrupo, idsocio, esentrada, cuenta, acapital, mov);
        }
    }

    /**
     *
     * @param sesion
     * @param idorigenp
     * @param idproducto
     * @param idauxiliar
     */
    @WebMethod(operationName = "eliminaTemporal", action = "eliminaTemporal")
    public void eliminaTemporal(
            @WebParam(name = "sesion") String sesion,
            @WebParam(name = "idorigenp") int idorigenp,
            @WebParam(name = "idproducto") int idproducto,
            @WebParam(name = "idauxiliar") int idauxiliar) {
        if (validadorInter()) {
            temporalService.eliminaTemporal(sesion, idorigenp, idproducto, idauxiliar);
        }
    }

    /**
     *
     * @param idusuario
     * @return
     */
    @WebMethod(operationName = "buscaTemporalIdusuario", action = "buscaTemporalIdusuario")
    public List<TemporalDTO> buscaTemporalIdusuario(@WebParam(name = "idusuario") int idusuario) {
        if (validadorInter()) {
            return temporalService.buscaTemporalIdusuario(idusuario);
        } else {
            return null;
        }
    }

    /**
     *
     * @param idusuario
     * @param idorigenp
     * @param idproducto
     * @param idauxiliar
     * @param mov
     */
    @WebMethod(operationName = "actualizaTemporalHuella", action = "actualizaTemporalHuella")
    public void actualizaTemporalHuella(
            @WebParam(name = "idusuario") int idusuario,
            @WebParam(name = "idorigenp") int idorigenp,
            @WebParam(name = "idproducto") int idproducto,
            @WebParam(name = "idauxiliar") int idauxiliar,
            @WebParam(name = "mov") int mov) {
        if (validadorInter()) {
            temporalService.actualizaTemporalHuella(idusuario, idorigenp, idproducto, idauxiliar, mov);
        }
    }

    /**
     *
     * @param idusuario
     * @param idorigen
     * @param idgrupo
     * @param idsocio
     */
    @WebMethod(operationName = "actualizaTemporalHuellaOGS", action = "actualizaTemporalHuellaOGS")
    public void actualizaTemporalHuellaOGS(
            @WebParam(name = "idusuario") int idusuario,
            @WebParam(name = "idorigen") int idorigen,
            @WebParam(name = "idgrupo") int idgrupo,
            @WebParam(name = "idsocio") int idsocio) {
        if (validadorInter()) {
            temporalService.actualizaTemporalHuellaOGS(idusuario, idorigen, idgrupo, idsocio);
        }
    }

    /**/
    /**
     *
     * @param idorigen
     * @return
     */
    @WebMethod(operationName = "buscaOrigenPorId", action = "buscaOrigenPorId")
    public OrigenesDTO buscaOrigenPorId(@WebParam(name = "idorigen") int idorigen) {
        if (validadorInter()) {
            return origenesService.buscaOrigenes(idorigen);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @return
     */
    @WebMethod(operationName = "buscaTodosLosOrigenes", action = "buscaTodosLosOrigenes")
    public List<OrigenesDTO> buscaTodosLosOrigenes() {
        if (validadorInter()) {
            return origenesService.buscaTodosLosOrigenes();
        } else {
            return null;
        }

    }

    /**/
    /**
     *
     * @param idusuario
     * @return
     */
    @WebMethod(operationName = "buscaIdsocioCola", action = "buscaIdsocioCola")
    public HuellasColaGuardadoDTO buscaIdsocioCola(@WebParam(name = "idusuario") int idusuario) {
        if (validadorInter()) {
            return huellasColaGuardadoService.BuscaSocioPorIdusuario(idusuario);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param idusuario
     */
    @WebMethod(operationName = "eliminaHuellasColaGuardado", action = "eliminaHuellasColaGuardado")
    public void eliminaHuellasColaGuardado(@WebParam(name = "idusuario") int idusuario) {
        if (validadorInter()) {
            huellasColaGuardadoService.eliminaHuellasColaGuardado(idusuario);
        }
    }

    /**/
    /**
     *
     * @param esBase
     * @return
     */
    @WebMethod(operationName = "buscaTodosLosQueriesLibres", action = "buscaTodosLosQueriesLibres")
    public List<QueryDTO> buscaTodosLosQueriesLibres(@WebParam(name = "esBase") boolean esBase) {
        if (validadorInter()) {
            return querysService.getQueriesLibresDTO(esBase);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param idusuario
     * @param esBase
     * @return
     */
    @WebMethod(operationName = "getQueriesPorIdUsuario", action = "getQueriesPorIdUsuario")
    public List<QueryDTO> getQueriesPorIdUsuario(@WebParam(name = "idusuario") int idusuario, @WebParam(name = "esBase") boolean esBase) {
        if (validadorInter()) {
            return querysService.getQueriesPorIdUsuario(idusuario, esBase);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param idquery
     * @return
     */
    @WebMethod(operationName = "buscaQueryPorId", action = "buscaQueryPorId")
    public QueryDTO buscaQueryPorId(@WebParam(name = "idquery") int idquery) {
        if (validadorInter()) {
            return querysService.buscaQueryDTOPorId(idquery);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param idquery
     * @return
     */
    @WebMethod(operationName = "eliminaQueryPorId", action = "eliminaQueryPorId")
    public PaqueteDTO eliminaQueryPorId(@WebParam(name = "idquery") int idquery) {
        if (validadorInter()) {
            return querysService.eliminaQuery(idquery);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param idscript
     * @return
     */
    @WebMethod(operationName = "getJAplicaScriptPorId", action = "getJAplicaScriptPorId")
    public JAplicaScriptDTO getJAplicaScriptPorId(@WebParam(name = "idquery") String idscript) {
        if (validadorInter()) {
            return jAplicaScriptService.getJAplicaScriptPorId(idscript);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param idscript
     * @param idusuario
     * @param autor
     * @param script
     * @param comentario
     * @return
     */
    @WebMethod(operationName = "insertaJAplicaScript", action = "insertaJAplicaScript")
    public int insertaJAplicaScript(@WebParam(name = "idscript") String idscript,
            @WebParam(name = "idusuario") int idusuario,
            @WebParam(name = "autor") String autor,
            @WebParam(name = "script") String script,
            @WebParam(name = "comentario") String comentario) {
        if (validadorInter()) {
            return jAplicaScriptService.insertaJAplicaScript(idscript, idusuario, autor, script, comentario);
        } else {
            return 0;
        }
    }

    /**/
    /**
     *
     * @param esVacio
     * @return
     */
    @WebMethod(operationName = "buscaProximoIdQuery", action = "buscaProximoIdQuery")
    public int buscaProximoIdQuery(@WebParam(name = "esVacio") boolean esVacio) {
        if (validadorInter()) {
            int g = querysService.buscaProximoIdQuery(esVacio);
            return g;
        }
        return 0;
    }

    /**/
    /**
     *
     * @param esInserta
     * @param idquery
     * @param descripcion
     * @param query
     * @param editable
     * @param remota
     * @return
     */
    @WebMethod(operationName = "QueryCU", action = "QueryCU")
    public PaqueteDTO QueryCU(@WebParam(name = "esInserta") boolean esInserta,
            @WebParam(name = "idquery") int idquery,
            @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "query") String query,
            @WebParam(name = "editable") boolean editable,
            @WebParam(name = "remota") boolean remota) {
        if (validadorInter()) {
            return querysService.QueryCU(esInserta, idquery, descripcion, query, editable, remota);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param idquery
     * @return
     */
    @WebMethod(operationName = "buscaQperfilesPorIdQuery", action = "buscaQperfilesPorIdQuery")
    public List<QperfilesDTO> buscaQperfilesPorIdQuery(@WebParam(name = "idquery") int idquery) {
        if (validadorInter()) {
            return qperfilesService.buscaQperfilesDTOPorIdQuery(idquery);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param idugrupo
     * @return
     */
    @WebMethod(operationName = "buscaQperfilesPorIdUgrupo", action = "buscaQperfilesPorIdUgrupo")
    public List<QperfilesDTO> buscaQperfilesPorIdUgrupo(@WebParam(name = "idugrupo") int idugrupo) {
        if (validadorInter()) {
            return qperfilesService.buscaQperfilesDTOPorIdugrupo(idugrupo);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param idquery
     * @param idugrupo
     * @return
     */
    @WebMethod(operationName = "buscaQPerfilesPor2Ids", action = "buscaQPerfilesPor2Ids")
    public QperfilesDTO buscaQPerfilesPor2Ids(@WebParam(name = "idquery") int idquery,
            @WebParam(name = "idugrupo") int idugrupo) {
        if (validadorInter()) {
            return qperfilesService.buscaQperfilesDTOPorIdQueryYIdugrupo(idquery, idugrupo);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param esInserta
     * @param idquery
     * @param idugrupo
     * @return
     */
    @WebMethod(operationName = "qPerfilesCR", action = "qPerfilesCR")
    public PaqueteDTO qPerfilesCR(@WebParam(name = "esInserta") boolean esInserta, @WebParam(name = "idquery") int idquery, @WebParam(name = "idugrupo") int idugrupo) {
        return qperfilesService.qPerfilesCR(esInserta, idquery, idugrupo);
    }

    /**/
    /**
     *
     * @param idquery
     * @return
     */
    @WebMethod(operationName = "eliminaQperfiles", action = "eliminaQperfiles")
    public PaqueteDTO eliminaQperfiles(@WebParam(name = "idquery") int idquery) {
        if (validadorInter()) {
            return qperfilesService.eliminaQPerfiles(idquery);
        } else {
            return null;
        }
    }

    /**
     *
     * @return
     */
    @WebMethod(operationName = "proximoIndicePermisos", action = "proximoIndicePermisos")
    public int proximoIndicePermisos() {
        if (validadorInter()) {
            return permisosService.proximoIndiceJPermisos();
        } else {
            return 0;
        }
    }

    /**/
    /**
     *
     * @param idpermiso
     * @return
     */
    @WebMethod(operationName = "buscaPermiso", action = "buscaPermiso")
    public JPermisosDTO buscaPermiso(@WebParam(name = "idpermiso") int idpermiso) {
        if (validadorInter()) {
            return permisosService.buscaJPermiso(idpermiso);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param idpermiso
     * @return
     */
    @WebMethod(operationName = "eliminaJPermiso", action = "eliminaJPermiso")
    public PaqueteDTO eliminaJPermiso(@WebParam(name = "idpermiso") int idpermiso) {
        if (validadorInter()) {
            return permisosService.eliminaJPermiso(idpermiso);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param esInserta
     * @param idpermiso
     * @param permiso
     * @param descripcion
     * @param idmenu
     * @param estatus
     * @return
     */
    @WebMethod(operationName = "jPermisosCU", action = "jPermisosCU")
    public PaqueteDTO jPermisosCU(@WebParam(name = "esInserta") boolean esInserta,
            @WebParam(name = "idpermiso") int idpermiso,
            @WebParam(name = "permiso") String permiso,
            @WebParam(name = "idmenu") int idmenu,
            @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "estatus") boolean estatus) {
        if (validadorInter()) {
            return permisosService.jPermisosCU(esInserta, idpermiso, permiso, idmenu, descripcion, estatus);
        } else {
            return null;
        }
    }

    /**
     *
     * @param esInserta
     * @param idugrupo
     * @param idpermiso
     * @return
     */
    @WebMethod(operationName = "jUgruposPermisosCR", action = "jUgruposPermisosCR")
    public PaqueteDTO jUgruposPermisosCR(@WebParam(name = "esInserta") boolean esInserta,
            @WebParam(name = "idugrupo") int idugrupo,
            @WebParam(name = "idpermiso") int idpermiso) {
        if (validadorInter()) {
            return ugruposPermisosService.jUgruposPermisosCR(esInserta, idugrupo, idpermiso);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param idusuario
     * @param idpermiso
     * @return
     */
    @WebMethod(operationName = "insertaUsuarioPermiso", action = "insertaUsuarioPermiso")
    public PaqueteDTO insertaUsuarioPermiso(@WebParam(name = "idusuario") int idusuario,
            @WebParam(name = "idpermiso") int idpermiso) {
        if (validadorInter()) {
            return usuariospermisosService.insertaUsuarioPermiso(idusuario, idpermiso);
        } else {
            return null;
        }
    }

    /**
     * @param idusuario
     * @param idpermiso
     * @return
     */
    @WebMethod(operationName = "eliminaUsuarioPermiso", action = "eliminaUsuarioPermiso")
    public PaqueteDTO eliminaUsuarioPermiso(@WebParam(name = "idusuario") int idusuario,
            @WebParam(name = "idpermiso") int idpermiso) {
        if (validadorInter()) {
            return usuariospermisosService.eliminaUsuarioPermiso(idusuario, idpermiso);
        } else {
            return null;
        }
    }

    /**
     * @param esInserta
     * @param idusuario
     * @param idugrupo
     * @return
     */
    @WebMethod(operationName = "jUsuariosugruposCR", action = "jUsuariosugruposCR")
    public PaqueteDTO jUsuariosugruposCR(@WebParam(name = "esInserta") boolean esInserta,
            @WebParam(name = "idusuario") int idusuario,
            @WebParam(name = "idugrupo") int idugrupo) {
        if (validadorInter()) {
            return usuariosugruposService.jUsuariosugruposCR(esInserta, idusuario, idugrupo);
        } else {
            return null;
        }
    }

    /**
     * @return
     */
    @WebMethod(operationName = "buscaTodosLosUsuarios", action = "buscaTodosLosUsuarios")
    public List<UsuariosDTO> buscaTodosLosUsuarios() {
        if (validadorInter()) {
            return usuariosService.buscaTodosLosUsuarios();
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param idmenu
     * @param idaccion
     * @param idusuario
     * @param referencia
     * @param detalle
     * @return
     */
    @WebMethod(operationName = "guardaEnBitacoraAfectaciones", action = "guardaEnBitacoraAfectaciones")
    public PaqueteDTO guardaEnBitacoraAfectaciones(@WebParam(name = "idmenu") int idmenu,
            @WebParam(name = "idaccion") int idaccion,
            @WebParam(name = "idusuario") int idusuario,
            @WebParam(name = "referencia") String referencia,
            @WebParam(name = "detalle") String detalle) {
        if (validadorInter()) {
            return jBitacoraAfectacionesService.guardaEnBitacoraAfectaciones(idmenu, idaccion, idusuario, referencia, detalle);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param idmenu
     * @param idaccion
     * @param idusuario
     * @return
     */
    @WebMethod(operationName = "guardaEnBitacoraAcceso", action = "guardaEnBitacoraAcceso")
    public PaqueteDTO guardaEnBitacoraAcceso(@WebParam(name = "idmenu") int idmenu,
            @WebParam(name = "idaccion") int idaccion,
            @WebParam(name = "idusuario") int idusuario) {
        if (validadorInter()) {
            return jBitacoraAccesoService.guardaEnBitacoraAcceso(idmenu, idaccion, idusuario);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaJPersonasBloqueadasPorIds", action = "buscaJPersonasBloqueadasPorIds")
    public JPersonasBloqueadasDTO buscaJPersonasBloqueadasPorIds(@WebParam(name = "id_doc") String id_doc, @WebParam(name = "idod") int idod, @WebParam(name = "fecha") String fecha) {
        if (validadorInter()) {
            return jPersonasBloqueadasService.buscaJPersonasBloqueadasPorIds(id_doc, idod, fecha);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaTodasLasJPersonasBloqueadas", action = "buscaTodasLasJPersonasBloqueadas")
    public PaqueteDTO buscaTodasLasJPersonasBloqueadas() {
        if (validadorInter()) {
            return jPersonasBloqueadasService.buscaTodasLasJPersonasBloqueadas();
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaJPersonasBloqueadasPorIDDoc", action = "buscaJPersonasBloqueadasPorIDDoc")
    public List<JPersonasBloqueadasDTO> buscaJPersonasBloqueadasPorIDDoc(@WebParam(name = "id_doc") String id_doc) {
        if (validadorInter()) {
            return jPersonasBloqueadasService.buscaJPersonasBloqueadasPorIDDoc(id_doc);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaFechasDeJPersonasBloqueadasPorIdOD", action = "buscaFechasDeJPersonasBloqueadasPorIdOD")
    public PaqueteDTO buscaFechasDeJPersonasBloqueadasPorIdOD(@WebParam(name = "idod") Integer idod) {
        if (validadorInter()) {
            return jPersonasBloqueadasService.buscaFechasDeJPersonasBloqueadasPorIdOD(idod);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaJPersonasBloqueadasPorIdODFecha", action = "buscaJPersonasBloqueadasPorIdODFecha")
    public PaqueteDTO buscaJPersonasBloqueadasPorIdODFecha(@WebParam(name = "idod") Integer idod, @WebParam(name = "fecha") String fecha) {
        if (validadorInter()) {
            return jPersonasBloqueadasService.buscaJPersonasBloqueadasPorIdODFecha(idod, fecha);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "eliminaJPersonasBloqueadasPorId", action = "eliminaJPersonasBloqueadasPorId")
    public PaqueteDTO eliminaJPersonasBloqueadasPorId(@WebParam(name = "id_doc") String id_doc, @WebParam(name = "idod") int idod, @WebParam(name = "fecha") String fecha) {
        if (validadorInter()) {
            return jPersonasBloqueadasService.eliminaJPersonasBloqueadasPorIds(id_doc, idod, fecha);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaJPersonasBloqueadasHPorId", action = "buscaJPersonasBloqueadasHPorId")
    public JPersonasBloqueadasDTO buscaJPersonasBloqueadasHPorId(@WebParam(name = "id_doc") String id_doc, @WebParam(name = "idod") int idod, @WebParam(name = "fecha") String fecha) {
        if (validadorInter()) {
            return jPersonasBloqueadas_HService.buscaJPersonasBloqueadasHPorIds(id_doc, idod, fecha);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaTodasLasJPersonasBloqueadasH", action = "buscaTodasLasJPersonasBloqueadasH")
    public PaqueteDTO buscaTodasLasJPersonasBloqueadasH() {
        if (validadorInter()) {
            return jPersonasBloqueadas_HService.buscaTodasLasJPersonasBloqueadasH();
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "insertarJPersonasBloqueadasH", action = "insertarJPersonasBloqueadasH")
    public PaqueteDTO insertarJPersonasBloqueadasH(
            @WebParam(name = "id_doc") String id_doc,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "rfc") String rfc,
            @WebParam(name = "curp") String curp,
            @WebParam(name = "idod") Integer idod,
            @WebParam(name = "fecha") String fecha,
            @WebParam(name = "fecha_alta_saicoop") String fecha_alta_saicoop,
            @WebParam(name = "dato1") String dato1,
            @WebParam(name = "dato2") String dato2,
            @WebParam(name = "dato3") String dato3,
            @WebParam(name = "usuario_baja") int usuario_baja) {
        if (validadorInter()) {
            return jPersonasBloqueadas_HService.insertarJPersonasBloqueadasH(id_doc, nombre, rfc, curp, idod, fecha, fecha_alta_saicoop, dato1, dato2, dato3, usuario_baja);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "eliminaJPersonasBloqueadasHPorId", action = "eliminaJPersonasBloqueadasHPorId")
    public PaqueteDTO eliminaJPersonasBloqueadasHPorId(@WebParam(name = "id") int id) {
        if (validadorInter()) {
            return jPersonasBloqueadas_HService.eliminaJPersonasBloqueadasHPorId(id);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaJOrigenDatosPorId", action = "buscaJOrigenDatosPorId")
    public JOrigenDatosDTO buscaJOrigenDatosPorId(@WebParam(name = "idod") int idod) {
        if (validadorInter()) {
            return jOrigenDatosService.buscaJOrigenDatosPorId(idod);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaTodasLasJOrigenDatos", action = "buscaTodasLasJOrigenDatos")
    public PaqueteDTO buscaTodasLasJOrigenDatos() {
        if (validadorInter()) {
            return jOrigenDatosService.buscaTodasLasJOrigenDatos();
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "JOrigenDatosCU", action = "JOrigenDatosCU")
    public PaqueteDTO JOrigenDatosCU(@WebParam(name = "esInserta") boolean esInserta,
            @WebParam(name = "idod") Integer idod,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "url") String url,
            @WebParam(name = "tipo") String tipo,
            @WebParam(name = "idmenu") Integer idmenu,
            @WebParam(name = "config_lectura") String config_lectura,
            @WebParam(name = "charset_lectura") String charset_lectura,
            @WebParam(name = "charset_escritura") String charset_escritura) {
        if (validadorInter()) {
            return jOrigenDatosService.JOrigenDatosCU(esInserta, idod, nombre, descripcion, url, tipo, idmenu, config_lectura, charset_lectura, charset_escritura);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "eliminaJOrigenDatosPorId", action = "eliminaJOrigenDatosPorId")
    public PaqueteDTO eliminaJOrigenDatosPorId(@WebParam(name = "idod") int idod) {
        if (validadorInter()) {
            return jOrigenDatosService.eliminaJOrigenDatosPorId(idod);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @return
     */
    @WebMethod(operationName = "buscaTodoElCatalogoDeMenu", action = "buscaTodoElCatalogoDeMenu")
    public PaqueteDTO buscaTodoElCatalogoDeMenu() {
        if (validadorInter()) {
            return jCatalogoMenusService.buscaTodoElCatalogoDeMenu();
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param idmenu
     * @return
     */
    @WebMethod(operationName = "buscaMenuPorId", action = "buscaMenuPorId")
    public JCatalogoMenusDTO buscaMenuPorId(@WebParam(name = "idmenu") int idmenu) {
        if (validadorInter()) {
            return jCatalogoMenusService.buscaMenuPorId(idmenu);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param idusuario
     * @param permiso
     * @return
     */
    @WebMethod(operationName = "permisos", action = "permisos")
    public boolean permisos(@WebParam(name = "idusuario") int idusuario,
            @WebParam(name = "permiso") String permiso) {
        if (validadorInter()) {
            return usuariospermisosService.permisos(idusuario, permiso);
        } else {
            return false;
        }
    }

    /**/
    /**
     *
     * @param idpermiso
     * @return
     */
    @WebMethod(operationName = "buscaJPermiso", action = "buscaJPermiso")
    public JPermisosDTO buscaJPermiso(@WebParam(name = "idpermiso") int idpermiso) {
        if (validadorInter()) {
            return permisosService.buscaJPermiso(idpermiso);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @return
     */
    @WebMethod(operationName = "buscaPermisos", action = "buscaPermisos")
    public List<JPermisosDTO> buscaPermisos() {
        if (validadorInter()) {
            return permisosService.buscaJPermisos();
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param idusuario
     * @return
     */
    @WebMethod(operationName = "buscarpermisosporIdUsuario", action = "buscarpermisosporIdUsuario")
    public List<JUsuariospermisosDTO> buscarpermisosporIdUsuario(@WebParam(name = "idusuario") int idusuario
    ) {
        if (validadorInter()) {
            return usuariospermisosService.buscaPermisosporIdUsuario(idusuario);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @return
     */
    @WebMethod(operationName = "proximoIndiceJUGrupos", action = "proximoIndiceJUGrupos")
    public int proximoIndiceJUGrupos() {
        if (validadorInter()) {
            return ugruposService.proximoIndiceJUGrupos();
        } else {
            return 0;
        }
    }

    /**/
    /**
     *
     * @param idugrupo
     * @return
     */
    @WebMethod(operationName = "eliminaJUgrupo", action = "eliminaJUgrupo")
    public PaqueteDTO eliminaJUgrupo(@WebParam(name = "idugrupo") int idugrupo) {
        if (validadorInter()) {
            return ugruposService.eliminaJUgrupo(idugrupo);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param esInserta
     * @param idugrupo
     * @param nombre
     * @return
     */
    @WebMethod(operationName = "jUGruposCU", action = "jUGruposCU")
    public PaqueteDTO jUGruposCU(@WebParam(name = "esInserta") boolean esInserta, @WebParam(name = "idugrupo") int idugrupo, @WebParam(name = "nombre") String nombre) {
        if (validadorInter()) {
            return ugruposService.jUgruposCU(esInserta, idugrupo, nombre);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param idgrupo
     * @return
     */
    @WebMethod(operationName = "buscaUgrupoPorId", action = "buscaUgrupoPorId")
    public JUgruposDTO buscaUgrupoPorId(@WebParam(name = "idgrupo") int idgrupo) {
        if (validadorInter()) {
            return ugruposService.buscaJUGrupoPorIdugrupo(idgrupo);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @return
     */
    @WebMethod(operationName = "buscaTodosLosUgrupos", action = "buscaTodosLosUgrupos")
    public List<JUgruposDTO> buscaTodosLosUgrupos() {
        if (validadorInter()) {
            return ugruposService.buscaLosJUGrupos();
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @return
     */
    @WebMethod(operationName = "buscaTodosLosUgruposPermisos", action = "buscaTodosLosUgruposPermisos")
    public List<JUgruposPermisosDTO> buscaTodosLosUgruposPermisos() {
        if (validadorInter()) {
            return ugruposPermisosService.buscaTodosLosUgruposPermisos();
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param idugrupo
     * @return
     */
    @WebMethod(operationName = "buscaUgruposPermisos", action = "buscaUgruposPermisos")
    public List<JUgruposPermisosDTO> buscaUgruposPermisos(@WebParam(name = "idugrpo") int idugrupo) {
        if (validadorInter()) {
            return ugruposPermisosService.buscaUgruposPermisos(idugrupo);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param idusuario
     * @return
     */
    @WebMethod(operationName = "buscaPermisosInnerJoinUsuariosugrupos", action = "buscaPermisosInnerJoinUsuariosugrupos")
    public List<JUgruposPermisosDTO> buscaPermisosInnerJoinUsuariosugrupos(@WebParam(name = "idusuario") int idusuario) {
        if (validadorInter()) {
            return ugruposPermisosService.buscaPermisosInnerJoinUsuariosugrupos(idusuario);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param idusuario
     * @return
     */
    @WebMethod(operationName = "buscaruGruposporIdUsuario", action = "buscaruGruposporIdUsuario")
    public List<JUsuariosugruposDTO> buscaruGruposporIdUsuario(@WebParam(name = "idusuario") int idusuario) {
        if (validadorInter()) {
            return usuariosugruposService.buscauGruposporIdUsuario(idusuario);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param idusuario
     * @return
     */
    @WebMethod(operationName = "buscarUsuarioPorIdLogin", action = "buscarUsuarioPorIdLogin")
    public UsuariosDTO buscarUsuarioPorIdLogin(@WebParam(name = "idusuario") int idusuario) {
        if (validadorInter()) {
            UsuariosDTO usuariodto = usuariosService.buscaUsuarioPorId(idusuario);
            if (usuariodto != null) {
                session.setAttribute("idusuario", usuariodto.getIdusuario());
                return usuariodto;
            } else {
                return null;
            }
        }
        return null;
    }

    /**/
    /**
     *
     * @param idusuario
     * @return
     */
    @WebMethod(operationName = "buscarUsuarioPorId", action = "buscarUsuarioPorId")
    public UsuariosDTO buscarUsuarioPorId(@WebParam(name = "idusuario") int idusuario) {
        if (validadorInter()) {
            UsuariosDTO usuariodto = usuariosService.buscaUsuarioPorId(idusuario);
            return usuariodto;
        }
        return null;
    }

    /**
     *
     * @param idusuario
     * @param pingreso
     */
    @WebMethod(operationName = "actualizaPIngresoEnUsuario", action = "actualizaPIngresoEnUsuario")
    public void actualizaPIngresoEnUsuario(@WebParam(name = "idusuario") int idusuario,
            @WebParam(name = "pingreso") String pingreso) {
        if (validadorInter()) {
            usuariosService.actualizaPIngreso(idusuario, pingreso);
        }
    }

    /**
     *
     * @param idproducto
     * @return
     */
    @WebMethod(operationName = "buscarProductoPorId", action = "buscarProductoPorId")
    public ProductosDTO buscarProductoPorId(@WebParam(name = "idproducto") int idproducto
    ) {
        if (validadorInter()) {
            return productosService.buscaProductoPorId(idproducto);
        } else {
            return null;
        }
    }

    /**
     *
     * @param formatohuella
     * @return
     */
    @WebMethod(operationName = "buscarTodoHuellaUsuario", action = "buscarTodoHuellaUsuario")
    public List<HuellasDpUsuarioDTO> buscarTodoHuellaUsuario(@WebParam(name = "formatohuella") int formatohuella
    ) {
        if (validadorInter()) {
            return huellasDpUsuarioService.buscarTodoHuellaUsuario(formatohuella);
        } else {
            return null;
        }
    }

    /**
     *
     * @param idusuario
     * @param formatoHuella
     * @return
     */
    @WebMethod(operationName = "buscarHuellaUsuario", action = "buscarHuellaUsuario")
    public HuellasDpUsuarioDTO buscarHuellaUsuario(@WebParam(name = "idusuario") int idusuario,
            @WebParam(name = "formatoHuella") int formatoHuella
    ) {
        if (validadorInter()) {
            return huellasDpUsuarioService.buscaHuellaUsuario(idusuario, formatoHuella);
        } else {
            return null;
        }
    }

    /**
     *
     * @param esInserta
     * @param idusuarioIngreso
     * @param idusuarioCapturo
     * @param templateREG
     * @param templateVER
     * @return
     */
    @WebMethod(operationName = "huellaDigitalUsuario", action = "huellaDigitalUsuario")
    public boolean huellaDigitalUsuario(
            @WebParam(name = "esInserta") boolean esInserta,
            @WebParam(name = "idusuarioIngreso") int idusuarioIngreso,
            @WebParam(name = "idusuarioCapturo") int idusuarioCapturo,
            @WebParam(name = "templateREG") List<byte[]> templateREG,
            @WebParam(name = "templateVER") List<byte[]> templateVER
    ) {
        if (validadorInter()) {
            return huellasDpUsuarioService.huellaDigitalUsuario(esInserta, idusuarioIngreso, idusuarioCapturo, templateREG, templateVER);
        } else {
            return false;
        }
    }

    /**
     *
     * @param idorigen
     * @param idgrupo
     * @param idsocio
     * @return
     */
    @WebMethod(operationName = "buscarHuellaPorSocio", action = "buscarHuellaPorSocio")
    public HuellasDpDTO buscarHuellaPorSocio(@WebParam(name = "idorigen") int idorigen,
            @WebParam(name = "idgrupo") int idgrupo,
            @WebParam(name = "idsocio") int idsocio
    ) {
        if (validadorInter()) {
            return huellasDpService.buscarHuellaPorSocio(idorigen, idgrupo, idsocio);
        } else {
            return null;
        }
    }

    /**
     *
     * @param limit
     * @param offset
     * @return
     */
    @WebMethod(operationName = "buscarTodasHuellasSocio", action = "buscarTodasHuellasSocio")
    public List<HuellasDpDTO> buscarTodasHuellasSocio(@WebParam(name = "limit") int limit,
            @WebParam(name = "offset") int offset
    ) {
        if (validadorInter()) {
            return huellasDpService.buscarTodasHuellasSocio(limit, offset);
        } else {
            return null;
        }
    }

    /**
     *
     * @param estatus
     * @return
     */
    @WebMethod(operationName = "buscarTodasHuellasSocioSinByte", action = "buscarTodasHuellasSocioSinByte")
    public List<HuellasDpDTO> buscarTodasHuellasSocioSinByte(@WebParam(name = "estatus") boolean estatus
    ) {
        if (validadorInter()) {
            return huellasDpService.buscarTodasHuellasSocioSinByte(estatus);
        } else {
            return null;
        }
    }

    /**
     *
     * @param idorigenc
     * @param periodo
     * @param idtipo
     * @param idpoliza
     * @return
     */
    @WebMethod(operationName = "buscaAuxiliaresdDTOPorIdPoliza", action = "buscaAuxiliaresdDTOPorIdPoliza")
    public List<AuxiliaresDDTO> buscaAuxiliaresdDTOPorIdPoliza(@WebParam(name = "idorigenc") int idorigenc,
            @WebParam(name = "periodo") String periodo,
            @WebParam(name = "idtipo") short idtipo,
            @WebParam(name = "idpoliza") int idpoliza) {
        if (validadorInter()) {
            return auxiliaresDService.buscaAuxiliaresdDTOPorIdPoliza(idorigenc, periodo, idtipo, idpoliza);
        } else {
            return null;
        }
    }

    /**
     *
     * @param idorigen
     * @param idgrupo
     * @param idsocio
     * @return
     */
    @WebMethod(operationName = "buscarAuxiliaresPorIds", action = "buscarAuxiliaresPorIds")
    public List<AuxiliaresDTO> buscarAuxiliaresPorIds(@WebParam(name = "idorigen") int idorigen,
            @WebParam(name = "idgrupo") int idgrupo,
            @WebParam(name = "idsocio") int idsocio) {
        if (validadorInter()) {
            return auxiliaresService.buscaAuxiliaresPorIds(idorigen, idgrupo, idsocio);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaAuxiliaresParaEstadosDeCuenta", action = "buscaAuxiliaresParaEstadosDeCuenta")
    public List<AuxiliaresDTO> buscaAuxiliaresParaEstadosDeCuenta(@WebParam(name = "fechainicial") String fechainicial, @WebParam(name = "fechafinal") String fechafinal, @WebParam(name = "tipo") String tipo) {
        if (validadorInter()) {
            return auxiliaresService.buscaAuxiliaresParaEstadosDeCuenta(fechainicial, fechafinal, tipo);
        } else {
            return null;
        }
    }

    /**
     *
     * @param idorigen
     * @return
     */
    @WebMethod(operationName = "buscaPersonasPorOrigen", action = "buscaPersonasPorOrigen")
    public List<PersonasDTO> buscaPersonasPorOrigen(@WebParam(name = "idorigen") int idorigen) {
        if (validadorInter()) {
            return personasService.buscaPersonasPorOrigen(idorigen);
        } else {
            return null;
        }
    }

    /**
     *
     * @param idgrupo
     * @return
     */
    @WebMethod(operationName = "buscaPersonasPorGrupo", action = "buscaPersonasPorGrupo")
    public List<PersonasDTO> buscaPersonasPorGrupo(@WebParam(name = "idgrupo") int idgrupo
    ) {
        if (validadorInter()) {
            return personasService.buscaPersonasPorGrupo(idgrupo);
        } else {
            return null;
        }
    }

    /**
     *
     * @param idorigen
     * @param idgrupo
     * @param idsocio
     * @return
     */
    @WebMethod(operationName = "buscaPersona", action = "buscaPersona")
    public PersonasDTO buscaPersona(@WebParam(name = "idorigen") int idorigen,
            @WebParam(name = "idgrupo") int idgrupo,
            @WebParam(name = "idsocio") int idsocio) {
        if (validadorInter()) {
            return personasService.buscaPersona(idorigen, idgrupo, idsocio);
        } else {
            return null;
        }
    }

    /**
     * @param persona
     * @param paterno
     * @param materno
     * @param nombre
     * @param rfc
     * @param curp
     * @return
     */
    @WebMethod(operationName = "buscaPersonaCnbv", action = "buscaPersonaCnbv")
    public List<PersonasDTO> buscaPersonaCnbv(@WebParam(name = "persona") String persona,
            @WebParam(name = "paterno") String paterno,
            @WebParam(name = "materno") String materno,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "rfc") String rfc,
            @WebParam(name = "curp") String curp) {
        if (validadorInter()) {
            return personasService.buscaPersonaCnbv(persona, paterno, materno, nombre, rfc, curp);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @return
     */
    @WebMethod(operationName = "buscaTodosLasPersonaCnbv", action = "buscaTodosLasPersonaCnbv")
    public List<PersonaCnbvDTO> buscaTodosLasPersonaCnbv() {
        if (validadorInter()) {
            return personaCnbvService.buscaTodosLasPersonaCnbv();
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param expediente
     * @return
     */
    @WebMethod(operationName = "buscaPersonaCnbvPorExpediente", action = "buscaPersonaCnbvPorExpediente")
    public List<PersonaCnbvDTO> buscaPersonaCnbvPorExpediente(@WebParam(name = "expediente") String expediente) {
        if (validadorInter()) {
            return personaCnbvService.buscaPersonaCnbvPorExpediente(expediente);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param expediente
     * @param personaid
     * @return
     */
    @WebMethod(operationName = "buscaPersonaCnbvPorExpedienteYId", action = "buscaPersonaCnbvPorExpedienteYId")
    public PersonaCnbvDTO buscaPersonaCnbvPorExpedienteYId(@WebParam(name = "expediente") String expediente, @WebParam(name = "personaid") int personaid) {
        if (validadorInter()) {
            return personaCnbvService.buscaPersonaCnbvPorExpedienteYId(expediente, personaid);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param expediente
     * @param personaid
     * @param caracter
     * @param persona
     * @param paterno
     * @param materno
     * @param nombre
     * @param rfc
     * @param curp
     * @param relacion
     * @param domicilio
     * @param complementarios
     * @param xml
     * @return
     */
    @WebMethod(operationName = "insertaPersonaCnbv", action = "insertaPersonaCnbv")
    public PaqueteDTO insertaPersonaCnbv(@WebParam(name = "expediente") String expediente,
            @WebParam(name = "personaid") int personaid,
            @WebParam(name = "caracter") String caracter,
            @WebParam(name = "persona") String persona,
            @WebParam(name = "paterno") String paterno,
            @WebParam(name = "materno") String materno,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "rfc") String rfc,
            @WebParam(name = "curp") String curp,
            @WebParam(name = "domicilio") String domicilio,
            @WebParam(name = "relacion") String relacion,
            @WebParam(name = "complementarios") String complementarios,
            @WebParam(name = "xml") Boolean xml) {
        if (validadorInter()) {
            return personaCnbvService.insertaPersonaCnbv(expediente, personaid, caracter, persona, paterno, materno, nombre, rfc, curp, domicilio, relacion, complementarios, xml);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param expediente
     * @param personaid
     * @param caracter
     * @param persona
     * @param paterno
     * @param materno
     * @param nombre
     * @param rfc
     * @param curp
     * @param relacion
     * @param domicilio
     * @param complementarios
     * @param xml
     * @return
     */
    @WebMethod(operationName = "actualizaPersonaCnbv", action = "actualizaPersonaCnbv")
    public PaqueteDTO actualizaPersonaCnbv(@WebParam(name = "expediente") String expediente,
            @WebParam(name = "personaid") int personaid,
            @WebParam(name = "caracter") String caracter,
            @WebParam(name = "persona") String persona,
            @WebParam(name = "paterno") String paterno,
            @WebParam(name = "materno") String materno,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "rfc") String rfc,
            @WebParam(name = "curp") String curp,
            @WebParam(name = "domicilio") String domicilio,
            @WebParam(name = "relacion") String relacion,
            @WebParam(name = "complementarios") String complementarios,
            @WebParam(name = "xml") Boolean xml) {
        if (validadorInter()) {
            return personaCnbvService.actualizaPersonaCnbv(expediente, personaid, caracter, persona, paterno, materno, nombre, rfc, curp, domicilio, relacion, complementarios, xml);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param expediente
     * @param personaid
     * @return
     */
    @WebMethod(operationName = "borraExpedienteCnbv", action = "borraExpedienteCnbv")
    public PaqueteDTO borraExpedienteCnbv(@WebParam(name = "expediente") String expediente, @WebParam(name = "personaid") int personaid) {
        if (validadorInter()) {
            return personaCnbvService.borraExpedienteCnbv(expediente, personaid);
        } else {
            return null;
        }
    }

    /**/
    /**
     *
     * @param expediente
     * @return
     */
    @WebMethod(operationName = "borraPersonaCnbv", action = "borraPersonaCnbv")
    public PaqueteDTO borraPersonaCnbv(@WebParam(name = "expediente") String expediente) {
        if (validadorInter()) {
            return personaCnbvService.borraPersonaCnbv(expediente);
        } else {
            return null;
        }
    }

    /**
     *
     * @param idfinalidad
     * @return
     */
    @WebMethod(operationName = "buscaFinalidadPorId", action = "buscaFinalidadPorId")
    public FinalidadesDTO buscaFinalidadPorId(@WebParam(name = "idfinalidad") int idfinalidad
    ) {
        if (validadorInter()) {
            return finalidadesService.buscaFinalidadPorId(idfinalidad);
        } else {
            return null;
        }
    }

    /**
     *
     * @param dependede
     * @return
     */
    @WebMethod(operationName = "buscaFinalidadesPorDependencia", action = "buscaFinalidadesPorDependencia")
    public List<FinalidadesDTO> buscaFinalidadesPorDependencia(@WebParam(name = "dependede") int dependede
    ) {
        if (validadorInter()) {
            return finalidadesService.buscaFinalidadesPorDependencia(dependede);
        } else {
            return null;
        }
    }

    /**
     *
     * @return
     */
    @WebMethod(operationName = "buscaTodasLasFinalidades", action = "buscaTodasLasFinalidades")
    public List<FinalidadesDTO> buscaTodasLasFinalidades() {
        if (validadorInter()) {
            return finalidadesService.buscaTodasLasFinalidades();
        } else {
            return null;
        }

    }

    /**
     *
     * @param idfinalidad
     * @param descripcion
     * @param dependede
     * @param clasif_contable_siti
     * @return
     */
    @WebMethod(operationName = "guardarFinalidad", action = "guardarFinalidad")
    public int guardarFinalidad(
            @WebParam(name = "idfinalidad") int idfinalidad,
            @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "dependede") int dependede,
            @WebParam(name = "clasif_contable_siti") Long clasif_contable_siti
    ) {
        if (validadorInter()) {
            return finalidadesService.finalidadesCU(true, idfinalidad, descripcion, dependede, clasif_contable_siti);
        } else {
            return 0;
        }
    }

    /**
     *
     * @param idfinalidad
     * @param descripcion
     * @param dependede
     * @param clasif_contable_siti
     * @return
     */
    @WebMethod(operationName = "actualizarFinalidad", action = "actualizarFinalidad")
    public int actualizarFinalidad(
            @WebParam(name = "idfinalidad") int idfinalidad,
            @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "dependede") int dependede,
            @WebParam(name = "clasif_contable_siti") Long clasif_contable_siti
    ) {
        if (validadorInter()) {
            return finalidadesService.finalidadesCU(false, idfinalidad, descripcion, dependede, clasif_contable_siti);
        } else {
            return 0;
        }
    }

    /**
     *
     * @param idfinalidad
     * @return
     */
    @WebMethod(operationName = "borrarFinalidad", action = "borrarFinalidad")
    public int borrarFinalidad(@WebParam(name = "idfinalidad") int idfinalidad) {
        if (validadorInter()) {
            return finalidadesService.borrarFinalidad(idfinalidad);
        } else {
            return 0;
        }
    }

    @WebMethod(operationName = "proximoIdFinalidad", action = "proximoIdFinalidad")
    public int proximoIdFinalidad() {
        if (validadorInter()) {
            return finalidadesService.proximoIdFinalidad();
        } else {
            return 0;
        }
    }

    /**
     *
     * @return
     */
    @WebMethod(operationName = "buscarTodosLosMunicipos", action = "buscarTodosLosMunicipos")
    public List<MunicipiosDTO> buscarTodosLosMunicipos() {
        if (validadorInter()) {
            return municipiosService.buscarTodosLosMunicipos();
        } else {
            return null;
        }
    }

    /**
     *
     * @param idmunicipio
     * @return
     */
    @WebMethod(operationName = "buscarMunicipio", action = "buscarMunicipio")
    public MunicipiosDTO buscarMunicipio(@WebParam(name = "idmunicipio") int idmunicipio
    ) {
        if (validadorInter()) {
            return municipiosService.buscarMunicipio(idmunicipio);
        } else {
            return null;
        }
    }

    /**
     *
     * @param idestado
     * @return
     */
    @WebMethod(operationName = "buscarMuniciposPorEstado", action = "buscarMuniciposPorEstado")
    public List<MunicipiosDTO> buscarMuniciposPorEstado(@WebParam(name = "idestado") int idestado
    ) {
        if (validadorInter()) {
            return municipiosService.buscarMuniciposPorEstado(idestado);
        } else {
            return null;
        }
    }

    /**
     *
     * @param idmunicipio
     * @param nombre
     * @param idestado
     * @param de_cp
     * @param a_cp
     * @return
     */
    @WebMethod(operationName = "guardarmunicipio", action = "guardarmunicipio")
    public int guardarmunicipio(@WebParam(name = "idmunicipio") int idmunicipio,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "idestado") int idestado,
            @WebParam(name = "de_cp") String de_cp,
            @WebParam(name = "a_cp") String a_cp
    ) {
        if (validadorInter()) {
            return municipiosService.municipiosCU(true, idmunicipio, nombre, idestado, de_cp, a_cp);
        } else {
            return 0;
        }
    }

    /**
     *
     * @param idmunicipio
     * @param nombre
     * @param idestado
     * @param de_cp
     * @param a_cp
     * @return
     */
    @WebMethod(operationName = "actualizarMunicipio", action = "actualizarMunicipio")
    public int actualizarMunicipio(@WebParam(name = "idmunicipio") int idmunicipio,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "idestado") int idestado,
            @WebParam(name = "de_cp") String de_cp,
            @WebParam(name = "a_cp") String a_cp) {
        if (validadorInter()) {
            return municipiosService.municipiosCU(false, idmunicipio, nombre, idestado, de_cp, a_cp);
        } else {
            return 0;
        }
    }

    /**
     *
     * @param idmunicipio
     * @return
     */
    @WebMethod(operationName = "borrarMunicipio", action = "borrarMunicipio")
    public int borrarMunicipio(@WebParam(name = "idmunicipio") int idmunicipio
    ) {
        if (validadorInter()) {
            return municipiosService.borrarMunicipio(idmunicipio);
        } else {
            return 0;
        }
    }

    /**
     *
     * @return
     */
    @WebMethod(operationName = "ultimoMunicipio", action = "ultimoMunicipio")
    public MunicipiosDTO ultimoMunicipio() {
        if (validadorInter()) {
            return municipiosService.ultimoMunicipio();
        } else {
            return null;
        }
    }

    /**
     *
     * @param idgrupo
     * @return
     */
    @WebMethod(operationName = "eliminarGrupo", action = "eliminarGrupo")
    public int eliminarGrupo(@WebParam(name = "idgrupo") int idgrupo
    ) {
        if (validadorInter()) {
            return gruposService.eliminarGrupo(idgrupo);
        } else {
            return 0;
        }
    }

    /**
     *
     * @param idgrupo
     * @param nombre
     * @param tipogrupo
     * @return
     */
    @WebMethod(operationName = "guardarGrupo", action = "guardarGrupo")
    public int guardarGrupo(@WebParam(name = "idgrupo") int idgrupo,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "tipogrupo") int tipogrupo) {
        if (validadorInter()) {
            return gruposService.gruposCU(true, idgrupo, nombre, tipogrupo);
        } else {
            return 0;
        }
    }

    /**
     *
     * @param idgrupo
     * @param nombre
     * @param tipogrupo
     * @return
     */
    @WebMethod(operationName = "actualizaGrupo", action = "actualizaGrupo")
    public int actualizaGrupo(@WebParam(name = "idgrupo") int idgrupo,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "tipogrupo") int tipogrupo) {
        if (validadorInter()) {
            return gruposService.gruposCU(false, idgrupo, nombre, tipogrupo);
        } else {
            return 0;
        }
    }

    /**
     *
     * @param idgrupo
     * @return
     */
    @WebMethod(operationName = "buscaGrupo", action = "buscaGrupo")
    public GruposDTO buscaGrupo(@WebParam(name = "idgrupo") int idgrupo
    ) {
        if (validadorInter()) {
            return gruposService.buscaGrupo(idgrupo);
        } else {
            return null;
        }
    }

    /**
     *
     * @return
     */
    @WebMethod(operationName = "buscaTodosLosGrupos", action = "buscaTodosLosGrupos")
    public List<GruposDTO> buscaTodosLosGrupos() {
        if (validadorInter()) {
            return gruposService.buscaTodosLosGrupos();
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "proximoIdGrupos", action = "proximoIdGrupos")
    public int proximoIdGrupos() {
        if (validadorInter()) {
            return gruposService.proximoIdGrupos();
        } else {
            return 0;
        }
    }

    /**
     *
     * @param idsector
     * @return
     */
    @WebMethod(operationName = "buscaSectorPoId", action = "buscaSectorPoId")
    public SectoresDTO buscaSectorPoId(@WebParam(name = "idsector") int idsector) {
        if (validadorInter()) {
            return sectoresService.buscaSectorPoId(idsector);
        } else {
            return null;
        }
    }

    /**
     *
     * @return
     */
    @WebMethod(operationName = "buscaTodosLosSectores", action = "buscaTodosLosSectores")
    public List<SectoresDTO> buscaTodosLosSectores() {
        if (validadorInter()) {
            return sectoresService.buscaTodosLosSectores();
        } else {
            return null;
        }
    }

    /**
     *
     * @param idsector
     * @param nombre
     * @return
     */
    @WebMethod(operationName = "guardarSector", action = "guardarSector")
    public int guardarSector(@WebParam(name = "idsector") int idsector,
            @WebParam(name = "nombre") String nombre) {
        if (validadorInter()) {
            return sectoresService.sectoresCU(true, idsector, nombre);
        } else {
            return 0;
        }
    }

    /**
     *
     * @param idsector
     * @param nombre
     * @return
     */
    @WebMethod(operationName = "actualizarSector", action = "actualizarSector")
    public int actualizarSector(@WebParam(name = "idsector") int idsector,
            @WebParam(name = "nombre") String nombre) {
        if (validadorInter()) {
            return sectoresService.sectoresCU(false, idsector, nombre);
        } else {
            return 0;
        }

    }

    /**
     *
     * @param idsector
     * @return
     */
    @WebMethod(operationName = "borrarSector", action = "borrarSector")
    public int borrarSector(@WebParam(name = "idsector") int idsector) {
        if (validadorInter()) {
            return sectoresService.borrarSector(idsector);
        } else {
            return 0;
        }

    }

    @WebMethod(operationName = "proximoIdSector", action = "proximoIdSector")
    public int proximoIdSector() {
        if (validadorInter()) {
            return sectoresService.proximoIdSector();
        } else {
            return 0;
        }
    }

    /**
     *
     * @param idbanco
     * @return
     */
    @WebMethod(operationName = "buscaBancosPorId", action = "buscaBancosPorId")
    public BancosDTO buscaBancosPorId(@WebParam(name = "idbanco") int idbanco) {
        if (validadorInter()) {
            return bancosService.buscaBancosPorId(idbanco);
        } else {
            return null;
        }

    }

    /**
     *
     * @return
     */
    @WebMethod(operationName = "buscaTodosLosBancos", action = "buscaTodosLosBancos")
    public List<BancosDTO> buscaTodosLosBancos() {
        if (validadorInter()) {
            return bancosService.buscaTodosLosBancos();
        } else {
            return null;
        }

    }

    /**
     *
     * @param idbanco
     * @param nombre
     * @param banco_receptor
     * @return
     */
    @WebMethod(operationName = "guardarBanco", action = "guardarBanco")
    public int guardarBanco(@WebParam(name = "idbanco") int idbanco,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "banco_receptor") String banco_receptor) {
        if (validadorInter()) {
            return bancosService.bancosCU(true, idbanco, nombre, banco_receptor);
        } else {
            return 0;
        }
    }

    /**
     *
     * @param idbanco
     * @param nombre
     * @param banco_receptor
     * @return
     */
    @WebMethod(operationName = "actualizarBanco", action = "actualizarBanco")
    public int actualizarBanco(@WebParam(name = "idbanco") int idbanco,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "banco_receptor") String banco_receptor) {
        if (validadorInter()) {
            return bancosService.bancosCU(false, idbanco, nombre, banco_receptor);
        } else {
            return 0;
        }
    }

    /**
     *
     * @param idbanco
     * @return
     */
    @WebMethod(operationName = "borrarBanco", action = "borrarBanco")
    public int borrarBanco(@WebParam(name = "idbanco") int idbanco) {
        if (validadorInter()) {
            return bancosService.borrarBanco(idbanco);
        } else {
            return 0;
        }
    }

    @WebMethod(operationName = "proximoIdBanco", action = "proximoIdBanco")
    public int proximoIdBanco() {
        if (validadorInter()) {
            return bancosService.proximoIdBanco();
        } else {
            return 0;
        }
    }

    /**
     *
     * @param idchequera
     * @return
     */
    @WebMethod(operationName = "buscaChequeraPorId", action = "buscaChequeraPorId")
    public ChequerasDTO buscaChequeraPorId(@WebParam(name = "idchequera") int idchequera) {
        if (validadorInter()) {
            return chequerasService.buscaChequeraPorId(idchequera);
        } else {
            return null;
        }
    }

    /**
     *
     * @return
     */
    @WebMethod(operationName = "buscaTodasLasChequeras", action = "buscaTodasLasChequeras")
    public List<ChequerasDTO> buscaTodasLasChequeras() {
        if (validadorInter()) {
            return chequerasService.buscaTodasLasChequeras();
        } else {
            return null;
        }
    }

    /**
     *
     * @param idchequera
     * @param idbanco
     * @param nombre
     * @param idcuenta
     * @param ultimocheque
     * @param impresora
     * @param idorigen
     * @return
     */
    @WebMethod(operationName = "guardarChequera", action = "guardarChequera")
    public int guardarChequera(@WebParam(name = "idchequera") int idchequera,
            @WebParam(name = "idbanco") int idbanco,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "idcuenta") String idcuenta,
            @WebParam(name = "ultimocheque") int ultimocheque,
            @WebParam(name = "impresora") String impresora,
            @WebParam(name = "idorigen") int idorigen) {
        if (validadorInter()) {
            return chequerasService.chequerasCU(true, idchequera, idbanco, nombre, idcuenta, ultimocheque, impresora, idorigen);
        } else {
            return 0;
        }
    }

    /**
     *
     * @param idchequera
     * @param idbanco
     * @param nombre
     * @param idcuenta
     * @param ultimocheque
     * @param impresora
     * @param idorigen
     * @return
     */
    @WebMethod(operationName = "actualizarChequera", action = "actualizarChequera")
    public int actualizarChequera(@WebParam(name = "idchequera") int idchequera,
            @WebParam(name = "idbanco") int idbanco,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "idcuenta") String idcuenta,
            @WebParam(name = "ultimocheque") int ultimocheque,
            @WebParam(name = "impresora") String impresora,
            @WebParam(name = "idorigen") int idorigen) {
        if (validadorInter()) {
            return chequerasService.chequerasCU(false, idchequera, idbanco, nombre, idcuenta, ultimocheque, impresora, idorigen);
        } else {
            return 0;
        }
    }

    /**
     *
     * @param idchequera
     * @return
     */
    @WebMethod(operationName = "borrarChequera", action = "borrarChequera")
    public int borrarChequera(@WebParam(name = "idchequera") int idchequera) {
        if (validadorInter()) {
            return chequerasService.borrarChequera(idchequera);
        } else {
            return 0;
        }
    }

    @WebMethod(operationName = "proximoIdChequera", action = "proximoIdChequera")
    public int proximoIdChequera() {
        if (validadorInter()) {
            return chequerasService.proximoIdChequera();
        } else {
            return 0;
        }
    }

    /**
     *
     * @return
     */
    @WebMethod(operationName = "buscarTodasLasColonias", action = "buscarTodasLasColonias")
    public List<ColoniasDTO> buscarTodasLasColonias() {
        if (validadorInter()) {
            return coloniasService.buscarTodasLasColonias();
        } else {
            return null;
        }
    }

    /**
     *
     * @param idmunicipio
     * @return
     */
    @WebMethod(operationName = "buscarColoniasPorMunicipio", action = "buscarColoniasPorMunicipio")
    public List<ColoniasDTO> buscarColoniasPorMunicipio(@WebParam(name = "idmunicipio") int idmunicipio) {
        if (validadorInter()) {
            return coloniasService.buscarColoniasPorMunicipio(idmunicipio);
        } else {
            return null;
        }
    }

    /**
     *
     * @param idColonia
     * @return
     */
    @WebMethod(operationName = "buscarColonia", action = "buscarColonia")
    public ColoniasDTO buscarColonia(@WebParam(name = "idColonia") int idColonia) {
        if (validadorInter()) {
            return coloniasService.buscarColonia(idColonia);
        } else {
            return null;
        }
    }

    /**
     *
     * @return
     */
    @WebMethod(operationName = "buscarCompletoDatoColonias", action = "buscarCompletoDatoColonias")
    public List<CompletoDatoColoniasDTO> buscarCompletoDatoColonias() {
        if (validadorInter()) {
            return coloniasService.buscarCompletoDatoColonias();
        } else {
            return null;
        }
    }

    /**
     *
     * @param codigoPostalDe
     * @param codigoPostalA
     * @return
     */
    @WebMethod(operationName = "buscarPorRangoCodigoPostal", action = "buscarPorRangoCodigoPostal")
    public List<CompletoDatoColoniasDTO> buscarPorRangoCodigoPostal(@WebParam(name = "codigoPostalDe") int codigoPostalDe,
            @WebParam(name = "codigoPostalA") int codigoPostalA) {
        if (validadorInter()) {
            return coloniasService.buscarPorRangoCodigoPostal(codigoPostalDe, codigoPostalA);
        } else {
            return null;
        }
    }

    /**
     *
     * @param idcolonia
     * @param nombre
     * @param idmunicipio
     * @param codigopostal
     * @return
     */
    @WebMethod(operationName = "guardarColonia", action = "guardarColonia")
    public int guardarColonia(@WebParam(name = "idcolonia") int idcolonia,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "idmunicipio") int idmunicipio,
            @WebParam(name = "codigopostal") String codigopostal) {
        if (validadorInter()) {
            return coloniasService.coloniasCU(true, idcolonia, nombre, idmunicipio, codigopostal);
        } else {
            return 0;
        }
    }

    /**
     *
     * @param idcolonia
     * @param nombre
     * @param idmunicipio
     * @param codigopostal
     * @return
     */
    @WebMethod(operationName = "actualizarColonia", action = "actualizarColonia")
    public int actualizarColonia(@WebParam(name = "idcolonia") int idcolonia,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "idmunicipio") int idmunicipio,
            @WebParam(name = "codigopostal") String codigopostal
    ) {
        if (validadorInter()) {
            return coloniasService.coloniasCU(false, idcolonia, nombre, idmunicipio, codigopostal);
        } else {
            return 0;
        }
    }

    /**
     *
     * @param idcolonia
     * @return
     */
    @WebMethod(operationName = "borrarColonia", action = "borrarColonia")
    public int borrarColonia(@WebParam(name = "idcolonia") int idcolonia
    ) {
        if (validadorInter()) {
            return coloniasService.borrarColonia(idcolonia);
        } else {
            return 0;
        }
    }

    /**
     *
     * @return
     */
    @WebMethod(operationName = "ultimoColonia", action = "ultimoColonia")
    public ColoniasDTO ultimoColonia() {
        if (validadorInter()) {
            return coloniasService.ultimoColonia();
        } else {
            return null;
        }
    }

    /**
     *
     * @return
     */
    @WebMethod(operationName = "buscarTodosLosEstados", action = "buscarTodosLosEstados")
    public List<EstadosDTO> buscarTodosLosEstados() {
        if (validadorInter()) {
            return estadosService.buscarTodosLosEstados();
        } else {
            return null;
        }
    }

    /**
     *
     * @param idpais
     * @return
     */
    @WebMethod(operationName = "buscarEstadosPorPais", action = "buscarEstadosPorPais")
    public List<EstadosDTO> buscarEstadosPorPais(@WebParam(name = "idpais") int idpais
    ) {
        if (validadorInter()) {
            return estadosService.buscarEstadosPorPais(idpais);
        } else {
            return null;
        }
    }

    /**
     *
     * @param idestado
     * @return
     */
    @WebMethod(operationName = "buscarEstado", action = "buscarEstado")
    public EstadosDTO buscarEstado(@WebParam(name = "idestado") int idestado
    ) {
        if (validadorInter()) {
            return estadosService.buscarEstado(idestado);
        } else {
            return null;
        }
    }

    /**
     *
     * @param idestado
     * @param nombre
     * @param ef
     * @param idpais
     * @return
     */
    @WebMethod(operationName = "guardarEstado", action = "guardarEstado")
    public int guardarEstado(@WebParam(name = "idestado") int idestado,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "ef") String ef,
            @WebParam(name = "idpais") int idpais) {
        if (validadorInter()) {
            return estadosService.estadosCU(true, idestado, nombre, ef, idpais);
        } else {
            return 0;
        }
    }

    /**
     *
     * @param idestado
     * @param nombre
     * @param ef
     * @param idpais
     * @return
     */
    @WebMethod(operationName = "actualizarEstado", action = "actualizarEstado")
    public int actualizarEstado(@WebParam(name = "idestado") int idestado,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "ef") String ef,
            @WebParam(name = "idpais") int idpais) {
        if (validadorInter()) {
            return estadosService.estadosCU(false, idestado, nombre, ef, idpais);
        } else {
            return 0;
        }
    }

    /**
     *
     * @param idestado
     * @return
     */
    @WebMethod(operationName = "borrarEstado", action = "borrarEstado")
    public int borrarEstado(@WebParam(name = "idestado") int idestado) {
        if (validadorInter()) {
            return estadosService.borrarEstado(idestado);
        } else {
            return 0;
        }
    }

    /**
     *
     * @return
     */
    @WebMethod(operationName = "ultimoEstado", action = "ultimoEstado")
    public EstadosDTO ultimoEstado() {
        if (validadorInter()) {
            return estadosService.ultimoEstado();
        } else {
            return null;
        }
    }

    /**
     *
     * @return
     */
    @WebMethod(operationName = "buscaTodosLosPaises", action = "buscaTodosLosPaises")
    public List<PaisesDTO> buscaTodosLosPaises() {
        if (validadorInter()) {
            return paisesService.buscaTodosLosPaises();
        } else {
            return null;
        }
    }

    /**
     * CONTROL DE SESSION*
     */
    @Resource
    private WebServiceContext webServiceContext;
    private HttpSession session;
    private HttpServletRequest request;
    private final List<HttpSession> sessions = new ArrayList<>(0);

    //-- VALIDA EL USUARIO Y PASSWORD DE LA CABECERA DEL HTTP ------------------
    private boolean validadorInter() {
        MessageContext messageContext = webServiceContext.getMessageContext();
        request = (HttpServletRequest) messageContext.get(MessageContext.SERVLET_REQUEST);
        session = request.getSession();
        Map http_headers = (Map) messageContext.get(MessageContext.HTTP_REQUEST_HEADERS);
        List userList = (List) http_headers.get("USUARIO");
        List passList = (List) http_headers.get("CONTRASENA");
        String username = "";
        String password = "";
        if (userList != null && passList != null) {
            if (!userList.isEmpty() && !passList.isEmpty()) {
                // USUARIO Y CONTRASEÑA
                username = userList.get(0).toString();
                password = passList.get(0).toString();
                List idSesionList = (List) http_headers.get("IDSESION");
                List ipBaseDatosList = (List) http_headers.get("IPBASEDATOS");
                List baseDatosList = (List) http_headers.get("BASEDATOS");
                if (ipBaseDatosList != null && baseDatosList != null && idSesionList != null) {
                    datosConexion.setIp(ipBaseDatosList.get(0).toString());
                    datosConexion.setBd(baseDatosList.get(0).toString());
                    datosConexion.setIdSesion(idSesionList.get(0).toString());
                }
            }
        }
        return username.equals("usuario") && password.equals("contrasena");
    }

    // Verifica que la conexion a la base este activa
    @WebMethod(operationName = "verificaConexionBaseDatos", action = "verificaConexionBaseDatos")
    public boolean verificaConexionBaseDatos() {
        return datosConexion.verificaConexionBD();
    }

    /**/
    /**
     *
     * @return
     */
    @WebMethod(operationName = "idSesion", action = "idSesion")
    public String idSesion() {
        return session.getId();
    }

    /**/
    /**
     *
     * @return
     */
    @WebMethod(operationName = "validaSesion", action = "validaSesion")
    public boolean validaSesion() {
        if (validadorInter()) {
            try {
                String idusuario = session.getValue("idusuario").toString();
                if (idusuario != null) {
                    AdminSesionDTO sesion = adminSesionService.buscaAdminSesionPorUsuario(Integer.parseInt(idusuario));
                    if (sesion.isEstatus()) {
                        if (!sesion.getSesionservidor().equals(datosConexion.getIdSesion())) {
                            return false;
                        }
                    }
                    if (sesion.isBloqueado()) {
                        return false;
                    }
                } else {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
            return true;
        }
        return false;
    }

    /*
     este metodo lo que hace es cargar los datos en la sesion y genera el
     formatFactory para meterlo dentro de la sesion
     checa si existe en la lista de sesiones, si existe la remplaza y si no la guarda
     envia el entityfactory a  datos conexion y despues checa que funcione correctamente.
     */
    /**
     * Web service operation
     *
     * @param iplocal
     * @param ipExterna
     * @param macAddress
     * @param ipBaseDatos
     * @param baseDatos
     * @param usuarioSistemaOperativo
     * @param sistemaOperativo
     * @param versionSistemaOperativo
     * @param arquitecturaSistemaOperativo
     * @return
     */
    @WebMethod(operationName = "datosCliente", action = "datosCliente")
    public boolean datosCliente(@WebParam(name = "iplocal") String iplocal,
            @WebParam(name = "ipExterna") String ipExterna,
            @WebParam(name = "macAddress") String macAddress,
            @WebParam(name = "ipBaseDatos") String ipBaseDatos,
            @WebParam(name = "baseDatos") String baseDatos,
            @WebParam(name = "usuarioSistemaOperativo") String usuarioSistemaOperativo,
            @WebParam(name = "sistemaOperativo") String sistemaOperativo,
            @WebParam(name = "versionSistemaOperativo") String versionSistemaOperativo,
            @WebParam(name = "arquitecturaSistemaOperativo") String arquitecturaSistemaOperativo) {
        boolean validaUsuarioPassword = validadorInter();
        if (validaUsuarioPassword) {
            try {
                // Si es valida la sesion se agregan los datos del cliente.
                session.setAttribute("iplocal", iplocal);
                session.setAttribute("ipExterna", ipExterna);
                session.setAttribute("macAddress", macAddress);
                session.setAttribute("ipBaseDatos", ipBaseDatos);
                session.setAttribute("baseDatos", baseDatos);
                session.setAttribute("usuarioSistemaOperativo", usuarioSistemaOperativo);
                session.setAttribute("sistemaOperativo", sistemaOperativo);
                session.setAttribute("versionSistemaOperativo", versionSistemaOperativo);
                session.setAttribute("arquitecturaSistemaOperativo", arquitecturaSistemaOperativo);
                session.setAttribute("estado", Boolean.TRUE);
            } catch (Exception e) {
                System.out.println("Error: clase SAICoop, metodo conexion: " + e.getMessage());
                return false;
            }
        }
        return validaUsuarioPassword;
    }

    /**
     *
     * @param idusuario
     * @return
     */
    @WebMethod(operationName = "insertaSesion", action = "insertaSesion")
    public boolean insertaSesion(@WebParam(name = "idusuario") int idusuario) {
        /*
        System.out.println("1 " + idusuario);
        System.out.println("2 " + datosConexion.getIdSesion());
        System.out.println("3 " + session.getAttribute("iplocal").toString());
        System.out.println("4 " + session.getAttribute("ipExterna").toString());
        System.out.println("5 " + session.getAttribute("macAddress").toString());
        System.out.println("6 " + session.getAttribute("ipBaseDatos").toString());
        System.out.println("7 " + session.getAttribute("baseDatos").toString());
        System.out.println("8 " + session.getAttribute("usuarioSistemaOperativo").toString());
        System.out.println("9 " + session.getAttribute("sistemaOperativo").toString());
        System.out.println("10 " + session.getAttribute("versionSistemaOperativo").toString());
        System.out.println("11 " + session.getAttribute("arquitecturaSistemaOperativo").toString());
         */
        try {
            if (validadorInter() && idusuario > 0) {
                AdminSesionDTO adminSesion = adminSesionService.buscaAdminSesionPorUsuario(idusuario);
                if (adminSesion == null) {
                    if (adminSesionService.adminSesion(true,
                            idusuario,
                            datosConexion.getIdSesion(),
                            session.getAttribute("iplocal").toString(),
                            session.getAttribute("ipExterna").toString(),
                            session.getAttribute("macAddress").toString(),
                            session.getAttribute("ipBaseDatos").toString(),
                            session.getAttribute("baseDatos").toString(),
                            session.getAttribute("usuarioSistemaOperativo").toString(),
                            session.getAttribute("sistemaOperativo").toString(),
                            session.getAttribute("versionSistemaOperativo").toString(),
                            session.getAttribute("arquitecturaSistemaOperativo").toString()) == 1) {
                        return true;
                    }
                } else if (!adminSesion.isBloqueado() && adminSesion.getIdusuario() != null) {
                    if (adminSesionService.adminSesion(false,
                            idusuario,
                            datosConexion.getIdSesion(),
                            session.getAttribute("iplocal").toString(),
                            session.getAttribute("ipExterna").toString(),
                            session.getAttribute("macAddress").toString(),
                            session.getAttribute("ipBaseDatos").toString(),
                            session.getAttribute("baseDatos").toString(),
                            session.getAttribute("usuarioSistemaOperativo").toString(),
                            session.getAttribute("sistemaOperativo").toString(),
                            session.getAttribute("versionSistemaOperativo").toString(),
                            session.getAttribute("arquitecturaSistemaOperativo").toString()) == 1) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
            return false;
        } catch (Exception e) {
            System.out.println("Error al insertar sesion. " + e.getMessage());
            return false;
        }
    }

    /**
     *
     * @param idusuario
     * @return
     */
    @WebMethod(operationName = "buscaSesionIdusuario", action = "buscaSesionIdusuario")
    public AdminSesionDTO buscaSesionIdusuario(@WebParam(name = "idusuario") int idusuario) {
        if (validadorInter()) {
            return adminSesionService.buscaAdminSesionPorUsuario(idusuario);
        } else {
            return null;
        }
    }

    /**
     *
     * @return
     */
    @WebMethod(operationName = "buscaSesionTodo", action = "buscaSesionTodo")
    public List<AdminSesionDTO> buscaSesionTodo() {
        if (validadorInter()) {
            return adminSesionService.buscaAdminSesionTodo();
        } else {
            return null;
        }
    }

    /**
     *
     * @param idusuario
     * @param estatus
     */
    @WebMethod(operationName = "actualizaAdminSesionEstatus", action = "actualizaAdminSesionEstatus")
    public void actualizaAdminSesionEstatus(@WebParam(name = "idusuario") int idusuario,
            @WebParam(name = "estatus") boolean estatus) {
        if (validadorInter()) {
            adminSesionService.actualizaAdminSesionEstatus(idusuario, estatus);
        }
    }

    /**
     *
     * @param idusuario
     * @param bloqueo
     */
    @WebMethod(operationName = "actualizaAdminSesionBloqueo", action = "actualizaAdminSesionBloqueo")
    public void actualizaAdminSesionBloqueo(@WebParam(name = "idusuario") int idusuario,
            @WebParam(name = "estatus") boolean bloqueo) {
        if (validadorInter()) {
            adminSesionService.actualizaAdminSesionBloqueo(idusuario, bloqueo);
        }
    }

    /**
     *
     * @param numero
     * @param isValid
     */
    @WebMethod(operationName = "tumbaSesion", action = "tumbaSesion")
    public void tumbaSesion(@WebParam(name = "numero") String numero,
            @WebParam(name = "isValid") boolean isValid) {
        if (validadorInter()) {
            sessions.stream().filter((session1) -> (session1.getId().equals(numero))).forEach((session1) -> {
                session1.putValue("estado", isValid);
            });
        }
    }

    /**
     * este metodo remueve de la lista la sesion y despues la invalida
     */
    @WebMethod(operationName = "cierraSession", action = "cierraSession")
    public void cierraSession() {
        if (validadorInter()) {
            for (int i = 0; i < sessions.size(); i++) {
                try {
                    if (sessions.get(i).getId().equals(session.getId())) {
                        sessions.remove(i);
                        session.invalidate();
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Error al cerrar session: " + session.getId());
                }
            }
        }
    }

    /**
     *
     * @return
     */
    @WebMethod(operationName = "validador", action = "validador")
    public boolean validador() {
        return validadorInter();
    }

    /**
     *
     * @return
     */
    @WebMethod(operationName = "ipCliente", action = "ipCliente")
    public String ipCliente() {
        if (validadorInter()) {
            return request.getRemoteAddr();
        } else {
            return null;
        }
    }

    /**
     *
     * @param usuario
     * @param ip
     * @param mac
     * @return
     */
    @WebMethod(operationName = "validaIp", action = "validaIp")
    public boolean validaIP(@WebParam(name = "usuario") String usuario,
            @WebParam(name = "ip") String ip,
            @WebParam(name = "mac") String mac) {
        if (validadorInter()) {
            return new ListaIpValida().validaIP(usuario, ip, mac);
        } else {
            return false;
        }
    }

    /**
     *
     * @return
     */
    @WebMethod(operationName = "traeLista", action = "traeLista")
    public List<String[]> traeLista() {
        if (validadorInter()) {
            return intermediario.traeLista();
        } else {
            return null;
        }
    }

    /**
     *
     * @param path
     * @return
     */
    @WebMethod(operationName = "getFile", action = "getFile")
    public byte[] getFile(@WebParam(name = "path") String path) {
        if (validadorInter()) {
            return intermediario.getFile(path);
        } else {
            return new byte[0];
        }
    }

    /**
     *
     * @param idorigen
     * @param idgrupo
     * @param idsocio
     * @return
     */
    @WebMethod(operationName = "buscaReferencia", action = "buscaReferencia")
    public PaqueteDTO buscaReferenciaTablas(@WebParam(name = "idorigen") int idorigen,
            @WebParam(name = "idgrupo") int idgrupo,
            @WebParam(name = "idsocio") int idsocio) {
        if (validadorInter()) {
            return referenciasService.buscaReferenciaTablas(idorigen, idgrupo, idsocio);
        } else {
            return null;
        }
    }

    // Inserta el detalle si una persona hace un retiro y no es el titular de la cuenta por medio de la huella (apoderado, menor)
    @WebMethod(operationName = "insertarUsoHuellaOtraPersona", action = "insertarUsoHuellaOtraPersona")
    public void insertarUsoHuellaOtraPersona(
            @WebParam(name = "idusuario") int idusuario,
            @WebParam(name = "idorigen") int idorigen,
            @WebParam(name = "idgrupo") int idgrupo,
            @WebParam(name = "idsocio") int idsocio,
            @WebParam(name = "idorigenp") int idorigenp,
            @WebParam(name = "idproducto") int idproducto,
            @WebParam(name = "idauxiliar") int idauxiliar,
            @WebParam(name = "monto") BigDecimal monto,
            @WebParam(name = "idorigenr") int idorigenr,
            @WebParam(name = "idgrupor") int idgrupor,
            @WebParam(name = "idsocior") int idsocior) {
        if (validadorInter()) {
            referenciasService1.insertarUsoHuellaOtraPersona(idusuario, idorigen, idgrupo, idsocio, idorigenp, idproducto, idauxiliar, monto, idorigenr, idgrupor, idsocior);
        }
    }

    /**
     *
     * @return
     */
    @WebMethod(operationName = "buscarMenuValidacionGeneralHuella", action = "buscarMenuValidacionGeneralHuella")
    public List<JMenuValidacionGeneralHuellaDTO> buscarMenuValidacionGeneralHuella() {
        if (validadorInter()) {
            return jMenuValidacionGeneralHuellaService.buscarMenuValidacionGeneralHuella();
        } else {
            return null;
        }
    }

    /**
     *
     * @param idusuario
     * @param modulo
     * @return
     */
    @WebMethod(operationName = "buscaVerificacionGeneralHuellaDigital", action = "buscaVerificacionGeneralHuellaDigital")
    public VerificacionGeneralHuellaDigitalDTO buscaVerificacionGeneralHuellaDigital(@WebParam(name = "idusuario") int idusuario,
            @WebParam(name = "modulo") String modulo) {
        if (validadorInter()) {
            return verificacionGeneralHuellaDigitalService.buscaVerificacionGeneralHuellaDigital(idusuario, modulo);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaVerificacionGeneralHuellaDigitalDTOPorIdUsuario", action = "buscaVerificacionGeneralHuellaDigitalDTOPorIdUsuario")
    public VerificacionGeneralHuellaDigitalDTO buscaVerificacionGeneralHuellaDigitalDTOPorIdUsuario(@WebParam(name = "idusuario") int idusuario) {
        if (validadorInter()) {
            return verificacionGeneralHuellaDigitalService.buscaVerificacionGeneralHuellaDigitalDTOPorIdUsuario(idusuario);
        } else {
            return null;
        }
    }

    @WebMethod(operationName = "buscaVerificacionGeneralHuellaDigitalPorIdUsuario", action = "buscaVerificacionGeneralHuellaDigitalPorIdUsuario")
    public List<VerificacionGeneralHuellaDigitalDTO> buscaVerificacionGeneralHuellaDigitalPorIdUsuario(@WebParam(name = "idusuario") int idusuario) {
        if (validadorInter()) {
            return verificacionGeneralHuellaDigitalService.buscaVerificacionGeneralHuellaDigitalPorIdUsuario(idusuario);
        } else {
            return null;
        }
    }

    /**
     *
     * @param idusuario
     * @param modulo
     * @param idorigen
     * @param idgrupo
     * @param idsocio
     * @return
     */
    @WebMethod(operationName = "actualizaVerificacionGeneralHuellaDigital", action = "actualizaVerificacionGeneralHuellaDigital")
    public int actualizaVerificacionGeneralHuellaDigital(@WebParam(name = "idusuario") int idusuario,
            @WebParam(name = "modulo") String modulo,
            @WebParam(name = "idorigen") int idorigen,
            @WebParam(name = "idgrupo") int idgrupo,
            @WebParam(name = "idsocio") int idsocio) {
        if (validadorInter()) {
            return verificacionGeneralHuellaDigitalService.actualizaVerificacionGeneralHuellaDigital(idusuario, modulo, idorigen, idgrupo, idsocio);
        } else {
            return 0;
        }
    }

    @WebMethod(operationName = "limpiajvm", action = "limpiajvm")
    public void limpiajvm() {
        if (validadorInter()) {
            utileria.limpiajvm();
        }
    }

    @WebMethod(operationName = "getValorConfiguracion", action = "getValorConfiguracion")
    public String getValorConfiguracion(
            @WebParam(name = "usuario") String usuario,
            @WebParam(name = "ventana") String ventana,
            @WebParam(name = "atributo") String atributo) {
        return utilService.getValor(usuario, ventana, atributo);
    }

    @WebMethod(operationName = "editarConfiguracionValorAtributo", action = "editarConfiguracionValorAtributo")
    public boolean editarConfiguracionValorAtributo(
            @WebParam(name = "usuario") String usuario,
            @WebParam(name = "ventana") String ventana,
            @WebParam(name = "atributo") String atributo,
            @WebParam(name = "valor") String valor) {
        return utilService.editarValorAtributo(usuario, ventana, atributo, valor);
    }

}

/*
 //------------------------------------------------------------------------------
 //------------------ METODOS QUE POSIBLEMENTE SE PUEDEN USAR -------------------
 //------------------------------------------------------------------------------

 private void datosSesion() {
 String scheme = request.getScheme();             // http
 String serverName = request.getServerName();     // hostname.com
 int serverPort = request.getServerPort();        // 80
 String servletPath = request.getServletPath();   // /servlet/MyServlet
 String pathInfo = request.getPathInfo();         // /a/b;c=123
 String queryString = request.getQueryString();   // d=789
 }


 //------------------------------------------------------------------------------
 */
