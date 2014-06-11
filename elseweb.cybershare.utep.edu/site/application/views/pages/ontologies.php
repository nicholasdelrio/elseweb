    <!--container start-->
    <div class="container">
        <div class="row">
            <h3>A Multitier Ontology Driven Infrastructure</h3>
            <p>Although ELSEWeb currently enables the transference of EDAC data to Lifemapper, we ultimately want to connect with other data and model providers. To accommodate for these expansions, we have devised a multitier ontology driven infrastructure that allows third-party providers to align with our ontologies and therefore be incorporated with our system.</p>
            <p>The first tier of our ontology consists of prevalent Linked 0pen Data (LOD) ontologies that, in addition to providing a community driven structure to our data, allows other semantic applications to easily consume our RDF. The second tier expands on LOD ontologies and provides specific concepts for describing data provider sources and modeling services. The third tier is where the domain specific data and model providers would align with our generic ontologies, and provide classes and properties specific to their domain. Finally, the transformation tier provides a link between a specific data and model provider. SADI services leverage the transformation ontology to automatically transform source data into forms a specific modeling agent can process.</p>

            <img width="800" src="<?php echo base_url(IMAGES."layered-ontologies.png");?>" alt="text img">
        </div>

        <div class="row">
            <div class="hiring">
                <div class="col-lg-6 col-sm-6">
                    <div class="content">
                        <h3 class="title">ELSEWeb Data</h3>
                        <p>The <a href="<?php echo ONTPREFIX."elseweb-data.owl";?>">elseweb-data ontology</a> provides concepts for describing the spatial/temporal dimensions of a dataset, how it can be accessed, and the specific nature of the data being contained.</p>
                        <a href="<?php echo ONTPREFIX."elseweb-data.owl";?>"><img width="470" src="<?php echo base_url(IMAGES."elseweb-data.png");?>" alt="text img"></a>
                    </div>
                </div>
                <div class="col-lg-6 col-sm-6">
                    <div class="content">
                        <h3 class="title">ELSEWeb Model</h3>
                        <p>The <a href="<?php echo ONTPREFIX."elseweb-modelling.owl";?>">elseweb-modelling</a> ontology provides concepts for describing generic algorithms and how they relate to parameter sets and software agents which serve as implementations.</p>
                         <a href="<?php echo ONTPREFIX."elseweb-modelling.owl";?>"><img width="470" src="<?php echo base_url(IMAGES."elseweb-modelling.png");?>" alt="text img"></a>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="hiring">
                <div class="col-lg-6 col-sm-6">
                    <div class="content">
                        <h3 class="title">ELSEWeb EDAC</h3>
                        <p>The <a href="<?php echo ONTPREFIX."elseweb-edac.owl";?>">elseweb-edac ontology</a> describes specific raster and vector datasets served by <a href="http://edac.unm.edu/">EDAC’s</a> large collection of Open Geospatial Consortium (OGC) web services. The ontology provides properties for attaching pointers to Web Coverage Service (WCS) Get-Capabilities documents as well as EDAC’s special condensed JSON capabilities representation. The <a href="<?php echo LODSPEAKR."instances/elseweb_edac:PublishedPRISMDataset";?>">environmental datasets</a> contained in this ontology were harvested from the <a href="http://gstore.unm.edu/">EDAC’s GSTORE</a>..</p>
                         <a href="<?php echo ONTPREFIX."elseweb-edac.owl";?>"><img width="470" src="<?php echo base_url(IMAGES."elseweb-edac.png");?>" alt="text img"></a>
                    </div>
                </div>
                <div class="col-lg-6 col-sm-6">
                    <div class="content">
                        <h3 class="title">ELSEWeb Lifemapper</h3>
                        <p>The <a href="<?php echo ONTPREFIX."elseweb-lifemapper.owl";?>">elseweb-lifemapper</a> describes specific <a href="<?php echo LODSPEAKR."instances/elseweb_lifemapper:LifemapperAlgorithm";?>">modeling algorithms</a> supported by <a href="http://lifemapper.org">Lifemapper</a> as well as corresponding parameter sets. The parameter descriptions contain minimum and maximum “hasValue” property restrictions to define the legal ranges of values bound to specific parameters. This ontology also contains a collection of <a href="<?php echo LODSPEAKR."instances/elseweb_lifemapper:SpeciesOccurrenceDataset";?>">species occurrence data</a> that can be referenced in experiments.</p>
                         <a href="<?php echo ONTPREFIX."elseweb-lifemapper.owl";?>"><img width="470" src="<?php echo base_url(IMAGES."elseweb-lifemapper.png");?>" alt="text img"></a>
                    </div>
                </div>
            </div>
        </div>


        <div class="row">
            <div class="text-center">
                <div class="content">
                    <h3 class="title">ELSEWeb EDAC to Lifemapper</h3>
                    <p>The <a href="<?php echo ONTPREFIX."elseweb-lifemapper.owl";?>">edac-to-lifemapper ontology</a> describes the relationships between user experiment specifications and Lifemapper experiment specifications. Users experiment specifications reference resources such as EDAC WCS datasets, which Lifemapper is unable to directly process.  Lifemapper experiment specifications expect input data as “Posted TIFFs” and to be associated with posted “Scenarios”. Therefore, rounds of transformations must ensue before feeding EDAC data to Lifemapper. The edac-to-lifemapper ontology specifies the intermediate forms and how they relate from the source EDAC data and the required Lifemapper scenarios. From these intermediate form descriptions, tools such as <a href”http://sadiframework.org/content/tag/cardioshare/”>SADI SHARE client</a> can identify services that support the transformations of EDAC data to forms ingestible by Lifemapper.
</p>
                    <a href="<?php echo ONTPREFIX."elseweb-lifemapper.owl";?>"><img width="900" src="<?php echo base_url(IMAGES."edac-to-lifemapper.png");?>" alt="text img"></a>
                </div>
            </div>
        </div>

    </div>
    <!--container end-->