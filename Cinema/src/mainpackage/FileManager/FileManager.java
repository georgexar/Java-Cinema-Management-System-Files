package mainpackage.FileManager;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import mainpackage.Clients.*;
import mainpackage.implementation.Mainclass;
import mainpackage.Administrators.*;
import mainpackage.moviecatalog.*;


public class FileManager {
			
			
	public static Cinemas getCinema(int cinemaid) // ΕΠΙΣΤΡΕΦΩ ΤΟ ΑΝΤΙΚΕΙΜΕΝΟ ΤΗΣ ΑΙΘΟΥΣΑΣ ΕΑΝ ΒΡΕΘΕΙ
	{ 
		for (Cinemas cinemas : Mainclass.cinema) 
		{
			if(cinemas.getCinemaId() == cinemaid) {return cinemas;}
		}
		System.out.println("Δεν βρέθηκε αίθουσα με αυτο το ID.");
		return null;
	}
	

	
	public static Films getFilm(int filmid) // ΕΠΙΣΤΡΕΦΩ ΤΟ ΑΝΤΙΚΕΙΜΕΝΟ ΤΗΣ ΤΑΙΝΙΑΣ ΕΑΝ ΒΡΕΘΕΙ
	{ 
		for (Films film : Mainclass.films) 
		{
			if(film.getFilmId() == filmid) {return film;}
		}
		System.out.println("Δεν βρέθηκε ταινία με αυτο το ID.");
		return null;
	}
	
	
	
