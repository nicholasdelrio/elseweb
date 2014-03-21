<!--main content start-->
<section id="main-content">
  <section class="wrapper site-min-height">
    <!-- page start-->
    <div class="row">
      <div class="col-lg-12">
        <section class="panel">
          <header class="panel-heading">
            Create New Data Management Plan
          </header>
          <div class="panel-body">
            <div class="stepy-tab">
              <ul id="default-titles" class="stepy-titles clearfix">
                <li id="info" class="current-step">
                  <div>one</div>
                </li>
                <li id="people" class="">
                  <div>two</div>
                </li>
                <li id="data" class="">
                  <div>three</div>
                </li>
                <li id="poli" class="">
                  <div>three</div>
                </li>
                <li id="storage" class="">
                  <div>three</div>
                </li>
                <li id="summary" class="">
                  <div>three</div>
                </li>
              </ul>
            </div>
            <form class="form-horizontal" id="default">
              <fieldset title="Info" class="step" id="info">
                <legend> </legend>
                <div class="form-group">
                  <label class="col-lg-2 control-label">Project Name</label>
                  <div class="col-lg-10">
                    <input type="text" class="form-control" placeholder="Project Name">
                    <span class="help-block">Enter Project Name</span>
                  </div>
                </div>
                <div class="form-group">
                  <label class="control-label col-lg-2">Start Date</label>
                  <div class="col-lg-10">
                   <input class="form-control form-control-inline input-medium default-date-picker" placeholder="Select Date"  size="16" type="text" value="" />
                   <span class="help-block">Select Start Date of Project</span>
                 </div>
               </div>
               <div class="form-group">
                <label class="control-label col-lg-2">End Date</label>
                <div class="col-lg-10">
                 <input class="form-control form-control-inline input-medium default-date-picker" placeholder="Select Date"  size="16" type="text" value="" />
                 <span class="help-block">Select End Date of Project</span>
               </div>
             </div>
             <div class="form-group">
              <label class="col-lg-2 control-label">Description</label>
              <div class="col-lg-10">
                <textarea class="form-control" cols="60" rows="5"></textarea>
                <span class="help-block">Enter Description of Project</span>
              </div>
            </div>
            <div class="form-group">
              <label class="col-lg-2 control-label">URL</label>
              <div class="col-lg-10">
                <input type="text" class="form-control" placeholder="URL">
                <span class="help-block">URL to the project's website or where more information can be found</span>
              </div>
            </div>

          </fieldset>
          <fieldset title="People" class="step" id="people" >
            <legend> </legend>
            <div class="form-group">
              <label class="col-lg-2 control-label">Full Name</label>
              <div class="col-lg-10">
                <input type="text" class="form-control" placeholder="Full Name">
                <span class="help-block">Enter Full Name</span>
              </div>
            </div>
            <div class="form-group">
              <label class="col-lg-2 control-label">Email Address</label>
              <div class="col-lg-10">
                <input type="text" class="form-control" placeholder="Email Address">
                <span class="help-block">Enter Email Address</span>
              </div>
            </div>

            <div class="form-group">
              <label class="col-lg-2 control-label">Role</label>
              <div class="col-lg-10">
                <div class="checkboxes">
                  <label class="label_check" for="checkbox-01">
                    <input name="sample-checkbox-01" id="checkbox-01" value="1" type="checkbox"  /> PI
                  </label>
                  <label class="label_check" for="checkbox-01">
                    <input name="sample-checkbox-01" id="checkbox-01" value="1" type="checkbox" /> Co-PI
                  </label>
                  <label class="label_check" for="checkbox-01">
                    <input name="sample-checkbox-01" id="checkbox-01" value="1" type="checkbox"  /> Data Manager
                  </label>
                  <label class="label_check" for="checkbox-01">
                    <input name="sample-checkbox-01" id="checkbox-01" value="1" type="checkbox"  /> Other
                  </label>
                </div>
              </div>
            </div>

            <div class="form-group">
              <label class="col-lg-2 control-label">Permissions</label>
              <div class="col-lg-10">
                <div class="radios">
                  <label class="label_radio" for="radio-01">
                    <input name="sample-radio" id="radio-01" value="1" type="radio" checked /> Owner
                  </label>
                  <label class="label_radio" for="radio-02">
                    <input name="sample-radio" id="radio-02" value="1" type="radio" /> Writer
                  </label>
                  <label class="label_radio" for="radio-03">
                    <input name="sample-radio" id="radio-03" value="1" type="radio" /> Reader
                  </label>
                </div>
              </div>
            </div>
            
                <div class="form-group">
                  <label class="col-lg-2 control-label"></label>
                  <div class="col-lg-10">
                  <button type="button" class="btn btn-shadow btn-sm btn-success">Add Person</button>
                </div>

                </div>

              </fieldset>
              <fieldset title="Data" class="step" id="data" >
                <legend> </legend>
                <div class="form-group">
                  <label class="col-lg-2 control-label">Phone</label>
                  <div class="col-lg-10">
                    <input type="text" class="form-control" placeholder="Phone">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-lg-2 control-label">Mobile</label>
                  <div class="col-lg-10">
                    <input type="text" class="form-control" placeholder="Mobile">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-lg-2 control-label">Address</label>
                  <div class="col-lg-10">
                    <textarea class="form-control" cols="60" rows="5"></textarea>
                  </div>
                </div>

              </fieldset>
              <fieldset title="Policies" class="step" id="poli" >
                <legend> </legend>
                <div class="form-group">
                  <label class="col-lg-2 control-label">Phone</label>
                  <div class="col-lg-10">
                    <input type="text" class="form-control" placeholder="Phone">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-lg-2 control-label">Mobile</label>
                  <div class="col-lg-10">
                    <input type="text" class="form-control" placeholder="Mobile">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-lg-2 control-label">Address</label>
                  <div class="col-lg-10">
                    <textarea class="form-control" cols="60" rows="5"></textarea>
                  </div>
                </div>

              </fieldset>
              <fieldset title="Storage" class="step" id="storage" >
                <legend> </legend>
                <div class="form-group">
                  <label class="col-lg-2 control-label">Phone</label>
                  <div class="col-lg-10">
                    <input type="text" class="form-control" placeholder="Phone">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-lg-2 control-label">Mobile</label>
                  <div class="col-lg-10">
                    <input type="text" class="form-control" placeholder="Mobile">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-lg-2 control-label">Address</label>
                  <div class="col-lg-10">
                    <textarea class="form-control" cols="60" rows="5"></textarea>
                  </div>
                </div>

              </fieldset>
              <fieldset title="Summary" class="step" id="summary" >
                <legend> </legend>
                <div class="form-group">
                  <label class="col-lg-2 control-label">Full Name</label>
                  <div class="col-lg-10">
                    <p class="form-control-static">Tawseef Ahmed</p>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-lg-2 control-label">Email Address</label>
                  <div class="col-lg-10">
                    <p class="form-control-static">tawseef@vectorlab.com</p>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-lg-2 control-label">User Name</label>
                  <div class="col-lg-10">
                    <p class="form-control-static">tawseef</p>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-lg-2 control-label">Phone</label>
                  <div class="col-lg-10">
                    <p class="form-control-static">01234567</p>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-lg-2 control-label">Mobile</label>
                  <div class="col-lg-10">
                    <p class="form-control-static">01234567</p>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-lg-2 control-label">Address</label>
                  <div class="col-lg-10">
                    <p class="form-control-static">
                      Dreamland Ave, Suite 73
                      AU, PC 1361
                      P: (123) 456-7891 </p>
                    </div>
                  </div>
                </fieldset>
                <input type="submit" class="finish btn btn-danger" value="Finish"/>
              </form>
            </div>
          </section>
        </div>
      </div>
      <!-- page end-->
    </section>
  </section>
  <!--main content end-->

