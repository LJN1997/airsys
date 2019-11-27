package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototy.IDataDao;
import entity.CountData;
import service.prototy.IDataService;
@Service
public class DataServiceImpl implements IDataService{
	@Autowired
	private IDataDao dataDao;

	@Override
	public List<CountData> findData() {
		return dataDao.find();
	}

}
