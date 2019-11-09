package service.prototy;

import java.util.List;

import entity.Place;
import util.MiniPager;

public interface IPlaceService {
	void Detele(int pid);
	void SaveOrUpdate(Place place);
	@MiniPager(tableName="airsys_place")
	List<Place> listPlace(int pageNo,int pageSize);
	List<Place> find(int pid);
}
