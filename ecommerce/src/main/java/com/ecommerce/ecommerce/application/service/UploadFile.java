package com.ecommerce.ecommerce.application.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadFile {

    //Creamos una constante final donde esta la ruta de la carpeta
    public final String FOLDER= "images//";

    //Esta en la imagen por default que se mostrata si el usuario no sube una imagen
    public final String IMG_DEFAULT= "default.jpg";

    public String upload(MultipartFile multipartFile) throws IOException {
        if (!multipartFile.isEmpty()){

            //Creamos un arreglo de bytes donde podremos guardar las imagenes
            byte [] bytes =multipartFile.getBytes();

            //Path para buscar la direccion de la cartera
            Path path= Paths.get(FOLDER + multipartFile.getOriginalFilename());

            Files.write(path, bytes);

            return multipartFile.getOriginalFilename();

        }

        return IMG_DEFAULT;

    }

}
