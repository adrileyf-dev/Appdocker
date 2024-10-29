package com.dev.appdocker.service;



import lombok.AllArgsConstructor;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Image;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service

public class DockerService {
    private final DockerClient dockerClient;



    public List<Container> listContainers(Boolean all){
        return  dockerClient.listContainersCmd().withShowAll(all).exec();
    }

    public  List<Image> listImages(){
        return dockerClient.listImagesCmd().exec();
    }

    public  List<Image> filterImages(String nome){
        return dockerClient.listImagesCmd().withImageNameFilter(nome).exec();
    }

    public void startContainer(String containerId){
        dockerClient.startContainerCmd(containerId).exec();
    }

    public void stopContainer(String containerId){
        dockerClient.stopContainerCmd(containerId).exec();
    }

    public void deleteContainer(String containerId){
        dockerClient.removeContainerCmd(containerId).exec();
    }
    public void createContainer(String imageName){
        dockerClient.createContainerCmd(imageName).exec();
    }

}
