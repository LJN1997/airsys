package service.prototy;

import java.util.List;

import entity.PlaceNotes;

public interface IPlaceNotesService {
	List<PlaceNotes> findAll();
	PlaceNotes findByOid(int oid);
}
