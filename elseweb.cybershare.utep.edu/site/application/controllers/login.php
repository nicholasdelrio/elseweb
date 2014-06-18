<?php defined('BASEPATH') OR exit('No direct script access allowed');

/* File: login.php (controller)
 * Author: Luis Garnica
 * View Dependant: login, register
 * Description: Validates and handles user login and registration.
 *  */

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

   /*
    * Function: new_user
    * Description: Validates and sanitizes input from the login form.
    *              With a correct user/password combination a session variable is set
    *              containing a log in flag, username and priviledge level.
    * Note: Priviledge level is currently hadcoded.
    * */     
    
    public function new_user(){
            $this->form_validation->set_rules('username', 'user name', 'required|trim|min_length[2]|max_length[150]|xss_clean');
            $this->form_validation->set_rules('password', 'password', 'required|trim|min_length[5]|max_length[150]|xss_clean');
 
            //throw error messages if we have any
            if($this->form_validation->run() == FALSE){
                echo validation_errors();
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
    
   /*
    * Function: register
    * Description: Validates user registration form and inserts the new user into the database.
    * */   
    
    public function register(){
        $this->form_validation->set_rules('username', 'User Name', 'required|trim|min_length[2]|max_length[20]|xss_clean');
        $this->form_validation->set_rules('password', 'Password', 'required|trim|min_length[5]|max_length[20]|xss_clean');
        $this->form_validation->set_rules('pass_confirm', 'Password Confirmation', 'required|trim|min_length[5]|max_length[20]|xss_clean');
        $this->form_validation->set_rules('email', 'Email', 'required|trim|valid_email|is_unique[USER.Uemail]|xss_clean');   
        $this->form_validation->set_rules('disc', 'Discipline', 'required|trim|max_length[50]|min_length[2]|xss_clean'); 
        $this->form_validation->set_rules('org', 'Organization', 'required|trim|max_length[100]|min_length[2]|xss_clean'); 
        
        $this->form_validation->set_message('is_unique', 'Email already used on previous registration.');
        
        //throw error messages if we have any
        if($this->form_validation->run() == FALSE){
                echo validation_errors();
        }
        else{
           $password = sha1($this->input->post('password')); //encrypted password in db
           $pass_confirm = sha1($this->input->post('pass_confirm'));  //encrypted password in db
           if ($password == $pass_confirm){
                $username = $this->input->post('username');
                $email = $this->input->post('email');
                $discipline = $this->input->post('disc');
                $organization = $this->input->post('org');
                $add_user = $this->LoginModel->add_user($username,$password, $email, $discipline, $organization);
                if ($add_user == TRUE){
                   echo "success";
                }
                else{
                   echo "Error occured";
                }
           }
           else {
               echo "Passwords do not match";
           }
        }
        
    }
    
   /*
    * Function: token
    * Description: Manual form token to prevent cross site login.
    * Note: Not currently in use.
    * */   
    
     public function token(){
            $token = md5(uniqid(rand(),true));
            $this->session->set_userdata('token',$token);
            return $token;
     }

   /*
    * Function: logout_ci
    * Description: Destroys all session variables and resets to home page.
    * */   
	
    public function logout_ci(){
            $this->session->sess_destroy();
            $url = site_url();
            header('Location: '.$url);
     }
        
}

?>