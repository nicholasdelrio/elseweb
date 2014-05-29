<div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    
                    <a class="navbar-brand" href="index.html">ELSE<span>Web</span></a>
                </div>
                <div class="navbar-collapse collapse ">
                    <ul class="nav navbar-nav">
                        <li class="<?php echo isActive($pageName,"home")?>"><a href="<?php echo site_url('home') ?>">Home</a></li>
                        <li class="<?php echo isActive($pageName,"experiments")?>"><a href="<?php echo site_url('experiments') ?>">Experiments</a></li>
                        <li class="<?php echo isActive($pageName,"ontologies")?>"><a href="<?php echo site_url('ontologies') ?>">Ontologies</a></li>
                        <li class="<?php echo isActive($pageName,"services")?>"><a href="<?php echo site_url('services') ?>">Services</a></li>
                        <li class="<?php echo isActive($pageName,"team")?>"><a href="<?php echo site_url('team') ?>">Team</a></li>          
                        <li class="<?php echo isActive($pageName,"publications")?>"><a href="<?php echo site_url('publications') ?>">Publications</a></li>

                       <?php if(!$this->session->userdata('is_logged_in')) { ?>
                        <li class="dropdown <?php echo isActive($pageName,"login/new_user")?>" id="menuLogin">
                          <a class="dropdown-toggle" href="#" data-toggle="dropdown" id="navLogin">Login</a>
                          <div class="dropdown-menu pull-right" style="padding:10px;">
                            <form  class="form-inline" role="form" method="post" id="loginForm" name="loginForm" action="">
                             <fieldset>
                             <div class="form-group">
                                <input type="text" placeholder="Username" style="margin-top: 8px" size="20" id="username" name="username"/>
                             </div>
                             <div class="form-group">
                                 <input type="password" placeholder="Password"  style="margin-top: 8px" size="20" id="password" name="password"/><br/>
                             </div>
                             </fieldset>
                            </form>
                              <hr/>
                              <input type="button" value="Forgot Username or Password?"  class="btn-small btn-default"/>
                              <input type="button" value="Login"  class="btn-small btn-default pull-right" onclick="userLogin('<?php echo site_url('login')?>')"/>
                              <input type="button" style="margin-right: 10px;" value="Register"  class="btn-small btn-default pull-right"/>
                          </div>
                        </li>
                       <?php } else {?>
                       <li class="<?php echo isActive($pageName,"login")?>"><a href="<?php echo site_url('login/logout_ci') ?>">Logout</a></li>
                        
                       <?php } ?> 
                        
                        <!--
                        <li class="<?php echo isActive($pageName,"contacts")?>"><a href="<?php echo site_url('contacts') ?>">Contacts</a></li>
                       
                        <li class="<?php echo isActive($pageName,"login")?>"><a href="<?php echo site_url('dashboard/login') ?>">Login</a></li>
                        <li><input type="text" placeholder=" Search" class="form-control search"></li>-->
                    </ul>
                </div>
            </div>
