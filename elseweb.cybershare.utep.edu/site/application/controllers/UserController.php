<?php

class UserController extends CI_Controller{
    
    public function index(){
        $this->load->model('UserModel');
        $data['records'] = $this->UserModel->getdata();
        $this->load->view('UserView', $data);
        
    }
    
}


?>

