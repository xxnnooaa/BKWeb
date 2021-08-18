package com.example.bkweb.service;

import java.io.IOException;

import org.json.JSONArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Getlinks {
    public JSONArray putpg(String link) {
            
        JSONArray urls = new JSONArray();

        try {
            
            Document doc = Jsoup.connect(link).get();      
            Elements title = doc.select(".views-field.views-field-title");
            Elements links = title.select(".field-content a[href]");


            for(int i=0; i<links.size(); i++){
                urls.put("https://bk.asia-city.com" + links.get(i).attr("href"));
            }
            // System.out.println(urls.toString(2));
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 

        return urls;
    }
}
