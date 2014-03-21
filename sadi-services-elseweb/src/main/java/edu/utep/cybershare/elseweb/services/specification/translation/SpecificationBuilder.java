package edu.utep.cybershare.elseweb.services.specification.translation;

import java.util.List;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;

import edu.utep.cybershare.elseweb.ontology.Vocabulary;
import edu.utep.cybershare.elseweb.services.specification.translation.json.JSONSpecification;
import edu.utep.cybershare.elseweb.services.specification.translation.json.ParameterBinding;
import edu.utep.cybershare.elseweb.services.util.ResourceURI;

public class SpecificationBuilder {
	
	private JSONSpecification jsonSpec;
	private ELSEWebSPARQLEndpoint endpoint;
	
	private Model model;
	private Resource specification;
	private ResourceURI resourceURI;
	
	public SpecificationBuilder(JSONSpecification jsonSpec, Model model){
		this.jsonSpec = jsonSpec;
		this.endpoint = new ELSEWebSPARQLEndpoint();
		this.model = model;
		this.resourceURI = new ResourceURI();
	}

	public Resource getSpecification(){
		this.buildSpecification();
		return this.specification;
	}
	
	private void buildSpecification(){
		specification = this.model.createResource(resourceURI.getURI("specification").toASCIIString(), Vocabulary.ExecutableExperimentSpecification);
		this.setOccurrenceSet(specification);
		this.setAlgorithm(specification);
	}
	
	private void setAlgorithm(Resource specification){
		String algorithmID = jsonSpec.getAlgorithmID();
		AlgorithmDescription description = endpoint.getAlgorithDescription(algorithmID);
		
		Resource algorithm = this.model.createResource(description.getAlgorithmURI(), Vocabulary.LifemapperAlgorithm);
		algorithm.addLiteral(Vocabulary.hasAlgorithmCode, algorithmID);
	
		Resource paramCollection = this.getParameterCollection(description);
		algorithm.addProperty(Vocabulary.behaviorControlledBy, paramCollection);
		
		specification.addProperty(Vocabulary.specifiesModellingAlgorithm, algorithm);
	}
	
	private Resource getParameterCollection(AlgorithmDescription description){
		String paramCollectionClassURI = description.getParamsCollectionClassURI();
		Resource paramCollectionClass = model.createResource(paramCollectionClassURI);
		Resource paramCollection = model.createResource(resourceURI.getURI("param-collection").toASCIIString(), paramCollectionClass);
		
		List<ParameterBinding> bindings = jsonSpec.getParameterBindings();
		Resource param;
		int i = 0;
		for(ParameterBinding binding : bindings){
			param = getParameter(description, binding, i++);
			paramCollection.addProperty(Vocabulary.hasParameterMember, param);
		}
		
		return paramCollection;
	}
		
	private Resource getParameter(AlgorithmDescription description, ParameterBinding binding, int id){
		String paramName = binding.getParameterName();
		String paramClassURI = description.getParamClassURI(paramName);
		
		Resource paramClass = model.createResource(paramClassURI);
		Resource param = model.createResource(resourceURI.getURI("param-" + id).toASCIIString(), paramClass);
		param.addLiteral(Vocabulary.hasParameterName, paramName);

		if(binding.getDataType().equals(ParameterBinding.DataType.doubleType))
			param.addLiteral(Vocabulary.boundToValue, binding.getDoubleValue());
		else
			param.addLiteral(Vocabulary.boundToValue, binding.getIntegerValue());
		
		return param;
	}
	
	private void setOccurrenceSet(Resource specification){
		String occurrenceSetID = jsonSpec.getOccurrenceSetID();
		String occurrenceSetURI = endpoint.getOccurrenceSet(occurrenceSetID);

		model.add(endpoint.constructOccurrenceSet(occurrenceSetID));
		
		Resource occurrenceSet = model.createResource(occurrenceSetURI, Vocabulary.SpeciesOccurrenceSet);
		specification.addProperty(Vocabulary.specifiesOccurrenceSet, occurrenceSet);
	}
}
