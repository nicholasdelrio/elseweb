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
                    html += "<p>"+result['specification']['id']+"</p>";
                    html += "<p>"+result['specification']['timestamp']+"</p>";
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