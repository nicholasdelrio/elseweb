<?php defined('BASEPATH') OR exit('No direct script access allowed');

/* File: history_model.php
 * Author: Luis Garnica
 * View Dependant: history
 * Description: Fetches experiment information for history table and experiment
 *              details view.
 *  
 *  */

class History_model extends CI_Model {
    
   //Query Parameters
   protected $limit = 1000; //default maximum of 1000 records
   protected $offset = 0;
    
    public function __construct() {
        parent::__construct();
        $this->load->library('session');
    }
    
    
   /*
    * Function: getUserExperimentList
    * Description: Fetches a list of experiments ran by current logged in user ordered by timestamp
    *              in descencing order.
    * */   
    
    public function getUserExperimentList(){
        $userName = $this->session->userdata('username');
        $this->db->order_by("Etimestamp", "desc"); 
        $query = $this->db->get_where('EXPERIMENT', array('Uusername_FK' => $userName), $this->limit, $this->offset);
        return $query->result_array();
    }
    
   /*
    * Function: getExperimentByID
    * Description: Fetches a sigle experiment row by its id. Needed for details view.
    * */       
    
    public function getExperimentByID($Eid){
       $userName = $this->session->userdata('username'); 
       $query = $this->db->get_where('EXPERIMENT', array('Uusername_FK' => $userName, 'Eid' => $Eid), 1, $this->offset);
       return $query->row();
    }
    
   /*
    * Function: getExperimentDataset
    * Description: Returns experiment datasets from a single experiment by ID.
    * */
    
    public function getExperimentDataset($Eid){
       $query = $this->db->get_where('EXPERIMENT_DATASETS', array('Eid_FK' => $Eid), null, $this->offset);
       return $query->result();
    }
    
    
   /*
    * Function: getExperimentParameters
    * Description: Returns experiment parameters (name and value) from a sigle experiment by ID.
    * */
    
    public function getExperimentParameters($Eid){
       $query = $this->db->get_where('EXP_PARAMETERS', array('Eid_FK' => $Eid), null, $this->offset);
       return $query->result();
    }

}


?>
