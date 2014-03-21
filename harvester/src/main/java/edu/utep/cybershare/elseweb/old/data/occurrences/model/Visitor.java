package edu.utep.cybershare.elseweb.old.data.occurrences.model;

public interface Visitor {
	public void visit(Region region);
	public void visit(Dataset dataset);
	public void visit(Layer layer);
	public void visit(Manifestation manifestation);
	public void visit(Species species);
	public void visit(SpeciesOccurrenceSet speciesOccurrence);
	public void visit(Projection projection);
}
