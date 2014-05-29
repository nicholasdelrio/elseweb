<?php defined('BASEPATH') OR exit('No direct script access allowed');

class Login extends CI_Controller
{
    public function __construct()
    {
        parent::__construct();
		$this->load->model('LoginModel');
		$this->load->library(array('session','form_validation'));
		$this->load->helper(array('url','form'));
		$this->load->database('default');
    }
	
    public function new_user(){
            $this->form_validation->set_rules('username', 'user name', 'required|trim|min_length[2]|max_length[150]|xss_clean');
            $this->form_validation->set_rules('password', 'password', 'required|trim|min_length[5]|max_length[150]|xss_clean');
 
            //throw error messages if we have any
            if($this->form_validation->run() == FALSE){
                echo "Incorrect Inputs";
	    }
            else{
                $username = $this->input->post('username');
		$password = sha1($this->input->post('password'));
		$check_user = $this->LoginModel->login_user($username,$password);
		if($check_user == TRUE){
                    $data = array(
                        'is_logged_in' 	=> TRUE,
	                'level' => 'subscriber',
	                'username' => $check_user->Uusername);		
			$this->session->set_userdata($data);
                        echo "success";
		}
	     }
		
    }
    
        public function token(){
            $token = md5(uniqid(rand(),true));
            $this->session->set_userdata('token',$token);
            return $token;
	}
	
	
	public function logout_ci(){
            $this->session->sess_destroy();
            //$this->index();
            $url = site_url();
            header('Location: '.$url);
	}
        
}

?>