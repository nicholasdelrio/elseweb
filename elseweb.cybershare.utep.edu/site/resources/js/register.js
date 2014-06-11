/* File: register.js
 * Author: Luis Garnica
 * View Dependant: register
 * Description: Functions used for elseweb user registration. 
 *  
 *  */

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