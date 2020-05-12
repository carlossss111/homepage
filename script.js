//Finds the day of the week using the Date() inbuilt function and returns it as a string.
const getDayString = function(){
    var d = new Date();
    var dayNumber = d.getDay();

    switch (dayNumber) {
        case 0:
            return "sunday";
        case 1:
            return "monday";
        case 2:
            return "tuesday";
        case 3:
            return "wednesday";
        case 4:
            return "thursday";
        case 5:
            return "friday";
        case 6:
            return "saturday";
        default:
            console.log(d)
            console.log(dayNumber)
            return "[Day String Not Found, Check Javascript.]"
    }
}
//Sends a HTTP GET request to openweather.org API. On success, returns a JSON file with local weather at current time.
const getWeatherData = async function(){

    //Constructs the URL by concaternating the main site and the query string.
    const apiKey = "59c1a6efb5ee1aa080e71cdfc6293b6c";
    const units = "metric"
    const myLocation = "Norwich,uk";
    const url = `https://api.openweathermap.org/data/2.5/weather?q=${myLocation}&units=${units}&appid=${apiKey}`;
    console.log("Connecting to:", url);

    //Tries to connect to the url using fetch() inbuilt function. Awaits response then if the response is valid
    //then converts the response from JSON into a readable response before returning it.
    try{
        const response = await fetch(url);
        if (response.ok){
            console.log("Connection successful!")
            const jsonResponse = await response.json();
            return jsonResponse;
        }
    //Error checking for an unreadable response and network connectivity issues, in that order.
        throw new Error("Request Failed, response.ok != true.");
    }
    catch(err){
        console.log("Weather failed to load.");
        console.log(err);
    }
}

//Takes data (response from a GET request) and navigates the openweather.org API.
//Returns descriptors in order of interest. Boring ones are nearer the bottom.
const getWeatherDescriptor = async function(rawData){
    var data = await rawData;

    if(data.weather[0].main === "Snow"){ return "snowy"; }
    else if (data.weather[0].main === "Thunderstorm"){ return "thunderous"; }
    else if (data.weather[0].main === "Rain"){ return "rainy"; }
    else if (data.main.temp >= 30){ return "hot"; }
    else if (data.main.temp <= 0){ return "freezing"; }
    else if (data.weather[0].main === "Mist"){ return "misty"; }
    else if (data.main.humidity >= 70){ return "humid"; }
    else if (data.wind.speed >= 8){ return "windy"; }
    else if (data.weather[0].main === "Clouds"){ return "cloudy"; }
    else if (data.weather[0].main === "Drizzle"){ return "damp"; }
    else{ return "clear"};
}

//Prints the weather descriptor and the day of the week to the console and the HTML document.
const printGreeting = async function(rawMainWeather,today){
    var mainWeather = await rawMainWeather;
    console.log(`It's a ${mainWeather} ${today}!`);
    document.getElementById("dayOfWeek").innerHTML = `It's a ${mainWeather} ${today}!`;
}

//Calls the getWeatherDescriptor using getWeatherData as a callback function. getDayString as a second paramter.
printGreeting(getWeatherDescriptor(getWeatherData()),getDayString());