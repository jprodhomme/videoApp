package videoApp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.Categorie;
import model.Video;

public class VideoRowMapper implements RowMapper<Video>{
	
	Categorie test = new Categorie (1, "bagarre");

	@Override
	public Video mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Video(rs.getString("id"), rs.getString("titre"), rs.getObject(Categorie.getIntitule()));
	}


}