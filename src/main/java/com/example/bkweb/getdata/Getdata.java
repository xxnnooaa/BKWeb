package com.example.bkweb.getdata;

import com.example.bkweb.service.Getcontent;
import com.example.bkweb.service.Getlinks;
import com.example.bkweb.service.Getplinks;
import com.example.bkweb.service.Inputapi;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Getdata {

    @Scheduled(fixedRate = 5000)
    public void getbklinks() {

        System.out.println("wait...\n");
        Getplinks s = new Getplinks();
        JSONArray link = s.putpgLink("https://bk.asia-city.com/search/content?search=Beer%20illegal");
        
        for (int i = 0; i < link.length(); i++) {
            Getlinks links = new Getlinks();
            JSONArray url = links.putpg(link.get(i).toString());

            for (int j = 0; j < url.length(); j++) {
                Getcontent data = new Getcontent();
                JSONObject item = data.input(url.get(j).toString());

                Inputapi in = new Inputapi();
                in.inputAPI(item);
            }

        }
    }
}
