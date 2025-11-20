package com.bajracharya.httpserver;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bajracharya.httpserver.config.Configuration;
import com.bajracharya.httpserver.config.ConfigurationManager;
import com.bajracharya.httpserver.core.ServerListenerThread;

//Driver Class for the HTTP server
public class HttpServer {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpServer.class);
    public static void main(String[] args) {
        
        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();
        LOGGER.info("Starting Server....");
        LOGGER.info("Using Port: "+conf.getPort());
        LOGGER.info("Using web root: "+conf.getWebroot());

        try {
            ServerListenerThread serverListenerThread = new ServerListenerThread(conf.getPort(), conf.getWebroot());
            serverListenerThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
