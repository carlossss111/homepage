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
>The adjective directly preceeding the day of the week causes alliteration.
>There is only one new adjective each day, AKA the adjective of the day!

[findDayString Function]
1.Date() inbuilt function returns the full date format. The day number is selected.
2.Depending on the day number, an equivalent string is returned (i.e 0 = "sunday").

[randomFromArray Function]
Returns the value of a random element in an array. Used in 'findAdjective' function to get a random adjective.

[findAdjective Function]
1.First the date is checked with the 'lastDate' stored variable. If it is NOT a new day since the page was last opened then the adjective is still current so can be returned. The rest of this function is therefore skipped in this case.
2.(Hence when the last adjective and date is not current the rest of the code continues...), all possible adjectives are set in an array and an empty array is also initalised.
3.The empty array is filled with all adjectives from the main array that cause alliteration with the day of the week (i.e [F]abulous [F]riday). The 'findDayString' function is used to find the day of the week.
4.A random adjective is selected from that array using the 'randomFromArray' function.
5.The lastDate and lastAdj local variables are updated (see part 1).
6.Return random adjective from part 4.

------------
-images-dir-
------------
Contains the images used on the webpage.

>>>>>>>>>>TODO>>>>>>>>>>
Script.js
//Todo keep one adj per day
//Todo prevent repetitive ones
//Todo link to definition
