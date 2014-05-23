<?php

class UserModel extends CI_Model{
    
    public function getData(){
        $query = $this->db->get('USER');
        return $query->result();
    }
    
}



?>