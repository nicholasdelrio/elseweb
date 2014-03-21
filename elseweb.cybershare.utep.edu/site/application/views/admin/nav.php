 <!--sidebar start-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
                  <li>
                      <a class="<?php echo isActive($pageName,"dashboard")?>" href="<?php echo site_url('dashboard') ?>">
                          <i class="icon-dashboard"></i>
                          <span>Dashboard</span>
                      </a>
                  </li>
                 
                   <li>
                      <a class="<?php echo isActive($pageName,"create")?>" href="<?php echo site_url('dashboard/create') ?>">
                          <i class="icon-th"></i>
                          <span>Create Plan</span>
                      </a>
                      
                  </li>
                  <li >
                      <a class="<?php echo isActive($pageName,"view")?>" href="<?php echo site_url('dashboard/view') ?>">
                          <i class="icon-eye-open"></i>
                          <span>View Plans</span>
                      </a>
                      
                  </li>


                   <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="icon-cogs"></i>
                          <span>Manage Plans</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="grids.html">Grids</a></li>
                          <li><a  href="calendar.html">Calendar</a></li>
                          <li><a  href="gallery.html">Gallery</a></li>
                          <li><a  href="todo_list.html">Todo List</a></li>
                      </ul>
                  </li>
                 <li>
                      <a class="<?php echo isActive($pageName,"profile")?>" href="<?php echo site_url('profile') ?>">
                          <i class="icon-user"></i>
                          <span>Profile</span>
                      </a>
                  </li>
                  <li>
                      <a  href="<?php echo site_url('contacts') ?>">
                          <i class="icon-envelope"></i>
                          <span>Contact Us</span>
                          <span class="label label-danger pull-right mail-info">2</span>
                      </a>
                  </li>
              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>
      <!--sidebar end-->