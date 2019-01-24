package edu.eci.netwotk;

import java.net.MalformedURLException;
import java.net.URL;

public class URLObject {
    
    public static void main(String[] args) {
        try {
            URL personalURL = new URL("http://hola.com:4000/");
            System.out.println("Protocol: " + personalURL.getProtocol());
            System.out.println("Authority: " + personalURL.getAuthority());
            System.out.println("Host: " + personalURL.getHost());
            System.out.println("Port: " + personalURL.getPort());
            System.out.println("Path: " + personalURL.getPath());
            System.out.println("Query: " + personalURL.getQuery());
            System.out.println("File: " + personalURL.getFile());
            System.out.println("Ref: " + personalURL.getRef());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
