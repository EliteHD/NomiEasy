let menuicn = document.querySelector(".menuicn");
let nav = document.querySelector(".navcontainer");

//menuicn.addEventListener("click", () => {
//	nav.classList.toggle("navclose");
//})
;
$(document).ready(function () {
    $('.sidenav').sidenav();
});
document.addEventListener("DOMContentLoaded", function () {
    $('.preloader-background').delay(1700).fadeOut('slow');

    $('.preloader-wrapper')
        .delay(1700)
        .fadeOut();
});
