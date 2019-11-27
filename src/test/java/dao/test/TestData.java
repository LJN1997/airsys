package dao.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototy.IDataDao;
import entity.CountData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestData {
	@Autowired
	private IDataDao dataDao;
	
	@Test
	public void testCount() {
		List<CountData> find = dataDao.find();
			for (CountData countData : find) {
				String allPrice = countData.getAllPrice();
				String count = countData.getCount();
				String pname = countData.getProvince();
				System.out.println(allPrice);
				System.out.println(count);
				System.out.println(pname);
			}
	}
}
