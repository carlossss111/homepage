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

//Returns a random value from an array passed in.
function randomFromArray(array){
    let selectedElement = Math.random() * array.length;
    selectedElement = Math.floor(selectedElement);
    return array[selectedElement];
}

//Returns a random adjective from a list of adjectives. Uses randomFromArray and findDayString helper functions.
function findAdjective(){
    const sAdjectives = ["sable","sad","safe","salty","same","sassy","satisfying","savory","scandalous","scarce","scared","scary","scattered","scientific","scintillating","scrawny","screeching","second","second-hand","secret","secretive","sedate","seemly","selective","selfish","separate","serious","shaggy","shaky","shallow","sharp","shiny","shivering","shocking","short","shrill","shut","shy","sick","silent","silent","silky","silly","simple","simplistic","sincere","six","skillful","skinny","sleepy","slim","slimy","slippery","sloppy","slow","small","smart","smelly","smiling","smoggy","smooth","sneaky","snobbish","snotty","soft","soggy","solid","somber","sophisticated","sordid","sore","sore","sour","sparkling","special","spectacular","spicy","spiffy","spiky","spiritual","spiteful","splendid","spooky","spotless","spotted","spotty","spurious","squalid","square","squealing","squeamish","staking","stale","standing","statuesque","steadfast","steady","steep","stereotyped","sticky","stiff","stimulating","stingy","stormy","straight","strange","striped","strong","stupendous","stupid","sturdy","subdued","subsequent","substantial","successful","succinct","sudden","sulky","super","superb","superficial","supreme","swanky","sweet","sweltering","swift","symptomatic","synonymous"];
    const mAdjectives = ["macabre","macho","maddening","madly","magenta","magical","magnificent","majestic","makeshift","male","malicious","mammoth","maniacal","many","marked","massive","married","marvelous","material","materialistic","mature","mean","measly","meaty","medical","meek","mellow","melodic","melted","merciful","mere","messy","mighty","military","milky","mindless","miniature","minor","miscreant","misty","mixed","moaning","modern","moldy","momentous","motionless","mountainous","muddled","mundane","murky","mushy","mute","mysterious"];
    const tAdjectives = ["taboo","tacit","tacky","talented","tall","tame","tan","tangible","tangy","tart","tasteful","tasteless","tasty","tawdry","tearful","tedious","teeny","teeny-tiny","telling","temporary","ten","tender","tense","tense","tenuous","terrible","terrific","tested","testy","thankful","therapeutic","thick","thin","thinkable","third","thirsty","thoughtful","thoughtless","threatening","three","thundering","tidy","tight","tightfisted","tiny","tired","tiresome","toothsome","torpid","tough","towering","tranquil","trashy","tremendous","tricky","trite","troubled","truculent","true","truthful","two","typical"];
    const fAdjectives = ["fabulous","faded","fain","fair","faithful","fallacious","false","familiar","famous","fanatical","fancy","fantastic","far","far-flung","fascinated","fast","fat faulty","fearful","fearless","feeble","feigned","female","fertile","festive","few","fierce","filthy","fine","finicky","first"," five"," fixed","flagrant","flammable","flaky","flashy","flat","flawless","flimsy","flippant","flowery","fluffy","fluttering"," foamy","foolish","foregoing","forgetful","fortunate","frail","fragile","frantic","free","freezing","frequent","fresh","fretful","friendly","frightened","frightening","full","fumbling","functional","funny","furry","furtive","future","futuristic","fuzzy"];
    const wAdjectives = ["wacky","waggish","waiting","wakeful","wandering","wanting","warlike","warm","wary","wasteful","watery","weak","wealthy","weary","well-groomed","well-made","well-off","well-to-do","wet","whimsical","whispering","white","whole","wholesale","wicked","wide","wide-eyed","wiggly","wild","willing","windy","wiry","wise","wistful","witty","woebegone","womanly","wonderful","wooden","woozy","workable","worried","worthless","wrathful","wretched","wrong","wry"];

    //First finds the first letter of the day for alliteration, then uses that to choose which array to select from.
    if (findDayString()[0].toLowerCase() === "s"){
        return randomFromArray(sAdjectives); //Go to randomFromArray function.
    }
    else if (findDayString()[0].toLowerCase() === "m"){
        return randomFromArray(mAdjectives);
    }
    else if (findDayString()[0].toLowerCase() === "t"){
        return randomFromArray(tAdjectives);
    }
    else if (findDayString()[0].toLowerCase() === "w"){
        return randomFromArray(wAdjectives);
    }
    else if (findDayString()[0].toLowerCase() === "f"){
        return randomFromArray(fAdjectives);
    }
    else{
        console.log(findDayString());
        return "[Error]";
    }
}

//console.log(`Have a ${findAdjective()} ${findDayString()}!`)
document.getElementById("dayOfWeek").innerHTML = `Have a ${findAdjective()} ${findDayString()}!`;