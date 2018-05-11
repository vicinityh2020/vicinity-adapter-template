/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gnomon.adapter.template.pojos;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author dzandes
 */
public class Response {
    
    private String message = "";
    
    public Response(){}
    public Response(String message){
        this.message = message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    @XmlElement
    public String getMessage(){
        return message;
    }
}
