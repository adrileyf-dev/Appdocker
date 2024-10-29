package com.example.appdocker.controller;

import com.example.appdocker.service.DockerSerivce;
import com.github.dockerjava.api.model.Container;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor

@RestController
@RequestMapping("/api/containers")
public class DockerContainersController {
    private final DockerSerivce serivce;

    @GetMapping("")
    public List<Container> listContainer(@RequestParam(required = false, defaultValue = "true") Boolean showaAll) {
        return serivce.listContainers(showaAll);
    }
//    }
//    @GetMapping("/filter")
//    public List<Container> listContainer(@RequestParam(required = false, defaultValue = "true") Boolean showaAll) {
//        return serivce.listContainers(showaAll);
//    }

    @GetMapping("/{id}/start")
    public void startContainer(@PathVariable String id) {
        serivce.startContainer(id);
    }

    @PostMapping("/{id}/stop")
    public void stopContainer(@PathVariable String id) {
        serivce.stopContainer(id);
    }

    @DeleteMapping("/{id}")
    public void deleteContainer(@PathVariable String id) {
        serivce.deleteContainer(id);
    }

    @PostMapping("")
    public  void createContainer(@RequestParam String imagemName){
        serivce.createContainer(imagemName);
    }
}
