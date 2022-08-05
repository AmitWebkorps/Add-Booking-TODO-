package Booking;
import java.util.regex.*;
public class Client {
      private String name;
      private int age;
      private String email;
	public Client(String name, int age, String email){
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		checkEmail();	
	  }
	@Override
	public String toString() {
		return "[name=" + name + ", age=" + age + ", email=" + email + "]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public boolean equals(Object o)
	{
		Client c=(Client)o;
		if(name==c.name)
		   return true;
		return false;
	}
	
	public boolean checkEmail()
	{
		String s1="^([\\w]*[\\w\\.]*(?!\\.)@gmail.com)";
		Pattern p = Pattern.compile(s1);
		Matcher m=p.matcher(email);
		if(!m.matches())
			throw new InvalidEmailException("email not valid");
		return true;
	}
    
}
