<?php //defined('BASEPATH') OR exit('No direct script access allowed');

class StoreExperiment extends CI_Controller{

    public function __construct()
    {
        parent::__construct();
		$this->load->model('experiment_model');
		$this->load->library(array('session','form_validation'));
		$this->load->helper(array('url','form'));
    }


   //Store sigle experiment data from logged in user
    public function store(){
        
            $this->form_validation->set_rules('experiment', 'JSON DATA', 'required|trim|xss_clean');
 
            //throw error messages if we have any
            if($this->form_validation->run() == FALSE){
                echo validation_errors();
	    }
            else
            {
                //Parse JSON string
                $s = $this->input->post('experiment');
                $json = str_replace(array("\t","\n"), "", $s);
                $a = json_decode($json, true);

                //Uncomment For debugging purposes
                /*
                foreach($a as $item)
                {
                     var_dump($item);
                } 
                 */ 
          
               if($this->experiment_model->store_experiment($a)){
                   echo "success";
               }
                else{
                    echo "Error Occured";
               }
           }
    }
        
}

?>
