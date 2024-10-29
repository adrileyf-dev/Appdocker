package com.dev.appdocker.DockerConfig;

import com.github.dockerjava.api.DockerClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class dockerConfig {
    @Value("docker.socket.path")
    private String dockerSocker;
    @Bean
    public DockerClient dockerClient(){
      return  null;
    }

}
