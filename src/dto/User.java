package dto;

import java.util.Map;

public class User {
	String name;
	String email;
	String mobileNumber;

	//to maintain the Expense of the map
	Map<String,Expense> lendToMap;


	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getMobileNumber(){
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber){
		this.mobileNumber = mobileNumber;
	}

	public Map<String,Expense> getLendToMap(){
		return lendToMap;
	}

	public void setLendToMap(Map<String,Expense> lendToMap){
		this.lendToMap = lendToMap;
	}

	public User(String name, Map<String,Expense> lendToMap){
		this.name = name;
		this.lendToMap = lendToMap;
	}

}
