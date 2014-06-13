<?php defined('BASEPATH') OR exit('No direct script access allowed');

class History_model extends CI_Model {
    
   //Query Parameters
   protected $limit = 100;
   protected $offset = 0;
    
    public function __construct() {
        parent::__construct();
        $this->load->library('session');
    }
    
    public function getUserExperimentList(){
        $userName = $this->session->userdata('username');
        $this->db->order_by("Etimestamp", "desc"); 
        $query = $this->db->get_where('EXPERIMENT', array('Uusername_FK' => $userName), $this->limit, $this->offset);
        return $query->result_array();
    }
    
    public function getExperimentByID($Eid){
       $userName = $this->session->userdata('username'); 
       $query = $this->db->get_where('EXPERIMENT', array('Uusername_FK' => $userName, 'Eid' => $Eid), 1, $this->offset);
       return $query->row();
    }
    
    public function getExperimentDataset($Eid){
       $query = $this->db->get_where('EXPERIMENT_DATASETS', array('Eid_FK' => $Eid), null, $this->offset);
       return $query->result();
    }
    
    public function getExperimentParameters($Eid){
       $query = $this->db->get_where('EXP_PARAMETERS', array('Eid_FK' => $Eid), null, $this->offset);
       return $query->result();
    }

}


?>
