# Real Time Forecast API

## Exercise 

Add javascript or jquery functionality to the forecast button so that when the 
button is clicked the container identified by the forecast-result will display the
current weather for the location added in the input box.

## Suggestions

* Use https://api.forecast.io/forecast for getting real time forecast information
    * Note: in order to be able to make requests to api.forecast.io you need to obtain an 
    API KEY for the forecast API. By registering on the https://api.forecast.io/forecast you 
    will get a API key. The key must be provided in the request parameters as well as the 
    geographic coordinates of the location.
    * Read the documentation of the forecast API. You can find useful information on how to 
    make the requests and what parameters to provide in the request to get the weather in 
    Celsius degrees or Fahrenheit.
   
* Google Maps API might be a good place to get geo coordinates for the location provided in
the input.
e.g: http://maps.googleapis.com/maps/api/geocode/json?address=London

* Javascript fetch method is a the indicated way to make requests to external APIs. Will be
good having a read through the documentation: https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch

* When in doubt ... google your way out.