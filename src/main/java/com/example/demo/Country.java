package com.example.demo;

import org.json.JSONObject;

import java.io.Serializable;

public class Country  {
    private String name;
    private String country_code;
    private String capital;
    private int population;
    private String flag_file_url;

    public Country(String name, String country_code, String capital, int population, String flag_file_url){
        this.name = name;
        this.country_code = country_code;
        this.capital = capital;
        this.population = population;
        this.flag_file_url = flag_file_url;
    }

    public String getName(){
        return name;
    }
    public String getCoutnryCode(){
        return country_code;
    }
    public String getCapital(){
        return capital;
    }
    public int getPopulation(){
        return population;
    }
    public String getFlagUrl(){
        return flag_file_url;
    }
    public JSONObject getJSON(){
        // we want to return a JSON object:
        // "name": "Finland",
        // "country_code": "FI",
        // "capital": "Helsinki",
        // "population": 5491817,
        // "flag_file_url": "<url to the flag file>"

        // not entirely sure which one is more efficient way: dataStyle1 or dataStyle2
        JSONObject dataStyle1 = new JSONObject(
        "{\"name\":"+getName()+",\"country_code\":"+getCoutnryCode()+",\"capital\":"+getCapital()+
                ", \"population\":"+getPopulation()+"," + "\"flag_file_url\":"+getFlagUrl()+"}"
        );

        JSONObject dataStyle2 = new JSONObject();
        dataStyle2.put("name", getName());
        dataStyle2.put("country_code", getCoutnryCode());
        dataStyle2.put("capital", getCapital());
        dataStyle2.put("population", getPopulation());
        dataStyle2.put("flag_file_url", getFlagUrl());

        System.out.println(("2"+dataStyle2));
        return dataStyle2;
    }

}
