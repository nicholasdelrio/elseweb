<?php defined('BASEPATH') OR exit('No direct script access allowed');

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class Migration_Initial_schema extends CI_Migration{
    
    public function up(){
        echo "Creating table 'DISCIPLINE'...";
        
        $fields = array (
            'Did' => array (
                'type' => 'INT',
                'constraint' => 11,
                'auto_increment' => TRUE,
            ),
            'Dname' => array (
                'type' => 'VARCHAR',
                'constraint' => '50',
            ));
        
        $this->dbforge->add_field($fields);
        $this->dbforge->add_key('Did', TRUE);
        $this->dbforge->create_table('DISCIPLINE');   
        
        //Initial Data
        $data = array(
            'Dname' => 'Computer Science'
        );
        
        $this->db->insert('DISCIPLINE', $data);
        
        echo "DONE <br/>";
        
        /**********************************************************************/
        
        echo "Creating table 'ORGANIZATION'...";
        $fields = array(
            'Oid' => array (
                'type' => 'INT',
                'constraint' => 11,
                'auto_increment' => TRUE
            ),
            'Oname' => array (
                'type' => 'VARCHAR',
                'constraint' => '100'
        ));
        
        $this->dbforge->add_field($fields);
        $this->dbforge->add_key('Oid', TRUE);
        $this->dbforge->create_table('ORGANIZATION');   
        
        //Initial Data
        $data = array(
            'Oname' => 'University of Texas at El Paso'
        );
        
        $this->db->insert('ORGANIZATION', $data);
        echo "DONE<br/>";
        
        
        /********************************************************************/
        
        echo "Creating table 'USER'...";
        $fields = array(
            'Uusername' => array (
                'type' => 'VARCHAR',
                'constraint' => '20'
            ),
            'Did_FK' => array (
                'type' => 'INT',
                'constraint' => 11,
            ),
            'Oid_FK' => array (
                'type' => 'INT',
                'constraint' => 11,
            ),  
            'Upassword' => array (
                'type' => 'VARCHAR',
                'constraint' => '100',
            ),
            'Uemail' => array (
                'type' => 'VARCHAR',
                'constraint' => '100',
            ),
            'Ureg_date' => array (
                'type' => 'TIMESTAMP'
            ),
            
        );        

        $this->dbforge->add_field($fields);
        $this->dbforge->add_key('Uusername', TRUE);
        $this->dbforge->create_table('USER');  
        
        //Hardcoded foreign keys
        $this->db->query('ALTER TABLE USER ADD FOREIGN KEY (Did_FK) REFERENCES DISCIPLINE (Did)');
        $this->db->query('ALTER TABLE USER ADD FOREIGN KEY (Oid_FK) REFERENCES ORGANIZATION (Oid)');
        $this->db->query('ALTER TABLE USER ADD UNIQUE INDEX (Uemail)');
        
        //Initial Data
        $data = array(
            'Uusername' => 'Admin',
            'Did_FK' => '1',
            'Oid_FK' => '1',
            'Upassword' => 'd033e22ae348aeb5660fc2140aec35850c4da997',
            'Uemail' => 'lagc03@gmail.com',
            'Ureg_date' => '2014-01-01'
        );        
        
        $this->db->insert('USER', $data);
        echo "DONE<br/>";
        
        /********************************************************************/
        
        echo "Creating table 'ALGORITHM'...";
        $fields = array(
          'Aid' => array(
              'type' => 'CHAR',
              'constraint' => '15'
          )  
        );
                
        $this->dbforge->add_field($fields);
        $this->dbforge->add_key('Aid', TRUE);
        $this->dbforge->create_table('ALGORITHM');  
        echo "DONE<br/>";
        
        /********************************************************************/
        
        echo "Creating table 'EXPERIMENT'";
        $fields = array (
            'Eid' => array(
                'type' => 'VARCHAR',
                'constraint' => '100'
            ),
            'Aid_FK' => array(
                'type' => 'CHAR',
                'constraint' => '15'
            ),
            'Uusername_FK'=> array(
                'type' => 'VARCHAR',
                'constraint' => '20'
            ),
            'Etimestamp' => array(
                'type'=> 'TIMESTAMP'
            ),
            'EresultURL' => array(
                'type' => 'VARCHAR',
                'null' => TRUE,
                'constraint' => '200'
            ),
            'Estatus' => array (
                'type' => 'VARCHAR',
                'constraint' => '45',
                'default' => 'PENDING'
            ),
            'EocurrenceDataID' => array(
                'type' => 'INT'
            ),
            'EexpectedResults' => array(
                'type' => 'TEXT'
            ),
            'Edescription' => array(
                'type' => 'TEXT'
            ),
            'EprovinenceID' => array (
                'type' => 'VARCHAR',
                'constraint' => '200',
                'null' => TRUE
            )
        );
        $this->dbforge->add_field($fields);
        $this->dbforge->add_key('Eid', TRUE);
        $this->dbforge->create_table('EXPERIMENT');
        
        //Hardcoded foreign keys
        $this->db->query('ALTER TABLE EXPERIMENT ADD FOREIGN KEY (Aid_FK) REFERENCES ALGORITHM (Aid)');
        $this->db->query('ALTER TABLE EXPERIMENT ADD FOREIGN KEY (Uusername_FK) REFERENCES USER (Uusername)');
        echo "DONE<br/>";
        
        /********************************************************************/
        echo "Creating table 'COMMENT'...";
        $fields = array(
            'Cid' => array(
                'type' => 'INT'
             ),
             'Uusername_FK' => array(
                 'type' => 'VARCHAR',
                 'constraint' => '20'
             ),
            'Ccomment' => array(
                'type' => 'VARCHAR',
                'constraint' => '300'
            ),
            'Ctimestamp' => array(
                'type' => 'TIMESTAMP',
            ));
           
        $this->dbforge->add_field($fields);
        $this->dbforge->add_key('Cid', TRUE);
        $this->dbforge->create_table('COMMENT'); 
        
        //hardcoded foreign keys
        $this->db->query('ALTER TABLE COMMENT ADD FOREIGN KEY (Uusername_FK) REFERENCES USER (Uusername)');
        echo "DONE<br/>";
        
        /********************************************************************/
        
        echo "Creating table 'ENVIRONMENT'...";
        $fields = array(
            'datasetURI' => array(
                'type' => 'VARCHAR',
                'constraint' => '100'
            )
        );
        
        $this->dbforge->add_field($fields);
        $this->dbforge->add_key('datasetURI', TRUE);
        $this->dbforge->create_table('ENVIRONMENT');  
   
        //hardcoded foreign keys
        echo "DONE<br/>";
        
        /********************************************************************/
        
        echo "Creating table 'EXPERIMENT_DATASETS'";
        $fields = array(
            'datasetURI_FK' => array(
                'type' => 'VARCHAR',
                'constraint' => '100'
            ),
            'Eid_FK' => array(
                'type' => 'VARCHAR',
                'constraint' => '100'
            )
            
        );
        
        $this->dbforge->add_field($fields);
        $this->dbforge->add_key('datasetURI_FK', TRUE);
        $this->dbforge->add_key('Eid_FK', TRUE);
        $this->dbforge->create_table('EXPERIMENT_DATASETS');  
   
        
        //hardcoded foreign keys
        $this->db->query('ALTER TABLE EXPERIMENT_DATASETS ADD FOREIGN KEY (datasetURI_FK) REFERENCES ENVIRONMENT (datasetURI)');
        $this->db->query('ALTER TABLE EXPERIMENT_DATASETS ADD FOREIGN KEY (Eid_FK) REFERENCES EXPERIMENT (Eid)');
        echo "DONE<br/>";
        
        /********************************************************************/
        
        echo "Creating table 'PARAMETER'...";
        $fields = array(
            'Pname' => array(
                'type' => 'VARCHAR',
                'constraint' => '50'
            ),
            'Aid_FK' => array(
                'type' => 'CHAR',
                'constraint' => '15'
            )
        );

        $this->dbforge->add_field($fields);
        $this->dbforge->add_key('Pname', TRUE);
        $this->dbforge->create_table('PARAMETER');  
    
        //hardcoded foreign keys
        $this->db->query('ALTER TABLE PARAMETER ADD FOREIGN KEY (Aid_FK) REFERENCES ALGORITHM (Aid)');
        echo "DONE<br/>";
        
       /********************************************************************/
          
       echo "Creating Table 'EXP_PARAMETERS'...";
       $fields = array(
           'Pname_FK' => array(
               'type' => 'VARCHAR',
               'constraint' => '50'
           ),
           'Eid_FK' => array(
               'type' => 'VARCHAR',
               'constraint' => '100'
           ),
           'Pvalue' =>  array(
               'type' => 'VARCHAR',
               'constraint' => '45'
           )               
       );
        
       $this->dbforge->add_field($fields);
       $this->dbforge->add_key('Pname_FK', TRUE);
       $this->dbforge->add_key('Eid_FK', TRUE);
       $this->dbforge->create_table('EXP_PARAMETERS');      
       
       //hardcoded foreign keys
       $this->db->query('ALTER TABLE EXP_PARAMETERS ADD FOREIGN KEY (Pname_FK) REFERENCES PARAMETER (Pname)');
       $this->db->query('ALTER TABLE EXP_PARAMETERS ADD FOREIGN KEY (Eid_FK) REFERENCES EXPERIMENT (Eid)');
       echo "DONE<br/>";
        
        
    }
    
    
    public function down(){
       $this->dbforge->drop_table('EXPERIMENT_DATASETS');
       $this->dbforge->drop_table('ENVIRONMENT');
       $this->dbforge->drop_table('COMMENT');
       $this->dbforge->drop_table('EXP_PARAMETERS');
       $this->dbforge->drop_table('PARAMETER');
       $this->dbforge->drop_table('EXPERIMENT');
       $this->dbforge->drop_table('ALGORITHM');
       $this->dbforge->drop_table('USER');
       $this->dbforge->drop_table('ORGANIZATION');
       $this->dbforge->drop_table('DISCIPLINE');   
    }   
    
}

?>
