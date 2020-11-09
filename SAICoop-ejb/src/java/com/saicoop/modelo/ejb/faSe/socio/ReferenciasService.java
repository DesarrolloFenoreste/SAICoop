/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.socio;

import com.saicoop.modelo.dto.util.PaqueteDTO;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author gerardo
 */
@Stateless
@LocalBean
public class ReferenciasService {

    @EJB
    private ReferenciasFacade referenciasFacade;

    public PaqueteDTO buscaReferenciaTablas(int idorigen, int idgrupo, int idsocio) {
        return referenciasFacade.buscaReferenciaTablas(idorigen, idgrupo, idsocio);
    }
    
    public boolean insertarUsoHuellaOtraPersona(int idusuario, int idorigen, int idgrupo, int idsocio, int idorigenp, int idproducto, int idauxiliar, BigDecimal monto, int idorigenr, int idgrupor, int idsocior) {
        return referenciasFacade.insertarUsoHuellaOtraPersona(idusuario, idorigen, idgrupo, idsocio, idorigenp, idproducto, idauxiliar, monto, idorigenr, idgrupor, idsocior);
    }

}
