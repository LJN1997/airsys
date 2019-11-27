package service.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import entity.CountData;
import service.prototy.IDataService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class DataServiceTest {
	@Autowired
	private IDataService dataService;
	
	@Test
	public void testFindData() {
		List<CountData> findData = dataService.findData();
		for (CountData countData : findData) {
			String count = countData.getCount();
			String allPrice = countData.getAllPrice();
			String pname = countData.getPname();
			System.out.println(count);
			System.out.println(allPrice);
			System.out.println(pname);
		}
	}
	
}
