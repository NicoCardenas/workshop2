package edu.eci.netwotk;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

public class Search {
    
    private static String url;
    
    public void main(String[] args) {
        try {
            URL search = read();
            
            String path = "D:\\NickZennin\\Documents\\GitHub\\workshop2\\Java\\web\\template.html";
            File htmlTemplateFile = readFile(path);
            System.out.println(System.getProperty("user.dir"));
            System.out.println("<<<<<<<<<<<" + htmlTemplateFile.getAbsolutePath() +" >>>>>>>>>>>>>>");
            System.out.println("<<<<<<<<<<<" + htmlTemplateFile.getCanonicalPath() +" >>>>>>>>>>>>>>");
            System.out.println("<<<<<<<<<<<" + htmlTemplateFile.getPath() +" >>>>>>>>>>>>>>");
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
            File newHtmlFile = new File("D:\\NickZennin\\Documents\\GitHub\\workshop2\\Java\\web\\resultado.html");
            FileUtils.writeStringToFile(newHtmlFile, htmlString);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private File readFile(String path){
        return new File(path);
    }
    
    private URL read() throws MalformedURLException{
        if (url == null){
            Scanner scan = new Scanner(System.in);
            url = scan.next();
        }
        return new URL(url);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
}
