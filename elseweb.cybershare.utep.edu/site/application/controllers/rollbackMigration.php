<?php defined('BASEPATH') OR exit('No direct script access allowed');

/* File: rollbackMigration.php (controller)
 * Author: Luis Garnica
 * View Dependant: none
 * Description: Rollback database to version set on version(param)
 *  */

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
