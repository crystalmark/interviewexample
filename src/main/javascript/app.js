var hello = require("./hello");

window.onload = function() {

  console.log('window loaded');

  document.getElementById('hello-world').textContent = hello.world();
};
