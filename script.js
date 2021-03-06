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

    //If there is no location data stored, then new location data for Lattitude and Longitude is requested.
    //The new data is stored for next time, and this block is not invoked again until the user wipes their data.
    //This data is stored because the finding the location each time takes too long.
    if(localStorage.getItem("myLocation") === null){
        let myLocation = await new Promise((resolve,reject) => {
            if (navigator.geolocation) {
                navigator.geolocation.getCurrentPosition((position)=>{
                    console.log(`Exsisting location not found. New location at: 'lat=${position.coords.latitude}&lon=${position.coords.longitude}'`);
                    resolve(`lat=${position.coords.latitude}&lon=${position.coords.longitude}`);
                })}
            else{
                reject("q=Norwich,uk")
            }
        })
        localStorage.setItem("myLocation",myLocation)
    }

    //Constructs the URL by concaternating the main site and the query string.
    const apiKey = "59c1a6efb5ee1aa080e71cdfc6293b6c";
    const units = "metric"
    const url = `https://api.openweathermap.org/data/2.5/weather?${localStorage.getItem("myLocation")}&units=${units}&appid=${apiKey}`;
    console.log("Connecting to:", url);

    //Tries to connect to the url using fetch() inbuilt function. Awaits response then if the response is valid
    //then converts the response from JSON into a readable response before returning it.
    try{
        const response = await fetch(url);
        if (response.ok){
            console.log("Connection successful!")
            const jsonResponse = await response.json();
            console.log("JSON Response:",jsonResponse);
            return jsonResponse;
        }
    //Error checking for an unreadable response and network connectivity issues, in that order.
        throw new Error("Request Failed, response.ok != true.");
    }
    catch(err){
        console.log("Weather failed to load:");
        console.log(err);
    }
}

//Takes data (response from a GET request) and navigates the openweather.org API.
//Returns descriptors in order of interest. Boring ones are nearer the bottom.
//A background image is also changed depending on the condiiton.
const getWeatherDescriptor = async function(rawData){
    var data = await rawData;

    if(data.weather[0].main === "Snow"){ 
        document.getElementById("backgroundImage").style.backgroundImage = "url('./images/backgrounds/snow.webp')";
        return "snowy"; }
    else if (data.weather[0].main === "Thunderstorm"){ 
        document.getElementById("backgroundImage").style.backgroundImage = "url('./images/backgrounds/thunderstorm.webp')";
        return "thunderous"; }
    else if (data.weather[0].main === "Rain" || data.weather[0].main === "Drizzle"){ 
        document.getElementById("backgroundImage").style.backgroundImage = "url('./images/backgrounds/rain.gif')";
        return "rainy"; }
    else if (data.main.temp >= 26){ 
        document.getElementById("backgroundImage").style.backgroundImage = "url('./images/backgrounds/hot.jpg')";
        return "hot"; }
    else if (data.main.temp <= 0){ 
        document.getElementById("backgroundImage").style.backgroundImage = "url('./images/backgrounds/cold.jpg')";
        return "freezing"; }
    else if (data.weather[0].main === "Mist"){ 
        document.getElementById("backgroundImage").style.backgroundImage = "url('./images/backgrounds/mist.png')";
        return "misty"; }
    else if (data.main.humidity >= 80){ 
        document.getElementById("backgroundImage").style.backgroundImage = "url('./images/backgrounds/humid.jpg')";
        return "humid"; }
    else if (data.wind.speed >= 7){ 
        document.getElementById("backgroundImage").style.backgroundImage = "url('./images/backgrounds/wind.jpg')";
        return "windy"; }
    else if (data.weather[0].main === "Clouds"){ 
        document.getElementById("backgroundImage").style.backgroundImage = "url('./images/backgrounds/clouds.jpg')"
        return "cloudy"; }
    else{ 
        document.getElementById("backgroundImage").style.backgroundImage = "url('./images/backgrounds/clear.jpeg')";
        return "clear"};
}

//Prints the weather descriptor and the day of the week to the console and the HTML document.
const printGreeting = async function(rawMainWeather,today){
    var mainWeather = await rawMainWeather;
    console.log(`It's a ${mainWeather} ${today}!`);
    document.getElementById("dayOfWeek").innerHTML = `It's a ${mainWeather} ${today}!`;
}

//Calls the getWeatherDescriptor using getWeatherData as a callback function. getDayString as a second paramter.
printGreeting(getWeatherDescriptor(getWeatherData()),getDayString());