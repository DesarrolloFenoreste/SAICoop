package com.saicoop.modelo.conexion;

import com.saicoop.modelo.dto.util.PaqueteDTO;
import com.saicoop.modelo.dto.util.RaiceNotice;
import com.saicoop.modelo.dto.util.ResultadoLista;
import com.saicoop.modelo.ejb.util.DatosConexion;
import com.saicoop.modelo.ejb.util.KitWeb;
import com.saicoop.modelo.ejb.util.ResultSetToDTO;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.sql.Timestamp;

/**
 *
 * @author Gerardo Treviño Montelongo
 * @version 1.00.001
 * @fecha 17 de Julio de 2017
 * @descripción: Clase que controla la creacion de la conexion y la ejecucion de
 * las peticiones CRUD y todo lo retorna a un paqueteDTO, contiene algunos
 * metodos de cnoversion.
 */
@Stateless
@LocalBean
public class ControladorJDBC {

    @EJB
    private DatosConexion datosConexion;

    PaqueteDTO paqueteDTO;
    KitWeb kitweb = new KitWeb();

    // -------------------------------------------------------------------------
    // --- GENERA LA CONEXION --------------------------------------------------
    // -------------------------------------------------------------------------
    /*public Connection getConnection() {
        return new ConexionJDBC().Conexion(datosConexion.getIp(), datosConexion.getBd(), "");
    }*/
    public Connection getConnection(String props) {
        return new ConexionJDBC().Conexion(datosConexion.getIp(), datosConexion.getBd(), props);
    }

