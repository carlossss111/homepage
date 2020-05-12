################
BROWSER HOMEPAGE
################

A homepage created for my personal use when first opening my firefox browser or when opening a new blank tab.

------------
-index.html-
------------
Contains the HTML code for the webpage. This includes the links to external sites.

------------
-style.css--
------------
Contains CSS code for positioning and colour.

------------
-script.js--
------------
The script determines the welcome message with the following criteria:
>The adjective directly preceeding the day of the week causes describes the current weather using an API.

[getDayString Function]
1.Date() inbuilt function returns the full date format. The day number is selected.
2.Depending on the day number, an equivalent string is returned (i.e 0 = "sunday").

[getWeatherData Async Function (ES8)]
1.Constructs a URL with the base and a query string.
2.The response from that address is collected using a GET request. This response is from openweather.org and returns a JSON file.
3.The response is stringified and returned (for use in the next async function).

[getWeatherDescriptor Async Function (ES8)]
1.Takes an object as an arguement (should be what is returned from getWeatherData).
2.Using the data in the object, a series of branches determine what descriptor to return (for use in the last async function).

[printGreeting Async Function (ES8)]
1.The descriptor (should be from getWeatherDescriptor and it's dependants) and the day of the week (should be from getDayString) are concaternated and the result is printed to the console and to the HTML file.

printGreeting is called with getWeatherDescriptor(getWeatherData) as the first arguement and getDayString as the second.
------------
-images-dir-
------------
Contains the images used on the webpage.