package mainpackage.Administrators;

import java.io.File;
import java.io.Serializable;

import mainpackage.Clients.Users;
import mainpackage.FileManager.FileManager;
import mainpackage.implementation.Mainclass;
import mainpackage.moviecatalog.Films;
import mainpackage.moviecatalog.Provoles;
import mainpackage.moviecatalog.Cinemas;

public class ContentAdmins extends Users implements Serializable{
	
	//ΠΡΟΣ ΥΛΟΠΟΙΗΣΗ
	public void insertFilm(Films film) // ΔΙΑΔΙΚΑΣΙΑ ΕΙΣΑΓΩΓΗΣ ΤΑΙΝΙΑΣ
	{
		
		
		Mainclass.films.add(film);
		String filmidtostring =String.valueOf(film.getFilmId());
		FileManager.CreateFileFilms(filmidtostring, film);
		System.out.println("Επιτυχής εισαγωγή ταινίας.");
		
	}
	
	public void insertCinema(Cinemas aithousa) //ΔΙΑΔΙΚΑΣΙΑ ΕΙΣΑΓΩΓΗΣ ΑΙΘΟΥΣΑΣ
	{
		
		String aithousaidparsed = String.valueOf(aithousa.getCinemaId());
		FileManager.CreateFileCinema(aithousaidparsed, aithousa);
		Mainclass.cinema.add(aithousa);
		System.out.println("Επιτυχής εισαγωγή αίθουσας.");
	}
	
	public void deleteFilm(int filmid , boolean delete) // ΔΙΑΔΙΚΑΣΙΑ ΔΙΑΓΡΑΦΗΣ ΤΑΙΝΙΑΣ
	{
		String filmpath = String.valueOf(filmid);
		
		File file = new File("FILMS/"+ filmpath + ".txt");
		if(file.exists()) 
		{
			file.delete();

			Films film = FileManager.getFilm(filmid);
			if(film != null) {
			if(delete) {
			Mainclass.films.remove(film);	
			}
			}
			System.out.println("Επιτυχής διαγραφή ταινίας! ");
			
		}
		else {System.out.println("Δεν υπάρχει ταινία με αυτό το ID!!!");}
		
		
		
	}
	
	public void assignFilmToCinema(Provoles provoli) //ΔΙΑΔΙΚΑΣΙΑ ΔΗΜΙΟΥΡΓΙΑΣ ΠΡΟΒΟΛΗΣ
	{ 
		Mainclass.provoles.add(provoli);
		String provoliID = String.valueOf(provoli.getProvoliID());
		FileManager.CreateFileProvoles(provoliID, provoli);
		
	} // ΣΑΝ ΝΑ ΥΛΟΠΟΙΕΙ CREATEPROVOLI()
	
	
	public ContentAdmins(String name,String username,String password) {super(name,username,password);}
}
