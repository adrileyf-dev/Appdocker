package com.example.appdocker.controller;

import com.example.appdocker.service.DockerSerivce;
import com.github.dockerjava.api.model.Image;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor

@RestController
@RequestMapping("api/images")
public class DockerImagesController {
    private final DockerSerivce serivce;
    @GetMapping("/filter")
    public List<Image> listImagens(@RequestParam(required = false,defaultValue = "image-") String filtername){
        return serivce.filterImages(filtername);
    }
    @GetMapping("")
    public List<Image> listImagens(){
        return serivce.listImages();
    }


}
