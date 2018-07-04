# Geekettes weather app

We are going to implement an app to fetch the weather at the specified location.

## Steps

1. Run the app, make sure you can open the webpage at localhost:8888
2. Uncomment the fetching code in `api.js` and remove the stubbed data, see that the app is not working anymore
3. Hard-code the same data we had in `api.js` into the `MainController.scala`, check that the app is now working (although with a stubbed data)
4. Implement the actual data fetching

## Suggestions

* Use https://openweathermap.org/current for getting real time forecast information
    * Note: in order to be able to make requests to openweathermap you need to obtain an
    API KEY by registering on the website.
    The key must be provided in the request parameters (along with the rest of the params required by the API).
    * Read the documentation of the forecast API. You can find useful information on how to
    make the requests and what parameters to provide in the request to get the weather in
    Celsius degrees or Fahrenheit.

* Google Maps API might be a good place to get geo coordinates for the location provided in the input.
e.g: http://maps.googleapis.com/maps/api/geocode/json?address=London

# Build

To compile and run tests:

```
sbt compile test
```

# Run

## Development

This project uses [sbt-revolver](https://github.com/spray/sbt-revolver) to spin up a development instance quickly.

From an SBT console:

```
~re-start
```

This will run your application in a forked JVM, reloading it whenever files change locally.