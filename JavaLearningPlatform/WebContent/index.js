const menu = document.querySelector('#mobile-menu');
const menuLinks = document.querySelector('.nav-menu');
if(menu) {
menu.addEventListener('click', function() {
    menu.classList.toggle('is-active');
    menuLinks.classList.toggle('active');
})
}

