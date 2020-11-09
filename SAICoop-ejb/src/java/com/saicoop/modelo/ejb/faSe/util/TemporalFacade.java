/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.util;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import com.saicoop.modelo.dto.util.TemporalDTO;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.LocalBean;

/**
 *
 * @author prometeo
 */
@Stateless
@LocalBean
public class TemporalFacade {

    @EJB
    private ControladorJDBC controladorJDBC;


    /*
     idusuario integer,
     sesion character varying(20),
     idorigen integer,
     idgrupo integer,
     idsocio integer,
     idorigenp integer,
     idproducto integer,
     idauxiliar integer,
     esentrada boolean,
     acapital numeric(12,2),
     io_pag numeric(10,2),
     io_cal numeric(10,2),
     im_pag numeric(10,2),
     im_cal numeric(10,2),
     aiva numeric(10,2),
     saldodiacum numeric(12,2),
     abonifio numeric(10,2),
     idcuenta character varying(20),
     aplicado boolean,
     ivaio_pag numeric(10,2),
     ivaio_cal numeric(10,2),
     ivaim_pag numeric(10,2),
     ivaim_cal numeric(10,2),
     mov integer,
     tipomov integer NOT NULL DEFAULT 0,
     efectivo numeric(12,2) DEFAULT 0,
     referencia text,
     cpnp_pag numeric(10,2) NOT NULL DEFAULT 0,
     cpnp_cal numeric(10,2) NOT NULL DEFAULT 0,
     diasvencidos integer NOT NULL DEFAULT 0,
     montovencido numeric(12,2) NOT NULL DEFAULT 0,
     idorigena integer,
     huella_valida boolean DEFAULT false,
     concepto_mov text,
     fe_nom_archivo text,
     fe_xml text,
     sai_aux text,
     */
    //private final static String guardaQuery = "INSERT INTO temporal(idusuario,sesion,idorigen,idgrupo,idsocio,idorigenp,idproducto,idauxiliar,esentrada,acapital,io_pag,io_cal,im_pag,im_cal,aiva,saldodiacum,abonifio,idcuenta,aplicado,ivaio_pag, ivaio_cal,ivaim_pag , ivaim_cal, mov, tipomov, efectivo, referencia, cpnp_pag, cpnp_cal, diasvencidos, montovencido, idorigena, huella_valida, concepto_mov, fe_nom_archivo, fe_xml, sai_aux) VALUES (_idusuario,'_sesion',_idorigen,_idgrupo,_idsocio,_idorigenp,_idproducto,_idauxiliar,_esentrada,_acapital,_io_pag,_io_cal,_im_pag,_im_cal,_aiva,_saldodiacum,_abonifio,'_idcuenta',_aplicado,_ivaio_pag, _ivaio_cal,_ivaim_pag , _ivaim_cal, _mov, _tipomov, _efectivo, '_referencia', _cpnp_pag, _cpnp_cal, _diasvencidos, _montovencido, _idorigena, _huella_valida, '_concepto_mov', '_fe_nom_archivo', '_fe_xml', '_sai_aux');";
    String guardaTemporal = "INSERT INTO temporal(idusuario,sesion,idorigen,idgrupo,idsocio,idorigenp,idproducto,idauxiliar,esentrada,acapital,idcuenta,mov) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
    String buscaTemporalPorSesion = "SELECT * FROM temporal WHERE sesion=?;";
    String buscaTemporalPorSesionIdOrigenpIdProductoIdAuxiliar = "SELECT * FROM temporal WHERE sesion=? AND idorigenp=? AND idproducto=? AND idauxiliar=?;";
    String buscaTemporalPorIdUsuario = "SELECT * FROM temporal WHERE idusuario = ?;";
    String buscaTemporalPorIdUsuarioIdOrigenpIdProductoIdAuxiliarYMov = "SELECT * FROM temporal WHERE idusuario=? AND idorigenp=? AND idproducto=? AND idauxiliar=? AND mov=?;";
    String buscaTemporalPorIdUsuarioIdOrigenIdGrupoIdSocio = "SELECT * FROM temporal WHERE idusuario=? AND idorigen=? AND idgrupo=? AND idsocio=?;";
    String actualizatemporalhuellaAtrue = "UPDATE temporal SET huella_valida=true WHERE idusuario=? AND idorigenp=? AND idproducto=? AND idauxiliar=? AND mov=?;";
    String actualizatemporalhuellaAtrueConOGS = "UPDATE temporal SET huella_valida=true WHERE idusuario=? AND idorigen=? AND idgrupo=? AND idsocio=?;";
    String borraTemporal = "DELETE FROM temporal WHERE sesion=?;";
    String borraTemporalConIds = "DELETE FROM temporal WHERE sesion=? and idorigenp=? and idproducto=? and idauxiliar=?;";

    BigDecimal bigd = new BigDecimal(0.00);

