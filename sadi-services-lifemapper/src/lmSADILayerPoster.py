'''
Created on Mar 12, 2014

@author: nick
'''

import sadi

from rdflib import *
from rdflib.resource import Resource as RDFLibResource

from lmSADIUtils.ClientTools import LifemapperClient
from lmSADIUtils.Namespace import LM, DATA
from lmSADIUtils.URI import ResourceURI

class LayerPosterService(sadi.Service):
    label = "LayerPosterService"
    serviceDescriptionText = 'Layer Poster Service'
    comment = 'Layer Poster Service'
    serviceNameText = "LayerPosterService"
    name = "LayerPosterService"

    def getOrganization(self):
        result = self.Organization()
        result.add(RDFS.label,Literal("University of Texas at El Paso CYBER-ShARE"))
        result.add(sadi.mygrid.authoritative, Literal(False))
        result.add(sadi.dc.creator, URIRef('mailto:nicholas.delrio@gmail.com'))
        return result

    def getInputClass(self):
        return LM.TIFFDataset

    def getOutputClass(self):
        return LM.PostedTIFFDataset
    
    def testProcess(self):
        inputGraph = Graph()
        inputGraph.parse("http://ontology.cybershare.utep.edu/ELSEWeb/linked-data/lifemapper/layers/tiff-dataset.owl")
        inputURI = URIRef("http://visko.cybershare.utep.edu/linked-data/elseweb/sadi/tiffDataset")
        inputResource = RDFLibResource(inputGraph, inputURI);
        
        outputGraph = Graph()
        outputURI = URIRef("http://visko.cybershare.utep.edu/linked-data/elseweb/sadi/tiffDataset")
        outputResource = RDFLibResource(outputGraph, outputURI);
        
        self.process(inputResource, outputResource)
        
        publishedTIFFLayer = outputResource.value(LM.hasPublishedLayer)
        fileManifestation = publishedTIFFLayer.value(DATA.hasManifestation)
        fileURL = fileManifestation.value(DATA.hasFileDownloadURL)
        layerID = publishedTIFFLayer.value(LM.hasLayerID)
        
        print(fileURL)
        print(publishedTIFFLayer)
        print(layerID)
    

    def process(self, input, output):
        username = "elseweb"
        password = "elseweb1"
        lmClient = LifemapperClient(username, password)
        
        # Get file download URL of the TIFF layer
        manif = input.value(DATA.hasManifestation)
        tiffFileDownloadURL = manif.value(DATA.hasFileDownloadURL)

        # Get the typeCode and layerUnits
        typeCode = input.value(LM.hasTypeCode)
        layerUnits = input.value(LM.hasLayerUnits)

        # Get the JSON spec
        jsonSpecification = input.value(LM.hasJSONExperimentSpecificationURL)

        lmClient.postLayer(tiffFileDownloadURL, layerUnits, typeCode)
        #layerID = str(12)
        
        layerID = lmClient.getLayerID()
        layerURL = lmClient.getLayerURL()
        
        print "posted layer ID %s " % layerID

        # The URI generator
        resourceURI = ResourceURI()
        
        # Create new manifestation
        fileManifestation = RDFLibResource(output.graph, resourceURI.getURI("manifestation"))
        FileManifestationClass = RDFLibResource(output.graph, DATA.FileManifestation)
        fileManifestation.set(RDF.type, FileManifestationClass)
        fileManifestation.set(DATA.hasLandingPageURL, Literal(layerURL))
        
        # Create the ScenarioLayer
        layer = RDFLibResource(output.graph, resourceURI.getURI("layer"))
        ScenarioLayerClass = RDFLibResource(output.graph, LM.ScenarioLayer)
        layer.set(RDF.type, ScenarioLayerClass)
        layer.set(DATA.hasManifestation, fileManifestation)
        layer.set(LM.hasLayerID, Literal(layerID))
        layer.set(LM.hasLayerURL, Literal(layerURL))
        layer.set(LM.hasJSONExperimentSpecificationURL, jsonSpecification)
        
        output.set(LM.hasPublishedLayer, layer)
        
        
# main function for testing
application = LayerPosterService()
if __name__ == "__main__":
    #sadi.serve(application, port=9090)
    application.testProcess()