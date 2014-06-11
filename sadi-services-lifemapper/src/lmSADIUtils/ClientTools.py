'''
Created on Mar 12, 2014

@author: nick
'''

from lifemapper.lmClientLib import LMClient
import uuid

class LifemapperClient:
    
    def __init__(self, username, password):
        self.lmClient = LMClient(userId=username, pwd=password)
        self.epsgCode = 4326
        
        self.experimentBaseURL = "http://lifemapper.org/services/sdm/experiments/"
        self.layerBaseURL = "http://lifemapper.org/services/sdm/layers/"
        self.scenarioBaseURL = "http://lifemapper.org/services/sdm/scenarios/"

    def postLayer(self, tiffURL, layerUnits, typeCode):
        
        identifier = str(uuid.uuid4())
        layerName = "ew-" + identifier
        layerTitle = "ELSEWeb Layer " + identifier
        print "layerName %s" % layerName
        print "layerTitle %s" % layerTitle
        print "layerURL %s" % tiffURL
        print "epsgCode %s" % self.epsgCode
        print "units %s" % layerUnits
        print "typeCode %s" % typeCode
        
        postedLayer = self.lmClient.sdm.postLayer(
                    layerName,
                    self.epsgCode,
                    typeCode,
                    layerUnits,
                    "GTiff",
                    layerUrl=tiffURL,
                    title=layerTitle)
        
        self.layerID = postedLayer.id
        self.layerURL = self.layerBaseURL + postedLayer.id
                
    
    def postScenario(self, scenarioLayerIDs):
        
        cellSizeUnits = "dd"
        
        identifier = str(uuid.uuid4())
        scenCode = "ew-" + identifier[14:]
        scenTitle = "ew-" + identifier[14:]

        print "scenCode %s" % scenCode
        print "scenTitle %s" % scenTitle

        print "scenarioLayerIDs %s" % scenarioLayerIDs

        postedScenario = self.lmClient.sdm.postScenario(
                                  layers = scenarioLayerIDs,
                                  code = scenCode,
                                  title = scenTitle,
                                  epsgCode = self.epsgCode,
                                  units = cellSizeUnits)
        
        self.scenarioID = postedScenario.id
        self.scenarioURL = self.scenarioBaseURL + postedScenario.id
        
        
    def postExperiment(self, algorithm, params, occurrenceSetID, scenarioID):

        mdlScn = scenarioID
        prjScns = [scenarioID]

        print("Scenario ID %s" % mdlScn)
        print("Projection ID %s" % prjScns)
        print("Algorithm %s" % algorithm)
        print "Chosen occurrence set ID %s" % occurrenceSetID

        alg = self.lmClient.getAlgorithmFromCode(algorithm)
        
        for binding

        exp = self.lmClient.sdm.postExperiment(algorithm, mdlScn, occurrenceSetID, prjScns=prjScns)

        self.experimentID = exp.id
        self.experimentURL = self.experimentBaseURL + exp.id
    
    
    def getLayerID(self):
        return self.layerID
    def getLayerURL(self):
        return self.layerURL
    
    def getScenarioID(self):
        return self.scenarioID
    def getScenarioURL(self):
        return self.scenarioURL
    
    def getExperimentID(self):
        return self.experimentID
    def getExperimentURL(self):
        return self.experimentURL