<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="img/favicon.png">
    <title><?php echo $title ?></title>
    

    <!-- Bootstrap core CSS -->
    <link href="<?php echo base_url(ADMIN."css/bootstrap.min.css");?>" rel="stylesheet">
    <link href="<?php echo base_url(ADMIN."css/bootstrap-reset.css");?>" rel="stylesheet">
    
    <!--external css-->
    <link href="<?php echo base_url(ADMIN."assets/font-awesome/css/font-awesome.css");?>" rel="stylesheet">
    <link href="<?php echo base_url(ADMIN."assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css");?>" rel="stylesheet" type="text/css" media="screen">
    <link href="<?php echo base_url(ADMIN."assets/bootstrap-datepicker/css/datepicker.css");?>" rel="stylesheet" type="text/css">

    
    <!-- Custom styles for this template -->
    <link href="<?php echo base_url(ADMIN."css/style.css");?>" rel="stylesheet">
    <link href="<?php echo base_url(ADMIN."css/style-responsive.css");?>" rel="stylesheet">

   

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

  <section id="container" >
	<?php echo $body ?>
	<!-- js placed at the end of the document so the pages load faster -->
    <script src="<?php echo base_url(ADMIN."js/jquery.js");?>"></script>
    <script src="<?php echo base_url(ADMIN."js/jquery-1.8.3.min.js");?>"></script>
    <script src="<?php echo base_url(ADMIN."js/bootstrap.min.js");?>"></script>
    <script class="include" type="text/javascript" src="<?php echo base_url(ADMIN."js/jquery.dcjqaccordion.2.7.js");?>"></script>  
    <script src="<?php echo base_url(ADMIN."js/jquery.scrollTo.min.js");?>"></script>
    <script src="<?php echo base_url(ADMIN."js/jquery.nicescroll.js");?>" type="text/javascript"></script>
    <script src="<?php echo base_url(ADMIN."js/jquery.sparkline.js");?>" type="text/javascript"></script>
    <script src="<?php echo base_url(ADMIN."assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js");?>"></script>
    <script src="<?php echo base_url(ADMIN."js/owl.carousel.js");?>"></script>
    <script src="<?php echo base_url(ADMIN."js/jquery.customSelect.min.js");?>"></script>
    <script src="<?php echo base_url(ADMIN."js/respond.min.js");?>"></script>
    <script class="include" type="text/javascript" src="<?php echo base_url(ADMIN."js/jquery.dcjqaccordion.2.7.js");?>"></script>
    <!--common script for all pages-->
    <script src="<?php echo base_url(ADMIN."js/common-scripts.js");?>"></script>

    <!--script for this page-->
    <script src="<?php echo base_url(ADMIN."js/sparkline-chart.js");?>"></script>
    <script src="<?php echo base_url(ADMIN."js/easy-pie-chart.js");?>"></script>  
    <script src="<?php echo base_url(ADMIN."js/count.js");?>"></script>

    <script src="<?php echo base_url(ADMIN."js/jquery.stepy.js");?>"></script>
      
    <script type="text/javascript" src="<?php echo base_url(ADMIN."assets/bootstrap-datepicker/js/bootstrap-datepicker.js");?>"></script>  
    
    <script src="<?php echo base_url(ADMIN."js/advanced-form-components.js");?>"></script>
    <!--custom checkbox & radio-->
  <script type="text/javascript" src="<?php echo base_url(ADMIN."js/ga.js");?>"></script>

  <script>

      //step wizard

      $(function() {
          $('#default').stepy({
              backLabel: 'Previous',
              block: true,
              nextLabel: 'Next',
              titleClick: true,
              titleTarget: '.stepy-tab'
          });
      });
  </script>
   
  <script>

      //owl carousel

      $(document).ready(function() {
          $("#owl-demo").owlCarousel({
              navigation : true,
              slideSpeed : 300,
              paginationSpeed : 400,
              singleItem : true,
        autoPlay:true

          });
      });

      //custom select box

      $(function(){
          $('select.styled').customSelect();
      });

  </script>

  </body>
</html>