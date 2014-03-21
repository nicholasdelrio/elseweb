package edu.utep.cybershare.elseweb.old.data.banded.model;

public class WCSCoverageDataset extends Element {

	private Region region;
	private Duration duration;
	private Measurement measurement;
	private WCSCoverageDistribution distribution;
	private int id;
	
	public WCSCoverageDataset(String identification) {
		super(identification);
		// TODO Auto-generated constructor stub
		id = -1;
	}

	public boolean isSet_ID(){
		return id > -1;
	}
	
	public boolean isSet_region(){
		return this.getRegion() != null;
	}
	
	public boolean isSet_distribution(){
		return this.getDistribution() != null;
	}
	
	public boolean isSet_duration(){
		return this.getDuration() != null;
	}
	
	public boolean isSet_measurement(){
		return this.getMeasurement() != null;
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public int getID(){
		return id;
	}
	
	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public Measurement getMeasurement() {
		return measurement;
	}

	public void setMeasurement(Measurement measurement) {
		this.measurement = measurement;
	}
	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
		
	}

	public WCSCoverageDistribution getDistribution() {
		return distribution;
	}

	public void setDistribution(WCSCoverageDistribution distribution) {
		this.distribution = distribution;
	}
}
