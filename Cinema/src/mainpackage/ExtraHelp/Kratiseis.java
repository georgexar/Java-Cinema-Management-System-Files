package mainpackage.ExtraHelp;

import java.io.Serializable;

public class Kratiseis implements Serializable {
	// ΑΝΤΙΚΕΙΜΕΝΑ KRATISEIS ΠΟΥ ΑΝΤΙΠΡΟΣΩΠΕΥΟΥΝ ΤΟΝ ΑΡΙΘΜΟ ID ΤΗΣ ΠΡΟΒΟΛΗΣ + ΤΙΣ ΘΕΣΕΙΣ ΠΟΥ ΕΚΛΕΙΣΕ Ο ΚΑΘΕ CUSTOMER
	private int movieId;
	
	private int theseiskratisis;
	
	public Kratiseis(int movieId,int theseiskratisis) {this.movieId=movieId;this.theseiskratisis=theseiskratisis;}
	
	public void setMovieId(int Id) {this.movieId=Id;}
	public void setTheseisKratisis(int num) {this.theseiskratisis=num;}
	public int getMovieId() {return this.movieId;}
	public int getTheseisKratisis() {return this.theseiskratisis;}
	
	

}
