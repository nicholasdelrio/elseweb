package edu.utep.cybershare.elseweb.old.data.banded.model;

public interface Visitor {
	
	public void visit(Characteristic characteristic);
	public void visit(WCSCoverageDataset dataset);
	public void visit(Measurement measurement);
	public void visit(Observation observation);
	public void visit(Entity entity);
	public void visit(WCSCoverageSet catalog);
	public void visit(WCSCoverageDistribution distribution);
	public void visit(Region region);
	public void visit(Duration duration);
	
}
