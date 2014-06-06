/* Main Javascript Functions */

/* Experiment functions */
function genGUID(base_url){
    middleNoty('information', 'Submitting experiment...');
    $.blockUI({ message: null });
    $.ajax({
    url: base_url + '/' + 'guid',
    success: function(response) { 
         if(response){
             appendGUID(response, base_url);
         }
       }     
    });  
}

function appendGUID(guid, base_url){
    var experiment_json = $('#experiment').val();  
    experiment_json = $.parseJSON(experiment_json);
    experiment_json["specification"]["id"] = guid;
    experiment_json = JSON.stringify(experiment_json);
    //alert(guid);              
    //alert(experiment_json);
    runExperiment(experiment_json, base_url);
}


function runExperiment(experiment_json, base_url){
    $.ajax({
        //need to do a cross domain post
        'url' : 'http://visko.cybershare.utep.edu/elseweb-endpoint/JSONSpecification',
        'type' : 'POST', //the way you want to send data to your URL
        'data' : 'jsonSpec=' + experiment_json, 
        'success' : function(result){ 
            if(result){             
                    //Merge experiment and result json
                    experiment_json = $.parseJSON(experiment_json);
                    var merged_json = $.extend({}, experiment_json, result);
                    merged_json = JSON.stringify(merged_json);
                    $.unblockUI();
                    $.noty.closeAll();  
                    //alert(merged_json);
                    storeExperiment(merged_json, base_url);
            }
            else
                topNoty('error', 'An error has ocurred.');
        },
        'error' : function(){
                    $.noty.closeAll();
                    $.unblockUI();
                    topNoty('error', 'Oops! Something went wrong... try again later');
        }
            
    });      
    
}


function storeExperiment(experiment_json, base_url){  
    $.ajax({
        'url' : base_url + '/' + 'store',
        'type' : 'POST', //the way you want to send data to your URL
        'data' : 'experiment=' + experiment_json, //JSON.stringify(experiment_json)
        'success' : function(result){ 
            if(result){
                if (result === 'success'){
                    topNoty('success', 'Experiment submitted successfully!');
                }
                else
                    topNoty('error', 'Oops! something went wrong... try again later');
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
     
     
     
