
<div class="container">
  <div class="row">
    <div class="col-md-9">
        <form role="form" method="post" onsubmit="return false;">
       <div class="form-group">
         <label for="jsonInput">Json Test</label> <br/>
         <textarea id="experiment" name="experiment"  rows="20" cols="105"></textarea>
       </div>
       <button type="button" class="btn btn-default pull-right" onclick="storeExperiment('<?php echo site_url('storeExperiment')?>')">
           Submit
       </button>
     </form>
    </div>
  </div>
</div>
