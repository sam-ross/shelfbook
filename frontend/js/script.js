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

var bookNumber = 1;
function insertText() {
  const node = document.createElement("li");
  const textNode = document.createTextNode("Book " + bookNumber);

  node.appendChild(textNode);

  document.getElementById("book-list").appendChild(node);
  console.log(document.getElementById("book-list"));
  bookNumber++;
}

function deleteText() {
  if (bookNumber > 1) {
    var list = document.getElementById("book-list");
    list.removeChild(list.lastElementChild);
    bookNumber--;
  } else {
    console.log("No books left to remove");
  }
}

function insertBook() {
  var btn = document.createElement("button");
  btn.innerHTML = "Click me";
  btn.className("button-6");
  document.getElementById("book-section").appendChild(btn);
}

function insertButton() {
  var btn = document.createElement("button");
  btn.innerHTML = "Click me";
  document.getElementById("book-section").appendChild(btn);
}

function insertBookLink() {
  var buttonA = document.createElement("a");
  buttonA.href = "#";
  buttonA.innerText = "Book link";
  buttonA.className = "book-link";
  document.getElementById("book-section").appendChild(buttonA);
}

function insertImage() {
  var bookImage = document.createElement("img");
  bookImage.src = "./resources/bookSpine.png";
  bookImage.className = "book-image";
  document.getElementById("book-section").appendChild(bookImage);
}

var bookCounter = 1;
function insertBooks() {
  var bookImage = document.createElement("img");
  var bookColour;
  if (bookCounter % 3 == 1) {
    bookColour = "Red";
  } else if (bookCounter % 3 == 2) {
    bookColour = "Purple";
  } else {
    bookColour = "Green";
  }
  bookImage.src = "./resources/book" + bookColour + ".png";
  bookImage.className = "book-image";
  document.getElementById("book-section").appendChild(bookImage);
  bookCounter++;
}
