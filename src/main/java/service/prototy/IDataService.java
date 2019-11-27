package service.prototy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototy.IDataDao;
import entity.CountData;


public interface IDataService {
	List<CountData> findData();

}
