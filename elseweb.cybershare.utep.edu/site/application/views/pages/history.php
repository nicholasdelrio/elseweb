
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
                       <th>Provinence ID</th>
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
                         echo "<td><a href='".$row['EresultURL']."'>Result URL</a></td>";
                         echo "<td><a href='".$row['EprovinenceID']."'>Provinence URI</a></td>";
                    ?>
                         <td style='text-align:center;'><button type='button' class='btn btn-purchase btn-xs' onClick='experimentDetails("history", "<?php echo $row['Eid']?>")'><span class='glyphicon glyphicon-align-justify'></span></button></td>
                    <?php
                         echo "</tr>";
                      }
                    ?>
                </tbody>
            </table>
        </div>
    </div> 
    
    <!-- Modal -->
   <div class="modal fade" id="modalDetails" tabindex="-1" role="dialog" aria-labelledby="Experiment Details" aria-hidden="true">
     <div class="modal-dialog">
       <div class="modal-content">
         <div class="modal-header">
           <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
           <h4 class="modal-title" id="myModalLabel">Experiment Details</h4>
         </div>
         <div class="modal-body" id="expDetails">
           Experiment content here
         </div>
         <div class="modal-footer">
           <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
         </div>
       </div>
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
