<?php

class Experiment_model extends CI_Model {
    
    public function __construct() {
        parent::__construct();
        $this->load->library('session');
    }
    
    public function store_experiment($decoded_json){
        $Eid = $decoded_json['specification']['id'];
        $EocurrendeDataID = $decoded_json['specification']['occurrenceDataID'];
        $Uusername = $this->session->userdata('username');
        $Estatus = "success"; //hardcoded
        
        $Aid = $decoded_json['specification']['algorithm']['id'];
        if($this->checkExistance('ALGORITHM', 'Aid', $Aid)==FALSE){
            $data=array(
                   'Aid'=>$Aid
            );
            $this->db->insert('ALGORITHM',$data);
        }
       
        foreach ($decoded_json['specification']['algorithm']['parameterBindings'] as $param){
           //Do parameter insertion here

           //echo $param['name']."\n";
           // echo $param['value'];
        }
        
        foreach($decoded_json['specification']['modelingScenario'] as $scenario){
            //echo $scenario['datasetURI'];
                       
        }
        
        $this->db->set('Etimestamp', 'NOW()', FALSE);
                
    }
    
    private function checkExistance ($tablename, $columnname, $value){
        $this->db->select('*');
        $this->db->like($columnname,$value);
        $query=$this->db->get($tablename);
        $result=$query->result_array();
        if(count($result))
        {
        return $query;
        }
        else
        {
        return FALSE;
        }
    }
    
}

?>
