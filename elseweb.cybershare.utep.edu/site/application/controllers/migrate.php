<?php defined('BASEPATH') OR exit('No direct script access allowed');

class Migrate extends CI_Controller{
    
   public function index(){ 
       $this->load->library('migration');
       if(ENVIRONMENT == 'development'){
            if ( ! $this->migration->current()){
                show_error($this->migration->error_string());  
            } 
            else{
                echo "Migration Success";
            }
       }
       else{
           echo "Migrations only run on development environment";
       }
       
   }

}

?>

