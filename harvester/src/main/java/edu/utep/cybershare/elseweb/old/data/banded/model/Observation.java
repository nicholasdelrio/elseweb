package edu.utep.cybershare.elseweb.old.data.banded.model;

public class Observation extends Element {

	private Entity entity;
	
	public Observation(String identification) {
		super(identification);
		// TODO Auto-generated constructor stub
	}
		
	public boolean isSet_entity(){
		return this.getEntity() != null;
	}
	
	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}
}
