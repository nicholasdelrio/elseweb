package edu.utep.cybershare.elseweb.experiment.json;

public class ParameterBinding {
	
	public static enum DataType {doubleType, intType};
	
	private String parameterName;
	private DataType dataType;
	private String value;
	
	public ParameterBinding(String parameterName, String value, DataType dataType){
		this.parameterName = parameterName;
		this.dataType = dataType;
		this.value = value;
	}
	
	public double getDoubleValue(){
		return Double.valueOf(this.value);
	}
	
	public int getIntegerValue(){
		return Integer.valueOf(this.value);
	}
	
	public DataType getDataType(){
		return this.dataType;
	}
	
	public String getParameterName(){
		return this.parameterName;
	}
}
