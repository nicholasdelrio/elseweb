package edu.utep.cybershare.elseweb.experiment;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import edu.utep.cybershare.elseweb.share.Client;
import edu.utep.cybershare.elseweb.share.Query;

/**
 * Servlet implementation class JSONSpecification
 */
public class JSONSpecification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSONSpecification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.runExperiment(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.runExperiment(request, response);
	}
	
	private void runExperiment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String jsonSpecificationString = request.getParameter("jsonSpec");
		
		if(jsonSpecificationString != null){

			System.out.println("got JSON input:");
			System.out.println(jsonSpecificationString);
			// Build the specification
			edu.utep.cybershare.elseweb.experiment.json.JSONSpecification jsonSpecification = new edu.utep.cybershare.elseweb.experiment.json.JSONSpecification(jsonSpecificationString);
			
			if(!jsonSpecification.isValid()){
				System.out.println("JSON is not valid!!!!");
				response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			}
			else{
				try{
					// Build the specification
					JSONExperimentSpecification specBuilder = new JSONExperimentSpecification(jsonSpecification);
					String specURLString = specBuilder.dumpJSONExperimentSpecification().toString();
				
					// Submit the specification
					String submissionResults = this.submitSpecification(specURLString);
					System.out.println(submissionResults);
				
					// Return submission results
					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(submissionResults);
				}
				catch(Exception e){
					e.printStackTrace();
					response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				}
			}
		}
		else{
			System.out.println("send bad request error since jsonSpec was null!");
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
	
	private String submitSpecification(String specURLString) throws Exception {	
		URL specURL = new URL(specURLString);
		Query shareQuery = new Query(specURL);
		Client client = new Client(shareQuery);
		JSONObject result = client.executeQuery(shareQuery);
		return result.toString();		
	}
		
	private String getUsageMessage(){
		String message = "<html><head><title>Usage Message: Requires HTTP Post</title></head><body>";
		message += "<p>Please post the contents of an ELSEWeb JSON Experiment Specification bound to the parameter: <b>jsonSpec</b></p>";
		message += "<p>An example JSON specification can be found <a href=\"http://ontology.cybershare.utep.edu/ELSEWeb/linked-data/lifemapper/experiments/specifications/json/sample-specification.json\">here</a></p>";
		message += "</body></html>";
		return message;
	}
}
