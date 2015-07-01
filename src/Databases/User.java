package Databases;

public class User {

	String username;
	String password;
	public User(){
		this.username="";
		this.password="";
	};
	
	//Set username
	public void setUsername(String _user){
		this.username = _user;
	}
	
	//Get username
	public String getUsername(){
		return username;
	}
	
	//Set password
	public void setPassword(String _pass){
		this.password = _pass;
	}
	
	//Get password
	public String getPassword(){
		return password;
	}
}
