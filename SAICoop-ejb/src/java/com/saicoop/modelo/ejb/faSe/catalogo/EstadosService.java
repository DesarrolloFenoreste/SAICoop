
package com.saicoop.modelo.ejb.faSe.catalogo;

import com.saicoop.modelo.dto.catalogo.EstadosDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Gerardo Treviño Montelongo
 * @version 1.00.001
 * @fecha 17 de Julio de 2017
 * @descripción: Clase service de estados
 */
@Stateless
@LocalBean
public class EstadosService {

    @EJB
    private EstadosFacade estadosFacade;

    public List<EstadosDTO> buscarTodosLosEstados() {
        return estadosFacade.buscarTodosLosEstados();
    }

    public List<EstadosDTO> buscarEstadosPorPais(int idpais) {
        return estadosFacade.buscarEstadosPorPais(idpais);
    }
    
    public EstadosDTO buscarEstado(int idestado) {
        return estadosFacade.buscarEstado(idestado);
    }

    public int estadosCU(boolean esInserta, int idestado, String nombre, String ef, int idpais) {
        return estadosFacade.estadosCU(esInserta, idestado, nombre, ef, idpais);
    }

    public int borrarEstado(int idestado) {
        return estadosFacade.borrarEstado(idestado);
    }

    public EstadosDTO ultimoEstado() {
        return estadosFacade.ultimoEstado();
    }

}
