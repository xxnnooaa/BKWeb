package com.example.bkweb.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.json.JSONObject;

public class InputData {
    public void inputData(JSONObject data){

        try {
            String md5 = data.getString("MD5");

            HttpResponse<String> response = Unirest.post("http://localhost:9200/bk_asia/_doc/"+ md5)
            .header("Content-Type", "application/json")
            .body(data.toString())
            .asString();


        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
