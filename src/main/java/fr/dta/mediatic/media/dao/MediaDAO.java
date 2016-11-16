package fr.dta.mediatic.media.dao;

import fr.dta.mediatic.media.model.Media;
import fr.dta.mediatic.utils.dao.GenericDAO;

public class MediaDAO extends GenericDAO {
	
	public static void createMedia(Media media){
		persist(media);
	}
	
	public static Media getMedia(){
		return null;
	}
	
	public static void deleteMedia(Media media){
		
	}
	
	public static void updateMedia(Media media){
		
	}
}
