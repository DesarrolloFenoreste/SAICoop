package com.saicoop.modelo.ejb.util;

/**
 *
 * @author Gerardo Treviño Montelongo
 * @version 1.00.001
 * @fecha 17 de Julio de 2017
 * @descripción: Clase que realiza la creacion del DTO en base a la tabla de la
 * base de datos.
 */
import java.lang.reflect.Field;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultSetToDTO {

    // -------------------------------------------------------------------------
    // --- CREA LA ENTIDAD DESDE UNA TABLA DE LA BASE DE DATOS -----------------
    // -------------------------------------------------------------------------
    public <T> T createFromResultSet(Class<T> classDTO, ResultSet rs) throws InstantiationException, IllegalAccessException, IllegalArgumentException, SQLException {
        T result = classDTO.newInstance();
        Field[] fields = classDTO.getDeclaredFields();
        for (Field field : fields) {
            String method = field.getName();
            System.out.println(method);
            String fieldName = this.getDatabaseFieldName(method);
            field.setAccessible(true); // Pone accesibles las variables del DTO
            try {
                if (rs.getString(fieldName) != null) {
                    // Esto se hace para los tipo Jdbc4Array 
                    String tipo = field.getType().getTypeName();
                    // Que el tipo de dato contenga [] pero que no sea de tipo byte[] 
                    if (tipo.contains("[]") && !tipo.contains("byte[]")) {
                        Array jdbc4Array = (Array) rs.getObject(fieldName);
                        field.set(result, (Object[]) jdbc4Array.getArray());
                        System.out.println(String.valueOf(rs.getObject(fieldName)));
                    } else if (tipo.contains("Object")) { // Si es Object se castea a String
                        field.set(result, String.valueOf(rs.getObject(fieldName)));
                        System.out.println(String.valueOf(rs.getObject(fieldName)));
                    } else {
                        // Si no son tipo Jdbc4Array u Object se castea normal
                        field.set(result, field.getType().cast(rs.getObject(fieldName)));
                        System.out.println(String.valueOf(rs.getObject(fieldName)));
                    }
                }
            } catch (SQLException ex) {
                System.out.println("La columna %s es invalida:" + ex.getMessage());
            }
            field.setAccessible(false); // Regresa a no accesibles las variables del DTO
        }
        return result;
    }

    // -------------------------------------------------------------------------
    // --- OBTINE EL NOMBRE DE LA COLUMNA --------------------------------------
    // -------------------------------------------------------------------------
    private String getDatabaseFieldName(String method) {
        char[] characters = method.toCharArray();
        List<Character> field_name = new ArrayList<>(0);
        for (char character : characters) {
            if (Character.isUpperCase(character)) {
                field_name.add('_');
            }
            field_name.add(Character.toUpperCase(character));
        }
        return this.getStringRepresentation(field_name);
    }

    // -------------------------------------------------------------------------
    // --- OBTIENE LA REPRESENTACION DEL DATO ----------------------------------
    // -------------------------------------------------------------------------
    private String getStringRepresentation(List<Character> list) {
        StringBuilder builder = new StringBuilder(list.size());
        list.stream().forEach((ch) -> {
            builder.append(ch);
        });
        return builder.toString();
    }

}
