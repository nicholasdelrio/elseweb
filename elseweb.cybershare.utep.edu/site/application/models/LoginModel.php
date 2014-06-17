<?php  defined('BASEPATH') OR exit('No direct script access allowed');

/* File: LoginModel.php
 * Author: Luis Garnica
 * View Dependant: login, register
 * Description: This class user login to the elseweb website and user registration. 
 *  
 *  */

class LoginModel extends CI_Model {
    
    public function __construct() {
        parent::__construct();
    }
    
    
   /*
    * Function: login_user
    * Description: Receives input of username and password, checks combination against the
    *              database and returns a user row if successful.
    * */
    
    public function login_user($username,$password)
    {
        $this->db->where('Uusername',$username);
        $this->db->where('Upassword',$password);
        $query = $this->db->get('USER'); //Table name USER
        if($query->num_rows() == 1)
        {
            return $query->row();
        }else{
            $this->session->set_flashdata('incorrect_user','Invalid user/password combination'); //Used for error reporting
            echo "Invalid user/password combination"; //Response to ajax
        }
    }
    
    
   /*
    * Function: add_user
    * Description: Inserts user registration data into DB, discipline and organization
    *              are tables are checked in order to prevent data repetition.
    * */
    
    
    public function add_user($username,$password, $email, $discipline, $organization)
    {
       
       try{ 
            //Begin the transaction
            $this->db->trans_start();
            $Dis_exits = $this->checkExistance('DISCIPLINE', 'Dname', $discipline);
            if ($Dis_exits == false){ 
                $data=array(
                   'Dname'=>$discipline
                );
                $this->db->insert('DISCIPLINE',$data);
                
                //Get last inserted Discipline
                $this->db->select_max('Did');
                $query = $this->db->get('DISCIPLINE');
                $Did = $query->row()->Did;
            }
            else{
                $Did = $Dis_exits->row()->Did;
            }
                
          
            $Org_exits = $this->checkExistance('ORGANIZATION', 'Oname', $organization);
            if ($Org_exits == false){ 
                $data=array(
                    'Oname'=>$organization
                 );
                 $this->db->insert('ORGANIZATION',$data);

                 //Get last inserted Organization
                 $this->db->select_max('Oid');
                 $query = $this->db->get('ORGANIZATION');
                 $Oid = $query->row()->Oid;
                
            }
            else{
                $Oid = $Org_exits->row()->Oid;
            }

            $data=array(
               'Uusername'=>$username,
               'Did_FK'=>$Did,
               'Oid_FK'=>$Oid,
               'Upassword'=>$password,
               'Uemail'=>$email
            );
            
            $this->db->set('Ureg_date', 'NOW()', FALSE);
            $this->db->insert('USER',$data);

            //End of transaction
            $this->db->trans_complete();
       }
       catch (Exception $e) {
            echo ('error: '.$e->getMessage());  
            return;
       }

       if ($this->db->trans_status() == TRUE){
           return true;
       }
       else{
           return false;
       }
   
    }
    
    
   /*
    * Function: checkExistance
    * Description: Checks if received value exists on the designated column and table,
    *              returns false if the value is not found.
    * */
    
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
