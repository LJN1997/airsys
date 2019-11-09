package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototy.IPlaceDao;
import entity.Place;
import service.prototy.IPlaceService;

@Service
public class PlaceServiceImpl implements IPlaceService{
	@Autowired
	private IPlaceDao placeDao;

	@Override
	public void Detele(int pid) {
		placeDao.PlaceDelete(pid);;
	}

	@Override
	public void SaveOrUpdate(Place place) {
		placeDao.PlaceSaveorUpadate(place);;
	}

	@Override
	public List<Place> listPlace(int pageNo, int pageSize) {
		return placeDao.Placelistfind((pageNo-1)*pageSize, pageSize);
	}

	@Override
	public List<Place> find(int pid) {
		return placeDao.find(pid);
	}
	
	
}
