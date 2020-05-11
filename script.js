//Finds the day of the week using the Date() inbuilt function and returns it as a string.
function findDayString(){
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

//console.log(`Have a ${findAdjective()} ${findDayString()}!`)
document.getElementById("dayOfWeek").innerHTML = `output here`;