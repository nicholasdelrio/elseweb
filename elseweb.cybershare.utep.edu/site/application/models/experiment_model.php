<?php defined('BASEPATH') OR exit('No direct script access allowed');

class Experiment_model extends CI_Model {
    
    public function __construct() {
        parent::__construct();
        $this->load->library('session');
    }
    
    public function store_experiment($decoded_json){
        
      try{ 
            $this->db->trans_start();

            //Insert Algorithm into the database if it does not exist
            $Aid = $decoded_json['specification']['algorithm']['id'];
            if($this->checkExistance('ALGORITHM', 'Aid', $Aid)==FALSE){
                $data=array(
                       'Aid'=>$Aid
                );
                $this->db->insert('ALGORITHM',$data);
            }

            //Get data for Experiment table
            $Eid = $decoded_json['specification']['id'];
            $EocurrendeDataID = $decoded_json['specification']['occurrenceDataID'];
            $Uusername = $this->session->userdata('username');
            $Estatus = "success"; //hardcoded CHANGE THIS
            $this->db->set('Etimestamp', 'NOW()', FALSE);
            $data=array(
                'Eid'=>$Eid,
                'Aid_FK'=>$Aid,
                'Uusername_FK'=>$Uusername,
                'Estatus'=>$Estatus,
                'EocurrenceDataID'=>$EocurrendeDataID
            );
            $this->db->insert('EXPERIMENT',$data);

            foreach ($decoded_json['specification']['algorithm']['parameterBindings'] as $param){
                //Insert parameter name only if it doesn't exist in PARAMETER table
                if($this->checkExistance('PARAMETER', 'Pname', $param['name'])==FALSE){
                    $data=array(
                           'Pname'    => $param['name'],
                           'Aid_FK' => $Aid
                    );
                    $this->db->insert('PARAMETER',$data);
                 }

                 $data=array(
                        'Pname_FK' => $param['name'],
                        'Eid_FK'   => $Eid,
                        'Pvalue'   => $param['value']
                 );
                 $this->db->insert('EXP_PARAMETERS',$data);
            }

            foreach($decoded_json['specification']['modelingScenario'] as $scenario){
                 //Insert datasetURI only if it doesn't exist in ENVIRONMENT table
                if($this->checkExistance('ENVIRONMENT', 'datasetURI', $scenario['datasetURI'])==FALSE){ 
                    $data=array(
                            'datasetURI' => $scenario['datasetURI']
                     );
                     $this->db->insert('ENVIRONMENT',$data); 
                }
                
                $data=array(
                    'datasetURI_FK' => $scenario['datasetURI'],
                    'Eid_FK'        => $Eid
                );
                $this->db->insert('EXPERIMENT_DATASETS',$data); 
            }

            //End of transaction
            $this->db->trans_complete();
      }
      catch (Exception $e) {
            echo ('error: '.$e->getMessage());  
            return false;
      }
       
       if ($this->db->trans_status() == TRUE){
           return true;
       }
       else{
           return false;
       }
                 
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