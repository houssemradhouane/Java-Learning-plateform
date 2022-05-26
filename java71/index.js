const menu = document.querySelector('#mobile-menu');
const menuLinks = document.querySelector('.nav-menu');
if(menu) {
menu.addEventListener('click', function() {
    menu.classList.toggle('is-active');
    menuLinks.classList.toggle('active');
})
}
/*https://stackoverflow.com/questions/62246139/how-to-create-login-authentication-client-side-using-javascript*/

