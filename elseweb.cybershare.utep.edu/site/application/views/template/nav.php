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

                        <li class="dropdown" id="menuLogin">
                          <a class="dropdown-toggle" href="#" data-toggle="dropdown" id="navLogin">Login</a>
                          <div class="dropdown-menu" style="padding:17px;">
                            <?php echo form_open('login/new_user'); ?>
                             <label for="username">Username:</label>
                             <input type="text" size="20" id="username" name="username"/><br/>
                             <label for="password">Password:</label>
                             <input type="password" size="20" id="password" name="password"/><br/>
                             <input type="submit" value="Login"/>
                            </form>
                            <?php 
                                if($this->session->flashdata('incorrect_user'))
                            {
                            ?>
                            <script type="text/javascript">
                              alert("incorrect user password combination");
                            </script>
                            <?php
                            }
                            ?>
                          </div>
                        </li>

                        
                        <!--
                        <li class="<?php echo isActive($pageName,"contacts")?>"><a href="<?php echo site_url('contacts') ?>">Contacts</a></li>
                       
                        <li class="<?php echo isActive($pageName,"login")?>"><a href="<?php echo site_url('dashboard/login') ?>">Login</a></li>
                        <li><input type="text" placeholder=" Search" class="form-control search"></li>-->
                    </ul>
                </div>
            </div>
