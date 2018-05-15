/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gnomon.adapter.template.controllers;

import com.gnomon.adapter.template.pojos.Requests.ActionRequest;
import com.gnomon.adapter.template.pojos.Requests.PropertyRequest;
import com.gnomon.adapter.template.pojos.Response;

import com.gnomon.adapter.template.services.AdapterService;
import com.gnomon.adapter.template.services.impl.AdapterServiceImpl;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.MediaType;

import org.apache.log4j.Logger;

/**
 *
 * @author dzandes
 */

@RestController
public class AdapterController {
    
    private static final Logger LOG = Logger.getLogger(AdapterController.class);
    
    private final AdapterService vasService_ = new AdapterServiceImpl();
    
    /**
     * 
     * @param oid : the service infrastructure id (not the VICINITY oid)
     * @param aid : the service infrastructure action name (not the VICINITY aid)
     * @param request : the request body (user defined/specific)
     * @return
     * @throws Exception 
     */
    @PostMapping(value = "/objects/{oid}/actions/{aid}", 
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE) 
    public Response generateResponseAction(@PathVariable("oid") String oid, @PathVariable("aid") String aid, 
            @RequestBody ActionRequest request) throws Exception {
        
        Response resp_ = vasService_.postAction(oid, aid, request);
        return resp_;
    }
    
    /**
     * 
     * @param oid : the service infrastructure id (not the VICINITY oid)
     * @param aid : the service infrastructure action name (not the VICINITY aid)
     * @param tid : the task id returned by previous POST operation
     * @return
     * @throws Exception 
     */
    @GetMapping(value = "/objects/{oid}/actions/{aid}/tasks/{tid}", 
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response generateResponseGetActionTask(@PathVariable("oid") String oid, 
            @PathVariable("aid") String aid, @PathVariable("tid") String tid) throws Exception {
        
        Response resp_ = vasService_.getActionTask(oid, aid, tid);
        return resp_;
    }
    
    /**
     * 
     * @param oid : the service infrastructure id (not the VICINITY oid)
     * @param aid : the service infrastructure action name (not the VICINITY aid)
     * @param tid : the task id returned by previous POST operation
     * @return
     * @throws Exception 
     */
    @DeleteMapping(value = "/objects/{oid}/actions/{aid}/tasks/{tid}", 
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response generateResponseDeleteActionTask(@PathVariable("oid") String oid, 
            @PathVariable("aid") String aid, @PathVariable("tid") String tid) throws Exception {
        
        Response resp_ = vasService_.deleteActionTask(oid, aid, tid);
        return resp_;
    }
    
    /**
     * 
     * @param oid : the service infrastructure id (not the VICINITY oid)
     * @param pid : the service infrastructure property name (not the VICINITY pid)
     * @return
     * @throws Exception 
     */
    @GetMapping(value = "/objects/{oid}/properties/{pid}", 
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response generateResponseGetProperty(@PathVariable("oid") String oid, 
            @PathVariable("pid") String pid) throws Exception {
        
        Response resp_ = vasService_.getProperty(oid, pid);
        return resp_;
    }
    
    /**
     * 
     * @param oid : the service infrastructure id (not the VICINITY oid)
     * @param pid : the service infrastructure property name (not the VICINITY pid)
     * @param request : the request body (user defined/specific)
     * @return
     * @throws Exception 
     */
    @PutMapping(value = "/objects/{oid}/properties/{pid}", 
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response generateResponsePutProperty(@PathVariable("oid") String oid, @PathVariable("pid") String pid,
            @RequestBody PropertyRequest request) throws Exception {
        
        Response resp_ = vasService_.putProperty(oid, pid, request);
        return resp_;
    }
    
    /**
     * 
     * @param oid : the service infrastructure id (not the VICINITY oid)
     * @param eid : the service event name (not the VICINITY eid)
     * @param request : the request body (user defined/specific)
     * @return
     * @throws Exception 
     */
    @PutMapping(value = "/objects/{oid}/events/{eid}", 
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response generateResponsePutEvent(@PathVariable("oid") String oid, @PathVariable("eid") String eid, 
            @RequestBody PropertyRequest request) throws Exception {
        
        Response resp_ = vasService_.putEvent(oid, eid, request);
        return resp_;
    }
    
    /**
     * 
     * @return
     * @throws Exception 
     */
    @GetMapping(value = "/objects", 
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String generateResponseGetThingsDescription() throws Exception {
        
        Response resp_ = vasService_.getThingsDescription();
        return resp_.getMessage();
    }
   
}