    // -------------------------------------------------------------------------
    // --- EJECUTA SELECT Y LO RESTORNA AL DTO ---------------------------------
    // -------------------------------------------------------------------------
    public <T> PaqueteDTO procesaSelect(Class<T> classDTO, List<ParametrosDTO> parametros, String query) {
        // Paquete final con el TODO
        paqueteDTO = new PaqueteDTO();
        List<RaiceNotice> notices = new ArrayList<>(0);
        // Conexiones y herramientas
        Connection connection = getConnection("");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            for (ParametrosDTO parametro : parametros) {
                cargaValores(preparedStatement, parametro);
                //preparedStatement.setObject(parametro.getPosicion(), parametro.getValor());
            }
            resultSet = preparedStatement.executeQuery();
            // Se obtiene el resultado dependiendo si se pide DTO o List
            if (classDTO != null) {

                resultSetToDTO(classDTO, resultSet, paqueteDTO);
            } else {
                resultSetToList(resultSet, paqueteDTO);
            }
            // Enviamos la respuesta
            List<RaiceNotice> raiceNotice = raiceNotice(preparedStatement, notices);
            paqueteDTO.setListRaiceNotice(raiceNotice);
        } catch (SQLException ex) {
            String mensaje = "Error en el metodo 'procesaSelect' en la clase 'ControladorJDBC'. " + ex.getMessage();
            System.out.println(ex.getMessage());
            paqueteDTO.setError(mensaje);
            // Enviamos la respuesta
            List<RaiceNotice> raiceNotice = raiceNotice(preparedStatement, notices);
            paqueteDTO.setListRaiceNotice(raiceNotice);
            paqueteDTO.setListResultadoDTO(new ArrayList<>(0));
        } finally {
            cierraPreparedStatement(preparedStatement);
            cierraResultSet(resultSet);
            cierraConnection(connection);
        }
        return paqueteDTO;
    }

    /*
    0 cualquiera puede verdo y editarlo
    1 solo ver
    2 no se puede ver desde el saicoop
    SELECT dato1 FROM tablas WHERE idtabla = 'param' AND idelemento = 'federacion';
    este permiso al parecer sirve para poder crear, editar tipo 1
    
     */
    // -------------------------------------------------------------------------
    // --- EJECUTA UNA LISTA DE QUERYS -----------------------------------------
    // -------------------------------------------------------------------------
    public PaqueteDTO procesaCRUD(List<String> querys, List<List<ParametrosDTO>> ListaParametros) {
        // Paquete final con el TODO
        paqueteDTO = new PaqueteDTO();
        // Conexiones y herramientas
        Connection connection = getConnection("");
        PreparedStatement preparedStatement = null;
        List<Integer> afectados = new ArrayList<>(querys.size());
        List<RaiceNotice> notices = new ArrayList<>(querys.size());
        int posicio = 0;
        try {
            // Commit transaction manual
            System.out.println("Accedo bien");
            connection.setAutoCommit(false);
            for (String query : querys) {
                preparedStatement = connection.prepareStatement(query);
                if (!ListaParametros.isEmpty()) {
                    List<ParametrosDTO> parametros = ListaParametros.get(posicio);
                    for (ParametrosDTO parametro : parametros) {
                        cargaValores(preparedStatement, parametro);
                    }
                }
                int execute = preparedStatement.executeUpdate();
                               afectados.add(execute);
                // Enviamos la respuesta
                List<RaiceNotice> raiceNotice = raiceNotice(preparedStatement, notices);
                paqueteDTO.setListRaiceNotice(raiceNotice);
                posicio++;
            }
            paqueteDTO.setListRaiceNotice(notices);
            paqueteDTO.setListAfecto(afectados);
            connection.commit();
        } catch (SQLException ex) {
            String mensaje = "Error en el metodo 'procesaCRUD' en la clase 'ControladorJDBC'. " + ex.getMessage();
            System.out.println(mensaje);
            paqueteDTO.setError(mensaje);
            // Enviamos la respuesta
            List<RaiceNotice> raiceNotice = raiceNotice(preparedStatement, notices);
            paqueteDTO.setListRaiceNotice(raiceNotice);
            // Si existe error aplica rollback
            connectionrollback(connection);

        } finally {
            cierraPreparedStatement(preparedStatement);
            cierraConnection(connection);
        }
        return paqueteDTO;
    }

    public PaqueteDTO procesaCRUDBatch(List<String> querys, List<List<ParametrosDTO>> ListaParametros) {
        // Paquete final con el TODO
        paqueteDTO = new PaqueteDTO();
        // Conexiones y herramientas
        Connection connection = getConnection("");
        PreparedStatement preparedStatement = null;
        List<Integer> afectados = new ArrayList<>(querys.size());
        List<RaiceNotice> notices = new ArrayList<>(querys.size());
        int posicio = 0;
        try {
            // Commit transaction manual
            connection.setAutoCommit(false);
            for (String query : querys) {
                preparedStatement = connection.prepareStatement(query);
                if (!ListaParametros.isEmpty()) {
                    List<ParametrosDTO> parametros = ListaParametros.get(posicio);
                    for (ParametrosDTO parametro : parametros) {
                        cargaValores(preparedStatement, parametro);
                    }
                }
                preparedStatement.addBatch();
            }
            int[] execute = preparedStatement.executeBatch();
            for (int i = 0; i < execute.length; i++) {
                afectados.add(execute[i]);
            }
            // Enviamos la respuesta
            List<RaiceNotice> raiceNotice = raiceNotice(preparedStatement, notices);
            paqueteDTO.setListRaiceNotice(raiceNotice);
            posicio++;
            paqueteDTO.setListRaiceNotice(notices);
            paqueteDTO.setListAfecto(afectados);
            connection.commit();
        } catch (SQLException ex) {
            String mensaje = "Error en el metodo 'procesaCRUD' en la clase 'ControladorJDBC'. " + ex.getMessage();
            System.out.println(mensaje);
            paqueteDTO.setError(mensaje);
            // Enviamos la respuesta
            List<RaiceNotice> raiceNotice = raiceNotice(preparedStatement, notices);
            paqueteDTO.setListRaiceNotice(raiceNotice);
            // Si existe error aplica rollback
            connectionrollback(connection);

        } finally {
            cierraPreparedStatement(preparedStatement);
            cierraConnection(connection);
        }
        return paqueteDTO;
    }

    // -------------------------------------------------------------------------
    // --- EJECUTA UNA LISTA DE FUNCIONES --------------------------------------
    // -------------------------------------------------------------------------
    public PaqueteDTO procesaFUNCTION(List<String> querys, List<List<ParametrosDTO>> ListaParametros, String props) {
        // Paquete final con el TODO
        paqueteDTO = new PaqueteDTO();
        // Conexiones y herramientas
        Connection connection = getConnection(props);
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Integer> afectados = new ArrayList<>(querys.size());
        List<RaiceNotice> notices = new ArrayList<>(querys.size());
        int posicio = 0;
        int updates = 0;
        try {
            // Commit trasaction manual
            connection.setAutoCommit(false);
            for (String query : querys) {
                preparedStatement = connection.prepareCall(query);
                List<ParametrosDTO> parametros = ListaParametros.get(posicio);
                for (ParametrosDTO parametro : parametros) {
                    cargaValores(preparedStatement, parametro);
                }
                preparedStatement.execute();
                // Enviamos la respuesta
                List<RaiceNotice> raiceNotice = raiceNotice(preparedStatement, notices);
                updates = updates + preparedStatement.getUpdateCount();
                afectados.add(preparedStatement.getUpdateCount());
                paqueteDTO.setListRaiceNotice(raiceNotice);
                posicio++;
            }
            paqueteDTO.setListRaiceNotice(notices);
            paqueteDTO.setListAfecto(afectados);
            connection.commit();
        } catch (SQLException ex) {
            String mensaje = "Error en el metodo 'procesaFUNCTION' en la clase 'ControladorJDBC'. " + ex.getMessage();
            String error = "Error en la funcion numero: " + posicio + ex.getMessage();
            paqueteDTO.setError(mensaje + "\n" + error);
            // Enviamos la respuesta
            List<RaiceNotice> raiceNotice = raiceNotice(preparedStatement, notices);
            paqueteDTO.setListRaiceNotice(raiceNotice);
            // Si existe error aplica rollback
            if (updates > 0) {
                connectionrollback(connection);
            } else {
                System.out.println(ex.getMessage() + ":No se afecto ningun registro.");
            }
        } finally {
            cierraPreparedStatement(preparedStatement);
            cierraResultSet(resultSet);
            cierraConnection(connection);
        }
        return paqueteDTO;
    }

    // -------------------------------------------------------------------------
    // --- CASTEA LOS VALORES DEL PREPAREDSTATEMENT ----------------------------
    // -------------------------------------------------------------------------
    private PreparedStatement cargaValores(PreparedStatement preparedStatement, ParametrosDTO parametro) {
        try {
            switch (parametro.getTipo()) {
                case "Boolean":
                    preparedStatement.setBoolean(parametro.getPosicion(), (boolean) parametro.getValor());
                    break;
                case "Date":
                    preparedStatement.setDate(parametro.getPosicion(), StringToDate(parametro.getValor()));
                    break;
                case "Timestamp":
                    preparedStatement.setTimestamp(parametro.getPosicion(), StringToTimestamp(String.valueOf(parametro.getValor())));
                    break;
                case "String":
                    preparedStatement.setString(parametro.getPosicion(), String.valueOf(parametro.getValor()));
                    break;
                default:
                    preparedStatement.setObject(parametro.getPosicion(), parametro.getValor());
                    break;
            }
        } catch (SQLException ex) {
            System.out.println("Error en el metodo 'cargaValores' en la clase 'ControladorJDBC' al convertir el parametro: " + ex.getMessage());
        }
        return preparedStatement;
    }

    // -------------------------------------------------------------------------
    // --- RETORNA EL RESULTSET FORMATEADO A DTO -------------------------------
    // -------------------------------------------------------------------------
    private <T> PaqueteDTO resultSetToDTO(Class<T> classDTO, ResultSet resultSet, PaqueteDTO paqueteDTO) {

        try {
            // ResultSet a DTO
            ResultSetToDTO resultSetToDTO = new ResultSetToDTO();
            // Arreglo de DTO
            List<T> listTdto = new ArrayList<>(0);
            while (resultSet.next()) {
                T registro = resultSetToDTO.createFromResultSet(classDTO, resultSet);
                listTdto.add(registro);
            }
            // Si no retorna resultado se envia una instancia del DTO
            if (listTdto.isEmpty()) {
                listTdto.add(null);
            }
            paqueteDTO.setListResultadoDTO(listTdto);
        } catch (SQLException | InstantiationException | IllegalAccessException | IllegalArgumentException ex) {
            System.out.println("Error en el metodo 'resultSetToDTO' en la clase 'ControladorJDBC' al pasar resultset en resultSetToDTO: " + ex.getMessage());
        }
        return paqueteDTO;
    }

    // -------------------------------------------------------------------------
    // --- RETORNA EL RESULTSET FORMATEADO A LISTA -----------------------------
    // -------------------------------------------------------------------------
    private <T> PaqueteDTO resultSetToList(ResultSet resultSet, PaqueteDTO paqueteDTO) {
        try {
            kitweb = new KitWeb();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int numcols = resultSetMetaData.getColumnCount();
            // Arreglo de DTO
            List<ResultadoLista> listResultadoLista = new ArrayList<>(0);
            ResultadoLista resultadoLista;
            // Se agrega la fila para los tipo de datos
            List<String> tipo = new ArrayList<>(numcols);
            for (int i = 1; i <= numcols; i++) {
                tipo.add(String.valueOf(resultSetMetaData.getColumnType(i)));
            }
            resultadoLista = new ResultadoLista();
            resultadoLista.setResultadoLista(tipo);
            listResultadoLista.add(resultadoLista);
            // Se agrega la fila para el nombre de las columnas
            List<String> columna = new ArrayList<>(numcols);
            for (int i = 1; i <= numcols; i++) {
                columna.add(resultSetMetaData.getColumnName(i));
            }
            resultadoLista = new ResultadoLista();
            resultadoLista.setResultadoLista(columna);
            listResultadoLista.add(resultadoLista);
            // Se agregan los registros del resultset
            while (resultSet.next()) {
                List<String> list = new ArrayList<>(numcols);
                for (int i = 1; i <= numcols; i++) {
                    String nombreCol = resultSetMetaData.getColumnName(i);
                    list.add(kitweb.escapaCaracteresXmlNoValidos(resultSet.getString(nombreCol)));
                }
                resultadoLista = new ResultadoLista();
                resultadoLista.setResultadoLista(list);
                listResultadoLista.add(resultadoLista);
            }
            paqueteDTO.setListResultadoLista(listResultadoLista);
        } catch (SQLException | IllegalArgumentException ex) {
            System.out.println("Error en el metodo 'resultSetToList' en la clase 'ControladorJDBC'. " + ex.getMessage());
        }
        return paqueteDTO;
    }

    // -------------------------------------------------------------------------
    // --- RAISE NOTICE --------------------------------------------------------
    // -------------------------------------------------------------------------
    public List<String> raiseNotice(PreparedStatement preparedStatement) {
        List<String> notice = new ArrayList<>(0);
        try {
            SQLWarning wars = preparedStatement.getWarnings();
            if (wars != null) {
                while (wars != null) {
                    // Aqui se esta llenando msjs List<String>
                    String s = "SQL " + wars.getMessage().replace("|MSG_TERMINAL|  >>>", "");
                    s = kitweb.escapaCaracteresXmlNoValidos(s);
                    notice.add(s);
                    wars = wars.getNextWarning();
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error en el metodo 'raiseNotice' en la clase 'ControladorJDBC'. " + ex.getMessage());
        }
        return notice;
    }

    // -------------------------------------------------------------------------
    // --- ENVIA LOS RAICE NOTICE AL ARREGLO PARA EL CLIENTE  ------------------
    // -------------------------------------------------------------------------
    private List<RaiceNotice> raiceNotice(PreparedStatement preparedStatement, List<RaiceNotice> notices) {
        try {
            // Enviamos la respuesta
            RaiceNotice raiceNotice = new RaiceNotice();
            raiceNotice.setRaiceNotice(raiseNotice(preparedStatement));
            notices.add(raiceNotice);
        } catch (Exception e) {
            System.out.println("Error en el metodo 'raiceNotice' en la clase 'ControladorJDBC'. " + e.getMessage());
        }
        return notices;
    }

    // -------------------------------------------------------------------------
    // --- VALIDA QUE EXISTA LA TABLA EN LA DB ---------------------------------
    // -------------------------------------------------------------------------
    private boolean existeLaTabla(Connection connection, String tabla) {
        try {
            String[] tipos = {"TABLE"};
            DatabaseMetaData dbmd = connection.getMetaData();
            ResultSet tables = dbmd.getTables(null, null, null, tipos);
            while (tables.next()) {
                String x = tables.getString("table_name");
                if (x.equals(tabla)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error en el metodo 'existeLaTabla' en la clase 'ControladorJDBC' no existe la tabla en la base de datos:" + tabla + " " + e.getMessage());
            return false;
        }
        return false;
    }

    // -------------------------------------------------------------------------
    // --- CIERRA CONEXIONES ---------------------------------------------------
    // -------------------------------------------------------------------------
    // connection
    public void cierraConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error en el metodo 'cierraConnection' en la clase 'ControladorJDBC' al cerrar conexion JDBC. " + ex.getMessage());
        }
    }

    // preparedStatement
    public void cierraPreparedStatement(PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error en el metodo 'cierraPreparedStatement' en la clase 'ControladorJDBC' al cerrar preparedStatement. " + ex.getMessage());
        }
    }

    // resultSet
    public void cierraResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error en el metodo 'cierraResultSet' en la clase 'ControladorJDBC' al cerrar resultSet. " + ex.getMessage());
        }
    }

    // rollback
    public void connectionrollback(Connection connection) {
        try {
            if (connection != null) {
                if (!connection.isClosed()) {
                    connection.rollback();
                } else {
                    System.out.println("la conexion ya estaba Cerrada, no se logro el rollback");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error en el metodo 'connectionrollback' en la clase 'ControladorJDBC' al aplicar rollback. " + ex.getMessage());
        }
    }

    // -------------------------------------------------------------------------
    // -------------------------------------------------------------------------
    // -------------------------------------------------------------------------
    // --- CONVIERTE UN STRING A DATE ------------------------------------------
    // -------------------------------------------------------------------------
    private Date StringToDate(Object fecha) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date date = simpleDateFormat.parse(fecha.toString());
            return new Date(date.getTime());
        } catch (ParseException ex) {
            System.out.println("Error en el metodo 'StringToDate' en la clase 'ControladorJDBC'. " + ex.getMessage());
        }
        return null;
    }

    // -------------------------------------------------------------------------
    // --- CONVIERTE UN STRING A TIMESTAMP -------------------------------------
    // -------------------------------------------------------------------------
    private Timestamp StringToTimestamp(String s) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
            java.util.Date date = sdf.parse(s);
            Timestamp timestamp = new Timestamp(date.getTime());
            return timestamp;
        } catch (ParseException ex) {
            System.out.println("Error en el metodo 'StringToTimestamp' en la clase 'ControladorJDBC'. " + ex.getMessage());
        }
        return null;
    }

}