	public static Object findUser(String username, Object o) {// ΕΠΙΣΤΡΕΦΩ ΤΟ ΑΝΤΙΚΕΙΜΕΝΟ ΤΟΥ USER ΕΑΝ ΒΡΕΘΕΙ
		
		if(o instanceof Customers) {
			
			for(Customers a : Mainclass.customers) {
				if(a.getUsername().equalsIgnoreCase(username)) {
					o = (Customers) a;
				}
			}
			
		} else if(o instanceof Admins) {
			
			for(Admins a : Mainclass.admins) {
				if(a.getUsername().equalsIgnoreCase(username)) {
					o = (Admins) a;
				}
			}
			
		} else if(o instanceof ContentAdmins) {
			
			for(ContentAdmins a : Mainclass.contentadmins) {
				if(a.getUsername().equalsIgnoreCase(username)) {
					o = (ContentAdmins) a;
				}
			}
			
		} else if(o instanceof Users) {
			for(Users a : Mainclass.users) {
				if(a.getUsername().equalsIgnoreCase(username)) {
					o = (Users) a;
				}
			}
		} else { o = null; }
		
		return o;
	}
	
	

	
	
	
	public static void CreateFileFilms(String path,Object o ) // ΔΗΜΙΟΥΡΓΙΑ ΑΡΧΕΙΩΝ TXT ΓΙΑ ΚΑΘΕ ΤΑΙΝΙΑ ΣΤΟΝ ΦΑΚΕΛΟ FILMS (ΔΗΜΙΟΥΡΓΕΙΤΑΙ ΔΥΝΑΜΙΚΑ)
	{
		File file = new File("FILMS");
		if( !file.exists()) {file.mkdirs();}
        try {
            FileOutputStream fileOut = new FileOutputStream("FILMS/"+ path + ".txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(o);
            out.close();
            fileOut.close();
         } catch (IOException i) {
            i.printStackTrace();
         }
      }
	
	public static void CreateFileProvoles(String path,Object o ) // ΔΗΜΙΟΥΡΓΙΑ ΑΡΧΕΙΩΝ TXT ΓΙΑ ΚΑΘΕ ΠΡΟΒΟΛΗ ΣΤΟΝ ΦΑΚΕΛΟ PROVOLES (ΔΗΜΙΟΥΡΓΕΙΤΑΙ ΔΥΝΑΜΙΚΑ)
	{
		File file = new File("PROVOLES");
		if( !file.exists()) {file.mkdirs();}
        try {
            FileOutputStream fileOut = new FileOutputStream("PROVOLES/"+ path + ".txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(o);
            out.close();
            fileOut.close();
         } catch (IOException i) {
            i.printStackTrace();
         }
      }
		
	
	public static void CreateFileUser(String path,Object o ) {// ΔΗΜΙΟΥΡΓΙΑ ΑΡΧΕΙΩΝ TXT ΓΙΑ ΚΑΘΕ USER ΣΤΟΝ ΦΑΚΕΛΟ USERS (ΔΗΜΙΟΥΡΓΕΙΤΑΙ ΔΥΝΑΜΙΚΑ)
		
		File file = new File("USERS");
		if( !file.exists()) {file.mkdirs();}
          try {
              FileOutputStream fileOut = new FileOutputStream("USERS/"+ path + ".txt");
              ObjectOutputStream out = new ObjectOutputStream(fileOut);
              out.writeObject(o);
              out.close();
              fileOut.close();
           } catch (IOException i) {
              i.printStackTrace();
           }
        }
	
	public static void CreateFileCinema(String path,Object o ) {// ΔΗΜΙΟΥΡΓΙΑ ΑΡΧΕΙΩΝ TXT ΓΙΑ ΚΑΘΕ ΑΙΘΟΥΣΑ ΣΤΟΝ ΦΑΚΕΛΟ CINEMAS (ΔΗΜΙΟΥΡΓΕΙΤΑΙ ΔΥΝΑΜΙΚΑ)
		
			File file = new File("CINEMAS");
			if( !file.exists()) {file.mkdirs();}
	          try {
	              FileOutputStream fileOut = new FileOutputStream("CINEMAS/"+ path + ".txt");
	              ObjectOutputStream out = new ObjectOutputStream(fileOut);
	              out.writeObject(o);
	              out.close();
	              fileOut.close();
	           } catch (IOException i) {
	              i.printStackTrace();
	           }
	        }
	
	
	public static void CreateFileAdmins(String path,Object o ) {// ΔΗΜΙΟΥΡΓΙΑ ΑΡΧΕΙΩΝ TXT ΓΙΑ ΚΑΘΕ ADMIN ΣΤΟΝ ΦΑΚΕΛΟ Admins (ΔΗΜΙΟΥΡΓΕΙΤΑΙ ΔΥΝΑΜΙΚΑ)
		
		File file = new File("Admins");
		if( !file.exists()) {file.mkdirs();}
          try {
              FileOutputStream fileOut = new FileOutputStream("Admins/"+ path + ".txt");
              ObjectOutputStream out = new ObjectOutputStream(fileOut);
              out.writeObject(o);
              out.close();
              fileOut.close();
           } catch (IOException i) {
              i.printStackTrace();
           }
        }
	
public static void CreateFileContentAdmins(String path,Object o ) {// ΔΗΜΙΟΥΡΓΙΑ ΑΡΧΕΙΩΝ TXT ΓΙΑ ΚΑΘΕ CONTENTADMIN ΣΤΟΝ ΦΑΚΕΛΟ ContentAdmins (ΔΗΜΙΟΥΡΓΕΙΤΑΙ ΔΥΝΑΜΙΚΑ)
		
		File file = new File("ContentAdmins");
		if( !file.exists()) {file.mkdirs();}
          try {
              FileOutputStream fileOut = new FileOutputStream("ContentAdmins/"+ path + ".txt");
              ObjectOutputStream out = new ObjectOutputStream(fileOut);
              out.writeObject(o);
              out.close();
              fileOut.close();
           } catch (IOException i) {
              i.printStackTrace();
           }
        }
public static void CreateFileCustomers(String path,Object o ) {// ΔΗΜΙΟΥΡΓΙΑ ΑΡΧΕΙΩΝ TXT ΓΙΑ ΚΑΘΕ CUSTOMER ΣΤΟΝ ΦΑΚΕΛΟ Customers (ΔΗΜΙΟΥΡΓΕΙΤΑΙ ΔΥΝΑΜΙΚΑ)
	
	File file = new File("Customers");
	if( !file.exists()) {file.mkdirs();}
      try {
          FileOutputStream fileOut = new FileOutputStream("Customers/"+ path + ".txt");
          ObjectOutputStream out = new ObjectOutputStream(fileOut);
          out.writeObject(o);
          out.close();
          fileOut.close();
       } catch (IOException i) {
          i.printStackTrace();
       }
    }
    
    public static void StarterLoad() //ΕΔΩ ΚΑΝΩ RESTORE ΟΛΕΣ ΤΙΣ ΛΙΣΤΕΣ ΤΗΣ MAIN
    {	
    	File file = new File("USERS");
    	if( file.exists()) {
    	for(File file2 : file.listFiles() ) 
    	{
    		Users user = (Users)deserialize("USERS/" + file2.getName().replace(".txt", ""));
    		Mainclass.users.add(user);	
    	}	 
    	}
    	File fileR = new File("Admins");
    	if( fileR.exists()) {
    	for(File file3 : fileR.listFiles() ) 
    	{
    		Admins admin = (Admins)deserialize("Admins/" + file3.getName().replace(".txt", ""));
    		Mainclass.admins.add(admin);	
    	}	
    	}
    	File fileRa = new File("ContentAdmins");
    	if( fileRa.exists()) {
    	for(File file4 : fileRa.listFiles() ) 
    	{
    		ContentAdmins contentadmin = (ContentAdmins)deserialize("ContentAdmins/" + file4.getName().replace(".txt", ""));
    		Mainclass.contentadmins.add(contentadmin);	
    	}
    	}
    	File fileRab = new File("Customers");
    	if( fileRab.exists()) {
    	for(File file5 : fileRab.listFiles() ) 
    	{	 
    		Customers customer = (Customers)deserialize("Customers/" + file5.getName().replace(".txt", ""));
    	
    		Mainclass.customers.add(customer);	
    	}
    	}
    	File fileRabc = new File("FILMS");
    	if( fileRabc.exists()) {
    	for(File file6 : fileRabc.listFiles() ) 
    	{	 
    		Films film = (Films)deserialize("FILMS/" + file6.getName().replace(".txt", ""));
    	
    		Mainclass.films.add(film);	
    	}
    	}
    	File fileRabcd = new File("PROVOLES");
    	if( fileRabcd.exists()) {
    	for(File file7 : fileRabcd.listFiles() ) 
    	{	 
    		Provoles provoli = (Provoles)deserialize("PROVOLES/" + file7.getName().replace(".txt", ""));
    	
    		Mainclass.provoles.add(provoli);	
    	}
    	}
    	
    	
    }
    
    
    public static Object deserialize(String path) { //ΔΙΑΔΙΚΑΣΙΑ ΕΠΙΣΤΡΟΦΗΣ ΑΝΤΙΚΕΙΜΕΝΟΥ ΑΠΟ ΤΑ ΤΧΤ ΠΟΥ ΕΧΟΥΝ ΔΗΜΙΟΥΡΓΗΘΕΙ ΚΑΘΩΣ ΕΙΝΑΙ ΣΤΑ ΚΟΡΕΑΤΙΚΑ ΛΟΓΩ ΤΟΥ SERIALIZE
    	Object o =  null;
        try {
            FileInputStream fileIn = new FileInputStream(path + ".txt");
            ObjectInputStream out = new ObjectInputStream(fileIn);
         
             o = out.readObject();
            out.close();
          return o;
         } catch (Exception ex) {

         }
        
        return null;
      }
    
    public static boolean UserIsCustomer(String name,String username,String password){ // ΑΝΙΧΝΕΥΩ ΑΝ ΕΙΝΑΙ CUSTOMER ΕΠΙΣΤΡΕΦΕΙ TRUE-FALSE
    	boolean thetruth=false;
    	for(Customers customer : Mainclass.customers) 
    	{     
    		if(customer.getUsername().equalsIgnoreCase(username) && customer.getName().equalsIgnoreCase(name) && customer.getPassword().equalsIgnoreCase(password)) 
    		{
    			thetruth=true;    			
    		}	
    	}
    	
    	
    	return thetruth;
    }
    public static boolean UserIsAdmin(String name,String username,String password){// ΑΝΙΧΝΕΥΩ ΑΝ ΕΙΝΑΙ ADMIN ΕΠΙΣΤΡΕΦΕΙ TRUE-FALSE
    	boolean thetruth=false;
    	for(Admins admin : Mainclass.admins) 
    	{     
    		if(admin.getUsername().equalsIgnoreCase(username) && admin.getName().equalsIgnoreCase(name) && admin.getPassword().equalsIgnoreCase(password) ) 
    		{
    			thetruth=true;    			
    		}	
    	}
    	return thetruth;
    }
    public static boolean UserIsContentAdmin(String name,String username,String password){// ΑΝΙΧΝΕΥΩ ΑΝ ΕΙΝΑΙ CONTENTADMIN ΕΠΙΣΤΡΕΦΕΙ TRUE-FALSE
    	boolean thetruth=false;
    	for(ContentAdmins contentadmin : Mainclass.contentadmins) 
    	{     
    		if(contentadmin.getUsername().equalsIgnoreCase(username) && contentadmin.getName().equalsIgnoreCase(name) && contentadmin.getPassword().equalsIgnoreCase(password) ) 
    		{
    			thetruth=true;    			
    		}	
    	}
    	return thetruth;
    }
 }
    

