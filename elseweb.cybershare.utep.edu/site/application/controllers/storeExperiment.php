<?php defined('BASEPATH') OR exit('No direct script access allowed');

/* File: storeExperiment.php (controller)
 * Author: Luis Garnica
 * View Dependant: endpoint
 * Description: Experiment uid generation, experiment persistance on database
 *              and final result rendering.
 *  */

class StoreExperiment extends CI_Controller{

    public function __construct()
    {
        parent::__construct();
		$this->load->model('experiment_model');
		$this->load->library(array('session','form_validation'));
		$this->load->helper(array('url','form'));
                if (!$this->session->userdata('is_logged_in')){
                    die("Restricted Access");
                }
    }

   /*
    * Function: store
    * Description: Receives raw json string. Json is parsed and processed for database insertion.
    * */   

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
                    echo "Error ocurred on execution... try again later.";
               } 
           }
    }
    
   /*
    * Function: store
    * Description: Render experiment results after successful run.
    * Note: Deprecated method probably not used, confirmation needed. 
    *       Need to delete on confirmation that this is no longer used.
    * */      
    
    public function viewResults(){
        $this->form_validation->set_rules('experiment', 'JSON DATA', 'required|trim|xss_clean');
        //throw error messages if we have any
        if($this->form_validation->run() == FALSE){
                echo validation_errors();
	}
        else{
           $string_json =  $this->input->post('experiment');
           $json = str_replace(array("\t","\n"), "", $string_json);
           $this->data = json_decode($json, true);
           
           //Render Endpoint view again with json data
           $this->load->view('endpoint',$this->data);          
        }
            
    }
    
   /*
    * Function: guid
    * Description: Generates a unique id for a corresponding experiment ajax request.
    * */   
    
    public function guid(){
       if (function_exists('com_create_guid')){
        echo trim(com_create_guid(),'{}');
        }else{
            mt_srand((double)microtime()*10000);//optional for php 4.2.0 and up.
            $charid = strtoupper(md5(uniqid(rand(), true)));
            $hyphen = chr(45);// "-"
            $uuid = chr(123)// "{"
                    .substr($charid, 0, 8).$hyphen
                    .substr($charid, 8, 4).$hyphen
                    .substr($charid,12, 4).$hyphen
                    .substr($charid,16, 4).$hyphen
                    .substr($charid,20,12)
                    .chr(125);// "}"
            echo trim($uuid,'{}');
        }      
    }
        
}

?>
