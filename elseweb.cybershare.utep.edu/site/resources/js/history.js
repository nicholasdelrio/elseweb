/* File: history.js
 * Author: Luis Garnica
 * View Dependant: history
 * Description:   
 *  
 *  */

/*
 *  Function: experimentDetails
 *  Description: Receives base_url and experiment id
 *               POST resquest to obtain experiment details from database
 *               filtering by experiment id. 
 */


function experimentDetails(base_url, eid){
    var html = "";
    var i = 0 ;
    $.ajax({
        'url' : base_url + '/' + 'getExperimentDetails',
        'type' : 'POST', //the way you want to send data to your URL
        'data' : 'Eid=' + eid, 
        'success' : function(result){ 
            if(result){             
                    //Merge experiment and result json
                    //experiment_json = $.parseJSON(experiment_json);
                    result =$.parseJSON(result);
                    html += "<div class='row'>";
                    html += "<div class='col-md-12'>";
                    html += "<h4>General Information</h4>"; 
                    html += "<p>Experiment ID: "+result['specification']['id']+"</p>";
                    html += "<p>Timestamp: "+result['specification']['timestamp']+"</p>";
                    html += "<p>Algorithm: "+result['specification']['algorithm']['id']+"</p>";
                    html += "<hr />";
                    html += "<h4>Datasets</h4>";
                    for (dataset in result['specification']['modelingScenario']){
                        html += "<p><a href='"+result['specification']['modelingScenario'][i]['datasetURI']+"' target='_blank'>"+result['specification']['modelingScenario'][i]['datasetURI']+"</a></p>";
                        i++;
                    } 
                    html += "<hr />";
                    html += "<h4>Parameters</h4>";
                    html += "<div class='row'>";
                    i = 0;
                     for (param in result['specification']['algorithm']['parameterBindings']){
                        html += "<div class='col-md-6'>"; 
                        //console.debug(result['specification']['algorithm']['parameterBindings'][i]['name']);
                        html += "Name: "+result['specification']['algorithm']['parameterBindings'][i]['name'];
                        html += "</div>";
                        html += "<div class='col-md-6'>"; 
                        html += "Value: "+result['specification']['algorithm']['parameterBindings'][i]['value'];
                        html += "</div>";
                        i++;
                    }                    
                    html += "</div>"
                    html += "<hr />";
                    html += "<h4>Results</h4>";
                    html += "<p>Success: "+result['executedSpecification']['successful']+"</p>";
                    html += "<p>Result URL: <a href='"+result['executedSpecification']['experimentResult']['resultURL']+" '  target='_blank'>"+result['executedSpecification']['experimentResult']['resultURL']+"</a></p>";
                    html += "<p>Provinence URI: <a href='"+result['executedSpecification']['experimentResult']['resultURI']+"'  target='_blank'>"+result['executedSpecification']['experimentResult']['resultURI']+"</a></p>";
                    html += "</div>";
                    html += "</div>";
                    $('#expDetails').html( html );
                    $('#modalDetails').modal('show');
            }
            else
                topNoty('error', 'An error has ocurred.');
        },
        'error' : function(){
                    topNoty('error', 'Oops! Something went wrong... try again later');
        }
            
    });     
    
}