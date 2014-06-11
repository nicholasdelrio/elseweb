/* File: endpoint.js
 * Author: Luis Garnica
 * View Dependant: endpoint
 * Description: Submit an experiment specification to the 
 *              endpoint service and save experiment data on elseweb database.  
 *  
 *  */


/*
 * Function: genGUID
 * Description: Generates a unique ID for the submitted specification.
 */

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


/*
 * Function: appendGUID
 * Description: Appends guid received as a parameter to the experiment_json string.
 */


function appendGUID(guid, base_url){
    var experiment_json = $('#experiment').val();  
    experiment_json = $.parseJSON(experiment_json); //string to manipulable json
    experiment_json["specification"]["id"] = guid; //append generated experiment id
    experiment_json = JSON.stringify(experiment_json);  //json to string
    //alert(guid);              
    //alert(experiment_json);
    runExperiment(experiment_json, base_url);
}


/*
 * Function: runExperiment
 * Description: POST  experiment_json to service endpoint
 *              Waits for result json and appends to original experiment_json.
 */

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


/*
 * Function: storeExperiment
 * Description: POST to controller that takes care of inserting experiment data into the elseweb 
 *              database. The json post is sent as a string. 
 *              On success the submit experiment container will be replaced with experiment results.
 */


function storeExperiment(experiment_json, base_url){  
    var html = ""; //Will store raw html with experiment results
    $.ajax({
        'url' : base_url + '/' + 'store',
        'type' : 'POST', //the way you want to send data to your URL
        'data' : 'experiment=' + experiment_json, //JSON.stringify(experiment_json)
        'success' : function(result){ 
            if(result){
                if (result === 'success'){
                    experiment_json = $.parseJSON(experiment_json);
                    topNoty('success', 'Experiment submitted successfully!');
                    $('#endpoint_container').fadeOut('slow');
                    $('#endpoint_container').empty();
                    html += "<div class='row'>";
                    html += "<div class='text-center feature-head'>";
                    html +=  "<h3>ELSEWeb Experiment Specification Results</h3>";
                    html += "</div>";
                    html += "</div>";
                    html += "<div class='property gray-bg'>";
                    html += "<div class='row'>";
                    html += "<div class='col-md-8 col-md-offset-2'>";
                    html += "<p>Experiment ID: "+experiment_json['specification']['id']+" </p>";
                    html += "<p>Success: "+experiment_json['executedSpecification']['successful']+" </p>";
                    html += "<p>Result URL: <a href='"+experiment_json['executedSpecification']['experimentResult']['resultURL']+"' target='_blank'>"+experiment_json['executedSpecification']['experimentResult']['resultURL']+"</a></p>";
                    html += "<p>Result URI: <a href='"+experiment_json['executedSpecification']['experimentResult']['resultURI']+"' target='_blank'>"+experiment_json['executedSpecification']['experimentResult']['resultURI']+"</a></p>";
                    html += "</div>";
                    html += "</div>"; 
                    html += "</div>"; 
                    html += "<div class='row'>";
                    html += "<div class='text-center col-md-4 col-md-offset-2'>";
                    html += "<a href='endpoint'><button type='button' class='btn btn-purchase'>New Experiment</button></a>";
                    html += "</div>";
                    html += "<div class='text-center col-md-4'>";
                    html += "<a href=''><button type='button' class='btn btn-default'>Experiment History</button></a>";
                    html += "</div>";
                    html += "</div>";
                    html += "</div>";
                    $('#endpoint_container').html( html );
                    $('html, body').animate({ scrollTop: $('#endpoint_container').offset().top }, 500);
                    $('#endpoint_container').fadeIn()('slow');
                    
                }
                else
                    topNoty('error', 'Oops! something went wrong... try again later');
            }
            else
                topNoty('error', 'An error has ocurred.');
        }       
    });       
    
}