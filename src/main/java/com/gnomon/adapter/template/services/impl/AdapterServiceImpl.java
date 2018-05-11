/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gnomon.adapter.template.services.impl;

import com.gnomon.adapter.template.pojos.Response;
import com.gnomon.adapter.template.pojos.Requests.ActionRequest;
import com.gnomon.adapter.template.pojos.Requests.PropertyRequest;

import org.apache.log4j.Logger;
import com.gnomon.adapter.template.services.AdapterService;

/**
 *
 * @author dzandes
 */
public class AdapterServiceImpl implements AdapterService {
    
    private static final Logger LOG = Logger.getLogger(AdapterServiceImpl.class);

    @Override
    public Response postAction(String oid, String aid, ActionRequest request) {
        
        LOG.info("Inside postAction - TBD by each pilot depending on their VAS...");
        
        Response resp_ = new Response("Not supported yet."); // TODO
        return resp_;
    }

    @Override
    public Response getActionTask(String oid, String aid, String tid) {
        
        LOG.info("Inside getActionTask - TBD by each pilot depending on their VAS...");
        
        Response resp_ = new Response("Not supported yet."); // TODO
        return resp_;
    }

    @Override
    public Response deleteActionTask(String oid, String aid, String tid) {
        
        LOG.info("Inside deleteActionTask - TBD by each pilot depending on their VAS...");
      
        Response resp_ = new Response("Not supported yet."); // TODO
        return resp_;
    }

    @Override
    public Response getProperty(String oid, String pid) {
        
        LOG.info("Inside getProperty - TBD by each pilot depending on their VAS...");
        
        Response resp_ = new Response("Not supported yet."); // TODO
        return resp_;
    }

    @Override
    public Response putProperty(String oid, String pid, PropertyRequest request) {
        
        LOG.info("Inside putProperty - TBD by each pilot depending on their VAS...");
        
        Response resp_ = new Response("Not supported yet."); // TODO
        return resp_;
    }

    @Override
    public Response putEvent(String oid, String eid, PropertyRequest request) {
        
        LOG.info("Inside putEvent - TBD by each pilot depending on their VAS...");
        
        Response resp_ = new Response("Not supported yet."); // TODO
        return resp_;
    }
    
    @Override
    public Response getThingsDescription() {
        
        LOG.info("Inside getThingsDescription - TBD by each pilot depending on their VAS...");
        
        Response resp_ = new Response("Not supported yet.");
        return resp_;
    }
    
}
