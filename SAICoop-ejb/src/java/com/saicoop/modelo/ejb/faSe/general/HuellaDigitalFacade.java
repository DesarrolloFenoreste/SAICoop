package com.saicoop.modelo.ejb.faSe.general;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.saicoop.modelo.dto.general.HuellasDpUsuarioDTO;
import com.saicoop.modelo.dto.socio.HuellasDpDTO;
import com.saicoop.modelo.ejb.faSe.socio.HuellasDpService;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.imageio.ImageIO;

/**
 *
 * @author gerardo
 */
@Stateless
@LocalBean
public class HuellaDigitalFacade {

    @EJB
    private HuellasDpUsuarioService huellasDpUsuarioService;
    @EJB
    private HuellasDpService huellasDpService;

    public HuellasDpUsuarioDTO huellasDPusuario(int idusuario, int formatoHuella) {
        try {
            return huellasDpUsuarioService.buscaHuellaUsuario(idusuario, formatoHuella);
        } catch (Exception e) {
            return null;
        }
    }

    public List<HuellasDpDTO> huellasDPsocios(int limit, int offset) {
        try {
            return huellasDpService.buscarTodasHuellasSocio(limit, offset);
        } catch (Exception e) {
            return null;
        }
    }

    // GENERACION DE LAS IMAGENES EN EL SERVIDOR  ------------------------------
    public boolean generaImagenHuella(byte[] imagen, String asignado, int toma, String carpeta, int dedo) {
        String ruta = validaCreaCarpeta(asignado, carpeta);
        if (ruta != null) {
            try {
                InputStream in = new ByteArrayInputStream(imagen);
                BufferedImage bImageFromConvert = ImageIO.read(in);
                ImageIO.write(bImageFromConvert, "jpg", archivoSalida(ruta, asignado, toma, dedo));
                return true;
            } catch (IOException ex) {
                System.out.println("Error al guardar la imagen en el servidor: " + ex.getMessage());
                return false;
            }
        } else {
            System.out.println("No existe la carpeta: " + ruta);
            return false;
        }
    }

    private File archivoSalida(String ruta, String asignado, int toma, int dedo) {
        if (dedo >= 0) {
            // Si es usuario
            return new File(ruta + "/" + asignado + "_" + dedo + "_" + toma + ".jpg");
        } else {
            // Si es socio
            return new File(ruta + "/" + asignado + "_" + toma + ".jpg");
        }
    }

    private String validaCreaCarpeta(String asignado, String carpeta) {
        String home = System.getProperty("user.home");
        try {
            String directorio = home + "/SAICoop_media";
            File folder = new File(directorio);
            // Creamos si no existe el directorio
            if (!folder.isDirectory()) {
                folder.mkdir();
            }
            String directorioRaiz = home + "/SAICoop_media/" + carpeta;
            File folderRaiz = new File(directorioRaiz);
            // Creamos si no existe el directorio
            if (!folderRaiz.isDirectory()) {
                folderRaiz.mkdir();
            }
            String directorioNodo = home + "/SAICoop_media/" + carpeta + "/" + asignado;
            File folderNodo = new File(directorioNodo);
            if (!folderNodo.isDirectory()) {
                folderNodo.mkdir();
            }
            if (folderNodo.exists()) {
                return directorioNodo;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error en validaCreaCarpeta de HuellaDigitalFacade: " + e.getMessage());
            return null;
        }
    }

}
