package mainpackage.implementation;

import java.util.HashSet;
import java.util.List;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Set;
import java.util.Scanner;


import mainpackage.Administrators.*;
import mainpackage.Clients.*;
import mainpackage.FileManager.FileManager;
import mainpackage.moviecatalog.*;
import mainpackage.ExtraHelp.*;

public class Mainclass {
	
	
	//ΔΗΜΙΟΥΡΓΩ ΤΙΣ ΛΙΣΤΕΣ ΜΕ ΤΑ ΔΕΔΟΜΕΝΑ
	
	public static Set<Users> users =new HashSet<>();
	public static Set<Customers> customers = new HashSet<>();
	public static Set<Admins> admins  = new HashSet<>();
	public static Set<ContentAdmins> contentadmins  = new HashSet<>();
	public static Set<Provoles> provoles  = new HashSet<>();
	public static Set<Films> films  = new HashSet<>();
	public static Set<Cinemas> cinema  = new HashSet<>();
	
	public static LocalDateTime getDateTime(String value) { //ΚΑΝΩ ΦΟΡΜΑΤ ΤΗΝ DATETIME ΜΕΤΑΒΛΗΤΗ
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
        return LocalDateTime.parse(value, formatter);
	}
	
	public static void main(String[] args) throws Exception {
	
	FileManager.StarterLoad(); // ΦΟΡΤΩΝΩ ΟΛΑ ΤΑ ΔΕΔΟΜΕΝΑ ΣΤΙΣ ΛΙΣΤΕΣ 
	boolean flag2;
	boolean lathosStoixeiaStoLogin;
	Scanner scanner = new Scanner(System.in);
	do {
		lathosStoixeiaStoLogin = false;
		flag2=false;
	System.out.println("Επιλέξτε ενέργεια γράφοντας τον αριθμό που θέλετε:1.Login 2.Signup 3.Quit ");
	String input = scanner.nextLine();
	if(input .equalsIgnoreCase("2")) {//ΕΔΩ ΚΑΝΕΙ ΕΓΓΡΑΦΗ!!!!!!!!
		Scanner sc2 = new Scanner(System.in);
		 System.out.println("Πραγματοποίηση εγγραφής ");
		 boolean lathosepilogh;
		 do {
			 lathosepilogh=false;
		 System.out.println("Που θα θελατε να εγγραφείτε;Γράψτε τον αριθμό που θέλετε: 1.Customers 2.Admins 3.ContentAdmins");
		 String Num = scanner.nextLine();
		 if(Num.equalsIgnoreCase("1") ) { //ΘΕΛΕΙ ΝΑ ΓΡΑΦΤΕΙ ΩΣ CUSTOMER
		 System.out.println("Γράψτε το ονομα σας: ");
		 String Name = sc2.nextLine(); 
		 boolean flag;
		 String userName="";
		 
		do {
			 flag=false;
			 System.out.println("Γραψτε το username σας: ");
			  userName = sc2.nextLine(); 
			 for(Users user:users) 
			 {
				if(user.getUsername().equalsIgnoreCase(userName)) {flag=true;System.out.println("Το username δεν είναι διαθέσιμο!Προσπάθησε πάλι ");} //ΚΑΝΩ ΕΛΕΓΧΟ ΓΙΑ ΝΑ ΔΩ ΑΝ ΕΙΝΑΙ ΜΟΝΑΔΙΚΟ Η ΟΧΙ ΤΟ USERNAME
			 }
		 }while(flag);
		 System.out.println("Γραψτε το password σας: ");
		 String password = sc2.nextLine(); //ΕΔΩ ΤΕΛΕΙΩΝΕΙ Η ΕΓΓΡΑΦΗ!!!!!!!!
		 
		 Users user = new Users(Name,userName,password);
		 users.add(user);
		 FileManager.CreateFileUser(userName, user);
		 
		 Customers customer = new Customers(Name,userName,password, new ArrayList<>());
		 customers.add(customer);
		 FileManager.CreateFileCustomers(userName, customer);
		 System.out.println("Επιτυχής εγγραφή!!! ");
		 }
		 else if(Num.equalsIgnoreCase("2")) {//ΘΕΛΕΙ ΝΑ ΓΡΑΦΤΕΙ ΩΣ ADMIN
			 System.out.println("Γράψτε το ονομα σας: ");
			 String Name = sc2.nextLine(); 
			 boolean flag;
			 String userName;
			do {
				 flag=false;
				 System.out.println("Γραψτε το username σας: ");
				  userName = sc2.nextLine(); 
				 for(Users user:users) 
				 {
					if(user.getUsername().equalsIgnoreCase(userName)) {flag=true;System.out.println("Το username δεν είναι διαθέσιμο!Προσπάθησε πάλι ");} 
				 }
			
			 }while(flag);
			 System.out.println("Γραψτε το password σας: ");
			 String password = sc2.nextLine(); 
			 
			 Users user = new Users(Name,userName,password);
			 users.add(user);
			 FileManager.CreateFileUser(userName, user);
			 
			 Admins admin = new Admins(Name,userName,password);
			 admins.add(admin);
			 FileManager.CreateFileAdmins(userName, admin);
			 System.out.println("Επιτυχής εγγραφή!!! ");
			 }
		 else if(Num.equalsIgnoreCase("3")) {//ΘΕΛΕΙ ΝΑ ΓΡΑΦΤΕΙ ΩΣ CONTENTADMIN
			 System.out.println("Γράψτε το ονομα σας: ");
			 String Name = sc2.nextLine(); 
			 boolean flag;
			 String userName;
			do {
				 flag=false;
				 System.out.println("Γραψτε το username σας: ");
				  userName = sc2.nextLine(); 
				 for(Users user:users) 
				 {
					if(user.getUsername().equalsIgnoreCase(userName)) {flag=true;System.out.println("Το username δεν είναι διαθέσιμο!Προσπάθησε πάλι ");} 
				 }
			
			 }while(flag);
			 System.out.println("Γραψτε το password σας: ");
			 String password = sc2.nextLine(); 
			 
			 Users user = new Users(Name,userName,password);
			 users.add(user);
			 FileManager.CreateFileUser(userName, user);
			 
			 ContentAdmins contentadmin = new ContentAdmins(Name,userName,password);
			 contentadmins.add(contentadmin);
			 FileManager.CreateFileContentAdmins(userName, contentadmin);
			 System.out.println("Επιτυχής εγγραφή!!! ");
			 }else {System.out.println("Μή έγκυρη επιλογή ! Προσπαθήστε ξανά. "); lathosepilogh = true;}
		 }while(lathosepilogh);
		 
	
		
		 
		}if(input .equalsIgnoreCase("1") || input .equalsIgnoreCase("2") ) //ΠΑΕΙ ΝΑ ΠΕΙ ΟΤΙ ΕΧΕΙ ΚΑΝΕΙ ΗΔΗ ΕΓΓΡΑΦΗ ΑΡΑ ΚΑΝΕΙ LOGIN
		{	Scanner sc3 = new Scanner(System.in);
		 	System.out.println("Παρακαλώ συνδεθείτε ");
			System.out.println("Name: ");
			String Name = sc3.nextLine();
			System.out.println("Username : ");
			String username = sc3.nextLine();			
			System.out.println("Password : ");
			String password = sc3.nextLine();
			Users randomuser = new Users(null, null, null) ;
			
			//ΨΑΧΝΩ ΤΑ ΑΡΧΕΙΑ ΝΑ ΔΩ ΑΝ ΕΙΝΑΙ CUSTOMER ADMIN CONTENTADMIN ΚΑΙ ΤΟΥ ΒΓΑΖΩ ΤΟ ΚΑΤΑΛΛΗΛΟ ΜΕΝΟΥ
			if(FileManager.UserIsCustomer(Name,username,password)) // ΠΑΕΙ ΝΑ ΠΕΙ ΟΤΙ ΕΙΝΑΙ ΕΓΓΕΓΡΑΜΜΕΝΟΣ ΩΣ CUSTOMER
			{	randomuser.login(username);
				
				//ΜΕΝΟΥ ΤΟΥ CUSTOMER
				 Customers customer = (Customers) FileManager.deserialize("Customers/"+username);
				 // Debug
				
				boolean fl ;
				boolean run;
				
				do {
					run=false;
					fl=false;
					
					 
				System.out.println("Παρακαλώ επιλέξτε ενέργεια γράφοντας τον αριθμό που θέλετε 1.Εμφάνιση διαθέσιμων Προβολών 2.Υποβολή κράτησης 3.Προβολή κράτησης 4.Αποσύνδεση");
				String num = sc3.nextLine();
				
				if(num.equalsIgnoreCase("1")) 
				{  
				     customer.ShowAvailableFilms();
					
				}
				
				
				else if(num.equalsIgnoreCase("2")) 
				{	Provoles wantedprov = null;
				
					System.out.println(" Εισάγετε το ID Προβολής που επιθυμείτε: ");
					
					int provoliid = new Scanner(System.in).nextInt();
					
					
					//KANW SCAN TO SET ME TIS PROBOLES KAI PAIRNW TO OBJ POU EPILEKSE
					for(Provoles provoli:provoles) 
					{	 
						if(provoli.getProvoliID() == provoliid) 
						{   
							wantedprov = provoli;	
						}
						
					}
					if(wantedprov!=null) {		// ΥΠΑΡΧΕΙ Η ΠΡΟΒΟΛΗ ΠΟΥ ΔΙΑΛΕΞΕ		
					System.out.println("Εισάγετε Αριθμό Θέσεων για κράτηση : ");
					int numofpos = sc3.nextInt();					
					customer.makeReservation( wantedprov , numofpos);//ΕΔΩ ΓΙΝΕΤΕ Η ΚΡΑΤΗΣΗ, ΜΕΣΑ ΣΤΗ ΣΥΝΑΡΤΗΣΗ ΓΙΝΕΤΕ ΕΛΕΓΧΟΣ ΑΝ ΜΠΟΡΕΙ ΝΑ ΓΙΝΕΙ Η ΚΡΑΤΗΣΗ Η ΟΧΙ
					
					
					
					}
					else { System.out.println("Λάθος ID προσπάθησε ξανά : ");} // WANTEDPROV=NULL ΣΗΜΑΙΝΕΙ ΔΕΝ ΒΡΕΘΗΚΕ ΤΟ ID ΠΟΥ ΕΒΑΛΕ ΑΡΑ ΔΕΝ ΥΠΑΡΧΕΙ Η ΠΡΟΒΟΛΗ
					
				}
				
				
				else if(num.equalsIgnoreCase("3")) 
				{
					customer.viewReservation();
					
				}
				
				else if(num.equalsIgnoreCase("4")) { run=true; customer.logout();  } 
				else {System.out.println("Λάθος επιλογή προσπάθησε πάλι!");  };
				}while(!run);
				
				
			}
			else if(FileManager.UserIsAdmin(Name,username,password)) // ΠΑΕΙ ΝΑ ΠΕΙ ΟΤΙ ΕΙΝΑΙ ΕΓΓΕΓΡΑΜΜΕΝΟΣ ΩΣ ADMIN
			{	
				//MENOY TOY ADMIN
				randomuser.login(username);
				Admins admin = new Admins(Name,username,password);
				boolean lathosarithmos;	
				boolean bgaltemeekso;
					
				do {
					lathosarithmos=false;
					bgaltemeekso = false;
				System.out.println("Παρακαλώ επιλέξτε ενέργεια γράφοντας τον αριθμό που θέλετε : \n1.Δημιουργία νέου Χρήστη \n2.Διαγραφή εγγεγραμμένου χρήστη \n3.Ενημέρωση πληροφοριών εγγεγραμμένου χρήστη \n4.Εύρεση εγγεγραμμένου χρήστη \n5.Προβολή όλων των χρηστών \n6.Προσθήκη ρόλου Διαχειριστή σε εναν ήδη εγγεγραμμένου χρήστη\n7.Αποσύνδεση");
				String num = sc3.nextLine();
				if(num.equalsIgnoreCase("1"))
				{
					String onoma;
					String pseudonimo;
					String kwdikos;
					
					System.out.println("Παρακαλώ εισάγετε τις πληροφορίες χρήστη :\n1.Name:");
					 onoma = sc3.nextLine();
				    boolean flag;
					System.out.println(" Username: ");//ΤΥΧΟΝ ΕΛΕΓΧΟΙ ΠΡΑΓΜΑΤΟΠΟΙΟΥΝΤΑΙ ΣΤΗ ΣΥΝΑΡΤΗΣΗ CREATEUSER!!!
					 pseudonimo = sc3.nextLine();
					System.out.println("Password: ");
					 kwdikos = sc3.nextLine();
					admin.createUser(onoma, pseudonimo, kwdikos);
					
					
				}
				else if(num.equalsIgnoreCase("2"))
				{
					System.out.println("Παρακαλώ εισάγετε τo username του χρήστη που θέλετε να διαγράψετε :");
					String pseudonimo = sc3.nextLine();
					admin.deleteUser(pseudonimo,true);
					
				}
				else if(num.equalsIgnoreCase("3"))
				{
					System.out.println("Παρακαλώ εισάγετε τo username του χρήστη που θέλετε να τροποποιήσετε :");
					String oldpseudonimo = sc3.nextLine();
					System.out.println(" Εισάγετε τις τροποποιήσεις :");
					System.out.println("Name:");
					String onoma = sc3.nextLine();
					System.out.println("Username: ");
					String pseudonimo = sc3.nextLine();
					System.out.println("Password: ");
					String kwdikos = sc3.nextLine();
					admin.updateUser(oldpseudonimo, onoma, pseudonimo, kwdikos);
					
				}
				else if(num.equalsIgnoreCase("4")) 
				{
					System.out.println("Παρακαλώ εισάγετε τo username του χρήστη που θέλετε να βρείτε :");
					String pseudonimo = sc3.nextLine();
					admin.searchUser(pseudonimo);
					
					
					
				}
				else if(num.equalsIgnoreCase("5"))
				{
					admin.viewAllUsers();
				
				}
				else if(num.equalsIgnoreCase("6"))
				{
					System.out.println("Παρακαλώ εισάγετε τo username του χρήστη που θέλετε να κάνετε διαχειριστή :");
					String pseudonimo = sc3.nextLine();
					admin.registerAdmin(pseudonimo);
					
					
				}else if(num.equalsIgnoreCase("7")) {bgaltemeekso=true; admin.logout();}
				else {System.out.println("Λάθος επιλογή προσπάθησε πάλι!");Thread.sleep(1500);lathosarithmos=true;}
				}while(lathosarithmos || !bgaltemeekso ); // ΚΑΝΩ BOOLEAN ΤΙΣ ΣΥΝΑΡΤΗΣΕΙΣ ΤΟΥ ADMIN
										
				
				
				
			
				
			}
			else if (FileManager.UserIsContentAdmin(Name,username,password)) // ΠΑΕΙ ΝΑ ΠΕΙ ΟΤΙ ΕΙΝΑΙ ΕΓΓΕΓΡΑΜΜΕΝΟΣ ΩΣ CONTENTADMIN
			{
				//MENOU TOY CONTENTADMIN
				randomuser.login(username);
				ContentAdmins contentadmin = new ContentAdmins(Name,username,password);
				boolean lathosarithmos;
				boolean bgaltemeekso;
				do {
					lathosarithmos=false;
					bgaltemeekso = false;
				System.out.println("Παρακαλώ επιλέξτε ενέργεια γράφοντας τον αριθμό που θέλετε : \n1.Εισαγωγή ταινίας \n2.Διαγραφή ταινίας \n3.Δημιουργία Προβολής \n4.Εισαγωγή Αίθουσας \n5.Αποσύνδεση");
				
				String num = sc3.nextLine();
				if(num.equalsIgnoreCase("1"))
				{  
					System.out.println("Εισάγετε το τίτλο της ταινίας:");
					String filmtitle = sc3.nextLine();
					
					boolean notparsed;
					int filmidparsed = 0;
					boolean notuniqueid;
					do {
						notuniqueid = false;
					do {
						notparsed = false;
						System.out.println("Εισάγετε το ID της ταινίας(εναν ακέραιο αριθμό):");
						String filmid = sc3.nextLine();
					try {filmidparsed = Integer.parseInt(filmid);}
					catch(Exception e) {System.out.println("Λάθος ID, εισάγετε αριθμό!"); notparsed = true;}
					}while(notparsed);
					 for(Films movie:films) 
					 {
						if(movie.getFilmId()==filmidparsed) {notuniqueid=true;System.out.println("Το Film ID δεν είναι διαθέσιμο!Προσπάθησε πάλι ");} 
					 }
					}while(notuniqueid);
					 
					System.out.println("Εισάγετε τη κατηγορία της ταινίας:");
					String filmcategory = sc3.nextLine();
					System.out.println("Εισάγετε τη περιγραφή της ταινίας:");
					String filmdescription = sc3.nextLine();
					Films film = new Films(filmidparsed,filmtitle,filmcategory,filmdescription);
					contentadmin.insertFilm(film);
					
				}
				else if(num.equalsIgnoreCase("2"))
				{	
					boolean notparsed;
					int filmidparsed = 0;
					do {
						notparsed = false;
						System.out.println("Εισάγετε το ID της ταινίας που θέλετε να διαγράψετε:");
						String filmid = sc3.nextLine();
						try {filmidparsed = Integer.parseInt(filmid);}
						catch(Exception e) {System.out.println("Λάθος ID!"); notparsed = true;}
					}while(notparsed);
					
					
					
						contentadmin.deleteFilm(filmidparsed,true);//ΚΑΝΩ ΕΛΕΓΧΟ ΑΝ ΥΠΑΡΧΕΙ ΤΑΙΝΙΑ ΜΕ ΑΥΤΟ ΤΟ ID
						
					
				}
				else if(num.equalsIgnoreCase("3")) 
				{
					LocalDateTime StartDate = null;
					LocalDateTime EndDate = null;
					
					System.out.println("Διαδικασία δημιουργείας προβολής!");
					boolean notparsed;
					int provoliIdparsed = 0;
					boolean notuniqueid;
					do {
						
						notuniqueid = false;
					do {
						notparsed = false;
						System.out.println("Εισάγετε το ID της προβολής(ακέραιος αριθμός):");
						String provoliId = sc3.nextLine();
					try {provoliIdparsed = Integer.parseInt(provoliId);}
					catch(Exception e) {System.out.println("Λάθος ID, εισάγετε αριθμό!"); notparsed = true;}
					}while(notparsed);
					 for(Provoles provoli:provoles) 
					 {
						if(provoli.getProvoliID()==provoliIdparsed) {notuniqueid=true;System.out.println("Το ID δεν είναι διαθέσιμο!Προσπάθησε πάλι ");} 
					 }
					}while(notuniqueid);
					
					
					

					// ΤΑ ΕΠΟΜΕΝΑ LOOPS ΕΛΕΓΧΟΥΝ ΑΝ ΜΠΕΙ ΣΩΣΤΟ INPUT ΩΣΤΕ ΝΑ ΓΙΝΟΥΝ HANDLE ΤΑ EXCEPTIONS
					boolean notparsed2;
					int filmidparsed = 0;
					do {
						notparsed2 = false;
						System.out.println("Εισάγετε το ID της ταινίας(εναν ακέραιο αριθμό):");
						String filmid = sc3.nextLine();
					try {filmidparsed = Integer.parseInt(filmid);}
					catch(Exception e) {System.out.println("Λάθος ID, εισάγετε αριθμό!"); notparsed2 = true;}
					}while(notparsed2);
					
					
					
					
					boolean notparsed3;
					int cinemaidparsed = 0;
					do {
						notparsed3=false;
						System.out.println("Εισάγετε το ID της αίθουσας(ακέραιος αριθμός):");
						String cinemaid=sc3.nextLine();
						try {cinemaidparsed = Integer.parseInt(cinemaid);}
						catch(Exception e) {System.out.println("Λάθος ID, εισάγετε αριθμό!"); notparsed3 = true;}
					}while(notparsed3);
					
					
					
					
					boolean wrongstartdate;
					do {
						wrongstartdate = false;
					System.out.println("Εισάγετε την ημερομηνία-ώρα που θα αρχίζει η προβολή( 10/04/23 21:00 ):  "); // ΑΝ ΓΡΑΦΤΕΙ ΜΕ ΑΛΛΟ ΤΡΟΠΟ ΠΕΤΑΕΙ ΕΡΡΟΡ
					String startdate = sc3.nextLine();
						try {StartDate=getDateTime(startdate);}
						catch(Exception e) {System.out.println("Λάθος ημερομηνία!Προσπάθησε ξανά.");wrongstartdate=true;}
					}while(wrongstartdate);
					
					
					boolean wrongendDate;
					do {
						wrongendDate = false;
						System.out.println("Εισάγετε την ώρα που θα τελειώνει η προβολή( 10/04/23 21:00 )::"); // ΑΝ ΓΡΑΦΤΕΙ ΜΕ ΑΛΛΟ ΤΡΟΠΟ ΠΕΤΑΕΙ ΕΡΡΟΡ
					String endDate = sc3.nextLine();
						try {EndDate=getDateTime(endDate);}
						catch(Exception e) {System.out.println("Λάθος ημερομηνία!Προσπάθησε ξανά.");wrongendDate=true;}
					}while(wrongendDate);
				
					
					
					Films movie =   FileManager.getFilm(filmidparsed);
					Cinemas room = FileManager.getCinema(cinemaidparsed);
					
					if( movie !=null && room!=null) 
					{
						Provoles provoli = new Provoles(provoliIdparsed, movie, room, StartDate, EndDate, 0 , true);
						contentadmin.assignFilmToCinema( provoli); 
				
					}
					
					
					
				}
				else if(num.equalsIgnoreCase("4")) 
				{
					boolean notparsed;
					int cinemaidparsed = 0;
					boolean notuniqueid;
					do {
						notuniqueid = false;
					do {
						notparsed = false;
						System.out.println("Εισάγετε το ID της αίθουσας(εναν ακέραιο αριθμό):");
						String cinemaid = sc3.nextLine();
					try {cinemaidparsed = Integer.parseInt(cinemaid);}
					catch(Exception e) {System.out.println("Λάθος ID, εισάγετε αριθμό!"); notparsed = true;}
					}while(notparsed);
					 for(Cinemas aithousa:cinema) 
					 {
						if(aithousa.getCinemaId()==cinemaidparsed) {notuniqueid=true;System.out.println("Το Cinema ID δεν είναι διαθέσιμο!Προσπάθησε πάλι ");} 
					 }
					}while(notuniqueid);
					
					
					boolean cinemais3d=false;
					boolean wronginput;
					do {
					wronginput = false;
					System.out.println("Εισάγετε αν είναι 3D η αίθουσα βάζοντας τον κατάλληλο αριθμό: 1.ΝΑΙ 2.ΟΧΙ ");
					String cinemais3dinput = sc3.nextLine();
					if(cinemais3dinput.equalsIgnoreCase("1")) {cinemais3d=true;}
					else if(cinemais3dinput.equalsIgnoreCase("2")) {cinemais3d=false;}
					else {System.out.println("Μή έγκυρη επιλογή! Προσπαθήστε ξανά ");wronginput=true;}
					}while(wronginput);
					
					
					boolean notparsed2;
					int cinemanumofseatsparsed = 0;
					do {
						notparsed2 = false;
						System.out.println("Εισάγετε τον αριθμό θέσεων της αίθουσας:");
						String cinemanumofseats = sc3.nextLine();
						try {cinemanumofseatsparsed = Integer.parseInt(cinemanumofseats);}
						catch(Exception e) {System.out.println("Λάθος!Εισάγετε αριθμό.  "); notparsed2 = true;}
					}while(notparsed2);
					
					Cinemas cinema = new Cinemas(cinemaidparsed,cinemais3d,cinemanumofseatsparsed);
					contentadmin.insertCinema(cinema);
				}
				
				
				
				else if(num.equalsIgnoreCase("5")) {bgaltemeekso=true; contentadmin.logout();}
				
				
				else {lathosarithmos=true;System.out.println("Λάθος επιλογή προσπάθησε πάλι!");Thread.sleep(1500);}
				
				}while(lathosarithmos || !bgaltemeekso);
				
				
				
				
				
				
				
				
				}else { System.out.println("Λάθος στοιχεία! Προσπάθησε ξανά "); lathosStoixeiaStoLogin = true; } // ΔΕΝ ΕΙΝΑΙ ΟΥΤΕ CUSTOM OYTE ADMIN OYTE CONTENTADMIN
			
			
			
		}if(input .equalsIgnoreCase("3")) { System.out.println(" Αποσυνδεθήκατε επιτυχώς ! ") ; return;  }   	
		else { System.out.println("Λαθος απάντηση προσπάθησε πάλι : ");flag2=true ;}//EXEI ΒΑΛΕΙ ΛΑΘΟΣ INPUT
	}while(flag2 || lathosStoixeiaStoLogin );
	 // ΤΩΡΑ ΕΔΩ ΣΚΑΝΝΑΡΩ ΤΟ FILE ΜΕ ΤΙΣ ΤΑΙΝΙΕΣ ΚΑΙ ΒΛΕΠΩ ΑΝ ΥΠΑΡΧΟΥΝ ΟΙ ΑΠΑΝΤΗΣΕΙΣ 
	}	
}

	
	

