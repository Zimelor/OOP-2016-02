package data;
  

import java.util.ArrayList;
import java.util.List;

public class Contact{
  
  private String name;
  private String lastName;
  private List<String> emails;
  private int phone;
  private long cellPhone;
  private String direction;
  
  private static final int countDigits(int num){
    int count = 0;
    while(num > 0){
    	count++;
      	num/=10;
    }
    return count;
  }
  
   private static final int countDigits(long num){
    int count = 0;
    while(num > 0){
    	count++;
      	num/=10;
    }
     return count;
  }
  
  private static boolean isValidName(String name){
    int len = name.length();
    boolean foo = true;
    if( len < 3 || len > 10){
    	return false;
    }
    if(name.matches(".*\\d+.*")){
    	return false;
    }
    return true;
  }
  
  public Contact(String newName, String newLastName, String newEmail, int newPhone, long cellPhone, String newDirection){
   this.setName(newName); 
   this.setLastName(newLastName); 
   this.emails = new ArrayList<>();
   this.addEmail(newEmail); 
   this.setPhone(newPhone);
   this.setCellPhone(cellPhone);
   this.setDirection(newDirection);
  
  }
	
  public final void setName(String newName){
    if(!isValidName(newName)){
    	throw new IllegalArgumentException();
    }
  	this.name = newName;
  }
  
  
  public final void setLastName(String newLastName){
    if(!isValidName(newLastName)){
    	throw new IllegalArgumentException();
    }
  	this.lastName = newLastName;
  }
  
  public final void addEmail(String newEmail){
    if(newEmail.matches("^\\w\\@(\\w.\\w)+")){ 
      this.emails.add(newEmail);}
    else{
    	throw new IllegalArgumentException();
    }
  }
  
  public final void setPhone(int newPhone){
    if((newPhone < 0) || countDigits(newPhone)!= 7){
    	throw new IllegalArgumentException();
    }
  	this.phone = newPhone;
  }
  
  public final void setCellPhone(long newCellPhone){
  	if((newCellPhone < 0) || countDigits(newCellPhone) != 10){
    	throw new IllegalArgumentException();
    }
    this.cellPhone = newCellPhone;
  }
  
  public final void  setDirection(String newDirection){
    if(newDirection.length()< 10 ||  newDirection.length()>30){
    	throw new IllegalArgumentException();
    }
    this.direction = newDirection;
  }

}
