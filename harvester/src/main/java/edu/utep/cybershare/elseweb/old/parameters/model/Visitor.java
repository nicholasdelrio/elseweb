package edu.utep.cybershare.elseweb.old.parameters.model;

public interface Visitor {
	
	public void visit(Algorithm algorithm);
	public void visit(Parameter parameter);
	public void visit(Parameters parameters);
}
