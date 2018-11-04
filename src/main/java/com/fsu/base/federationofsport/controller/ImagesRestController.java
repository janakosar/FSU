package com.fsu.base.federationofsport.controller;

import com.fsu.base.federationofsport.model.Image;
import com.fsu.base.federationofsport.service.IImageService;
import com.fsu.base.federationofsport.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created by yana on 10.04.18.
 */
@RestController
public class ImagesRestController {

    private StorageService storageService;
    private IImageService imageService;

    @Autowired
    ImagesRestController(StorageService storageService,
                         IImageService imageService){
        this.storageService = storageService;
        this.imageService = imageService;
    }

    @GetMapping("/images/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @GetMapping("/api/images/all")
    Iterable<Image> getAll() {
        return imageService.getAll();
    }


    @GetMapping(path = "/api/images/{id}")
    Image get(@PathVariable Long id){
        return imageService.get(id);
    }

    @PostMapping("/api/images/upload")
    Image add(@RequestBody Image imageBase64){

        return imageService.add(imageBase64);
    }

    @DeleteMapping(path = "/api/images/{id}")
    void  delete(@PathVariable Long id){
        imageService.delete(id);
    }

}