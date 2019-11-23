package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototy.IPlaceNotesDao;
import entity.PlaceNotes;
import service.prototy.IPlaceNotesService;
import service.prototy.IPlaceService;
@Service
public class PlaceNotesServiceImpl implements IPlaceNotesService{
	@Autowired
	private IPlaceNotesDao placeNotesDao;

	@Override
	public List<PlaceNotes> findAll() {
		return placeNotesDao.find();
	}

	@Override
	public PlaceNotes findByOid(int oid) {
		return placeNotesDao.findByOid(oid);
	}

}
