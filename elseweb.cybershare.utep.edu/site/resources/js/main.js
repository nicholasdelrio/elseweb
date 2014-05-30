/* Main Javascript Functions */

function userLogin(base_url){   
    var username = $('#username').val();
    var password = $('#password').val();
    $.ajax({
        'url' : base_url + '/' + 'new_user',
        'type' : 'POST', //the way you want to send data to your URL
        'data' : 'username=' + username + '&password='  + password,
        'success' : function(result){ //probably this request will return anything, it'll be put in var "result"
            //var container = $('#container'); //jquery selector (get element by id)
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

function userRegister(base_url){   
    var username = $('#reg_username').val();
    var password = $('#reg_password').val();
    var pass_confirm = $('#pass_confirm').val();
    var email = $('#email').val();
    var discipline = $('#disc').val();
    var organization = $('#org').val();
        $.ajax({
            'url' : base_url + '/' + 'register',
            'type' : 'POST', //the way you want to send data to your URL
            'data' : 'username=' + username + '&password='  + password + '&pass_confirm='  + pass_confirm + '&email='  + email + '&disc='  + discipline + '&org='  + organization,
            'success' : function(result){ //probably this request will return anything, it'll be put in var "result"
                //var container = $('#container'); //jquery selector (get element by id)
                if(result){
                    if (result === 'success'){
                        topNoty('success', 'Registration Successful!');
                        $('#registerForm').trigger("reset");
                    }
                    else
                        topNoty('warning', result);
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
        timeout: 1800
    });     
 }