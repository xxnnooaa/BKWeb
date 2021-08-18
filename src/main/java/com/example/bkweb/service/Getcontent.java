package com.example.bkweb.service;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Getcontent {
    public JSONObject input(String url){
            
        JSONObject content = new JSONObject();
        try {

            Document doc = Jsoup.connect(url).get();
            Elements titles = doc.select(".title");
            Elements details = doc.select(".article-details-content");
            Elements dates = doc.select(".author");

            String date = dates.get(1).text();
            String[] x = date.split("\\|");

            content.put("text_title", titles.get(0).text());
            content.put("text_description", details.text());
            content.put("text_date", x[1]);
            content.put("language", "en");
            content.put("source", "BK-Asia");
            content.put("url", url);
            

            // System.out.println(content.toString(2));        


        } catch (Exception e) {
            e.printStackTrace();
        }

        return content;

    }
}
