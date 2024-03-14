package dto;

public class Expense {
	String User_id;
	double amount;

	public String getUser_id(){
		return User_id;
	}

	public void setUser_id(String user_id){
		this.User_id = user_id;
	}

	public double getAmount(){
		return amount;
	}

	public void setAmount(double amount){
		this.amount = amount;
	}

	public Expense(String User_id, double amount){
		this.User_id = getUser_id();
		this.amount = getAmount();
	}

}
