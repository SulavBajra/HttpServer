package com.bajracharya.http;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpParser {
    private final static Logger LOGGER = LoggerFactory.getLogger(HttpParser.class);

    public HttpRequest parseHttpRequest(InputStream inputStream){
        InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.US_ASCII);

        HttpRequest httpRequest = new HttpRequest();

        parseRequestLine(reader,httpRequest);
        parseHeader(reader,httpRequest);
        parseBody(reader,httpRequest);

        return httpRequest;
    }

    private void parseRequestLine(InputStreamReader reader, HttpRequest httpRequest){

    }

    private void parseHeader(InputStreamReader reader, HttpRequest httpRequest){

    }

    private void parseBody(InputStreamReader reader, HttpRequest httpRequest){

    }

}