    /* -------------------------------------------------------------------------
     * RETORNAN AL CLIENTE 
     ------------------------------------------------------------------------ */
    //idusuario,sesion,idorigen,idgrupo,idsocio,idorigenp,idproducto,idauxiliar,esentrada,acapital,io_pag,io_cal,im_pag,im_cal,aiva,saldodiacum,abonifio,idcuenta,aplicado,ivaio_pag, ivaio_cal,ivaim_pag , ivaim_cal, mov, tipomov, efectivo, referencia, cpnp_pag, cpnp_cal, diasvencidos, montovencido, idorigena, huella_valida, concepto_mov, fe_nom_archivo, fe_xml, sai_aux
    public int insertaTemporal(String sesion, int idorigenp, int idproducto, int idauxiliar, int idusuario, int idorigen, int idgrupo, int idsocio, boolean esentrada, String idcuenta, double acapital, int mov) {
        try {
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            //temporal(idusuario,sesion,idorigen,idgrupo,idsocio,idorigenp,idproducto,idauxiliar,esentrada,acapital,idcuenta,mov)
            listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", idusuario));
            listParametrosDTOreg.add(new ParametrosDTO(2, "String", sesion));
            listParametrosDTOreg.add(new ParametrosDTO(3, "Integer", idorigen));
            listParametrosDTOreg.add(new ParametrosDTO(4, "Integer", idgrupo));
            listParametrosDTOreg.add(new ParametrosDTO(5, "Integer", idsocio));
            listParametrosDTOreg.add(new ParametrosDTO(6, "Integer", idorigenp));
            listParametrosDTOreg.add(new ParametrosDTO(7, "Integer", idproducto));
            listParametrosDTOreg.add(new ParametrosDTO(8, "Integer", idauxiliar));
            listParametrosDTOreg.add(new ParametrosDTO(9, "Boolean", esentrada));
            listParametrosDTOreg.add(new ParametrosDTO(10, "Double", acapital));
            listParametrosDTOreg.add(new ParametrosDTO(11, "String", idcuenta));
            listParametrosDTOreg.add(new ParametrosDTO(12, "Integer", mov));
            querys.add(guardaTemporal);
            ListaParametros.add(listParametrosDTOreg);
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto.getListAfecto().get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    /*  public int insertaTemporal(String sesion, int idorigenp, int idproducto, int idauxiliar, int idusuario, int idorigen, int idgrupo, int idsocio, boolean esentrada, String cuenta, double acapital, int mov) {
     Conexion con = new Conexion("jdbc:postgresql://", datosConexion.getIp(), ":5432/", datosConexion.getBd(), "", "user=postgres", "password=slufpana?");
     int n = con.ejecutaGIU(buscaTemporalPorIdUsuario
     .replace("_idusuario", Integer.toString(idusuario))
     .replace("_idusuario", Integer.toString(sesion))
     .replace("_idusuario", Integer.toString(idorigen))
     .replace("_idusuario", Integer.toString(idgrupo))
     .replace("_idusuario", Integer.toString(idsocio))
     .replace("_idusuario", Integer.toString(idorigenp))
     .replace("_idusuario", Integer.toString(idproducto))
     .replace("_idusuario", Integer.toString(idauxiliar))
     .replace("_idusuario", Integer.toString(esentrada))
     .replace("_idusuario", Integer.toString(acapital))
     .replace("_idusuario", Integer.toString(io_pag))
     .replace("_idusuario", Integer.toString(io_cal))
     .replace("_idusuario", Integer.toString(im_pag))
     .replace("_idusuario", Integer.toString(im_cal))
     .replace("_idusuario", Integer.toString(aiva))
     .replace("_idusuario", Integer.toString(saldodiacum))
     .replace("_idusuario", Integer.toString(abonifio))
     .replace("_idusuario", Integer.toString(idcuenta))
     .replace("_idusuario", Integer.toString(aplicado))
     .replace("_idusuario", Integer.toString(ivaio_pag))
     .replace("_idusuario", Integer.toString(ivaio_cal))
     .replace("_idusuario", Integer.toString(ivaim_pag))
     .replace("_idusuario", Integer.toString(ivaim_cal))
     .replace("_idusuario", Integer.toString(mov))
     .replace("_idusuario", Integer.toString(tipomov))
     .replace("_idusuario", Integer.toString(efectivo))
     .replace("_idusuario", Integer.toString(referencia))
     .replace("_idusuario", Integer.toString(cpnp_pag))
     .replace("_idusuario", Integer.toString(cpnp_cal))
     .replace("_idusuario", Integer.toString(diasvencidos))
     .replace("_idusuario", Integer.toString(montovencido))
     .replace("_idusuario", Integer.toString(idorigena))
     .replace("_idusuario", Integer.toString(huella_valida))
     .replace("_idusuario", Integer.toString(concepto_mov))
     .replace("_idusuario", Integer.toString(fe_nom_archivo))
     .replace("_idusuario", Integer.toString(fe_xml))
     .replace("_idusuario", Integer.toString(sai_aux)));
     return n;
     }*/
    // ACTUALIZA EL REGISTRO
    public int actualizaTemporalHuella(int idusuario, int idorigenp, int idproducto, int idauxiliar, int mov) {
        try {
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            //idusuario=? AND idorigenp=? AND idproducto=? AND idauxiliar=? AND mov=?
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", idusuario));
            listParametrosDTOreg.add(new ParametrosDTO(2, "Integer", idorigenp));
            listParametrosDTOreg.add(new ParametrosDTO(3, "Integer", idproducto));
            listParametrosDTOreg.add(new ParametrosDTO(4, "Integer", idauxiliar));
            listParametrosDTOreg.add(new ParametrosDTO(5, "Integer", mov));
            querys.add(actualizatemporalhuellaAtrue);
            ListaParametros.add(listParametrosDTOreg);
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto.getListAfecto().get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int actualizaTemporalHuellaOGS(int idusuario, int idorigen, int idgrupo, int idsocio) {
        try {
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            //idusuario=? AND idorigen=? AND idgrupo=? AND idsocio=?
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", idusuario));
            listParametrosDTOreg.add(new ParametrosDTO(2, "Integer", idorigen));
            listParametrosDTOreg.add(new ParametrosDTO(3, "Integer", idgrupo));
            listParametrosDTOreg.add(new ParametrosDTO(4, "Integer", idsocio));
            querys.add(actualizatemporalhuellaAtrueConOGS);
            ListaParametros.add(listParametrosDTOreg);
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto.getListAfecto().get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int eliminaTemporal(String sesion) {
        try {
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            listParametrosDTOreg.add(new ParametrosDTO(1, "String", sesion));
            querys.add(borraTemporal);
            ListaParametros.add(listParametrosDTOreg);
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto.getListAfecto().get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int eliminaTemporal(String sesion, int idorigenp, int idproducto, int idauxiliar) {
        try {
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            //sesion=? and idorigenp=? and idproducto=? and idauxiliar=?
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            listParametrosDTOreg.add(new ParametrosDTO(1, "String", sesion));
            listParametrosDTOreg.add(new ParametrosDTO(2, "Integer", idorigenp));
            listParametrosDTOreg.add(new ParametrosDTO(3, "Integer", idproducto));
            listParametrosDTOreg.add(new ParametrosDTO(4, "Integer", idauxiliar));
            querys.add(borraTemporalConIds);
            ListaParametros.add(listParametrosDTOreg);
            PaqueteDTO afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
            return afecto.getListAfecto().get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public TemporalDTO buscaTemporal(String sesion) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "String", sesion));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(TemporalDTO.class, listParametrosDTO, buscaTemporalPorSesion);
        return (TemporalDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

    public TemporalDTO buscaTemporal(String sesion, int idorigenp, int idproducto, int idauxiliar) {
        // sesion=? AND idorigenp=? AND idproducto=? AND idauxiliar=?
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "String", sesion));
        listParametrosDTO.add(new ParametrosDTO(2, "Integer", idorigenp));
        listParametrosDTO.add(new ParametrosDTO(3, "Integer", idproducto));
        listParametrosDTO.add(new ParametrosDTO(4, "Integer", idauxiliar));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(TemporalDTO.class, listParametrosDTO, buscaTemporalPorSesionIdOrigenpIdProductoIdAuxiliar);
        return (TemporalDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

    // BUSCA AL SOCIO Y PASA LA ENTIDAD A DTO PARA RETORNARLA AL CLIENTE
    public List<TemporalDTO> buscaTemporalIdusuario(int idusuario) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Parametros para la consulta
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idusuario));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(TemporalDTO.class, listParametrosDTO, buscaTemporalPorIdUsuario);
        return (List<TemporalDTO>) paqueteDTO.getListResultadoDTO();
    }

    public TemporalDTO buscaTemporal(int idusuario, int idorigenp, int idproducto, int idauxiliar, int mov) {
        // idusuario=? AND idorigenp=? AND idproducto=? AND idauxiliar=? AND mov=?
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idusuario));
        listParametrosDTO.add(new ParametrosDTO(2, "Integer", idorigenp));
        listParametrosDTO.add(new ParametrosDTO(3, "Integer", idproducto));
        listParametrosDTO.add(new ParametrosDTO(4, "Integer", idauxiliar));
        listParametrosDTO.add(new ParametrosDTO(5, "Integer", mov));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(TemporalDTO.class, listParametrosDTO, buscaTemporalPorIdUsuarioIdOrigenpIdProductoIdAuxiliarYMov);
        return (TemporalDTO) paqueteDTO.getListResultadoDTO().get(0);
    }

    public List<TemporalDTO> buscaTemporalOGS(int idusuario, int idorigen, int idgrupo, int idsocio) {
        // idusuario=? AND idorigen=? AND idgrupo=? AND idsocio=?
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idusuario));
        listParametrosDTO.add(new ParametrosDTO(2, "Integer", idorigen));
        listParametrosDTO.add(new ParametrosDTO(3, "Integer", idgrupo));
        listParametrosDTO.add(new ParametrosDTO(4, "Integer", idsocio));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(TemporalDTO.class, listParametrosDTO, buscaTemporalPorIdUsuarioIdOrigenIdGrupoIdSocio);
        return (List<TemporalDTO>) paqueteDTO.getListResultadoDTO();
    }
}
