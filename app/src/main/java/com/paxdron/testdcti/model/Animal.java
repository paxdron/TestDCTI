package com.paxdron.testdcti.model;

/**
 * Created by Antonio on 22/02/2017.
 */

public abstract class Animal {
	private int Id;
	private String NaabCode;
	private String Name;
	private String RegName;
	private String Code;
	private float Price;
	private boolean Gender;
	private String Breed;

	Animal(int id, String naabCode, String name, String regName, String code, float price, boolean gender, String breed) {
		Id=id;
		NaabCode = naabCode;
		Name = name;
		RegName = regName;
		Code = code;
		Price = price;
		Gender = gender;
		Breed = breed;
	}

	//<editor-fold desc="GETTERS">

	public int getId() {
		return Id;
	}

	public String getNaabCode() {
		return NaabCode;
	}

	public String getName() {
		return Name;
	}

	public String getRegName() {
		return RegName;
	}

	public String getCode() {
		return Code;
	}

	public float getPrice() {
		return Price;
	}

	public boolean isGender() {
		return Gender;
	}

	public String getBreed() {
		return Breed;
	}
	//</editor-fold>
}
