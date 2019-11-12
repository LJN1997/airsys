package service.prototy;

import java.util.List;

import entity.Place;
import util.MiniPager;
import util.Pager;

public interface IPlaceService {
	void Detele(int pid);
	void SaveOrUpdate(Place place);
	@MiniPager(tableName="airsys_place")
	Pager<Place> listPlace(int pageNo,int pageSize);
	List<Place> find(int pid);
	List<Place> findAll();
}
