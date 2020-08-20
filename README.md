# CountryRestAPI
Simple API for https://restcountries.eu 


### Setup
Clone the repository by ```git clone {thisrepo}```

Using IntelliJ as IDE, open the project and run the application of for short ```Shift+F10```

Service runs in localhost port: 8080


### Endpoints
GET localhost:8080/countries ---
Returns all countries in JSON

GET localhost:8080/countries?id=id ---
Takes in the id and gets corresponding country information in JSON

### Error handling
County code is checked everytime. 

400 Bad request is returned if the coutnry code includes something other than letters OR if it's longer or shorter than 2 characters.

400 Bad request is also returned in case no country is found. This *could* be another status code but I kept it in 400 since it acts as a good fail response.
