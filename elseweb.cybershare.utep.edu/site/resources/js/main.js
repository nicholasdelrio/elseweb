/* Main Javascript Functions */

/* Experiment functions */



function storeExperiment(base_url){
    var experiment_json = $('#experiment').val();
    $.ajax({
        'url' : base_url + '/' + 'store',
        //'dataType' : 'json',
        'type' : 'POST', //the way you want to send data to your URL
        'data' : 'experiment=' + experiment_json, //JSON.stringify(experiment_json)
        'success' : function(result){ 
            if(result){
                if (result === 'success'){
                    topNoty('success', 'Experiment information sucessfully stored!');
                }
                else
                    topNoty('warning', result);
            }
            else
                topNoty('error', 'An error has ocurred.');
        }       
    });       
    
}

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

/* Registration functions */

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

/* Functions used on the registration page for autocomplete inputs */

$(function(){
  $("#disc").autocomplete({
    source: disc_url //variable declared on the register view (contains controller url)
  });
}); 

$(function(){
  $("#org").autocomplete({
    source: org_url //variable declared on the register view (contains controller url)
  });
}); 

/* Notification Handler receives type (warning, error or success) and text to display 
 * notification will popup on the middle top of the webpage
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