package dao.prototy;

import java.util.List;

import entity.PlaceNotes;

public interface IPlaceNotesDao {
	List<PlaceNotes> find();
		
	PlaceNotes findByOid(int oid);
	
}
