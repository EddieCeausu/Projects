var currentSpeed = [108, 9]; // [hourSp, minuteSp]
const reductionHard = { "hours": 2, "minutes": (1/6) };
const reductionEasy = { "hours": 1, "minutes": (1/12) };
var currentScore = 0;

Number.prototype.pad = function (size) {
    var s = String(this);
    while (s.length < (size || 2)) { s = "0" + s; }
    return s;
}

function timeToString(time) {
    return time[0] + ":" + Number(time[1]).pad(2);
}

function genTime() {
    let currentTime = document.getElementById("time").innerHTML;
    // console.log("current time is", currentTime);

    var newTime =
        currentScore >= 1 ? (
            (Math.floor(Math.random() * (currentScore <= 12 ? currentScore - 1 : 12) + 1)).toString()
                + ":" +
                (Math.floor(Math.random() * 60)).pad(2).toString()) 
            : 12 + ":" + (Math.floor(Math.random() * 60)).pad(2).toString();
    console.log("New time is: ", newTime);
    return newTime;
}

function reset() {
    document.getElementById("hours-rotate").style.animation = "none";
    document.getElementById("min-rotate").style.animation = "none";
    document.getElementById("hours-rotate").offsetHeight;
    document.getElementById("min-rotate").offsetHeight;
    document.getElementById("hours-rotate").style.animation = null;
    document.getElementById("min-rotate").style.animation = null;
}

function stop() {
    document.getElementById("min-rotate").style.animationPlayState = 'paused';
    document.getElementById("hours-rotate").style.animationPlayState = 'paused';
    game();
}
function skipLevel(factor) {
    currentSpeed = [currentSpeed[0]-(2 * factor), currentSpeed[1]-((1/6) * factor)];
    document.getElementById("min-rotate").style.animation = "rotate" + currentSpeed[1] + "s infinite linear";
    document.getElementById("hours-rotate").style.animation = "rotate" + currentSpeed[0] + "s infinite linear";
    start();
}
function start() {
    document.getElementById("hours-rotate").style.animationPlayState = 'running';
    document.getElementById("min-rotate").style.animationPlayState = 'running';
}

function getTime() {
    // get matrix -> string array
    let matrixMin = (window.getComputedStyle(
        document.getElementById("min-rotate"))
        .getPropertyValue("transform")
        .split('(')[1].split(')')[0].split(','));
    let matrixHours = (window.getComputedStyle(
        document.getElementById("hours-rotate"))
        .getPropertyValue("transform"))
        .split('(')[1].split(')')[0].split(',');

    // [cosθ, -sinθ, sinθ, cosθ]
    console.log(matrixHours, matrixMin);

    //atan(cosθ, -sinθ) * 180 / pi -> round 
    let currentMinAngle = Math.round(Math.atan2(matrixMin[1], matrixMin[0]) * (180 / Math.PI));
    let currentHourAngle = Math.floor(Math.atan2(matrixHours[1], matrixHours[0]) * (180 / Math.PI));
    console.log(currentHourAngle, currentMinAngle);

    // if (-) -> 60 + - θ else ÷ 6
    var min = (currentMinAngle / 6) > 0 ? currentMinAngle / 6 : 60 + (currentMinAngle / 6);
    // hour = (θ - (min / 2)) / 30 if < 0 -> 12 + (θ - (min / 2)) / 30
    var hour = ((currentHourAngle - (min / 2)) / 30) > 0 ? (currentHourAngle - (min / 2)) / 30 : 12 + ((currentHourAngle - (min / 2)) / 30);
    console.log(hour, min);
    min = Math.round(min);
    hour = Math.ceil(hour);
    
    if (min == 60) {
        min = 0;
        hour += 1;
    }
    if (hour > 12) hour = 12 - hour;
    // console.log("Hours θ: ", currentHourAngle, "Minutes θ: ", currentMinAngle);
    // console.log("Hours: ", hour, "Minutes: ", min);
    console.log(hour, min);

    return [hour, parseInt(min.pad(2))];
}
function changeSpeed() {
    console.log(currentSpeed);
    currentSpeed = [currentSpeed[0]-2, currentSpeed[1]-(1/6)];
    console.log(currentSpeed);
    document.getElementById("min-rotate").style.animation = "rotate" + currentSpeed[1] + "s infinite linear";
    document.getElementById("hours-rotate").style.animation = "rotate" + currentSpeed[0] + "s infinite linear";
    
}
function game() {
    // time = [hour, minute]
    var userTime = getTime();
    let temp = document.getElementById("time").innerHTML;
    var goalTime = [temp.charAt(2) == ":" ? temp.substring(0,2) : temp.charAt(0), temp.substr(-2)];

    console.log("Goal time is: ", timeToString(goalTime), "\nTime on clock is: ", timeToString(userTime));
    
    // if time is good then increase scoreboard, change time, increase speed
    if (goalTime[0] == userTime[0] && goalTime[1] == userTime[1]){
        setTimeout(function () {
            document.getElementById("scoreboard").innerHTML = ++currentScore;
            changeSpeed();
            document.getElementById("time").innerHTML = genTime();
            reset();
            start();
        }, 2500);
        
    } else { // display wrong-box wait 2.5 seconds -> back to title screen
        var d = document.getElementById("wrong-box");
        d.style.display = "show";
        setTimeout(function() {
            d.style.display = "none";
            document.getElementById("time").innerHTML = genTime();
            reset();
            start();
        }, 2500);
        
    }

}



