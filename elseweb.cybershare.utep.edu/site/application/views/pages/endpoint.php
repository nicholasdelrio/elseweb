
<div class="container">
    <div class="row">
        <div class="text-center feature-head">
            <h3>ELSEWeb Experiment Specification Submission</h3>
        </div>        
    </div>
    
    <div class="row">
        <div class="text-center col-md-12">
          <p>You have accessed the <a href="http://elseweb.cybershare.utep.edu/">ELSEWeb Project</a> experiment endpoint.</p> 
          <p>Please submit your ELSEWeb experiment specification in the text box below. An example specification can be found below.</p>
        </div>
    </div>
    
    
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <form role="form" method="post" onsubmit="return false;">
           <div class="form-group">
             <textarea id="experiment" name="experiment" rows="22" style="width: 100%">
                    {"specification": {
                        "occurrenceDataID": "1032789",
                        "algorithm": {
                            "id": "ANN",
                            "parameterBindings": [
                                {"name": "Choice", "value": "1", "datatype": "integer"},
                                {"name": "Epoch", "value": "5000000", "datatype": "integer"},
                                {"name": "HiddenLayerNeurons", "value": "14", "datatype": "integer"},
                                {"name": "LearningRate", "value": "0.3", "datatype": "double"},
                                {"name": "MinimumError", "value": "0.01", "datatype": "double"},
                                {"name": "Momentum", "value": "0.05", "datatype": "double"}         
                                ]
                        },
                        "modelingScenario": [
                            {"datasetURI": "http://visko.cybershare.utep.edu/linked-data/edac/services/dataset_348882"},
                            {"datasetURI": "http://visko.cybershare.utep.edu/linked-data/edac/services/dataset_348883"},
                            {"datasetURI": "http://visko.cybershare.utep.edu/linked-data/edac/services/dataset_348884"}
                            ]
                        }
                    }		                 
             </textarea>
           </div>
                <button type="button" class="btn btn-purchase pull-right" 
                        onclick="genGUID('storeExperiment')">
                        Run Experiment
                </button>
         </form>
        </div>
    </div>
    
    <div class="row info-paragraph">
        <div class="text-center col-md-8 col-md-offset-2">
            <p>
               Alternatively, you can POST experiment specifications to the 
               <a href="./JSONSpecification">JSONSpecification Submission Service</a>. 
               Specifications posted to the JSONSpecification submission service should be bound to the 
               <b>jsonSpec</b> parameter.
            </p>
        </div>
    </div>
    
    
</div>
