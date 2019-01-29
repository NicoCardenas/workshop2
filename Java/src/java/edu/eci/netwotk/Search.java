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
            
            ClassLoader classLoader = getClass().getClassLoader();
            //File htmlTemplateFile = new File(classLoader.getResource("web/template.html").getFile());
            File htmlTemplateFile = new File("home/../web/template.html");
            System.out.println("<<>>>>>>>>> " + htmlTemplateFile.getAbsolutePath());
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
