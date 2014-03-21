'''
Created on Mar 12, 2014

@author: nick
'''

import sadi
import uuid

from rdflib import *
from rdflib.resource import Resource as RDFLibResource

from lmSADIUtils.URI import ResourceURI
from lmSADIUtils.ClientTools import LifemapperClient
from lmSADIUtils.Namespace import LM, DATA

class ScenarioPosterService(sadi.Service):
    label = "ScenarioPosterService"
    serviceDescriptionText = 'Scenario Poster Service'
    comment = 'Scenario Poster Service'
    serviceNameText = "ScenarioPosterService"
    name = "ScenarioPosterService"

    def getOrganization(self):
        result = self.Organization()
        result.add(RDFS.label,Literal("University of Texas at El Paso CYBER-ShARE"))
        result.add(sadi.mygrid.authoritative, Literal(False))
        result.add(sadi.dc.creator, URIRef('mailto:nicholas.delrio@gmail.com'))
        return result

    def getInputClass(self):
        return LM.UnpostedScenario

    def getOutputClass(self):
        return LM.PostedScenario
    
    def testProcess(self):
        username = "elseweb"
        password = "elseweb1"
        lmClient = LifemapperClient(username, password)
        
        scenarioLayerIDs = []
        scenarioLayerIDs.append(str(1846))
        scenarioLayerIDs.append(str(1847))
        scenarioLayerIDs.append(str(1848))
        scenarioLayerIDs.append(str(1849))
        scenarioLayerIDs.append(str(1850))
        
        print "scenarioLayerIDs %s" % scenarioLayerIDs
        
        # Post scenario and save ID
        scenarioID = lmClient.postScenario(scenarioLayerIDs)
        
        print "scenarioID %s" % scenarioID
        

    def process(self, input, output):
        username = "elseweb"
        password = "elseweb1"
        lmClient = LifemapperClient(username, password)
        
        # Get the JSON spec
        jsonSpecification = input.value(LM.hasJSONExperimentSpecificationURL)
        
        # Get published scenario layers
        scenarioLayerIDs = []
        for layer in input[LM.hasScenarioLayer]:
            layerID = layer.value(LM.hasLayerID)
            scenarioLayerIDs.append(str(layerID))

        # Post scenario and save ID
        lmClient.postScenario(scenarioLayerIDs)
        #scenarioID = str(234)
        
        scenarioID = lmClient.getScenarioID()
        scenarioURL = lmClient.getScenarioURL()
        
        # The URI generator
        resourceURI = ResourceURI()
        
        # Create the published scenario
        scenario = RDFLibResource(output.graph, resourceURI.getURI("scenario"))
        ScenarioClass = RDFLibResource(output.graph, LM.Scenario)
        scenario.set(RDF.type, ScenarioClass)
        scenario.set(LM.hasScenarioID, Literal(scenarioID))
        scenario.set(LM.hasScenarioURL, Literal(scenarioURL))
        scenario.set(LM.hasJSONExperimentSpecificationURL, jsonSpecification)
        
        # Add scenarioID to output
        output.set(LM.hasPublishedScenario, scenario)
        
# main function for testing
application = ScenarioPosterService()
if __name__ == "__main__":
    #sadi.serve(application, port=9090)
    application.testProcess()