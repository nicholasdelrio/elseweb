<?php  //defined('BASEPATH') OR exit('No direct script access allowed');

class History extends MY_Controller{
    
       //public function __construct()
      // {
       // parent::__construct();
		
       //}
    
      
	public function index($renderData=""){	
            $this->load->model('history_model');
            $this->data['experiment'] = $this->history_model->getUserExperimentList();   
         
            $this->title = "ELSEWeb | Experiment History";
            $this->keywords = "elseweb, cybershare, species modeling, species modelling";
		
                
            if ($this->session->userdata('is_logged_in')){          
                $folder = 'template';
                $this->_render('pages/history',$renderData, $folder);     
            }
            else{
                $folder = 'template';
                $this->_render('pages/register',$renderData, $folder);   

            }
  
        }
        
        public function getExperimentDetails(){
            $this->load->model('history_model');
            $Eid = $this->input->post('Eid');
            $experiment = $this->history_model->getExperimentByID($Eid);
            //Append general experiment information
            $json['specification']['id'] = $experiment->Eid;
            $json['specification']['ocurrenceDataID'] = $experiment->EocurrenceDataID;
            $json['specification']['timestamp'] = $experiment->Etimestamp;
            $json['specification']['algorithm']['id'] = $experiment->Aid_FK;
            
            //Append experiment parameters (name and value)
            $parameters = $this->history_model->getExperimentParameters($Eid);
            $i = 0;
            foreach ($parameters as $row){
                $json['specification']['algorithm']['parameterBindings'][$i]['name'] = $row->Pname_FK;
                $json['specification']['algorithm']['parameterBindings'][$i]['value'] = $row->Pvalue; 
                $i++;

            }
            
            //Append Environment URIs
            $datasets = $this->history_model->getExperimentDataset($Eid);
            foreach($datasets as $row){
                $json['specification']['modelingScenario'][]['datasetURI'] = $row->datasetURI_FK;   
            }
           
            
            //Append experiment results
            $json['executedSpecification']['successful'] = $experiment->Estatus;
            $json['executedSpecification']['experimentResult']['resultURI'] = $experiment->EprovinenceID;
            $json['executedSpecification']['experimentResult']['resultURL'] = $experiment->EresultURL;
            
            
            $json = json_encode($json);
            echo($json); //json response
             
        }
        
        
}

?>

