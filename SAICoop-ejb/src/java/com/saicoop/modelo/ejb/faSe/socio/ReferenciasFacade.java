/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.socio;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import com.saicoop.modelo.ejb.faSe.util.TablasService;
import com.saicoop.modelo.ejb.impl.SaiFunciones;
import com.saicoop.modelo.ejb.util.KitWeb;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author gerardo
 */
@Stateless
@LocalBean
public class ReferenciasFacade {

    @EJB
    private TablasService tablasService;
    
    @EJB
    private SaiFunciones saiFunciones;

    @EJB
    private ControladorJDBC controladorJDBC;

    KitWeb kitweb = new KitWeb();

    String buscaReferenciaTablas = " SELECT r.idorigenr, r.idgrupor, r.idsocior, TRIM(p.nombre ||' '|| p.appaterno ||' '|| p.apmaterno) AS nombre "
            + " FROM referencias r "
            + " INNER JOIN personas p ON (p.idorigen = r.idorigenr AND p.idgrupo = r.idgrupor AND p.idsocio = r.idsocior) "
            + " WHERE r.tiporeferencia IN (@@tiporeferncia@@) "
            + "   AND r.idorigen = ? "
            + "   AND r.idgrupo = ? "
            + "   AND r.idsocio = ? ";

    String guardaUsoHuellaOtraPersona = "INSERT INTO uso_huella_otra_persona (idusuario, idorigen, idgrupo, idsocio, idorigenp, idproducto, idauxiliar, monto, fecha, idorigenr, idgrupor, idsocior) "
            + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

    // -------------------------------------------------------------------------
    // --- REFERENCIAS - Referencia de tablas ----------------------------------
    // -------------------------------------------------------------------------
    public PaqueteDTO buscaReferenciaTablas(int idorigen, int idgrupo, int idsocio) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idorigen));
        listParametrosDTO.add(new ParametrosDTO(2, "Integer", idgrupo));
        listParametrosDTO.add(new ParametrosDTO(3, "Integer", idsocio));
        // Ejecuta el proceso
        String dato1 = "-1";
        try {
            // Ejecuta el proceso
            dato1 = tablasService.buscaTabla("param", "referencia_huella").getDato1();
        } catch (Exception e) {
        }
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(null, listParametrosDTO, buscaReferenciaTablas.replace("@@tiporeferncia@@", dato1));
        return paqueteDTO;
    }


    // INSERTA A LA PERSONA QUE VALIDO EL MOVIMIENTO CON LA HUELLA
    public boolean insertarUsoHuellaOtraPersona(int idusuario, int idorigen, int idgrupo, int idsocio, int idorigenp, int idproducto, int idauxiliar, BigDecimal monto, int idorigenr, int idgrupor, int idsocior) {
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOdetalle = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOdetalle.add(new ParametrosDTO(1, "Integer", idusuario));
            listParametrosDTOdetalle.add(new ParametrosDTO(2, "Integer", idorigen));
            listParametrosDTOdetalle.add(new ParametrosDTO(3, "Integer", idgrupo));
            listParametrosDTOdetalle.add(new ParametrosDTO(4, "Integer", idsocio));
            listParametrosDTOdetalle.add(new ParametrosDTO(5, "Integer", idorigenp));
            listParametrosDTOdetalle.add(new ParametrosDTO(6, "Integer", idproducto));
            listParametrosDTOdetalle.add(new ParametrosDTO(7, "Integer", idauxiliar));
            listParametrosDTOdetalle.add(new ParametrosDTO(8, "BigDecimal", monto));
            listParametrosDTOdetalle.add(new ParametrosDTO(9, "Timestamp", saiFunciones.saiFechaDBTimeStampString()));
            listParametrosDTOdetalle.add(new ParametrosDTO(10, "Integer", idorigenr));
            listParametrosDTOdetalle.add(new ParametrosDTO(11, "Integer", idgrupor));
            listParametrosDTOdetalle.add(new ParametrosDTO(12, "Integer", idsocior));
            ListaParametros.add(listParametrosDTOdetalle);
            querys.add(guardaUsoHuellaOtraPersona);
            // Ejecutamos el insert o update
            controladorJDBC.procesaCRUD(querys, ListaParametros);
            return true;
        } catch (Exception e) {
            System.out.println("Error en insertarUsoHuellaOtraPersona de ReferenciasFacade. " + e.getMessage());
            return false;
        }
    }
    
}
