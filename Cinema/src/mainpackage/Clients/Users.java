package mainpackage.Clients;
import java.io.Serializable;

public class Users implements Serializable {

	private String name;
	private String username;
	private String password;
	
	//ΠΡΟΣ ΥΛΟΠΟΙΗΣΗ
	public void login(String username){ System.out.println(" Καλώς όρισες "+username+" !" );   }
	public void logout(){  System.out.println(" Αποσυνδεθήκατε επιτυχώς ! ") ; System.exit(0);  }
	
	
	public Users(String name,String username,String password) {this.name=name;this.username=username;this.password=password;} //CONSTRUCTOR
	
	
	public String getName() {return this.name;}
	public String getUsername() {return this.username;}
	public String getPassword() {return this.password;}
	public void setName(String name) {this.name = name; }
	public void setUsername(String username) {this.username = username;}
	public void setPassword(String password) {this.password = password;}	
}
