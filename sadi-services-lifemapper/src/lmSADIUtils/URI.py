'''
Created on Mar 12, 2014

@author: nick
'''

from rdflib import *
import uuid

class ResourceURI:
    def __init__(self):
        self.identifier = str(uuid.uuid4())
        self.baseURI = "http://visko.cybershare.utep.edu/linked-data/elseweb/sadi/"

    def getURI(self, baseFragment):
        fullFragment = baseFragment + "-" + self.identifier
        return URIRef(self.baseURI + fullFragment)