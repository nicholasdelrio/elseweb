package edu.utep.cybershare.elseweb.services.specification.translation.json;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import edu.utep.cybershare.elseweb.services.util.HTTPGetUtils;


public class JSONSpecification {
	
	private JSONObject specification;
	private String specID;
	private String occurrenceSetID;
	private String algorithmID;
	private ArrayList<ParameterBinding> parameterBindings;
	private ArrayList<String> modellingScenario;
	
	private boolean isValid;
	
	public JSONSpecification(URL jsonSpecURL){	
		String jsonSpecString = HTTPGetUtils.getInstance().downloadText(jsonSpecURL);
		init(jsonSpecString);
	}
	
	public JSONSpecification(String jsonSpecString){
		this.init(jsonSpecString);
	}
	
	public boolean isValid(){return this.isValid;}
	
	public String getString(){return this.specification.toString();}
	
	private void init(String jsonSpecString){
		this.isValid = true;
		
		try{
			specification = new JSONObject(jsonSpecString);
			init(specification);
		}catch(Exception e){e.printStackTrace();}

	}
	
	private void init(JSONObject jsonSpec){
		try{
			JSONObject spec = jsonSpec.getJSONObject("specification");
			this.setAlgorithmComponenets(spec);
			this.setOccurrenceData(spec);
			this.setModellingScenario(spec);
			this.setSpecID(spec);
		}
		catch(Exception e){e.printStackTrace();isValid = false;}
	}
	
	public String getOccurrenceSetID(){return this.occurrenceSetID;}
	public String getAlgorithmID(){return this.algorithmID;}
	public List<ParameterBinding> getParameterBindings(){return this.parameterBindings;}
	public List<String> getModellingScenario(){return this.modellingScenario;}
	public String getSpecID() {return specID;}
	
	private void setOccurrenceData(JSONObject jsonSpec){
		try{this.occurrenceSetID = jsonSpec.getString("occurrenceDataID");}
		catch(Exception e){e.printStackTrace();isValid = false;}
	}

	private void setSpecID(JSONObject jsonSpec){
		try{this.specID = jsonSpec.getString("id");}
		catch(Exception e){e.printStackTrace();isValid = false;}
	}
	
	private void setAlgorithmComponenets(JSONObject jsonSpec){
		parameterBindings = new ArrayList<ParameterBinding>();
		
		try{
			JSONObject algorithm = jsonSpec.getJSONObject("algorithm");
			this.algorithmID = algorithm.getString("id");
			
			JSONArray paramBindings = algorithm.getJSONArray("parameterBindings");
			JSONObject paramBinding;
			String parameterName;
			String dataType;
			String value;
			for(int i = 0; i < paramBindings.length(); i ++){
				paramBinding = paramBindings.getJSONObject(i);
				dataType = paramBinding.getString("datatype");
				parameterName = paramBinding.getString("name");
				value = paramBinding.getString("value");
				
				if(dataType.equals("double"))
					this.parameterBindings.add(new ParameterBinding(parameterName, value, ParameterBinding.DataType.doubleType));
				else
					this.parameterBindings.add(new ParameterBinding(parameterName, value, ParameterBinding.DataType.intType));
			}
			
		}
		catch(Exception e){e.printStackTrace();isValid = false;}
	}

	private void setModellingScenario(JSONObject jsonSpec){
		modellingScenario = new ArrayList<String>();
		
		try{
			JSONArray modellingScenarios = jsonSpec.getJSONArray("modelingScenario");
			JSONObject modellingScenario;
			String datasetIRI;
			for(int i = 0; i < modellingScenarios.length(); i ++){
				modellingScenario = modellingScenarios.getJSONObject(i);
				datasetIRI = modellingScenario.getString("datasetURI");
				this.modellingScenario.add(datasetIRI);
			}
		}
		catch(Exception e){e.printStackTrace();isValid = false;}
	}
}