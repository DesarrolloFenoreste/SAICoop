/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.dto.util.PaqueteDTO;
import com.saicoop.modelo.dto.util.ResultadoLista;
import com.saicoop.modelo.ejb.impl.SaiFunciones;
import com.saicoop.modelo.ejb.util.KitWeb;
import com.saicoop.modelo.ejb.util.Utileria;
import java.math.BigDecimal;
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
public class SaiFuncionesService {

    @EJB
    private Utileria utileria;

    @EJB
    private SaiFunciones saiFunciones;

    KitWeb kitweb = new KitWeb();

    public PaqueteDTO ejecutaEPRCC() {
        utileria.limpiajvm();
        return saiFunciones.ejecutaEPRCC();
    }

    public PaqueteDTO reporteDeConcentracionDeCaptacion(int valor) {
        utileria.limpiajvm();
        return saiFunciones.reporteDeConcentracionDeCaptacion(valor);
    }

    public PaqueteDTO reporteDeRequerimientosDeReserva(String tipo, String valor) {
        utileria.limpiajvm();
        return saiFunciones.reporteDeRequerimientosDeReserva(tipo, valor);
    }

    public PaqueteDTO reporteDeEvolucionDeBandas(String tipo, String fechainicial, String fechafinal) {
        utileria.limpiajvm();
        return saiFunciones.reporteDeEvolucionDeBandas(tipo, fechainicial, fechafinal);
    }

    public PaqueteDTO reporteDeConcentracionDeCartera(int concentrado, String fecha, String tipos) {
        utileria.limpiajvm();
        return saiFunciones.reporteConcentracionDeCartera(concentrado, fecha, tipos);
    }

    public List<ResultadoLista> listaFechaCarteraVencidaHistorial() {
        utileria.limpiajvm();
        return saiFunciones.listaFechaCarteraVencidaHistorial();
    }

    public PaqueteDTO generacionDeCarteraVencida() {
        utileria.limpiajvm();
        return saiFunciones.generacionDeCarteraVencida();
    }

    public int ImportarPolizasExtemporaneas() {
        utileria.limpiajvm();
        return saiFunciones.ImportarPolizasExtemporaneas();
    }

    public int exportarPolizasExtemporaneas(String periodo) {
        utileria.limpiajvm();
        return saiFunciones.exportarPolizasExtemporaneas(periodo);
    }

    public PaqueteDTO generacionDePolizas(Integer idusuario, boolean esResumen, String concepto, String nomArchivo, String fecha) {
        utileria.limpiajvm();
        return saiFunciones.generacionDePolizas(idusuario, esResumen, concepto, nomArchivo, fecha);
    }

    public PaqueteDTO condonacionMasiva(int idusuario, String nomArch) {
        utileria.limpiajvm();
        return saiFunciones.condonacionMasiva(idusuario, nomArch);
    }

    public PaqueteDTO inactivaPersonasPorGrupo(int idgrupo) {
        utileria.limpiajvm();
        return saiFunciones.inactivaPersonasPorGrupo(idgrupo);
    }

    public PaqueteDTO liquidacionMasivaDePrestamos(String cuentaContable, BigDecimal montoLimite, String nomArch, int idorigen, int idProductoDeudor, int idProductoAcredor, int limitediasVencidos, int limiteDiasSinMovimientos, boolean abonar) {
        utileria.limpiajvm();
        return saiFunciones.liquidacionMasivaDePrestamos(cuentaContable, montoLimite, nomArch, idorigen, idProductoDeudor, idProductoAcredor, limitediasVencidos, limiteDiasSinMovimientos, abonar);
    }

    public String saiFechaTrabajo() {
        utileria.limpiajvm();
        return saiFunciones.saiFechaTrabajo();
    }

    public PaqueteDTO estadoDeCuentas(int idorigenp, int idproducto, int idauxiliar, String fecha_ini, String fecha_fin, String tipo) {
        utileria.limpiajvm();
        return saiFunciones.estadoDeCuentas(idorigenp, idproducto, idauxiliar, fecha_ini, fecha_fin, tipo);
    }

    public PaqueteDTO cierreAnual() {
        utileria.limpiajvm();
        return saiFunciones.cierreAnual();
    }

    public PaqueteDTO generaSaldosIniciales() {
        utileria.limpiajvm();
        return saiFunciones.generaSaldosIniciales();
    }

}
