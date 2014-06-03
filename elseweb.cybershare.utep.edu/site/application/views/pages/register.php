<script type="text/javascript">
  var disc_url = '<?php echo site_url('register/get_discipline'); ?>';    
  var org_url = '<?php echo site_url('register/get_organization'); ?>'; 
</script>


<!--container start-->
 <div class="container register">
    <div class="row">
        <div class="text-center feature-head">
            <h3>ELSEWeb Registration</h3>
        </div>        
    </div>
     
    <!-- Row start -->
    <div class="row">
      <div class="col-md-8  col-md-offset-2 col-sm-6 col-xs-8">
        <div class="panel panel-default">
          <div class="panel-heading clearfix">
            <h3 class="panel-title">User Registration</h3>
          </div>

          <div class="panel-body">
            <form class="form-horizontal row-border" method="post"
                  id="registerForm" name="registerForm">
              <div class="form-group">
                <label class="col-md-2 control-label">Username</label>
                <div class="col-md-10">
                  <input type="text" name="reg_username" id="reg_username" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-md-2 control-label">Email</label>
                <div class="col-md-10">
                  <input class="form-control" name="email" id="email" type="text">
                </div>
              </div>
              <div class="form-group">
                <label class="col-md-2 control-label">Discipline</label>
                <div class="col-md-10">
                    <input class="form-control" name="disc" id="disc" type="text">
                </div>
              </div>
              <div class="form-group">
                <label class="col-md-2 control-label">Organization</label>
                <div class="col-md-10">
                    <input class="form-control" name="org" id="org" type="text">
                </div>
              </div>
              <div class="form-group">
                <label class="col-md-2 control-label">Password</label>
                <div class="col-md-10">
                  <input class="form-control" type="password" name="reg_password" id="reg_password">
                </div>
              </div>
              <div class="form-group">
                <label class="col-md-2 control-label">Confirm Password</label>
                <div class="col-md-10">
                  <input class="form-control" type="password" name="pass_confirm" id="pass_confirm">
                </div>
              </div>
              <div class="form-group">
                <div class="col-md-12">
                  <input class="btn btn-lg btn-default pull-right" type="button" value="Submit"
                         onclick="userRegister('<?php echo site_url('login')?>')">
                </div>
              </div>
              
              <!--  
              <div class="form-group has-error">
                <label class="col-md-2 control-label">Input error</label>
                <div class="col-md-10">
                  <input type="text" class="form-control" id="inputError" placeholder="Input Error">
                  <i class="icon-pencil input-icon error"></i>
                </div>
              </div>
              -->
            </form>
          </div>
        </div>
      </div>
    </div>
    <!-- Row end -->         
     
</div>  



