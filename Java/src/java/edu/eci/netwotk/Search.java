package edu.eci.netwotk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

public class Search {
    
    public static void main(String[] args) {
        try {
            URL search = read();
            
            File htmlTemplateFile = new File("web/template.html");
            String htmlString = FileUtils.readFileToString(htmlTemplateFile);

            String body = "Protocol: " + search.getProtocol() + 
                          "<br> Authority: " + search.getAuthority() + 
                          "<br> Host: " + search.getHost() +
                          "<br> Port: " + search.getPort() + 
                          "<br> Path: " + search.getPath() + 
                          "<br> Query: " + search.getQuery() +
                          "<br> File: " + search.getFile() +
                          "<br> Ref: " + search.getRef();
            htmlString = htmlString.replace("$content", body);
            File newHtmlFile = new File("web/resultado.html");
            FileUtils.writeStringToFile(newHtmlFile, htmlString);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static URL read() throws MalformedURLException{
        Scanner scan = new Scanner(System.in);
        String url = scan.next();
        //String webString = reque
        return new URL(url);
    }
}
