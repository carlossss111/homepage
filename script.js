var d = new Date();
var dayNumber = d.getDay();
var dayString = ""

switch (dayNumber) {
    case 0:
        dayString = "Happy Sedentary Sunday!";
        break;
    case 1:
        dayString = "Happy Manic Monday!";
        break;
    case 2:
        dayString = "Happy Tenacious Tuesday!";
        break;
    case 3:
        dayString = "Happy Wacky Wednesday!";
        break;
    case 4:
        dayString = "Happy Thrilling Thursday!";
        break;
    case 5:
        dayString = "Happy Flammable Friday!";
        break;
    case 6:
        dayString = "Happy Sanguine Saturday!";
        break;
    default:
        dayString = "Day Not Found, Check Javascript."
        console.log(d)
        console.log(dayNumber)
}

document.getElementById("dayOfWeek").innerHTML = dayString;