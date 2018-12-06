package videoApp;


import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;


import model.Video;


@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String args[]) {
		SpringApplication.run(Application.class, args);

		
		
		
//		try {
//
//			int choix;
//
//			do {
//				choix = Menu.showMenu();
//				switch (choix) {
//				case 1 : afficheVideo(Collection);
//				break;
//				case 2 : insertVideo(null);
//				break;
//				case 3 :();
//				break;
//				default : break;
//				}
//
//			} while (choix!=4);
//
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
	}


	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... strings) throws Exception {
		createTable();
		Video kassos = new Video("Les Kassos", "Lapin SM", "animation");
		
		insertVideo(kassos);
		
		
	}

	public void createTable() {

		log.info("Drop Table");

		jdbcTemplate.execute("DROP TABLE IF EXISTS videos");
		jdbcTemplate.execute("DROP TABLE IF EXISTS categorie");

		log.info("Creating categorie");

		jdbcTemplate.execute("CREATE TABLE categorie(\n" + 
				"        intitule Varchar (50) NOT NULL ,\n" + 
				"        id       Int(2)  NOT NULL\n" + 
				"    ,CONSTRAINT Categorie_PK PRIMARY KEY (intitule)\n" + 
				")ENGINE=InnoDB;");


		log.info("Creating videos");


		jdbcTemplate.execute("CREATE TABLE videos(\n" + 
				"        id        Varchar (50) NOT NULL ,\n" + 
				"        titre     Varchar (50) NOT NULL ,\n" + 
				"        categorie Varchar (50) NOT NULL ,\n" + 
				"        intitule  Varchar (50) NOT NULL\n" + 
				"    ,CONSTRAINT video_PK PRIMARY KEY (id)\n" + 
				"\n" + 
				"    ,CONSTRAINT video_categorie_FK FOREIGN KEY (intitule) REFERENCES categorie(intitule)\n" + 
				")ENGINE=InnoDB;");
	}


	/**
	 * @param newVideo : the Video to be added in database
	 */

	@SuppressWarnings("static-access")
	public void insertVideo(Video newVideo) {
		jdbcTemplate.update(
				"INSERT INTO videos(id, titre, categorie) VALUES (?,?,?)",
				newVideo.getId(),
				newVideo.getTitre(),
				newVideo.getCategorie()
				);
	}

	public List<Video> afficheVideo(String collection){
		log.info(MessageFormat.format("Querying for video list where titre = ?", collection));

		return jdbcTemplate.query(
				"SELECT * FROM video", new Object[] {collection },
				new VideoRowMapper());
	}

	public void deleteVideo() {
		jdbcTemplate.update(
				"DELETE FROM videos WHERE titre = ?");
	}


}