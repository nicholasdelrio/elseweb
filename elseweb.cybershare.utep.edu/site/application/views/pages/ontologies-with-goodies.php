<!--breadcrumbs start-->
    <!--<div class="breadcrumbs">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-sm-4">
                    <h1>About us</h1>
                </div>
                <div class="col-lg-8 col-sm-8">
                    <ol class="breadcrumb pull-right">
                        <li><a href="#">Home</a></li>
                        <li><a href="#">Pages</a></li>
                        <li class="active">About</li>
                    </ol>
                </div>
            </div>
        </div>
    </div>-->
    <!--breadcrumbs end-->

    <!--container start-->
    <div class="container">
        <div class="row">
            <div class="col-lg-5">
                 <img width="470" src="<?php echo base_url(IMAGES."layered-ontologies.png");?>" alt="text img">
                <!--
                <div class="span5 about-carousel">
                    <div id="myCarousel" class="carousel slide">
                        <!-- Carousel items -->
                        <!--<div class="carousel-inner">
                            <div class="active item">
                                <img src="<?php echo base_url(IMAGES."about_1.jpg");?>" alt="image">
                                
                                <div class="carousel-caption">
                                    <p>Donec luctus ullamcorper nulla</p>
                                </div>
                            </div>
                            <div class="item">
                                <img src="<?php echo base_url(IMAGES."about_2.jpg");?>" alt="image">
                                <div class="carousel-caption">
                                    <p>Blanditiis praesentium voluptatum</p>
                                </div>
                            </div>
                            <div class="item">
                                <img src="<?php echo base_url(IMAGES."about_1.jpg");?>" alt="image">
                                <div class="carousel-caption">
                                    <p>Honest and amazing things that bring positive results</p>
                                </div>
                            </div>
                        </div>
                        <!-- Carousel nav -->
                        <!--
                        <a class="carousel-control left" href="#myCarousel" data-slide="prev">
                            <i class="icon-angle-left"></i>
                        </a>
                        <a class="carousel-control right" href="#myCarousel" data-slide="next">
                            <i class="icon-angle-right"></i>
                        </a>
                    </div>
                </div>-->
            </div>
            <div class="col-lg-7 about">
                <h3>A Multitier Ontology Driven Infrastructure</h3>
                <p>Although ELSEWeb currently enables the transference of EDAC data to Lifemapper, we ultimately want to connect with other data and model providers. To accommodate for these expansions, we have devised a multitier ontology driven infrastructure that allows third-party providers to align with our ontologies and therefore be incorporated with our system.</p>
                <p>The first tier of our ontology consists of prevalent Linked 0pen Data (LOD) ontologies that, in addition to providing a community driven structure to our data, allows other semantic applications to easily consume our RDF. The second tier expands on LOD ontologies and provides specific concepts for describing data provider sources and modeling services. The third tier is where the domain specific data and model providers would align with our generic ontologies, and provide classes and properties specific to their domain. Finally, the transformation tier provides a link between a specific data and model provider. SADI services leverage the transformation ontology to automatically transform source data into forms a specific modeling agent can process.</p>
            </div>
        </div>
        <div class="row">
            <div class="hiring">
                <div class="col-lg-6 col-sm-6">
                <!--
                    <div class="icon-wrap ico-bg round">
                        <i class="icon-desktop"></i>
                    </div> -->
                    <div class="content">
                        <h3 class="title">ELSEWeb Data</h3>
                        <p>The <a href="<?php echo ONTPREFIX."elseweb-data.owl";?>">elseweb-data ontology</a> provides concepts for describing the spatial/temporal dimensions of a dataset, how it can be accessed, and the specific nature of the data being contained.</p>
                        <a href="<?php echo ONTPREFIX."elseweb-data.owl";?>"><img width="470" src="<?php echo base_url(IMAGES."elseweb-data.png");?>" alt="text img"></a>
                    </div>
                </div>
                <div class="col-lg-6 col-sm-6">
                    <!-- <div class="icon-wrap ico-bg round">
                        <i class="icon-user"></i>
                    </div>-->
                    <div class="content">
                        <h3 class="title">ELSEWeb Model</h3>
                        <p>The <a href="<?php echo ONTPREFIX."elseweb-modelling.owl";?>">elseweb-modelling</a> ontology provides concepts for describing the generic algorithms and how they relate to parameter sets and software agents that implements the algorithm.</p>
                        <img width="470" src="<?php echo base_url(IMAGES."elseweb-modelling.png");?>" alt="text img">
                    </div>
                </div>
            </div>
        </div>
    </div>

     <div class="gray-box">
         <div class="container">
             <div class="row">
                 <div class="col-lg-5">
                     <!--testimonial start-->
                     <div class="about-testimonial boxed-style about-flexslider ">
                         <section class="slider">
                             <div class="flexslider">
                                 <ul class="slides about-flex-slides">
                                     <li>
                                         <div class="about-testimonial-image ">
                                            <img src="<?php echo base_url(IMAGES."testimonial-img-1.jpg");?>" alt="image">
                                             
                                         </div>
                                         <a class="about-testimonial-author" href="#">Omar Ochoa</a>
                                         <span class="about-testimonial-company">ABC Realestate LLC</span>
                                         <div class="about-testimonial-content">
                                             <p class="about-testimonial-quote">
                                                 Pellentesque et pulvinar enim. Quisque at tempor ligula. Maecenas augue ante, euismod vitae egestas sit amet, accumsan eu nulla. Nullam tempor lectus a ligula lobortis pretium. Donec ut purus sed tortor malesuada venenatis eget eget lorem.
                                             </p>
                                         </div>
                                     </li>
                                     <li>
                                         <div class="about-testimonial-image ">
                                             
                                             <img src="<?php echo base_url(IMAGES."avatar2.jpg");?>" alt="image">
                                         </div>
                                         <a class="about-testimonial-author" href="#">Nicholas Del Rio</a>
                                         <span class="about-testimonial-company">DEF LLC</span>
                                         <div class="about-testimonial-content">
                                             <p class="about-testimonial-quote">
                                                 Pellentesque et pulvinar enim. Quisque at tempor ligula. Maecenas augue ante, euismod vitae egestas sit amet, accumsan eu nulla. Nullam tempor lectus a ligula lobortis pretium. Donec ut purus sed tortor malesuada venenatis eget eget lorem.
                                             </p>
                                         </div>
                                     </li>
                                 </ul>
                             </div>
                         </section>
                     </div>
                     <!--testimonial end-->
                 </div>
                 <div class="col-lg-7">
                     <h3 class="skills">Support</h3>
                     <div class="about-skill-meter">
                         <div class="progress progress-xs">
                             <div style="width: 60%;" aria-valuemax="100" aria-valuemin="0" aria-valuenow="60" role="progressbar" class="progress-bar progress-bar-danger">
                                 <span class="sr-only">Web Design : 60% Complete</span>
                             </div>
                         </div>
                     </div>
                     <div class="about-skill-meter">
                         <div class="progress progress-xs">
                             <div style="width: 90%;" aria-valuemax="100" aria-valuemin="0" aria-valuenow="60" role="progressbar" class="progress-bar progress-bar-danger">
                                 <span class="sr-only">Html/CSS : 90% Complete</span>
                             </div>
                         </div>
                     </div>
                     <div class="about-skill-meter">
                         <div class="progress progress-xs">
                             <div style="width: 70%;" aria-valuemax="100" aria-valuemin="0" aria-valuenow="60" role="progressbar" class="progress-bar progress-bar-danger">
                                 <span class="sr-only">Wordpress : 70% Complete</span>
                             </div>
                         </div>
                     </div>
                     <div class="about-skill-meter">
                         <div class="progress progress-xs">
                             <div style="width: 55%;" aria-valuemax="100" aria-valuemin="0" aria-valuenow="60" role="progressbar" class="progress-bar progress-bar-danger">
                                 <span class="sr-only">Graphic Design : 55% Complete</span>
                             </div>
                         </div>
                     </div>
                 </div>
             </div>
         </div>
     </div>

     <div class="container">
        <div class="row">
            <div class="text-center feature-head">
                <h1> Meet Our Team </h1>
                <p>We work with forward thinking clients to create beautiful, honest and amazing things that bring positive results.</p>
            </div>
            <div class="col-lg-4">
                <div class="person text-center">
                    
                    <img src="<?php echo base_url(IMAGES."team/team_img1.jpg");?>" alt="image">
                </div>
                <div class="person-info text-center">
                    <h4>
                        <a href="javascript:;">Ericson Reagan</a>
                    </h4>
                    <p class="text-muted"> Managing Director </p>
                    <div class="team-social-link">
                        <a href="#"><i class="icon-facebook"></i></a>
                        <a href="#"><i class="icon-twitter"></i></a>
                        <a href="#"><i class="icon-pinterest"></i></a>
                        <a href="#"><i class="icon-linkedin"></i></a>
                        <a href="#"><i class="icon-google-plus"></i></a>
                    </div>
                    <p>Redantium, totam rem aperiam, eaque ipsa qu ab illo inventore veritatis et quasi architectos beatae vitae dicta sunt explicabo. Nemo enims sadips ipsums un.</p>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="person text-center">
                    <img src="<?php echo base_url(IMAGES."team/team_img2.jpg");?>" alt="image">
                </div>
                <div class="person-info text-center">
                    <h4>
                        <a href="javascript:;">Alicja Colon</a>
                    </h4>
                    <p class="text-muted"> Web Designer </p>
                    <div class="team-social-link">
                        <a href="#"><i class="icon-facebook"></i></a>
                        <a href="#"><i class="icon-twitter"></i></a>
                        <a href="#"><i class="icon-pinterest"></i></a>
                        <a href="#"><i class="icon-linkedin"></i></a>
                        <a href="#"><i class="icon-google-plus"></i></a>
                    </div>
                    <p>Redantium, totam rem aperiam, eaque ipsa qu ab illo inventore veritatis et quasi architectos beatae vitae dicta sunt explicabo. Nemo enims sadips ipsums un.</p>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="person text-center">
                    <img src="<?php echo base_url(IMAGES."team/team_img3.jpg");?>" alt="image">
                </div>
                <div class="person-info text-center">
                    <h4>
                        <a href="javascript:;">Jonathan Smith</a>
                    </h4>
                    <p class="text-muted"> Web Developer </p>
                    <div class="team-social-link">
                        <a href="#"><i class="icon-facebook"></i></a>
                        <a href="#"><i class="icon-twitter"></i></a>
                        <a href="#"><i class="icon-pinterest"></i></a>
                        <a href="#"><i class="icon-linkedin"></i></a>
                        <a href="#"><i class="icon-google-plus"></i></a>
                    </div>
                    <p>Redantium, totam rem aperiam, eaque ipsa qu ab illo inventore veritatis et quasi architectos beatae vitae dicta sunt explicabo. Nemo enims sadips ipsums un.</p>
                </div>
            </div>
        </div>
    </div>
    <!--container end-->