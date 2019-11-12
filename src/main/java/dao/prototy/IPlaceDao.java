package dao.prototy;

import java.util.List;

import entity.Place;

public interface IPlaceDao {
	void PlaceDelete(int pid);
	void PlaceSaveorUpadate(Place place);
	List<Place> Placelistfind(int pageNo, int pageSize); 
	List<Place> find(int pid);
	List<Place> findAll();
}
