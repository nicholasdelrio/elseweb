<?php defined('BASEPATH') OR exit('No direct script access allowed');

class History_model extends CI_Model {
    
   //Query Parameters
   protected $limit = 100;
   protected $offset = 0;
    
    public function __construct() {
        parent::__construct();
        $this->load->library('session');
    }
    
    public function getExperimentList(){
        $userName = $this->session->userdata('username');
        $this->db->order_by("Etimestamp", "desc"); 
        $query = $this->db->get_where('EXPERIMENT', array('Uusername_FK' => $userName), $this->limit, $this->offset);
        return $query->result_array();
    }
    
    
    public function getExperimentDetails(){
       //to do
    }

}


?>
