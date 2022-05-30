$(document).ready(function(){
    $('#login').click(function(){
        $('.login-form').addClass('popup');
    });
    
    $('.login-form form fa-times').click(function(){
        $('.login-form').removeClass('popup');
    });
    
    
    
    });