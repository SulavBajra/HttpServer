package com.bajracharya.httpserver.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpConnectionWorkerThread extends Thread {
    private Socket socket;
    private final static Logger LOGGER = LoggerFactory.getLogger(HttpConnectionWorkerThread.class);

    public HttpConnectionWorkerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        InputStream inputStream = null;
        OutputStream outputStream = null;
       try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            //reading
            

            //writing
            String html = "<html><head><title>http server </title></head><body><h1>Hello</h1></body></html>";
            final String CRLF = "\n\r";
            String response = "HTTP/1.1 200 OK"+CRLF+"Content-Length"+html.getBytes().length + CRLF + CRLF + html +
                                CRLF + CRLF;
            outputStream.write(response.getBytes());

            LOGGER.info("Connection Processing finished");

       } catch (IOException e) {
        LOGGER.error("Problem with communication",e);
       }finally{
          if(inputStream != null || outputStream != null || socket != null){
            try{
                inputStream.close();
                outputStream.close();
                socket.close();
            }catch(IOException e){
                e.printStackTrace();
            }
          }
       }


    }
}
