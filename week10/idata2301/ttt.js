function load() {
  document.getElementsByTagName("p")[0].innerText = "Hello World!";

  const element = document.createElement("p");
  let seconds = 0;
  element.innerText = "0 seconds have passed";
  document.body.appendChild(element);

  setInterval(() => {
    element.innerText = `${seconds++} seconds have passed`;
  }, 1000);

  const a = document.getElementById("a");
  const b = document.getElementById("b");

  const result = document.getElementById("result");

  const sumdating = () => {
    result.innerText = parseFloat(a.value) + parseFloat(b.value);
  };

  a.addEventListener("keyup", sumdating);
  b.addEventListener("keyup", sumdating);

  const turnIndicator = document.getElementById("turn-indicator");
  const tiles = document.getElementById("ttt-grid");

  let isCircleTurn = false;
  let tilesClicked = 0;

  const updateTurnIndicator = () => {
    turnIndicator.innerText = isCircleTurn ? "circle" : "cross";
  };

  updateTurnIndicator();

  for (let tile of tiles.children) {
    tile.addEventListener("click", () => {
      if (tilesClicked < 9 && !tile.classList.contains("clicked")) {
        tile.innerText = isCircleTurn ? "O" : "X";
        isCircleTurn = !isCircleTurn;
        tile.classList.add("clicked");
        updateTurnIndicator();
        tilesClicked++;
      }
    });
  }

  const reset = document.getElementById("reset");

  reset.addEventListener("click", () => {
    for (let tile of tiles.children) {
      tile.innerText = "";
      tile.classList.remove("clicked");
      isCircleTurn = false;
      tilesClicked = 0;
      updateTurnIndicator();
    }
  });

  const favoriteColorSelect = document.getElementById("favorite-color");

  let colors = ["red", "green", "blue"];
  let colorIndex = 0;

  setInterval(() => {
    // document.body.style.backgroundColor = colors[colorIndex];
    colorIndex = (colorIndex + 1) % colors.length;
  }, 1000);

  favoriteColorSelect.addEventListener("change", () => {
    if (favoriteColorSelect.value === "Roundhouse Kick") {
      document.body.style.backgroundImage =
        "url('https://images01.military.com/sites/default/files/styles/full/public/2021-04/chucknorris.jpeg.jpg')";
      document.body.style.backgroundSize = "cover";
    } else {
      document.body.style.backgroundImage = "none";
      document.body.style.backgroundColor = favoriteColorSelect.value;
    }
  });

  document.getElementById("hello-adder").addEventListener("click", addHello);
  document
    .getElementById("hello-remover")
    .addEventListener("click", removeHello);

  const magicButton = document.getElementById("magic-button");
  
  magicButton.addEventListener("mouseover", () => {
    magicButton.style.position = "absolute";
    magicButton.style.left = Math.random() * 100 + "%";
    magicButton.style.top = Math.random() * 100 + "%";
  });
}

const addHello = () => {
  const container = document.getElementById("hello-container");
  const hello = document.createElement("p");
  hello.innerText = "Hello World!";
  container.appendChild(hello);
};

const removeHello = () => {
  const container = document.getElementById("hello-container");
  if (container.children.length > 0)
    container.removeChild(container.children[0]);
};
