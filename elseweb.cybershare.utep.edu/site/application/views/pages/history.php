
<!-- Javascript dependencies -->
<script type="text/javascript" src="<?php echo base_url(JS."history.js");?>"></script>

<div class="container">
    
    <div class="row">
        <div class="text-center feature-head">
            <h3>Experiment History</h3>
        </div>
    </div>
    
    <div class="row">
        <div class="col-md-12">
            <table class="table table-striped"
                <thead>
                    <tr>
                       <th>Experiment ID</th>   
                       <th>Timestamp</th>   
                       <th style='text-align:center;'>Success</th>
                       <th>Result URL</th>
                       <th style='text-align:center;'>Details</th>
                    </tr>
                </thead>
                <tbody>
                    <?php
                      foreach($experiment as $row){
                         echo "<tr>";
                         echo "<td>".$row['Eid']."</td>";
                         echo "<td>".$row['Etimestamp']."</td>";
                         echo "<td style='text-align:center;'>".$row['Estatus']."</td>";
                         echo "<td><a href='".$row['EresultURL']."'>".$row['EresultURL']."</a></td>";
                         echo "<td style='text-align:center;'><button type='button' class='btn btn-purchase btn-xs'><span class='glyphicon glyphicon-align-justify'></span></button></td>";
                         echo "</tr>";
                      }
                    ?>
                </tbody>
            </table>
        </div>
    </div>    
         
         
    
        
    <!--   Uncomment for Testing purposes
    <?php        
    foreach($experiment as $item)
      {
         var_dump($item);
     }   
    ?> -->

</div>
