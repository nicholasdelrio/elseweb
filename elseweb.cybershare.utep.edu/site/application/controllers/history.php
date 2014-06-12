<?php

class History extends MY_Controller{
    
       //public function __construct()
      // {
       // parent::__construct();
		
       //}
    
      
	public function index($renderData=""){	
            $this->load->model('history_model');
            $this->data['experiment'] = $this->history_model->getExperimentList();   
         
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
        
}

?>

