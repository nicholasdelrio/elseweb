package edu.utep.cybershare.elseweb.old.data.banded.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WCSCoverageSet extends Element{

	HashMap<String, WCSCoverageDataset> datasets;
	
	public WCSCoverageSet(String identification) {
		super(identification);
		// TODO Auto-generated constructor stub
		datasets = new HashMap<String, WCSCoverageDataset>();
	}
	
	public boolean isSet_datasets(){return this.getDatasets().size() > 0;}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	public void addDataset(WCSCoverageDataset dataset){
		datasets.put(dataset.getIdentification(), dataset);
	}
	
	public List<WCSCoverageDataset> getDatasets(){
		return new ArrayList<WCSCoverageDataset>(datasets.values());
	}
}
