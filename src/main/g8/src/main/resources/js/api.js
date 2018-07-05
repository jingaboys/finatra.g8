/**
 * Dummy implementation
 */

function getWeather() {
    var location = document.getElementById("location").value;
    /*
    var weatherFetchUrl = `http://localhost:9999/weather.json?address=${location}`;

    fetch(weatherFetchUrl).then((response) => {
        return response.json()
    }).then((weatherResultJson) => {
        var forecastResult = document.getElementById("forecast-result")
        forecastResult.style.visibility = "visible"
        forecastResult.innerHTML = `In <strong>${location}</strong> the weather is <strong>${weatherResultJson.currently.summary}</strong> and the temperature is <strong>${weatherResultJson.currently.temperature}</strong> degrees Celsius.`
    })
    */

    var weatherResultJson = {
        "currently": {
            "summary": "Sunny",
            "temperature": 30.51
        }
    }
    var forecastResult = document.getElementById("forecast-result")
    forecastResult.style.visibility = "visible"
    forecastResult.innerHTML = `In <strong>${location}</strong> the weather is <strong>${weatherResultJson.currently.summary}</strong> and the temperature is <strong>${weatherResultJson.currently.temperature}</strong> degrees Celsius.`
}

