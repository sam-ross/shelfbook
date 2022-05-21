var timesClicked = 0;

function showTimesClicked() {
  timesClicked++;
  document.getElementById("para1").innerText = "Times clicked: " + timesClicked;
}

function changeHeader() {
  document.getElementById("header1").innerText = "Shelfbook" + timesClicked;
}

function callHelloEndpoint() {
  var request = new XMLHttpRequest();
  // request.open("GET", "http://localhost:7777/hello", false);
  request.open("GET", "http://www.google.com", false);
  request.send();
  console.log(request.responseText);
}

function alertUser() {
  window.alert("Red alert!!!");
}

function confirmFart() {
  if (window.confirm("Are you sure you're ready for stinky fart?")) {
    playFartNoise();
  }
}

playFartNoise = () => document.getElementById("fart").play();

function changeAuthor() {
  var newDesigner = window.prompt(
    "Who's going to be taking the credit?!? 🤠",
    "John Doe"
  );
  if (newDesigner != null) {
    document.getElementById("footerDesigner").innerText = "By " + newDesigner;
  }
}

function helloWorld() {
  console.log("Hello world");
}

function springMessage() {
  // var xmlHttp = new XMLHttpRequest();
  // xmlHttp.onreadystatechange = function () {
  //   if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
  //     callback(xmlHttp.responseText);
  // };

  // xmlHttp.onload = function () {
  //   console.log("load");
  // };
  // xmlHttp.onerror = function () {
  //   console.log("error");
  // };
  // xmlHttp.onprogress = function () {
  //   console.log("progress");
  // };

  // xmlHttp.open("GET", "http://localhost:7777/helloSam", false);
  // xmlHttp.send();
  // console.log(xmlHttp.responseText);

  const Http = new XMLHttpRequest();
  const url = "http://localhost:7777/helloSam";
  Http.open("GET", url);
  Http.send();

  Http.onreadystatechange = (e) => {
    console.log(Http.responseText);
  };
}
