package com.example.bkweb.service;

import org.json.JSONArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Getplinks {
    public JSONArray putpgLink(String linky) {
            
        JSONArray urls = new JSONArray();
        
        try {
            urls.put(linky);
            Document doc = Jsoup.connect(urls.get(0).toString()).get();
            Elements pages = doc.select(".pagination");
            Elements pagelink = pages.select("a");

            for(Element link : pagelink){
              urls.put("https://bk.asia-city.com" + link.attr("href"));
            }

            // System.out.println(urls.toString(2));
        } catch (Exception e) {
            //TODO: handle exception
        }
        return urls;
    }
}
