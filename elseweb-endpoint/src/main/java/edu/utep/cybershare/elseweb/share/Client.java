package edu.utep.cybershare.elseweb.share;

import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Client {
	
	private static final String EMPTY_RESULT_SET = "Empty Result Set";
	private static final String EXECUTION_ERROR = "Execution Error";
	private static final String SUCCESS = "Success";
	
	private static final String RESULT_URL_VARNAME = "resultURL";
	private static final String RESULT_URI_VARNAME = "resultURI";
	
	private Endpoint endpoint;
	private String resultURL;
	private String resultURI;
	private String statusMessage;
	
	public Client(Query shareQuery){
		endpoint = new Endpoint();
	}
	
	private JSONObject getJSONResult(){
		//create root node container
		JSONObject object = null;
		
		try{
			object = new JSONObject();

			JSONObject executedSpecification = new JSONObject();
			object.put("executedSpecification", executedSpecification);

			JSONObject experimentResult = new JSONObject();
			executedSpecification.put("experimentResult", experimentResult);	
			
			if(statusMessage.equals(SUCCESS)){
				executedSpecification.put("successful", "true");
				experimentResult.put("resultURL", this.resultURL);
				experimentResult.put("resultURI", this.resultURI);
			}
			else{
				executedSpecification.put("successful", "false");
				experimentResult.put("resultURL", this.statusMessage);
				experimentResult.put("resultURI", this.statusMessage);
				
			}
		}
		catch(Exception e){e.printStackTrace();}	
		return object;
	}
	
	public JSONObject executeQuery(Query shareQuery){
		this.executeSHAREQuery(shareQuery);
		return this.getJSONResult();
	}
	
	private void executeSHAREQuery(Query shareQuery){
		//assume error initially
		this.statusMessage = Client.EXECUTION_ERROR;
		
		//submit query and get task (i.e., job) ID so we can poll
		String taskIDJSON = endpoint.submitQuery(shareQuery);
		System.out.println(taskIDJSON);
		String taskID = getTaskID(taskIDJSON);
		
		//now poll until you get result
		boolean completed = false;
		String statusMessage;
		while(!completed){
			pause(2);
			
			statusMessage = endpoint.getStatus(taskID);
			
			if(isCompletedMessage(statusMessage)){
				setResults(statusMessage);
				this.statusMessage = Client.SUCCESS;
				completed = true;
			}
			else
				System.out.println(statusMessage);
		}
	}
	
	private void pause(int seconds){
		try{Thread.sleep(seconds * 1000);}
		catch(Exception e){e.printStackTrace();}
	}
	
	private void setResults(String jsonAnswer){
		System.out.println(jsonAnswer);
		try{
			JSONObject answer = new JSONObject(jsonAnswer);
			JSONArray fields = answer.getJSONArray("fields");
			
			JSONArray resultRow = answer.getJSONArray("rows").getJSONArray(0);
			
			String fieldName;
			for(int i = 0; i < fields.length(); i ++){
				fieldName = fields.getString(i);
				if(fieldName.equals(RESULT_URI_VARNAME))
					this.resultURI = resultRow.getString(i);
				else if(fieldName.equals(RESULT_URL_VARNAME))
					this.resultURL = resultRow.getString(i);
			}
		}
		catch(Exception e){e.printStackTrace();}
		statusMessage =  Client.EMPTY_RESULT_SET;
	}
	
	private static boolean isCompletedMessage(String message){
		return message.startsWith("{");
	}
		
	private static String getTaskID(String jsonString){
		try {
			JSONObject object = new JSONObject(jsonString);
			return object.getString("taskId");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args){
		URL experimentURL;	
		Client client;
		Query shareQuery;
		try{
			experimentURL = new URL("http://ontology.cybershare.utep.edu/ELSEWeb/linked-data/lifemapper/experiments/specifications/json/sample-specification.owl");
			shareQuery = new Query(experimentURL);
			client = new Client(shareQuery);
			System.out.println("Response Message:");
			System.out.println(client.executeQuery(shareQuery));
		}
		catch(Exception e){e.printStackTrace();}
	}
}
