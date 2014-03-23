<!--container start-->
<div class="container">

   <div class="row">
        <div class="hiring">
            <div class="col-lg-6 col-sm-6">
                <div class="content">
                    <img width="500" src="<?php echo base_url(IMAGES."elseweb-gui.png");?>" alt="text img">    
                </div>
            </div>
            <div class="col-lg-6 col-sm-6">
                <h3>This component is undergoing a major overhaul and is currently not available.</h3>
                <div class="content">
                    <h3 class="title">Option 1: Experiment Graphical User Interface</h3>
                    <p>The primary entry point to the ELSEWeb system is through the ELSEWeb graphical user interface. Through the interface, users can specify an experiment specification in terms of:</p>
                    <ul>
                        <li><p><a href="<?php echo LODSPEAKR."instances/elseweb_edac:PublishedPRISMDataset";?>">Scenario Data</a></p></li>
                        <li><p><a href="<?php echo LODSPEAKR."instances/elseweb_lifemapper:LifemapperAlgorithm";?>">Algorithm Selection</a></p></li>
                        <li><p><a href="<?php echo LODSPEAKR."instances/elseweb_lifemapper:ParameterDescription";?>">Algorithm Parameters</a></p></li>
                        <li><p><a href="<?php echo LODSPEAKR."instances/elseweb_lifemapper:SpeciesOccurrenceDataset";?>">Species Occurrence Data</a></p></li>
                    </ul>

                    <a href="#" class="btn btn-purchase">Run an Experiment</a></p>

                </div>
            </div>
        </div>
    </div>


    <div class="row">
        <div class="hiring">
            <div class="col-lg-6 col-sm-6">
                <div class="content">
                    <h3 class="title">Option 2: Experiment Endpoint Service</h3>
                    <p>The Experiment Interface presented above captures users selection in the form of an <a href="http://ontology.cybershare.utep.edu/ELSEWeb/linked-data/lifemapper/experiments/specifications/json/sample-specification.json">ELSEWeb experiment specification</a>. These specifications are posted to an underlying <a href=”http://visko.cybershare.utep.edu/elseweb-endpoint/”>HTTP POST service</a>. Power users can generate their own JSON specifications and submit them to the service through the input text box or submit specifications programmatically.</p>
                    <a href="<?php echo ENDPOINT;?>" class="btn btn-purchase">Submit a Specification</a></p>
                </div>
            </div>
            <div class="col-lg-6 col-sm-6">
                <div class="content">
                    <pre><span class="inner-pre" style="font-size: 8px">{"specification": {
    "id": "d046d1fa-98cc-4705-b44d-884c263bbcfa",
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
            {"datasetURI": "http://visko.cybershare.utep.edu/linked-data/edac/services/dataset_348880"},
            {"datasetURI": "http://visko.cybershare.utep.edu/linked-data/edac/services/dataset_348881"},
            {"datasetURI": "http://visko.cybershare.utep.edu/linked-data/edac/services/dataset_348884"}
            ]
    }
}</span></pre>
                </div>
            </div>
        </div>
    </div>

   <div class="row">
        <div class="hiring">
                        <div class="col-lg-6 col-sm-6">
                <div class="content">
                    <pre><span class="inner-pre" style="font-size: 9px">{"executedSpecification": {
    "successful": "true",
    "experimentResult": {
        "resultURI": "http://visko.cybershare.utep.edu/linked-data/elseweb/sadi/experimentResult-ef92ec6c-fffe-444d-b052-ff99ac5fe358",
        "resultURL": "http://lifemapper.org/services/sdm/experiments/999951"
        }
    }
}</span></pre>
                </div>
            </div>
            <div class="col-lg-6 col-sm-6">
                <div class="content">
                    <h3 class="title">Experiment Results</h3>
                    <p>
                    If ELSEWeb was able to execute your experiment successfully, you will be provided with both a link to the Lifemapper experiment result page as well as a link to the provenance trace associated with the experiment run. This information is encoded within a JSON response which indicates: whether the experiment was successfully executed, the link to the Lifemapper result page, and a link to the provenance trace (i.e., resultURI).
                    </p>
                </div>
            </div>
        </div>
    </div>


</div>
<!--container end-->

