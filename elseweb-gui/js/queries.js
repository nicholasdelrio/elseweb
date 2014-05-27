/* 
 * Contains functions for accessing SPARQL queries that return
 * data for populating ELSEWeb GUI widgets
 */


// The paths to the SPARQL query files
var queriesPath = "../queries";
var algorithmsQueryPath = queriesPath + "algorithms.rq";
var algorithmURIsQueryPath = queriesPath + "algorithmURIs.rq";
var charTemplatePath = queriesPath + "chracteristics-template.rq"

var queryString;

function setQueryString(data) {
    queryString = data;
    alert(queryString);
}

$.ajax({
    type: 'GET',
    url: $(this).attr('source'),
    dataType: '',
    success: setQueryString
});