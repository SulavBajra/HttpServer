package com.bajracharya.httpserver.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.bajracharya.httpserver.exception.HttpConfigurationException;
import com.bajracharya.httpserver.util.Json;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public class ConfigurationManager {
    private static ConfigurationManager myConfigurationManager;
    private static Configuration myCurrentConfiguration;

    private ConfigurationManager(){

    }

    public static ConfigurationManager getInstance(){
        if(myConfigurationManager == null)
            myConfigurationManager = new ConfigurationManager();
            return myConfigurationManager;
    }

    //for loading configuration file by the path provided
    public void loadConfigurationFile(String filePath){
        FileReader fileReader = null;
        try{
            fileReader = new FileReader(filePath);
        }catch(FileNotFoundException ex){
            throw new HttpConfigurationException(ex);
        }
        StringBuffer sb = new StringBuffer();
        int i;
        try{
            while((i =fileReader.read())!= -1){
            sb.append((char)i);
            }
        }catch(IOException ex){
            throw new HttpConfigurationException(ex);
        }
        JsonNode conf = null;
        try {
            conf = Json.parse(sb.toString());
        } catch (IOException ex) {
            throw new HttpConfigurationException("Error parsing the configuration File", ex);
        }
        try{
            myCurrentConfiguration = Json.fromJson(conf, Configuration.class);
        }catch(JsonProcessingException ex){
            throw new HttpConfigurationException("Error parsing the configuration file, internal",ex);
        } 
    }

    //Returns the current loaded configuration
    public Configuration getCurrentConfiguration(){
        if(myCurrentConfiguration == null){
            throw new HttpConfigurationException("No current configuration set");
        }
        return myCurrentConfiguration;
    }

}
