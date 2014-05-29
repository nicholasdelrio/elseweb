/* Main Javascript Functions */

function userLogin(base_url){   
    var username = $('#username').val();
    var password = $('#password').val();
    $.ajax({
        'url' : base_url + '/' + 'new_user',
        'type' : 'POST', //the way you want to send data to your URL
        'data' : 'username=' + username + '&password='  + password,
        'success' : function(result){ //probably this request will return anything, it'll be put in var "data"
            //var container = $('#container'); //jquery selector (get element by id)
            if(result){
                if (result === 'success'){
                    topNoty('success', 'Login Successful!');   
                }
                else
                    topNoty('warning', result)
            }
            else
                topNoty('error', 'An error has ocurred.');
        }       
    });
      
}




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
            speed: 700 
        },
        timeout: 2000
    });     
 }