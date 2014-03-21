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
                        <li class="<?php echo isActive($pageName,"about")?>"><a href="<?php echo site_url('about') ?>">Experiments</a></li>
                        <li class="<?php echo isActive($pageName,"ontologies")?>"><a href="<?php echo site_url('ontologies') ?>">Ontologies</a></li>
                        <li class="<?php echo isActive($pageName,"about")?>"><a href="<?php echo site_url('about') ?>">Services</a></li>
                        <li class="<?php echo isActive($pageName,"about")?>"><a href="<?php echo site_url('about') ?>">Publications</a></li>

                        <!--
                        <li class="dropdown ">
                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false">Feature <b class=" icon-angle-down"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="typography.html">Typography</a></li>
                                <li><a href="button.html">Buttons</a></li>
                            </ul>
                        </li>
                        <li class="<?php echo isActive($pageName,"contacts")?>"><a href="<?php echo site_url('contacts') ?>">Contacts</a></li>
                       
                        <li class="<?php echo isActive($pageName,"login")?>"><a href="<?php echo site_url('dashboard/login') ?>">Login</a></li>
                        <li><input type="text" placeholder=" Search" class="form-control search"></li>-->
                    </ul>
                </div>
            </div>
