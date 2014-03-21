package edu.utep.cybershare.elseweb.old.parameters.model;

import java.util.ArrayList;
import java.util.List;

public class Algorithm extends Element{

	private String code;
	private String name;
	private ArrayList<Parameter> parameters;
	
	public Algorithm(String code){
		super(code);
		parameters = new ArrayList<Parameter>();
	}
	
	public boolean isSet_parameters(){
		return this.getParameters().size() > 0;
	}
	
	public boolean isSet_code(){
		return this.getCode() != null;
	}
	
	public boolean isSet_name(){
		return this.getName() != null;
	}
	
	public void addParameter(Parameter param){
		parameters.add(param);
	}
	
	public List<Parameter> getParameters(){
		return parameters;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}
}
