<?php defined('BASEPATH') OR exit('No direct script access allowed');

class History_model extends CI_Model {
    
    public function __construct() {
        parent::__construct();
        $this->load->library('session');
    }
    
    public function getExperimentList(){
        //to do
    }
    
    
    public function getExperimentDetails(){
       //to do
    }

}


?>
