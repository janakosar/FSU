package com.fsu.base.federationofsport.storage;

import com.fsu.base.federationofsport.controller.ImagesRestController;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by yana on 10.04.18.
 */
@Service
public class StorageService {

    private final Path rootLocation = Paths.get("upload-dir");

    public String store(String imageBase64) {

        if (imageBase64 == null || imageBase64.isEmpty()){
            return null;
        }

        byte[] data = Base64.decodeBase64(imageBase64);
        String filename = "image_" + System.currentTimeMillis() + ".png";
        Path path = this.rootLocation.resolve(filename);

        OutputStream stream = null;
        try {
            stream = new FileOutputStream(path.toFile());
            stream.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (stream != null) {
                try {
                    stream.flush();
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return getUrl(filename);
    }

    private String getUrl(String filename){
        return MvcUriComponentsBuilder
                .fromMethodName(ImagesRestController.class, "getFile", filename).build().toString();
    }

    public Resource loadFile(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            URI uri = file.toUri();
            Resource resource = new UrlResource(uri);
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                String errorMessage = "Failed to load " + filename + ": ";
                if (!resource.exists()){
                    errorMessage = errorMessage + "resource doesn't exists.";
                }else {
                    errorMessage = errorMessage + "resource isn't readable.";
                }
                throw new RuntimeException(errorMessage);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    public void init() {

        if (rootLocation.toFile().exists()) {
            return;
        }
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }
    }
}