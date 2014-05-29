<?php  defined('BASEPATH') OR exit('No direct script access allowed');

class LoginModel extends CI_Model {
    
    public function __construct() {
        parent::__construct();
    }
    
    public function login_user($username,$password)
    {
        $this->db->where('Uusername',$username);
        $this->db->where('Upassword',$password);
        $query = $this->db->get('USER');
        if($query->num_rows() == 1)
        {
            return $query->row();
        }else{
            $this->session->set_flashdata('incorrect_user','Invalid user/password combination');
            echo "Invalid user/password combination";
        }
    }
}
?>
