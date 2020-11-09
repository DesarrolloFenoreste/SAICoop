package com.saicoop.modelo.ejb.faSe.catalogo;

import com.saicoop.modelo.dto.catalogo.ColoniasDTO;
import com.saicoop.modelo.dto.catalogo.CompletoDatoColoniasDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Gerardo Treviño Montelongo
 * @version 1.00.001
 * @fecha 17 de Julio de 2017
 * @descripción: Clase service de colonias
 */
@Stateless
@LocalBean
public class ColoniasService {

    @EJB
    private ColoniasFacade coloniasFacade;

    public List<ColoniasDTO> buscarTodasLasColonias() {
        return coloniasFacade.buscarTodasLasColonias();
    }

    public List<ColoniasDTO> buscarColoniasPorMunicipio(int idmunicipio) {
        return coloniasFacade.buscarColoniasPorMunicipio(idmunicipio);
    }

    public ColoniasDTO buscarColonia(int idColonia) {
        return coloniasFacade.buscarColonia(idColonia);
    }

    public int coloniasCU(boolean esInserta, int idcolonia, String nombre, int idmunicipio, String codigopostal) {
        return coloniasFacade.coloniasCU(esInserta, idcolonia, nombre, idmunicipio, codigopostal);
    }

    public int borrarColonia(int idcolonia) {
        return coloniasFacade.borrarColonia(idcolonia);
    }

    public ColoniasDTO ultimoColonia() {
        return coloniasFacade.ultimoColonia();
    }

    // --- GENERICO ------------------------------------------------------------
    public List<CompletoDatoColoniasDTO> buscarCompletoDatoColonias() {
        return coloniasFacade.buscarCompletoDatoColonias();
    }

    public List<CompletoDatoColoniasDTO> buscarPorRangoCodigoPostal(int codigoPostalDe, int codigoPostalA) {
        return coloniasFacade.buscarPorRangoCodigoPostal(codigoPostalDe, codigoPostalA);
    }
    // -------------------------------------------------------------------------

}
