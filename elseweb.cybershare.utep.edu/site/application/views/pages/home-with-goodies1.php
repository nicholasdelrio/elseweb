     <!-- revolution slider start -->
     <div class="fullwidthbanner-container main-slider">
         <div class="fullwidthabnner">
             <ul id="revolutionul" style="display:none;">
                 <!-- 1st slide -->
                 <li data-transition="fade" data-slotamount="8" data-masterspeed="700" data-delay="9400" data-thumb="">
                     
                     <div class="caption lfl slide_item_left"
                          data-x="10"
                          data-y="70"
                          data-speed="400"
                          data-start="1500"
                          data-easing="easeOutBack">
                          <img width="650" src="<?php echo base_url(IMAGES."banner/chihuahuan-desert-spread.png");?>" alt="Banner Background">
                     </div>
                     <div class="caption lfr slide_title white-txt"
                          data-x="870"
                          data-y="120"
                          data-speed="400"
                          data-start="1000"
                          data-easing="easeOutExpo">
                         Investigation
                     </div>
                     <div class="caption lfr slide_desc"
                          data-x="870"
                          data-y="260"
                          data-speed="400"
                          data-start="2500"
                          data-easing="easeOutExpo">
                         Easily generate projection models<br>
                         which may uncover factors leading<br>
                         to the decline or proliferation of<br>
                         certain species.
                     </div>
                 </li>

                 <!-- 2nd slide  -->
                 <li data-transition="fade" data-slotamount="7" data-masterspeed="300" data-delay="9400" data-thumb="">
                     
                     <!--<img src="<?php echo base_url(IMAGES."banner/red-bg.jpg");?>" alt="text img">-->
                     <div class="caption lfl slide_item_right"
                          data-x="10"
                          data-y="105"
                          data-speed="1200"
                          data-start="1500"
                          data-easing="easeOutBack">
                         
                         <img width="810" src="<?php echo base_url(IMAGES."banner/lifemapper-result.png");?>" id="rev-hint1" alt="text img">
                     </div>
                     

                     <div class="caption lfr slide_title slide_item_left white-txt"
                          data-x="870"
                          data-y="145"
                          data-speed="400"
                          data-start="3500"
                          data-easing="easeOutExpo">
                         Modeling Support
                     </div>
                     <div class="caption lfr slide_subtitle slide_item_left "
                          data-x="870"
                          data-y="200"
                          data-speed="400"
                          data-start="4000"
                          data-easing="easeOutExpo">
                         Lifemapper
                     </div>
                     <div class="caption lfr slide_desc slide_item_left"
                          data-x="870"
                          data-y="280"
                          data-speed="400"
                          data-start="4500"
                          data-easing="easeOutExpo">
                          Models are generating using<br>
                          the vast infrastructure supported<br>
                          by <a href="http://lifemapper.org">Lifemapper</a>.
                     </div>


                 </li>

                 <!-- 3rd slide  -->
                 <li data-transition="fade" data-slotamount="8" data-masterspeed="700" data-delay="9400" data-thumb="">
                     <!-- THE MAIN IMAGE IN THE FIRST SLIDE -->
                     <!--
                     <img src="<?php echo base_url(IMAGES."banner/banner_bg.jpg");?>" alt="Banner Background">-->
                     
                     <div class="caption lft slide_title white-txt"
                          data-x="10"
                          data-y="60"
                          data-speed="400"
                          data-start="1500"
                          data-easing="easeOutExpo">
                          A Massive Collection of Scenario Data
                     </div>
                     <div class="caption lft slide_subtitle"
                          data-x="10"
                          data-y="180"
                          data-speed="400"
                          data-start="2000"
                          data-easing="easeOutExpo">
                          Earth Data Analysis Center
                     </div>
                     <div class="caption lft slide_desc"
                          data-x="10"
                          data-y="240"
                          data-speed="400"
                          data-start="2500"
                          data-easing="easeOutExpo">
                          Generate future species projection models</br>
                          from thousands of environmental data sets<br>
                          hosted at the <a href="http://edac.unm.edu/">Earth Data Analysis Center</a>.
                     </div>
                     <div class="caption lft start"
                          data-x="490"
                          data-y="55"
                          data-speed="400"
                          data-start="2000"
                          data-easing="easeOutBack"  >
                          <img width="770" src="<?php echo base_url(IMAGES."banner/edac-data.png");?>" alt="Man">
                         
                     </div>
                 </li>
             </ul>
            <div class="tp-bannertimer tp-top"></div>
         </div>
     </div>
     <!-- revolution slider end -->

    <!--container start-->
    <div class="container">
        <div class="row">
            <!--feature start-->
            <div class="text-center feature-head">
                <h1>Welcome to ELSEWeb</h1>
                <p>Earth, Life, and Semantic Web</p>
            </div>
            
            <p>The Earth, Life and Semantic Web (ELSeWeb) project integrates the NASA-funded <a href="http://edac.unm.edu">Earth Data Analysis Center</a> with an analytical Web Service platform, <a href="http://lifemapper.org">Lifemapper</a>, which models potential future species distributions under scenarios of climate change. The integrated system provides climate change impact scientists streamlined mechanisms for discovering, accessing, understanding, and using Earth observation data to model future species projection scenarios.</p>

            <!--feature end-->
        </div>
        
    </div>


    <!--property start-->
    <div class="property gray-bg">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-sm-6 text-center">
                  
                    <img width="400" src="<?php echo base_url(IMAGES."elseweb-gui.png");?>" alt="text img">
                </div>
                <div class="col-lg-6 col-sm-6">
                    <h1>Running ELSEWeb Experiments</h1>
                    <p>You can interact with a user interface that lets you specify an ELSEWeb experiment by allowing the selection of: <a href="<?php echo LODSPEAKR."instances/elseweb_lifemapper:SpeciesOccurrenceDataset";?>">species occurrence data</a>, <a href="<?php echo LODSPEAKR."instances/elseweb_edac:PublishedPRISMDataset";?>">environmental scenario data</a>, and <a href="<?php echo LODSPEAKR."instances/elseweb_lifemapper:LifemapperAlgorithm";?>">modeling algorithms</a>.</p>
                    <a href="javascript:;" class="btn btn-purchase">Start Running Experiments</a>
                </div>
            </div>
        </div>
    </div>
    <!--property end-->

     <div class="container">
         <!--clients start-->
         <div class="clients">
             <div class="container">
                 <div class="row">
                     <div class="col-lg-12 text-center">
                         <ul class="list-unstyled">
                          <li><a href="http://www.nasa.gov/"><img width="100" src="<?php echo base_url(IMAGES."resources/meatball-logo.jpg");?>" alt="text img"></a></li>
                          <li><a href="http://cybershare.utep.edu/"><img width="100" src="<?php echo base_url(IMAGES."resources/cybershare-logo.jpg");?>" alt="text img"></a></li>
                          <li><a href="http://sadiframework.org/"><img width="100" src="<?php echo base_url(IMAGES."resources/sadi-logo.png");?>" alt="text img"></a></li>
                          <li><a href="http://lodspeakr.org/"><img width="100" src="<?php echo base_url(IMAGES."resources/lodspeakr-logo.png");?>" alt="text img"></a></li>
                         </ul>
                     </div>
                 </div>
             </div>
         </div>
         <!--clients end-->
     </div>

     <!--container end-->