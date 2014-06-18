/* File: main.js
 * Author: Luis Garnica
 * View Dependant: All
 * Description: Javascript functions available for all views.
 *              -> User Login Handling
 *              -> Noty plugin handler functions (general notifications).
 *  
 *  */


/* User Login functions */

function userLogin(base_url){   
    var username = $('#username').val();
    var password = $('#password').val();
    $.ajax({
        'url' : base_url + '/' + 'new_user',
        'type' : 'POST', //the way you want to send data to your URL
        'data' : 'username=' + username + '&password='  + password,
        'success' : function(result){ //probably this request will return anything, it'll be put in var "result"
            if(result){
                if (result === 'success'){
                    topNoty('success', 'Login Successful!');
                    setTimeout('location.reload()', 2900);
                }
                else
                    topNoty('warning', result);
            }
            else
                topNoty('error', 'An error has ocurred.');
        }       
    });   
}


 
/* Functions: topNoty, middleNoty
 * Description: Notification Handler receives type (warning, error or success) and text to display 
 * notification will popup on the middle top of the current loaded webpage.
 * */

function topNoty (type, text) { 
    noty({
        layout: 'top',
        type: type,
        text: text,
        dismissQueue: true, 
        animation: {
            open: {height: 'toggle'},
            close: {height: 'toggle'},
            easing: 'swing',
            speed: 650 
        },
        timeout: 1900
    });     
 }
 
 function middleNoty(type, text){
     noty({
        layout: 'center',
        type: type,
        text: text,
        dismissQueue: false, 
        animation: {
            open: {height: 'toggle'},
            close: {height: 'toggle'},
            easing: 'swing',
            speed: 650 
        },
    });     
 }    
     
     
     
