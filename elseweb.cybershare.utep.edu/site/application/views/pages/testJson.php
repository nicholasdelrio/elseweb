
<div class="container">
    <div class="row">
        <div class="text-center feature-head">
            <h3>Experiment Endpoint Service</h3>
        </div>        
    </div>
    
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <form role="form" method="post" onsubmit="return false;">
           <div class="form-group">
             <label for="jsonInput">Experiment JSON</label> <br/>
             <textarea id="experiment" name="experiment"  rows="20" cols="92" style="background-color: #ffffff"></textarea>
           </div>
                <button type="button" class="btn btn-default pull-right" 
                   onclick="storeExperiment('<?php echo site_url('storeExperiment')?>')">
               Submit
           </button>
         </form>
        </div>
  </div>
</div>
