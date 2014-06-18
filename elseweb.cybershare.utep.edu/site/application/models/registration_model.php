<?php defined('BASEPATH') OR exit('No direct script access allowed');

/* File: registration_model.php
 * Author: Luis Garnica
 * View Dependant: register
 * Description: Used for autohint inputs on the user registration form
 *              methods are called from controller through ajax. Discipline and
 *              Organization tables.
 *  */

class Registration_model extends CI_Model{
    
    function get_discipline($q){
    $this->db->select('Dname');
    $this->db->like('Dname', $q);
    $query = $this->db->get('DISCIPLINE');
    if($query->num_rows > 0){
      foreach ($query->result_array() as $row){
        $row_set[] = htmlentities(stripslashes($row['Dname'])); //build an array
      }
      echo json_encode($row_set); //format the array into json data
    }
  }
  
   function get_organization($q){
    $this->db->select('Oname');
    $this->db->like('Oname', $q);
    $query = $this->db->get('ORGANIZATION');
    if($query->num_rows > 0){
      foreach ($query->result_array() as $row){
        $row_set[] = htmlentities(stripslashes($row['Oname'])); //build an array
      }
      echo json_encode($row_set); //format the array into json data
    }
    
  } 
 
  
}

?>

