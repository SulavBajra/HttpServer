package com.bajracharya.httpserver;

import com.bajracharya.httpserver.config.Configuration;
import com.bajracharya.httpserver.config.ConfigurationManager;

//Driver Class for the HTTP server
public class HttpServer {
    public static void main(String[] args) {
        
        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();
        System.out.println(conf);

        System.out.println("Using Port: "+conf.getPort());
        System.out.println("Using web root: "+conf.getWebroot());
    }
}
