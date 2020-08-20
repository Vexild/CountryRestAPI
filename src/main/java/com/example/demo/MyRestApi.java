package com.example.demo;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@Service
public class MyRestApi{

    private final RestTemplate restTemplate;

    public MyRestApi(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @RequestMapping(value = "/countries", method = GET)
    public ResponseEntity<String> getAllCountries(){
        String url = "https://restcountries.eu/rest/v2/all";
        String result = this.restTemplate.getForObject(url, String.class);

        return new ResponseEntity(result, HttpStatus.OK);
    }

    // NOTE: I use the country_code as a simple ID since it's unique
    @RequestMapping(value = "/countries",  params = "id", method = GET)
    public ResponseEntity<String> getCountryById(@RequestParam("id") String code_id) {
        try{
            if(code_id.length() == 2 && code_id.chars().allMatch(Character::isLetter)) {
                String url = "https://restcountries.eu/rest/v2/alpha?codes=" + code_id;
                String result = this.restTemplate.getForObject(url, String.class);
                if (result.contains("null")) return new ResponseEntity("Country not found", HttpStatus.BAD_REQUEST);
                else return new ResponseEntity(result, HttpStatus.OK);
            }
            else {
                return new ResponseEntity("Invalid country code" ,HttpStatus.BAD_REQUEST);
            }
        }
        catch(Exception e){
            return new ResponseEntity(e ,HttpStatus.BAD_REQUEST);
        }
    }
}
