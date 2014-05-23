<?php defined('BASEPATH') OR exit('No direct script access allowed');

class RollbackMigration extends CI_Controller{
    
   public function index(){ 
       $this->load->library('migration');
       if(ENVIRONMENT == 'development'){
            if ( ! $this->migration->version(0)){
                show_error($this->migration->error_string());  
            } 
            else{
                echo "Rollback Success";
            }
       }
       else{
           echo "Migrations only run on development environment";
       }
       
   }

}

?>
