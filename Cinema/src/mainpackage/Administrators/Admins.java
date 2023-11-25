package mainpackage.Administrators;
import mainpackage.FileManager.*;

import java.util.ArrayList;
import mainpackage.implementation.Mainclass;
import mainpackage.moviecatalog.Films;
import mainpackage.Clients.*;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class Admins extends Users implements Serializable{
	

	public void createUser(String name , String Username , String password) //ΔΙΑΔΙΚΑΣΙΑ ΔΗΜΙΟΥΡΓΙΑΣ USER
	{/*PAIRNW ΤΟ FILE ΜΕ ΤΑ USER KAI KANW INSERT TON USER*/
		boolean var = false;
		for(Users user:Mainclass.users) 
		{
			if ( user.getUsername().equalsIgnoreCase(Username)) 
			{
				var = true;
			}	
		}
		if(!var)
		{
		Users user = new Users(name,Username,password);
		Mainclass.users.add(user);
		FileManager.CreateFileUser(user.getUsername(), user);
		//Return true = ΠΕΤΥΧΕ Η ΔΗΜΙΟΥΡΓΙΑ
		}else {System.out.println("Μή διαθέσιμο username! Προσπαθήστε ξανά.");}// Return false = ΑΠΕΤΥΧΕ Η ΔΗΜΙΟΥΡΓΙΑ
	}
	public void updateUser(String oldusername,String name, String username , String password) //ΔΙΑΔΙΚΑΣΙΑ ΑΝΑΝΕΩΣΗΣ USER ΑΠΟ ΟΤΙ ΑΡΧΕΙΟ ΒΡΙΣΚΕΤΑΙ 
	{//ΠΑΙΡΝΩ ΤΟ FILE ΜΕ ΤΟΥΣ USERS ΚΑΙ ΚΑΝΩ UPDATE ΤΟΝ USER ME ΠΟΝΤΙΑΚΟ ΤΡΟΠΟ
		boolean var1 =false;
		boolean var2 =false;
		boolean var3 =false;
		boolean var4 =false;
		
		for(Users user:Mainclass.users)  //ΕΛΕΓΧΩ ΑΝ ΕΙΝΑΙ USER
		{
			if ( user.getUsername().equalsIgnoreCase(oldusername)) 
			{
			    var1=true;
			}	
		}
		for(Admins admin:Mainclass.admins) //ΕΛΕΓΧΩ ΑΝ ΕΙΝΑΙ ADMIN
		{
			if ( admin.getUsername().equalsIgnoreCase(oldusername)) 
			{
			    var2=true;
			}	
		}
		for(ContentAdmins contentadmin:Mainclass.contentadmins) //ΕΛΕΓΧΩ ΑΝ ΕΙΝΑΙ CONTENTADMIN
		{
			if ( contentadmin.getUsername().equalsIgnoreCase(oldusername)) 
			{
			    var3=true;
			}	
		}
		for(Customers customer:Mainclass.customers) //ΕΛΕΓΧΩ ΑΝ ΕΙΝΑΙ CUSTOMER
		{
			if ( customer.getUsername().equalsIgnoreCase(oldusername)) 
			{
			    var4=true;
			}	
		}
		
		 //AFTER CHANGES
		 if(var1) {deleteUser(oldusername, false);createUser(name,username,password);}
		 if(var2) 
		 {	
			 Admins old = (Admins) FileManager.findUser(oldusername, new Admins("","",""));
			 Admins admin = new Admins(name,username,password);
			 FileManager.CreateFileAdmins(username,admin);
			 Mainclass.admins.add(admin);
			 Mainclass.admins.remove(old);	 
		 }
		 if(var3)
		 {
			 ContentAdmins old = (ContentAdmins) FileManager.findUser(oldusername, new ContentAdmins("","",""));
			 ContentAdmins contentadmin = new ContentAdmins(name,username,password);
			 FileManager.CreateFileContentAdmins(username,contentadmin);
			 Mainclass.contentadmins.add(contentadmin);
			 Mainclass.contentadmins.remove(old);
		 
			 
		 }
		 if(var4)
		 {
			 Customers old = (Customers) FileManager.findUser(oldusername, new Customers("", "", "", new ArrayList<>()));
			 Customers customer = new Customers(name,username,password, old.getReservList());
			 FileManager.CreateFileCustomers(username,customer);
			 Mainclass.customers.add(customer);
			 Mainclass.customers.remove(old);
			 
			
		 }
		 if(!var1) {System.out.println("ERROR! Δεν βρέθηκε ο χρήστης!!!");}// ΔΕΝ ΥΠΑΡΧΕΙ Ο USER ΠΟΥ ΘΕΛΩ ΝΑ ΚΑΝΩ UPDATE
		 

		
	}
	public void deleteUser(String user_username, boolean delete)
	{// ΣΚΑΝΑΡΩ ΟΛΑ ΤΑ FILES ΠΟΥ ΜΠΟΡΕΙ ΝΑ ΕΙΝΑΙ ΚΑΤΑΧΩΡΗΜΕΝΟΣ , ΑΝ ΤΟΝ ΒΡΩ ΤΟΝ ΔΙΑΓΡΑΦΩ 
		
		File file = new File("USERS/"+ user_username + ".txt");
		if(file.exists()) 
		{
			file.delete();
		

			Users user = (Users) FileManager.findUser(user_username, new Users("", "", "")); // ΔΙΑΔΙΚΑΣΙΑ ΩΣΤΕ ΝΑ ΤΟΝ ΠΕΤΑΞΩ ΑΠΟ ΤΗΝ ΛΙΣΤΑ ΑΦΟΥ ΔΙΑΓΡΑΦΕΙ
			
			if(user != null) {
				if(delete) {
				Mainclass.users.remove(user);
				}
			}
			
			
			
			
		}
		else {System.out.println("Ο χρήστης δεν βρέθηκε!!!");}
		
		
		
		//TWRA GIA ADMINS
		File file2 = new File("Admins/"+ user_username + ".txt");
		if(file2.exists()) 
		{
			file2.delete();
			Admins admin = (Admins) FileManager.findUser(user_username, new Admins("", "", ""));	// ΔΙΑΔΙΚΑΣΙΑ ΩΣΤΕ ΝΑ ΤΟΝ ΠΕΤΑΞΩ ΑΠΟ ΤΗΝ ΛΙΣΤΑ ΑΦΟΥ ΔΙΑΓΡΑΦΕΙ
			if(admin != null) {
				if(delete) {
					Mainclass.admins.remove(admin);
				}
			}
			
		}
		
		//TWRA GIA CUSTOMERS
		File file3 = new File("Customers/"+ user_username + ".txt");
		if(file3.exists()) 
		{
			file3.delete();
			Customers customer = (Customers) FileManager.findUser(user_username,new Customers("","","", new ArrayList<>()));// ΔΙΑΔΙΚΑΣΙΑ ΩΣΤΕ ΝΑ ΤΟΝ ΠΕΤΑΞΩ ΑΠΟ ΤΗΝ ΛΙΣΤΑ ΑΦΟΥ ΔΙΑΓΡΑΦΕΙ
			if(customer != null) {
			if(delete) {
			Mainclass.customers.remove(customer);
			}
			}


			
			
		}
		
		//TWRA GIA CONTENT ADMINS
		File file4 = new File("ContentAdmins/"+ user_username + ".txt");
		if(file4.exists()) 
		{
			file4.delete();
			ContentAdmins contentadmin = (ContentAdmins)FileManager.findUser(user_username,new ContentAdmins("","",""));// ΔΙΑΔΙΚΑΣΙΑ ΩΣΤΕ ΝΑ ΤΟΝ ΠΕΤΑΞΩ ΑΠΟ ΤΗΝ ΛΙΣΤΑ ΑΦΟΥ ΔΙΑΓΡΑΦΕΙ
			if(contentadmin != null) {
			if(delete) {
			Mainclass.contentadmins.remove(contentadmin);
			}
			}

			
		}
		
	}
    public void searchUser(String user_username) // ΔΙΑΔΙΚΑΣΙΑ ΩΣΤΕ ΝΑ ΒΡΩ ΤΑ ΣΤΟΙΧΕΙΑ ΤΟΥ USER ΜΕ ΤΟ USERNAME ΠΟΥ ΔΙΝΩ ΩΣ ΠΑΡΑΜΕΤΡΟ
	{/*ΠΑΙΡΝΩ ΤΟ FILE ΜΕ ΤΑ USER KAI KANΩ SEARCH TON USER*/
		File file = new File("USERS/"+ user_username + ".txt");
		if(file.exists()) 
		{  
			for(Users user:Mainclass.users) 
			{
				if ( user.getUsername().equalsIgnoreCase(user_username)) 
				{
					System.out.println("Name:"+user.getName());
					System.out.println("Username:"+user.getPassword());
					System.out.println("Password:"+user.getUsername());	
				}	
			}
		}
		else {System.out.println("Ο χρήστης δεν βρέθηκε!!!");}
		
		
	}
	public void viewAllUsers()
	{/* ΣΚΑΝΑΡΩ ΟΛΟ ΤΟ HASHSET ΜΕ ΤΑ USER ΠΟΥ ΕΧΩ ΣΤΗ MAINCLASS*/
		
		for(Users user:Mainclass.users) 
		{
			System.out.println("Name:"+user.getName()+",Username:"+user.getUsername()+",Password:"+user.getPassword()+ "\n");
				
		}
		
		
	}
	public void registerAdmin(String user_username) // ΔΙΑΔΙΚΑΣΙΑ ΩΣΤΕ ΝΑ ΚΑΝΩ ΕΝΑΝ USER ADMIN
	{
		boolean flag= false;
		String onoma = "";
		String paratsoukli="";
		String kwdikos="";
		for(Users user:Mainclass.users) 
		{
			if ( user.getUsername().equalsIgnoreCase(user_username)) 
			{
				 onoma = user.getName();
				 paratsoukli = user.getUsername();
				 kwdikos = user.getPassword();
				 flag = true;
			}	
		}
		if(flag) // ΕΑΝ Ο ΧΡΗΣΤΗΣ ΕΙΝΑΙ ΗΔΗ ΕΓΓΕΓΡΑΜΜΕΝΟΣ ΤΟΤΕ ΚΑΝΤΟΝ ADMIN 
		{
		deleteUser(user_username, true);
		Users atomo = new Users(onoma,paratsoukli,kwdikos);
		Admins atomo1 = new Admins(onoma,paratsoukli,kwdikos);
		
		FileManager.CreateFileUser(atomo.getName(), atomo);
		Mainclass.users.add(atomo);
		FileManager.CreateFileAdmins(atomo1.getName(), atomo1);
		Mainclass.admins.add(atomo1);
		}else {System.out.println("ERROR!Δεν βρέθηκε ο χρήστης!");}
	}
    
	
	
	public Admins(String name,String username,String password) {super(name,username,password);} // CONSTRUCTOR

	
	

}
