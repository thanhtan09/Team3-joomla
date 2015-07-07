package Databases;

import java.util.Calendar;

public class Banner {

	String name;
	String category;
	String client;
	
	public Banner(){
		this.name="";
		this.category="";
		this.client="";
	};
	
	//Set name
	public void setName(String name){
		Calendar now = Calendar.getInstance();
		int day = now.get(Calendar.DAY_OF_MONTH);
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		String newname = "1"+day+hour+minute+second+"-"+name;
		this.name = newname;
	}
	
	//Get name
	public String getName(){
		return name;
	}
	
	//Set category
	public void setCategory(String cate){
		this.category = cate;
	}
	
	//Get category
	public String getCategory(){
		return category;
	}
	
	//Set client
	public void setClient(String client){
		this.client = client;
	}
	
	//Get client
	public String getClient(){
		return client;
	}
}
