package com.paxdron.testdcti.model;


/**
 * Created by Antonio on 22/02/2017.
 */

public class AnimalTable extends Animal {
	private boolean selected;

	public boolean isSelected() {
		return selected;
	}

	public AnimalTable(int id,String naabCode, String name, String regName, String code, float price, boolean gender, String breed) {
		super(id, naabCode, name, regName, code, price, gender, breed);
		this.selected = selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
