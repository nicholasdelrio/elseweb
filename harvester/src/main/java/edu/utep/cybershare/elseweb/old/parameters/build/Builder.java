package edu.utep.cybershare.elseweb.old.parameters.build;

import edu.utep.cybershare.elseweb.old.parameters.model.Algorithm;
import edu.utep.cybershare.elseweb.old.parameters.model.Parameter;
import edu.utep.cybershare.elseweb.old.parameters.model.Parameters;

public class Builder {
	
	private Algorithm anAlgorithm;
	private Parameters aParameterSet;

	private ModelProduct product;
	
	public Builder(ModelProduct modelProduct){
		product = modelProduct;
		
		reset();
	}
		
	private void reset(){
		anAlgorithm = null;
		aParameterSet = null;
	}

	
	public void buildAlgorithm(String code, String name){
		anAlgorithm = product.getAlgorithm(code);
		anAlgorithm.setName(name);
		anAlgorithm.setCode(code);
	}
	
	public void buildParameterSet(){
		String parameterSetName = anAlgorithm.getName() + "_parameters";
		
		aParameterSet = product.getParamterSet(parameterSetName);
		aParameterSet.setParentAlgorithm(anAlgorithm);
	}

	public void buildParameter(String name, String min, String max, String type, String defaultValue){
		Parameter param = product.getParameter(name);
		param.setName(name);
		param.setMin(min);
		param.setMax(max);
		param.setType(type);
		param.setDefaultValue(defaultValue);
		
		aParameterSet.add(param);
	}
		
	public void assemble(){		
		reset();
	}
}
