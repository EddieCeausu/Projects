var canvas = document.getElementById("myCanvas");
var tool = canvas.getContext("2d");

var gravity = 1;
var sq = { x: canvas.width/2, y: 550, width: 20, height: 20 };
var plat = { x: 100, y: 600, width: 1000, height: 30 }

var keyState = {};


window.addEventListener('keydown',function(e){
    keyState[e.keyCode || e.which] = true;
},true);

window.addEventListener('keyup',function(e){
    keyState[e.keyCode || e.which] = false;
},true);

function draw() {
  tool.clearRect(0,0, canvas.width, canvas.height);
  drawBall()
  drawPlatform()
  movement();
  //gravity = 0.5;
  sq.y += gravity;
  console.log(sq.x + " " + sq.y)
  // collision
  if(sq.y < sq.height || sq.y > canvas.height - sq.height)
    sq.y = -sq.y - 2;

  if(sq.x < sq.width || sq.x > canvas.width - sq.width)
    sq.x = -sq.x - 2;

    if (sq.x < plat.x + plat.width + 1 && 1+ sq.x + sq.height > plat.x && sq.y < plat.y + plat.height && sq.height + sq.y > plat.y) {
            keyState[40] = false;
            gravity = 0;
          } else {
            gravity = 1
          }
  //console.log(distance(sq.x, sq.y, platx, platy))

}



function drawPlatform() {
  tool.beginPath()
  tool.rect(plat.x, plat.y, plat.width, plat.height)
  tool.fillStyle = "#424b5b"
  tool.fill();
  tool.closePath()
}

function drawBall() {
  tool.beginPath();
  tool.rect(sq.x, sq.y, sq.width, sq.height);
  tool.strokeStyle = "#4286f4";
  tool.stroke();
  tool.closePath();
}

function movement() {
	if (keyState[37] || keyState[65])  // ← & a
    sq.x -= 2;

  if (keyState[39] || keyState[68])  // → & d
    sq.x += 2;

  if (keyState[40] || keyState[83])  // ↓ & s
    sq.y += 2;

  if (keyState[38] || keyState[87])  // ↑ & w
    sq.y -= 2;

    //sprint
  if (keyState[16] && (keyState[39] || keyState[68]))
    sq.x += 4;
  if (keyState[16] && (keyState[37] || keyState[65]))
    sq.x -= 4;
}

setInterval(draw, 10);
