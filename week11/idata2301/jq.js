$(document).ready(() => {
  $("p").text("Hello World!");

  $.ajax("https://jsonplaceholder.typicode.com/posts/1").done((data) => {
    $("#post").text(data.title);
  });
});
