package com.saicoop.modelo.ejb.faSe.catalogo;

import com.saicoop.modelo.dto.catalogo.MunicipiosDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Gerardo Treviño Montelongo
 * @version 1.00.001
 * @fecha 17 de Julio de 2017
 * @descripción: Clase service de municipios
 */
@Stateless
@LocalBean
public class MunicipiosService {

    @EJB
    private MunicipiosFacade municipiosFacade;

    public List<MunicipiosDTO> buscarTodosLosMunicipos() {
        return municipiosFacade.buscarTodosLosMunicipos();
    }

    public MunicipiosDTO buscarMunicipio(int idmunicipio) {
        return municipiosFacade.buscarMunicipio(idmunicipio);
    }

    public List<MunicipiosDTO> buscarMuniciposPorEstado(int idestado) {
        return municipiosFacade.buscarMuniciposPorEstado(idestado);
    }

    public int municipiosCU(boolean esInserta, int idmunicipio, String nombre, int idestado, String de_cp, String a_cp) {
        return municipiosFacade.municipiosCU(esInserta, idmunicipio, nombre, idestado, de_cp, a_cp);
    }

    public int borrarMunicipio(int idmunicipio) {
        return municipiosFacade.borrarMunicipio(idmunicipio);
    }

    public MunicipiosDTO ultimoMunicipio() {
        return municipiosFacade.ultimoMunicipio();
    }

}
