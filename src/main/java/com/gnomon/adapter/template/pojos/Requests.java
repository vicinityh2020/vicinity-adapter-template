/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gnomon.adapter.template.pojos;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

/**
 *
 * @author dzandes
 */
public class Requests {
    
    public static class Input {
        
        private String parameterName;
        private String parameterValue;
        
        public Input(){}
        public Input(String parameterName, String parameterValue) {
            this.parameterName = parameterName;
            this.parameterValue = parameterValue;
        }

        @XmlElement(name = "parameterName")
        public String getParameterName() {
            return parameterName;
        }

        public void setParameterName(String parameterName) {
            this.parameterName = parameterName;
        }

        @XmlElement(name = "parameterValue")
        public String getParameterValue() {
            return parameterValue;
        }

        public void setParameterValue(String parameterValue) {
            this.parameterValue = parameterValue;
        }
    }
    
    /**
     *  The class is just an example. The Request for any related VAS endpoint is user-specific
     */
    @XmlRootElement
    public static class ActionRequest {
        
        private ArrayList<Input> input = new ArrayList<>();
        
        public ActionRequest(){}
        public ActionRequest(ArrayList<Input> input) {
            this.input = input;
        }

        @XmlElement(name = "input")
        public ArrayList<Input> getInput() {
            return input;
        }

        public void setInput(ArrayList<Input> input) {
            this.input = input;
        }
    }
    
    @XmlRootElement
    public static class PropertyRequest {
        
        private String value;
        
        public PropertyRequest(){}
        public PropertyRequest(String value) {
            this.value = value;
        }

        @XmlElement(name = "value")
        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
    
}
