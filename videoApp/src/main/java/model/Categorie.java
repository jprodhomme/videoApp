package model;

public class Categorie {
	
	private int id;
	private static String intitule;
	//bla bla bla
	
	public Categorie(int id, String intitule) {
		super();
		this.id = id;
		Categorie.intitule = intitule;
	}
	

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public static String getIntitule() {
		return intitule;
	}
	@SuppressWarnings("static-access")
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	
}
