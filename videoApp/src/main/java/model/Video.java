package model;

public class Video {

	private String id;
	private String titre;
	private static Categorie categorie;
	
	
	public Video(String id, String titre, Object categorie) {
		super();
		this.id = id;
		this.titre = titre;
		Video.categorie =  (Categorie) categorie;
	}
	
	
	@Override
	public String toString() {
		return "Video [id=" + id + ", titre=" + titre + ", categorie=" + categorie + "]";
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}


	public static Categorie getCategorie() {
		return categorie;
	}


	public static void setCategorie(Categorie categorie) {
		Video.categorie = categorie;
	}
	
	
	
	

	
	
}
