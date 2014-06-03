<?php //defined('BASEPATH') OR exit('No direct script access allowed');

class StoreExperiment extends CI_Controller{

    public function store(){
        $this->load->model('experiment_model');
        $s = "{\"specification\": {
                \"id\": \"d046d1fa-98cc-4705-b44d-884c263bbcfa\",
                \"occurrenceDataID\": \"1032789\",
                \"algorithm\": {
                    \"id\": \"ANN\",
                    \"parameterBindings\": [
                        {\"name\": \"Choice\", \"value\": \"1\", \"datatype\": \"integer\"},
                        {\"name\": \"Epoch\", \"value\": \"5000000\", \"datatype\": \"integer\"},
                        {\"name\": \"HiddenLayerNeurons\", \"value\": \"14\", \"datatype\": \"integer\"},
                        {\"name\": \"LearningRate\", \"value\": \"0.3\", \"datatype\": \"double\"},
                        {\"name\": \"MinimumError\", \"value\": \"0.01\", \"datatype\": \"double\"},
                        {\"name\": \"Momentum\", \"value\": \"0.05\", \"datatype\": \"double\"}         
                        ]
                },
                \"modelingScenario\": [
                    {\"datasetURI\": \"http://visko.cybershare.utep.edu/linked-data/edac/services/dataset_348882\"},
                    {\"datasetURI\": \"http://visko.cybershare.utep.edu/linked-data/edac/services/dataset_348883\"},
                    {\"datasetURI\": \"http://visko.cybershare.utep.edu/linked-data/edac/services/dataset_348884\"}
                    ]
                }
            }";   
          $json = str_replace(array("\t","\n"), "", $s);
          $a = json_decode($json, true);
          foreach($a as $item)
          {
               var_dump($item);
          } 
          
          $this->experiment_model->store_experiment($a);
          
    }
        
}

?>
