let slideIndex = 1;

var timer;
var dropdownMenu = document.getElementById("dropdown");
var cbox= document.getElementsByClassName("chkbx");
var sbtn= document.getElementsByClassName("button-1"); 
// });
// const point = document.querySelectorAll('.img');
// // const images = document.querySelectorAll('img');
sbtn.disabled = true;
showSlides(slideIndex);

function clearTimer(){
  clearTimeout(timer);
}
// Next/previous controls
function plusSlides(n) {
  showSlides(slideIndex += n);
}
function arrowpress(){
  document.addEventListener('keydown', function(event) {
    if (event.keyCode == 37 ) {
      showSlides(slideIndex -= 1);
    }
    else if (event.keyCode ==39){
      showSlides(slideIndex += 1);
    }
    
  })
}


// function hoverImg(){
//  if($('.img').hover){
//   clearTimer();
//  }
// }
// Thumbnail image controls
function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  let i;
  let slides = document.getElementsByClassName("slideshow");

  let dots = document.getElementsByClassName("dot");

  if (n > slides.length) {slideIndex = 1}
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  } 
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " active";
  var j=0;
  // for(j=0; j < point.length; j++ )
  // {
  //   point(j).onpointerover = (event) => {
  //     clearTimer();
  //   };
  // }
  if(!(clearTimer()))
  {timer = setTimeout(() => plusSlides(1), 12000)};
}
function myFunction() {
  document.getElementById("myDropdown").classList.toggle("show");
}
// Close the dropdown if the user clicks outside of it
window.onclick = function(event) {
  if (!(event.target.matches('.navbut'))) {
    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}

function myFunction2() {
  var x = document.getElementsById("navbar");
  if (x.className === "Nav") {
    x.className += " responsive";
  } else {
    x.className = "Nav";
  }
}


// function myFunction(x) {
//   x.classList.toggle("change");
//   }

// const dropdownBtn = document.getElementById("btn");
// const dropdownMenu = document.getElementById("dropdown");
// // const dropdownBtn = 

// const toggleDropdown = function () {
//   dropdownMenu.classList.toggle("show");
// };

// dropdownBtn.addEventListener("click", function (e) {
//   toggleDropdown();
// });

// document.getElementsById("navbut").addEventListener("click", function () {
//   toggleDropdown();
// https://stackoverflow.com/questions/14795099/pure-javascript-to-check-if-something-has-hover-without-setting-on-mouseover-ou });
