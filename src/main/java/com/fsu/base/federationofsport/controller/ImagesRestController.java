package com.fsu.base.federationofsport.controller;

import com.fsu.base.federationofsport.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by yana on 10.04.18.
 */
@Controller
public class ImagesRestController {

    private StorageService storageService;

    @Autowired
    ImagesRestController(StorageService storageService){
        this.storageService = storageService;
    }


//    @PostMapping("/images/upload")
//    public ResponseEntity<Image> handleFileUpload(@RequestParam("file") MultipartFile file) {
//        try {
//            storageService.store(file);
//            files.add(file.getOriginalFilename());
//            return ResponseEntity.status(HttpStatus.OK).body(new Image(file.getOriginalFilename()));
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);
//        }
//    }

    @GetMapping("/images/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}