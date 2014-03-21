package edu.utep.cybershare.elseweb.old.data.banded.model;

import java.util.Calendar;

public class Duration extends Element{
	private Calendar startDate;
	private Calendar endDate;

	
	public Duration(String identification) {
		super(identification);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isSet_startDate(){
		return this.getStartDate() != null;
	}
	
	public boolean isSet_endDate(){
		return this.getEndDate() != null;
	}
	
	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

	public Calendar getEndDate() {
		return endDate;
	}



	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}



	public Calendar getStartDate() {
		return startDate;
	}



	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}
}
