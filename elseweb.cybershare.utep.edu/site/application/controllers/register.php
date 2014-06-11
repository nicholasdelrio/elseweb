<?php defined('BASEPATH') OR exit('No direct script access allowed');

class Register extends MY_Controller{
    
    	public function index($renderData=""){	
		
		/*
		 *set up title and keywords (if not the default in custom.php config file will be set) 
		 */
         
         $this->title = "ELSEWeb | Registration";
		
		
        // 1. when you pass AJAX to renderData it will generate only that particular PAGE skipping other parts like header, nav bar,etc.,
        //      this can be used for AJAX Responses
        // 2. when you pass JSON , then the response will be json object of $this->data.  This can be used for JSON Responses to AJAX Calls.
        // 3. By default full page will be rendered
        $folder = 'template';
		$this->_render('pages/register',$renderData,'template');
	}
        
        public function get_discipline(){
             $this->load->model('registration_model');
             if ($this->input->get('term')){
                 $q = $this->security->xss_clean($this->input->get('term'));
                 $q = strtolower($q);
                 $this->registration_model->get_discipline($q);
             }
        }
        
        
        public function get_organization(){
             $this->load->model('registration_model');
             if ($this->input->get('term')){
                 $q = $this->security->xss_clean($this->input->get('term'));
                 $q = strtolower($q);
                 $this->registration_model->get_organization($q);
             }           
            
        }
    
}

?>
