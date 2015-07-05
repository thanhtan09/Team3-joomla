package Databases;

import java.util.Calendar;

public class Client {

	String name;
	String contact;
	String email;
	String status;
	
	public Client(){
		this.name = "";
		this.contact = "";
		this.email = "";
		this.status = "";
	};
	
	//Set title
	public void setName(String name){
		Calendar now = Calendar.getInstance();
		int day = now.get(Calendar.DAY_OF_MONTH);
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		String newName = "1"+day+hour+minute+second+"-"+name;
		this.name = newName;
	}
	
	//Get name
	public String getName(){
		return name;
	}
	
	//Set Contact
	public void setContact(String contact){
		this.contact = contact;
	}
	
	//Get Contact
	public String getContact(){
		return contact;
	}
	
	//Set status
	public void setStatus(String status){
		this.status = status;
	}
	
	//Get status
	public String getStatus(){
		return status;
	}
	
	//Set email
	public void setEmail(String email){
		this.email = email;
	}
	
	//Get email
	public String getEmail(){
		return email;
	}
}
