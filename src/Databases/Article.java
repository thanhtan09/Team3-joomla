package Databases;

import java.util.Calendar;

public class Article {

	String title;
	String catetory;
	String status;
	String content;
	String image;
	
	public Article(){
		this.title="";
		this.catetory="";
		this.status="";
		this.content="";
		this.image="";
	};
	
	//Set title
	public void setTitle(String _title){
		Calendar now = Calendar.getInstance();
		int day = now.get(Calendar.DAY_OF_MONTH);
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		String newTitle = "1"+day+hour+minute+second+"-"+_title;
		this.title = newTitle;
	}
	
	//Get title
	public String getTitle(){
		return title;
	}
	
	//Set category
	public void setCategory(String _cate){
		this.catetory = _cate;
	}
	
	//Get category
	public String getCategory(){
		return catetory;
	}
	
	//Set status
	public void setStatus(String _status){
		this.status = _status;
	}
	//Get status
	public String getStatus(){
		return status;
	}
	//Set content
	public void setContent(String _content){
		this.content = _content;
	}
	//Get content
	public String getContent(){
		return content;
	}
	
	//Set image
	public void setImage(String _image){
		this.image = _image;
	}
	
	//Get image
	public String getImage(){
		return image;
	}
}
