'''
Created on Mar 12, 2014

@author: nick
'''

import sadi
import sys

from rdflib import *
from rdflib.resource import Resource as RDFLibResource

from lmSADIUtils.ClientTools import LifemapperClient
from lmSADIUtils.Namespace import LM, DATA
from lmSADIUtils.URI import ResourceURI

class ExperimentPosterService(sadi.Service):
    label = "ExperimentPosterService"
    serviceDescriptionText = 'Experiment Poster Service'
    comment = 'Experiment Poster Service'
    serviceNameText = "ExperimentPosterService"
    name = "ExperimentPosterService"

    def getOrganization(self):
        result = self.Organization()
        result.add(RDFS.label,Literal("University of Texas at El Paso CYBER-ShARE"))
        result.add(sadi.mygrid.authoritative, Literal(False))
        result.add(sadi.dc.creator, URIRef('mailto:nicholas.delrio@gmail.com'))
        return result

    def getInputClass(self):
        return LM.ExecutableExperimentSpecification

    def getOutputClass(self):
        return LM.ExecutedExperimentSpecification

    def process(self, input, output):
        username = "elseweb"
        password = "elseweb1"
        lmClient = LifemapperClient(username, password)
        
        # Get scenario id
        scenario = input.value(LM.specifiesModellingScenario)
        scenarioID = scenario.value(LM.hasScenarioID)
        
        # Extract Algorithm
        algorithm = input.value(LM.specifiesModellingAlgorithm)
        algorithmCode = algorithm.value(LM.hasAlgorithmCode)

        # Extract OccurrenceSetID
        occurrenceSet = input.value(LM.specifiesOccurrenceSet)
        occurrenceSetID = occurrenceSet.value(LM.hasOccurrenceSetID)

        lmClient.postExperiment(algorithmCode, occurrenceSetID, scenarioID)
        #resultURL = "http://somedomain.com/testURL"
        
        #get experimentURL and id
        experimentURL = lmClient.getExperimentURL()
        experimentID = lmClient.getExperimentID()
        
        print "experiment result URL %s " % experimentURL

        # The URI generator
        resourceURI = ResourceURI()

        # Create the experiment result
        experimentResult = RDFLibResource(output.graph, resourceURI.getURI("experimentResult"))
        experimentResultClass = RDFLibResource(output.graph, LM.ExperimentResult)
        experimentResult.set(RDF.type, experimentResultClass)
        experimentResult.set(LM.hasExperimentResultURL, Literal(experimentURL))
        experimentResult.set(LM.hasExperimentResultID, Literal(experimentID))

        # Add the experiment result to the executed specification
        output.set(LM.hasExperimentResult, experimentResult)        
        
# main function for testing
application = ExperimentPosterService()
if __name__ == "__main__":
    sadi.serve(application, port=9090)