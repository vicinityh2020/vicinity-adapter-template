/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gnomon.adapter.template;

import com.gnomon.adapter.template.pojos.Response;
import com.gnomon.adapter.template.services.AdapterService;
import com.gnomon.adapter.template.services.impl.AdapterServiceImpl;

import java.net.URI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author dzandes
 */

@SpringBootApplication
public class Application {
    
    public static void main(String[] args){
        
        SpringApplication.run(Application.class, args);
        
        RestTemplate restTemplate = new RestTemplate();
        
        /*
        * Agent_URL:Agent_Port is where your multi tenant agent is running, e.g. 160.43.33.111:8888
        *   , therefore, you have to adapt it for your case
        *
        * The POST during startup to the Agent below is needed when/if we do not have Auto-Discovery
        */
        String agentUrl = "http://<Agent_URL>:<Agent_Port>/agent/objects";
        
        AdapterService service = new AdapterServiceImpl();
        Response resp_ = service.getThingsDescription();
        
        HttpEntity<String> bodyEntity = new HttpEntity<>(resp_.getMessage());
        
        URI uri = UriComponentsBuilder.fromHttpUrl(agentUrl)
                                .build()
                                .encode().toUri();
        
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, bodyEntity, String.class);
        
        System.out.println("Response status : " + response.getStatusCodeValue());
    }
}
