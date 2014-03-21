package edu.utep.cybershare.elseweb.old.parameters.build;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.utep.cybershare.elseweb.old.parameters.model.Algorithm;
import edu.utep.cybershare.elseweb.old.parameters.model.Parameter;
import edu.utep.cybershare.elseweb.old.parameters.model.Parameters;

public class ModelProduct {
	
	private HashMap<String, Algorithm> algorithms;
	private HashMap<String, Parameter> parameters;
	private HashMap<String, Parameters> parameterSets;
	
	public ModelProduct(){
		algorithms = new HashMap<String, Algorithm>();
		parameters = new HashMap<String, Parameter>();
		parameterSets = new HashMap<String, Parameters>();
	}
		
	public Algorithm getAlgorithm(String key){
		Algorithm algorithm = algorithms.get(key);
		if(algorithm == null){
			algorithm = new Algorithm(key);
			algorithms.put(key, algorithm);
		}
		return algorithm;
	}
	
	public Parameters getParamterSet(String key){
		Parameters parameterSet = parameterSets.get(key);
		if(parameterSet == null){
			parameterSet = new Parameters(key);
			parameterSets.put(key, parameterSet);
		}
		return parameterSet;
	}

	public Parameter getParameter(String key){
		Parameter parameter = parameters.get(key);
		if(parameter == null){
			parameter = new Parameter(key);
			parameters.put(key, parameter);
		}
		return parameter;
	}

	//get model elements
	public List<Parameter> getParameters(){return new ArrayList<Parameter>(parameters.values());}
	public List<Algorithm> getAlgorithms(){return new ArrayList<Algorithm>(algorithms.values());}
	public List<Parameters> getParameterSets(){return new ArrayList<Parameters>(parameterSets.values());}
}
