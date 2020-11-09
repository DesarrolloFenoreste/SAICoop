/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.faSe.general;

import com.saicoop.modelo.conexion.ControladorJDBC;
import com.saicoop.modelo.conexion.ParametrosDTO;
import com.saicoop.modelo.dto.general.JPermisosDTO;
import com.saicoop.modelo.dto.util.PaqueteDTO;
import java.util.ArrayList;
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
public class JPermisosFacade {
    
    @EJB
    private ControladorJDBC controladorJDBC;

    /*
        idpermiso integer NOT NULL,
        permiso character varying(50),
        idmenu integer NOT NULL,
        descripcion character varying(100),
        estatus boolean NOT NULL,
     */
    String ultimoPermiso = "select *from j_permisos order by idpermiso desc limit 1;";
    String buscaPermisos = "select *from j_permisos;";
    String buscaPermisosPorId = "select *from j_permisos where idpermiso=?;";
    String insertaPermiso = "insert into j_permisos(idpermiso,permiso,idmenu,descripcion,estatus)values(?,?,?,?,?);";
    String eliminaPermiso = "delete from j_permisos where idpermiso=?;";
    String actualizaPermiso = "update j_permisos SET permiso=?, idmenu=?, descripcion=?, estatus=? WHERE idpermiso=?;";
    String innerPermisosDeGrupoDeUsuario = "SELECT jp.idpermiso, jp.permiso, jp.idmenu, jp.descripcion, jp.estatus FROM j_permisos jp INNER JOIN j_ugrupospermisos jugp ON jp.idpermiso=jugp.idpermiso INNER JOIN j_usuariosugrupos juug ON  jugp.idugrupo=juug.idugrupo WHERE juug.idusuario=? and jp.permiso=?;";
    
    public JPermisosDTO buscaPermiso(int idpermiso) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idpermiso));
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(JPermisosDTO.class, listParametrosDTO, buscaPermisosPorId);
        return (JPermisosDTO) paqueteDTO.getListResultadoDTO().get(0);
    }
    
    public PaqueteDTO innerPermisosDeGrupoDeUsuario(int idusuario, String permiso) {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        listParametrosDTO.add(new ParametrosDTO(1, "Integer", idusuario));
        listParametrosDTO.add(new ParametrosDTO(2, "String", permiso));
        // Ejecuta el proceso
        return controladorJDBC.procesaSelect(JPermisosDTO.class, listParametrosDTO, innerPermisosDeGrupoDeUsuario);
        
    }
    
    public List<JPermisosDTO> buscaPermisos() {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(JPermisosDTO.class, listParametrosDTO, buscaPermisos);
        return (List<JPermisosDTO>) paqueteDTO.getListResultadoDTO();
    }
    
    public int proximoIndicePermisos() {
        // Lista de parametros para la consulta
        List<ParametrosDTO> listParametrosDTO = new ArrayList<>(0);
        // Ejecuta el proceso
        PaqueteDTO paqueteDTO = controladorJDBC.procesaSelect(JPermisosDTO.class, listParametrosDTO, ultimoPermiso);
        int siguiente = ((JPermisosDTO) paqueteDTO.getListResultadoDTO().get(0)).getIdpermiso() + 1;
        return siguiente;
    }
    
    public PaqueteDTO eliminaJPermiso(int idpermiso) {
        PaqueteDTO afecto = null;
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(1, "Integer", idpermiso));
            querys.add(eliminaPermiso);
            ListaParametros.add(listParametrosDTOreg);
            // Ejecutamos el insert o update
            afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
        } catch (Exception e) {
            if (afecto != null) {
                afecto.setError(afecto.getError() + "\n" + e.getMessage());
            }
        }
        return afecto;
    }
    
    public PaqueteDTO jPermisosCU(boolean esInserta, int idpermiso, String permiso, int idmenu, String descripcion, boolean estatus) {
        PaqueteDTO afecto = null;
        int id = 0;
        int is = 0;
        int per = 0;
        int men = 0;
        try {
            // Lista de parametros y querys a ejecutar
            List<List<ParametrosDTO>> ListaParametros = new ArrayList<>(0);
            List<String> querys = new ArrayList<>(0);
            int des = 0;
            if (esInserta == true) {
                id = 1;
                per = 2;
                men = 3;
                des = 4;
                is = 5;
                querys.add(insertaPermiso);
            } else {
                id = 5;
                per = 1;
                men = 2;
                des = 3;
                is = 4;
                querys.add(actualizaPermiso);
            }
            // Lista de parametros para la consulta
            List<ParametrosDTO> listParametrosDTOreg = new ArrayList<>(0);
            // Parametros para la consulta
            listParametrosDTOreg.add(new ParametrosDTO(id, "Integer", idpermiso));
            listParametrosDTOreg.add(new ParametrosDTO(per, "String", permiso));
            listParametrosDTOreg.add(new ParametrosDTO(men, "Integer", idmenu));
            listParametrosDTOreg.add(new ParametrosDTO(des, "String", descripcion));
            listParametrosDTOreg.add(new ParametrosDTO(is, "Boolean", estatus));
            ListaParametros.add(listParametrosDTOreg);
            // Ejecutamos el insert o update
            afecto = controladorJDBC.procesaCRUD(querys, ListaParametros);
        } catch (Exception e) {
            if (afecto != null) {
                afecto.setError(afecto.getError() + "\n" + e.getMessage());
            }
        }
        return afecto;
    }
    
}
