package mainpackage.Clients;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import mainpackage.ExtraHelp.*;
import mainpackage.FileManager.FileManager;
import mainpackage.implementation.Mainclass;

import java.util.List;
import java.util.ArrayList;

import mainpackage.moviecatalog.*;

public class Customers extends Users implements Serializable {
	
	public List<Kratiseis> reserv; // ΕΔΩ ΕΙΝΑΙ Η ΛΙΣΤΑ ΜΕ ΤΙΣ ΚΡΑΤΗΣΕΙΣ ΤΟΥ ΚΑΘΕ CUSTOMER
	

	public void ShowAvailableFilms() { // ΔΙΑΔΙΚΑΣΙΑ ΕΜΦΑΝΙΣΗΣ ΟΛΩΝ ΤΩΝ ΠΡΟΒΟΛΩΝ
		
		for(Provoles provoli :Mainclass.provoles) 
		{
			System.out.println("ID προβολής:"+provoli.getProvoliID() +"   Ταινία:" +provoli.getProvoliFilm().getFilmTitle() +"   Ωρα έναρξης:" +provoli.getProvoliStartDate() +"   Ωρα λήξης:" +provoli.getProvoliEndDate()+"   Διαθέσιμες θέσεις:"+(provoli.getProvoliCinema().getCinemaNumberOfSeats()-provoli.getProvoliNumberOfReservations())  +"\n");
		}
	}
	public void makeReservation(Provoles provoli ,int theseis) // ΔΙΑΔΙΚΑΣΙΑ ΚΡΑΤΗΣΗΣ , ΓΙΝΕΤΕ ΕΛΕΓΧΟΣ ΑΝ ΜΠΟΡΕΙ ΝΑ ΥΛΟΠΟΙΗΘΕΙ ΑΝΑΛΟΓΑ ΜΕ ΤΙΣ ΘΕΣΕΙΣ ΠΟΥ ΘΕΛΕΙ
	{
		
		if(theseis + provoli.getProvoliNumberOfReservations() > provoli.getProvoliCinema().getCinemaNumberOfSeats()) 
		{
			provoli.setprovoliIsAvailable(false);
		}
		
		
		if(provoli.getProvoliIsAvailable()) {
			
		Kratiseis reservation = new Kratiseis(provoli.getProvoliID(),theseis);
		provoli.setprovoliNumberOfReservations(provoli.getProvoliNumberOfReservations()+theseis);
		//SAVE
		this.reserv.add(reservation);
		String provoliID = String.valueOf(provoli.getProvoliID());
		FileManager.CreateFileProvoles(provoliID, provoli);
		System.out.println("Κανατε κρατηση για την προβολη με ID : "+reservation.getMovieId());
		System.out.println("Κάνατε κράτηση "+ theseis + " θέσεις");
		FileManager.CreateFileCustomers(super.getUsername(), this);
		}else {System.out.println("Δεν υπάρχουν τόσες θέσεις για αυτη τη προβολή");}
		
		
	}
	public void viewReservation() // ΚΑΝΩ PRINT ΟΛΗ ΤΗ ΛΙΣΤΑ ΜΕ ΤΑ RESERVATIONS ΤΟΥ CUSTOMER
	{
		for(Kratiseis kratisi : reserv) 
		{
			System.out.println("Κανατε κρατηση για την προβολη με ID :"+kratisi.getMovieId() + "," + "Θέσεις κράτησης :" + kratisi.getTheseisKratisis()+"\n");
			
		}	
	}
	
	
	
	public Customers(String name,String username,String password, List<Kratiseis> reserv) {super(name,username,password);this.reserv = reserv;} //CONSTRUCTOR
	
	public List<Kratiseis> getReservList() { return this.reserv;}
	
	
	
	
	
}
