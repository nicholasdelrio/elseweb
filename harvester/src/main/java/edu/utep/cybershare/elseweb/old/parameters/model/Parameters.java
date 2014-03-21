package edu.utep.cybershare.elseweb.old.parameters.model;

import java.util.ArrayList;

public class Parameters extends Element {

	private ArrayList<Parameter> parameterSet;
	private Algorithm parentAlgorithm;
	
	public Parameters(String identification) {
		super(identification);
		// TODO Auto-generated constructor stub
		
		parameterSet = new ArrayList<Parameter>();
	}
	
	public void setParentAlgorithm(Algorithm algorithm){
		this.parentAlgorithm = algorithm;
	}
	
	public Algorithm getParentAlgorithm(){
		return this.parentAlgorithm;
	}
	
	public void add(Parameter param){
		parameterSet.add(param);
	}
	
	public ArrayList<Parameter> getParameters(){
		return this.parameterSet;
	}
	
	public boolean isSet_ParameterSet(){
		return this.getParameters().size() > 0;
	}
	public boolean isSet_ParentAlgorithm(){
		return this.parentAlgorithm != null;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
